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

package org.eclipse.damos.mscript.interpreter;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.damos.mscript.AdditiveExpression;
import org.eclipse.damos.mscript.AlgorithmExpression;
import org.eclipse.damos.mscript.AnonymousTypeSpecifier;
import org.eclipse.damos.mscript.ArrayConcatenationOperator;
import org.eclipse.damos.mscript.ArrayConstructionOperator;
import org.eclipse.damos.mscript.ArrayDimension;
import org.eclipse.damos.mscript.ArrayElementAccess;
import org.eclipse.damos.mscript.ArraySubscript;
import org.eclipse.damos.mscript.ArrayType;
import org.eclipse.damos.mscript.BooleanLiteral;
import org.eclipse.damos.mscript.BooleanType;
import org.eclipse.damos.mscript.CallableElement;
import org.eclipse.damos.mscript.CompositeTypeMember;
import org.eclipse.damos.mscript.CompositeTypeMemberList;
import org.eclipse.damos.mscript.ConstantDeclaration;
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
import org.eclipse.damos.mscript.IntegerType;
import org.eclipse.damos.mscript.InvalidExpression;
import org.eclipse.damos.mscript.LambdaExpression;
import org.eclipse.damos.mscript.LetExpression;
import org.eclipse.damos.mscript.LetExpressionAssignment;
import org.eclipse.damos.mscript.LogicalAndExpression;
import org.eclipse.damos.mscript.LogicalOrExpression;
import org.eclipse.damos.mscript.MemberVariableAccess;
import org.eclipse.damos.mscript.MscriptFactory;
import org.eclipse.damos.mscript.MscriptPackage;
import org.eclipse.damos.mscript.MultiplicativeExpression;
import org.eclipse.damos.mscript.NumericType;
import org.eclipse.damos.mscript.OperatorKind;
import org.eclipse.damos.mscript.ParenthesizedExpression;
import org.eclipse.damos.mscript.PowerExpression;
import org.eclipse.damos.mscript.RangeExpression;
import org.eclipse.damos.mscript.RealLiteral;
import org.eclipse.damos.mscript.RealType;
import org.eclipse.damos.mscript.RecordConstructionMember;
import org.eclipse.damos.mscript.RecordConstructionOperator;
import org.eclipse.damos.mscript.RecordType;
import org.eclipse.damos.mscript.RelationalExpression;
import org.eclipse.damos.mscript.StringLiteral;
import org.eclipse.damos.mscript.StringType;
import org.eclipse.damos.mscript.SwitchExpression;
import org.eclipse.damos.mscript.TemplateExpression;
import org.eclipse.damos.mscript.TemplateSegment;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.TypeTestExpression;
import org.eclipse.damos.mscript.UnaryExpression;
import org.eclipse.damos.mscript.UnionConstructionOperator;
import org.eclipse.damos.mscript.UnionType;
import org.eclipse.damos.mscript.Unit;
import org.eclipse.damos.mscript.UnitConstructionOperator;
import org.eclipse.damos.mscript.internal.MscriptPlugin;
import org.eclipse.damos.mscript.interpreter.value.AnyValue;
import org.eclipse.damos.mscript.interpreter.value.IArrayValue;
import org.eclipse.damos.mscript.interpreter.value.IBooleanValue;
import org.eclipse.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.mscript.interpreter.value.InvalidValue;
import org.eclipse.damos.mscript.interpreter.value.MatrixValue;
import org.eclipse.damos.mscript.interpreter.value.RecordValue;
import org.eclipse.damos.mscript.interpreter.value.StringValue;
import org.eclipse.damos.mscript.interpreter.value.UnionValue;
import org.eclipse.damos.mscript.interpreter.value.UnitValue;
import org.eclipse.damos.mscript.interpreter.value.Values;
import org.eclipse.damos.mscript.interpreter.value.VectorValue;
import org.eclipse.damos.mscript.util.SyntaxStatus;
import org.eclipse.damos.mscript.util.TypeUtil;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xml.type.AnyType;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionEvaluator implements IExpressionEvaluator, IExpressionVisitor<IValue, IExpressionEvaluationContext> {
		
	private final ExpressionEvaluatorHelper expressionEvaluatorHelper = new ExpressionEvaluatorHelper();
	
	private final ICompoundStatementInterpreter compoundStatementInterpreter = new CompoundStatementInterpreter();

	public IValue evaluate(IExpressionEvaluationContext context, Expression expression) {
		IValue value = expression.accept(context, this);
		context.processValue(expression, value);
		return value;
	}
	
	public IValue visit(IExpressionEvaluationContext context, LetExpression letExpression) {
		if (letExpression.getTarget() == null) {
			return InvalidValue.SINGLETON;
		}
		for (LetExpressionAssignment assignment : letExpression.getAssignments()) {
			Expression assignedExpression = assignment.getAssignedExpression();
			if (assignedExpression == null) {
				return InvalidValue.SINGLETON;
			}
			IValue value = evaluate(context, assignedExpression);
			context.processValue(assignment.getVariables().get(0), value);
		}
		return evaluate(context, letExpression.getTarget());
	}

	public IValue visit(IExpressionEvaluationContext context, IfExpression ifExpression) {
		if (ifExpression.getCondition() == null || ifExpression.getThenExpression() == null || ifExpression.getElseExpression() == null) {
			return InvalidValue.SINGLETON;
		}
		
		if (ifExpression.isStatic()) {
			context.enterStaticScope();
		}
		IValue conditionValue = evaluate(context, ifExpression.getCondition());
		if (ifExpression.isStatic()) {
			context.leaveStaticScope();
		}

		if (conditionValue instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}

		if (!(conditionValue.getDataType() instanceof BooleanType)) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "If expression condition must evaluate to boolean type", ifExpression.getCondition()));
			}
			return InvalidValue.SINGLETON;
		}

		// TODO: 'context instanceof ExpressionEvaluationContext' should be replaced with a method in IExpressionEvaluationContext
		if (ifExpression.isStatic() || context instanceof ExpressionEvaluationContext) {
			if (conditionValue instanceof IBooleanValue) {
				boolean booleanValue = ((IBooleanValue) conditionValue).booleanValue();
				if (booleanValue) {
					return evaluate(context, ifExpression.getThenExpression());
				}
				return evaluate(context, ifExpression.getElseExpression());
			}
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "If expression condition within static scope must evaluate to boolean", ifExpression.getCondition()));
			}
			return InvalidValue.SINGLETON;
		}

		IValue thenValue = evaluate(context, ifExpression.getThenExpression());
		IValue elseValue = evaluate(context, ifExpression.getElseExpression());

		if (thenValue instanceof InvalidValue || elseValue instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}

		Type type = TypeUtil.getLeftHandDataType(thenValue.getDataType(), elseValue.getDataType());
		if (type == null) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Resulting data type is incompatible with else expression data type", ifExpression.getThenExpression()));
			}
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Resulting data type is incompatible with then expression data type", ifExpression.getElseExpression()));
			}
			return InvalidValue.SINGLETON;
		}
		
		if (conditionValue instanceof IBooleanValue) {
			boolean booleanValue = ((IBooleanValue) conditionValue).booleanValue();
			if (booleanValue) {
				return thenValue;
			}
			return elseValue;
		}

		return new AnyValue(context.getComputationContext(), type);
	}

	public IValue visit(IExpressionEvaluationContext context, InspectExpression inspectExpression) {
		IValue value = evaluate(context, inspectExpression.getUnionExpression());
		if (value instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}
		
		if (!(value.getDataType() instanceof UnionType)) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Inspect expression must result to union type", inspectExpression.getUnionExpression()));
			}
			return InvalidValue.SINGLETON;
		}
		
		UnionType unionType = (UnionType) value.getDataType();

		UnionValue unionValue = null;
		if (value instanceof UnionValue) {
			unionValue = (UnionValue) value;
		}

		boolean invalidValue = false;

		Type resultDataType = null;
		IValue resultValue = null;
		
		Set<CompositeTypeMember> members = new LinkedHashSet<CompositeTypeMember>(unionType.getMembers());
		
		for (InspectWhenClause whenClause : inspectExpression.getWhenClauses()) {
			CompositeTypeMember member = unionType.getMember(whenClause.getName());
			if (member != null) {
				members.remove(member);
				
				IValue memberValue;
				
				if (unionValue != null && unionType.getMembers().indexOf(member) == unionValue.getTag()) {
					memberValue = unionValue.getValue();
				} else {
					// This has to be improved
					if (context.getStatusCollector() == null) {
						continue;
					}
					memberValue = new AnyValue(context.getComputationContext(), member.getType());
				}
				
				context.enterVariableScope();
				context.addVariable(new IteratorVariable(whenClause, memberValue));
				IValue whenClauseResultValue = evaluate(context, whenClause.getExpression());
				context.leaveVariableScope();
				
				if (whenClauseResultValue instanceof InvalidValue) {
					invalidValue = true;
					continue;
				}
				
				if (!(whenClauseResultValue instanceof AnyValue)) {
					resultValue = whenClauseResultValue;
				}
				
				if (resultDataType == null) {
					resultDataType = whenClauseResultValue.getDataType();
				} else {
					resultDataType = TypeUtil.getLeftHandDataType(resultDataType, whenClauseResultValue.getDataType());
					if (resultDataType == null) {
						if (context.getStatusCollector() != null) {
							context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Incompatible data type with previous when clauses", whenClause.getExpression()));
						}
						invalidValue = true;
					}
				}
			} else {
				if (context.getStatusCollector() != null) {
					context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, whenClause.getName() + " is not member of union", whenClause, whenClause.getNameFeature()));
				}
				invalidValue = true;
			}
		}
		
		if (!members.isEmpty()) {
			if (context.getStatusCollector() != null) {
				StringBuilder message = new StringBuilder("Inspect expression does not handle member");
				if (members.size() > 1) {
					message.append("s");
				}
				message.append(" ");
				boolean first = true;
				for (CompositeTypeMember member : members) {
					if (first) {
						first = false;
					} else {
						message.append(", ");
					}
					message.append(member.getName());
				}
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, message.toString(), inspectExpression.getUnionExpression()));
			}
			invalidValue = true;
		}
		
		if (invalidValue) {
			return InvalidValue.SINGLETON;
		}
		
		if (resultValue == null) {
			resultValue = new AnyValue(context.getComputationContext(), resultDataType);
		}
		
		return resultValue;
	}

	public IValue visit(IExpressionEvaluationContext context, RangeExpression rangeExpression) {
		Expression startExpression = null;
		Expression incrementExpression = null;
		Expression endExpression = null;

		EList<Expression> operands = rangeExpression.getOperands();
		if (operands.size() == 2) {
			startExpression = operands.get(0);
			endExpression = operands.get(1);
		} else if (operands.size() == 3) {
			startExpression = operands.get(0);
			incrementExpression = operands.get(1);
			endExpression = operands.get(2);
		} else {
			return InvalidValue.SINGLETON;
		}

		IValue startValue = evaluate(context, startExpression);
		IValue incrementValue = incrementExpression != null ? evaluate(context, incrementExpression) : null;
		IValue endValue = evaluate(context, endExpression);

		if (startValue instanceof InvalidValue || incrementValue instanceof InvalidValue || endValue instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}

		boolean nonStatic = false;

		if (startValue instanceof AnyValue) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Start expression must be constant", startExpression));
			}
			nonStatic = true;
		}

		if (incrementValue instanceof AnyValue) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Increment expression must be constant", incrementExpression));
			}
			nonStatic = true;
		}

		if (endValue instanceof AnyValue) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "End expression must be constant", endExpression));
			}
			nonStatic = true;
		}

		if (nonStatic) {
			return InvalidValue.SINGLETON;
		}

		boolean nonNumeric = false;

		if (!(startValue instanceof ISimpleNumericValue)) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Start expression must be numeric", startExpression));
			}
			nonNumeric = true;
		}

		if (incrementValue != null && !(incrementValue instanceof ISimpleNumericValue)) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Increment expression must be numeric", incrementExpression));
			}
			nonNumeric = true;
		}

		if (!(endValue instanceof ISimpleNumericValue)) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "End expression must be numeric", endExpression));
			}
			nonNumeric = true;
		}

		if (nonNumeric) {
			return InvalidValue.SINGLETON;
		}

		Type type = startValue.getDataType();
		if (incrementValue != null && type != null) {
			type = TypeUtil.getLeftHandDataType(type, incrementValue.getDataType());
		}
		if (type != null) {
			type = TypeUtil.getLeftHandDataType(type, endValue.getDataType());
		}
		if (!(type instanceof NumericType)) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Incompatible data types in range expression", rangeExpression));
			}
			return InvalidValue.SINGLETON;
		}

		List<IValue> values = new ArrayList<IValue>();

		ISimpleNumericValue numericStartValue = (ISimpleNumericValue) startValue;
		ISimpleNumericValue numericIncrementValue = (ISimpleNumericValue) incrementValue;
		ISimpleNumericValue numericEndValue = (ISimpleNumericValue) endValue;

		if (type instanceof IntegerType) {
			long x = numericStartValue.longValue();
			long increment = incrementValue != null ? numericIncrementValue.longValue() : 1;
			long end = numericEndValue.longValue();
			if (increment > 0 && x <= end) {
				for (; x <= end; x += increment) {
					values.add(Values.valueOf(context.getComputationContext(), EcoreUtil.copy((NumericType) type), x));
				}
			} else if (increment < 0 && x >= end) {
				for (; x >= end; x += increment) {
					values.add(Values.valueOf(context.getComputationContext(), EcoreUtil.copy((NumericType) type), x));
				}
			}
		} else {
			double x = numericStartValue.doubleValue();
			double increment = incrementValue != null ? numericIncrementValue.doubleValue() : 1.0;
			double end = numericEndValue.doubleValue();
			if (increment > 0.0 && x <= end) {
				for (; x <= end; x += increment) {
					values.add(Values.valueOf(context.getComputationContext(), EcoreUtil.copy((NumericType) type), x));
				}
			} else if (increment < 0.0 && x >= end) {
				for (; x >= end; x += increment) {
					values.add(Values.valueOf(context.getComputationContext(), EcoreUtil.copy((NumericType) type), x));
				}
			}
		}

		return new VectorValue(context.getComputationContext(), TypeUtil.createArrayType(EcoreUtil.copy(type), values.size()), values.toArray(new IValue[values.size()]));
	}

	public IValue visit(IExpressionEvaluationContext context, ImpliesExpression impliesExpression) {
		if (impliesExpression.getLeftOperand() == null || impliesExpression.getRightOperand() == null) {
			return InvalidValue.SINGLETON;
		}
		
		IValue leftValue = evaluate(context, impliesExpression.getLeftOperand());

		if (leftValue instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}

		if (context.isStaticScope() && leftValue instanceof IBooleanValue && !((IBooleanValue) leftValue).booleanValue()) {
			return Values.valueOf(context.getComputationContext(), true);
		}

		IValue rightValue = evaluate(context, impliesExpression.getRightOperand());

		if (rightValue instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}

		if (leftValue instanceof IBooleanValue) {
			IBooleanValue leftBooleanValue = (IBooleanValue) leftValue;
			if (!leftBooleanValue.booleanValue()) {
				return Values.valueOf(context.getComputationContext(), true);
			}
			if (rightValue instanceof IBooleanValue) {
				IBooleanValue rightBooleanValue = (IBooleanValue) rightValue;
				return Values.valueOf(context.getComputationContext(), rightBooleanValue.booleanValue());
			}
		}

		if ((leftValue instanceof IBooleanValue || leftValue instanceof AnyValue) && leftValue.getDataType() instanceof BooleanType
				&& (rightValue instanceof IBooleanValue || rightValue instanceof AnyValue) && rightValue.getDataType() instanceof BooleanType) {
			return leftValue;
		}

		if (!(leftValue.getDataType() instanceof BooleanType)) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Implies expression left operand must result to boolean type", impliesExpression.getLeftOperand()));
			}
		}

		if (!(rightValue.getDataType() instanceof BooleanType)) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Implies expression right operand must result to boolean type", impliesExpression.getRightOperand()));
			}
		}

		return InvalidValue.SINGLETON;
	}

	public IValue visit(IExpressionEvaluationContext context, LogicalOrExpression logicalOrExpression) {
		if (logicalOrExpression.getLeftOperand() == null || logicalOrExpression.getRightOperand() == null) {
			return InvalidValue.SINGLETON;
		}
		
		IValue leftValue = evaluate(context, logicalOrExpression.getLeftOperand());

		if (leftValue instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}

		if (context.isStaticScope() && leftValue instanceof IBooleanValue && ((IBooleanValue) leftValue).booleanValue()) {
			return Values.valueOf(context.getComputationContext(), true);
		}

		IValue rightValue = evaluate(context, logicalOrExpression.getRightOperand());

		if (rightValue instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}

		if (leftValue instanceof IBooleanValue) {
			IBooleanValue leftBooleanValue = (IBooleanValue) leftValue;
			if (leftBooleanValue.booleanValue()) {
				return Values.valueOf(context.getComputationContext(), true);
			}
			if (rightValue instanceof IBooleanValue) {
				IBooleanValue rightBooleanValue = (IBooleanValue) rightValue;
				return Values.valueOf(context.getComputationContext(), rightBooleanValue.booleanValue());
			}
		}

		if ((leftValue instanceof IBooleanValue || leftValue instanceof AnyValue) && leftValue.getDataType() instanceof BooleanType
				&& (rightValue instanceof IBooleanValue || rightValue instanceof AnyValue) && rightValue.getDataType() instanceof BooleanType) {
			return leftValue;
		}

		if (!(leftValue.getDataType() instanceof BooleanType)) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Logical OR expression left operand must result to boolean type", logicalOrExpression.getLeftOperand()));
			}
		}

		if (!(rightValue.getDataType() instanceof BooleanType)) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Logical OR expression right operand must result to boolean type", logicalOrExpression.getRightOperand()));
			}
		}

		return InvalidValue.SINGLETON;
	}

	public IValue visit(IExpressionEvaluationContext context, LogicalAndExpression logicalAndExpression) {
		if (logicalAndExpression.getLeftOperand() == null || logicalAndExpression.getRightOperand() == null) {
			return InvalidValue.SINGLETON;
		}
		
		IValue leftValue = evaluate(context, logicalAndExpression.getLeftOperand());

		if (leftValue instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}

		if (context.isStaticScope() && leftValue instanceof IBooleanValue && !((IBooleanValue) leftValue).booleanValue()) {
			return Values.valueOf(context.getComputationContext(), false);
		}

		IValue rightValue = evaluate(context, logicalAndExpression.getRightOperand());

		if (rightValue instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}

		if (leftValue instanceof IBooleanValue) {
			IBooleanValue leftBooleanValue = (IBooleanValue) leftValue;
			if (!leftBooleanValue.booleanValue()) {
				return Values.valueOf(context.getComputationContext(), false);
			}
			if (rightValue instanceof IBooleanValue) {
				IBooleanValue rightBooleanValue = (IBooleanValue) rightValue;
				return Values.valueOf(context.getComputationContext(), rightBooleanValue.booleanValue());
			}
		}

		if ((leftValue instanceof IBooleanValue || leftValue instanceof AnyValue) && leftValue.getDataType() instanceof BooleanType
				&& (rightValue instanceof IBooleanValue || rightValue instanceof AnyValue) && rightValue.getDataType() instanceof BooleanType) {
			return leftValue;
		}

		if (!(leftValue.getDataType() instanceof BooleanType)) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Logical AND expression left operand must result to boolean type", logicalAndExpression.getLeftOperand()));
			}
		}

		if (!(rightValue.getDataType() instanceof BooleanType)) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Logical AND expression right operand must result to boolean type", logicalAndExpression.getRightOperand()));
			}
		}

		return InvalidValue.SINGLETON;
	}

	public IValue visit(IExpressionEvaluationContext context, EqualityExpression equalityExpression) {
		if (equalityExpression.getLeftOperand() == null || equalityExpression.getRightOperand() == null) {
			return InvalidValue.SINGLETON;
		}
		
		IValue leftValue = evaluate(context, equalityExpression.getLeftOperand());
		IValue rightValue = evaluate(context, equalityExpression.getRightOperand());

		if (leftValue instanceof InvalidValue || rightValue instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}

		IValue result;
		switch (equalityExpression.getOperator()) {
		case EQUAL_TO:
			result = leftValue.equalTo(rightValue);
			break;
		case NOT_EQUAL_TO:
			result = leftValue.notEqualTo(rightValue);
			break;
		default:
			throw new IllegalArgumentException();
		}

		if (result instanceof InvalidValue) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Invalid equality operation operands", equalityExpression));
			}
		}

		return result;
	}

	public IValue visit(IExpressionEvaluationContext context, RelationalExpression relationalExpression) {
		if (relationalExpression.getLeftOperand() == null || relationalExpression.getRightOperand() == null) {
			return InvalidValue.SINGLETON;
		}

		IValue leftValue = evaluate(context, relationalExpression.getLeftOperand());
		IValue rightValue = evaluate(context, relationalExpression.getRightOperand());

		if (leftValue instanceof InvalidValue || rightValue instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}

		IValue result;
		switch (relationalExpression.getOperator()) {
		case LESS_THAN:
			result = leftValue.lessThan(rightValue);
			break;
		case LESS_THAN_OR_EQUAL_TO:
			result = leftValue.lessThanOrEqualTo(rightValue);
			break;
		case GREATER_THAN:
			result = leftValue.greaterThan(rightValue);
			break;
		case GREATER_THAN_OR_EQUAL_TO:
			result = leftValue.greaterThanOrEqualTo(rightValue);
			break;
		default:
			throw new IllegalArgumentException();
		}

		if (result instanceof InvalidValue) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Invalid relational operation operands", relationalExpression));
			}
		}

		return result;
	}

	public IValue visit(IExpressionEvaluationContext context, TypeTestExpression typeTestExpression) {
		if (typeTestExpression.getExpression() == null || typeTestExpression.getTypeSpecifier() == null) {
			return InvalidValue.SINGLETON;
		}
		IValue value = evaluate(context, typeTestExpression.getExpression());
		if (value instanceof InvalidValue) {
			return value;
		}
		Type type = typeTestExpression.getTypeSpecifier().getType();
		return Values.valueOf(context.getComputationContext(), type.isAssignableFrom(value.getDataType()));
	}

	public IValue visit(IExpressionEvaluationContext context, AdditiveExpression additiveExpression) {
		if (additiveExpression.getLeftOperand() == null || additiveExpression.getRightOperand() == null) {
			return InvalidValue.SINGLETON;
		}
		
		IValue leftValue = evaluate(context, additiveExpression.getLeftOperand());
		IValue rightValue = evaluate(context, additiveExpression.getRightOperand());

		if (leftValue instanceof InvalidValue || rightValue instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}

		IValue result;

		switch (additiveExpression.getOperator()) {
		case ADD:
			result = leftValue.add(rightValue);
			break;
		case SUBTRACT:
			result = leftValue.subtract(rightValue);
			break;
		default:
			throw new IllegalArgumentException();
		}

		if (result instanceof InvalidValue) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Additive operation cannot not be performed on provided operands", additiveExpression));
			}
		}

		return result;
	}

	public IValue visit(IExpressionEvaluationContext context, MultiplicativeExpression multiplicativeExpression) {
		if (multiplicativeExpression.getLeftOperand() == null || multiplicativeExpression.getRightOperand() == null) {
			return InvalidValue.SINGLETON;
		}

		IValue leftValue = evaluate(context, multiplicativeExpression.getLeftOperand());
		IValue rightValue = evaluate(context, multiplicativeExpression.getRightOperand());

		if (leftValue instanceof InvalidValue || rightValue instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}

		IValue result;

		switch (multiplicativeExpression.getOperator()) {
		case MULTIPLY:
			result = leftValue.multiply(rightValue);
			break;
		case DIVIDE:
			result = leftValue.divide(rightValue);
			break;
		case MODULO:
			result = leftValue.modulo(rightValue);
			break;
		default:
			throw new IllegalArgumentException();
		}

		if (result instanceof InvalidValue) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Multiplicative operation cannot not be performed on provided operands", multiplicativeExpression));
			}
		}

		return result;
	}
	
	public IValue visit(IExpressionEvaluationContext context, UnaryExpression unaryExpression) {
		if (unaryExpression.getOperand() == null) {
			return InvalidValue.SINGLETON;
		}
		
		IValue operandValue = evaluate(context, unaryExpression.getOperand());
		if (operandValue instanceof InvalidValue) {
			return operandValue;
		}

		IValue result;

		switch (unaryExpression.getOperator()) {
		case NEGATE:
			result = operandValue.negate();
			break;
		case LOGICAL_NOT:
			if (operandValue instanceof IBooleanValue) {
				IBooleanValue booleanResult = (IBooleanValue) operandValue;
				result = Values.valueOf(context.getComputationContext(), !booleanResult.booleanValue());
			} else if (operandValue instanceof AnyValue && operandValue.getDataType() instanceof BooleanType) {
				result = operandValue;
			} else {
				result = InvalidValue.SINGLETON;
			}
			break;
		default:
			throw new IllegalArgumentException();
		}

		if (result instanceof InvalidValue) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Invalid unary operation operand", unaryExpression));
			}
		}

		return result;
	}

	public IValue visit(IExpressionEvaluationContext context, ArrayConstructionOperator arrayConstructionOperator) {
		int size = arrayConstructionOperator.getExpressions().size();
		IValue[] elements = new IValue[size];

		boolean anyValue = false;
		{
			int i = 0;
			for (Expression expression : arrayConstructionOperator.getExpressions()) {
				IValue value = evaluate(context, expression);
				if (value instanceof InvalidValue) {
					return value;
				}
				if (value instanceof AnyValue) {
					anyValue = true;
				}
				elements[i++] = value;
			}
		}

		return expressionEvaluatorHelper.createArrayValue(context, elements, anyValue, arrayConstructionOperator);
	}

	public IValue visit(IExpressionEvaluationContext context, ArrayConcatenationOperator arrayConcatenationOperator) {
		if (context.getStatusCollector() != null) {
			context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Array concatenation expression not supported", arrayConcatenationOperator));
		}
		return InvalidValue.SINGLETON;
//		int rowSize = arrayConcatenationOperator.getRows().size();
//		int columnSize = -1;
//
//		for (ExpressionList expressionList : arrayConcatenationOperator.getRows()) {
//			if (columnSize == -1) {
//				columnSize = expressionList.getExpressions().size();
//			} else if (columnSize < expressionList.getExpressions().size()) {
//				columnSize = expressionList.getExpressions().size();
//			}
//		}
//
//		IValue[][] matrix = new IValue[rowSize][columnSize];
//
//		int row = 0;
//		for (ExpressionList expressionList : arrayConcatenationOperator.getRows()) {
//			int column = 0;
//			for (Expression expression : expressionList.getExpressions()) {
//				matrix[row][column] = evaluate(context, expression);
//				++column;
//			}
//			++row;
//		}
//
//		IValue result = processMatrix(matrix, rowSize, columnSize);
//		if (result instanceof InvalidValue) {
//			if (context.getStatusCollector() != null) {
//				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Invalid matrix operation", arrayConcatenationOperator));
//			}
//		}
//		return result;
	}

//	private IValue processMatrix(IValue[][] matrix, int rowSize, int columnSize) {
//		return InvalidValue.SINGLETON;
//	}

	public IValue visit(IExpressionEvaluationContext context, RecordConstructionOperator recordConstructionOperator) {
		RecordType recordType = MscriptFactory.eINSTANCE.createRecordType();
		recordType.setLabel(recordConstructionOperator.getLabel());
		
		IValue[] values = new IValue[recordConstructionOperator.getMembers().size()];

		boolean anyValue = false;

		{
			int i = 0;
			for (RecordConstructionMember member : recordConstructionOperator.getMembers()) {
				if (member.getValue() == null) {
					return InvalidValue.SINGLETON;
				}
				
				IValue value = evaluate(context, member.getValue());

				if (value instanceof InvalidValue) {
					return InvalidValue.SINGLETON;
				}

				if (value instanceof AnyValue) {
					anyValue = true;
				}

				CompositeTypeMember compositeTypeMember = MscriptFactory.eINSTANCE.createCompositeTypeMember();
				compositeTypeMember.setName(member.getName());

				AnonymousTypeSpecifier dataTypeSpecifier = MscriptFactory.eINSTANCE.createAnonymousTypeSpecifier();
				dataTypeSpecifier.setType(EcoreUtil.copy(value.getDataType()));
				CompositeTypeMemberList compositeTypeMemberList = MscriptFactory.eINSTANCE.createCompositeTypeMemberList();
				compositeTypeMemberList.setTypeSpecifier(dataTypeSpecifier);
				compositeTypeMemberList.getMembers().add(compositeTypeMember);
				
				recordType.getMemberLists().add(compositeTypeMemberList);

				values[i++] = value;
			}
		}

		if (anyValue) {
			for (int i = 0; i < values.length; ++i) {
				if (!(values[i] instanceof AnyValue)) {
					values[i] = new AnyValue(context.getComputationContext(), values[i].getDataType());
				}
			}
			return new AnyValue(context.getComputationContext(), recordType);
		}

		return new RecordValue(context.getComputationContext(), recordType, values);
	}

	public IValue visit(IExpressionEvaluationContext context, UnionConstructionOperator unionConstructionOperator) {
		if (!isResolved(unionConstructionOperator.getTypeSpecifier())) {
			return InvalidValue.SINGLETON;
		}
		
		Type type = unionConstructionOperator.getTypeSpecifier().getType();
		
		if (!isResolved(type)) {
			return InvalidValue.SINGLETON;
		}
		
		if (!(type instanceof UnionType)) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Type must be union type", unionConstructionOperator.getTypeSpecifier()));
			}
			return InvalidValue.SINGLETON;
		}
		
		UnionType unionType = (UnionType) type;
		
		if (!isResolved(unionConstructionOperator.getMember())) {
			return InvalidValue.SINGLETON;
		}
		
		IValue value = evaluate(context, unionConstructionOperator.getValue());
		
		if (value instanceof InvalidValue) {
			return value;
		}
		
		if (!unionConstructionOperator.getMember().getType().isAssignableFrom(value.getDataType())) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Union value has incompatible data type", unionConstructionOperator.getValue()));
			}
			return InvalidValue.SINGLETON;
		}
		
		if (value instanceof AnyValue) {
			return new AnyValue(context.getComputationContext(), type);
		}
		
		return new UnionValue(context.getComputationContext(), unionType, unionType.getMembers().indexOf(unionConstructionOperator.getMember()), value.convert(unionConstructionOperator.getMember().getType()));
	}

	public IValue visit(IExpressionEvaluationContext context, UnitConstructionOperator unitConstructionOperator) {
		if (unitConstructionOperator.getUnit() == null) {
			return InvalidValue.SINGLETON;
		}
		Unit unit = EcoreUtil.copy(unitConstructionOperator.getUnit());
		return new UnitValue(context.getComputationContext(), unit);
	}

	public IValue visit(IExpressionEvaluationContext context, PowerExpression powerExpression) {
		if (powerExpression.getLeftOperand() == null || powerExpression.getRightOperand() == null) {
			return InvalidValue.SINGLETON;
		}
		
		IValue operandValue = evaluate(context, powerExpression.getLeftOperand());
		IValue exponentValue = evaluate(context, powerExpression.getRightOperand());

		if (operandValue instanceof InvalidValue || exponentValue instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}

		boolean failed = false;

		if (!(operandValue.getDataType() instanceof NumericType)) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Power operand must be numeric", powerExpression.getLeftOperand()));
			}
			failed = true;
		}

		if (!(exponentValue.getDataType() instanceof NumericType)) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Power exponent must be numeric", powerExpression.getRightOperand()));
			}
			failed = true;
		}

		if (failed) {
			return InvalidValue.SINGLETON;
		}

		NumericType operandType = (NumericType) operandValue.getDataType();
		NumericType exponentType = (NumericType) exponentValue.getDataType();

		boolean constantIntegerExponent = exponentType instanceof IntegerType && exponentValue instanceof ISimpleNumericValue;

		Unit dimensionlessUnit = TypeUtil.createUnit();

		if (!dimensionlessUnit.isEquivalentTo(operandType.getUnit(), true) && !constantIntegerExponent) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Power exponent must be integer constant if operand is dimensional", powerExpression.getRightOperand()));
			}
			failed = true;
		}

		if (!dimensionlessUnit.isEquivalentTo(exponentType.getUnit(), true)) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Power exponent must be dimensionless", powerExpression.getRightOperand()));
			}
			failed = true;
		}

		if (failed) {
			return InvalidValue.SINGLETON;
		}

		IValue result = null;
		if (operandValue instanceof ISimpleNumericValue && exponentValue instanceof ISimpleNumericValue) {
			result = operandValue.power(exponentValue);
		} else {
			Type type;
			if (constantIntegerExponent) {
				type = operandType.evaluate(OperatorKind.POWER, (int) ((ISimpleNumericValue) exponentValue).longValue());
			} else {
				RealType realType = MscriptFactory.eINSTANCE.createRealType();
				realType.setUnit(EcoreUtil.copy(operandType.getUnit()));
				type = realType;
			}
			result = new AnyValue(context.getComputationContext(), type);
		}

		return result;
	}

	public IValue visit(IExpressionEvaluationContext context, ParenthesizedExpression parenthesizedExpression) {
		EList<Expression> expressions = parenthesizedExpression.getExpressions();
		if (expressions.isEmpty()) {
			return InvalidValue.SINGLETON;
		}
		return evaluate(context, expressions.get(0));
	}

	public IValue visit(IExpressionEvaluationContext context, ArrayElementAccess arrayElementAccess) {
		if (arrayElementAccess.getArray() == null) {
			return InvalidValue.SINGLETON;
		}
		
		IValue value = evaluate(context, arrayElementAccess.getArray());
		if (value instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}

		if (value == null) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "No value set for array", arrayElementAccess.getArray()));
			}
			return InvalidValue.SINGLETON;
		}

		if (!(value.getDataType() instanceof ArrayType)) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Array element access is only applicable to arrays", arrayElementAccess));
			}
			return InvalidValue.SINGLETON;
		}

		ArrayType arrayType = (ArrayType) value.getDataType();

		EList<ArraySubscript> subscripts = arrayElementAccess.getSubscripts();
		EList<ArrayDimension> dimensions = arrayType.getDimensions();

		if (subscripts.size() != dimensions.size()) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Array subscript dimensionality must be " + dimensions.size(), arrayElementAccess));
			}
			return InvalidValue.SINGLETON;
		}

		boolean anyValue = !(value instanceof IArrayValue);

		boolean slice = false;
		int[][] sliceIndices = new int[subscripts.size()][];
		
		for (int i = 0; i < sliceIndices.length; ++i) {
			Expression sizeExpression = dimensions.get(i).getSize();
			if (sizeExpression == null) {
				return InvalidValue.SINGLETON;
			}
			
			IValue sizeValue = context.getValue(sizeExpression);
			
			// TODO: This has to be redesigned
			if (sizeValue == null) {
				sizeValue = evaluate(context, sizeExpression);
			}
			
			if (sizeValue == null || !(sizeValue.getDataType() instanceof IntegerType) || !(sizeValue instanceof ISimpleNumericValue)) {
				if (context.getStatusCollector() != null) {
					context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Invalid array size data type", arrayElementAccess));
				}
				return InvalidValue.SINGLETON;
			}

			int size = (int) ((ISimpleNumericValue) sizeValue).longValue();

			ArraySubscript subscript = subscripts.get(i);
			if (subscript.getExpression() == null) {
				if (context.getStatusCollector() != null) {
					context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Array subscript not set", subscript));
				}
				return InvalidValue.SINGLETON;
			}

			IValue subsciptValue = evaluate(context, subscript.getExpression());
			if (subsciptValue instanceof InvalidValue) {
				return InvalidValue.SINGLETON;
			}

			if (!(subsciptValue.getDataType() instanceof IntegerType || subsciptValue.getDataType() instanceof ArrayType)) {
				if (context.getStatusCollector() != null) {
					context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Array subscript data type must be integer or integer vector", subscript));
				}
				return InvalidValue.SINGLETON;
			}
			
			if (subsciptValue.getDataType() instanceof ArrayType && !(subsciptValue instanceof VectorValue)) {
				if (context.getStatusCollector() != null) {
					context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Array subscript array must be constant", subscript));
				}
				return InvalidValue.SINGLETON;
			}
			
			if (subsciptValue instanceof ISimpleNumericValue) {
				sliceIndices[i] = new int[] { (int) ((ISimpleNumericValue) subsciptValue).longValue() };
			} else if (subsciptValue instanceof VectorValue) {
				VectorValue vectorSubscriptValue = (VectorValue) subsciptValue;
				sliceIndices[i] = new int[vectorSubscriptValue.getSize()];
				for (int j = 0; j < vectorSubscriptValue.getSize(); ++j) {
					IValue sliceValue = vectorSubscriptValue.get(j);
					if (!(sliceValue instanceof ISimpleNumericValue)) {
						if (context.getStatusCollector() != null) {
							context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Array subscript array elements must be numeric", subscript));
						}
						return InvalidValue.SINGLETON;
					}
					sliceIndices[i][j] = (int) ((ISimpleNumericValue) sliceValue).longValue();
				}
				slice = true;
			} else {
				anyValue = true;
				continue;
			}

			for (int j = 0; j < sliceIndices[i].length; ++j) {
				int index = sliceIndices[i][j];
				if (index < 0) {
					if (context.getStatusCollector() != null) {
						context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Array subscript must be greater than or equal to 0", subscript));
					}
					return InvalidValue.SINGLETON;
				}
				if (index >= size) {
					if (context.getStatusCollector() != null) {
						context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Array subscript must be less than " + size, subscript));
					}
					return InvalidValue.SINGLETON;
				}
			}
		}
		
		if (slice) {
			int[] sizes = new int[subscripts.size()];
			for (int i = 0; i < sizes.length; ++i) {
				sizes[i] = sliceIndices[i].length;
			}
			ArrayType sliceType = TypeUtil.createArrayType(EcoreUtil.copy(arrayType.getElementType()), sizes);
			
			if (anyValue) {
				return new AnyValue(context.getComputationContext(), sliceType);
			}

			IArrayValue arrayValue = (IArrayValue) value;
			
			if (subscripts.size() == 1) {
				IValue[] elements = new IValue[sizes[0]];
				for (int i = 0; i < elements.length; ++i) {
					elements[i] = arrayValue.get(sliceIndices[0][i]);
				}
				return new VectorValue(context.getComputationContext(), sliceType, elements);
			}
			
			IValue[][] elements = new IValue[sizes[0]][sizes[1]];
			for (int i = 0; i < sizes[0]; ++i) {
				for (int j = 0; j < sizes[1]; ++j) {
					elements[i][j] = arrayValue.get(sliceIndices[0][i], sliceIndices[1][j]);
				}
			}
			return new MatrixValue(context.getComputationContext(), sliceType, elements);
		}

		if (anyValue) {
			return new AnyValue(context.getComputationContext(), EcoreUtil.copy(arrayType.getElementType()));
		}

		IArrayValue arrayValue = (IArrayValue) value;
		
		int[] indices = new int[sliceIndices.length];
		for (int i = 0; i < sliceIndices.length; ++i) {
			indices[i] = sliceIndices[i][0];
		}
		
		return arrayValue.get(indices);
	}

	public IValue visit(IExpressionEvaluationContext context, FeatureReference featureReference) {
		if (!isResolved(featureReference.getFeature())) {
			return InvalidValue.SINGLETON;
		}
		IValue value = context.getValue(featureReference);
		if (value == null) {
			if (featureReference.getFeature() instanceof ConstantDeclaration) {
				ConstantDeclaration constantDeclaration = (ConstantDeclaration) featureReference.getFeature();
				if (context.addVisitedEvaluable(constantDeclaration)) {
					value = evaluate(context, constantDeclaration.getInitializer());
					context.processValue(constantDeclaration, value);
					context.removeVisitedEvaluable(constantDeclaration);
					if (value instanceof AnyType) {
						if (context.getStatusCollector() != null) {
							context.getStatusCollector().collectStatus(
									new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0,
											"Value of constant " + featureReference.getFeature().getName()
													+ " could not be evaluated statically", featureReference));
						}
						value = InvalidValue.SINGLETON;
					}
				} else {
					value = InvalidValue.SINGLETON;
				}
			}
		}
		if (value == null) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "No value set for " + featureReference.getFeature().getName(), featureReference));
			}
			value = InvalidValue.SINGLETON;
		}
		return value;
	}

	public IValue visit(IExpressionEvaluationContext context, MemberVariableAccess memberVariableAccess) {
		if (memberVariableAccess.getTarget() == null) {
			return InvalidValue.SINGLETON;
		}
		
		IValue value = evaluate(context, memberVariableAccess.getTarget());
		if (value instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}

		if (value == null) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "No value set for target", memberVariableAccess.getTarget()));
			}
			return InvalidValue.SINGLETON;
		}

		if (!(value.getDataType() instanceof RecordType)) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Member variable access is only applicable to structs", memberVariableAccess, MscriptPackage.eINSTANCE.getMemberVariableAccess_MemberVariable()));
			}
			return InvalidValue.SINGLETON;
		}

		RecordType recordType = (RecordType) value.getDataType();

		int memberIndex = recordType.getMemberIndex(memberVariableAccess.getMemberVariable());
		if (memberIndex == -1) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, memberVariableAccess.getMemberVariable() + " is not a member variable", memberVariableAccess, MscriptPackage.eINSTANCE.getMemberVariableAccess_MemberVariable()));
			}
			return InvalidValue.SINGLETON;
		}

		if (value instanceof RecordValue) {
			return ((RecordValue) value).get(memberIndex);
		}

		return new AnyValue(context.getComputationContext(), EcoreUtil.copy(recordType.getMembers().get(memberIndex).getType()));
	}

	public IValue visit(IExpressionEvaluationContext context, FunctionCall functionCall) {
		CallableElement feature = functionCall.getFeature();
		if (!isResolved(feature) || feature.getName() == null) {
			return InvalidValue.SINGLETON;
		}
		
		IFunctionInvocationHandler functionInvocationHandler = context.getFunctionInvocationHandler();
		if (functionInvocationHandler != null) {
			return functionInvocationHandler.invokeFunction(context, functionCall).get(0);
		}
		
		if (context.getStatusCollector() != null) {
			context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "The function " + feature.getName() + " is not supported", functionCall));
		}
		
		return InvalidValue.SINGLETON;
	}

	public IValue visit(IExpressionEvaluationContext context, EndExpression endExpression) {
		EObject container = endExpression.eContainer();

		while (container != null && !(container instanceof ArraySubscript)) {
			container = container.eContainer();
		}

		if (!(container instanceof ArraySubscript && container.eContainer() instanceof ArrayElementAccess)) {
			return InvalidValue.SINGLETON;
		}

		ArraySubscript arraySubscript = (ArraySubscript) container;
		ArrayElementAccess arrayElementAccess = (ArrayElementAccess) container.eContainer();

		int dimension = arrayElementAccess.getSubscripts().indexOf(arraySubscript);

		IValue arrayValue = context.getValue(arrayElementAccess.getArray());
		if (arrayValue == null) {
			arrayValue = evaluate(context, arrayElementAccess.getArray());
		}

		if (arrayValue instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}

		if (!(arrayValue.getDataType() instanceof ArrayType)) {
			return InvalidValue.SINGLETON;
		}

		ArrayType arrayType = (ArrayType) arrayValue.getDataType();

		EList<ArrayDimension> dimensions = arrayType.getDimensions();
		if (dimension >= dimensions.size()) {
			return InvalidValue.SINGLETON;
		}

		Expression sizeExpression = dimensions.get(dimension).getSize();
		IValue sizeValue = context.getValue(sizeExpression);
		if (sizeValue == null) {
			sizeValue = evaluate(context, sizeExpression);
		}

		if (!(sizeValue instanceof ISimpleNumericValue)) {
			return InvalidValue.SINGLETON;
		}

		long size = ((ISimpleNumericValue) sizeValue).longValue();
		if (size == 0) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Array dimension must be greater than 0", endExpression));
			}
			return InvalidValue.SINGLETON;
		}

		return Values.valueOf(context.getComputationContext(), TypeUtil.createIntegerType(), size - 1);
	}

	public IValue visit(IExpressionEvaluationContext context, RealLiteral realLiteral) {
		RealType realType = MscriptFactory.eINSTANCE.createRealType();
		realType.setUnit(EcoreUtil.copy(realLiteral.getUnit()));
		return Values.valueOf(context.getComputationContext(), realType, realLiteral.getValue());
	}

	public IValue visit(IExpressionEvaluationContext context, IntegerLiteral integerLiteral) {
		IntegerType integerType = MscriptFactory.eINSTANCE.createIntegerType();
		integerType.setUnit(EcoreUtil.copy(integerLiteral.getUnit()));
		return Values.valueOf(context.getComputationContext(), integerType, integerLiteral.getValue());
	}

	public IValue visit(IExpressionEvaluationContext context, BooleanLiteral booleanLiteral) {
		return Values.valueOf(context.getComputationContext(), booleanLiteral.isTrue());
	}

	public IValue visit(IExpressionEvaluationContext context, StringLiteral stringLiteral) {
		return new StringValue(context.getComputationContext(), stringLiteral.getText());
	}

	public IValue visit(IExpressionEvaluationContext context, TemplateExpression templateExpression) {
		templateExpression.normalizeSegments();
		
		boolean pendingNewLine = false;
		boolean anyValue = false;
		
		StringBuilder sb = new StringBuilder();
		for (TemplateSegment segment : templateExpression.getSegments()) {
			if (segment instanceof ConstantTemplateSegment) {
				if (anyValue) {
					continue;
				}
				
				String text = ((ConstantTemplateSegment) segment).getNormalizedText();
				if (pendingNewLine && (text.length() == 0 || text.charAt(0) != '\n')) {
					sb.append('\n');
				}
				if (text.length() > 0) {
					sb.append(text);
				}
				pendingNewLine = false;
			} else if (segment instanceof ExpressionTemplateSegment) {
				if (pendingNewLine) {
					sb.append('\n');
					pendingNewLine = false;
				}

				ExpressionTemplateSegment expressionSegment = (ExpressionTemplateSegment) segment;
				IValue value = evaluate(context, expressionSegment.getExpression());
				if (value instanceof InvalidValue) {
					return InvalidValue.SINGLETON;
				}
				value = value.convert(MscriptFactory.eINSTANCE.createStringType());
				if (!(value.getDataType() instanceof StringType)) {
					if (context.getStatusCollector() != null) {
						context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Expression must result to string", expressionSegment.getExpression()));
					}
					return InvalidValue.SINGLETON;
				}
				
				if (anyValue) {
					continue;
				}
				
				if (value instanceof AnyValue) {
					anyValue = true;
					continue;
				}
				
				String text = value.toString();
				boolean newLine = false;
				for (int i = 0; i < text.length(); ++i) {
					if (newLine) {
						sb.append(expressionSegment.getIndentation());
					}
					char c = text.charAt(i);
					newLine = c == '\n';
					if (newLine && i == text.length() - 1) {
						pendingNewLine = true;
					} else {
						sb.append(c);
					}
				}
			} else {
				throw new IllegalStateException("Unknown string segment type " + segment.getClass().getCanonicalName());
			}
		}
		
		if (pendingNewLine) {
			sb.append('\n');
		}

		if (anyValue) {
			return new AnyValue(context.getComputationContext(), MscriptFactory.eINSTANCE.createStringType());
		}

		return new StringValue(context.getComputationContext(), sb.toString());
	}

	public IValue visit(IExpressionEvaluationContext context, LambdaExpression lambdaExpression) {
		return new AnyValue(context.getComputationContext(), MscriptFactory.eINSTANCE.createFunctionType());
	}

	public IValue visit(IExpressionEvaluationContext context, AlgorithmExpression algorithmExpression) {
		IValue returnValue = compoundStatementInterpreter.execute(((ExpressionEvaluationContext) context).getInterpreterContext(), algorithmExpression.getBody());
		if (returnValue == null) {
			return InvalidValue.SINGLETON;
		}
		return returnValue;
	}

	public IValue visit(IExpressionEvaluationContext context, SwitchExpression switchExpression) {
		if (context.getStatusCollector() != null) {
			context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Switch expression not supported", switchExpression));
		}
		return InvalidValue.SINGLETON;
	}
	
	public IValue visit(IExpressionEvaluationContext context, InvalidExpression invalidExpression) {
		return InvalidValue.SINGLETON;
	}

	private boolean isResolved(EObject eObject) {
		return eObject != null && !eObject.eIsProxy();
	}

}
