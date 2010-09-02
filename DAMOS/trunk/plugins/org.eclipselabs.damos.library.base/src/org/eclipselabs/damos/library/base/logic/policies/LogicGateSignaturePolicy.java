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

package org.eclipselabs.damos.library.base.logic.policies;

import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.evaluation.IEvaluationContext;
import org.eclipselabs.damos.evaluation.componentsignature.ComponentSignatureEvaluationResult;
import org.eclipselabs.damos.evaluation.componentsignature.IComponentSignature;
import org.eclipselabs.damos.evaluation.componentsignature.IComponentSignatureEvaluationResult;
import org.eclipselabs.damos.evaluation.componentsignature.IComponentSignaturePolicy;
import org.eclipselabs.damos.library.base.LibraryBasePlugin;
import org.eclipselabs.damos.typesystem.BooleanType;
import org.eclipselabs.damos.typesystem.DataType;
import org.eclipselabs.damos.typesystem.TypeSystemFactory;

/**
 * @author Andreas Unger
 *
 */
public class LogicGateSignaturePolicy implements IComponentSignaturePolicy {

	private static final IComponentSignature SIGNATURE = new IComponentSignature() {
		
		public DataType getOutputDataType(OutputPort outputPort) {
			return TypeSystemFactory.eINSTANCE.createBooleanType();
		}
		
		public DataType getInputDataType(InputPort inputPort) {
			return TypeSystemFactory.eINSTANCE.createBooleanType();
		}
		
	};
	
	public IComponentSignatureEvaluationResult evaluateSignature(IEvaluationContext context, Component component, Map<InputPort, DataType> incomingDataTypes) {
		MultiStatus status = new MultiStatus(LibraryBasePlugin.PLUGIN_ID, 0, "", null);
		
		for (Entry<InputPort, DataType> incomingDataType : incomingDataTypes.entrySet()) {
			if (!(incomingDataType.getValue() instanceof BooleanType)) {
				status.add(new Status(IStatus.ERROR, LibraryBasePlugin.PLUGIN_ID, "Input value must be boolean"));
			}
		}
		
		if (!status.isOK()) {
			return new ComponentSignatureEvaluationResult(status);
		}
		
		return new ComponentSignatureEvaluationResult(SIGNATURE);
	}

}
