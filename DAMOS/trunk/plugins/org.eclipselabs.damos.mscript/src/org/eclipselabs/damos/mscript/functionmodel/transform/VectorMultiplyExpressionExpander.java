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

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.mscript.AdditiveExpression;
import org.eclipselabs.damos.mscript.ArrayElementAccess;
import org.eclipselabs.damos.mscript.ArraySubscript;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.Compound;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.IntegerLiteral;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.LocalVariableDeclaration;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.MultiplicativeExpression;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.ParenthesizedExpression;
import org.eclipselabs.damos.mscript.RealLiteral;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.VariableReference;
import org.eclipselabs.damos.mscript.interpreter.ComputationContext;
import org.eclipselabs.damos.mscript.interpreter.value.AnyValue;
import org.eclipselabs.damos.mscript.interpreter.value.IArrayValue;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.util.MscriptUtil;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class VectorMultiplyExpressionExpander implements IExpressionTransformStrategy {

	public boolean canHandle(ITransformerContext context, Expression expression) {
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

	public void transform(ITransformerContext context, Expression expression, List<? extends IExpressionTarget> targets, IExpressionTransformer transformer) {
		Expression leftOperand = ((MultiplicativeExpression) expression).getLeftOperand();
		Expression rightOperand = ((MultiplicativeExpression) expression).getRightOperand();

		ParenthesizedExpression parenthesizedExpression = MscriptFactory.eINSTANCE.createParenthesizedExpression();

		ArrayType leftArrayType = (ArrayType) getDataType(context, leftOperand);
		ArrayType rightArrayType = (ArrayType) getDataType(context, rightOperand);
		
		Type resultDataType = leftArrayType.getElementType().evaluate(OperatorKind.MULTIPLY, rightArrayType.getElementType());
		
		VariableReference leftVariableReference;
		VariableReference rightVariableReference;
		
		if (leftOperand instanceof VariableReference) {
			leftVariableReference = (VariableReference) leftOperand;
		} else {
			leftVariableReference = createVariableReference(context, leftOperand, "left", transformer);
		}

		if (rightOperand instanceof VariableReference) {
			rightVariableReference = (VariableReference) rightOperand;
		} else {
			rightVariableReference = createVariableReference(context, rightOperand, "right", transformer);
		}

		Expression rootExpression = null;
		for (int i = 0; i < TypeUtil.getArraySize(leftArrayType); ++i) {
			MultiplicativeExpression multiplicativeExpression = MscriptFactory.eINSTANCE.createMultiplicativeExpression();
			setDataType(context, multiplicativeExpression, EcoreUtil.copy(resultDataType));
			
			Expression leftMultiplicationOperand = createArrayElementAccess(context, leftVariableReference, leftArrayType, i);
			Expression rightMultiplicationOperand = createArrayElementAccess(context, rightVariableReference, rightArrayType, i);

			multiplicativeExpression.setOperator(OperatorKind.MULTIPLY);
			multiplicativeExpression.setLeftOperand(leftMultiplicationOperand);
			multiplicativeExpression.setRightOperand(rightMultiplicationOperand);
			
			if (rootExpression == null) {
				rootExpression = multiplicativeExpression;
			} else {
				AdditiveExpression additiveExpression = MscriptFactory.eINSTANCE.createAdditiveExpression();
				additiveExpression.setLeftOperand(rootExpression);
				additiveExpression.setRightOperand(multiplicativeExpression);
				setDataType(context, additiveExpression, EcoreUtil.copy(resultDataType));
				rootExpression = additiveExpression;
			}
		}
		
		parenthesizedExpression.getExpressions().add(rootExpression);

		setDataType(context, rootExpression, EcoreUtil.copy(resultDataType));
		setDataType(context, parenthesizedExpression, EcoreUtil.copy(resultDataType));
		
		targets.get(0).assignExpression(parenthesizedExpression);
	}

	/**
	 * @param operand
	 * @param arrayType
	 * @param index
	 * @return
	 */
	private Expression createArrayElementAccess(ITransformerContext context, VariableReference operand, ArrayType arrayType, int index) {
		IValue value = context.getStaticEvaluationResult().getValue(operand);
		if (value instanceof IArrayValue) {
			IValue elementValue = ((IArrayValue) value).get(index);
			if (elementValue instanceof ISimpleNumericValue) {
				ISimpleNumericValue numericValue = (ISimpleNumericValue) elementValue;
				Type elementType = arrayType.getElementType();
				if (elementType instanceof RealType) {
					RealLiteral realLiteral = MscriptFactory.eINSTANCE.createRealLiteral();
					realLiteral.setUnit(EcoreUtil.copy(((RealType) elementType).getUnit()));
					realLiteral.setValue(numericValue.doubleValue());
					context.getStaticEvaluationResult().setValue(realLiteral, numericValue);
					return realLiteral;
				} else if (elementType instanceof IntegerType) {
					IntegerLiteral integerLiteral = MscriptFactory.eINSTANCE.createIntegerLiteral();
					integerLiteral.setUnit(EcoreUtil.copy(((IntegerType) elementType).getUnit()));
					integerLiteral.setValue(numericValue.longValue());
					context.getStaticEvaluationResult().setValue(integerLiteral, numericValue);
					return integerLiteral;
				}
			}
		}
		
		VariableReference variableReference = EcoreUtil.copy(operand);
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
	
	private VariableReference createVariableReference(ITransformerContext context, Expression operand, String name, IExpressionTransformer transformer) {
		LocalVariableDeclaration variableDeclaration = MscriptFactory.eINSTANCE.createLocalVariableDeclaration();
		variableDeclaration.setName(MscriptUtil.findAvailableLocalVariableName(context.getCompound(), name));
		context.getCompound().getStatements().add(variableDeclaration);
		
		Compound compoundStatement = MscriptFactory.eINSTANCE.createCompound();
		context.getCompound().getStatements().add(compoundStatement);

		context.enterScope();
		context.setCompound(compoundStatement);

		IValue value = context.getStaticEvaluationResult().getValue(operand);
		context.getStaticEvaluationResult().setValue(variableDeclaration, value);
		transformer.transform(
				operand,
				Collections.singletonList(new VariableExpressionTarget(context, variableDeclaration, 0)));
		
		context.leaveScope();

		VariableReference variableReference = MscriptUtil.createVariableReference(context.getStaticEvaluationResult(), variableDeclaration, 0, false);
		context.getStaticEvaluationResult().setValue(variableReference, value);
		return variableReference;
	}

	private Type getDataType(ITransformerContext context, Expression expression) {
		return context.getStaticEvaluationResult().getValue(expression).getDataType();
	}
	
	private void setDataType(ITransformerContext context, Expression expression, Type type) {
		context.getStaticEvaluationResult().setValue(expression, new AnyValue(new ComputationContext(), type));
	}

}
