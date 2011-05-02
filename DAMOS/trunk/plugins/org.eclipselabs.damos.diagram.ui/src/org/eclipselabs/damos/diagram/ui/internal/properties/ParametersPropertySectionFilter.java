package org.eclipselabs.damos.diagram.ui.internal.properties;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.IFilter;
import org.eclipselabs.damos.dml.Argument;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.ParameterVisibilityKind;

public class ParametersPropertySectionFilter implements IFilter {

	public boolean select(Object toTest) {
		if (toTest instanceof IAdaptable) {
			IAdaptable adaptable = (IAdaptable) toTest;
			Block block = (Block) adaptable.getAdapter(Block.class);
			if (block == null) {
				return false;
			}
			for (Argument argument : block.getArguments()) {
				if (argument.getParameter() != null && argument.getParameter().getVisibility() == ParameterVisibilityKind.PUBLIC) {
					return true;
				}
			}
		}
		return false;
	}

}
