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

package org.eclipselabs.damos.codegen.c.codefragments;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipselabs.damos.codegen.c.IComponentGenerator;
import org.eclipselabs.damos.codegen.c.IGeneratorContext;
import org.eclipselabs.damos.codegen.c.internal.util.InternalGeneratorUtil;
import org.eclipselabs.damos.codegen.c.internal.util.TaskGeneratorUtil;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationExtensions;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.execution.TaskGraph;
import org.eclipselabs.damos.execution.datatype.IComponentSignature;
import org.eclipselabs.damos.mscript.codegen.c.DataTypeGenerator;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class TaskMessageStruct extends PrimaryCodeFragment {

	private final DataTypeGenerator dataTypeGenerator = new DataTypeGenerator();
	
	private String content;
	
	@Inject
	TaskMessageStruct() {
	}

	@Override
	protected void doInitialize(IGeneratorContext context, IProgressMonitor monitor) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		
		for (TaskGraph taskGraph : context.getExecutionFlow().getTaskGraphs()) {
			EList<Input> inputSockets = TaskGeneratorUtil.getInputSockets(taskGraph);
			if (!inputSockets.isEmpty()) {
				out.print("typedef struct {\n");
				out.print("int kind;\n");
				out.print("union {\n");
				for (Input input : inputSockets) {
					if (!input.getPorts().isEmpty()) {
						ComponentNode componentNode = (ComponentNode) taskGraph.getInitialNodes().get(0);
						IComponentGenerator generator = InternalGeneratorUtil.getComponentGenerator(componentNode);
						IComponentSignature signature = generator.getContext().getComponentSignature();
						out.print(dataTypeGenerator.generateDataType(GeneratorConfigurationExtensions.getComputationModel(context.getConfiguration(), componentNode), context, signature.getInputDataType(input.getPorts().get(0)), null));
						out.print(" ");
						out.print(input.getName());
						out.print(";\n");
					}
				}
				out.print("} data;\n");
				out.printf("} %s_Message;\n", TaskGeneratorUtil.getTaskName(context.getConfiguration(), taskGraph));
			}
		}
		
		content = sb.toString();
	}

	public CharSequence generateForwardDeclaration(boolean internal) {
		return content;
	}

}
