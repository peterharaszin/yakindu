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

package org.eclipse.damos.codegen.c.rte;

import org.eclipse.damos.codegen.c.IGeneratorContext;

/**
 * @author Andreas Unger
 *
 */
public interface IMessageQueueGenerator {

	boolean contributesContextCode();
	CharSequence generateContextCode(IGeneratorContext context, String variableName, IMessageQueueInfo info);

	boolean contributesInitializationCode();
	CharSequence generateInitializationCode(IGeneratorContext context, String variableName, IMessageQueueInfo info);

	CharSequence generateSendCode(IGeneratorContext context, String variableName, String dataPointer, IMessageQueueInfo info);
	CharSequence generateReceiveCode(IGeneratorContext context, String variableName, String dataPointer, IMessageQueueInfo info);

}
