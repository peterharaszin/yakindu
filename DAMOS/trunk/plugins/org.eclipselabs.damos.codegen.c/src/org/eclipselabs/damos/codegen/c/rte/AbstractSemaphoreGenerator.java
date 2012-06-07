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

package org.eclipselabs.damos.codegen.c.rte;


/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractSemaphoreGenerator implements ISemaphoreGenerator {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.rte.ISemaphoreGenerator#contributesContextCode()
	 */
	public boolean contributesContextCode() {
		return false;
	}

	public CharSequence generateContextCode(String variableName, ISemaphoreInfo info) {
		return "";
	}

	public boolean contributesInitializationCode() {
		return false;
	}

	public CharSequence generateInitializationCode(String variableName, ISemaphoreInfo info) {
		return "";
	}

	public CharSequence generateDownCode(String variableName, ISemaphoreInfo info) {
		return "";
	}

	public CharSequence generateUpCode(String variableName, ISemaphoreInfo info) {
		return "";
	}
	
}
