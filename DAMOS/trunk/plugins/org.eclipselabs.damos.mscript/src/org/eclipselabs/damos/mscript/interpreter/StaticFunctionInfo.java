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

package org.eclipselabs.damos.mscript.interpreter;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.mscript.Evaluable;
import org.eclipselabs.damos.mscript.FeatureReference;
import org.eclipselabs.damos.mscript.FunctionCall;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.function.FunctionDescription;
import org.eclipselabs.damos.mscript.function.FunctionInstance;
import org.eclipselabs.damos.mscript.function.transform.TransformAdapter;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class StaticFunctionInfo {

	private FunctionDescription functionDescription;

	private final Map<Evaluable, IValue> values = new HashMap<Evaluable, IValue>();
	
	private final Map<FeatureReference, Integer> stepIndices = new HashMap<FeatureReference, Integer>();
	
	private final Map<VariableDeclaration, Integer> circularBufferSizes = new HashMap<VariableDeclaration, Integer>();
	
	private final Map<FunctionCall, StaticFunctionInfo> callees = new HashMap<FunctionCall, StaticFunctionInfo>();
	
	private FunctionInstance functionInstance;

	/**
	 * 
	 */
	public StaticFunctionInfo(FunctionDescription functionDescription) {
		this.functionDescription = functionDescription;
	}

	public IValue getValue(Evaluable evaluable) {
		return values.get(evaluable);
	}

	public void setValue(Evaluable evaluable, IValue value) {
		values.put(evaluable, value);
	}
	
	public int getStepIndex(FeatureReference variableReference) {
		Integer stepIndex = stepIndices.get(variableReference);
		if (stepIndex == null) {
			return 0;
		}
		return stepIndex;
	}
	
	public void setStepIndex(FeatureReference variableReference, int stepIndex) {
		stepIndices.put(variableReference, stepIndex);
	}
	
	public int getCircularBufferSize(VariableDeclaration variableDeclaration) {
		Integer size = circularBufferSizes.get(variableDeclaration);
		return size != null ? size : 1;
	}
	
	public void setCircularBufferSize(VariableDeclaration variableDeclaration, int size) {
		circularBufferSizes.put(variableDeclaration, size);
	}

	/**
	 * @return the functionDescription
	 */
	public FunctionDescription getFunctionDescription() {
		return functionDescription;
	}
	
	/**
	 * @param functionDescription the functionDescription to set
	 */
	public void setFunctionDescription(FunctionDescription functionDescription) {
		this.functionDescription = functionDescription;
	}
	
	public void addCallee(FunctionCall functionCall, StaticFunctionInfo callee) {
		callees.put(functionCall, callee);
	}
	
	public StaticFunctionInfo getCallee(FunctionCall functionCall) {
		return callees.get(getActualFunctionCall(functionCall));
	}
	
	private FunctionCall getActualFunctionCall(FunctionCall functionCall) {
		@SuppressWarnings("unchecked")
		TransformAdapter<FunctionCall> adapter = (TransformAdapter<FunctionCall>) EcoreUtil.getAdapter(functionCall.eAdapters(), TransformAdapter.class);
		if (adapter != null) {
			return adapter.getOriginalElement();
		}
		return functionCall;
	}

	/**
	 * @return the functionInstance
	 */
	public FunctionInstance getFunctionInstance() {
		return functionInstance;
	}
	
	/**
	 * @param functionInstance the functionInstance to set
	 */
	public void setFunctionInstance(FunctionInstance functionInstance) {
		this.functionInstance = functionInstance;
	}

}
