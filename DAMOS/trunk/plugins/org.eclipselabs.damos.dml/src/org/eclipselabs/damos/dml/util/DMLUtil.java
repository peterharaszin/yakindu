/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.dml.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.Connector;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.FragmentElement;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.InputConnector;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.Output;
import org.eclipselabs.damos.dml.OutputConnector;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.ParameterizedElement;
import org.eclipselabs.damos.dml.Subsystem;
import org.eclipselabs.damos.dml.SubsystemRealization;

/**
 * @author Andreas Unger
 *
 */
public class DMLUtil {
		
	@SuppressWarnings("rawtypes")
	public static int indexOf(EObject o) {
		EStructuralFeature feature = o.eContainingFeature();
		if (feature != null) {
			Object l = o.eContainer().eGet(feature);
			if (l instanceof List) {
				return ((List) l).indexOf(o);
			}
		}
		return -1;
	}

	public static ResourceSet getResourceSet(EObject eObject) {
		Resource resource = eObject.eResource();
		return resource != null ? resource.getResourceSet() : null;
	}
	
	public static Notifier getRootNotifier(EObject eObject) {
		Resource resource = eObject.eResource();
		if (resource != null) {
			ResourceSet resourceSet = resource.getResourceSet();
			if (resourceSet != null) {
				return resourceSet;
			}
			return resource;
		}
		return EcoreUtil.getRootContainer(eObject);
	}
		
	public static String getArgumentValue(ParameterizedElement element, String parameterName, String defaultValue) {
		String value = element.getArgumentStringValue(parameterName);
		if (value != null) {
			return value;
		}
		return defaultValue;
	}

	public static int getArgumentValueAsInteger(ParameterizedElement element, String parameterName, int defaultValue) {
		String value = element.getArgumentStringValue(parameterName);
		if (value != null) {
			try {
				return Integer.parseInt(value);
			} catch (NumberFormatException e) {
				// return default value
			}
		}
		return defaultValue;
	}
	
	public static int getArgumentValueAsInteger(ParameterizedElement element, String parameterName, Integer defaultValue) {
		return getArgumentValueAsInteger(element, parameterName, defaultValue.intValue());
	}

	public static double getArgumentValueAsDouble(ParameterizedElement element, String parameterName, double defaultValue) {
		String value = element.getArgumentStringValue(parameterName);
		if (value != null) {
			try {
				return Double.parseDouble(value);
			} catch (NumberFormatException e) {
				// return default value
			}
		}
		return defaultValue;
	}

	public static double getArgumentValueAsDouble(ParameterizedElement element, String parameterName, Double defaultValue) {
		return getArgumentValueAsDouble(element, parameterName, defaultValue.doubleValue());
	}
	
	public static boolean getArgumentValueAsBoolean(ParameterizedElement element, String parameterName, boolean defaultValue) {
		String value = element.getArgumentStringValue(parameterName);
		if (value != null) {
			return Boolean.parseBoolean(value);
		}
		return defaultValue;
	}

	public static boolean getArgumentValueAsBoolean(ParameterizedElement element, String parameterName, Boolean defaultValue) {
		return getArgumentValueAsBoolean(element, parameterName, defaultValue.booleanValue());
	}
	
	public static String findAvailableComponentName(Fragment fragment, String preferredName) {
		Set<String> names = new HashSet<String>();
		for (Component component : fragment.getAllComponents()) {
			names.add(component.getName());
		}
		String availableName = preferredName;
		for (int i = 2; names.contains(availableName); ++i) {
			availableName = preferredName + i;
		}
		return availableName;
	}
	
	public static boolean canConnectOutgoingConnection(Connector connector) {
		return connector instanceof OutputConnector;
	}

	public static boolean canConnectIncomingConnection(Connector connector, Fragment connectionContainerFragment) {
		if (!(connector instanceof InputConnector)) {
			return false;
		}
		for (Connection connection : connector.getConnections()) {
			if (areFragmentsRelated(connection.getOwningFragment(), connectionContainerFragment)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isChildFragment(Fragment fragment, Fragment otherFragment) {
		do {
			if (fragment.getParent() == otherFragment) {
				return true;
			}
			fragment = fragment.getParent();
		} while (fragment != null);
		
		return false;
	}
	
	public static boolean areFragmentsRelated(Fragment fragment1, Fragment fragment2) {
		return fragment1 == fragment2 || isChildFragment(fragment1, fragment2) || isChildFragment(fragment2, fragment1);
	}
	
	public static Fragment getRootFragment(Fragment fragment) {
		Fragment root = fragment;
		while (root.getParent() != null) {
			root = root.getParent();
		}
		return root;
	}
	
	public static SubsystemRealization findSubsystemRealization(Fragment fragment, Subsystem subsystem) {
		for (FragmentElement fragmentElement : fragment.getFragmentElements()) {
			if (fragmentElement instanceof SubsystemRealization) {
				SubsystemRealization subsystemRealization = (SubsystemRealization) fragmentElement;
				if (subsystemRealization.getRealizedSubsystem() == subsystem) {
					return subsystemRealization;
				}
			}
		}
		return null;
	}
	
	public enum SubsystemRealizationType {
		NONE,
		EXISTS,
		IMPLEMENTS,
		OVERRIDES
	}

	public static SubsystemRealizationType getSubsystemRealizationType(Subsystem subsystem, Fragment context) {
		SubsystemRealization realization = subsystem.getRealization(context);
		if (realization != null) {
			if (realization.getOwningFragment() == context) {
				if (context.getParent() == null || subsystem.getRealization(context.getParent()) == null) {
					return SubsystemRealizationType.IMPLEMENTS;
				}
				return SubsystemRealizationType.OVERRIDES;
			}
			return SubsystemRealizationType.EXISTS;
		}
		return SubsystemRealizationType.NONE;
	}
	
	public static <T extends Component> Map<String, T> getComponentMap(Fragment context, Class<T> clazz) {
		Map<String, T> components = new HashMap<String, T>();
		for (Component component : context.getAllComponents()) {
			if (clazz.isInstance(component)) {
				components.put(component.getName(), clazz.cast(component));
			}
		}
		return components;
	}
	
	public static Collection<Connection> getConnections(Component component) {
		Collection<Connection> connections = new ArrayList<Connection>();
		for (Input input : component.getInputs()) {
			for (InputPort inputPort : input.getPorts()) {
				connections.addAll(inputPort.getConnections());
			}
		}
		for (Output output : component.getOutputs()) {
			for (OutputPort outputPort : output.getPorts()) {
				connections.addAll(outputPort.getConnections());
			}
		}
		return connections;
	}
	
	public static <T extends EObject> T getOwner(EObject eObject, Class<T> clazz) {
		while (eObject != null) {
			if (clazz.isInstance(eObject)) {
				return clazz.cast(eObject);
			}
			eObject = eObject.eContainer();
		}
		return null;
	}

}
