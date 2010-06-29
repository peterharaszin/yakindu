/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.esmp.dsm.simulation.internal.launching;

import java.util.List;

import org.esmp.dsm.semantic.blockdiagram.Block;

/**
 * @author Andreas Unger
 *
 */
public class MissingSimulationModelException extends Exception {

	private List<Block> missingSimulationModelBlocks;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public MissingSimulationModelException() {
	}
	
	/**
	 * 
	 */
	public MissingSimulationModelException(List<Block> missingSimulationModelBlocks) {
		this.missingSimulationModelBlocks = missingSimulationModelBlocks;
	}
	
	/**
	 * @return the missingSimulationModelBlocks
	 */
	public List<Block> getMissingSimulationModelBlocks() {
		return missingSimulationModelBlocks;
	}
	
}
