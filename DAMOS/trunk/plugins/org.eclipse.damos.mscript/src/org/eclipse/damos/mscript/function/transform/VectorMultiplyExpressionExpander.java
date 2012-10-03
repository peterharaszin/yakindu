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

import java.util.Collections;

import org.eclipse.damos.mscript.AdditiveExpression;
import org.eclipse.damos.mscript.ArrayElementAccess;
import org.eclipse.damos.mscript.ArraySubscript;
import org.eclipse.damos.mscript.ArrayType;
import org.eclipse.damos.mscript.CompoundStatement;
import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.FeatureReference;
import org.eclipse.damos.mscript.IntegerLiteral;
import org.eclipse.damos.mscript.IntegerType;
import org.eclipse.damos.mscript.LocalVariableDeclaration;
import org.eclipse.damos.mscript.MscriptFactory;
import org.eclipse.damos.mscript.MultiplicativeExpression;
import org.eclipse.damos.mscript.OperatorKind;
import org.eclipse.damos.mscript.ParenthesizedExpression;
import org.eclipse.damos.mscript.RealLiteral;
import org.eclipse.damos.mscript.RealType;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.interpreter.ComputationContext;
import org.eclipse.damos.mscript.interpreter.value.AnyValue;
import org.eclipse.damos.mscript.interpreter.value.IArrayValue;
import org.eclipse.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.mscript.util.MscriptUtil;
import org.eclipse.damos.mscript.util.TypeUtil;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Andreas Unger
 *
 */
public class VectorMultiplyExpressionExpander extends AbstractExpressionTransformStrategy {

	public boolean canTransform(ITransformerContext context, Expression expression) {
		if (expression instanceof MultiplicativeExpression) {
			MultiplicativeExpression multiplicativeExpression = (MultiplicativeExpression) expression;
			if (multiplicativeExpression.getOperator() == OperatorKind.MULTIPLY) {
				Expression leftOperand = multiplicativeExpression.getLeftOperand();
				Expression rightOperand = multiplicativeExpression.getRightOperand();
				Type leftDataType = getDataType(context, leftOperand);
				Type rightDataType = getDataType(context, rightOperand);
				return TypeUtil.isNumericVector(leftDataType) && TypeUtil.isNumericVector(rightDataType);
			}
		}
		return false;
	}

	public void transform(ExpressionTransformResult result, Expression expression) {
		Expression leftOperand = ((MultiplicativeExpression) expression).getLeftOperand();
		Expression rightOperand = ((MultiplicativeExpression) expression).getRightOperand();

		ParenthesizedExpression parenthesizedExpression = MscriptFactory.eINSTANCE.createParenthesizedExpression();

		ArrayType leftArrayType = (ArrayType) getDataType(result.getContext(), leftOperand);
		ArrayType rightArrayType = (ArrayType) getDataType(result.getContext(), rightOperand);
		
		Type resultDataType = leftArrayType.getElementType().evaluate(OperatorKind.MULTIPLY, rightArrayType.getElementType());
		
		FeatureReference leftVariableReference;
		FeatureReference rightVariableReference;
		
		if (leftOperand instanceof FeatureReference) {
			leftVariableReference = (FeatureReference) leftOperand;
		} else {
			leftVariableReference = createVariableReference(result.getContext(), leftOperand, "left", result.getTransformer());
		}

		if (rightOperand instanceof FeatureReference) {
			rightVariableReference = (FeatureReference) rightOperand;
		} else {
			rightVariableReference = createVariableReference(result.getContext(), rightOperand, "right", result.getTransformer());
		}

		Expression rootExpression = null;
		for (int i = 0; i < TypeUtil.getArraySize(leftArrayType); ++i) {
			MultiplicativeExpression multiplicativeExpression = MscriptFactory.eINSTANCE.createMultiplicativeExpression();
			setDataType(result.getContext(), multiplicativeExpression, EcoreUtil.copy(resultDataType));
			
			Expression leftMultiplicationOperand = createArrayElementAccess(result.getContext(), leftVariableReference, leftArrayType, i);
			Expression rightMultiplicationOperand = createArrayElementAccess(result.getContext(), rightVariableReference, rightArrayType, i);

			multiplicativeExpression.setOperator(OperatorKind.MULTIPLY);
			multiplicativeExpression.setLeftOperand(leftMultiplicationOperand);
			multiplicativeExpression.setRightOperand(rightMultiplicationOperand);
			
			if (rootExpression == null) {
				rootExpression = multiplicativeExpression;
			} else {
				AdditiveExpression additiveExpression = MscriptFactory.eINSTANCE.createAdditiveExpression();
				additiveExpression.setLeftOperand(rootExpression);
				additiveExpression.setRightOperand(multiplicativeExpression);
				setDataType(result.getContext(), additiveExpression, EcoreUtil.copy(resultDataType));
				rootExpression = additiveExpression;
			}
		}
		
		parenthesizedExpression.getExpressions().add(rootExpression);

		setDataType(result.getContext(), rootExpression, EcoreUtil.copy(resultDataType));
		setDataType(result.getContext(), parenthesizedExpression, EcoreUtil.copy(resultDataType));
		
		result.getTargets().get(0).assignExpression(parenthesizedExpression);
	}

	/**
	 * @param operand
	 * @param arrayType
	 * @param index
	 * @return
	 */
	private Expression createArrayElementAccess(ITransformerContext context, FeatureReference operand, ArrayType arrayType, int index) {
		IValue value = context.getFunctionInfo().getValue(operand);
		if (value instanceof IArrayValue) {
			IValue elementValue = ((IArrayValue) value).get(index);
			if (elementValue instanceof ISimpleNumericValue) {
				ISimpleNumericValue numericValue = (ISimpleNumericValue) elementValue;
				Type elementType = arrayType.getElementType();
				if (elementType instanceof RealType) {
					RealLiteral realLiteral = MscriptFactory.eINSTANCE.createRealLiteral();
					realLiteral.setUnit(EcoreUtil.copy(((RealType) elementType).getUnit()));
					realLiteral.setValue(numericValue.doubleValue());
					context.getFunctionInfo().setValue(realLiteral, numericValue);
					return realLiteral;
				} else if (elementType instanceof IntegerType) {
					IntegerLiteral integerLiteral = MscriptFactory.eINSTANCE.createIntegerLiteral();
					integerLiteral.setUnit(EcoreUtil.copy(((IntegerType) elementType).getUnit()));
					integerLiteral.setValue(numericValue.longValue());
					context.getFunctionInfo().setValue(integerLiteral, numericValue);
					return integerLiteral;
				}
			}
		}
		
		FeatureReference variableReference = EcoreUtil.copy(operand);
		setDataType(context, variableReference, EcoreUtil.copy(arrayType));
		IntegerLiteral integerLiteral = MscriptFactory.eINSTANCE.createIntegerLiteral();
		integerLiteral.setUnit(TypeUtil.createUnit());
		integerLiteral.setValue(index);
		IntegerType integerType = MscriptFactory.eINSTANCE.createIntegerType();
		integerType.setUnit(TypeUtil.createUnit());
		setDataType(context, integerLiteral, integerType);
		ArrayElementAccess arrayElementAccess = MscriptFactory.eINSTANCE.createArrayElementAccess();
		arrayElementAccess.setArray(variableReference);
		ArraySubscript subscript = MscriptFactory.eINSTANCE.createArraySubscript();
		subscript.setExpression(integerLiteral);
		arrayElementAccess.getSubscripts().add(subscript);
		setDataType(context, arrayElementAccess, EcoreUtil.copy(arrayType.getElementType()));
		return arrayElementAccess;
	}
	
	private FeatureReference createVariableReference(ITransformerContext context, Expression operand, String name, IExpressionTransformer transformer) {
		LocalVariableDeclaration variableDeclaration = MscriptFactory.eINSTANCE.createLocalVariableDeclaration();
		variableDeclaration.setName(MscriptUtil.findAvailableLocalVariableName(context.getCompound(), name));
		context.getCompound().getStatements().add(variableDeclaration);
		
		CompoundStatement compoundStatement = MscriptFactory.eINSTANCE.createCompoundStatement();
		context.getCompound().getStatements().add(compoundStatement);

		context.enterScope();
		context.setCompound(compoundStatement);

		IValue value = context.getFunctionInfo().getValue(operand);
		context.getFunctionInfo().setValue(variableDeclaration, value);
		transformer.transform(context, operand,
				Collections.singletonList(new VariableExpressionTarget(context, variableDeclaration, 0)));
		
		context.leaveScope();

		FeatureReference variableReference = MscriptUtil.createVariableReference(context.getFunctionInfo(), variableDeclaration, 0, false);
		context.getFunctionInfo().setValue(variableReference, value);
		return variableReference;
	}

	private Type getDataType(ITransformerContext context, Expression expression) {
		return context.getFunctionInfo().getValue(expression).getDataType();
	}
	
	private void setDataType(ITransformerContext context, Expression expression, Type type) {
		context.getFunctionInfo().setValue(expression, new AnyValue(new ComputationContext(), type));
	}

}
