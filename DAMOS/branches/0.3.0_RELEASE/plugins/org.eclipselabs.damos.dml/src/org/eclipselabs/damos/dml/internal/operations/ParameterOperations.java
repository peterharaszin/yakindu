/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.internal.operations;

import org.eclipselabs.damos.dml.Parameter;
import org.eclipselabs.damos.dml.ParameterPredefinedValue;
import org.eclipselabs.damos.dml.ValueSpecification;

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