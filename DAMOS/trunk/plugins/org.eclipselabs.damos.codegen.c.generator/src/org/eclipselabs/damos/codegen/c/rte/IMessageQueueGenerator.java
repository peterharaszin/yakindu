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
public interface IMessageQueueGenerator {

	boolean contributesContextCode();
	void writeContextCode(Appendable appendable, String variableName, IMessageQueueInfo info) throws IOException;

	boolean contributesInitializationCode();
	void writeInitializationCode(Appendable appendable, String variableName, IMessageQueueInfo info) throws IOException;

	void writeSendCode(Appendable appendable, String variableName, String dataPointer, IMessageQueueInfo info) throws IOException;
	void writeReceiveCode(Appendable appendable, String variableName, String dataPointer, IMessageQueueInfo info) throws IOException;

}
