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

package org.eclipselabs.damos.mscript.interpreter.util;

import java.util.Collections;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipselabs.damos.mscript.Compound;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.LocalVariableDeclaration;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.il.transform.ExpressionTarget;
import org.eclipselabs.damos.mscript.il.transform.ExpressionTransformer;
import org.eclipselabs.damos.mscript.il.transform.ITransformerContext;
import org.eclipselabs.damos.mscript.internal.MscriptPlugin;
import org.eclipselabs.damos.mscript.internal.util.StatusUtil;
import org.eclipselabs.damos.mscript.interpreter.CompoundInterpreter;
import org.eclipselabs.damos.mscript.interpreter.IInterpreterContext;
import org.eclipselabs.damos.mscript.interpreter.IVariable;
import org.eclipselabs.damos.mscript.interpreter.Variable;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionInterpreterHelper {
	
	private Compound compound;
	
	private ITransformerContext transformerContext;

	private IInterpreterContext interpreterContext;
	
	private Expression expression;
	
	/**
	 * 
	 */
	public ExpressionInterpreterHelper(ITransformerContext transformerContext, IInterpreterContext interpreterContext, Expression expression) {
		this.transformerContext = transformerContext;
		this.interpreterContext = interpreterContext;
		this.expression = expression;
	}

	public IValue evaluateSingle() throws CoreException {
		MultiStatus status = new MultiStatus(MscriptPlugin.PLUGIN_ID, 0, "Expression evaluation", null);
		
		LocalVariableDeclaration resultVariableDeclaration = MscriptFactory.eINSTANCE.createLocalVariableDeclaration();
		
		compound = MscriptFactory.eINSTANCE.createCompound();

		transformerContext.enterScope();
		transformerContext.setCompound(compound);
		
		try {
			ExpressionTarget target = new ExpressionTarget(resultVariableDeclaration, 0);
			
			IStatus transformationStatus = new ExpressionTransformer(transformerContext).transform(expression, Collections.singletonList(target));

			if (!transformationStatus.isOK()) {
				StatusUtil.merge(status, transformationStatus);
				throw new CoreException(status);
			}
			
			preprocessCompound(compound);

			IVariable outputVariable = new Variable(interpreterContext, resultVariableDeclaration);
			interpreterContext.addVariable(outputVariable);
			
			new CompoundInterpreter().execute(interpreterContext, compound);

			return outputVariable.getValue(0);
		} finally {
			transformerContext.leaveScope();
		}
	}
	
	protected void preprocessCompound(Compound compound) throws CoreException {
	}

}
