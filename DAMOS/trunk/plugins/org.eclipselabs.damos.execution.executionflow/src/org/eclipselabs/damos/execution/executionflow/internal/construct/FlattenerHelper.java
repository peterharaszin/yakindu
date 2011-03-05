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
	
	private Map<Component, Node> nodes = new LinkedHashMap<Component, Node>();
	private Map<Subsystem, SubsystemMapping> subsystemMappings = new HashMap<Subsystem, SubsystemMapping>();

	/**
	 * 
	 */
	public FlattenerHelper(ExecutionFlow flow) {
		this.flow = flow;
	}
	
	public void flatten() {
		flatten(flow.getTopLevelFragment(), new LinkedList<Subsystem>());
	}
	
	public Collection<Node> getNodes() {
		return nodes.values();
	}

	private void flatten(Fragment fragment, LinkedList<Subsystem> enclosingSubsystems) {
		for (Component component : fragment.getAllComponents()) {
			if (component instanceof Subsystem) {
				flattenSubsystem((Subsystem) component, fragment, enclosingSubsystems);
			} else if (!(component instanceof Inoutport) || enclosingSubsystems.isEmpty()) {
				ComponentNode node = ExecutionFlowFactory.eINSTANCE.createComponentNode();
				node.setComponent(component);
				node.getEnclosingSubsystems().addAll(enclosingSubsystems);
				nodes.put(component, node);
			}
		}
		
		Map<OutputPort, DataFlow> dataFlows = new HashMap<OutputPort, DataFlow>();
		for (Connection connection : fragment.getAllConnections()) {
			if ((connection.getSourcePort().getComponent() instanceof Inoutport || connection.getTargetPort().getComponent() instanceof Inoutport) && !enclosingSubsystems.isEmpty()) {
				continue;
			}
			
			OutputPort sourcePort = getActualSourcePort(connection.getSourcePort());
			List<InputPort> targetPorts = getActualTargetPorts(connection.getTargetPort());
			
			DataFlow dataFlow = dataFlows.get(sourcePort);
			if (dataFlow == null) {
				dataFlow = ExecutionFlowFactory.eINSTANCE.createDataFlow();
				DataFlowSourceEnd sourceEnd = ExecutionFlowFactory.eINSTANCE.createDataFlowSourceEnd();
				sourceEnd.setDataFlow(dataFlow);
				sourceEnd.setNode(nodes.get(sourcePort.getComponent()));
				sourceEnd.setConnector(sourcePort);

				PortInfo portInfo = ExecutionFlowFactory.eINSTANCE.createPortInfo();
				portInfo.setInoutputIndex(DMLUtil.indexOf(sourcePort.getOutput()));
				portInfo.setPortIndex(sourcePort.getIndex());
				sourceEnd.setConnectorInfo(portInfo);
				
				flow.getDataFlows().add(dataFlow);
				dataFlows.put(sourcePort, dataFlow);
			}
			for (InputPort targetPort : targetPorts) {
				DataFlowTargetEnd targetEnd = ExecutionFlowFactory.eINSTANCE.createDataFlowTargetEnd();
				targetEnd.setDataFlow(dataFlow);
				targetEnd.setNode(nodes.get(targetPort.getComponent()));
				targetEnd.setConnector(targetPort);

				PortInfo portInfo = ExecutionFlowFactory.eINSTANCE.createPortInfo();
				portInfo.setInoutputIndex(DMLUtil.indexOf(targetPort.getInput()));
				portInfo.setPortIndex(targetPort.getIndex());
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
				SubsystemMapping subsystemMapping = new SubsystemMapping();

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
							subsystemMapping.getInputs().put(subsystemInput, inputPorts);
						}
					}
				}
				
				Map<String, Outport> outports = DMLUtil.getComponentMap(realizingFragment, Outport.class);
				for (Output output : subsystem.getOutputs()) {
					if (output instanceof SubsystemOutput) {
						SubsystemOutput subsystemOutput = (SubsystemOutput) output;
						Outport outport = outports.get(subsystemOutput.getOutlet().getName());
						if (outport != null) {
							subsystemMapping.getOutputs().put(subsystemOutput, outport.getFirstInputPort().getFirstConnection(realizingFragment).getSourcePort());
						}
					}
				}

				subsystemMappings.put(subsystem, subsystemMapping);
				
				enclosingSubsystems.addFirst(subsystem);
				flatten(realizingFragment, enclosingSubsystems);
				enclosingSubsystems.removeFirst();
			}
		}
	}
	
	private OutputPort getActualSourcePort(OutputPort sourcePort) {
		while (sourcePort.getOutput() instanceof SubsystemOutput) {
			SubsystemMapping subsystemMapping = subsystemMappings.get(sourcePort.getComponent());
			if (subsystemMapping != null) {
				sourcePort = subsystemMapping.getOutputs().get(sourcePort.getOutput());
			} else {
				return null;
			}
		}
		return sourcePort;
	}
	
	private List<InputPort> getActualTargetPorts(InputPort targetPort) {
		if (targetPort.getInput() instanceof SubsystemInput) {
			List<InputPort> actualTargetPorts = new ArrayList<InputPort>();
			getActualTargetPorts((SubsystemInput) targetPort.getInput(), actualTargetPorts);
			return actualTargetPorts;
		}
		return Collections.singletonList(targetPort);
	}
	
	private void getActualTargetPorts(SubsystemInput subsystemInput, List<InputPort> actualTargetPorts) {
		SubsystemMapping subsystemMapping = subsystemMappings.get(subsystemInput.getComponent());
		if (subsystemMapping != null) {
			List<InputPort> targetPorts = subsystemMapping.getInputs().get(subsystemInput);
			for (InputPort targetPort : targetPorts) {
				if (targetPort.getInput() instanceof SubsystemInput) {
					getActualTargetPorts((SubsystemInput) targetPort.getInput(), actualTargetPorts);
				} else {
					actualTargetPorts.add(targetPort);
				}
			}
		}
	}

	private static class SubsystemMapping {
		
		private Map<SubsystemInput, List<InputPort>> inputs = new HashMap<SubsystemInput, List<InputPort>>();
		private Map<SubsystemOutput, OutputPort> outputs = new HashMap<SubsystemOutput, OutputPort>();
		
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
