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

import org.eclipse.damos.codegen.c.IGeneratorContext;
import org.eclipse.damos.codegen.c.internal.rte.SemaphoreInfo;
import org.eclipse.damos.common.util.PrintAppendable;

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
	
	@Override
	public boolean contributesContextCode() {
		return true;
	}
	
	@Override
	public CharSequence generateContextCode(IGeneratorContext context, String variableName, IMessageQueueInfo info) {
		StringBuilder sb = new StringBuilder();
		sb.append("struct {\n");
		sb.append("int ").append("tail;\n");
		sb.append("int ").append("head;\n");
		sb.append("unsigned char ").append("buffer[").append(info.getCapacity()).append(" * ").append(info.getElementSize()).append("];\n");
		if (fastLockGenerator.contributesContextCode()) {
			sb.append(fastLockGenerator.generateContextCode("mutex"));
		}
		if (semaphoreGenerator.contributesContextCode()) {
			sb.append(semaphoreGenerator.generateContextCode("fillCount", createFillCountSemaphoreInfo(info)));
			sb.append(semaphoreGenerator.generateContextCode("emptyCount", createEmptyCountSemaphoreInfo(info)));
		}
		sb.append("} ").append(variableName).append(";\n");
		return sb;
	}

	@Override
	public boolean contributesInitializationCode() {
		return true;
	}
	
	@Override
	public CharSequence generateInitializationCode(IGeneratorContext context, String variableName, IMessageQueueInfo info) {
		StringBuilder sb = new StringBuilder();
		sb.append(variableName).append(".tail = 0;\n");
		sb.append(variableName).append(".head = 0;\n");
		if (fastLockGenerator.contributesInitializationCode()) {
			String createMutexQualifier = createMutexQualifier(variableName);
			sb.append(fastLockGenerator.generateInitializationCode(createMutexQualifier));
		}
		if (semaphoreGenerator.contributesInitializationCode()) {
			sb.append(semaphoreGenerator.generateInitializationCode(createFillCountQualifier(variableName), createFillCountSemaphoreInfo(info)));
			sb.append(semaphoreGenerator.generateInitializationCode(createEmptyCountQualifier(variableName), createEmptyCountSemaphoreInfo(info)));
		}
		return sb;
	}

	@Override
	public CharSequence generateSendCode(IGeneratorContext context, String variableName, String dataPointer, IMessageQueueInfo info) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);

		out.println("{");
		out.print(semaphoreGenerator.generateDownCode(createEmptyCountQualifier(variableName), createEmptyCountSemaphoreInfo(info)));
		out.print(fastLockGenerator.generateLockCode(createMutexQualifier(variableName)));
		
		out.printf("memcpy(%s.buffer + %s.tail, %s, %s);\n", variableName, variableName, dataPointer, info.getElementSize());
		out.printf("%s.tail = (%s.tail + %s) %% %s;\n", variableName, variableName, info.getElementSize(), info.getCapacity());
		
		out.print(fastLockGenerator.generateUnlockCode(createMutexQualifier(variableName)));
		out.print(semaphoreGenerator.generateUpCode(createFillCountQualifier(variableName), createFillCountSemaphoreInfo(info)));
		out.println("}");
		
		return sb;
	}

	@Override
	public CharSequence generateReceiveCode(IGeneratorContext context, String variableName, String dataPointer, IMessageQueueInfo info) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);

		out.println("{");
		out.print(semaphoreGenerator.generateDownCode(createFillCountQualifier(variableName), createFillCountSemaphoreInfo(info)));
		out.print(fastLockGenerator.generateLockCode(createMutexQualifier(variableName)));
		
		out.printf("memcpy(%s, %s.buffer + %s.head, %s);\n", dataPointer, variableName, variableName, info.getElementSize());
		out.printf("%s.head = (%s.head + %s) %% %s;\n", variableName, variableName, info.getElementSize(), info.getCapacity());

		out.print(fastLockGenerator.generateUnlockCode(createMutexQualifier(variableName)));
		out.print(semaphoreGenerator.generateUpCode(createEmptyCountQualifier(variableName), createEmptyCountSemaphoreInfo(info)));
		out.println("}");
		
		return sb;
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
