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

package org.eclipselabs.damos.execution.engine;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.mscript.typesystem.DataType;

/**
 * @author Andreas Unger
 *
 */
public class ComponentSignature implements IComponentSignature {

	private Map<OutputPort, DataType> outputDataTypes = new HashMap<OutputPort,DataType>();

	public Map<OutputPort, DataType> getOutputDataTypes() {
		return outputDataTypes;
	}
	
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
		
		if (outputDataTypes.size() != other.outputDataTypes.size()) {
			return false;
		}
	
		for (Entry<OutputPort, DataType> outputDataType : outputDataTypes.entrySet()) {
			if (!EcoreUtil.equals(outputDataType.getValue(), other.outputDataTypes.get(outputDataType.getKey()))) {
				return false;
			}
		}

		return true;
	}

}
