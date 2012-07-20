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

import java.util.List;

import org.eclipse.core.runtime.MultiStatus;
import org.eclipselabs.damos.mscript.Compound;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.ForStatement;
import org.eclipselabs.damos.mscript.IterationCall;
import org.eclipselabs.damos.mscript.IterationVariableDeclaration;
import org.eclipselabs.damos.mscript.LocalVariableDeclaration;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.VariableReference;
import org.eclipselabs.damos.mscript.internal.MscriptPlugin;
import org.eclipselabs.damos.mscript.internal.util.StatusUtil;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class IterateTransformer implements IIterationCallTransformer {

	public IIterationCallTransformerResult transform(ITransformerContext context, IterationCall iterationCall, Expression collectionExpression, List<? extends IExpressionTarget> targets) {
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
		
		VariableExpressionTarget target = new VariableExpressionTarget(context, accumulatorDeclaration);
		
		StatusUtil.merge(status, new ExpressionTransformer(context).transform(
				iterationCall.getAccumulator().getInitializer(),
				target.asList()));

		forStatement.setIterationVariable(transformedIterationVariable);
		forStatement.setCollectionExpression(collectionExpression);

		Compound body = MscriptFactory.eINSTANCE.createCompound();
		context.enterScope();
		context.setCompound(body);
		StatusUtil.merge(status, new ExpressionTransformer(context).transform(
				iterationCall.getExpression(),
				target.asList()));
		context.leaveScope();
		forStatement.setBody(body);

		context.getCompound().getStatements().add(forStatement);
		
		VariableReference variableReference = MscriptFactory.eINSTANCE.createVariableReference();
		variableReference.setFeature(accumulatorDeclaration);
		context.getStaticEvaluationResult().setValue(variableReference, accumulatorValue);
		targets.get(0).assignExpression(variableReference);
		
		return null;
	}

}
