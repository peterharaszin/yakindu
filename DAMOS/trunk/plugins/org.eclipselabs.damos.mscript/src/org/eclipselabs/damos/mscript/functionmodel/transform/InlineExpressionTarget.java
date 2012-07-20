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
import java.util.List;

import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.LocalVariableDeclaration;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.StringType;
import org.eclipselabs.damos.mscript.VariableReference;
import org.eclipselabs.damos.mscript.interpreter.value.AnyValue;
import org.eclipselabs.damos.mscript.util.MscriptUtil;

/**
 * @author Andreas Unger
 *
 */
public class InlineExpressionTarget implements IExpressionTarget {

	private final ITransformerContext context;
	
	private Expression assignedExpression;
	private DataType targetDataType;
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

	public VariableReference createVariableReference(DataType targetDataType) {
		if (variableDeclaration == null) {
			variableDeclaration = MscriptFactory.eINSTANCE.createLocalVariableDeclaration();
			variableDeclaration.setName(MscriptUtil.findAvailableLocalVariableName(context.getCompound(), getVariableName(targetDataType)));
			context.getStaticEvaluationResult().setValue(variableDeclaration, new AnyValue(context.getStaticEvaluationResult().getComputationContext(), targetDataType));
			context.getCompound().getStatements().add(variableDeclaration);
			this.targetDataType = targetDataType;
		}
		return createVariableReference();
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
	private VariableReference createVariableReference() {
		if (variableDeclaration == null || targetDataType == null) {
			throw new IllegalStateException();
		}
		VariableReference variableReference = MscriptUtil.createVariableReference(context.getStaticEvaluationResult(), variableDeclaration, 0, false);
		context.getStaticEvaluationResult().setValue(variableReference, new AnyValue(context.getStaticEvaluationResult().getComputationContext(), targetDataType));
		return variableReference;
	}
	
	protected String getVariableName(DataType dataType) {
		if (dataType instanceof ArrayType) {
			switch (((ArrayType) dataType).getDimensionality()) {
			case 1:
				return "vector";
			case 2:
				return "matrix";
			default:
				return "array";
			}
		}
		if (dataType instanceof RealType) {
			return "realval";
		}
		if (dataType instanceof IntegerType) {
			return "intval";
		}
		if (dataType instanceof StringType) {
			return "string";
		}
		return "temp";
	}

	public List<IExpressionTarget> asList() {
		return Collections.<IExpressionTarget>singletonList(this);
	}

}
