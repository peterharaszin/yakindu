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

package org.eclipse.damos.library.base.ui.editparts;

import org.eclipse.damos.diagram.ui.editparts.RectangularBlockEditPart;
import org.eclipse.damos.diagram.ui.figures.FontColorAwareLabel;
import org.eclipse.damos.dml.Block;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.library.base.util.NumericDataInConstants;
import org.eclipse.draw2d.Label;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @author Andreas Unger
 *
 */
public class NumericDataInEditPart extends RectangularBlockEditPart {

	private Label textLabel;
	
	/**
	 * @param view
	 */
	public NumericDataInEditPart(View view) {
		super(view);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.editparts.ComponentEditPart#refreshVisuals()
	 */
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshText();
	}
	
	protected void refreshText() {
		Block block = (Block) resolveSemanticElement();
		if (block != null) {
			String minimumValue = block.getArgumentStringValue(NumericDataInConstants.PARAMETER__MINIMUM_VALUE);
			String maximumValue = block.getArgumentStringValue(NumericDataInConstants.PARAMETER__MAXIMUM_VALUE);
			textLabel.setText(minimumValue + ".." + maximumValue);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart#createMainFigure()
	 */
	protected NodeFigure createMainFigure() {
		NodeFigure figure = super.createMainFigure();
		textLabel = new FontColorAwareLabel();
		figure.add(textLabel);
		return figure;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.editparts.ComponentEditPart#handleNotificationEvent(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	protected void handleNotificationEvent(Notification notification) {
		if (notification.getFeature() == DMLPackage.eINSTANCE.getArgument_Value()) {
			refreshText();
		}
		super.handleNotificationEvent(notification);
	}
	
}
