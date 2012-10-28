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

package org.eclipse.damos.codegen.c.internal.util;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.damos.codegen.c.IComponentGenerator;
import org.eclipse.damos.codegen.c.IGeneratorContext;
import org.eclipse.damos.codegen.c.MscriptGeneratorConfiguration;
import org.eclipse.damos.codegen.c.internal.rte.MessageQueueInfo;
import org.eclipse.damos.codegen.c.util.GeneratorConfigurationExtensions;
import org.eclipse.damos.codegen.c.util.GeneratorNodeExtensions;
import org.eclipse.damos.dconfig.Configuration;
import org.eclipse.damos.dml.Input;
import org.eclipse.damos.dml.OutputPort;
import org.eclipse.damos.execution.ComponentNode;
import org.eclipse.damos.execution.DataFlowEnd;
import org.eclipse.damos.execution.Node;
import org.eclipse.damos.execution.TaskGraph;
import org.eclipse.damos.execution.TaskInputNode;
import org.eclipse.damos.execution.datatype.IComponentSignature;
import org.eclipse.damos.mscript.AnonymousTypeSpecifier;
import org.eclipse.damos.mscript.CompositeTypeMember;
import org.eclipse.damos.mscript.CompositeTypeMemberList;
import org.eclipse.damos.mscript.MscriptFactory;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.UnionType;
import org.eclipse.damos.mscript.codegen.c.DataTypeGenerator;
import org.eclipse.damos.mscript.codegen.c.codefragments.UnionTypeDeclaration;
import org.eclipse.damos.mscript.codegen.c.datatype.MachineDataTypes;
import org.eclipse.damos.mscript.codegen.c.datatype.MachineUnionType;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class TaskGeneratorHelper {

	@Inject
	private DataTypeGenerator dataTypeGenerator;
	
	public EList<Input> getInputSockets(TaskGraph taskGraph) {
		EList<Node> initialNodes = taskGraph.getInitialNodes();
		if (!initialNodes.isEmpty()) {
			Node node = initialNodes.get(0);
			if (node instanceof ComponentNode) {
				ComponentNode componentNode = (ComponentNode) node;
				return componentNode.getComponent().getInputSockets();
			}
		}
		return ECollections.emptyEList();
	}

	public CharSequence getCDataTypeFor(IGeneratorContext context, CharSequence variableName, TaskInputNode inputNode) {
		DataFlowEnd end = inputNode.getDrivingEnds().get(0);
		IComponentGenerator componentGenerator = GeneratorNodeExtensions.getComponentGenerator((ComponentNode) end.getNode());
		Type type = componentGenerator.getContext().getComponentSignature().getOutputDataType((OutputPort) end.getConnector());
		return dataTypeGenerator.generateDataType(new MscriptGeneratorConfiguration(GeneratorConfigurationExtensions.getComputationModel(context.getConfiguration(), (ComponentNode) end.getNode()), context.getConfiguration()), variableName, context, type, null);
	}

	public String getTaskContextVariable(IGeneratorContext context, String taskName, boolean pointer) {
		StringBuilder sb = new StringBuilder();
		
		if (pointer) {
			sb.append("&");
		}
		
		if (GeneratorConfigurationExtensions.isSingleton(context.getConfiguration())) {
			String prefix = GeneratorConfigurationExtensions.getPrefix(context.getConfiguration());
			if (prefix != null) {
				sb.append(prefix);
			}
			sb.append("context.");
		} else {
			sb.append("context->");
		}

		sb.append(taskName);

		return sb.toString();
	}

	public MessageQueueInfo createMessageQueueInfoFor(IGeneratorContext context, TaskInputNode inputNode) {
		return new MessageQueueInfo("10", "sizeof(" + getCDataTypeFor(context, null, inputNode) + ")");
	}
	
	public MessageQueueInfo createMessageQueueInfoFor(IGeneratorContext context, TaskGraph taskGraph) {
		UnionTypeDeclaration messageUnionTypeDeclaration = createMessageUnionTypeDeclaration(context, taskGraph);
		return new MessageQueueInfo("10", "sizeof(" + messageUnionTypeDeclaration.getName() + ")");
	}
	
	public UnionTypeDeclaration createMessageUnionTypeDeclaration(IGeneratorContext context, TaskGraph taskGraph) {
		EList<Input> inputSockets = getInputSockets(taskGraph);
		if (!inputSockets.isEmpty()) {
			ComponentNode componentNode = (ComponentNode) taskGraph.getInitialNodes().get(0);
			UnionType messageType = MscriptFactory.eINSTANCE.createUnionType();
			for (Input input : inputSockets) {
				if (!input.getPorts().isEmpty()) {
					IComponentGenerator generator = GeneratorNodeExtensions.getComponentGenerator(componentNode);
					IComponentSignature signature = generator.getContext().getComponentSignature();
					Type type = signature.getInputDataType(input.getPorts().get(0));

					CompositeTypeMember member = MscriptFactory.eINSTANCE.createCompositeTypeMember();
					member.setName(input.getName());
					
					CompositeTypeMemberList memberList = MscriptFactory.eINSTANCE.createCompositeTypeMemberList();
					AnonymousTypeSpecifier typeSpecifier = MscriptFactory.eINSTANCE.createAnonymousTypeSpecifier();
					typeSpecifier.setType(type);
					memberList.setTypeSpecifier(typeSpecifier);
					memberList.getMembers().add(member);
					
					messageType.getMemberLists().add(memberList);
				}
			}
			if (!messageType.getMemberLists().isEmpty()) {
				MachineUnionType machineDataType = MachineDataTypes.create(new MscriptGeneratorConfiguration(GeneratorConfigurationExtensions.getComputationModel(context.getConfiguration(), componentNode), context.getConfiguration()), messageType);
				return context.addCodeFragment(new UnionTypeDeclaration(machineDataType), new NullProgressMonitor());
			}
		}
		return null;
	}

	public String getTaskName(Configuration configuration, TaskGraph taskGraph) {
		return GeneratorConfigurationExtensions.getPrefix(configuration, taskGraph.getInitialNodes().get(0)) + ((ComponentNode) taskGraph.getInitialNodes().get(0)).getComponent().getName() + "_Task";
	}
	
	public String getTaskInputVariableName(Configuration configuration, TaskInputNode inputNode) {
		TaskGraph taskGraph = inputNode.getTaskGraph();
		String taskInputVariableName = getTaskName(configuration, taskGraph) + "_input";
		if (taskGraph.getInputNodes().size() > 1) {
			taskInputVariableName += taskGraph.getInputNodes().indexOf(inputNode);
		}
		return taskInputVariableName;
	}

}
