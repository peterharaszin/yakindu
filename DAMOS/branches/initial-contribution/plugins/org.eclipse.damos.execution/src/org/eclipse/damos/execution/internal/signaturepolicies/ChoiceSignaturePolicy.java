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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.damos.dml.ActionLink;
import org.eclipse.damos.dml.Choice;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.InputPort;
import org.eclipse.damos.dscript.DscriptValueSpecification;
import org.eclipse.damos.execution.datatype.AbstractComponentSignaturePolicy;
import org.eclipse.damos.execution.datatype.ComponentSignature;
import org.eclipse.damos.execution.datatype.ComponentSignatureEvaluationResult;
import org.eclipse.damos.execution.datatype.IComponentSignatureEvaluationResult;
import org.eclipse.damos.execution.internal.ExecutionPlugin;
import org.eclipse.damos.execution.util.ExpressionUtil;
import org.eclipse.damos.mscript.InvalidType;
import org.eclipse.damos.mscript.OperatorKind;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class ChoiceSignaturePolicy extends AbstractComponentSignaturePolicy {

	@Override
	public IComponentSignatureEvaluationResult evaluateSignature(Component component, Map<InputPort, Type> incomingDataTypes) {
		MultiStatus status = new MultiStatus(ExecutionPlugin.PLUGIN_ID, 0, "", null);

		Choice choice = (Choice) component;
		
		Type incomingDataType = incomingDataTypes.get(choice.getFirstInputPort());
		if (incomingDataType == null) {
			return new ComponentSignatureEvaluationResult();
		}
		
		for (ActionLink actionLink : choice.getActionLinks()) {
			if (actionLink.getCondition() == null) {
				continue;
			}
			try {
				if (actionLink.getCondition() instanceof DscriptValueSpecification) {
					DscriptValueSpecification condition = (DscriptValueSpecification) actionLink.getCondition();
					IValue value = ExpressionUtil.evaluateExpression(condition.getExpression());
					if (incomingDataType.evaluate(OperatorKind.EQUAL_TO, value.getDataType()) instanceof InvalidType) {
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
