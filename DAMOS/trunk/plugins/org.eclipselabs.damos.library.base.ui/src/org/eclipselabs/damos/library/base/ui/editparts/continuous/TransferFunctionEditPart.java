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

package org.eclipselabs.damos.library.base.ui.editparts.continuous;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.dml.Argument;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.execution.core.util.ExpressionUtil;
import org.eclipselabs.damos.library.base.util.continuous.TransferFunctionConstants;
import org.eclipselabs.damos.library.common.ui.editparts.FractionBlockEditPart;
import org.eclipselabs.damos.library.common.util.PolynomialExpressionUtil;
import org.eclipselabs.damos.mscript.interpreter.value.INumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.VectorValue;

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
		String expression = createPolynomialExpression(TransferFunctionConstants.PARAMETER__NUMERATOR_COEFFICIENTS);
		if (expression != null) {
			return expression;
		}
		return "a1s^{n}+a2s^{n-1}+...+ans+1";
	}

	protected String getDenominator() {
		String expression = createPolynomialExpression(TransferFunctionConstants.PARAMETER__DENOMINATOR_COEFFICIENTS);
		if (expression != null) {
			return expression;
		}
		return "b1s^{n}+b2s^{n-1}+...+bns+1";
	}
	
	private String createPolynomialExpression(String parameterName) {
		Block block = (Block) resolveSemanticElement();
		if (block != null) {
			try {
				IValue value = ExpressionUtil.evaluateArgumentExpression(block, parameterName);
				if (value instanceof VectorValue) {
					VectorValue vectorValue = (VectorValue) value;
					double[] coefficients = new double[vectorValue.getSize()];
					for (int i = 0; i < coefficients.length; ++i) {
						INumericValue elementValue = vectorValue.get(i);
						if (!(elementValue instanceof ISimpleNumericValue)) {
							return null;
						}
						coefficients[i] = ((ISimpleNumericValue) elementValue).doubleValue();
					}
					return PolynomialExpressionUtil.createPolynomialExpression(coefficients, "s", false);
				}
			} catch (CoreException e) {
				// Ignore invalid expression
			}
		}
		return null;
	}

	protected void handleNotificationEvent(Notification notification) {
		Object notifier = notification.getNotifier();
		if (notifier instanceof Argument) {
			String parameterName = ((Argument) notifier).getParameter().getName();
			if (TransferFunctionConstants.PARAMETER__NUMERATOR_COEFFICIENTS.equals(parameterName)) {
				refreshNumerator();
			} else if (TransferFunctionConstants.PARAMETER__DENOMINATOR_COEFFICIENTS.equals(parameterName)) {
				refreshDenominator();
			}
		}
		super.handleNotificationEvent(notification);
	}

}
