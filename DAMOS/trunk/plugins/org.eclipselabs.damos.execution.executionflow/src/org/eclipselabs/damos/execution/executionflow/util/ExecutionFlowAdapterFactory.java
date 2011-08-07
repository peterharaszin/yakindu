/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executionflow.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage
 * @generated
 */
public class ExecutionFlowAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ExecutionFlowPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionFlowAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ExecutionFlowPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionFlowSwitch<Adapter> modelSwitch =
		new ExecutionFlowSwitch<Adapter>() {
			@Override
			public Adapter caseExecutionFlow(ExecutionFlow object) {
				return createExecutionFlowAdapter();
			}
			@Override
			public Adapter caseGraph(Graph object) {
				return createGraphAdapter();
			}
			@Override
			public Adapter caseNode(Node object) {
				return createNodeAdapter();
			}
			@Override
			public Adapter caseSubgraph(Subgraph object) {
				return createSubgraphAdapter();
			}
			@Override
			public Adapter caseComponentNode(ComponentNode object) {
				return createComponentNodeAdapter();
			}
			@Override
			public Adapter caseLatchNode(LatchNode object) {
				return createLatchNodeAdapter();
			}
			@Override
			public Adapter caseCompoundNode(CompoundNode object) {
				return createCompoundNodeAdapter();
			}
			@Override
			public Adapter caseActionNode(ActionNode object) {
				return createActionNodeAdapter();
			}
			@Override
			public Adapter caseSubsystemNode(SubsystemNode object) {
				return createSubsystemNodeAdapter();
			}
			@Override
			public Adapter caseTaskNode(TaskNode object) {
				return createTaskNodeAdapter();
			}
			@Override
			public Adapter caseTaskInputNode(TaskInputNode object) {
				return createTaskInputNodeAdapter();
			}
			@Override
			public Adapter caseEdge(Edge object) {
				return createEdgeAdapter();
			}
			@Override
			public Adapter caseDataFlow(DataFlow object) {
				return createDataFlowAdapter();
			}
			@Override
			public Adapter caseDataFlowEnd(DataFlowEnd object) {
				return createDataFlowEndAdapter();
			}
			@Override
			public Adapter caseDataFlowSourceEnd(DataFlowSourceEnd object) {
				return createDataFlowSourceEndAdapter();
			}
			@Override
			public Adapter caseDataFlowTargetEnd(DataFlowTargetEnd object) {
				return createDataFlowTargetEndAdapter();
			}
			@Override
			public Adapter caseConnectorInfo(ConnectorInfo object) {
				return createConnectorInfoAdapter();
			}
			@Override
			public Adapter casePortInfo(PortInfo object) {
				return createPortInfoAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.execution.executionflow.ExecutionFlow <em>Execution Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlow
	 * @generated
	 */
	public Adapter createExecutionFlowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.execution.executionflow.Graph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.execution.executionflow.Graph
	 * @generated
	 */
	public Adapter createGraphAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.execution.executionflow.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.execution.executionflow.Node
	 * @generated
	 */
	public Adapter createNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.execution.executionflow.Subgraph <em>Subgraph</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.execution.executionflow.Subgraph
	 * @generated
	 */
	public Adapter createSubgraphAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.execution.executionflow.ComponentNode <em>Component Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.execution.executionflow.ComponentNode
	 * @generated
	 */
	public Adapter createComponentNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.execution.executionflow.LatchNode <em>Latch Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.execution.executionflow.LatchNode
	 * @generated
	 */
	public Adapter createLatchNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.execution.executionflow.CompoundNode <em>Compound Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.execution.executionflow.CompoundNode
	 * @generated
	 */
	public Adapter createCompoundNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.execution.executionflow.ActionNode <em>Action Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.execution.executionflow.ActionNode
	 * @generated
	 */
	public Adapter createActionNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.execution.executionflow.SubsystemNode <em>Subsystem Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.execution.executionflow.SubsystemNode
	 * @generated
	 */
	public Adapter createSubsystemNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.execution.executionflow.TaskNode <em>Task Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.execution.executionflow.TaskNode
	 * @generated
	 */
	public Adapter createTaskNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.execution.executionflow.TaskInputNode <em>Task Input Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.execution.executionflow.TaskInputNode
	 * @generated
	 */
	public Adapter createTaskInputNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.execution.executionflow.Edge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.execution.executionflow.Edge
	 * @generated
	 */
	public Adapter createEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.execution.executionflow.DataFlow <em>Data Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.execution.executionflow.DataFlow
	 * @generated
	 */
	public Adapter createDataFlowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.execution.executionflow.DataFlowEnd <em>Data Flow End</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.execution.executionflow.DataFlowEnd
	 * @generated
	 */
	public Adapter createDataFlowEndAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.execution.executionflow.DataFlowSourceEnd <em>Data Flow Source End</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.execution.executionflow.DataFlowSourceEnd
	 * @generated
	 */
	public Adapter createDataFlowSourceEndAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.execution.executionflow.DataFlowTargetEnd <em>Data Flow Target End</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.execution.executionflow.DataFlowTargetEnd
	 * @generated
	 */
	public Adapter createDataFlowTargetEndAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.execution.executionflow.ConnectorInfo <em>Connector Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.execution.executionflow.ConnectorInfo
	 * @generated
	 */
	public Adapter createConnectorInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.execution.executionflow.PortInfo <em>Port Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.execution.executionflow.PortInfo
	 * @generated
	 */
	public Adapter createPortInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ExecutionFlowAdapterFactory
