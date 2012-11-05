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

package org.eclipse.damos.simulation.simulator.internal;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.damos.dml.Action;
import org.eclipse.damos.dml.ActionLink;
import org.eclipse.damos.dml.Choice;
import org.eclipse.damos.dml.WhileLoop;
import org.eclipse.damos.dscript.DscriptValueSpecification;
import org.eclipse.damos.execution.ActionNode;
import org.eclipse.damos.execution.ComponentNode;
import org.eclipse.damos.execution.CompoundNode;
import org.eclipse.damos.execution.DataFlowSourceEnd;
import org.eclipse.damos.execution.DataFlowTargetEnd;
import org.eclipse.damos.execution.Graph;
import org.eclipse.damos.execution.Node;
import org.eclipse.damos.execution.PortInfo;
import org.eclipse.damos.execution.TaskGraph;
import org.eclipse.damos.execution.TaskInputNode;
import org.eclipse.damos.execution.util.ExpressionUtil;
import org.eclipse.damos.mscript.interpreter.value.IBooleanValue;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.simulation.ISimulationMonitor;
import org.eclipse.damos.simulation.simulator.ISimulationObject;
import org.eclipse.damos.simulation.simulator.util.SimulationUtil;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Andreas Unger
 *
 */
public class DiscreteStateComputationHelper {

	public void computeDiscreteStates(Graph graph, double t, ISimulationMonitor monitor) throws CoreException {
		computeOutputValues(graph, t, monitor);
		
		if (monitor.isCanceled()) {
			return;
		}

		update(graph, t, monitor);
	}

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
				if (!(componentNode.getComponent() instanceof Choice) && canExecute(componentNode, t)) {
					computeComponentOutputValues(componentNode, t, monitor);
				}
			} else {
				throw new IllegalArgumentException();
			}
		}
	}

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
				ISimulationObject simulationObject = SimulationUtil.getSimulationObject(sourceEnd.getNode());
				if (simulationObject != null && sourceEnd.getConnectorInfo() instanceof PortInfo) {
					PortInfo portInfo = (PortInfo) sourceEnd.getConnectorInfo();
					IValue value = simulationObject.getOutputValue(portInfo.getInoutputIndex(), portInfo.getPortIndex());
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
		ISimulationObject simulationObject = SimulationUtil.getSimulationObject(componentNode);
		simulationObject.computeOutputValues(t, monitor);
		propagateComponentOutputValues(componentNode, simulationObject);
	}

	/**
	 * @param node
	 * @param simulationObject
	 * @throws CoreException
	 */
	public void propagateComponentOutputValues(ComponentNode node, ISimulationObject simulationObject)
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
	public void setInputValues(DataFlowSourceEnd sourceEnd, IValue value) throws CoreException {
		for (DataFlowTargetEnd targetEnd : sourceEnd.getDataFlow().getTargetEnds()) {
			if (targetEnd.getNode() instanceof TaskInputNode) {
				TaskInputNode taskInputNode = (TaskInputNode) targetEnd.getNode();
				TaskGraph taskGraph = taskInputNode.getTaskGraph();
				Task task = (Task) EcoreUtil.getAdapter(taskGraph.eAdapters(), Task.class);
				if (task != null) {
					task.sendValue(taskInputNode, value);
				}
			} else {
				ISimulationObject targetSimulationObject = SimulationUtil.getSimulationObject(targetEnd.getNode());
				if (targetSimulationObject != null) {
					PortInfo targetPortInfo = (PortInfo) targetEnd.getConnectorInfo();
					targetSimulationObject.setInputValue(targetPortInfo.getInoutputIndex(), targetPortInfo.getPortIndex(), value);
				}
			}
		}
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
					ISimulationObject simulationObject = SimulationUtil.getSimulationObject(node);
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

		ISimulationObject simulationObject = SimulationUtil.getSimulationObject(sourceEnd.getNode());
		IValue value = simulationObject.getOutputValue(sourcePortInfo.getInoutputIndex(), sourcePortInfo.getPortIndex());

		for (ActionLink actionLink : choice.getActionLinks()) {
			Action action = actionLink.getAction();
			if (actionLink.getCondition() != null) {
				if (!(actionLink.getCondition() instanceof DscriptValueSpecification)) {
					throw new CoreException(new Status(IStatus.ERROR, SimulatorPlugin.PLUGIN_ID, "Invalid action link condition"));
				}
				IValue conditionValue = ExpressionUtil.evaluateExpression(((DscriptValueSpecification) actionLink.getCondition()).getExpression());
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

}
