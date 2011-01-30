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

package org.eclipselabs.damos.library.base.ui.logic.editparts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.editparts.LabeledRectangularBlockEditPart;
import org.eclipselabs.damos.dml.Argument;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.ExpressionParameter;
import org.eclipselabs.damos.dml.PredefinedExpressionEntry;
import org.eclipselabs.damos.library.base.logic.util.CompareConstants;

/**
 * @author Andreas Unger
 *
 */
public class CompareEditPart extends LabeledRectangularBlockEditPart {

	/**
	 * @param view
	 */
	public CompareEditPart(View view) {
		super(view);
	}

	protected String getLabel() {
		String operator = "";
		Block block = (Block) resolveSemanticElement();
		if (block != null) {
			Argument argument = block.getArgument(CompareConstants.PARAMETER__OPERATOR);
			if (argument != null && argument.getParameter() instanceof ExpressionParameter) {
				ExpressionParameter parameter = (ExpressionParameter) argument.getParameter();
				PredefinedExpressionEntry entry = parameter.getPredefinedExpression(argument.getValue().stringValue());
				if (entry != null) {
					operator = entry.getAlias();
				}
			}
		}
		return operator;
	}
	
	protected void handleNotificationEvent(Notification notification) {
		Object notifier = notification.getNotifier();
		if (notifier instanceof Argument) {
			String parameterName = ((Argument) notifier).getParameter().getName();
			if (CompareConstants.PARAMETER__OPERATOR.equals(parameterName)) {
				refreshLabel();
			}
		}
		super.handleNotificationEvent(notification);
	}

}
