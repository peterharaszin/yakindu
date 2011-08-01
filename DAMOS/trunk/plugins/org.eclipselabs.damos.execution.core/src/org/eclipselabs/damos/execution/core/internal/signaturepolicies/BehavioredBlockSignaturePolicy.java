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

package org.eclipselabs.damos.execution.core.internal.signaturepolicies;

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
import org.eclipselabs.damos.execution.core.AbstractComponentSignaturePolicy;
import org.eclipselabs.damos.execution.core.ComponentSignature;
import org.eclipselabs.damos.execution.core.ComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.core.ExecutionEnginePlugin;
import org.eclipselabs.damos.execution.core.IComponentSignatureEvaluationResult;
import org.eclipselabs.damos.execution.core.util.BehavioredBlockHelper;
import org.eclipselabs.mscript.computation.core.ComputationContext;
import org.eclipselabs.mscript.computation.core.value.IValue;
import org.eclipselabs.mscript.computation.core.value.Values;
import org.eclipselabs.mscript.language.ast.FunctionDefinition;
import org.eclipselabs.mscript.language.ast.OutputParameterDeclaration;
import org.eclipselabs.mscript.language.interpreter.IStaticEvaluationContext;
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

		Helper helper = new Helper(block);

		ComponentSignature signature = new ComponentSignature(incomingDataTypes);
		
		FunctionDefinition functionDefinition;
		try {
			functionDefinition = helper.createFunctionDefinition();
		} catch (CoreException e) {
			status.add(e.getStatus());
			return new ComponentSignatureEvaluationResult(status);
		}

		List<IValue> templateArguments = helper.getTemplateArguments(functionDefinition, status);
		List<DataType> inputParameterDataTypes = helper.getInputParameterDataTypes(
				functionDefinition, signature, status);

		if (status.getSeverity() > IStatus.WARNING) {
			return new ComponentSignatureEvaluationResult(status);
		}

		if (inputParameterDataTypes == null) {
			return new ComponentSignatureEvaluationResult();
		}

		IStaticEvaluationContext staticEvaluationContext;
		try {
			staticEvaluationContext = helper.createStaticEvaluationContext(functionDefinition, templateArguments, inputParameterDataTypes);
		} catch (CoreException e) {
			status.add(e.getStatus());
			return new ComponentSignatureEvaluationResult(status);
		}
		
		if (!helper.getStatus().isOK()) {
			status.merge(helper.getStatus());
		}

		Iterator<OutputParameterDeclaration> outputParameterDeclarationIt = functionDefinition.getOutputParameterDeclarations().iterator();
		for (Output output : block.getOutputs()) {
			BlockOutput blockOutput = (BlockOutput) output;
			
			if (!outputParameterDeclarationIt.hasNext()) {
				status.add(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "No output parameter found for output '" + blockOutput.getDefinition().getName() + "'"));
				break;
			}
			
			OutputParameterDeclaration outputParameterDeclaration = outputParameterDeclarationIt.next();
			DataType dataType = staticEvaluationContext.getValue(outputParameterDeclaration).getDataType();

			if (blockOutput.getDefinition().isManyPorts() || blockOutput.getDefinition().getMinimumPortCount() == 0) {
				if (!(dataType instanceof ArrayType)) {
					status.add(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Output '"
							+ outputParameterDeclaration.getName() + "' must result to array type"));
					continue;
				}
				ArrayType arrayType = (ArrayType) dataType;

				for (OutputPort outputPort : output.getPorts()) {
					signature.getOutputDataTypes().put(outputPort, EcoreUtil.copy(arrayType.getElementType()));
				}
			} else {
				if (output.getPorts().isEmpty()) {
					status.add(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Invalid output '"
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
		protected IValue getGlobalTemplateArgument(String name) throws CoreException {
			if (SAMPLE_TIME_TEMPLATE_PARAMETER_NAME.equals(name)) {
				RealType realType = TypeSystemFactory.eINSTANCE.createRealType();
				realType.setUnit(TypeSystemUtil.createUnit(UnitSymbol.SECOND));
				return Values.valueOf(new ComputationContext(), realType, 1);
			}
			if (SAMPLE_RATE_TEMPLATE_PARAMETER_NAME.equals(name)) {
				RealType realType = TypeSystemFactory.eINSTANCE.createRealType();
				Unit herzUnit = TypeSystemUtil.createUnit(UnitSymbol.SECOND);
				herzUnit.getNumerator().getFactor(UnitSymbol.SECOND).setExponent(-1);
				realType.setUnit(herzUnit);
				return Values.valueOf(new ComputationContext(), realType, 1);
			}
			return super.getGlobalTemplateArgument(name);
		}
		
	}

}