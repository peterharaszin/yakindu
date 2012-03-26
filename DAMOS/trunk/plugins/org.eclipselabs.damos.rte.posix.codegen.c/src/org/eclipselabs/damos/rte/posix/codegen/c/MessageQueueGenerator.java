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

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipselabs.damos.codegen.c.IGeneratorContext;
import org.eclipselabs.damos.codegen.c.rte.AbstractMessageQueueGenerator;
import org.eclipselabs.damos.codegen.c.rte.IMessageQueueInfo;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationUtil;
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
	public void writeContextCode(IGeneratorContext context, Appendable appendable, String variableName, IMessageQueueInfo info) throws IOException {
		context.addCodeFragment(new MessageQueueStruct(), new NullProgressMonitor());

		PrintAppendable out = new PrintAppendable(appendable);
		String prefix = GeneratorConfigurationUtil.getPrefix(context.getConfiguration());
		out.println("struct {");
		out.printf("%sMessageQueue base;\n", prefix);
		out.printf("unsigned char buffer[%s * %s];\n", info.getCapacity(), info.getElementSize());
		out.printf("} %s;\n", variableName);
	}
	
	@Override
	public boolean contributesInitializationCode() {
		return true;
	}
	
	@Override
	public void writeInitializationCode(IGeneratorContext context, Appendable appendable, String variableName, IMessageQueueInfo info) throws IOException {
		context.addCodeFragment(new MessageQueueFunction.Init(), new NullProgressMonitor());
		
		PrintAppendable out = new PrintAppendable(appendable);
		String prefix = GeneratorConfigurationUtil.getPrefix(context.getConfiguration());
		out.printf("%sMessageQueue_init((%sMessageQueue *) &%s, %s, %s);\n", prefix, prefix, variableName, info.getCapacity(), info.getElementSize());
	}
	
	@Override
	public void writeSendCode(IGeneratorContext context, Appendable appendable, String variableName, String dataPointer, IMessageQueueInfo info) throws IOException {
		context.addCodeFragment(new MessageQueueFunction.Send(), new NullProgressMonitor());

		PrintAppendable out = new PrintAppendable(appendable);
		String prefix = GeneratorConfigurationUtil.getPrefix(context.getConfiguration());
		out.printf("%sMessageQueue_send((%sMessageQueue *) &%s, %s);\n", prefix, prefix, variableName, dataPointer);
	}
	
	@Override
	public void writeReceiveCode(IGeneratorContext context, Appendable appendable, String variableName, String dataPointer, IMessageQueueInfo info) throws IOException {
		context.addCodeFragment(new MessageQueueFunction.Receive(), new NullProgressMonitor());

		PrintAppendable out = new PrintAppendable(appendable);
		String prefix = GeneratorConfigurationUtil.getPrefix(context.getConfiguration());
		out.printf("%sMessageQueue_receive((%sMessageQueue *) &%s, %s);\n", prefix, prefix, variableName, dataPointer);
	}
	
}
