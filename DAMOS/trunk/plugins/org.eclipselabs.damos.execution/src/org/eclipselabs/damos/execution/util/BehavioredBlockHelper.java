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

package org.eclipselabs.damos.execution.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.dml.Argument;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockInput;
import org.eclipselabs.damos.dml.BlockInputPort;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.Parameter;
import org.eclipselabs.damos.dml.ValueSpecification;
import org.eclipselabs.damos.dmltext.MscriptBlockType;
import org.eclipselabs.damos.dmltext.MscriptValueSpecification;
import org.eclipselabs.damos.execution.ExecutionCorePlugin;
import org.eclipselabs.damos.execution.IComponentSignature;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.FunctionDeclaration;
import org.eclipselabs.damos.mscript.InputParameterDeclaration;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.ParameterDeclaration;
import org.eclipselabs.damos.mscript.TensorType;
import org.eclipselabs.damos.mscript.interpreter.ComputationContext;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationContext;
import org.eclipselabs.damos.mscript.interpreter.StaticExpressionEvaluator;
import org.eclipselabs.damos.mscript.interpreter.StaticFunctionEvaluator;
import org.eclipselabs.damos.mscript.interpreter.value.AnyValue;
import org.eclipselabs.damos.mscript.interpreter.value.ArrayValue;
import org.eclipselabs.damos.mscript.interpreter.value.INumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.VectorValue;
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

	private final IStaticEvaluationContext staticEvaluationContext;
	private final Block block;
	
	private final StaticExpressionEvaluator staticExpressionEvaluator = new StaticExpressionEvaluator();
	private final StaticFunctionEvaluator staticFunctionEvaluator = new StaticFunctionEvaluator();
	
	/**
	 * 
	 */
	public BehavioredBlockHelper(IStaticEvaluationContext staticEvaluationContext, Block block) {
		this.staticEvaluationContext = staticEvaluationContext;
		this.block = block;
	}
	
	/**
	 * @return the staticEvaluationContext
	 */
	public IStaticEvaluationContext getStaticEvaluationContext() {
		return staticEvaluationContext;
	}
	
	public IStatus getStatus() {
		return multiStatus;
	}
	
	public FunctionDeclaration createFunctionDefinition() throws CoreException {
		MscriptBlockType blockType = (MscriptBlockType) block.getType();
		FunctionDeclaration functionDeclaration = MscriptUtil.getFunctionDefinition(blockType.getDeclarations(), "main");
		if (functionDeclaration == null) {
			throw new CoreException(new Status(IStatus.ERROR, ExecutionCorePlugin.PLUGIN_ID, "Mscript function 'main' not found"));
		}
		
		return functionDeclaration;
	}

	public void evaluateFunctionDefinition(FunctionDeclaration functionDeclaration, List<IValue> templateArguments, List<DataType> inputParameterDataTypes) throws CoreException {
		multiStatus = new MultiStatus(ExecutionCorePlugin.PLUGIN_ID, 0, "", null);
		
		if (multiStatus.getSeverity() > IStatus.WARNING) {
			throw new CoreException(multiStatus);
		}
		
		Iterator<IValue> templateArgumentIt = templateArguments.iterator();
		for (ParameterDeclaration parameterDeclaration : functionDeclaration.getTemplateParameterDeclarations()) {
			staticEvaluationContext.setValue(parameterDeclaration, templateArgumentIt.next());
		}

		Iterator<DataType> inputParameterDataTypeIt = inputParameterDataTypes.iterator();
		for (ParameterDeclaration parameterDeclaration : functionDeclaration.getInputParameterDeclarations()) {
			staticEvaluationContext.setValue(parameterDeclaration, new AnyValue(new ComputationContext(), inputParameterDataTypeIt.next()));
		}

		IStatus status = staticFunctionEvaluator.evaluate(staticEvaluationContext, functionDeclaration);
		if (status.getSeverity() > IStatus.WARNING) {
			throw new CoreException(status);
		}
		
		if (!status.isOK()) {
			multiStatus.merge(status);
		}
	}

	public List<IValue> getTemplateArguments(FunctionDeclaration functionDeclaration, MultiStatus status) {
		List<IValue> templateArguments = new ArrayList<IValue>();
		for (ParameterDeclaration parameterDeclaration : functionDeclaration.getTemplateParameterDeclarations()) {
			String parameterName = parameterDeclaration.getName();
			try {
				IValue value = getParameterTemplateArgumentValue(parameterName);
				if (value == null) {
					value = getInputTemplateArgumentValue(parameterName);
				}
				if (value == null) {
					value = getGlobalTemplateArgumentValue(parameterName);
				}
				if (value != null) {
					templateArguments.add(value);
				} else {
					status.add(new Status(IStatus.ERROR, ExecutionCorePlugin.PLUGIN_ID, "Block parameter '"
							+ parameterName + "' not found"));
				}
			} catch (CoreException e) {
				status.add(e.getStatus());
			}
		}
		return templateArguments;
	}

	public List<DataType> getInputParameterDataTypes(FunctionDeclaration functionDeclaration, IComponentSignature signature, MultiStatus status) {
		List<DataType> dataTypes = new ArrayList<DataType>();

		if (!block.getInputSockets().isEmpty()) {
			IntegerType messageKindDataType = MscriptFactory.eINSTANCE.createIntegerType();
			messageKindDataType.setUnit(TypeUtil.createUnit());
			dataTypes.add(messageKindDataType);
		}
		
		Iterator<InputParameterDeclaration> parameterDeclarationIterator = functionDeclaration.getInputParameterDeclarations().iterator();
		for (Input input : block.getInputs()) {
			BlockInput blockInput = (BlockInput) input;
			
			if (!parameterDeclarationIterator.hasNext()) {
				status.add(new Status(IStatus.ERROR, ExecutionCorePlugin.PLUGIN_ID, "No input parameter found for input '" + blockInput.getDefinition().getName() + "'"));
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
								status.add(new Status(IStatus.ERROR, ExecutionCorePlugin.PLUGIN_ID, "Input '" + parameterDeclaration.getName() + "' has incompatible input values"));
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
					status.add(new Status(IStatus.ERROR, ExecutionCorePlugin.PLUGIN_ID, "Invalid input '" + parameterDeclaration.getName() + "'"));
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
	
	private IValue getParameterTemplateArgumentValue(String parameterName) throws CoreException {
		Argument argument = block.getArgument(parameterName);
		if (argument != null) {
			return evaluateParameterValue(argument.getParameter(), argument.getValue());
		}
		if (block.getType() != null) {
			Parameter parameter = block.getType().getParameter(parameterName);
			if (parameter != null) {
				return evaluateParameterValue(parameter, parameter.getDefaultValue());
			}
		}
		return null;
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
						throw new CoreException(new Status(IStatus.ERROR, ExecutionCorePlugin.PLUGIN_ID, "No argument for input parameter '" + name + "' found"));
					}
					IValue value = evaluateParameterValue(argument.getParameter(), argument.getValue());
					if (elementType == null) {
						elementType = value.getDataType();
					} else {
						elementType = TypeUtil.getLeftHandDataType(elementType, value.getDataType());
						if (elementType == null) {
							throw new CoreException(new Status(IStatus.ERROR, ExecutionCorePlugin.PLUGIN_ID, "Argument values of input parameter '" + name + "' have incompatible data types"));
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
	
	protected IValue getGlobalTemplateArgumentValue(String name) throws CoreException {
		return null;
	}
	
	private IValue evaluateParameterValue(Parameter parameter, ValueSpecification valueSpecification) throws CoreException {
		if (valueSpecification instanceof MscriptValueSpecification) {
			Expression expression = ((MscriptValueSpecification) valueSpecification).getExpression();
			IStatus status = staticExpressionEvaluator.evaluate(staticEvaluationContext, expression);
			if (status.getSeverity() > IStatus.WARNING) {
				throw new CoreException(status);
			}
			return staticEvaluationContext.getValue(expression);
		}
		throw new CoreException(new Status(IStatus.ERROR, ExecutionCorePlugin.PLUGIN_ID, "Argument value of parameter '" + parameter.getName() + "' must be an expression"));
	}

}
