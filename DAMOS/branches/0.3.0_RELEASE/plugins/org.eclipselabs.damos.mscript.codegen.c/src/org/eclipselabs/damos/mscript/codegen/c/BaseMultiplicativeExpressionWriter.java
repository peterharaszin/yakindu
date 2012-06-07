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

import java.io.IOException;

import org.eclipselabs.damos.mscript.MultiplicativeOperator;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.FloatingPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;

/**
 * @author Andreas Unger
 *
 */
public abstract class BaseMultiplicativeExpressionWriter implements IMultiplicativeExpressionWriter {
	
	public void write(Appendable appendable, ICodeFragmentCollector codeFragmentCollector, MultiplicativeOperator operator, NumberFormat targetNumberFormat, NumericExpressionInfo leftOperand, NumericExpressionInfo rightOperand) throws IOException {
		if (targetNumberFormat instanceof FloatingPointFormat) {
			writeFloatingPointMultiplicativeExpression(appendable, codeFragmentCollector, operator, targetNumberFormat, leftOperand, rightOperand);
		} else if (targetNumberFormat instanceof FixedPointFormat) {
			writeFixedPointMultiplicativeExpression(appendable, codeFragmentCollector, operator, (FixedPointFormat) targetNumberFormat, leftOperand, rightOperand);
		} else {
			throw new IllegalArgumentException();
		}
	}

	private void writeFloatingPointMultiplicativeExpression(Appendable appendable, ICodeFragmentCollector codeFragmentCollector, MultiplicativeOperator operator, NumberFormat targetNumberFormat, NumericExpressionInfo leftOperand, NumericExpressionInfo rightOperand) throws IOException {
		if (operator == MultiplicativeOperator.MODULO) {
			appendable.append("fmod(");
			NumericExpressionCaster.INSTANCE.cast(appendable, targetNumberFormat, leftOperand);
			appendable.append(", ");
			NumericExpressionCaster.INSTANCE.cast(appendable, targetNumberFormat, rightOperand);
			appendable.append(")");
		} else {
			NumericExpressionCaster.INSTANCE.cast(appendable, targetNumberFormat, leftOperand);
			appendable.append(" ");
			appendable.append(operator.getLiteral());
			appendable.append(" ");
			NumericExpressionCaster.INSTANCE.cast(appendable, targetNumberFormat, rightOperand);
		}
	}
	
	private void writeFixedPointMultiplicativeExpression(Appendable appendable, ICodeFragmentCollector codeFragmentCollector, MultiplicativeOperator operator, FixedPointFormat targetNumberFormat, NumericExpressionInfo leftOperand, NumericExpressionInfo rightOperand) throws IOException {
		switch (operator) {
		case MULTIPLY:
			writeFixedPointMultiplicationExpression(appendable, codeFragmentCollector, targetNumberFormat, leftOperand, rightOperand);
			break;
		case DIVIDE:
			writeFixedPointDivisionExpression(appendable, codeFragmentCollector, targetNumberFormat, leftOperand, rightOperand);
			break;
		case MODULO:
			NumericExpressionCaster.INSTANCE.cast(appendable, targetNumberFormat, leftOperand);
			appendable.append(" % ");
			NumericExpressionCaster.INSTANCE.cast(appendable, targetNumberFormat, rightOperand);
			break;
		default:
			throw new IllegalArgumentException();
		}
	}
	
	protected abstract void writeFixedPointMultiplicationExpression(Appendable appendable, ICodeFragmentCollector codeFragmentCollector, FixedPointFormat targetNumberFormat, NumericExpressionInfo leftOperand, NumericExpressionInfo rightOperand) throws IOException;

	protected abstract void writeFixedPointDivisionExpression(Appendable appendable, ICodeFragmentCollector codeFragmentCollector, FixedPointFormat targetNumberFormat, NumericExpressionInfo leftOperand, NumericExpressionInfo rightOperand) throws IOException;

}
