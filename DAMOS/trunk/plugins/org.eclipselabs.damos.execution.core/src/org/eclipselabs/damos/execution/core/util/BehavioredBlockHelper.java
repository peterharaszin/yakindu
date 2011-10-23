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

package org.eclipselabs.damos.execution.core.util;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.impl.ListBasedDiagnosticConsumer;
import org.eclipselabs.damos.dml.Argument;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockInput;
import org.eclipselabs.damos.dml.BlockInputPort;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OpaqueBehaviorSpecification;
import org.eclipselabs.damos.dmltext.MscriptBehaviorSpecification;
import org.eclipselabs.damos.dmltext.MscriptValueSpecification;
import org.eclipselabs.damos.execution.core.ExecutionEnginePlugin;
import org.eclipselabs.damos.execution.core.IComponentSignature;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.FunctionDefinition;
import org.eclipselabs.damos.mscript.InputParameterDeclaration;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.Module;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.ParameterDeclaration;
import org.eclipselabs.damos.mscript.TensorType;
import org.eclipselabs.damos.mscript.interpreter.ComputationContext;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationContext;
import org.eclipselabs.damos.mscript.interpreter.StaticEvaluationContext;
import org.eclipselabs.damos.mscript.interpreter.StaticFunctionEvaluator;
import org.eclipselabs.damos.mscript.interpreter.value.AnyValue;
import org.eclipselabs.damos.mscript.interpreter.value.ArrayValue;
import org.eclipselabs.damos.mscript.interpreter.value.INumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.VectorValue;
import org.eclipselabs.damos.mscript.parser.antlr.MscriptParser;
import org.eclipselabs.damos.mscript.util.MscriptUtil;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class BehavioredBlockHelper {

	protected static final String SAMPLE_TIME_TEMPLATE_PARAMETER_NAME = "Ts";
	protected static final String SAMPLE_RATE_TEMPLATE_PARAMETER_NAME = "fs";
	
	private MultiStatus multiStatus;

	private Block block;
	
	/**
	 * 
	 */
	public BehavioredBlockHelper(Block block) {
		this.block = block;
	}
	
	public IStatus getStatus() {
		return multiStatus;
	}
	
	public FunctionDefinition createFunctionDefinition() throws CoreException {
		Module module;
		if (block.getType().getBehavior() instanceof MscriptBehaviorSpecification) {
			module = ((MscriptBehaviorSpecification) block.getType().getBehavior()).getModule();
		} else {
			if (!(block.getType().getBehavior() instanceof OpaqueBehaviorSpecification)) {
				throw new CoreException(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Invalid block behavior specified"));
			}
	
			OpaqueBehaviorSpecification behavior = (OpaqueBehaviorSpecification) block.getType().getBehavior();
	
			if (behavior.getModel() == null) {
				if (behavior.getBehavior() == null) {
					throw new CoreException(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "No block behavior specified"));
				}
		
				MscriptParser parser = ExecutionEnginePlugin.getDefault().getMscriptParser();
	
				IParseResult parseResult = parser.parse(parser.getGrammarAccess().getModuleRule(),
						new StringReader(behavior.getBehavior()));
	
				if (parseResult.hasSyntaxErrors()) {
					throw new CoreException(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Parsing block behavior failed"));
				}
	
				behavior.setModel((Module) parseResult.getRootASTElement());
				
				ILinker linker = ExecutionEnginePlugin.getDefault().getLinker();
				linker.linkModel(behavior.getModel(), new ListBasedDiagnosticConsumer());
			}
	
			if (!(behavior.getModel() instanceof Module)) {
				throw new CoreException(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Invalid block behavior model"));
			}
	
			module = (Module) behavior.getModel();
		}

		FunctionDefinition functionDefinition = MscriptUtil.getFunctionDefinition(module, "main");
		// TODO: Remove this, since the starting function must always be 'main'
		if (functionDefinition == null) {
			functionDefinition = MscriptUtil.getFunctionDefinition(module, block.getType().getName());
		}
		if (functionDefinition == null) {
			throw new CoreException(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Mscript function 'main' not found"));
		}
		
		return functionDefinition;
	}

	public IStaticEvaluationContext createStaticEvaluationContext(FunctionDefinition functionDefinition, List<IValue> templateArguments, List<DataType> inputParameterDataTypes) throws CoreException {
		multiStatus = new MultiStatus(ExecutionEnginePlugin.PLUGIN_ID, 0, "", null);
		
		if (multiStatus.getSeverity() > IStatus.WARNING) {
			throw new CoreException(multiStatus);
		}
		
		IStaticEvaluationContext staticEvaluationContext = new StaticEvaluationContext();

		Iterator<IValue> templateArgumentIt = templateArguments.iterator();
		for (ParameterDeclaration parameterDeclaration : functionDefinition.getTemplateParameterDeclarations()) {
			staticEvaluationContext.setValue(parameterDeclaration, templateArgumentIt.next());
		}

		Iterator<DataType> inputParameterDataTypeIt = inputParameterDataTypes.iterator();
		for (ParameterDeclaration parameterDeclaration : functionDefinition.getInputParameterDeclarations()) {
			staticEvaluationContext.setValue(parameterDeclaration, new AnyValue(new ComputationContext(), inputParameterDataTypeIt.next()));
		}

		IStatus status = new StaticFunctionEvaluator().evaluate(staticEvaluationContext, functionDefinition);
		if (status.getSeverity() > IStatus.WARNING) {
			throw new CoreException(status);
		}
		
		if (!status.isOK()) {
			multiStatus.merge(status);
		}

		return staticEvaluationContext;
	}

	public List<IValue> getTemplateArguments(FunctionDefinition functionDefinition, MultiStatus status) {
		List<IValue> templateArguments = new ArrayList<IValue>();
		for (ParameterDeclaration parameterDeclaration : functionDefinition.getTemplateParameterDeclarations()) {
			String parameterName = parameterDeclaration.getName();
			Argument argument = block.getArgument(parameterName);
			if (argument == null) {
				try {
					IValue templateArgument = getInputTemplateArgumentValue(parameterName);
					if (templateArgument == null) {
						templateArgument = getGlobalTemplateArgument(parameterName);
					}
					if (templateArgument != null) {
						templateArguments.add(templateArgument);
					} else {
						status.add(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Block parameter '" + parameterDeclaration.getName() + "' not found"));
					}
				} catch (CoreException e) {
					status.add(e.getStatus());
				}
				continue;
			}

			try {
				IValue value = evaluateArgumentValue(argument);
				templateArguments.add(value);
			} catch (CoreException e) {
				status.add(e.getStatus());
			}
		}
		return templateArguments;
	}

	public List<DataType> getInputParameterDataTypes(FunctionDefinition functionDefinition, IComponentSignature signature, MultiStatus status) {
		List<DataType> dataTypes = new ArrayList<DataType>();

		if (!block.getInputSockets().isEmpty()) {
			IntegerType messageKindDataType = MscriptFactory.eINSTANCE.createIntegerType();
			messageKindDataType.setUnit(TypeUtil.createUnit());
			dataTypes.add(messageKindDataType);
		}
		
		Iterator<InputParameterDeclaration> parameterDeclarationIterator = functionDefinition.getInputParameterDeclarations().iterator();
		for (Input input : block.getInputs()) {
			BlockInput blockInput = (BlockInput) input;
			
			if (!parameterDeclarationIterator.hasNext()) {
				status.add(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "No input parameter found for input '" + blockInput.getDefinition().getName() + "'"));
				return null;
			}

			ParameterDeclaration parameterDeclaration = parameterDeclarationIterator.next();
			
			if (blockInput.getDefinition().isManyPorts() || blockInput.getDefinition().getMinimumPortCount() == 0) {
				DataType elementDataType = null;
				for (InputPort inputPort : input.getPorts()) {
					DataType dataType = signature.getInputDataType(inputPort);
					if (dataType != null) {
						if (elementDataType == null) {
							elementDataType = dataType;
						} else {
							elementDataType = TypeUtil.getLeftHandDataType(elementDataType, dataType);
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
				dataTypes.add(TypeUtil.createArrayType(elementDataType, input.getPorts().size()));
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
	
	private IValue getInputTemplateArgumentValue(String name) throws CoreException {
		for (Input input : block.getInputs()) {
			BlockInput blockInput = (BlockInput) input;
			if (blockInput.getDefinition().isManyPorts() && blockInput.getDefinition().getParameter(name) != null) {
				DataType elementType = null;
				List<IValue> values = new ArrayList<IValue>(blockInput.getPorts().size());
				for (InputPort inputPort : blockInput.getPorts()) {
					BlockInputPort blockInputPort = (BlockInputPort) inputPort;
					Argument argument = blockInputPort.getArgument(name);
					if (argument == null) {
						throw new CoreException(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "No argument for input parameter '" + name + "' found"));
					}
					IValue value = evaluateArgumentValue(argument);
					if (elementType == null) {
						elementType = value.getDataType();
					} else {
						elementType = TypeUtil.getLeftHandDataType(elementType, value.getDataType());
						if (elementType == null) {
							throw new CoreException(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Argument values of input parameter '" + name + "' have incompatible data types"));
						}
					}
					values.add(value);
				}
				ArrayType arrayType = TypeUtil.createArrayType(elementType, values.size());
				if (arrayType instanceof TensorType) {
					return new VectorValue(new ComputationContext(), (TensorType) arrayType, values.toArray(new INumericValue[values.size()]));
				}
				return new ArrayValue(new ComputationContext(), arrayType, values.toArray(new IValue[values.size()]));
			}
		}
		return null;
	}
	
	protected IValue getGlobalTemplateArgument(String name) throws CoreException {
		return null;
	}
	
	private IValue evaluateArgumentValue(Argument argument) throws CoreException {
		if (argument.getValue() instanceof MscriptValueSpecification) {
			return ExpressionUtil.evaluateExpression(((MscriptValueSpecification) argument.getValue()).getExpression());
		}
		return ExpressionUtil.evaluateExpression(argument.getValue().stringValue());
	}

}
