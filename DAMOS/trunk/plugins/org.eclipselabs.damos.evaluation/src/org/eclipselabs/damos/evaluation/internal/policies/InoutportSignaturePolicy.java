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
import org.eclipselabs.damos.dml.Inoutport;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OpaqueDataTypeSpecification;
import org.eclipselabs.damos.evaluation.EvaluationPlugin;
import org.eclipselabs.damos.evaluation.IEvaluationContext;
import org.eclipselabs.damos.evaluation.componentsignature.ComponentSignature;
import org.eclipselabs.damos.evaluation.componentsignature.ComponentSignatureEvaluationResult;
import org.eclipselabs.damos.evaluation.componentsignature.IComponentSignatureEvaluationResult;
import org.eclipselabs.damos.evaluation.componentsignature.IComponentSignaturePolicy;
import org.eclipselabs.damos.evaluation.util.EvaluationUtil;
import org.eclipselabs.damos.typesystem.DataType;
import org.eclipselabs.damos.typesystem.InvalidDataType;

/**
 * @author Andreas Unger
 *
 */
public class InoutportSignaturePolicy implements IComponentSignaturePolicy {

	public IComponentSignatureEvaluationResult evaluateSignature(IEvaluationContext context, Component component, Map<InputPort, DataType> incomingDataTypes) {
		Inoutport inport = (Inoutport) component;
		
		MultiStatus status = new MultiStatus(EvaluationPlugin.PLUGIN_ID, 0, "", null);
		ComponentSignature signature = new ComponentSignature();
		
		DataType dataType = getDataType(context, status, inport);
		if (dataType != null) {
			DataType incomingDataType = incomingDataTypes.get(component.getFirstInputPort());
			if (incomingDataType != null) {
				if (!dataType.isAssignableFrom(incomingDataType)) {
					status.add(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, "Incompatible input value"));
				}
			}
			if (component.getFirstInputPort() != null) {
				signature.getInputDataTypes().put(component.getFirstInputPort(), (DataType) EcoreUtil.copy(dataType));
			}
			signature.getOutputDataTypes().put(component.getFirstOutputPort(), (DataType) EcoreUtil.copy(dataType));
		}

		return new ComponentSignatureEvaluationResult(signature, status);
	}

	/**
	 * @param context
	 * @param status
	 * @param inoutport
	 */
	protected DataType getDataType(IEvaluationContext context, MultiStatus status, Inoutport inoutport) {
		if (inoutport.getDataType() instanceof OpaqueDataTypeSpecification) {
			OpaqueDataTypeSpecification dataTypeSpecification = (OpaqueDataTypeSpecification) inoutport.getDataType();
			if (dataTypeSpecification.getDataType() != null && dataTypeSpecification.getDataType().trim().length() > 0) {
				try {
					DataType dataType = EvaluationUtil.evaluateDataTypeSpecifierDataType(context, dataTypeSpecification.getDataType());
					if (!(dataType instanceof InvalidDataType)) {
						return dataType;
					} else {
						status.add(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, "Invalid data type specified"));
					}
				} catch (CoreException e) {
					status.add(new MultiStatus(
							EvaluationPlugin.PLUGIN_ID,
							0,
							new IStatus[] { e.getStatus() },
							"Data type evaluation failed",
							null));
				}
			} else {
				status.add(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, "No data type specified"));
			}
		} else {
			status.add(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, "Invalid model"));
		}
		return null;
	}

}
