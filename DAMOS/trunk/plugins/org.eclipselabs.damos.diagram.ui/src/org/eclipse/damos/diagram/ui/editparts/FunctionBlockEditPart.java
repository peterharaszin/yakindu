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

package org.eclipse.damos.diagram.ui.editparts;

import org.eclipse.damos.diagram.ui.editpolicies.IEditPolicyRoles;
import org.eclipse.damos.diagram.ui.editpolicies.NonRotatableTransformEditPolicy;
import org.eclipse.damos.diagram.ui.figures.FunctionBlockFigure;
import org.eclipse.damos.dml.Block;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.util.DMLUtil;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @author Andreas Unger
 *
 */
public class FunctionBlockEditPart extends StandardBlockEditPart {

	/**
	 * @param view
	 */
	public FunctionBlockEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(IEditPolicyRoles.TRANSFORM_ROLE, new NonRotatableTransformEditPolicy());
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshHeader();
	}

	protected void refreshHeader() {
		Block block = (Block) resolveSemanticElement();
		if (block != null) {
			getMainFigure().setHeaderText(DMLUtil.safeFormatName(block.getType()));
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart#createMainFigure()
	 */
	@Override
	protected FunctionBlockFigure createMainFigure() {
		return new FunctionBlockFigure();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getFigure()
	 */
	@Override
	public FunctionBlockFigure getMainFigure() {
		return (FunctionBlockFigure) super.getMainFigure();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.editparts.ComponentEditPart#handleNotificationEvent(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	protected void handleNotificationEvent(Notification notification) {
		if (notification.getFeature() == DMLPackage.eINSTANCE.getBlock_Type()) {
			refreshHeader();
		}
		super.handleNotificationEvent(notification);
	}
	
}
