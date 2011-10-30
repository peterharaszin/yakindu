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

package org.eclipselabs.damos.library.common.ui.editparts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.editparts.LabeledRectangularBlockEditPart;
import org.eclipselabs.damos.dml.Argument;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.Parameter;
import org.eclipselabs.damos.dml.ParameterPredefinedValue;

/**
 * @author Andreas Unger
 *
 */
public abstract class ArgumentValueBlockEditPart extends LabeledRectangularBlockEditPart {

	/**
	 * @param view
	 */
	public ArgumentValueBlockEditPart(View view) {
		super(view);
	}

	protected String getText() {
		Block block = (Block) resolveSemanticElement();
		if (block != null) {
			Argument argument = block.getArgument(getParameterName());
			if (argument != null) {
				Parameter parameter = argument.getParameter();
				String stringValue = argument.getValue().stringValue();
				ParameterPredefinedValue value = parameter.getPredefinedValue(stringValue);
				if (value != null) {
					return value.getAlias();
				}
				return stringValue;
			}
		}
		return "";
	}
	
	protected void handleNotificationEvent(Notification notification) {
		Object notifier = notification.getNotifier();
		if (notifier instanceof Argument) {
			String parameterName = ((Argument) notifier).getParameter().getName();
			if (getParameterName().equals(parameterName)) {
				refreshText();
			}
		}
		super.handleNotificationEvent(notification);
	}
	
	protected abstract String getParameterName();

}
