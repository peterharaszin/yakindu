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
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.util.MscriptUtil;

/**
 * @author Andreas Unger
 *
 */
public class DefaultExpressionTransformStrategy implements IExpressionTransformStrategy {

	public boolean canHandle(ITransformerContext context, Expression expression) {
		return true;
	}

	public void transform(ITransformerContext context, Expression expression, List<? extends IExpressionTarget> targets, IExpressionTransformer transformer) {
		dispatch(context, targets, transformer, expression);
	}
	
	protected void dispatch(ITransformerContext context, List<? extends IExpressionTarget> targets, IExpressionTransformer transformer, Expression expression) {
		if (expression instanceof LetExpression) {
			transformLetExpression(context, targets, transformer, (LetExpression) expression);
		} else if (expression instanceof IfExpression) {
			transformIfExpression(context, targets, transformer, (IfExpression) expression);
		} else if (expression instanceof RangeExpression) {
			transformRangeExpression(context, targets, transformer, (RangeExpression) expression);
		} else if (expression instanceof VariableReference) {
			transformVariableReference(context, targets, transformer, (VariableReference) expression);
		} else if (expression instanceof FunctionCall) {
			transformFunctionCall(context, targets, transformer, (FunctionCall) expression);
		} else if (expression instanceof IterationCall) {
			transformIterationCall(context, targets, transformer, (IterationCall) expression);
		} else if (expression instanceof ImpliesExpression) {
			transformImpliesExpression(context, targets, transformer, (ImpliesExpression) expression);
		} else if (expression instanceof LogicalOrExpression) {
			transformLogicalOrExpression(context, targets, transformer, (LogicalOrExpression) expression);
		} else if (expression instanceof LogicalAndExpression) {
			transformLogicalAndExpression(context, targets, transformer, (LogicalAndExpression) expression);
		} else if (expression instanceof EqualityExpression) {
			transformEqualityExpression(context, targets, transformer, (EqualityExpression) expression);
		} else if (expression instanceof RelationalExpression) {
			transformRelationalExpression(context, targets, transformer, (RelationalExpression) expression);
		} else if (expression instanceof AdditiveExpression) {
			transformAdditiveExpression(context, targets, transformer, (AdditiveExpression) expression);
		} else if (expression instanceof MultiplicativeExpression) {
			transformMultiplicativeExpression(context, targets, transformer, (MultiplicativeExpression) expression);
		} else if (expression instanceof TypeTestExpression) {
			transformTypeTestExpression(context, targets, transformer, (TypeTestExpression) expression);
		} else if (expression instanceof UnaryExpression) {
			transformUnaryExpression(context, targets, transformer, (UnaryExpression) expression);
		} else if (expression instanceof PowerExpression) {
			transformPowerExpression(context, targets, transformer, (PowerExpression) expression);
		} else if (expression instanceof ArrayConstructionOperator) {
			transformArrayConstructionOperator(context, targets, transformer, (ArrayConstructionOperator) expression);
		} else if (expression instanceof ArrayElementAccess) {
			transformArrayElementAccess(context, targets, transformer, (ArrayElementAccess) expression);
		} else if (expression instanceof StructConstructionOperator) {
			transformStructConstructionOperator(context, targets, transformer, (StructConstructionOperator) expression);
		} else if (expression instanceof MemberVariableAccess) {
			transformMemberVariableAccess(context, targets, transformer, (MemberVariableAccess) expression);
		} else if (expression instanceof ParenthesizedExpression) {
			transformParenthesizedExpression(context, targets, transformer, (ParenthesizedExpression) expression);
		} else if (expression instanceof TemplateExpression) {
			transformTemplateExpression(context, targets, transformer, (TemplateExpression) expression);
		} else {
			assignExpression(context, expression, EcoreUtil.copy(expression), targets);
		}
	}

	protected void transformLetExpression(ITransformerContext context, List<? extends IExpressionTarget> targets, IExpressionTransformer transformer, LetExpression letExpression) {
		LetExpression transformedLetExpression = MscriptFactory.eINSTANCE.createLetExpression();
		
		transformedLetExpression.setTarget(transformNext(context, letExpression.getTarget(), transformer));
		
		for (LetExpressionAssignment assignment : letExpression.getAssignments()) {
			LetExpressionAssignment transformedAssignment = MscriptFactory.eINSTANCE.createLetExpressionAssignment();
			
			transformedAssignment.setAssignedExpression(transformNext(context, assignment.getAssignedExpression(), transformer));
			
			for (LetExpressionVariableDeclaration variable : assignment.getVariables()) {
				LetExpressionVariableDeclaration transformedVariable = EcoreUtil.copy(variable);
				transformedAssignment.getVariables().add(transformedVariable);
				context.addVariableDeclarationMapping(variable, transformedVariable);
			}
		}
		
		assignExpression(context, letExpression, transformedLetExpression, targets);
	}
	
	protected void transformIfExpression(ITransformerContext context, List<? extends IExpressionTarget> targets, IExpressionTransformer transformer, IfExpression ifExpression) {
		IfExpression transformedIfExpression = MscriptFactory.eINSTANCE.createIfExpression();
		transformedIfExpression.setStatic(ifExpression.isStatic());
		
		transformedIfExpression.setCondition(transformNext(context, ifExpression.getCondition(), transformer));
		transformedIfExpression.setThenExpression(transformNext(context, ifExpression.getThenExpression(), transformer));
		transformedIfExpression.setElseExpression(transformNext(context, ifExpression.getElseExpression(), transformer));
		
		assignExpression(context, ifExpression, transformedIfExpression, targets);
	}
	
	protected void transformRangeExpression(ITransformerContext context, List<? extends IExpressionTarget> targets, IExpressionTransformer transformer, RangeExpression rangeExpression) {
		RangeExpression transformedRangeExpression = MscriptFactory.eINSTANCE.createRangeExpression();
		for (Expression operand : rangeExpression.getOperands()) {
			transformedRangeExpression.getOperands().add(transformNext(context, operand, transformer));
		}
		assignExpression(context, rangeExpression, transformedRangeExpression, targets);
	}
	
	protected void transformVariableReference(ITransformerContext context, List<? extends IExpressionTarget> targets, IExpressionTransformer transformer, VariableReference variableReference) {
		if (variableReference.getFeature() instanceof VariableDeclaration) {
			VariableDeclaration variableDeclaration = (VariableDeclaration) variableReference.getFeature();
			if (variableDeclaration != null) {
				int stepIndex = context.getStaticEvaluationResult().getStepIndex(variableReference);
				assignExpression(context, variableReference, MscriptUtil.createVariableReference(context.getStaticEvaluationResult(), context.mapVariableDeclaration(variableDeclaration), stepIndex, false), targets);
			}
		} else {
			assignExpression(context, variableReference, EcoreUtil.copy(variableReference), targets);
		}
	}

	protected void transformFunctionCall(ITransformerContext context, List<? extends IExpressionTarget> targets, IExpressionTransformer transformer, FunctionCall functionCall) {
		FunctionCall transformedFunctionCall = MscriptFactory.eINSTANCE.createFunctionCall();
		transformedFunctionCall.setFeature(functionCall.getFeature());
		for (Expression expression : functionCall.getArguments()) {
			Expression transformedExpression = transformNext(context, expression, transformer);
			if (transformedExpression instanceof InvalidExpression) {
				targets.get(0).assignExpression(transformedExpression);
				return;
			}
			transformedFunctionCall.getArguments().add(transformedExpression);
		}
		assignExpression(context, functionCall, transformedFunctionCall, targets);
	}
	
	protected void transformIterationCall(ITransformerContext context, List<? extends IExpressionTarget> targets, IExpressionTransformer transformer, IterationCall iterationCall) {
		IterationCall transformedIterationCall = MscriptFactory.eINSTANCE.createIterationCall();
		
		transformedIterationCall.setIdentifier(iterationCall.getIdentifier());
		transformedIterationCall.setTarget(transformNext(context, iterationCall.getTarget(), transformer));
		transformedIterationCall.setBreakCondition(transformNext(context, iterationCall.getBreakCondition(), transformer));
		transformedIterationCall.setExpression(transformNext(context, iterationCall.getExpression(), transformer));
		
		IterationAccumulator transformedAccumulator = MscriptFactory.eINSTANCE.createIterationAccumulator();
		transformedAccumulator.setName(iterationCall.getAccumulator().getName());
		transformedAccumulator.setInitializer(transformNext(context, iterationCall.getAccumulator().getInitializer(), transformer));
		context.addVariableDeclarationMapping(iterationCall.getAccumulator(), transformedAccumulator);
		
		for (IterationVariableDeclaration iterationVariable : iterationCall.getIterationVariables()) {
			IterationVariableDeclaration transformedIterationVariable = EcoreUtil.copy(iterationVariable);
			transformedIterationCall.getIterationVariables().add(transformedIterationVariable);
			context.addVariableDeclarationMapping(iterationVariable, transformedIterationVariable);
		}
		
		assignExpression(context, iterationCall, transformedIterationCall, targets);
	}
	
	protected void transformImpliesExpression(ITransformerContext context, List<? extends IExpressionTarget> targets, IExpressionTransformer transformer, ImpliesExpression impliesExpression) {
		ImpliesExpression transformedImpliesExpression = MscriptFactory.eINSTANCE.createImpliesExpression();
		
		Expression leftTransformedExpression = transformNext(context, impliesExpression.getLeftOperand(), transformer);
		Expression rightTransformedExpression = transformNext(context, impliesExpression.getRightOperand(), transformer);
		
		transformedImpliesExpression.setLeftOperand(leftTransformedExpression);
		transformedImpliesExpression.setRightOperand(rightTransformedExpression);
		
		assignExpression(context, impliesExpression, transformedImpliesExpression, targets);
	}
	
	protected void transformLogicalOrExpression(ITransformerContext context, List<? extends IExpressionTarget> targets, IExpressionTransformer transformer, LogicalOrExpression logicalOrExpression) {
		LogicalOrExpression transformedExpression = MscriptFactory.eINSTANCE.createLogicalOrExpression();
		transformedExpression.setLeftOperand(transformNext(context, logicalOrExpression.getLeftOperand(), transformer));
		transformedExpression.setRightOperand(transformNext(context, logicalOrExpression.getRightOperand(), transformer));
		assignExpression(context, logicalOrExpression, transformedExpression, targets);
	}
	
	protected void transformLogicalAndExpression(ITransformerContext context, List<? extends IExpressionTarget> targets, IExpressionTransformer transformer, LogicalAndExpression logicalAndExpression) {
		LogicalAndExpression transformedExpression = MscriptFactory.eINSTANCE.createLogicalAndExpression();
		transformedExpression.setLeftOperand(transformNext(context, logicalAndExpression.getLeftOperand(), transformer));
		transformedExpression.setRightOperand(transformNext(context, logicalAndExpression.getRightOperand(), transformer));
		assignExpression(context, logicalAndExpression, transformedExpression, targets);
	}
	
	protected void transformEqualityExpression(ITransformerContext context, List<? extends IExpressionTarget> targets, IExpressionTransformer transformer, EqualityExpression equalityExpression) {
		EqualityExpression transformedExpression = MscriptFactory.eINSTANCE.createEqualityExpression();
		transformedExpression.setOperator(equalityExpression.getOperator());
		
		Expression leftExpression = transformNext(context, equalityExpression.getLeftOperand(), transformer);
		transformedExpression.setLeftOperand(leftExpression);
		Expression rightExpression = transformNext(context, equalityExpression.getRightOperand(), transformer);
		transformedExpression.setRightOperand(rightExpression);

		assignExpression(context, equalityExpression, transformedExpression, targets);
	}
	
	protected void transformRelationalExpression(ITransformerContext context, List<? extends IExpressionTarget> targets, IExpressionTransformer transformer, RelationalExpression relationalExpression) {
		RelationalExpression transformedExpression = MscriptFactory.eINSTANCE.createRelationalExpression();
		transformedExpression.setOperator(relationalExpression.getOperator());
		
		Expression leftExpression = transformNext(context, relationalExpression.getLeftOperand(), transformer);
		transformedExpression.setLeftOperand(leftExpression);
		Expression rightExpression = transformNext(context, relationalExpression.getRightOperand(), transformer);
		transformedExpression.setRightOperand(rightExpression);

		assignExpression(context, relationalExpression, transformedExpression, targets);
	}
	
	protected void transformAdditiveExpression(ITransformerContext context, List<? extends IExpressionTarget> targets, IExpressionTransformer transformer, AdditiveExpression additiveExpression) {
		AdditiveExpression transformedExpression = MscriptFactory.eINSTANCE.createAdditiveExpression();
		transformedExpression.setOperator(additiveExpression.getOperator());
		transformedExpression.setLeftOperand(transformNext(context, additiveExpression.getLeftOperand(), transformer));
		transformedExpression.setRightOperand(transformNext(context, additiveExpression.getRightOperand(), transformer));
		assignExpression(context, additiveExpression, transformedExpression, targets);
	}
	
	protected void transformMultiplicativeExpression(ITransformerContext context, List<? extends IExpressionTarget> targets, IExpressionTransformer transformer, MultiplicativeExpression multiplicativeExpression) {
		MultiplicativeExpression transformedExpression = MscriptFactory.eINSTANCE.createMultiplicativeExpression();
		transformedExpression.setOperator(multiplicativeExpression.getOperator());
		transformedExpression.setLeftOperand(transformNext(context, multiplicativeExpression.getLeftOperand(), transformer));
		transformedExpression.setRightOperand(transformNext(context, multiplicativeExpression.getRightOperand(), transformer));
		assignExpression(context, multiplicativeExpression, transformedExpression, targets);
	}
	
	protected void transformTypeTestExpression(ITransformerContext context, List<? extends IExpressionTarget> targets, IExpressionTransformer transformer, TypeTestExpression typeTestExpression) {
		TypeTestExpression transformedTypeTestExpression = MscriptFactory.eINSTANCE.createTypeTestExpression();
		Expression expression = transformNext(context, typeTestExpression.getExpression(), transformer);
		transformedTypeTestExpression.setExpression(expression);
		transformedTypeTestExpression.setTypeSpecifier(EcoreUtil.copy(typeTestExpression.getTypeSpecifier()));
		assignExpression(context, expression, transformedTypeTestExpression, targets);
	}
	
	protected void transformUnaryExpression(ITransformerContext context, List<? extends IExpressionTarget> targets, IExpressionTransformer transformer, UnaryExpression unaryExpression) {
		UnaryExpression transformedExpression = MscriptFactory.eINSTANCE.createUnaryExpression();
		transformedExpression.setOperator(unaryExpression.getOperator());
		Expression expression = transformNext(context, unaryExpression.getOperand(), transformer);
		transformedExpression.setOperand(expression);
		assignExpression(context, expression, transformedExpression, targets);
	}
	
	protected void transformPowerExpression(ITransformerContext context, List<? extends IExpressionTarget> targets, IExpressionTransformer transformer, PowerExpression powerExpression) {
		PowerExpression transformedExpression = MscriptFactory.eINSTANCE.createPowerExpression();
		transformedExpression.setOperand(transformNext(context, powerExpression.getOperand(), transformer));
		transformedExpression.setExponent(transformNext(context, powerExpression.getExponent(), transformer));
		transformedExpression.setOperator(powerExpression.getOperator());
		assignExpression(context, powerExpression, transformedExpression, targets);
	}
	
	protected void transformArrayConstructionOperator(ITransformerContext context, List<? extends IExpressionTarget> targets, IExpressionTransformer transformer, ArrayConstructionOperator arrayConstructionOperator) {
		ArrayConstructionOperator transformedExpression = MscriptFactory.eINSTANCE.createArrayConstructionOperator();
		for (Expression expression : arrayConstructionOperator.getExpressions()) {
			transformedExpression.getExpressions().add(transformNext(context, expression, transformer));
		}
		for (ArrayConstructionIterationClause iterationClause : arrayConstructionOperator.getIterationClauses()) {
			Expression transformedCollectionExpression = transformNext(context, iterationClause.getCollectionExpression(), transformer);
			ArrayConstructionIterationClause transformedIterationClause = MscriptFactory.eINSTANCE.createArrayConstructionIterationClause();
			transformedIterationClause.setIterationVariable(EcoreUtil.copy(iterationClause.getIterationVariable()));
			transformedIterationClause.setCollectionExpression(transformedCollectionExpression);
			transformedExpression.getIterationClauses().add(transformedIterationClause);
		}
		assignExpression(context, arrayConstructionOperator, transformedExpression, targets);
	}
	
	protected void transformArrayElementAccess(ITransformerContext context, List<? extends IExpressionTarget> targets, IExpressionTransformer transformer, ArrayElementAccess arrayElementAccess) {
		ArrayElementAccess transformedAccess = MscriptFactory.eINSTANCE.createArrayElementAccess();
		transformedAccess.setArray(transformNext(context, arrayElementAccess.getArray(), transformer));
		for (ArraySubscript arraySubscript : arrayElementAccess.getSubscripts()) {
			Expression transformedExpression = transformNext(context, arraySubscript.getExpression(), transformer);
			ArraySubscript subscript = MscriptFactory.eINSTANCE.createArraySubscript();
			subscript.setExpression(transformedExpression);
			transformedAccess.getSubscripts().add(subscript);
		}
		assignExpression(context, arrayElementAccess, transformedAccess, targets);
	}
	
	protected void transformStructConstructionOperator(ITransformerContext context, List<? extends IExpressionTarget> targets, IExpressionTransformer transformer, StructConstructionOperator structConstructionOperator) {
		StructConstructionOperator transformedStructConstructionOperator = MscriptFactory.eINSTANCE.createStructConstructionOperator();
		for (StructConstructionMember member : structConstructionOperator.getMembers()) {
			StructConstructionMember transformedMember = MscriptFactory.eINSTANCE.createStructConstructionMember();
			transformedMember.setName(member.getName());
			transformedMember.setValue(transformNext(context, member.getValue(), transformer));
			transformedStructConstructionOperator.getMembers().add(transformedMember);
		}
		assignExpression(context, structConstructionOperator, transformedStructConstructionOperator, targets);
	}
	
	protected void transformMemberVariableAccess(ITransformerContext context, List<? extends IExpressionTarget> targets, IExpressionTransformer transformer, MemberVariableAccess memberVariableAccess) {
		MemberVariableAccess transformedMemberVariableAccess = MscriptFactory.eINSTANCE.createMemberVariableAccess();
		transformedMemberVariableAccess.setTarget(transformNext(context, memberVariableAccess.getTarget(), transformer));
		transformedMemberVariableAccess.setMemberVariable(memberVariableAccess.getMemberVariable());
		assignExpression(context, memberVariableAccess, transformedMemberVariableAccess, targets);
	}
	
	protected void transformParenthesizedExpression(ITransformerContext context, List<? extends IExpressionTarget> targets, IExpressionTransformer transformer, ParenthesizedExpression parenthesizedExpression) {
		ParenthesizedExpression transformedExpression = MscriptFactory.eINSTANCE.createParenthesizedExpression();
		Expression firstParenthesizedExpression = parenthesizedExpression.getExpressions().get(0);
		Expression transformedFirstParenthesizedExpression = transformNext(context, firstParenthesizedExpression, transformer);
		transformedExpression.getExpressions().add(transformedFirstParenthesizedExpression);
		assignExpression(context, parenthesizedExpression, transformedExpression, targets);
	}
	
	protected void transformTemplateExpression(ITransformerContext context, List<? extends IExpressionTarget> targets, IExpressionTransformer transformer, TemplateExpression templateExpression) {
		TemplateExpression transformedTemplateExpression = MscriptFactory.eINSTANCE.createTemplateExpression();
		for (TemplateSegment segment : templateExpression.getSegments()) {
			if (segment instanceof ConstantTemplateSegment) {
				transformedTemplateExpression.getSegments().add(EcoreUtil.copy(segment));
			} else if (segment instanceof ExpressionTemplateSegment) {
				ExpressionTemplateSegment expressionTemplateSegment = (ExpressionTemplateSegment) segment;
				ExpressionTemplateSegment transformedTemplateSegment = MscriptFactory.eINSTANCE.createExpressionTemplateSegment();
				transformedTemplateSegment.setExpression(transformNext(context, expressionTemplateSegment.getExpression(), transformer));
				transformedTemplateExpression.getSegments().add(transformedTemplateSegment);
			} else {
				throw new IllegalArgumentException("Unknown template segment " + segment.getClass().getCanonicalName());
			}
		}
		assignExpression(context, templateExpression, transformedTemplateExpression, targets);
	}
	
	protected Expression transformNext(ITransformerContext context, Expression expression, IExpressionTransformer transformer) {
		InlineExpressionTarget target = new InlineExpressionTarget(context);
		transformer.transform(expression, target.asList());
		Expression transformedExpression = target.getAssignedExpression();
		IValue value = context.getStaticEvaluationResult().getValue(expression);
		if (value == null) {
			throw new IllegalStateException("No value set for expression");
		}
		context.getStaticEvaluationResult().setValue(transformedExpression, value);
		return transformedExpression;
	}
	
	protected void assignExpression(ITransformerContext context, Expression expression, Expression transformedExpression, List<? extends IExpressionTarget> targets) {
		IValue value = context.getStaticEvaluationResult().getValue(expression);
		if (value == null) {
			throw new IllegalStateException("No value set for expression");
		}
		context.getStaticEvaluationResult().setValue(transformedExpression, value);
		targets.get(0).assignExpression(transformedExpression);
	}
	
}
