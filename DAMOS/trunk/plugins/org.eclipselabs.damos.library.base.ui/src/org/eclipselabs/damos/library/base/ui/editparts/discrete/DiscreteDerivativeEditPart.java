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

package org.eclipselabs.damos.library.base.ui.editparts.discrete;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.dml.Argument;
import org.eclipselabs.damos.library.base.util.discrete.DiscreteDerivativeConstants;
import org.eclipselabs.damos.library.common.ui.editparts.FractionBlockEditPart;

/**
 * @author Andreas Unger
 *
 */
public class DiscreteDerivativeEditPart extends FractionBlockEditPart {

	/**
	 * @param view
	 */
	public DiscreteDerivativeEditPart(View view) {
		super(view);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.library.basic.ui.editparts.FractionBlockEditPart#getNumerator()
	 */
	protected String getNumerator() {
		return " \u0394u ";
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.library.basic.ui.editparts.FractionBlockEditPart#getDenominator()
	 */
	protected String getDenominator() {
		return " Ts ";
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.editparts.BlockEditPart#handleNotificationEvent(org.eclipse.emf.common.notify.Notification)
	 */
	protected void handleNotificationEvent(Notification notification) {
		Object notifier = notification.getNotifier();
		if (notifier instanceof Argument) {
			String parameterName = ((Argument) notifier).getParameter().getName();
			if (DiscreteDerivativeConstants.PARAMETER__GAIN.equals(parameterName)) {
				refreshNumerator();
			}
		}
		super.handleNotificationEvent(notification);
	}

}
