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


/**
 * @author Andreas Unger
 *
 */
public class ComplexOperationSplitter {

//	private static final List<String> FIRST_INDEX_VARIABLE_NAMES = new ArrayList<String>();
//	
//	static {
//		FIRST_INDEX_VARIABLE_NAMES.add("i");
//		FIRST_INDEX_VARIABLE_NAMES.add("j");
//		FIRST_INDEX_VARIABLE_NAMES.add("k");
//		FIRST_INDEX_VARIABLE_NAMES.add("l");
//	}
//	
//	public boolean canHandle(ITransformerContext context, Expression expression) {
//		if (expression instanceof BinaryExpression) {
//			BinaryExpression binaryExpression = (BinaryExpression) expression;
//			switch (binaryExpression.getOperator()) {
//			case ADD:
//			case SUBTRACT:
//			case ELEMENT_WISE_ADD:
//			case ELEMENT_WISE_SUBTRACT:
//			case ELEMENT_WISE_MULTIPLY:
//			case ELEMENT_WISE_DIVIDE:
//			case ELEMENT_WISE_MODULO:
//				Expression leftOperand = binaryExpression.getLeftOperand();
//				Expression rightOperand = binaryExpression.getRightOperand();
//				DataType leftDataType = getDataType(context, leftOperand);
//				DataType rightDataType = getDataType(context, rightOperand);
//				return TypeUtil.isNumericArray(leftDataType) && TypeUtil.isNumericArray(rightDataType);
//			default:
//				break;
//			}
//		}
//		return false;
//	}
//
//	public Expression transform(ITransformerContext context, Expression expression, IExpressionTransformer transformer) {
//		Expression leftOperand = ((BinaryExpression) expression).getLeftOperand();
//		Expression rightOperand = ((BinaryExpression) expression).getRightOperand();
//
//		ArrayType rightArrayType = (ArrayType) context.getStaticEvaluationResult().getValue(rightOperand).getDataType();
//
//		LocalVariableDeclaration localVariableDeclaration = MscriptFactory.eINSTANCE.createLocalVariableDeclaration();
//		localVariableDeclaration.setName(MscriptUtil.findAvailableLocalVariableName(context.getCompound(), getVariableName(rightArrayType)));
//		IValue expressionValue = context.getStaticEvaluationResult().getValue(expression);
//		context.getStaticEvaluationResult().setValue(localVariableDeclaration, expressionValue);
//		context.getCompound().getStatements().add(localVariableDeclaration);
//		
//		splitExpression(context, localVariableDeclaration, ((BinaryExpression) expression).getOperator(), leftOperand, rightOperand, transformer);
//		
//		VariableReference variableReference = MscriptFactory.eINSTANCE.createVariableReference();
//		variableReference.setFeature(localVariableDeclaration);
//		return variableReference;
//	}
//	
//	private void splitExpression(ITransformerContext context, LocalVariableDeclaration localVariableDeclaration, OperatorKind operator, Expression leftOperand, Expression rightOperand, IExpressionTransformer transformer) {
//		VariableReference leftVariableReference;
//		VariableReference rightVariableReference;
//		
//		if (leftOperand instanceof VariableReference) {
//			leftVariableReference = EcoreUtil.copy((VariableReference) leftOperand);
//			context.getStaticEvaluationResult().setValue(leftVariableReference, context.getStaticEvaluationResult().getValue(leftOperand));
//		} else {
//			leftVariableReference = createVariableReference(context, leftOperand, "left", transformer);
//		}
//
//		if (rightOperand instanceof VariableReference) {
//			rightVariableReference = EcoreUtil.copy((VariableReference) rightOperand);
//			context.getStaticEvaluationResult().setValue(rightVariableReference, context.getStaticEvaluationResult().getValue(rightOperand));
//		} else {
//			rightVariableReference = createVariableReference(context, rightOperand, "right", transformer);
//		}
//		
//		AdditiveExpression additiveExpression = MscriptFactory.eINSTANCE.createAdditiveExpression();
//		additiveExpression.setLeftOperand(leftVariableReference);
//		additiveExpression.setRightOperand(rightVariableReference);
//		additiveExpression.setOperator(operator);
//		context.getStaticEvaluationResult().setValue(additiveExpression, context.getStaticEvaluationResult().getValue(localVariableDeclaration));
//
//		Assignment assignment = MscriptFactory.eINSTANCE.createAssignment();
//		VariableReference variableReference = MscriptUtil.createVariableReference(context.getStaticEvaluationResult(), localVariableDeclaration, 0, false);
//		context.getStaticEvaluationResult().setValue(variableReference, context.getStaticEvaluationResult().getValue(localVariableDeclaration));
//		
//		assignment.setTarget(variableReference);
//		assignment.setAssignedExpression(additiveExpression);
//		
//		context.getCompound().getStatements().add(assignment);
//	}
//
//	private VariableReference createVariableReference(ITransformerContext context, Expression operand, String name, IExpressionTransformer transformer) {
//		LocalVariableDeclaration variableDeclaration = MscriptFactory.eINSTANCE.createLocalVariableDeclaration();
//		variableDeclaration.setName(MscriptUtil.findAvailableLocalVariableName(context.getCompound(), name));
//		context.getCompound().getStatements().add(variableDeclaration);
//		
//		Compound compoundStatement = MscriptFactory.eINSTANCE.createCompound();
//		context.getCompound().getStatements().add(compoundStatement);
//
//		context.enterScope();
//		context.setCompound(compoundStatement);
//
//		IValue value = context.getStaticEvaluationResult().getValue(operand);
//		context.getStaticEvaluationResult().setValue(variableDeclaration, value);
////		transformer.transform(
////				operand,
////				Collections.singletonList(new ExpressionTarget(variableDeclaration, 0)));
//		
//		context.leaveScope();
//
//		VariableReference variableReference = MscriptUtil.createVariableReference(context.getStaticEvaluationResult(), variableDeclaration, 0, false);
//		context.getStaticEvaluationResult().setValue(variableReference, value);
//		return variableReference;
//	}
//
//	private DataType getDataType(ITransformerContext context, Expression expression) {
//		return context.getStaticEvaluationResult().getValue(expression).getDataType();
//	}
//	
//	private void generateLoop(ITransformerContext context, LocalVariableDeclaration result, Expression leftOperand, Expression rightOperand, int dimension, List<String> indexVariableNames, List<IterationVariableDeclaration> iterationVariables, IExpressionTransformer transformer) {
//		ArrayType rightArrayType = (ArrayType) context.getStaticEvaluationResult().getValue(rightOperand).getDataType();
//		
//		if (dimension < indexVariableNames.size()) {
//			IterationVariableDeclaration iterationVariable = MscriptFactory.eINSTANCE.createIterationVariableDeclaration();
//			iterationVariable.setName(indexVariableNames.get(dimension));
//			iterationVariables.add(iterationVariable);
//			context.getStaticEvaluationResult().setValue(iterationVariable, new AnyValue(context.getStaticEvaluationResult().getComputationContext(), TypeUtil.createIntegerType()));
//			
//			RangeExpression rangeExpression = MscriptFactory.eINSTANCE.createRangeExpression();
//			
//			IntegerLiteral startLiteral = MscriptFactory.eINSTANCE.createIntegerLiteral();
//			startLiteral.setValue(0);
//			startLiteral.setUnit(TypeUtil.createUnit());
//			ISimpleNumericValue startValue = Values.valueOf(context.getStaticEvaluationResult().getComputationContext(), TypeUtil.createIntegerType(), 0);
//			context.getStaticEvaluationResult().setValue(startLiteral, startValue);
//			rangeExpression.getOperands().add(startLiteral);
//			
//			IntegerLiteral endLiteral = MscriptFactory.eINSTANCE.createIntegerLiteral();
//			int arrayDimensionSize = TypeUtil.getArrayDimensionSize(rightArrayType.getDimensions().get(dimension));
//			int end = arrayDimensionSize - 1;
//			endLiteral.setValue(end);
//			endLiteral.setUnit(TypeUtil.createUnit());
//			ISimpleNumericValue endValue = Values.valueOf(context.getStaticEvaluationResult().getComputationContext(), TypeUtil.createIntegerType(), end);
//			context.getStaticEvaluationResult().setValue(endLiteral, endValue);
//
//			rangeExpression.getOperands().add(endLiteral);
//
//			context.getStaticEvaluationResult().setValue(rangeExpression, new RangeValue(context.getStaticEvaluationResult().getComputationContext(), TypeUtil.createArrayType(TypeUtil.createIntegerType(), arrayDimensionSize), startValue, endValue));
//			
//			ForStatement forStatement = MscriptFactory.eINSTANCE.createForStatement();
//			forStatement.setIterationVariable(iterationVariable);
//			forStatement.setCollectionExpression(rangeExpression);
//			
//			Compound body = MscriptFactory.eINSTANCE.createCompound();
//			forStatement.setBody(body);
//			context.getCompound().getStatements().add(forStatement);
//			
//			context.enterScope();
//			context.setCompound(body);
//			generateLoop(context, result, leftOperand, rightOperand, dimension + 1, indexVariableNames, iterationVariables, transformer);
//			context.leaveScope();
//		} else {
//			
//		}
//	}
//	
//	private List<String> getIndexVariableNames(int dimensionality) {
//		if (dimensionality <= 4) {
//			return FIRST_INDEX_VARIABLE_NAMES.subList(0, dimensionality);
//		}
//		List<String> names = new ArrayList<String>();
//		for (int i = 0; i < dimensionality; ++i) {
//			names.add("i" + i);
//		}
//		return names;
//	}
//
//	private String getVariableName(ArrayType arrayType) {
//		switch (arrayType.getDimensionality()) {
//		case 1:
//			return "vector";
//		case 2:
//			return "matrix";
//		default:
//			return "array";
//		}
//	}

}
