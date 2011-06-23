/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.execution.engine.internal.signaturepolicies;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockOutput;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.Output;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.execution.engine.AbstractComponentSignaturePolicy;
import org.eclipselabs.damos.execution.engine.ComponentSignature;
import org.eclipselabs.damos.execution.engine.ComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.engine.ExecutionEnginePlugin;
import org.eclipselabs.damos.execution.engine.IComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.engine.util.BehavioredBlockHelper;
import org.eclipselabs.mscript.computation.core.ComputationContext;
import org.eclipselabs.mscript.computation.core.value.IValue;
import org.eclipselabs.mscript.computation.core.value.ValueConstructor;
import org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor;
import org.eclipselabs.mscript.language.il.ILFunctionDefinition;
import org.eclipselabs.mscript.language.il.OutputVariableDeclaration;
import org.eclipselabs.mscript.language.il.transform.FunctionDefinitionTransformer;
import org.eclipselabs.mscript.language.il.transform.IFunctionDefinitionTransformerResult;
import org.eclipselabs.mscript.typesystem.ArrayType;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.RealType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.Unit;
import org.eclipselabs.mscript.typesystem.UnitSymbol;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

public class BehavioredBlockSignaturePolicy extends AbstractComponentSignaturePolicy {

	@Override
	public IComponentSignatureEvaluationResult evaluateSignature(Component component,
			Map<InputPort, DataType> incomingDataTypes) {
		Block block = (Block) component;

		MultiStatus status = new MultiStatus(ExecutionEnginePlugin.PLUGIN_ID, 0, "", null);

		FunctionDescriptor functionDescriptor;

		Helper helper = new Helper(block);

		try {
			functionDescriptor = helper.constructFunctionDescriptor();
		} catch (CoreException e) {
			status.add(e.getStatus());
			return new ComponentSignatureEvaluationResult(status);
		}

		ComponentSignature componentSignature = new ComponentSignature(incomingDataTypes);
		
		List<IValue> templateArguments = helper.getTemplateArguments(
				functionDescriptor.getDefinition(), status);
		List<DataType> inputParameterDataTypes = helper.getInputParameterDataTypes(
				functionDescriptor.getDefinition(), componentSignature, status);

		if (!status.isOK()) {
			return new ComponentSignatureEvaluationResult(status);
		}

		if (inputParameterDataTypes == null) {
			return new ComponentSignatureEvaluationResult();
		}

		IFunctionDefinitionTransformerResult functionDefinitionTransformerResult = new FunctionDefinitionTransformer()
				.transform(functionDescriptor, null, templateArguments, inputParameterDataTypes);

		if (!functionDefinitionTransformerResult.getStatus().isOK()) {
			status.add(functionDefinitionTransformerResult.getStatus());
			return new ComponentSignatureEvaluationResult(status);
		}
		
		ILFunctionDefinition functionDefinition = functionDefinitionTransformerResult.getILFunctionDefinition();

		Iterator<OutputVariableDeclaration> outputVariableDeclarationIterator = functionDefinition.getOutputVariableDeclarations().iterator();
		for (Output output : block.getOutputs()) {
			BlockOutput blockOutput = (BlockOutput) output;
			
			if (!outputVariableDeclarationIterator.hasNext()) {
				status.add(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "No output parameter found for output '" + blockOutput.getDefinition().getName() + "'"));
				break;
			}
			
			OutputVariableDeclaration outputVariableDeclaration = outputVariableDeclarationIterator.next();
			DataType dataType = outputVariableDeclaration.getDataType();

			if (blockOutput.getDefinition().isManyPorts() || blockOutput.getDefinition().getMinimumPortCount() == 0) {
				if (!(dataType instanceof ArrayType)) {
					status.add(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Output '"
							+ outputVariableDeclaration.getName() + "' must result to array type"));
					continue;
				}
				ArrayType arrayType = (ArrayType) dataType;

				for (OutputPort outputPort : output.getPorts()) {
					componentSignature.getOutputDataTypes().put(outputPort, EcoreUtil.copy(arrayType.getElementType()));
				}
			} else {
				if (output.getPorts().isEmpty()) {
					status.add(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Invalid output '"
							+ outputVariableDeclaration.getName() + "'"));
					continue;
				}
				componentSignature.getOutputDataTypes().put(output.getPorts().get(0), dataType);
			}
		}

		if (!status.isOK()) {
			return new ComponentSignatureEvaluationResult(status);
		}

		return new ComponentSignatureEvaluationResult(componentSignature);
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
				RealType realType = TypeSystemFactory.eINSTANCE.createRealType();
				realType.setUnit(TypeSystemUtil.createUnit(UnitSymbol.SECOND));
				return new ValueConstructor().construct(new ComputationContext(), realType, 1);
			}
			if (SAMPLE_RATE_TEMPLATE_PARAMETER_NAME.equals(name)) {
				RealType realType = TypeSystemFactory.eINSTANCE.createRealType();
				Unit herzUnit = TypeSystemUtil.createUnit();
				herzUnit.getFactor(UnitSymbol.SECOND).setExponent(-1);
				realType.setUnit(herzUnit);
				return new ValueConstructor().construct(new ComputationContext(), realType, 1);
			}
			return super.getGlobalTemplateArgument(name);
		}
		
	}

}