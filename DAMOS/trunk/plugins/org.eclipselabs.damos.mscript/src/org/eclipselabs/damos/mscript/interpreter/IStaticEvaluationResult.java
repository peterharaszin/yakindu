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

import org.eclipse.core.runtime.IStatus;
import org.eclipselabs.damos.mscript.Evaluable;
import org.eclipselabs.damos.mscript.FeatureReference;
import org.eclipselabs.damos.mscript.FunctionDeclaration;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.function.FunctionDescription;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public interface IStaticEvaluationResult extends IStatusCollector {

	IComputationContext getComputationContext();
	
	IStatus getStatus();
	
	IValue getValue(Evaluable evaluable);
	void setValue(Evaluable evaluable, IValue value);
	
	int getStepIndex(FeatureReference variableReference);
	void setStepIndex(FeatureReference variableReference, int stepIndex);
	
	int getCircularBufferSize(VariableDeclaration variableDeclaration);
	void setCircularBufferSize(VariableDeclaration variableDeclaration, int size);
	
	FunctionDescription getFunctionDescription(FunctionDeclaration functionDeclaration);
	void setFunctionDescription(FunctionDeclaration functionDeclaration, FunctionDescription functionDescription);
	
	StaticFunctionInfo getFunctionInfo(FunctionCallPath functionCallPath);
	void setFunctionInfo(FunctionCallPath functionCallPath, StaticFunctionInfo functionInfo);
	
	Iterable<StaticFunctionInfo> getFunctionInfos();
	Iterable<FunctionCallPath> getFunctionCallPaths();
	
}
