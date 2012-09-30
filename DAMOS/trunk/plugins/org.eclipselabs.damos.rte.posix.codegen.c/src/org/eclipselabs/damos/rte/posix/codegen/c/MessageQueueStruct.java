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

package org.eclipselabs.damos.rte.posix.codegen.c;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.codegen.c.IGeneratorContext;
import org.eclipselabs.damos.codegen.c.codefragments.PrimaryCodeFragment;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationExtensions;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.Include;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.ContextStruct;

/**
 * @author Andreas Unger
 *
 */
public class MessageQueueStruct extends PrimaryCodeFragment {

	private static final Collection<Include> FORWARD_DECLARATION_INCLUDES = new ArrayList<Include>();
	
	static {
		FORWARD_DECLARATION_INCLUDES.add(new Include("pthread.h"));
		FORWARD_DECLARATION_INCLUDES.add(new Include("semaphore.h"));
	}
	
	private String prefix;
	
	@Override
	protected void doInitialize(IGeneratorContext context, IProgressMonitor monitor) {
		addDependency(FORWARD_DECLARATION_REQUIRED_BY, new IDependencyRule() {
			
			public boolean applies(ICodeFragment other) {
				return other instanceof ContextStruct;
			}
			
		});
		
		prefix = GeneratorConfigurationExtensions.getPrefix(context.getConfiguration());
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#getForwardDeclarationIncludes()
	 */
	@Override
	public Collection<Include> getForwardDeclarationIncludes() {
		return FORWARD_DECLARATION_INCLUDES;
	}
	
	public CharSequence generateForwardDeclaration(boolean internal) {
		StringBuilder sb = new StringBuilder();
		sb.append("typedef struct {\n");
		sb.append("pthread_mutex_t mutex;\n");
		sb.append("sem_t fillCount;\n");
		sb.append("sem_t emptyCount;\n");
		sb.append("int tail;\n");
		sb.append("int head;\n");
		sb.append("int size;\n");
		sb.append("int elementSize;\n");
		sb.append("} ").append(prefix).append("MessageQueue;\n\n");

		sb.append("typedef struct {\n");
		sb.append(prefix).append("MessageQueue base;\n");
		sb.append("unsigned char buffer[1];\n");
		sb.append("} ").append(prefix).append("MessageQueueWithBuffer;\n");
		return sb;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return obj instanceof MessageQueueStruct;
	}

}
