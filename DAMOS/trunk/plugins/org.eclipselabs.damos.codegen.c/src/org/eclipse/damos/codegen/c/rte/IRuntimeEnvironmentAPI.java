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

package org.eclipse.damos.codegen.c.rte;

import java.util.Collection;

import org.eclipse.damos.codegen.c.IGeneratorContext;
import org.eclipse.damos.mscript.codegen.c.Include;

/**
 * @author Andreas Unger
 *
 */
public interface IRuntimeEnvironmentAPI {

	Collection<Include> getImplementationIncludes();
	Collection<Include> getForwardDeclarationIncludes();
	
    CharSequence generateTaskInfoStructName(IGeneratorContext context);
	
	IFastLockGenerator getFastLockGenerator();
	ISemaphoreGenerator getSemaphoreGenerator();
	IMessageQueueGenerator getMessageQueueGenerator();
	
	CharSequence generateTaskFunctionType(String name);
	CharSequence generateTaskSignature(String name);
	CharSequence generateTaskReturnStatement(String name);
	
}
