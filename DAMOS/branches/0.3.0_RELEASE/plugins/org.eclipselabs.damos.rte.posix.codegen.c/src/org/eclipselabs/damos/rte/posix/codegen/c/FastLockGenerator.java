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

package org.eclipselabs.damos.rte.posix.codegen.c;

import java.io.IOException;

import org.eclipselabs.damos.codegen.c.rte.AbstractFastLockGenerator;

/**
 * @author Andreas Unger
 *
 */
public class FastLockGenerator extends AbstractFastLockGenerator {

	@Override
	public boolean contributesContextCode() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.rte.AbstractSimpleLockGenerator#writeContextCode(java.lang.Appendable, java.lang.String)
	 */
	@Override
	public void writeContextCode(Appendable appendable, String variableName) throws IOException {
		appendable.append("pthread_mutex_t ").append(variableName).append(";\n");
	}
	
	@Override
	public boolean contributesInitializationCode() {
		return true;
	}
	
	@Override
	public void writeInitializationCode(Appendable appendable, String variableName) throws IOException {
		appendable.append("pthread_mutex_init(&").append(variableName).append(", NULL);\n");
	}

	@Override
	public void writeLockCode(Appendable appendable, String variableName) throws IOException {
		appendable.append("pthread_mutex_lock(&").append(variableName).append(");\n");
	}
	
	@Override
	public void writeUnlockCode(Appendable appendable, String variableName) throws IOException {
		appendable.append("pthread_mutex_unlock(&").append(variableName).append(");\n");
	}

}
