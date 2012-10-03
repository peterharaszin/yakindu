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

package org.eclipse.damos.library.base.ui.editparts;

import org.eclipse.damos.diagram.ui.editparts.BlockInputPortEditPart;
import org.eclipse.damos.diagram.ui.figures.InputPortFigure;
import org.eclipse.damos.diagram.ui.figures.PortFigure;
import org.eclipse.damos.dml.Argument;
import org.eclipse.damos.dml.BlockInputPort;
import org.eclipse.damos.dml.util.DMLUtil;
import org.eclipse.damos.library.base.ui.figures.SumInputPortContentFigure;
import org.eclipse.damos.library.base.util.SumConstants;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @author Andreas Unger
 *
 */
public class SumInputPortEditPart extends BlockInputPortEditPart {

	/**
	 * @param view
	 */
	public SumInputPortEditPart(View view) {
		super(view);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.editparts.PortEditPart#refreshVisuals()
	 */
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshSign();
	}
	
	protected void refreshSign() {
		Argument a = getSignArgument();
		if (a != null) {
			String literal = Double.parseDouble(a.getValue().stringValue()) >= 0 ? "+" : "-";
			((SumInputPortContentFigure) ((PortFigure) getFigure()).getContentFigure()).setSign(literal);
		}
	}
	
	protected Argument getSignArgument() {
		BlockInputPort inputPort = (BlockInputPort) resolveSemanticElement();
		if (inputPort != null) {
			return inputPort.getArgument(SumConstants.PORT_PARAMETER__SIGN);
		}
		return null;
	}
	
	protected String getSignParameterLiteral() {
		BlockInputPort inputPort = (BlockInputPort) resolveSemanticElement();
		double sign = 1;
		if (inputPort != null) {
			sign = DMLUtil.getArgumentValueAsDouble(inputPort, SumConstants.PORT_PARAMETER__SIGN, 1);
		}
		return sign >= 0 ? "+" : "-";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#handleNotificationEvent(org.eclipse.emf.common.notify.Notification)
	 */
	protected void handleNotificationEvent(Notification notification) {
		Argument a = getSignArgument();
		if (a != null) {
			if (notification.getNotifier() == a) { 
				refreshSign();
				return;
			}
		}
		super.handleNotificationEvent(notification);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.editparts.PortEditPart#createNodeFigure()
	 */
	protected NodeFigure createNodeFigure() {
		return new InputPortFigure(new SumInputPortContentFigure());
	}

}
