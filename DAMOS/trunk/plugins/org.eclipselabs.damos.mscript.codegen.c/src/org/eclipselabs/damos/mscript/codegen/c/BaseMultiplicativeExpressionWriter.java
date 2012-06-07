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
	
	public CharSequence generate(ICodeFragmentCollector codeFragmentCollector, MultiplicativeOperator operator, NumberFormat targetNumberFormat, NumericExpressionInfo leftOperand, NumericExpressionInfo rightOperand) {
		if (targetNumberFormat instanceof FloatingPointFormat) {
			return generateFloatingPointMultiplicativeExpression(codeFragmentCollector, operator, targetNumberFormat, leftOperand, rightOperand);
		} else if (targetNumberFormat instanceof FixedPointFormat) {
			return generateFixedPointMultiplicativeExpression(codeFragmentCollector, operator, (FixedPointFormat) targetNumberFormat, leftOperand, rightOperand);
		} else {
			throw new IllegalArgumentException();
		}
	}

	private CharSequence generateFloatingPointMultiplicativeExpression(ICodeFragmentCollector codeFragmentCollector, MultiplicativeOperator operator, NumberFormat targetNumberFormat, NumericExpressionInfo leftOperand, NumericExpressionInfo rightOperand) {
		StringBuilder sb = new StringBuilder();
		try {
			if (operator == MultiplicativeOperator.MODULO) {
				sb.append("fmod(");
				NumericExpressionCaster.INSTANCE.cast(sb, targetNumberFormat, leftOperand);
				sb.append(", ");
				NumericExpressionCaster.INSTANCE.cast(sb, targetNumberFormat, rightOperand);
				sb.append(")");
			} else {
				NumericExpressionCaster.INSTANCE.cast(sb, targetNumberFormat, leftOperand);
				sb.append(" ");
				sb.append(operator.getLiteral());
				sb.append(" ");
				NumericExpressionCaster.INSTANCE.cast(sb, targetNumberFormat, rightOperand);
			}
		} catch (IOException e) {
			// TODO: REMOVE
			e.printStackTrace();
		}
		return sb;
	}
	
	private CharSequence generateFixedPointMultiplicativeExpression(ICodeFragmentCollector codeFragmentCollector, MultiplicativeOperator operator, FixedPointFormat targetNumberFormat, NumericExpressionInfo leftOperand, NumericExpressionInfo rightOperand) {
		StringBuilder sb = new StringBuilder();
		try {
			switch (operator) {
			case MULTIPLY:
				sb.append(generateFixedPointMultiplicationExpression(codeFragmentCollector, targetNumberFormat, leftOperand, rightOperand));
				break;
			case DIVIDE:
				sb.append(generateFixedPointDivisionExpression(codeFragmentCollector, targetNumberFormat, leftOperand, rightOperand));
				break;
			case MODULO:
				NumericExpressionCaster.INSTANCE.cast(sb, targetNumberFormat, leftOperand);
				sb.append(" % ");
				NumericExpressionCaster.INSTANCE.cast(sb, targetNumberFormat, rightOperand);
				break;
			default:
				throw new IllegalArgumentException();
			}
		} catch (IOException e) {
			// TODO: REMOVE
			e.printStackTrace();
		}
		return sb;
	}
	
	protected abstract CharSequence generateFixedPointMultiplicationExpression(ICodeFragmentCollector codeFragmentCollector, FixedPointFormat targetNumberFormat, NumericExpressionInfo leftOperand, NumericExpressionInfo rightOperand);

	protected abstract CharSequence generateFixedPointDivisionExpression(ICodeFragmentCollector codeFragmentCollector, FixedPointFormat targetNumberFormat, NumericExpressionInfo leftOperand, NumericExpressionInfo rightOperand);

}
