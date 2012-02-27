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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Inlet;
import org.eclipselabs.damos.dml.Inoutlet;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.Outlet;
import org.eclipselabs.damos.dml.Output;
import org.eclipselabs.damos.dml.Subsystem;
import org.eclipselabs.damos.dml.SubsystemInput;
import org.eclipselabs.damos.dml.SubsystemOutput;
import org.eclipselabs.damos.dmltext.MscriptDataTypeSpecification;
import org.eclipselabs.damos.execution.AbstractComponentSignaturePolicy;
import org.eclipselabs.damos.execution.ComponentSignature;
import org.eclipselabs.damos.execution.ComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.ExecutionCorePlugin;
import org.eclipselabs.damos.execution.IComponentSignatureEvaluationResult;
import org.eclipselabs.damos.mscript.DataType;

/**
 * @author Andreas Unger
 *
 */
public class SubsystemSignaturePolicy extends AbstractComponentSignaturePolicy {

	@Override
	public IComponentSignatureEvaluationResult evaluateSignature(Component component, Map<InputPort, DataType> incomingDataTypes) {
		Subsystem subsystem = (Subsystem) component;
		
		MultiStatus status = new MultiStatus(ExecutionCorePlugin.PLUGIN_ID, 0, "", null);
		ComponentSignature signature = new ComponentSignature(incomingDataTypes);
		
		for (Input input : subsystem.getInputs()) {
			if (input instanceof SubsystemInput) {
				Inlet inlet = ((SubsystemInput) input).getInlet();
				DataType dataType = getDataType(status, inlet);
				if (dataType != null) {
					if (!input.getPorts().isEmpty()) {
						DataType incomingDataType = incomingDataTypes.get(input.getPorts().get(0));
						if (incomingDataType != null && !dataType.isAssignableFrom(incomingDataType)) {
							status.add(new Status(IStatus.ERROR, ExecutionCorePlugin.PLUGIN_ID, getInoutletErrorMessage(inlet, "Incompatible input value")));
						}
					} else {
						status.add(new Status(IStatus.ERROR, ExecutionCorePlugin.PLUGIN_ID, getInoutletErrorMessage(inlet, "Missing input port")));
					}
				}
			} else {
				status.add(new Status(IStatus.ERROR, ExecutionCorePlugin.PLUGIN_ID, "Invalid subsystem input"));
			}
		}

		for (Output output : subsystem.getOutputs()) {
			if (output instanceof SubsystemOutput) {
				Outlet outlet = ((SubsystemOutput) output).getOutlet();
				DataType dataType = getDataType(status, outlet);
				if (dataType != null) {
					if (!output.getPorts().isEmpty()) {
						signature.getOutputDataTypes().put(output.getPorts().get(0), EcoreUtil.copy(dataType));
					} else {
						status.add(new Status(IStatus.ERROR, ExecutionCorePlugin.PLUGIN_ID, getInoutletErrorMessage(outlet, "Missing output port")));
					}
				}
			} else {
				status.add(new Status(IStatus.ERROR, ExecutionCorePlugin.PLUGIN_ID, "Invalid subsystem output"));
			}
		}

		if (status.getSeverity() > IStatus.WARNING) {
			return new ComponentSignatureEvaluationResult(status);
		}
		return new ComponentSignatureEvaluationResult(signature, status);
	}
	
	private DataType getDataType(MultiStatus status, Inoutlet inoutlet) {
		if (inoutlet != null && inoutlet.getDataType() instanceof MscriptDataTypeSpecification) {
			return ((MscriptDataTypeSpecification) inoutlet.getDataType()).getType();
		} else {
			status.add(new Status(IStatus.ERROR, ExecutionCorePlugin.PLUGIN_ID, "Invalid model"));
		}
		return null;
	}
	
	private String getInoutletErrorMessage(Inoutlet inoutlet, String message) {
		return "Subsystem " + (inoutlet instanceof Inlet ? "input" : "output") + " '" + inoutlet.getName() + "': " + message;
	}

}
