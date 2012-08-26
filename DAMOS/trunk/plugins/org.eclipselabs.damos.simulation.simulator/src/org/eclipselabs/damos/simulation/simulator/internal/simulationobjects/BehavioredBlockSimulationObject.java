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

package org.eclipselabs.damos.simulation.simulator.internal.simulationobjects;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockInput;
import org.eclipselabs.damos.dml.BlockOutput;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.execution.util.BehavioredBlockHelper;
import org.eclipselabs.damos.mscript.AnonymousTypeSpecifier;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.CompositeTypeMember;
import org.eclipselabs.damos.mscript.CompositeTypeMemberList;
import org.eclipselabs.damos.mscript.CompoundStatement;
import org.eclipselabs.damos.mscript.FunctionDeclaration;
import org.eclipselabs.damos.mscript.InputParameterDeclaration;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.OutputParameterDeclaration;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.UnionType;
import org.eclipselabs.damos.mscript.Unit;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.function.ComputationCompound;
import org.eclipselabs.damos.mscript.function.FunctionDescription;
import org.eclipselabs.damos.mscript.function.FunctionInstance;
import org.eclipselabs.damos.mscript.function.transform.FunctionDefinitionTransformer;
import org.eclipselabs.damos.mscript.function.transform.IFunctionDefinitionTransformerResult;
import org.eclipselabs.damos.mscript.interpreter.CompoundStatementInterpreter;
import org.eclipselabs.damos.mscript.interpreter.ComputationContext;
import org.eclipselabs.damos.mscript.interpreter.FunctionObject;
import org.eclipselabs.damos.mscript.interpreter.ICompoundStatementInterpreter;
import org.eclipselabs.damos.mscript.interpreter.IFunctionObject;
import org.eclipselabs.damos.mscript.interpreter.IInterpreterContext;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationResult;
import org.eclipselabs.damos.mscript.interpreter.IVariable;
import org.eclipselabs.damos.mscript.interpreter.InterpreterContext;
import org.eclipselabs.damos.mscript.interpreter.StaticEvaluationResult;
import org.eclipselabs.damos.mscript.interpreter.value.IArrayValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.UnionValue;
import org.eclipselabs.damos.mscript.interpreter.value.Values;
import org.eclipselabs.damos.mscript.interpreter.value.VectorValue;
import org.eclipselabs.damos.mscript.util.TypeUtil;
import org.eclipselabs.damos.simulation.ISimulationMonitor;
import org.eclipselabs.damos.simulation.simulator.AbstractBlockSimulationObject;
import org.eclipselabs.damos.simulation.simulator.internal.SimulatorPlugin;

/**
 * @author Andreas Unger
 *
 */
public class BehavioredBlockSimulationObject extends AbstractBlockSimulationObject {

	private final ICompoundStatementInterpreter compoundStatementInterpreter = new CompoundStatementInterpreter();

	private boolean hasInputSockets;
	private UnionType messageType;
	private int[] messageKinds;
	
	private IInterpreterContext interpreterContext;
	private IFunctionObject functionObject;
	
	private IVariable[] inputVariables;
	private IVariable[] outputVariables;
		
	private boolean[] multiPortInput;
	private boolean[] multiPortOutput;
	
	private List<ComputationCompound> computeOutputsCompounds = new ArrayList<ComputationCompound>();
	private List<ComputationCompound> updateCompounds = new ArrayList<ComputationCompound>();
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject#initialize()
	 */
	@Override
	public void initialize(IProgressMonitor monitor) throws CoreException {
		MultiStatus status = new MultiStatus(SimulatorPlugin.PLUGIN_ID, 0, "Simulation object initialization", null);

		Block block = getComponent();

		Helper helper = new Helper(block);
		
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

		FunctionDeclaration functionDeclaration = helper.createFunctionDefinition();
		
		List<IValue> staticArguments = helper.getStaticArguments(functionDeclaration, status);
		List<Type> inputParameterDataTypes = helper.getInputParameterDataTypes(functionDeclaration, getComponentSignature(), status);

		if (status.getSeverity() > IStatus.WARNING) {
			throw new CoreException(status);
		}
		
		if (inputParameterDataTypes == null) {
			throw new CoreException(new Status(IStatus.ERROR, SimulatorPlugin.PLUGIN_ID, "Missing input data types"));
		}
		
		IStaticEvaluationResult staticEvaluationResult = new StaticEvaluationResult();
		helper.evaluateFunctionDefinition(staticEvaluationResult, functionDeclaration, staticArguments, inputParameterDataTypes);
		if (!staticEvaluationResult.getStatus().isOK()) {
			status.add(staticEvaluationResult.getStatus());
		}
		if (staticEvaluationResult.getStatus().getSeverity() > IStatus.WARNING) {
			throw new CoreException(status);
		}
		
		FunctionDescription functionDescription = staticEvaluationResult.getFunctionDescription(functionDeclaration);
		IFunctionDefinitionTransformerResult functionDefinitionTransformerResult = new FunctionDefinitionTransformer()
				.transform(staticEvaluationResult, functionDescription, staticArguments, inputParameterDataTypes);
		if (!functionDefinitionTransformerResult.getStatus().isOK()) {
			status.add(functionDefinitionTransformerResult.getStatus());
			throw new CoreException(status);
		}
		
		FunctionInstance functionInstance = functionDefinitionTransformerResult.getFunctionInstance();
		
		interpreterContext = new InterpreterContext(staticEvaluationResult, getComputationContext());
		functionObject = FunctionObject.create(interpreterContext, functionInstance);

		for (IVariable variable : functionObject.getVariables()) {
			interpreterContext.addVariable(variable);
		}
		
		initializeInputVariables();
		initializeOutputVariables();

		CompoundStatement initializationCompound = functionObject.getFunctionInstance().getInitializationCompound();
		if (initializationCompound != null) {
			compoundStatementInterpreter.execute(interpreterContext, initializationCompound);
		}
		
		for (ComputationCompound compound : functionObject.getFunctionInstance().getComputationCompounds()) {
			initializeComputationCompound(compound);
		}
	}
	
	private void initializeInputVariables() throws CoreException {
		inputVariables = new IVariable[functionObject.getFunctionInstance().getDeclaration().getInputParameterDeclarations().size()];
		multiPortInput = new boolean[inputVariables.length];
		
		int i = 0;
		for (InputParameterDeclaration inputParameterDeclaration : functionObject.getFunctionInstance().getDeclaration().getInputParameterDeclarations()) {
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
		Type type = interpreterContext.getStaticEvaluationResult().getValue(variableDeclaration).getDataType();
		if (type instanceof ArrayType) {
			ArrayType arrayType = (ArrayType) type;
			variable.setValue(0, new VectorValue(interpreterContext.getComputationContext(), arrayType, new IValue[TypeUtil.getArraySize(arrayType)]));
		} else {
			throw new CoreException(new Status(IStatus.ERROR, SimulatorPlugin.PLUGIN_ID,
					"Variable declaration type must be array type"));
		}
	}
	
	protected void initializeComputationCompound(ComputationCompound compound) {
		if (!compound.getOutputs().isEmpty()) {
			computeOutputsCompounds.add(compound);
		} else {
			updateCompounds.add(compound);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject#consumeInputValue(org.eclipselabs.damos.dml.InputPort, org.eclipselabs.mscript.computation.core.value.IValue)
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
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject#computeOutputValues()
	 */
	@Override
	public void computeOutputValues(double t, ISimulationMonitor monitor) throws CoreException {
		for (ComputationCompound compound : computeOutputsCompounds) {
			compoundStatementInterpreter.execute(interpreterContext, compound);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject#getOutputValue(org.eclipselabs.damos.dml.OutputPort)
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
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject#update()
	 */
	@Override
	public void update(double t) {
		for (ComputationCompound compound : updateCompounds) {
			compoundStatementInterpreter.execute(interpreterContext, compound);
		}
		functionObject.incrementStepIndex();
	}
	
	/**
	 * @return the interpreterContext
	 */
	protected IInterpreterContext getInterpreterContext() {
		return interpreterContext;
	}
	
	private class Helper extends BehavioredBlockHelper {
		
		/**
		 * @param block
		 */
		public Helper(Block block) {
			super(block);
		}

		@Override
		protected IValue getGlobalStaticArgumentValue(String name) throws CoreException {
			if (SAMPLE_TIME_STATIC_PARAMETER_NAME.equals(name)) {
				double sampleTime = getNode().getSampleTime();
				RealType realType = MscriptFactory.eINSTANCE.createRealType();
				realType.setUnit(TypeUtil.createUnit(getBlock().eResource().getResourceSet(), TypeUtil.SECOND_UNIT));
				return Values.valueOf(new ComputationContext(), realType, sampleTime);
			}
			if (SAMPLE_RATE_STATIC_PARAMETER_NAME.equals(name)) {
				double sampleRate = 1 / getNode().getSampleTime();
				RealType realType = MscriptFactory.eINSTANCE.createRealType();
				Unit herzUnit = TypeUtil.createUnit(getBlock().eResource().getResourceSet(), TypeUtil.SECOND_UNIT);
				herzUnit.getFactor(TypeUtil.SECOND_UNIT).setExponent(-1);
				realType.setUnit(herzUnit);
				return Values.valueOf(new ComputationContext(), realType, sampleRate);
			}
			return super.getGlobalStaticArgumentValue(name);
		}
		
	}

}
