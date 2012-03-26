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

package org.eclipselabs.damos.codegen.c;

import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.codegen.c.internal.util.InternalGeneratorUtil;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationUtil;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.execution.datatype.IComponentSignature;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.codegen.c.util.MscriptGeneratorUtil;

/**
 * @author Andreas Unger
 *
 */
public class OutputStruct extends PrimaryCodeFragment {

	private String content;
	
	protected void doInitialize(IGeneratorContext context, IProgressMonitor monitor) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		String prefix = GeneratorConfigurationUtil.getPrefix(context.getConfiguration());

		out.println("typedef struct {");
		for (ComponentNode node : InternalGeneratorUtil.getOutportNodes(context)) {
			IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(node);
			IComponentSignature signature = generator.getContext().getComponentSignature();
			InputPort inputPort = node.getComponent().getFirstInputPort();
			DataType dataType = signature.getInputDataType(inputPort);
			out.printf("%s;\n", MscriptGeneratorUtil.getCVariableDeclaration(GeneratorConfigurationUtil.getComputationModel(context.getConfiguration(), node), dataType, InternalGeneratorUtil.uncapitalize(node.getComponent().getName()), false));
		}
		out.printf("} %sOutput;\n", prefix);
		
		content = sb.toString();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.ICodeFragment#writeForwardDeclaration(java.lang.Appendable, boolean)
	 */
	public void writeForwardDeclaration(Appendable appendable, boolean internal) throws IOException {
		appendable.append(content);
	}

}
