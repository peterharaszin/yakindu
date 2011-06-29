/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.diagram.ui.internal.editparts;


import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.GradientData;
import org.eclipse.swt.graphics.Color;
import org.eclipselabs.damos.diagram.ui.editpolicies.DeleteSemanticComponentEditPolicy;
import org.eclipselabs.damos.diagram.ui.editpolicies.IEditPolicyRoles;
import org.eclipselabs.damos.diagram.ui.figures.IFontColorAwareFigure;
import org.eclipselabs.damos.diagram.ui.internal.editpolicies.CompoundConstrainedToolbarLayoutEditPolicy;
import org.eclipselabs.damos.diagram.ui.internal.editpolicies.FragmentSelectionEditPolicy;
import org.eclipselabs.damos.diagram.ui.internal.figures.BlankableBorderedNodeFigure;

/**
 * @author Andreas Unger
 *
 */
public abstract class CompoundEditPart extends AbstractBorderedShapeEditPart {

	/**
	 * @param view
	 */
	public CompoundEditPart(View view) {
		super(view);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart#createDefaultEditPolicies()
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new CompoundConstrainedToolbarLayoutEditPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new DeleteSemanticComponentEditPolicy());
		installEditPolicy(IEditPolicyRoles.FRAGMENT_SELECTION_ROLE, new FragmentSelectionEditPolicy());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart#createNodeFigure()
	 */
	@Override
	protected NodeFigure createNodeFigure() {
		return new BlankableBorderedNodeFigure(createMainFigure());
	}
	
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshFontColor();
	}

	@Override
	protected void setFontColor(Color color) {
		IFigure mainFigure = getMainFigure();
		if (mainFigure instanceof IFontColorAwareFigure) {
			IFontColorAwareFigure fontColorAwareFigure = (IFontColorAwareFigure) mainFigure;
			fontColorAwareFigure.setFontColor(color);
		}
	}

	protected void handleNotificationEvent(Notification notification) {
		Object feature = notification.getFeature();
		if (NotationPackage.eINSTANCE.getFontStyle_FontColor().equals(feature)) {
			refreshFontColor();
		} else {
			super.handleNotificationEvent(notification);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#setGradient(org.eclipse.gmf.runtime.notation.datatype.GradientData)
	 */
	@Override
	protected void setGradient(GradientData gradient) {
    	NodeFigure mainFigure = (NodeFigure) getMainFigure();
    	if (gradient != null) {    		    		
    		mainFigure.setIsUsingGradient(true);
    		mainFigure.setGradientData(gradient.getGradientColor1(), gradient.getGradientColor2(), gradient.getGradientStyle()); 		
    	} else {
    		mainFigure.setIsUsingGradient(false);
    	}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#supportsGradient()
	 */
	@Override
	public boolean supportsGradient() {
		return true;
	}

}
