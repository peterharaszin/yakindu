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

package org.eclipselabs.damos.mscript.codegen.c.util;

import java.io.IOException;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.codegen.c.ArrayLiteralDeclarationCodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipselabs.damos.mscript.codegen.c.NumericExpressionCaster;
import org.eclipselabs.damos.mscript.codegen.c.NumericExpressionInfo;
import org.eclipselabs.damos.mscript.codegen.c.StructLiteralDeclarationCodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineDataTypes;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;
import org.eclipselabs.damos.mscript.interpreter.value.IArrayValue;
import org.eclipselabs.damos.mscript.interpreter.value.IBooleanValue;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.StructValue;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class MscriptGeneratorUtil {
	
	public static String getCVariableDeclaration(IMscriptGeneratorContext context, DataType dataType, String name, boolean pointer, ICodeFragment dependentCodeFragment) {
		return getCVariableDeclaration(context.getComputationModel(), context.getCodeFragmentCollector(), dataType, name, pointer, dependentCodeFragment);
	}
	
	public static String getCVariableDeclaration(ComputationModel computationModel, ICodeFragmentCollector codeFragmentCollector, DataType dataType, String name, boolean pointer, ICodeFragment dependentCodeFragment) {
		StringBuilder cDataType = new StringBuilder();

		cDataType.append(getCDataType(computationModel, codeFragmentCollector, dataType, dependentCodeFragment));
		cDataType.append(" ");
		if (pointer) {
			cDataType.append("*");
		}
		cDataType.append(name);

		return cDataType.toString();
	}

	public static String getIndexCDataType(ComputationModel computationModel, long maximumIndex) {
		if (maximumIndex <= 0xffL) {
			return "uint_fast8_t";
		}
		if (maximumIndex <= 0xffffL) {
			return "uint_fast16_t";
		}
		if (maximumIndex <= 0xffffffffL) {
			return "uint_fast32_t";
		}
		return "uint_fast64_t";
	}

	public static String getCDataType(IMscriptGeneratorContext context, DataType dataType, ICodeFragment dependentCodeFragment) {
		return getCDataType(context.getComputationModel(), context.getCodeFragmentCollector(), dataType, dependentCodeFragment);
	}
	
	public static String getCDataType(ComputationModel computationModel, ICodeFragmentCollector codeFragmentCollector, DataType dataType, ICodeFragment dependentCodeFragment) {
		return MachineDataTypes.create(computationModel, dataType).getCDataType(computationModel, codeFragmentCollector, dependentCodeFragment);
	}
	
	public static String getLiteralString(IMscriptGeneratorContext context, DataType dataType, double value, ICodeFragment dependentCodeFragment) {
		return getLiteralString(context.getComputationModel(), context.getCodeFragmentCollector(), dataType, value, dependentCodeFragment);
	}
	
	public static String getLiteralString(IMscriptGeneratorContext context, DataType dataType, long value, ICodeFragment dependentCodeFragment) {
		return getLiteralString(context.getComputationModel(), context.getCodeFragmentCollector(), dataType, value, dependentCodeFragment);
	}

	public static String getLiteralString(ComputationModel computationModel, ICodeFragmentCollector codeFragmentCollector, DataType dataType, double value, ICodeFragment dependentCodeFragment) {
		NumberFormat numberFormat = computationModel.getNumberFormat(dataType);
		String cDataType = getCDataType(computationModel, codeFragmentCollector, dataType, dependentCodeFragment);
		if (numberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			return String.format("(%s) %d", cDataType, Math.round(value * Math.pow(2, fixedPointFormat.getFractionLength())));
		}
		return String.format("(%s) %s", cDataType, Double.toString(value));
	}

	public static String getLiteralString(ComputationModel computationModel, ICodeFragmentCollector codeFragmentCollector, DataType dataType, long value, ICodeFragment dependentCodeFragment) {
		NumberFormat numberFormat = computationModel.getNumberFormat(dataType);
		String cDataType = getCDataType(computationModel, codeFragmentCollector, dataType, dependentCodeFragment);
		if (numberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			value <<= fixedPointFormat.getFractionLength();
		}
		return String.format("(%s) %d", cDataType, value);
	}

	public static CharSequence cast(IMscriptGeneratorContext context, String expression, DataType expressionDataType, DataType targetDataType) {
		return cast(context.getComputationModel(), expression, expressionDataType, targetDataType);
	}
	
	public static CharSequence cast(ComputationModel computationModel, final String expression, DataType expressionDataType, DataType targetDataType) {
		StringBuilder sb = new StringBuilder();
		if (targetDataType instanceof NumericType) {
			NumberFormat targetNumberFormat = computationModel.getNumberFormat(targetDataType);
			NumberFormat expressionNumberFormat = computationModel.getNumberFormat(expressionDataType);
			try {
				NumericExpressionCaster.INSTANCE.cast(sb, targetNumberFormat, NumericExpressionInfo.create(expressionNumberFormat, expression));
			} catch (IOException e) {
				// TODO REMOVE
				e.printStackTrace();
			}
		} else {
			new PrintAppendable(sb).print(expression);
		}
		return sb;
	}

	public static CharSequence cast(IMscriptGeneratorContext context, Expression expression, DataType targetDataType) {
		if (targetDataType instanceof NumericType) {
			NumberFormat numberFormat = context.getComputationModel().getNumberFormat(targetDataType);
			return castNumericType(context, numberFormat, expression);
		}
		return new ExpressionGenerator().generate(context, expression);
	}

	public static CharSequence castNumericType(final IMscriptGeneratorContext context, NumberFormat targetNumberFormat, final Expression expression) {
		StringBuilder sb = new StringBuilder();
		DataType expressionDataType = context.getStaticEvaluationContext().getValue(expression).getDataType();
		NumberFormat expressionNumberFormat = context.getComputationModel().getNumberFormat(expressionDataType);
		try {
			NumericExpressionCaster.INSTANCE.cast(sb, targetNumberFormat, NumericExpressionInfo.create(expressionNumberFormat, new ExpressionGenerator().generate(context, expression)));
		} catch (IOException e) {
			// TODO REMOVE
			e.printStackTrace();
		}
		return sb;
	}

	public static String getLiteralString(IMscriptGeneratorContext context, IValue value) {
		return getLiteralString(context.getComputationModel(), context.getCodeFragmentCollector(), value);
	}
	
	public static String getLiteralString(ComputationModel computationModel, ICodeFragmentCollector codeFragmentCollector, IValue value) {
		if (value instanceof IArrayValue) {
			ArrayLiteralDeclarationCodeFragment codeFragment = new ArrayLiteralDeclarationCodeFragment(computationModel, (IArrayValue) value);
			codeFragment = (ArrayLiteralDeclarationCodeFragment) codeFragmentCollector.addCodeFragment(codeFragment, new NullProgressMonitor());
			return codeFragment.getName();
		}
		if (value instanceof StructValue) {
			StructLiteralDeclarationCodeFragment codeFragment = new StructLiteralDeclarationCodeFragment(computationModel, (StructValue) value);
			codeFragment = (StructLiteralDeclarationCodeFragment) codeFragmentCollector.addCodeFragment(codeFragment, new NullProgressMonitor());
			return codeFragment.getName();
		}
		StringBuilder sb = new StringBuilder();
		createInitializer(computationModel, codeFragmentCollector, new PrintAppendable(sb), value);
		return sb.toString();
	}

	public static void createInitializer(ComputationModel computationModel, ICodeFragmentCollector codeFragmentCollector, PrintAppendable out, IValue value) {
		if (value instanceof ISimpleNumericValue) {
			ISimpleNumericValue numericTemplateArgument = (ISimpleNumericValue) value;
			if (value.getDataType() instanceof RealType) {
				out.print(MscriptGeneratorUtil.getLiteralString(computationModel, codeFragmentCollector, numericTemplateArgument.getDataType(), numericTemplateArgument.doubleValue(), null));
			} else if (value.getDataType() instanceof IntegerType) {
				out.print(MscriptGeneratorUtil.getLiteralString(computationModel, codeFragmentCollector, numericTemplateArgument.getDataType(), numericTemplateArgument.longValue(), null));
			}
		} else if (value instanceof IBooleanValue) {
			IBooleanValue booleanTemplateArgument = (IBooleanValue) value;
			out.print(booleanTemplateArgument.booleanValue() ? "1" : "0");
		} else if (value instanceof IArrayValue) {
			createArrayInitializer(computationModel, codeFragmentCollector, out, (IArrayValue) value);
		} else if (value instanceof StructValue) {
			createStructInitializer(computationModel, codeFragmentCollector, out, (StructValue) value);
		} else {
			throw new IllegalArgumentException();
		}
	}

	private static void createArrayInitializer(ComputationModel computationModel, ICodeFragmentCollector codeFragmentCollector, PrintAppendable out, IArrayValue value) {
		out.print("{ { ");
		int size = TypeUtil.getArraySize(value.getDataType());
		for (int i = 0; i < size; ++i) {
			if (i > 0) {
				out.print(", ");
			}
			createInitializer(computationModel, codeFragmentCollector, out, value.get(i));
		}
		out.print(" } }");
	}

	private static void createStructInitializer(ComputationModel computationModel, ICodeFragmentCollector codeFragmentCollector, PrintAppendable out, StructValue value) {
		out.print("{ ");
		for (int i = 0; i < value.getDataType().getMembers().size(); ++i) {
			if (i > 0) {
				out.print(", ");
			}
			createInitializer(computationModel, codeFragmentCollector, out, value.get(i));
		}
		out.print(" }");
	}

}
