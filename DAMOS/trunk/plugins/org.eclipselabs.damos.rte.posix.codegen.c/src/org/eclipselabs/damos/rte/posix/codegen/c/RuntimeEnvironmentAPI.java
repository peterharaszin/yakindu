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

import org.eclipselabs.damos.codegen.c.rte.AbstractRuntimeEnvironmentAPI;
import org.eclipselabs.damos.codegen.c.rte.IFastLockGenerator;
import org.eclipselabs.damos.codegen.c.rte.IMessageQueueGenerator;
import org.eclipselabs.damos.codegen.c.rte.ISemaphoreGenerator;

/**
 * @author Andreas Unger
 *
 */
public class RuntimeEnvironmentAPI extends AbstractRuntimeEnvironmentAPI {

	public boolean contributesMultitaskingIncludes() {
		return true;
	}
	
	public void writeMultitaskingIncludes(Appendable appendable) throws IOException {
		appendable.append("#include <pthread.h>\n");
		appendable.append("#include <semaphore.h>\n");
		appendable.append("#include <damos/posix/mq.h>\n");
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.rte.IRuntimeEnvironmentAPI#writeTaskInfoInclude(java.lang.Appendable)
	 */
	public void writeTaskInfoInclude(Appendable appendable) throws IOException {
		appendable.append("#include <damos/posix/task.h>\n");
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.rte.IRuntimeEnvironmentAPI#getTaskInfoStructName()
	 */
	public String getTaskInfoStructName() {
		return "DamosPosixTaskInfo";
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
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.rte.IRuntimeEnvironmentAPI#writeTaskFunctionType(java.lang.Appendable, java.lang.String)
	 */
	public void writeTaskFunctionType(Appendable appendable, String name) throws IOException {
		appendable.append("void *(*").append(name).append(")(void *context)");
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.rte.IRuntimeEnvironmentAPI#writeTaskFunction(java.lang.Appendable, java.lang.String)
	 */
	public void writeTaskSignature(Appendable appendable, String name) throws IOException {
		appendable.append("void *").append(name).append("(void *context)");
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.rte.IRuntimeEnvironmentAPI#writeTaskReturnStatement(java.lang.Appendable, java.lang.String)
	 */
	public void writeTaskReturnStatement(Appendable appendable, String name) throws IOException {
		appendable.append("return NULL;");
	}
	
}
