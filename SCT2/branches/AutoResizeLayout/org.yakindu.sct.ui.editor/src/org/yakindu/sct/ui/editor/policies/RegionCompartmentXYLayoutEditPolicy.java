/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.policies;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
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
import org.yakindu.sct.ui.editor.editor.figures.RegionFigure;
import org.yakindu.sct.ui.editor.editparts.RegionCompartmentEditPart;
import org.yakindu.sct.ui.editor.editparts.RegionEditPart;
import org.yakindu.sct.ui.editor.editparts.StateEditPart;

import de.itemis.gmf.runtime.commons.editparts.FixedXYLayoutEditPolicy;

/**
 * Special implementation of {@link XYLayoutEditPolicy} for the
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
public class RegionCompartmentXYLayoutEditPolicy extends
		FixedXYLayoutEditPolicy {

	public static final int SPACEING = 40;

	@Override
	protected Command getMoveChildrenCommand(Request request) {
		CompoundCommand result = new CompoundCommand();
//		result.add(changeRegionBoundsCommand(request));
		result.add(super.getMoveChildrenCommand(request));

		return result;
	}

	protected RegionFigure getRegionFigure() {
		IFigure figure = getHostFigure();
		while (!(figure instanceof RegionFigure)) {
			figure = figure.getParent();
		}
		return (RegionFigure) figure;
	}

	@SuppressWarnings("unchecked")
	private Command changeRegionBoundsCommand(Request req) {
		ChangeBoundsRequest request = (ChangeBoundsRequest) req;
		CompoundCommand cmd = new CompoundCommand();

		Rectangle regionBounds = getRegionFigure().getBounds().getCopy();

		List<IGraphicalEditPart> editParts = request.getEditParts();
		for (IGraphicalEditPart editPart : editParts) {
			PrecisionRectangle newStateBounds = new PrecisionRectangle(editPart
					.getFigure().getBounds());
			editPart.getFigure().translateToAbsolute(newStateBounds);
			newStateBounds.translate(request.getMoveDelta());
			newStateBounds.resize(request.getSizeDelta());
			newStateBounds.expand(SPACEING, SPACEING);

			regionBounds.union(newStateBounds);
		}

		getHost().getFigure().translateToRelative(regionBounds);

		EditPart parent = getHost().getParent();
		while(parent != null) {
			if(parent instanceof RegionEditPart || parent instanceof StateEditPart){
				View shapeView = (View) parent.getModel();
				ICommand boundsCommand = new SetBoundsCommand(getHost()
						.getEditingDomain(),
						DiagramUIMessages.SetLocationCommand_Label_Resize,
						new EObjectAdapter(shapeView), regionBounds);
				cmd.add(new ICommandProxy(boundsCommand));
				
			}
			parent = parent.getParent();
		}
		return cmd;
	}

	@Override
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
