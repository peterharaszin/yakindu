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

package org.eclipse.damos.mscript.codegen.c.util;

import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.IntegerType;
import org.eclipse.damos.mscript.NumericType;
import org.eclipse.damos.mscript.RealType;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.codegen.c.IExpressionGenerator;
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipse.damos.mscript.codegen.c.LiteralGenerator;
import org.eclipse.damos.mscript.codegen.c.NumericExpressionCaster;
import org.eclipse.damos.mscript.computation.ComputationModel;
import org.eclipse.damos.mscript.computation.NumberFormat;
import org.eclipse.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipse.damos.mscript.interpreter.value.IValue;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class CastHelper {
	
	@Inject
	private IExpressionGenerator expressionGenerator;
	
	@Inject
	private LiteralGenerator literalGenerator;
	
	@Inject
	private NumericExpressionCaster numericExpressionCaster;
	
	public CharSequence cast(ComputationModel computationModel, CharSequence expression, Type expressionDataType, Type targetDataType) {
		if (targetDataType instanceof NumericType) {
			NumberFormat targetNumberFormat = computationModel.getNumberFormat(targetDataType);
			NumberFormat expressionNumberFormat = computationModel.getNumberFormat(expressionDataType);
			return numericExpressionCaster.cast(expression, expressionNumberFormat, targetNumberFormat);
		}
		return expression;
	}

	public CharSequence cast(IMscriptGeneratorContext context, Expression expression, Type targetDataType) {
		if (targetDataType instanceof NumericType) {
			NumberFormat targetNumberFormat = context.getConfiguration().getComputationModel().getNumberFormat(targetDataType);
			return castNumericType(context, expression, targetNumberFormat);
		}
		return expressionGenerator.generate(context, expression);
	}

	public CharSequence castNumericType(IMscriptGeneratorContext context, Expression expression, NumberFormat targetNumberFormat) {
		IValue value = context.getFunctionInfo().getValue(expression);
		if (value instanceof ISimpleNumericValue) {
			ISimpleNumericValue numericValue = (ISimpleNumericValue) value;
			if (value.getDataType() instanceof RealType) {
				return literalGenerator.generateLiteral(context.getConfiguration().getComputationModel(), targetNumberFormat, numericValue.doubleValue());
			}
			if (value.getDataType() instanceof IntegerType) {
				return literalGenerator.generateLiteral(context.getConfiguration().getComputationModel(), targetNumberFormat, numericValue.longValue());
			}
		}
		
		Type expressionDataType = context.getFunctionInfo().getValue(expression).getDataType();
		NumberFormat expressionNumberFormat = context.getConfiguration().getComputationModel().getNumberFormat(expressionDataType);
		
		return numericExpressionCaster.cast(expressionGenerator.generate(context, expression), expressionNumberFormat, targetNumberFormat);
	}

}
