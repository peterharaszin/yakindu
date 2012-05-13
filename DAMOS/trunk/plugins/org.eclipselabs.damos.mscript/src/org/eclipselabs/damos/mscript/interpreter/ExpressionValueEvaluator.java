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
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.DataTypeSpecifier;
import org.eclipselabs.damos.mscript.EqualityExpression;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.ExpressionList;
import org.eclipselabs.damos.mscript.FunctionCall;
import org.eclipselabs.damos.mscript.ImpliesExpression;
import org.eclipselabs.damos.mscript.IntegerLiteral;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.InvalidDataType;
import org.eclipselabs.damos.mscript.LogicalAndExpression;
import org.eclipselabs.damos.mscript.LogicalOrExpression;
import org.eclipselabs.damos.mscript.MemberVariableAccess;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.MultiplicativeExpression;
import org.eclipselabs.damos.mscript.ParenthesizedExpression;
import org.eclipselabs.damos.mscript.PowerExpression;
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
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.VariableReference;
import org.eclipselabs.damos.mscript.builtin.BuiltinFunctionKind;
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
import org.eclipselabs.damos.mscript.interpreter.value.StructValue;
import org.eclipselabs.damos.mscript.interpreter.value.UnitValue;
import org.eclipselabs.damos.mscript.interpreter.value.Values;
import org.eclipselabs.damos.mscript.interpreter.value.VectorValue;
import org.eclipselabs.damos.mscript.util.MscriptSwitch;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionValueEvaluator implements IExpressionValueEvaluator {
		
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IExpressionValueEvaluator#evaluate(org.eclipselabs.mscript.language.interpreter.IInterpreterContext, org.eclipselabs.mscript.language.ast.Expression)
	 */
	public IValue evaluate(IInterpreterContext context, Expression expression) {
		return new ExpressionValueEvaluatorSwitch(context).doSwitch(expression);
	}
	
	private static class ExpressionValueEvaluatorSwitch extends MscriptSwitch<IValue> {
		
		private IInterpreterContext context;

		private IBuiltinFunctionLookupTable builtinFunctionLookupTable = new BuiltinFunctionLookupTable();

		/**
		 * 
		 */
		public ExpressionValueEvaluatorSwitch(IInterpreterContext context) {
			this.context = context;
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseAdditiveExpression(org.eclipselabs.mscript.language.ast.AdditiveExpression)
		 */
		@Override
		public IValue caseAdditiveExpression(AdditiveExpression additiveExpression) {
			IValue leftValue = doSwitch(additiveExpression.getLeftOperand());
			IValue rightValue = doSwitch(additiveExpression.getRightOperand());
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
				throw new RuntimeException("Additive operation cannot not be performed on provided operands");
			}
			
			return result;
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseMultiplicativeExpression(org.eclipselabs.mscript.language.ast.MultiplicativeExpression)
		 */
		@Override
		public IValue caseMultiplicativeExpression(MultiplicativeExpression multiplicativeExpression) {
			IValue leftValue = doSwitch(multiplicativeExpression.getLeftOperand());
			IValue rightValue = doSwitch(multiplicativeExpression.getRightOperand());
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
				throw new RuntimeException("Multiplicative operation cannot not be performed on provided operands");
			}
			
			return result;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseImpliesExpression(org.eclipselabs.mscript.language.ast.ImpliesExpression)
		 */
		@Override
		public IValue caseImpliesExpression(ImpliesExpression impliesExpression) {
			Expression operand = impliesExpression.getLeftOperand();
			IValue value = doSwitch(operand);
			if (value instanceof IBooleanValue) {
				IBooleanValue booleanResult = (IBooleanValue) value;
				if (!booleanResult.booleanValue()) {
					return Values.valueOf(context.getComputationContext(), true);
				}
				value = doSwitch(impliesExpression.getRightOperand());
				if (value instanceof IBooleanValue) {
					booleanResult = (IBooleanValue) value;
					return Values.valueOf(context.getComputationContext(), booleanResult.booleanValue());
				}
			}
			throw new RuntimeException("Implies expression operands must be boolean");
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLogicalAndExpression(org.eclipselabs.mscript.language.ast.LogicalAndExpression)
		 */
		@Override
		public IValue caseLogicalAndExpression(LogicalAndExpression logicalAndExpression) {
			IValue leftValue = doSwitch(logicalAndExpression.getLeftOperand());
			if (leftValue instanceof IBooleanValue) {
				IBooleanValue booleanResult = (IBooleanValue) leftValue;
				if (!booleanResult.booleanValue()) {
					return Values.valueOf(context.getComputationContext(), false);
				}
			} else {
				throw new RuntimeException("Logical expression left operand must be boolean");
			}

			IValue rightValue = doSwitch(logicalAndExpression.getRightOperand());
			if (rightValue instanceof IBooleanValue) {
				IBooleanValue booleanResult = (IBooleanValue) rightValue;
				if (!booleanResult.booleanValue()) {
					return Values.valueOf(context.getComputationContext(), false);
				}
			} else {
				throw new RuntimeException("Logical expression right operand must be boolean");
			}
			
			return Values.valueOf(context.getComputationContext(), true);
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLogicalOrExpression(org.eclipselabs.mscript.language.ast.LogicalOrExpression)
		 */
		@Override
		public IValue caseLogicalOrExpression(LogicalOrExpression logicalOrExpression) {
			IValue leftValue = doSwitch(logicalOrExpression.getLeftOperand());
			if (leftValue instanceof IBooleanValue) {
				IBooleanValue booleanResult = (IBooleanValue) leftValue;
				if (booleanResult.booleanValue()) {
					return Values.valueOf(context.getComputationContext(), true);
				}
			} else {
				throw new RuntimeException("Logical expression left operand must be boolean");
			}

			IValue rightValue = doSwitch(logicalOrExpression.getRightOperand());
			if (rightValue instanceof IBooleanValue) {
				IBooleanValue booleanResult = (IBooleanValue) rightValue;
				if (booleanResult.booleanValue()) {
					return Values.valueOf(context.getComputationContext(), true);
				}
			} else {
				throw new RuntimeException("Logical expression right operand must be boolean");
			}
			
			return Values.valueOf(context.getComputationContext(), false);
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseEqualityExpression(org.eclipselabs.mscript.language.ast.EqualityExpression)
		 */
		@Override
		public IValue caseEqualityExpression(EqualityExpression equalityExpression) {
			IValue result = null;
			switch (equalityExpression.getOperator()) {
			case EQUAL_TO:
				result = doSwitch(equalityExpression.getLeftOperand()).equalTo(doSwitch(equalityExpression.getRightOperand()));
				break;
			case NOT_EQUAL_TO:
				result = doSwitch(equalityExpression.getLeftOperand()).notEqualTo(doSwitch(equalityExpression.getRightOperand()));
				break;
			default:
				throw new IllegalArgumentException();
			}
			if (result instanceof InvalidValue) {
				throw new RuntimeException("Invalid equality operation operands");
			}
			return result;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRelationalExpression(org.eclipselabs.mscript.language.ast.RelationalExpression)
		 */
		@Override
		public IValue caseRelationalExpression(RelationalExpression relationalExpression) {
			IValue result = null;
			switch (relationalExpression.getOperator()) {
			case LESS_THAN:
				result = doSwitch(relationalExpression.getLeftOperand()).lessThan(doSwitch(relationalExpression.getRightOperand()));
				break;
			case LESS_THAN_OR_EQUAL_TO:
				result = doSwitch(relationalExpression.getLeftOperand()).lessThanOrEqualTo(doSwitch(relationalExpression.getRightOperand()));
				break;
			case GREATER_THAN:
				result = doSwitch(relationalExpression.getLeftOperand()).greaterThan(doSwitch(relationalExpression.getRightOperand()));
				break;
			case GREATER_THAN_OR_EQUAL_TO:
				result = doSwitch(relationalExpression.getLeftOperand()).greaterThanOrEqualTo(doSwitch(relationalExpression.getRightOperand()));
				break;
			default:
				throw new IllegalArgumentException();
			}
			if (result instanceof InvalidValue) {
				throw new RuntimeException("Invalid relational operation operands");
			}
			return result;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseTypeTestExpression(org.eclipselabs.mscript.language.ast.TypeTestExpression)
		 */
		@Override
		public IValue caseTypeTestExpression(TypeTestExpression typeTestExpression) {
			IValue value = doSwitch(typeTestExpression.getExpression());
			DataType dataType = EcoreUtil.copy(typeTestExpression.getTypeSpecifier().getType());
			return Values.valueOf(context.getComputationContext(), dataType.isAssignableFrom(value.getDataType()));
		}
	
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseUnaryExpression(org.eclipselabs.mscript.language.ast.UnaryExpression)
		 */
		@Override
		public IValue caseUnaryExpression(UnaryExpression unaryExpression) {
			IValue result;
			IValue operandValue = doSwitch(unaryExpression.getOperand());
			switch (unaryExpression.getOperator()) {
			case NEGATE:
				result = operandValue.negate();
				break;
			case LOGICAL_NOT:
				if (operandValue instanceof IBooleanValue) {
					IBooleanValue booleanResult = (IBooleanValue) operandValue;
					result = Values.valueOf(context.getComputationContext(), !booleanResult.booleanValue());
				} else {
					result = InvalidValue.SINGLETON;
				}
				break;
			default:
				throw new IllegalArgumentException();
			}
			if (result instanceof InvalidValue) {
				throw new RuntimeException("Invalid unary operation operand");
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
				IValue value = doSwitch(expression);
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
					return InvalidValue.SINGLETON;
				}
				elements[i] = value;
				++i;
			}
			
			ArrayType arrayType = createArrayType(elements);
			
			if (arrayType == null) {
				return InvalidValue.SINGLETON;
			}
			
			if (arrayType.isTensor()) {
				return new VectorValue(context.getComputationContext(), arrayType, (INumericValue[]) elements);
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
					matrix[row][column] = doSwitch(expression);
					++column;
				}
				++row;
			}
			
			return processMatrix(matrix, rowSize, columnSize);
		}
	
		public IValue processMatrix(IValue[][] matrix, int rowSize, int columnSize) {
			return InvalidValue.SINGLETON;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.util.MscriptSwitch#caseArrayElementAccess(org.eclipselabs.damos.mscript.ArrayElementAccess)
		 */
		@Override
		public IValue caseArrayElementAccess(ArrayElementAccess arrayElementAccess) {
			IValue value = doSwitch(arrayElementAccess.getArray());
			if (value == null) {
//				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "No value set for array", arrayElementAccess.getArray()));
				return InvalidValue.SINGLETON;
			}
			
			if (!(value.getDataType() instanceof ArrayType)) {
//				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Array element access is only applicable to arrays", arrayElementAccess.getArray()));
				return InvalidValue.SINGLETON;
			}
			
			ArrayType arrayType = (ArrayType) value.getDataType();

			if (arrayElementAccess.getSubscripts().size() != 1) {
//				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Array subscript dimensionality must be 1", arrayElementAccess));
				return InvalidValue.SINGLETON;
			}
			
			EList<ArrayDimension> dimensions = arrayType.getDimensions();
			if (dimensions.size() != 1) {
//				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Array dimensionality must be 1", arrayElementAccess));
				return InvalidValue.SINGLETON;
			}
			
			Expression sizeExpression = dimensions.get(0).getSize();
			IValue sizeValue = context.getStaticEvaluationContext().getValue(sizeExpression);
			// TODO: This has to be redesigned
			if (sizeValue == null) {
				sizeValue = doSwitch(sizeExpression);
			}
			if (sizeValue == null || !(sizeValue.getDataType() instanceof IntegerType) || !(sizeValue instanceof ISimpleNumericValue)) {
//				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Invalid array size data type", arrayElementAccess));
				return InvalidValue.SINGLETON;
			}
			
			int size = (int) ((ISimpleNumericValue) sizeValue).longValue();
			
			ArraySubscript subscript = arrayElementAccess.getSubscripts().get(0);
			if (subscript.getExpression() == null) {
//				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Array subscript not set", subscript));
				return InvalidValue.SINGLETON;
			}
			
			IValue subsciptValue = doSwitch(subscript.getExpression());
			if (!(subsciptValue.getDataType() instanceof IntegerType)) {
//				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Array subscript data type must be integer", arrayElementAccess));
				return InvalidValue.SINGLETON;
			}
			
			if (subsciptValue instanceof ISimpleNumericValue) {
				int index = (int) ((ISimpleNumericValue) subsciptValue).longValue();
				if (index < size) {
					if (value instanceof IArrayValue) {
						return ((IArrayValue) value).get(index);
					}
				} else {
//					status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Array subscript must be less than " + size, arrayElementAccess));
					return InvalidValue.SINGLETON;
				}
			}
			
//			return new AnyValue(context.getComputationContext(), arrayType.getElementType());
			return InvalidValue.SINGLETON;
		}
		
		@Override
		public IValue caseStructConstructionOperator(StructConstructionOperator structConstructionOperator) {
			StructType structType = MscriptFactory.eINSTANCE.createStructType();
			IValue[] values = new IValue[structConstructionOperator.getMembers().size()];
			
			boolean anyValue = false;

			{
				int i = 0;
				for (StructConstructionMember constructionMember : structConstructionOperator.getMembers()) {
					IValue value = doSwitch(constructionMember.getValue());
					
					if (value instanceof InvalidValue) {
						return InvalidValue.SINGLETON;
					}
					
					if (value instanceof AnyValue) {
						anyValue = true;
					}
					
					StructMember member = MscriptFactory.eINSTANCE.createStructMember();
					member.setName(constructionMember.getName());
					DataTypeSpecifier dataTypeSpecifier = MscriptFactory.eINSTANCE.createDataTypeSpecifier();
					dataTypeSpecifier.setAnonymousType(EcoreUtil.copy(value.getDataType()));
					member.setTypeSpecifier(dataTypeSpecifier);
					structType.getMembers().add(member);
					
					values[i++] = value;
				}
			}
			
			if (anyValue) {
				return InvalidValue.SINGLETON;
			}
			
			return new StructValue(context.getComputationContext(), structType, values);
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.util.MscriptSwitch#casePowerExpression(org.eclipselabs.damos.mscript.PowerExpression)
		 */
		@Override
		public IValue casePowerExpression(PowerExpression powerExpression) {
			IValue operandValue = doSwitch(powerExpression.getOperand());
			IValue exponentValue = doSwitch(powerExpression.getExponent());
			
			IValue result = operandValue.power(exponentValue);

			if (result instanceof InvalidValue) {
				throw new RuntimeException("Power operation cannot not be performed on provided operands");
			}
			
			return result;
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
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseParenthesizedExpression(org.eclipselabs.mscript.language.ast.ParenthesizedExpression)
		 */
		@Override
		public IValue caseParenthesizedExpression(ParenthesizedExpression parenthesizedExpression) {
			return doSwitch(parenthesizedExpression.getExpressions().get(0));
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.il.util.FunctionModelSwitch#caseFunctionCall(org.eclipselabs.mscript.language.il.FunctionCall)
		 */
		@Override
		public IValue caseFunctionCall(FunctionCall functionCall) {
			String name = functionCall.getFeature().getName();
			
			List<IValue> argumentValues = new ArrayList<IValue>();
			for (Expression argument : functionCall.getArguments()) {
				argumentValues.add(ExpressionValueEvaluatorSwitch.this.doSwitch(argument));
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
			
			return super.caseFunctionCall(functionCall);
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.util.MscriptSwitch#caseVariableAccess(org.eclipselabs.damos.mscript.VariableAccess)
		 */
		@Override
		public IValue caseVariableReference(VariableReference variableReference) {
			if (!(variableReference.getFeature() instanceof VariableDeclaration)) {
				throw new IllegalArgumentException();
			}
			VariableDeclaration variableDeclaration = (VariableDeclaration) variableReference.getFeature();
			
			IVariable variable = context.getVariable(variableDeclaration);
			int stepIndex = context.getStaticEvaluationContext().getStepIndex(variableReference);
			IValue result = variable.getValue(stepIndex);
			if (result == null) {
				return InvalidValue.SINGLETON;
			}
			return result;
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.util.MscriptSwitch#caseMemberVariableAccess(org.eclipselabs.damos.mscript.MemberVariableAccess)
		 */
		@Override
		public IValue caseMemberVariableAccess(MemberVariableAccess memberVariableAccess) {
			IValue value = doSwitch(memberVariableAccess.getTarget());
			if (value instanceof InvalidValue) {
				return InvalidValue.SINGLETON;
			}

			if (value == null) {
				return InvalidValue.SINGLETON;
			}
			
			if (!(value.getDataType() instanceof StructType)) {
				return InvalidValue.SINGLETON;
			}
			
			StructType structType = (StructType) value.getDataType();
			
			int memberIndex = structType.getMemberIndex(memberVariableAccess.getMemberVariable());
			if (memberIndex == -1) {
				return InvalidValue.SINGLETON;
			}
			
			if (!(value instanceof StructValue)) {
				return InvalidValue.SINGLETON;
			}
			
			return ((StructValue) value).get(memberIndex);
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
		 */
		@Override
		public IValue defaultCase(EObject object) {
			return InvalidValue.SINGLETON;
		}
	
	}
	
}
