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

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipselabs.damos.codegen.c.IGeneratorContext;
import org.eclipselabs.damos.codegen.c.rte.AbstractMessageQueueGenerator;
import org.eclipselabs.damos.codegen.c.rte.IMessageQueueInfo;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationExtensions;
import org.eclipselabs.damos.common.util.PrintAppendable;

/**
 * @author Andreas Unger
 *
 */
public class MessageQueueGenerator extends AbstractMessageQueueGenerator {

	@Override
	public boolean contributesContextCode() {
		return true;
	}
	
	@Override
	public CharSequence generateContextCode(IGeneratorContext context, String variableName, IMessageQueueInfo info) {
		context.addCodeFragment(new MessageQueueStruct(), new NullProgressMonitor());

		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		String prefix = GeneratorConfigurationExtensions.getPrefix(context.getConfiguration());
		out.println("struct {");
		out.printf("%sMessageQueue base;\n", prefix);
		out.printf("unsigned char buffer[%s * %s];\n", info.getCapacity(), info.getElementSize());
		out.printf("} %s;\n", variableName);
		
		return sb;
	}
	
	@Override
	public boolean contributesInitializationCode() {
		return true;
	}
	
	@Override
	public CharSequence generateInitializationCode(IGeneratorContext context, String variableName, IMessageQueueInfo info) {
		context.addCodeFragment(new MessageQueueFunction.Init(), new NullProgressMonitor());
	
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		String prefix = GeneratorConfigurationExtensions.getPrefix(context.getConfiguration());
		out.printf("%sMessageQueue_init((%sMessageQueue *) &%s, %s, %s);\n", prefix, prefix, variableName, info.getCapacity(), info.getElementSize());
		return sb;
	}
	
	@Override
	public CharSequence generateSendCode(IGeneratorContext context, String variableName, String dataPointer, IMessageQueueInfo info) {
		context.addCodeFragment(new MessageQueueFunction.Send(), new NullProgressMonitor());

		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		String prefix = GeneratorConfigurationExtensions.getPrefix(context.getConfiguration());
		out.printf("%sMessageQueue_send((%sMessageQueue *) &%s, %s);\n", prefix, prefix, variableName, dataPointer);
		return sb;
	}
	
	@Override
	public CharSequence generateReceiveCode(IGeneratorContext context, String variableName, String dataPointer, IMessageQueueInfo info) {
		context.addCodeFragment(new MessageQueueFunction.Receive(), new NullProgressMonitor());

		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		String prefix = GeneratorConfigurationExtensions.getPrefix(context.getConfiguration());
		out.printf("%sMessageQueue_receive((%sMessageQueue *) &%s, %s);\n", prefix, prefix, variableName, dataPointer);
		return sb;
	}
	
}
