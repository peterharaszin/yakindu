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

import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.mscript.codegen.c.internal.util.CastToFixedPointHelper;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat;

/**
 * @author Andreas Unger
 *
 */
public class InlineMultiplicativeExpressionGenerator extends BaseMultiplicativeExpressionGenerator {
	
	protected CharSequence generateFixedPointMultiplicationExpression(ICodeFragmentCollector codeFragmentCollector, FixedPointFormat targetNumberFormat, NumericExpressionInfo leftOperand, NumericExpressionInfo rightOperand) {
		StringBuilder appendable = new StringBuilder();
		PrintAppendable out = new PrintAppendable(appendable);
		
		int intermediateWordSize = getIntermediateWordSize(targetNumberFormat);
		boolean hasIntermediateWordSize = intermediateWordSize != targetNumberFormat.getWordSize();
	
		if (hasIntermediateWordSize) {
			out.printf("(int%d_t) ", targetNumberFormat.getWordSize());
		}
		
		if (hasIntermediateWordSize || targetNumberFormat.getFractionLength() > 0) {
			out.print("(");
		}
		
		out.print(CastToFixedPointHelper.INSTANCE.cast(intermediateWordSize, targetNumberFormat.getFractionLength(), leftOperand));
		
		out.print(" * ");
		
		if (targetNumberFormat.getFractionLength() > 0) {
			out.print("(");
		}

		out.print(CastToFixedPointHelper.INSTANCE.cast(intermediateWordSize, targetNumberFormat.getFractionLength(), rightOperand));
		
		if (targetNumberFormat.getFractionLength() > 0) {
			out.printf(") >> %d", targetNumberFormat.getFractionLength());
		}

		if (hasIntermediateWordSize || targetNumberFormat.getFractionLength() > 0) {
			out.print(")");
		}
		
		return appendable;
	}

	protected CharSequence generateFixedPointDivisionExpression(ICodeFragmentCollector codeFragmentCollector, FixedPointFormat targetNumberFormat, NumericExpressionInfo leftOperand, NumericExpressionInfo rightOperand) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);

		int intermediateWordSize = getIntermediateWordSize(targetNumberFormat);
		boolean hasIntermediateWordSize = intermediateWordSize != targetNumberFormat.getWordSize();
	
		if (hasIntermediateWordSize) {
			out.printf("(int%d_t) (", targetNumberFormat.getWordSize());
		}
		
		if (targetNumberFormat.getFractionLength() > 0) {
			out.print("((");
		}

		out.print(CastToFixedPointHelper.INSTANCE.cast(intermediateWordSize, targetNumberFormat.getFractionLength(), leftOperand));
		
		if (targetNumberFormat.getFractionLength() > 0) {
			out.printf(") << %d)", targetNumberFormat.getFractionLength());
		}

		out.print(" / ");
		
		out.print(CastToFixedPointHelper.INSTANCE.cast(intermediateWordSize, targetNumberFormat.getFractionLength(), rightOperand));
		
		if (hasIntermediateWordSize) {
			out.print(")");
		}
		
		return sb;
	}

	private int getIntermediateWordSize(FixedPointFormat fixedPointFormat) {
		if (fixedPointFormat.getFractionLength() != 0) {
			return 2 * fixedPointFormat.getWordSize();
		}
		return fixedPointFormat.getWordSize();
	}

}
