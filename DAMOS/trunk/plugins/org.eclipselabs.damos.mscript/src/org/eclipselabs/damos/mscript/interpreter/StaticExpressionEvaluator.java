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
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.mscript.AdditiveExpression;
import org.eclipselabs.damos.mscript.ArrayConcatenationOperator;
import org.eclipselabs.damos.mscript.ArrayConstructionOperator;
import org.eclipselabs.damos.mscript.ArrayDimension;
import org.eclipselabs.damos.mscript.ArrayElementAccess;
import org.eclipselabs.damos.mscript.ArraySubscript;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.BooleanLiteral;
import org.eclipselabs.damos.mscript.BooleanType;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.EqualityExpression;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.ExpressionList;
import org.eclipselabs.damos.mscript.FunctionCall;
import org.eclipselabs.damos.mscript.IfExpression;
import org.eclipselabs.damos.mscript.ImpliesExpression;
import org.eclipselabs.damos.mscript.IntegerLiteral;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.InvalidDataType;
import org.eclipselabs.damos.mscript.IterationCall;
import org.eclipselabs.damos.mscript.LetExpression;
import org.eclipselabs.damos.mscript.LetExpressionAssignment;
import org.eclipselabs.damos.mscript.LogicalAndExpression;
import org.eclipselabs.damos.mscript.LogicalOrExpression;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.MultiplicativeExpression;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.ParenthesizedExpression;
import org.eclipselabs.damos.mscript.PowerExpression;
import org.eclipselabs.damos.mscript.RealLiteral;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.RelationalExpression;
import org.eclipselabs.damos.mscript.StringLiteral;
import org.eclipselabs.damos.mscript.TensorType;
import org.eclipselabs.damos.mscript.TypeTestExpression;
import org.eclipselabs.damos.mscript.UnaryExpression;
import org.eclipselabs.damos.mscript.Unit;
import org.eclipselabs.damos.mscript.UnitConstructionOperator;
import org.eclipselabs.damos.mscript.VariableReference;
import org.eclipselabs.damos.mscript.builtin.BuiltinFunctionKind;
import org.eclipselabs.damos.mscript.internal.MscriptPlugin;
import org.eclipselabs.damos.mscript.internal.builtin.BuiltinFunctionLookupTable;
import org.eclipselabs.damos.mscript.internal.builtin.IBuiltinFunction;
import org.eclipselabs.damos.mscript.internal.builtin.IBuiltinFunctionLookupTable;
import org.eclipselabs.damos.mscript.interpreter.value.AnyValue;
import org.eclipselabs.damos.mscript.interpreter.value.ArrayValue;
import org.eclipselabs.damos.mscript.interpreter.value.IArrayValue;
import org.eclipselabs.damos.mscript.interpreter.value.IBooleanValue;
import org.eclipselabs.damos.mscript.interpreter.value.INumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.InvalidValue;
import org.eclipselabs.damos.mscript.interpreter.value.StringValue;
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
public class StaticExpressionEvaluator {

	public IStatus evaluate(IStaticEvaluationContext context, Expression expression) {
		return evaluate(context, expression, false);
	}
		
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IExpressionValueEvaluator#evaluate(org.eclipselabs.mscript.language.interpreter.IEvaluationContext, org.eclipselabs.mscript.language.ast.Expression)
	 */
	public IStatus evaluate(IStaticEvaluationContext context, Expression expression, boolean staticScope) {
		ExpressionValueEvaluatorSwitch expressionValueEvaluatorSwitch = new ExpressionValueEvaluatorSwitch(context, staticScope);
		expressionValueEvaluatorSwitch.evaluate(expression);
		return expressionValueEvaluatorSwitch.getStatus();
	}
	
	private static class ExpressionValueEvaluatorSwitch extends MscriptSwitch<IValue> {
		
		private boolean staticScope;
		
		private MultiStatus status = new MultiStatus(MscriptPlugin.PLUGIN_ID, 0, "Expression evaluation", null);

		private IStaticEvaluationContext context;
		
		private IBuiltinFunctionLookupTable builtinFunctionLookupTable = new BuiltinFunctionLookupTable();

		/**
		 * 
		 */
		public ExpressionValueEvaluatorSwitch(IStaticEvaluationContext context, boolean staticScope) {
			this.context = context;
			this.staticScope = staticScope;
		}
		
		/**
		 * @return the status
		 */
		public MultiStatus getStatus() {
			return status;
		}
		
		public IValue evaluate(Expression expression) {
			IValue value = doSwitch(expression);
			context.setValue(expression, value);
			return value;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLetExpression(org.eclipselabs.mscript.language.ast.LetExpression)
		 */
		@Override
		public IValue caseLetExpression(LetExpression letExpression) {
			for (LetExpressionAssignment assignment : letExpression.getAssignments()) {
				IValue value = evaluate(assignment.getAssignedExpression());
				context.setValue(assignment.getVariables().get(0), value);
			}
			return evaluate(letExpression.getTarget());
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIfExpression(org.eclipselabs.mscript.language.ast.IfExpression)
		 */
		@Override
		public IValue caseIfExpression(IfExpression ifExpression) {
			staticScope = ifExpression.isStatic();
			IValue conditionValue = evaluate(ifExpression.getCondition());
			staticScope = false;

			if (conditionValue instanceof InvalidValue) {
				return InvalidValue.SINGLETON;
			}
			
			if (!(conditionValue.getDataType() instanceof BooleanType)) {
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "If expression condition must evaluate to boolean type", ifExpression.getCondition()));
				return InvalidValue.SINGLETON;
			}

			if (ifExpression.isStatic()) {
				if (conditionValue instanceof IBooleanValue) {
					boolean booleanValue = ((IBooleanValue) conditionValue).booleanValue();
					if (booleanValue) {
						return evaluate(ifExpression.getThenExpression());
					}
					return evaluate(ifExpression.getElseExpression());
				}
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Static if expression condition cannot be evaluated", ifExpression.getCondition()));
				return InvalidValue.SINGLETON;
			}

			IValue thenValue = evaluate(ifExpression.getThenExpression());
			IValue elseValue = evaluate(ifExpression.getElseExpression());
			
			if (thenValue instanceof InvalidValue || elseValue instanceof InvalidValue) {
				return InvalidValue.SINGLETON;
			}
			
			DataType dataType = TypeUtil.getLeftHandDataType(thenValue.getDataType(), elseValue.getDataType());
			if (dataType == null) {
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Resulting data type is incompatible with else expression data type", ifExpression.getThenExpression()));
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Resulting data type is incompatible with then expression data type", ifExpression.getElseExpression()));
				return InvalidValue.SINGLETON;
			}
			
			return new AnyValue(context.getComputationContext(), dataType);
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseImpliesExpression(org.eclipselabs.mscript.language.ast.ImpliesExpression)
		 */
		@Override
		public IValue caseImpliesExpression(ImpliesExpression impliesExpression) {
			IValue leftValue = evaluate(impliesExpression.getLeftOperand());
			
			if (leftValue instanceof InvalidValue) {
				return InvalidValue.SINGLETON;
			}
			
			if (staticScope && leftValue instanceof IBooleanValue && !((IBooleanValue) leftValue).booleanValue()) {
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
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Implies expression left operand must result to boolean type", impliesExpression.getLeftOperand()));
			}
			
			if (!(rightValue.getDataType() instanceof BooleanType)) {
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Implies expression right operand must result to boolean type", impliesExpression.getRightOperand()));
			}

			return InvalidValue.SINGLETON;
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLogicalOrExpression(org.eclipselabs.mscript.language.ast.LogicalOrExpression)
		 */
		@Override
		public IValue caseLogicalOrExpression(LogicalOrExpression logicalOrExpression) {
			IValue leftValue = evaluate(logicalOrExpression.getLeftOperand());

			if (leftValue instanceof InvalidValue) {
				return InvalidValue.SINGLETON;
			}
			
			if (staticScope && leftValue instanceof IBooleanValue && ((IBooleanValue) leftValue).booleanValue()) {
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
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Logical OR expression left operand must result to boolean type", logicalOrExpression.getLeftOperand()));
			}
			
			if (!(rightValue.getDataType() instanceof BooleanType)) {
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Logical OR expression right operand must result to boolean type", logicalOrExpression.getRightOperand()));
			}

			return InvalidValue.SINGLETON;
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLogicalAndExpression(org.eclipselabs.mscript.language.ast.LogicalAndExpression)
		 */
		@Override
		public IValue caseLogicalAndExpression(LogicalAndExpression logicalAndExpression) {
			IValue leftValue = evaluate(logicalAndExpression.getLeftOperand());
			
			if (leftValue instanceof InvalidValue) {
				return InvalidValue.SINGLETON;
			}
			
			if (staticScope && leftValue instanceof IBooleanValue && !((IBooleanValue) leftValue).booleanValue()) {
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
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Logical AND expression left operand must result to boolean type", logicalAndExpression.getLeftOperand()));
			}
			
			if (!(rightValue.getDataType() instanceof BooleanType)) {
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Logical AND expression right operand must result to boolean type", logicalAndExpression.getRightOperand()));
			}

			return InvalidValue.SINGLETON;
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseEqualityExpression(org.eclipselabs.mscript.language.ast.EqualityExpression)
		 */
		@Override
		public IValue caseEqualityExpression(EqualityExpression equalityExpression) {
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
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Invalid equality operation operands", equalityExpression));
			}
			
			return result;
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRelationalExpression(org.eclipselabs.mscript.language.ast.RelationalExpression)
		 */
		@Override
		public IValue caseRelationalExpression(RelationalExpression relationalExpression) {
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
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Invalid relational operation operands", relationalExpression));
			}
			
			return result;
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseTypeTestExpression(org.eclipselabs.mscript.language.ast.TypeTestExpression)
		 */
		@Override
		public IValue caseTypeTestExpression(TypeTestExpression typeTestExpression) {
			IValue value = evaluate(typeTestExpression.getExpression());
			if (value instanceof InvalidValue) {
				return value;
			}
			DataType dataType = EcoreUtil.copy(typeTestExpression.getTypeSpecifier().getType());
			return Values.valueOf(context.getComputationContext(), dataType.isAssignableFrom(value.getDataType()));
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseAdditiveExpression(org.eclipselabs.mscript.language.ast.AdditiveExpression)
		 */
		@Override
		public IValue caseAdditiveExpression(AdditiveExpression additiveExpression) {
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
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Additive operation cannot not be performed on provided operands", additiveExpression));
			}
			
			return result;
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseMultiplicativeExpression(org.eclipselabs.mscript.language.ast.MultiplicativeExpression)
		 */
		@Override
		public IValue caseMultiplicativeExpression(MultiplicativeExpression multiplicativeExpression) {
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
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Multiplicative operation cannot not be performed on provided operands", multiplicativeExpression));
			}
			
			return result;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseUnaryExpression(org.eclipselabs.mscript.language.ast.UnaryExpression)
		 */
		@Override
		public IValue caseUnaryExpression(UnaryExpression unaryExpression) {
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
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Invalid unary operation operand", unaryExpression));
			}
			
			return result;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseArrayConstructionOperator(org.eclipselabs.mscript.language.ast.ArrayConstructionOperator)
		 */
		@Override
		public IValue caseArrayConstructionOperator(ArrayConstructionOperator arrayConstructionOperator) {
			int size = arrayConstructionOperator.getExpressions().size();
			
			IValue[] elements = null;
			
			int i = 0;
			for (Expression expression : arrayConstructionOperator.getExpressions()) {
				IValue value = evaluate(expression);
				if (value instanceof InvalidValue) {
					return value;
				}
				if (elements == null) {
					if (value instanceof INumericValue) {
						elements = new INumericValue[size];
					} else {
						elements = new IValue[size];
					}
				} else if (elements instanceof INumericValue[] && !(value instanceof INumericValue)) {
					status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Invalid array construction elements", arrayConstructionOperator));
					return InvalidValue.SINGLETON;
				}
				elements[i] = value;
				++i;
			}
			
			ArrayType arrayType = createArrayType(elements);
			
			if (arrayType == null) {
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Invalid array construction elements", arrayConstructionOperator));
				return InvalidValue.SINGLETON;
			}
			
			context.setValue(arrayType.getDimensions().get(0).getSize(), Values.valueOf(context.getComputationContext(), TypeUtil.createIntegerType(), size));

			if (arrayType instanceof TensorType) {
				return new VectorValue(context.getComputationContext(), (TensorType) arrayType, (INumericValue[]) elements);
			}
			
			return new ArrayValue(context.getComputationContext(), arrayType, elements);
		}
		
		private ArrayType createArrayType(IValue[] elements) {
			DataType elementType = null;
			
			for (IValue elementValue : elements) {
				DataType dataType = elementValue.getDataType();
				
				if (dataType == null || dataType instanceof InvalidDataType) {
					return null;
				}
				
				if (elementType != null && !elementType.isEquivalentTo(dataType)) {
					DataType leftHandDataType = TypeUtil.getLeftHandDataType(elementType, dataType);
					if (leftHandDataType == null) {
						return null;
					}
					dataType = leftHandDataType;
				}
				
				elementType = dataType;
			}
			
			return TypeUtil.createArrayType(elementType, elements.length);
		}
		
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
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Invalid matrix operation", arrayConcatenationOperator));
			}
			return result;
		}
	
		public IValue processMatrix(IValue[][] matrix, int rowSize, int columnSize) {
			return InvalidValue.SINGLETON;
		}
	
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseUnitConstructionOperator(org.eclipselabs.mscript.language.ast.UnitConstructionOperator)
		 */
		@Override
		public IValue caseUnitConstructionOperator(UnitConstructionOperator unitConstructionOperator) {
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
			IValue operandValue = evaluate(powerExpression.getOperand());
			IValue exponentValue = evaluate(powerExpression.getExponent());
			
			if (operandValue instanceof InvalidValue || exponentValue instanceof InvalidValue) {
				return InvalidValue.SINGLETON;
			}
			
			boolean failed = false;
			
			if (!(operandValue.getDataType() instanceof NumericType)) {
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Power operand must be numeric", powerExpression.getOperand()));
				failed = true;
			}

			if (!(exponentValue.getDataType() instanceof NumericType)) {
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Power exponent must be numeric", powerExpression.getExponent()));
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
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Power exponent must be integer constant if operand is dimensional", powerExpression.getExponent()));
				failed = true;
			}
			
			if (!dimensionlessUnit.isEquivalentTo(exponentType.getUnit(), true)) {
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Power exponent must be dimensionless", powerExpression.getExponent()));
				failed = true;
			}

			if (failed) {
				return InvalidValue.SINGLETON;
			}

			DataType dataType;
			if (constantIntegerExponent) {
				dataType = operandType.evaluate(OperatorKind.POWER, (int) ((ISimpleNumericValue) exponentValue).longValue());
			} else {
				RealType realType = MscriptFactory.eINSTANCE.createRealType();
				realType.setUnit(EcoreUtil.copy(operandType.getUnit()));
				dataType = realType;
			}
			
			IValue result = null;
			if (operandValue instanceof ISimpleNumericValue && exponentValue instanceof ISimpleNumericValue) {
				result = Values.valueOf(context.getComputationContext(), (NumericType) dataType, Math.pow(
						((ISimpleNumericValue) operandValue).doubleValue(),
						((ISimpleNumericValue) exponentValue).doubleValue()));
			} else {
				result = new AnyValue(context.getComputationContext(), dataType);
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
			IValue value = evaluate(arrayElementAccess.getArray());
			if (value == null) {
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "No value set for array", arrayElementAccess.getArray()));
				return InvalidValue.SINGLETON;
			}
			
			if (!(value.getDataType() instanceof ArrayType)) {
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Array element access is only applicable to arrays", arrayElementAccess.getArray()));
				return InvalidValue.SINGLETON;
			}

			if (!(value instanceof IArrayValue)) {
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Dynamic arrays not supported", arrayElementAccess.getArray()));
				return InvalidValue.SINGLETON;
			}
			
			IArrayValue arrayValue = (IArrayValue) value;
			
			if (arrayElementAccess.getSubscripts().size() != 1) {
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Array subscript dimensionality must be 1", arrayElementAccess));
				return InvalidValue.SINGLETON;
			}
			
			EList<ArrayDimension> dimensions = arrayValue.getDataType().getDimensions();
			if (dimensions.size() != 1) {
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Array dimensionality must be 1", arrayElementAccess));
				return InvalidValue.SINGLETON;
			}
			
			IValue sizeValue = context.getValue(dimensions.get(0).getSize());
			if (sizeValue == null || !(sizeValue.getDataType() instanceof IntegerType) || !(sizeValue instanceof ISimpleNumericValue)) {
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Invalid array size data type", arrayElementAccess));
				return InvalidValue.SINGLETON;
			}
			
			int size = (int) ((ISimpleNumericValue) sizeValue).longValue();
			
			ArraySubscript subscript = arrayElementAccess.getSubscripts().get(0);
			if (subscript.getExpression() == null) {
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Array subscript not set", subscript));
				return InvalidValue.SINGLETON;
			}
			
			IValue subsciptValue = evaluate(subscript.getExpression());
			if (!(subsciptValue.getDataType() instanceof IntegerType)) {
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Array subscript data type must be integer", arrayElementAccess));
				return InvalidValue.SINGLETON;
			}
			
			if (subsciptValue instanceof ISimpleNumericValue) {
				int index = (int) ((ISimpleNumericValue) subsciptValue).longValue();
				if (index < size) {
					return arrayValue.get(index);
				} else {
					status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Array subscript must be less than " + size, arrayElementAccess));
					return InvalidValue.SINGLETON;
				}
			}
			
			return new AnyValue(context.getComputationContext(), arrayValue.getDataType().getElementType());
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseVariableAccess(org.eclipselabs.mscript.language.ast.VariableAccess)
		 */
		@Override
		public IValue caseVariableReference(VariableReference variableReference) {
			if (variableReference.getFeature() == null || variableReference.getFeature().eIsProxy()) {
				return InvalidValue.SINGLETON;
			}
			IValue value = context.getValue(variableReference.getFeature());
			if (value == null) {
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "No value set for " + variableReference.getFeature().getName(), variableReference));
				value = InvalidValue.SINGLETON;
			}
			return value;
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.il.util.FunctionModelSwitch#caseFunctionCall(org.eclipselabs.mscript.language.il.FunctionCall)
		 */
		@Override
		public IValue caseFunctionCall(FunctionCall functionCall) {
			String name = functionCall.getFeature().getName();
			
			List<IValue> argumentValues = new ArrayList<IValue>();
			for (Expression argument : functionCall.getArguments()) {
				argumentValues.add(ExpressionValueEvaluatorSwitch.this.evaluate(argument));
			}

			List<DataType> inputParameterDataTypes = new ArrayList<DataType>();
			for (IValue argumentValue : argumentValues) {
				inputParameterDataTypes.add(argumentValue.getDataType());
			}
			BuiltinFunctionKind descriptor = BuiltinFunctionKind.get(name, inputParameterDataTypes);
			if (descriptor != null) {
				IBuiltinFunction behavior = builtinFunctionLookupTable.getFunction(descriptor);
				if (behavior != null) {
					return behavior.call(context.getComputationContext(), argumentValues).get(0);
				}
			}
			
			status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "The function " + functionCall.getFeature().getName() + " is not supported", functionCall));
			return InvalidValue.SINGLETON;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIterationCall(org.eclipselabs.mscript.language.ast.IterationCall)
		 */
		@Override
		public IValue caseIterationCall(IterationCall iterationCall) {
			if (!"iterate".equals(iterationCall.getIdentifier())) {
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Invalid iteration call " + iterationCall.getIdentifier(), iterationCall));
				return InvalidValue.SINGLETON;
			}

			IValue targetValue = evaluate(iterationCall.getTarget());
			if (targetValue instanceof InvalidValue) {
				return InvalidValue.SINGLETON;
			}
			
			if (!(targetValue.getDataType() instanceof ArrayType)) {
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Iteration call target must be array type", iterationCall));
				return InvalidValue.SINGLETON;
			}
			
			ArrayType arrayType = (ArrayType) targetValue.getDataType();
			
			if (arrayType.getDimensionality() != 1) {
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Iteration call target array type must have dimensionality of 1", iterationCall));
				return InvalidValue.SINGLETON;
			}
			
			// TODO: Evaluate all array sizes ahead of time
			Expression sizeExpression = arrayType.getDimensions().get(0).getSize();
			IValue sizeValue = evaluate(sizeExpression);
			if (!(sizeValue instanceof ISimpleNumericValue) || !(sizeValue.getDataType() instanceof IntegerType)) {
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Array size expression must be integer", sizeExpression));
				return InvalidValue.SINGLETON;
			}

			IValue accumulatorValue = evaluate(iterationCall.getAccumulator().getInitializer());
			if (accumulatorValue instanceof InvalidValue) {
				return InvalidValue.SINGLETON;
			}
			
			if (!(accumulatorValue instanceof AnyValue)) {
				accumulatorValue = new AnyValue(context.getComputationContext(), accumulatorValue.getDataType());
			}
			
			context.setValue(iterationCall.getAccumulator(), accumulatorValue);
			
			if (iterationCall.getIterationVariables().size() != 1) {
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Iteration call must have exactly one iteration variable", iterationCall));
				return InvalidValue.SINGLETON;
			}
			
			context.setValue(iterationCall.getIterationVariables().get(0), new AnyValue(context.getComputationContext(), arrayType.getElementType()));

			IValue expressionValue = evaluate(iterationCall.getExpression());
			if (expressionValue instanceof InvalidValue) {
				return InvalidValue.SINGLETON;
			}
			
			DataType resultingDataType = TypeUtil.getLeftHandDataType(accumulatorValue.getDataType(), expressionValue.getDataType());
			if (resultingDataType == null) {
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Iteration call accumulator type is incompatabile with expression type", iterationCall));
				return InvalidValue.SINGLETON;
			}
			
			if (!accumulatorValue.getDataType().isAssignableFrom(resultingDataType)) {
				accumulatorValue = new AnyValue(context.getComputationContext(), resultingDataType);
				context.setValue(iterationCall.getAccumulator(), accumulatorValue);
			}
			
			return new AnyValue(context.getComputationContext(), resultingDataType);
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
		 */
		@Override
		public IValue defaultCase(EObject object) {
			status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Invalid expression", object));
			return InvalidValue.SINGLETON;
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
	
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseStringLiteral(org.eclipselabs.mscript.language.ast.StringLiteral)
		 */
		@Override
		public IValue caseStringLiteral(StringLiteral stringLiteral) {
			return new StringValue(context.getComputationContext(), stringLiteral.getValue());
		}
		
	}
	
}
