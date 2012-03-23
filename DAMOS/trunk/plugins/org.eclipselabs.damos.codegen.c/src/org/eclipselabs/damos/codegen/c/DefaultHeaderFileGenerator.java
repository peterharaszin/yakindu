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
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.codegen.c.internal.util.InternalGeneratorUtil;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationUtil;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.execution.datatype.IComponentSignature;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.codegen.c.util.MscriptGeneratorUtil;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class DefaultHeaderFileGenerator extends AbstractFileGenerator implements IHeaderFileGenerator {

	private final ITaskGenerator taskGenerator;
	
	/**
	 * 
	 */
	@Inject
	DefaultHeaderFileGenerator(ITaskGenerator taskGenerator) {
		this.taskGenerator = taskGenerator;
	}

	public void writeFile(IGeneratorContext context, Appendable appendable, IProgressMonitor monitor) throws IOException {
		PrintAppendable out = new PrintAppendable(appendable);
		
		String headerFileName = GeneratorConfigurationUtil.getSystemHeaderFile(context.getConfiguration());
		String headerMacro = headerFileName.replaceAll("\\W", "_").toUpperCase() + "_";
		
		String prefix = GeneratorConfigurationUtil.getPrefix(context.getConfiguration());
		
		out.printf("#ifndef %s\n", headerMacro);
		out.printf("#define %s\n", headerMacro);
		out.println();
		
		out.println("#include <stdint.h>");

		taskGenerator.writeTaskInfoInclude(context, out, monitor);

		out.println();
		out.println("#ifdef __cplusplus");
		out.println("extern \"C\" {");
		out.println("#endif /* __cplusplus */");
		out.println();
		
		taskGenerator.writeExternVariables(context, out, monitor);
		
		List<ComponentNode> inportNodes = getInportNodes(context);
		if (!inportNodes.isEmpty()) {
			out.println("typedef struct {");
			for (ComponentNode node : inportNodes) {
				IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(node);
				IComponentSignature signature = generator.getContext().getComponentSignature();
				OutputPort outputPort = node.getComponent().getFirstOutputPort();
				DataType dataType = signature.getOutputDataType(outputPort);
				out.printf("%s;\n", MscriptGeneratorUtil.getCVariableDeclaration(GeneratorConfigurationUtil.getComputationModel(context.getConfiguration(), node), dataType, InternalGeneratorUtil.uncapitalize(node.getComponent().getName()), false));
			}
			out.printf("} %sInput;\n\n", prefix);
		}
		
		List<ComponentNode> outportNodes = getOutportNodes(context);
		if (!outportNodes.isEmpty()) {
			out.println("typedef struct {");
			for (ComponentNode node : outportNodes) {
				IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(node);
				IComponentSignature signature = generator.getContext().getComponentSignature();
				InputPort inputPort = node.getComponent().getFirstInputPort();
				DataType dataType = signature.getInputDataType(inputPort);
				out.printf("%s;\n", MscriptGeneratorUtil.getCVariableDeclaration(GeneratorConfigurationUtil.getComputationModel(context.getConfiguration(), node), dataType, InternalGeneratorUtil.uncapitalize(node.getComponent().getName()), false));
			}
			out.printf("} %sOutput;\n\n", prefix);
		}

		out.printf("void %sinitialize(void);\n", prefix);
		
		writeExecutionFunctionSignature(context, appendable);
		out.print(";\n");

		out.println();
		out.println("#ifdef __cplusplus");
		out.println("}");
		out.println("#endif /* __cplusplus */");
		out.println();
		out.printf("#endif /* %s */\n", headerMacro);
	}
	
}
