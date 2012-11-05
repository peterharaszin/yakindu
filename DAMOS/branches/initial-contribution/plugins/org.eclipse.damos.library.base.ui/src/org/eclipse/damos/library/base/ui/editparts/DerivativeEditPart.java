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

import org.eclipse.damos.dml.Argument;
import org.eclipse.damos.library.base.util.DerivativeConstants;
import org.eclipse.damos.library.common.ui.editparts.FractionBlockEditPart;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @author Andreas Unger
 *
 */
public class DerivativeEditPart extends FractionBlockEditPart {

	/**
	 * @param view
	 */
	public DerivativeEditPart(View view) {
		super(view);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.library.basic.ui.editparts.FractionBlockEditPart#getNumerator()
	 */
	protected String getNumerator() {
		return " du ";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.library.basic.ui.editparts.FractionBlockEditPart#getDenominator()
	 */
	protected String getDenominator() {
		return " dt ";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.editparts.BlockEditPart#handleNotificationEvent(org.eclipse.emf.common.notify.Notification)
	 */
	protected void handleNotificationEvent(Notification notification) {
		Object notifier = notification.getNotifier();
		if (notifier instanceof Argument) {
			String parameterName = ((Argument) notifier).getParameter().getName();
			if (DerivativeConstants.PARAMETER__GAIN.equals(parameterName)) {
				refreshNumerator();
			}
		}
		super.handleNotificationEvent(notification);
	}

}
