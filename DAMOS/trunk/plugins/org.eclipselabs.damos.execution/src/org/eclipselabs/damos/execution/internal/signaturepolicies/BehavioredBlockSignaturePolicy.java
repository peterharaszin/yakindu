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

package org.eclipselabs.damos.execution.internal.signaturepolicies;

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
import org.eclipselabs.damos.execution.datatype.AbstractComponentSignaturePolicy;
import org.eclipselabs.damos.execution.datatype.ComponentSignature;
import org.eclipselabs.damos.execution.datatype.ComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.datatype.IComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.internal.ExecutionPlugin;
import org.eclipselabs.damos.execution.util.BehavioredBlockHelper;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.FunctionDeclaration;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.OutputParameterDeclaration;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.Unit;
import org.eclipselabs.damos.mscript.UnitSymbol;
import org.eclipselabs.damos.mscript.interpreter.ComputationContext;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationResult;
import org.eclipselabs.damos.mscript.interpreter.StaticEvaluationResult;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.Values;
import org.eclipselabs.damos.mscript.util.TypeUtil;

public class BehavioredBlockSignaturePolicy extends AbstractComponentSignaturePolicy {

	@Override
	public IComponentSignatureEvaluationResult evaluateSignature(Component component,
			Map<InputPort, DataType> incomingDataTypes) {
		Block block = (Block) component;

		MultiStatus status = new MultiStatus(ExecutionPlugin.PLUGIN_ID, 0, "", null);

		Helper helper = new Helper(block);

		ComponentSignature signature = new ComponentSignature(incomingDataTypes);
		
		FunctionDeclaration functionDeclaration;
		try {
			functionDeclaration = helper.createFunctionDefinition();
		} catch (CoreException e) {
			status.add(e.getStatus());
			return new ComponentSignatureEvaluationResult(status);
		}

		List<IValue> staticArguments = helper.getStaticArguments(functionDeclaration, status);
		List<DataType> inputParameterDataTypes = helper.getInputParameterDataTypes(
				functionDeclaration, signature, status);
		
		if (status.getSeverity() > IStatus.WARNING) {
			return new ComponentSignatureEvaluationResult(status);
		}

		if (inputParameterDataTypes == null) {
			return new ComponentSignatureEvaluationResult();
		}

		IStaticEvaluationResult staticEvaluationResult = new StaticEvaluationResult();
		helper.evaluateFunctionDefinition(staticEvaluationResult, functionDeclaration, staticArguments, inputParameterDataTypes);
		if (!staticEvaluationResult.getStatus().isOK()) {
			status.merge(staticEvaluationResult.getStatus());
		}
		if (staticEvaluationResult.getStatus().getSeverity() > IStatus.WARNING) {
			return new ComponentSignatureEvaluationResult(status);
		}
		
		Iterator<OutputParameterDeclaration> outputParameterDeclarationIt = functionDeclaration.getOutputParameterDeclarations().iterator();
		for (Output output : block.getOutputs()) {
			BlockOutput blockOutput = (BlockOutput) output;
			
			if (!outputParameterDeclarationIt.hasNext()) {
				status.add(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "No output parameter found for output '" + blockOutput.getDefinition().getName() + "'"));
				break;
			}
			
			OutputParameterDeclaration outputParameterDeclaration = outputParameterDeclarationIt.next();
			DataType dataType = staticEvaluationResult.getValue(outputParameterDeclaration).getDataType();

			if (blockOutput.getDefinition().isManyPorts() || blockOutput.getDefinition().getMinimumPortCount() == 0) {
				if (!(dataType instanceof ArrayType)) {
					status.add(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "Output '"
							+ outputParameterDeclaration.getName() + "' must result to array type"));
					continue;
				}
				ArrayType arrayType = (ArrayType) dataType;

				for (OutputPort outputPort : output.getPorts()) {
					signature.getOutputDataTypes().put(outputPort, EcoreUtil.copy(arrayType.getElementType()));
				}
			} else {
				if (output.getPorts().isEmpty()) {
					status.add(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "Invalid output '"
							+ outputParameterDeclaration.getName() + "'"));
					continue;
				}
				signature.getOutputDataTypes().put(output.getPorts().get(0), dataType);
			}
		}

		if (status.getSeverity() > IStatus.WARNING) {
			return new ComponentSignatureEvaluationResult(status);
		}

		return new ComponentSignatureEvaluationResult(signature, status);
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
				RealType realType = MscriptFactory.eINSTANCE.createRealType();
				realType.setUnit(TypeUtil.createUnit(UnitSymbol.SECOND));
				return Values.valueOf(new ComputationContext(), realType, 1);
			}
			if (SAMPLE_RATE_STATIC_PARAMETER_NAME.equals(name)) {
				RealType realType = MscriptFactory.eINSTANCE.createRealType();
				Unit herzUnit = TypeUtil.createUnit(UnitSymbol.SECOND);
				herzUnit.getNumerator().getFactor(UnitSymbol.SECOND).setExponent(-1);
				realType.setUnit(herzUnit);
				return Values.valueOf(new ComputationContext(), realType, 1);
			}
			return super.getGlobalStaticArgumentValue(name);
		}
		
	}

}