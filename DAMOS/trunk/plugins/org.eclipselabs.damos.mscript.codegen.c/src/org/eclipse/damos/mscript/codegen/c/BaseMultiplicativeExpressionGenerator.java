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

import org.eclipse.damos.mscript.OperatorKind;
import org.eclipse.damos.mscript.computation.FixedPointFormat;
import org.eclipse.damos.mscript.computation.FloatingPointFormat;
import org.eclipse.damos.mscript.computation.NumberFormat;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Andreas Unger
 *
 */
public abstract class BaseMultiplicativeExpressionGenerator implements IMultiplicativeExpressionGenerator {
	
	public CharSequence generate(ICodeFragmentCollector codeFragmentCollector, OperatorKind operator, NumberFormat targetNumberFormat, INumericExpressionOperand leftOperand, INumericExpressionOperand rightOperand) {
		if (targetNumberFormat instanceof FloatingPointFormat) {
			return generateFloatingPointMultiplicativeExpression(codeFragmentCollector, operator, targetNumberFormat, leftOperand, rightOperand);
		} else if (targetNumberFormat instanceof FixedPointFormat) {
			return generateFixedPointMultiplicativeExpression(codeFragmentCollector, operator, (FixedPointFormat) targetNumberFormat, leftOperand, rightOperand);
		} else {
			throw new IllegalArgumentException();
		}
	}

	private CharSequence generateFloatingPointMultiplicativeExpression(ICodeFragmentCollector codeFragmentCollector, OperatorKind operator, NumberFormat targetNumberFormat, INumericExpressionOperand leftOperand, INumericExpressionOperand rightOperand) {
		StringBuilder sb = new StringBuilder();
		if (operator == OperatorKind.MODULO || operator == OperatorKind.ELEMENT_WISE_MODULO) {
			sb.append("fmod(");
			sb.append(leftOperand.generate(targetNumberFormat));
			sb.append(", ");
			sb.append(rightOperand.generate(targetNumberFormat));
			sb.append(")");
		} else {
			sb.append(leftOperand.generate(targetNumberFormat));
			sb.append(" ");
			sb.append(operator.getLiteral());
			sb.append(" ");
			sb.append(rightOperand.generate(targetNumberFormat));
		}
		return sb;
	}
	
	private CharSequence generateFixedPointMultiplicativeExpression(ICodeFragmentCollector codeFragmentCollector, OperatorKind operator, FixedPointFormat targetNumberFormat, INumericExpressionOperand leftOperand, INumericExpressionOperand rightOperand) {
		StringBuilder sb = new StringBuilder();
		switch (operator) {
		case MULTIPLY:
		case ELEMENT_WISE_MULTIPLY:
			sb.append(generateFixedPointMultiplicationExpression(codeFragmentCollector, targetNumberFormat, leftOperand, rightOperand));
			break;
		case DIVIDE:
		case ELEMENT_WISE_DIVIDE:
			sb.append(generateFixedPointDivisionExpression(codeFragmentCollector, targetNumberFormat, leftOperand, rightOperand));
			break;
		case MODULO:
		case ELEMENT_WISE_MODULO:
			sb.append(leftOperand.generate(targetNumberFormat));
			sb.append(" % ");
			sb.append(rightOperand.generate(targetNumberFormat));
			break;
		default:
			throw new IllegalArgumentException();
		}
		return sb;
	}
	
	protected abstract CharSequence generateFixedPointMultiplicationExpression(ICodeFragmentCollector codeFragmentCollector, FixedPointFormat targetNumberFormat, INumericExpressionOperand leftOperand, INumericExpressionOperand rightOperand);

	protected abstract CharSequence generateFixedPointDivisionExpression(ICodeFragmentCollector codeFragmentCollector, FixedPointFormat targetNumberFormat, INumericExpressionOperand leftOperand, INumericExpressionOperand rightOperand);

	protected FixedPointFormat getIntermediateNumberFormat(FixedPointFormat fixedPointFormat) {
		int intermediateWordSize = getIntermediateWordSize(fixedPointFormat);
		if (intermediateWordSize != fixedPointFormat.getWordSize()) {
			fixedPointFormat = EcoreUtil.copy(fixedPointFormat);
			fixedPointFormat.setIntegerLength(intermediateWordSize - fixedPointFormat.getFractionLength());
		}
		return fixedPointFormat;
	}

	private int getIntermediateWordSize(FixedPointFormat fixedPointFormat) {
		if (fixedPointFormat.getFractionLength() != 0) {
			return 2 * fixedPointFormat.getWordSize();
		}
		return fixedPointFormat.getWordSize();
	}

}
