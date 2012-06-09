/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.mscript.codegen.c;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.mscript.AdditiveExpression;
import org.eclipselabs.damos.mscript.ArrayConstructionOperator;
import org.eclipselabs.damos.mscript.ArrayElementAccess;
import org.eclipselabs.damos.mscript.ArraySubscript;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.BooleanLiteral;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.EqualityExpression;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.FunctionCall;
import org.eclipselabs.damos.mscript.ImpliesExpression;
import org.eclipselabs.damos.mscript.IntegerLiteral;
import org.eclipselabs.damos.mscript.LogicalAndExpression;
import org.eclipselabs.damos.mscript.LogicalOrExpression;
import org.eclipselabs.damos.mscript.MemberVariableAccess;
import org.eclipselabs.damos.mscript.MultiplicativeExpression;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.ParenthesizedExpression;
import org.eclipselabs.damos.mscript.PowerExpression;
import org.eclipselabs.damos.mscript.RealLiteral;
import org.eclipselabs.damos.mscript.RelationalExpression;
import org.eclipselabs.damos.mscript.StringLiteral;
import org.eclipselabs.damos.mscript.StructConstructionMember;
import org.eclipselabs.damos.mscript.StructConstructionOperator;
import org.eclipselabs.damos.mscript.StructType;
import org.eclipselabs.damos.mscript.UnaryExpression;
import org.eclipselabs.damos.mscript.VariableReference;
import org.eclipselabs.damos.mscript.builtin.BuiltinFunctionKind;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.ArrayConstructionFunction;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.ScalarMultiplyFunction;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.StructConstructionFunction;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineDataTypes;
import org.eclipselabs.damos.mscript.codegen.c.internal.VariableAccessGenerator;
import org.eclipselabs.damos.mscript.codegen.c.internal.builtin.BuiltinFunctionGeneratorLookupTable;
import org.eclipselabs.damos.mscript.codegen.c.internal.builtin.IBuiltinFunctionGeneratorLookupTable;
import org.eclipselabs.damos.mscript.codegen.c.internal.builtin.IFunctionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.util.MscriptGeneratorUtil;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.FloatingPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;
import org.eclipselabs.damos.mscript.computationmodel.util.ComputationModelUtil;
import org.eclipselabs.damos.mscript.interpreter.value.IArrayValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.StructValue;
import org.eclipselabs.damos.mscript.util.MscriptSwitch;
import org.eclipselabs.damos.mscript.util.TypeUtil;

public class ExpressionGenerator implements IExpressionGenerator {
	
	public CharSequence generate(IMscriptGeneratorContext context, Expression expression) {
		StringBuilder sb = new StringBuilder();
		new ExpressionGeneratorSwitch(context, sb).doSwitch(expression);
		return sb;
	}
	
	private static class ExpressionGeneratorSwitch extends MscriptSwitch<Boolean> {

		private final IMultiplicativeExpressionGenerator multiplicativeExpressionGenerator = new InlineMultiplicativeExpressionGenerator();
		
		private IMscriptGeneratorContext context;
		private IBuiltinFunctionGeneratorLookupTable builtinFunctionGeneratorLookupTable = new BuiltinFunctionGeneratorLookupTable();
		
		private PrintAppendable out;

		public ExpressionGeneratorSwitch(IMscriptGeneratorContext context, StringBuilder sb) {
			this.context = context;
			out = new PrintAppendable(sb);
		}
	
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseImpliesExpression(org.eclipselabs.mscript.language.ast.ImpliesExpression)
		 */
		@Override
		public Boolean caseImpliesExpression(ImpliesExpression impliesExpression) {
			out.print("(!(");
			doSwitch(impliesExpression.getLeftOperand());
			out.print(") || ");
			doSwitch(impliesExpression.getRightOperand());
			out.print(")");
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLogicalOrExpression(org.eclipselabs.mscript.language.ast.LogicalOrExpression)
		 */
		@Override
		public Boolean caseLogicalOrExpression(LogicalOrExpression logicalOrExpression) {
			doSwitch(logicalOrExpression.getLeftOperand());
			out.print(" || ");
			doSwitch(logicalOrExpression.getRightOperand());
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLogicalAndExpression(org.eclipselabs.mscript.language.ast.LogicalAndExpression)
		 */
		@Override
		public Boolean caseLogicalAndExpression(LogicalAndExpression logicalAndExpression) {
			doSwitch(logicalAndExpression.getLeftOperand());
			out.print(" && ");
			doSwitch(logicalAndExpression.getRightOperand());
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseEqualityExpression(org.eclipselabs.mscript.language.ast.EqualityExpression)
		 */
		@Override
		public Boolean caseEqualityExpression(EqualityExpression equalityExpression) {
			try {
				writeCompareExpression(equalityExpression.getLeftOperand(), equalityExpression.getRightOperand(), equalityExpression.getOperator().getLiteral());
			} catch (IOException e) {
				throw new WrappedException(e);
			}
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRelationalExpression(org.eclipselabs.mscript.language.ast.RelationalExpression)
		 */
		@Override
		public Boolean caseRelationalExpression(RelationalExpression relationalExpression) {
			try {
				writeCompareExpression(relationalExpression.getLeftOperand(), relationalExpression.getRightOperand(), relationalExpression.getOperator().getLiteral());
			} catch (IOException e) {
				throw new WrappedException(e);
			}
			return true;
		}
		
		private void writeCompareExpression(Expression leftOperand, Expression rightOperand, String operator) throws IOException {
			DataType leftDataType = getDataType(leftOperand);
			DataType rightDataType = getDataType(rightOperand);
			
			if (leftDataType instanceof NumericType && rightDataType instanceof NumericType) {
				DataType dataType1 = TypeUtil.getLeftHandDataType(leftDataType, rightDataType);
				DataType dataType2 = TypeUtil.getLeftHandDataType(rightDataType, leftDataType);
				
				NumberFormat numberFormat1 = context.getComputationModel().getNumberFormat(dataType1);
				NumberFormat numberFormat2 = context.getComputationModel().getNumberFormat(dataType2);
				
				NumberFormat widestNumberFormat = ComputationModelUtil.getWidestNumberFormat(numberFormat1, numberFormat2);
	
				out.print(MscriptGeneratorUtil.castNumericType(context, widestNumberFormat, leftOperand));
				out.print(" ");
				out.print(operator);
				out.print(" ");
				out.print(MscriptGeneratorUtil.castNumericType(context, widestNumberFormat, rightOperand));
			} else {
				doSwitch(leftOperand);
				out.print(" ");
				out.print(operator);
				out.print(" ");
				doSwitch(rightOperand);
			}
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseAdditiveExpression(org.eclipselabs.mscript.language.ast.AdditiveExpression)
		 */
		@Override
		public Boolean caseAdditiveExpression(AdditiveExpression additiveExpression) {
			DataType dataType = getDataType(additiveExpression);
			NumberFormat numberFormat = context.getComputationModel().getNumberFormat(dataType);
	
			out.print(MscriptGeneratorUtil.castNumericType(context, numberFormat, additiveExpression.getLeftOperand()));
			out.print(" ");
			out.print(additiveExpression.getOperator().getLiteral());
			out.print(" ");
			out.print(MscriptGeneratorUtil.castNumericType(context, numberFormat, additiveExpression.getRightOperand()));
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseMultiplicativeExpression(org.eclipselabs.mscript.language.ast.MultiplicativeExpression)
		 */
		@Override
		public Boolean caseMultiplicativeExpression(final MultiplicativeExpression multiplicativeExpression) {
			NumberFormat numberFormat = context.getComputationModel().getNumberFormat(getDataType(multiplicativeExpression));

			DataType leftDataType = getDataType(multiplicativeExpression.getLeftOperand());
			DataType rightDataType = getDataType(multiplicativeExpression.getRightOperand());
			
			if (leftDataType instanceof NumericType && TypeUtil.isTensor(rightDataType)) {
				return writeScalarMultiplicativeExpression(multiplicativeExpression, multiplicativeExpression.getLeftOperand(), multiplicativeExpression.getRightOperand());
			}
			if (TypeUtil.isTensor(leftDataType) && rightDataType instanceof NumericType) {
				return writeScalarMultiplicativeExpression(multiplicativeExpression, multiplicativeExpression.getRightOperand(), multiplicativeExpression.getLeftOperand());
			}
			
			NumberFormat leftNumberFormat = context.getComputationModel().getNumberFormat(leftDataType);
			NumberFormat rightNumberFormat = context.getComputationModel().getNumberFormat(rightDataType);
			
			IExpressionGenerator expressionGenerator = new ExpressionGenerator();
			NumericExpressionInfo leftOperand = NumericExpressionInfo.create(leftNumberFormat, expressionGenerator.generate(context, multiplicativeExpression.getLeftOperand()));
			NumericExpressionInfo rightOperand = NumericExpressionInfo.create(rightNumberFormat, expressionGenerator.generate(context, multiplicativeExpression.getRightOperand()));
			out.print(multiplicativeExpressionGenerator.generate(context.getCodeFragmentCollector(), multiplicativeExpression.getOperator(), numberFormat, leftOperand, rightOperand));

			return true;
		}
	
		/**
		 * @param operator
		 * @param scalarExpression
		 * @param tensorExpression
		 * @return
		 */
		private Boolean writeScalarMultiplicativeExpression(MultiplicativeExpression multiplicativeExpression, Expression scalarExpression,
				Expression tensorExpression) {
			DataType scalarType = EcoreUtil.copy(getDataType(scalarExpression));
			ArrayType arrayType = (ArrayType) getDataType(tensorExpression);
			DataType elementType = EcoreUtil.copy(arrayType.getElementType());
			ArrayType resultType = EcoreUtil.copy((ArrayType) getDataType(multiplicativeExpression));
			ScalarMultiplyFunction codeFragment = (ScalarMultiplyFunction) context.getCodeFragmentCollector().addCodeFragment(new ScalarMultiplyFunction(context.getComputationModel(), scalarType, elementType, resultType), new NullProgressMonitor());
			out.printf("%s(", codeFragment.getName());
			doSwitch(scalarExpression);
			out.print(", &(");
			doSwitch(tensorExpression);
			out.printf(").data[0], %d)", TypeUtil.getArraySize(arrayType));
			return true;
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseParenthesizedExpression(org.eclipselabs.mscript.language.ast.ParenthesizedExpression)
		 */
		@Override
		public Boolean caseParenthesizedExpression(ParenthesizedExpression parenthesizedExpression) {
			out.print("(");
			doSwitch(parenthesizedExpression.getExpressions().get(0));
			out.print(")");
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseUnaryExpression(org.eclipselabs.mscript.language.ast.UnaryExpression)
		 */
		@Override
		public Boolean caseUnaryExpression(UnaryExpression unaryExpression) {
			out.print(unaryExpression.getOperator().getLiteral());
			doSwitch(unaryExpression.getOperand());
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.util.MscriptSwitch#casePowerExpression(org.eclipselabs.damos.mscript.PowerExpression)
		 */
		@Override
		public Boolean casePowerExpression(PowerExpression powerExpression) {
			DataType dataType = getDataType(powerExpression);
			NumberFormat numberFormat = context.getComputationModel().getNumberFormat(dataType);
	
			if (numberFormat instanceof FixedPointFormat) {
				FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
				if (fixedPointFormat.getWordSize() > 32) {
					out.print("DamosMath_powfix32(");
				} else {
					out.print("DamosMath_powfix64(");
				}
				out.print(MscriptGeneratorUtil.castNumericType(context, numberFormat, powerExpression.getOperand()));
				out.print(", ");
				out.print(MscriptGeneratorUtil.castNumericType(context, numberFormat, powerExpression.getExponent()));
				out.printf(", %d)", fixedPointFormat.getFractionLength());
			} else if (numberFormat instanceof FloatingPointFormat) {
				out.print("pow(");
				out.print(MscriptGeneratorUtil.castNumericType(context, numberFormat, powerExpression.getOperand()));
				out.print(", ");
				out.print(MscriptGeneratorUtil.castNumericType(context, numberFormat, powerExpression.getExponent()));
				out.print(")");
			}

			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRealLiteral(org.eclipselabs.mscript.language.ast.RealLiteral)
		 */
		@Override
		public Boolean caseRealLiteral(RealLiteral realLiteral) {
			DataType dataType = getDataType(realLiteral);
			out.print(MscriptGeneratorUtil.getLiteralString(context, dataType, realLiteral.getValue(), null));
			return true;
		}
	
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIntegerLiteral(org.eclipselabs.mscript.language.ast.IntegerLiteral)
		 */
		@Override
		public Boolean caseIntegerLiteral(IntegerLiteral integerLiteral) {
			DataType dataType = getDataType(integerLiteral);
			out.print(MscriptGeneratorUtil.getLiteralString(context, dataType, integerLiteral.getValue(), null));
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseBooleanLiteral(org.eclipselabs.mscript.language.ast.BooleanLiteral)
		 */
		@Override
		public Boolean caseBooleanLiteral(BooleanLiteral booleanLiteral) {
			out.print(booleanLiteral.isTrue() ? "1" : "0");
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseStringLiteral(org.eclipselabs.mscript.language.ast.StringLiteral)
		 */
		@Override
		public Boolean caseStringLiteral(StringLiteral stringLiteral) {
			out.print("\"" + stringLiteral.getValue() + "\"");
			return true;
		}
				
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.il.util.FunctionModelSwitch#caseFunctionCall(org.eclipselabs.mscript.language.il.FunctionCall)
		 */
		@Override
		public Boolean caseFunctionCall(FunctionCall functionCall) {
			String name = functionCall.getFeature().getName();

			List<DataType> inputParameterDataTypes = new ArrayList<DataType>();
			for (Expression argument : functionCall.getArguments()) {
				inputParameterDataTypes.add(getDataType(argument));
			}
			BuiltinFunctionKind descriptor = BuiltinFunctionKind.get(name, inputParameterDataTypes);
			if (descriptor != null) {
				IFunctionGenerator generator = builtinFunctionGeneratorLookupTable.getFunctionGenerator(descriptor);
				if (generator != null) {
					out.print(generator.generate(context, functionCall));
				}
			}

			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.util.MscriptSwitch#caseArrayElementAccess(org.eclipselabs.damos.mscript.ArrayElementAccess)
		 */
		@Override
		public Boolean caseArrayElementAccess(ArrayElementAccess arrayElementAccess) {
			doSwitch(arrayElementAccess.getArray());
			out.print(".data");
			for (ArraySubscript subscript : arrayElementAccess.getSubscripts()) {
				out.print("[");
				doSwitch(subscript.getExpression());
				out.print("]");
			}
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.util.MscriptSwitch#caseArrayConstructionOperator(org.eclipselabs.damos.mscript.ArrayConstructionOperator)
		 */
		@Override
		public Boolean caseArrayConstructionOperator(ArrayConstructionOperator arrayConstructionOperator) {
			IValue value = context.getStaticEvaluationContext().getValue(arrayConstructionOperator);
			if (value instanceof IArrayValue) {
				out.print(MscriptGeneratorUtil.getLiteralString(context, value));
			} else {
				ArrayConstructionFunction codeFragment = (ArrayConstructionFunction) context.getCodeFragmentCollector().addCodeFragment(new ArrayConstructionFunction(context.getComputationModel(), MachineDataTypes.create(context.getComputationModel(), (ArrayType) value.getDataType())), new NullProgressMonitor());
				out.print(codeFragment.getName());
				out.print("(");
				boolean first = true;
				for (Expression expression : arrayConstructionOperator.getExpressions()) {
					if (first) {
						first = false;
					} else {
						out.print(", ");
					}
					doSwitch(expression);
				}
				out.print(")");
			}
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.util.MscriptSwitch#caseStructConstructionOperator(org.eclipselabs.damos.mscript.StructConstructionOperator)
		 */
		@Override
		public Boolean caseStructConstructionOperator(StructConstructionOperator structConstructionOperator) {
			IValue value = context.getStaticEvaluationContext().getValue(structConstructionOperator);
			if (value instanceof StructValue) {
				out.print(MscriptGeneratorUtil.getLiteralString(context, value));
			} else {
				StructConstructionFunction codeFragment = (StructConstructionFunction) context.getCodeFragmentCollector().addCodeFragment(new StructConstructionFunction(context.getComputationModel(), MachineDataTypes.create(context.getComputationModel(), (StructType) value.getDataType())), new NullProgressMonitor());
				out.print(codeFragment.getName());
				out.print("(");
				boolean first = true;
				for (StructConstructionMember member : structConstructionOperator.getMembers()) {
					if (first) {
						first = false;
					} else {
						out.print(", ");
					}
					doSwitch(member.getValue());
				}
				out.print(")");
			}
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.util.MscriptSwitch#caseMemberVariableAccess(org.eclipselabs.damos.mscript.MemberVariableAccess)
		 */
		@Override
		public Boolean caseMemberVariableAccess(MemberVariableAccess memberVariableAccess) {
			doSwitch(memberVariableAccess.getTarget());
			out.print(".");
			out.print(memberVariableAccess.getMemberVariable());
			return true;
		}

		public Boolean caseVariableReference(VariableReference variableReference) {
			out.print(new VariableAccessGenerator(context, variableReference).generate());
			return true;
		}

		private DataType getDataType(Expression expression) {
			return context.getStaticEvaluationContext().getValue(expression).getDataType();
		}
	
	}
	
}