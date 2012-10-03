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

package org.eclipse.damos.mscript.codegen.c.internal.builtin;

import org.eclipse.damos.common.util.PrintAppendable;
import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.FunctionCall;
import org.eclipse.damos.mscript.NumericType;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipse.damos.mscript.codegen.c.util.MscriptGeneratorUtil;
import org.eclipse.damos.mscript.computation.FixedPointFormat;
import org.eclipse.damos.mscript.computation.FloatingPointFormat;
import org.eclipse.damos.mscript.computation.NumberFormat;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractSingleParameterFunctionGenerator implements IBuiltinFunctionGenerator {

	public CharSequence generate(IMscriptGeneratorContext context, FunctionCall functionCall) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		
		Expression argument = functionCall.getArguments().get(0);
		
		Type argumentDataType = context.getFunctionInfo().getValue(functionCall).getDataType();
		if (!(argumentDataType instanceof NumericType)) {
			throw new IllegalArgumentException();
		}
		
		NumberFormat numberFormat = context.getConfiguration().getComputationModel().getNumberFormat(argumentDataType);
		if (numberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			out.printf("%s(", getFixedPointFunctionName(fixedPointFormat));
			out.print(MscriptGeneratorUtil.castNumericType(context, argument, numberFormat));
			out.printf(", %d)", fixedPointFormat.getFractionLength());
		} else if (numberFormat instanceof FloatingPointFormat) {
			FloatingPointFormat floatingPointFormat = (FloatingPointFormat) numberFormat;
			out.printf("%s(", getFloatingPointFunctionName(floatingPointFormat));
			out.print(MscriptGeneratorUtil.castNumericType(context, argument, numberFormat));
			out.print(")");
		} else {
			throw new IllegalArgumentException();
		}
		
		contributeCodeFragments(context.getCodeFragmentCollector());
		return sb;
	}
	
	protected void contributeCodeFragments(ICodeFragmentCollector codeFragmentCollector) {
	}
	
	protected abstract String getFixedPointFunctionName(FixedPointFormat fixedPointFormat);
	protected abstract String getFloatingPointFunctionName(FloatingPointFormat floatingPointFormat);
	
}
