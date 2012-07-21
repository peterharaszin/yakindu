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

package org.eclipselabs.damos.mscript.codegen.c.internal.builtin;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.FunctionCall;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.codegen.c.DataTypeGenerator;
import org.eclipselabs.damos.mscript.codegen.c.ExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.IExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipselabs.damos.mscript.codegen.c.NumericExpressionCaster;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.FloatingPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;

/**
 * @author Andreas Unger
 *
 */
public class RoundFunctionGenerator implements IBuiltinFunctionGenerator {

	private final DataTypeGenerator dataTypeGenerator = new DataTypeGenerator();
	private final IExpressionGenerator expressionGenerator = new ExpressionGenerator();
	
	public CharSequence generate(final IMscriptGeneratorContext context, FunctionCall functionCall) {
		final Expression argument = functionCall.getArguments().get(0);
		
		final Type argumentDataType = context.getStaticEvaluationResult().getValue(argument).getDataType();
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
		
		return NumericExpressionCaster.INSTANCE.cast(text, argumentNumberFormat, resultNumberFormat);
	}
	
}
