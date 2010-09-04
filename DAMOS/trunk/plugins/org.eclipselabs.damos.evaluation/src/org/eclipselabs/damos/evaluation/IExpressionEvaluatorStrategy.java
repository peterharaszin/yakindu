/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.evaluation;

import org.eclipselabs.damos.scripting.mscript.BooleanLiteral;
import org.eclipselabs.damos.scripting.mscript.IntegerLiteral;
import org.eclipselabs.damos.scripting.mscript.RealLiteral;
import org.eclipselabs.damos.scripting.mscript.StringLiteral;
import org.eclipselabs.damos.scripting.mscript.SymbolReference;

/**
 * @author Andreas Unger
 *
 */
public interface IExpressionEvaluatorStrategy<T> {

	T add(IEvaluationContext context, T addend1, T addend2);
	T subtract(IEvaluationContext context, T minuend, T subtrahend);
	T multiply(IEvaluationContext context, T factor1, T factor2);
	T divide(IEvaluationContext context, T dividend, T divisor);
	T elementWiseDivide(IEvaluationContext context, T dividend, T divisor);
	T elementWiseMultiply(IEvaluationContext context, T factor1, T factor2);
	T unaryMinus(IEvaluationContext context, T operand);
	
	T processMatrix(IEvaluationContext context, T[][] matrix, int rowSize, int columnSize);

	T processRealLiteral(IEvaluationContext context, RealLiteral realLiteral);
	T processIntegerLiteral(IEvaluationContext context, IntegerLiteral integerLiteral);
	T processBooleanLiteral(IEvaluationContext context, BooleanLiteral booleanLiteral);
	T processStringLiteral(IEvaluationContext context, StringLiteral stringLiteral);
	
	T processSymbolReference(IEvaluationContext context, SymbolReference symbolReference);
	
}
