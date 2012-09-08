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

package org.eclipselabs.damos.dml.internal.operations;

import org.eclipselabs.damos.dml.Argument;
import org.eclipselabs.damos.dml.Parameter;
import org.eclipselabs.damos.dml.ParameterizedElement;

public class ParameterizedElementOperations {

	public static  Argument getArgument(ParameterizedElement parameterizedElement, Parameter parameter) {
		for (Argument argument : parameterizedElement.getArguments()) {
			if (argument.getParameter() == parameter) {
				return argument;
			}
		}
		return null;
	}

	public static  Argument getArgument(ParameterizedElement parameterizedElement, String parameterName) {
		for (Argument argument : parameterizedElement.getArguments()) {
			if (argument.getParameter().getName().equals(parameterName)) {
				return argument;
			}
		}
		return null;
	}

	public static  String getArgumentStringValue(ParameterizedElement parameterizedElement, String parameterName) {
		Argument argument = parameterizedElement.getArgument(parameterName);
		if (argument != null && argument.isSetValue()) {
			return argument.getValue().stringValue();
		}
		return null;
	}

}
