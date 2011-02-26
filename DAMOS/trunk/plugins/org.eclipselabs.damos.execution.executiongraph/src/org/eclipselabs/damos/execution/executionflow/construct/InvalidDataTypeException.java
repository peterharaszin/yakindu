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

package org.eclipselabs.damos.execution.executionflow.construct;

import java.util.Collections;
import java.util.List;

import org.eclipselabs.damos.execution.executionflow.Node;

/**
 * @author Andreas Unger
 *
 */
public class InvalidDataTypeException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private List<Node> invalidNodes = Collections.emptyList();
	
	/**
	 * 
	 */
	public InvalidDataTypeException() {
	}
	
	public InvalidDataTypeException(String message) {
		super(message);
	}
	
	/**
	 * 
	 */
	public InvalidDataTypeException(List<Node> invalidNodes) {
		this.invalidNodes = invalidNodes;
	}
	
	/**
	 * @return the backlog
	 */
	public List<Node> getInvalidNodes() {
		return invalidNodes;
	}

}
