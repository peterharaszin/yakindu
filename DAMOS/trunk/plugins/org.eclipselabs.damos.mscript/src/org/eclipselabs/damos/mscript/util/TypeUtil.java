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

package org.eclipselabs.damos.mscript.util;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.EqualityHelper;
import org.eclipselabs.damos.mscript.ArrayDimension;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.IntegerLiteral;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.TensorType;
import org.eclipselabs.damos.mscript.Unit;
import org.eclipselabs.damos.mscript.UnitFactor;

/**
 * @author Andreas Unger
 *
 */
public class TypeUtil {
	
	public static final DataType INVALID_DATA_TYPE = MscriptFactory.eINSTANCE.createInvalidDataType();
	public static final DataType BOOLEAN_TYPE = MscriptFactory.eINSTANCE.createBooleanType();
	public static final DataType STRING_TYPE = MscriptFactory.eINSTANCE.createStringType();
	public static final DataType UNIT_TYPE = MscriptFactory.eINSTANCE.createUnitType();
	
	public static RealType createRealType() {
		return createRealType(createUnit());
	}
	
	public static RealType createRealType(String... symbols) {
		return createRealType(createUnit(symbols));
	}

	public static RealType createRealType(Unit unit) {
		RealType realType = MscriptFactory.eINSTANCE.createRealType();
		realType.setUnit(unit);
		return realType;
	}

	public static IntegerType createIntegerType() {
		return createIntegerType(createUnit());
	}
	
	public static IntegerType createIntegerType(String... symbols) {
		return createIntegerType(createUnit(symbols));
	}

	public static IntegerType createIntegerType(Unit unit) {
		IntegerType integerType = MscriptFactory.eINSTANCE.createIntegerType();
		integerType.setUnit(unit);
		return integerType;
	}

	public static int getArraySize(ArrayType arrayType) {
		return getArrayRowSize(arrayType);
	}
	
	public static int getArrayRowSize(ArrayType arrayType) {
		if (arrayType.getDimensions().isEmpty()) {
			throw new IllegalArgumentException();
		}
		return getArrayDimensionSize(arrayType.getDimensions().get(0));
	}
	
	public static int getArrayColumnSize(ArrayType arrayType) {
		if (arrayType.getDimensions().size() < 2) {
			throw new IllegalArgumentException();
		}
		return getArrayDimensionSize(arrayType.getDimensions().get(1));
	}
	
	public static int getArrayDimensionSize(ArrayDimension arrayDimension) {
		Expression sizeExpression = arrayDimension.getSize();
		if (sizeExpression == null) {
			return -1;
		}
		if (sizeExpression instanceof IntegerLiteral) {
			return (int) ((IntegerLiteral) sizeExpression).getValue();
		}
		throw new IllegalArgumentException();
	}
	
	public static ArrayType createArrayType(DataType elementType, int... sizes) {
		ArrayType arrayType = doCreateArrayType(elementType);
		initializeArrayDimensions(arrayType, sizes);
		return arrayType;
	}
	
	private static ArrayType doCreateArrayType(DataType elementType) {
		ArrayType arrayType;
		if (elementType instanceof NumericType) {
			arrayType = MscriptFactory.eINSTANCE.createTensorType();
		} else {
			arrayType = MscriptFactory.eINSTANCE.createArrayType();
		}
		if (elementType.eContainer() != null) {
			arrayType.setElementType(elementType);
		} else {
			arrayType.setDefinedElementType(elementType);
		}
		return arrayType;
	}
	
	private static void initializeArrayDimensions(ArrayType arrayType, int... sizes) {
		for (int size : sizes) {
			ArrayDimension dimension = MscriptFactory.eINSTANCE.createArrayDimension();
			IntegerLiteral sizeExpression = MscriptFactory.eINSTANCE.createIntegerLiteral();
			sizeExpression.setUnit(TypeUtil.createUnit());
			sizeExpression.setValue(size);
			dimension.setSize(sizeExpression);
			arrayType.getDimensions().add(dimension);
		}
	}

	@SuppressWarnings("unchecked")
	public static boolean equalArrayDimensions(ArrayType arrayType1, ArrayType arrayType2) {
		return new EqualityHelper().equals(
				(List<EObject>) (List<?>) arrayType1.getDimensions(),
				(List<EObject>) (List<?>) arrayType2.getDimensions());
	}
	
	public static Unit evaluateUnit(Unit unit, OperatorKind operator, Unit other) {
		if (unit == null) {
			return EcoreUtil.copy(other);
		}
		if (unit.getNumerator() == null) {
			MscriptFactory.eINSTANCE.createInvalidDataType();
		}
		return unit.evaluate(operator, other);
	}

	public static Unit evaluateUnit(Unit unit, OperatorKind operator, int n) {
		if (unit.getNumerator() == null) {
			MscriptFactory.eINSTANCE.createInvalidDataType();
		}
		return unit.evaluate(operator, n);
	}

	public static Unit createUnit() {
		return createUnit(0);
	}

	public static Unit createUnit(String... symbols) {
		return createUnit(0, symbols);
	}
	
	public static Unit createUnit(int scale) {
		Unit unit = MscriptFactory.eINSTANCE.createUnit();
		unit.setNumerator(MscriptFactory.eINSTANCE.createUnitNumerator());
		unit.setScale(scale);
		return unit;
	}
	
	public static Unit createUnit(int scale, String... symbols) {
		Unit unit = createUnit(scale);
		for (String symbol : symbols) {
			UnitFactor factor = unit.getNumerator().getFactor(symbol);
			if (factor != null) {
				factor.setExponent(factor.getExponent() + 1);
			} else {
				factor = MscriptFactory.eINSTANCE.createUnitFactor();
				factor.setSymbol(symbol);
				unit.getNumerator().getFactors().add(factor);
			}
		}
		return unit;
	}
		
	public static DataType getLeftHandDataType(DataType dataType1, DataType dataType2) {
		if (dataType1.isAssignableFrom(dataType2)) {
			return dataType1;
		} else if (dataType2.isAssignableFrom(dataType1)) {
			return dataType2;
		}
		return null;
	}
	
	public static boolean isVector(DataType dataType) {
		if (dataType instanceof TensorType) {
			TensorType tensorType = (TensorType) dataType;
			return tensorType.isVector();
		}
		return false;
	}
	
}
