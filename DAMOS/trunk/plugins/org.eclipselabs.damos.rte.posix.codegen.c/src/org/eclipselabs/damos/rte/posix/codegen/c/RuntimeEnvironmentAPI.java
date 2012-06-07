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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipselabs.damos.codegen.c.IGeneratorContext;
import org.eclipselabs.damos.codegen.c.rte.AbstractRuntimeEnvironmentAPI;
import org.eclipselabs.damos.codegen.c.rte.IFastLockGenerator;
import org.eclipselabs.damos.codegen.c.rte.IMessageQueueGenerator;
import org.eclipselabs.damos.codegen.c.rte.ISemaphoreGenerator;
import org.eclipselabs.damos.mscript.codegen.c.Include;

/**
 * @author Andreas Unger
 *
 */
public class RuntimeEnvironmentAPI extends AbstractRuntimeEnvironmentAPI {

	private static final Collection<Include> IMPLEMENTATION_INCLUDES = new ArrayList<Include>();
	
	static {
		IMPLEMENTATION_INCLUDES.add(new Include("pthread.h"));
		IMPLEMENTATION_INCLUDES.add(new Include("semaphore.h"));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.rte.IRuntimeEnvironmentAPI#getMultitaskingIncludes()
	 */
	public Collection<Include> getImplementationIncludes() {
		return IMPLEMENTATION_INCLUDES;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.rte.IRuntimeEnvironmentAPI#getTaskInfoIncludes()
	 */
	public Collection<Include> getForwardDeclarationIncludes() {
		return Collections.emptyList();
	}
	
	public CharSequence generateTaskInfoStructName(IGeneratorContext context) {
		context.addCodeFragment(new TaskInfoStruct(), new NullProgressMonitor());
		return "Damos_Posix_TaskInfo";
	}
	
	public IFastLockGenerator getFastLockGenerator() {
		return new FastLockGenerator();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.rte.IRuntimeEnvironmentAPI#getSemaphoreGenerator()
	 */
	public ISemaphoreGenerator getSemaphoreGenerator() {
		return new SemaphoreGenerator();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.rte.IRuntimeEnvironmentAPI#getMessageQueueGenerator()
	 */
	public IMessageQueueGenerator getMessageQueueGenerator() {
		return new MessageQueueGenerator();
	}
	
	public CharSequence generateTaskFunctionType(String name) {
		return new StringBuilder().append("void *(*").append(name).append(")(void *context)");
	}
	
	public CharSequence generateTaskSignature(String name) {
		return new StringBuilder().append("void *").append(name).append("(void *context)");
	}

	public CharSequence generateTaskReturnStatement(String name) {
		return new StringBuilder().append("return NULL;\n");
	}
	
}
