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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.codegen.c.ContextStruct;
import org.eclipselabs.damos.codegen.c.IGeneratorContext;
import org.eclipselabs.damos.codegen.c.PrimaryCodeFragment;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationUtil;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentDependency;

/**
 * @author Andreas Unger
 *
 */
public class MessageQueueStruct extends PrimaryCodeFragment {

	private static final Collection<String> FORWARD_DECLARATION_INCLUDES = new ArrayList<String>();
	
	static {
		FORWARD_DECLARATION_INCLUDES.add("pthread.h");
		FORWARD_DECLARATION_INCLUDES.add("semaphore.h");
	}
	
	private String prefix;
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#getForwardDeclarationIncludes()
	 */
	@Override
	public Collection<String> getForwardDeclarationIncludes() {
		return FORWARD_DECLARATION_INCLUDES;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.PrimaryCodeFragment#doInitialize(org.eclipselabs.damos.codegen.c.IGeneratorContext, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected void doInitialize(IGeneratorContext context, IProgressMonitor monitor) throws IOException {
		addDependency(new ICodeFragmentDependency.Stub() {
			
			@Override
			public boolean forwardDeclarationRequiredBy(ICodeFragment other) {
				return other instanceof ContextStruct;
			}
			
		});
		
		prefix = GeneratorConfigurationUtil.getPrefix(context.getConfiguration());
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.ICodeFragment#writeForwardDeclaration(java.lang.Appendable, boolean)
	 */
	public void writeForwardDeclaration(Appendable appendable, boolean internal) throws IOException {
		appendable.append("typedef struct {\n");
		appendable.append("pthread_mutex_t mutex;\n");
		appendable.append("sem_t fillCount;\n");
		appendable.append("sem_t emptyCount;\n");
		appendable.append("int tail;\n");
		appendable.append("int head;\n");
		appendable.append("int size;\n");
		appendable.append("int elementSize;\n");
		appendable.append("} ").append(prefix).append("MessageQueue;\n\n");

		appendable.append("typedef struct {\n");
		appendable.append(prefix).append("MessageQueue base;\n");
		appendable.append("unsigned char buffer[1];\n");
		appendable.append("} ").append(prefix).append("MessageQueueWithBuffer;\n");
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
