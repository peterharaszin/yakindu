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

package org.eclipse.damos.codegen.c.util;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.damos.codegen.c.CodegenCPlugin;
import org.eclipse.damos.codegen.c.ITargetGenerator;
import org.eclipse.damos.codegen.c.internal.registry.RuntimeEnvironmentAPIRegistry;
import org.eclipse.damos.codegen.c.internal.registry.TargetGeneratorDescriptor;
import org.eclipse.damos.codegen.c.internal.registry.TargetGeneratorRegistry;
import org.eclipse.damos.codegen.c.rte.IRuntimeEnvironmentAPI;
import org.eclipse.damos.dconfig.Configuration;
import org.eclipse.damos.dconfig.util.PropertyPath;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.dml.util.SystemPath;
import org.eclipse.damos.execution.ComponentNode;
import org.eclipse.damos.execution.Node;
import org.eclipse.damos.execution.util.ExpressionUtil;
import org.eclipse.damos.mscript.BooleanLiteral;
import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.StringLiteral;
import org.eclipse.damos.mscript.computation.ComputationModel;
import org.eclipse.damos.mscript.computation.util.ComputationModelUtil;
import org.eclipse.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipse.damos.mscript.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class GeneratorConfigurationExtensions {

	private static final PropertyPath PROJECT_NAME_PROPERTY_PATH = PropertyPath.create("damos.codegen.generator/projectName");

	private static final PropertyPath SOURCE_FOLDER_PROPERTY_PATH = PropertyPath.create("damos.codegen.generator/sourceFolder");
	private static final PropertyPath HEADER_FOLDER_PROPERTY_PATH = PropertyPath.create("damos.codegen.generator/headerFolder");

	private static final PropertyPath SYSTEM_SOURCE_FILE_PROPERTY_PATH = PropertyPath.create("damos.codegen.generator/systemSourceFile");
	private static final PropertyPath SYSTEM_HEADER_FILE_PROPERTY_PATH = PropertyPath.create("damos.codegen.generator/systemHeaderFile");

	private static final PropertyPath SINGLETON_PROPERTY_PATH = PropertyPath.create("damos.codegen.generator/singleton");

	private static final PropertyPath STRING_BUFFER_SIZE_PROPERTY_PATH = PropertyPath.create("damos.codegen.generator/stringBufferSize");

	private static final PropertyPath RTE_RUNTIME_PROPERTY_PATH = PropertyPath.create("damos.rte.runtime");
	private static final PropertyPath PREFIX_PROPERTY_PATH = PropertyPath.create("damos.codegen.c.prefix");
	private static final PropertyPath TARGET_PROPERTY_PATH = PropertyPath.create("damos.codegen.target");
	
	public static String getProjectName(Configuration configuration) {
		return getPropertyStringValue(configuration, PROJECT_NAME_PROPERTY_PATH, null);
	}
	
	public static String getSourceFolder(Configuration configuration) {
		return getPropertyStringValue(configuration, SOURCE_FOLDER_PROPERTY_PATH, null);
	}

	public static String getHeaderFolder(Configuration configuration) {
		return getPropertyStringValue(configuration, HEADER_FOLDER_PROPERTY_PATH, getSourceFolder(configuration));
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
		return getPropertyStringValue(configuration, SYSTEM_SOURCE_FILE_PROPERTY_PATH, defaultSourceFile);
	}

	public static String getSystemHeaderFile(Configuration configuration) {
		String defaultHeaderFile = new Path(getSystemSourceFile(configuration)).removeFileExtension().addFileExtension("h").toString();
		return getPropertyStringValue(configuration, SYSTEM_HEADER_FILE_PROPERTY_PATH, defaultHeaderFile);
	}
	
	public static boolean isSingleton(Configuration configuration) {
		return getPropertyBooleanValue(configuration, SINGLETON_PROPERTY_PATH, false);
	}

	public static int getStringBufferSize(Configuration configuration) {
		Expression expression = configuration.getPropertyValue(STRING_BUFFER_SIZE_PROPERTY_PATH);
		if (expression != null) {
			try {
				IValue value = ExpressionUtil.evaluateExpression(expression);
				if (value instanceof ISimpleNumericValue) {
					return (int) ((ISimpleNumericValue) value).longValue();
				}
			} catch (CoreException e) {
				CodegenCPlugin.getDefault().getLog().log(e.getStatus());
			}
		}
		return 32;
	}

	public static String getPrefix(Configuration configuration, Node node) {
		String prefix = null;
		Expression prefixValue = configuration.getPropertyValue(node.getSystemPath(), PREFIX_PROPERTY_PATH);
		if (prefixValue instanceof StringLiteral) {
			prefix = ((StringLiteral) prefixValue).getText();
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
			prefix = ((StringLiteral) prefixValue).getText();
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

	private static String getPropertyStringValue(Configuration configuration, PropertyPath propertyPath, String defaultValue) {
		Expression expression = configuration.getPropertyValue(propertyPath);
		if (expression instanceof StringLiteral) {
			return ((StringLiteral) expression).getText();
		}
		return defaultValue;
	}

	private static boolean getPropertyBooleanValue(Configuration configuration, PropertyPath propertyPath, boolean defaultValue) {
		Expression expression = configuration.getPropertyValue(propertyPath);
		if (expression instanceof BooleanLiteral) {
			return ((BooleanLiteral) expression).isTrue();
		}
		return defaultValue;
	}

}
