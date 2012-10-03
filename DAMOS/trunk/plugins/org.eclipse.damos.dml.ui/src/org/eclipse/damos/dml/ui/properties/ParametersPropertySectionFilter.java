package org.eclipse.damos.dml.ui.properties;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.damos.dml.Argument;
import org.eclipse.damos.dml.ParameterVisibilityKind;
import org.eclipse.damos.dml.ParameterizedElement;
import org.eclipse.jface.viewers.IFilter;

public class ParametersPropertySectionFilter implements IFilter {

	public boolean select(Object toTest) {
		ParameterizedElement parameterizedElement = null;
		if (toTest instanceof ParameterizedElement) {
			parameterizedElement = (ParameterizedElement) toTest;
		} else if (toTest instanceof IAdaptable) {
			parameterizedElement = (ParameterizedElement) ((IAdaptable) toTest).getAdapter(ParameterizedElement.class);
		}
		if (parameterizedElement != null) {
			for (Argument argument : parameterizedElement.getArguments()) {
				if (argument.getParameter() != null && !argument.getParameter().eIsProxy() && argument.getParameter().getVisibility() == ParameterVisibilityKind.PUBLIC) {
					return true;
				}
			}
		}
		return false;
	}

}
