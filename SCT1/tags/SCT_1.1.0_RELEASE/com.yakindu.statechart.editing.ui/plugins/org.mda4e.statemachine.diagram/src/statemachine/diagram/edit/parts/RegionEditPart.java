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

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MarginBorder;
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
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

import statemachine.diagram.edit.policies.RegionItemSemanticEditPolicy;
import statemachine.diagram.part.StatemachineVisualIDRegistry;

/**
 * @generated
 */
public class RegionEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2001;

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
	public RegionEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new RegionItemSemanticEditPolicy());
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
		RegionFigure figure = new RegionFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public RegionFigure getPrimaryShape() {
		return (RegionFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof RegionPriorityEditPart) {
			((RegionPriorityEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureRegionPriorityFigure());
			return true;
		}
		if (childEditPart instanceof RegionRegionCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureRegionCompartmentRectangle();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((RegionRegionCompartmentEditPart) childEditPart)
					.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof RegionPriorityEditPart) {
			return true;
		}
		if (childEditPart instanceof RegionRegionCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureRegionCompartmentRectangle();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((RegionRegionCompartmentEditPart) childEditPart)
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
		if (editPart instanceof RegionRegionCompartmentEditPart) {
			return getPrimaryShape().getFigureRegionCompartmentRectangle();
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
				.getType(RegionPriorityEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class RegionFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureRegionPriorityFigure;
		/**
		 * @generated
		 */
		private RectangleFigure fFigureRegionCompartmentRectangle;

		/**
		 * @generated
		 */
		public RegionFigure() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(8),
					getMapMode().DPtoLP(8)));
			this.setLineWidth(1);

			this.setBorder(new MarginBorder(getMapMode().DPtoLP(2),
					getMapMode().DPtoLP(0), getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(0)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			RectangleFigure regionLabelRectangle0 = new RectangleFigure();
			regionLabelRectangle0.setOutline(false);
			regionLabelRectangle0.setLineWidth(1);

			GridData constraintRegionLabelRectangle0 = new GridData();
			constraintRegionLabelRectangle0.verticalAlignment = GridData.BEGINNING;
			constraintRegionLabelRectangle0.horizontalAlignment = GridData.CENTER;
			constraintRegionLabelRectangle0.horizontalIndent = 0;
			constraintRegionLabelRectangle0.horizontalSpan = 1;
			constraintRegionLabelRectangle0.verticalSpan = 1;
			constraintRegionLabelRectangle0.grabExcessHorizontalSpace = true;
			constraintRegionLabelRectangle0.grabExcessVerticalSpace = false;
			this.add(regionLabelRectangle0, constraintRegionLabelRectangle0);

			GridLayout layoutRegionLabelRectangle0 = new GridLayout();
			layoutRegionLabelRectangle0.numColumns = 1;
			layoutRegionLabelRectangle0.makeColumnsEqualWidth = true;
			regionLabelRectangle0.setLayoutManager(layoutRegionLabelRectangle0);

			fFigureRegionPriorityFigure = new WrappingLabel();
			fFigureRegionPriorityFigure.setText("<priority>");

			fFigureRegionPriorityFigure
					.setFont(FFIGUREREGIONPRIORITYFIGURE_FONT);

			GridData constraintFFigureRegionPriorityFigure = new GridData();
			constraintFFigureRegionPriorityFigure.verticalAlignment = GridData.BEGINNING;
			constraintFFigureRegionPriorityFigure.horizontalAlignment = GridData.CENTER;
			constraintFFigureRegionPriorityFigure.horizontalIndent = 0;
			constraintFFigureRegionPriorityFigure.horizontalSpan = 1;
			constraintFFigureRegionPriorityFigure.verticalSpan = 1;
			constraintFFigureRegionPriorityFigure.grabExcessHorizontalSpace = true;
			constraintFFigureRegionPriorityFigure.grabExcessVerticalSpace = true;
			regionLabelRectangle0.add(fFigureRegionPriorityFigure,
					constraintFFigureRegionPriorityFigure);

			fFigureRegionCompartmentRectangle = new RectangleFigure();
			fFigureRegionCompartmentRectangle.setOutline(false);
			fFigureRegionCompartmentRectangle.setLineWidth(1);

			GridData constraintFFigureRegionCompartmentRectangle = new GridData();
			constraintFFigureRegionCompartmentRectangle.verticalAlignment = GridData.FILL;
			constraintFFigureRegionCompartmentRectangle.horizontalAlignment = GridData.FILL;
			constraintFFigureRegionCompartmentRectangle.horizontalIndent = 0;
			constraintFFigureRegionCompartmentRectangle.horizontalSpan = 1;
			constraintFFigureRegionCompartmentRectangle.verticalSpan = 1;
			constraintFFigureRegionCompartmentRectangle.grabExcessHorizontalSpace = true;
			constraintFFigureRegionCompartmentRectangle.grabExcessVerticalSpace = true;
			this.add(fFigureRegionCompartmentRectangle,
					constraintFFigureRegionCompartmentRectangle);

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
		public WrappingLabel getFigureRegionPriorityFigure() {
			return fFigureRegionPriorityFigure;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureRegionCompartmentRectangle() {
			return fFigureRegionCompartmentRectangle;
		}

	}

	/**
	 * @generated
	 */
	static final Font FFIGUREREGIONPRIORITYFIGURE_FONT = new Font(Display
			.getCurrent(), "Verdana", 10, SWT.BOLD);

}
