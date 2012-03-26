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
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipselabs.damos.codegen.c.internal.rte.MessageQueueInfo;
import org.eclipselabs.damos.codegen.c.internal.util.TaskGeneratorUtil;
import org.eclipselabs.damos.codegen.c.rte.IRuntimeEnvironmentAPI;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationUtil;
import org.eclipselabs.damos.execution.TaskGraph;
import org.eclipselabs.damos.execution.TaskInputNode;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class Task extends PrimaryCodeFragment {

	private final IGraphGenerator graphGenerator;
	
	private List<String> forwardDeclarations = new ArrayList<String>();
	private List<String> implementations = new ArrayList<String>();
	
	/**
	 * 
	 */
	@Inject
	Task(IGraphGenerator graphGenerator) {
		this.graphGenerator = graphGenerator;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.PrimaryCodeFragment#doInitialize(org.eclipselabs.damos.codegen.c.IGeneratorContext, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected void doInitialize(IGeneratorContext context, IProgressMonitor monitor) throws IOException {
		initializeForwardDeclarations(context);
		initializeImplementations(context, monitor);
	}

	private void initializeForwardDeclarations(IGeneratorContext context) throws IOException {
		IRuntimeEnvironmentAPI rteAPI = GeneratorConfigurationUtil.getRuntimeEnvironmentAPI(context.getConfiguration());
		for (TaskGraph taskGraph : context.getExecutionFlow().getTaskGraphs()) {
			StringBuilder sb = new StringBuilder();
			rteAPI.writeTaskSignature(sb, TaskGeneratorUtil.getTaskName(context.getConfiguration(), taskGraph));
			sb.append(";\n");
			forwardDeclarations.add(sb.toString());
		}
	}

	private void initializeImplementations(IGeneratorContext context, IProgressMonitor monitor) throws IOException {
		IRuntimeEnvironmentAPI runtimeEnvironmentAPI = GeneratorConfigurationUtil.getRuntimeEnvironmentAPI(context.getConfiguration());
		if (runtimeEnvironmentAPI == null) {
			throw new IllegalArgumentException("No runtime environment specified");
		}
		
		for (TaskGraph taskGraph : context.getExecutionFlow().getTaskGraphs()) {
			StringBuilder sb = new StringBuilder();
			
			String taskName = TaskGeneratorUtil.getTaskName(context.getConfiguration(), taskGraph);
			runtimeEnvironmentAPI.writeTaskSignature(sb, taskName);
			sb.append(" {\n");
			graphGenerator.writeOutputVariableDeclarations(context, sb, taskGraph, monitor);
			
			EList<TaskInputNode> inputNodes = taskGraph.getInputNodes();

			if (!inputNodes.isEmpty()) {
				if (TaskGeneratorUtil.getInputSockets(taskGraph).isEmpty()) {
					TaskInputNode inputNode = taskGraph.getInputNodes().get(0);
					String taskInputVariableName = TaskGeneratorUtil.getTaskInputVariableName(context.getConfiguration(), inputNode);
					sb.append(TaskGeneratorUtil.getCDataTypeFor(context, inputNode)).append(" ").append(taskInputVariableName).append(";\n");
				} else {
					sb.append(TaskGeneratorUtil.getTaskName(context.getConfiguration(), taskGraph));
					sb.append("_Message ");
					sb.append(TaskGeneratorUtil.getTaskName(context.getConfiguration(), taskGraph));
					sb.append("_message;\n");
				}
			}
			
			sb.append("for (;;) {\n");
			
			if (!inputNodes.isEmpty()) {
				String qualifier = TaskGeneratorUtil.getTaskContextVariable(context, taskName, false) + "." + "queue";
				if (TaskGeneratorUtil.getInputSockets(taskGraph).isEmpty()) {
					TaskInputNode inputNode = inputNodes.get(0);
					String taskInputVariableName = TaskGeneratorUtil.getTaskInputVariableName(context.getConfiguration(), inputNode);
					MessageQueueInfo messageQueueInfo = TaskGeneratorUtil.createMessageQueueInfoFor(context, inputNode);
					runtimeEnvironmentAPI.getMessageQueueGenerator().writeReceiveCode(context, sb, qualifier, "&" + taskInputVariableName, messageQueueInfo);
				} else {
					String taskInputVariableName = TaskGeneratorUtil.getTaskName(context.getConfiguration(), taskGraph) + "_message";
					MessageQueueInfo messageQueueInfo = TaskGeneratorUtil.createMessageQueueInfoFor(context, taskGraph);
					runtimeEnvironmentAPI.getMessageQueueGenerator().writeReceiveCode(context, sb, qualifier, "&" + taskInputVariableName, messageQueueInfo);
				}
			}

			graphGenerator.writeGraph(context, sb, taskGraph, monitor);
							
			sb.append("}\n");
			runtimeEnvironmentAPI.writeTaskReturnStatement(sb, taskName);
			sb.append("}\n");
			
			implementations.add(sb.toString());
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.ICodeFragment#writeForwardDeclaration(java.lang.Appendable, boolean)
	 */
	public void writeForwardDeclaration(Appendable appendable, boolean internal) throws IOException {
		for (String forwardDeclaration : forwardDeclarations) {
			if (internal) {
				appendable.append("static ");
			}
			appendable.append(forwardDeclaration);
		}
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
		for (String implementation : implementations) {
			if (internal) {
				appendable.append("static ");
			}
			appendable.append(implementation);
		}
	}

}
