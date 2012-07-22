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

package org.eclipselabs.damos.mscript.functionmodel.transform;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionTransformStrategyProvider implements IExpressionTransformStrategyProvider {

	private final Collection<IExpressionTransformStrategy> expressionTransformStrategies = new ArrayList<IExpressionTransformStrategy>();
	
	{
		expressionTransformStrategies.add(new IfExpressionExpander());
		expressionTransformStrategies.add(new LetExpressionExpander());
		expressionTransformStrategies.add(new IterationCallExpander());
		expressionTransformStrategies.add(new ArrayConstructionOperatorExpander());
		expressionTransformStrategies.add(new VectorMultiplyExpressionExpander());
		expressionTransformStrategies.add(new ComplexOperationSplitter());
		expressionTransformStrategies.add(new LambdaExpressionExpander());
		expressionTransformStrategies.add(new DefaultExpressionTransformStrategy());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.functionmodel.transform.IExpressionTransformStrategyProvider#getExpressionTransformStrategies()
	 */
	public Collection<IExpressionTransformStrategy> getExpressionTransformStrategies() {
		return expressionTransformStrategies;
	}

}
