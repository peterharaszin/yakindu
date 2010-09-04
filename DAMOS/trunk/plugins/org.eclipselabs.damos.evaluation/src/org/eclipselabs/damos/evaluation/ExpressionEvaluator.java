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
import org.eclipselabs.damos.scripting.mscript.BooleanLiteral;
import org.eclipselabs.damos.scripting.mscript.Expression;
import org.eclipselabs.damos.scripting.mscript.ExpressionList;
import org.eclipselabs.damos.scripting.mscript.IntegerLiteral;
import org.eclipselabs.damos.scripting.mscript.MatrixConstructionOperator;
import org.eclipselabs.damos.scripting.mscript.MultiplyDivideExpression;
import org.eclipselabs.damos.scripting.mscript.MultiplyDivideOperator;
import org.eclipselabs.damos.scripting.mscript.ParenthesizedExpression;
import org.eclipselabs.damos.scripting.mscript.RealLiteral;
import org.eclipselabs.damos.scripting.mscript.StringLiteral;
import org.eclipselabs.damos.scripting.mscript.SymbolReference;
import org.eclipselabs.damos.scripting.mscript.UnaryMinusExpression;
import org.eclipselabs.damos.scripting.mscript.util.MscriptSwitch;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionEvaluator<T> extends MscriptSwitch<T> {
	
	private IEvaluationContext context;
	private IExpressionEvaluatorStrategy<T> strategy;
	
	/**
	 * 
	 */
	public ExpressionEvaluator(IEvaluationContext context, IExpressionEvaluatorStrategy<T> strategy) {
		this.context = context;
		this.strategy = strategy;
	}
	
	/**
	 * @return the context
	 */
	protected IEvaluationContext getContext() {
		return context;
	}
	
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
	
	protected T add(T addend1, T addend2) {
		return strategy.add(context, addend1, addend2);
	}
	
	protected T subtract(T minuend, T subtrahend) {
		return strategy.subtract(context, minuend, subtrahend);
	}
	
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
		case ELEMENT_WISE_MULTIPLY:
			return elementWiseMultiply(operand1, operand2);
		case ELEMENT_WISE_DIVIDE:
			return elementWiseDivide(operand1, operand2);
		}
		throw new IllegalArgumentException();
	}
	
	protected T multiply(T factor1, T factor2) {
		return strategy.multiply(context, factor1, factor2);
	}
	
	protected T divide(T dividend, T divisor) {
		return strategy.divide(context, dividend, divisor);
	}
	
	protected T elementWiseMultiply(T factor1, T factor2) {
		return strategy.elementWiseMultiply(context, factor1, factor2);
	}

	protected T elementWiseDivide(T dividend, T divisor) {
		return strategy.elementWiseDivide(context, dividend, divisor);
	}
	
	public T caseMatrixConstructionOperator(MatrixConstructionOperator object) {
		int rowSize = object.getExpressionLists().size();
		int columnSize = -1;
		
		for (ExpressionList expressionList : object.getExpressionLists()) {
			if (columnSize == -1) {
				columnSize = expressionList.getExpressions().size();
			} else if (columnSize < expressionList.getExpressions().size()) {
				columnSize = expressionList.getExpressions().size();
			}
		}
		
		@SuppressWarnings("unchecked")
		T[][] matrix = (T[][]) new Object[rowSize][columnSize];

		int row = 0;
		for (ExpressionList expressionList : object.getExpressionLists()) {
			int column = 0;
			for (Expression expression : expressionList.getExpressions()) {
				matrix[row][column] = doSwitch(expression);
				++column;
			}
			++row;
		}
		
		return processMatrix(matrix, rowSize, columnSize);
	}
	
	protected T processMatrix(T[][] matrix, int rowSize, int columnSize) {
		return strategy.processMatrix(context, matrix, rowSize, columnSize);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.scripting.mscript.util.MscriptSwitch#caseUnaryMinusExpression(org.eclipselabs.damos.scripting.mscript.UnaryMinusExpression)
	 */
	@Override
	public T caseUnaryMinusExpression(UnaryMinusExpression object) {
		return strategy.unaryMinus(context, doSwitch(object.getOperand()));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.scripting.mscript.util.MscriptSwitch#caseRealLiteral(org.eclipselabs.damos.scripting.mscript.RealLiteral)
	 */
	@Override
	public T caseRealLiteral(RealLiteral object) {
		return strategy.processRealLiteral(context, object);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.scripting.mscript.util.MscriptSwitch#caseIntegerLiteral(org.eclipselabs.damos.scripting.mscript.IntegerLiteral)
	 */
	@Override
	public T caseIntegerLiteral(IntegerLiteral object) {
		return strategy.processIntegerLiteral(context, object);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.scripting.mscript.util.MscriptSwitch#caseBooleanLiteral(org.eclipselabs.damos.scripting.mscript.BooleanLiteral)
	 */
	@Override
	public T caseBooleanLiteral(BooleanLiteral object) {
		return strategy.processBooleanLiteral(context, object);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.scripting.mscript.util.MscriptSwitch#caseStringLiteral(org.eclipselabs.damos.scripting.mscript.StringLiteral)
	 */
	@Override
	public T caseStringLiteral(StringLiteral object) {
		return strategy.processStringLiteral(context, object);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.scripting.mscript.util.MscriptSwitch#caseSymbolReference(org.eclipselabs.damos.scripting.mscript.SymbolReference)
	 */
	@Override
	public T caseSymbolReference(SymbolReference object) {
		return strategy.processSymbolReference(context, object);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.scripting.mscript.util.MscriptSwitch#caseParenthesizedExpression(org.eclipselabs.damos.scripting.mscript.ParenthesizedExpression)
	 */
	@Override
	public T caseParenthesizedExpression(ParenthesizedExpression object) {
		return doSwitch(object.getExpression());
	}
	
}
