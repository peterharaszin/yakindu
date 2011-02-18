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
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.FragmentElement;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.Subsystem;
import org.eclipselabs.damos.dml.SubsystemRealization;
import org.eclipselabs.damos.execution.engine.internal.ComponentMultiStatus;
import org.eclipselabs.damos.execution.engine.internal.ComponentStatus;
import org.eclipselabs.damos.execution.engine.internal.registry.ComponentSignaturePolicyProviderRegistry;
import org.eclipselabs.mscript.typesystem.DataType;

/**
 * @author Andreas Unger
 *
 */
public class ComponentSignatureResolver {
	
	public ComponentSignatureResolverResult resolve(Fragment fragment, boolean descend) {
		Map<Component, IComponentSignature> signatures = new HashMap<Component, IComponentSignature>();
		MultiStatus status = new MultiStatus(ExecutionEnginePlugin.PLUGIN_ID, 0, "Resolving component signatures failed", null);

		if (descend) {
			doResolveAll(fragment, signatures, status, new HashSet<Fragment>());
		} else {
			doResolve(fragment, signatures, status);
		}
		
		if (!status.isOK()) {
			return new ComponentSignatureResolverResult(signatures, status);
		}
		return new ComponentSignatureResolverResult(signatures);
	}
	
	private void doResolveAll(Fragment fragment, Map<Component, IComponentSignature> signatures, MultiStatus status, HashSet<Fragment> visitedFragments) {
		doResolve(fragment, signatures, status);
		visitedFragments.add(fragment);
		
		for (FragmentElement element : fragment.getComponents()) {
			if (element instanceof Subsystem) {
				Subsystem subsystem = (Subsystem) element;
				SubsystemRealization realization = subsystem.getRealization(fragment);
				if (realization != null) {
					Fragment realizingFragment = realization.getRealizingFragment();
					if (realizingFragment != null) {
						if (!visitedFragments.contains(realizingFragment)) {
							doResolveAll(realizingFragment, signatures, status, visitedFragments);
						}
					} else {
						status.add(new ComponentStatus(IStatus.ERROR, subsystem, "No realizing fragment in subsystem realization specified"));
					}
				} else {
					status.add(new ComponentStatus(IStatus.ERROR, subsystem, "No subsystem realization specified"));
				}
			}
		}
	}

	private void doResolve(Fragment fragment, Map<Component, IComponentSignature> signatures, MultiStatus status) {
		Map<Component, IStatus> statusMap = new HashMap<Component, IStatus>();
		Set<Component> unresolvedComponents = new HashSet<Component>();
		
		boolean changed;
		do {
			changed = false;
			for (Component component : fragment.getAllComponents()) {
				IComponentSignaturePolicy policy = ComponentSignaturePolicyProviderRegistry.getInstance().createPolicy(component);
				if (policy != null) {
					IComponentSignatureEvaluationResult result = policy.evaluateSignature(
							component,
							getIncomingDataTypes(fragment, component, signatures));
					
					if (result != null) {
						if (result.getSignature() != null) {
							IComponentSignature oldSignature = signatures.get(component);
							IComponentSignature newSignature = result.getSignature();
							if (newSignature != null && (oldSignature == null || !oldSignature.equals(newSignature))) {
								signatures.put(component, newSignature);
								changed = true;
							}
						}
						if (!result.getStatus().isOK()) {
							statusMap.put(component, result.getStatus());
						}
						if (result.getSignature() == null && result.getStatus().isOK()) {
							unresolvedComponents.add(component);
						} else {
							unresolvedComponents.remove(component);
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
			for (Entry<Component, IStatus> entry : statusMap.entrySet()) {
				String message = "Resolving component signature of '" + entry.getKey().getName() + "' failed";
				if (entry.getValue().isMultiStatus()) {
					status.add(new ComponentMultiStatus(entry.getKey(), entry.getValue().getChildren(), message));
				} else {
					status.add(new ComponentMultiStatus(entry.getKey(), new IStatus[] { entry.getValue() }, message));
				}
			}
		}
		for (Component unresolvedComponent : unresolvedComponents) {
			status.add(new ComponentStatus(IStatus.ERROR, unresolvedComponent, "Component signature of '" + unresolvedComponent.getName() + "' could not be resolved"));
		}
	}

	/**
	 * @param fragment
	 * @param component
	 */
	private Map<InputPort, DataType> getIncomingDataTypes(Fragment fragment, Component component, Map<Component, IComponentSignature> signatures) {
		Map<InputPort, DataType> incomingDataTypes = new HashMap<InputPort, DataType>();
		for (InputPort inputPort : component.getInputPorts()) {
			Connection connection = inputPort.getFirstConnection(fragment);
			if (connection != null) {
				OutputPort sourcePort = connection.getSourcePort();
				IComponentSignature signature = signatures.get(sourcePort.getComponent());
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
