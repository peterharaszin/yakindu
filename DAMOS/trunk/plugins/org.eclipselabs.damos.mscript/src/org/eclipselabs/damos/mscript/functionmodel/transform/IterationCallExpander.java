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

import java.util.List;

import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.IterationCall;
import org.eclipselabs.damos.mscript.MscriptFactory;

/**
 * @author Andreas Unger
 *
 */
public class IterationCallExpander implements IExpressionTransformStrategy {

	private IterationCallTransformerLookup iterationCallTransformerLookup = new IterationCallTransformerLookup();

	public boolean canHandle(ITransformerContext context, Expression expression) {
		return expression instanceof IterationCall;
	}

	public void transform(ITransformerContext context, Expression expression, List<? extends IExpressionTarget> targets, IExpressionTransformer transformer) {
		IterationCall iterationCall = (IterationCall) expression;
		IIterationCallTransformer iterationCallTransformer = iterationCallTransformerLookup.getTransformer(iterationCall.getIdentifier());
		if (iterationCallTransformer == null) {
			// TODO: Handle error
//			status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Invalid iteration call", iterationCall));
			targets.get(0).assignExpression(MscriptFactory.eINSTANCE.createInvalidExpression());
			return;
		}
		
		InlineExpressionTarget target = new InlineExpressionTarget(context);
		transformer.transform(iterationCall.getTarget(), target.asList());
		iterationCallTransformer.transform(context, iterationCall, target.getAssignedExpression(), targets);
	}

}
