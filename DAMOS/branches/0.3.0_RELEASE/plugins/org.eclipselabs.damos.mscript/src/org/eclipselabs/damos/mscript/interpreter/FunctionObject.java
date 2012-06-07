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

package org.eclipselabs.damos.mscript.interpreter;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipselabs.damos.mscript.InputParameterDeclaration;
import org.eclipselabs.damos.mscript.OutputParameterDeclaration;
import org.eclipselabs.damos.mscript.StateVariableDeclaration;
import org.eclipselabs.damos.mscript.TemplateParameterDeclaration;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.functionmodel.FunctionInstance;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.Values;

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
		
		for (TemplateParameterDeclaration declaration : functionInstance.getFunctionDeclaration().getTemplateParameterDeclarations()) {
			IVariable variable = new Variable(context, declaration);
			IValue value = context.getStaticEvaluationContext().getValue(declaration);
			variable.setValue(0, Values.transform(context.getComputationContext(), value));
			functionObject.variables.put(declaration, variable);
		}
		
		for (InputParameterDeclaration declaration : functionInstance.getFunctionDeclaration().getInputParameterDeclarations()) {
			functionObject.variables.put(declaration, new Variable(context, declaration, context.getStaticEvaluationContext().getCircularBufferSize(declaration)));
		}
		
		for (OutputParameterDeclaration declaration : functionInstance.getFunctionDeclaration().getOutputParameterDeclarations()) {
			functionObject.variables.put(declaration, new Variable(context, declaration, context.getStaticEvaluationContext().getCircularBufferSize(declaration)));
		}
		
		for (StateVariableDeclaration declaration : functionInstance.getFunctionDeclaration().getStateVariableDeclarations()) {
			functionObject.variables.put(declaration, new Variable(context, declaration, context.getStaticEvaluationContext().getCircularBufferSize(declaration)));
		}
		
		return functionObject;
	}
	
	public FunctionInstance getFunctionInstance() {
		return functionInstance;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IFunctionObject#getVariables()
	 */
	public Collection<IVariable> getVariables() {
		return Collections.unmodifiableCollection(variables.values());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IFunctionObject#getVariable(org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration)
	 */
	public IVariable getVariable(VariableDeclaration declaration) {
		return variables.get(declaration);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IFunctionObject#incrementStepIndex()
	 */
	public void incrementStepIndex() {
		for (IVariable variable : variables.values()) {
			variable.incrementStepIndex();
		}
	}
	
}
