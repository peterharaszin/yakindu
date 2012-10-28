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

package org.eclipse.damos.mscript.codegen.c;

import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.codegen.c.util.CastHelper;
import org.eclipse.damos.mscript.computation.NumberFormat;

/**
 * @author Andreas Unger
 *
 */
public class NumericExpressionOperand implements INumericExpressionOperand {
	
	private final CastHelper castHelper;
	private final IMscriptGeneratorContext context;
	private final Expression expression;
	
	/**
	 * 
	 */
	public NumericExpressionOperand(CastHelper castHelper, IMscriptGeneratorContext context, Expression expression) {
		this.castHelper = castHelper;
		this.context = context;
		this.expression = expression;
	}

	public CharSequence generate(NumberFormat targetNumberFormat) {
		return castHelper.castNumericType(context, expression, targetNumberFormat);
	}

}
