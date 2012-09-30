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
import org.eclipselabs.damos.mscript.FunctionDeclaration;
import org.eclipselabs.damos.mscript.OutputParameterDeclaration;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.interpreter.FunctionCallPath;
import org.eclipselabs.damos.mscript.interpreter.FunctionSignature;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationResult;
import org.eclipselabs.damos.mscript.interpreter.StaticEvaluationResult;

public class BehavioredBlockSignaturePolicy extends AbstractComponentSignaturePolicy {

	@Override
	public IComponentSignatureEvaluationResult evaluateSignature(Component component,
			Map<InputPort, Type> incomingDataTypes) {
		Block block = (Block) component;

		MultiStatus status = new MultiStatus(ExecutionPlugin.PLUGIN_ID, 0, "", null);

		BehavioredBlockHelper helper = new BehavioredBlockHelper(block);

		ComponentSignature componentSignature = new ComponentSignature(incomingDataTypes);
		
		FunctionDeclaration functionDeclaration;
		try {
			functionDeclaration = helper.getBehavior();
		} catch (CoreException e) {
			status.add(e.getStatus());
			return new ComponentSignatureEvaluationResult(status);
		}

		FunctionSignature functionSignature = helper.getFunctionSignature(functionDeclaration, componentSignature, status);
		
		if (status.getSeverity() > IStatus.WARNING) {
			return new ComponentSignatureEvaluationResult(status);
		}

		if (functionSignature == null) {
			return new ComponentSignatureEvaluationResult();
		}

		IStaticEvaluationResult staticEvaluationResult = new StaticEvaluationResult();
		helper.evaluateFunctionDeclaration(staticEvaluationResult, functionDeclaration, functionSignature);
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
			Type type = staticEvaluationResult.getFunctionInfo(FunctionCallPath.EMPTY).getValue(outputParameterDeclaration).getDataType();

			if (blockOutput.getDefinition().isManyPorts() || blockOutput.getDefinition().getMinimumPortCount() == 0) {
				if (!(type instanceof ArrayType)) {
					status.add(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "Output '"
							+ outputParameterDeclaration.getName() + "' must result to array type"));
					continue;
				}
				ArrayType arrayType = (ArrayType) type;

				for (OutputPort outputPort : output.getPorts()) {
					componentSignature.getOutputDataTypes().put(outputPort, EcoreUtil.copy(arrayType.getElementType()));
				}
			} else {
				if (output.getPorts().isEmpty()) {
					status.add(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "Invalid output '"
							+ outputParameterDeclaration.getName() + "'"));
					continue;
				}
				componentSignature.getOutputDataTypes().put(output.getPorts().get(0), type);
			}
		}

		if (status.getSeverity() > IStatus.WARNING) {
			return new ComponentSignatureEvaluationResult(status);
		}

		return new ComponentSignatureEvaluationResult(componentSignature, status);
	}

}