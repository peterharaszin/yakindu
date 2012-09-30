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

package org.eclipselabs.damos.codegen.c;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.ContextStruct;

/**
 * @author Andreas Unger
 *
 */
public interface ITaskGenerator {

	void addTaskContexts(IGeneratorContext context, ContextStruct contextStruct, IProgressMonitor monitor);

	CharSequence generateInitializeTasks(IGeneratorContext context, IProgressMonitor monitor);
	
	boolean contributesLatchUpdate(IGeneratorContext context, ComponentNode componentNode);
	
	CharSequence generateLatchUpdate(IGeneratorContext context, ComponentNode componentNode, IProgressMonitor monitor);

	boolean contributesMessageQueueSend(IGeneratorContext context, ComponentNode componentNode);
	
	CharSequence generateMessageQueueSend(IGeneratorContext context, ComponentNode componentNode, IProgressMonitor monitor);

}
