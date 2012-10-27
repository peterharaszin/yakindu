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
import org.eclipse.damos.mscript.ArrayType;
import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.FunctionCall;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.codegen.c.ExpressionGenerator;
import org.eclipse.damos.mscript.codegen.c.IExpressionGenerator;
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipse.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class SumFunctionGenerator implements IBuiltinFunctionGenerator {

	private final IExpressionGenerator expressionGenerator = new ExpressionGenerator();
	
	public CharSequence generate(IMscriptGeneratorContext context, FunctionCall functionCall) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		
		Expression argument = functionCall.getArguments().get(0);
		
		Type type = context.getFunctionInfo().getValue(argument).getDataType();
		if (!TypeUtil.isNumericArray(type)) {
			throw new RuntimeException("Target type of sum() method must be tensor type");
		}
		
		ArrayType arrayType = (ArrayType) type;
		
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
