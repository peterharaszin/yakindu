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

package org.eclipse.damos.mscript.codegen.c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.damos.mscript.AdditiveExpression;
import org.eclipse.damos.mscript.AlgorithmExpression;
import org.eclipse.damos.mscript.ArrayConcatenationOperator;
import org.eclipse.damos.mscript.ArrayConstructionOperator;
import org.eclipse.damos.mscript.ArrayElementAccess;
import org.eclipse.damos.mscript.ArraySubscript;
import org.eclipse.damos.mscript.BooleanLiteral;
import org.eclipse.damos.mscript.CallableElement;
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
import org.eclipse.damos.mscript.InputParameterDeclaration;
import org.eclipse.damos.mscript.InspectExpression;
import org.eclipse.damos.mscript.IntegerLiteral;
import org.eclipse.damos.mscript.InvalidExpression;
import org.eclipse.damos.mscript.LambdaExpression;
import org.eclipse.damos.mscript.LetExpression;
import org.eclipse.damos.mscript.LogicalAndExpression;
import org.eclipse.damos.mscript.LogicalOrExpression;
import org.eclipse.damos.mscript.MemberVariableAccess;
import org.eclipse.damos.mscript.MscriptFactory;
import org.eclipse.damos.mscript.MultiplicativeExpression;
import org.eclipse.damos.mscript.NumericType;
import org.eclipse.damos.mscript.OperatorKind;
import org.eclipse.damos.mscript.ParenthesizedExpression;
import org.eclipse.damos.mscript.PowerExpression;
import org.eclipse.damos.mscript.RangeExpression;
import org.eclipse.damos.mscript.RealLiteral;
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
import org.eclipse.damos.mscript.UnitConstructionOperator;
import org.eclipse.damos.mscript.codegen.c.codefragments.ComputeFunction;
import org.eclipse.damos.mscript.codegen.c.codefragments.ConstantStringSegment;
import org.eclipse.damos.mscript.codegen.c.codefragments.ContextStruct;
import org.eclipse.damos.mscript.codegen.c.codefragments.ExpressionStringSegment;
import org.eclipse.damos.mscript.codegen.c.codefragments.FunctionContextStructMember;
import org.eclipse.damos.mscript.codegen.c.codefragments.IStringSegment;
import org.eclipse.damos.mscript.codegen.c.codefragments.InitializeFunction;
import org.eclipse.damos.mscript.codegen.c.codefragments.RecordConstructionFunction;
import org.eclipse.damos.mscript.codegen.c.codefragments.StringConstructionFunction;
import org.eclipse.damos.mscript.codegen.c.codefragments.StringEqualToFunction;
import org.eclipse.damos.mscript.codegen.c.codefragments.StringTable;
import org.eclipse.damos.mscript.codegen.c.codefragments.UpdateFunction;
import org.eclipse.damos.mscript.codegen.c.codefragments.factories.IComputeFunctionFactory;
import org.eclipse.damos.mscript.codegen.c.datatype.MachineDataTypes;
import org.eclipse.damos.mscript.codegen.c.internal.VariableReferenceGenerator;
import org.eclipse.damos.mscript.codegen.c.internal.builtin.IBuiltinFunctionGenerator;
import org.eclipse.damos.mscript.codegen.c.internal.builtin.IBuiltinFunctionGeneratorLookup;
import org.eclipse.damos.mscript.codegen.c.util.CastHelper;
import org.eclipse.damos.mscript.computation.FixedPointFormat;
import org.eclipse.damos.mscript.computation.FloatingPointFormat;
import org.eclipse.damos.mscript.computation.NumberFormat;
import org.eclipse.damos.mscript.computation.util.ComputationModelUtil;
import org.eclipse.damos.mscript.function.util.FunctionModelUtil;
import org.eclipse.damos.mscript.interpreter.StaticFunctionInfo;
import org.eclipse.damos.mscript.interpreter.value.IArrayValue;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.mscript.interpreter.value.InvalidValue;
import org.eclipse.damos.mscript.interpreter.value.RecordValue;
import org.eclipse.damos.mscript.interpreter.value.StringValue;
import org.eclipse.damos.mscript.util.TypeUtil;

import com.google.inject.Inject;

public class ExpressionGenerator implements IExpressionGenerator, IExpressionVisitor<CharSequence, IMscriptGeneratorContext> {
	
	@Inject
	private CastHelper castHelper;
	
	@Inject
	private IComputeFunctionFactory computeFunctionFactory;
	
	@Inject
	private INumericExpressionOperandFactory numericExpressionOperandFactory;
	
	@Inject
	private LiteralGenerator literalGenerator;
	
	@Inject
	private IMultiplicativeExpressionGenerator multiplicativeExpressionGenerator;
	
	@Inject
	private VariableReferenceGenerator variableReferenceGenerator;
	
	@Inject
	private IBuiltinFunctionGeneratorLookup builtinFunctionGeneratorLookup;
	
	@Inject
	private IDefaultVariableAccessStrategyFactory defaultVariableAccessStrategyFactory;
	
	public CharSequence generate(IMscriptGeneratorContext context, Expression expression) {
		return expression.accept(context, this);
	}
	
	@Override
	public CharSequence visit(IMscriptGeneratorContext context, LetExpression letExpression) {
		return "";
	}

	@Override
	public CharSequence visit(IMscriptGeneratorContext context, IfExpression ifExpression) {
		return "";
	}

	@Override
	public CharSequence visit(IMscriptGeneratorContext context, InspectExpression inspectExpression) {
		return "";
	}

	@Override
	public CharSequence visit(IMscriptGeneratorContext context, RangeExpression rangeExpression) {
		return "";
	}

	@Override
	public CharSequence visit(IMscriptGeneratorContext context, ImpliesExpression impliesExpression) {
		StringBuilder sb = new StringBuilder();
		sb.append("(!(");
		sb.append(generate(context, impliesExpression.getLeftOperand()));
		sb.append(") || ");
		sb.append(generate(context, impliesExpression.getRightOperand()));
		sb.append(")");
		return sb;
	}

	@Override
	public CharSequence visit(IMscriptGeneratorContext context, LogicalOrExpression logicalOrExpression) {
		StringBuilder sb = new StringBuilder();
		sb.append(generate(context, logicalOrExpression.getLeftOperand()));
		sb.append(" || ");
		sb.append(generate(context, logicalOrExpression.getRightOperand()));
		return sb;
	}

	@Override
	public CharSequence visit(IMscriptGeneratorContext context, LogicalAndExpression logicalAndExpression) {
		StringBuilder sb = new StringBuilder();
		sb.append(generate(context, logicalAndExpression.getLeftOperand()));
		sb.append(" && ");
		sb.append(generate(context, logicalAndExpression.getRightOperand()));
		return sb;
	}

	@Override
	public CharSequence visit(IMscriptGeneratorContext context, EqualityExpression equalityExpression) {
		Type leftDataType = getDataType(context, equalityExpression.getLeftOperand());
		Type rightDataType = getDataType(context, equalityExpression.getRightOperand());

		if (leftDataType instanceof StringType && rightDataType instanceof StringType) {
			StringBuilder sb = new StringBuilder();
			StringEqualToFunction stringEqualToFunction = context.getCodeFragmentCollector().addCodeFragment(new StringEqualToFunction(context.getConfiguration().getStringBufferSize()), new NullProgressMonitor());
			if (equalityExpression.getOperator() == OperatorKind.NOT_EQUAL_TO) {
				sb.append("!");
			}
			sb.append(stringEqualToFunction.getName());
			sb.append("(");
			sb.append("&(");
			sb.append(generate(context, equalityExpression.getLeftOperand()));
			sb.append(").data[0], &(");
			sb.append(generate(context, equalityExpression.getRightOperand()));
			sb.append(").data[0])");
			return sb;
		}
		
		return generateCompareExpression(context, equalityExpression.getLeftOperand(), equalityExpression.getRightOperand(), equalityExpression.getOperator().getLiteral());
	}

	@Override
	public CharSequence visit(IMscriptGeneratorContext context, RelationalExpression relationalExpression) {
		return generateCompareExpression(context, relationalExpression.getLeftOperand(), relationalExpression.getRightOperand(), relationalExpression.getOperator().getLiteral());
	}

	private CharSequence generateCompareExpression(IMscriptGeneratorContext context, Expression leftOperand, Expression rightOperand, String operator) {
		StringBuilder sb = new StringBuilder();
		
		Type leftDataType = getDataType(context, leftOperand);
		Type rightDataType = getDataType(context, rightOperand);
		
		if (leftDataType instanceof NumericType && rightDataType instanceof NumericType) {
			Type dataType1 = TypeUtil.getLeftHandDataType(leftDataType, rightDataType);
			Type dataType2 = TypeUtil.getLeftHandDataType(rightDataType, leftDataType);
			
			NumberFormat numberFormat1 = context.getConfiguration().getComputationModel().getNumberFormat(dataType1);
			NumberFormat numberFormat2 = context.getConfiguration().getComputationModel().getNumberFormat(dataType2);
			
			NumberFormat widestNumberFormat = ComputationModelUtil.getWidestNumberFormat(numberFormat1, numberFormat2);

			sb.append(castHelper.castNumericType(context, leftOperand, widestNumberFormat));
			sb.append(" ");
			sb.append(operator);
			sb.append(" ");
			sb.append(castHelper.castNumericType(context, rightOperand, widestNumberFormat));
		} else {
			sb.append(generate(context, leftOperand));
			sb.append(" ");
			sb.append(operator);
			sb.append(" ");
			sb.append(generate(context, rightOperand));
		}
		
		return sb;
	}

	@Override
	public CharSequence visit(IMscriptGeneratorContext context, TypeTestExpression typeTestExpression) {
		return "";
	}

	@Override
	public CharSequence visit(IMscriptGeneratorContext context, AdditiveExpression additiveExpression) {
		StringBuilder sb = new StringBuilder();
		
		Type type = getDataType(context, additiveExpression);
		NumberFormat numberFormat = context.getConfiguration().getComputationModel().getNumberFormat(type);
		
		Type leftDataType = getDataType(context, additiveExpression.getLeftOperand());
		Type rightDataType = getDataType(context, additiveExpression.getRightOperand());
		
		if (leftDataType instanceof StringType || rightDataType instanceof StringType) {
			IValue leftValue = context.getFunctionInfo().getValue(additiveExpression.getLeftOperand());
			if (leftValue == null || leftValue instanceof InvalidValue) {
				return sb;
			}
			IValue leftConvertedValue = leftValue.convert(MscriptFactory.eINSTANCE.createStringType());
			if (leftConvertedValue instanceof InvalidValue) {
				return sb;
			}
			IStringSegment leftStringSegment = new ExpressionStringSegment(leftConvertedValue instanceof StringValue, MachineDataTypes.create(context.getConfiguration(), leftValue.getDataType()));

			IValue rightValue = context.getFunctionInfo().getValue(additiveExpression.getRightOperand());
			if (rightValue == null || rightValue instanceof InvalidValue) {
				return sb;
			}
			IValue rightConvertedValue = rightValue.convert(MscriptFactory.eINSTANCE.createStringType());
			if (rightConvertedValue instanceof InvalidValue) {
				return sb;
			}
			IStringSegment rightStringSegment = new ExpressionStringSegment(rightConvertedValue instanceof StringValue, MachineDataTypes.create(context.getConfiguration(), rightValue.getDataType()));

			if (leftStringSegment == null || rightStringSegment == null) {
				return sb;
			}
			
			List<IStringSegment> stringSegments = new ArrayList<IStringSegment>();
			stringSegments.add(leftStringSegment);
			stringSegments.add(rightStringSegment);
			StringConstructionFunction codeFragment = context.getCodeFragmentCollector().addCodeFragment(new StringConstructionFunction(context.getConfiguration(), stringSegments, true), new NullProgressMonitor());
			StringTable stringTable = context.getCodeFragmentCollector().addCodeFragment(new StringTable(), new NullProgressMonitor());

			sb.append(codeFragment.getName());
			sb.append("(");

			if (leftConvertedValue instanceof StringValue) {
				sb.append(Integer.toString(stringTable.addString(leftConvertedValue.toString())));
			} else {
				if (rightDataType instanceof StringType) {
					sb.append("&(");
				}
				sb.append(generate(context, additiveExpression.getLeftOperand()));
				if (rightDataType instanceof StringType) {
					sb.append(").data[0]");
				}
			}
			
			sb.append(", ");

			if (rightConvertedValue instanceof StringValue) {
				sb.append(Integer.toString(stringTable.addString(rightConvertedValue.toString())));
			} else {
				if (rightDataType instanceof StringType) {
					sb.append("&(");
				}
				sb.append(generate(context, additiveExpression.getRightOperand()));
				if (rightDataType instanceof StringType) {
					sb.append(").data[0]");
				}
			}
			
			sb.append(")");
		} else {
			sb.append(castHelper.castNumericType(context, additiveExpression.getLeftOperand(), numberFormat));
			sb.append(" ");
			sb.append(additiveExpression.getOperator().getLiteral());
			sb.append(" ");
			sb.append(castHelper.castNumericType(context, additiveExpression.getRightOperand(), numberFormat));
		}
		
		return sb;
	}

	@Override
	public CharSequence visit(IMscriptGeneratorContext context, MultiplicativeExpression multiplicativeExpression) {
		NumberFormat numberFormat = context.getConfiguration().getComputationModel().getNumberFormat(getDataType(context, multiplicativeExpression));

		INumericExpressionOperand leftOperand = numericExpressionOperandFactory.create(context, multiplicativeExpression.getLeftOperand());
		INumericExpressionOperand rightOperand = numericExpressionOperandFactory.create(context, multiplicativeExpression.getRightOperand());
		
		return multiplicativeExpressionGenerator.generate(context.getCodeFragmentCollector(), multiplicativeExpression.getOperator(), numberFormat, leftOperand, rightOperand);
	}

	@Override
	public CharSequence visit(IMscriptGeneratorContext context, UnaryExpression unaryExpression) {
		StringBuilder sb = new StringBuilder();
		if (unaryExpression.getOperator() == OperatorKind.NEGATE) {
			sb.append("-");
		} else {
			sb.append(unaryExpression.getOperator().getLiteral());
		}
		sb.append(generate(context, unaryExpression.getOperand()));
		return sb;
	}

	@Override
	public CharSequence visit(IMscriptGeneratorContext context, ArrayConstructionOperator arrayConstructionOperator) {
		IValue value = context.getFunctionInfo().getValue(arrayConstructionOperator);
		if (value instanceof IArrayValue) {
			return literalGenerator.generateLiteral(context.getConfiguration(), context.getCodeFragmentCollector(), value);
		}
		return "";
	}

	@Override
	public CharSequence visit(IMscriptGeneratorContext context, ArrayConcatenationOperator arrayConcatenationOperator) {
		return "";
	}

	@Override
	public CharSequence visit(IMscriptGeneratorContext context, RecordConstructionOperator recordConstructionOperator) {
		StringBuilder sb = new StringBuilder();
		IValue value = context.getFunctionInfo().getValue(recordConstructionOperator);
		if (value instanceof RecordValue) {
			sb.append(literalGenerator.generateLiteral(context.getConfiguration(), context.getCodeFragmentCollector(), value));
		} else {
			RecordConstructionFunction codeFragment = (RecordConstructionFunction) context.getCodeFragmentCollector().addCodeFragment(new RecordConstructionFunction(MachineDataTypes.create(context.getConfiguration(), (RecordType) value.getDataType())), new NullProgressMonitor());
			sb.append(codeFragment.getName());
			sb.append("(");
			boolean first = true;
			for (RecordConstructionMember member : recordConstructionOperator.getMembers()) {
				if (first) {
					first = false;
				} else {
					sb.append(", ");
				}
				sb.append(generate(context, member.getValue()));
			}
			sb.append(")");
		}
		return sb;
	}

	@Override
	public CharSequence visit(IMscriptGeneratorContext context, UnionConstructionOperator unionConstructionOperator) {
		return "";
	}

	@Override
	public CharSequence visit(IMscriptGeneratorContext context, UnitConstructionOperator unitConstructionOperator) {
		return "";
	}

	@Override
	public CharSequence visit(IMscriptGeneratorContext context, PowerExpression powerExpression) {
		StringBuilder sb = new StringBuilder();
		Type type = getDataType(context, powerExpression);
		NumberFormat numberFormat = context.getConfiguration().getComputationModel().getNumberFormat(type);

		if (numberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			if (fixedPointFormat.getWordSize() > 32) {
				sb.append("DamosMath_powfix32(");
			} else {
				sb.append("DamosMath_powfix64(");
			}
			sb.append(castHelper.castNumericType(context, powerExpression.getLeftOperand(), numberFormat));
			sb.append(", ");
			sb.append(castHelper.castNumericType(context, powerExpression.getRightOperand(), numberFormat));
			sb.append(", ");
			sb.append(fixedPointFormat.getFractionLength());
			sb.append(")");
		} else if (numberFormat instanceof FloatingPointFormat) {
			sb.append("pow(");
			sb.append(castHelper.castNumericType(context, powerExpression.getLeftOperand(), numberFormat));
			sb.append(", ");
			sb.append(castHelper.castNumericType(context, powerExpression.getRightOperand(), numberFormat));
			sb.append(")");
		}
		return sb;
	}

	@Override
	public CharSequence visit(IMscriptGeneratorContext context, ParenthesizedExpression parenthesizedExpression) {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		sb.append(generate(context, parenthesizedExpression.getExpressions().get(0)));
		sb.append(")");
		return sb;
	}

	@Override
	public CharSequence visit(IMscriptGeneratorContext context, ArrayElementAccess arrayElementAccess) {
		StringBuilder sb = new StringBuilder();
		sb.append(generate(context, arrayElementAccess.getArray()));
		for (ArraySubscript subscript : arrayElementAccess.getSubscripts()) {
			sb.append("[");
			sb.append(generate(context, subscript.getExpression()));
			sb.append("]");
		}
		return sb;
	}

	@Override
	public CharSequence visit(IMscriptGeneratorContext context, FeatureReference featureReference) {
		return variableReferenceGenerator.generate(context, featureReference);
	}

	@Override
	public CharSequence visit(IMscriptGeneratorContext context, MemberVariableAccess memberVariableAccess) {
		StringBuilder sb = new StringBuilder();
		sb.append(generate(context, memberVariableAccess.getTarget()));
		sb.append(".");
		sb.append(memberVariableAccess.getMemberVariable());
		return sb;
	}

	@Override
	public CharSequence visit(IMscriptGeneratorContext context, FunctionCall functionCall) {
		CallableElement feature = functionCall.getFeature();
		if (feature == null || feature.eIsProxy() || feature.getName() == null) {
			return "";
		}
		
		StaticFunctionInfo functionInfo = context.getFunctionInfo();
		IValue value = functionInfo.getValue(functionCall);
		if (value == null) {
			throw new IllegalStateException("No static value found for " + functionCall.getFeature().getName());
		}
		
		if (value instanceof InvalidValue) {
			return "";
		}

		IBuiltinFunctionGenerator generator = builtinFunctionGeneratorLookup.getFunctionGenerator(functionCall);
		if (generator != null) {
			return generator.generate(context, functionCall);
		}
		
		StaticFunctionInfo callee = functionInfo.getCallee(functionCall);
		IVariableAccessStrategy variableAccessStrategy = defaultVariableAccessStrategyFactory.create(context.getConfiguration(), callee, context.getSampleInterval());
		MscriptGeneratorContext calleeGeneratorContext = new MscriptGeneratorContext(context.getConfiguration(), callee, context.getSampleInterval(), variableAccessStrategy, context.getCodeFragmentCollector());
		ComputeFunction computeFunction = context.getCodeFragmentCollector().addCodeFragment((ComputeFunction) computeFunctionFactory.create(calleeGeneratorContext), new NullProgressMonitor());
		
		FunctionContextStructMember functionContextStructMember = FunctionContextStructMember.initialize(context, computeFunction, calleeGeneratorContext.getFunctionInfo(), context.getFunctionInfo());
		
		if (functionContextStructMember != null) {
			ContextStruct contextStruct = context.getCodeFragmentCollector().addCodeFragment(new ContextStruct(context.getFunctionInfo(), false /* TODO */), new NullProgressMonitor());

			{
				InitializeFunction initializeFunction = computeFunction.getInitializeFunction();
				StringBuilder sb = new StringBuilder();
				sb.append(initializeFunction.getName());
				sb.append("(");
				if (functionContextStructMember != null) {
					sb.append(context.getVariableAccessStrategy().generateContextMemberAccess(true, functionContextStructMember.getName()));
				}
				sb.append(");\n");

				contextStruct = context.getCodeFragmentCollector().addCodeFragment(new ContextStruct(context.getFunctionInfo(), false /* TODO */), new NullProgressMonitor());
				contextStruct.addInitializeCall(sb);
			}
			
			{
				UpdateFunction updateFunction = computeFunction.getUpdateFunction();
				StringBuilder sb = new StringBuilder();
				sb.append(updateFunction.getName());
				sb.append("(");
				boolean first = true;
				if (functionContextStructMember != null) {
					sb.append(context.getVariableAccessStrategy().generateContextMemberAccess(true, functionContextStructMember.getName()));
					first = false;
				}
				Iterator<InputParameterDeclaration> inputParameterDeclarationIt = callee.getFunctionDescription().getDeclaration().getInputParameterDeclarations().iterator();
				for (Expression argument : functionCall.getArguments()) {
					if (!inputParameterDeclarationIt.hasNext() || inputParameterDeclarationIt.next().isConstant()) {
						continue;
					}
					if (first) {
						first = false;
					} else {
						sb.append(", ");
					}
					sb.append(generate(context, argument));
				}
				sb.append(");\n");

				contextStruct.addUpdateCall(sb);
			}
		}
		
		StringBuilder sb = new StringBuilder();

		sb.append(computeFunction.getName());
		sb.append("(");
		boolean first = true;
		if (functionContextStructMember != null) {
			sb.append(context.getVariableAccessStrategy().generateContextMemberAccess(true, functionContextStructMember.getName()));
			first = false;
		}
		List<InputParameterDeclaration> directFeedthroughInputs = FunctionModelUtil.getDirectFeedthroughInputs(calleeGeneratorContext.getFunctionInfo().getFunctionInstance());
		Iterator<InputParameterDeclaration> inputParameterDeclarationIt = directFeedthroughInputs.iterator();
		for (Expression argument : functionCall.getArguments()) {
			if (!inputParameterDeclarationIt.hasNext() || inputParameterDeclarationIt.next().isConstant()) {
				continue;
			}
			if (first) {
				first = false;
			} else {
				sb.append(", ");
			}
			sb.append(generate(context, argument));
		}
		sb.append(")");
		
		return sb;
	}

	@Override
	public CharSequence visit(IMscriptGeneratorContext context, EndExpression endExpression) {
		return "";
	}

	@Override
	public CharSequence visit(IMscriptGeneratorContext context, RealLiteral realLiteral) {
		Type type = getDataType(context, realLiteral);
		return literalGenerator.generateLiteral(context.getConfiguration().getComputationModel(), type, realLiteral.getValue());
	}

	@Override
	public CharSequence visit(IMscriptGeneratorContext context, IntegerLiteral integerLiteral) {
		Type type = getDataType(context, integerLiteral);
		return literalGenerator.generateLiteral(context.getConfiguration().getComputationModel(), type, integerLiteral.getValue());
	}

	@Override
	public CharSequence visit(IMscriptGeneratorContext context, BooleanLiteral booleanLiteral) {
		return booleanLiteral.isTrue() ? "1" : "0";
	}

	@Override
	public CharSequence visit(IMscriptGeneratorContext context, StringLiteral stringLiteral) {
		StringConstructionFunction codeFragment = context.getCodeFragmentCollector().addCodeFragment(new StringConstructionFunction(context.getConfiguration(), Collections.singletonList(new ConstantStringSegment()), true), new NullProgressMonitor());
		StringTable stringTable = context.getCodeFragmentCollector().addCodeFragment(new StringTable(), new NullProgressMonitor());

		StringBuilder sb = new StringBuilder();
		sb.append(codeFragment.getName());
		sb.append("(");
		sb.append(Integer.toString(stringTable.addString(stringLiteral.getText())));
		sb.append(")");
		return sb;
	}

	@Override
	public CharSequence visit(IMscriptGeneratorContext context, TemplateExpression templateExpression) {
		templateExpression.normalizeSegments();
		
		List<IStringSegment> stringSegments = new ArrayList<IStringSegment>();
		for (TemplateSegment templateSegment : templateExpression.getSegments()) {
			if (templateSegment instanceof ConstantTemplateSegment) {
				ConstantTemplateSegment constantTemplateSegment = (ConstantTemplateSegment) templateSegment;
				if (constantTemplateSegment.getNormalizedText().isEmpty()) {
					continue;
				}
				stringSegments.add(new ConstantStringSegment());
			} else if (templateSegment instanceof ExpressionTemplateSegment) {
				ExpressionTemplateSegment expressionTemplateSegment = (ExpressionTemplateSegment) templateSegment;
				Expression expression = expressionTemplateSegment.getExpression();
				IValue value = context.getFunctionInfo().getValue(expression);
				if (value == null || value instanceof InvalidValue) {
					continue;
				}
				IValue convertedValue = value.convert(MscriptFactory.eINSTANCE.createStringType());
				if (convertedValue instanceof InvalidValue) {
					continue;
				}
				stringSegments.add(new ExpressionStringSegment(convertedValue instanceof StringValue, MachineDataTypes.create(context.getConfiguration(), value.getDataType())));
			} else {
				throw new IllegalArgumentException("Unknown template segment " + templateSegment.getClass().getCanonicalName());
			}
		}
		
		StringConstructionFunction codeFragment = context.getCodeFragmentCollector().addCodeFragment(new StringConstructionFunction(context.getConfiguration(), stringSegments, false), new NullProgressMonitor());
		StringTable stringTable = context.getCodeFragmentCollector().addCodeFragment(new StringTable(), new NullProgressMonitor());

		StringBuilder sb = new StringBuilder();
		sb.append(codeFragment.getName());
		sb.append("(");

		boolean first = true;
		for (TemplateSegment templateSegment : templateExpression.getSegments()) {
			if (!first) {
				sb.append(", ");
			}
			if (templateSegment instanceof ConstantTemplateSegment) {
				ConstantTemplateSegment constantTemplateSegment = (ConstantTemplateSegment) templateSegment;
				String text = constantTemplateSegment.getNormalizedText();
				if (text.isEmpty()) {
					continue;
				}
				if (text.charAt(0) == '\n') {
					text = "\f" + text.substring(1);
				}
				sb.append(Integer.toString(stringTable.addString(text)));
			} else if (templateSegment instanceof ExpressionTemplateSegment) {
				ExpressionTemplateSegment expressionTemplateSegment = (ExpressionTemplateSegment) templateSegment;
				Expression expression = expressionTemplateSegment.getExpression();
				IValue value = context.getFunctionInfo().getValue(expression);
				if (value == null || value instanceof InvalidValue) {
					continue;
				}
				IValue convertedValue = value.convert(MscriptFactory.eINSTANCE.createStringType());
				if (convertedValue instanceof InvalidValue) {
					continue;
				}
				sb.append(Integer.toString(stringTable.addString(Character.toString((char) 0x02) + expressionTemplateSegment.getIndentation())));
				sb.append(", ");
				if (convertedValue instanceof StringValue) {
					sb.append(Integer.toString(stringTable.addString(convertedValue.toString())));
				} else {
					if (value.getDataType() instanceof StringType) {
						sb.append("&(");
					}
					sb.append(generate(context, expression));
					if (value.getDataType() instanceof StringType) {
						sb.append(").data[0]");
					}
				}
			} else {
				throw new IllegalArgumentException("Unknown template segment " + templateSegment.getClass().getCanonicalName());
			}
			first = false;
		}

		sb.append(")");
		return sb;
	}

	@Override
	public CharSequence visit(IMscriptGeneratorContext context, LambdaExpression lambdaExpression) {
		return "";
	}

	@Override
	public CharSequence visit(IMscriptGeneratorContext context, AlgorithmExpression algorithmExpression) {
		return "";
	}

	@Override
	public CharSequence visit(IMscriptGeneratorContext context, SwitchExpression switchExpression) {
		return "";
	}

	@Override
	public CharSequence visit(IMscriptGeneratorContext context, InvalidExpression invalidExpression) {
		return "";
	}
	
	private Type getDataType(IMscriptGeneratorContext context, Expression expression) {
		return context.getFunctionInfo().getValue(expression).getDataType();
	}

}
