package org.eclipselabs.damos.dml.ui.internal.properties;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.IFilter;
import org.eclipselabs.damos.dml.Argument;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.ParameterVisibilityKind;

public class ParametersPropertySectionFilter implements IFilter {

	public boolean select(Object toTest) {
		Block block = null;
		if (toTest instanceof Block) {
			block = (Block) toTest;
		} else if (toTest instanceof IAdaptable) {
			block = (Block) ((IAdaptable) toTest).getAdapter(Block.class);
		}
		if (block != null) {
			for (Argument argument : block.getArguments()) {
				if (argument.getParameter() != null && argument.getParameter().getVisibility() == ParameterVisibilityKind.PUBLIC) {
					return true;
				}
			}
		}
		return false;
	}

}
