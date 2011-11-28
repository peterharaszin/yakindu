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

package org.eclipselabs.damos.mscript.il.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipselabs.damos.mscript.InputParameterDeclaration;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.il.ComputationCompound;
import org.eclipselabs.damos.mscript.il.ILFunctionDefinition;

/**
 * @author Andreas Unger
 *
 */
public class ILUtil {

	public static List<InputParameterDeclaration> getDirectFeedthroughInputs(ILFunctionDefinition functionDefinition) {
		List<InputParameterDeclaration> inputs = new ArrayList<InputParameterDeclaration>();
		for (InputParameterDeclaration inputParameterDeclaration : functionDefinition.getFunctionDefinition().getInputParameterDeclarations()) {
			if (isDirectFeedthrough(functionDefinition, inputParameterDeclaration)) {
				inputs.add((InputParameterDeclaration) inputParameterDeclaration);
			}
		}
		return inputs;
	}

	public static boolean isDirectFeedthrough(ILFunctionDefinition functionDefinition, VariableDeclaration variableDeclaration) {
		for (ComputationCompound compound : getFeedingCompounds(functionDefinition, variableDeclaration)) {
			if (!compound.getOutputs().isEmpty()) {
				return true;
			}
		}
		return false;
	}

	public static List<ComputationCompound> getFeedingCompounds(ILFunctionDefinition functionDefinition, VariableDeclaration variableDeclaration) {
		if (functionDefinition == null) {
			return Collections.emptyList();
		}
		List<ComputationCompound> feedingCompounds = new ArrayList<ComputationCompound>();
		for (ComputationCompound computationCompound : functionDefinition.getComputationCompounds()) {
			if (computationCompound.getInputs().contains(variableDeclaration)) {
				feedingCompounds.add(computationCompound);
			}
		}
		return feedingCompounds;
	}

}
