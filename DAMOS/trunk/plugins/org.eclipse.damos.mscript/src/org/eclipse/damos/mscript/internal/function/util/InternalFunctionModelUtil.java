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

package org.eclipse.damos.mscript.internal.function.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.damos.mscript.function.EquationDescription;
import org.eclipse.damos.mscript.function.EquationPart;
import org.eclipse.damos.mscript.function.VariableStep;

/**
 * @author Andreas Unger
 *
 */
public class InternalFunctionModelUtil {

	public static EquationPart getFirstLeftHandSideEquationPart(EquationDescription equationDescription) {
		List<EquationPart> lhsEquationParts = equationDescription.getLeftHandSide().getParts();
		return !lhsEquationParts.isEmpty() ? lhsEquationParts.get(0) : null;
	}
	
	public static VariableStep getFirstLeftHandSideVariableStep(EquationDescription equationDescription) {
		EquationPart lhsEquationPart = getFirstLeftHandSideEquationPart(equationDescription);
		return lhsEquationPart != null ? lhsEquationPart.getVariableStep() : null;
	}

	public static EquationDescription getDefiningEquation(VariableStep variableStep) {
		for (EquationPart equationPart : variableStep.getUsingEquationParts()) {
			EquationDescription equationDescription = equationPart.getSide().getEquationDescription();
			if (equationPart.getSide() == equationDescription.getLeftHandSide()) {
				return equationDescription;
			}
		}
		return null;
	}
	
	public static boolean isDefinedBy(EquationDescription equationDescription, EquationDescription otherEquationDescription) {
		return isDefinedBy(equationDescription, otherEquationDescription, new HashSet<EquationDescription>());
	}

	private static boolean isDefinedBy(EquationDescription equationDescription, EquationDescription otherEquationDescription, Set<EquationDescription> visitedEquationDescriptions) {
		if (!visitedEquationDescriptions.add(equationDescription)) {
			return false;
		}
		for (EquationPart equationPart : equationDescription.getRightHandSide().getParts()) {
			EquationDescription definingEquationDescription = getDefiningEquation(equationPart.getVariableStep());
			if (definingEquationDescription == otherEquationDescription) {
				return true;
			}
			if (definingEquationDescription != null && isDefinedBy(definingEquationDescription, otherEquationDescription, new HashSet<EquationDescription>(visitedEquationDescriptions))) {
				return true;
			}
		}
		return false;
	}

}
