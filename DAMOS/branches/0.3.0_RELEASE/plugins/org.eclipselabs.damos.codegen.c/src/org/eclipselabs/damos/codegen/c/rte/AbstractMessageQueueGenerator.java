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

import org.eclipselabs.damos.codegen.c.IGeneratorContext;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractMessageQueueGenerator implements IMessageQueueGenerator {

	public boolean contributesContextCode() {
		return false;
	}

	public void writeContextCode(IGeneratorContext context, Appendable appendable, String variableName, IMessageQueueInfo info) throws IOException {
	}

	public boolean contributesInitializationCode() {
		return false;
	}

	public void writeInitializationCode(IGeneratorContext context, Appendable appendable, String variableName, IMessageQueueInfo info) throws IOException {
	}

	public void writeSendCode(IGeneratorContext context, Appendable appendable, String variableName, String dataPointer, IMessageQueueInfo info) throws IOException {
	}

	public void writeReceiveCode(IGeneratorContext context, Appendable appendable, String variableName, String dataPointer, IMessageQueueInfo info) throws IOException {
	}

}
