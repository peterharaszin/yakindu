/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.mscript.function.transform;

import java.util.List;

import org.eclipse.damos.mscript.Expression;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionTransformer implements IExpressionTransformer {

	private final IExpressionTransformStrategyProvider expressionTransformStrategyProvider = new ExpressionTransformStrategyProvider();

	private final IExpressionTransformStrategy defaultExpressionTransformStrategy = new DefaultExpressionTransformStrategy();
	
	public void transform(ITransformerContext context, Expression expression, List<? extends IExpressionTarget> targets) {
		ExpressionTransformResult result = new ExpressionTransformResult(context, this, targets);
		IExpressionTransformStrategy transformStrategy = expressionTransformStrategyProvider.getExpressionTransformStrategy(context, expression);
		if (transformStrategy != null) {
			transformStrategy.transform(result, expression);
		} else {
			defaultExpressionTransformStrategy.transform(result, expression);
		}
	}
	
//	protected Expression condenseExpression(IValue value, Expression expression) {
//		if (value instanceof ISimpleNumericValue) {
//			ISimpleNumericValue numericValue = (ISimpleNumericValue) value;
//			NumericType dataType = numericValue.getDataType();
//			if (dataType instanceof RealType) {
//				RealLiteral realLiteral = MscriptFactory.eINSTANCE.createRealLiteral();
//				realLiteral.setValue(numericValue.doubleValue());
//				realLiteral.setUnit(EcoreUtil.copy(dataType.getUnit()));
//				expression = realLiteral;
//			} else if (dataType instanceof IntegerType) {
//				IntegerLiteral integerLiteral = MscriptFactory.eINSTANCE.createIntegerLiteral();
//				integerLiteral.setValue(numericValue.longValue());
//				integerLiteral.setUnit(EcoreUtil.copy(dataType.getUnit()));
//				expression = integerLiteral;
//			}
//		}
//		return expression;
//	}
	
}
