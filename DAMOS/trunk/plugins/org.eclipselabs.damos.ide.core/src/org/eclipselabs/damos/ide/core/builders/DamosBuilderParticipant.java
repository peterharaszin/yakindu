/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.ide.core.builders;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.builder.IXtextBuilderParticipant;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipselabs.damos.common.markers.IMarkerConstants;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.FragmentElement;
import org.eclipselabs.damos.dml.util.DMLValidator;
import org.eclipselabs.damos.execution.core.DataTypeResolver;
import org.eclipselabs.damos.execution.core.DataTypeResolverResult;
import org.eclipselabs.damos.execution.core.IEObjectStatus;
import org.eclipselabs.damos.ide.core.internal.util.TextUtils;

/**
 * @author Andreas Unger
 * 
 */
public class DamosBuilderParticipant implements IXtextBuilderParticipant {

	public void build(IBuildContext buildContext, IProgressMonitor monitor) throws CoreException {
		ResourceSet resourceSet = buildContext.getResourceSet();
		
		for (IResourceDescription.Delta delta : buildContext.getDeltas()) {
			if (delta.getNew() == null) {
				continue;
			}
			
			URI uri = delta.getUri();
			Resource resource = resourceSet.getResource(uri, true);
			
			if (!uri.isPlatformResource()) {
				continue;
			}

			IPath path = new Path(uri.toPlatformString(true));

			IFile file = buildContext.getBuiltProject().getWorkspace().getRoot().getFile(path);

			file.deleteMarkers(null, false, IResource.DEPTH_INFINITE);
			file.deleteMarkers(null, false, IResource.DEPTH_INFINITE);

			boolean validationResult = true;

			for (EObject eObject : resource.getContents()) {
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
						attachMarkers(file, fragment, source, BasicDiagnostic.toIStatus(diagnostic));
					}
					if (diagnostics.getSeverity() > Diagnostic.WARNING) {
						validationResult = false;
					}
				}
			}

			if (validationResult) {
				DataTypeResolver dataTypeResolver = new DataTypeResolver();
				Collection<Fragment> fragments = EcoreUtil.getObjectsByType(resource.getContents(),
						DMLPackage.Literals.FRAGMENT);
				for (Fragment fragment : fragments) {
					DataTypeResolverResult result = dataTypeResolver.resolve(fragment, false);
					if (!result.getStatus().isOK()) {
						for (IStatus status : result.getStatus().getChildren()) {
							attachMarkers(file, fragment, null, status);
						}
					}
				}
			}
		}
	}

	/**
	 * @param blockDiagramResource
	 * @param fragment
	 * @param diagnostic
	 * @throws CoreException
	 */
	protected void attachMarkers(IResource resource, Fragment fragment, EObject source, IStatus status)
			throws CoreException {
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
