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

package org.eclipselabs.damos.execution.core.internal.signaturepolicies;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Inlet;
import org.eclipselabs.damos.dml.Inoutlet;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OpaqueDataTypeSpecification;
import org.eclipselabs.damos.dml.Outlet;
import org.eclipselabs.damos.dml.Output;
import org.eclipselabs.damos.dml.Subsystem;
import org.eclipselabs.damos.dml.SubsystemInput;
import org.eclipselabs.damos.dml.SubsystemOutput;
import org.eclipselabs.damos.execution.core.AbstractComponentSignaturePolicy;
import org.eclipselabs.damos.execution.core.ComponentSignature;
import org.eclipselabs.damos.execution.core.ComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.core.ExecutionEnginePlugin;
import org.eclipselabs.damos.execution.core.IComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.core.util.DataTypeSpecifierUtil;
import org.eclipselabs.mscript.computation.core.ComputationContext;
import org.eclipselabs.mscript.language.interpreter.IInterpreterContext;
import org.eclipselabs.mscript.language.interpreter.InterpreterContext;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.InvalidDataType;

/**
 * @author Andreas Unger
 *
 */
public class SubsystemSignaturePolicy extends AbstractComponentSignaturePolicy {

	@Override
	public IComponentSignatureEvaluationResult evaluateSignature(Component component, Map<InputPort, DataType> incomingDataTypes) {
		Subsystem subsystem = (Subsystem) component;
		
		MultiStatus status = new MultiStatus(ExecutionEnginePlugin.PLUGIN_ID, 0, "", null);
		ComponentSignature signature = new ComponentSignature(incomingDataTypes);
		
		for (Input input : subsystem.getInputs()) {
			if (input instanceof SubsystemInput) {
				Inlet inlet = ((SubsystemInput) input).getInlet();
				DataType dataType = getDataType(status, inlet);
				if (dataType != null) {
					if (!input.getPorts().isEmpty()) {
						DataType incomingDataType = incomingDataTypes.get(input.getPorts().get(0));
						if (incomingDataType != null && !dataType.isAssignableFrom(incomingDataType)) {
							status.add(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, getInoutletErrorMessage(inlet, "Incompatible input value")));
						}
					} else {
						status.add(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, getInoutletErrorMessage(inlet, "Missing input port")));
					}
				}
			} else {
				status.add(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Invalid subsystem input"));
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
						status.add(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, getInoutletErrorMessage(outlet, "Missing output port")));
					}
				}
			} else {
				status.add(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Invalid subsystem output"));
			}
		}

		if (!status.isOK()) {
			return new ComponentSignatureEvaluationResult(status);
		}
		return new ComponentSignatureEvaluationResult(signature);
	}
	
	private DataType getDataType(MultiStatus status, Inoutlet inoutlet) {
		if (inoutlet != null && inoutlet.getDataType() instanceof OpaqueDataTypeSpecification) {
			OpaqueDataTypeSpecification dataTypeSpecification = (OpaqueDataTypeSpecification) inoutlet.getDataType();
			if (dataTypeSpecification.getDataType() != null && dataTypeSpecification.getDataType().trim().length() > 0) {
				try {
					IInterpreterContext context = new InterpreterContext(new ComputationContext());
					DataType dataType = DataTypeSpecifierUtil.evaluateDataTypeSpecifierDataType(context, dataTypeSpecification.getDataType());
					if (!(dataType instanceof InvalidDataType)) {
						return dataType;
					} else {
						status.add(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, getInoutletErrorMessage(inoutlet, "Invalid data type specified")));
					}
				} catch (CoreException e) {
					status.add(new MultiStatus(
							ExecutionEnginePlugin.PLUGIN_ID,
							0,
							new IStatus[] { e.getStatus() },
							"Data type evaluation for inlet '" + inoutlet.getName() + "' failed",
							null));
				}
			} else {
				status.add(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, getInoutletErrorMessage(inoutlet, "No data type specified")));
			}
		} else {
			status.add(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Invalid model"));
		}
		return null;
	}
	
	private String getInoutletErrorMessage(Inoutlet inoutlet, String message) {
		return "Subsystem " + (inoutlet instanceof Inlet ? "input" : "output") + " '" + inoutlet.getName() + "': " + message;
	}

}
