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
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.FunctionCall;
import org.eclipselabs.damos.mscript.TensorType;
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
	
	public void generate(IMscriptGeneratorContext context, FunctionCall functionCall) {
		PrintAppendable out = new PrintAppendable(context.getAppendable());
		
		Expression argument = functionCall.getArguments().get(0);
		
		DataType dataType = context.getStaticEvaluationContext().getValue(argument).getDataType();
		if (!(dataType instanceof TensorType)) {
			throw new RuntimeException("Target type of sum() method must be tensor type");
		}
		
		TensorType tensorType = (TensorType) dataType;
		
		int arraySize = TypeUtil.getArraySize(tensorType);
		for (int i = 0; i < arraySize; ++i) {
			if (i > 0) {
				out.print(" + ");
			}
			out.print("(");
			expressionGenerator.generate(context, argument);
			out.printf(")[%d]", i);
		}
	}
	
}
