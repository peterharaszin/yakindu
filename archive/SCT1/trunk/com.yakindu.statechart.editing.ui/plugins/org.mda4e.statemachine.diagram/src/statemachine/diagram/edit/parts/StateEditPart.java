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
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
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
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

import statemachine.diagram.edit.policies.StateItemSemanticEditPolicy;
import statemachine.diagram.part.StatemachineVisualIDRegistry;
import statemachine.diagram.providers.StatemachineElementTypes;

/**
 * @generated
 */
public class StateEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3001;

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
	public StateEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new StateItemSemanticEditPolicy());
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
		StateFigure figure = new StateFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public StateFigure getPrimaryShape() {
		return (StateFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof StateEntryEditPart) {
			((StateEntryEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureStateEntryFigure());
			return true;
		}
		if (childEditPart instanceof StateNameEditPart) {
			((StateNameEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureStateNameFigure());
			return true;
		}
		if (childEditPart instanceof StateExitEditPart) {
			((StateExitEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureStateExitFigure());
			return true;
		}
		if (childEditPart instanceof StateDoEditPart) {
			((StateDoEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureStateDoFigure());
			return true;
		}
		if (childEditPart instanceof StateStateCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureStateCompartmentRectangle();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((StateStateCompartmentEditPart) childEditPart)
					.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof StateEntryEditPart) {
			return true;
		}
		if (childEditPart instanceof StateNameEditPart) {
			return true;
		}
		if (childEditPart instanceof StateExitEditPart) {
			return true;
		}
		if (childEditPart instanceof StateDoEditPart) {
			return true;
		}
		if (childEditPart instanceof StateStateCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureStateCompartmentRectangle();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((StateStateCompartmentEditPart) childEditPart)
					.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof StateStateCompartmentEditPart) {
			return getPrimaryShape().getFigureStateCompartmentRectangle();
		}
		return getContentPane();
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
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
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
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(StatemachineVisualIDRegistry
				.getType(StateNameEditPart.VISUAL_ID));
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
		if (targetEditPart instanceof statemachine.diagram.edit.parts.StateEditPart) {
			types.add(StatemachineElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof PseudostateEditPart) {
			types.add(StatemachineElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof FinalStateEditPart) {
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
	public class StateFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureStateNameFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureStateEntryFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureStateDoFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureStateExitFigure;
		/**
		 * @generated
		 */
		private RectangleFigure fFigureStateCompartmentRectangle;

		/**
		 * @generated
		 */
		public StateFigure() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = false;
			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(8),
					getMapMode().DPtoLP(8)));
			this.setLineWidth(1);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			RectangleFigure stateLabelRectangle0 = new RectangleFigure();
			stateLabelRectangle0.setOutline(false);
			stateLabelRectangle0.setLineWidth(1);

			GridData constraintStateLabelRectangle0 = new GridData();
			constraintStateLabelRectangle0.verticalAlignment = GridData.FILL;
			constraintStateLabelRectangle0.horizontalAlignment = GridData.FILL;
			constraintStateLabelRectangle0.horizontalIndent = 0;
			constraintStateLabelRectangle0.horizontalSpan = 1;
			constraintStateLabelRectangle0.verticalSpan = 1;
			constraintStateLabelRectangle0.grabExcessHorizontalSpace = true;
			constraintStateLabelRectangle0.grabExcessVerticalSpace = false;
			this.add(stateLabelRectangle0, constraintStateLabelRectangle0);

			GridLayout layoutStateLabelRectangle0 = new GridLayout();
			layoutStateLabelRectangle0.numColumns = 1;
			layoutStateLabelRectangle0.makeColumnsEqualWidth = false;
			stateLabelRectangle0.setLayoutManager(layoutStateLabelRectangle0);

			fFigureStateNameFigure = new WrappingLabel();
			fFigureStateNameFigure.setText("<name>");

			fFigureStateNameFigure.setFont(FFIGURESTATENAMEFIGURE_FONT);

			GridData constraintFFigureStateNameFigure = new GridData();
			constraintFFigureStateNameFigure.verticalAlignment = GridData.CENTER;
			constraintFFigureStateNameFigure.horizontalAlignment = GridData.CENTER;
			constraintFFigureStateNameFigure.horizontalIndent = 0;
			constraintFFigureStateNameFigure.horizontalSpan = 1;
			constraintFFigureStateNameFigure.verticalSpan = 1;
			constraintFFigureStateNameFigure.grabExcessHorizontalSpace = true;
			constraintFFigureStateNameFigure.grabExcessVerticalSpace = false;
			stateLabelRectangle0.add(fFigureStateNameFigure,
					constraintFFigureStateNameFigure);

			fFigureStateEntryFigure = new WrappingLabel();
			fFigureStateEntryFigure.setText("<entry>");

			GridData constraintFFigureStateEntryFigure = new GridData();
			constraintFFigureStateEntryFigure.verticalAlignment = GridData.CENTER;
			constraintFFigureStateEntryFigure.horizontalAlignment = GridData.CENTER;
			constraintFFigureStateEntryFigure.horizontalIndent = 0;
			constraintFFigureStateEntryFigure.horizontalSpan = 1;
			constraintFFigureStateEntryFigure.verticalSpan = 1;
			constraintFFigureStateEntryFigure.grabExcessHorizontalSpace = true;
			constraintFFigureStateEntryFigure.grabExcessVerticalSpace = false;
			stateLabelRectangle0.add(fFigureStateEntryFigure,
					constraintFFigureStateEntryFigure);

			fFigureStateDoFigure = new WrappingLabel();
			fFigureStateDoFigure.setText("<do>");

			GridData constraintFFigureStateDoFigure = new GridData();
			constraintFFigureStateDoFigure.verticalAlignment = GridData.CENTER;
			constraintFFigureStateDoFigure.horizontalAlignment = GridData.CENTER;
			constraintFFigureStateDoFigure.horizontalIndent = 0;
			constraintFFigureStateDoFigure.horizontalSpan = 1;
			constraintFFigureStateDoFigure.verticalSpan = 1;
			constraintFFigureStateDoFigure.grabExcessHorizontalSpace = true;
			constraintFFigureStateDoFigure.grabExcessVerticalSpace = false;
			stateLabelRectangle0.add(fFigureStateDoFigure,
					constraintFFigureStateDoFigure);

			fFigureStateExitFigure = new WrappingLabel();
			fFigureStateExitFigure.setText("<exit>");

			GridData constraintFFigureStateExitFigure = new GridData();
			constraintFFigureStateExitFigure.verticalAlignment = GridData.CENTER;
			constraintFFigureStateExitFigure.horizontalAlignment = GridData.CENTER;
			constraintFFigureStateExitFigure.horizontalIndent = 0;
			constraintFFigureStateExitFigure.horizontalSpan = 1;
			constraintFFigureStateExitFigure.verticalSpan = 1;
			constraintFFigureStateExitFigure.grabExcessHorizontalSpace = true;
			constraintFFigureStateExitFigure.grabExcessVerticalSpace = false;
			stateLabelRectangle0.add(fFigureStateExitFigure,
					constraintFFigureStateExitFigure);

			fFigureStateCompartmentRectangle = new RectangleFigure();
			fFigureStateCompartmentRectangle.setOutline(false);
			fFigureStateCompartmentRectangle.setLineWidth(1);

			GridData constraintFFigureStateCompartmentRectangle = new GridData();
			constraintFFigureStateCompartmentRectangle.verticalAlignment = GridData.FILL;
			constraintFFigureStateCompartmentRectangle.horizontalAlignment = GridData.FILL;
			constraintFFigureStateCompartmentRectangle.horizontalIndent = 0;
			constraintFFigureStateCompartmentRectangle.horizontalSpan = 1;
			constraintFFigureStateCompartmentRectangle.verticalSpan = 1;
			constraintFFigureStateCompartmentRectangle.grabExcessHorizontalSpace = true;
			constraintFFigureStateCompartmentRectangle.grabExcessVerticalSpace = true;
			this.add(fFigureStateCompartmentRectangle,
					constraintFFigureStateCompartmentRectangle);

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

		/**
		 * @generated
		 */
		public WrappingLabel getFigureStateNameFigure() {
			return fFigureStateNameFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureStateEntryFigure() {
			return fFigureStateEntryFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureStateDoFigure() {
			return fFigureStateDoFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureStateExitFigure() {
			return fFigureStateExitFigure;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureStateCompartmentRectangle() {
			return fFigureStateCompartmentRectangle;
		}

	}

	/**
	 * @generated
	 */
	static final Font FFIGURESTATENAMEFIGURE_FONT = new Font(Display
			.getCurrent(), "Verdana", 10, SWT.BOLD);

}
