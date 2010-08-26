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

import java.util.Iterator;

import org.eclipselabs.damos.scripting.mscript.AddSubtractExpression;
import org.eclipselabs.damos.scripting.mscript.AddSubtractOperator;
import org.eclipselabs.damos.scripting.mscript.Expression;
import org.eclipselabs.damos.scripting.mscript.MultiplyDivideExpression;
import org.eclipselabs.damos.scripting.mscript.MultiplyDivideOperator;
import org.eclipselabs.damos.scripting.mscript.ParenthesizedExpression;
import org.eclipselabs.damos.scripting.mscript.util.MscriptSwitch;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractExpressionEvaluator<T> extends MscriptSwitch<T> {
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.scripting.mscript.util.MscriptSwitch#caseAddSubtractExpression(org.eclipselabs.damos.scripting.mscript.AddSubtractExpression)
	 */
	@Override
	public T caseAddSubtractExpression(AddSubtractExpression object) {
		T result = null;
		Iterator<AddSubtractOperator> operatorIterator = object.getOperators().iterator();
		for (Expression expression : object.getOperands()) {
			if (result == null) {
				result = doSwitch(expression);
			} else {
				result = addSubtract(result, doSwitch(expression), operatorIterator.next());
			}
		}
		return result;
	}
	
	protected T addSubtract(T operand1, T operand2, AddSubtractOperator operator) {
		switch (operator) {
		case ADD:
			return add(operand1, operand2);
		case SUBTRACT:
			return subtract(operand1, operand2);
		}
		throw new IllegalArgumentException();
	}
	
	protected abstract T add(T addend1, T addend2);
	
	protected abstract T subtract(T minuend, T subtrahend);
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.scripting.mscript.util.MscriptSwitch#caseMultiplyDivideExpression(org.eclipselabs.damos.scripting.mscript.MultiplyDivideExpression)
	 */
	@Override
	public T caseMultiplyDivideExpression(MultiplyDivideExpression object) {
		T result = null;
		Iterator<MultiplyDivideOperator> operatorIterator = object.getOperators().iterator();
		for (Expression expression : object.getOperands()) {
			if (result == null) {
				result = doSwitch(expression);
			} else {
				result = multiplyDivide(result, doSwitch(expression), operatorIterator.next());
			}
		}
		return result;
	}
	
	protected T multiplyDivide(T operand1, T operand2, MultiplyDivideOperator operator) {
		switch (operator) {
		case MULTIPLY:
			return multiply(operand1, operand2);
		case DIVIDE:
			return divide(operand1, operand2);
		}
		throw new IllegalArgumentException();
	}
	
	protected abstract T multiply(T factor1, T factor2);
	
	protected abstract T divide(T dividend, T divisor);
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.scripting.mscript.util.MscriptSwitch#caseParenthesizedExpression(org.eclipselabs.damos.scripting.mscript.ParenthesizedExpression)
	 */
	@Override
	public T caseParenthesizedExpression(ParenthesizedExpression object) {
		return doSwitch(object.getExpression());
	}
	
}
