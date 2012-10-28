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

package org.eclipse.damos.codegen.c.codefragments;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.damos.codegen.c.IGeneratorContext;
import org.eclipse.damos.codegen.c.IGraphGenerator;
import org.eclipse.damos.codegen.c.internal.rte.MessageQueueInfo;
import org.eclipse.damos.codegen.c.internal.util.TaskGeneratorHelper;
import org.eclipse.damos.codegen.c.rte.IRuntimeEnvironmentAPI;
import org.eclipse.damos.codegen.c.util.GeneratorConfigurationExtensions;
import org.eclipse.damos.execution.TaskGraph;
import org.eclipse.damos.execution.TaskInputNode;
import org.eclipse.damos.mscript.codegen.c.Include;
import org.eclipse.damos.mscript.codegen.c.codefragments.UnionTypeDeclaration;
import org.eclipse.emf.common.util.EList;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class TaskFunction extends PrimaryCodeFragment {

	@Inject
	private IGraphGenerator graphGenerator;
	
	@Inject
	private TaskGeneratorHelper taskGeneratorHelper;
	
	private Collection<Include> implementationIncludes = new ArrayList<Include>();

	private List<String> forwardDeclarations = new ArrayList<String>();
	private List<String> implementations = new ArrayList<String>();
	
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
			sb.append(rteAPI.generateTaskSignature(taskGeneratorHelper.getTaskName(context.getConfiguration(), taskGraph)));
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
			
			String taskName = taskGeneratorHelper.getTaskName(context.getConfiguration(), taskGraph);
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
				if (taskGeneratorHelper.getInputSockets(taskGraph).isEmpty()) {
					TaskInputNode inputNode = taskGraph.getInputNodes().get(0);
					String taskInputVariableName = taskGeneratorHelper.getTaskInputVariableName(context.getConfiguration(), inputNode);
					sb.append(taskGeneratorHelper.getCDataTypeFor(context, taskInputVariableName, inputNode)).append(";\n");
				} else {
					UnionTypeDeclaration messageUnionTypeDeclaration = taskGeneratorHelper.createMessageUnionTypeDeclaration(context, taskGraph);
					sb.append(messageUnionTypeDeclaration.getName());
					sb.append(" ");
					sb.append(taskGeneratorHelper.getTaskName(context.getConfiguration(), taskGraph));
					sb.append("_message;\n");
				}
			}
			
			sb.append("\n");
			
			sb.append("for (;;) {\n");
			
			if (!inputNodes.isEmpty()) {
				String qualifier = taskGeneratorHelper.getTaskContextVariable(context, taskName, false) + "." + "queue";
				if (taskGeneratorHelper.getInputSockets(taskGraph).isEmpty()) {
					TaskInputNode inputNode = inputNodes.get(0);
					String taskInputVariableName = taskGeneratorHelper.getTaskInputVariableName(context.getConfiguration(), inputNode);
					MessageQueueInfo messageQueueInfo = taskGeneratorHelper.createMessageQueueInfoFor(context, inputNode);
					sb.append(runtimeEnvironmentAPI.getMessageQueueGenerator().generateReceiveCode(context, qualifier, "&" + taskInputVariableName, messageQueueInfo));
				} else {
					String taskInputVariableName = taskGeneratorHelper.getTaskName(context.getConfiguration(), taskGraph) + "_message";
					MessageQueueInfo messageQueueInfo = taskGeneratorHelper.createMessageQueueInfoFor(context, taskGraph);
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
	 * @see org.eclipse.damos.mscript.codegen.c.AbstractCodeFragment#contributesImplementation()
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
