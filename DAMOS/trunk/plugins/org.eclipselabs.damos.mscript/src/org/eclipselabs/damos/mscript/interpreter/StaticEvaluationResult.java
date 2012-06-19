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

package org.eclipselabs.damos.mscript.interpreter;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipselabs.damos.mscript.Evaluable;
import org.eclipselabs.damos.mscript.FunctionDeclaration;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.VariableReference;
import org.eclipselabs.damos.mscript.functionmodel.FunctionDescriptor;
import org.eclipselabs.damos.mscript.internal.MscriptPlugin;
import org.eclipselabs.damos.mscript.internal.util.StatusUtil;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class StaticEvaluationResult implements IStaticEvaluationResult {

	private final IComputationContext computationContext = new ComputationContext();
	
	private Map<Evaluable, IValue> values = new HashMap<Evaluable, IValue>();
	
	private Map<VariableReference, Integer> stepIndices = new HashMap<VariableReference, Integer>();
	private Map<VariableDeclaration, Integer> circularBufferSizes = new HashMap<VariableDeclaration, Integer>();
	
	private Map<FunctionDeclaration, FunctionDescriptor> functionDescriptors = new HashMap<FunctionDeclaration, FunctionDescriptor>();
	
	private MultiStatus status = new MultiStatus(MscriptPlugin.PLUGIN_ID, 0, "Expression evaluation", null);

	/**
	 * @return the status
	 */
	public MultiStatus getStatus() {
		return status;
	}
	
	public void collectStatus(IStatus status) {
		StatusUtil.merge(this.status, status);
	}

	public IComputationContext getComputationContext() {
		return computationContext;
	}
	
	public IValue getValue(Evaluable evaluable) {
		return values.get(evaluable);
	}

	public void setValue(Evaluable evaluable, IValue value) {
		values.put(evaluable, value);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IStaticEvaluationResult#getStepIndex(org.eclipselabs.mscript.language.ast.VariableAccess)
	 */
	public int getStepIndex(VariableReference variableReference) {
		Integer stepIndex = stepIndices.get(variableReference);
		if (stepIndex == null) {
			return 0;
		}
		return stepIndex;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IStaticEvaluationResult#setStepIndex(org.eclipselabs.mscript.language.ast.VariableAccess, int)
	 */
	public void setStepIndex(VariableReference variableReference, int stepIndex) {
		stepIndices.put(variableReference, stepIndex);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationResult#getCircularBufferSize(org.eclipselabs.damos.mscript.VariableDeclaration)
	 */
	public int getCircularBufferSize(VariableDeclaration variableDeclaration) {
		Integer size = circularBufferSizes.get(variableDeclaration);
		return size != null ? size : 1;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationResult#setCircularBufferSize(org.eclipselabs.damos.mscript.VariableDeclaration, int)
	 */
	public void setCircularBufferSize(VariableDeclaration variableDeclaration, int size) {
		circularBufferSizes.put(variableDeclaration, size);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IStaticEvaluationResult#getFunctionDescriptor(org.eclipselabs.mscript.language.ast.FunctionDefinition)
	 */
	public FunctionDescriptor getFunctionDescriptor(FunctionDeclaration functionDeclaration) {
		return functionDescriptors.get(functionDeclaration);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IStaticEvaluationResult#setFunctionDescriptor(org.eclipselabs.mscript.language.ast.FunctionDefinition, org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor)
	 */
	public void setFunctionDescriptor(FunctionDeclaration functionDeclaration, FunctionDescriptor functionDescriptor) {
		functionDescriptors.put(functionDeclaration, functionDescriptor);
	}
	
}
