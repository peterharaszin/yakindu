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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.mscript.AdditiveExpression;
import org.eclipselabs.damos.mscript.ArrayConstructionIterationClause;
import org.eclipselabs.damos.mscript.ArrayConstructionOperator;
import org.eclipselabs.damos.mscript.ArrayElementAccess;
import org.eclipselabs.damos.mscript.ArraySubscript;
import org.eclipselabs.damos.mscript.Assignment;
import org.eclipselabs.damos.mscript.BooleanLiteral;
import org.eclipselabs.damos.mscript.Compound;
import org.eclipselabs.damos.mscript.EndExpression;
import org.eclipselabs.damos.mscript.EqualityExpression;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.FunctionCall;
import org.eclipselabs.damos.mscript.IfExpression;
import org.eclipselabs.damos.mscript.IfStatement;
import org.eclipselabs.damos.mscript.ImpliesExpression;
import org.eclipselabs.damos.mscript.IntegerLiteral;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.InvalidExpression;
import org.eclipselabs.damos.mscript.IterationCall;
import org.eclipselabs.damos.mscript.LetExpression;
import org.eclipselabs.damos.mscript.LetExpressionAssignment;
import org.eclipselabs.damos.mscript.Literal;
import org.eclipselabs.damos.mscript.LocalVariableDeclaration;
import org.eclipselabs.damos.mscript.LogicalAndExpression;
import org.eclipselabs.damos.mscript.LogicalOrExpression;
import org.eclipselabs.damos.mscript.MemberVariableAccess;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.MultiplicativeExpression;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.ParenthesizedExpression;
import org.eclipselabs.damos.mscript.PowerExpression;
import org.eclipselabs.damos.mscript.RangeExpression;
import org.eclipselabs.damos.mscript.RealLiteral;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.RelationalExpression;
import org.eclipselabs.damos.mscript.StringLiteral;
import org.eclipselabs.damos.mscript.StructConstructionMember;
import org.eclipselabs.damos.mscript.StructConstructionOperator;
import org.eclipselabs.damos.mscript.TypeTestExpression;
import org.eclipselabs.damos.mscript.UnaryExpression;
import org.eclipselabs.damos.mscript.UnitConstructionOperator;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.VariableReference;
import org.eclipselabs.damos.mscript.internal.MscriptPlugin;
import org.eclipselabs.damos.mscript.interpreter.value.IBooleanValue;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.util.MscriptSwitch;
import org.eclipselabs.damos.mscript.util.MscriptUtil;
import org.eclipselabs.damos.mscript.util.SyntaxStatus;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionTransformer extends MscriptSwitch<Expression> implements IExpressionTransformer {

	private ITransformerContext context;

	private IterationCallTransformerLookupTable iterationCallTransformerLookupTable = new IterationCallTransformerLookupTable();
	
	private MultiStatus status;

	/**
	 * 
	 */
	public ExpressionTransformer(ITransformerContext context) {
		this.context = context;
		status = new MultiStatus(MscriptPlugin.PLUGIN_ID, 0, "Expression transformation", null);
	}
	
	/**
	 * @param value
	 * @param expression
	 * @return
	 */
	protected Expression condenseExpression(IValue value, Expression expression) {
		if (value instanceof ISimpleNumericValue) {
			ISimpleNumericValue numericValue = (ISimpleNumericValue) value;
			NumericType dataType = numericValue.getDataType();
			if (dataType instanceof RealType) {
				RealLiteral realLiteral = MscriptFactory.eINSTANCE.createRealLiteral();
				realLiteral.setValue(numericValue.doubleValue());
				realLiteral.setUnit(EcoreUtil.copy(dataType.getUnit()));
				expression = realLiteral;
			} else if (dataType instanceof IntegerType) {
				IntegerLiteral integerLiteral = MscriptFactory.eINSTANCE.createIntegerLiteral();
				integerLiteral.setValue(numericValue.longValue());
				integerLiteral.setUnit(EcoreUtil.copy(dataType.getUnit()));
				expression = integerLiteral;
			}
		}
		return expression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.transform.IExpressionTransformer#transform(org.eclipselabs.mscript.language.ast.Expression, java.util.List)
	 */
	public IStatus transform(Expression expression, List<? extends IExpressionTarget> targets) {
		Expression result = doTransform(expression);
		IExpressionTarget target = targets.get(0);

		Assignment assignment = MscriptFactory.eINSTANCE.createAssignment();
		assignment.setAssignedExpression(result);
		assignment.setTarget(MscriptUtil.createVariableReference(context.getStaticEvaluationResult(), target.getVariableDeclaration(), target.getStepIndex(), false));
		context.getCompound().getStatements().add(assignment);
		
		return status.isOK() ? Status.OK_STATUS : status;
	}
	
	private Expression doTransform(Expression expression) {
		Expression newExpression = doSwitch(expression);
		IValue value = context.getStaticEvaluationResult().getValue(expression);
		if (value != null) {
			if (!(expression instanceof Literal)) {
				newExpression = condenseExpression(value, newExpression);
			}
			context.getStaticEvaluationResult().setValue(newExpression, value);
		}
		return newExpression;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLetExpression(org.eclipselabs.mscript.language.ast.LetExpression)
	 */
	@Override
	public Expression caseLetExpression(LetExpression letExpression) {
		LocalVariableDeclaration localVariableDeclaration = MscriptFactory.eINSTANCE.createLocalVariableDeclaration();
		localVariableDeclaration.setName(MscriptUtil.findAvailableLocalVariableName(context.getCompound(), "temp"));
		IValue expressionValue = context.getStaticEvaluationResult().getValue(letExpression);
		context.getStaticEvaluationResult().setValue(localVariableDeclaration, expressionValue);
		context.getCompound().getStatements().add(localVariableDeclaration);

		Compound compoundStatement = MscriptFactory.eINSTANCE.createCompound();
		context.getCompound().getStatements().add(compoundStatement);
		
		context.enterScope();
		context.setCompound(compoundStatement);

		for (LetExpressionAssignment assignment : letExpression.getAssignments()) {
			LocalVariableDeclaration localVariable = MscriptFactory.eINSTANCE.createLocalVariableDeclaration();
			VariableDeclaration variable = assignment.getVariables().get(0);
			
			context.addVariableDeclarationMapping(variable, localVariable);
			
			IValue partValue = context.getStaticEvaluationResult().getValue(variable);
			context.getStaticEvaluationResult().setValue(localVariable, partValue);
			localVariable.setName(MscriptUtil.findAvailableLocalVariableName(context.getCompound(), variable.getName()));
			Expression assignedExpression = doTransform(assignment.getAssignedExpression());
			localVariable.setInitializer(assignedExpression);
			compoundStatement.getStatements().add(localVariable);
		}

		transform(
				letExpression.getTarget(),
				Collections.singletonList(new ExpressionTarget(localVariableDeclaration, 0)));
		
		context.leaveScope();
		
		VariableReference variableReference = MscriptFactory.eINSTANCE.createVariableReference();
		variableReference.setFeature(localVariableDeclaration);
		return variableReference;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIfExpression(org.eclipselabs.mscript.language.ast.IfExpression)
	 */
	@Override
	public Expression caseIfExpression(IfExpression ifExpression) {
		IValue ifConditionValue = context.getStaticEvaluationResult().getValue(ifExpression.getCondition());
		if (ifConditionValue instanceof IBooleanValue) {
			boolean condition = ((IBooleanValue) ifConditionValue).booleanValue();
			Expression expression = condition ? ifExpression.getThenExpression() : ifExpression.getElseExpression();
			return doTransform(expression);
		}
		
		Expression conditionExpression = doTransform(ifExpression.getCondition());

		LocalVariableDeclaration localVariableDeclaration = MscriptFactory.eINSTANCE.createLocalVariableDeclaration();
		localVariableDeclaration.setName(MscriptUtil.findAvailableLocalVariableName(context.getCompound(), "ifresult"));
		
		IValue ifExpressionValue = context.getStaticEvaluationResult().getValue(ifExpression);
		context.getStaticEvaluationResult().setValue(localVariableDeclaration, ifExpressionValue);
		
		context.getCompound().getStatements().add(localVariableDeclaration);
		IfStatement ifStatement = MscriptFactory.eINSTANCE.createIfStatement();
		ifStatement.setCondition(conditionExpression);
		context.getCompound().getStatements().add(ifStatement);
		
		Compound thenStatement = MscriptFactory.eINSTANCE.createCompound();
		ifStatement.setThenStatement(thenStatement);
		context.enterScope();
		context.setCompound(thenStatement);
		transform(
				ifExpression.getThenExpression(),
				Collections.singletonList(new ExpressionTarget(localVariableDeclaration, 0)));
		context.leaveScope();
		
		Compound elseStatement = MscriptFactory.eINSTANCE.createCompound();
		ifStatement.setElseStatement(elseStatement);
		context.enterScope();
		context.setCompound(elseStatement);
		transform(
				ifExpression.getElseExpression(),
				Collections.singletonList(new ExpressionTarget(localVariableDeclaration, 0)));
		context.leaveScope();
		
		VariableReference variableReference = MscriptFactory.eINSTANCE.createVariableReference();
		variableReference.setFeature(localVariableDeclaration);
		return variableReference;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.util.MscriptSwitch#caseRangeExpression(org.eclipselabs.damos.mscript.RangeExpression)
	 */
	@Override
	public Expression caseRangeExpression(RangeExpression rangeExpression) {
		RangeExpression transformedRangeExpression = MscriptFactory.eINSTANCE.createRangeExpression();
		for (Expression operand : rangeExpression.getOperands()) {
			transformedRangeExpression.getOperands().add(doTransform(operand));
		}
		return transformedRangeExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseVariableAccess(org.eclipselabs.mscript.language.ast.VariableAccess)
	 */
	@Override
	public Expression caseVariableReference(VariableReference variableReference) {
		if (variableReference.getFeature() instanceof VariableDeclaration) {
			VariableDeclaration variableDeclaration = (VariableDeclaration) variableReference.getFeature();
			if (variableDeclaration != null) {
				int stepIndex = context.getStaticEvaluationResult().getStepIndex(variableReference);
				return MscriptUtil.createVariableReference(context.getStaticEvaluationResult(), context.mapVariableDeclaration(variableDeclaration), stepIndex, false);
			}
		} else {
			return EcoreUtil.copy(variableReference);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseFunctionCall(org.eclipselabs.mscript.language.ast.FunctionCall)
	 */
	@Override
	public Expression caseFunctionCall(FunctionCall functionCall) {
		FunctionCall transformedFunctionCall = MscriptFactory.eINSTANCE.createFunctionCall();
		transformedFunctionCall.setFeature(functionCall.getFeature());
		for (Expression expression : functionCall.getArguments()) {
			Expression transformedExpression = doTransform(expression);
			if (transformedExpression instanceof InvalidExpression) {
				return transformedExpression;
			}
			transformedFunctionCall.getArguments().add(transformedExpression);
		}
		return transformedFunctionCall;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIterationCall(org.eclipselabs.mscript.language.ast.IterationCall)
	 */
	@Override
	public Expression caseIterationCall(IterationCall iterationCall) {
		IIterationCallTransformer transformer = iterationCallTransformerLookupTable.getTransformer(iterationCall.getIdentifier());
		if (transformer == null) {
			status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Invalid iteration call", iterationCall));
			return createInvalidExpression();
		}
		
		IIterationCallTransformerResult result = transformer.transform(context, iterationCall, doTransform(iterationCall.getTarget()));
		
		VariableReference variableReference = MscriptFactory.eINSTANCE.createVariableReference();
		variableReference.setFeature(result.getLocalVariableDeclaration());
		return variableReference;
	}
			
	private InvalidExpression createInvalidExpression() {
		InvalidExpression invalidExpression = MscriptFactory.eINSTANCE.createInvalidExpression();
		return invalidExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseImpliesExpression(org.eclipselabs.mscript.language.ast.ImpliesExpression)
	 */
	@Override
	public Expression caseImpliesExpression(ImpliesExpression impliesExpression) {
		ImpliesExpression transformedImpliesExpression = MscriptFactory.eINSTANCE.createImpliesExpression();
		
		Expression leftTransformedExpression = doTransform(impliesExpression.getLeftOperand());
		Expression rightTransformedExpression = doTransform(impliesExpression.getRightOperand());
		
		transformedImpliesExpression.setLeftOperand(leftTransformedExpression);
		transformedImpliesExpression.setRightOperand(rightTransformedExpression);

		return transformedImpliesExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLogicalOrExpression(org.eclipselabs.mscript.language.ast.LogicalOrExpression)
	 */
	@Override
	public Expression caseLogicalOrExpression(LogicalOrExpression logicalOrExpression) {
		LogicalOrExpression transformedExpression = MscriptFactory.eINSTANCE.createLogicalOrExpression();
		transformedExpression.setLeftOperand(doTransform(logicalOrExpression.getLeftOperand()));
		transformedExpression.setRightOperand(doTransform(logicalOrExpression.getRightOperand()));
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLogicalAndExpression(org.eclipselabs.mscript.language.ast.LogicalAndExpression)
	 */
	@Override
	public Expression caseLogicalAndExpression(LogicalAndExpression logicalAndExpression) {
		LogicalAndExpression transformedExpression = MscriptFactory.eINSTANCE.createLogicalAndExpression();
		transformedExpression.setLeftOperand(doTransform(logicalAndExpression.getLeftOperand()));
		transformedExpression.setRightOperand(doTransform(logicalAndExpression.getRightOperand()));
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseEqualityExpression(org.eclipselabs.mscript.language.ast.EqualityExpression)
	 */
	@Override
	public Expression caseEqualityExpression(EqualityExpression equalityExpression) {
		EqualityExpression transformedExpression = MscriptFactory.eINSTANCE.createEqualityExpression();
		transformedExpression.setOperator(equalityExpression.getOperator());
		
		Expression leftExpression = doTransform(equalityExpression.getLeftOperand());
		transformedExpression.setLeftOperand(leftExpression);
		Expression rightExpression = doTransform(equalityExpression.getRightOperand());		
		transformedExpression.setRightOperand(rightExpression);
		
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRelationalExpression(org.eclipselabs.mscript.language.ast.RelationalExpression)
	 */
	@Override
	public Expression caseRelationalExpression(RelationalExpression relationalExpression) {
		RelationalExpression transformedExpression = MscriptFactory.eINSTANCE.createRelationalExpression();
		transformedExpression.setOperator(relationalExpression.getOperator());
		
		Expression leftExpression = doTransform(relationalExpression.getLeftOperand());
		transformedExpression.setLeftOperand(leftExpression);
		Expression rightExpression = doTransform(relationalExpression.getRightOperand());
		transformedExpression.setRightOperand(rightExpression);
		
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseAdditiveExpression(org.eclipselabs.mscript.language.ast.AdditiveExpression)
	 */
	@Override
	public Expression caseAdditiveExpression(AdditiveExpression additiveExpression) {
		AdditiveExpression transformedExpression = MscriptFactory.eINSTANCE.createAdditiveExpression();
		transformedExpression.setOperator(additiveExpression.getOperator());
		transformedExpression.setLeftOperand(doTransform(additiveExpression.getLeftOperand()));
		transformedExpression.setRightOperand(doTransform(additiveExpression.getRightOperand()));
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseMultiplicativeExpression(org.eclipselabs.mscript.language.ast.MultiplicativeExpression)
	 */
	@Override
	public Expression caseMultiplicativeExpression(MultiplicativeExpression multiplicativeExpression) {
		MultiplicativeExpression transformedExpression = MscriptFactory.eINSTANCE.createMultiplicativeExpression();
		transformedExpression.setOperator(multiplicativeExpression.getOperator());
		transformedExpression.setLeftOperand(doTransform(multiplicativeExpression.getLeftOperand()));
		transformedExpression.setRightOperand(doTransform(multiplicativeExpression.getRightOperand()));
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseTypeTestExpression(org.eclipselabs.mscript.language.ast.TypeTestExpression)
	 */
	@Override
	public Expression caseTypeTestExpression(TypeTestExpression typeTestExpression) {
		TypeTestExpression transformedTypeTestExpression = MscriptFactory.eINSTANCE.createTypeTestExpression();
		Expression expression = doTransform(typeTestExpression.getExpression());
		transformedTypeTestExpression.setExpression(expression);
		transformedTypeTestExpression.setTypeSpecifier(EcoreUtil.copy(typeTestExpression.getTypeSpecifier()));
		return transformedTypeTestExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseUnaryExpression(org.eclipselabs.mscript.language.ast.UnaryExpression)
	 */
	@Override
	public Expression caseUnaryExpression(UnaryExpression unaryExpression) {
		UnaryExpression transformedExpression = MscriptFactory.eINSTANCE.createUnaryExpression();
		transformedExpression.setOperator(unaryExpression.getOperator());
		Expression expression = doTransform(unaryExpression.getOperand());
		transformedExpression.setOperand(expression);
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.util.MscriptSwitch#casePowerExpression(org.eclipselabs.damos.mscript.PowerExpression)
	 */
	@Override
	public Expression casePowerExpression(PowerExpression powerExpression) {
		PowerExpression transformedExpression = MscriptFactory.eINSTANCE.createPowerExpression();
		transformedExpression.setOperand(doTransform(powerExpression.getOperand()));
		transformedExpression.setExponent(doTransform(powerExpression.getExponent()));
		transformedExpression.setOperator(powerExpression.getOperator());
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseArrayConstructionOperator(org.eclipselabs.mscript.language.ast.ArrayConstructionOperator)
	 */
	@Override
	public Expression caseArrayConstructionOperator(ArrayConstructionOperator arrayConstructionOperator) {
		ArrayConstructionOperator transformedExpression = MscriptFactory.eINSTANCE.createArrayConstructionOperator();
		for (Expression expression : arrayConstructionOperator.getExpressions()) {
			transformedExpression.getExpressions().add(doTransform(expression));
		}
		for (ArrayConstructionIterationClause iterationClause : arrayConstructionOperator.getIterationClauses()) {
			Expression transformedCollectionExpression = doTransform(iterationClause.getCollectionExpression());
			ArrayConstructionIterationClause transformedIterationClause = MscriptFactory.eINSTANCE.createArrayConstructionIterationClause();
			transformedIterationClause.setIterationVariable(EcoreUtil.copy(iterationClause.getIterationVariable()));
			transformedIterationClause.setCollectionExpression(transformedCollectionExpression);
			transformedExpression.getIterationClauses().add(transformedIterationClause);
		}
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.util.MscriptSwitch#caseArrayElementAccess(org.eclipselabs.damos.mscript.ArrayElementAccess)
	 */
	@Override
	public Expression caseArrayElementAccess(ArrayElementAccess arrayElementAccess) {
		ArrayElementAccess transformedAccess = MscriptFactory.eINSTANCE.createArrayElementAccess();
		transformedAccess.setArray(doTransform(arrayElementAccess.getArray()));
		for (ArraySubscript arraySubscript : arrayElementAccess.getSubscripts()) {
			Expression transformedExpression = doTransform(arraySubscript.getExpression());
			ArraySubscript subscript = MscriptFactory.eINSTANCE.createArraySubscript();
			subscript.setExpression(transformedExpression);
			transformedAccess.getSubscripts().add(subscript);
		}
		return transformedAccess;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.util.MscriptSwitch#caseStructConstructionOperator(org.eclipselabs.damos.mscript.StructConstructionOperator)
	 */
	@Override
	public Expression caseStructConstructionOperator(StructConstructionOperator structConstructionOperator) {
		StructConstructionOperator transformedStructConstructionOperator = MscriptFactory.eINSTANCE.createStructConstructionOperator();
		for (StructConstructionMember member : structConstructionOperator.getMembers()) {
			StructConstructionMember transformedMember = MscriptFactory.eINSTANCE.createStructConstructionMember();
			transformedMember.setName(member.getName());
			transformedMember.setValue(doTransform(member.getValue()));
			transformedStructConstructionOperator.getMembers().add(transformedMember);
		}
		return transformedStructConstructionOperator;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.util.MscriptSwitch#caseMemberVariableAccess(org.eclipselabs.damos.mscript.MemberVariableAccess)
	 */
	@Override
	public Expression caseMemberVariableAccess(MemberVariableAccess memberVariableAccess) {
		MemberVariableAccess transformedMemberVariableAccess = MscriptFactory.eINSTANCE.createMemberVariableAccess();
		transformedMemberVariableAccess.setTarget(doTransform(memberVariableAccess.getTarget()));
		transformedMemberVariableAccess.setMemberVariable(memberVariableAccess.getMemberVariable());
		return transformedMemberVariableAccess;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseParenthesizedExpression(org.eclipselabs.mscript.language.ast.ParenthesizedExpression)
	 */
	@Override
	public Expression caseParenthesizedExpression(ParenthesizedExpression parenthesizedExpression) {
		ParenthesizedExpression transformedExpression = MscriptFactory.eINSTANCE.createParenthesizedExpression();
		Expression firstParenthesizedExpression = parenthesizedExpression.getExpressions().get(0);
		Expression transformedFirstParenthesizedExpression = doTransform(firstParenthesizedExpression);
		transformedExpression.getExpressions().add(transformedFirstParenthesizedExpression);
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRealLiteral(org.eclipselabs.mscript.language.ast.RealLiteral)
	 */
	@Override
	public Expression caseRealLiteral(RealLiteral realLiteral) {
		RealType realType = MscriptFactory.eINSTANCE.createRealType();
		realType.setUnit(EcoreUtil.copy(realLiteral.getUnit()));
		
		RealLiteral transformedRealLiteral = EcoreUtil.copy(realLiteral);
		return transformedRealLiteral;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIntegerLiteral(org.eclipselabs.mscript.language.ast.IntegerLiteral)
	 */
	@Override
	public Expression caseIntegerLiteral(IntegerLiteral integerLiteral) {
		IntegerType integerType = MscriptFactory.eINSTANCE.createIntegerType();
		integerType.setUnit(EcoreUtil.copy(integerLiteral.getUnit()));

		IntegerLiteral transformedIntegerLiteral = EcoreUtil.copy(integerLiteral);
		return transformedIntegerLiteral;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseBooleanLiteral(org.eclipselabs.mscript.language.ast.BooleanLiteral)
	 */
	@Override
	public Expression caseBooleanLiteral(BooleanLiteral booleanLiteral) {
		BooleanLiteral transformedBooleanLiteral = EcoreUtil.copy(booleanLiteral);
		return transformedBooleanLiteral;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseStringLiteral(org.eclipselabs.mscript.language.ast.StringLiteral)
	 */
	@Override
	public Expression caseStringLiteral(StringLiteral stringLiteral) {
		StringLiteral transformedStringLiteral = EcoreUtil.copy(stringLiteral);
		return transformedStringLiteral;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseUnitConstructionOperator(org.eclipselabs.mscript.language.ast.UnitConstructionOperator)
	 */
	@Override
	public Expression caseUnitConstructionOperator(UnitConstructionOperator unitConstructionOperator) {
		UnitConstructionOperator transformedUnitConstructionOperator = EcoreUtil.copy(unitConstructionOperator);
		return transformedUnitConstructionOperator;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.util.MscriptSwitch#caseEndExpression(org.eclipselabs.damos.mscript.EndExpression)
	 */
	@Override
	public Expression caseEndExpression(EndExpression endExpression) {
		EndExpression transformedEndExpression = EcoreUtil.copy(endExpression);
		return transformedEndExpression;
	}
	
}
