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

package org.esmp.dsm.library.continuous.ui.editparts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.notation.View;
import org.esmp.dsm.library.basic.ui.editparts.FractionBlockEditPart;
import org.esmp.dsm.library.common.util.PolynomialExpressionUtil;
import org.esmp.dsm.library.continuous.util.TransferFunctionConstants;
import org.esmp.dsm.semantic.blockdiagram.Block;
import org.esmp.dsm.semantic.blockdiagram.Parameter;

/**
 * @author Andreas Unger
 *
 */
public class TransferFunctionEditPart extends FractionBlockEditPart {

	/**
	 * @param view
	 */
	public TransferFunctionEditPart(View view) {
		super(view);
	}

	protected String getNumerator() {
		return createPolynomialExpression(TransferFunctionConstants.PARAMETER__NUMERATOR_COEFFICIENTS);
	}

	protected String getDenominator() {
		return createPolynomialExpression(TransferFunctionConstants.PARAMETER__DENOMINATOR_COEFFICIENTS);
	}
	
	private String createPolynomialExpression(String parameterName) {
		return PolynomialExpressionUtil.createFromParameter((Block) resolveSemanticElement(), parameterName, "s", false);
	}
		
	protected void handleNotificationEvent(Notification notification) {
		Object notifier = notification.getNotifier();
		if (notifier instanceof Parameter) {
			String parameterName = ((Parameter) notifier).getName();
			if (TransferFunctionConstants.PARAMETER__NUMERATOR_COEFFICIENTS.equals(parameterName)) {
				refreshNumerator();
			} else if (TransferFunctionConstants.PARAMETER__DENOMINATOR_COEFFICIENTS.equals(parameterName)) {
				refreshDenominator();
			}
		}
		super.handleNotificationEvent(notification);
	}

}
