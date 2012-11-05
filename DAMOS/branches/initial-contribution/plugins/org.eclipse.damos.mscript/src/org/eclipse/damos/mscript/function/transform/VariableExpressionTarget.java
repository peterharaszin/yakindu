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

import org.eclipse.damos.mscript.Assignment;
import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.FeatureReference;
import org.eclipse.damos.mscript.MscriptFactory;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.VariableDeclaration;
import org.eclipse.damos.mscript.interpreter.value.AnyValue;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.mscript.util.MscriptUtil;

/**
 * @author Andreas Unger
 *
 */
public class VariableExpressionTarget extends AbstractExpressionTarget {

	private final ITransformerContext context;
	private final VariableDeclaration variableDeclaration;
	private final int stepIndex;
	
	public VariableExpressionTarget(ITransformerContext context, VariableDeclaration variableDeclaration) {
		this(context, variableDeclaration, 0);
	}

	public VariableExpressionTarget(ITransformerContext context, VariableDeclaration variableDeclaration, int stepIndex) {
		this.context = context;
		this.variableDeclaration = variableDeclaration;
		this.stepIndex = stepIndex;
	}
	
	public void assignExpression(Expression expression) {
		Assignment assignment = MscriptFactory.eINSTANCE.createAssignment();
		assignment.setTarget(createVariableReference(getDataType()));
		assignment.setAssignedExpression(expression);
		context.getCompound().getStatements().add(assignment);
	}

	public FeatureReference createVariableReference(Type targetDataType) {
		FeatureReference variableReference = MscriptUtil.createVariableReference(context.getFunctionInfo(), variableDeclaration, stepIndex, false);
		context.getFunctionInfo().setValue(variableReference, new AnyValue(context.getStaticEvaluationResult().getComputationContext(), getDataType()));
		return variableReference;
	}
	
	public VariableExpressionTarget toVariableExpressionTarget(Type targetDataType) {
		return this;
	}
	
	private Type getDataType() {
		IValue value = context.getFunctionInfo().getValue(variableDeclaration);
		return value.getDataType();
	}

}
