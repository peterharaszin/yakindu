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

package org.eclipselabs.damos.mscript.codegen.c;

import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.codegen.c.util.MscriptGeneratorUtil;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;

/**
 * @author Andreas Unger
 *
 */
public class NumericExpressionOperand implements INumericExpressionOperand {
	
	private final IMscriptGeneratorContext context;
	private final Expression expression;
	
	/**
	 * 
	 */
	public NumericExpressionOperand(IMscriptGeneratorContext context, Expression expression) {
		this.context = context;
		this.expression = expression;
	}

	public CharSequence generate(NumberFormat targetNumberFormat) {
		return MscriptGeneratorUtil.castNumericType(context, expression, targetNumberFormat);
	}

}
