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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.evaluation.internal.InvalidUnitExpressionOperandException;
import org.eclipselabs.damos.evaluation.internal.UnitExpressionHelper;
import org.eclipselabs.damos.scripting.mscript.BooleanLiteral;
import org.eclipselabs.damos.scripting.mscript.Expression;
import org.eclipselabs.damos.scripting.mscript.ExpressionList;
import org.eclipselabs.damos.scripting.mscript.IntegerLiteral;
import org.eclipselabs.damos.scripting.mscript.MatrixConstructionOperator;
import org.eclipselabs.damos.scripting.mscript.RealLiteral;
import org.eclipselabs.damos.scripting.mscript.StringLiteral;
import org.eclipselabs.damos.scripting.mscript.SymbolReference;
import org.eclipselabs.damos.scripting.mscript.UnaryMinusExpression;
import org.eclipselabs.damos.typesystem.ArrayType;
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
public class ExpressionDataTypeEvaluator extends AbstractExpressionEvaluator<DataType> {

	/**
	 * @param context
	 */
	public ExpressionDataTypeEvaluator(IEvaluationContext context) {
		super(context);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.AbstractExpressionEvaluator#add(java.lang.Object, java.lang.Object)
	 */
	@Override
	protected DataType add(DataType addend1, DataType addend2) {
		return addend1.evaluate(OperatorKind.ADD, addend2);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.AbstractExpressionEvaluator#subtract(java.lang.Object, java.lang.Object)
	 */
	@Override
	protected DataType subtract(DataType minuend, DataType subtrahend) {
		return minuend.evaluate(OperatorKind.SUBTRACT, subtrahend);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.AbstractExpressionEvaluator#multiply(java.lang.Object, java.lang.Object)
	 */
	@Override
	protected DataType multiply(DataType factor1, DataType factor2) {
		return factor1.evaluate(OperatorKind.MULTIPLY, factor2);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.AbstractExpressionEvaluator#divide(java.lang.Object, java.lang.Object)
	 */
	@Override
	protected DataType divide(DataType dividend, DataType divisor) {
		return dividend.evaluate(OperatorKind.DIVIDE, divisor);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.scripting.mscript.util.MscriptSwitch#caseUnaryMinusExpression(org.eclipselabs.damos.scripting.mscript.UnaryMinusExpression)
	 */
	@Override
	public DataType caseUnaryMinusExpression(UnaryMinusExpression object) {
		return doSwitch(object.getOperand()).evaluate(OperatorKind.UNARY_MINUS, null);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.scripting.mscript.util.MscriptSwitch#caseRealLiteral(org.eclipselabs.damos.scripting.mscript.RealLiteral)
	 */
	@Override
	public DataType caseRealLiteral(RealLiteral object) {
		RealType realType = TypeSystemFactory.eINSTANCE.createRealType();
		try {
			if (object.getUnit() != null) {
				realType.setUnit(new UnitExpressionHelper().evaluate(object.getUnit()));
			} else {
				realType.setUnit(TypeSystemUtil.createUnit());
			}
		} catch (InvalidUnitExpressionOperandException e) {
			return TypeSystemFactory.eINSTANCE.createInvalidDataType();
		}
		return realType;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.scripting.mscript.util.MscriptSwitch#caseIntegerLiteral(org.eclipselabs.damos.scripting.mscript.IntegerLiteral)
	 */
	@Override
	public DataType caseIntegerLiteral(IntegerLiteral object) {
		IntegerType integerType = TypeSystemFactory.eINSTANCE.createIntegerType();
		try {
			if (object.getUnit() != null) {
				integerType.setUnit(new UnitExpressionHelper().evaluate(object.getUnit()));
			} else {
				integerType.setUnit(TypeSystemUtil.createUnit());
			}
		} catch (InvalidUnitExpressionOperandException e) {
			return TypeSystemFactory.eINSTANCE.createInvalidDataType();
		}
		return integerType;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.scripting.mscript.util.MscriptSwitch#caseBooleanLiteral(org.eclipselabs.damos.scripting.mscript.BooleanLiteral)
	 */
	@Override
	public DataType caseBooleanLiteral(BooleanLiteral object) {
		return TypeSystemFactory.eINSTANCE.createBooleanType();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.scripting.mscript.util.MscriptSwitch#caseStringLiteral(org.eclipselabs.damos.scripting.mscript.StringLiteral)
	 */
	@Override
	public DataType caseStringLiteral(StringLiteral object) {
		return TypeSystemFactory.eINSTANCE.createStringType();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.scripting.mscript.util.MscriptSwitch#caseArrayConcatenationOperator(org.eclipselabs.damos.scripting.mscript.ArrayConcatenationOperator)
	 */
	@Override
	public DataType caseMatrixConstructionOperator(MatrixConstructionOperator object) {
		ArrayType arrayType = null;
		
		int rowSize = object.getExpressionLists().size();
		int columnSize = -1;
		
		int row = 0;
		for (ExpressionList expressionList : object.getExpressionLists()) {
			if (columnSize == -1) {
				columnSize = expressionList.getExpressions().size();
			} else if (columnSize != expressionList.getExpressions().size()) {
				return TypeSystemFactory.eINSTANCE.createInvalidDataType(); 
			}
			
			int column = 0;
			for (Expression expression : expressionList.getExpressions()) {
				DataType elementType = doSwitch(expression);
				
				if (elementType instanceof InvalidDataType) {
					return TypeSystemFactory.eINSTANCE.createInvalidDataType();
				}
				
				if (arrayType == null) {
					arrayType = TypeSystemUtil.createArrayType(elementType, rowSize, columnSize);
				} else if (!EcoreUtil.equals(arrayType.getElementType(), elementType)) {
					DataType commonDataType = TypeSystemUtil.getLeftHandDataType(arrayType.getElementType(), elementType);
					if (commonDataType == null) {
						return TypeSystemFactory.eINSTANCE.createInvalidDataType();
					}
					arrayType.setElementType(commonDataType);
				}
				++column;
			}
			++row;
		}
		
		if (arrayType == null) {
			return TypeSystemFactory.eINSTANCE.createInvalidDataType();
		}
		
		return arrayType;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.scripting.mscript.util.MscriptSwitch#caseSymbolReference(org.eclipselabs.damos.scripting.mscript.SymbolReference)
	 */
	@Override
	public DataType caseSymbolReference(SymbolReference object) {
		try {
			return getContext().getSymbolDataType(object);
		} catch (CoreException e) {
			// Return invalid data type
		}
		return TypeSystemFactory.eINSTANCE.createInvalidDataType(); 
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.scripting.mscript.util.MscriptSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public DataType defaultCase(EObject object) {
		return TypeSystemFactory.eINSTANCE.createInvalidDataType();
	}

}
