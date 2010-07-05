package org.eclipselabs.damos.diagram.ui.internal.properties;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.IFilter;
import org.eclipselabs.damos.diagram.ui.properties.ParametersPropertySectionDelegate;
import org.eclipselabs.damos.dml.Block;

public class ParametersPropertySectionFilter implements IFilter {

	public boolean select(Object toTest) {
		if (toTest instanceof IAdaptable) {
			IAdaptable adaptable = (IAdaptable) toTest;
			Block block = (Block) adaptable.getAdapter(Block.class);
			return block != null && block.getArguments().size() > 0 && adaptable.getAdapter(ParametersPropertySectionDelegate.class) != null;
		}
		return false;
	}

}
