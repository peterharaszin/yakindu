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

package org.eclipselabs.damos.execution.engine.internal.signaturepolicies;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.dml.ActionLink;
import org.eclipselabs.damos.dml.Choice;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.execution.engine.AbstractComponentSignaturePolicy;
import org.eclipselabs.damos.execution.engine.ComponentSignature;
import org.eclipselabs.damos.execution.engine.ComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.engine.ExecutionEnginePlugin;
import org.eclipselabs.damos.execution.engine.IComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.engine.util.ExpressionUtil;
import org.eclipselabs.mscript.computation.engine.value.IBooleanValue;
import org.eclipselabs.mscript.computation.engine.value.IValue;
import org.eclipselabs.mscript.typesystem.DataType;

/**
 * @author Andreas Unger
 *
 */
public class ChoiceSignaturePolicy extends AbstractComponentSignaturePolicy {

	@Override
	public IComponentSignatureEvaluationResult evaluateSignature(Component component, Map<InputPort, DataType> incomingDataTypes) {
		MultiStatus status = new MultiStatus(ExecutionEnginePlugin.PLUGIN_ID, 0, "", null);

		Choice choice = (Choice) component;
		
		for (ActionLink actionLink : choice.getActionLinks()) {
			if (actionLink.getCondition() == null) {
				continue;
			}
			try {
			String condition = actionLink.getCondition().stringCondition();
			IValue incomingDataType = ExpressionUtil.evaluateExpression(condition);
				if (!(incomingDataType instanceof IBooleanValue)) {
					status.add(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Action link condition '" + condition + "' does not evaluate to boolean type"));
				}
			} catch (CoreException e) {
				status.add(e.getStatus());
			}
		}
		
		if (!status.isOK()) {
			return new ComponentSignatureEvaluationResult(status);
		}
		
		return new ComponentSignatureEvaluationResult(new ComponentSignature(incomingDataTypes));
	}

}
