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

package org.eclipse.damos.simulation.simulator.internal.simulationobjects;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.damos.dml.Block;
import org.eclipse.damos.dml.BlockInput;
import org.eclipse.damos.dml.BlockOutput;
import org.eclipse.damos.dml.Input;
import org.eclipse.damos.execution.util.DscriptBlockHelper;
import org.eclipse.damos.mscript.AnonymousTypeSpecifier;
import org.eclipse.damos.mscript.ArrayType;
import org.eclipse.damos.mscript.CompositeTypeMember;
import org.eclipse.damos.mscript.CompositeTypeMemberList;
import org.eclipse.damos.mscript.FunctionDeclaration;
import org.eclipse.damos.mscript.InputParameterDeclaration;
import org.eclipse.damos.mscript.MscriptFactory;
import org.eclipse.damos.mscript.OutputParameterDeclaration;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.UnionType;
import org.eclipse.damos.mscript.VariableDeclaration;
import org.eclipse.damos.mscript.interpreter.FunctionCallPath;
import org.eclipse.damos.mscript.interpreter.FunctionSignature;
import org.eclipse.damos.mscript.interpreter.IFunctionObject;
import org.eclipse.damos.mscript.interpreter.IInterpreterContext;
import org.eclipse.damos.mscript.interpreter.IStaticEvaluationResult;
import org.eclipse.damos.mscript.interpreter.IVariable;
import org.eclipse.damos.mscript.interpreter.Interpreter;
import org.eclipse.damos.mscript.interpreter.InterpreterContext;
import org.eclipse.damos.mscript.interpreter.StaticEvaluationResult;
import org.eclipse.damos.mscript.interpreter.value.IArrayValue;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.mscript.interpreter.value.UnionValue;
import org.eclipse.damos.mscript.interpreter.value.VectorValue;
import org.eclipse.damos.mscript.util.TypeUtil;
import org.eclipse.damos.simulation.ISimulationMonitor;
import org.eclipse.damos.simulation.simulator.AbstractBlockSimulationObject;
import org.eclipse.damos.simulation.simulator.internal.SimulatorPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Andreas Unger
 *
 */
public class DscriptBlockSimulationObject extends AbstractBlockSimulationObject {

	private boolean hasInputSockets;
	private UnionType messageType;
	private int[] messageKinds;
	
	private Interpreter interpreter;
	private IInterpreterContext interpreterContext;
	private IFunctionObject functionObject;
	
	private IVariable[] inputVariables;
	private IVariable[] outputVariables;
		
	private boolean[] multiPortInput;
	private boolean[] multiPortOutput;
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.simulation.simulator.AbstractSimulationObject#initialize()
	 */
	@Override
	public void initialize(IProgressMonitor monitor) throws CoreException {
		MultiStatus status = new MultiStatus(SimulatorPlugin.PLUGIN_ID, 0, "Simulation object initialization", null);

		DscriptBlockHelper helper = new DscriptBlockHelper(getComponent());
		
		FunctionDeclaration functionDeclaration = helper.getBehavior();
		FunctionSignature functionSignature = helper.getFunctionSignature(functionDeclaration, getComponentSignature(), status);
		
		if (status.getSeverity() > IStatus.WARNING) {
			throw new CoreException(status);
		}
		
		if (functionSignature == null) {
			throw new CoreException(new Status(IStatus.ERROR, SimulatorPlugin.PLUGIN_ID, "Missing input data types"));
		}
		
		IStaticEvaluationResult staticEvaluationResult = new StaticEvaluationResult();
		helper.evaluateFunctionDeclaration(staticEvaluationResult, functionDeclaration, functionSignature);
		if (!staticEvaluationResult.getStatus().isOK()) {
			status.add(staticEvaluationResult.getStatus());
		}
		if (staticEvaluationResult.getStatus().getSeverity() > IStatus.WARNING) {
			throw new CoreException(status);
		}
		
		interpreter = new Interpreter(staticEvaluationResult, getComputationContext(), getNode().getSampleInterval());
		interpreterContext = new InterpreterContext(staticEvaluationResult, getComputationContext(), interpreter);
		functionObject = interpreter.createFunctionObject(interpreterContext);
				
		initializeSockets();
		initializeInputVariables();
		initializeOutputVariables();
	}

	private void initializeSockets() {
		Block block = getComponent();
		hasInputSockets = !block.getInputSockets().isEmpty();
		if (hasInputSockets) {
			EList<Input> inputs = block.getInputs();
			EList<Input> socketInputs = block.getInputSockets();
			
			messageType = MscriptFactory.eINSTANCE.createUnionType();
			for (Input socketInput : socketInputs) {
				CompositeTypeMember member = MscriptFactory.eINSTANCE.createCompositeTypeMember();
				member.setName(socketInput.getName());
				
				CompositeTypeMemberList memberList = MscriptFactory.eINSTANCE.createCompositeTypeMemberList();
				AnonymousTypeSpecifier typeSpecifier = MscriptFactory.eINSTANCE.createAnonymousTypeSpecifier();
				// TODO: Check port count
				typeSpecifier.setType(EcoreUtil.copy(getComponentSignature().getInputDataType(socketInput.getPorts().get(0))));
				memberList.setTypeSpecifier(typeSpecifier);
				memberList.getMembers().add(member);
				
				messageType.getMemberLists().add(memberList);
			}
			
			messageKinds = new int[inputs.size()];
			for (int i = 0; i < messageKinds.length; ++i) {
				messageKinds[i] = socketInputs.indexOf(inputs.get(i));
			}
		}
	}
	
	private void initializeInputVariables() throws CoreException {
		inputVariables = new IVariable[functionObject.getFunctionInstance().getDeclaration().getNonConstantInputParameterDeclarations().size()];
		multiPortInput = new boolean[inputVariables.length];
		
		int i = 0;
		for (InputParameterDeclaration inputParameterDeclaration : functionObject.getFunctionInstance().getDeclaration().getNonConstantInputParameterDeclarations()) {
			IVariable variable = functionObject.getVariable(inputParameterDeclaration);
			
			// TODO: Check if this code works for combination of sockets and non-sockets (probably not)
			int inputIndex = hasInputSockets ? i - 1 : i;
			if (inputIndex >= 0) {
				BlockInput input = (BlockInput) getComponent().getInputs().get(inputIndex);
				
				if (input.getDefinition().isManyPorts() || input.getDefinition().getMinimumPortCount() == 0) {
					initializeArrayVariable(inputParameterDeclaration, variable);
					multiPortInput[i] = true;
				}
			}
			
			inputVariables[i] = variable;
			++i;
		}
	}
	
	private void initializeOutputVariables() throws CoreException {
		outputVariables = new IVariable[functionObject.getFunctionInstance().getDeclaration().getOutputParameterDeclarations().size()];
		multiPortOutput = new boolean[outputVariables.length];

		int i = 0;
		for (OutputParameterDeclaration outputParameterDeclaration : functionObject.getFunctionInstance().getDeclaration().getOutputParameterDeclarations()) {
			IVariable variable = functionObject.getVariable(outputParameterDeclaration);
			
			BlockOutput output = (BlockOutput) getComponent().getOutputs().get(i);
			
			if (output.getDefinition().isManyPorts() || output.getDefinition().getMinimumPortCount() == 0) {
				initializeArrayVariable(outputParameterDeclaration, variable);
				multiPortOutput[i] = true;
			}
			
			outputVariables[i] = variable;
			++i;
		}
	}

	private void initializeArrayVariable(VariableDeclaration variableDeclaration, IVariable variable) throws CoreException {
		Type type = interpreterContext.getStaticEvaluationResult().getFunctionInfo(FunctionCallPath.EMPTY).getValue(variableDeclaration).getDataType();
		if (type instanceof ArrayType) {
			ArrayType arrayType = (ArrayType) type;
			variable.setValue(0, new VectorValue(interpreterContext.getComputationContext(), arrayType, new IValue[TypeUtil.getArraySize(arrayType)]));
		} else {
			throw new CoreException(new Status(IStatus.ERROR, SimulatorPlugin.PLUGIN_ID,
					"Variable declaration type must be array type"));
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.simulation.simulator.AbstractSimulationObject#consumeInputValue(org.eclipse.damos.dml.InputPort, org.eclipse.damos.mscript.computation.core.value.IValue)
	 */
	@Override
	public void setInputValue(int inputIndex, int portIndex, IValue value) {
		if (hasInputSockets) {
			int messageKind = messageKinds[inputIndex];
			if (messageKind != -1) {
				inputVariables[0].setValue(0, new UnionValue(getComputationContext(), messageType, messageKind, value));
				return;
			}
			++inputIndex;
		}
		
		IVariable variable = inputVariables[inputIndex];
		if (multiPortInput[inputIndex]) {
			IArrayValue arrayValue = (IArrayValue) variable.getValue(0);
			arrayValue.set(portIndex, value);
		} else {
			variable.setValue(0, value);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.simulation.simulator.AbstractSimulationObject#computeOutputValues()
	 */
	@Override
	public void computeOutputValues(double t, ISimulationMonitor monitor) throws CoreException {
		updateTime(t);
		interpreter.compute(interpreterContext);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.simulation.simulator.AbstractSimulationObject#getOutputValue(org.eclipse.damos.dml.OutputPort)
	 */
	@Override
	public IValue getOutputValue(int outputIndex, int portIndex) {
		IVariable variable = outputVariables[outputIndex];
		if (multiPortOutput[outputIndex]) {
			IArrayValue arrayValue = (IArrayValue) variable.getValue(0);
			return arrayValue.get(portIndex);
		}
		return variable.getValue(0);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.simulation.simulator.AbstractSimulationObject#update()
	 */
	@Override
	public void update(double t) {
		updateTime(t);
		interpreter.update();
	}
	
	/**
	 * @return the interpreterContext
	 */
	protected IInterpreterContext getInterpreterContext() {
		return interpreterContext;
	}
	
	/**
	 * @return the functionObject
	 */
	public IFunctionObject getFunctionObject() {
		return functionObject;
	}
	
	protected void updateTime(double t) {
		interpreter.updateTime(t);
	}

}
