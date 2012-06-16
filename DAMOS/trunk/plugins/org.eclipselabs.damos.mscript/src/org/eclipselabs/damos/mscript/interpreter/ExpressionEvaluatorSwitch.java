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
import org.eclipselabs.damos.mscript.ArrayConstructionOperator;
import org.eclipselabs.damos.mscript.ArrayDimension;
import org.eclipselabs.damos.mscript.ArrayElementAccess;
import org.eclipselabs.damos.mscript.ArraySubscript;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.BooleanLiteral;
import org.eclipselabs.damos.mscript.BooleanType;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.EndExpression;
import org.eclipselabs.damos.mscript.EqualityExpression;
import org.eclipselabs.damos.mscript.Evaluable;
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
import org.eclipselabs.damos.mscript.StructConstructionMember;
import org.eclipselabs.damos.mscript.StructConstructionOperator;
import org.eclipselabs.damos.mscript.StructMember;
import org.eclipselabs.damos.mscript.StructType;
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

abstract class ExpressionEvaluatorSwitch extends MscriptSwitch<IValue> {

	private final IBuiltinFunctionLookupTable builtinFunctionLookupTable = new BuiltinFunctionLookupTable();

	private boolean staticScope;

	/**
	 * 
	 */
	public ExpressionEvaluatorSwitch(boolean staticScope) {
		this.staticScope = staticScope;
	}

	public IValue evaluate(Expression expression) {
		return doSwitch(expression);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLetExpression(org.eclipselabs.mscript.language.ast.LetExpression)
	 */
	@Override
	public IValue caseLetExpression(LetExpression letExpression) {
		for (LetExpressionAssignment assignment : letExpression.getAssignments()) {
			IValue value = evaluate(assignment.getAssignedExpression());
			setStaticValue(assignment.getVariables().get(0), value);
		}
		return evaluate(letExpression.getTarget());
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIfExpression(org.eclipselabs.mscript.language.ast.IfExpression)
	 */
	@Override
	public IValue caseIfExpression(IfExpression ifExpression) {
		boolean oldStaticScope = staticScope;
		if (!oldStaticScope) {
			staticScope = ifExpression.isStatic();
		}
		IValue conditionValue = evaluate(ifExpression.getCondition());
		staticScope = oldStaticScope;

		if (conditionValue instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}

		if (!(conditionValue.getDataType() instanceof BooleanType)) {
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "If expression condition must evaluate to boolean type", ifExpression.getCondition()));
			}
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
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Static if expression condition cannot be evaluated", ifExpression.getCondition()));
			}
			return InvalidValue.SINGLETON;
		}

		IValue thenValue = evaluate(ifExpression.getThenExpression());
		IValue elseValue = evaluate(ifExpression.getElseExpression());

		if (thenValue instanceof InvalidValue || elseValue instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}

		DataType dataType = TypeUtil.getLeftHandDataType(thenValue.getDataType(), elseValue.getDataType());
		if (dataType == null) {
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Resulting data type is incompatible with else expression data type", ifExpression.getThenExpression()));
			}
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Resulting data type is incompatible with then expression data type", ifExpression.getElseExpression()));
			}
			return InvalidValue.SINGLETON;
		}

		return new AnyValue(getComputationContext(), dataType);
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
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Start expression must be static", startExpression));
			}
			nonStatic = true;
		}

		if (incrementValue instanceof AnyValue) {
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Increment expression must be static", incrementExpression));
			}
			nonStatic = true;
		}

		if (endValue instanceof AnyValue) {
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "End expression must be static", endExpression));
			}
			nonStatic = true;
		}

		if (nonStatic) {
			return InvalidValue.SINGLETON;
		}

		boolean nonNumeric = false;

		if (!(startValue instanceof ISimpleNumericValue)) {
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Start expression must be numeric", startExpression));
			}
			nonNumeric = true;
		}

		if (incrementValue != null && !(incrementValue instanceof ISimpleNumericValue)) {
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Increment expression must be numeric", incrementExpression));
			}
			nonNumeric = true;
		}

		if (!(endValue instanceof ISimpleNumericValue)) {
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "End expression must be numeric", endExpression));
			}
			nonNumeric = true;
		}

		if (nonNumeric) {
			return InvalidValue.SINGLETON;
		}

		DataType dataType = startValue.getDataType();
		if (incrementValue != null && dataType != null) {
			dataType = TypeUtil.getLeftHandDataType(dataType, incrementValue.getDataType());
		}
		if (dataType != null) {
			dataType = TypeUtil.getLeftHandDataType(dataType, endValue.getDataType());
		}
		if (!(dataType instanceof NumericType)) {
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Incompatible data types in range expression", rangeExpression));
			}
			return InvalidValue.SINGLETON;
		}

		List<IValue> values = new ArrayList<IValue>();

		ISimpleNumericValue numericStartValue = (ISimpleNumericValue) startValue;
		ISimpleNumericValue numericIncrementValue = (ISimpleNumericValue) incrementValue;
		ISimpleNumericValue numericEndValue = (ISimpleNumericValue) endValue;

		if (dataType instanceof IntegerType) {
			long x = numericStartValue.longValue();
			long increment = incrementValue != null ? numericIncrementValue.longValue() : 1;
			long end = numericEndValue.longValue();
			if (increment > 0 && x <= end) {
				for (; x <= end; x += increment) {
					values.add(Values.valueOf(getComputationContext(), (NumericType) dataType, x));
				}
			} else if (increment < 0 && x >= end) {
				for (; x >= end; x += increment) {
					values.add(Values.valueOf(getComputationContext(), (NumericType) dataType, x));
				}
			}
		} else {
			double x = numericStartValue.doubleValue();
			double increment = incrementValue != null ? numericIncrementValue.doubleValue() : 1.0;
			double end = numericEndValue.doubleValue();
			if (increment > 0.0 && x <= end) {
				for (; x <= end; x += increment) {
					values.add(Values.valueOf(getComputationContext(), (NumericType) dataType, x));
				}
			} else if (increment < 0.0 && x >= end) {
				for (; x >= end; x += increment) {
					values.add(Values.valueOf(getComputationContext(), (NumericType) dataType, x));
				}
			}
		}

		return new VectorValue(getComputationContext(), TypeUtil.createArrayType(dataType, values.size()), values.toArray(new IValue[values.size()]));
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
			return Values.valueOf(getComputationContext(), true);
		}

		IValue rightValue = evaluate(impliesExpression.getRightOperand());

		if (rightValue instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}

		if (leftValue instanceof IBooleanValue) {
			IBooleanValue leftBooleanValue = (IBooleanValue) leftValue;
			if (!leftBooleanValue.booleanValue()) {
				return Values.valueOf(getComputationContext(), true);
			}
			if (rightValue instanceof IBooleanValue) {
				IBooleanValue rightBooleanValue = (IBooleanValue) rightValue;
				return Values.valueOf(getComputationContext(), rightBooleanValue.booleanValue());
			}
		}

		if ((leftValue instanceof IBooleanValue || leftValue instanceof AnyValue) && leftValue.getDataType() instanceof BooleanType
				&& (rightValue instanceof IBooleanValue || rightValue instanceof AnyValue) && rightValue.getDataType() instanceof BooleanType) {
			return leftValue;
		}

		if (!(leftValue.getDataType() instanceof BooleanType)) {
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Implies expression left operand must result to boolean type", impliesExpression.getLeftOperand()));
			}
		}

		if (!(rightValue.getDataType() instanceof BooleanType)) {
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Implies expression right operand must result to boolean type", impliesExpression.getRightOperand()));
			}
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
			return Values.valueOf(getComputationContext(), true);
		}

		IValue rightValue = evaluate(logicalOrExpression.getRightOperand());

		if (rightValue instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}

		if (leftValue instanceof IBooleanValue) {
			IBooleanValue leftBooleanValue = (IBooleanValue) leftValue;
			if (leftBooleanValue.booleanValue()) {
				return Values.valueOf(getComputationContext(), true);
			}
			if (rightValue instanceof IBooleanValue) {
				IBooleanValue rightBooleanValue = (IBooleanValue) rightValue;
				return Values.valueOf(getComputationContext(), rightBooleanValue.booleanValue());
			}
		}

		if ((leftValue instanceof IBooleanValue || leftValue instanceof AnyValue) && leftValue.getDataType() instanceof BooleanType
				&& (rightValue instanceof IBooleanValue || rightValue instanceof AnyValue) && rightValue.getDataType() instanceof BooleanType) {
			return leftValue;
		}

		if (!(leftValue.getDataType() instanceof BooleanType)) {
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Logical OR expression left operand must result to boolean type", logicalOrExpression.getLeftOperand()));
			}
		}

		if (!(rightValue.getDataType() instanceof BooleanType)) {
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Logical OR expression right operand must result to boolean type", logicalOrExpression.getRightOperand()));
			}
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
			return Values.valueOf(getComputationContext(), false);
		}

		IValue rightValue = evaluate(logicalAndExpression.getRightOperand());

		if (rightValue instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}

		if (leftValue instanceof IBooleanValue) {
			IBooleanValue leftBooleanValue = (IBooleanValue) leftValue;
			if (!leftBooleanValue.booleanValue()) {
				return Values.valueOf(getComputationContext(), false);
			}
			if (rightValue instanceof IBooleanValue) {
				IBooleanValue rightBooleanValue = (IBooleanValue) rightValue;
				return Values.valueOf(getComputationContext(), rightBooleanValue.booleanValue());
			}
		}

		if ((leftValue instanceof IBooleanValue || leftValue instanceof AnyValue) && leftValue.getDataType() instanceof BooleanType
				&& (rightValue instanceof IBooleanValue || rightValue instanceof AnyValue) && rightValue.getDataType() instanceof BooleanType) {
			return leftValue;
		}

		if (!(leftValue.getDataType() instanceof BooleanType)) {
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Logical AND expression left operand must result to boolean type", logicalAndExpression.getLeftOperand()));
			}
		}

		if (!(rightValue.getDataType() instanceof BooleanType)) {
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Logical AND expression right operand must result to boolean type", logicalAndExpression.getRightOperand()));
			}
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
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Invalid equality operation operands", equalityExpression));
			}
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
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Invalid relational operation operands", relationalExpression));
			}
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
		return Values.valueOf(getComputationContext(), dataType.isAssignableFrom(value.getDataType()));
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
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Additive operation cannot not be performed on provided operands", additiveExpression));
			}
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
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Multiplicative operation cannot not be performed on provided operands", multiplicativeExpression));
			}
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
				result = Values.valueOf(getComputationContext(), !booleanResult.booleanValue());
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
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Invalid unary operation operand", unaryExpression));
			}
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseArrayConstructionOperator(org.eclipselabs.mscript.language.ast.ArrayConstructionOperator)
	 */
	@Override
	public IValue caseArrayConstructionOperator(ArrayConstructionOperator arrayConstructionOperator) {
		int size = arrayConstructionOperator.getExpressions().size();

		IValue[] elements = new IValue[size];
		boolean anyValue = false;

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

		if (anyValue) {
			for (int i = 0; i < size; ++i) {
				if (!(elements[i] instanceof AnyValue)) {
					elements[i] = new AnyValue(getComputationContext(), elements[i].getDataType());
				}
			}
		}

		ArrayType arrayType = createArrayType(elements);

		if (arrayType == null) {
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Incompatible array construction elements", arrayConstructionOperator));
			}
			return InvalidValue.SINGLETON;
		}

		// Vector
		if (arrayType.getDimensionality() == 1) {
			setStaticValue(arrayType.getDimensions().get(0).getSize(), Values.valueOf(getComputationContext(), TypeUtil.createIntegerType(), size));
	
			if (anyValue) {
				return new AnyValue(getComputationContext(), arrayType);
			}
	
			if (arrayType.isNumeric()) {
				return new VectorValue(getComputationContext(), arrayType, elements);
			}
	
			return new ArrayValue(getComputationContext(), arrayType, elements);
		}
		
		// Matrix
		int rowSize = TypeUtil.getArrayRowSize(arrayType);
		setStaticValue(arrayType.getDimensions().get(0).getSize(), Values.valueOf(getComputationContext(), TypeUtil.createIntegerType(), rowSize));
		int columnSize = TypeUtil.getArrayColumnSize(arrayType);
		setStaticValue(arrayType.getDimensions().get(1).getSize(), Values.valueOf(getComputationContext(), TypeUtil.createIntegerType(), columnSize));
		
		if (anyValue) {
			return new AnyValue(getComputationContext(), arrayType);
		}

		IValue[][] values = new IValue[rowSize][columnSize];
		for (int i = 0; i < rowSize; ++i) {
			for (int j = 0; j < columnSize; ++j) {
				values[i][j] = ((IArrayValue) elements[i]).get(j);
			}
		}
		return new MatrixValue(getComputationContext(), arrayType, values);
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
		
		if (elementType instanceof ArrayType) {
			ArrayType elementArrayType = (ArrayType) elementType;
			if (elementArrayType.getDimensionality() != 1) {
				// We do not support tensors yet
				return null;
			}
			return TypeUtil.createArrayType(elementArrayType.getElementType(), elements.length, TypeUtil.getArraySize(elementArrayType));
		}

		return TypeUtil.createArrayType(elementType, elements.length);
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
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Invalid matrix operation", arrayConcatenationOperator));
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
		IValue[] values = new IValue[structConstructionOperator.getMembers().size()];

		boolean anyValue = false;

		{
			int i = 0;
			for (StructConstructionMember constructionMember : structConstructionOperator.getMembers()) {
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
					values[i] = new AnyValue(getComputationContext(), values[i].getDataType());
				}
			}
			return new AnyValue(getComputationContext(), structType);
		}

		return new StructValue(getComputationContext(), structType, values);
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
		return new UnitValue(getComputationContext(), unit);
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
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Power operand must be numeric", powerExpression.getOperand()));
			}
			failed = true;
		}

		if (!(exponentValue.getDataType() instanceof NumericType)) {
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Power exponent must be numeric", powerExpression.getExponent()));
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
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Power exponent must be integer constant if operand is dimensional", powerExpression.getExponent()));
			}
			failed = true;
		}

		if (!dimensionlessUnit.isEquivalentTo(exponentType.getUnit(), true)) {
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Power exponent must be dimensionless", powerExpression.getExponent()));
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
			DataType dataType;
			if (constantIntegerExponent) {
				dataType = operandType.evaluate(OperatorKind.POWER, (int) ((ISimpleNumericValue) exponentValue).longValue());
			} else {
				RealType realType = MscriptFactory.eINSTANCE.createRealType();
				realType.setUnit(EcoreUtil.copy(operandType.getUnit()));
				dataType = realType;
			}
			result = new AnyValue(getComputationContext(), dataType);
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
		if (value instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}

		if (value == null) {
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "No value set for array", arrayElementAccess.getArray()));
			}
			return InvalidValue.SINGLETON;
		}

		if (!(value.getDataType() instanceof ArrayType)) {
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Array element access is only applicable to arrays", arrayElementAccess));
			}
			return InvalidValue.SINGLETON;
		}

		ArrayType arrayType = (ArrayType) value.getDataType();

		if (arrayElementAccess.getSubscripts().size() != 1) {
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Array subscript dimensionality must be 1", arrayElementAccess));
			}
			return InvalidValue.SINGLETON;
		}

		EList<ArrayDimension> dimensions = arrayType.getDimensions();
		if (dimensions.size() != 1) {
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Array dimensionality must be 1", arrayElementAccess));
			}
			return InvalidValue.SINGLETON;
		}

		Expression sizeExpression = dimensions.get(0).getSize();
		IValue sizeValue = getStaticValue(sizeExpression);
		// TODO: This has to be redesigned
		if (sizeValue == null) {
			sizeValue = evaluate(sizeExpression);
		}
		if (sizeValue == null || !(sizeValue.getDataType() instanceof IntegerType) || !(sizeValue instanceof ISimpleNumericValue)) {
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Invalid array size data type", arrayElementAccess));
			}
			return InvalidValue.SINGLETON;
		}

		int size = (int) ((ISimpleNumericValue) sizeValue).longValue();

		ArraySubscript subscript = arrayElementAccess.getSubscripts().get(0);
		if (subscript.getExpression() == null) {
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Array subscript not set", subscript));
			}
			return InvalidValue.SINGLETON;
		}

		IValue subsciptValue = evaluate(subscript.getExpression());
		if (subsciptValue instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}

		if (!(subsciptValue.getDataType() instanceof IntegerType)) {
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Array subscript data type must be integer", arrayElementAccess));
			}
			return InvalidValue.SINGLETON;
		}

		if (subsciptValue instanceof ISimpleNumericValue) {
			int index = (int) ((ISimpleNumericValue) subsciptValue).longValue();
			if (index < 0) {
				if (isCollectStatus()) {
					collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Array subscript must be greater than or equal to 0", arrayElementAccess));
				}
				return InvalidValue.SINGLETON;
			}
			if (index < size) {
				if (value instanceof IArrayValue) {
					return ((IArrayValue) value).get(index);
				}
			} else {
				if (isCollectStatus()) {
					collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Array subscript must be less than " + size, arrayElementAccess));
				}
				return InvalidValue.SINGLETON;
			}
		}

		return new AnyValue(getComputationContext(), EcoreUtil.copy(arrayType.getElementType()));
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseVariableAccess(org.eclipselabs.mscript.language.ast.VariableAccess)
	 */
	@Override
	public IValue caseVariableReference(VariableReference variableReference) {
		if (variableReference.getFeature() == null || variableReference.getFeature().eIsProxy()) {
			return InvalidValue.SINGLETON;
		}
		IValue value = getStaticValue(variableReference.getFeature());
		if (value == null) {
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "No value set for " + variableReference.getFeature().getName(), variableReference));
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
		IValue value = evaluate(memberVariableAccess.getTarget());
		if (value instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}

		if (value == null) {
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "No value set for target", memberVariableAccess.getTarget()));
			}
			return InvalidValue.SINGLETON;
		}

		if (!(value.getDataType() instanceof StructType)) {
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Member variable access is only applicable to structs", memberVariableAccess, MscriptPackage.eINSTANCE.getMemberVariableAccess_MemberVariable()));
			}
			return InvalidValue.SINGLETON;
		}

		StructType structType = (StructType) value.getDataType();

		int memberIndex = structType.getMemberIndex(memberVariableAccess.getMemberVariable());
		if (memberIndex == -1) {
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, memberVariableAccess.getMemberVariable() + " is not a member variable", memberVariableAccess, MscriptPackage.eINSTANCE.getMemberVariableAccess_MemberVariable()));
			}
			return InvalidValue.SINGLETON;
		}

		if (value instanceof StructValue) {
			return ((StructValue) value).get(memberIndex);
		}

		return new AnyValue(getComputationContext(), EcoreUtil.copy(structType.getMembers().get(memberIndex).getTypeSpecifier().getType()));
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.util.FunctionModelSwitch#caseFunctionCall(org.eclipselabs.mscript.language.il.FunctionCall)
	 */
	@Override
	public IValue caseFunctionCall(FunctionCall functionCall) {
		String name = functionCall.getFeature().getName();

		List<IValue> argumentValues = new ArrayList<IValue>();
		for (Expression argument : functionCall.getArguments()) {
			argumentValues.add(evaluate(argument));
		}

		List<DataType> inputParameterDataTypes = new ArrayList<DataType>();
		for (IValue argumentValue : argumentValues) {
			inputParameterDataTypes.add(argumentValue.getDataType());
		}
		BuiltinFunctionKind descriptor = BuiltinFunctionKind.get(name, inputParameterDataTypes);
		if (descriptor != null) {
			IBuiltinFunction behavior = builtinFunctionLookupTable.getFunction(descriptor);
			if (behavior != null) {
				return behavior.call(getComputationContext(), argumentValues).get(0);
			}
		}

		if (isCollectStatus()) {
			collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "The function " + functionCall.getFeature().getName() + " is not supported", functionCall));
		}
		return InvalidValue.SINGLETON;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIterationCall(org.eclipselabs.mscript.language.ast.IterationCall)
	 */
	@Override
	public IValue caseIterationCall(IterationCall iterationCall) {
		if (!"iterate".equals(iterationCall.getIdentifier())) {
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Invalid iteration call " + iterationCall.getIdentifier(), iterationCall));
			}
			return InvalidValue.SINGLETON;
		}

		IValue targetValue = evaluate(iterationCall.getTarget());
		if (targetValue instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}

		if (!(targetValue.getDataType() instanceof ArrayType)) {
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Iteration call target must be array type", iterationCall));
			}
			return InvalidValue.SINGLETON;
		}

		ArrayType arrayType = (ArrayType) targetValue.getDataType();

		if (arrayType.getDimensionality() != 1) {
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Iteration call target array type must have dimensionality of 1", iterationCall));
			}
			return InvalidValue.SINGLETON;
		}

		// TODO: Evaluate all array sizes ahead of time
		Expression sizeExpression = arrayType.getDimensions().get(0).getSize();
		IValue sizeValue = evaluate(sizeExpression);
		if (!(sizeValue instanceof ISimpleNumericValue) || !(sizeValue.getDataType() instanceof IntegerType)) {
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Array size expression must be integer", sizeExpression));
			}
			return InvalidValue.SINGLETON;
		}

		IValue accumulatorValue = evaluate(iterationCall.getAccumulator().getInitializer());
		if (accumulatorValue instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}

		if (!(accumulatorValue instanceof AnyValue)) {
			accumulatorValue = new AnyValue(getComputationContext(), accumulatorValue.getDataType());
		}

		setStaticValue(iterationCall.getAccumulator(), accumulatorValue);

		if (iterationCall.getIterationVariables().size() != 1) {
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Iteration call must have exactly one iteration variable", iterationCall));
			}
			return InvalidValue.SINGLETON;
		}

		setStaticValue(iterationCall.getIterationVariables().get(0), new AnyValue(getComputationContext(), arrayType.getElementType()));

		IValue expressionValue = evaluate(iterationCall.getExpression());
		if (expressionValue instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}

		DataType resultingDataType = TypeUtil.getLeftHandDataType(accumulatorValue.getDataType(), expressionValue.getDataType());
		if (resultingDataType == null) {
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Iteration call accumulator type is incompatabile with expression type", iterationCall));
			}
			return InvalidValue.SINGLETON;
		}

		if (!accumulatorValue.getDataType().isAssignableFrom(resultingDataType)) {
			accumulatorValue = new AnyValue(getComputationContext(), resultingDataType);
			setStaticValue(iterationCall.getAccumulator(), accumulatorValue);
		}

		// TODO: If possible, return static value
		return new AnyValue(getComputationContext(), resultingDataType);
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

		IValue arrayValue = getStaticValue(arrayElementAccess.getArray());
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
		IValue sizeValue = getStaticValue(sizeExpression);
		if (sizeValue == null) {
			sizeValue = evaluate(sizeExpression);
		}

		if (!(sizeValue instanceof ISimpleNumericValue)) {
			return InvalidValue.SINGLETON;
		}

		long size = ((ISimpleNumericValue) sizeValue).longValue();
		if (size == 0) {
			if (isCollectStatus()) {
				collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Array dimension must be greater than 0", endExpression));
			}
			return InvalidValue.SINGLETON;
		}

		return Values.valueOf(getComputationContext(), TypeUtil.createIntegerType(), size - 1);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRealLiteral(org.eclipselabs.mscript.language.ast.RealLiteral)
	 */
	@Override
	public IValue caseRealLiteral(RealLiteral realLiteral) {
		RealType realType = MscriptFactory.eINSTANCE.createRealType();
		realType.setUnit(EcoreUtil.copy(realLiteral.getUnit()));
		return Values.valueOf(getComputationContext(), realType, realLiteral.getValue());
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIntegerLiteral(org.eclipselabs.mscript.language.ast.IntegerLiteral)
	 */
	@Override
	public IValue caseIntegerLiteral(IntegerLiteral integerLiteral) {
		IntegerType integerType = MscriptFactory.eINSTANCE.createIntegerType();
		integerType.setUnit(EcoreUtil.copy(integerLiteral.getUnit()));
		return Values.valueOf(getComputationContext(), integerType, integerLiteral.getValue());
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseBooleanLiteral(org.eclipselabs.mscript.language.ast.BooleanLiteral)
	 */
	@Override
	public IValue caseBooleanLiteral(BooleanLiteral booleanLiteral) {
		return Values.valueOf(getComputationContext(), booleanLiteral.isTrue());
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseStringLiteral(org.eclipselabs.mscript.language.ast.StringLiteral)
	 */
	@Override
	public IValue caseStringLiteral(StringLiteral stringLiteral) {
		return new StringValue(getComputationContext(), stringLiteral.getValue());
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public IValue defaultCase(EObject object) {
		if (isCollectStatus()) {
			collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Invalid expression", object));
		}
		return InvalidValue.SINGLETON;
	}
	
	/**
	 * @return
	 */
	protected abstract IComputationContext getComputationContext();

	protected abstract IValue getStaticValue(Evaluable evaluable);

	protected void setStaticValue(Evaluable evaluable, IValue value) {
	}

	protected boolean isCollectStatus() {
		return false;
	}
	
	protected void collectStatus(IStatus status) {
	}

}
