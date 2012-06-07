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
import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.mscript.codegen.c.internal.util.CastToFixedPointHelper;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat;

/**
 * @author Andreas Unger
 *
 */
public class FunctionMultiplicativeExpressionWriter extends BaseMultiplicativeExpressionWriter {
	
	protected CharSequence generateFixedPointMultiplicationExpression(ICodeFragmentCollector codeFragmentCollector, FixedPointFormat targetNumberFormat, NumericExpressionInfo leftOperand, NumericExpressionInfo rightOperand) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		
		out.printf("Mscript_mulfix%d_%d(", targetNumberFormat.getIntegerLength(), targetNumberFormat.getFractionLength());
		try {
			NumericExpressionCaster.INSTANCE.cast(sb, targetNumberFormat, leftOperand);
		} catch (IOException e) {
			// TODO REMOVE
			e.printStackTrace();
		}
		out.print(", ");
		try {
			NumericExpressionCaster.INSTANCE.cast(sb, targetNumberFormat, rightOperand);
		} catch (IOException e) {
			// TODO REMOVE
			e.printStackTrace();
		}
		out.print(")");
		
		codeFragmentCollector.addCodeFragment(new MultiplyFunctionCodeFragment(targetNumberFormat.getIntegerLength(), targetNumberFormat.getFractionLength()), new NullProgressMonitor());
		return sb;
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

		try {
			CastToFixedPointHelper.INSTANCE.cast(out, intermediateWordSize, targetNumberFormat.getFractionLength(), leftOperand);
		} catch (IOException e) {
			// TODO REMOVE
			e.printStackTrace();
		}
		
		if (targetNumberFormat.getFractionLength() > 0) {
			out.printf(") << %d)", targetNumberFormat.getFractionLength());
		}

		out.print(" / ");
		
		try {
			CastToFixedPointHelper.INSTANCE.cast(out, intermediateWordSize, targetNumberFormat.getFractionLength(), rightOperand);
		} catch (IOException e) {
			// TODO REMOVE
			e.printStackTrace();
		}
		
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
	
	private static class MultiplyFunctionCodeFragment extends AbstractCodeFragment {
		
		private final int integerLength;
		private final int fractionLength;
		
		/**
		 * 
		 */
		public MultiplyFunctionCodeFragment(int integerLength, int fractionLength) {
			this.integerLength = integerLength;
			this.fractionLength = fractionLength;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#getIncludes()
		 */
		@Override
		public Collection<Include> getForwardDeclarationIncludes() {
			return Collections.singletonList(new Include("stdint.h"));
		}
		
		public void writeForwardDeclaration(Appendable appendable, boolean internal) throws IOException {
			writeFunctionSignature(appendable, internal);
			appendable.append(";\n");
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#contributesImplementation()
		 */
		@Override
		public boolean contributesImplementation() {
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#writeImplementation(java.lang.Appendable, boolean)
		 */
		@Override
		public void writeImplementation(Appendable appendable, boolean internal) throws IOException {
			PrintAppendable out = new PrintAppendable(appendable);
			
			int wordSize = integerLength + fractionLength;

			writeFunctionSignature(appendable, internal);
			
			out.print(" {\n");
			out.printf("const uint%d_t mask = (INT%d_C(1) << %d) - 1;\n\n", wordSize, wordSize, fractionLength);

			out.printf("int%d_t hi0 = a >> %d;\n", wordSize, fractionLength);
			out.printf("int%d_t hi1 = b >> %d;\n", wordSize, fractionLength);
			out.printf("uint%d_t lo0 = a & mask;\n", wordSize);
			out.printf("uint%d_t lo1 = b & mask;\n\n", wordSize);

			out.printf("int%d_t resultHi = hi0 * hi1;\n", wordSize);
			out.printf("int%d_t result = hi0 * lo1 + hi1 * lo0;\n", wordSize);
			out.printf("uint%d_t resultLo = lo0 * lo1;\n\n", wordSize);

			out.printf("result += (resultHi & mask) << %d;\n", fractionLength);
			out.printf("result += resultLo >> %d;\n\n", fractionLength);

			out.printf("return result;\n");
			out.println("}");
		}
		
		private void writeFunctionSignature(Appendable appendable, boolean internal) throws IOException {
			PrintAppendable out = new PrintAppendable(appendable);

			int wordSize = integerLength + fractionLength;

			if (internal) {
				out.print("static ");
			}
			
			out.printf("int%d_t Mscript_mulfix%d_%d(int%d_t a, int%d_t b)", wordSize, integerLength, fractionLength, wordSize, wordSize);
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			return integerLength ^ fractionLength;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof MultiplyFunctionCodeFragment) {
				MultiplyFunctionCodeFragment other = (MultiplyFunctionCodeFragment) obj;
				return other.integerLength == integerLength && other.fractionLength == fractionLength;
			}
			return false;
		}
		
	}

}
