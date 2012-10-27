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

package org.eclipse.damos.mscript.function.transform;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.damos.mscript.function.FunctionInstance;
import org.eclipse.damos.mscript.interpreter.StaticFunctionInfo;

/**
 * @author Andreas Unger
 *
 * @noextend
 * @noimplement
 */
// TODO: Rename this class
public interface IFunctionDefinitionTransformerResult {

	FunctionInstance getFunctionInstance(StaticFunctionInfo functionInfo);
	void setFunctionInstance(StaticFunctionInfo functionInfo, FunctionInstance functionInstance);
	
	IStatus getStatus();
	void setStatus(IStatus status);
	
}