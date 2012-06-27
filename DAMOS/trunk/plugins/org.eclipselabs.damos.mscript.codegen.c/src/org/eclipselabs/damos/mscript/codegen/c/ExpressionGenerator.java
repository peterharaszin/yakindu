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
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.mscript.AdditiveExpression;
import org.eclipselabs.damos.mscript.ArrayConstructionOperator;
import org.eclipselabs.damos.mscript.ArrayElementAccess;
import org.eclipselabs.damos.mscript.ArraySubscript;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.BooleanLiteral;
import org.eclipselabs.damos.mscript.CallableElement;
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
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.ParenthesizedExpression;
import org.eclipselabs.damos.mscript.PowerExpression;
import org.eclipselabs.damos.mscript.RealLiteral;
import org.eclipselabs.damos.mscript.RelationalExpression;
import org.eclipselabs.damos.mscript.SimpleStringLiteral;
import org.eclipselabs.damos.mscript.StructConstructionMember;
import org.eclipselabs.damos.mscript.StructConstructionOperator;
import org.eclipselabs.damos.mscript.StructType;
import org.eclipselabs.damos.mscript.UnaryExpression;
import org.eclipselabs.damos.mscript.VariableReference;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.ArrayConstructionFunction;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.ArrayElementWiseOperationFunction;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.ArrayScalarMultiplyFunction;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.MatrixMultiplyFunction;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.MatrixVectorMultiplyFunction;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.StructConstructionFunction;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.VectorMatrixMultiplyFunction;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineArrayType;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineDataTypes;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineNumericType;
import org.eclipselabs.damos.mscript.codegen.c.internal.VariableReferenceGenerator;
import org.eclipselabs.damos.mscript.codegen.c.internal.builtin.BuiltinFunctionGeneratorLookup;
import org.eclipselabs.damos.mscript.codegen.c.internal.builtin.IBuiltinFunctionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.internal.builtin.IBuiltinFunctionGeneratorLookup;
import org.eclipselabs.damos.mscript.codegen.c.util.MscriptGeneratorUtil;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.FloatingPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;
import org.eclipselabs.damos.mscript.computationmodel.util.ComputationModelUtil;
import org.eclipselabs.damos.mscript.interpreter.value.IArrayValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.InvalidValue;
import org.eclipselabs.damos.mscript.interpreter.value.StructValue;
import org.eclipselabs.damos.mscript.util.MscriptSwitch;
import org.eclipselabs.damos.mscript.util.TypeUtil;

public class ExpressionGenerator implements IExpressionGenerator {
	
	private final LiteralGenerator literalGenerator = new LiteralGenerator(new DataTypeGenerator());
	private final VariableReferenceGenerator variableReferenceGenerator = new VariableReferenceGenerator(literalGenerator);
	
	public CharSequence generate(IMscriptGeneratorContext context, Expression expression) {
		StringBuilder sb = new StringBuilder();
		new ExpressionGeneratorSwitch(context, sb).doSwitch(expression);
		return sb;
	}
	
	private class ExpressionGeneratorSwitch extends MscriptSwitch<Boolean> {

		private final IMultiplicativeExpressionGenerator multiplicativeExpressionGenerator = new InlineMultiplicativeExpressionGenerator();
		
		private IMscriptGeneratorContext context;
		private IBuiltinFunctionGeneratorLookup builtinFunctionGeneratorLookup = new BuiltinFunctionGeneratorLookup();
		
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
				generateCompareExpression(equalityExpression.getLeftOperand(), equalityExpression.getRightOperand(), equalityExpression.getOperator().getLiteral());
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
				generateCompareExpression(relationalExpression.getLeftOperand(), relationalExpression.getRightOperand(), relationalExpression.getOperator().getLiteral());
			} catch (IOException e) {
				throw new WrappedException(e);
			}
			return true;
		}
		
		private void generateCompareExpression(Expression leftOperand, Expression rightOperand, String operator) throws IOException {
			DataType leftDataType = getDataType(leftOperand);
			DataType rightDataType = getDataType(rightOperand);
			
			if (leftDataType instanceof NumericType && rightDataType instanceof NumericType) {
				DataType dataType1 = TypeUtil.getLeftHandDataType(leftDataType, rightDataType);
				DataType dataType2 = TypeUtil.getLeftHandDataType(rightDataType, leftDataType);
				
				NumberFormat numberFormat1 = context.getComputationModel().getNumberFormat(dataType1);
				NumberFormat numberFormat2 = context.getComputationModel().getNumberFormat(dataType2);
				
				NumberFormat widestNumberFormat = ComputationModelUtil.getWidestNumberFormat(numberFormat1, numberFormat2);
	
				out.print(MscriptGeneratorUtil.castNumericType(context, leftOperand, widestNumberFormat));
				out.print(" ");
				out.print(operator);
				out.print(" ");
				out.print(MscriptGeneratorUtil.castNumericType(context, rightOperand, widestNumberFormat));
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
			
			DataType leftDataType = getDataType(additiveExpression.getLeftOperand());
			DataType rightDataType = getDataType(additiveExpression.getRightOperand());

			if (TypeUtil.isNumericArray(leftDataType) && TypeUtil.isNumericArray(rightDataType)) {
				return generateArrayElementWiseExpression(additiveExpression);
			}
	
			out.print(MscriptGeneratorUtil.castNumericType(context, additiveExpression.getLeftOperand(), numberFormat));
			out.print(" ");
			out.print(additiveExpression.getOperator().getLiteral());
			out.print(" ");
			out.print(MscriptGeneratorUtil.castNumericType(context, additiveExpression.getRightOperand(), numberFormat));
			return true;
		}
		
		private Boolean generateArrayElementWiseExpression(AdditiveExpression additiveExpression) {
			MachineArrayType leftMatrixType = MachineDataTypes.create(context.getComputationModel(), (ArrayType) getDataType(additiveExpression.getLeftOperand()));
			MachineArrayType rightMatrixType = MachineDataTypes.create(context.getComputationModel(), (ArrayType) getDataType(additiveExpression.getRightOperand()));
			MachineArrayType resultType = MachineDataTypes.create(context.getComputationModel(), (ArrayType) getDataType(additiveExpression));
			OperatorKind operator = additiveExpression.getOperator();
			
			switch (additiveExpression.getOperator()) {
			case ELEMENT_WISE_ADD:
				operator = OperatorKind.ADD;
				break;
			case ELEMENT_WISE_SUBTRACT:
				operator = OperatorKind.SUBTRACT;
				break;
			case ELEMENT_WISE_MULTIPLY:
				operator = OperatorKind.MULTIPLY;
				break;
			case ELEMENT_WISE_DIVIDE:
				operator = OperatorKind.DIVIDE;
				break;
			case ELEMENT_WISE_MODULO:
				operator = OperatorKind.MODULO;
				break;
			default:
				break;
			}
			
			ArrayElementWiseOperationFunction codeFragment = context.getCodeFragmentCollector().addCodeFragment(new ArrayElementWiseOperationFunction(context.getComputationModel(), operator, leftMatrixType, rightMatrixType, resultType), new NullProgressMonitor());

			out.printf("%s(&(", codeFragment.getName());
			doSwitch(additiveExpression.getLeftOperand());
			out.print(").data[0], &(");
			doSwitch(additiveExpression.getRightOperand());
			out.print(").data[0])");
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
			
			if (leftDataType instanceof NumericType && TypeUtil.isNumericArray(rightDataType)) {
				return generateScalarMatrixMultiplyExpression(multiplicativeExpression, multiplicativeExpression.getLeftOperand(), multiplicativeExpression.getRightOperand());
			}
			if (TypeUtil.isNumericArray(leftDataType) && rightDataType instanceof NumericType) {
				return generateScalarMatrixMultiplyExpression(multiplicativeExpression, multiplicativeExpression.getRightOperand(), multiplicativeExpression.getLeftOperand());
			}
			
			if (TypeUtil.isNumericMatrix(leftDataType) && TypeUtil.isNumericMatrix(rightDataType)) {
				return generateMatrixMultiplyExpression(multiplicativeExpression, multiplicativeExpression.getLeftOperand(), multiplicativeExpression.getRightOperand());
			}
			
			if (TypeUtil.isNumericMatrix(leftDataType) && TypeUtil.isNumericVector(rightDataType)) {
				return generateMatrixVectorMultiplyExpression(multiplicativeExpression, multiplicativeExpression.getLeftOperand(), multiplicativeExpression.getRightOperand());
			}

			if (TypeUtil.isNumericVector(leftDataType) && TypeUtil.isNumericMatrix(rightDataType)) {
				return generateVectorMatrixMultiplyExpression(multiplicativeExpression, multiplicativeExpression.getLeftOperand(), multiplicativeExpression.getRightOperand());
			}

			INumericExpressionOperand leftOperand = new NumericExpressionOperand(context, multiplicativeExpression.getLeftOperand());
			INumericExpressionOperand rightOperand = new NumericExpressionOperand(context, multiplicativeExpression.getRightOperand());
			out.print(multiplicativeExpressionGenerator.generate(context.getCodeFragmentCollector(), multiplicativeExpression.getOperator(), numberFormat, leftOperand, rightOperand));

			return true;
		}

		private Boolean generateScalarMatrixMultiplyExpression(MultiplicativeExpression multiplicativeExpression, Expression scalarExpression,
				Expression arrayExpression) {
			MachineNumericType scalarType = MachineDataTypes.create(context.getComputationModel(), (NumericType) getDataType(scalarExpression));
			MachineArrayType arrayType = MachineDataTypes.create(context.getComputationModel(), (ArrayType) getDataType(arrayExpression));
			MachineArrayType resultType = MachineDataTypes.create(context.getComputationModel(), (ArrayType) getDataType(multiplicativeExpression));
			ArrayScalarMultiplyFunction codeFragment = context.getCodeFragmentCollector().addCodeFragment(new ArrayScalarMultiplyFunction(context.getComputationModel(), scalarType, arrayType, resultType), new NullProgressMonitor());
			out.printf("%s(", codeFragment.getName());
			doSwitch(scalarExpression);
			out.print(", &(");
			doSwitch(arrayExpression);
			out.print(").data[0])");
			return true;
		}

		private Boolean generateMatrixMultiplyExpression(MultiplicativeExpression multiplicativeExpression, Expression leftMatrixExpression,
				Expression rightMatrixExpression) {
			MachineArrayType leftMatrixType = MachineDataTypes.create(context.getComputationModel(), (ArrayType) getDataType(leftMatrixExpression));
			MachineArrayType rightMatrixType = MachineDataTypes.create(context.getComputationModel(), (ArrayType) getDataType(rightMatrixExpression));
			MachineArrayType resultType = MachineDataTypes.create(context.getComputationModel(), (ArrayType) getDataType(multiplicativeExpression));
			MatrixMultiplyFunction codeFragment = context.getCodeFragmentCollector().addCodeFragment(new MatrixMultiplyFunction(context.getComputationModel(), leftMatrixType, rightMatrixType, resultType), new NullProgressMonitor());
			out.printf("%s(&(", codeFragment.getName());
			doSwitch(leftMatrixExpression);
			out.print(").data[0], &(");
			doSwitch(rightMatrixExpression);
			out.print(").data[0])");
			return true;
		}

		private Boolean generateMatrixVectorMultiplyExpression(MultiplicativeExpression multiplicativeExpression, Expression matrixExpression,
				Expression vectorExpression) {
			MachineArrayType matrixType = MachineDataTypes.create(context.getComputationModel(), (ArrayType) getDataType(matrixExpression));
			MachineArrayType vectorType = MachineDataTypes.create(context.getComputationModel(), (ArrayType) getDataType(vectorExpression));
			MachineArrayType resultType = MachineDataTypes.create(context.getComputationModel(), (ArrayType) getDataType(multiplicativeExpression));
			MatrixVectorMultiplyFunction codeFragment = context.getCodeFragmentCollector().addCodeFragment(new MatrixVectorMultiplyFunction(context.getComputationModel(), matrixType, vectorType, resultType), new NullProgressMonitor());
			out.printf("%s(&(", codeFragment.getName());
			doSwitch(matrixExpression);
			out.print(").data[0], &(");
			doSwitch(vectorExpression);
			out.print(").data[0])");
			return true;
		}

		private Boolean generateVectorMatrixMultiplyExpression(MultiplicativeExpression multiplicativeExpression,
				Expression vectorExpression, Expression matrixExpression) {
			MachineArrayType vectorType = MachineDataTypes.create(context.getComputationModel(), (ArrayType) getDataType(vectorExpression));
			MachineArrayType matrixType = MachineDataTypes.create(context.getComputationModel(), (ArrayType) getDataType(matrixExpression));
			MachineArrayType resultType = MachineDataTypes.create(context.getComputationModel(), (ArrayType) getDataType(multiplicativeExpression));
			VectorMatrixMultiplyFunction codeFragment = context.getCodeFragmentCollector().addCodeFragment(new VectorMatrixMultiplyFunction(context.getComputationModel(), vectorType, matrixType, resultType), new NullProgressMonitor());
			out.printf("%s(&(", codeFragment.getName());
			doSwitch(vectorExpression);
			out.print(").data[0], &(");
			doSwitch(matrixExpression);
			out.print(").data[0])");
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
			if (unaryExpression.getOperator() == OperatorKind.NEGATE) {
				out.print("-");
			} else {
				out.print(unaryExpression.getOperator().getLiteral());
			}
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
				out.print(MscriptGeneratorUtil.castNumericType(context, powerExpression.getOperand(), numberFormat));
				out.print(", ");
				out.print(MscriptGeneratorUtil.castNumericType(context, powerExpression.getExponent(), numberFormat));
				out.printf(", %d)", fixedPointFormat.getFractionLength());
			} else if (numberFormat instanceof FloatingPointFormat) {
				out.print("pow(");
				out.print(MscriptGeneratorUtil.castNumericType(context, powerExpression.getOperand(), numberFormat));
				out.print(", ");
				out.print(MscriptGeneratorUtil.castNumericType(context, powerExpression.getExponent(), numberFormat));
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
			out.print(literalGenerator.generateLiteral(context.getComputationModel(), dataType, realLiteral.getValue()));
			return true;
		}
	
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIntegerLiteral(org.eclipselabs.mscript.language.ast.IntegerLiteral)
		 */
		@Override
		public Boolean caseIntegerLiteral(IntegerLiteral integerLiteral) {
			DataType dataType = getDataType(integerLiteral);
			out.print(literalGenerator.generateLiteral(context.getComputationModel(), dataType, integerLiteral.getValue()));
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
		
		@Override
		public Boolean caseSimpleStringLiteral(SimpleStringLiteral stringLiteral) {
			out.print("\"" + stringLiteral.getText() + "\"");
			return true;
		}
				
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.il.util.FunctionModelSwitch#caseFunctionCall(org.eclipselabs.mscript.language.il.FunctionCall)
		 */
		@Override
		public Boolean caseFunctionCall(FunctionCall functionCall) {
			CallableElement feature = functionCall.getFeature();
			if (feature == null || feature.eIsProxy() || feature.getName() == null) {
				return true;
			}
			
			IValue value = context.getStaticEvaluationResult().getValue(functionCall);
			if (value == null) {
				throw new IllegalStateException("No static value found for " + functionCall.getFeature().getName());
			}
			
			if (value instanceof InvalidValue) {
				return true;
			}

			IBuiltinFunctionGenerator generator = builtinFunctionGeneratorLookup.getFunctionGenerator(functionCall);
			if (generator != null) {
				out.print(generator.generate(context, functionCall));
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
			IValue value = context.getStaticEvaluationResult().getValue(arrayConstructionOperator);
			if (value instanceof IArrayValue) {
				out.print(literalGenerator.generateLiteral(context.getComputationModel(), context.getCodeFragmentCollector(), value));
			} else {
				ArrayType arrayType = (ArrayType) value.getDataType();
				ArrayConstructionFunction codeFragment = context.getCodeFragmentCollector().addCodeFragment(new ArrayConstructionFunction(context.getComputationModel(), MachineDataTypes.create(context.getComputationModel(), arrayType)), new NullProgressMonitor());
				out.print(codeFragment.getName());
				out.print("(");
				generateConstructArrayDimension(arrayType, 0, arrayConstructionOperator.getExpressions());
				out.print(")");
			}
			return true;
		}
		
		private void generateConstructArrayDimension(ArrayType arrayType, int dimension, List<Expression> expressions) {
			boolean first = true;
			for (Expression expression : expressions) {
				if (first) {
					first = false;
				} else {
					out.print(", ");
				}
				if (dimension == arrayType.getDimensionality() - 1) {
					out.print(MscriptGeneratorUtil.cast(context, expression, arrayType.getElementType()));
				} else {
					generateConstructArrayDimension(arrayType, dimension + 1, ((ArrayConstructionOperator) expression).getExpressions());
				}
			}
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.util.MscriptSwitch#caseStructConstructionOperator(org.eclipselabs.damos.mscript.StructConstructionOperator)
		 */
		@Override
		public Boolean caseStructConstructionOperator(StructConstructionOperator structConstructionOperator) {
			IValue value = context.getStaticEvaluationResult().getValue(structConstructionOperator);
			if (value instanceof StructValue) {
				out.print(literalGenerator.generateLiteral(context.getComputationModel(), context.getCodeFragmentCollector(), value));
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
			out.print(variableReferenceGenerator.generate(context, variableReference));
			return true;
		}

		private DataType getDataType(Expression expression) {
			return context.getStaticEvaluationResult().getValue(expression).getDataType();
		}
	
	}
	
}