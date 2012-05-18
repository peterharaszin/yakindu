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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.ui.editor.policies.StateCompartmentCanonicalEditPolicy;
import org.yakindu.sct.ui.editor.policies.StateCompartmentCreationEditPolicy;

import de.itemis.gmf.runtime.commons.editpolicies.CompartmentLayoutEditPolicy;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StateFigureCompartmentEditPart extends
		ResizableCompartmentEditPart {

	private static final String PARENT_VIEW = "parent_view";

	public StateFigureCompartmentEditPart(View view) {
		super(view);
	}

	// Listeners for the parent view to get notified when layout is changed
	@Override
	protected void addNotationalListeners() {
		addListenerFilter(PARENT_VIEW, this, getParent().getNotationView());
		super.addNotationalListeners();
	}

	@Override
	protected void removeNotationalListeners() {
		removeListenerFilter(PARENT_VIEW);
		super.removeNotationalListeners();
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new StateCompartmentCreationEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new StateCompartmentCanonicalEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new DragDropEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE,
				new CompartmentLayoutEditPolicy(
						SGraphPackage.Literals.COMPOSITE_ELEMENT__REGIONS));

	}

	@Override
	public boolean isSelectable() {
		return false;
	}

	@Override
	protected IFigure createFigure() {
		ResizableCompartmentFigure figure = (ResizableCompartmentFigure) super
				.createFigure();
		figure.getContentPane().setLayoutManager(
				new StateFigureCompartmentLayout(getAlignment()));
		figure.setBorder(null);
		//Should be initialized with null to display nothing. 
		figure.setToolTip((String)null);
		return figure;
	}

	@Override
	public ResizableCompartmentFigure getFigure() {
		return (ResizableCompartmentFigure) super.getFigure();
	}

	@Override
	public StateEditPart getParent() {
		return (StateEditPart) super.getParent();
	}

	protected boolean getAlignment() {
		// We use a BooleanValueStyle to carry the alignment value
		BooleanValueStyle style = (BooleanValueStyle) getParent()
				.getNotationView().getStyle(
						NotationPackage.Literals.BOOLEAN_VALUE_STYLE);
		return (style != null) ? style.isBooleanValue() : true;
	}

	@Override
	protected void handleNotificationEvent(Notification event) {
		if (event.getFeature() == NotationPackage.Literals.BOOLEAN_VALUE_STYLE__BOOLEAN_VALUE) {
			updateLayout();
		}
		super.handleNotificationEvent(event);
	}

	private void updateLayout() {
		getFigure().getContentPane().setLayoutManager(
				new StateFigureCompartmentLayout(getAlignment()));
	}

	private static final class StateFigureCompartmentLayout extends
			ConstrainedToolbarLayout {
		public StateFigureCompartmentLayout(boolean alignment) {
			super(alignment);
			setSpacing(-1); // make lines overlap so it looks like a shared line
		}

		@Override
		protected Dimension calculatePreferredSize(IFigure container,
				int wHint, int hHint) {
			return new Dimension(1, 1);
		}
	}
}
