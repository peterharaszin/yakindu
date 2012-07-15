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

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.mscript.AdditiveExpression;
import org.eclipselabs.damos.mscript.ArrayConstructionIterationClause;
import org.eclipselabs.damos.mscript.ArrayConstructionOperator;
import org.eclipselabs.damos.mscript.ArrayElementAccess;
import org.eclipselabs.damos.mscript.ArraySubscript;
import org.eclipselabs.damos.mscript.ConstantTemplateSegment;
import org.eclipselabs.damos.mscript.EqualityExpression;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.ExpressionTemplateSegment;
import org.eclipselabs.damos.mscript.FunctionCall;
import org.eclipselabs.damos.mscript.IfExpression;
import org.eclipselabs.damos.mscript.ImpliesExpression;
import org.eclipselabs.damos.mscript.InvalidExpression;
import org.eclipselabs.damos.mscript.IterationAccumulator;
import org.eclipselabs.damos.mscript.IterationCall;
import org.eclipselabs.damos.mscript.IterationVariableDeclaration;
import org.eclipselabs.damos.mscript.LetExpression;
import org.eclipselabs.damos.mscript.LetExpressionAssignment;
import org.eclipselabs.damos.mscript.LetExpressionVariableDeclaration;
import org.eclipselabs.damos.mscript.LogicalAndExpression;
import org.eclipselabs.damos.mscript.LogicalOrExpression;
import org.eclipselabs.damos.mscript.MemberVariableAccess;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.MultiplicativeExpression;
import org.eclipselabs.damos.mscript.ParenthesizedExpression;
import org.eclipselabs.damos.mscript.PowerExpression;
import org.eclipselabs.damos.mscript.RangeExpression;
import org.eclipselabs.damos.mscript.RelationalExpression;
import org.eclipselabs.damos.mscript.StructConstructionMember;
import org.eclipselabs.damos.mscript.StructConstructionOperator;
import org.eclipselabs.damos.mscript.TemplateExpression;
import org.eclipselabs.damos.mscript.TemplateSegment;
import org.eclipselabs.damos.mscript.TypeTestExpression;
import org.eclipselabs.damos.mscript.UnaryExpression;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.VariableReference;
import org.eclipselabs.damos.mscript.util.MscriptUtil;

/**
 * @author Andreas Unger
 *
 */
public class DefaultExpressionTransformStrategy implements IExpressionTransformStrategy {

	public boolean canHandle(ITransformerContext context, Expression expression) {
		return true;
	}

	public Expression transform(ITransformerContext context, Expression expression, IExpressionTransformer transformer) {
		return dispatch(context, transformer, expression);
	}
	
	protected Expression dispatch(ITransformerContext context, IExpressionTransformer transformer, Expression expression) {
		if (expression instanceof LetExpression) {
			return transformLetExpression(context, transformer, (LetExpression) expression);
		}
		if (expression instanceof IfExpression) {
			return transformIfExpression(context, transformer, (IfExpression) expression);
		}
		if (expression instanceof RangeExpression) {
			return transformRangeExpression(context, transformer, (RangeExpression) expression);
		}
		if (expression instanceof VariableReference) {
			return transformVariableReference(context, transformer, (VariableReference) expression);
		}
		if (expression instanceof FunctionCall) {
			return transformFunctionCall(context, transformer, (FunctionCall) expression);
		}
		if (expression instanceof IterationCall) {
			return transformIterationCall(context, transformer, (IterationCall) expression);
		}
		if (expression instanceof ImpliesExpression) {
			return transformImpliesExpression(context, transformer, (ImpliesExpression) expression);
		}
		if (expression instanceof LogicalOrExpression) {
			return transformLogicalOrExpression(context, transformer, (LogicalOrExpression) expression);
		}
		if (expression instanceof LogicalAndExpression) {
			return transformLogicalAndExpression(context, transformer, (LogicalAndExpression) expression);
		}
		if (expression instanceof EqualityExpression) {
			return transformEqualityExpression(context, transformer, (EqualityExpression) expression);
		}
		if (expression instanceof RelationalExpression) {
			return transformRelationalExpression(context, transformer, (RelationalExpression) expression);
		}
		if (expression instanceof AdditiveExpression) {
			return transformAdditiveExpression(context, transformer, (AdditiveExpression) expression);
		}
		if (expression instanceof MultiplicativeExpression) {
			return transformMultiplicativeExpression(context, transformer, (MultiplicativeExpression) expression);
		}
		if (expression instanceof TypeTestExpression) {
			return transformTypeTestExpression(context, transformer, (TypeTestExpression) expression);
		}
		if (expression instanceof UnaryExpression) {
			return transformUnaryExpression(context, transformer, (UnaryExpression) expression);
		}
		if (expression instanceof PowerExpression) {
			return transformPowerExpression(context, transformer, (PowerExpression) expression);
		}
		if (expression instanceof ArrayConstructionOperator) {
			return transformArrayConstructionOperator(context, transformer, (ArrayConstructionOperator) expression);
		}
		if (expression instanceof ArrayElementAccess) {
			return transformArrayElementAccess(context, transformer, (ArrayElementAccess) expression);
		}
		if (expression instanceof StructConstructionOperator) {
			return transformStructConstructionOperator(context, transformer, (StructConstructionOperator) expression);
		}
		if (expression instanceof MemberVariableAccess) {
			return transformMemberVariableAccess(context, transformer, (MemberVariableAccess) expression);
		}
		if (expression instanceof ParenthesizedExpression) {
			return transformParenthesizedExpression(context, transformer, (ParenthesizedExpression) expression);
		}
		if (expression instanceof TemplateExpression) {
			return transformTemplateExpression(context, transformer, (TemplateExpression) expression);
		}
		return EcoreUtil.copy(expression);
	}

	protected Expression transformLetExpression(ITransformerContext context, IExpressionTransformer transformer, LetExpression letExpression) {
		LetExpression transformedLetExpression = MscriptFactory.eINSTANCE.createLetExpression();
		transformedLetExpression.setTarget(transformer.transformNext(letExpression.getTarget()));
		for (LetExpressionAssignment assignment : letExpression.getAssignments()) {
			LetExpressionAssignment transformedAssignment = MscriptFactory.eINSTANCE.createLetExpressionAssignment();
			transformedAssignment.setAssignedExpression(transformer.transformNext(assignment.getAssignedExpression()));
			for (LetExpressionVariableDeclaration variable : assignment.getVariables()) {
				LetExpressionVariableDeclaration transformedVariable = EcoreUtil.copy(variable);
				transformedAssignment.getVariables().add(transformedVariable);
				context.addVariableDeclarationMapping(variable, transformedVariable);
			}
		}
		return transformedLetExpression;
	}
	
	protected Expression transformIfExpression(ITransformerContext context, IExpressionTransformer transformer, IfExpression ifExpression) {
		IfExpression transformedIfExpression = MscriptFactory.eINSTANCE.createIfExpression();
		transformedIfExpression.setStatic(ifExpression.isStatic());
		transformedIfExpression.setCondition(transformer.transformNext(ifExpression.getCondition()));
		transformedIfExpression.setThenExpression(transformer.transformNext(ifExpression.getThenExpression()));
		transformedIfExpression.setElseExpression(transformer.transformNext(ifExpression.getElseExpression()));
		return transformedIfExpression;
	}
	
	protected Expression transformRangeExpression(ITransformerContext context, IExpressionTransformer transformer, RangeExpression rangeExpression) {
		RangeExpression transformedRangeExpression = MscriptFactory.eINSTANCE.createRangeExpression();
		for (Expression operand : rangeExpression.getOperands()) {
			transformedRangeExpression.getOperands().add(transformer.transformNext(operand));
		}
		return transformedRangeExpression;
	}
	
	protected Expression transformVariableReference(ITransformerContext context, IExpressionTransformer transformer, VariableReference variableReference) {
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

	protected Expression transformFunctionCall(ITransformerContext context, IExpressionTransformer transformer, FunctionCall functionCall) {
		FunctionCall transformedFunctionCall = MscriptFactory.eINSTANCE.createFunctionCall();
		transformedFunctionCall.setFeature(functionCall.getFeature());
		for (Expression expression : functionCall.getArguments()) {
			Expression transformedExpression = transformer.transformNext(expression);
			if (transformedExpression instanceof InvalidExpression) {
				return transformedExpression;
			}
			transformedFunctionCall.getArguments().add(transformedExpression);
		}
		return transformedFunctionCall;
	}
	
	protected Expression transformIterationCall(ITransformerContext context, IExpressionTransformer transformer, IterationCall iterationCall) {
		IterationCall transformedIterationCall = MscriptFactory.eINSTANCE.createIterationCall();
		
		transformedIterationCall.setIdentifier(iterationCall.getIdentifier());
		transformedIterationCall.setTarget(transformer.transformNext(iterationCall.getTarget()));
		transformedIterationCall.setBreakCondition(transformer.transformNext(iterationCall.getBreakCondition()));
		transformedIterationCall.setExpression(transformer.transformNext(iterationCall.getExpression()));
		
		IterationAccumulator transformedAccumulator = MscriptFactory.eINSTANCE.createIterationAccumulator();
		transformedAccumulator.setName(iterationCall.getAccumulator().getName());
		transformedAccumulator.setInitializer(transformer.transformNext(iterationCall.getAccumulator().getInitializer()));
		context.addVariableDeclarationMapping(iterationCall.getAccumulator(), transformedAccumulator);
		
		for (IterationVariableDeclaration iterationVariable : iterationCall.getIterationVariables()) {
			IterationVariableDeclaration transformedIterationVariable = EcoreUtil.copy(iterationVariable);
			transformedIterationCall.getIterationVariables().add(transformedIterationVariable);
			context.addVariableDeclarationMapping(iterationVariable, transformedIterationVariable);
		}
		
		return transformedIterationCall;
	}
	
	protected Expression transformImpliesExpression(ITransformerContext context, IExpressionTransformer transformer, ImpliesExpression impliesExpression) {
		ImpliesExpression transformedImpliesExpression = MscriptFactory.eINSTANCE.createImpliesExpression();
		
		Expression leftTransformedExpression = transformer.transformNext(impliesExpression.getLeftOperand());
		Expression rightTransformedExpression = transformer.transformNext(impliesExpression.getRightOperand());
		
		transformedImpliesExpression.setLeftOperand(leftTransformedExpression);
		transformedImpliesExpression.setRightOperand(rightTransformedExpression);

		return transformedImpliesExpression;
	}
	
	protected Expression transformLogicalOrExpression(ITransformerContext context, IExpressionTransformer transformer, LogicalOrExpression logicalOrExpression) {
		LogicalOrExpression transformedExpression = MscriptFactory.eINSTANCE.createLogicalOrExpression();
		transformedExpression.setLeftOperand(transformer.transformNext(logicalOrExpression.getLeftOperand()));
		transformedExpression.setRightOperand(transformer.transformNext(logicalOrExpression.getRightOperand()));
		return transformedExpression;
	}
	
	protected Expression transformLogicalAndExpression(ITransformerContext context, IExpressionTransformer transformer, LogicalAndExpression logicalAndExpression) {
		LogicalAndExpression transformedExpression = MscriptFactory.eINSTANCE.createLogicalAndExpression();
		transformedExpression.setLeftOperand(transformer.transformNext(logicalAndExpression.getLeftOperand()));
		transformedExpression.setRightOperand(transformer.transformNext(logicalAndExpression.getRightOperand()));
		return transformedExpression;
	}
	
	protected Expression transformEqualityExpression(ITransformerContext context, IExpressionTransformer transformer, EqualityExpression equalityExpression) {
		EqualityExpression transformedExpression = MscriptFactory.eINSTANCE.createEqualityExpression();
		transformedExpression.setOperator(equalityExpression.getOperator());
		
		Expression leftExpression = transformer.transformNext(equalityExpression.getLeftOperand());
		transformedExpression.setLeftOperand(leftExpression);
		Expression rightExpression = transformer.transformNext(equalityExpression.getRightOperand());		
		transformedExpression.setRightOperand(rightExpression);
		
		return transformedExpression;
	}
	
	protected Expression transformRelationalExpression(ITransformerContext context, IExpressionTransformer transformer, RelationalExpression relationalExpression) {
		RelationalExpression transformedExpression = MscriptFactory.eINSTANCE.createRelationalExpression();
		transformedExpression.setOperator(relationalExpression.getOperator());
		
		Expression leftExpression = transformer.transformNext(relationalExpression.getLeftOperand());
		transformedExpression.setLeftOperand(leftExpression);
		Expression rightExpression = transformer.transformNext(relationalExpression.getRightOperand());
		transformedExpression.setRightOperand(rightExpression);
		
		return transformedExpression;
	}
	
	protected Expression transformAdditiveExpression(ITransformerContext context, IExpressionTransformer transformer, AdditiveExpression additiveExpression) {
		AdditiveExpression transformedExpression = MscriptFactory.eINSTANCE.createAdditiveExpression();
		transformedExpression.setOperator(additiveExpression.getOperator());
		transformedExpression.setLeftOperand(transformer.transformNext(additiveExpression.getLeftOperand()));
		transformedExpression.setRightOperand(transformer.transformNext(additiveExpression.getRightOperand()));
		return transformedExpression;
	}
	
	protected Expression transformMultiplicativeExpression(ITransformerContext context, IExpressionTransformer transformer, MultiplicativeExpression multiplicativeExpression) {
		MultiplicativeExpression transformedExpression = MscriptFactory.eINSTANCE.createMultiplicativeExpression();
		transformedExpression.setOperator(multiplicativeExpression.getOperator());
		transformedExpression.setLeftOperand(transformer.transformNext(multiplicativeExpression.getLeftOperand()));
		transformedExpression.setRightOperand(transformer.transformNext(multiplicativeExpression.getRightOperand()));
		return transformedExpression;
	}
	
	protected Expression transformTypeTestExpression(ITransformerContext context, IExpressionTransformer transformer, TypeTestExpression typeTestExpression) {
		TypeTestExpression transformedTypeTestExpression = MscriptFactory.eINSTANCE.createTypeTestExpression();
		Expression expression = transformer.transformNext(typeTestExpression.getExpression());
		transformedTypeTestExpression.setExpression(expression);
		transformedTypeTestExpression.setTypeSpecifier(EcoreUtil.copy(typeTestExpression.getTypeSpecifier()));
		return transformedTypeTestExpression;
	}
	
	protected Expression transformUnaryExpression(ITransformerContext context, IExpressionTransformer transformer, UnaryExpression unaryExpression) {
		UnaryExpression transformedExpression = MscriptFactory.eINSTANCE.createUnaryExpression();
		transformedExpression.setOperator(unaryExpression.getOperator());
		Expression expression = transformer.transformNext(unaryExpression.getOperand());
		transformedExpression.setOperand(expression);
		return transformedExpression;
	}
	
	protected Expression transformPowerExpression(ITransformerContext context, IExpressionTransformer transformer, PowerExpression powerExpression) {
		PowerExpression transformedExpression = MscriptFactory.eINSTANCE.createPowerExpression();
		transformedExpression.setOperand(transformer.transformNext(powerExpression.getOperand()));
		transformedExpression.setExponent(transformer.transformNext(powerExpression.getExponent()));
		transformedExpression.setOperator(powerExpression.getOperator());
		return transformedExpression;
	}
	
	protected Expression transformArrayConstructionOperator(ITransformerContext context, IExpressionTransformer transformer, ArrayConstructionOperator arrayConstructionOperator) {
		ArrayConstructionOperator transformedExpression = MscriptFactory.eINSTANCE.createArrayConstructionOperator();
		for (Expression expression : arrayConstructionOperator.getExpressions()) {
			transformedExpression.getExpressions().add(transformer.transformNext(expression));
		}
		for (ArrayConstructionIterationClause iterationClause : arrayConstructionOperator.getIterationClauses()) {
			Expression transformedCollectionExpression = transformer.transformNext(iterationClause.getCollectionExpression());
			ArrayConstructionIterationClause transformedIterationClause = MscriptFactory.eINSTANCE.createArrayConstructionIterationClause();
			transformedIterationClause.setIterationVariable(EcoreUtil.copy(iterationClause.getIterationVariable()));
			transformedIterationClause.setCollectionExpression(transformedCollectionExpression);
			transformedExpression.getIterationClauses().add(transformedIterationClause);
		}
		return transformedExpression;
	}
	
	protected Expression transformArrayElementAccess(ITransformerContext context, IExpressionTransformer transformer, ArrayElementAccess arrayElementAccess) {
		ArrayElementAccess transformedAccess = MscriptFactory.eINSTANCE.createArrayElementAccess();
		transformedAccess.setArray(transformer.transformNext(arrayElementAccess.getArray()));
		for (ArraySubscript arraySubscript : arrayElementAccess.getSubscripts()) {
			Expression transformedExpression = transformer.transformNext(arraySubscript.getExpression());
			ArraySubscript subscript = MscriptFactory.eINSTANCE.createArraySubscript();
			subscript.setExpression(transformedExpression);
			transformedAccess.getSubscripts().add(subscript);
		}
		return transformedAccess;
	}
	
	protected Expression transformStructConstructionOperator(ITransformerContext context, IExpressionTransformer transformer, StructConstructionOperator structConstructionOperator) {
		StructConstructionOperator transformedStructConstructionOperator = MscriptFactory.eINSTANCE.createStructConstructionOperator();
		for (StructConstructionMember member : structConstructionOperator.getMembers()) {
			StructConstructionMember transformedMember = MscriptFactory.eINSTANCE.createStructConstructionMember();
			transformedMember.setName(member.getName());
			transformedMember.setValue(transformer.transformNext(member.getValue()));
			transformedStructConstructionOperator.getMembers().add(transformedMember);
		}
		return transformedStructConstructionOperator;
	}
	
	protected Expression transformMemberVariableAccess(ITransformerContext context, IExpressionTransformer transformer, MemberVariableAccess memberVariableAccess) {
		MemberVariableAccess transformedMemberVariableAccess = MscriptFactory.eINSTANCE.createMemberVariableAccess();
		transformedMemberVariableAccess.setTarget(transformer.transformNext(memberVariableAccess.getTarget()));
		transformedMemberVariableAccess.setMemberVariable(memberVariableAccess.getMemberVariable());
		return transformedMemberVariableAccess;
	}
	
	protected Expression transformParenthesizedExpression(ITransformerContext context, IExpressionTransformer transformer, ParenthesizedExpression parenthesizedExpression) {
		ParenthesizedExpression transformedExpression = MscriptFactory.eINSTANCE.createParenthesizedExpression();
		Expression firstParenthesizedExpression = parenthesizedExpression.getExpressions().get(0);
		Expression transformedFirstParenthesizedExpression = transformer.transformNext(firstParenthesizedExpression);
		transformedExpression.getExpressions().add(transformedFirstParenthesizedExpression);
		return transformedExpression;
	}
	
	protected Expression transformTemplateExpression(ITransformerContext context, IExpressionTransformer transformer, TemplateExpression templateExpression) {
		TemplateExpression transformedTemplateExpression = MscriptFactory.eINSTANCE.createTemplateExpression();
		for (TemplateSegment segment : templateExpression.getSegments()) {
			if (segment instanceof ConstantTemplateSegment) {
				transformedTemplateExpression.getSegments().add(EcoreUtil.copy(segment));
			} else if (segment instanceof ExpressionTemplateSegment) {
				ExpressionTemplateSegment expressionTemplateSegment = (ExpressionTemplateSegment) segment;
				ExpressionTemplateSegment transformedTemplateSegment = MscriptFactory.eINSTANCE.createExpressionTemplateSegment();
				transformedTemplateSegment.setExpression(transformer.transformNext(expressionTemplateSegment.getExpression()));
				transformedTemplateExpression.getSegments().add(transformedTemplateSegment);
			} else {
				throw new IllegalArgumentException("Unknown template segment " + segment.getClass().getCanonicalName());
			}
		}
		return transformedTemplateExpression;
	}
	
}
