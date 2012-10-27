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

package org.eclipse.damos.diagram.ui.editparts;

import org.eclipse.damos.diagram.ui.internal.editparts.BlockEditPartDelegate;
import org.eclipse.damos.diagram.ui.internal.editparts.ComponentEditPartDelegate;
import org.eclipse.damos.dml.Argument;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @author Andreas Unger
 *
 */
public abstract class TextualContentBlockEditPart extends TextualContentComponentEditPart {

	/**
	 * @param view
	 */
	public TextualContentBlockEditPart(View view) {
		super(view);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.editparts.BlockEditPart#createDelegate()
	 */
	@Override
	protected final ComponentEditPartDelegate createDelegate() {
		return new BlockEditPartDelegate(this);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#handleNotificationEvent(org.eclipse.emf.common.notify.Notification)
	 */
	protected void handleNotificationEvent(Notification notification) {
		if (notification.getNotifier() == getContentArgument()) {
			refreshContent();
		} else {
			super.handleNotificationEvent(notification);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.editparts.ITextualContentEditPart#getContentElement()
	 */
	public final EObject getContentElement() {
		return getContentArgument();
	}
	
	protected abstract Argument getContentArgument();
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.editparts.ITextualContentEditPart#getContentFeature()
	 */
	public EStructuralFeature getContentFeature() {
		return DMLPackage.eINSTANCE.getArgument_Value();
	}

	public String getContentText() {
		return getContentArgument().getValue().stringValue();
	}
	
}
