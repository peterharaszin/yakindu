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

package org.eclipselabs.damos.execution.engine.util;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockInput;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OpaqueBehaviorSpecification;
import org.eclipselabs.damos.execution.engine.ExecutionEnginePlugin;
import org.eclipselabs.damos.execution.engine.IComponentSignature;
import org.eclipselabs.mscript.computation.engine.ComputationContext;
import org.eclipselabs.mscript.computation.engine.value.IValue;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.FunctionDefinition;
import org.eclipselabs.mscript.language.ast.Module;
import org.eclipselabs.mscript.language.ast.ParameterDeclaration;
import org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor;
import org.eclipselabs.mscript.language.functionmodel.util.FunctionDescriptorConstructor;
import org.eclipselabs.mscript.language.functionmodel.util.IFunctionDescriptorConstructorResult;
import org.eclipselabs.mscript.language.il.transform.ITransformerContext;
import org.eclipselabs.mscript.language.il.transform.TransformerContext;
import org.eclipselabs.mscript.language.interpreter.IInterpreterContext;
import org.eclipselabs.mscript.language.interpreter.InterpreterContext;
import org.eclipselabs.mscript.language.interpreter.util.ExpressionInterpreterHelper;
import org.eclipselabs.mscript.language.parser.antlr.MscriptParser;
import org.eclipselabs.mscript.language.util.LanguageUtil;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

/**
 * @author Andreas Unger
 *
 */
public class BehavioredBlockHelper {

	protected static final String SAMPLE_TIME_TEMPLATE_PARAMETER_NAME = "Ts";
	protected static final String SAMPLE_RATE_TEMPLATE_PARAMETER_NAME = "fs";
	
	private Block block;
	
	/**
	 * 
	 */
	public BehavioredBlockHelper(Block block) {
		this.block = block;
	}
	
	public FunctionDescriptor constructFunctionDescriptor() throws CoreException {
		if (!(block.getType().getBehavior() instanceof OpaqueBehaviorSpecification)) {
			throw new CoreException(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Invalid block behavior specified"));
		}

		OpaqueBehaviorSpecification behavior = (OpaqueBehaviorSpecification) block.getType().getBehavior();

		if (StringUtils.isBlank(behavior.getBehavior())) {
			throw new CoreException(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "No block behavior specified"));
		}

		MscriptParser parser = ExecutionEnginePlugin.getDefault().getMscriptParser();

		IParseResult parseResult = parser.parse(parser.getGrammarAccess().getModuleRule().getName(),
				new StringReader(behavior.getBehavior()));

		if (!parseResult.getParseErrors().isEmpty()) {
			throw new CoreException(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Parsing block behavior failed"));
		}

		Module module = (Module) parseResult.getRootASTElement();
		FunctionDefinition functionDefinition = LanguageUtil.getFunctionDefinition(module, block.getType().getName());
		if (functionDefinition == null) {
			throw new CoreException(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Mscript function '" + block.getType().getName() + "' not found"));
		}

		IFunctionDescriptorConstructorResult functionDescriptorConstructorResult = new FunctionDescriptorConstructor()
				.construct(functionDefinition);

		if (!functionDescriptorConstructorResult.getStatus().isOK()) {
			throw new CoreException(functionDescriptorConstructorResult.getStatus());
		}
		
		return functionDescriptorConstructorResult.getFunctionDescriptor();
	}

	public List<IValue> getTemplateArguments(FunctionDefinition functionDefinition, MultiStatus status) {
		List<IValue> templateArguments = new ArrayList<IValue>();
		for (ParameterDeclaration parameterDeclaration : functionDefinition.getTemplateParameterDeclarations()) {
			String parameterName = parameterDeclaration.getName();
			String argument = block.getArgumentStringValue(parameterName);
			if (argument == null) {
				IValue globalTemplateArgumentValue = getGlobalTemplateArgument(parameterName);
				if (globalTemplateArgumentValue != null) {
					templateArguments.add(globalTemplateArgumentValue);
				} else {
					status.add(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Block parameter '" + parameterDeclaration.getName() + "' not found"));
				}
				continue;
			}

			MscriptParser parser = ExecutionEnginePlugin.getDefault().getMscriptParser();

			IParseResult parseResult = parser.parse(parser.getGrammarAccess().getExpressionRule().getName(),
					new StringReader(argument));
			
			if (!parseResult.getParseErrors().isEmpty()) {
				status.add(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Parsing block parameter '" + parameterDeclaration.getName() + "' failed"));
				continue;
			}

			ITransformerContext transformerContext = new TransformerContext();
			IInterpreterContext interpreterContext = new InterpreterContext(new ComputationContext());

			ExpressionInterpreterHelper expressionInterpreterHelper = new ExpressionInterpreterHelper(transformerContext,
					interpreterContext, (Expression) parseResult.getRootASTElement());
			
			try {
				IValue value = expressionInterpreterHelper.evaluateSingle();
				templateArguments.add(value);
			} catch (CoreException e) {
				status.add(e.getStatus());
			}
		}
		return templateArguments;
	}

	public List<DataType> getInputParameterDataTypes(FunctionDefinition functionDefinition, IComponentSignature signature, MultiStatus status) {
		List<DataType> dataTypes = new ArrayList<DataType>();
		for (ParameterDeclaration parameterDeclaration : functionDefinition.getInputParameterDeclarations()) {
			BlockInput input = (BlockInput) block.getInput(parameterDeclaration.getName());
			if (input == null) {
				status.add(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Input '" + parameterDeclaration.getName() + "' not found"));
				continue;
			}

			if (input.getDefinition().isManyPorts() || input.getDefinition().getMinimumPortCount() == 0) {
				DataType elementDataType = null;
				for (InputPort inputPort : input.getPorts()) {
					DataType dataType = signature.getInputDataType(inputPort);
					if (dataType != null) {
						if (elementDataType == null) {
							elementDataType = dataType;
						} else {
							elementDataType = TypeSystemUtil.getLeftHandDataType(elementDataType, dataType);
							if (elementDataType == null) {
								status.add(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Input '" + parameterDeclaration.getName() + "' has incompatible input values"));
								continue;
							}
						}
					}
				}
				if (elementDataType == null) {
					return null;
				}
				dataTypes.add(TypeSystemUtil.createArrayType(elementDataType, input.getPorts().size()));
			} else {
				DataType dataType = null;
				if (input.getPorts().isEmpty()) {
					status.add(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Invalid input '" + parameterDeclaration.getName() + "'"));
					continue;
				}
				dataType = signature.getInputDataType(input.getPorts().get(0));
				if (dataType == null) {
					return null;
				}
				dataTypes.add(dataType);
			}
		}
		return dataTypes;
	}
	
	protected IValue getGlobalTemplateArgument(String name) {
		return null;
	}

}
