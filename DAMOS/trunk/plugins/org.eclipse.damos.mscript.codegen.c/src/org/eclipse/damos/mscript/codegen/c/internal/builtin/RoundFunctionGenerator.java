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

package org.eclipse.damos.mscript.codegen.c.internal.builtin;

import org.eclipse.damos.common.util.PrintAppendable;
import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.FunctionCall;
import org.eclipse.damos.mscript.IntegerType;
import org.eclipse.damos.mscript.MscriptFactory;
import org.eclipse.damos.mscript.NumericType;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.codegen.c.DataTypeGenerator;
import org.eclipse.damos.mscript.codegen.c.IExpressionGenerator;
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipse.damos.mscript.codegen.c.NumericExpressionCaster;
import org.eclipse.damos.mscript.computation.FixedPointFormat;
import org.eclipse.damos.mscript.computation.FloatingPointFormat;
import org.eclipse.damos.mscript.computation.NumberFormat;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class RoundFunctionGenerator implements IBuiltinFunctionGenerator {

	@Inject
	private IExpressionGenerator expressionGenerator;

	@Inject
	private DataTypeGenerator dataTypeGenerator;
	
	@Inject
	private NumericExpressionCaster numericExpressionCaster;

	public CharSequence generate(final IMscriptGeneratorContext context, FunctionCall functionCall) {
		final Expression argument = functionCall.getArguments().get(0);
		
		final Type argumentDataType = context.getFunctionInfo().getValue(argument).getDataType();
		if (!(argumentDataType instanceof NumericType)) {
			throw new IllegalArgumentException();
		}
		
		NumericType argumentNumericType = (NumericType) argumentDataType;
		IntegerType resultDataType = MscriptFactory.eINSTANCE.createIntegerType();
		resultDataType.setUnit(EcoreUtil.copy(argumentNumericType.getUnit()));
		
		NumberFormat argumentNumberFormat = context.getConfiguration().getComputationModel().getNumberFormat(argumentDataType);
		NumberFormat resultNumberFormat = context.getConfiguration().getComputationModel().getNumberFormat(resultDataType);
		
		StringBuilder text = new StringBuilder();
		
		if (argumentNumberFormat instanceof FixedPointFormat) {
			final FixedPointFormat fixedPointFormat = (FixedPointFormat) argumentNumberFormat;
			final int fractionLength = fixedPointFormat.getFractionLength();
			if (fractionLength > 0) {
				PrintAppendable out = new PrintAppendable(text);
				out.print("((");
				out.print(expressionGenerator.generate(context, argument));
				out.printf(") + %d) & (%s) 0x%x", 1L << fractionLength - 1,
						dataTypeGenerator.generateDataType(context.getConfiguration(), null, context.getCodeFragmentCollector(), argumentDataType, null),
						(1L << fixedPointFormat.getWordSize()) - 1 >>> fractionLength << fractionLength);
			} else {
				text.append(expressionGenerator.generate(context, argument));
			}
		} else if (argumentNumberFormat instanceof FloatingPointFormat) {
			text.append("floor((");
			text.append(expressionGenerator.generate(context, argument));
			text.append(") + 0.5)");
		} else {
			throw new IllegalArgumentException();
		}
		
		return numericExpressionCaster.cast(text, argumentNumberFormat, resultNumberFormat);
	}
	
}
