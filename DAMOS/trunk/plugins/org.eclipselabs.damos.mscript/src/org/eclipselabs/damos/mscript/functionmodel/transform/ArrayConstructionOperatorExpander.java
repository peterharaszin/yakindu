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
import java.util.List;

import org.eclipselabs.damos.mscript.ArrayConstructionOperator;
import org.eclipselabs.damos.mscript.ArrayElementAccess;
import org.eclipselabs.damos.mscript.ArraySubscript;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.Assignment;
import org.eclipselabs.damos.mscript.CompoundStatement;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.IntegerLiteral;
import org.eclipselabs.damos.mscript.LocalVariableDeclaration;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.VariableReference;
import org.eclipselabs.damos.mscript.interpreter.IComputationContext;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationResult;
import org.eclipselabs.damos.mscript.interpreter.value.AnyValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.Values;
import org.eclipselabs.damos.mscript.util.MscriptUtil;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class ArrayConstructionOperatorExpander implements IExpressionTransformStrategy {

	private final static int[] EMPTY_INT_ARRAY = new int[0];
	
	public boolean canHandle(ITransformerContext context, Expression expression) {
		return expression instanceof ArrayConstructionOperator;
	}
	
	public void transform(ITransformerContext context, Expression expression,
			List<? extends IExpressionTarget> targets, IExpressionTransformer transformer) {
		ArrayConstructionOperator arrayExpression = (ArrayConstructionOperator) expression;
		IValue expressionValue = context.getStaticEvaluationResult().getValue(arrayExpression);
		ArrayType arrayType = (ArrayType) expressionValue.getDataType();

		List<Integer> indices = new ArrayList<Integer>();
		transformArrayExpression(context, transformer, arrayExpression, arrayType, targets, indices);
	}
	
	private void transformArrayExpression(ITransformerContext context, IExpressionTransformer transformer, ArrayConstructionOperator arrayExpression, ArrayType arrayType, List<? extends IExpressionTarget> targets, List<Integer> indices) {
		IStaticEvaluationResult staticEvaluationResult = context.getStaticEvaluationResult();
		IComputationContext computationContext = staticEvaluationResult.getComputationContext();

		int index = 0;
		for (Expression elementExpression : arrayExpression.getExpressions()) {
			List<Integer> currentIndices = new ArrayList<Integer>(indices);
			currentIndices.add(index);
			if (elementExpression instanceof ArrayConstructionOperator) {
				transformArrayExpression(context, transformer, (ArrayConstructionOperator) elementExpression, arrayType, targets, currentIndices);
			} else if (currentIndices.size() == arrayType.getDimensionality()) {
				VariableReference variableReference = targets.get(0).createVariableReference(arrayType);
				
				ArrayElementAccess arrayElementAccess = MscriptFactory.eINSTANCE.createArrayElementAccess();
				arrayElementAccess.setArray(variableReference);
				staticEvaluationResult.setValue(arrayElementAccess, new AnyValue(computationContext, arrayType.getElementType()));
	
				for (Integer i : currentIndices) {
					arrayElementAccess.getSubscripts().add(createArraySubscript(context, i));
				}
				
				Assignment assignment = MscriptFactory.eINSTANCE.createAssignment();
				assignment.setTarget(arrayElementAccess);
				
				InlineExpressionTarget elementExpressionTarget = new InlineExpressionTarget(context);
				transformer.transform(elementExpression, elementExpressionTarget.asList());
				assignment.setAssignedExpression(elementExpressionTarget.getAssignedExpression());
				
				context.getCompound().getStatements().add(assignment);
			} else {
				LocalVariableDeclaration elementVariableDeclaration = null;
				IValue elementValue = null;
				
				Type elementExpressionType = staticEvaluationResult.getValue(elementExpression).getDataType();
				
				int[] rightIndices = EMPTY_INT_ARRAY;
				int[] rightSizes = EMPTY_INT_ARRAY;

				if (elementExpressionType instanceof ArrayType) {
					ArrayType elementExpressionArrayType = (ArrayType) elementExpressionType;

					rightIndices = new int[elementExpressionArrayType.getDimensionality()];
					rightSizes = new int[rightIndices.length];
					for (int i = 0; i < rightSizes.length; ++i) {
						rightSizes[i] = TypeUtil.getArrayDimensionSize(elementExpressionArrayType.getDimensions().get(i));
					}

					elementVariableDeclaration = MscriptFactory.eINSTANCE.createLocalVariableDeclaration();
					elementVariableDeclaration.setName(MscriptUtil.findAvailableLocalVariableName(context.getCompound(), getVariableName(elementExpressionArrayType)));
					context.getCompound().getStatements().add(elementVariableDeclaration);
					
					CompoundStatement compoundStatement = MscriptFactory.eINSTANCE.createCompoundStatement();
					context.getCompound().getStatements().add(compoundStatement);

					context.enterScope();
					context.setCompound(compoundStatement);
	
					elementValue = staticEvaluationResult.getValue(elementExpression);
					staticEvaluationResult.setValue(elementVariableDeclaration, elementValue);
					
					VariableExpressionTarget elementExpressionTarget = new VariableExpressionTarget(context, elementVariableDeclaration);
					transformer.transform(elementExpression, elementExpressionTarget.asList());
					
					context.leaveScope();
				}
				do {
					Assignment assignment = MscriptFactory.eINSTANCE.createAssignment();
					VariableReference variableReference = targets.get(0).createVariableReference(arrayType);
					
					ArrayElementAccess arrayElementAccess = MscriptFactory.eINSTANCE.createArrayElementAccess();
					arrayElementAccess.setArray(variableReference);
					staticEvaluationResult.setValue(arrayElementAccess, new AnyValue(computationContext, arrayType.getElementType()));
	
					for (Integer i : currentIndices) {
						arrayElementAccess.getSubscripts().add(createArraySubscript(context, i));
					}
					for (int i = 0; i < rightIndices.length; ++i) {
						arrayElementAccess.getSubscripts().add(createArraySubscript(context, rightIndices[i]));
					}
					
					assignment.setTarget(arrayElementAccess);

					if (elementExpressionType instanceof ArrayType) {
						ArrayType elementExpressionArrayType = (ArrayType) elementExpressionType;

						VariableReference elementVariableReference = MscriptUtil.createVariableReference(staticEvaluationResult, elementVariableDeclaration, 0, false);
						staticEvaluationResult.setValue(elementVariableReference, new AnyValue(computationContext, elementExpressionArrayType.getElementType()));

						ArrayElementAccess rightArrayElementAccess = MscriptFactory.eINSTANCE.createArrayElementAccess();
						rightArrayElementAccess.setArray(elementVariableReference);
						staticEvaluationResult.setValue(rightArrayElementAccess, new AnyValue(computationContext, elementExpressionArrayType.getElementType()));
						for (int i = 0; i < rightIndices.length; ++i) {
							rightArrayElementAccess.getSubscripts().add(createArraySubscript(context, rightIndices[i]));
						}
						assignment.setAssignedExpression(rightArrayElementAccess);
					} else {
						InlineExpressionTarget elementExpressionTarget = new InlineExpressionTarget(context);
						transformer.transform(elementExpression, elementExpressionTarget.asList());
						assignment.setAssignedExpression(elementExpressionTarget.getAssignedExpression());
					}
					
					context.getCompound().getStatements().add(assignment);
				} while (nextIndices(rightIndices, rightSizes));
			}
			++index;
		}
	}

	private ArraySubscript createArraySubscript(ITransformerContext context, int index) {
		ArraySubscript subscript = MscriptFactory.eINSTANCE.createArraySubscript();
		IntegerLiteral integerLiteral = MscriptFactory.eINSTANCE.createIntegerLiteral();
		integerLiteral.setUnit(TypeUtil.createUnit());
		integerLiteral.setValue(index);
		subscript.setExpression(integerLiteral);
		context.getStaticEvaluationResult().setValue(integerLiteral, Values.valueOf(context.getStaticEvaluationResult().getComputationContext(), TypeUtil.createIntegerType(), index));
		return subscript;
	}
	
	private boolean nextIndices(int[] indices, int[] sizes) {
		for (int i = indices.length - 1; i >= 0; --i) {
			if (++indices[i] < sizes[i]) {
				return true;
			}
			indices[i] = 0;
		}
		return false;
	}
	
	private String getVariableName(ArrayType arrayType) {
		switch (arrayType.getDimensionality()) {
		case 1:
			return "vector";
		case 2:
			return "matrix";
		default:
			return "array";
		}
	}

}
