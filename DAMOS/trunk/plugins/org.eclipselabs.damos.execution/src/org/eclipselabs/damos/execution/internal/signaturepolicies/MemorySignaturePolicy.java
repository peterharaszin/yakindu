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
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.MemoryInitialCondition;
import org.eclipselabs.damos.dml.MemoryInput;
import org.eclipselabs.damos.execution.datatype.AbstractComponentSignaturePolicy;
import org.eclipselabs.damos.execution.datatype.ComponentSignature;
import org.eclipselabs.damos.execution.datatype.ComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.datatype.IComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.internal.ExecutionPlugin;
import org.eclipselabs.damos.mscript.DataType;

/**
 * @author Andreas Unger
 *
 */
public class MemorySignaturePolicy extends AbstractComponentSignaturePolicy {

	@Override
	public IComponentSignatureEvaluationResult evaluateSignature(Component component, Map<InputPort, DataType> incomingDataTypes) {
		DataType dataType = null;
		DataType initialConditionDataType = null;
		
		for (Input input : component.getInputs()) {
			if (input.getPorts().isEmpty()) {
				continue;
			}
			
			DataType incomingDataType = incomingDataTypes.get(input.getPorts().get(0));
			if (input instanceof MemoryInput) {
				dataType = incomingDataType;
			} else if (input instanceof MemoryInitialCondition) {
				initialConditionDataType = incomingDataType;
			}
		}
		
		if (dataType == null) {
			return new ComponentSignatureEvaluationResult();
		}
		
		IStatus status = Status.OK_STATUS;

		if (initialConditionDataType != null && !dataType.isAssignableFrom(initialConditionDataType)) {
			MultiStatus multiStatus = new MultiStatus(ExecutionPlugin.PLUGIN_ID, 0, "", null);
			multiStatus.add(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "Data type of initial condition is incompatible with input data type"));
			status = multiStatus;
		}
		
		ComponentSignature signature = new ComponentSignature(incomingDataTypes);
		signature.getOutputDataTypes().put(component.getFirstOutputPort(), dataType);
		return new ComponentSignatureEvaluationResult(signature, status);
	}

}
