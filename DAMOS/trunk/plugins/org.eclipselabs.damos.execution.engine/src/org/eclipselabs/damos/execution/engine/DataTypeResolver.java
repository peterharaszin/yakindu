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

package org.eclipselabs.damos.execution.engine;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.execution.engine.internal.ComponentMultiStatus;
import org.eclipselabs.damos.execution.engine.internal.ComponentStatus;
import org.eclipselabs.damos.execution.engine.internal.registry.ComponentSignaturePolicyProviderRegistry;
import org.eclipselabs.mscript.typesystem.DataType;

/**
 * @author Andreas Unger
 *
 */
public class DataTypeResolver {
	
	public DataTypeResolverResult resolve(Fragment fragment) {
		DataTypeResolverResult resolverResult = new DataTypeResolverResult();
		Map<Component, IStatus> statusMap = new HashMap<Component, IStatus>();
		
		boolean changed;
		do {
			changed = false;
			for (Component component : fragment.getAllComponents()) {
				IComponentSignaturePolicy policy = ComponentSignaturePolicyProviderRegistry.getInstance().createPolicy(component);
				if (policy != null) {
					IComponentSignatureEvaluationResult result = policy.evaluateSignature(
							component,
							getIncomingDataTypes(fragment, component, resolverResult));
					
					if (result != null) {
						if (result.getSignature() != null) {
							IComponentSignature oldSignature = resolverResult.getSignatures().get(component);
							IComponentSignature newSignature = result.getSignature();
							if (newSignature != null && (oldSignature == null || !oldSignature.equals(newSignature))) {
								resolverResult.getSignatures().put(component, newSignature);
								changed = true;
							}
						}
						
						if (!result.getStatus().isOK()) {
							statusMap.put(component, result.getStatus());
						}
					} else {
						statusMap.put(component, new ComponentStatus(IStatus.ERROR, component, "No signature returned by signature policy"));
					}
				} else {
					statusMap.put(component, new ComponentStatus(IStatus.ERROR, component, "No component signature policy found"));
				}
			}
		} while (changed);
		
		if (!statusMap.isEmpty()) {
			MultiStatus resolverStatus = new MultiStatus(ExecutionCorePlugin.PLUGIN_ID, 0, "Evaluation failed", null);
			for (Entry<Component, IStatus> entry : statusMap.entrySet()) {
				String message = "Resolving data type of component '" + entry.getKey().getName() + "' failed";
				if (entry.getValue().isMultiStatus()) {
					resolverStatus.add(new ComponentMultiStatus(entry.getKey(), entry.getValue().getChildren(), message));
				} else {
					resolverStatus.add(new ComponentMultiStatus(entry.getKey(), new IStatus[] { entry.getValue() }, message));
				}
			}
			resolverResult.setStatus(resolverStatus);
		}
		
		return resolverResult;
	}

	/**
	 * @param fragment
	 * @param component
	 */
	private Map<InputPort, DataType> getIncomingDataTypes(Fragment fragment, Component component, DataTypeResolverResult result) {
		Map<InputPort, DataType> incomingDataTypes = new HashMap<InputPort, DataType>();
		for (InputPort inputPort : component.getInputPorts()) {
			Connection connection = inputPort.getIncomingConnection(fragment);
			if (connection != null) {
				OutputPort sourcePort = connection.getSourcePort();
				IComponentSignature signature = result.getSignatures().get(sourcePort.getComponent());
				if (signature != null) {
					DataType incomingDataType = signature.getOutputDataType(sourcePort);
					if (incomingDataType != null) {
						incomingDataTypes.put(inputPort, incomingDataType);
					}
				}
			}
		}
		return incomingDataTypes;
	}

}
