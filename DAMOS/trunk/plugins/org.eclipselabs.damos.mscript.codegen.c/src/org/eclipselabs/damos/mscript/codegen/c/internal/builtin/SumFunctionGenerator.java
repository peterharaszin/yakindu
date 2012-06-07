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

import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.FunctionCall;
import org.eclipselabs.damos.mscript.codegen.c.ExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.IExpressionGenerator;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class SumFunctionGenerator implements IFunctionGenerator {

	private final IExpressionGenerator expressionGenerator = new ExpressionGenerator();
	
	public CharSequence generate(IMscriptGeneratorContext context, FunctionCall functionCall) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		
		Expression argument = functionCall.getArguments().get(0);
		
		DataType dataType = context.getStaticEvaluationContext().getValue(argument).getDataType();
		if (!TypeUtil.isTensor(dataType)) {
			throw new RuntimeException("Target type of sum() method must be tensor type");
		}
		
		ArrayType arrayType = (ArrayType) dataType;
		
		int arraySize = TypeUtil.getArraySize(arrayType);
		for (int i = 0; i < arraySize; ++i) {
			if (i > 0) {
				out.print(" + ");
			}
			out.print("(");
			out.print(expressionGenerator.generate(context, argument));
			out.printf(")[%d]", i);
		}
		
		return sb;
	}
	
}
