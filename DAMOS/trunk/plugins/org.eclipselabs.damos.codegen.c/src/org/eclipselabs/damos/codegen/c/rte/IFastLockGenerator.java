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
public interface IFastLockGenerator {

	boolean contributesContextCode();
	CharSequence generateContextCode(String variableName);

	boolean contributesInitializationCode();
	CharSequence generateInitializationCode(String variableName);

	CharSequence generateLockCode(String variableName);
	CharSequence generateUnlockCode(String variableName);
	
}
