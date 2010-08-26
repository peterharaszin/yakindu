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

package org.eclipselabs.damos.evaluation.componentsignature;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.typesystem.DataType;

/**
 * @author Andreas Unger
 *
 */
public class ComponentSignature implements IComponentSignature {

	private Map<InputPort, DataType> inputDataTypes = new HashMap<InputPort,DataType>();
	private Map<OutputPort, DataType> outputDataTypes = new HashMap<OutputPort,DataType>();

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.ComponentSignature#getInputSignature()
	 */
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.blocksignature.IBlockSignature#getInputDataTypes()
	 */
	public Map<InputPort, DataType> getInputDataTypes() {
		return inputDataTypes;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.ComponentSignature#getOutputSignature()
	 */
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.blocksignature.IBlockSignature#getOutputDataTypes()
	 */
	public Map<OutputPort, DataType> getOutputDataTypes() {
		return outputDataTypes;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.IComponentSignature#getInputDataType(org.eclipselabs.damos.dml.InputPort)
	 */
	public DataType getInputDataType(InputPort inputPort) {
		return inputDataTypes.get(inputPort);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.IComponentSignature#getOutputDataType(org.eclipselabs.damos.dml.OutputPort)
	 */
	public DataType getOutputDataType(OutputPort outputPort) {
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
	
		for (Entry<InputPort, DataType> inputDataType : inputDataTypes.entrySet()) {
			if (!EcoreUtil.equals(inputDataType.getValue(), other.inputDataTypes.get(inputDataType.getKey()))) {
				return false;
			}
		}
		
		for (Entry<OutputPort, DataType> outputDataType : outputDataTypes.entrySet()) {
			if (!EcoreUtil.equals(outputDataType.getValue(), other.outputDataTypes.get(outputDataType.getKey()))) {
				return false;
			}
		}

		return true;
	}

}
