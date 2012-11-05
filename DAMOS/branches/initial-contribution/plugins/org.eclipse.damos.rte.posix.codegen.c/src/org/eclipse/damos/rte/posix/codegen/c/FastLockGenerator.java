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

package org.eclipse.damos.rte.posix.codegen.c;

import org.eclipse.damos.codegen.c.rte.AbstractFastLockGenerator;

/**
 * @author Andreas Unger
 *
 */
public class FastLockGenerator extends AbstractFastLockGenerator {

	@Override
	public boolean contributesContextCode() {
		return true;
	}
	
	@Override
	public CharSequence generateContextCode(String variableName) {
		return new StringBuilder().append("pthread_mutex_t ").append(variableName).append(";\n");
	}
	
	@Override
	public boolean contributesInitializationCode() {
		return true;
	}
	
	@Override
	public CharSequence generateInitializationCode(String variableName) {
		return new StringBuilder().append("pthread_mutex_init(&").append(variableName).append(", NULL);\n");
	}

	@Override
	public CharSequence generateLockCode(String variableName) {
		return new StringBuilder().append("pthread_mutex_lock(&").append(variableName).append(");\n");
	}
	
	@Override
	public CharSequence generateUnlockCode(String variableName) {
		return new StringBuilder().append("pthread_mutex_unlock(&").append(variableName).append(");\n");
	}

}
