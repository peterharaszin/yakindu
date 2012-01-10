/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.editparts;

import java.util.List;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableEditPolicyEx;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableEditPolicyEx;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.Compartment;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.ui.editor.editor.figures.StateFigure;
import org.yakindu.sct.ui.editor.editor.figures.utils.GridDataFactory;
import org.yakindu.sct.ui.editor.editor.figures.utils.MapModeUtils;
import org.yakindu.sct.ui.editor.preferences.StatechartColorConstants;

/**
 * The EditPart for the State.
 * 
 * 
 * @author andreas muelder
 * @author alexander nyssen
 * @author markus muehlbrandt
 * 
 */
public class StateEditPart extends ShapeNodeEditPart implements
		IPrimaryEditPart {

	private EditPart figureCompartmentEditPart;

	public StateEditPart(View view) {
		super(view);
	}

	/**
	 * Delegates all {@link CreateViewAndElementRequest}s to the figure
	 * compartment.
	 */
	@Override
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateViewAndElementRequest) {
			return figureCompartmentEditPart;
		}
		if (request instanceof GroupRequest
				&& request.getType() == RequestConstants.REQ_DROP) {
			GroupRequest req = (GroupRequest) request;
			if (areInsertableChildren(req.getEditParts())) {
				return figureCompartmentEditPart;
			}
		}

		return super.getTargetEditPart(request);
	}

	private boolean areInsertableChildren(List<?> editParts) {
		for (Object object : editParts) {
			if (!(object instanceof RegionEditPart)) {
				return false;
			}
		}
		return true;
	}

	@Override
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = new DefaultSizeNodeFigure(getDefaultSize()) {
			@Override
			// StateFigure is drawed smaller (Blurshadow size)
			public Rectangle getHandleBounds() {
				Insets insets = new Insets(0, 0, StateFigure.BLUR_SHADOW_WIDTH,
						StateFigure.BLUR_SHADOW_WIDTH);

				return new Rectangle(getBounds().x + insets.left, getBounds().y
						+ insets.top, getBounds().width
						- (insets.right + insets.left), getBounds().height
						- (insets.bottom + insets.top));
			}

		};
		figure.setLayoutManager(new StackLayout());
		figure.setMinimumSize(getDefaultSize());
		figure.add(createPrimaryShape());
		return figure;
	}

	private Dimension getDefaultSize() {
		return MapModeUtils.getDefaultSizeDimension(getMapMode());
	}

	public StateFigure createPrimaryShape() {
		return new StateFigure(getMapMode());
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		// installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
		// new RelationshipSemanticEditPolicy());
		// We don't want to allow creation for parent editpart on a State
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicy() {
					@Override
					protected Command getCreateElementAndViewCommand(
							CreateViewAndElementRequest request) {
						return UnexecutableCommand.INSTANCE;
					}
				});

		if (isCollapsed()) {
			installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE,
					new NonResizableEditPolicyEx());
		} else {
			installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE,
					new ResizableEditPolicyEx());
		}
	}

	@Override
	protected void refreshVisuals() {
		refreshCompartmentStates();
		super.refreshVisuals();
	}

	private void refreshCompartmentStates() {
		if (getTextCompartment().isCollapsed()) {
			getPrimaryShape().setConstraint(
					getPrimaryShape().getTextCompartmentPane(),
					getCollapsedData());
		} else {
			GridData expandedData = getExpandedData();
			if (!getFigureCompartment().isCollapsed())
				expandedData.grabExcessVerticalSpace = false;
			getPrimaryShape().setConstraint(
					getPrimaryShape().getTextCompartmentPane(), expandedData);
		}
		if (getFigureCompartment().isCollapsed()) {
			getPrimaryShape().setConstraint(
					getPrimaryShape().getFigureCompartmentPane(),
					getCollapsedData());
		} else {
			GridData expandedData = getExpandedData();

			getPrimaryShape().setConstraint(
					getPrimaryShape().getFigureCompartmentPane(), expandedData);
		}
	}

	private GridData getExpandedData() {
		return GridDataFactory.fillDefaults().grab(true, true).getData();
	}

	private GridData getCollapsedData() {
		return GridDataFactory.fillDefaults().grab(false, false).getData();
	}

	@Override
	protected void refreshBounds() {

		// TODO: Calculate the 'default' size
		int width = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE
				.getSize_Width())).intValue();
		int height = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE
				.getSize_Height())).intValue();

		Dimension size = new Dimension(width, height);
		int x = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE
				.getLocation_X())).intValue();
		int y = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE
				.getLocation_Y())).intValue();
		Point loc = new Point(x, y);

		if (isCollapsed()) {
			((GraphicalEditPart) getParent()).setLayoutConstraint(this,
					getFigure(), new Rectangle(loc, new Dimension(58, 66)));
		} else {
			((GraphicalEditPart) getParent()).setLayoutConstraint(this,
					getFigure(), new Rectangle(loc, size));
		}
	}

	private Compartment getFigureCompartment() {
		return (Compartment) getNotationView().getChildren().get(2);
	}

	private Compartment getTextCompartment() {
		return (Compartment) getNotationView().getChildren().get(1);
	}

	public boolean isCollapsed() {
		return getFigureCompartment().isCollapsed()
				&& getTextCompartment().isCollapsed();
	}

	@Override
	public IFigure getContentPane() {
		return getPrimaryShape().getFigureCompartmentPane();
	}

	public StateFigure getPrimaryShape() {
		return (StateFigure) getFigure().getChildren().get(0);
	}

	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (childEditPart instanceof StateFigureCompartmentEditPart) {
			figureCompartmentEditPart = childEditPart;
			IFigure pane = getPrimaryShape().getFigureCompartmentPane();
			IFigure compartmentFigure = ((StateFigureCompartmentEditPart) childEditPart)
					.getFigure();
			pane.add(compartmentFigure);
		} else if (childEditPart instanceof StateNameEditPart) {
			((StateNameEditPart) childEditPart).setLabel(getPrimaryShape()
					.getNameFigure());
		} else if (childEditPart instanceof StateTextCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getTextCompartmentPane();
			IFigure compartmentFigure = ((StateTextCompartmentEditPart) childEditPart)
					.getFigure();
			pane.add(compartmentFigure);
		} else {
			super.addChildVisual(childEditPart, index);
		}
	}

	// TODO: removeChildvisual

	@Override
	protected void addNotationalListeners() {
		super.addNotationalListeners();
		addListenerFilter("TextCompartmentView", this, (Node) getNotationView()
				.getChildren().get(1));
		addListenerFilter("FigureCompartmentView", this,
				(Node) getNotationView().getChildren().get(2));
	}

	@Override
	protected void removeNotationalListeners() {
		super.removeNotationalListeners();
		removeListenerFilter("TextCompartmentView");
		removeListenerFilter("FigureCompartmentView");
	}

	/**
	 * Returns the default background color for states
	 */
	@Override
	public Object getPreferredValue(EStructuralFeature feature) {
		if (feature == NotationPackage.eINSTANCE.getLineStyle_LineColor()) {
			return FigureUtilities
					.RGBToInteger(StatechartColorConstants.STATE_LINE_COLOR
							.getRGB());
		} else if (feature == NotationPackage.eINSTANCE
				.getFillStyle_FillColor()) {
			return FigureUtilities
					.RGBToInteger(StatechartColorConstants.STATE_BG_COLOR
							.getRGB());
		}
		return super.getPreferredValue(feature);
	}

	@Override
	public State resolveSemanticElement() {
		return (State) super.resolveSemanticElement();
	}

	@Override
	protected void handleNotificationEvent(Notification notification) {

		if (notification.getFeature() == NotationPackage.Literals.DRAWER_STYLE__COLLAPSED) {

			if (isCollapsed()) {
				installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE,
						new NonResizableEditPolicyEx());

			} else {

				installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE,
						new ResizableEditPolicyEx());
			}
			refreshVisuals();
		}

		super.handleNotificationEvent(notification);
	}
}