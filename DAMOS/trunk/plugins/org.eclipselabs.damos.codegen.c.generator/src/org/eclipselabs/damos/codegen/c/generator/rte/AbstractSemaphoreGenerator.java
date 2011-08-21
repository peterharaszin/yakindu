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

package org.eclipselabs.damos.codegen.c.generator.rte;

import java.io.IOException;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractSemaphoreGenerator implements ISemaphoreGenerator {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.rte.ISemaphoreGenerator#contributesContextCode()
	 */
	public boolean contributesContextCode() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.rte.ISemaphoreGenerator#writeContextCode(java.lang.Appendable, java.lang.String, org.eclipselabs.damos.codegen.c.generator.rte.ISemaphoreInfo)
	 */
	public void writeContextCode(Appendable appendable, String variableName, ISemaphoreInfo info) throws IOException {
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.rte.ISemaphoreGenerator#contributesInitializationCode()
	 */
	public boolean contributesInitializationCode() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.rte.ISemaphoreGenerator#writeInitializationCode(java.lang.Appendable, java.lang.String, org.eclipselabs.damos.codegen.c.generator.rte.ISemaphoreInfo)
	 */
	public void writeInitializationCode(Appendable appendable, String variableName, ISemaphoreInfo info) throws IOException {
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.rte.ISemaphoreGenerator#writeDownCode(java.lang.Appendable, java.lang.String, org.eclipselabs.damos.codegen.c.generator.rte.ISemaphoreInfo)
	 */
	public void writeDownCode(Appendable appendable, String variableName, ISemaphoreInfo info) throws IOException {
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.rte.ISemaphoreGenerator#writeUpCode(java.lang.Appendable, java.lang.String, org.eclipselabs.damos.codegen.c.generator.rte.ISemaphoreInfo)
	 */
	public void writeUpCode(Appendable appendable, String variableName, ISemaphoreInfo info) throws IOException {
	}
	
}
