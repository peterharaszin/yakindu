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
	private Map<List<Subsystem>, SubsystemDescriptor> subsystemDescriptors = new HashMap<List<Subsystem>, SubsystemDescriptor>();

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
		
		Map<SubsystemBinding<OutputConnector>, DataFlow> dataFlows = new HashMap<SubsystemBinding<OutputConnector>, DataFlow>();
		for (Connection connection : fragment.getAllConnections()) {
			if (!enclosingSubsystems.isEmpty()) {
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
						
			SubsystemBinding<OutputConnector> source = getActualSource(enclosingSubsystems, connection.getSource());
			DataFlow dataFlow = dataFlows.get(source);
			if (dataFlow == null) {
				dataFlow = ExecutionFlowFactory.eINSTANCE.createDataFlow();
				DataFlowSourceEnd sourceEnd = ExecutionFlowFactory.eINSTANCE.createDataFlowSourceEnd();
				sourceEnd.setDataFlow(dataFlow);
				sourceEnd.setNode(nodes.get(new SubsystemBinding<FragmentElement>(source.getEnclosingSubsystems(), DMLUtil.getOwner(source.getElement(), FragmentElement.class))));
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

			List<SubsystemBinding<InputConnector>> targets = getActualTargets(enclosingSubsystems, connection.getTarget());
			for (SubsystemBinding<InputConnector> target : targets) {
				DataFlowTargetEnd targetEnd = ExecutionFlowFactory.eINSTANCE.createDataFlowTargetEnd();
				targetEnd.setDataFlow(dataFlow);
				targetEnd.setNode(nodes.get(new SubsystemBinding<FragmentElement>(target.getEnclosingSubsystems(), DMLUtil.getOwner(target.getElement(), FragmentElement.class))));
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

		subsystemDescriptors.put(new ArrayList<Subsystem>(enclosingSubsystems), subsystemDescriptor);
		
		flatten(realizingFragment, enclosingSubsystems);
		enclosingSubsystems.removeFirst();
	}
	
	private SubsystemBinding<OutputConnector> getActualSource(List<Subsystem> enclosingSubsystems, OutputConnector source) {
		while (source instanceof OutputPort && ((OutputPort) source).getOutput() instanceof SubsystemOutput) {
			OutputPort sourcePort = (OutputPort) source;
			ArrayList<Subsystem> newEnclosingSubsystems = new ArrayList<Subsystem>(enclosingSubsystems.size() + 1);
			newEnclosingSubsystems.add((Subsystem) sourcePort.getComponent());
			newEnclosingSubsystems.addAll(enclosingSubsystems);
			enclosingSubsystems = newEnclosingSubsystems;
			SubsystemDescriptor subsystemDescriptor = subsystemDescriptors.get(enclosingSubsystems);
			if (subsystemDescriptor != null) {
				source = subsystemDescriptor.getOutputs().get(sourcePort.getOutput());
			} else {
				return null;
			}
		}
		return new SubsystemBinding<OutputConnector>(enclosingSubsystems, source);
	}
	
	private List<SubsystemBinding<InputConnector>> getActualTargets(List<Subsystem> enclosingSubsystems, InputConnector target) {
		if (target instanceof InputPort && ((InputPort) target).getInput() instanceof SubsystemInput) {
			InputPort targetPort = (InputPort) target;
			List<SubsystemBinding<InputConnector>> actualTargets = new ArrayList<SubsystemBinding<InputConnector>>();
			getActualTargets(enclosingSubsystems, (SubsystemInput) targetPort.getInput(), actualTargets);
			return actualTargets;
		}
		return Collections.singletonList(new SubsystemBinding<InputConnector>(enclosingSubsystems, target));
	}
	
	private void getActualTargets(List<Subsystem> enclosingSubsystems, SubsystemInput subsystemInput, List<SubsystemBinding<InputConnector>> actualTargets) {
		ArrayList<Subsystem> newEnclosingSubsystems = new ArrayList<Subsystem>(enclosingSubsystems.size() + 1);
		newEnclosingSubsystems.add((Subsystem) subsystemInput.getComponent());
		newEnclosingSubsystems.addAll(enclosingSubsystems);
		enclosingSubsystems = newEnclosingSubsystems;
		SubsystemDescriptor subsystemDescriptor = subsystemDescriptors.get(enclosingSubsystems);
		if (subsystemDescriptor != null) {
			List<InputConnector> targets = subsystemDescriptor.getInputs().get(subsystemInput);
			for (InputConnector target : targets) {
				if (target instanceof InputPort && ((InputPort) target).getInput() instanceof SubsystemInput) {
					InputPort targetPort = (InputPort) target;
					getActualTargets(enclosingSubsystems, (SubsystemInput) targetPort.getInput(), actualTargets);
				} else {
					actualTargets.add(new SubsystemBinding<InputConnector>(subsystemDescriptor.getEnclosingSubsystems(), target));
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
		private Map<SubsystemInput, List<InputConnector>> inputs = new HashMap<SubsystemInput, List<InputConnector>>();
		private Map<SubsystemOutput, OutputConnector> outputs = new HashMap<SubsystemOutput, OutputConnector>();
		
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
