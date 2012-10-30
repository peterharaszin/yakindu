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

import org.eclipse.damos.mscript.computation.FixedPointFormat;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class InlineMultiplicativeExpressionGenerator extends BaseMultiplicativeExpressionGenerator {
	
	@Inject
	private PrimitiveTypeGenerator primitiveTypeGenerator;
	
	protected CharSequence generateFixedPointMultiplicationExpression(ICodeFragmentCollector codeFragmentCollector, FixedPointFormat targetNumberFormat, INumericExpressionOperand leftOperand, INumericExpressionOperand rightOperand) {
		StringBuilder sb = new StringBuilder();
		
		FixedPointFormat intermediateNumberFormat = getIntermediateNumberFormat(targetNumberFormat);
		boolean hasIntermediateWordSize = intermediateNumberFormat != targetNumberFormat;
		
		if (hasIntermediateWordSize) {
			sb.append("(");
			sb.append(primitiveTypeGenerator.generateIntegerType(targetNumberFormat.getWordSize()));
			sb.append(") ");
		}
		
		if (hasIntermediateWordSize || targetNumberFormat.getFractionLength() > 0) {
			sb.append("(");
		}
		
		sb.append(leftOperand.generate(intermediateNumberFormat));
		
		sb.append(" * ");
		
		if (targetNumberFormat.getFractionLength() > 0) {
			sb.append("(");
		}

		sb.append(rightOperand.generate(intermediateNumberFormat));
		
		if (targetNumberFormat.getFractionLength() > 0) {
			sb.append(") >> ");
			sb.append(targetNumberFormat.getFractionLength());
		}

		if (hasIntermediateWordSize || targetNumberFormat.getFractionLength() > 0) {
			sb.append(")");
		}
		
		return sb;
	}

	protected CharSequence generateFixedPointDivisionExpression(ICodeFragmentCollector codeFragmentCollector, FixedPointFormat targetNumberFormat, INumericExpressionOperand leftOperand, INumericExpressionOperand rightOperand) {
		StringBuilder sb = new StringBuilder();

		FixedPointFormat intermediateNumberFormat = getIntermediateNumberFormat(targetNumberFormat);
		boolean hasIntermediateWordSize = intermediateNumberFormat != targetNumberFormat;
	
		if (hasIntermediateWordSize) {
			sb.append("(");
			sb.append(primitiveTypeGenerator.generateIntegerType(targetNumberFormat.getWordSize()));
			sb.append(") (");
		}
		
		if (targetNumberFormat.getFractionLength() > 0) {
			sb.append("((");
		}

		sb.append(leftOperand.generate(intermediateNumberFormat));
		
		if (targetNumberFormat.getFractionLength() > 0) {
			sb.append(") << ");
			sb.append(targetNumberFormat.getFractionLength());
			sb.append(")");
		}

		sb.append(" / ");
		
		sb.append(rightOperand.generate(intermediateNumberFormat));
		
		if (hasIntermediateWordSize) {
			sb.append(")");
		}
		
		return sb;
	}
	
}
