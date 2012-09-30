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

package org.eclipselabs.damos.mscript.function.transform;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.mscript.function.FunctionInstance;
import org.eclipselabs.damos.mscript.interpreter.StaticFunctionInfo;

/**
 * @author Andreas Unger
 *
 */
public class FunctionDefinitionTransformerResult implements IFunctionDefinitionTransformerResult {

	private final Map<StaticFunctionInfo, FunctionInstance> functionInstances = new HashMap<StaticFunctionInfo, FunctionInstance>();
	private IStatus status = Status.OK_STATUS;
	
	public FunctionInstance getFunctionInstance(StaticFunctionInfo functionInfo) {
		return functionInstances.get(functionInfo);
	}
	
	public void setFunctionInstance(StaticFunctionInfo functionInfo, FunctionInstance functionInstance) {
		functionInstances.put(functionInfo, functionInstance);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.transform.IFunctionDefinitionTransformerResult#getStatus()
	 */
	public IStatus getStatus() {
		return status;
	}
	
	/**
	 * @param status the status to set
	 */
	public void setStatus(IStatus status) {
		this.status = status;
	}
	
}
