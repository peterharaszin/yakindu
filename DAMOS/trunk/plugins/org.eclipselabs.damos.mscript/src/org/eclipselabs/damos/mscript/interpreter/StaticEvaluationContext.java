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

import org.eclipselabs.damos.mscript.Evaluable;
import org.eclipselabs.damos.mscript.FunctionDefinition;
import org.eclipselabs.damos.mscript.VariableAccess;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.functionmodel.FunctionDescriptor;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class StaticEvaluationContext implements IStaticEvaluationContext {

	private final IComputationContext computationContext = new ComputationContext();
	
	private Map<Evaluable, IValue> values = new HashMap<Evaluable, IValue>();
	
	private Map<VariableAccess, Integer> stepIndices = new HashMap<VariableAccess, Integer>();
	private Map<VariableDeclaration, Integer> circularBufferSizes = new HashMap<VariableDeclaration, Integer>();
	
	private Map<FunctionDefinition, FunctionDescriptor> functionDescriptors = new HashMap<FunctionDefinition, FunctionDescriptor>();

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IEvaluationContext#getComputationContext()
	 */
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
	 * @see org.eclipselabs.mscript.language.interpreter.IStaticEvaluationContext#getStepIndex(org.eclipselabs.mscript.language.ast.VariableAccess)
	 */
	public int getStepIndex(VariableAccess variableAccess) {
		Integer stepIndex = stepIndices.get(variableAccess);
		if (stepIndex == null) {
			return 0;
		}
		return stepIndex;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IStaticEvaluationContext#setStepIndex(org.eclipselabs.mscript.language.ast.VariableAccess, int)
	 */
	public void setStepIndex(VariableAccess variableAccess, int stepIndex) {
		stepIndices.put(variableAccess, stepIndex);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationContext#getCircularBufferSize(org.eclipselabs.damos.mscript.VariableDeclaration)
	 */
	public int getCircularBufferSize(VariableDeclaration variableDeclaration) {
		Integer size = circularBufferSizes.get(variableDeclaration);
		return size != null ? size : 0;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationContext#setCircularBufferSize(org.eclipselabs.damos.mscript.VariableDeclaration, int)
	 */
	public void setCircularBufferSize(VariableDeclaration variableDeclaration, int size) {
		circularBufferSizes.put(variableDeclaration, size);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IStaticEvaluationContext#getFunctionDescriptor(org.eclipselabs.mscript.language.ast.FunctionDefinition)
	 */
	public FunctionDescriptor getFunctionDescriptor(FunctionDefinition functionDefinition) {
		return functionDescriptors.get(functionDefinition);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IStaticEvaluationContext#setFunctionDescriptor(org.eclipselabs.mscript.language.ast.FunctionDefinition, org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor)
	 */
	public void setFunctionDescriptor(FunctionDefinition functionDefinition, FunctionDescriptor functionDescriptor) {
		functionDescriptors.put(functionDefinition, functionDescriptor);
	}
	
}
