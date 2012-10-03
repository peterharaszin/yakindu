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

package org.eclipse.damos.library.vi.signatures.communication;

import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.damos.dml.Block;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.InputPort;
import org.eclipse.damos.execution.datatype.ComponentSignature;
import org.eclipse.damos.execution.datatype.ComponentSignatureEvaluationResult;
import org.eclipse.damos.execution.datatype.IComponentSignatureEvaluationResult;
import org.eclipse.damos.library.vi.LibraryVIPlugin;
import org.eclipse.damos.library.vi.util.communication.UDPSourceConstants;
import org.eclipse.damos.mscript.NumericType;
import org.eclipse.damos.mscript.Type;

/**
 * @author Andreas Unger
 *
 */
public class UDPSinkSignaturePolicy extends UDPSignaturePolicy {
	
	@Override
	public IComponentSignatureEvaluationResult evaluateSignature(Component component, Map<InputPort, Type> incomingDataTypes) {
		Block block = (Block) component;
		
		MultiStatus multiStatus = new MultiStatus(LibraryVIPlugin.PLUGIN_ID, 0, "", null);
		
		String host = block.getArgumentStringValue(UDPSourceConstants.PARAMETER__HOST);
		if (host == null || host.trim().length() == 0) {
			multiStatus.add(new Status(IStatus.ERROR, LibraryVIPlugin.PLUGIN_ID, "No host specified"));
		}
		checkNetworkPortParameter(block, multiStatus);
		
		for (Type incomingDataType : incomingDataTypes.values()) {
			if (!(incomingDataType instanceof NumericType)) {
				multiStatus.add(new Status(IStatus.ERROR, LibraryVIPlugin.PLUGIN_ID, "Input values must be numeric"));
				break;
			}
		}
		
		ComponentSignature signature = new ComponentSignature(incomingDataTypes);
		return new ComponentSignatureEvaluationResult(signature, multiStatus);
	}

}
