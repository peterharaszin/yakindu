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
import org.eclipselabs.damos.execution.datatype.IComponentSignature;
import org.eclipselabs.damos.execution.internal.ExecutionPlugin;
import org.eclipselabs.damos.mscript.AnonymousTypeSpecifier;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.CompositeTypeMember;
import org.eclipselabs.damos.mscript.CompositeTypeMemberList;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.FunctionDeclaration;
import org.eclipselabs.damos.mscript.InputParameterDeclaration;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.ParameterDeclaration;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.UnionType;
import org.eclipselabs.damos.mscript.interpreter.ComputationContext;
import org.eclipselabs.damos.mscript.interpreter.ExpressionEvaluator;
import org.eclipselabs.damos.mscript.interpreter.IExpressionEvaluator;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationResult;
import org.eclipselabs.damos.mscript.interpreter.StaticEvaluationResult;
import org.eclipselabs.damos.mscript.interpreter.StaticExpressionEvaluationContext;
import org.eclipselabs.damos.mscript.interpreter.StaticFunctionEvaluator;
import org.eclipselabs.damos.mscript.interpreter.value.AnyValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.InvalidValue;
import org.eclipselabs.damos.mscript.interpreter.value.VectorValue;
import org.eclipselabs.damos.mscript.util.MscriptUtil;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class BehavioredBlockHelper {

	protected static final String SAMPLE_TIME_STATIC_PARAMETER_NAME = "Ts";
	protected static final String SAMPLE_RATE_STATIC_PARAMETER_NAME = "fs";
	
	private final Block block;
	
	private final IExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
	private final StaticFunctionEvaluator staticFunctionEvaluator = new StaticFunctionEvaluator();
	
	/**
	 * 
	 */
	public BehavioredBlockHelper(Block block) {
		this.block = block;
	}
	
	/**
	 * @return the block
	 */
	public Block getBlock() {
		return block;
	}
	
	public FunctionDeclaration createFunctionDefinition() throws CoreException {
		MscriptBlockType blockType = (MscriptBlockType) block.getType();
		FunctionDeclaration functionDeclaration = MscriptUtil.getFunctionDefinition(blockType.getDeclarations(), "main");
		if (functionDeclaration == null) {
			throw new CoreException(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "Mscript function 'main' not found"));
		}
		
		return functionDeclaration;
	}

	public void evaluateFunctionDefinition(IStaticEvaluationResult staticEvaluationResult, FunctionDeclaration functionDeclaration, List<IValue> staticArguments, List<Type> inputParameterDataTypes) {
		Iterator<IValue> staticArgumentIt = staticArguments.iterator();
		for (ParameterDeclaration parameterDeclaration : functionDeclaration.getConstantInputParameterDeclarations()) {
			staticEvaluationResult.setValue(parameterDeclaration, staticArgumentIt.next());
		}

		Iterator<Type> inputParameterDataTypeIt = inputParameterDataTypes.iterator();
		for (ParameterDeclaration parameterDeclaration : functionDeclaration.getNonConstantInputParameterDeclarations()) {
			staticEvaluationResult.setValue(parameterDeclaration, new AnyValue(new ComputationContext(), inputParameterDataTypeIt.next()));
		}

		staticFunctionEvaluator.evaluate(staticEvaluationResult, functionDeclaration);
	}

	public List<IValue> getStaticArguments(FunctionDeclaration functionDeclaration, MultiStatus status) {
		List<IValue> staticArguments = new ArrayList<IValue>();
		for (ParameterDeclaration parameterDeclaration : functionDeclaration.getConstantInputParameterDeclarations()) {
			String parameterName = parameterDeclaration.getName();
			try {
				IValue value = getParameterStaticArgumentValue(parameterName);
				if (value == null) {
					value = getInputStaticArgumentValue(parameterName);
				}
				if (value == null) {
					value = getGlobalStaticArgumentValue(parameterName);
				}
				if (value != null) {
					staticArguments.add(value);
				} else {
					status.add(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "Block parameter '"
							+ parameterName + "' not found"));
				}
			} catch (CoreException e) {
				status.add(e.getStatus());
			}
		}
		return staticArguments;
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
	
	private IValue getParameterStaticArgumentValue(String parameterName) throws CoreException {
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

	private IValue getInputStaticArgumentValue(String name) throws CoreException {
		for (Input input : block.getInputs()) {
			BlockInput blockInput = (BlockInput) input;
			if (blockInput.getDefinition().isManyPorts() && blockInput.getDefinition().getParameter(name) != null) {
				Type elementType = null;
				List<IValue> values = new ArrayList<IValue>(blockInput.getPorts().size());
				for (InputPort inputPort : blockInput.getPorts()) {
					BlockInputPort blockInputPort = (BlockInputPort) inputPort;
					Argument argument = blockInputPort.getArgument(name);
					if (argument == null) {
						throw new CoreException(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "No argument for input parameter '" + name + "' found"));
					}
					IValue value = evaluateParameterValue(argument.getParameter(), argument.getValue());
					if (elementType == null) {
						elementType = value.getDataType();
					} else {
						elementType = TypeUtil.getLeftHandDataType(elementType, value.getDataType());
						if (elementType == null) {
							throw new CoreException(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "Argument values of input parameter '" + name + "' have incompatible data types"));
						}
					}
					values.add(value);
				}
				ArrayType arrayType = TypeUtil.createArrayType(elementType, values.size());
				return new VectorValue(new ComputationContext(), arrayType, values.toArray(new IValue[values.size()]));
			}
		}
		return null;
	}
	
	protected IValue getGlobalStaticArgumentValue(String name) throws CoreException {
		return null;
	}
	
	private IValue evaluateParameterValue(Parameter parameter, ValueSpecification valueSpecification) throws CoreException {
		if (valueSpecification instanceof MscriptValueSpecification) {
			Expression expression = ((MscriptValueSpecification) valueSpecification).getExpression();
			IStaticEvaluationResult context = new StaticEvaluationResult();
			IValue value = expressionEvaluator.evaluate(new StaticExpressionEvaluationContext(context), expression);
			if (context.getStatus().getSeverity() > IStatus.WARNING) {
				throw new CoreException(context.getStatus());
			}
			if (value instanceof InvalidValue) {
				throw new CoreException(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "Argument value of parameter '" + parameter.getName() + "' is invalid"));
			}
			return value;
		}
		throw new CoreException(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "Argument value of parameter '" + parameter.getName() + "' must be an expression"));
	}

}
