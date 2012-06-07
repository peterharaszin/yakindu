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
public interface ISemaphoreGenerator {

	boolean contributesContextCode();
	CharSequence generateContextCode(String variableName, ISemaphoreInfo info);

	boolean contributesInitializationCode();
	CharSequence generateInitializationCode(String variableName, ISemaphoreInfo info);

	CharSequence generateDownCode(String variableName, ISemaphoreInfo info);
	CharSequence generateUpCode(String variableName, ISemaphoreInfo info);

}
