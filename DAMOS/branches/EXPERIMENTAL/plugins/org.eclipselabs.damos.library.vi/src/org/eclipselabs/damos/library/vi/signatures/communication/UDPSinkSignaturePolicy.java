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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.execution.datatype.ComponentSignature;
import org.eclipselabs.damos.execution.datatype.ComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.datatype.IComponentSignatureEvaluationResult;
import org.eclipselabs.damos.library.vi.LibraryVIPlugin;
import org.eclipselabs.damos.library.vi.util.communication.UDPSourceConstants;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.NumericType;

/**
 * @author Andreas Unger
 *
 */
public class UDPSinkSignaturePolicy extends UDPSignaturePolicy {
	
	@Override
	public IComponentSignatureEvaluationResult evaluateSignature(Component component, Map<InputPort, DataType> incomingDataTypes) {
		Block block = (Block) component;
		
		MultiStatus multiStatus = new MultiStatus(LibraryVIPlugin.PLUGIN_ID, 0, "", null);
		
		String host = block.getArgumentStringValue(UDPSourceConstants.PARAMETER__HOST);
		if (host == null || host.trim().length() == 0) {
			multiStatus.add(new Status(IStatus.ERROR, LibraryVIPlugin.PLUGIN_ID, "No host specified"));
		}
		checkNetworkPortParameter(block, multiStatus);
		
		for (DataType incomingDataType : incomingDataTypes.values()) {
			if (!(incomingDataType instanceof NumericType)) {
				multiStatus.add(new Status(IStatus.ERROR, LibraryVIPlugin.PLUGIN_ID, "Input values must be numeric"));
				break;
			}
		}
		
		ComponentSignature signature = new ComponentSignature(incomingDataTypes);
		return new ComponentSignatureEvaluationResult(signature, multiStatus);
	}

}
