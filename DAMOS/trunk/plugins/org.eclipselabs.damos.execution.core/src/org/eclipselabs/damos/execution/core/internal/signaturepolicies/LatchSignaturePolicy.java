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
import org.eclipselabs.damos.dml.ExpressionSpecification;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.Latch;
import org.eclipselabs.damos.execution.core.AbstractComponentSignaturePolicy;
import org.eclipselabs.damos.execution.core.ComponentSignature;
import org.eclipselabs.damos.execution.core.ComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.core.ExecutionEnginePlugin;
import org.eclipselabs.damos.execution.core.IComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.core.util.ExpressionUtil;
import org.eclipselabs.mscript.computation.core.value.IValue;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.InvalidDataType;

/**
 * @author Andreas Unger
 *
 */
public class LatchSignaturePolicy extends AbstractComponentSignaturePolicy {

	@Override
	public IComponentSignatureEvaluationResult evaluateSignature(Component component, Map<InputPort, DataType> incomingDataTypes) {
		Latch latch = (Latch) component;
		
		MultiStatus status = new MultiStatus(ExecutionEnginePlugin.PLUGIN_ID, 0, "", null);
		ComponentSignature signature = null;
		
		DataType dataType = getDataType(status, latch);
		if (dataType != null) {
			DataType incomingDataType = incomingDataTypes.get(component.getFirstInputPort());
			if (incomingDataType != null) {
				if (!incomingDataType.isAssignableFrom(dataType)) {
					status.add(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Initial value data type incompatible with input value data type"));
				}
				signature = new ComponentSignature(incomingDataTypes);
				signature.getOutputDataTypes().put(component.getFirstOutputPort(), EcoreUtil.copy(incomingDataType));
			}
		}

		if (status.getSeverity() > IStatus.WARNING) {
			return new ComponentSignatureEvaluationResult(signature, status);
		}
		return new ComponentSignatureEvaluationResult(signature, status);
	}

	protected DataType getDataType(MultiStatus status, Latch latch) {
		if (latch.getInitialValue() instanceof ExpressionSpecification) {
			ExpressionSpecification expressionSpecification = (ExpressionSpecification) latch.getInitialValue();
			if (expressionSpecification.getExpression() != null && expressionSpecification.getExpression().trim().length() > 0) {
				try {
					IValue value = ExpressionUtil.evaluateExpression(expressionSpecification.getExpression());
					if (!(value.getDataType() instanceof InvalidDataType)) {
						return value.getDataType();
					} else {
						status.add(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Invalid initial value specified"));
					}
				} catch (CoreException e) {
					status.add(new MultiStatus(
							ExecutionEnginePlugin.PLUGIN_ID,
							0,
							new IStatus[] { e.getStatus() },
							"Initial value evaluation failed",
							null));
				}
			} else {
				status.add(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "No Initial Value specified"));
			}
		} else {
			status.add(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Invalid model"));
		}
		return null;
	}

}
