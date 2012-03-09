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

import java.io.IOException;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.FunctionCall;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.codegen.c.ExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.IExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipselabs.damos.mscript.codegen.c.IWriter;
import org.eclipselabs.damos.mscript.codegen.c.NumericExpressionCaster;
import org.eclipselabs.damos.mscript.codegen.c.NumericExpressionInfo;
import org.eclipselabs.damos.mscript.codegen.c.util.MscriptGeneratorUtil;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.FloatingPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;

/**
 * @author Andreas Unger
 *
 */
public class RoundFunctionGenerator implements IFunctionGenerator {

	private final IExpressionGenerator expressionGenerator = new ExpressionGenerator();
	
	public void generate(final IMscriptGeneratorContext context, FunctionCall functionCall) throws IOException {
		final PrintAppendable out = new PrintAppendable(context.getAppendable());
		
		final Expression argument = functionCall.getArguments().get(0);
		
		final DataType argumentDataType = context.getStaticEvaluationContext().getValue(argument).getDataType();
		if (!(argumentDataType instanceof NumericType)) {
			throw new IllegalArgumentException();
		}
		
		NumericType argumentNumericType = (NumericType) argumentDataType;
		IntegerType resultDataType = MscriptFactory.eINSTANCE.createIntegerType();
		resultDataType.setUnit(EcoreUtil.copy(argumentNumericType.getUnit()));
		
		NumberFormat argumentNumberFormat = context.getComputationModel().getNumberFormat(argumentDataType);
		NumberFormat resultNumberFormat = context.getComputationModel().getNumberFormat(resultDataType);
		
		IWriter writer;
		
		if (argumentNumberFormat instanceof FixedPointFormat) {
			final FixedPointFormat fixedPointFormat = (FixedPointFormat) argumentNumberFormat;
			final int fractionLength = fixedPointFormat.getFractionLength();
			writer = new IWriter() {
				
				public void write(Appendable appendable) throws IOException {
					if (fractionLength > 0) {
						out.print("((");
						expressionGenerator.generate(context, argument);
						out.printf(") + %d) & (%s) 0x%x", 1L << fractionLength - 1,
								MscriptGeneratorUtil.getCDataType(context.getComputationModel(), argumentDataType),
								(1L << fixedPointFormat.getWordSize()) - 1 >>> fractionLength << fractionLength);
					} else {
						expressionGenerator.generate(context, argument);
					}
				}
				
			};
		} else if (argumentNumberFormat instanceof FloatingPointFormat) {
			writer = new IWriter() {

				public void write(Appendable appendable) throws IOException {
					out.print("floor((");
					expressionGenerator.generate(context, argument);
					out.print(") + 0.5)");
				}
				
			};
		} else {
			throw new IllegalArgumentException();
		}
		
		NumericExpressionCaster.INSTANCE.cast(context.getAppendable(), resultNumberFormat, NumericExpressionInfo.create(argumentNumberFormat, writer));
	}
	
}
