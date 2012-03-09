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

import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.mscript.ArrayDimension;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.BooleanType;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.codegen.c.ExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipselabs.damos.mscript.codegen.c.IWriter;
import org.eclipselabs.damos.mscript.codegen.c.NumericExpressionCaster;
import org.eclipselabs.damos.mscript.codegen.c.NumericExpressionInfo;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.FloatingPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;

/**
 * @author Andreas Unger
 *
 */
public class MscriptGeneratorUtil {
	
	public static String getCVariableDeclaration(ComputationModel computationModel, DataType dataType, String name, boolean pointer) {
		StringBuilder cDataType = new StringBuilder();

		if (dataType instanceof ArrayType) {
			ArrayType arrayType = (ArrayType) dataType;

			cDataType.append(getCDataType(computationModel, arrayType.getElementType()));
			cDataType.append(" ");
			if (pointer) {
				cDataType.append("*");
			}
			cDataType.append(name);
			cDataType.append("[");
			
			boolean first = true;
			for (ArrayDimension arrayDimension : arrayType.getDimensions()) {
				if (first) {
					first = false;
				} else {
					cDataType.append(", ");
				}
				cDataType.append(arrayDimension.getSize());
			}
			
			cDataType.append("]");
		} else {
			cDataType.append(getCDataType(computationModel, dataType));
			cDataType.append(" ");
			if (pointer) {
				cDataType.append("*");
			}
			cDataType.append(name);
		}

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

	public static String getCDataType(ComputationModel computationModel, DataType dataType) {
		if (dataType instanceof BooleanType) {
			return "uint_fast8_t";
		}
		if (dataType instanceof NumericType) {
			NumberFormat numberFormat = computationModel.getNumberFormat(dataType);
			if (numberFormat instanceof FloatingPointFormat) {
				FloatingPointFormat floatingPointFormat = (FloatingPointFormat) numberFormat;
				switch (floatingPointFormat.getKind()) {
				case BINARY32:
					return "float";
				case BINARY64:
					return "double";
				}
			} else if (numberFormat instanceof FixedPointFormat) {
				FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
				return String.format("int%d_t", fixedPointFormat.getWordSize());
			}
		}
		throw new IllegalArgumentException();
	}
	
	public static String getLiteralString(ComputationModel computationModel, DataType dataType, double value) {
		NumberFormat numberFormat = computationModel.getNumberFormat(dataType);
		String cDataType = getCDataType(computationModel, dataType);
		if (numberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			return String.format("(%s) %d", cDataType, Math.round(value * Math.pow(2, fixedPointFormat.getFractionLength())));
		}
		return String.format("(%s) %s", cDataType, Double.toString(value));
	}

	public static String getLiteralString(ComputationModel computationModel, DataType dataType, long value) {
		NumberFormat numberFormat = computationModel.getNumberFormat(dataType);
		String cDataType = getCDataType(computationModel, dataType);
		if (numberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			value <<= fixedPointFormat.getFractionLength();
		}
		return String.format("(%s) %d", cDataType, value);
	}

	public static void cast(IMscriptGeneratorContext context, String expression, DataType expressionDataType, DataType targetDataType) throws IOException {
		cast(context.getComputationModel(), context.getAppendable(), expression, expressionDataType, targetDataType);
	}
	
	public static void cast(ComputationModel computationModel, final Appendable appendable, final String expression, DataType expressionDataType, DataType targetDataType) throws IOException {
		if (targetDataType instanceof NumericType) {
			NumberFormat targetNumberFormat = computationModel.getNumberFormat(targetDataType);
			NumberFormat expressionNumberFormat = computationModel.getNumberFormat(expressionDataType);
			NumericExpressionCaster.INSTANCE.cast(appendable, targetNumberFormat, NumericExpressionInfo.create(expressionNumberFormat, new IWriter() {
				
				public void write(Appendable appendable) throws IOException {
					appendable.append(expression);
				}
				
			}));
		} else {
			new PrintAppendable(appendable).print(expression);
		}
	}

	public static void cast(IMscriptGeneratorContext context, Expression expression, DataType targetDataType) throws IOException {
		if (targetDataType instanceof NumericType) {
			NumberFormat numberFormat = context.getComputationModel().getNumberFormat(targetDataType);
			castNumericType(context, numberFormat, expression);
		} else {
			new ExpressionGenerator().generate(context, expression);
		}
	}

	public static void castNumericType(final IMscriptGeneratorContext context, NumberFormat targetNumberFormat, final Expression expression) throws IOException {
		DataType expressionDataType = context.getStaticEvaluationContext().getValue(expression).getDataType();
		NumberFormat expressionNumberFormat = context.getComputationModel().getNumberFormat(expressionDataType);
		NumericExpressionCaster.INSTANCE.cast(context.getAppendable(), targetNumberFormat, NumericExpressionInfo.create(expressionNumberFormat, new IWriter() {
			
			public void write(Appendable appendable) throws IOException {
				new ExpressionGenerator().generate(context, expression);
			}
			
		}));
	}

}
