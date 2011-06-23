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
import org.eclipselabs.damos.dml.Inoutport;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OpaqueDataTypeSpecification;
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
public class InoutportSignaturePolicy extends AbstractComponentSignaturePolicy {

	@Override
	public IComponentSignatureEvaluationResult evaluateSignature(Component component, Map<InputPort, DataType> incomingDataTypes) {
		Inoutport inport = (Inoutport) component;
		
		MultiStatus status = new MultiStatus(ExecutionEnginePlugin.PLUGIN_ID, 0, "", null);
		ComponentSignature signature = null;
		
		DataType dataType = getDataType(status, inport);
		if (dataType != null) {
			DataType incomingDataType = incomingDataTypes.get(component.getFirstInputPort());
			if (incomingDataType != null) {
				if (!dataType.isAssignableFrom(incomingDataType)) {
					status.add(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Incompatible input value"));
				}
			}
			signature = new ComponentSignature(incomingDataTypes);
			signature.getOutputDataTypes().put(component.getFirstOutputPort(), EcoreUtil.copy(dataType));
		}

		if (!status.isOK()) {
			return new ComponentSignatureEvaluationResult(signature, status);
		}
		return new ComponentSignatureEvaluationResult(signature);
	}

	/**
	 * @param context
	 * @param status
	 * @param inoutport
	 */
	protected DataType getDataType(MultiStatus status, Inoutport inoutport) {
		if (inoutport.getDataType() instanceof OpaqueDataTypeSpecification) {
			OpaqueDataTypeSpecification dataTypeSpecification = (OpaqueDataTypeSpecification) inoutport.getDataType();
			if (dataTypeSpecification.getDataType() != null && dataTypeSpecification.getDataType().trim().length() > 0) {
				try {
					IInterpreterContext context = new InterpreterContext(new ComputationContext());
					DataType dataType = DataTypeSpecifierUtil.evaluateDataTypeSpecifierDataType(context, dataTypeSpecification.getDataType());
					if (!(dataType instanceof InvalidDataType)) {
						return dataType;
					} else {
						status.add(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Invalid data type specified"));
					}
				} catch (CoreException e) {
					status.add(new MultiStatus(
							ExecutionEnginePlugin.PLUGIN_ID,
							0,
							new IStatus[] { e.getStatus() },
							"Data type evaluation failed",
							null));
				}
			} else {
				status.add(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "No data type specified"));
			}
		} else {
			status.add(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Invalid model"));
		}
		return null;
	}

}
