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

package org.eclipse.damos.mscript.function.transform;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.damos.mscript.Expression;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionTransformStrategyProvider implements IExpressionTransformStrategyProvider {

	private final Collection<AbstractExpressionTransformStrategy> expressionTransformStrategies = new ArrayList<AbstractExpressionTransformStrategy>();
	
	{
		expressionTransformStrategies.add(new IfExpressionExpander());
		expressionTransformStrategies.add(new LetExpressionExpander());
		expressionTransformStrategies.add(new ArrayConstructionOperatorExpander());
		expressionTransformStrategies.add(new VectorMultiplyExpressionExpander());
		expressionTransformStrategies.add(new BinaryOperationSplitter());
		expressionTransformStrategies.add(new FunctionCallSplitter());
		expressionTransformStrategies.add(new InspectExpressionExpander());
		expressionTransformStrategies.add(new LambdaExpressionExpander());
	}
	
	public IExpressionTransformStrategy getExpressionTransformStrategy(ITransformerContext context, Expression expression) {
		for (AbstractExpressionTransformStrategy transformStrategy : expressionTransformStrategies) {
			if (transformStrategy.canTransform(context, expression)) {
				return transformStrategy;
			}
		}
		return null;
	}

}
