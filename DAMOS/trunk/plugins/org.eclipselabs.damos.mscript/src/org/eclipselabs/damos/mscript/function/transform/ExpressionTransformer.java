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

package org.eclipselabs.damos.mscript.function.transform;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.internal.MscriptPlugin;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionTransformer implements IExpressionTransformer {

	private final IExpressionTransformStrategyProvider expressionTransformStrategyProvider = new ExpressionTransformStrategyProvider();
	
	private ITransformerContext context;

	private MultiStatus status;

	/**
	 * 
	 */
	public ExpressionTransformer(ITransformerContext context) {
		this.context = context;
		status = new MultiStatus(MscriptPlugin.PLUGIN_ID, 0, "Expression transformation", null);
	}
	
	public IStatus transform(Expression expression, List<? extends IExpressionTarget> targets) {
		for (IExpressionTransformStrategy transformStrategy : expressionTransformStrategyProvider.getExpressionTransformStrategies()) {
			if (transformStrategy.canHandle(context, expression)) {
				transformStrategy.transform(context, expression, targets, this);
				break;
			}
		}
		return status.isOK() ? Status.OK_STATUS : status;
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
