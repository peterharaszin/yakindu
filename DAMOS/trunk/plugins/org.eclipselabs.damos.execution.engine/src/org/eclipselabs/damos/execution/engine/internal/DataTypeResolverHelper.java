/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.execution.engine.internal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Compound;
import org.eclipselabs.damos.dml.CompoundMember;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.FragmentElement;
import org.eclipselabs.damos.dml.InputConnector;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OutputConnector;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.WhileLoop;
import org.eclipselabs.damos.execution.engine.IComponentSignature;
import org.eclipselabs.damos.execution.engine.IComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.engine.IComponentSignaturePolicy;
import org.eclipselabs.damos.execution.engine.internal.registry.ComponentSignaturePolicyProviderRegistry;
import org.eclipselabs.mscript.typesystem.BooleanType;
import org.eclipselabs.mscript.typesystem.DataType;

/**
 * @author Andreas Unger
 *
 */
public class DataTypeResolverHelper {

	private Fragment fragment;
	private Map<Component, IComponentSignature> signatures;
	private MultiStatus status;
	
	private Map<EObject, IStatus> statusMap = new HashMap<EObject, IStatus>();
	private Set<Component> unresolvedComponents = new HashSet<Component>();
	
	/**
	 * 
	 */
	public DataTypeResolverHelper(Fragment fragment, Map<Component, IComponentSignature> signatures, MultiStatus status) {
		this.fragment = fragment;
		this.signatures = signatures;
		this.status = status;
	}

	public void resolve() {
		boolean changed;
		do {
			changed = false;
			for (FragmentElement element : fragment.getAllFragmentElements()) {
				changed = resolveElement(element, changed);
			}
		} while (changed);
		
		if (!statusMap.isEmpty()) {
			for (Entry<EObject, IStatus> entry : statusMap.entrySet()) {
				String message;
				if (entry.getKey() instanceof Component) {
					Component component = (Component) entry.getKey();
					message = "Resolving data types of component '" + component.getName() + "' failed";
				} else {
					message = "Resolving data types failed";
				}
				if (entry.getValue().isMultiStatus()) {
					status.add(new EObjectMultiStatus(entry.getKey(), entry.getValue().getChildren(), message));
				} else {
					status.add(new EObjectMultiStatus(entry.getKey(), new IStatus[] { entry.getValue() }, message));
				}
			}
		}
		
		for (Component unresolvedComponent : unresolvedComponents) {
			status.add(new EObjectStatus(IStatus.ERROR, unresolvedComponent, "Component signature of '" + unresolvedComponent.getName() + "' could not be resolved"));
		}
	}

	private boolean resolveElement(EObject element, boolean changed) {
		if (element instanceof Component) {
			Component component = (Component) element;
			changed = resolveComponent(component, changed);
		} else if (element instanceof Compound) {
			Compound compound = (Compound) element;
			resolveCompoundOutputConnectors(compound);
			for (CompoundMember member : compound.getMembers()) {
				changed = resolveElement(member, changed);
			}
			resolveCompoundInputConnectors(compound);
		}
		return changed;
	}

	/**
	 * @param compound
	 */
	private void resolveCompoundInputConnectors(Compound compound) {
		if (compound instanceof WhileLoop) {
			WhileLoop whileLoop = (WhileLoop) compound;
			DataType incomingDataType = getIncomingDataType(whileLoop.getCondition());
			if (incomingDataType != null && !(incomingDataType instanceof BooleanType)) {
				statusMap.put(whileLoop, new EObjectStatus(IStatus.ERROR, whileLoop, "While loop condition input value must be boolean"));
			} else {
				statusMap.remove(whileLoop);
			}
		}
	}

	/**
	 * @param compound
	 */
	private void resolveCompoundOutputConnectors(Compound compound) {
	}

	private boolean resolveComponent(Component component, boolean changed) {
		IComponentSignaturePolicy policy = ComponentSignaturePolicyProviderRegistry.getInstance().createPolicy(component);
		if (policy != null) {
			IComponentSignatureEvaluationResult result = policy.evaluateSignature(
					component,
					getIncomingDataTypes(component));
			
			if (result != null) {
				if (result.getSignature() != null) {
					IComponentSignature oldSignature = signatures.get(component);
					IComponentSignature newSignature = result.getSignature();
					if (newSignature != null && (oldSignature == null || !oldSignature.equals(newSignature))) {
						signatures.put(component, newSignature);
						changed = true;
					}
				}
				
				if (result.getStatus().isOK()) {
					statusMap.remove(component);
				} else {
					statusMap.put(component, result.getStatus());
				}
				
				if (result.getSignature() == null && result.getStatus().isOK()) {
					unresolvedComponents.add(component);
				} else {
					unresolvedComponents.remove(component);
				}
			} else {
				statusMap.put(component, new EObjectStatus(IStatus.ERROR, component, "No signature returned by signature policy"));
			}
		} else {
			statusMap.put(component, new EObjectStatus(IStatus.ERROR, component, "No component signature policy found"));
		}
		return changed;
	}

	private Map<InputPort, DataType> getIncomingDataTypes(Component component) {
		Map<InputPort, DataType> incomingDataTypes = new HashMap<InputPort, DataType>();
		for (InputPort inputPort : component.getInputPorts()) {
			DataType incomingDataType = getIncomingDataType(inputPort);
			if (incomingDataType != null) {
				incomingDataTypes.put(inputPort, incomingDataType);
			}
		}
		return incomingDataTypes;
	}

	/**
	 * @param inputPort
	 * @param incomingDataTypes
	 */
	private DataType getIncomingDataType(InputConnector inputPort) {
		DataType incomingDataType = null;
		Connection connection = inputPort.getFirstConnection(fragment);
		if (connection != null) {
			if (connection.getSource() instanceof OutputPort) {
				OutputPort sourcePort = (OutputPort) connection.getSource();
				IComponentSignature signature = signatures.get(sourcePort.getComponent());
				if (signature != null) {
					incomingDataType = signature.getOutputDataType(sourcePort);
				}
			} else {
				incomingDataType = getFixedConnectorDataType(connection.getSource());
			}
		}
		return incomingDataType;
	}
	
	private DataType getFixedConnectorDataType(OutputConnector connector) {
		return null;
	}

}
