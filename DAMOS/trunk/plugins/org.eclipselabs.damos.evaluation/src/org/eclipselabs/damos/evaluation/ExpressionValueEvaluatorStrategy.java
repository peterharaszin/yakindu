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

import org.eclipselabs.mscript.language.ast.BooleanKind;
import org.eclipselabs.mscript.language.ast.BooleanLiteral;
import org.eclipselabs.mscript.language.ast.IntegerLiteral;
import org.eclipselabs.mscript.language.ast.RealLiteral;
import org.eclipselabs.mscript.language.ast.StringLiteral;
import org.eclipselabs.mscript.language.ast.SymbolReference;
import org.eclipselabs.mscript.typesystem.DataType;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionValueEvaluatorStrategy implements IExpressionEvaluatorStrategy<IValue> {

	private ExpressionDataTypeEvaluatorStrategy dataTypeEvaluatorStrategy = new ExpressionDataTypeEvaluatorStrategy();
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IExpressionEvaluatorStrategy#add(java.lang.Object, java.lang.Object)
	 */
	public IValue add(IEvaluationContext context, IValue addend1, IValue addend2) {
		return addend1.add(addend2);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IExpressionEvaluatorStrategy#subtract(java.lang.Object, java.lang.Object)
	 */
	public IValue subtract(IEvaluationContext context, IValue minuend, IValue subtrahend) {
		return minuend.subtract(subtrahend);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IExpressionEvaluatorStrategy#multiply(java.lang.Object, java.lang.Object)
	 */
	public IValue multiply(IEvaluationContext context, IValue factor1, IValue factor2) {
		return factor1.multiply(factor2);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IExpressionEvaluatorStrategy#divide(java.lang.Object, java.lang.Object)
	 */
	public IValue divide(IEvaluationContext context, IValue dividend, IValue divisor) {
		return dividend.divide(divisor);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IExpressionEvaluatorStrategy#elementWiseMultiply(java.lang.Object, java.lang.Object)
	 */
	public IValue elementWiseMultiply(IEvaluationContext context, IValue factor1, IValue factor2) {
		return factor1.elementWiseMultiply(factor2);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IExpressionEvaluatorStrategy#elementWiseDivide(java.lang.Object, java.lang.Object)
	 */
	public IValue elementWiseDivide(IEvaluationContext context, IValue dividend, IValue divisor) {
		return dividend.elementWiseDivide(divisor);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IExpressionEvaluatorStrategy#unaryMinus(java.lang.Object)
	 */
	public IValue unaryMinus(IEvaluationContext context, IValue operand) {
		return operand.unaryMinus();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IExpressionEvaluatorStrategy#processMatrix(org.eclipselabs.damos.evaluation.IEvaluationContext, T[][], int, int)
	 */
	public IValue processMatrix(IEvaluationContext context, IValue[][] matrix, int rowSize, int columnSize) {
		return InvalidValue.SINGLETON;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IExpressionEvaluatorStrategy#processRealLiteral(org.eclipselabs.mscript.language.ast.RealLiteral)
	 */
	public IValue processRealLiteral(IEvaluationContext context, RealLiteral realLiteral) {
		DataType dataType = dataTypeEvaluatorStrategy.processRealLiteral(context, realLiteral);
		return new RealValue(dataType, realLiteral.getValue());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IExpressionEvaluatorStrategy#processIntegerLiteral(org.eclipselabs.mscript.language.ast.IntegerLiteral)
	 */
	public IValue processIntegerLiteral(IEvaluationContext context, IntegerLiteral integerLiteral) {
		DataType dataType = dataTypeEvaluatorStrategy.processIntegerLiteral(context, integerLiteral);
		return new IntegerValue(dataType, integerLiteral.getValue());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IExpressionEvaluatorStrategy#processBooleanLiteral(org.eclipselabs.mscript.language.ast.BooleanLiteral)
	 */
	public IValue processBooleanLiteral(IEvaluationContext context, BooleanLiteral booleanLiteral) {
		DataType dataType = dataTypeEvaluatorStrategy.processBooleanLiteral(context, booleanLiteral);
		return new BooleanValue(dataType, booleanLiteral.getValue() == BooleanKind.TRUE);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IExpressionEvaluatorStrategy#processStringLiteral(org.eclipselabs.mscript.language.ast.StringLiteral)
	 */
	public IValue processStringLiteral(IEvaluationContext context, StringLiteral stringLiteral) {
		DataType dataType = dataTypeEvaluatorStrategy.processStringLiteral(context, stringLiteral);
		return new StringValue(dataType, stringLiteral.getValue());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IExpressionEvaluatorStrategy#processSymbolReference(org.eclipselabs.mscript.language.ast.SymbolReference)
	 */
	public IValue processSymbolReference(IEvaluationContext context, SymbolReference symbolReference) {
		return InvalidValue.SINGLETON;
	}
	
}
