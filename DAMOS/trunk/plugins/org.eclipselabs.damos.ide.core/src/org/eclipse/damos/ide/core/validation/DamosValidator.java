package org.eclipse.damos.ide.core.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.dml.FragmentElement;
import org.eclipse.damos.dml.util.DMLValidator;
import org.eclipse.damos.execution.datatype.DataTypeResolver;
import org.eclipse.damos.execution.datatype.DataTypeResolverResult;
import org.eclipse.damos.execution.datatype.IEObjectStatus;
import org.eclipse.damos.ide.core.internal.util.TextUtils;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Andreas Unger
 * 
 */
public class DamosValidator {

	public List<Problem> validate(Resource resource, IProgressMonitor monitor) throws CoreException {
		List<Problem> markers = new ArrayList<Problem>();

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
					addMarkers(markers, fragment, source, BasicDiagnostic.toIStatus(diagnostic));
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
						addMarkers(markers, fragment, null, status);
					}
				}
			}
		}
		return markers;
	}

	private void addMarkers(List<Problem> problems, Fragment fragment, EObject source, IStatus status)
			throws CoreException {
		if (source == null && status instanceof IEObjectStatus) {
			source = ((IEObjectStatus) status).getEObject();
		}

		if (!status.isOK() && status.getChildren().length > 0) {
			for (IStatus child : status.getChildren()) {
				addMarkers(problems, fragment, source, child);
			}
		} else {
			int severity;
			URI fragmentURI = null;
			URI elementURI = null;
			String location = null;
			String message;

			message = status.getMessage();
			if (fragment != null) {
				fragmentURI = EcoreUtil.getURI(fragment);
			}

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

			if (source != null) {
				if (source instanceof Component) {
					Component component = (Component) source;
					location = component.getName();
				}
				elementURI = EcoreUtil.getURI(source);
			}

			problems.add(Problem.create(severity, status.getPlugin(), status.getCode(), fragmentURI, elementURI, location, message));
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
