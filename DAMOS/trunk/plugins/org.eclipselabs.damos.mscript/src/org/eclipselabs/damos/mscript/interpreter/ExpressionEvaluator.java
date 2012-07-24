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

package org.eclipselabs.damos.mscript.interpreter;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.mscript.AdditiveExpression;
import org.eclipselabs.damos.mscript.AnonymousTypeSpecifier;
import org.eclipselabs.damos.mscript.ArrayConcatenationOperator;
import org.eclipselabs.damos.mscript.ArrayConstructionIterationClause;
import org.eclipselabs.damos.mscript.ArrayConstructionOperator;
import org.eclipselabs.damos.mscript.ArrayDimension;
import org.eclipselabs.damos.mscript.ArrayElementAccess;
import org.eclipselabs.damos.mscript.ArraySubscript;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.BooleanLiteral;
import org.eclipselabs.damos.mscript.BooleanType;
import org.eclipselabs.damos.mscript.CallableElement;
import org.eclipselabs.damos.mscript.ConstantTemplateSegment;
import org.eclipselabs.damos.mscript.EndExpression;
import org.eclipselabs.damos.mscript.EqualityExpression;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.ExpressionList;
import org.eclipselabs.damos.mscript.ExpressionTemplateSegment;
import org.eclipselabs.damos.mscript.FunctionCall;
import org.eclipselabs.damos.mscript.IfExpression;
import org.eclipselabs.damos.mscript.ImpliesExpression;
import org.eclipselabs.damos.mscript.IntegerLiteral;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.InvalidType;
import org.eclipselabs.damos.mscript.LambdaExpression;
import org.eclipselabs.damos.mscript.LetExpression;
import org.eclipselabs.damos.mscript.LetExpressionAssignment;
import org.eclipselabs.damos.mscript.LogicalAndExpression;
import org.eclipselabs.damos.mscript.LogicalOrExpression;
import org.eclipselabs.damos.mscript.MemberVariableAccess;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.MultiplicativeExpression;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.ParenthesizedExpression;
import org.eclipselabs.damos.mscript.PowerExpression;
import org.eclipselabs.damos.mscript.RangeExpression;
import org.eclipselabs.damos.mscript.RealLiteral;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.RelationalExpression;
import org.eclipselabs.damos.mscript.StringLiteral;
import org.eclipselabs.damos.mscript.StringType;
import org.eclipselabs.damos.mscript.StructConstructionMember;
import org.eclipselabs.damos.mscript.StructConstructionOperator;
import org.eclipselabs.damos.mscript.StructMember;
import org.eclipselabs.damos.mscript.StructType;
import org.eclipselabs.damos.mscript.TemplateExpression;
import org.eclipselabs.damos.mscript.TemplateSegment;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.TypeTestExpression;
import org.eclipselabs.damos.mscript.UnaryExpression;
import org.eclipselabs.damos.mscript.Unit;
import org.eclipselabs.damos.mscript.UnitConstructionOperator;
import org.eclipselabs.damos.mscript.VariableReference;
import org.eclipselabs.damos.mscript.internal.MscriptPlugin;
import org.eclipselabs.damos.mscript.internal.builtin.BuiltinFunctionLookup;
import org.eclipselabs.damos.mscript.internal.builtin.IBuiltinFunction;
import org.eclipselabs.damos.mscript.internal.builtin.IBuiltinFunctionLookup;
import org.eclipselabs.damos.mscript.interpreter.value.AnyValue;
import org.eclipselabs.damos.mscript.interpreter.value.IArrayValue;
import org.eclipselabs.damos.mscript.interpreter.value.IBooleanValue;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.InvalidValue;
import org.eclipselabs.damos.mscript.interpreter.value.MatrixValue;
import org.eclipselabs.damos.mscript.interpreter.value.StringValue;
import org.eclipselabs.damos.mscript.interpreter.value.StructValue;
import org.eclipselabs.damos.mscript.interpreter.value.UnitValue;
import org.eclipselabs.damos.mscript.interpreter.value.Values;
import org.eclipselabs.damos.mscript.interpreter.value.VectorValue;
import org.eclipselabs.damos.mscript.util.MscriptSwitch;
import org.eclipselabs.damos.mscript.util.SyntaxStatus;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionEvaluator implements IExpressionEvaluator {
		
	public IValue evaluate(IExpressionEvaluationContext context, Expression expression) {
		return new ExpressionEvaluatorSwitch(context).evaluate(expression);
	}
	
	private static class ExpressionEvaluatorSwitch extends MscriptSwitch<IValue> {

		private final IBuiltinFunctionLookup builtinFunctionLookup = new BuiltinFunctionLookup();

		private final IExpressionEvaluationContext context;
		
		public ExpressionEvaluatorSwitch(IExpressionEvaluationContext context) {
			this.context = context;
		}

		public IValue evaluate(Expression expression) {
			IValue value = doEvaluate(expression);
			context.processValue(expression, value);
			return value;
		}

		/**
		 * @param expression
		 * @return
		 */
		protected IValue doEvaluate(Expression expression) {
			return doSwitch(expression);
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLetExpression(org.eclipselabs.mscript.language.ast.LetExpression)
		 */
		@Override
		public IValue caseLetExpression(LetExpression letExpression) {
			if (letExpression.getTarget() == null) {
				return InvalidValue.SINGLETON;
			}
			for (LetExpressionAssignment assignment : letExpression.getAssignments()) {
				Expression assignedExpression = assignment.getAssignedExpression();
				if (assignedExpression == null) {
					return InvalidValue.SINGLETON;
				}
				IValue value = evaluate(assignedExpression);
				context.processValue(assignment.getVariables().get(0), value);
			}
			return evaluate(letExpression.getTarget());
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIfExpression(org.eclipselabs.mscript.language.ast.IfExpression)
		 */
		@Override
		public IValue caseIfExpression(IfExpression ifExpression) {
			if (ifExpression.getCondition() == null || ifExpression.getThenExpression() == null || ifExpression.getElseExpression() == null) {
				return InvalidValue.SINGLETON;
			}
			
			if (ifExpression.isStatic()) {
				context.enterStaticScope();
			}
			IValue conditionValue = evaluate(ifExpression.getCondition());
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

			if (ifExpression.isStatic() || context.isStaticScope()) {
				if (conditionValue instanceof IBooleanValue) {
					boolean booleanValue = ((IBooleanValue) conditionValue).booleanValue();
					if (booleanValue) {
						return evaluate(ifExpression.getThenExpression());
					}
					return evaluate(ifExpression.getElseExpression());
				}
				if (context.getStatusCollector() != null) {
					context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "If expression condition within static scope must evaluate to boolean", ifExpression.getCondition()));
				}
				return InvalidValue.SINGLETON;
			}

			IValue thenValue = evaluate(ifExpression.getThenExpression());
			IValue elseValue = evaluate(ifExpression.getElseExpression());

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

			return new AnyValue(context.getComputationContext(), type);
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.util.MscriptSwitch#caseRangeExpression(org.eclipselabs.damos.mscript.RangeExpression)
		 */
		@Override
		public IValue caseRangeExpression(RangeExpression rangeExpression) {
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

			IValue startValue = evaluate(startExpression);
			IValue incrementValue = incrementExpression != null ? evaluate(incrementExpression) : null;
			IValue endValue = evaluate(endExpression);

			if (startValue instanceof InvalidValue || incrementValue instanceof InvalidValue || endValue instanceof InvalidValue) {
				return InvalidValue.SINGLETON;
			}

			boolean nonStatic = false;

			if (startValue instanceof AnyValue) {
				if (context.getStatusCollector() != null) {
					context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Start expression must be static", startExpression));
				}
				nonStatic = true;
			}

			if (incrementValue instanceof AnyValue) {
				if (context.getStatusCollector() != null) {
					context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Increment expression must be static", incrementExpression));
				}
				nonStatic = true;
			}

			if (endValue instanceof AnyValue) {
				if (context.getStatusCollector() != null) {
					context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "End expression must be static", endExpression));
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

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseImpliesExpression(org.eclipselabs.mscript.language.ast.ImpliesExpression)
		 */
		@Override
		public IValue caseImpliesExpression(ImpliesExpression impliesExpression) {
			if (impliesExpression.getLeftOperand() == null || impliesExpression.getRightOperand() == null) {
				return InvalidValue.SINGLETON;
			}
			
			IValue leftValue = evaluate(impliesExpression.getLeftOperand());

			if (leftValue instanceof InvalidValue) {
				return InvalidValue.SINGLETON;
			}

			if (context.isStaticScope() && leftValue instanceof IBooleanValue && !((IBooleanValue) leftValue).booleanValue()) {
				return Values.valueOf(context.getComputationContext(), true);
			}

			IValue rightValue = evaluate(impliesExpression.getRightOperand());

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

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLogicalOrExpression(org.eclipselabs.mscript.language.ast.LogicalOrExpression)
		 */
		@Override
		public IValue caseLogicalOrExpression(LogicalOrExpression logicalOrExpression) {
			if (logicalOrExpression.getLeftOperand() == null || logicalOrExpression.getRightOperand() == null) {
				return InvalidValue.SINGLETON;
			}
			
			IValue leftValue = evaluate(logicalOrExpression.getLeftOperand());

			if (leftValue instanceof InvalidValue) {
				return InvalidValue.SINGLETON;
			}

			if (context.isStaticScope() && leftValue instanceof IBooleanValue && ((IBooleanValue) leftValue).booleanValue()) {
				return Values.valueOf(context.getComputationContext(), true);
			}

			IValue rightValue = evaluate(logicalOrExpression.getRightOperand());

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

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLogicalAndExpression(org.eclipselabs.mscript.language.ast.LogicalAndExpression)
		 */
		@Override
		public IValue caseLogicalAndExpression(LogicalAndExpression logicalAndExpression) {
			if (logicalAndExpression.getLeftOperand() == null || logicalAndExpression.getRightOperand() == null) {
				return InvalidValue.SINGLETON;
			}
			
			IValue leftValue = evaluate(logicalAndExpression.getLeftOperand());

			if (leftValue instanceof InvalidValue) {
				return InvalidValue.SINGLETON;
			}

			if (context.isStaticScope() && leftValue instanceof IBooleanValue && !((IBooleanValue) leftValue).booleanValue()) {
				return Values.valueOf(context.getComputationContext(), false);
			}

			IValue rightValue = evaluate(logicalAndExpression.getRightOperand());

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

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseEqualityExpression(org.eclipselabs.mscript.language.ast.EqualityExpression)
		 */
		@Override
		public IValue caseEqualityExpression(EqualityExpression equalityExpression) {
			if (equalityExpression.getLeftOperand() == null || equalityExpression.getRightOperand() == null) {
				return InvalidValue.SINGLETON;
			}
			
			IValue leftValue = evaluate(equalityExpression.getLeftOperand());
			IValue rightValue = evaluate(equalityExpression.getRightOperand());

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

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRelationalExpression(org.eclipselabs.mscript.language.ast.RelationalExpression)
		 */
		@Override
		public IValue caseRelationalExpression(RelationalExpression relationalExpression) {
			if (relationalExpression.getLeftOperand() == null || relationalExpression.getRightOperand() == null) {
				return InvalidValue.SINGLETON;
			}

			IValue leftValue = evaluate(relationalExpression.getLeftOperand());
			IValue rightValue = evaluate(relationalExpression.getRightOperand());

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

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseTypeTestExpression(org.eclipselabs.mscript.language.ast.TypeTestExpression)
		 */
		@Override
		public IValue caseTypeTestExpression(TypeTestExpression typeTestExpression) {
			if (typeTestExpression.getExpression() == null || typeTestExpression.getTypeSpecifier() == null) {
				return InvalidValue.SINGLETON;
			}
			IValue value = evaluate(typeTestExpression.getExpression());
			if (value instanceof InvalidValue) {
				return value;
			}
			Type type = typeTestExpression.getTypeSpecifier().getType();
			return Values.valueOf(context.getComputationContext(), type.isAssignableFrom(value.getDataType()));
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseAdditiveExpression(org.eclipselabs.mscript.language.ast.AdditiveExpression)
		 */
		@Override
		public IValue caseAdditiveExpression(AdditiveExpression additiveExpression) {
			if (additiveExpression.getLeftOperand() == null || additiveExpression.getRightOperand() == null) {
				return InvalidValue.SINGLETON;
			}
			
			IValue leftValue = evaluate(additiveExpression.getLeftOperand());
			IValue rightValue = evaluate(additiveExpression.getRightOperand());

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

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseMultiplicativeExpression(org.eclipselabs.mscript.language.ast.MultiplicativeExpression)
		 */
		@Override
		public IValue caseMultiplicativeExpression(MultiplicativeExpression multiplicativeExpression) {
			if (multiplicativeExpression.getLeftOperand() == null || multiplicativeExpression.getRightOperand() == null) {
				return InvalidValue.SINGLETON;
			}

			IValue leftValue = evaluate(multiplicativeExpression.getLeftOperand());
			IValue rightValue = evaluate(multiplicativeExpression.getRightOperand());

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

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseUnaryExpression(org.eclipselabs.mscript.language.ast.UnaryExpression)
		 */
		@Override
		public IValue caseUnaryExpression(UnaryExpression unaryExpression) {
			if (unaryExpression.getOperand() == null) {
				return InvalidValue.SINGLETON;
			}
			
			IValue operandValue = evaluate(unaryExpression.getOperand());
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

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseArrayConstructionOperator(org.eclipselabs.mscript.language.ast.ArrayConstructionOperator)
		 */
		@Override
		public IValue caseArrayConstructionOperator(ArrayConstructionOperator arrayConstructionOperator) {
			boolean anyValue = false;
			IValue[] elements = null;
			
			if (!arrayConstructionOperator.getIterationClauses().isEmpty()) {
				if (arrayConstructionOperator.getIterationClauses().size() > 1) {
					if (context.getStatusCollector() != null) {
						context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Only one iteration clause supported", arrayConstructionOperator));
					}
					return InvalidValue.SINGLETON;
				}
				
				ArrayConstructionIterationClause clause = arrayConstructionOperator.getIterationClauses().get(0);
				
				if (clause.getCollectionExpression() == null || clause.getIterationVariable() == null) {
					return InvalidValue.SINGLETON;
				}
				
				IValue collectionValue = evaluate(clause.getCollectionExpression());
				if (collectionValue instanceof InvalidValue) {
					return InvalidValue.SINGLETON;
				}
				
				if (!(collectionValue.getDataType() instanceof ArrayType) || ((ArrayType) collectionValue.getDataType()).getDimensionality() != 1) {
					if (context.getStatusCollector() != null) {
						context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Iteration expression must be vector", clause.getCollectionExpression()));
					}
					return InvalidValue.SINGLETON;
				}
				
				ArrayType collectionType = (ArrayType) collectionValue.getDataType();
				int size = TypeUtil.getArraySize(collectionType);

				if (collectionValue instanceof VectorValue) {
					VectorValue vectorValue = (VectorValue) collectionValue;
					elements = new IValue[vectorValue.getSize()];
					for (int i = 0; i < vectorValue.getSize(); ++i) {
						context.enterVariableScope();
						context.addVariable(new IteratorVariable(clause.getIterationVariable(), vectorValue.get(i)));
						elements[i] = doEvaluate(arrayConstructionOperator.getExpressions().get(0));
						context.leaveVariableScope();
						if (elements[i] instanceof InvalidValue) {
							return InvalidValue.SINGLETON;
						}
						if (elements[i] instanceof AnyValue) {
							anyValue = true;
						}
					}
				} else {
					elements = new IValue[size];
					for (int i = 0; i < size; ++i) {
						context.enterVariableScope();
						context.addVariable(new IteratorVariable(clause.getIterationVariable(), new AnyValue(context.getComputationContext(), EcoreUtil.copy(collectionType.getElementType()))));
						elements[i] = doEvaluate(arrayConstructionOperator.getExpressions().get(0));
						context.leaveVariableScope();
						if (elements[i] instanceof InvalidValue) {
							return InvalidValue.SINGLETON;
						}
						if (elements[i] instanceof AnyValue) {
							anyValue = true;
						}
					}
				}
			} else {
				int size = arrayConstructionOperator.getExpressions().size();
	
				elements = new IValue[size];
	
				{
					int i = 0;
					for (Expression expression : arrayConstructionOperator.getExpressions()) {
						IValue value = evaluate(expression);
						if (value instanceof InvalidValue) {
							return value;
						}
						if (value instanceof AnyValue) {
							anyValue = true;
						}
						elements[i++] = value;
					}
				}
			}

			if (anyValue) {
				for (int i = 0; i < elements.length; ++i) {
					if (!(elements[i] instanceof AnyValue)) {
						elements[i] = new AnyValue(context.getComputationContext(), elements[i].getDataType());
					}
				}
			}

			ArrayType arrayType = createArrayType(elements);

			if (arrayType == null) {
				if (context.getStatusCollector() != null) {
					context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Incompatible array construction elements", arrayConstructionOperator));
				}
				return InvalidValue.SINGLETON;
			}

			// Vector
			if (arrayType.getDimensionality() == 1) {
				context.processValue(arrayType.getDimensions().get(0).getSize(), Values.valueOf(context.getComputationContext(), TypeUtil.createIntegerType(), elements.length));
		
				if (anyValue) {
					return new AnyValue(context.getComputationContext(), arrayType);
				}
		
				return new VectorValue(context.getComputationContext(), arrayType, elements);
			}
			
			// Matrix
			int rowSize = TypeUtil.getArrayRowSize(arrayType);
			context.processValue(arrayType.getDimensions().get(0).getSize(), Values.valueOf(context.getComputationContext(), TypeUtil.createIntegerType(), rowSize));
			int columnSize = TypeUtil.getArrayColumnSize(arrayType);
			context.processValue(arrayType.getDimensions().get(1).getSize(), Values.valueOf(context.getComputationContext(), TypeUtil.createIntegerType(), columnSize));
			
			if (anyValue) {
				return new AnyValue(context.getComputationContext(), arrayType);
			}

			IValue[][] values = new IValue[rowSize][columnSize];
			for (int i = 0; i < rowSize; ++i) {
				for (int j = 0; j < columnSize; ++j) {
					values[i][j] = ((IArrayValue) elements[i]).get(j);
				}
			}
			return new MatrixValue(context.getComputationContext(), arrayType, values);
		}

		private ArrayType createArrayType(IValue[] elements) {
			Type elementType = null;

			for (IValue elementValue : elements) {
				Type type = elementValue.getDataType();

				if (type == null || type instanceof InvalidType) {
					return null;
				}

				if (elementType != null && !elementType.isEquivalentTo(type)) {
					Type leftHandDataType = TypeUtil.getLeftHandDataType(elementType, type);
					if (leftHandDataType == null) {
						return null;
					}
					type = leftHandDataType;
				}

				elementType = type;
			}
			
			if (elementType instanceof ArrayType) {
				ArrayType elementArrayType = (ArrayType) elementType;
				if (elementArrayType.getDimensionality() != 1) {
					// We do not support tensors yet
					return null;
				}
				return TypeUtil.createArrayType(EcoreUtil.copy(elementArrayType.getElementType()), elements.length, TypeUtil.getArraySize(elementArrayType));
			}

			return TypeUtil.createArrayType(EcoreUtil.copy(elementType), elements.length);
		}

		@Override
		public IValue caseArrayConcatenationOperator(ArrayConcatenationOperator arrayConcatenationOperator) {
			int rowSize = arrayConcatenationOperator.getRows().size();
			int columnSize = -1;

			for (ExpressionList expressionList : arrayConcatenationOperator.getRows()) {
				if (columnSize == -1) {
					columnSize = expressionList.getExpressions().size();
				} else if (columnSize < expressionList.getExpressions().size()) {
					columnSize = expressionList.getExpressions().size();
				}
			}

			IValue[][] matrix = new IValue[rowSize][columnSize];

			int row = 0;
			for (ExpressionList expressionList : arrayConcatenationOperator.getRows()) {
				int column = 0;
				for (Expression expression : expressionList.getExpressions()) {
					matrix[row][column] = evaluate(expression);
					++column;
				}
				++row;
			}

			IValue result = processMatrix(matrix, rowSize, columnSize);
			if (result instanceof InvalidValue) {
				if (context.getStatusCollector() != null) {
					context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Invalid matrix operation", arrayConcatenationOperator));
				}
			}
			return result;
		}

		public IValue processMatrix(IValue[][] matrix, int rowSize, int columnSize) {
			return InvalidValue.SINGLETON;
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.util.MscriptSwitch#caseStructConstructionOperator(org.eclipselabs.damos.mscript.StructConstructionOperator)
		 */
		@Override
		public IValue caseStructConstructionOperator(StructConstructionOperator structConstructionOperator) {
			StructType structType = MscriptFactory.eINSTANCE.createStructType();
			structType.setLabel(structConstructionOperator.getLabel());
			
			IValue[] values = new IValue[structConstructionOperator.getMembers().size()];

			boolean anyValue = false;

			{
				int i = 0;
				for (StructConstructionMember constructionMember : structConstructionOperator.getMembers()) {
					if (constructionMember.getValue() == null) {
						return InvalidValue.SINGLETON;
					}
					
					IValue value = evaluate(constructionMember.getValue());

					if (value instanceof InvalidValue) {
						return InvalidValue.SINGLETON;
					}

					if (value instanceof AnyValue) {
						anyValue = true;
					}

					StructMember member = MscriptFactory.eINSTANCE.createStructMember();
					member.setName(constructionMember.getName());
					AnonymousTypeSpecifier dataTypeSpecifier = MscriptFactory.eINSTANCE.createAnonymousTypeSpecifier();
					dataTypeSpecifier.setType(EcoreUtil.copy(value.getDataType()));
					member.setTypeSpecifier(dataTypeSpecifier);
					structType.getMembers().add(member);

					values[i++] = value;
				}
			}

			if (anyValue) {
				for (int i = 0; i < values.length; ++i) {
					if (!(values[i] instanceof AnyValue)) {
						values[i] = new AnyValue(context.getComputationContext(), values[i].getDataType());
					}
				}
				return new AnyValue(context.getComputationContext(), structType);
			}

			return new StructValue(context.getComputationContext(), structType, values);
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseUnitConstructionOperator(org.eclipselabs.mscript.language.ast.UnitConstructionOperator)
		 */
		@Override
		public IValue caseUnitConstructionOperator(UnitConstructionOperator unitConstructionOperator) {
			if (unitConstructionOperator.getUnit() == null) {
				return InvalidValue.SINGLETON;
			}
			Unit unit = null;
			if (unitConstructionOperator.getUnit().getNumerator() != null) {
				unit = EcoreUtil.copy(unitConstructionOperator.getUnit());
			}
			return new UnitValue(context.getComputationContext(), unit);
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.util.MscriptSwitch#casePowerExpression(org.eclipselabs.damos.mscript.PowerExpression)
		 */
		@Override
		public IValue casePowerExpression(PowerExpression powerExpression) {
			if (powerExpression.getLeftOperand() == null || powerExpression.getRightOperand() == null) {
				return InvalidValue.SINGLETON;
			}
			
			IValue operandValue = evaluate(powerExpression.getLeftOperand());
			IValue exponentValue = evaluate(powerExpression.getRightOperand());

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

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseParenthesizedExpression(org.eclipselabs.mscript.language.ast.ParenthesizedExpression)
		 */
		@Override
		public IValue caseParenthesizedExpression(ParenthesizedExpression parenthesizedExpression) {
			EList<Expression> expressions = parenthesizedExpression.getExpressions();
			if (expressions.isEmpty()) {
				return InvalidValue.SINGLETON;
			}
			return evaluate(expressions.get(0));
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.util.MscriptSwitch#caseArrayElementAccess(org.eclipselabs.damos.mscript.ArrayElementAccess)
		 */
		@Override
		public IValue caseArrayElementAccess(ArrayElementAccess arrayElementAccess) {
			if (arrayElementAccess.getArray() == null) {
				return InvalidValue.SINGLETON;
			}
			
			IValue value = evaluate(arrayElementAccess.getArray());
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
					sizeValue = evaluate(sizeExpression);
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
	
				IValue subsciptValue = evaluate(subscript.getExpression());
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
						context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Array subscript array must be static", subscript));
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

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseVariableAccess(org.eclipselabs.mscript.language.ast.VariableAccess)
		 */
		@Override
		public IValue caseVariableReference(VariableReference variableReference) {
			if (variableReference.getFeature() == null || variableReference.getFeature().eIsProxy()) {
				return InvalidValue.SINGLETON;
			}
			IValue value = context.getValue(variableReference);
			if (value == null) {
				if (context.getStatusCollector() != null) {
					context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "No value set for " + variableReference.getFeature().getName(), variableReference));
				}
				value = InvalidValue.SINGLETON;
			}
			return value;
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.util.MscriptSwitch#caseMemberVariableAccess(org.eclipselabs.damos.mscript.MemberVariableAccess)
		 */
		@Override
		public IValue caseMemberVariableAccess(MemberVariableAccess memberVariableAccess) {
			if (memberVariableAccess.getTarget() == null) {
				return InvalidValue.SINGLETON;
			}
			
			IValue value = evaluate(memberVariableAccess.getTarget());
			if (value instanceof InvalidValue) {
				return InvalidValue.SINGLETON;
			}

			if (value == null) {
				if (context.getStatusCollector() != null) {
					context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "No value set for target", memberVariableAccess.getTarget()));
				}
				return InvalidValue.SINGLETON;
			}

			if (!(value.getDataType() instanceof StructType)) {
				if (context.getStatusCollector() != null) {
					context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Member variable access is only applicable to structs", memberVariableAccess, MscriptPackage.eINSTANCE.getMemberVariableAccess_MemberVariable()));
				}
				return InvalidValue.SINGLETON;
			}

			StructType structType = (StructType) value.getDataType();

			int memberIndex = structType.getMemberIndex(memberVariableAccess.getMemberVariable());
			if (memberIndex == -1) {
				if (context.getStatusCollector() != null) {
					context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, memberVariableAccess.getMemberVariable() + " is not a member variable", memberVariableAccess, MscriptPackage.eINSTANCE.getMemberVariableAccess_MemberVariable()));
				}
				return InvalidValue.SINGLETON;
			}

			if (value instanceof StructValue) {
				return ((StructValue) value).get(memberIndex);
			}

			return new AnyValue(context.getComputationContext(), EcoreUtil.copy(structType.getMembers().get(memberIndex).getTypeSpecifier().getType()));
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.il.util.FunctionModelSwitch#caseFunctionCall(org.eclipselabs.mscript.language.il.FunctionCall)
		 */
		@Override
		public IValue caseFunctionCall(FunctionCall functionCall) {
			CallableElement feature = functionCall.getFeature();
			if (feature == null || feature.eIsProxy() || feature.getName() == null) {
				return InvalidValue.SINGLETON;
			}
			
			IBuiltinFunction function = builtinFunctionLookup.getFunction(functionCall);
			if (function != null) {
				return function.call(context, functionCall);
			}
			
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "The function " + feature.getName() + " is not supported", functionCall));
			}
			
			return InvalidValue.SINGLETON;
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.util.MscriptSwitch#caseEndExpression(org.eclipselabs.damos.mscript.EndExpression)
		 */
		@Override
		public IValue caseEndExpression(EndExpression endExpression) {
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
				arrayValue = evaluate(arrayElementAccess.getArray());
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
				sizeValue = evaluate(sizeExpression);
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

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRealLiteral(org.eclipselabs.mscript.language.ast.RealLiteral)
		 */
		@Override
		public IValue caseRealLiteral(RealLiteral realLiteral) {
			RealType realType = MscriptFactory.eINSTANCE.createRealType();
			realType.setUnit(EcoreUtil.copy(realLiteral.getUnit()));
			return Values.valueOf(context.getComputationContext(), realType, realLiteral.getValue());
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIntegerLiteral(org.eclipselabs.mscript.language.ast.IntegerLiteral)
		 */
		@Override
		public IValue caseIntegerLiteral(IntegerLiteral integerLiteral) {
			IntegerType integerType = MscriptFactory.eINSTANCE.createIntegerType();
			integerType.setUnit(EcoreUtil.copy(integerLiteral.getUnit()));
			return Values.valueOf(context.getComputationContext(), integerType, integerLiteral.getValue());
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseBooleanLiteral(org.eclipselabs.mscript.language.ast.BooleanLiteral)
		 */
		@Override
		public IValue caseBooleanLiteral(BooleanLiteral booleanLiteral) {
			return Values.valueOf(context.getComputationContext(), booleanLiteral.isTrue());
		}

		@Override
		public IValue caseStringLiteral(StringLiteral stringLiteral) {
			return new StringValue(context.getComputationContext(), stringLiteral.getText());
		}
		
		@Override
		public IValue caseTemplateExpression(TemplateExpression templateExpression) {
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
					IValue value = evaluate(expressionSegment.getExpression());
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
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.util.MscriptSwitch#caseLambdaExpression(org.eclipselabs.damos.mscript.LambdaExpression)
		 */
		@Override
		public IValue caseLambdaExpression(LambdaExpression lambdaExpression) {
			return new AnyValue(context.getComputationContext(), MscriptFactory.eINSTANCE.createFunctionType());
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
		 */
		@Override
		public IValue defaultCase(EObject object) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Invalid expression", object));
			}
			return InvalidValue.SINGLETON;
		}
		
	}
	
}
