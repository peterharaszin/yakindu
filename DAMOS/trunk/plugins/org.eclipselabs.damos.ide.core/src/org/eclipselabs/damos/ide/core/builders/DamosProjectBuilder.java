package org.eclipselabs.damos.ide.core.builders;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.common.markers.IMarkerConstants;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.FragmentElement;
import org.eclipselabs.damos.dml.util.DMLValidator;
import org.eclipselabs.damos.execution.engine.DataTypeResolver;
import org.eclipselabs.damos.execution.engine.DataTypeResolverResult;
import org.eclipselabs.damos.execution.engine.IEObjectStatus;
import org.eclipselabs.damos.ide.core.IDECorePlugin;
import org.eclipselabs.damos.ide.core.internal.util.TextUtils;

public class DamosProjectBuilder extends IncrementalProjectBuilder {
	
	private static final Set<String> FILE_EXTENSIONS = new HashSet<String>();
	
	{
		FILE_EXTENSIONS.add("dml");
		FILE_EXTENSIONS.add("blockdiagram");
	}

	protected IProject[] build(int kind, @SuppressWarnings("rawtypes") Map args, IProgressMonitor monitor) throws CoreException {
		if (kind == IncrementalProjectBuilder.FULL_BUILD) {
			fullBuild(monitor);
		} else {
			IResourceDelta delta = getDelta(getProject());
			if (delta == null) {
				fullBuild(monitor);
			} else {
				incrementalBuild(delta, monitor);
			}
		}
		return null;
	}

	protected void fullBuild(final IProgressMonitor monitor) throws CoreException {
		getProject().accept(new ValidationVisitor());
	}

	protected void incrementalBuild(IResourceDelta delta, IProgressMonitor monitor) throws CoreException {
		delta.accept(new ValidationVisitor());
	}
	
	protected void clean(IProgressMonitor monitor) throws CoreException {
		getProject().deleteMarkers(null, false, IResource.DEPTH_INFINITE);
	}
	
	private static class ValidationVisitor implements IResourceVisitor, IResourceDeltaVisitor {

		public boolean visit(IResource resource) throws CoreException {
			return validate(resource);
		}
		
		public boolean visit(IResourceDelta delta) throws CoreException {
			if ((delta.getKind() & (IResourceDelta.ADDED | IResourceDelta.CHANGED)) != 0) {
				return validate(delta.getResource());
			}
			return true;
		}
		
		protected boolean validate(IResource resource) throws CoreException {
			if (resource.getType() != IResource.FILE) {
				return true;
			}
			
			String fileExtension = resource.getFileExtension();
			if (fileExtension == null || !FILE_EXTENSIONS.contains(fileExtension)) {
				return true;
			}
			
			IPath umlFullPath = resource.getFullPath();
			
			ResourceSet resourceSet = new ResourceSetImpl();
			Resource blockDiagramResource;
			try {
				blockDiagramResource = resourceSet.getResource(URI.createPlatformResourceURI(umlFullPath.toString(), true), true);
			} catch (RuntimeException e) {
				throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID,
						"Loading block diagram file '" + resource.getFullPath() + "' failed", e));
			}
			
			resource.deleteMarkers(null, false, IResource.DEPTH_INFINITE);
			resource.deleteMarkers(null, false, IResource.DEPTH_INFINITE);
			
			boolean validationResult = true;
						
			for (EObject eObject : blockDiagramResource.getContents()) {
				if (eObject.eClass().getEPackage() != DMLPackage.eINSTANCE) {
					continue;
				}
				
				BasicDiagnostic diagnostics = new BasicDiagnostic();
				
				Map<Object, Object> context = new HashMap<Object, Object>();
				context.put(EValidator.SubstitutionLabelProvider.class, SubstitutionProvider.INSTANCE);
				if (eObject instanceof Fragment) {
					context.put(Fragment.class, eObject);
				}
				
				DMLValidator.INSTANCE.validate(eObject, diagnostics, context);
				if (eObject instanceof Fragment) {
					Fragment fragment = (Fragment) eObject;
					for (FragmentElement fragmentElement : fragment.getAllFragmentElements()) {
						DMLValidator.INSTANCE.validate(fragmentElement, diagnostics, context);
						for (TreeIterator<EObject> it = fragmentElement.eAllContents(); it.hasNext();) {
							DMLValidator.INSTANCE.validate(it.next(), diagnostics, context);
						}
					}
				} else {
					for (TreeIterator<EObject> it = eObject.eAllContents(); it.hasNext();) {
						DMLValidator.INSTANCE.validate(it.next(), diagnostics, context);
					}
				}
				
				if (diagnostics.getSeverity() != Diagnostic.OK) {
					Fragment fragment = null;
					if (eObject instanceof Fragment) {
						fragment = (Fragment) eObject;
					}
					for (Diagnostic diagnostic : diagnostics.getChildren()) {
						EObject source = null;
						if (diagnostic.getData() != null && !diagnostic.getData().isEmpty()) {
							Object data = diagnostic.getData().get(0);
							if (data instanceof EObject) {
								source = (EObject) data;
							}
						}
						attachMarkers(resource, fragment, source, BasicDiagnostic.toIStatus(diagnostic));
					}
					if (diagnostics.getSeverity() > Diagnostic.WARNING) {
						validationResult = false;
					}
				}
			}
			
			if (validationResult) {
				DataTypeResolver dataTypeResolver = new DataTypeResolver();
				Collection<Fragment> fragments = EcoreUtil.getObjectsByType(blockDiagramResource.getContents(), DMLPackage.Literals.FRAGMENT);
				for (Fragment fragment : fragments) {
					DataTypeResolverResult result = dataTypeResolver.resolve(fragment, false);
					if (!result.getStatus().isOK()) {
						for (IStatus status : result.getStatus().getChildren()) {
							attachMarkers(resource, fragment, null, status);
						}
					}
				}
			}

			return true;
		}

		/**
		 * @param blockDiagramResource
		 * @param fragment
		 * @param diagnostic
		 * @throws CoreException 
		 */
		protected void attachMarkers(IResource resource, Fragment fragment, EObject source, IStatus status) throws CoreException {
			if (source == null && status instanceof IEObjectStatus) {
				source = ((IEObjectStatus) status).getEObject();
			}
			
			if (!status.isOK() && status.getChildren().length > 0) {
				for (IStatus child : status.getChildren()) {
					attachMarkers(resource, fragment, source, child);
				}
			} else {
				IMarker marker = resource.createMarker(IMarkerConstants.PROBLEM_MARKER_ID);
				marker.setAttribute(IMarker.MESSAGE, status.getMessage());
				if (fragment != null) {
					marker.setAttribute(IMarkerConstants.ATTRIBUTE__FRAGMENT_URI, EcoreUtil.getURI(fragment).toString());
				}
				
				int severity;
				switch (status.getSeverity()) {
				case IStatus.INFO:
					severity = IMarker.SEVERITY_INFO;
					break;
				case IStatus.WARNING:
					severity = IMarker.SEVERITY_WARNING;
					break;
				default:
					severity = IMarker.SEVERITY_ERROR;
					break;
				}
				marker.setAttribute(IMarker.SEVERITY, severity);
				if (source != null) {
					if (source instanceof Component) {
						Component component = (Component) source;
						marker.setAttribute(IMarker.LOCATION, component.getName());
					}
					marker.setAttribute(EValidator.URI_ATTRIBUTE, EcoreUtil.getURI(source).toString());
				}
			}
		}
		
		private static class SubstitutionProvider implements EValidator.SubstitutionLabelProvider {

			private static final SubstitutionProvider INSTANCE = new SubstitutionProvider();
			
			private SubstitutionProvider() {
				super();
			}
			
			public String getObjectLabel(EObject eObject) {
				return TextUtils.getText(eObject);
			}

			public String getFeatureLabel(EStructuralFeature eStructuralFeature) {
				return eStructuralFeature.getName();
			}

			public String getValueLabel(EDataType eDataType, Object value) {
				return EcoreUtil.convertToString(eDataType, value);
			}
		}

	}

}
