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

package org.eclipselabs.damos.library.base.ui.continuous.editparts;

import java.io.StringReader;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipselabs.damos.dml.Argument;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.execution.core.ExecutionEnginePlugin;
import org.eclipselabs.damos.library.base.continuous.util.TransferFunctionConstants;
import org.eclipselabs.damos.library.common.ui.editparts.FractionBlockEditPart;
import org.eclipselabs.damos.library.common.util.PolynomialExpressionUtil;
import org.eclipselabs.damos.mscript.ArrayConstructionOperator;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.IntegerLiteral;
import org.eclipselabs.damos.mscript.RealLiteral;
import org.eclipselabs.damos.mscript.UnaryExpression;
import org.eclipselabs.damos.mscript.UnaryOperator;
import org.eclipselabs.damos.mscript.parser.antlr.MscriptParser;

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
			String argument = block.getArgumentStringValue(parameterName);
			if (argument != null) {
				MscriptParser parser = ExecutionEnginePlugin.getDefault().getMscriptParser();
				IParseResult result = parser.parse(
						parser.getGrammarAccess().getArrayConstructionOperatorRule(),
						new StringReader(argument));
				if (!result.hasSyntaxErrors()) {
					List<Expression> expressions = ((ArrayConstructionOperator) result.getRootASTElement()).getExpressions();
					double[] coefficients = new double[expressions.size()];
					int i = 0;
					for (Expression expression : expressions) {
						double factor = 1;
						if (expression instanceof UnaryExpression) {
							UnaryExpression unaryExpression = (UnaryExpression) expression;
							if (unaryExpression.getOperator() == UnaryOperator.NEGATE) {
								expression = unaryExpression.getOperand();
								factor = -1;
							}
						}
						if (expression instanceof RealLiteral) {
							coefficients[i] = factor * ((RealLiteral) expression).getValue();
						} else if (expression instanceof IntegerLiteral) {
							coefficients[i] = factor * ((IntegerLiteral) expression).getValue();
						} else {
							return null;
						}
						++i;
					}
					return PolynomialExpressionUtil.createPolynomialExpression(coefficients, "s", false);
				}
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
