/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.codegen.c.util;

import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.StringLiteral;

/**
 * @author Andreas Unger
 *
 */
public class GeneratorConfigurationUtil {

	public static String getPropertyStringValue(Configuration configuration, String propertyName, String defaultValue) {
		Expression expression = configuration.getPropertyValue(propertyName);
		if (expression instanceof StringLiteral) {
			return ((StringLiteral) expression).getValue();
		}
		return defaultValue;
	}

}
