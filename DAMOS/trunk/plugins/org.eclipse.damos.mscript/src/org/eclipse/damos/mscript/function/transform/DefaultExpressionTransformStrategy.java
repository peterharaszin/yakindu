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

import org.eclipse.damos.mscript.AdditiveExpression;
import org.eclipse.damos.mscript.AlgorithmExpression;
import org.eclipse.damos.mscript.ArrayConcatenationOperator;
import org.eclipse.damos.mscript.ArrayConstructionOperator;
import org.eclipse.damos.mscript.ArrayElementAccess;
import org.eclipse.damos.mscript.ArraySubscript;
import org.eclipse.damos.mscript.BooleanLiteral;
import org.eclipse.damos.mscript.ConstantTemplateSegment;
import org.eclipse.damos.mscript.EndExpression;
import org.eclipse.damos.mscript.EqualityExpression;
import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.ExpressionTemplateSegment;
import org.eclipse.damos.mscript.FeatureReference;
import org.eclipse.damos.mscript.FunctionCall;
import org.eclipse.damos.mscript.IExpressionVisitor;
import org.eclipse.damos.mscript.IfExpression;
import org.eclipse.damos.mscript.ImpliesExpression;
import org.eclipse.damos.mscript.InspectExpression;
import org.eclipse.damos.mscript.InspectWhenClause;
import org.eclipse.damos.mscript.IntegerLiteral;
import org.eclipse.damos.mscript.InvalidExpression;
import org.eclipse.damos.mscript.LambdaExpression;
import org.eclipse.damos.mscript.LetExpression;
import org.eclipse.damos.mscript.LetExpressionAssignment;
import org.eclipse.damos.mscript.LetExpressionVariableDeclaration;
import org.eclipse.damos.mscript.LogicalAndExpression;
import org.eclipse.damos.mscript.LogicalOrExpression;
import org.eclipse.damos.mscript.MemberVariableAccess;
import org.eclipse.damos.mscript.MscriptFactory;
import org.eclipse.damos.mscript.MultiplicativeExpression;
import org.eclipse.damos.mscript.ParenthesizedExpression;
import org.eclipse.damos.mscript.PowerExpression;
import org.eclipse.damos.mscript.RangeExpression;
import org.eclipse.damos.mscript.RealLiteral;
import org.eclipse.damos.mscript.RecordConstructionMember;
import org.eclipse.damos.mscript.RecordConstructionOperator;
import org.eclipse.damos.mscript.RelationalExpression;
import org.eclipse.damos.mscript.StringLiteral;
import org.eclipse.damos.mscript.SwitchExpression;
import org.eclipse.damos.mscript.TemplateExpression;
import org.eclipse.damos.mscript.TemplateSegment;
import org.eclipse.damos.mscript.TypeSpecifier;
import org.eclipse.damos.mscript.TypeTestExpression;
import org.eclipse.damos.mscript.UnaryExpression;
import org.eclipse.damos.mscript.UnionConstructionOperator;
import org.eclipse.damos.mscript.UnionType;
import org.eclipse.damos.mscript.UnitConstructionOperator;
import org.eclipse.damos.mscript.VariableDeclaration;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.mscript.util.MscriptUtil;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Andreas Unger
 *
 */
public class DefaultExpressionTransformStrategy implements IExpressionTransformStrategy, IExpressionVisitor<Void, ExpressionTransformResult> {

	public void transform(ExpressionTransformResult result, Expression expression) {
		expression.accept(result, this);
	}
	
	public Void visit(ExpressionTransformResult result, LetExpression letExpression) {
		LetExpression transformedLetExpression = MscriptFactory.eINSTANCE.createLetExpression();
		
		for (LetExpressionAssignment assignment : letExpression.getAssignments()) {
			LetExpressionAssignment transformedAssignment = MscriptFactory.eINSTANCE.createLetExpressionAssignment();
			for (LetExpressionVariableDeclaration variable : assignment.getVariables()) {
				LetExpressionVariableDeclaration transformedVariable = EcoreUtil.copy(variable);
				transformedAssignment.getVariables().add(transformedVariable);
				result.getContext().addVariableDeclarationMapping(variable, transformedVariable);
			}
			transformedAssignment.setAssignedExpression(transformNext(result, assignment.getAssignedExpression()));
		}
		
		transformedLetExpression.setTarget(transformNext(result, letExpression.getTarget()));

		assignExpression(result, letExpression, transformedLetExpression);
		return null;
	}
	
	public Void visit(ExpressionTransformResult result, IfExpression ifExpression) {
		IfExpression transformedIfExpression = MscriptFactory.eINSTANCE.createIfExpression();
		transformedIfExpression.setStatic(ifExpression.isStatic());
		
		transformedIfExpression.setCondition(transformNext(result, ifExpression.getCondition()));
		transformedIfExpression.setThenExpression(transformNext(result, ifExpression.getThenExpression()));
		transformedIfExpression.setElseExpression(transformNext(result, ifExpression.getElseExpression()));
		
		assignExpression(result, ifExpression, transformedIfExpression);
		return null;
	}
	
	public Void visit(ExpressionTransformResult result, InspectExpression inspectExpression) {
		InspectExpression transformedInspectExpression = MscriptFactory.eINSTANCE.createInspectExpression();
		
		transformedInspectExpression.setUnionExpression(transformNext(result, inspectExpression.getUnionExpression()));
		
		for (InspectWhenClause whenClause : inspectExpression.getWhenClauses()) {
			InspectWhenClause transformedWhenClause = MscriptFactory.eINSTANCE.createInspectWhenClause();
			result.getContext().addVariableDeclarationMapping(whenClause, transformedWhenClause);
			transformedInspectExpression.getWhenClauses().add(transformedWhenClause);
			transformedWhenClause.setName(whenClause.getName());
			transformedWhenClause.setExpression(transformNext(result, whenClause.getExpression()));
		}
		
		assignExpression(result, inspectExpression, transformedInspectExpression);
		return null;
	}

	public Void visit(ExpressionTransformResult result, RangeExpression rangeExpression) {
		RangeExpression transformedRangeExpression = MscriptFactory.eINSTANCE.createRangeExpression();
		for (Expression operand : rangeExpression.getOperands()) {
			transformedRangeExpression.getOperands().add(transformNext(result, operand));
		}
		assignExpression(result, rangeExpression, transformedRangeExpression);
		return null;
	}
	
	public Void visit(ExpressionTransformResult result, FeatureReference variableReference) {
		if (variableReference.getFeature() instanceof VariableDeclaration) {
			VariableDeclaration variableDeclaration = (VariableDeclaration) variableReference.getFeature();
			if (variableDeclaration != null) {
				int stepIndex = result.getContext().getFunctionInfo().getStepIndex(variableReference);
				assignExpression(result, variableReference, MscriptUtil.createVariableReference(result.getContext().getFunctionInfo(), result.getContext().mapVariableDeclaration(variableDeclaration), stepIndex, false));
			}
		} else {
			assignExpression(result, variableReference, EcoreUtil.copy(variableReference));
		}
		return null;
	}

	public Void visit(ExpressionTransformResult result, FunctionCall functionCall) {
		FunctionCall transformedFunctionCall = MscriptFactory.eINSTANCE.createFunctionCall();
		transformedFunctionCall.eAdapters().add(new TransformAdapter<FunctionCall>(functionCall));
		FeatureReference featureReference = MscriptFactory.eINSTANCE.createFeatureReference();
		featureReference.setFeature(functionCall.getFeature());
		transformedFunctionCall.setTarget(featureReference);
		for (Expression expression : functionCall.getArguments()) {
			Expression transformedExpression = transformNext(result, expression);
			if (transformedExpression instanceof InvalidExpression) {
				result.getTargets().get(0).assignExpression(transformedExpression);
				return null;
			}
			transformedFunctionCall.getArguments().add(transformedExpression);
		}
		assignExpression(result, functionCall, transformedFunctionCall);
		return null;
	}
	
	public Void visit(ExpressionTransformResult result, ImpliesExpression impliesExpression) {
		ImpliesExpression transformedImpliesExpression = MscriptFactory.eINSTANCE.createImpliesExpression();
		
		Expression leftTransformedExpression = transformNext(result, impliesExpression.getLeftOperand());
		Expression rightTransformedExpression = transformNext(result, impliesExpression.getRightOperand());
		
		transformedImpliesExpression.setLeftOperand(leftTransformedExpression);
		transformedImpliesExpression.setRightOperand(rightTransformedExpression);
		
		assignExpression(result, impliesExpression, transformedImpliesExpression);
		return null;
	}
	
	public Void visit(ExpressionTransformResult result, LogicalOrExpression logicalOrExpression) {
		LogicalOrExpression transformedExpression = MscriptFactory.eINSTANCE.createLogicalOrExpression();
		transformedExpression.setLeftOperand(transformNext(result, logicalOrExpression.getLeftOperand()));
		transformedExpression.setRightOperand(transformNext(result, logicalOrExpression.getRightOperand()));
		assignExpression(result, logicalOrExpression, transformedExpression);
		return null;
	}
	
	public Void visit(ExpressionTransformResult result, LogicalAndExpression logicalAndExpression) {
		LogicalAndExpression transformedExpression = MscriptFactory.eINSTANCE.createLogicalAndExpression();
		transformedExpression.setLeftOperand(transformNext(result, logicalAndExpression.getLeftOperand()));
		transformedExpression.setRightOperand(transformNext(result, logicalAndExpression.getRightOperand()));
		assignExpression(result, logicalAndExpression, transformedExpression);
		return null;
	}
	
	public Void visit(ExpressionTransformResult result, EqualityExpression equalityExpression) {
		EqualityExpression transformedExpression = MscriptFactory.eINSTANCE.createEqualityExpression();
		transformedExpression.setOperator(equalityExpression.getOperator());
		
		Expression leftExpression = transformNext(result, equalityExpression.getLeftOperand());
		transformedExpression.setLeftOperand(leftExpression);
		Expression rightExpression = transformNext(result, equalityExpression.getRightOperand());
		transformedExpression.setRightOperand(rightExpression);

		assignExpression(result, equalityExpression, transformedExpression);
		return null;
	}
	
	public Void visit(ExpressionTransformResult result, RelationalExpression relationalExpression) {
		RelationalExpression transformedExpression = MscriptFactory.eINSTANCE.createRelationalExpression();
		transformedExpression.setOperator(relationalExpression.getOperator());
		
		Expression leftExpression = transformNext(result, relationalExpression.getLeftOperand());
		transformedExpression.setLeftOperand(leftExpression);
		Expression rightExpression = transformNext(result, relationalExpression.getRightOperand());
		transformedExpression.setRightOperand(rightExpression);

		assignExpression(result, relationalExpression, transformedExpression);
		return null;
	}
	
	public Void visit(ExpressionTransformResult result, AdditiveExpression additiveExpression) {
		AdditiveExpression transformedExpression = MscriptFactory.eINSTANCE.createAdditiveExpression();
		transformedExpression.setOperator(additiveExpression.getOperator());
		transformedExpression.setLeftOperand(transformNext(result, additiveExpression.getLeftOperand()));
		transformedExpression.setRightOperand(transformNext(result, additiveExpression.getRightOperand()));
		assignExpression(result, additiveExpression, transformedExpression);
		return null;
	}
	
	public Void visit(ExpressionTransformResult result, MultiplicativeExpression multiplicativeExpression) {
		MultiplicativeExpression transformedExpression = MscriptFactory.eINSTANCE.createMultiplicativeExpression();
		transformedExpression.setOperator(multiplicativeExpression.getOperator());
		transformedExpression.setLeftOperand(transformNext(result, multiplicativeExpression.getLeftOperand()));
		transformedExpression.setRightOperand(transformNext(result, multiplicativeExpression.getRightOperand()));
		assignExpression(result, multiplicativeExpression, transformedExpression);
		return null;
	}
	
	public Void visit(ExpressionTransformResult result, TypeTestExpression typeTestExpression) {
		TypeTestExpression transformedTypeTestExpression = MscriptFactory.eINSTANCE.createTypeTestExpression();
		Expression expression = transformNext(result, typeTestExpression.getExpression());
		transformedTypeTestExpression.setExpression(expression);
		transformedTypeTestExpression.setTypeSpecifier(EcoreUtil.copy(typeTestExpression.getTypeSpecifier()));
		assignExpression(result, expression, transformedTypeTestExpression);
		return null;
	}
	
	public Void visit(ExpressionTransformResult result, UnaryExpression unaryExpression) {
		UnaryExpression transformedExpression = MscriptFactory.eINSTANCE.createUnaryExpression();
		transformedExpression.setOperator(unaryExpression.getOperator());
		Expression expression = transformNext(result, unaryExpression.getOperand());
		transformedExpression.setOperand(expression);
		assignExpression(result, expression, transformedExpression);
		return null;
	}
	
	public Void visit(ExpressionTransformResult result, PowerExpression powerExpression) {
		PowerExpression transformedExpression = MscriptFactory.eINSTANCE.createPowerExpression();
		transformedExpression.setLeftOperand(transformNext(result, powerExpression.getLeftOperand()));
		transformedExpression.setRightOperand(transformNext(result, powerExpression.getRightOperand()));
		transformedExpression.setOperator(powerExpression.getOperator());
		assignExpression(result, powerExpression, transformedExpression);
		return null;
	}
	
	public Void visit(ExpressionTransformResult result, ArrayConstructionOperator arrayConstructionOperator) {
		ArrayConstructionOperator transformedExpression = MscriptFactory.eINSTANCE.createArrayConstructionOperator();
		for (Expression expression : arrayConstructionOperator.getExpressions()) {
			transformedExpression.getExpressions().add(transformNext(result, expression));
		}
		assignExpression(result, arrayConstructionOperator, transformedExpression);
		return null;
	}
	
	public Void visit(ExpressionTransformResult result, UnionConstructionOperator unionConstructionOperator) {
		UnionConstructionOperator transformedExpression = MscriptFactory.eINSTANCE.createUnionConstructionOperator();
		TypeSpecifier typeSpecifier = unionConstructionOperator.getTypeSpecifier();
		if (typeSpecifier != null && typeSpecifier.getType() instanceof UnionType) {
			UnionType unionType = (UnionType) typeSpecifier.getType();
			TypeSpecifier transformedTypeSpecifier = EcoreUtil.copy(typeSpecifier);
			transformedExpression.setTypeSpecifier(transformedTypeSpecifier);
			int memberIndex = unionType.getMembers().indexOf(unionConstructionOperator.getMember());
			if (memberIndex != -1) {
				transformedExpression.setMember(((UnionType) transformedTypeSpecifier.getType()).getMembers().get(memberIndex));
			}
		}
		transformedExpression.setValue(transformNext(result, unionConstructionOperator.getValue()));
		assignExpression(result, unionConstructionOperator, transformedExpression);
		return null;
	}

	public Void visit(ExpressionTransformResult result, ArrayElementAccess arrayElementAccess) {
		ArrayElementAccess transformedAccess = MscriptFactory.eINSTANCE.createArrayElementAccess();
		transformedAccess.setArray(transformNext(result, arrayElementAccess.getArray()));
		for (ArraySubscript arraySubscript : arrayElementAccess.getSubscripts()) {
			Expression transformedExpression = transformNext(result, arraySubscript.getExpression());
			ArraySubscript subscript = MscriptFactory.eINSTANCE.createArraySubscript();
			subscript.setExpression(transformedExpression);
			transformedAccess.getSubscripts().add(subscript);
		}
		assignExpression(result, arrayElementAccess, transformedAccess);
		return null;
	}
	
	public Void visit(ExpressionTransformResult result, RecordConstructionOperator recordConstructionOperator) {
		RecordConstructionOperator transformedStructConstructionOperator = MscriptFactory.eINSTANCE.createRecordConstructionOperator();
		for (RecordConstructionMember member : recordConstructionOperator.getMembers()) {
			RecordConstructionMember transformedMember = MscriptFactory.eINSTANCE.createRecordConstructionMember();
			transformedMember.setName(member.getName());
			transformedMember.setValue(transformNext(result, member.getValue()));
			transformedStructConstructionOperator.getMembers().add(transformedMember);
		}
		assignExpression(result, recordConstructionOperator, transformedStructConstructionOperator);
		return null;
	}
	
	public Void visit(ExpressionTransformResult result, MemberVariableAccess memberVariableAccess) {
		MemberVariableAccess transformedMemberVariableAccess = MscriptFactory.eINSTANCE.createMemberVariableAccess();
		transformedMemberVariableAccess.setTarget(transformNext(result, memberVariableAccess.getTarget()));
		transformedMemberVariableAccess.setMemberVariable(memberVariableAccess.getMemberVariable());
		assignExpression(result, memberVariableAccess, transformedMemberVariableAccess);
		return null;
	}
	
	public Void visit(ExpressionTransformResult result, ParenthesizedExpression parenthesizedExpression) {
		ParenthesizedExpression transformedExpression = MscriptFactory.eINSTANCE.createParenthesizedExpression();
		Expression firstParenthesizedExpression = parenthesizedExpression.getExpressions().get(0);
		Expression transformedFirstParenthesizedExpression = transformNext(result, firstParenthesizedExpression);
		transformedExpression.getExpressions().add(transformedFirstParenthesizedExpression);
		assignExpression(result, parenthesizedExpression, transformedExpression);
		return null;
	}
	
	public Void visit(ExpressionTransformResult result, TemplateExpression templateExpression) {
		TemplateExpression transformedTemplateExpression = MscriptFactory.eINSTANCE.createTemplateExpression();
		for (TemplateSegment segment : templateExpression.getSegments()) {
			if (segment instanceof ConstantTemplateSegment) {
				transformedTemplateExpression.getSegments().add(EcoreUtil.copy(segment));
			} else if (segment instanceof ExpressionTemplateSegment) {
				ExpressionTemplateSegment expressionTemplateSegment = (ExpressionTemplateSegment) segment;
				ExpressionTemplateSegment transformedTemplateSegment = MscriptFactory.eINSTANCE.createExpressionTemplateSegment();
				transformedTemplateSegment.setExpression(transformNext(result, expressionTemplateSegment.getExpression()));
				transformedTemplateExpression.getSegments().add(transformedTemplateSegment);
			} else {
				throw new IllegalArgumentException("Unknown template segment " + segment.getClass().getCanonicalName());
			}
		}
		assignExpression(result, templateExpression, transformedTemplateExpression);
		return null;
	}
	
	protected Expression transformNext(ExpressionTransformResult result, Expression expression) {
		InlineExpressionTarget target = new InlineExpressionTarget(result.getContext());
		result.getTransformer().transform(result.getContext(), expression, target.asList());
		Expression transformedExpression = target.getAssignedExpression();
		IValue value = result.getContext().getFunctionInfo().getValue(expression);
		if (value == null) {
			throw new IllegalStateException("No value set for expression");
		}
		result.getContext().getFunctionInfo().setValue(transformedExpression, value);
		return transformedExpression;
	}
	
	protected void assignExpression(ExpressionTransformResult result, Expression expression, Expression transformedExpression) {
		IValue value = result.getContext().getFunctionInfo().getValue(expression);
		if (value == null) {
			throw new IllegalStateException("No value set for expression");
		}
		result.getContext().getFunctionInfo().setValue(transformedExpression, value);
		result.getTargets().get(0).assignExpression(transformedExpression);
	}

	public Void visit(ExpressionTransformResult result, ArrayConcatenationOperator arrayConcatenationOperator) {
		assignExpression(result, arrayConcatenationOperator, EcoreUtil.copy(arrayConcatenationOperator));
		return null;
	}

	public Void visit(ExpressionTransformResult result, UnitConstructionOperator unitConstructionOperator) {
		assignExpression(result, unitConstructionOperator, EcoreUtil.copy(unitConstructionOperator));
		return null;
	}

	public Void visit(ExpressionTransformResult result, EndExpression endExpression) {
		assignExpression(result, endExpression, EcoreUtil.copy(endExpression));
		return null;
	}

	public Void visit(ExpressionTransformResult result, RealLiteral realLiteral) {
		assignExpression(result, realLiteral, EcoreUtil.copy(realLiteral));
		return null;
	}

	public Void visit(ExpressionTransformResult result, IntegerLiteral integerLiteral) {
		assignExpression(result, integerLiteral, EcoreUtil.copy(integerLiteral));
		return null;
	}

	public Void visit(ExpressionTransformResult result, BooleanLiteral booleanLiteral) {
		assignExpression(result, booleanLiteral, EcoreUtil.copy(booleanLiteral));
		return null;
	}

	public Void visit(ExpressionTransformResult result, StringLiteral stringLiteral) {
		assignExpression(result, stringLiteral, EcoreUtil.copy(stringLiteral));
		return null;
	}

	public Void visit(ExpressionTransformResult result, LambdaExpression lambdaExpression) {
		assignExpression(result, lambdaExpression, EcoreUtil.copy(lambdaExpression));
		return null;
	}

	public Void visit(ExpressionTransformResult result, AlgorithmExpression algorithmExpression) {
		assignExpression(result, algorithmExpression, EcoreUtil.copy(algorithmExpression));
		return null;
	}

	public Void visit(ExpressionTransformResult result, SwitchExpression switchExpression) {
		assignExpression(result, switchExpression, EcoreUtil.copy(switchExpression));
		return null;
	}

	public Void visit(ExpressionTransformResult result, InvalidExpression invalidExpression) {
		assignExpression(result, invalidExpression, EcoreUtil.copy(invalidExpression));
		return null;
	}
	
}
