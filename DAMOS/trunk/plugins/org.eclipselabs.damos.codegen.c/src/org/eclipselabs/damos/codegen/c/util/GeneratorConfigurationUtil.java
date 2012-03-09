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

import org.eclipse.core.runtime.Path;
import org.eclipselabs.damos.codegen.c.internal.util.InternalGeneratorUtil;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.dml.Fragment;
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

	public static String getSystemSourceFile(Configuration configuration) {
		Fragment contextFragment = configuration.getContextFragment();
		String defaultSourceFile = contextFragment.getName();
		if (defaultSourceFile == null || defaultSourceFile.trim().length() == 0) {
			defaultSourceFile = "main.c";
		} else {
			defaultSourceFile.replaceAll("\\W", "_");
			defaultSourceFile += ".c";
		}
		return GeneratorConfigurationUtil.getPropertyStringValue(configuration, "damos.codegen.generator/systemSourceFile", defaultSourceFile);
	}

	public static String getSystemHeaderFile(Configuration configuration) {
		String defaultHeaderFile = new Path(getSystemSourceFile(configuration)).removeFileExtension().addFileExtension("h").toString();
		return GeneratorConfigurationUtil.getPropertyStringValue(configuration, "damos.codegen.generator/systemHeaderFile", defaultHeaderFile);
	}

	public static String getPrefix(Configuration configuration) {
		String prefix = InternalGeneratorUtil.getPrefix(configuration);
		if (prefix == null) {
			prefix = "";
		}
		return prefix;
	}

}
