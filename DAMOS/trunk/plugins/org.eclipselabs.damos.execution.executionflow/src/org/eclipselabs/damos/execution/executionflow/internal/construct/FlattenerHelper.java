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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.FragmentElement;
import org.eclipselabs.damos.dml.Inoutport;
import org.eclipselabs.damos.dml.Inport;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.Outport;
import org.eclipselabs.damos.dml.Output;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.Subsystem;
import org.eclipselabs.damos.dml.SubsystemInput;
import org.eclipselabs.damos.dml.SubsystemOutput;
import org.eclipselabs.damos.dml.SubsystemRealization;
import org.eclipselabs.damos.dml.util.DMLUtil;
import org.eclipselabs.damos.execution.executionflow.ComponentNode;
import org.eclipselabs.damos.execution.executionflow.DataFlow;
import org.eclipselabs.damos.execution.executionflow.DataFlowSourceEnd;
import org.eclipselabs.damos.execution.executionflow.DataFlowTargetEnd;
import org.eclipselabs.damos.execution.executionflow.ExecutionFlow;
import org.eclipselabs.damos.execution.executionflow.ExecutionFlowFactory;
import org.eclipselabs.damos.execution.executionflow.Node;
import org.eclipselabs.damos.execution.executionflow.PortInfo;

/**
 * @author Andreas Unger
 *
 */
public class FlattenerHelper {

	private ExecutionFlow flow;
	
	private Map<SubsystemBinding<FragmentElement>, Node> nodes = new LinkedHashMap<SubsystemBinding<FragmentElement>, Node>();
	private Map<Subsystem, SubsystemDescriptor> subsystemDescriptors = new HashMap<Subsystem, SubsystemDescriptor>();

	/**
	 * 
	 */
	public FlattenerHelper(ExecutionFlow flow) {
		this.flow = flow;
	}
	
	public Collection<Node> getNodes() {
		return nodes.values();
	}

	public void flatten() {
		flatten(flow.getTopLevelFragment(), new LinkedList<Subsystem>());
	}
	
	private void flatten(Fragment fragment, LinkedList<Subsystem> enclosingSubsystems) {
		Subsystem enclosingSubsystem = enclosingSubsystems.isEmpty() ? null : enclosingSubsystems.get(0);

		for (FragmentElement element : fragment.getAllFragmentElements()) {
			if (element instanceof Subsystem) {
				Subsystem subsystem = (Subsystem) element;
				flattenSubsystem(subsystem, fragment, enclosingSubsystems);
			} else if (element instanceof Component && (!(element instanceof Inoutport) || enclosingSubsystems.isEmpty())) {
				Component component = (Component) element;
				ComponentNode node = ExecutionFlowFactory.eINSTANCE.createComponentNode();
				node.setComponent(component);
				node.getEnclosingSubsystems().addAll(enclosingSubsystems);
				nodes.put(new SubsystemBinding<FragmentElement>(enclosingSubsystem, component), node);
			}
		}
		
		Map<OutputPort, DataFlow> dataFlows = new HashMap<OutputPort, DataFlow>();
		for (Connection connection : fragment.getAllConnections()) {
			if ((connection.getSourcePort().getComponent() instanceof Inoutport || connection.getTargetPort().getComponent() instanceof Inoutport) && !enclosingSubsystems.isEmpty()) {
				continue;
			}
						
			SubsystemBinding<OutputPort> sourcePort = getActualSourcePort(enclosingSubsystem, connection.getSourcePort());
			DataFlow dataFlow = dataFlows.get(sourcePort);
			if (dataFlow == null) {
				dataFlow = ExecutionFlowFactory.eINSTANCE.createDataFlow();
				DataFlowSourceEnd sourceEnd = ExecutionFlowFactory.eINSTANCE.createDataFlowSourceEnd();
				sourceEnd.setDataFlow(dataFlow);
				sourceEnd.setNode(nodes.get(new SubsystemBinding<FragmentElement>(sourcePort.getSubsystem(), sourcePort.getElement().getComponent())));
				sourceEnd.setConnector(sourcePort.getElement());

				PortInfo portInfo = ExecutionFlowFactory.eINSTANCE.createPortInfo();
				portInfo.setInoutputIndex(DMLUtil.indexOf(sourcePort.getElement().getOutput()));
				portInfo.setPortIndex(sourcePort.getElement().getIndex());
				sourceEnd.setConnectorInfo(portInfo);
				
				flow.getDataFlows().add(dataFlow);
				dataFlows.put(sourcePort.getElement(), dataFlow);
			}

			List<SubsystemBinding<InputPort>> targetPorts = getActualTargetPorts(enclosingSubsystem, connection.getTargetPort());
			for (SubsystemBinding<InputPort> targetPort : targetPorts) {
				DataFlowTargetEnd targetEnd = ExecutionFlowFactory.eINSTANCE.createDataFlowTargetEnd();
				targetEnd.setDataFlow(dataFlow);
				targetEnd.setNode(nodes.get(new SubsystemBinding<FragmentElement>(targetPort.getSubsystem(), targetPort.getElement().getComponent())));
				targetEnd.setConnector(targetPort.getElement());

				PortInfo portInfo = ExecutionFlowFactory.eINSTANCE.createPortInfo();
				portInfo.setInoutputIndex(DMLUtil.indexOf(targetPort.getElement().getInput()));
				portInfo.setPortIndex(targetPort.getElement().getIndex());
				targetEnd.setConnectorInfo(portInfo);
			}
		}
	}
	
	private void flattenSubsystem(Subsystem subsystem, Fragment context, LinkedList<Subsystem> enclosingSubsystems) {
		SubsystemRealization realization = subsystem.getRealization(context);
		if (realization != null) {
			// TODO: Throw exception if no realization provided
			Fragment realizingFragment = realization.getRealizingFragment();
			if (realizingFragment != null) {
				SubsystemDescriptor subsystemDescriptor = new SubsystemDescriptor(subsystem);

				Map<String, Inport> inports = DMLUtil.getComponentMap(realizingFragment, Inport.class);
				for (Input input : subsystem.getInputs()) {
					if (input instanceof SubsystemInput) {
						SubsystemInput subsystemInput = (SubsystemInput) input;
						Inport inport = inports.get(subsystemInput.getInlet().getName());
						if (inport != null) {
							List<InputPort> inputPorts = new ArrayList<InputPort>();
							for (Connection connection : inport.getFirstOutputPort().getConnections(realizingFragment)) {
								inputPorts.add(connection.getTargetPort());
							}
							subsystemDescriptor.getInputs().put(subsystemInput, inputPorts);
						}
					}
				}
				
				Map<String, Outport> outports = DMLUtil.getComponentMap(realizingFragment, Outport.class);
				for (Output output : subsystem.getOutputs()) {
					if (output instanceof SubsystemOutput) {
						SubsystemOutput subsystemOutput = (SubsystemOutput) output;
						Outport outport = outports.get(subsystemOutput.getOutlet().getName());
						if (outport != null) {
							subsystemDescriptor.getOutputs().put(subsystemOutput, outport.getFirstInputPort().getFirstConnection(realizingFragment).getSourcePort());
						}
					}
				}

				subsystemDescriptors.put(subsystem, subsystemDescriptor);
				
				enclosingSubsystems.addFirst(subsystem);
				flatten(realizingFragment, enclosingSubsystems);
				enclosingSubsystems.removeFirst();
			}
		}
	}
	
	private SubsystemBinding<OutputPort> getActualSourcePort(Subsystem subsystem, OutputPort sourcePort) {
		while (sourcePort.getOutput() instanceof SubsystemOutput) {
			SubsystemDescriptor subsystemDescriptor = subsystemDescriptors.get(sourcePort.getComponent());
			if (subsystemDescriptor != null) {
				subsystem = subsystemDescriptor.getSubsystem();
				sourcePort = subsystemDescriptor.getOutputs().get(sourcePort.getOutput());
			} else {
				return null;
			}
		}
		return new SubsystemBinding<OutputPort>(subsystem, sourcePort);
	}
	
	private List<SubsystemBinding<InputPort>> getActualTargetPorts(Subsystem subsystem, InputPort targetPort) {
		if (targetPort.getInput() instanceof SubsystemInput) {
			List<SubsystemBinding<InputPort>> actualTargetPorts = new ArrayList<SubsystemBinding<InputPort>>();
			getActualTargetPorts((SubsystemInput) targetPort.getInput(), actualTargetPorts);
			return actualTargetPorts;
		}
		return Collections.singletonList(new SubsystemBinding<InputPort>(subsystem, targetPort));
	}
	
	private void getActualTargetPorts(SubsystemInput subsystemInput, List<SubsystemBinding<InputPort>> actualTargetPorts) {
		SubsystemDescriptor subsystemDescriptor = subsystemDescriptors.get(subsystemInput.getComponent());
		if (subsystemDescriptor != null) {
			List<InputPort> targetPorts = subsystemDescriptor.getInputs().get(subsystemInput);
			for (InputPort targetPort : targetPorts) {
				if (targetPort.getInput() instanceof SubsystemInput) {
					getActualTargetPorts((SubsystemInput) targetPort.getInput(), actualTargetPorts);
				} else {
					actualTargetPorts.add(new SubsystemBinding<InputPort>(subsystemDescriptor.getSubsystem(), targetPort));
				}
			}
		}
	}
	
	private static class SubsystemBinding<T> {
		
		private Subsystem subsystem;
		private T element;

		/**
		 * 
		 */
		public SubsystemBinding(Subsystem subsystem, T element) {
			this.subsystem = subsystem;
			this.element = element;
		}
		
		/**
		 * @return the subsystem
		 */
		public Subsystem getSubsystem() {
			return subsystem;
		}
		
		/**
		 * @return the element
		 */
		public T getElement() {
			return element;
		}
		
		@Override
		public int hashCode() {
			return (subsystem != null ? subsystem.hashCode() : 0) ^ element.hashCode();
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj instanceof SubsystemBinding) {
				SubsystemBinding<?> other = (SubsystemBinding<?>) obj;
				return other.subsystem == subsystem && other.element == element;
			}
			return false;
		}

	}

	private static class SubsystemDescriptor {
		
		private Subsystem subsystem;
		private Map<SubsystemInput, List<InputPort>> inputs = new HashMap<SubsystemInput, List<InputPort>>();
		private Map<SubsystemOutput, OutputPort> outputs = new HashMap<SubsystemOutput, OutputPort>();
		
		/**
		 * 
		 */
		public SubsystemDescriptor(Subsystem subsystem) {
			this.subsystem = subsystem;
		}
		
		/**
		 * @return the subsystem
		 */
		public Subsystem getSubsystem() {
			return subsystem;
		}
		
		/**
		 * @return the inputs
		 */
		public Map<SubsystemInput, List<InputPort>> getInputs() {
			return inputs;
		}
		
		/**
		 * @return the outputs
		 */
		public Map<SubsystemOutput, OutputPort> getOutputs() {
			return outputs;
		}
		
	}
	
}
