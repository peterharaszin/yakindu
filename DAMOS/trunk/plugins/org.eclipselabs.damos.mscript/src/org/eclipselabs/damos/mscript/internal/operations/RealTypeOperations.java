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

import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.Type;

public class RealTypeOperations extends PrimitiveTypeOperations {
	
	private static final NumericTypeEvaluator NUMERIC_TYPE_EVALUATOR = new NumericTypeEvaluator() {
		
		protected NumericType createResultType(OperatorKind operator, NumericType otherNumericType) {
			return MscriptFactory.eINSTANCE.createRealType();
		}
		
	};

	public static Type evaluate(RealType realType, OperatorKind operator, Type other) {
		return NUMERIC_TYPE_EVALUATOR.evaluate(realType, operator, other);
	}

	public static Type evaluate(RealType realType, OperatorKind operator, int n) {
		RealType result = MscriptFactory.eINSTANCE.createRealType();
		result.setUnit(realType.getUnit().evaluate(operator, n));
		return result;
	}

	public static boolean isAssignableFrom(RealType realType, Type other) {
		if (other instanceof NumericType) {
			NumericType otherNumericType = (NumericType) other;
			return realType.getUnit().isWildcard() || realType.getUnit().isEquivalentTo(otherNumericType.getUnit(), false);
		}
		return false;
	}

}