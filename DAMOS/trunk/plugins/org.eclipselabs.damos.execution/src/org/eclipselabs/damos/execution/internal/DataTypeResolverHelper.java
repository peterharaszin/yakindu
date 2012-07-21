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

package org.eclipselabs.damos.execution.internal;

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
import org.eclipselabs.damos.execution.datatype.IComponentSignature;
import org.eclipselabs.damos.execution.datatype.IComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.datatype.IComponentSignaturePolicy;
import org.eclipselabs.damos.execution.internal.registry.ComponentSignaturePolicyProviderRegistry;
import org.eclipselabs.damos.mscript.BooleanType;
import org.eclipselabs.damos.mscript.Type;

/**
 * @author Andreas Unger
 *
 */
public class DataTypeResolverHelper {

	private Fragment fragment;
	private Map<Component, IComponentSignature> signatures;
	private MultiStatus status;
	
	private Map<EObject, IStatus> statusMap = new HashMap<EObject, IStatus>();
	private Map<EObject, IStatus> errorStatusMap = new HashMap<EObject, IStatus>();
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
				addStatus(entry, "");
			}
		}
		
		if (!errorStatusMap.isEmpty()) {
			for (Entry<EObject, IStatus> entry : errorStatusMap.entrySet()) {
				String message;
				if (entry.getKey() instanceof Component) {
					Component component = (Component) entry.getKey();
					message = "Resolving data types of component '" + component.getName() + "' failed";
				} else {
					message = "Resolving data types failed";
				}
				addStatus(entry, message);
			}
		}
		
		for (Component unresolvedComponent : unresolvedComponents) {
			status.add(new EObjectStatus(IStatus.ERROR, unresolvedComponent, "Component signature of '" + unresolvedComponent.getName() + "' could not be resolved"));
		}
	}

	/**
	 * @param entry
	 * @param message
	 */
	private void addStatus(Entry<EObject, IStatus> entry, String message) {
		if (entry.getValue().isMultiStatus()) {
			status.add(new EObjectMultiStatus(entry.getKey(), entry.getValue().getChildren(), message));
		} else {
			status.add(new EObjectMultiStatus(entry.getKey(), new IStatus[] { entry.getValue() }, message));
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
			Type incomingDataType = getIncomingDataType(whileLoop.getCondition());
			if (incomingDataType != null && !(incomingDataType instanceof BooleanType)) {
				errorStatusMap.put(whileLoop, new EObjectStatus(IStatus.ERROR, whileLoop, "While loop condition input value must be boolean"));
			} else {
				errorStatusMap.remove(whileLoop);
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
				
				if (result.getStatus().getSeverity() < IStatus.ERROR) {
					if (result.getStatus().isOK()) {
						statusMap.remove(component);
					} else {
						statusMap.put(component, result.getStatus());
					}
					errorStatusMap.remove(component);
				} else {
					statusMap.remove(component);
					errorStatusMap.put(component, result.getStatus());
				}
				
				if (result.getSignature() == null && result.getStatus().getSeverity() < IStatus.ERROR) {
					unresolvedComponents.add(component);
				} else {
					unresolvedComponents.remove(component);
				}
			} else {
				errorStatusMap.put(component, new EObjectStatus(IStatus.ERROR, component, "No signature returned by signature policy"));
			}
		} else {
			errorStatusMap.put(component, new EObjectStatus(IStatus.ERROR, component, "No component signature policy found"));
		}
		return changed;
	}

	private Map<InputPort, Type> getIncomingDataTypes(Component component) {
		Map<InputPort, Type> incomingDataTypes = new HashMap<InputPort, Type>();
		for (InputPort inputPort : component.getInputPorts()) {
			Type incomingDataType = getIncomingDataType(inputPort);
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
	private Type getIncomingDataType(InputConnector inputPort) {
		Type incomingDataType = null;
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
	
	private Type getFixedConnectorDataType(OutputConnector connector) {
		return null;
	}

}
