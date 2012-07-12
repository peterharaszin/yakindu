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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipselabs.damos.codegen.c.IGeneratorContext;
import org.eclipselabs.damos.codegen.c.IGraphGenerator;
import org.eclipselabs.damos.codegen.c.internal.rte.MessageQueueInfo;
import org.eclipselabs.damos.codegen.c.internal.util.TaskGeneratorUtil;
import org.eclipselabs.damos.codegen.c.rte.IRuntimeEnvironmentAPI;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationExtensions;
import org.eclipselabs.damos.execution.TaskGraph;
import org.eclipselabs.damos.execution.TaskInputNode;
import org.eclipselabs.damos.mscript.codegen.c.Include;

/**
 * @author Andreas Unger
 *
 */
public class TaskFunction extends PrimaryCodeFragment {

	private final IGraphGenerator graphGenerator;
	
	private Collection<Include> implementationIncludes = new ArrayList<Include>();

	private List<String> forwardDeclarations = new ArrayList<String>();
	private List<String> implementations = new ArrayList<String>();
	
	public TaskFunction(IGraphGenerator graphGenerator) {
		this.graphGenerator = graphGenerator;
	}
	
	@Override
	public Collection<Include> getImplementationIncludes() {
		return implementationIncludes;
	}
	
	@Override
	protected void doInitialize(IGeneratorContext context, IProgressMonitor monitor) {
		initializeForwardDeclarations(context);
		initializeImplementations(context, monitor);
	}

	private void initializeForwardDeclarations(IGeneratorContext context) {
		IRuntimeEnvironmentAPI rteAPI = GeneratorConfigurationExtensions.getRuntimeEnvironmentAPI(context.getConfiguration());
		for (TaskGraph taskGraph : context.getExecutionFlow().getTaskGraphs()) {
			StringBuilder sb = new StringBuilder();
			sb.append(rteAPI.generateTaskSignature(TaskGeneratorUtil.getTaskName(context.getConfiguration(), taskGraph)));
			sb.append(";\n");
			forwardDeclarations.add(sb.toString());
		}
	}

	private void initializeImplementations(IGeneratorContext context, IProgressMonitor monitor) {
		IRuntimeEnvironmentAPI runtimeEnvironmentAPI = GeneratorConfigurationExtensions.getRuntimeEnvironmentAPI(context.getConfiguration());
		if (runtimeEnvironmentAPI == null) {
			throw new IllegalArgumentException("No runtime environment specified");
		}
		
		for (TaskGraph taskGraph : context.getExecutionFlow().getTaskGraphs()) {
			implementationIncludes.addAll(graphGenerator.getImplementationIncludes(context, taskGraph));
			
			StringBuilder sb = new StringBuilder();
			
			String taskName = TaskGeneratorUtil.getTaskName(context.getConfiguration(), taskGraph);
			sb.append(runtimeEnvironmentAPI.generateTaskSignature(taskName));
			sb.append(" {\n");

			if (!GeneratorConfigurationExtensions.isSingleton(context.getConfiguration())) {
				String prefix = GeneratorConfigurationExtensions.getPrefix(context.getConfiguration());
				sb.append(prefix);
				sb.append("Context *context = (");
				sb.append(prefix);
				sb.append("Context *) data;\n\n");
			}
			
			sb.append(graphGenerator.generateOutputVariableDeclarations(context, taskGraph, monitor));
			
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
			
			sb.append("\n");
			
			sb.append("for (;;) {\n");
			
			if (!inputNodes.isEmpty()) {
				String qualifier = TaskGeneratorUtil.getTaskContextVariable(context, taskName, false) + "." + "queue";
				if (TaskGeneratorUtil.getInputSockets(taskGraph).isEmpty()) {
					TaskInputNode inputNode = inputNodes.get(0);
					String taskInputVariableName = TaskGeneratorUtil.getTaskInputVariableName(context.getConfiguration(), inputNode);
					MessageQueueInfo messageQueueInfo = TaskGeneratorUtil.createMessageQueueInfoFor(context, inputNode);
					sb.append(runtimeEnvironmentAPI.getMessageQueueGenerator().generateReceiveCode(context, qualifier, "&" + taskInputVariableName, messageQueueInfo));
				} else {
					String taskInputVariableName = TaskGeneratorUtil.getTaskName(context.getConfiguration(), taskGraph) + "_message";
					MessageQueueInfo messageQueueInfo = TaskGeneratorUtil.createMessageQueueInfoFor(context, taskGraph);
					sb.append(runtimeEnvironmentAPI.getMessageQueueGenerator().generateReceiveCode(context, qualifier, "&" + taskInputVariableName, messageQueueInfo));
				}
			}

			sb.append(graphGenerator.generateGraph(context, taskGraph, monitor));
							
			sb.append("}\n");
			sb.append(runtimeEnvironmentAPI.generateTaskReturnStatement(taskName));
			sb.append("}\n");
			
			implementations.add(sb.toString());
		}
	}

	public CharSequence generateForwardDeclaration(boolean internal) {
		StringBuilder sb = new StringBuilder();
		for (String forwardDeclaration : forwardDeclarations) {
			if (internal) {
				sb.append("static ");
			}
			sb.append(forwardDeclaration);
		}
		return sb;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#contributesImplementation()
	 */
	@Override
	public boolean contributesImplementation() {
		return true;
	}
	
	@Override
	public CharSequence generateImplementation(boolean internal) {
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for (String implementation : implementations) {
			if (first) {
				first = false;
			} else {
				sb.append("\n");
			}
			
			if (internal) {
				sb.append("static ");
			}
			
			sb.append(implementation);
		}
		return sb;
	}

}
