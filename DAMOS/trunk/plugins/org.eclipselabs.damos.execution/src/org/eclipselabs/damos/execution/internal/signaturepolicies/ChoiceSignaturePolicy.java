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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.dml.ActionLink;
import org.eclipselabs.damos.dml.Choice;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dmltext.MscriptValueSpecification;
import org.eclipselabs.damos.execution.AbstractComponentSignaturePolicy;
import org.eclipselabs.damos.execution.ComponentSignature;
import org.eclipselabs.damos.execution.ComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.ExecutionPlugin;
import org.eclipselabs.damos.execution.IComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.util.ExpressionUtil;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.InvalidDataType;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class ChoiceSignaturePolicy extends AbstractComponentSignaturePolicy {

	@Override
	public IComponentSignatureEvaluationResult evaluateSignature(Component component, Map<InputPort, DataType> incomingDataTypes) {
		MultiStatus status = new MultiStatus(ExecutionPlugin.PLUGIN_ID, 0, "", null);

		Choice choice = (Choice) component;
		
		DataType incomingDataType = incomingDataTypes.get(choice.getFirstInputPort());
		if (incomingDataType == null) {
			return new ComponentSignatureEvaluationResult();
		}
		
		for (ActionLink actionLink : choice.getActionLinks()) {
			if (actionLink.getCondition() == null) {
				continue;
			}
			try {
				if (actionLink.getCondition() instanceof MscriptValueSpecification) {
					MscriptValueSpecification condition = (MscriptValueSpecification) actionLink.getCondition();
					IValue value = ExpressionUtil.evaluateExpression(condition.getExpression());
					if (incomingDataType.evaluate(OperatorKind.EQUAL_TO, value.getDataType()) instanceof InvalidDataType) {
						status.add(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "Action link condition '" + condition.stringValue() + "' is incompatible with choice input value"));
					}
				} else {
					status.add(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "Invalid initial value"));
				}
			} catch (CoreException e) {
				status.add(e.getStatus());
			}
		}
		
		if (status.getSeverity() > IStatus.WARNING) {
			return new ComponentSignatureEvaluationResult(status);
		}
		
		return new ComponentSignatureEvaluationResult(new ComponentSignature(incomingDataTypes));
	}

}
