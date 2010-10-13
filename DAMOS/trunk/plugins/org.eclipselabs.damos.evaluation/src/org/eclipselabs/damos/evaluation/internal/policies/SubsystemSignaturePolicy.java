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

package org.eclipselabs.damos.evaluation.internal.policies;

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
import org.eclipselabs.damos.evaluation.ComponentEvaluationContext;
import org.eclipselabs.damos.evaluation.EvaluationPlugin;
import org.eclipselabs.damos.evaluation.IEvaluationContext;
import org.eclipselabs.damos.evaluation.componentsignature.ComponentSignature;
import org.eclipselabs.damos.evaluation.componentsignature.ComponentSignatureEvaluationResult;
import org.eclipselabs.damos.evaluation.componentsignature.IComponentSignatureEvaluationResult;
import org.eclipselabs.damos.evaluation.componentsignature.IComponentSignaturePolicy;
import org.eclipselabs.damos.evaluation.util.EvaluationUtil;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.InvalidDataType;

/**
 * @author Andreas Unger
 *
 */
public class SubsystemSignaturePolicy implements IComponentSignaturePolicy {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.componentsignature.IComponentSignaturePolicy#evaluateSignature(org.eclipselabs.damos.evaluation.IEvaluationContext, org.eclipselabs.damos.dml.Component, java.util.Map)
	 */
	public IComponentSignatureEvaluationResult evaluateSignature(Component component, Map<InputPort, DataType> incomingDataTypes) {
		IEvaluationContext context = new ComponentEvaluationContext(component);
		Subsystem subsystem = (Subsystem) component;
		
		MultiStatus status = new MultiStatus(EvaluationPlugin.PLUGIN_ID, 0, "", null);
		ComponentSignature signature = new ComponentSignature();
		
		for (Input input : subsystem.getInputs()) {
			if (input instanceof SubsystemInput) {
				Inlet inlet = ((SubsystemInput) input).getInlet();
				DataType dataType = getDataType(context, status, inlet);
				if (dataType != null) {
					if (!input.getPorts().isEmpty()) {
						DataType incomingDataType = incomingDataTypes.get(input.getPorts().get(0));
						if (incomingDataType != null && !dataType.isAssignableFrom(incomingDataType)) {
							status.add(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, getInoutletErrorMessage(inlet, "Incompatible input value")));
						}
					} else {
						status.add(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, getInoutletErrorMessage(inlet, "Missing input port")));
					}
				}
			} else {
				status.add(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, "Invalid subsystem input"));
			}
		}

		for (Output output : subsystem.getOutputs()) {
			if (output instanceof SubsystemOutput) {
				Outlet outlet = ((SubsystemOutput) output).getOutlet();
				DataType dataType = getDataType(context, status, outlet);
				if (dataType != null) {
					if (!output.getPorts().isEmpty()) {
						signature.getOutputDataTypes().put(output.getPorts().get(0), (DataType) EcoreUtil.copy(dataType));
					} else {
						status.add(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, getInoutletErrorMessage(outlet, "Missing output port")));
					}
				}
			} else {
				status.add(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, "Invalid subsystem output"));
			}
		}

		return new ComponentSignatureEvaluationResult(signature, status);
	}
	
	private DataType getDataType(IEvaluationContext context, MultiStatus status, Inoutlet inoutlet) {
		if (inoutlet != null && inoutlet.getDataType() instanceof OpaqueDataTypeSpecification) {
			OpaqueDataTypeSpecification dataTypeSpecification = (OpaqueDataTypeSpecification) inoutlet.getDataType();
			if (dataTypeSpecification.getDataType() != null && dataTypeSpecification.getDataType().trim().length() > 0) {
				try {
					DataType dataType = EvaluationUtil.evaluateDataTypeSpecifierDataType(context, dataTypeSpecification.getDataType());
					if (!(dataType instanceof InvalidDataType)) {
						return dataType;
					} else {
						status.add(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, getInoutletErrorMessage(inoutlet, "Invalid data type specified")));
					}
				} catch (CoreException e) {
					status.add(new MultiStatus(
							EvaluationPlugin.PLUGIN_ID,
							0,
							new IStatus[] { e.getStatus() },
							"Data type evaluation for inlet '" + inoutlet.getName() + "' failed",
							null));
				}
			} else {
				status.add(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, getInoutletErrorMessage(inoutlet, "No data type specified")));
			}
		} else {
			status.add(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, "Invalid model"));
		}
		return null;
	}
	
	private String getInoutletErrorMessage(Inoutlet inoutlet, String message) {
		return "Subsystem " + (inoutlet instanceof Inlet ? "input" : "output") + " '" + inoutlet.getName() + "': " + message;
	}

}
