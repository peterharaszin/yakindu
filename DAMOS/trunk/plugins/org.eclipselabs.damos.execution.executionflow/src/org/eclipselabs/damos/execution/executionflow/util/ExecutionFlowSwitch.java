/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executionflow.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipselabs.damos.execution.executionflow.*;
import org.eclipselabs.damos.execution.executionflow.ActionNode;
import org.eclipselabs.damos.execution.executionflow.ComponentNode;
import org.eclipselabs.damos.execution.executionflow.CompoundNode;
import org.eclipselabs.damos.execution.executionflow.ConnectorInfo;
import org.eclipselabs.damos.execution.executionflow.DataFlow;
import org.eclipselabs.damos.execution.executionflow.DataFlowEnd;
import org.eclipselabs.damos.execution.executionflow.DataFlowSourceEnd;
import org.eclipselabs.damos.execution.executionflow.DataFlowTargetEnd;
import org.eclipselabs.damos.execution.executionflow.Edge;
import org.eclipselabs.damos.execution.executionflow.ExecutionFlow;
import org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage;
import org.eclipselabs.damos.execution.executionflow.Graph;
import org.eclipselabs.damos.execution.executionflow.Node;
import org.eclipselabs.damos.execution.executionflow.PortInfo;
import org.eclipselabs.damos.execution.executionflow.Subgraph;
import org.eclipselabs.damos.execution.executionflow.SubsystemNode;
import org.eclipselabs.damos.execution.executionflow.TaskNode;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage
 * @generated
 */
public class ExecutionFlowSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ExecutionFlowPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionFlowSwitch() {
		if (modelPackage == null) {
			modelPackage = ExecutionFlowPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ExecutionFlowPackage.EXECUTION_FLOW: {
				ExecutionFlow executionFlow = (ExecutionFlow)theEObject;
				T result = caseExecutionFlow(executionFlow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionFlowPackage.GRAPH: {
				Graph graph = (Graph)theEObject;
				T result = caseGraph(graph);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionFlowPackage.NODE: {
				Node node = (Node)theEObject;
				T result = caseNode(node);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionFlowPackage.SUBGRAPH: {
				Subgraph subgraph = (Subgraph)theEObject;
				T result = caseSubgraph(subgraph);
				if (result == null) result = caseGraph(subgraph);
				if (result == null) result = caseNode(subgraph);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionFlowPackage.COMPONENT_NODE: {
				ComponentNode componentNode = (ComponentNode)theEObject;
				T result = caseComponentNode(componentNode);
				if (result == null) result = caseNode(componentNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionFlowPackage.LATCH_NODE: {
				LatchNode latchNode = (LatchNode)theEObject;
				T result = caseLatchNode(latchNode);
				if (result == null) result = caseComponentNode(latchNode);
				if (result == null) result = caseNode(latchNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionFlowPackage.COMPOUND_NODE: {
				CompoundNode compoundNode = (CompoundNode)theEObject;
				T result = caseCompoundNode(compoundNode);
				if (result == null) result = caseSubgraph(compoundNode);
				if (result == null) result = caseGraph(compoundNode);
				if (result == null) result = caseNode(compoundNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionFlowPackage.ACTION_NODE: {
				ActionNode actionNode = (ActionNode)theEObject;
				T result = caseActionNode(actionNode);
				if (result == null) result = caseCompoundNode(actionNode);
				if (result == null) result = caseSubgraph(actionNode);
				if (result == null) result = caseGraph(actionNode);
				if (result == null) result = caseNode(actionNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionFlowPackage.SUBSYSTEM_NODE: {
				SubsystemNode subsystemNode = (SubsystemNode)theEObject;
				T result = caseSubsystemNode(subsystemNode);
				if (result == null) result = caseSubgraph(subsystemNode);
				if (result == null) result = caseGraph(subsystemNode);
				if (result == null) result = caseNode(subsystemNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionFlowPackage.TASK_NODE: {
				TaskNode taskNode = (TaskNode)theEObject;
				T result = caseTaskNode(taskNode);
				if (result == null) result = caseSubgraph(taskNode);
				if (result == null) result = caseGraph(taskNode);
				if (result == null) result = caseNode(taskNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionFlowPackage.TASK_INPUT_NODE: {
				TaskInputNode taskInputNode = (TaskInputNode)theEObject;
				T result = caseTaskInputNode(taskInputNode);
				if (result == null) result = caseNode(taskInputNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionFlowPackage.EDGE: {
				Edge edge = (Edge)theEObject;
				T result = caseEdge(edge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionFlowPackage.DATA_FLOW: {
				DataFlow dataFlow = (DataFlow)theEObject;
				T result = caseDataFlow(dataFlow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionFlowPackage.DATA_FLOW_END: {
				DataFlowEnd dataFlowEnd = (DataFlowEnd)theEObject;
				T result = caseDataFlowEnd(dataFlowEnd);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionFlowPackage.DATA_FLOW_SOURCE_END: {
				DataFlowSourceEnd dataFlowSourceEnd = (DataFlowSourceEnd)theEObject;
				T result = caseDataFlowSourceEnd(dataFlowSourceEnd);
				if (result == null) result = caseDataFlowEnd(dataFlowSourceEnd);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionFlowPackage.DATA_FLOW_TARGET_END: {
				DataFlowTargetEnd dataFlowTargetEnd = (DataFlowTargetEnd)theEObject;
				T result = caseDataFlowTargetEnd(dataFlowTargetEnd);
				if (result == null) result = caseDataFlowEnd(dataFlowTargetEnd);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionFlowPackage.CONNECTOR_INFO: {
				ConnectorInfo connectorInfo = (ConnectorInfo)theEObject;
				T result = caseConnectorInfo(connectorInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExecutionFlowPackage.PORT_INFO: {
				PortInfo portInfo = (PortInfo)theEObject;
				T result = casePortInfo(portInfo);
				if (result == null) result = caseConnectorInfo(portInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Execution Flow</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execution Flow</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecutionFlow(ExecutionFlow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Graph</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Graph</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGraph(Graph object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNode(Node object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subgraph</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subgraph</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubgraph(Subgraph object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentNode(ComponentNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Latch Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Latch Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLatchNode(LatchNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compound Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compound Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompoundNode(CompoundNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActionNode(ActionNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subsystem Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subsystem Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubsystemNode(SubsystemNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTaskNode(TaskNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task Input Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task Input Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTaskInputNode(TaskInputNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEdge(Edge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Flow</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Flow</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataFlow(DataFlow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Flow End</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Flow End</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataFlowEnd(DataFlowEnd object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Flow Source End</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Flow Source End</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataFlowSourceEnd(DataFlowSourceEnd object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Flow Target End</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Flow Target End</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataFlowTargetEnd(DataFlowTargetEnd object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connector Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectorInfo(ConnectorInfo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePortInfo(PortInfo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ExecutionFlowSwitch
