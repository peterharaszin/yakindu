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

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.mscript.Assignment;
import org.eclipselabs.damos.mscript.BinaryExpression;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.LocalVariableDeclaration;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.VariableReference;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.util.MscriptUtil;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class ComplexOperationSplitter implements IExpressionTransformStrategy {

	public boolean canHandle(ITransformerContext context, Expression expression) {
		if (expression instanceof BinaryExpression) {
			BinaryExpression binaryExpression = (BinaryExpression) expression;
			switch (binaryExpression.getOperator()) {
			case ADD:
			case SUBTRACT:
			case MULTIPLY:
			case DIVIDE:
			case MODULO:
			case ELEMENT_WISE_ADD:
			case ELEMENT_WISE_SUBTRACT:
			case ELEMENT_WISE_MULTIPLY:
			case ELEMENT_WISE_DIVIDE:
			case ELEMENT_WISE_MODULO:
			case EQUAL_TO:
			case NOT_EQUAL_TO:
				Expression leftOperand = binaryExpression.getLeftOperand();
				Expression rightOperand = binaryExpression.getRightOperand();
				DataType leftDataType = getDataType(context, leftOperand);
				DataType rightDataType = getDataType(context, rightOperand);
				return TypeUtil.isNumericArray(leftDataType) || TypeUtil.isNumericArray(rightDataType);
			default:
				break;
			}
		}
		return false;
	}
	
	public void transform(ITransformerContext context, Expression expression, List<? extends IExpressionTarget> targets, IExpressionTransformer transformer) {
		BinaryExpression binaryExpression = (BinaryExpression) expression;
		Expression leftOperand = binaryExpression.getLeftOperand();
		Expression rightOperand = binaryExpression.getRightOperand();

		IValue binaryExpressionValue = context.getStaticEvaluationResult().getValue(binaryExpression);

		VariableReference leftVariableReference;
		VariableReference rightVariableReference;
		
		if (leftOperand instanceof VariableReference) {
			leftVariableReference = EcoreUtil.copy((VariableReference) leftOperand);
			context.getStaticEvaluationResult().setValue(leftVariableReference, context.getStaticEvaluationResult().getValue(leftOperand));
		} else {
			leftVariableReference = createVariableReference(context, leftOperand, "left", transformer);
		}

		if (rightOperand instanceof VariableReference) {
			rightVariableReference = EcoreUtil.copy((VariableReference) rightOperand);
			context.getStaticEvaluationResult().setValue(rightVariableReference, context.getStaticEvaluationResult().getValue(rightOperand));
		} else {
			rightVariableReference = createVariableReference(context, rightOperand, "right", transformer);
		}
		
		BinaryExpression transformedBinaryExpression = (BinaryExpression) MscriptFactory.eINSTANCE.create(binaryExpression.eClass());
		transformedBinaryExpression.setLeftOperand(leftVariableReference);
		transformedBinaryExpression.setRightOperand(rightVariableReference);
		transformedBinaryExpression.setOperator(binaryExpression.getOperator());
		context.getStaticEvaluationResult().setValue(transformedBinaryExpression, binaryExpressionValue);

		Assignment assignment = MscriptFactory.eINSTANCE.createAssignment();
		assignment.setTarget(targets.get(0).createVariableReference(binaryExpressionValue.getDataType()));
		assignment.setAssignedExpression(transformedBinaryExpression);
		
		context.getCompound().getStatements().add(assignment);
	}
	
	private VariableReference createVariableReference(ITransformerContext context, Expression operand, String name, IExpressionTransformer transformer) {
		IValue operandValue = context.getStaticEvaluationResult().getValue(operand);

		LocalVariableDeclaration variableDeclaration = MscriptFactory.eINSTANCE.createLocalVariableDeclaration();
		variableDeclaration.setName(MscriptUtil.findAvailableLocalVariableName(context.getCompound(), name));
		context.getStaticEvaluationResult().setValue(variableDeclaration, operandValue);
		context.getCompound().getStatements().add(variableDeclaration);
		
		VariableExpressionTarget target = new VariableExpressionTarget(context, variableDeclaration);
		transformer.transform(operand, target.asList());
		
		return target.createVariableReference(operandValue.getDataType());
	}

	private DataType getDataType(ITransformerContext context, Expression expression) {
		return context.getStaticEvaluationResult().getValue(expression).getDataType();
	}

}
