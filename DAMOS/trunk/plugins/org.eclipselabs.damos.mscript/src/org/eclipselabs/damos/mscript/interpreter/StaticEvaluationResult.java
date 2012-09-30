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

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipselabs.damos.mscript.Evaluable;
import org.eclipselabs.damos.mscript.FeatureReference;
import org.eclipselabs.damos.mscript.FunctionDeclaration;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.function.FunctionDescription;
import org.eclipselabs.damos.mscript.function.transform.FunctionDefinitionTransformerResult;
import org.eclipselabs.damos.mscript.function.transform.IFunctionDefinitionTransformerResult;
import org.eclipselabs.damos.mscript.internal.MscriptPlugin;
import org.eclipselabs.damos.mscript.internal.util.StatusUtil;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;

import com.google.common.collect.ImmutableSet;

/**
 * @author Andreas Unger
 *
 */
public class StaticEvaluationResult implements IStaticEvaluationResult {

	private final IComputationContext computationContext = new ComputationContext();
	
	private Map<FunctionCallPath, StaticFunctionInfo> functionInfos = new LinkedHashMap<FunctionCallPath, StaticFunctionInfo>();
	
	private MultiStatus status = new MultiStatus(MscriptPlugin.PLUGIN_ID, 0, "Expression evaluation", null);
	
	private IFunctionDefinitionTransformerResult functionTransformationCache = new FunctionDefinitionTransformerResult();

	/**
	 * 
	 */
	public StaticEvaluationResult() {
		functionInfos.put(FunctionCallPath.EMPTY, new StaticFunctionInfo(null));
	}
	
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
		return functionInfos.get(FunctionCallPath.EMPTY).getValue(evaluable);
	}

	public void setValue(Evaluable evaluable, IValue value) {
		functionInfos.get(FunctionCallPath.EMPTY).setValue(evaluable, value);
	}
	
	public int getStepIndex(FeatureReference variableReference) {
		Integer stepIndex = functionInfos.get(FunctionCallPath.EMPTY).getStepIndex(variableReference);
		if (stepIndex == null) {
			return 0;
		}
		return stepIndex;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IStaticEvaluationResult#setStepIndex(org.eclipselabs.mscript.language.ast.VariableAccess, int)
	 */
	public void setStepIndex(FeatureReference variableReference, int stepIndex) {
		functionInfos.get(FunctionCallPath.EMPTY).setStepIndex(variableReference, stepIndex);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationResult#getCircularBufferSize(org.eclipselabs.damos.mscript.VariableDeclaration)
	 */
	public int getCircularBufferSize(VariableDeclaration variableDeclaration) {
		Integer size = functionInfos.get(FunctionCallPath.EMPTY).getCircularBufferSize(variableDeclaration);
		return size != null ? size : 1;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationResult#setCircularBufferSize(org.eclipselabs.damos.mscript.VariableDeclaration, int)
	 */
	public void setCircularBufferSize(VariableDeclaration variableDeclaration, int size) {
		functionInfos.get(FunctionCallPath.EMPTY).setCircularBufferSize(variableDeclaration, size);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IStaticEvaluationResult#getFunctionDescription(org.eclipselabs.mscript.language.ast.FunctionDefinition)
	 */
	public FunctionDescription getFunctionDescription(FunctionDeclaration functionDeclaration) {
		return functionInfos.get(FunctionCallPath.EMPTY).getFunctionDescription();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IStaticEvaluationResult#setFunctionDescription(org.eclipselabs.mscript.language.ast.FunctionDefinition, org.eclipselabs.mscript.language.function.FunctionDescription)
	 */
	public void setFunctionDescription(FunctionDeclaration functionDeclaration, FunctionDescription functionDescription) {
		functionInfos.get(FunctionCallPath.EMPTY).setFunctionDescription(functionDescription);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationResult#getFunctionInfo(org.eclipselabs.damos.mscript.interpreter.FunctionCallPath)
	 */
	public StaticFunctionInfo getFunctionInfo(FunctionCallPath functionCallPath) {
		return functionInfos.get(functionCallPath);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationResult#setFunctionInfo(org.eclipselabs.damos.mscript.interpreter.FunctionCallPath, org.eclipselabs.damos.mscript.interpreter.StaticFunctionInfo)
	 */
	public void setFunctionInfo(FunctionCallPath functionCallPath, StaticFunctionInfo functionInfo) {
		functionInfos.put(functionCallPath, functionInfo);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationResult#getFunctionInfos()
	 */
	public Iterable<StaticFunctionInfo> getFunctionInfos() {
		return ImmutableSet.copyOf(functionInfos.values());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationResult#getFunctionCallPaths()
	 */
	public Iterable<FunctionCallPath> getFunctionCallPaths() {
		return functionInfos.keySet();
	}
	
	public IFunctionDefinitionTransformerResult getFunctionTransformationCache() {
		return functionTransformationCache;
	}
	
}
