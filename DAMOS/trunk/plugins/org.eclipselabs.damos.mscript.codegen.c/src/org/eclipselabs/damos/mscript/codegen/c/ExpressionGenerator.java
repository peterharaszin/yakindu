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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.mscript.AdditiveExpression;
import org.eclipselabs.damos.mscript.ArrayConstructionOperator;
import org.eclipselabs.damos.mscript.ArrayElementAccess;
import org.eclipselabs.damos.mscript.ArraySubscript;
import org.eclipselabs.damos.mscript.BooleanLiteral;
import org.eclipselabs.damos.mscript.CallableElement;
import org.eclipselabs.damos.mscript.ConstantTemplateSegment;
import org.eclipselabs.damos.mscript.EqualityExpression;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.ExpressionTemplateSegment;
import org.eclipselabs.damos.mscript.FeatureReference;
import org.eclipselabs.damos.mscript.FunctionCall;
import org.eclipselabs.damos.mscript.ImpliesExpression;
import org.eclipselabs.damos.mscript.IntegerLiteral;
import org.eclipselabs.damos.mscript.LogicalAndExpression;
import org.eclipselabs.damos.mscript.LogicalOrExpression;
import org.eclipselabs.damos.mscript.MemberVariableAccess;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.MultiplicativeExpression;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.ParenthesizedExpression;
import org.eclipselabs.damos.mscript.PowerExpression;
import org.eclipselabs.damos.mscript.RealLiteral;
import org.eclipselabs.damos.mscript.RecordConstructionMember;
import org.eclipselabs.damos.mscript.RecordConstructionOperator;
import org.eclipselabs.damos.mscript.RecordType;
import org.eclipselabs.damos.mscript.RelationalExpression;
import org.eclipselabs.damos.mscript.StringLiteral;
import org.eclipselabs.damos.mscript.StringType;
import org.eclipselabs.damos.mscript.TemplateExpression;
import org.eclipselabs.damos.mscript.TemplateSegment;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.UnaryExpression;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.ConstantStringSegment;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.ExpressionStringSegment;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.IStringSegment;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.RecordConstructionFunction;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.StringConstructionFunction;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.StringEqualToFunction;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.StringTable;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineDataTypes;
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
import org.eclipselabs.damos.mscript.interpreter.value.RecordValue;
import org.eclipselabs.damos.mscript.interpreter.value.StringValue;
import org.eclipselabs.damos.mscript.util.MscriptSwitch;
import org.eclipselabs.damos.mscript.util.TypeUtil;

public class ExpressionGenerator implements IExpressionGenerator {
	
	private final LiteralGenerator literalGenerator = new LiteralGenerator(new DataTypeGenerator());
	private final VariableReferenceGenerator variableReferenceGenerator = new VariableReferenceGenerator(this, literalGenerator);
	
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
			Type leftDataType = getDataType(equalityExpression.getLeftOperand());
			Type rightDataType = getDataType(equalityExpression.getRightOperand());

			if (leftDataType instanceof StringType && rightDataType instanceof StringType) {
				StringEqualToFunction stringEqualToFunction = context.getCodeFragmentCollector().addCodeFragment(new StringEqualToFunction(context.getConfiguration().getStringBufferSize()), new NullProgressMonitor());
				if (equalityExpression.getOperator() == OperatorKind.NOT_EQUAL_TO) {
					out.print("!");
				}
				out.print(stringEqualToFunction.getName());
				out.print("(");
				out.print("&(");
				doSwitch(equalityExpression.getLeftOperand());
				out.print(").data[0], &(");
				doSwitch(equalityExpression.getRightOperand());
				out.print(").data[0])");
				return true;
			}
			
			generateCompareExpression(equalityExpression.getLeftOperand(), equalityExpression.getRightOperand(), equalityExpression.getOperator().getLiteral());
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRelationalExpression(org.eclipselabs.mscript.language.ast.RelationalExpression)
		 */
		@Override
		public Boolean caseRelationalExpression(RelationalExpression relationalExpression) {
			generateCompareExpression(relationalExpression.getLeftOperand(), relationalExpression.getRightOperand(), relationalExpression.getOperator().getLiteral());
			return true;
		}
		
		private void generateCompareExpression(Expression leftOperand, Expression rightOperand, String operator) {
			Type leftDataType = getDataType(leftOperand);
			Type rightDataType = getDataType(rightOperand);
			
			if (leftDataType instanceof NumericType && rightDataType instanceof NumericType) {
				Type dataType1 = TypeUtil.getLeftHandDataType(leftDataType, rightDataType);
				Type dataType2 = TypeUtil.getLeftHandDataType(rightDataType, leftDataType);
				
				NumberFormat numberFormat1 = context.getConfiguration().getComputationModel().getNumberFormat(dataType1);
				NumberFormat numberFormat2 = context.getConfiguration().getComputationModel().getNumberFormat(dataType2);
				
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
			Type type = getDataType(additiveExpression);
			NumberFormat numberFormat = context.getConfiguration().getComputationModel().getNumberFormat(type);
			
			Type leftDataType = getDataType(additiveExpression.getLeftOperand());
			Type rightDataType = getDataType(additiveExpression.getRightOperand());
			
			if (leftDataType instanceof StringType || rightDataType instanceof StringType) {
				IValue leftValue = context.getStaticEvaluationResult().getValue(additiveExpression.getLeftOperand());
				if (leftValue == null || leftValue instanceof InvalidValue) {
					return true;
				}
				IValue leftConvertedValue = leftValue.convert(MscriptFactory.eINSTANCE.createStringType());
				if (leftConvertedValue instanceof InvalidValue) {
					return true;
				}
				IStringSegment leftStringSegment = new ExpressionStringSegment(leftConvertedValue instanceof StringValue, MachineDataTypes.create(context.getConfiguration(), leftValue.getDataType()));

				IValue rightValue = context.getStaticEvaluationResult().getValue(additiveExpression.getRightOperand());
				if (rightValue == null || rightValue instanceof InvalidValue) {
					return true;
				}
				IValue rightConvertedValue = rightValue.convert(MscriptFactory.eINSTANCE.createStringType());
				if (rightConvertedValue instanceof InvalidValue) {
					return true;
				}
				IStringSegment rightStringSegment = new ExpressionStringSegment(rightConvertedValue instanceof StringValue, MachineDataTypes.create(context.getConfiguration(), rightValue.getDataType()));

				if (leftStringSegment == null || rightStringSegment == null) {
					return true;
				}
				
				List<IStringSegment> stringSegments = new ArrayList<IStringSegment>();
				stringSegments.add(leftStringSegment);
				stringSegments.add(rightStringSegment);
				StringConstructionFunction codeFragment = context.getCodeFragmentCollector().addCodeFragment(new StringConstructionFunction(context.getConfiguration(), stringSegments, true), new NullProgressMonitor());
				StringTable stringTable = context.getCodeFragmentCollector().addCodeFragment(new StringTable(), new NullProgressMonitor());

				out.print(codeFragment.getName());
				out.print("(");

				if (leftConvertedValue instanceof StringValue) {
					out.print(Integer.toString(stringTable.addString(leftConvertedValue.toString())));
				} else {
					if (rightDataType instanceof StringType) {
						out.print("&(");
					}
					doSwitch(additiveExpression.getLeftOperand());
					if (rightDataType instanceof StringType) {
						out.print(").data[0]");
					}
				}
				
				out.print(", ");

				if (rightConvertedValue instanceof StringValue) {
					out.print(Integer.toString(stringTable.addString(rightConvertedValue.toString())));
				} else {
					if (rightDataType instanceof StringType) {
						out.print("&(");
					}
					doSwitch(additiveExpression.getRightOperand());
					if (rightDataType instanceof StringType) {
						out.print(").data[0]");
					}
				}
				
				out.print(")");
				
				return true;
			}

			out.print(MscriptGeneratorUtil.castNumericType(context, additiveExpression.getLeftOperand(), numberFormat));
			out.print(" ");
			out.print(additiveExpression.getOperator().getLiteral());
			out.print(" ");
			out.print(MscriptGeneratorUtil.castNumericType(context, additiveExpression.getRightOperand(), numberFormat));
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseMultiplicativeExpression(org.eclipselabs.mscript.language.ast.MultiplicativeExpression)
		 */
		@Override
		public Boolean caseMultiplicativeExpression(final MultiplicativeExpression multiplicativeExpression) {
			NumberFormat numberFormat = context.getConfiguration().getComputationModel().getNumberFormat(getDataType(multiplicativeExpression));

			INumericExpressionOperand leftOperand = new NumericExpressionOperand(context, multiplicativeExpression.getLeftOperand());
			INumericExpressionOperand rightOperand = new NumericExpressionOperand(context, multiplicativeExpression.getRightOperand());
			out.print(multiplicativeExpressionGenerator.generate(context.getCodeFragmentCollector(), multiplicativeExpression.getOperator(), numberFormat, leftOperand, rightOperand));

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
			Type type = getDataType(powerExpression);
			NumberFormat numberFormat = context.getConfiguration().getComputationModel().getNumberFormat(type);
	
			if (numberFormat instanceof FixedPointFormat) {
				FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
				if (fixedPointFormat.getWordSize() > 32) {
					out.print("DamosMath_powfix32(");
				} else {
					out.print("DamosMath_powfix64(");
				}
				out.print(MscriptGeneratorUtil.castNumericType(context, powerExpression.getLeftOperand(), numberFormat));
				out.print(", ");
				out.print(MscriptGeneratorUtil.castNumericType(context, powerExpression.getRightOperand(), numberFormat));
				out.printf(", %d)", fixedPointFormat.getFractionLength());
			} else if (numberFormat instanceof FloatingPointFormat) {
				out.print("pow(");
				out.print(MscriptGeneratorUtil.castNumericType(context, powerExpression.getLeftOperand(), numberFormat));
				out.print(", ");
				out.print(MscriptGeneratorUtil.castNumericType(context, powerExpression.getRightOperand(), numberFormat));
				out.print(")");
			}

			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRealLiteral(org.eclipselabs.mscript.language.ast.RealLiteral)
		 */
		@Override
		public Boolean caseRealLiteral(RealLiteral realLiteral) {
			Type type = getDataType(realLiteral);
			out.print(literalGenerator.generateLiteral(context.getConfiguration().getComputationModel(), type, realLiteral.getValue()));
			return true;
		}
	
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIntegerLiteral(org.eclipselabs.mscript.language.ast.IntegerLiteral)
		 */
		@Override
		public Boolean caseIntegerLiteral(IntegerLiteral integerLiteral) {
			Type type = getDataType(integerLiteral);
			out.print(literalGenerator.generateLiteral(context.getConfiguration().getComputationModel(), type, integerLiteral.getValue()));
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
		public Boolean caseStringLiteral(StringLiteral stringLiteral) {
			StringConstructionFunction codeFragment = context.getCodeFragmentCollector().addCodeFragment(new StringConstructionFunction(context.getConfiguration(), Collections.singletonList(new ConstantStringSegment()), true), new NullProgressMonitor());
			StringTable stringTable = context.getCodeFragmentCollector().addCodeFragment(new StringTable(), new NullProgressMonitor());
			
			out.print(codeFragment.getName());
			out.print("(");
			out.print(Integer.toString(stringTable.addString(stringLiteral.getText())));
			out.print(")");
			
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.util.MscriptSwitch#caseTemplateExpression(org.eclipselabs.damos.mscript.TemplateExpression)
		 */
		@Override
		public Boolean caseTemplateExpression(TemplateExpression templateExpression) {
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
					IValue value = context.getStaticEvaluationResult().getValue(expression);
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

			out.print(codeFragment.getName());
			out.print("(");

			boolean first = true;
			for (TemplateSegment templateSegment : templateExpression.getSegments()) {
				if (!first) {
					out.print(", ");
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
					out.print(Integer.toString(stringTable.addString(text)));
				} else if (templateSegment instanceof ExpressionTemplateSegment) {
					ExpressionTemplateSegment expressionTemplateSegment = (ExpressionTemplateSegment) templateSegment;
					Expression expression = expressionTemplateSegment.getExpression();
					IValue value = context.getStaticEvaluationResult().getValue(expression);
					if (value == null || value instanceof InvalidValue) {
						continue;
					}
					IValue convertedValue = value.convert(MscriptFactory.eINSTANCE.createStringType());
					if (convertedValue instanceof InvalidValue) {
						continue;
					}
					out.print(Integer.toString(stringTable.addString(Character.toString((char) 0x02) + expressionTemplateSegment.getIndentation())));
					out.print(", ");
					if (convertedValue instanceof StringValue) {
						out.print(Integer.toString(stringTable.addString(convertedValue.toString())));
					} else {
						if (value.getDataType() instanceof StringType) {
							out.print("&(");
						}
						doSwitch(expression);
						if (value.getDataType() instanceof StringType) {
							out.print(").data[0]");
						}
					}
				} else {
					throw new IllegalArgumentException("Unknown template segment " + templateSegment.getClass().getCanonicalName());
				}
				first = false;
			}

			out.print(")");

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
				out.print(literalGenerator.generateLiteral(context.getConfiguration(), context.getCodeFragmentCollector(), value));
			}
			return true;
		}
		
		@Override
		public Boolean caseRecordConstructionOperator(RecordConstructionOperator recordConstructionOperator) {
			IValue value = context.getStaticEvaluationResult().getValue(recordConstructionOperator);
			if (value instanceof RecordValue) {
				out.print(literalGenerator.generateLiteral(context.getConfiguration(), context.getCodeFragmentCollector(), value));
			} else {
				RecordConstructionFunction codeFragment = (RecordConstructionFunction) context.getCodeFragmentCollector().addCodeFragment(new RecordConstructionFunction(MachineDataTypes.create(context.getConfiguration(), (RecordType) value.getDataType())), new NullProgressMonitor());
				out.print(codeFragment.getName());
				out.print("(");
				boolean first = true;
				for (RecordConstructionMember member : recordConstructionOperator.getMembers()) {
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

		public Boolean caseFeatureReference(FeatureReference variableReference) {
			out.print(variableReferenceGenerator.generate(context, variableReference));
			return true;
		}

		private Type getDataType(Expression expression) {
			return context.getStaticEvaluationResult().getValue(expression).getDataType();
		}
	
	}
	
}