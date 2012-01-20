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

package org.eclipselabs.damos.mscript.interpreter.value;

import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.FloatingPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;
import org.eclipselabs.damos.mscript.interpreter.IComputationContext;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class Values {
	
	/**
	 * 
	 */
	private Values() {
		// Hide constructor
	}

	public static ISimpleNumericValue valueOf(IComputationContext context, NumericType numericType, double value) {
		if (numericType instanceof RealType) {
			return createRealValue(context, (RealType) numericType, value);
		}
		throw new IllegalArgumentException("Data type must be real type");
	}
	
	public static ISimpleNumericValue valueOf(IComputationContext context, NumericType numericType, long value) {
		if (numericType instanceof RealType) {
			return createRealValue(context, (RealType) numericType, value);
		}
		if (numericType instanceof IntegerType) {
			return createIntegerValue(context, (IntegerType) numericType, value);
		}
		throw new IllegalArgumentException("Data type must be real type");
	}

	private static ISimpleNumericValue createRealValue(IComputationContext context, RealType realType, double value) {
		NumberFormat numberFormat = context.getComputationModel().getNumberFormat(realType);
		if (numberFormat instanceof FloatingPointFormat) {
			FloatingPointFormat floatingPointFormat = (FloatingPointFormat) numberFormat;
			switch (floatingPointFormat.getKind()) {
			case BINARY32:
				return new Binary32Value(context, realType, floatingPointFormat, (float) value);
			case BINARY64:
				return new Binary64Value(context, realType, floatingPointFormat, value);
			default:
				throw new IllegalArgumentException();
			}
		}
		if (numberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			FixedPointValue fixedPointValue = new FixedPointValue(context, realType, fixedPointFormat, 0);
			FixedPointValue.initializeValue(context, fixedPointValue, value);
			return fixedPointValue;
		}
		throw new IllegalArgumentException();
	}
	
	private static ISimpleNumericValue createIntegerValue(IComputationContext context, IntegerType integerType, long value) {
		NumberFormat numberFormat = context.getComputationModel().getNumberFormat(integerType);
		if (numberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			FixedPointValue integerValue = new FixedPointValue(context, integerType, fixedPointFormat, 0);
			FixedPointValue.initializeValue(context, integerValue, value);
			return integerValue;
		}
		throw new IllegalArgumentException();
	}
	
	public static IBooleanValue valueOf(IComputationContext context, boolean value) {
		return new BooleanValue(context, value);
	}
	
	public static IValue transform(IComputationContext context, IValue value) {
		if (value instanceof ISimpleNumericValue) {
			ISimpleNumericValue numericValue = (ISimpleNumericValue) value;
			if (numericValue.getDataType() instanceof RealType) {
				return Values.valueOf(context, (RealType) value.getDataType(), numericValue.doubleValue());
			}
			if (numericValue.getDataType() instanceof IntegerType) {
				return Values.valueOf(context, (IntegerType) value.getDataType(), numericValue.longValue());
			}
		}
		if (value instanceof VectorValue) {
			VectorValue vectorValue = (VectorValue) value;
			
			INumericValue[] elements = new INumericValue[TypeUtil.getArrayRowSize(vectorValue.getDataType())];
			
			for (int i = 0; i < elements.length; ++i) {
				elements[i] = (INumericValue) transform(context, vectorValue.get(i));
			}
			
			return new VectorValue(context, vectorValue.getDataType(), elements);
		}
		return value;
	}

}
