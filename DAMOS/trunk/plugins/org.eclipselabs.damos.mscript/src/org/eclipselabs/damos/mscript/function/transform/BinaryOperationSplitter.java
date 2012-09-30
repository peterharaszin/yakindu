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

package org.eclipselabs.damos.mscript.function.transform;

import java.util.List;

import org.eclipselabs.damos.mscript.Assignment;
import org.eclipselabs.damos.mscript.BinaryExpression;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.FeatureReference;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class BinaryOperationSplitter implements IExpressionTransformStrategy {

	private final ExpressionTransformHelper helper = new ExpressionTransformHelper();

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
				Type leftDataType = getDataType(context, leftOperand);
				Type rightDataType = getDataType(context, rightOperand);
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

		IValue binaryExpressionValue = context.getFunctionInfo().getValue(binaryExpression);

		FeatureReference leftVariableReference = helper.transformToVariableReference(context, leftOperand, "left", transformer);
		FeatureReference rightVariableReference = helper.transformToVariableReference(context, rightOperand, "right", transformer);
		
		BinaryExpression transformedBinaryExpression = (BinaryExpression) MscriptFactory.eINSTANCE.create(binaryExpression.eClass());
		transformedBinaryExpression.setLeftOperand(leftVariableReference);
		transformedBinaryExpression.setRightOperand(rightVariableReference);
		transformedBinaryExpression.setOperator(binaryExpression.getOperator());
		context.getFunctionInfo().setValue(transformedBinaryExpression, binaryExpressionValue);

		Assignment assignment = MscriptFactory.eINSTANCE.createAssignment();
		assignment.setTarget(targets.get(0).createVariableReference(binaryExpressionValue.getDataType()));
		assignment.setAssignedExpression(transformedBinaryExpression);
		
		context.getCompound().getStatements().add(assignment);
	}
	
	private Type getDataType(ITransformerContext context, Expression expression) {
		return context.getFunctionInfo().getValue(expression).getDataType();
	}

}
