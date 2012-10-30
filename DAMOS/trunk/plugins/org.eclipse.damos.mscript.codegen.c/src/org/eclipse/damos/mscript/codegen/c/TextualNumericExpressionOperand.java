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

import org.eclipse.damos.mscript.computation.NumberFormat;

/**
 * @author Andreas Unger
 *
 */
public class TextualNumericExpressionOperand implements INumericExpressionOperand {

	private final NumericExpressionCaster numericExpressionCaster;
	private final NumberFormat numberFormat;
	private final CharSequence expression;
	
	public TextualNumericExpressionOperand(NumericExpressionCaster numericExpressionCaster, CharSequence expression, NumberFormat numberFormat) {
		this.numericExpressionCaster = numericExpressionCaster;
		this.numberFormat = numberFormat;
		this.expression = expression;
	}
	
	public CharSequence generate(NumberFormat targetNumberFormat) {
		return numericExpressionCaster.cast(expression, numberFormat, targetNumberFormat);
	}

}
