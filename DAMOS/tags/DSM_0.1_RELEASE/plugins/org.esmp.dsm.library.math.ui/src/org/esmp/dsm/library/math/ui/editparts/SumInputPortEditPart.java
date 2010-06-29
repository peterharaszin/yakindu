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

package org.esmp.dsm.library.math.ui.editparts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.esmp.dsm.diagram.ui.editparts.InputPortEditPart;
import org.esmp.dsm.diagram.ui.figures.InputPortFigure;
import org.esmp.dsm.diagram.ui.figures.PortFigure;
import org.esmp.dsm.library.math.ui.figures.SumInputPortContentFigure;
import org.esmp.dsm.library.math.util.SumConstants;
import org.esmp.dsm.semantic.blockdiagram.InputPort;
import org.esmp.dsm.semantic.blockdiagram.Parameter;
import org.esmp.dsm.semantic.blockdiagram.util.BlockDiagramUtil;

/**
 * @author Andreas Unger
 *
 */
public class SumInputPortEditPart extends InputPortEditPart {

	/**
	 * @param view
	 */
	public SumInputPortEditPart(View view) {
		super(view);
	}
	
	/* (non-Javadoc)
	 * @see org.esmp.dsm.diagram.ui.editparts.PortEditPart#refreshVisuals()
	 */
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshSign();
	}
	
	protected void refreshSign() {
		Parameter p = getSignParameter();
		if (p != null) {
			String literal = "1".equals(p.getValue()) ? "+" : "-";
			((SumInputPortContentFigure) ((PortFigure) getFigure()).getContentFigure()).setSign(literal);
		}
	}
	
	protected Parameter getSignParameter() {
		InputPort inputPort = (InputPort) resolveSemanticElement();
		if (inputPort != null) {
			return inputPort.getParameter(SumConstants.PORT_PARAMETER__SIGN);
		}
		return null;
	}
	
	protected String getSignParameterLiteral() {
		InputPort inputPort = (InputPort) resolveSemanticElement();
		double sign = 1;
		if (inputPort != null) {
			sign = BlockDiagramUtil.getParameterValueAsDouble(inputPort, SumConstants.PORT_PARAMETER__SIGN, 1);
		}
		return sign >= 0 ? "+" : "-";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#handleNotificationEvent(org.eclipse.emf.common.notify.Notification)
	 */
	protected void handleNotificationEvent(Notification notification) {
		Parameter p = getSignParameter();
		if (p != null) {
			if (notification.getNotifier() == p) { 
				refreshSign();
				return;
			}
		}
		super.handleNotificationEvent(notification);
	}
	
	/* (non-Javadoc)
	 * @see org.esmp.dsm.diagram.ui.editparts.PortEditPart#createNodeFigure()
	 */
	protected NodeFigure createNodeFigure() {
		return new InputPortFigure(new SumInputPortContentFigure());
	}

}
