package org.yakindu.sct.statechart.diagram.policies;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.statechart.diagram.editparts.RegionCompartmentEditPart;
import org.yakindu.sct.statechart.diagram.editparts.StateEditPart;

/**
 * Special implementatin of {@link XYLayoutEditPolicy} for the
 * {@link RegionCompartmentEditPart}.
 * 
 * If a State within the region compartment is collapsed, this Edit Policy does
 * not change the width and height in the Notation model for this state.
 * 
 * So the original width and height of the state before it was collapsed, is
 * remembered and used when the state is expanded again.
 * 
 * @author muelder
 * 
 */
public class RegionCompartmentXYLayoutEditPolicy extends XYLayoutEditPolicy {

	protected Command createChangeConstraintCommand(EditPart child,
			Object constraint) {
		if (child instanceof StateEditPart
				&& ((StateEditPart) child).isCollapsed()) {
			Rectangle newBounds = (Rectangle) constraint;
			View shapeView = (View) child.getModel();
			// Override the new bounds with the original bounds from the
			// notation model here
			newBounds.width = (Integer) ViewUtil.getStructuralFeatureValue(
					shapeView, NotationPackage.eINSTANCE.getSize_Width());
			newBounds.height = (Integer) ViewUtil.getStructuralFeatureValue(
					shapeView, NotationPackage.eINSTANCE.getSize_Height());
			ICommand boundsCommand = new SetBoundsCommand(getHost()
					.getEditingDomain(),
					DiagramUIMessages.SetLocationCommand_Label_Resize,
					new EObjectAdapter(shapeView), newBounds);
			return new ICommandProxy(boundsCommand);
		} else {
			return super.createChangeConstraintCommand(child, constraint);
		}
	}

	@Override
	public IGraphicalEditPart getHost() {
		return (IGraphicalEditPart) super.getHost();
	}
}
