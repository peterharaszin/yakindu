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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Compound;
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
import org.eclipselabs.damos.execution.executionflow.CompoundNode;
import org.eclipselabs.damos.execution.executionflow.DataFlow;
import org.eclipselabs.damos.execution.executionflow.DataFlowSourceEnd;
import org.eclipselabs.damos.execution.executionflow.DataFlowTargetEnd;
import org.eclipselabs.damos.execution.executionflow.ExecutionFlow;
import org.eclipselabs.damos.execution.executionflow.ExecutionFlowFactory;
import org.eclipselabs.damos.execution.executionflow.Node;
import org.eclipselabs.damos.execution.executionflow.PortInfo;
import org.eclipselabs.damos.execution.executionflow.construct.ExecutionFlowPlugin;

/**
 * @author Andreas Unger
 *
 */
public class FlattenerHelper {

	private ExecutionFlow executionFlow;
	
	private Map<SubsystemBinding<FragmentElement>, Node> nodes = new LinkedHashMap<SubsystemBinding<FragmentElement>, Node>();
	private Map<Subsystem, SubsystemDescriptor> subsystemDescriptors = new HashMap<Subsystem, SubsystemDescriptor>();

	/**
	 * 
	 */
	public FlattenerHelper(ExecutionFlow flow) {
		this.executionFlow = flow;
	}
	
	public Collection<Node> getNodes() {
		return nodes.values();
	}

	public void flatten() throws CoreException {
		flatten(executionFlow.getTopLevelFragment(), new LinkedList<Subsystem>());
	}
	
	private void flatten(Fragment fragment, LinkedList<Subsystem> enclosingSubsystems) throws CoreException {
		for (FragmentElement element : fragment.getAllFragmentElements()) {
			if (element instanceof Subsystem) {
				Subsystem subsystem = (Subsystem) element;
				flattenSubsystem(subsystem, fragment, enclosingSubsystems);
			} else if (element instanceof Compound) {
				Compound compound = (Compound) element;
				CompoundNode node = ExecutionFlowFactory.eINSTANCE.createCompoundNode();
				node.setCompound(compound);
				node.getEnclosingSubsystems().addAll(enclosingSubsystems);
				nodes.put(new SubsystemBinding<FragmentElement>(enclosingSubsystems, compound), node);
			} else if (element instanceof Component && (!(element instanceof Inoutport) || enclosingSubsystems.isEmpty())) {
				Component component = (Component) element;
				ComponentNode node = ExecutionFlowFactory.eINSTANCE.createComponentNode();
				node.setComponent(component);
				node.getEnclosingSubsystems().addAll(enclosingSubsystems);
				nodes.put(new SubsystemBinding<FragmentElement>(enclosingSubsystems, component), node);
			}
		}
		
		Map<SubsystemBinding<OutputPort>, DataFlow> dataFlows = new HashMap<SubsystemBinding<OutputPort>, DataFlow>();
		for (Connection connection : fragment.getAllConnections()) {
			if ((connection.getSourcePort().getComponent() instanceof Inoutport || connection.getTargetPort().getComponent() instanceof Inoutport) && !enclosingSubsystems.isEmpty()) {
				continue;
			}
						
			SubsystemBinding<OutputPort> sourcePort = getActualSourcePort(enclosingSubsystems, connection.getSourcePort());
			DataFlow dataFlow = dataFlows.get(sourcePort);
			if (dataFlow == null) {
				dataFlow = ExecutionFlowFactory.eINSTANCE.createDataFlow();
				DataFlowSourceEnd sourceEnd = ExecutionFlowFactory.eINSTANCE.createDataFlowSourceEnd();
				sourceEnd.setDataFlow(dataFlow);
				sourceEnd.setNode(nodes.get(new SubsystemBinding<FragmentElement>(sourcePort.getEnclosingSubsystems(), sourcePort.getElement().getComponent())));
				sourceEnd.setConnector(sourcePort.getElement());

				PortInfo portInfo = ExecutionFlowFactory.eINSTANCE.createPortInfo();
				portInfo.setInoutputIndex(DMLUtil.indexOf(sourcePort.getElement().getOutput()));
				portInfo.setPortIndex(sourcePort.getElement().getIndex());
				sourceEnd.setConnectorInfo(portInfo);
				
				executionFlow.getDataFlows().add(dataFlow);
				dataFlows.put(sourcePort, dataFlow);
			}

			List<SubsystemBinding<InputPort>> targetPorts = getActualTargetPorts(enclosingSubsystems, connection.getTargetPort());
			for (SubsystemBinding<InputPort> targetPort : targetPorts) {
				DataFlowTargetEnd targetEnd = ExecutionFlowFactory.eINSTANCE.createDataFlowTargetEnd();
				targetEnd.setDataFlow(dataFlow);
				targetEnd.setNode(nodes.get(new SubsystemBinding<FragmentElement>(targetPort.getEnclosingSubsystems(), targetPort.getElement().getComponent())));
				targetEnd.setConnector(targetPort.getElement());

				PortInfo portInfo = ExecutionFlowFactory.eINSTANCE.createPortInfo();
				portInfo.setInoutputIndex(DMLUtil.indexOf(targetPort.getElement().getInput()));
				portInfo.setPortIndex(targetPort.getElement().getIndex());
				targetEnd.setConnectorInfo(portInfo);
			}
		}
	}
	
	private void flattenSubsystem(Subsystem subsystem, Fragment context, LinkedList<Subsystem> enclosingSubsystems) throws CoreException {
		SubsystemRealization realization = subsystem.getRealization(context);
		if (realization == null) {
			throw new CoreException(new Status(IStatus.ERROR, ExecutionFlowPlugin.PLUGIN_ID, "No realization specified for subsystem '" + subsystem.getName() + "'"));
		}
			
		Fragment realizingFragment = realization.getRealizingFragment();

		if (realizingFragment == null) {
			throw new CoreException(new Status(IStatus.ERROR, ExecutionFlowPlugin.PLUGIN_ID, "No realizing fragment specified for subsystem '" + subsystem.getName() + "'"));
		}

		enclosingSubsystems.addFirst(subsystem);
		SubsystemDescriptor subsystemDescriptor = new SubsystemDescriptor(enclosingSubsystems);

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
		
		flatten(realizingFragment, enclosingSubsystems);
		enclosingSubsystems.removeFirst();
	}
	
	private SubsystemBinding<OutputPort> getActualSourcePort(List<Subsystem> enclosingSubsystems, OutputPort sourcePort) {
		while (sourcePort.getOutput() instanceof SubsystemOutput) {
			SubsystemDescriptor subsystemDescriptor = subsystemDescriptors.get(sourcePort.getComponent());
			if (subsystemDescriptor != null) {
				enclosingSubsystems = subsystemDescriptor.getEnclosingSubsystems();
				sourcePort = subsystemDescriptor.getOutputs().get(sourcePort.getOutput());
			} else {
				return null;
			}
		}
		return new SubsystemBinding<OutputPort>(enclosingSubsystems, sourcePort);
	}
	
	private List<SubsystemBinding<InputPort>> getActualTargetPorts(List<Subsystem> enclosingSubsystems, InputPort targetPort) {
		if (targetPort.getInput() instanceof SubsystemInput) {
			List<SubsystemBinding<InputPort>> actualTargetPorts = new ArrayList<SubsystemBinding<InputPort>>();
			getActualTargetPorts((SubsystemInput) targetPort.getInput(), actualTargetPorts);
			return actualTargetPorts;
		}
		return Collections.singletonList(new SubsystemBinding<InputPort>(enclosingSubsystems, targetPort));
	}
	
	private void getActualTargetPorts(SubsystemInput subsystemInput, List<SubsystemBinding<InputPort>> actualTargetPorts) {
		SubsystemDescriptor subsystemDescriptor = subsystemDescriptors.get(subsystemInput.getComponent());
		if (subsystemDescriptor != null) {
			List<InputPort> targetPorts = subsystemDescriptor.getInputs().get(subsystemInput);
			for (InputPort targetPort : targetPorts) {
				if (targetPort.getInput() instanceof SubsystemInput) {
					getActualTargetPorts((SubsystemInput) targetPort.getInput(), actualTargetPorts);
				} else {
					actualTargetPorts.add(new SubsystemBinding<InputPort>(subsystemDescriptor.getEnclosingSubsystems(), targetPort));
				}
			}
		}
	}
	
	private static class SubsystemBinding<T> {
		
		private List<Subsystem> enclosingSubsystems;
		private T element;

		/**
		 * 
		 */
		public SubsystemBinding(List<Subsystem> enclosingSubsystems, T element) {
			this.enclosingSubsystems = new ArrayList<Subsystem>(enclosingSubsystems);
			this.element = element;
		}
		
		public List<Subsystem> getEnclosingSubsystems() {
			return enclosingSubsystems;
		}
		
		/**
		 * @return the element
		 */
		public T getElement() {
			return element;
		}
		
		@Override
		public int hashCode() {
			return 31 * element.hashCode() + enclosingSubsystems.hashCode();
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj instanceof SubsystemBinding) {
				SubsystemBinding<?> other = (SubsystemBinding<?>) obj;
				return other.element.equals(element) && other.enclosingSubsystems.equals(enclosingSubsystems);
			}
			return false;
		}

	}

	private static class SubsystemDescriptor {
		
		private List<Subsystem> enclosingSubsystems;
		private Map<SubsystemInput, List<InputPort>> inputs = new HashMap<SubsystemInput, List<InputPort>>();
		private Map<SubsystemOutput, OutputPort> outputs = new HashMap<SubsystemOutput, OutputPort>();
		
		/**
		 * 
		 */
		public SubsystemDescriptor(List<Subsystem> enclosingSubsystems) {
			this.enclosingSubsystems = new ArrayList<Subsystem>(enclosingSubsystems);
		}
		
		/**
		 * @return the enclosingSubsystems
		 */
		public List<Subsystem> getEnclosingSubsystems() {
			return enclosingSubsystems;
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
