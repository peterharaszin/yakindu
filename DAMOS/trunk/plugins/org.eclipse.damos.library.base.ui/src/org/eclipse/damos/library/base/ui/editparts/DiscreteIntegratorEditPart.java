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

import org.eclipse.damos.dml.Argument;
import org.eclipse.damos.dml.Block;
import org.eclipse.damos.dml.util.DMLUtil;
import org.eclipse.damos.library.base.util.DiscreteIntegratorConstants;
import org.eclipse.damos.library.common.ui.editparts.FractionBlockEditPart;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @author Andreas Unger
 *
 */
public class DiscreteIntegratorEditPart extends FractionBlockEditPart {

	/**
	 * @param view
	 */
	public DiscreteIntegratorEditPart(View view) {
		super(view);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.library.basic.ui.editparts.FractionBlockEditPart#getNumerator()
	 */
	protected String getNumerator() {
		Block block = (Block) resolveSemanticElement();
		if (block != null) {
			boolean accumulation = DMLUtil.getArgumentValueAsBoolean(block, DiscreteIntegratorConstants.PARAMETER__ACCUMULATION, false);
			if (accumulation) {
				return " 1 ";
			}
		}
		return " Ts ";
	}
		
	/* (non-Javadoc)
	 * @see org.eclipse.damos.library.basic.ui.editparts.FractionBlockEditPart#getDenominator()
	 */
	protected String getDenominator() {
		return " z-1 ";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.editparts.BlockEditPart#handleNotificationEvent(org.eclipse.emf.common.notify.Notification)
	 */
	protected void handleNotificationEvent(Notification notification) {
		Object notifier = notification.getNotifier();
		if (notifier instanceof Argument) {
			String parameterName = ((Argument) notifier).getParameter().getName();
			if (DiscreteIntegratorConstants.PARAMETER__GAIN.equals(parameterName)
					|| DiscreteIntegratorConstants.PARAMETER__ACCUMULATION.equals(parameterName)) {
				refreshNumerator();
			}
		}
		super.handleNotificationEvent(notification);
	}

}
