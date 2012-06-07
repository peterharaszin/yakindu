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

package org.eclipselabs.damos.mscript.functionmodel.transform;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.mscript.functionmodel.FunctionInstance;

/**
 * @author Andreas Unger
 *
 */
public class FunctionDefinitionTransformerResult implements IFunctionDefinitionTransformerResult {

	private FunctionInstance functionInstance;
	private IStatus status;
	
	public FunctionDefinitionTransformerResult(FunctionInstance functionInstance) {
		this(functionInstance, Status.OK_STATUS);
	}
	
	/**
	 * 
	 */
	public FunctionDefinitionTransformerResult(FunctionInstance functionInstance, IStatus status) {
		this.functionInstance = functionInstance;
		this.status = status;
	}
	
	public FunctionInstance getFunctionInstance() {
		return functionInstance;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.transform.IFunctionDefinitionTransformerResult#getStatus()
	 */
	public IStatus getStatus() {
		return status;
	}
	
}
