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

package org.eclipselabs.damos.mscript.functionmodel.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipselabs.damos.mscript.InputParameterDeclaration;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.functionmodel.ComputationCompound;
import org.eclipselabs.damos.mscript.functionmodel.FunctionInstance;

/**
 * @author Andreas Unger
 *
 */
public class FunctionModelUtil {

	public static List<InputParameterDeclaration> getDirectFeedthroughInputs(FunctionInstance functionInstance) {
		List<InputParameterDeclaration> inputs = new ArrayList<InputParameterDeclaration>();
		for (InputParameterDeclaration inputParameterDeclaration : functionInstance.getFunctionDeclaration().getInputParameterDeclarations()) {
			if (isDirectFeedthrough(functionInstance, inputParameterDeclaration)) {
				inputs.add((InputParameterDeclaration) inputParameterDeclaration);
			}
		}
		return inputs;
	}

	public static boolean isDirectFeedthrough(FunctionInstance functionInstance, VariableDeclaration variableDeclaration) {
		for (ComputationCompound compound : getFeedingCompounds(functionInstance, variableDeclaration)) {
			if (!compound.getOutputs().isEmpty()) {
				return true;
			}
		}
		return false;
	}

	public static List<ComputationCompound> getFeedingCompounds(FunctionInstance functionInstance, VariableDeclaration variableDeclaration) {
		if (functionInstance == null) {
			return Collections.emptyList();
		}
		List<ComputationCompound> feedingCompounds = new ArrayList<ComputationCompound>();
		for (ComputationCompound computationCompound : functionInstance.getComputationCompounds()) {
			if (computationCompound.getInputs().contains(variableDeclaration)) {
				feedingCompounds.add(computationCompound);
			}
		}
		return feedingCompounds;
	}

}
