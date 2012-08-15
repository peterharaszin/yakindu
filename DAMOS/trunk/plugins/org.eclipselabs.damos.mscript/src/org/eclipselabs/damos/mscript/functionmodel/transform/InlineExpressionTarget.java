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

import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.FeatureReference;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.LocalVariableDeclaration;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.StringType;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.interpreter.value.AnyValue;
import org.eclipselabs.damos.mscript.util.MscriptUtil;

/**
 * @author Andreas Unger
 *
 */
public class InlineExpressionTarget extends AbstractExpressionTarget {

	private final ITransformerContext context;
	
	private Expression assignedExpression;
	private Type targetDataType;
	private LocalVariableDeclaration variableDeclaration;
	
	/**
	 * 
	 */
	public InlineExpressionTarget(ITransformerContext context) {
		this.context = context;
	}
	
	public void assignExpression(Expression expression) {
		assignedExpression = expression;
	}

	public FeatureReference createVariableReference(Type targetDataType) {
		if (variableDeclaration == null) {
			variableDeclaration = MscriptFactory.eINSTANCE.createLocalVariableDeclaration();
			variableDeclaration.setName(MscriptUtil.findAvailableLocalVariableName(context.getCompound(), getVariableName(targetDataType)));
			context.getStaticEvaluationResult().setValue(variableDeclaration, new AnyValue(context.getStaticEvaluationResult().getComputationContext(), targetDataType));
			context.getCompound().getStatements().add(variableDeclaration);
			this.targetDataType = targetDataType;
		}
		return createVariableReference();
	}
	
	public VariableExpressionTarget toVariableExpressionTarget(Type targetDataType) {
		assignedExpression = createVariableReference(targetDataType);
		return new VariableExpressionTarget(context, variableDeclaration);
	}
	
	public Expression getAssignedExpression() {
		if (variableDeclaration != null) {
			return createVariableReference();
		}
		return assignedExpression;
	}

	/**
	 * @return
	 */
	private FeatureReference createVariableReference() {
		if (variableDeclaration == null || targetDataType == null) {
			throw new IllegalStateException();
		}
		FeatureReference variableReference = MscriptUtil.createVariableReference(context.getStaticEvaluationResult(), variableDeclaration, 0, false);
		context.getStaticEvaluationResult().setValue(variableReference, new AnyValue(context.getStaticEvaluationResult().getComputationContext(), targetDataType));
		return variableReference;
	}
	
	protected String getVariableName(Type type) {
		if (type instanceof ArrayType) {
			switch (((ArrayType) type).getDimensionality()) {
			case 1:
				return "vector";
			case 2:
				return "matrix";
			default:
				return "array";
			}
		}
		if (type instanceof RealType) {
			return "realval";
		}
		if (type instanceof IntegerType) {
			return "intval";
		}
		if (type instanceof StringType) {
			return "string";
		}
		return "temp";
	}

}
