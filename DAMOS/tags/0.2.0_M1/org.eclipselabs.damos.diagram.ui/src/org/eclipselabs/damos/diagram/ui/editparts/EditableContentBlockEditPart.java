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

package org.eclipselabs.damos.diagram.ui.editparts;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.core.internal.commands.SetArgumentValueCommand;
import org.eclipselabs.damos.diagram.ui.internal.editparts.BlockEditPartDelegate;
import org.eclipselabs.damos.diagram.ui.internal.editparts.ComponentEditPartDelegate;
import org.eclipselabs.damos.dml.Argument;
import org.eclipselabs.damos.dml.DMLFactory;
import org.eclipselabs.damos.dml.ExpressionSpecification;

/**
 * @author Andreas Unger
 *
 */
public abstract class EditableContentBlockEditPart extends EditableContentComponentEditPart {

	/**
	 * @param view
	 */
	public EditableContentBlockEditPart(View view) {
		super(view);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.editparts.BlockEditPart#createDelegate()
	 */
	@Override
	protected final ComponentEditPartDelegate createDelegate() {
		return new BlockEditPartDelegate(this);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#handleNotificationEvent(org.eclipse.emf.common.notify.Notification)
	 */
	protected void handleNotificationEvent(Notification notification) {
		if (notification.getNotifier() == getArgument()) {
			refreshContent();
		} else {
			super.handleNotificationEvent(notification);
		}
	}

	protected String getContentText() {
		return getArgument().getValue().stringValue();
	}
	
	protected ICommand createParseCommand(IAdaptable element, String newString, int flags) {
		ExpressionSpecification expressionSpec = DMLFactory.eINSTANCE.createExpressionSpecification();
		expressionSpec.setExpression(newString);
		return new SetArgumentValueCommand(getArgument(), expressionSpec);
	}
	
	protected abstract Argument getArgument();
	
}
