/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.execution.executionflow.internal.construct;

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
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Compound;
import org.eclipselabs.damos.dml.CompoundMember;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.FragmentElement;
import org.eclipselabs.damos.dml.Inoutport;
import org.eclipselabs.damos.dml.Inport;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.InputConnector;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.Outport;
import org.eclipselabs.damos.dml.Output;
import org.eclipselabs.damos.dml.OutputConnector;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.Subsystem;
import org.eclipselabs.damos.dml.SubsystemInput;
import org.eclipselabs.damos.dml.SubsystemOutput;
import org.eclipselabs.damos.dml.SubsystemRealization;
import org.eclipselabs.damos.dml.util.DMLUtil;
import org.eclipselabs.damos.execution.executionflow.ComponentNode;
import org.eclipselabs.damos.execution.executionflow.CompoundNode;
import org.eclipselabs.damos.execution.executionflow.DataFlow;
import org.eclipselabs.damos.execution.executionflow.DataFlowSourceEnd;
import org.eclipselabs.damos.execution.executionflow.DataFlowTargetEnd;
import org.eclipselabs.damos.execution.executionflow.ExecutionFlow;
import org.eclipselabs.damos.execution.executionflow.ExecutionFlowFactory;
import org.eclipselabs.damos.execution.executionflow.Graph;
import org.eclipselabs.damos.execution.executionflow.Node;
import org.eclipselabs.damos.execution.executionflow.PortInfo;
import org.eclipselabs.damos.execution.executionflow.construct.ExecutionFlowPlugin;

/**
 * @author Andreas Unger
 *
 */
public class FlattenerHelper {

	private ExecutionFlow executionFlow;
	
	private Map<Node, Graph> nodeGraphs = new HashMap<Node, Graph>();
	private Map<Graph, Collection<Node>> graphNodes = new LinkedHashMap<Graph, Collection<Node>>();
	private Map<SubsystemBinding<FragmentElement>, Node> allNodes = new HashMap<SubsystemBinding<FragmentElement>, Node>();
	private Map<SubsystemPath, SubsystemDescriptor> subsystemDescriptors = new HashMap<SubsystemPath, SubsystemDescriptor>();

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
		return graphNodes.get(graph);
	}

	public void flatten() throws CoreException {
		flatten(executionFlow.getTopLevelFragment(), new SubsystemPath(), executionFlow.getGraph());
	}
	
	private void flatten(Fragment fragment, SubsystemPath subsystemPath, Graph graph) throws CoreException {
		for (FragmentElement element : fragment.getAllFragmentElements()) {
			flattenFragmentElement(fragment, subsystemPath, graph, element);
		}
		
		Map<SubsystemBinding<OutputConnector>, DataFlow> dataFlows = new HashMap<SubsystemBinding<OutputConnector>, DataFlow>();
		for (Connection connection : fragment.getAllConnections()) {
			if (!subsystemPath.isRoot()) {
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
						
			SubsystemBinding<OutputConnector> source = getActualSource(subsystemPath, connection.getSource());
			DataFlow dataFlow = dataFlows.get(source);
			if (dataFlow == null) {
				dataFlow = ExecutionFlowFactory.eINSTANCE.createDataFlow();
				DataFlowSourceEnd sourceEnd = ExecutionFlowFactory.eINSTANCE.createDataFlowSourceEnd();
				sourceEnd.setDataFlow(dataFlow);
				sourceEnd.setNode(allNodes.get(new SubsystemBinding<FragmentElement>(source.getSubsystemPath(), DMLUtil.getOwner(source.getElement(), FragmentElement.class))));
				sourceEnd.setConnector(source.getElement());

				if (source.getElement() instanceof OutputPort) {
					OutputPort sourcePort = (OutputPort) source.getElement();
					PortInfo portInfo = ExecutionFlowFactory.eINSTANCE.createPortInfo();
					portInfo.setInoutputIndex(DMLUtil.indexOf(sourcePort.getOutput()));
					portInfo.setPortIndex(sourcePort.getIndex());
					sourceEnd.setConnectorInfo(portInfo);
				}
				
				executionFlow.getDataFlows().add(dataFlow);
				dataFlows.put(source, dataFlow);
			}

			List<SubsystemBinding<InputConnector>> targets = getActualTargets(subsystemPath, connection.getTarget());
			for (SubsystemBinding<InputConnector> target : targets) {
				DataFlowTargetEnd targetEnd = ExecutionFlowFactory.eINSTANCE.createDataFlowTargetEnd();
				targetEnd.setDataFlow(dataFlow);
				targetEnd.setNode(allNodes.get(new SubsystemBinding<FragmentElement>(target.getSubsystemPath(), DMLUtil.getOwner(target.getElement(), FragmentElement.class))));
				targetEnd.setConnector(target.getElement());

				if (target.getElement() instanceof InputPort) {
					InputPort targetPort = (InputPort) target.getElement();
					PortInfo portInfo = ExecutionFlowFactory.eINSTANCE.createPortInfo();
					portInfo.setInoutputIndex(DMLUtil.indexOf(targetPort.getInput()));
					portInfo.setPortIndex(targetPort.getIndex());
					targetEnd.setConnectorInfo(portInfo);
				}
			}
		}
	}

	/**
	 * @param fragment
	 * @param subsystemPath
	 * @param element
	 * @throws CoreException
	 */
	private void flattenFragmentElement(Fragment fragment, SubsystemPath subsystemPath, Graph graph, FragmentElement element) throws CoreException {
		if (element instanceof Subsystem) {
			Subsystem subsystem = (Subsystem) element;
			flattenSubsystem(subsystem, fragment, graph, subsystemPath);
		} else if (element instanceof Compound) {
			Compound compound = (Compound) element;
			CompoundNode node = ExecutionFlowFactory.eINSTANCE.createCompoundNode();
			node.setCompound(compound);
			node.getEnclosingSubsystems().addAll(subsystemPath.getSubsystems());
			addGraphNode(graph, node);
			allNodes.put(new SubsystemBinding<FragmentElement>(subsystemPath, compound), node);
			flattenCompound(fragment, subsystemPath, node, compound);
		} else if (element instanceof Component && (!(element instanceof Inoutport) || subsystemPath.isRoot())) {
			Component component = (Component) element;
			ComponentNode node = ExecutionFlowFactory.eINSTANCE.createComponentNode();
			node.setComponent(component);
			node.getEnclosingSubsystems().addAll(subsystemPath.getSubsystems());
			addGraphNode(graph, node);
			allNodes.put(new SubsystemBinding<FragmentElement>(subsystemPath, component), node);
		}
	}
	
	private void flattenCompound(Fragment fragment, SubsystemPath subsystemPath, Graph graph, Compound compound) throws CoreException {
		for (CompoundMember member : compound.getMembers()) {
			flattenFragmentElement(fragment, subsystemPath, graph, (FragmentElement) member);
		}
	}
	
	private void flattenSubsystem(Subsystem subsystem, Fragment context, Graph graph, SubsystemPath subsystemPath) throws CoreException {
		SubsystemRealization realization = subsystem.getRealization(context);
		if (realization == null) {
			throw new CoreException(new Status(IStatus.ERROR, ExecutionFlowPlugin.PLUGIN_ID, "No realization specified for subsystem '" + subsystem.getName() + "'"));
		}
			
		Fragment realizingFragment = realization.getRealizingFragment();

		if (realizingFragment == null) {
			throw new CoreException(new Status(IStatus.ERROR, ExecutionFlowPlugin.PLUGIN_ID, "No realizing fragment specified for subsystem '" + subsystem.getName() + "'"));
		}

		subsystemPath = subsystemPath.append(subsystem);
		SubsystemDescriptor subsystemDescriptor = new SubsystemDescriptor(subsystemPath);

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

		subsystemDescriptors.put(subsystemPath, subsystemDescriptor);
		
		flatten(realizingFragment, subsystemPath, graph);
	}
	
	private SubsystemBinding<OutputConnector> getActualSource(SubsystemPath subsystemPath, OutputConnector source) {
		while (source instanceof OutputPort && ((OutputPort) source).getOutput() instanceof SubsystemOutput) {
			OutputPort sourcePort = (OutputPort) source;
			subsystemPath = subsystemPath.append((Subsystem) sourcePort.getComponent());
			SubsystemDescriptor subsystemDescriptor = subsystemDescriptors.get(subsystemPath);
			if (subsystemDescriptor != null) {
				source = subsystemDescriptor.getOutputs().get(sourcePort.getOutput());
			} else {
				return null;
			}
		}
		return new SubsystemBinding<OutputConnector>(subsystemPath, source);
	}
	
	private List<SubsystemBinding<InputConnector>> getActualTargets(SubsystemPath subsystemPath, InputConnector target) {
		if (target instanceof InputPort && ((InputPort) target).getInput() instanceof SubsystemInput) {
			InputPort targetPort = (InputPort) target;
			List<SubsystemBinding<InputConnector>> actualTargets = new ArrayList<SubsystemBinding<InputConnector>>();
			getActualTargets(subsystemPath, (SubsystemInput) targetPort.getInput(), actualTargets);
			return actualTargets;
		}
		return Collections.singletonList(new SubsystemBinding<InputConnector>(subsystemPath, target));
	}
	
	private void getActualTargets(SubsystemPath subsystemPath, SubsystemInput subsystemInput, List<SubsystemBinding<InputConnector>> actualTargets) {
		subsystemPath = subsystemPath.append((Subsystem) subsystemInput.getComponent());
		SubsystemDescriptor subsystemDescriptor = subsystemDescriptors.get(subsystemPath);
		if (subsystemDescriptor != null) {
			List<InputConnector> targets = subsystemDescriptor.getInputs().get(subsystemInput);
			for (InputConnector target : targets) {
				if (target instanceof InputPort && ((InputPort) target).getInput() instanceof SubsystemInput) {
					InputPort targetPort = (InputPort) target;
					getActualTargets(subsystemPath, (SubsystemInput) targetPort.getInput(), actualTargets);
				} else {
					actualTargets.add(new SubsystemBinding<InputConnector>(subsystemDescriptor.getSubsystemPath(), target));
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
	
	private static class SubsystemBinding<T> {
		
		private SubsystemPath subsystemPath;
		private T element;

		/**
		 * 
		 */
		public SubsystemBinding(SubsystemPath subsystemPath, T element) {
			this.subsystemPath = subsystemPath;
			this.element = element;
		}
		
		public SubsystemPath getSubsystemPath() {
			return subsystemPath;
		}
		
		/**
		 * @return the element
		 */
		public T getElement() {
			return element;
		}
		
		@Override
		public int hashCode() {
			return 31 * element.hashCode() + subsystemPath.hashCode();
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj instanceof SubsystemBinding) {
				SubsystemBinding<?> other = (SubsystemBinding<?>) obj;
				return other.element.equals(element) && other.subsystemPath.equals(subsystemPath);
			}
			return false;
		}

	}

	private static class SubsystemDescriptor {
		
		private SubsystemPath subsystemPath;
		private Map<SubsystemInput, List<InputConnector>> inputs = new HashMap<SubsystemInput, List<InputConnector>>();
		private Map<SubsystemOutput, OutputConnector> outputs = new HashMap<SubsystemOutput, OutputConnector>();
		
		/**
		 * 
		 */
		public SubsystemDescriptor(SubsystemPath subsystemPath) {
			this.subsystemPath = subsystemPath;
		}
		
		/**
		 * @return the subsystemPath
		 */
		public SubsystemPath getSubsystemPath() {
			return subsystemPath;
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
	
	private static class SubsystemPath {
		
		private List<Subsystem> subsystems = Collections.emptyList();
		
		/**
		 * @return the subsystems
		 */
		public List<Subsystem> getSubsystems() {
			return Collections.unmodifiableList(subsystems);
		}
		
		public boolean isRoot() {
			return subsystems.isEmpty();
		}
		
		public SubsystemPath append(Subsystem subsystem) {
			SubsystemPath newSubsystemPath = new SubsystemPath();
			newSubsystemPath.subsystems = new ArrayList<Subsystem>(subsystems.size() + 1);
			newSubsystemPath.subsystems.add(subsystem);
			newSubsystemPath.subsystems.addAll(subsystems);
			return newSubsystemPath;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			return subsystems.hashCode();
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof SubsystemPath) {
				SubsystemPath other = (SubsystemPath) obj;
				return subsystems.equals(other.subsystems);
			}
			return false;
		}

	}
	
}
