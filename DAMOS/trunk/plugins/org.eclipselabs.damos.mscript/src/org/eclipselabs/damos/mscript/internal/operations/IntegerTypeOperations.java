/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.mscript.internal.operations;

import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.StringType;
import org.eclipselabs.damos.mscript.Type;

public class IntegerTypeOperations extends PrimitiveTypeOperations {

	private static final NumericTypeEvaluator NUMERIC_TYPE_EVALUATOR = new NumericTypeEvaluator() {
		
		public Type evaluate(NumericType numericType, OperatorKind operator, Type other) {
			if (operator == OperatorKind.ADD && other instanceof StringType) {
				return MscriptFactory.eINSTANCE.createStringType();
			}
			return super.evaluate(numericType, operator, other);
		}
		
		protected NumericType createResultType(OperatorKind operator, NumericType otherNumericType) {
			NumericType result;
			if (otherNumericType instanceof IntegerType && operator != OperatorKind.DIVIDE && operator != OperatorKind.ELEMENT_WISE_DIVIDE) {
				result = MscriptFactory.eINSTANCE.createIntegerType();
			} else {
				result = MscriptFactory.eINSTANCE.createRealType();
			}
			return result;
		}
		
	};

	public static Type evaluate(IntegerType integerType, OperatorKind operator, Type other) {
		return NUMERIC_TYPE_EVALUATOR.evaluate(integerType, operator, other);
	}

	public static Type evaluate(IntegerType integerType, OperatorKind operator, int n) {
		RealType result = MscriptFactory.eINSTANCE.createRealType();
		result.setUnit(integerType.getUnit().evaluate(operator, n));
		return result;
	}

	public static boolean isAssignableFrom(IntegerType integerType, Type other) {
		if (other instanceof IntegerType) {
			IntegerType otherIntegerType = (IntegerType) other;
			return integerType.getUnit().isWildcard() || integerType.getUnit().isEquivalentTo(otherIntegerType.getUnit(), false);
		}
		return false;
	}

}