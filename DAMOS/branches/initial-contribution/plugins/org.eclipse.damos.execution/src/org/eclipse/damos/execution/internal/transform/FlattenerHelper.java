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

package org.eclipse.damos.execution.internal.transform;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.damos.dml.Action;
import org.eclipse.damos.dml.Choice;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.Compound;
import org.eclipse.damos.dml.CompoundMember;
import org.eclipse.damos.dml.Connection;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.dml.FragmentElement;
import org.eclipse.damos.dml.Inoutport;
import org.eclipse.damos.dml.Inport;
import org.eclipse.damos.dml.Input;
import org.eclipse.damos.dml.InputConnector;
import org.eclipse.damos.dml.InputPort;
import org.eclipse.damos.dml.Latch;
import org.eclipse.damos.dml.Outport;
import org.eclipse.damos.dml.Output;
import org.eclipse.damos.dml.OutputConnector;
import org.eclipse.damos.dml.OutputPort;
import org.eclipse.damos.dml.Subsystem;
import org.eclipse.damos.dml.SubsystemInput;
import org.eclipse.damos.dml.SubsystemOutput;
import org.eclipse.damos.dml.SubsystemRealization;
import org.eclipse.damos.dml.util.DMLUtil;
import org.eclipse.damos.dml.util.SystemPath;
import org.eclipse.damos.execution.ActionNode;
import org.eclipse.damos.execution.ComponentNode;
import org.eclipse.damos.execution.CompoundNode;
import org.eclipse.damos.execution.DataFlow;
import org.eclipse.damos.execution.DataFlowSourceEnd;
import org.eclipse.damos.execution.DataFlowTargetEnd;
import org.eclipse.damos.execution.ExecutionFactory;
import org.eclipse.damos.execution.ExecutionFlow;
import org.eclipse.damos.execution.Graph;
import org.eclipse.damos.execution.Node;
import org.eclipse.damos.execution.PortInfo;
import org.eclipse.damos.execution.internal.ExecutionPlugin;

/**
 * @author Andreas Unger
 *
 */
public class FlattenerHelper {

	private ExecutionFlow executionFlow;
	
	private Map<Node, Graph> nodeGraphs = new HashMap<Node, Graph>();
	private Map<Graph, Collection<Node>> graphNodes = new LinkedHashMap<Graph, Collection<Node>>();
	private Map<SubsystemBinding<FragmentElement>, Node> allNodes = new HashMap<SubsystemBinding<FragmentElement>, Node>();
	private Map<SystemPath, SubsystemDescriptor> subsystemDescriptors = new HashMap<SystemPath, SubsystemDescriptor>();

	/**
	 * 
	 */
	public FlattenerHelper(ExecutionFlow flow) {
		this.executionFlow = flow;
	}
	
	public Graph getGraph(Node node) {
		return nodeGraphs.get(node);
	}
	
	public Collection<Node> getNodes(Graph graph) {
		Collection<Node> nodes = graphNodes.get(graph);
		if (nodes == null) {
			nodes = Collections.emptyList();
		}
		return nodes;
	}
	
	public ComponentNode getComponentNode(Graph graph, Component component) {
		for (Node node : graphNodes.get(graph)) {
			if (node instanceof ComponentNode) {
				ComponentNode componentNode = (ComponentNode) node;
				if (componentNode.getComponent() == component) {
					return componentNode;
				}
			}
		}
		return null;
	}

	public void flatten() throws CoreException {
		flatten(executionFlow.getTopLevelFragment(), SystemPath.create(executionFlow.getTopLevelFragment()), executionFlow.getGraph());
	}
	
	private void flatten(Fragment fragment, SystemPath systemPath, Graph graph) throws CoreException {
		for (FragmentElement element : fragment.getAllFragmentElements()) {
			flattenFragmentElement(fragment, systemPath, graph, element);
		}
		
		initializeActionNodes(graph);
		initializeDataFlows(fragment, systemPath);
	}

	/**
	 * @param fragment
	 * @param systemPath
	 * @param element
	 * @throws CoreException
	 */
	private void flattenFragmentElement(Fragment fragment, SystemPath systemPath, Graph graph, FragmentElement element) throws CoreException {
		if (element instanceof Subsystem) {
			Subsystem subsystem = (Subsystem) element;
			flattenSubsystem(subsystem, fragment, graph, systemPath);
		} else if (element instanceof Compound) {
			Compound compound = (Compound) element;
			CompoundNode node;
			if (element instanceof Action) {
				node = ExecutionFactory.eINSTANCE.createActionNode();
			} else {
				node = ExecutionFactory.eINSTANCE.createCompoundNode();
			}
			node.setCompound(compound);
			node.getEnclosingSubsystems().addAll(systemPath.getSubsystems());
			addGraphNode(graph, node);
			allNodes.put(new SubsystemBinding<FragmentElement>(systemPath, compound), node);
			flattenCompound(fragment, systemPath, node, compound);
		} else if (element instanceof Component && (!(element instanceof Inoutport) || systemPath.isRoot())) {
			Component component = (Component) element;
			ComponentNode node;
			if (component instanceof Latch) {
				node = ExecutionFactory.eINSTANCE.createLatchNode();
			} else {
				node = ExecutionFactory.eINSTANCE.createComponentNode();
			}
			node.setComponent(component);
			node.getEnclosingSubsystems().addAll(systemPath.getSubsystems());
			addGraphNode(graph, node);
			allNodes.put(new SubsystemBinding<FragmentElement>(systemPath, component), node);
		}
	}
	
	private void flattenCompound(Fragment fragment, SystemPath systemPath, Graph graph, Compound compound) throws CoreException {
		for (CompoundMember member : compound.getMembers()) {
			flattenFragmentElement(fragment, systemPath, graph, (FragmentElement) member);
		}
	}
	
	private void flattenSubsystem(Subsystem subsystem, Fragment context, Graph graph, SystemPath systemPath) throws CoreException {
		SubsystemRealization realization = subsystem.getRealization(context);
		if (realization == null) {
			throw new CoreException(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "No realization specified for subsystem '" + subsystem.getName() + "'"));
		}
			
		Fragment realizingFragment = realization.getRealizingFragment();

		if (realizingFragment == null) {
			throw new CoreException(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "No realizing fragment specified for subsystem '" + subsystem.getName() + "'"));
		}

		systemPath = systemPath.append(subsystem);
		SubsystemDescriptor subsystemDescriptor = new SubsystemDescriptor(systemPath);

		Map<String, Inport> inports = DMLUtil.getComponentMap(realizingFragment, Inport.class);
		for (Input input : subsystem.getInputs()) {
			if (input instanceof SubsystemInput) {
				SubsystemInput subsystemInput = (SubsystemInput) input;
				Inport inport = inports.get(subsystemInput.getInlet().getName());
				if (inport != null) {
					List<InputConnector> inputConnectors = new ArrayList<InputConnector>();
					for (Connection connection : inport.getFirstOutputPort().getConnections(realizingFragment)) {
						inputConnectors.add(connection.getTarget());
					}
					subsystemDescriptor.getInputs().put(subsystemInput, inputConnectors);
				}
			}
		}
		
		Map<String, Outport> outports = DMLUtil.getComponentMap(realizingFragment, Outport.class);
		for (Output output : subsystem.getOutputs()) {
			if (output instanceof SubsystemOutput) {
				SubsystemOutput subsystemOutput = (SubsystemOutput) output;
				Outport outport = outports.get(subsystemOutput.getOutlet().getName());
				if (outport != null) {
					subsystemDescriptor.getOutputs().put(subsystemOutput, outport.getFirstInputPort().getFirstConnection(realizingFragment).getSource());
				}
			}
		}

		subsystemDescriptors.put(systemPath, subsystemDescriptor);
		
		flatten(realizingFragment, systemPath, graph);
	}
	
	private SubsystemBinding<OutputConnector> getActualSource(SystemPath systemPath, OutputConnector source) {
		while (source instanceof OutputPort && ((OutputPort) source).getOutput() instanceof SubsystemOutput) {
			OutputPort sourcePort = (OutputPort) source;
			systemPath = systemPath.append((Subsystem) sourcePort.getComponent());
			SubsystemDescriptor subsystemDescriptor = subsystemDescriptors.get(systemPath);
			if (subsystemDescriptor != null) {
				source = subsystemDescriptor.getOutputs().get(sourcePort.getOutput());
			} else {
				return null;
			}
		}
		return new SubsystemBinding<OutputConnector>(systemPath, source);
	}
	
	private List<SubsystemBinding<InputConnector>> getActualTargets(SystemPath systemPath, InputConnector target) {
		if (target instanceof InputPort && ((InputPort) target).getInput() instanceof SubsystemInput) {
			InputPort targetPort = (InputPort) target;
			List<SubsystemBinding<InputConnector>> actualTargets = new ArrayList<SubsystemBinding<InputConnector>>();
			getActualTargets(systemPath, (SubsystemInput) targetPort.getInput(), actualTargets);
			return actualTargets;
		}
		return Collections.singletonList(new SubsystemBinding<InputConnector>(systemPath, target));
	}
	
	private void getActualTargets(SystemPath systemPath, SubsystemInput subsystemInput, List<SubsystemBinding<InputConnector>> actualTargets) {
		systemPath = systemPath.append((Subsystem) subsystemInput.getComponent());
		SubsystemDescriptor subsystemDescriptor = subsystemDescriptors.get(systemPath);
		if (subsystemDescriptor != null) {
			List<InputConnector> targets = subsystemDescriptor.getInputs().get(subsystemInput);
			for (InputConnector target : targets) {
				if (target instanceof InputPort && ((InputPort) target).getInput() instanceof SubsystemInput) {
					InputPort targetPort = (InputPort) target;
					getActualTargets(systemPath, (SubsystemInput) targetPort.getInput(), actualTargets);
				} else {
					actualTargets.add(new SubsystemBinding<InputConnector>(subsystemDescriptor.getSystemPath(), target));
				}
			}
		}
	}
	
	private void addGraphNode(Graph graph, Node node) {
		Collection<Node> nodes = graphNodes.get(graph);
		if (nodes == null) {
			nodes = new ArrayList<Node>();
			graphNodes.put(graph, nodes);
		}
		nodes.add(node);
		nodeGraphs.put(node, graph);
	}
	
	/**
	 * @param graph
	 * @throws CoreException
	 */
	private void initializeActionNodes(Graph graph) throws CoreException {
		for (Node node : getNodes(graph)) {
			if (node instanceof ActionNode) {
				ActionNode actionNode = (ActionNode) node;
				Action action = (Action) actionNode.getCompound();
				if (action.getLink() != null) {
					Choice choice = action.getLink().getChoice();
					ComponentNode choiceNode = getComponentNode(graph, choice);
					if (choiceNode == null) {
						throw new CoreException(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "Choice node for choice '" + choice.getName() + "' not found"));
					}
					actionNode.setChoiceNode(choiceNode);
				}
			}
		}
	}

	/**
	 * @param fragment
	 * @param systemPath
	 */
	private void initializeDataFlows(Fragment fragment, SystemPath systemPath) {
		Map<SubsystemBinding<OutputConnector>, DataFlow> dataFlows = new HashMap<SubsystemBinding<OutputConnector>, DataFlow>();
		for (Connection connection : fragment.getAllConnections()) {
			if (!systemPath.isRoot()) {
				if (connection.getSource() instanceof OutputPort) {
					OutputPort outputPort = (OutputPort) connection.getSource();
					if (outputPort.getComponent() instanceof Inoutport) {
						continue;
					}
				}
				if (connection.getTarget() instanceof InputPort) {
					InputPort inputPort = (InputPort) connection.getTarget();
					if (inputPort.getComponent() instanceof Inoutport) {
						continue;
					}
				}
			}
						
			SubsystemBinding<OutputConnector> source = getActualSource(systemPath, connection.getSource());
			DataFlow dataFlow = dataFlows.get(source);
			if (dataFlow == null) {
				dataFlow = ExecutionFactory.eINSTANCE.createDataFlow();
				DataFlowSourceEnd sourceEnd = ExecutionFactory.eINSTANCE.createDataFlowSourceEnd();
				sourceEnd.setDataFlow(dataFlow);
				sourceEnd.setNode(allNodes.get(new SubsystemBinding<FragmentElement>(source.getSystemPath(), DMLUtil.getOwner(source.getElement(), FragmentElement.class))));
				sourceEnd.setConnector(source.getElement());
	
				if (source.getElement() instanceof OutputPort) {
					OutputPort sourcePort = (OutputPort) source.getElement();
					PortInfo portInfo = ExecutionFactory.eINSTANCE.createPortInfo();
					portInfo.setInoutputIndex(DMLUtil.indexOf(sourcePort.getOutput()));
					portInfo.setPortIndex(sourcePort.getIndex());
					sourceEnd.setConnectorInfo(portInfo);
				}
				
				executionFlow.getDataFlows().add(dataFlow);
				dataFlows.put(source, dataFlow);
			}
	
			List<SubsystemBinding<InputConnector>> targets = getActualTargets(systemPath, connection.getTarget());
			for (SubsystemBinding<InputConnector> target : targets) {
				DataFlowTargetEnd targetEnd = ExecutionFactory.eINSTANCE.createDataFlowTargetEnd();
				targetEnd.setDataFlow(dataFlow);
				targetEnd.setNode(allNodes.get(new SubsystemBinding<FragmentElement>(target.getSystemPath(), DMLUtil.getOwner(target.getElement(), FragmentElement.class))));
				targetEnd.setConnector(target.getElement());
	
				if (target.getElement() instanceof InputPort) {
					InputPort targetPort = (InputPort) target.getElement();
					PortInfo portInfo = ExecutionFactory.eINSTANCE.createPortInfo();
					portInfo.setInoutputIndex(DMLUtil.indexOf(targetPort.getInput()));
					portInfo.setPortIndex(targetPort.getIndex());
					targetEnd.setConnectorInfo(portInfo);
				}
			}
		}
	}

	private static class SubsystemBinding<T> {
		
		private SystemPath systemPath;
		private T element;

		/**
		 * 
		 */
		public SubsystemBinding(SystemPath systemPath, T element) {
			this.systemPath = systemPath;
			this.element = element;
		}
		
		public SystemPath getSystemPath() {
			return systemPath;
		}
		
		/**
		 * @return the element
		 */
		public T getElement() {
			return element;
		}
		
		@Override
		public int hashCode() {
			return 31 * element.hashCode() + systemPath.hashCode();
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj instanceof SubsystemBinding) {
				SubsystemBinding<?> other = (SubsystemBinding<?>) obj;
				return other.element.equals(element) && other.systemPath.equals(systemPath);
			}
			return false;
		}

	}

	private static class SubsystemDescriptor {
		
		private SystemPath systemPath;
		private Map<SubsystemInput, List<InputConnector>> inputs = new HashMap<SubsystemInput, List<InputConnector>>();
		private Map<SubsystemOutput, OutputConnector> outputs = new HashMap<SubsystemOutput, OutputConnector>();
		
		/**
		 * 
		 */
		public SubsystemDescriptor(SystemPath systemPath) {
			this.systemPath = systemPath;
		}
		
		/**
		 * @return the systemPath
		 */
		public SystemPath getSystemPath() {
			return systemPath;
		}
		
		/**
		 * @return the inputs
		 */
		public Map<SubsystemInput, List<InputConnector>> getInputs() {
			return inputs;
		}
		
		/**
		 * @return the outputs
		 */
		public Map<SubsystemOutput, OutputConnector> getOutputs() {
			return outputs;
		}
		
	}
	
}
