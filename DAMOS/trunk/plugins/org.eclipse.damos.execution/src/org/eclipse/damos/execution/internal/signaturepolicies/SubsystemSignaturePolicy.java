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

package org.eclipse.damos.execution.internal.signaturepolicies;

import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.Inlet;
import org.eclipse.damos.dml.Inoutlet;
import org.eclipse.damos.dml.Input;
import org.eclipse.damos.dml.InputPort;
import org.eclipse.damos.dml.Outlet;
import org.eclipse.damos.dml.Output;
import org.eclipse.damos.dml.Subsystem;
import org.eclipse.damos.dml.SubsystemInput;
import org.eclipse.damos.dml.SubsystemOutput;
import org.eclipse.damos.dscript.DscriptDataTypeSpecification;
import org.eclipse.damos.execution.datatype.AbstractComponentSignaturePolicy;
import org.eclipse.damos.execution.datatype.ComponentSignature;
import org.eclipse.damos.execution.datatype.ComponentSignatureEvaluationResult;
import org.eclipse.damos.execution.datatype.IComponentSignatureEvaluationResult;
import org.eclipse.damos.execution.internal.ExecutionPlugin;
import org.eclipse.damos.mscript.Type;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Andreas Unger
 *
 */
public class SubsystemSignaturePolicy extends AbstractComponentSignaturePolicy {

	@Override
	public IComponentSignatureEvaluationResult evaluateSignature(Component component, Map<InputPort, Type> incomingDataTypes) {
		Subsystem subsystem = (Subsystem) component;
		
		MultiStatus status = new MultiStatus(ExecutionPlugin.PLUGIN_ID, 0, "", null);
		ComponentSignature signature = new ComponentSignature(incomingDataTypes);
		
		for (Input input : subsystem.getInputs()) {
			if (input instanceof SubsystemInput) {
				Inlet inlet = ((SubsystemInput) input).getInlet();
				Type type = getDataType(status, inlet);
				if (type != null) {
					if (!input.getPorts().isEmpty()) {
						Type incomingDataType = incomingDataTypes.get(input.getPorts().get(0));
						if (incomingDataType != null && !type.isAssignableFrom(incomingDataType)) {
							status.add(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, getInoutletErrorMessage(inlet, "Incompatible input value")));
						}
					} else {
						status.add(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, getInoutletErrorMessage(inlet, "Missing input port")));
					}
				}
			} else {
				status.add(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "Invalid subsystem input"));
			}
		}

		for (Output output : subsystem.getOutputs()) {
			if (output instanceof SubsystemOutput) {
				Outlet outlet = ((SubsystemOutput) output).getOutlet();
				Type type = getDataType(status, outlet);
				if (type != null) {
					if (!output.getPorts().isEmpty()) {
						signature.getOutputDataTypes().put(output.getPorts().get(0), EcoreUtil.copy(type));
					} else {
						status.add(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, getInoutletErrorMessage(outlet, "Missing output port")));
					}
				}
			} else {
				status.add(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "Invalid subsystem output"));
			}
		}

		if (status.getSeverity() > IStatus.WARNING) {
			return new ComponentSignatureEvaluationResult(status);
		}
		return new ComponentSignatureEvaluationResult(signature, status);
	}
	
	private Type getDataType(MultiStatus status, Inoutlet inoutlet) {
		if (inoutlet != null && inoutlet.getDataType() instanceof DscriptDataTypeSpecification) {
			return ((DscriptDataTypeSpecification) inoutlet.getDataType()).getType();
		} else {
			status.add(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "Invalid model"));
		}
		return null;
	}
	
	private String getInoutletErrorMessage(Inoutlet inoutlet, String message) {
		return "Subsystem " + (inoutlet instanceof Inlet ? "input" : "output") + " '" + inoutlet.getName() + "': " + message;
	}

}
