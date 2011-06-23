/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.eclipselabs.damos.simulation.simulator.solver;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipselabs.damos.dml.Action;
import org.eclipselabs.damos.dml.ActionLink;
import org.eclipselabs.damos.dml.Choice;
import org.eclipselabs.damos.dml.Join;
import org.eclipselabs.damos.dml.WhileLoop;
import org.eclipselabs.damos.execution.engine.util.ExpressionUtil;
import org.eclipselabs.damos.execution.executionflow.ActionNode;
import org.eclipselabs.damos.execution.executionflow.ComponentNode;
import org.eclipselabs.damos.execution.executionflow.CompoundNode;
import org.eclipselabs.damos.execution.executionflow.DataFlowSourceEnd;
import org.eclipselabs.damos.execution.executionflow.DataFlowTargetEnd;
import org.eclipselabs.damos.execution.executionflow.Graph;
import org.eclipselabs.damos.execution.executionflow.Node;
import org.eclipselabs.damos.execution.executionflow.PortInfo;
import org.eclipselabs.damos.execution.executionflow.Subgraph;
import org.eclipselabs.damos.simulation.core.ISimulationMonitor;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModel;
import org.eclipselabs.damos.simulation.simulator.IComponentSimulationObject;
import org.eclipselabs.damos.simulation.simulator.internal.ISimulationContext;
import org.eclipselabs.damos.simulation.simulator.internal.SimulationEnginePlugin;
import org.eclipselabs.damos.simulation.simulator.util.SimulationUtil;
import org.eclipselabs.mscript.computation.engine.value.IBooleanValue;
import org.eclipselabs.mscript.computation.engine.value.IValue;

/**
 * Base class managing common boilerplate for all solvers.
 */
public abstract class AbstractSolver implements ISolver {
	
	protected ISimulationContext context;

	/**
	 * @param graph
	 * @param monitor
	 * @throws CoreException
	 */
	protected void computeDiscreteStates(Graph graph, double t, ISimulationMonitor monitor) throws CoreException {
		computeOutputValues(graph, t, monitor);
		
		if (monitor.isCanceled()) {
			return;
		}

		update(graph, t, monitor);
	}

	protected abstract void configure(SimulationModel simulationModel);
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.solver.ISolver#initialize(org.eclipselabs.damos.simulation.simulator.internal.ISimulationContext, org.eclipselabs.damos.simulation.core.ISimulationMonitor)
	 */
	public void initialize(ISimulationContext context, IProgressMonitor monitor) throws CoreException {
		this.context = context;
		configure(context.getSimulationModel());
		initializeIntegrationData(context.getExecutionFlow().getGraph(), monitor);
	}

	private void initializeIntegrationData(Graph graph, IProgressMonitor monitor) throws CoreException {
		for (Node node : graph.getNodes()) {
			if (monitor.isCanceled()) {
				break;
			}
			
			if (node instanceof Graph) {
				initializeIntegrationData((Graph) node, monitor);
			} else if (node instanceof ComponentNode) {
				IComponentSimulationObject simulationObject = SimulationUtil.getComponentSimulationObject(node);
				if (simulationObject != null) {
					double[] stateVector = simulationObject.getStateVector();
					if (stateVector != null && stateVector.length > 0) {
						node.eAdapters().add(createIntegrationData(simulationObject));
					}
				}
			}
		}
	}
	
	protected abstract IIntegrationData createIntegrationData(IComponentSimulationObject simulationObject);

	/**
	 * @param graph
	 * @param compoundSimulationEngine
	 * @param monitor
	 * @throws CoreException
	 */
	private void computeOutputValues(Graph graph, double t, ISimulationMonitor monitor) throws CoreException {
		for (Node node : graph.getNodes()) {
			if (monitor.isCanceled()) {
				break;
			}
			
			if (node instanceof CompoundNode) {
				CompoundNode compoundNode = (CompoundNode) node;
				if (isCompoundRunnable(compoundNode)) {
					if (compoundNode.getCompound() instanceof WhileLoop) {
						runWhileLoop(compoundNode, t, monitor);
					} else if (compoundNode.getCompound() instanceof Action) {
						computeDiscreteStates(compoundNode, t, monitor);
					} else {
						throw new IllegalArgumentException();
					}
				}
			} else if (node instanceof ComponentNode) {
				ComponentNode componentNode = (ComponentNode) node;
				if (canExecute(componentNode, t)) {
					if (componentNode.getComponent() instanceof Join) {
						computeJoinOutputValues(componentNode);
					} else if (!(componentNode.getComponent() instanceof Choice)) {
						computeComponentOutputValues(componentNode, t, monitor);
					}
				}
			} else {
				throw new IllegalArgumentException();
			}
		}
	}

	/**
	 * @param node
	 * @param monitor
	 * @throws CoreException
	 */
	private void runWhileLoop(CompoundNode compoundNode, double t, ISimulationMonitor monitor) throws CoreException {
		boolean condition;
		do {
			if (monitor.isCanceled()) {
				break;
			}
			
			computeDiscreteStates(compoundNode, t, monitor);
			
			condition = false;

			EList<DataFlowTargetEnd> incomingDataFlows = compoundNode.getIncomingDataFlows();
			if (!incomingDataFlows.isEmpty()) {
				DataFlowTargetEnd targetEnd = incomingDataFlows.get(0);
				DataFlowSourceEnd sourceEnd = targetEnd.getDataFlow().getSourceEnd();
				IComponentSimulationObject componentSimulationObject = SimulationUtil.getComponentSimulationObject(sourceEnd.getNode());
				if (componentSimulationObject != null && sourceEnd.getConnectorInfo() instanceof PortInfo) {
					PortInfo portInfo = (PortInfo) sourceEnd.getConnectorInfo();
					IValue value = componentSimulationObject.getOutputValue(portInfo.getInoutputIndex(), portInfo.getPortIndex());
					if (value instanceof IBooleanValue) {
						IBooleanValue booleanValue = (IBooleanValue) value;
						condition = booleanValue.booleanValue();
					}
				}
			}
		} while (condition);
	}

	/**
	 * @param componentNode
	 * @throws CoreException
	 */
	private void computeComponentOutputValues(ComponentNode componentNode, double t, ISimulationMonitor monitor) throws CoreException {
		IComponentSimulationObject simulationObject = SimulationUtil.getComponentSimulationObject(componentNode);
		simulationObject.computeOutputValues(t, monitor);
		propagateComponentOutputValues(componentNode, simulationObject);
	}

	/**
	 * @param node
	 * @param simulationObject
	 * @throws CoreException
	 */
	protected void propagateComponentOutputValues(ComponentNode node, IComponentSimulationObject simulationObject)
			throws CoreException {
		for (DataFlowSourceEnd sourceEnd : node.getOutgoingDataFlows()) {
			PortInfo sourcePortInfo = (PortInfo) sourceEnd.getConnectorInfo();
			IValue value = simulationObject.getOutputValue(sourcePortInfo.getInoutputIndex(), sourcePortInfo.getPortIndex());
			setInputValues(sourceEnd, value);
		}
	}

	/**
	 * @param sourceEnd
	 * @param value
	 * @throws CoreException
	 */
	private void setInputValues(DataFlowSourceEnd sourceEnd, IValue value) throws CoreException {
		for (DataFlowTargetEnd targetEnd : sourceEnd.getDataFlow().getTargetEnds()) {
			IComponentSimulationObject targetSimulationObject = SimulationUtil.getComponentSimulationObject(targetEnd.getNode());
			if (targetSimulationObject != null) {
				PortInfo targetPortInfo = (PortInfo) targetEnd.getConnectorInfo();
				targetSimulationObject.setInputValue(targetPortInfo.getInoutputIndex(), targetPortInfo.getPortIndex(), value);
			}
		}
	}

	/**
	 * @param joinNode
	 * @throws CoreException
	 */
	private void computeJoinOutputValues(ComponentNode joinNode) throws CoreException {
		DataFlowSourceEnd sourceEnd = getCompoundSourceEnd(joinNode);
		if (sourceEnd == null) {
			sourceEnd = getDefaultSourceEnd(joinNode);
		}
		if (sourceEnd == null) {
			throw new CoreException(new Status(IStatus.ERROR, SimulationEnginePlugin.PLUGIN_ID, "No Join input available"));
		}

		if (joinNode.getOutgoingDataFlows().isEmpty()) {
			throw new CoreException(new Status(IStatus.ERROR, SimulationEnginePlugin.PLUGIN_ID, "Join output not connected"));
		}
		DataFlowSourceEnd joinSourceEnd = joinNode.getOutgoingDataFlows().get(0);
		
		IComponentSimulationObject simulationObject = SimulationUtil.getComponentSimulationObject(sourceEnd.getNode());
		PortInfo sourcePortInfo = (PortInfo) sourceEnd.getConnectorInfo();
		IValue value = simulationObject.getOutputValue(sourcePortInfo.getInoutputIndex(), sourcePortInfo.getPortIndex());
		
		setInputValues(joinSourceEnd, value);
	}
	
	private DataFlowSourceEnd getCompoundSourceEnd(ComponentNode joinNode) throws CoreException {
		for (DataFlowTargetEnd targetEnd : joinNode.getIncomingDataFlows()) {
			DataFlowSourceEnd sourceEnd = targetEnd.getDataFlow().getSourceEnd();
			if (sourceEnd.getNode().getGraph() == joinNode.getGraph()) {
				continue;
			}
			if (sourceEnd.getNode() instanceof ComponentNode) {
				if (isComponentRunnable((ComponentNode) sourceEnd.getNode())) {
					return sourceEnd;
				}
			} else {
				throw new IllegalArgumentException();
			}
		}
		return null;
	}

	private DataFlowSourceEnd getDefaultSourceEnd(ComponentNode joinNode) throws CoreException {
		for (DataFlowTargetEnd targetEnd : joinNode.getIncomingDataFlows()) {
			DataFlowSourceEnd sourceEnd = targetEnd.getDataFlow().getSourceEnd();
			if (sourceEnd.getNode().getGraph() != joinNode.getGraph()) {
				continue;
			}
			if (sourceEnd.getNode() instanceof ComponentNode) {
				return sourceEnd;
			} else {
				throw new IllegalArgumentException();
			}
		}
		return null;
	}

	/**
	 * @param graph
	 * @param monitor
	 * @throws CoreException
	 */
	private void update(Graph graph, double t, ISimulationMonitor monitor) throws CoreException {
		for (Node node : graph.getNodes()) {
			if (monitor.isCanceled()) {
				break;
			}
			
			if (node instanceof ComponentNode) {
				ComponentNode componentNode = (ComponentNode) node;
				if (canExecute(componentNode, t)) {
					IComponentSimulationObject simulationObject = SimulationUtil.getComponentSimulationObject(node);
					if (simulationObject != null) {
						simulationObject.update(t);
					}
				}
			}
		}
	}
	
	protected boolean canExecute(ComponentNode componentNode, double t) {
		return true;
	}

	private boolean isCompoundRunnable(CompoundNode compoundNode) throws CoreException {
		if (compoundNode instanceof ActionNode) {
			ActionNode actionNode = (ActionNode) compoundNode;
			if (actionNode.getChoiceNode() == null) {
				return true;
			}
			
			Action action = (Action) compoundNode.getCompound();
			ComponentNode choiceNode = actionNode.getChoiceNode();

			return action == getRunnableAction(choiceNode);
		}
		return false;
	}
	
	private Action getRunnableAction(ComponentNode choiceNode) throws CoreException {
		Choice choice = (Choice) choiceNode.getComponent();
		Action defaultAction = null;

		DataFlowTargetEnd targetEnd = choiceNode.getIncomingDataFlows().get(0);
		DataFlowSourceEnd sourceEnd = targetEnd.getDataFlow().getSourceEnd();
		PortInfo sourcePortInfo = (PortInfo) sourceEnd.getConnectorInfo();

		IComponentSimulationObject simulationObject = SimulationUtil.getComponentSimulationObject(sourceEnd.getNode());
		IValue value = simulationObject.getOutputValue(sourcePortInfo.getInoutputIndex(), sourcePortInfo.getPortIndex());

		for (ActionLink actionLink : choice.getActionLinks()) {
			Action action = actionLink.getAction();
			if (actionLink.getCondition() != null) {
				IValue conditionValue = ExpressionUtil.evaluateExpression(actionLink.getCondition().stringCondition());
				IValue result = value.equalTo(conditionValue);
				if (result instanceof IBooleanValue) {
					IBooleanValue booleanResult = (IBooleanValue) result;
					if (booleanResult.booleanValue()) {
						return action;
					}
				}
			} else {
				defaultAction = action;
			}
		}
		
		return defaultAction;
	}
	
	private boolean isComponentRunnable(ComponentNode componentNode) throws CoreException {
		Graph graph = componentNode.getGraph();
		while (graph instanceof Subgraph) {
			Subgraph subgraph = (Subgraph) graph;
			if (graph instanceof CompoundNode && !isCompoundRunnable((CompoundNode) graph)) {
				return false;
			}
			graph = subgraph.getGraph();
		}
		return true;
	}

}
