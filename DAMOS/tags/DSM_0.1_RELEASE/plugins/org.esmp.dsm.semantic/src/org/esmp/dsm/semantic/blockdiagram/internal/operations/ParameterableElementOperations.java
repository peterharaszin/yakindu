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

package org.esmp.dsm.semantic.blockdiagram.internal.operations;

import org.esmp.dsm.semantic.blockdiagram.Parameter;
import org.esmp.dsm.semantic.blockdiagram.ParameterableElement;

/**
 * @author Andreas Unger
 *
 */
public class ParameterableElementOperations {

	public static Parameter getParameter(ParameterableElement parameterableElement, String name) {
		for (Parameter parameter : parameterableElement.getParameters()) {
			if (parameter.getName().equals(name)) {
				return parameter;
			}
		}
		return null;
	}

	public static String getParameterValue(ParameterableElement parameterableElement, String name) {
		Parameter parameter = parameterableElement.getParameter(name);
		if (parameter != null) {
			return parameter.getValue();
		}
		return null;
	}

}
