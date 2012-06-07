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

import org.eclipselabs.damos.codegen.c.rte.AbstractSemaphoreGenerator;
import org.eclipselabs.damos.codegen.c.rte.ISemaphoreInfo;

/**
 * @author Andreas Unger
 *
 */
public class SemaphoreGenerator extends AbstractSemaphoreGenerator {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.rte.AbstractSemaphoreGenerator#contributesContextCode()
	 */
	@Override
	public boolean contributesContextCode() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.rte.AbstractSemaphoreGenerator#writeContextCode(java.lang.Appendable, java.lang.String, org.eclipselabs.damos.codegen.c.rte.ISemaphoreInfo)
	 */
	@Override
	public void writeContextCode(Appendable appendable, String variableName, ISemaphoreInfo info) throws IOException {
		appendable.append("sem_t ").append(variableName).append(";\n");
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.rte.AbstractSemaphoreGenerator#contributesInitializationCode()
	 */
	@Override
	public boolean contributesInitializationCode() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.rte.AbstractSemaphoreGenerator#writeInitializationCode(java.lang.Appendable, java.lang.String, org.eclipselabs.damos.codegen.c.rte.ISemaphoreInfo)
	 */
	@Override
	public void writeInitializationCode(Appendable appendable, String variableName, ISemaphoreInfo info) throws IOException {
		appendable.append("sem_init(&").append(variableName).append(", 0, ").append(info.getInitialCount()).append(");\n");
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.rte.AbstractSemaphoreGenerator#writeDownCode(java.lang.Appendable, java.lang.String, org.eclipselabs.damos.codegen.c.rte.ISemaphoreInfo)
	 */
	@Override
	public void writeDownCode(Appendable appendable, String variableName, ISemaphoreInfo info) throws IOException {
		appendable.append("sem_wait(&").append(variableName).append(");\n");
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.rte.AbstractSemaphoreGenerator#writeUpCode(java.lang.Appendable, java.lang.String, org.eclipselabs.damos.codegen.c.rte.ISemaphoreInfo)
	 */
	@Override
	public void writeUpCode(Appendable appendable, String variableName, ISemaphoreInfo info) throws IOException {
		appendable.append("sem_post(&").append(variableName).append(");\n");
	}
	
}
