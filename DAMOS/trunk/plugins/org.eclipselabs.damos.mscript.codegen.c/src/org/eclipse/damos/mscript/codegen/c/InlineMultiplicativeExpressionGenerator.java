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

import org.eclipse.damos.common.util.PrintAppendable;
import org.eclipse.damos.mscript.computation.FixedPointFormat;

/**
 * @author Andreas Unger
 *
 */
public class InlineMultiplicativeExpressionGenerator extends BaseMultiplicativeExpressionGenerator {
	
	protected CharSequence generateFixedPointMultiplicationExpression(ICodeFragmentCollector codeFragmentCollector, FixedPointFormat targetNumberFormat, INumericExpressionOperand leftOperand, INumericExpressionOperand rightOperand) {
		StringBuilder appendable = new StringBuilder();
		PrintAppendable out = new PrintAppendable(appendable);
		
		FixedPointFormat intermediateNumberFormat = getIntermediateNumberFormat(targetNumberFormat);
		boolean hasIntermediateWordSize = intermediateNumberFormat != targetNumberFormat;
		
		if (hasIntermediateWordSize) {
			out.printf("(int%d_t) ", targetNumberFormat.getWordSize());
		}
		
		if (hasIntermediateWordSize || targetNumberFormat.getFractionLength() > 0) {
			out.print("(");
		}
		
		out.print(leftOperand.generate(intermediateNumberFormat));
		
		out.print(" * ");
		
		if (targetNumberFormat.getFractionLength() > 0) {
			out.print("(");
		}

		out.print(rightOperand.generate(intermediateNumberFormat));
		
		if (targetNumberFormat.getFractionLength() > 0) {
			out.printf(") >> %d", targetNumberFormat.getFractionLength());
		}

		if (hasIntermediateWordSize || targetNumberFormat.getFractionLength() > 0) {
			out.print(")");
		}
		
		return appendable;
	}

	protected CharSequence generateFixedPointDivisionExpression(ICodeFragmentCollector codeFragmentCollector, FixedPointFormat targetNumberFormat, INumericExpressionOperand leftOperand, INumericExpressionOperand rightOperand) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);

		FixedPointFormat intermediateNumberFormat = getIntermediateNumberFormat(targetNumberFormat);
		boolean hasIntermediateWordSize = intermediateNumberFormat != targetNumberFormat;
	
		if (hasIntermediateWordSize) {
			out.printf("(int%d_t) (", targetNumberFormat.getWordSize());
		}
		
		if (targetNumberFormat.getFractionLength() > 0) {
			out.print("((");
		}

		out.print(leftOperand.generate(intermediateNumberFormat));
		
		if (targetNumberFormat.getFractionLength() > 0) {
			out.printf(") << %d)", targetNumberFormat.getFractionLength());
		}

		out.print(" / ");
		
		out.print(rightOperand.generate(intermediateNumberFormat));
		
		if (hasIntermediateWordSize) {
			out.print(")");
		}
		
		return sb;
	}
	
}
