package org.eclipselabs.damos.ide.core.builders;

import java.io.IOException;
import java.util.Map;

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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.common.markers.IMarkerConstants;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.execution.engine.DataTypeResolver;
import org.eclipselabs.damos.execution.engine.DataTypeResolverResult;
import org.eclipselabs.damos.execution.engine.IComponentStatus;
import org.eclipselabs.damos.ide.core.IDECorePlugin;

public class DamosProjectBuilder extends IncrementalProjectBuilder {

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
			if (resource.getType() != IResource.FILE || !"blockdiagram".equals(resource.getFileExtension())) {
				return true;
			}
			
			IPath umlFullPath = resource.getFullPath();
			
			ResourceSet resourceSet = new ResourceSetImpl();
			Resource blockDiagramResource = resourceSet.createResource(URI.createPlatformResourceURI(umlFullPath.toString(), true));
			try {
				blockDiagramResource.load(null);
			} catch (IOException e) {
				throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID,
						"Loading block diagram file '" + resource.getFullPath() + "' failed", e));
			}
			
			resource.deleteMarkers(null, false, IResource.DEPTH_INFINITE);
			resource.deleteMarkers(null, false, IResource.DEPTH_INFINITE);
			
			DataTypeResolver dataTypeResolver = new DataTypeResolver();
			for (Object o : EcoreUtil.getObjectsByType(blockDiagramResource.getContents(), DMLPackage.Literals.FRAGMENT)) {
				Fragment fragment = (Fragment) o;
				DataTypeResolverResult result = dataTypeResolver.resolve(fragment);
				if (!result.getStatus().isOK()) {
					for (IStatus status : result.getStatus().getChildren()) {
						attachMarkers(resource, fragment, null, status);
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
		protected void attachMarkers(IResource resource, Fragment fragment, Component component, IStatus status) throws CoreException {
			if (component == null && status instanceof IComponentStatus) {
				component = ((IComponentStatus) status).getComponent();
			}
			
			if (!status.isOK() && status.getChildren().length > 0) {
				for (IStatus child : status.getChildren()) {
					attachMarkers(resource, fragment, component, child);
				}
			} else {
				IMarker marker = resource.createMarker(IMarkerConstants.PROBLEM_MARKER_ID);
				marker.setAttribute(IMarker.MESSAGE, status.getMessage());
				marker.setAttribute(IMarkerConstants.ATTRIBUTE__FRAGMENT_URI, EcoreUtil.getURI(fragment).toString());
				
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
				if (component != null) {
					marker.setAttribute(IMarker.LOCATION, component.getName());
					marker.setAttribute(IMarkerConstants.ATTRIBUTE__ELEMENT_URI, EcoreUtil.getURI(component).toString());
				}
			}
		}

	}

}
