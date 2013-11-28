/**
 * Copyright (c) 2006-2009 committers of mda4e and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of mda4e (http://www.mda4e.org/) - initial API and implementation
 *
 */
package statemachine.diagram.edit.parts;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.swt.graphics.Color;
import statemachine.diagram.edit.policies.FinalStateItemSemanticEditPolicy;
import statemachine.diagram.providers.StatemachineElementTypes;

/**
 * @generated
 */
public class FinalStateEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3004;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public FinalStateEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new FinalStateItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child
						.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		FinalStateFigure figure = new FinalStateFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public FinalStateFigure getPrimaryShape() {
		return (FinalStateFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * @param nodeShape instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSource() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(StatemachineElementTypes.Transition_4001);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (targetEditPart instanceof StateEditPart) {
			types.add(StatemachineElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof PseudostateEditPart) {
			types.add(StatemachineElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof statemachine.diagram.edit.parts.FinalStateEditPart) {
			types.add(StatemachineElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof Pseudostate2EditPart) {
			types.add(StatemachineElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof Pseudostate3EditPart) {
			types.add(StatemachineElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof Pseudostate4EditPart) {
			types.add(StatemachineElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof Pseudostate5EditPart) {
			types.add(StatemachineElementTypes.Transition_4001);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForTarget(
			IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == StatemachineElementTypes.Transition_4001) {
			types.add(StatemachineElementTypes.State_3001);
		}
		if (relationshipType == StatemachineElementTypes.Transition_4001) {
			types.add(StatemachineElementTypes.Pseudostate_3003);
		}
		if (relationshipType == StatemachineElementTypes.Transition_4001) {
			types.add(StatemachineElementTypes.FinalState_3004);
		}
		if (relationshipType == StatemachineElementTypes.Transition_4001) {
			types.add(StatemachineElementTypes.Pseudostate_3005);
		}
		if (relationshipType == StatemachineElementTypes.Transition_4001) {
			types.add(StatemachineElementTypes.Pseudostate_3006);
		}
		if (relationshipType == StatemachineElementTypes.Transition_4001) {
			types.add(StatemachineElementTypes.Pseudostate_3007);
		}
		if (relationshipType == StatemachineElementTypes.Transition_4001) {
			types.add(StatemachineElementTypes.Pseudostate_3008);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(StatemachineElementTypes.Transition_4001);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForSource(
			IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == StatemachineElementTypes.Transition_4001) {
			types.add(StatemachineElementTypes.State_3001);
		}
		if (relationshipType == StatemachineElementTypes.Transition_4001) {
			types.add(StatemachineElementTypes.Pseudostate_3003);
		}
		if (relationshipType == StatemachineElementTypes.Transition_4001) {
			types.add(StatemachineElementTypes.FinalState_3004);
		}
		if (relationshipType == StatemachineElementTypes.Transition_4001) {
			types.add(StatemachineElementTypes.Pseudostate_3005);
		}
		if (relationshipType == StatemachineElementTypes.Transition_4001) {
			types.add(StatemachineElementTypes.Pseudostate_3006);
		}
		if (relationshipType == StatemachineElementTypes.Transition_4001) {
			types.add(StatemachineElementTypes.Pseudostate_3007);
		}
		if (relationshipType == StatemachineElementTypes.Transition_4001) {
			types.add(StatemachineElementTypes.Pseudostate_3008);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class FinalStateFigure extends
			statemachine.figures.customfigures.FinalStateFigure {

		/**
		 * @generated
		 */
		public FinalStateFigure() {

			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(40),
					getMapMode().DPtoLP(40)));
			this.setMaximumSize(new Dimension(getMapMode().DPtoLP(40),
					getMapMode().DPtoLP(40)));
			this.setMinimumSize(new Dimension(getMapMode().DPtoLP(40),
					getMapMode().DPtoLP(40)));
		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = false;

		/**
		 * @generated
		 */
		protected boolean useLocalCoordinates() {
			return myUseLocalCoordinates;
		}

		/**
		 * @generated
		 */
		protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
			myUseLocalCoordinates = useLocalCoordinates;
		}

	}

}
