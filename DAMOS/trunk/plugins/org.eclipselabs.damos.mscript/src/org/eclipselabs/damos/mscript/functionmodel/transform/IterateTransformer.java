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

package org.eclipselabs.damos.mscript.functionmodel.transform;

import java.util.Collections;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipselabs.damos.mscript.Compound;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.ForStatement;
import org.eclipselabs.damos.mscript.IterationCall;
import org.eclipselabs.damos.mscript.IterationVariableDeclaration;
import org.eclipselabs.damos.mscript.LocalVariableDeclaration;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.internal.MscriptPlugin;
import org.eclipselabs.damos.mscript.internal.util.StatusUtil;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class IterateTransformer implements IIterationCallTransformer {

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.imperativemodel.transform.IIterationCallTransformer#transform(org.eclipselabs.mscript.language.ast.IterationCall, org.eclipselabs.mscript.language.imperativemodel.util.ImperativeExpressionTransformer.Scope)
	 */
	public IIterationCallTransformerResult transform(ITransformerContext context, IterationCall iterationCall, Expression collectionExpression) {
		MultiStatus status = new MultiStatus(MscriptPlugin.PLUGIN_ID, 0, "Iterate transformation", null);
		
		LocalVariableDeclaration accumulatorDeclaration = MscriptFactory.eINSTANCE.createLocalVariableDeclaration();
		IValue accumulatorValue = context.getStaticEvaluationResult().getValue(iterationCall.getAccumulator());
		context.getStaticEvaluationResult().setValue(accumulatorDeclaration, accumulatorValue);
		accumulatorDeclaration.setName(iterationCall.getAccumulator().getName());
		context.getCompound().getStatements().add(accumulatorDeclaration);
		ForStatement forStatement = MscriptFactory.eINSTANCE.createForStatement();
		
		IterationVariableDeclaration iterationVariable = iterationCall.getIterationVariables().get(0);
		IterationVariableDeclaration transformedIterationVariable = MscriptFactory.eINSTANCE.createIterationVariableDeclaration();
		IValue iterationVariableValue = context.getStaticEvaluationResult().getValue(iterationVariable);
		context.getStaticEvaluationResult().setValue(transformedIterationVariable, iterationVariableValue);
		transformedIterationVariable.setName(iterationVariable.getName());
		
		context.addVariableDeclarationMapping(iterationCall.getAccumulator(), accumulatorDeclaration);
		context.addVariableDeclarationMapping(iterationVariable, transformedIterationVariable);
		
		StatusUtil.merge(status, new ExpressionTransformer(context).transform(
				iterationCall.getAccumulator().getInitializer(),
				Collections.singletonList(new ExpressionTarget(accumulatorDeclaration, 0))));

		forStatement.setIterationVariable(transformedIterationVariable);
		forStatement.setCollectionExpression(collectionExpression);

		Compound body = MscriptFactory.eINSTANCE.createCompound();
		context.enterScope();
		context.setCompound(body);
		StatusUtil.merge(status, new ExpressionTransformer(context).transform(
				iterationCall.getExpression(),
				Collections.singletonList(new ExpressionTarget(accumulatorDeclaration, 0))));
		context.leaveScope();
		forStatement.setBody(body);

		context.getCompound().getStatements().add(forStatement);
		
		if (status.getSeverity() > IStatus.WARNING) {
			return new IterationCallTransformerResult(accumulatorDeclaration, status);
		}
		
		return new IterationCallTransformerResult(accumulatorDeclaration);
	}

}
