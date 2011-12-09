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

package org.eclipselabs.damos.mscript.functionmodel.transform;

import org.eclipselabs.damos.mscript.functionmodel.FunctionInstance;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationContext;

/**
 * @author Andreas Unger
 *
 */
public class FunctionDefinitionTransformerContext extends TransformerContext implements IFunctionDefinitionTransformerContext {

	private FunctionInstance functionInstance;
	
	/**
	 * 
	 */
	public FunctionDefinitionTransformerContext(IStaticEvaluationContext staticEvaluationContext, FunctionInstance functionInstance) {
		super(staticEvaluationContext);
		this.functionInstance = functionInstance;
	}
	
	public FunctionInstance getFunctionInstance() {
		return functionInstance;
	}
	
}
