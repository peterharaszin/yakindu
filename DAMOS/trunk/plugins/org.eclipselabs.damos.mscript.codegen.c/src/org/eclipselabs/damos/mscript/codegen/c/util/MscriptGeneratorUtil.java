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

import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.codegen.c.DataTypeGenerator;
import org.eclipselabs.damos.mscript.codegen.c.ExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipselabs.damos.mscript.codegen.c.LiteralGenerator;
import org.eclipselabs.damos.mscript.codegen.c.NumericExpressionCaster;
import org.eclipselabs.damos.mscript.computation.ComputationModel;
import org.eclipselabs.damos.mscript.computation.NumberFormat;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class MscriptGeneratorUtil {
	
	public static CharSequence cast(ComputationModel computationModel, CharSequence expression, Type expressionDataType, Type targetDataType) {
		if (targetDataType instanceof NumericType) {
			NumberFormat targetNumberFormat = computationModel.getNumberFormat(targetDataType);
			NumberFormat expressionNumberFormat = computationModel.getNumberFormat(expressionDataType);
			return NumericExpressionCaster.INSTANCE.cast(expression, expressionNumberFormat, targetNumberFormat);
		}
		return expression;
	}

	public static CharSequence cast(IMscriptGeneratorContext context, Expression expression, Type targetDataType) {
		if (targetDataType instanceof NumericType) {
			NumberFormat targetNumberFormat = context.getConfiguration().getComputationModel().getNumberFormat(targetDataType);
			return castNumericType(context, expression, targetNumberFormat);
		}
		return new ExpressionGenerator().generate(context, expression);
	}

	public static CharSequence castNumericType(IMscriptGeneratorContext context, Expression expression, NumberFormat targetNumberFormat) {
		IValue value = context.getStaticEvaluationResult().getValue(expression);
		if (value instanceof ISimpleNumericValue) {
			ISimpleNumericValue numericValue = (ISimpleNumericValue) value;
			if (value.getDataType() instanceof RealType) {
				return new LiteralGenerator(new DataTypeGenerator()).generateLiteral(context.getConfiguration().getComputationModel(), targetNumberFormat, numericValue.doubleValue());
			}
			if (value.getDataType() instanceof IntegerType) {
				return new LiteralGenerator(new DataTypeGenerator()).generateLiteral(context.getConfiguration().getComputationModel(), targetNumberFormat, numericValue.longValue());
			}
		}
		
		Type expressionDataType = context.getStaticEvaluationResult().getValue(expression).getDataType();
		NumberFormat expressionNumberFormat = context.getConfiguration().getComputationModel().getNumberFormat(expressionDataType);
		
		return NumericExpressionCaster.INSTANCE.cast(new ExpressionGenerator().generate(context, expression), expressionNumberFormat, targetNumberFormat);
	}

}
