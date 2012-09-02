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
import org.eclipselabs.damos.dml.Inoutport;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dscript.DscriptDataTypeSpecification;
import org.eclipselabs.damos.execution.datatype.AbstractComponentSignaturePolicy;
import org.eclipselabs.damos.execution.datatype.ComponentSignature;
import org.eclipselabs.damos.execution.datatype.ComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.datatype.IComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.internal.ExecutionPlugin;
import org.eclipselabs.damos.mscript.Type;

/**
 * @author Andreas Unger
 *
 */
public class InoutportSignaturePolicy extends AbstractComponentSignaturePolicy {

	@Override
	public IComponentSignatureEvaluationResult evaluateSignature(Component component, Map<InputPort, Type> incomingDataTypes) {
		Inoutport inport = (Inoutport) component;
		
		MultiStatus status = new MultiStatus(ExecutionPlugin.PLUGIN_ID, 0, "", null);
		ComponentSignature signature = null;
		
		Type type = getDataType(status, inport);
		if (type != null) {
			Type incomingDataType = incomingDataTypes.get(component.getFirstInputPort());
			if (incomingDataType != null) {
				if (!type.isAssignableFrom(incomingDataType)) {
					status.add(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "Specified data type incompatible with input value data type"));
				}
			}
			signature = new ComponentSignature(incomingDataTypes);
			signature.getOutputDataTypes().put(component.getFirstOutputPort(), EcoreUtil.copy(type));
		}

		return new ComponentSignatureEvaluationResult(signature, status);
	}

	/**
	 * @param context
	 * @param status
	 * @param inoutport
	 */
	protected Type getDataType(MultiStatus status, Inoutport inoutport) {
		if (inoutport.getDataType() instanceof DscriptDataTypeSpecification) {
			return ((DscriptDataTypeSpecification) inoutport.getDataType()).getType();
		} else {
			status.add(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "Invalid model"));
		}
		return null;
	}

}
