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

package org.eclipselabs.damos.evaluation;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.evaluation.componentsignature.IComponentSignature;
import org.eclipselabs.damos.evaluation.componentsignature.IComponentSignaturePolicy;
import org.eclipselabs.damos.evaluation.internal.registry.ComponentSignaturePolicyProviderRegistry;
import org.eclipselabs.damos.typesystem.DataType;

/**
 * @author Andreas Unger
 *
 */
public class DataTypeResolver {
	
	public DataTypeResolverResult resolve(Fragment fragment, DiagnosticChain diagnostics) {
		DataTypeResolverResult resolverResult = new DataTypeResolverResult();
		Map<Component, Diagnostic> componentDiagnostics = new HashMap<Component, Diagnostic>();
		
		boolean changed;
		do {
			changed = false;
			for (Component component : fragment.getAllComponents()) {
				IComponentSignaturePolicy policy = ComponentSignaturePolicyProviderRegistry.getInstance().createPolicy(component);
				if (policy != null) {
					IEvaluationContext context = new IEvaluationContext() {
						// TODO
					};
					
					BasicDiagnostic componentDiagnostic = new BasicDiagnostic(component.getName(), 0, "Evaluation failed", new Object[] { component });
					IComponentSignature newSignature = policy.evaluateSignature(
							context,
							component,
							getIncomingDataTypes(fragment, component, resolverResult),
							componentDiagnostic);
					componentDiagnostic.recomputeSeverity();
					
					if (newSignature != null) {
						IComponentSignature oldSignature = resolverResult.getSignatures().get(component);
						if (newSignature != null && (oldSignature == null || !oldSignature.equals(newSignature))) {
							resolverResult.getSignatures().put(component, newSignature);
							changed = true;
						}
					}
					
					if (componentDiagnostic.getSeverity() != Diagnostic.OK) {
						componentDiagnostics.put(component, componentDiagnostic);
					}
				} else {
					componentDiagnostics.put(component, new BasicDiagnostic(Diagnostic.ERROR, component.getName(), 0, "No component signature policy found", new Object[] { component }));
				}
			}
		} while (changed);
		
		for (Diagnostic componentDiagnostic : componentDiagnostics.values()) {
			diagnostics.add(componentDiagnostic);
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
