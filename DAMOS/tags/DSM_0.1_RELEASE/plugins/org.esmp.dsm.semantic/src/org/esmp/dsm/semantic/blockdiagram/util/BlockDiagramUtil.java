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

package org.esmp.dsm.semantic.blockdiagram.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.esmp.dsm.semantic.blockdiagram.Block;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagram;
import org.esmp.dsm.semantic.blockdiagram.InputPort;
import org.esmp.dsm.semantic.blockdiagram.OutputPort;
import org.esmp.dsm.semantic.blockdiagram.ParameterableElement;
import org.esmp.dsm.semantic.blockdiagram.Port;

/**
 * @author Andreas Unger
 *
 */
public class BlockDiagramUtil {
		
	public static String getParameterValue(ParameterableElement element, String name, String defaultValue) {
		String value = element.getParameterValue(name);
		if (value != null) {
			return value;
		}
		return defaultValue;
	}

	public static int getParameterValueAsInteger(ParameterableElement element, String name, int defaultValue) {
		String value = element.getParameterValue(name);
		if (value != null) {
			try {
				return Integer.parseInt(value);
			} catch (NumberFormatException e) {
				// return default value
			}
		}
		return defaultValue;
	}
	
	public static int getParameterValueAsInteger(ParameterableElement element, String name, Integer defaultValue) {
		return getParameterValueAsInteger(element, name, defaultValue.intValue());
	}

	public static double getParameterValueAsDouble(ParameterableElement element, String name, double defaultValue) {
		String value = element.getParameterValue(name);
		if (value != null) {
			try {
				return Double.parseDouble(value);
			} catch (NumberFormatException e) {
				// return default value
			}
		}
		return defaultValue;
	}

	public static double getParameterValueAsDouble(ParameterableElement element, String name, Double defaultValue) {
		return getParameterValueAsDouble(element, name, defaultValue.doubleValue());
	}
	
	public static boolean getParameterValueAsBoolean(ParameterableElement element, String name, boolean defaultValue) {
		String value = element.getParameterValue(name);
		if (value != null) {
			return Boolean.parseBoolean(value);
		}
		return defaultValue;
	}

	public static boolean getParameterValueAsBoolean(ParameterableElement element, String name, Boolean defaultValue) {
		return getParameterValueAsBoolean(element, name, defaultValue.booleanValue());
	}
	
	@SuppressWarnings("unchecked")
	public static int getIndex(EObject o) {
		EStructuralFeature feature = o.eContainingFeature();
		if (feature != null) {
			Object l = o.eContainer().eGet(feature);
			if (l instanceof List) {
				return ((List) l).indexOf(o);
			}
		}
		return -1;
	}

	public static String findAvailableBlockName(BlockDiagram blockDiagram, String preferredName) {
		Set<String> names = new HashSet<String>();
		for (Block block : blockDiagram.getBlocks()) {
			names.add(block.getName());
		}
		String availableName = preferredName;
		for (int i = 2; names.contains(availableName); ++i) {
			availableName = preferredName + i;
		}
		return availableName;
	}
	
	public static boolean canConnectOutgoingConnection(Port port) {
		return port instanceof OutputPort;
	}

	public static boolean canConnectIncomingConnection(Port port) {
		return port instanceof InputPort && ((InputPort) port).getIncomingConnection() == null;
	}

}
