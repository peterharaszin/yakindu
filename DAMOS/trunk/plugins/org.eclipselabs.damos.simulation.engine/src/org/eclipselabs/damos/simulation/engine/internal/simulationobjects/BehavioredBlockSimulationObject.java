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

package org.eclipselabs.damos.simulation.engine.internal.simulationobjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockInput;
import org.eclipselabs.damos.dml.BlockOutput;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.util.DMLUtil;
import org.eclipselabs.damos.execution.engine.util.BehavioredBlockHelper;
import org.eclipselabs.damos.simulation.engine.AbstractBlockSimulationObject;
import org.eclipselabs.damos.simulation.engine.SimulationEnginePlugin;
import org.eclipselabs.mscript.computation.engine.ComputationContext;
import org.eclipselabs.mscript.computation.engine.value.INumericValue;
import org.eclipselabs.mscript.computation.engine.value.IValue;
import org.eclipselabs.mscript.computation.engine.value.ValueConstructor;
import org.eclipselabs.mscript.computation.engine.value.VectorValue;
import org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor;
import org.eclipselabs.mscript.language.il.Compound;
import org.eclipselabs.mscript.language.il.ComputationCompound;
import org.eclipselabs.mscript.language.il.ILFunctionDefinition;
import org.eclipselabs.mscript.language.il.InputVariableDeclaration;
import org.eclipselabs.mscript.language.il.OutputVariableDeclaration;
import org.eclipselabs.mscript.language.il.transform.FunctionDefinitionTransformer;
import org.eclipselabs.mscript.language.il.transform.IFunctionDefinitionTransformerResult;
import org.eclipselabs.mscript.language.interpreter.CompoundInterpreter;
import org.eclipselabs.mscript.language.interpreter.Functor;
import org.eclipselabs.mscript.language.interpreter.IFunctor;
import org.eclipselabs.mscript.language.interpreter.IInterpreterContext;
import org.eclipselabs.mscript.language.interpreter.IVariable;
import org.eclipselabs.mscript.language.interpreter.InterpreterContext;
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
	private IFunctor functor;
	
	private CompoundInterpreter compoundInterpreter;

	private Map<OutputPort, IValue> outputValues = new HashMap<OutputPort, IValue>();
		
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.engine.AbstractComponentSimulationObject#initialize()
	 */
	@Override
	public void initialize() throws CoreException {
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
		
		interpreterContext = new InterpreterContext(new ComputationContext(getComputationModel()));
		functor = Functor.create(interpreterContext, functionDefinition);

		for (IVariable variable : functor.getVariables()) {
			interpreterContext.addVariable(variable);
		}

		Compound initializationCompound = functor.getFunctionDefinition().getInitializationCompound();
		if (initializationCompound != null) {
			new CompoundInterpreter(interpreterContext).doSwitch(initializationCompound);
		}
		
		compoundInterpreter = new CompoundInterpreter(interpreterContext);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.engine.AbstractComponentSimulationObject#consumeInputValue(org.eclipselabs.damos.dml.InputPort, org.eclipselabs.mscript.computation.engine.value.IValue)
	 */
	@Override
	public void consumeInputValue(InputPort inputPort, IValue value) throws CoreException {
		InputVariableDeclaration inputVariableDeclaration = null;
		
		BlockInput input = (BlockInput) inputPort.getInput();
		for (InputVariableDeclaration declaration : functor.getFunctionDefinition().getInputVariableDeclarations()) {
			if (input.getDefinition().getName().equals(declaration.getName())) {
				inputVariableDeclaration = declaration;
				break;
			}
		}
		
		IVariable variable = functor.getVariable(inputVariableDeclaration);
		if (input.getDefinition().isManyPorts() || input.getDefinition().getMinimumPortCount() == 0) {
			VectorValue vectorValue = (VectorValue) variable.getValue(0);
			if (vectorValue == null) {
				TensorType tensorType = (TensorType) variable.getDeclaration().getType();
				vectorValue = new VectorValue(interpreterContext.getComputationContext(), tensorType, new INumericValue[tensorType.getSize()]);
				variable.setValue(0, vectorValue);
			}
			vectorValue.set(DMLUtil.indexOf(inputPort), (INumericValue) value);
		} else {
			variable.setValue(0, value);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.engine.AbstractComponentSimulationObject#computeOutputValues()
	 */
	@Override
	public void computeOutputValues() throws CoreException {
		for (ComputationCompound compound : functor.getFunctionDefinition().getComputationCompounds()) {
			if (!compound.getOutputs().isEmpty()) {
				compoundInterpreter.doSwitch(compound);
			}
		}

		for (OutputVariableDeclaration declaration : functor.getFunctionDefinition().getOutputVariableDeclarations()) {
			IVariable variable = functor.getVariable(declaration);
			BlockOutput output = (BlockOutput) getComponent().getOutput(variable.getDeclaration().getName());
			outputValues.put(output.getPorts().get(0), variable.getValue(0));
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.engine.AbstractComponentSimulationObject#getOutputValue(org.eclipselabs.damos.dml.OutputPort)
	 */
	@Override
	public IValue getOutputValue(OutputPort outputPort) throws CoreException {
		return outputValues.get(outputPort);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.engine.AbstractComponentSimulationObject#update()
	 */
	@Override
	public void update() throws CoreException {
		for (ComputationCompound compound : functor.getFunctionDefinition().getComputationCompounds()) {
			if (compound.getOutputs().isEmpty()) {
				compoundInterpreter.doSwitch(compound);
			}
		}
		functor.incrementStepIndex();
	}
	
	private class Helper extends BehavioredBlockHelper {
		
		/**
		 * @param block
		 */
		public Helper(Block block) {
			super(block);
		}

		@Override
		protected IValue getGlobalTemplateArgument(String name) {
			if (SAMPLE_TIME_TEMPLATE_PARAMETER_NAME.equals(name)) {
				double sampleTime = getExecutionModel().getSampleTime();
				RealType realType = TypeSystemFactory.eINSTANCE.createRealType();
				realType.setUnit(TypeSystemUtil.createUnit(UnitSymbol.SECOND));
				return new ValueConstructor().createRealValue(new ComputationContext(), realType, sampleTime);
			}
			if (SAMPLE_RATE_TEMPLATE_PARAMETER_NAME.equals(name)) {
				double sampleRate = 1 / getExecutionModel().getSampleTime();
				RealType realType = TypeSystemFactory.eINSTANCE.createRealType();
				Unit herzUnit = TypeSystemUtil.createUnit();
				herzUnit.getFactor(UnitSymbol.SECOND).setExponent(-1);
				realType.setUnit(herzUnit);
				return new ValueConstructor().createRealValue(new ComputationContext(), realType, sampleRate);
			}
			return super.getGlobalTemplateArgument(name);
		}
		
	}

}
