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

package org.eclipse.damos.execution.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.damos.dml.Argument;
import org.eclipse.damos.dml.Block;
import org.eclipse.damos.dml.BlockInput;
import org.eclipse.damos.dml.BlockOutput;
import org.eclipse.damos.dml.BlockPort;
import org.eclipse.damos.dml.BlockType;
import org.eclipse.damos.dml.InoutputDefinition;
import org.eclipse.damos.dml.Input;
import org.eclipse.damos.dml.InputDefinition;
import org.eclipse.damos.dml.InputPort;
import org.eclipse.damos.dml.OutputDefinition;
import org.eclipse.damos.dml.Parameter;
import org.eclipse.damos.dml.Port;
import org.eclipse.damos.dml.ValueSpecification;
import org.eclipse.damos.dscript.BehaviorDeclaration;
import org.eclipse.damos.dscript.DscriptBlockType;
import org.eclipse.damos.dscript.DscriptValueSpecification;
import org.eclipse.damos.execution.datatype.IComponentSignature;
import org.eclipse.damos.execution.internal.ExecutionPlugin;
import org.eclipse.damos.mscript.AnonymousTypeSpecifier;
import org.eclipse.damos.mscript.ArrayType;
import org.eclipse.damos.mscript.CompositeTypeMember;
import org.eclipse.damos.mscript.CompositeTypeMemberList;
import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.FunctionDeclaration;
import org.eclipse.damos.mscript.InputParameterDeclaration;
import org.eclipse.damos.mscript.MscriptFactory;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.UnionType;
import org.eclipse.damos.mscript.interpreter.ComputationContext;
import org.eclipse.damos.mscript.interpreter.ExpressionEvaluator;
import org.eclipse.damos.mscript.interpreter.FunctionParameter;
import org.eclipse.damos.mscript.interpreter.FunctionSignature;
import org.eclipse.damos.mscript.interpreter.IExpressionEvaluator;
import org.eclipse.damos.mscript.interpreter.IStaticEvaluationResult;
import org.eclipse.damos.mscript.interpreter.StaticEvaluationContext;
import org.eclipse.damos.mscript.interpreter.StaticEvaluationResult;
import org.eclipse.damos.mscript.interpreter.StaticExpressionEvaluationContext;
import org.eclipse.damos.mscript.interpreter.StaticFunctionEvaluator;
import org.eclipse.damos.mscript.interpreter.TypeFunctionParameter;
import org.eclipse.damos.mscript.interpreter.ValueFunctionParameter;
import org.eclipse.damos.mscript.interpreter.value.AnyValue;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.mscript.interpreter.value.InvalidValue;
import org.eclipse.damos.mscript.interpreter.value.VectorValue;
import org.eclipse.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class DscriptBlockHelper {

	private final Block block;
	
	private final IExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
	private final StaticFunctionEvaluator staticFunctionEvaluator = new StaticFunctionEvaluator();
	
	/**
	 * 
	 */
	public DscriptBlockHelper(Block block) {
		this.block = block;
	}
	
	/**
	 * @return the block
	 */
	public Block getBlock() {
		return block;
	}
	
	public BehaviorDeclaration getBehavior() throws CoreException {
		DscriptBlockType blockType = (DscriptBlockType) block.getType();
		BehaviorDeclaration behavior = blockType.getBehavior();
		if (behavior == null) {
			throw new CoreException(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "No behavior specified"));
		}
		
		return behavior;
	}

	public void evaluateFunctionDeclaration(IStaticEvaluationResult staticEvaluationResult, FunctionDeclaration functionDeclaration, FunctionSignature functionSignature) {
		Iterator<InputParameterDeclaration> it = functionDeclaration.getInputParameterDeclarations().iterator();
		for (FunctionParameter parameter : functionSignature.getParameters()) {
			if (parameter instanceof TypeFunctionParameter) {
				staticEvaluationResult.setValue(it.next(), new AnyValue(new ComputationContext(), ((TypeFunctionParameter) parameter).getType()));
			} else if (parameter instanceof ValueFunctionParameter) {
				staticEvaluationResult.setValue(it.next(), ((ValueFunctionParameter) parameter).getValue());
			} else {
				throw new IllegalStateException();
			}
		}
		staticFunctionEvaluator.evaluate(new StaticEvaluationContext(staticEvaluationResult), functionDeclaration);
	}

	public FunctionSignature getFunctionSignature(FunctionDeclaration functionDeclaration, IComponentSignature componentSignature, MultiStatus status) {
		List<FunctionParameter> parameters = new ArrayList<FunctionParameter>();
		if (!getInputParameterDataTypes(componentSignature, parameters, status)) {
			return null;
		}
		if (!getFunctionParameters(parameters, status)) {
			return null;
		}
		return FunctionSignature.create(functionDeclaration, parameters);
	}

	private boolean getInputParameterDataTypes(IComponentSignature signature, List<FunctionParameter> functionParameters, MultiStatus status) {
		Iterator<InputDefinition> parameterDeclarationIterator = getBlock().getType().getInputDefinitions().iterator();

		if (!block.getInputSockets().isEmpty()) {
			if (!parameterDeclarationIterator.hasNext()) {
				status.add(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "No input parameter found for socket inputs"));
				return false;
			}

			parameterDeclarationIterator.next();
			
			UnionType messageType = MscriptFactory.eINSTANCE.createUnionType();
			for (Input input : block.getInputSockets()) {
				BlockInput blockInput = (BlockInput) input;

				Type type = getInputParameterDataType(blockInput, signature, status);
				if (type == null) {
					return false;
				}
				
				CompositeTypeMember member = MscriptFactory.eINSTANCE.createCompositeTypeMember();
				member.setName(input.getName());
				
				CompositeTypeMemberList memberList = MscriptFactory.eINSTANCE.createCompositeTypeMemberList();
				AnonymousTypeSpecifier typeSpecifier = MscriptFactory.eINSTANCE.createAnonymousTypeSpecifier();
				typeSpecifier.setType(type);
				memberList.setTypeSpecifier(typeSpecifier);
				memberList.getMembers().add(member);
				
				messageType.getMemberLists().add(memberList);
			}
			functionParameters.add(FunctionParameter.create(messageType));
		}
		
		for (Input input : block.getInputs()) {
			if (input.isSocket()) {
				continue;
			}
			
			BlockInput blockInput = (BlockInput) input;

			if (!parameterDeclarationIterator.hasNext()) {
				status.add(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "No input parameter found for input '" + blockInput.getDefinition().getName() + "'"));
				return false;
			}

			parameterDeclarationIterator.next();

			Type type = getInputParameterDataType(blockInput, signature, status);
			if (type == null) {
				return false;
			}
			functionParameters.add(FunctionParameter.create(type));
		}
		return true;
	}

	public List<Type> getInputParameterDataTypes(FunctionDeclaration functionDeclaration, IComponentSignature signature, MultiStatus status) {
		List<Type> types = new ArrayList<Type>();

		Iterator<InputParameterDeclaration> parameterDeclarationIterator = functionDeclaration.getNonConstantInputParameterDeclarations().iterator();

		if (!block.getInputSockets().isEmpty()) {
			if (!parameterDeclarationIterator.hasNext()) {
				status.add(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "No input parameter found for socket inputs"));
				return null;
			}

			parameterDeclarationIterator.next();
			
			UnionType messageType = MscriptFactory.eINSTANCE.createUnionType();
			for (Input input : block.getInputSockets()) {
				BlockInput blockInput = (BlockInput) input;

				Type type = getInputParameterDataType(blockInput, signature, status);
				if (type == null) {
					return null;
				}
				
				CompositeTypeMember member = MscriptFactory.eINSTANCE.createCompositeTypeMember();
				member.setName(input.getName());
				
				CompositeTypeMemberList memberList = MscriptFactory.eINSTANCE.createCompositeTypeMemberList();
				AnonymousTypeSpecifier typeSpecifier = MscriptFactory.eINSTANCE.createAnonymousTypeSpecifier();
				typeSpecifier.setType(type);
				memberList.setTypeSpecifier(typeSpecifier);
				memberList.getMembers().add(member);
				
				messageType.getMemberLists().add(memberList);
			}
			types.add(messageType);
		}
		
		for (Input input : block.getInputs()) {
			if (input.isSocket()) {
				continue;
			}
			
			BlockInput blockInput = (BlockInput) input;

			if (!parameterDeclarationIterator.hasNext()) {
				status.add(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "No input parameter found for input '" + blockInput.getDefinition().getName() + "'"));
				return null;
			}

			parameterDeclarationIterator.next();

			Type type = getInputParameterDataType(blockInput, signature, status);
			if (type == null) {
				return null;
			}
			types.add(type);
		}
		return types;
	}
	
	private Type getInputParameterDataType(BlockInput blockInput, IComponentSignature signature, MultiStatus status) {
		if (blockInput.getDefinition().isManyPorts() || blockInput.getDefinition().getMinimumPortCount() == 0) {
			Type elementDataType = null;
			for (InputPort inputPort : blockInput.getPorts()) {
				Type type = signature.getInputDataType(inputPort);
				if (type != null) {
					if (elementDataType == null) {
						elementDataType = type;
					} else {
						elementDataType = TypeUtil.getLeftHandDataType(elementDataType, type);
						if (elementDataType == null) {
							status.add(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "Input '" + blockInput.getName() + "' has incompatible input values"));
							continue;
						}
					}
				}
			}
			if (elementDataType == null) {
				return null;
			}
			return TypeUtil.createArrayType(elementDataType, blockInput.getPorts().size());
		}

		if (blockInput.getPorts().isEmpty()) {
			status.add(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "Invalid input '" + blockInput.getName() + "'"));
			return null;
		}
		return signature.getInputDataType(blockInput.getPorts().get(0));
	}
	
	private boolean getFunctionParameters(List<FunctionParameter> functionParameters, MultiStatus status) {
		boolean result = true;
		BlockType blockType = getBlock().getType();
		for (InputDefinition inputDefinition : blockType.getInputDefinitions()) {
			BlockInput input = getBlock().getInput(inputDefinition);
			if (input != null) {
				try {
					getArgumentValues(inputDefinition, input.getPorts(), functionParameters);
				} catch (CoreException e) {
					result = false;
					status.add(e.getStatus());
				}
			} else {
				status.add(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "Input '" + inputDefinition.getName() + "' not found"));
			}
		}
		for (OutputDefinition outputDefinition : blockType.getOutputDefinitions()) {
			BlockOutput output = getBlock().getOutput(outputDefinition);
			if (output != null) {
				try {
					getArgumentValues(outputDefinition, output.getPorts(), functionParameters);
				} catch (CoreException e) {
					result = false;
					status.add(e.getStatus());
				}
			} else {
				status.add(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "Output '" + outputDefinition.getName() + "' not found"));
			}
		}
		for (Parameter parameter : blockType.getParameters()) {
			try {
				functionParameters.add(FunctionParameter.create(getArgumentValue(parameter)));
			} catch (CoreException e) {
				result = false;
				status.add(e.getStatus());
			}
		}
		return result;
	}
	
	private void getArgumentValues(InoutputDefinition inoutputDefinition, List<? extends Port> ports, List<FunctionParameter> functionParameters) throws CoreException {
		for (Parameter parameter : inoutputDefinition.getParameters()) {
			if (inoutputDefinition.isManyPorts()) {
				Type elementType = null;
				List<IValue> values = new ArrayList<IValue>(ports.size());
				for (Port inputPort : ports) {
					BlockPort blockInputPort = (BlockPort) inputPort;
					Argument argument = blockInputPort.getArgument(parameter);
					if (argument == null) {
						throw new CoreException(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "No argument for parameter '" + parameter.getName() + "' found"));
					}
					IValue value = evaluateParameterValue(argument.getParameter(), argument.getValue());
					if (elementType == null) {
						elementType = value.getDataType();
					} else {
						elementType = TypeUtil.getLeftHandDataType(elementType, value.getDataType());
						if (elementType == null) {
							throw new CoreException(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "Argument values of parameter '" + parameter.getName() + "' have incompatible data types"));
						}
					}
					values.add(value);
				}
				ArrayType arrayType = TypeUtil.createArrayType(elementType, values.size());
				VectorValue value = new VectorValue(new ComputationContext(), arrayType, values.toArray(new IValue[values.size()]));
				functionParameters.add(FunctionParameter.create(value));
			} else {
				// TODO
				throw new CoreException(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "Single port parameters not supported"));
			}
		}
	}
	
	private IValue getArgumentValue(Parameter parameter) throws CoreException {
		Argument argument = block.getArgument(parameter);
		if (argument != null) {
			return evaluateParameterValue(parameter, argument.getValue());
		}
		if (block.getType() != null) {
			return evaluateParameterValue(parameter, parameter.getDefaultValue());
		}
		return null;
	}
	
	private IValue evaluateParameterValue(Parameter parameter, ValueSpecification valueSpecification) throws CoreException {
		if (valueSpecification instanceof DscriptValueSpecification) {
			Expression expression = ((DscriptValueSpecification) valueSpecification).getExpression();
			IStaticEvaluationResult result = new StaticEvaluationResult();
			IValue value = expressionEvaluator.evaluate(new StaticExpressionEvaluationContext(new StaticEvaluationContext(result)), expression);
			if (result.getStatus().getSeverity() > IStatus.WARNING) {
				throw new CoreException(result.getStatus());
			}
			if (value instanceof InvalidValue) {
				throw new CoreException(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "Argument value of parameter '" + parameter.getName() + "' is invalid"));
			}
			return value;
		}
		throw new CoreException(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "Argument value of parameter '" + parameter.getName() + "' must be an expression"));
	}

}
