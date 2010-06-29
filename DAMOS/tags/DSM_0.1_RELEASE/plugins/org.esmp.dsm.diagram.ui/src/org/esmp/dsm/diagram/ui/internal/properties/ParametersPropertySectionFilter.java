package org.esmp.dsm.diagram.ui.internal.properties;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IFilter;
import org.esmp.dsm.diagram.ui.editparts.BlockEditPart;
import org.esmp.dsm.diagram.ui.properties.ParametersPropertySectionDelegate;
import org.esmp.dsm.semantic.blockdiagram.Block;

public class ParametersPropertySectionFilter implements IFilter {

	public boolean select(Object toTest) {
		if (toTest instanceof BlockEditPart) {
			BlockEditPart blockEditPart = (BlockEditPart) toTest;
			EObject o = blockEditPart.resolveSemanticElement();
			if (o instanceof Block) {
				Block block = (Block) o;
				return block != null && block.getParameters().size() > 0 && blockEditPart.getAdapter(ParametersPropertySectionDelegate.class) != null;
			}
		}
		return false;
	}

}
