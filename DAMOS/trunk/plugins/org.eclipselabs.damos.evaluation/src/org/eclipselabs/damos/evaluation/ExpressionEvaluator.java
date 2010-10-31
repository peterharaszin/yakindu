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

import org.eclipselabs.mscript.language.ast.AdditiveExpression;
import org.eclipselabs.mscript.language.ast.AdditiveExpressionPart;
import org.eclipselabs.mscript.language.ast.AdditiveOperator;
import org.eclipselabs.mscript.language.ast.ArrayConcatenationOperator;
import org.eclipselabs.mscript.language.ast.BooleanLiteral;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.ExpressionList;
import org.eclipselabs.mscript.language.ast.FeatureCall;
import org.eclipselabs.mscript.language.ast.IntegerLiteral;
import org.eclipselabs.mscript.language.ast.MultiplicativeExpression;
import org.eclipselabs.mscript.language.ast.MultiplicativeExpressionPart;
import org.eclipselabs.mscript.language.ast.MultiplicativeOperator;
import org.eclipselabs.mscript.language.ast.ParenthesizedExpression;
import org.eclipselabs.mscript.language.ast.RealLiteral;
import org.eclipselabs.mscript.language.ast.StringLiteral;
import org.eclipselabs.mscript.language.ast.UnaryExpression;
import org.eclipselabs.mscript.language.ast.UnaryOperator;
import org.eclipselabs.mscript.language.ast.util.AstSwitch;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionEvaluator<T> extends AstSwitch<T> {
	
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
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseAdditiveExpression(org.eclipselabs.mscript.language.ast.AdditiveExpression)
	 */
	@Override
	public T caseAdditiveExpression(AdditiveExpression object) {
		T result = doSwitch(object.getLeftOperand());
		for (AdditiveExpressionPart part : object.getRightParts()) {
			result = addSubtract(result, doSwitch(part.getOperand()), part.getOperator());
		}
		return result;
	}
	
	protected T addSubtract(T operand1, T operand2, AdditiveOperator operator) {
		switch (operator) {
		case ADDITION:
			return add(operand1, operand2);
		case SUBTRACTION:
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
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseMultiplicativeExpression(org.eclipselabs.mscript.language.ast.MultiplicativeExpression)
	 */
	@Override
	public T caseMultiplicativeExpression(MultiplicativeExpression object) {
		T result = doSwitch(object.getLeftOperand());
		for (MultiplicativeExpressionPart part : object.getRightParts()) {
			result = multiplyDivide(result, doSwitch(part.getOperand()), part.getOperator());
		}
		return result;
	}
	
	protected T multiplyDivide(T operand1, T operand2, MultiplicativeOperator operator) {
		switch (operator) {
		case MULTIPLICATION:
			return multiply(operand1, operand2);
		case DIVISION:
			return divide(operand1, operand2);
		case ELEMENT_WISE_MULTIPLICATION:
			return elementWiseMultiply(operand1, operand2);
		case ELEMENT_WISE_DIVISION:
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
	
	public T caseArrayConcatenationOperator(ArrayConcatenationOperator object) {
		int rowSize = object.getRows().size();
		int columnSize = -1;
		
		for (ExpressionList expressionList : object.getRows()) {
			if (columnSize == -1) {
				columnSize = expressionList.getExpressions().size();
			} else if (columnSize < expressionList.getExpressions().size()) {
				columnSize = expressionList.getExpressions().size();
			}
		}
		
		@SuppressWarnings("unchecked")
		T[][] matrix = (T[][]) new Object[rowSize][columnSize];

		int row = 0;
		for (ExpressionList expressionList : object.getRows()) {
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
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseUnaryExpression(org.eclipselabs.mscript.language.ast.UnaryExpression)
	 */
	@Override
	public T caseUnaryExpression(UnaryExpression object) {
		if (object.getOperator() == UnaryOperator.MINUS) {
			return strategy.unaryMinus(context, doSwitch(object.getOperand()));
		}
		throw new IllegalArgumentException();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRealLiteral(org.eclipselabs.mscript.language.ast.RealLiteral)
	 */
	@Override
	public T caseRealLiteral(RealLiteral object) {
		return strategy.processRealLiteral(context, object);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIntegerLiteral(org.eclipselabs.mscript.language.ast.IntegerLiteral)
	 */
	@Override
	public T caseIntegerLiteral(IntegerLiteral object) {
		return strategy.processIntegerLiteral(context, object);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseBooleanLiteral(org.eclipselabs.mscript.language.ast.BooleanLiteral)
	 */
	@Override
	public T caseBooleanLiteral(BooleanLiteral object) {
		return strategy.processBooleanLiteral(context, object);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseStringLiteral(org.eclipselabs.mscript.language.ast.StringLiteral)
	 */
	@Override
	public T caseStringLiteral(StringLiteral object) {
		return strategy.processStringLiteral(context, object);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseSymbolReference(org.eclipselabs.mscript.language.ast.SymbolReference)
	 */
	@Override
	public T caseFeatureCall(FeatureCall object) {
		return strategy.processSymbolReference(context, object);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseParenthesizedExpression(org.eclipselabs.mscript.language.ast.ParenthesizedExpression)
	 */
	@Override
	public T caseParenthesizedExpression(ParenthesizedExpression object) {
		return doSwitch(object.getExpressions().get(0));
	}
	
}
