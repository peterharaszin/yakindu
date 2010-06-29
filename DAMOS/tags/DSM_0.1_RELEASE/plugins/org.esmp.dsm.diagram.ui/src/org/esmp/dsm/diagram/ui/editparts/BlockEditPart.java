/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.esmp.dsm.diagram.ui.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.esmp.dsm.diagram.ui.editpolicies.AdjustInputCountEditPolicy;
import org.esmp.dsm.diagram.ui.editpolicies.AdjustOutputCountEditPolicy;
import org.esmp.dsm.diagram.ui.editpolicies.BlockCanonicalEditPolicy;
import org.esmp.dsm.diagram.ui.editpolicies.BlockComponentEditPolicy;
import org.esmp.dsm.diagram.ui.editpolicies.EditPolicyRoles;
import org.esmp.dsm.diagram.ui.editpolicies.TransformEditPolicy;
import org.esmp.dsm.diagram.ui.figures.BlockFigure;
import org.esmp.dsm.diagram.ui.internal.editparts.ParameterNotificationHelper;
import org.esmp.dsm.diagram.ui.properties.ParametersPropertySectionDelegate;
import org.esmp.dsm.notation.blockdiagramnotation.BlockDiagramNotationPackage;
import org.esmp.dsm.notation.blockdiagramnotation.BlockLayoutConstraint;
import org.esmp.dsm.semantic.blockdiagram.Block;
import org.esmp.dsm.semantic.blockdiagram.Port;

public abstract class BlockEditPart extends AbstractBorderedShapeEditPart {

	private ParameterNotificationHelper parameterNotificationHelper = new ParameterNotificationHelper(this);

	public BlockEditPart(View view) {
		super(view);
	}
	
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		removeEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new BlockCanonicalEditPolicy());
		installEditPolicy(EditPolicyRoles.TRANSFORM_ROLE, new TransformEditPolicy());
		installEditPolicy(EditPolicyRoles.ADJUST_INPUT_COUNT_ROLE, new AdjustInputCountEditPolicy());
		installEditPolicy(EditPolicyRoles.ADJUST_OUTPUT_COUNT_ROLE, new AdjustOutputCountEditPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new BlockComponentEditPolicy());
	}
	
	public BlockFigure getBlockFigure() {
		return (BlockFigure) getMainFigure();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart#refreshVisuals()
	 */
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshFlipped();
		refreshRotation();
	}
	
	protected void refreshFlipped() {
		Node node = (Node) getNotationView();
		if (node != null) {
			LayoutConstraint l = node.getLayoutConstraint();
			if (l instanceof BlockLayoutConstraint) {
				getBlockFigure().setFlipped(((BlockLayoutConstraint) l).isFlipped());
			}
		}
	}
	
	protected void refreshRotation() {
		Node node = (Node) getNotationView();
		if (node != null) {
			LayoutConstraint l = node.getLayoutConstraint();
			if (l instanceof BlockLayoutConstraint) {
				getBlockFigure().setRotation(((BlockLayoutConstraint) l).getRotation());
			}
		}
	}
		
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#handleNotificationEvent(org.eclipse.emf.common.notify.Notification)
	 */
	protected void handleNotificationEvent(Notification notification) {
		Object feature = notification.getFeature();
		if (BlockDiagramNotationPackage.eINSTANCE.getBlockLayoutConstraint_Flipped().equals(feature)) {
			refreshFlipped();
		} else if (BlockDiagramNotationPackage.eINSTANCE.getBlockLayoutConstraint_Rotation().equals(feature)) {
			refreshRotation();
		} else {
			super.handleNotificationEvent(notification);
		}
	}

	public EditPart getPrimaryChildEditPart() {
		// The first non-port and non-parameter edit part is our primary edit part.
		for (Object ep : getChildren()) {
			if (!(ep instanceof PortEditPart || ep instanceof BlockParameterEditPart)) {
				return (EditPart) ep;
			}
		}
		return super.getPrimaryChildEditPart();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart#addChildVisual(org.eclipse.gef.EditPart, int)
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (childEditPart instanceof IBorderItemEditPart) {
			super.addChildVisual(childEditPart, index);
		} else {
			/*
			 * Workaround for a bug in the super class.
			 * TODO: Report addChildVisual() bug.
			 */

			IFigure childFigure = ((GraphicalEditPart) childEditPart).getFigure();
			IFigure parent = getContentPaneFor((IGraphicalEditPart) childEditPart);
			
			// Map the index within the edit parts to the index within the content pane figures.
			for (Object child : getChildren()) {
				if (child == childEditPart) {
					break;
				}
				if (child instanceof IBorderItemEditPart) {
					--index;
				}
			}

			index = Math.min(parent.getChildren().size(), index);
			
            parent.add(childFigure, index);
		}

		if (childEditPart instanceof PortEditPart) {
			PortEditPart portEditPart = (PortEditPart) childEditPart;
			Port port = (Port) portEditPart.resolveSemanticElement();
			if (port != null) {
				getMainFigure().setConstraint(portEditPart.getFigure(), getPortFigureConstraint(port));
			}
		}
	}

	protected Object getPortFigureConstraint(Port port) {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#addSemanticListeners()
	 */
	protected void addSemanticListeners() {
		super.addSemanticListeners();
		EObject o = resolveSemanticElement();
		if (o instanceof Block) {
			parameterNotificationHelper.addSemanticListeners(((Block) o).getParameters());
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#removeSemanticListeners()
	 */
	protected void removeSemanticListeners() {
		parameterNotificationHelper.removeSemanticListeners();
		super.removeSemanticListeners();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#getAdapter(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	public Object getAdapter(Class key) {
		if (key == ParametersPropertySectionDelegate.class) {
			return new ParametersPropertySectionDelegate();
		}
		return super.getAdapter(key);
	}

}
