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

package org.eclipselabs.mscript.language.interpreter;

import org.eclipselabs.mscript.computation.core.IComputationContext;

/**
 * @author Andreas Unger
 * 
 * @noextend
 * @noimplement
 */
public interface IInterpreterContext {
	
	IComputationContext getComputationContext();

	IInterpreterScope getScope();
	void enterScope();
	void leaveScope();
	
	void setCanceled(boolean canceled);
	boolean isCanceled();

}
