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
import org.eclipselabs.damos.codegen.c.rte.IRuntimeEnvironmentAPI;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.dconfig.util.PropertyPath;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.util.SystemPath;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.execution.Node;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.StringLiteral;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;
import org.eclipselabs.damos.mscript.computationmodel.util.ComputationModelUtil;

/**
 * @author Andreas Unger
 *
 */
public class GeneratorConfigurationExtensions {

	private static final PropertyPath PREFIX_PROPERTY_PATH = PropertyPath.create("damos.codegen.c.prefix");
	private static final PropertyPath RTE_RUNTIME_PROPERTY_PATH = PropertyPath.create("damos.rte.runtime");
	private static final PropertyPath TARGET_PROPERTY_PATH = PropertyPath.create("damos.codegen.target");
	
	public static String getPropertyStringValue(Configuration configuration, String propertyName, String defaultValue) {
		Expression expression = configuration.getPropertyValue(PropertyPath.create(propertyName));
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

	public static String getPrefix(Configuration configuration, Node node) {
		String prefix = null;
		Expression prefixValue = configuration.getPropertyValue(node.getSystemPath(), PREFIX_PROPERTY_PATH);
		if (prefixValue instanceof StringLiteral) {
			prefix = ((StringLiteral) prefixValue).getValue();
		}
		if (prefix == null) {
			prefix = "";
		}
		return prefix;
	}

	public static String getPrefix(Configuration configuration) {
		String prefix = null;
		Expression prefixValue = configuration.getPropertyValue(SystemPath.create(configuration.getContextFragment()), PREFIX_PROPERTY_PATH);
		if (prefixValue instanceof StringLiteral) {
			prefix = ((StringLiteral) prefixValue).getValue();
		}
		if (prefix == null) {
			prefix = "";
		}
		return prefix;
	}

	public static IRuntimeEnvironmentAPI getRuntimeEnvironmentAPI(Configuration configuration) {
		String runtimeId = configuration.getPropertySelectionName(RTE_RUNTIME_PROPERTY_PATH);
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
		String targetId = configuration.getPropertySelectionName(TARGET_PROPERTY_PATH);
		if (targetId != null) {
			TargetGeneratorDescriptor targetGeneratorDescriptor = TargetGeneratorRegistry.getInstance().getGenerator(targetId);
			if (targetGeneratorDescriptor != null) {
				return targetGeneratorDescriptor.createGenerator();
			}
		}
		return null;
	}

}
