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

package org.eclipselabs.damos.execution.internal.signaturepolicies;

import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.execution.datatype.AbstractComponentSignaturePolicy;
import org.eclipselabs.damos.execution.datatype.ComponentSignature;
import org.eclipselabs.damos.execution.datatype.ComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.datatype.IComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.internal.ExecutionPlugin;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class JoinSignaturePolicy extends AbstractComponentSignaturePolicy {

	@Override
	public IComponentSignatureEvaluationResult evaluateSignature(Component component, Map<InputPort, DataType> incomingDataTypes) {
		DataType dataType = null;
		
		for (InputPort inputPort : component.getInputPorts()) {
			DataType incomingDataType = incomingDataTypes.get(inputPort);
			if (incomingDataType == null) {
				continue;
			}
			if (dataType != null) {
				dataType = TypeUtil.getLeftHandDataType(dataType, incomingDataType);
				if (dataType == null) {
					MultiStatus status = new MultiStatus(ExecutionPlugin.PLUGIN_ID, 0, "", null);
					status.add(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "Incompatible input values"));
					return new ComponentSignatureEvaluationResult(status);
				}
			} else {
				dataType = incomingDataType;
			}
		}
		
		if (dataType == null) {
			return new ComponentSignatureEvaluationResult();
		}
		
		ComponentSignature signature = new ComponentSignature(incomingDataTypes);
		signature.getOutputDataTypes().put(component.getFirstOutputPort(), dataType);
		return new ComponentSignatureEvaluationResult(signature);
	}

}
