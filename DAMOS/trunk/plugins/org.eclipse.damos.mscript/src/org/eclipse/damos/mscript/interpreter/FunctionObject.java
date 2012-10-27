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

package org.eclipse.damos.mscript.interpreter;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.damos.mscript.ConstantDeclaration;
import org.eclipse.damos.mscript.InputParameterDeclaration;
import org.eclipse.damos.mscript.OutputParameterDeclaration;
import org.eclipse.damos.mscript.StateVariableDeclaration;
import org.eclipse.damos.mscript.VariableDeclaration;
import org.eclipse.damos.mscript.function.FunctionInstance;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.mscript.interpreter.value.Values;

/**
 * @author Andreas Unger
 *
 */
public class FunctionObject implements IFunctionObject {

	private FunctionInstance functionInstance;
	private Map<VariableDeclaration, IVariable> variables = new HashMap<VariableDeclaration, IVariable>();
	
	/**
	 * 
	 */
	private FunctionObject() {
	}
	
	public static IFunctionObject create(IInterpreterContext context, FunctionInstance functionInstance) {
		FunctionObject functionObject = new FunctionObject();
		functionObject.functionInstance = functionInstance;
		
		for (InputParameterDeclaration declaration : functionInstance.getDeclaration().getConstantInputParameterDeclarations()) {
			createStaticVariable(context, functionObject, declaration);
		}
		
		for (ConstantDeclaration declaration : functionInstance.getDeclaration().getConstantDeclarations()) {
			createStaticVariable(context, functionObject, declaration);
		}

		for (InputParameterDeclaration declaration : functionInstance.getDeclaration().getNonConstantInputParameterDeclarations()) {
			functionObject.variables.put(declaration, new Variable(context, declaration, context.getStaticEvaluationResult().getFunctionInfo(context.getFunctionCallPath()).getCircularBufferSize(declaration)));
		}
		
		for (OutputParameterDeclaration declaration : functionInstance.getDeclaration().getOutputParameterDeclarations()) {
			functionObject.variables.put(declaration, new Variable(context, declaration, context.getStaticEvaluationResult().getFunctionInfo(context.getFunctionCallPath()).getCircularBufferSize(declaration)));
		}
		
		for (StateVariableDeclaration declaration : functionInstance.getDeclaration().getStateVariableDeclarations()) {
			functionObject.variables.put(declaration, new Variable(context, declaration, context.getStaticEvaluationResult().getFunctionInfo(context.getFunctionCallPath()).getCircularBufferSize(declaration)));
		}
		
		return functionObject;
	}

	/**
	 * @param context
	 * @param functionObject
	 * @param variableDeclaration
	 */
	private static void createStaticVariable(IInterpreterContext context, FunctionObject functionObject,
			VariableDeclaration variableDeclaration) {
		IVariable variable = new Variable(context, variableDeclaration);
		IValue value = context.getStaticEvaluationResult().getFunctionInfo(context.getFunctionCallPath()).getValue(variableDeclaration);
		variable.setValue(0, Values.transform(context.getComputationContext(), value));
		functionObject.variables.put(variableDeclaration, variable);
	}
	
	public FunctionInstance getFunctionInstance() {
		return functionInstance;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.language.interpreter.IFunctionObject#getVariables()
	 */
	public Collection<IVariable> getVariables() {
		return Collections.unmodifiableCollection(variables.values());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.language.interpreter.IFunctionObject#getVariable(org.eclipse.damos.mscript.language.imperativemodel.VariableDeclaration)
	 */
	public IVariable getVariable(VariableDeclaration declaration) {
		return variables.get(declaration);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.interpreter.IFunctionObject#addVariable(org.eclipse.damos.mscript.interpreter.IVariable)
	 */
	public void addVariable(IVariable variable) {
		variables.put(variable.getDeclaration(), variable);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.language.interpreter.IFunctionObject#incrementStepIndex()
	 */
	public void incrementStepIndex() {
		for (IVariable variable : variables.values()) {
			variable.incrementStepIndex();
		}
	}
	
}
