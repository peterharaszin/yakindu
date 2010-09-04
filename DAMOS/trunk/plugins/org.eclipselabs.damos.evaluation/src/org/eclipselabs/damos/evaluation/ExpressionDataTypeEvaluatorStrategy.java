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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.evaluation.internal.InvalidUnitExpressionOperandException;
import org.eclipselabs.damos.evaluation.internal.UnitExpressionHelper;
import org.eclipselabs.damos.scripting.mscript.BooleanLiteral;
import org.eclipselabs.damos.scripting.mscript.IntegerLiteral;
import org.eclipselabs.damos.scripting.mscript.RealLiteral;
import org.eclipselabs.damos.scripting.mscript.StringLiteral;
import org.eclipselabs.damos.scripting.mscript.SymbolReference;
import org.eclipselabs.damos.typesystem.DataType;
import org.eclipselabs.damos.typesystem.IntegerType;
import org.eclipselabs.damos.typesystem.InvalidDataType;
import org.eclipselabs.damos.typesystem.OperatorKind;
import org.eclipselabs.damos.typesystem.RealType;
import org.eclipselabs.damos.typesystem.TypeSystemFactory;
import org.eclipselabs.damos.typesystem.util.TypeSystemUtil;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionDataTypeEvaluatorStrategy implements IExpressionEvaluatorStrategy<DataType> {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IExpressionEvaluatorStrategy#add(java.lang.Object, java.lang.Object)
	 */
	public DataType add(IEvaluationContext context, DataType addend1, DataType addend2) {
		return addend1.evaluate(OperatorKind.ADD, addend2);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IExpressionEvaluatorStrategy#subtract(java.lang.Object, java.lang.Object)
	 */
	public DataType subtract(IEvaluationContext context, DataType minuend, DataType subtrahend) {
		return minuend.evaluate(OperatorKind.SUBTRACT, subtrahend);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IExpressionEvaluatorStrategy#multiply(java.lang.Object, java.lang.Object)
	 */
	public DataType multiply(IEvaluationContext context, DataType factor1, DataType factor2) {
		return factor1.evaluate(OperatorKind.MULTIPLY, factor2);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IExpressionEvaluatorStrategy#divide(java.lang.Object, java.lang.Object)
	 */
	public DataType divide(IEvaluationContext context, DataType dividend, DataType divisor) {
		return dividend.evaluate(OperatorKind.DIVIDE, divisor);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IExpressionEvaluatorStrategy#elementWiseMultiply(java.lang.Object, java.lang.Object)
	 */
	public DataType elementWiseMultiply(IEvaluationContext context, DataType factor1, DataType factor2) {
		return factor1.evaluate(OperatorKind.ELEMENT_WISE_MULTIPLY, factor2);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IExpressionEvaluatorStrategy#elementWiseDivide(java.lang.Object, java.lang.Object)
	 */
	public DataType elementWiseDivide(IEvaluationContext context, DataType dividend, DataType divisor) {
		return dividend.evaluate(OperatorKind.ELEMENT_WISE_DIVIDE, divisor);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IExpressionEvaluatorStrategy#unaryMinus(java.lang.Object)
	 */
	public DataType unaryMinus(IEvaluationContext context, DataType operand) {
		return operand.evaluate(OperatorKind.UNARY_MINUS, null);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IExpressionEvaluatorStrategy#processMatrix(org.eclipselabs.damos.evaluation.IEvaluationContext, T[][], int, int)
	 */
	public DataType processMatrix(IEvaluationContext context, DataType[][] matrix, int rowSize, int columnSize) {
		DataType elementType = null;
		
		for (int row = 0; row < rowSize; ++row) {
			for (int column = 0; column < columnSize; ++column) {
				DataType dataType = matrix[row][column];
				
				if (dataType == null || dataType instanceof InvalidDataType) {
					return TypeSystemUtil.INVALID_DATA_TYPE;
				}
				
				if (!EcoreUtil.equals(elementType, dataType)) {
					DataType leftHandDataType = TypeSystemUtil.getLeftHandDataType(elementType, dataType);
					if (leftHandDataType == null) {
						return TypeSystemUtil.INVALID_DATA_TYPE;
					}
					dataType = leftHandDataType;
				}
				
				elementType = dataType;
			}
		}
		
		return TypeSystemUtil.createArrayType(elementType, rowSize, columnSize);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IExpressionEvaluatorStrategy#processRealLiteral(org.eclipselabs.damos.scripting.mscript.RealLiteral)
	 */
	public DataType processRealLiteral(IEvaluationContext context, RealLiteral realLiteral) {
		RealType realType = TypeSystemFactory.eINSTANCE.createRealType();
		try {
			if (realLiteral.getUnit() != null) {
				realType.setUnit(new UnitExpressionHelper().evaluate(realLiteral.getUnit()));
			} else {
				realType.setUnit(TypeSystemUtil.createUnit());
			}
		} catch (InvalidUnitExpressionOperandException e) {
			return TypeSystemUtil.INVALID_DATA_TYPE;
		}
		return realType;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IExpressionEvaluatorStrategy#processIntegerLiteral(org.eclipselabs.damos.scripting.mscript.IntegerLiteral)
	 */
	public DataType processIntegerLiteral(IEvaluationContext context, IntegerLiteral integerLiteral) {
		IntegerType integerType = TypeSystemFactory.eINSTANCE.createIntegerType();
		try {
			if (integerLiteral.getUnit() != null) {
				integerType.setUnit(new UnitExpressionHelper().evaluate(integerLiteral.getUnit()));
			} else {
				integerType.setUnit(TypeSystemUtil.createUnit());
			}
		} catch (InvalidUnitExpressionOperandException e) {
			return TypeSystemUtil.INVALID_DATA_TYPE;
		}
		return integerType;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IExpressionEvaluatorStrategy#processBooleanLiteral(org.eclipselabs.damos.scripting.mscript.BooleanLiteral)
	 */
	public DataType processBooleanLiteral(IEvaluationContext context, BooleanLiteral booleanLiteral) {
		return TypeSystemUtil.BOOLEAN_TYPE;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IExpressionEvaluatorStrategy#processStringLiteral(org.eclipselabs.damos.scripting.mscript.StringLiteral)
	 */
	public DataType processStringLiteral(IEvaluationContext context, StringLiteral stringLiteral) {
		return TypeSystemUtil.STRING_TYPE;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IExpressionEvaluatorStrategy#processSymbolReference(org.eclipselabs.damos.scripting.mscript.SymbolReference)
	 */
	public DataType processSymbolReference(IEvaluationContext context, SymbolReference symbolReference) {
		try {
			return context.getSymbolDataType(symbolReference);
		} catch (CoreException e) {
			// Return invalid data type
		}
		return TypeSystemUtil.INVALID_DATA_TYPE;
	}
	
}
