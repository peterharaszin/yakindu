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

package org.eclipse.damos.execution.internal.signaturepolicies;

import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.InputPort;
import org.eclipse.damos.execution.datatype.AbstractComponentSignaturePolicy;
import org.eclipse.damos.execution.datatype.ComponentSignature;
import org.eclipse.damos.execution.datatype.ComponentSignatureEvaluationResult;
import org.eclipse.damos.execution.datatype.IComponentSignatureEvaluationResult;
import org.eclipse.damos.execution.internal.ExecutionPlugin;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class JoinSignaturePolicy extends AbstractComponentSignaturePolicy {

	@Override
	public IComponentSignatureEvaluationResult evaluateSignature(Component component, Map<InputPort, Type> incomingDataTypes) {
		Type type = null;
		
		for (InputPort inputPort : component.getInputPorts()) {
			Type incomingDataType = incomingDataTypes.get(inputPort);
			if (incomingDataType == null) {
				continue;
			}
			if (type != null) {
				type = TypeUtil.getLeftHandDataType(type, incomingDataType);
				if (type == null) {
					MultiStatus status = new MultiStatus(ExecutionPlugin.PLUGIN_ID, 0, "", null);
					status.add(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "Incompatible input values"));
					return new ComponentSignatureEvaluationResult(status);
				}
			} else {
				type = incomingDataType;
			}
		}
		
		if (type == null) {
			return new ComponentSignatureEvaluationResult();
		}
		
		ComponentSignature signature = new ComponentSignature(incomingDataTypes);
		signature.getOutputDataTypes().put(component.getFirstOutputPort(), type);
		return new ComponentSignatureEvaluationResult(signature);
	}

}
