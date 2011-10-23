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

package org.eclipselabs.damos.codegen.c.generator.rte;

import java.io.IOException;

import org.eclipselabs.damos.codegen.c.generator.internal.rte.SemaphoreInfo;
import org.eclipselabs.damos.common.util.PrintAppendable;

/**
 * @author Andreas Unger
 *
 */
public class BoundedBufferMessageQueueGenerator extends AbstractMessageQueueGenerator {

	private IFastLockGenerator fastLockGenerator;
	private ISemaphoreGenerator semaphoreGenerator;
	
	/**
	 * 
	 */
	public BoundedBufferMessageQueueGenerator(IRuntimeEnvironmentAPI runtimeEnvironmentAPI) {
		this.fastLockGenerator = runtimeEnvironmentAPI.getFastLockGenerator();
		this.semaphoreGenerator = runtimeEnvironmentAPI.getSemaphoreGenerator();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.rte.AbstractMessageQueueGenerator#contributesContextCode()
	 */
	@Override
	public boolean contributesContextCode() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.rte.AbstractMessageQueueGenerator#writeContextCode(java.lang.Appendable, java.lang.String, org.eclipselabs.damos.codegen.c.generator.rte.IMessageQueueInfo)
	 */
	@Override
	public void writeContextCode(Appendable appendable, String variableName, IMessageQueueInfo info) throws IOException {
		appendable.append("struct {\n");
		appendable.append("int ").append("tail;\n");
		appendable.append("int ").append("head;\n");
		appendable.append("unsigned char ").append("buffer[").append(info.getCapacity()).append(" * ").append(info.getElementSize()).append("];\n");
		if (fastLockGenerator.contributesContextCode()) {
			fastLockGenerator.writeContextCode(appendable, "mutex");
		}
		if (semaphoreGenerator.contributesContextCode()) {
			semaphoreGenerator.writeContextCode(appendable, "fillCount", createFillCountSemaphoreInfo(info));
			semaphoreGenerator.writeContextCode(appendable, "emptyCount", createEmptyCountSemaphoreInfo(info));
		}
		appendable.append("} ").append(variableName).append(";\n");
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.rte.AbstractMessageQueueGenerator#contributesInitializationCode()
	 */
	@Override
	public boolean contributesInitializationCode() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.rte.AbstractMessageQueueGenerator#writeInitializationCode(java.lang.Appendable, java.lang.String, org.eclipselabs.damos.codegen.c.generator.rte.IMessageQueueInfo)
	 */
	@Override
	public void writeInitializationCode(Appendable appendable, String variableName, IMessageQueueInfo info) throws IOException {
		appendable.append(variableName).append(".tail = 0;\n");
		appendable.append(variableName).append(".head = 0;\n");
		if (fastLockGenerator.contributesInitializationCode()) {
			String createMutexQualifier = createMutexQualifier(variableName);
			fastLockGenerator.writeInitializationCode(appendable, createMutexQualifier);
		}
		if (semaphoreGenerator.contributesInitializationCode()) {
			semaphoreGenerator.writeInitializationCode(appendable, createFillCountQualifier(variableName), createFillCountSemaphoreInfo(info));
			semaphoreGenerator.writeInitializationCode(appendable, createEmptyCountQualifier(variableName), createEmptyCountSemaphoreInfo(info));
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.rte.AbstractMessageQueueGenerator#writeSendCode(java.lang.Appendable, java.lang.String, org.eclipselabs.damos.codegen.c.generator.rte.IMessageQueueInfo)
	 */
	@Override
	public void writeSendCode(Appendable appendable, String variableName, String dataPointer, IMessageQueueInfo info) throws IOException {
		PrintAppendable out = new PrintAppendable(appendable);

		out.println("{");
		semaphoreGenerator.writeDownCode(appendable, createEmptyCountQualifier(variableName), createEmptyCountSemaphoreInfo(info));
		fastLockGenerator.writeLockCode(appendable, createMutexQualifier(variableName));
		
		out.printf("memcpy(%s.buffer + %s.tail, %s, %s);\n", variableName, variableName, dataPointer, info.getElementSize());
		out.printf("%s.tail = (%s.tail + %s) %% %s;\n", variableName, variableName, info.getElementSize(), info.getCapacity());
		
		fastLockGenerator.writeUnlockCode(appendable, createMutexQualifier(variableName));
		semaphoreGenerator.writeUpCode(appendable, createFillCountQualifier(variableName), createFillCountSemaphoreInfo(info));
		out.println("}");
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.rte.AbstractMessageQueueGenerator#writeReceiveCode(java.lang.Appendable, java.lang.String, org.eclipselabs.damos.codegen.c.generator.rte.IMessageQueueInfo)
	 */
	@Override
	public void writeReceiveCode(Appendable appendable, String variableName, String dataPointer, IMessageQueueInfo info) throws IOException {
		PrintAppendable out = new PrintAppendable(appendable);

		out.println("{");
		semaphoreGenerator.writeDownCode(appendable, createFillCountQualifier(variableName), createFillCountSemaphoreInfo(info));
		fastLockGenerator.writeLockCode(appendable, createMutexQualifier(variableName));
		
		out.printf("memcpy(%s, %s.buffer + %s.head, %s);\n", dataPointer, variableName, variableName, info.getElementSize());
		out.printf("%s.head = (%s.head + %s) %% %s;\n", variableName, variableName, info.getElementSize(), info.getCapacity());

		fastLockGenerator.writeUnlockCode(appendable, createMutexQualifier(variableName));
		semaphoreGenerator.writeUpCode(appendable, createEmptyCountQualifier(variableName), createEmptyCountSemaphoreInfo(info));
		out.println("}");
	}

	/**
	 * @param info
	 * @return
	 */
	private SemaphoreInfo createEmptyCountSemaphoreInfo(IMessageQueueInfo info) {
		return new SemaphoreInfo(info.getCapacity(), info.getCapacity());
	}

	/**
	 * @param info
	 * @return
	 */
	private SemaphoreInfo createFillCountSemaphoreInfo(IMessageQueueInfo info) {
		return new SemaphoreInfo(info.getCapacity(), "0");
	}

	/**
	 * @param variableName
	 * @return
	 */
	private String createMutexQualifier(String variableName) {
		return variableName + ".mutex";
	}

	/**
	 * @param variableName
	 * @return
	 */
	private String createEmptyCountQualifier(String variableName) {
		return variableName + ".emptyCount";
	}

	/**
	 * @param variableName
	 * @return
	 */
	private String createFillCountQualifier(String variableName) {
		return variableName + ".fillCount";
	}
	
}
