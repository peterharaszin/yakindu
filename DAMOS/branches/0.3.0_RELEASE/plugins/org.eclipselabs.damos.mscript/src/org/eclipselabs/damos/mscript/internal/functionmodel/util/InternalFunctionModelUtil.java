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

import org.eclipselabs.damos.mscript.functionmodel.EquationDescriptor;
import org.eclipselabs.damos.mscript.functionmodel.EquationPart;
import org.eclipselabs.damos.mscript.functionmodel.VariableStep;

/**
 * @author Andreas Unger
 *
 */
public class InternalFunctionModelUtil {

	public static EquationPart getFirstLeftHandSideEquationPart(EquationDescriptor equationDescriptor) {
		List<EquationPart> lhsEquationParts = equationDescriptor.getLeftHandSide().getParts();
		return !lhsEquationParts.isEmpty() ? lhsEquationParts.get(0) : null;
	}
	
	public static VariableStep getFirstLeftHandSideVariableStep(EquationDescriptor equationDescriptor) {
		EquationPart lhsEquationPart = getFirstLeftHandSideEquationPart(equationDescriptor);
		return lhsEquationPart != null ? lhsEquationPart.getVariableStep() : null;
	}

	public static EquationDescriptor getDefiningEquation(VariableStep variableStep) {
		for (EquationPart equationPart : variableStep.getUsingEquationParts()) {
			EquationDescriptor equationDescriptor = equationPart.getSide().getDescriptor();
			if (equationPart.getSide() == equationDescriptor.getLeftHandSide()) {
				return equationDescriptor;
			}
		}
		return null;
	}
	
	public static boolean isDefinedBy(EquationDescriptor equationDescriptor, EquationDescriptor otherEquationDescriptor) {
		return isDefinedBy(equationDescriptor, otherEquationDescriptor, new HashSet<EquationDescriptor>());
	}

	private static boolean isDefinedBy(EquationDescriptor equationDescriptor, EquationDescriptor otherEquationDescriptor, Set<EquationDescriptor> visitedEquationDescriptors) {
		if (!visitedEquationDescriptors.add(equationDescriptor)) {
			return false;
		}
		for (EquationPart equationPart : equationDescriptor.getRightHandSide().getParts()) {
			EquationDescriptor definingEquationDescriptor = getDefiningEquation(equationPart.getVariableStep());
			if (definingEquationDescriptor == otherEquationDescriptor) {
				return true;
			}
			if (definingEquationDescriptor != null && isDefinedBy(definingEquationDescriptor, otherEquationDescriptor, new HashSet<EquationDescriptor>(visitedEquationDescriptors))) {
				return true;
			}
		}
		return false;
	}

}
