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

import org.eclipselabs.damos.codegen.c.rte.AbstractMessageQueueGenerator;
import org.eclipselabs.damos.codegen.c.rte.IMessageQueueInfo;

/**
 * @author Andreas Unger
 *
 */
public class MessageQueueGenerator extends AbstractMessageQueueGenerator {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.rte.AbstractMessageQueueGenerator#contributesContextCode()
	 */
	@Override
	public boolean contributesContextCode() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.rte.AbstractMessageQueueGenerator#writeContextCode(java.lang.Appendable, java.lang.String, org.eclipselabs.damos.codegen.c.rte.IMessageQueueInfo)
	 */
	@Override
	public void writeContextCode(Appendable appendable, String variableName, IMessageQueueInfo info) throws IOException {
		appendable.append("DAMOS_POSIX_MESSAGE_QUEUE(").append(info.getCapacity()).append(", ")
				.append(info.getElementSize()).append(") ").append(variableName).append(";\n");
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.rte.AbstractMessageQueueGenerator#contributesInitializationCode()
	 */
	@Override
	public boolean contributesInitializationCode() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.rte.AbstractMessageQueueGenerator#writeInitializationCode(java.lang.Appendable, java.lang.String, org.eclipselabs.damos.codegen.c.rte.IMessageQueueInfo)
	 */
	@Override
	public void writeInitializationCode(Appendable appendable, String variableName, IMessageQueueInfo info) throws IOException {
		appendable.append("DamosPosixMessageQueue_init(").append("(DamosPosixMessageQueue *) &").append(variableName).append(", ")
				.append(info.getCapacity()).append(", ").append(info.getElementSize()).append(");\n");
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.rte.AbstractMessageQueueGenerator#writeSendCode(java.lang.Appendable, java.lang.String, java.lang.String, org.eclipselabs.damos.codegen.c.rte.IMessageQueueInfo)
	 */
	@Override
	public void writeSendCode(Appendable appendable, String variableName, String dataPointer, IMessageQueueInfo info) throws IOException {
		appendable.append("DamosPosixMessageQueue_send(").append("(DamosPosixMessageQueue *) &").append(variableName).append(", ")
				.append(dataPointer).append(");\n");
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.rte.AbstractMessageQueueGenerator#writeReceiveCode(java.lang.Appendable, java.lang.String, java.lang.String, org.eclipselabs.damos.codegen.c.rte.IMessageQueueInfo)
	 */
	@Override
	public void writeReceiveCode(Appendable appendable, String variableName, String dataPointer, IMessageQueueInfo info) throws IOException {
		appendable.append("DamosPosixMessageQueue_receive(").append("(DamosPosixMessageQueue *) &").append(variableName).append(", ")
				.append(dataPointer).append(");\n");
	}
	
}
