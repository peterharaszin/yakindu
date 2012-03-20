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

package org.eclipselabs.damos.library.vi.signatures.communication;

import java.util.Map;

import org.eclipse.core.runtime.MultiStatus;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.execution.datatype.ComponentSignature;
import org.eclipselabs.damos.execution.datatype.ComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.datatype.IComponentSignatureEvaluationResult;
import org.eclipselabs.damos.library.vi.LibraryVIPlugin;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class UDPSourceSignaturePolicy extends UDPSignaturePolicy {
	
	@Override
	public IComponentSignatureEvaluationResult evaluateSignature(Component component, Map<InputPort, DataType> incomingDataTypes) {
		Block block = (Block) component;
		
		MultiStatus multiStatus = new MultiStatus(LibraryVIPlugin.PLUGIN_ID, 0, "", null);
		checkNetworkPortParameter(block, multiStatus);
		
		ComponentSignature signature = new ComponentSignature(incomingDataTypes);

		for (OutputPort outputPort : component.getOutputPorts()) {
			NumericType outputDataType;
			outputDataType = MscriptFactory.eINSTANCE.createRealType();
			outputDataType.setUnit(TypeUtil.createUnit());
			signature.getOutputDataTypes().put(outputPort, outputDataType);
		}
		
		return new ComponentSignatureEvaluationResult(signature, multiStatus);
	}

}
