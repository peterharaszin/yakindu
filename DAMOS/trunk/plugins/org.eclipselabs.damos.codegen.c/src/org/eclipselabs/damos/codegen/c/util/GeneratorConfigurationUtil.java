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
import org.eclipselabs.damos.codegen.c.ITargetGenerator;
import org.eclipselabs.damos.codegen.c.internal.registry.RuntimeEnvironmentAPIRegistry;
import org.eclipselabs.damos.codegen.c.internal.registry.TargetGeneratorDescriptor;
import org.eclipselabs.damos.codegen.c.internal.registry.TargetGeneratorRegistry;
import org.eclipselabs.damos.codegen.c.internal.util.InternalGeneratorUtil;
import org.eclipselabs.damos.codegen.c.rte.IRuntimeEnvironmentAPI;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.execution.executionflow.ComponentNode;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.StringLiteral;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;
import org.eclipselabs.damos.mscript.computationmodel.util.ComputationModelUtil;

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
		return getPropertyStringValue(configuration, "damos.codegen.generator/systemSourceFile", defaultSourceFile);
	}

	public static String getSystemHeaderFile(Configuration configuration) {
		String defaultHeaderFile = new Path(getSystemSourceFile(configuration)).removeFileExtension().addFileExtension("h").toString();
		return getPropertyStringValue(configuration, "damos.codegen.generator/systemHeaderFile", defaultHeaderFile);
	}

	public static String getPrefix(Configuration configuration) {
		String prefix = InternalGeneratorUtil.getPrefix(configuration);
		if (prefix == null) {
			prefix = "";
		}
		return prefix;
	}

	public static IRuntimeEnvironmentAPI getRuntimeEnvironmentAPI(Configuration configuration) {
		String runtimeId = configuration.getPropertySelectionName("damos.rte.runtime");
		if (runtimeId != null) {
			return RuntimeEnvironmentAPIRegistry.getInstance().getRuntimeEnvironmentAPI(runtimeId);
		}
		return null;
	}

	public static ComputationModel getComputationModel(Configuration configuration, ComponentNode node) {
		ComputationModel computationModel = configuration.getComputationModel(node.getSystemPath());
		if (computationModel == null) {
			computationModel = ComputationModelUtil.constructDefaultComputationModel();
		}
		return computationModel;
	}
	
	public static ITargetGenerator getTargetGenerator(Configuration configuration) {
		String targetId = configuration.getPropertySelectionName("damos.codegen.target");
		if (targetId != null) {
			TargetGeneratorDescriptor targetGeneratorDescriptor = TargetGeneratorRegistry.getInstance().getGenerator(targetId);
			if (targetGeneratorDescriptor != null) {
				return targetGeneratorDescriptor.createGenerator();
			}
		}
		return null;
	}

}
