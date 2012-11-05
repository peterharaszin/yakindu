/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.execution.datatype;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.damos.dml.InputPort;
import org.eclipse.damos.dml.OutputPort;
import org.eclipse.damos.mscript.Type;

/**
 * @author Andreas Unger
 *
 */
public class ComponentSignature implements IComponentSignature {

	private Map<InputPort, Type> inputDataTypes;
	private Map<OutputPort, Type> outputDataTypes = new HashMap<OutputPort,Type>();

	/**
	 * 
	 */
	public ComponentSignature(Map<InputPort, Type> inputDataTypes) {
		this.inputDataTypes = inputDataTypes;
	}
	
	public Type getInputDataType(InputPort inputPort) {
		return inputDataTypes.get(inputPort);
	}
	
	public Map<OutputPort, Type> getOutputDataTypes() {
		return outputDataTypes;
	}
	
	public Type getOutputDataType(OutputPort outputPort) {
		return outputDataTypes.get(outputPort);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ComponentSignature)) {
			return false;
		}

		ComponentSignature other = (ComponentSignature) obj;
		
		if (inputDataTypes.size() != other.inputDataTypes.size()) {
			return false;
		}
	
		if (outputDataTypes.size() != other.outputDataTypes.size()) {
			return false;
		}

		for (Entry<InputPort, Type> inputDataType : inputDataTypes.entrySet()) {
			if (!inputDataType.getValue().isEquivalentTo(other.inputDataTypes.get(inputDataType.getKey()))) {
				return false;
			}
		}

		for (Entry<OutputPort, Type> outputDataType : outputDataTypes.entrySet()) {
			if (!outputDataType.getValue().isEquivalentTo(other.outputDataTypes.get(outputDataType.getKey()))) {
				return false;
			}
		}

		return true;
	}

}
