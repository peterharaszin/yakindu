/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
package org.eclipse.damos.library.base.ui.editparts;

import org.eclipse.damos.diagram.ui.editparts.RectangularBlockEditPart;
import org.eclipse.damos.dml.Argument;
import org.eclipse.damos.dml.Block;
import org.eclipse.damos.dml.util.DMLUtil;
import org.eclipse.damos.library.base.util.DelayConstants;
import org.eclipse.damos.library.common.ui.figures.MathExpressionLabel;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

public class DelayEditPart extends RectangularBlockEditPart {

	private MathExpressionLabel contentFigure;
	
	public DelayEditPart(View view) {
		super(view);
	}
	
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshDelay();
	}
	
	protected void refreshDelay() {
		String text = "z^{n}";
		Block block = (Block) resolveSemanticElement();
		if (block != null) {
			int delay = DMLUtil.getArgumentValueAsInteger(block, DelayConstants.PARAMETER__DELAY, 0);
			if (delay > 0) {
				text = "z^{-" + delay + "}";
			}
		}
		contentFigure.setText(text);
	}
	
	protected NodeFigure createMainFigure() {
		NodeFigure figure = super.createMainFigure();
		contentFigure = new MathExpressionLabel();
		figure.add(contentFigure);
		return figure;
	}

	protected void handleNotificationEvent(Notification notification) {
		Object notifier = notification.getNotifier();
		if (notifier instanceof Argument) {
			String parameterName = ((Argument) notifier).getParameter().getName();
			if (DelayConstants.PARAMETER__DELAY.equals(parameterName)) {
				refreshDelay();
			}
		}
		super.handleNotificationEvent(notification);
	}

}
