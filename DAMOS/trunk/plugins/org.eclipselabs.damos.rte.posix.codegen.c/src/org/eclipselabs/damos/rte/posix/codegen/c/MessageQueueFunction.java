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
import org.eclipselabs.damos.codegen.c.IGeneratorContext;
import org.eclipselabs.damos.codegen.c.PrimaryCodeFragment;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationUtil;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentDependency;

/**
 * @author Andreas Unger
 *
 */
public abstract class MessageQueueFunction extends PrimaryCodeFragment {

	private static final Collection<String> IMPLEMENTATION_INCLUDES = new ArrayList<String>();
	
	static {
		IMPLEMENTATION_INCLUDES.add("stddef.h");
		IMPLEMENTATION_INCLUDES.add("string.h");
	}

	private String prefix;
	private String functionSignature;
	
	/**
	 * @return the prefix
	 */
	protected String getPrefix() {
		return prefix;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#getImplementationIncludes()
	 */
	@Override
	public Collection<String> getImplementationIncludes() {
		return IMPLEMENTATION_INCLUDES;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.ICodeFragment#writeForwardDeclaration(java.lang.Appendable, boolean)
	 */
	public void writeForwardDeclaration(Appendable appendable, boolean internal) throws IOException {
		if (internal) {
			appendable.append("static ");
		}
		appendable.append(functionSignature);
		appendable.append(";\n");
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.PrimaryCodeFragment#doInitialize(org.eclipselabs.damos.codegen.c.IGeneratorContext, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected void doInitialize(IGeneratorContext context, IProgressMonitor monitor) throws IOException {
		addDependency(new ICodeFragmentDependency.Stub() {
			
			@Override
			public boolean forwardDeclarationDependsOn(ICodeFragment other) {
				return other instanceof MessageQueueStruct;
			}
			
		});

		prefix = GeneratorConfigurationUtil.getPrefix(context.getConfiguration());
		StringBuilder sb = new StringBuilder();
		writeFunctionSignature(sb);
		functionSignature = sb.toString();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#contributesImplementation()
	 */
	@Override
	public boolean contributesImplementation() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#writeImplementation(java.lang.Appendable, boolean)
	 */
	@Override
	public void writeImplementation(Appendable appendable, boolean internal) throws IOException {
		if (internal) {
			appendable.append("static ");
		}
		appendable.append(functionSignature);
		appendable.append(" {\n");
		writeBody(appendable);
		appendable.append("}\n");
	}
	
	protected abstract void writeFunctionSignature(Appendable appendable) throws IOException;
	
	protected abstract void writeBody(Appendable appendable) throws IOException;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
	
	public static class Init extends MessageQueueFunction {

		@Override
		protected void writeFunctionSignature(Appendable appendable) throws IOException {
			PrintAppendable out = new PrintAppendable(appendable);
			out.printf("void %sMessageQueue_init(%sMessageQueue *mq, int capacity, int elementSize)", getPrefix(), getPrefix());
		}

		@Override
		protected void writeBody(Appendable appendable) throws IOException {
			appendable.append("mq->tail = 0;\n");
			appendable.append("mq->head = 0;\n");
			appendable.append("pthread_mutex_init(&mq->mutex, NULL);\n");
			appendable.append("sem_init(&mq->fillCount, 0, 0);\n");
			appendable.append("sem_init(&mq->emptyCount, 0, capacity);\n");
			appendable.append("mq->size = capacity * elementSize;\n");
			appendable.append("mq->elementSize = elementSize;\n");
		}
		
		@Override
		public boolean equals(Object obj) {
			return obj instanceof Init;
		}

	}

	public static class Send extends MessageQueueFunction {
		
		@Override
		protected void writeFunctionSignature(Appendable appendable) throws IOException {
			PrintAppendable out = new PrintAppendable(appendable);
			out.printf("void %sMessageQueue_send(%sMessageQueue *mq, const void *data)", getPrefix(), getPrefix());
		}

		@Override
		protected void writeBody(Appendable appendable) throws IOException {
			PrintAppendable out = new PrintAppendable(appendable);
			out.println("sem_wait(&mq->emptyCount);");
			out.println("pthread_mutex_lock(&mq->mutex);");
			out.printf("memcpy(((%sMessageQueueWithBuffer *) mq)->buffer + mq->tail, data, mq->elementSize);\n", getPrefix());
			out.println("mq->tail = (mq->tail + mq->elementSize) % mq->size;");
			out.println("pthread_mutex_unlock(&mq->mutex);");
			out.println("sem_post(&mq->fillCount);");
		}
		
		@Override
		public boolean equals(Object obj) {
			return obj instanceof Send;
		}

	}

	public static class Receive extends MessageQueueFunction {
		
		@Override
		protected void writeFunctionSignature(Appendable appendable) throws IOException {
			PrintAppendable out = new PrintAppendable(appendable);
			out.printf("void %sMessageQueue_receive(%sMessageQueue *mq, void *data)", getPrefix(), getPrefix());
		}

		@Override
		protected void writeBody(Appendable appendable) throws IOException {
			PrintAppendable out = new PrintAppendable(appendable);
			out.println("sem_wait(&mq->fillCount);");
			out.println("pthread_mutex_lock(&mq->mutex);");
			out.printf("memcpy(data, ((%sMessageQueueWithBuffer *) mq)->buffer + mq->head, mq->elementSize);\n", getPrefix());
			out.println("mq->head = (mq->head + mq->elementSize) % mq->size;");
			out.println("pthread_mutex_unlock(&mq->mutex);");
			out.println("sem_post(&mq->emptyCount);");
		}

		@Override
		public boolean equals(Object obj) {
			return obj instanceof Receive;
		}

	}

}
