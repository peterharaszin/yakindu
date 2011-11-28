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

package org.eclipselabs.damos.mscript.il.transform;

import org.eclipselabs.damos.mscript.il.ILFunctionDefinition;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationContext;

/**
 * @author Andreas Unger
 *
 */
public class FunctionDefinitionTransformerContext extends TransformerContext implements IFunctionDefinitionTransformerContext {

	private ILFunctionDefinition functionDefinition;
	
	/**
	 * 
	 */
	public FunctionDefinitionTransformerContext(IStaticEvaluationContext staticEvaluationContext, ILFunctionDefinition functionDefinition) {
		super(staticEvaluationContext);
		this.functionDefinition = functionDefinition;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.transform.IFunctionDefinitionTransformerContext#getFunctionDefinition()
	 */
	public ILFunctionDefinition getFunctionDefinition() {
		return functionDefinition;
	}
	
}
