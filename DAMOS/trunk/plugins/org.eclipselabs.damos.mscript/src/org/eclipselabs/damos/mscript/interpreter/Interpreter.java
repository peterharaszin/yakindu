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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipselabs.damos.mscript.Compound;
import org.eclipselabs.damos.mscript.InputParameterDeclaration;
import org.eclipselabs.damos.mscript.OutputParameterDeclaration;
import org.eclipselabs.damos.mscript.functionmodel.ComputationCompound;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class Interpreter implements IInterpreter {

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IInterpreter#initialize(org.eclipselabs.mscript.language.interpreter.IInterpreterContext, org.eclipselabs.mscript.language.interpreter.IFunctionObject)
	 */
	public void initialize(IInterpreterContext context, IFunctionObject functionObject) {
		Compound initializationCompound = functionObject.getFunctionInstance().getInitializationCompound();
		if (initializationCompound != null) {
			new CompoundInterpreter().execute(context, initializationCompound);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IInterpreter#execute(org.eclipselabs.mscript.language.interpreter.IInterpreterContext, org.eclipselabs.mscript.language.interpreter.IFunctionObject, java.util.List)
	 */
	public List<IValue> execute(IInterpreterContext context, IFunctionObject functionObject, List<IValue> inputValues) {
		Iterator<IValue> inputValueIterator = inputValues.iterator();
		for (InputParameterDeclaration inputParameterDeclaration : functionObject.getFunctionInstance().getFunctionDefinition().getInputParameterDeclarations()) {
			IVariable variable = functionObject.getVariable(inputParameterDeclaration);
			variable.setValue(0, inputValueIterator.next());
		}
		
		ICompoundInterpreter compoundInterpreter = new CompoundInterpreter();
		
		for (ComputationCompound compound : functionObject.getFunctionInstance().getComputationCompounds()) {
			compoundInterpreter.execute(context, compound);
		}
		
		List<IValue> outputValues = new ArrayList<IValue>();
		for (OutputParameterDeclaration outputVariableDeclaration : functionObject.getFunctionInstance().getFunctionDefinition().getOutputParameterDeclarations()) {
			outputValues.add(functionObject.getVariable(outputVariableDeclaration).getValue(0));
		}
		
		return outputValues;
	}
		
}
