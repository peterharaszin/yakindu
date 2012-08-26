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

package org.eclipselabs.damos.mscript.internal.functionmodel.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipselabs.damos.mscript.functionmodel.EquationDescription;
import org.eclipselabs.damos.mscript.functionmodel.EquationPart;
import org.eclipselabs.damos.mscript.functionmodel.VariableStep;

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
	
	public static boolean isDefinedBy(EquationDescription equationDescription, EquationDescription otherEquationDescriptor) {
		return isDefinedBy(equationDescription, otherEquationDescriptor, new HashSet<EquationDescription>());
	}

	private static boolean isDefinedBy(EquationDescription equationDescription, EquationDescription otherEquationDescriptor, Set<EquationDescription> visitedEquationDescriptors) {
		if (!visitedEquationDescriptors.add(equationDescription)) {
			return false;
		}
		for (EquationPart equationPart : equationDescription.getRightHandSide().getParts()) {
			EquationDescription definingEquationDescriptor = getDefiningEquation(equationPart.getVariableStep());
			if (definingEquationDescriptor == otherEquationDescriptor) {
				return true;
			}
			if (definingEquationDescriptor != null && isDefinedBy(definingEquationDescriptor, otherEquationDescriptor, new HashSet<EquationDescription>(visitedEquationDescriptors))) {
				return true;
			}
		}
		return false;
	}

}
