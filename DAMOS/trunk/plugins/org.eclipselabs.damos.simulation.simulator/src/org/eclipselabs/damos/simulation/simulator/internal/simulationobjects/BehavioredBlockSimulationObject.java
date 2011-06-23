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
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockInput;
import org.eclipselabs.damos.dml.BlockOutput;
import org.eclipselabs.damos.execution.core.util.BehavioredBlockHelper;
import org.eclipselabs.damos.simulation.core.ISimulationMonitor;
import org.eclipselabs.damos.simulation.simulator.AbstractBlockSimulationObject;
import org.eclipselabs.damos.simulation.simulator.internal.SimulationEnginePlugin;
import org.eclipselabs.mscript.computation.core.ComputationContext;
import org.eclipselabs.mscript.computation.core.value.ArrayValue;
import org.eclipselabs.mscript.computation.core.value.IArrayValue;
import org.eclipselabs.mscript.computation.core.value.INumericValue;
import org.eclipselabs.mscript.computation.core.value.IValue;
import org.eclipselabs.mscript.computation.core.value.ValueConstructor;
import org.eclipselabs.mscript.computation.core.value.VectorValue;
import org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor;
import org.eclipselabs.mscript.language.il.Compound;
import org.eclipselabs.mscript.language.il.ComputationCompound;
import org.eclipselabs.mscript.language.il.ILFunctionDefinition;
import org.eclipselabs.mscript.language.il.InputVariableDeclaration;
import org.eclipselabs.mscript.language.il.OutputVariableDeclaration;
import org.eclipselabs.mscript.language.il.VariableDeclaration;
import org.eclipselabs.mscript.language.il.transform.FunctionDefinitionTransformer;
import org.eclipselabs.mscript.language.il.transform.IFunctionDefinitionTransformerResult;
import org.eclipselabs.mscript.language.interpreter.CompoundInterpreter;
import org.eclipselabs.mscript.language.interpreter.FunctionObject;
import org.eclipselabs.mscript.language.interpreter.ICompoundInterpreter;
import org.eclipselabs.mscript.language.interpreter.IFunctionObject;
import org.eclipselabs.mscript.language.interpreter.IInterpreterContext;
import org.eclipselabs.mscript.language.interpreter.IVariable;
import org.eclipselabs.mscript.language.interpreter.InterpreterContext;
import org.eclipselabs.mscript.typesystem.ArrayType;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.RealType;
import org.eclipselabs.mscript.typesystem.TensorType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.Unit;
import org.eclipselabs.mscript.typesystem.UnitSymbol;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

/**
 * @author Andreas Unger
 *
 */
public class BehavioredBlockSimulationObject extends AbstractBlockSimulationObject {

	private IInterpreterContext interpreterContext;
	private IFunctionObject functionObject;
	
	private ICompoundInterpreter compoundInterpreter = new CompoundInterpreter();

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
		MultiStatus status = new MultiStatus(SimulationEnginePlugin.PLUGIN_ID, 0, "Simulation object initialization failed", null);

		Block block = getComponent();

		Helper helper = new Helper(block);
		
		FunctionDescriptor functionDescriptor = helper.constructFunctionDescriptor();
		
		List<IValue> templateArguments = helper.getTemplateArguments(functionDescriptor.getDefinition(), status);
		List<DataType> inputParameterDataTypes = helper.getInputParameterDataTypes(functionDescriptor.getDefinition(), getSignature(), status);

		if (!status.isOK()) {
			throw new CoreException(status);
		}
		
		if (inputParameterDataTypes == null) {
			throw new CoreException(new Status(IStatus.ERROR, SimulationEnginePlugin.PLUGIN_ID, "Missing input data types"));
		}
		
		IFunctionDefinitionTransformerResult functionDefinitionTransformerResult = new FunctionDefinitionTransformer()
				.transform(functionDescriptor, null, templateArguments, inputParameterDataTypes);

		if (!functionDefinitionTransformerResult.getStatus().isOK()) {
			status.add(functionDefinitionTransformerResult.getStatus());
			throw new CoreException(status);
		}
		
		ILFunctionDefinition functionDefinition = functionDefinitionTransformerResult.getILFunctionDefinition();
		
		interpreterContext = new InterpreterContext(getComputationContext());
		functionObject = FunctionObject.create(interpreterContext, functionDefinition);

		for (IVariable variable : functionObject.getVariables()) {
			interpreterContext.addVariable(variable);
		}
		
		initializeInputVariables();
		initializeOutputVariables();

		Compound initializationCompound = functionObject.getFunctionDefinition().getInitializationCompound();
		if (initializationCompound != null) {
			compoundInterpreter.execute(interpreterContext, initializationCompound);
		}
		
		for (ComputationCompound compound : functionObject.getFunctionDefinition().getComputationCompounds()) {
			if (!compound.getOutputs().isEmpty()) {
				computeOutputsCompounds.add(compound);
			} else {
				updateCompounds.add(compound);
			}
		}
	}
	
	private void initializeInputVariables() throws CoreException {
		inputVariables = new IVariable[functionObject.getFunctionDefinition().getInputVariableDeclarations().size()];
		multiPortInput = new boolean[inputVariables.length];
		
		int i = 0;
		for (InputVariableDeclaration inputVariableDeclaration : functionObject.getFunctionDefinition().getInputVariableDeclarations()) {
			IVariable variable = functionObject.getVariable(inputVariableDeclaration);
			
			BlockInput input = (BlockInput) getComponent().getInputs().get(i);
			
			if (input.getDefinition().isManyPorts() || input.getDefinition().getMinimumPortCount() == 0) {
				initializeArrayVariable(inputVariableDeclaration, variable);
				multiPortInput[i] = true;
			}
			
			inputVariables[i] = variable;
			++i;
		}
	}
	
	private void initializeOutputVariables() throws CoreException {
		outputVariables = new IVariable[functionObject.getFunctionDefinition().getOutputVariableDeclarations().size()];
		multiPortOutput = new boolean[outputVariables.length];

		int i = 0;
		for (OutputVariableDeclaration outputVariableDeclaration : functionObject.getFunctionDefinition().getOutputVariableDeclarations()) {
			IVariable variable = functionObject.getVariable(outputVariableDeclaration);
			
			BlockOutput output = (BlockOutput) getComponent().getOutputs().get(i);
			
			if (output.getDefinition().isManyPorts() || output.getDefinition().getMinimumPortCount() == 0) {
				initializeArrayVariable(outputVariableDeclaration, variable);
				multiPortOutput[i] = true;
			}
			
			outputVariables[i] = variable;
			++i;
		}
	}

	private void initializeArrayVariable(VariableDeclaration variableDeclaration, IVariable variable) throws CoreException {
		DataType dataType = variableDeclaration.getDataType();
		if (dataType instanceof ArrayType) {
			if (dataType instanceof TensorType) {
				TensorType tensorType = (TensorType) dataType;
				variable.setValue(0, new VectorValue(interpreterContext.getComputationContext(), tensorType, new INumericValue[tensorType.getSize()]));
			} else {
				ArrayType arrayType = (ArrayType) dataType;
				variable.setValue(0, new ArrayValue(interpreterContext.getComputationContext(), arrayType, new IValue[arrayType.getSize()]));
			}
		} else {
			throw new CoreException(new Status(IStatus.ERROR, SimulationEnginePlugin.PLUGIN_ID,
					"Variable declaration type must be array type"));
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject#consumeInputValue(org.eclipselabs.damos.dml.InputPort, org.eclipselabs.mscript.computation.core.value.IValue)
	 */
	@Override
	public void setInputValue(int inputIndex, int portIndex, IValue value) {
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
			compoundInterpreter.execute(interpreterContext, compound);
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
			compoundInterpreter.execute(interpreterContext, compound);
		}
		functionObject.incrementStepIndex();
	}
	
	private class Helper extends BehavioredBlockHelper {
		
		/**
		 * @param block
		 */
		public Helper(Block block) {
			super(block);
		}

		@Override
		protected IValue getGlobalTemplateArgument(String name) throws CoreException {
			if (SAMPLE_TIME_TEMPLATE_PARAMETER_NAME.equals(name)) {
				double sampleTime = getNode().getSampleTime();
				RealType realType = TypeSystemFactory.eINSTANCE.createRealType();
				realType.setUnit(TypeSystemUtil.createUnit(UnitSymbol.SECOND));
				return new ValueConstructor().construct(new ComputationContext(), realType, sampleTime);
			}
			if (SAMPLE_RATE_TEMPLATE_PARAMETER_NAME.equals(name)) {
				double sampleRate = 1 / getNode().getSampleTime();
				RealType realType = TypeSystemFactory.eINSTANCE.createRealType();
				Unit herzUnit = TypeSystemUtil.createUnit();
				herzUnit.getFactor(UnitSymbol.SECOND).setExponent(-1);
				realType.setUnit(herzUnit);
				return new ValueConstructor().construct(new ComputationContext(), realType, sampleRate);
			}
			return super.getGlobalTemplateArgument(name);
		}
		
	}

}
