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

package org.eclipse.damos.rte.posix.codegen.c;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.damos.codegen.c.IGeneratorContext;
import org.eclipse.damos.codegen.c.codefragments.PrimaryCodeFragment;
import org.eclipse.damos.codegen.c.util.GeneratorConfigurationExtensions;
import org.eclipse.damos.common.util.PrintAppendable;
import org.eclipse.damos.mscript.codegen.c.ICodeFragment;
import org.eclipse.damos.mscript.codegen.c.Include;

/**
 * @author Andreas Unger
 *
 */
public abstract class MessageQueueFunction extends PrimaryCodeFragment {

	private static final Collection<Include> IMPLEMENTATION_INCLUDES = new ArrayList<Include>();
	
	static {
		IMPLEMENTATION_INCLUDES.add(new Include("stddef.h"));
		IMPLEMENTATION_INCLUDES.add(new Include("string.h"));
	}

	private String prefix;
	private String functionSignature;
	
	/**
	 * @return the prefix
	 */
	protected String getPrefix() {
		return prefix;
	}
	
	@Override
	protected void doInitialize(IGeneratorContext context, IProgressMonitor monitor) {
		addDependency(FORWARD_DECLARATION_DEPENDS_ON, new IDependencyRule() {
			
			public boolean applies(ICodeFragment other) {
				return other instanceof MessageQueueStruct;
			}
			
		});
	
		prefix = GeneratorConfigurationExtensions.getPrefix(context.getConfiguration());
		StringBuilder sb = new StringBuilder();
		sb.append(generateFunctionSignature());
		functionSignature = sb.toString();
	}

	public CharSequence generateForwardDeclaration(boolean internal) {
		StringBuilder sb = new StringBuilder();
		if (internal) {
			sb.append("static ");
		}
		sb.append(functionSignature);
		sb.append(";\n");
		return sb;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.codegen.c.AbstractCodeFragment#getImplementationIncludes()
	 */
	@Override
	public Collection<Include> getImplementationIncludes() {
		return IMPLEMENTATION_INCLUDES;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.codegen.c.AbstractCodeFragment#contributesImplementation()
	 */
	@Override
	public boolean contributesImplementation() {
		return true;
	}
	
	@Override
	public CharSequence generateImplementation(boolean internal) {
		StringBuilder sb = new StringBuilder();
		if (internal) {
			sb.append("static ");
		}
		sb.append(functionSignature);
		sb.append(" {\n");
		sb.append(generateBody());
		sb.append("}\n");
		return sb;
	}
	
	protected abstract CharSequence generateFunctionSignature();
	
	protected abstract CharSequence generateBody();
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
	
	public static class Init extends MessageQueueFunction {

		@Override
		protected CharSequence generateFunctionSignature() {
			StringBuilder sb = new StringBuilder();
			PrintAppendable out = new PrintAppendable(sb);
			out.printf("void %sMessageQueue_init(%sMessageQueue *mq, int capacity, int elementSize)", getPrefix(), getPrefix());
			return sb;
		}

		@Override
		protected CharSequence generateBody() {
			StringBuilder sb = new StringBuilder();
			sb.append("mq->tail = 0;\n");
			sb.append("mq->head = 0;\n");
			sb.append("pthread_mutex_init(&mq->mutex, NULL);\n");
			sb.append("sem_init(&mq->fillCount, 0, 0);\n");
			sb.append("sem_init(&mq->emptyCount, 0, capacity);\n");
			sb.append("mq->size = capacity * elementSize;\n");
			sb.append("mq->elementSize = elementSize;\n");
			return sb;
		}
		
		@Override
		public boolean equals(Object obj) {
			return obj instanceof Init;
		}

	}

	public static class Send extends MessageQueueFunction {
		
		@Override
		protected CharSequence generateFunctionSignature() {
			StringBuilder sb = new StringBuilder();
			PrintAppendable out = new PrintAppendable(sb);
			out.printf("void %sMessageQueue_send(%sMessageQueue *mq, const void *data)", getPrefix(), getPrefix());
			return sb;
		}

		@Override
		protected CharSequence generateBody() {
			StringBuilder sb = new StringBuilder();
			PrintAppendable out = new PrintAppendable(sb);
			out.println("sem_wait(&mq->emptyCount);");
			out.println("pthread_mutex_lock(&mq->mutex);");
			out.printf("memcpy(((%sMessageQueueWithBuffer *) mq)->buffer + mq->tail, data, mq->elementSize);\n", getPrefix());
			out.println("mq->tail = (mq->tail + mq->elementSize) % mq->size;");
			out.println("pthread_mutex_unlock(&mq->mutex);");
			out.println("sem_post(&mq->fillCount);");
			return sb;
		}
		
		@Override
		public boolean equals(Object obj) {
			return obj instanceof Send;
		}

	}

	public static class Receive extends MessageQueueFunction {
		
		@Override
		protected CharSequence generateFunctionSignature() {
			StringBuilder sb = new StringBuilder();
			PrintAppendable out = new PrintAppendable(sb);
			out.printf("void %sMessageQueue_receive(%sMessageQueue *mq, void *data)", getPrefix(), getPrefix());
			return sb;
		}

		@Override
		protected CharSequence generateBody() {
			StringBuilder sb = new StringBuilder();
			PrintAppendable out = new PrintAppendable(sb);
			out.println("sem_wait(&mq->fillCount);");
			out.println("pthread_mutex_lock(&mq->mutex);");
			out.printf("memcpy(data, ((%sMessageQueueWithBuffer *) mq)->buffer + mq->head, mq->elementSize);\n", getPrefix());
			out.println("mq->head = (mq->head + mq->elementSize) % mq->size;");
			out.println("pthread_mutex_unlock(&mq->mutex);");
			out.println("sem_post(&mq->emptyCount);");
			return sb;
		}

		@Override
		public boolean equals(Object obj) {
			return obj instanceof Receive;
		}

	}

}
