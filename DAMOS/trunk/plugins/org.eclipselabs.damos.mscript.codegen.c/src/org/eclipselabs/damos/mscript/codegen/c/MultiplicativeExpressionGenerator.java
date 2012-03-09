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

import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.mscript.MultiplicativeOperator;
import org.eclipselabs.damos.mscript.codegen.c.internal.util.CastToFixedPointHelper;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.FloatingPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;

/**
 * @author Andreas Unger
 *
 */
public class MultiplicativeExpressionGenerator {
	
	public void generate(Appendable appendable, MultiplicativeOperator operator, NumberFormat targetNumberFormat, NumericExpressionInfo leftOperand, NumericExpressionInfo rightOperand) throws IOException {
		PrintAppendable out = new PrintAppendable(appendable);
		if (targetNumberFormat instanceof FloatingPointFormat) {
			writeFloatingPointMultiplicativeExpression(out, operator, targetNumberFormat, leftOperand, rightOperand);
		} else if (targetNumberFormat instanceof FixedPointFormat) {
			writeFixedPointMultiplicativeExpression(out, operator, (FixedPointFormat) targetNumberFormat, leftOperand, rightOperand);
		} else {
			throw new IllegalArgumentException();
		}
	}

	private void writeFloatingPointMultiplicativeExpression(PrintAppendable out, MultiplicativeOperator operator, NumberFormat targetNumberFormat, NumericExpressionInfo leftOperand, NumericExpressionInfo rightOperand) throws IOException {
		if (operator == MultiplicativeOperator.MODULO) {
			out.print("fmod(");
			NumericExpressionCaster.INSTANCE.cast(out, targetNumberFormat, leftOperand);
			out.print(", ");
			NumericExpressionCaster.INSTANCE.cast(out, targetNumberFormat, rightOperand);
			out.print(")");
		} else {
			NumericExpressionCaster.INSTANCE.cast(out, targetNumberFormat, leftOperand);
			out.print(" ");
			out.print(operator.getLiteral());
			out.print(" ");
			NumericExpressionCaster.INSTANCE.cast(out, targetNumberFormat, rightOperand);
		}
	}
	
	private void writeFixedPointMultiplicativeExpression(PrintAppendable out, MultiplicativeOperator operator, FixedPointFormat targetNumberFormat, NumericExpressionInfo leftOperand, NumericExpressionInfo rightOperand) throws IOException {
		switch (operator) {
		case MULTIPLY:
			writeFixedPointMultiplicationExpression(out, targetNumberFormat, leftOperand, rightOperand);
			break;
		case DIVIDE:
			writeFixedPointDivisionExpression(out, targetNumberFormat, leftOperand, rightOperand);
			break;
		case MODULO:
			NumericExpressionCaster.INSTANCE.cast(out, targetNumberFormat, leftOperand);
			out.print(" % ");
			NumericExpressionCaster.INSTANCE.cast(out, targetNumberFormat, rightOperand);
			break;
		default:
			throw new IllegalArgumentException();
		}
	}
	
	private void writeFixedPointMultiplicationExpression(PrintAppendable out, FixedPointFormat targetNumberFormat, NumericExpressionInfo leftOperand, NumericExpressionInfo rightOperand) throws IOException {
		int intermediateWordSize = getIntermediateWordSize(targetNumberFormat);
		boolean hasIntermediateWordSize = intermediateWordSize != targetNumberFormat.getWordSize();
	
		if (hasIntermediateWordSize) {
			out.printf("(int%d_t) ", targetNumberFormat.getWordSize());
		}
		
		if (hasIntermediateWordSize || targetNumberFormat.getFractionLength() > 0) {
			out.print("(");
		}
		
		CastToFixedPointHelper.INSTANCE.cast(out, intermediateWordSize, targetNumberFormat.getFractionLength(), leftOperand);
		
		out.print(" * ");
		
		if (targetNumberFormat.getFractionLength() > 0) {
			out.print("(");
		}

		CastToFixedPointHelper.INSTANCE.cast(out, intermediateWordSize, targetNumberFormat.getFractionLength(), rightOperand);
		
		if (targetNumberFormat.getFractionLength() > 0) {
			out.printf(") >> %d", targetNumberFormat.getFractionLength());
		}

		if (hasIntermediateWordSize || targetNumberFormat.getFractionLength() > 0) {
			out.print(")");
		}
	}

	private void writeFixedPointDivisionExpression(PrintAppendable out, FixedPointFormat targetNumberFormat, NumericExpressionInfo leftOperand, NumericExpressionInfo rightOperand) throws IOException {
		int intermediateWordSize = getIntermediateWordSize(targetNumberFormat);
		boolean hasIntermediateWordSize = intermediateWordSize != targetNumberFormat.getWordSize();
	
		if (hasIntermediateWordSize) {
			out.printf("(int%d_t) (", targetNumberFormat.getWordSize());
		}
		
		if (targetNumberFormat.getFractionLength() > 0) {
			out.print("((");
		}

		CastToFixedPointHelper.INSTANCE.cast(out, intermediateWordSize, targetNumberFormat.getFractionLength(), leftOperand);
		
		if (targetNumberFormat.getFractionLength() > 0) {
			out.printf(") << %d)", targetNumberFormat.getFractionLength());
		}

		out.print(" / ");
		
		CastToFixedPointHelper.INSTANCE.cast(out, intermediateWordSize, targetNumberFormat.getFractionLength(), rightOperand);
		
		if (hasIntermediateWordSize) {
			out.print(")");
		}
	}

	private int getIntermediateWordSize(FixedPointFormat fixedPointFormat) {
		if (fixedPointFormat.getFractionLength() != 0) {
			return 2 * fixedPointFormat.getWordSize();
		}
		return fixedPointFormat.getWordSize();
	}

}
