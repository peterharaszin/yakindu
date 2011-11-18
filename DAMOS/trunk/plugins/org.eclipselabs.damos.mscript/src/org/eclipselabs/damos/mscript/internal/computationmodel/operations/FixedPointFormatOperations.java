/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.internal.computationmodel.operations;

import org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointOperation;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointOperationKind;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;

public class FixedPointFormatOperations {

	public static  FixedPointOperation getOperation(FixedPointFormat fixedPointFormat, FixedPointOperationKind kind) {
		for (FixedPointOperation operation : fixedPointFormat.getOperations()) {
			if (operation.getKind() == kind) {
				return operation;
			}
		}
		return null;
	}

	public static boolean isEquivalentTo(FixedPointFormat fixedPointFormat, NumberFormat other) {
		return new NumberFormatEqualityHelper().equals(fixedPointFormat, other);
	}

}
