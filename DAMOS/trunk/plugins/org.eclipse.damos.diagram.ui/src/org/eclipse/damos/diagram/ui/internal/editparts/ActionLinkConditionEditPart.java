/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.diagram.ui.internal.editparts;

import org.eclipse.damos.diagram.ui.editparts.ITextualContentEditPart;
import org.eclipse.damos.diagram.ui.internal.editpolicies.NonResizableLabelEditPolicy;
import org.eclipse.damos.diagram.ui.tools.IValueSpecificationDirectEditHelper;
import org.eclipse.damos.dml.ActionLink;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.ui.registry.UIInjectorProviderRegistry;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.label.ILabelDelegate;
import org.eclipse.gmf.runtime.diagram.ui.label.LabelExDelegate;
import org.eclipse.gmf.runtime.draw2d.ui.figures.LabelEx;
import org.eclipse.gmf.runtime.notation.View;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Andreas Unger
 *
 */
public class ActionLinkConditionEditPart extends LabelEditPart implements ITextualContentEditPart {

	private ILabelDelegate conditionLabel;

	@Inject
	private IValueSpecificationDirectEditHelper directEditHelper;
	
	/**
	 * @param view
	 */
	public ActionLinkConditionEditPart(View view) {
		super(view);
		Injector injector = UIInjectorProviderRegistry.getInstance().getInjector(view.getElement());
		if (injector != null) {
			injector.injectMembers(this);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart#createDefaultEditPolicies()
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new NonResizableLabelEditPolicy());
		directEditHelper.createDefaultEditPolicies(this);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart#createFigure()
	 */
	@Override
	protected IFigure createFigure() {
		IFigure figure = super.createFigure();
		LabelEx label = new LabelEx();
		conditionLabel = new LabelExDelegate(label);
		figure.add(label);
		return figure;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart#refreshVisuals()
	 */
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshCondition();
	}
	
	protected void refreshCondition() {
		ActionLink actionLink = (ActionLink) resolveSemanticElement();
		if (conditionLabel != null && actionLink != null) {
			if (actionLink.getCondition() != null) {
				conditionLabel.setText(actionLink.getCondition().stringValue());
			} else {
				conditionLabel.setText("default");
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.TopGraphicEditPart#performDirectEditRequest(org.eclipse.gef.Request)
	 */
	@Override
	protected void performDirectEditRequest(Request request) {
		directEditHelper.performDirectEditRequest(this, request);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart#handleNotificationEvent(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	protected void handleNotificationEvent(Notification notification) {
		if (notification.getFeature() == DMLPackage.eINSTANCE.getActionLink_Condition()) {
			refreshCondition();
		} else {
			super.handleNotificationEvent(notification);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.editparts.ITextAwareEditPart#getEditableElement()
	 */
	public EObject getContentElement() {
		return resolveSemanticElement();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.editparts.ITextAwareEditPart#getEditableFeature()
	 */
	public EStructuralFeature getContentFeature() {
		return DMLPackage.eINSTANCE.getActionLink_Condition();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart#getEditText()
	 */
	public String getContentText() {
		ActionLink actionLink = (ActionLink) resolveSemanticElement();
		if (actionLink != null) {
			if (actionLink.getCondition() != null) {
				return actionLink.getCondition().stringValue();
			} else {
				return "default";
			}
		}
		return "";
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart#setLabelText(java.lang.String)
	 */
	public void setContentText(String text) {
	}
	
	public ILabelDelegate getContentLabel() {
		return conditionLabel;
	}
	
}
