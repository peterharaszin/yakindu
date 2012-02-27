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

import java.io.IOException;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractMessageQueueGenerator implements IMessageQueueGenerator {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.rte.ISimpleLockGenerator#contributesContextStructCode()
	 */
	public boolean contributesContextCode() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.rte.ISimpleLockGenerator#writeContextStructCode(java.lang.Appendable)
	 */
	public void writeContextCode(Appendable appendable, String variableName, IMessageQueueInfo info) throws IOException {
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.rte.ISimpleLockGenerator#contributesInitializationCode()
	 */
	public boolean contributesInitializationCode() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.rte.ISimpleLockGenerator#writeInitializationCode(java.lang.Appendable, java.lang.String)
	 */
	public void writeInitializationCode(Appendable appendable, String variableName, IMessageQueueInfo info) throws IOException {
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.rte.ISimpleLockGenerator#writeLockCode(java.lang.Appendable, java.lang.String)
	 */
	public void writeSendCode(Appendable appendable, String variableName, String dataPointer, IMessageQueueInfo info) throws IOException {
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.rte.ISimpleLockGenerator#writeUnlockCode(java.lang.Appendable, java.lang.String)
	 */
	public void writeReceiveCode(Appendable appendable, String variableName, String dataPointer, IMessageQueueInfo info) throws IOException {
	}

}
