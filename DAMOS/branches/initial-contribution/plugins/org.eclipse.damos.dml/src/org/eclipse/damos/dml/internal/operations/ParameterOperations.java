/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
package org.eclipse.damos.dml.internal.operations;

import org.eclipse.damos.dml.Parameter;
import org.eclipse.damos.dml.ParameterPredefinedValue;
import org.eclipse.damos.dml.ValueSpecification;

public class ParameterOperations {

	public static ValueSpecification getDefaultValue(Parameter parameter) {
		return parameter.getOwnedDefaultValue();
	}
	
	public static ParameterPredefinedValue getPredefinedValue(Parameter parameter, String stringValue) {
		for (ParameterPredefinedValue entry : parameter.getPredefinedValues()) {
			if (entry.getValue() != null && stringValue.equals(entry.getValue().stringValue())) {
				return entry;
			}
		}
		return null;
	}

	public static ParameterPredefinedValue getPredefinedValueByAlias(Parameter parameter, String alias) {
		for (ParameterPredefinedValue entry : parameter.getPredefinedValues()) {
			if (alias.equals(entry.getAlias())) {
				return entry;
			}
		}
		return null;
	}

}