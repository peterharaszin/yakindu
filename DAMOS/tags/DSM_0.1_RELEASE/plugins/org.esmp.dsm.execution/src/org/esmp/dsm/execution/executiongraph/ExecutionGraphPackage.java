/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.execution.executiongraph;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.esmp.dsm.execution.executiongraph.ExecutionGraphFactory
 * @model kind="package"
 * @generated
 */
public interface ExecutionGraphPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "executiongraph";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.esmp.org/dsm/ExecutionGraph/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "executiongraph";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExecutionGraphPackage eINSTANCE = org.esmp.dsm.execution.executiongraph.impl.ExecutionGraphPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.esmp.dsm.execution.executiongraph.impl.ExecutionGraphImpl <em>Execution Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.esmp.dsm.execution.executiongraph.impl.ExecutionGraphImpl
	 * @see org.esmp.dsm.execution.executiongraph.impl.ExecutionGraphPackageImpl#getExecutionGraph()
	 * @generated
	 */
	int EXECUTION_GRAPH = 0;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_GRAPH__NODES = 0;

	/**
	 * The feature id for the '<em><b>Initial Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_GRAPH__INITIAL_NODES = 1;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_GRAPH__EDGES = 2;

	/**
	 * The feature id for the '<em><b>Block Diagram</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_GRAPH__BLOCK_DIAGRAM = 3;

	/**
	 * The number of structural features of the '<em>Execution Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_GRAPH_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.esmp.dsm.execution.executiongraph.impl.ExecutionNodeImpl <em>Execution Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.esmp.dsm.execution.executiongraph.impl.ExecutionNodeImpl
	 * @see org.esmp.dsm.execution.executiongraph.impl.ExecutionGraphPackageImpl#getExecutionNode()
	 * @generated
	 */
	int EXECUTION_NODE = 1;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_NODE__INCOMING_EDGES = 0;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_NODE__OUTGOING_EDGES = 1;

	/**
	 * The feature id for the '<em><b>Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_NODE__BLOCK = 2;

	/**
	 * The number of structural features of the '<em>Execution Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_NODE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.esmp.dsm.execution.executiongraph.impl.ExecutionEdgeImpl <em>Execution Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.esmp.dsm.execution.executiongraph.impl.ExecutionEdgeImpl
	 * @see org.esmp.dsm.execution.executiongraph.impl.ExecutionGraphPackageImpl#getExecutionEdge()
	 * @generated
	 */
	int EXECUTION_EDGE = 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_EDGE__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_EDGE__TARGET = 1;

	/**
	 * The number of structural features of the '<em>Execution Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_EDGE_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '<em>URI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.URI
	 * @see org.esmp.dsm.execution.executiongraph.impl.ExecutionGraphPackageImpl#getURI()
	 * @generated
	 */
	int URI = 3;


	/**
	 * Returns the meta object for class '{@link org.esmp.dsm.execution.executiongraph.ExecutionGraph <em>Execution Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Graph</em>'.
	 * @see org.esmp.dsm.execution.executiongraph.ExecutionGraph
	 * @generated
	 */
	EClass getExecutionGraph();

	/**
	 * Returns the meta object for the containment reference list '{@link org.esmp.dsm.execution.executiongraph.ExecutionGraph#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see org.esmp.dsm.execution.executiongraph.ExecutionGraph#getNodes()
	 * @see #getExecutionGraph()
	 * @generated
	 */
	EReference getExecutionGraph_Nodes();

	/**
	 * Returns the meta object for the reference list '{@link org.esmp.dsm.execution.executiongraph.ExecutionGraph#getInitialNodes <em>Initial Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Initial Nodes</em>'.
	 * @see org.esmp.dsm.execution.executiongraph.ExecutionGraph#getInitialNodes()
	 * @see #getExecutionGraph()
	 * @generated
	 */
	EReference getExecutionGraph_InitialNodes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.esmp.dsm.execution.executiongraph.ExecutionGraph#getEdges <em>Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Edges</em>'.
	 * @see org.esmp.dsm.execution.executiongraph.ExecutionGraph#getEdges()
	 * @see #getExecutionGraph()
	 * @generated
	 */
	EReference getExecutionGraph_Edges();

	/**
	 * Returns the meta object for the reference '{@link org.esmp.dsm.execution.executiongraph.ExecutionGraph#getBlockDiagram <em>Block Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Block Diagram</em>'.
	 * @see org.esmp.dsm.execution.executiongraph.ExecutionGraph#getBlockDiagram()
	 * @see #getExecutionGraph()
	 * @generated
	 */
	EReference getExecutionGraph_BlockDiagram();

	/**
	 * Returns the meta object for class '{@link org.esmp.dsm.execution.executiongraph.ExecutionNode <em>Execution Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Node</em>'.
	 * @see org.esmp.dsm.execution.executiongraph.ExecutionNode
	 * @generated
	 */
	EClass getExecutionNode();

	/**
	 * Returns the meta object for the reference list '{@link org.esmp.dsm.execution.executiongraph.ExecutionNode#getIncomingEdges <em>Incoming Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Edges</em>'.
	 * @see org.esmp.dsm.execution.executiongraph.ExecutionNode#getIncomingEdges()
	 * @see #getExecutionNode()
	 * @generated
	 */
	EReference getExecutionNode_IncomingEdges();

	/**
	 * Returns the meta object for the reference list '{@link org.esmp.dsm.execution.executiongraph.ExecutionNode#getOutgoingEdges <em>Outgoing Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Edges</em>'.
	 * @see org.esmp.dsm.execution.executiongraph.ExecutionNode#getOutgoingEdges()
	 * @see #getExecutionNode()
	 * @generated
	 */
	EReference getExecutionNode_OutgoingEdges();

	/**
	 * Returns the meta object for the reference '{@link org.esmp.dsm.execution.executiongraph.ExecutionNode#getBlock <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Block</em>'.
	 * @see org.esmp.dsm.execution.executiongraph.ExecutionNode#getBlock()
	 * @see #getExecutionNode()
	 * @generated
	 */
	EReference getExecutionNode_Block();

	/**
	 * Returns the meta object for class '{@link org.esmp.dsm.execution.executiongraph.ExecutionEdge <em>Execution Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Edge</em>'.
	 * @see org.esmp.dsm.execution.executiongraph.ExecutionEdge
	 * @generated
	 */
	EClass getExecutionEdge();

	/**
	 * Returns the meta object for the reference '{@link org.esmp.dsm.execution.executiongraph.ExecutionEdge#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.esmp.dsm.execution.executiongraph.ExecutionEdge#getSource()
	 * @see #getExecutionEdge()
	 * @generated
	 */
	EReference getExecutionEdge_Source();

	/**
	 * Returns the meta object for the reference '{@link org.esmp.dsm.execution.executiongraph.ExecutionEdge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.esmp.dsm.execution.executiongraph.ExecutionEdge#getTarget()
	 * @see #getExecutionEdge()
	 * @generated
	 */
	EReference getExecutionEdge_Target();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.util.URI <em>URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>URI</em>'.
	 * @see org.eclipse.emf.common.util.URI
	 * @model instanceClass="org.eclipse.emf.common.util.URI"
	 * @generated
	 */
	EDataType getURI();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExecutionGraphFactory getExecutionGraphFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.esmp.dsm.execution.executiongraph.impl.ExecutionGraphImpl <em>Execution Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.esmp.dsm.execution.executiongraph.impl.ExecutionGraphImpl
		 * @see org.esmp.dsm.execution.executiongraph.impl.ExecutionGraphPackageImpl#getExecutionGraph()
		 * @generated
		 */
		EClass EXECUTION_GRAPH = eINSTANCE.getExecutionGraph();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_GRAPH__NODES = eINSTANCE.getExecutionGraph_Nodes();

		/**
		 * The meta object literal for the '<em><b>Initial Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_GRAPH__INITIAL_NODES = eINSTANCE.getExecutionGraph_InitialNodes();

		/**
		 * The meta object literal for the '<em><b>Edges</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_GRAPH__EDGES = eINSTANCE.getExecutionGraph_Edges();

		/**
		 * The meta object literal for the '<em><b>Block Diagram</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_GRAPH__BLOCK_DIAGRAM = eINSTANCE.getExecutionGraph_BlockDiagram();

		/**
		 * The meta object literal for the '{@link org.esmp.dsm.execution.executiongraph.impl.ExecutionNodeImpl <em>Execution Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.esmp.dsm.execution.executiongraph.impl.ExecutionNodeImpl
		 * @see org.esmp.dsm.execution.executiongraph.impl.ExecutionGraphPackageImpl#getExecutionNode()
		 * @generated
		 */
		EClass EXECUTION_NODE = eINSTANCE.getExecutionNode();

		/**
		 * The meta object literal for the '<em><b>Incoming Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_NODE__INCOMING_EDGES = eINSTANCE.getExecutionNode_IncomingEdges();

		/**
		 * The meta object literal for the '<em><b>Outgoing Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_NODE__OUTGOING_EDGES = eINSTANCE.getExecutionNode_OutgoingEdges();

		/**
		 * The meta object literal for the '<em><b>Block</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_NODE__BLOCK = eINSTANCE.getExecutionNode_Block();

		/**
		 * The meta object literal for the '{@link org.esmp.dsm.execution.executiongraph.impl.ExecutionEdgeImpl <em>Execution Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.esmp.dsm.execution.executiongraph.impl.ExecutionEdgeImpl
		 * @see org.esmp.dsm.execution.executiongraph.impl.ExecutionGraphPackageImpl#getExecutionEdge()
		 * @generated
		 */
		EClass EXECUTION_EDGE = eINSTANCE.getExecutionEdge();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_EDGE__SOURCE = eINSTANCE.getExecutionEdge_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_EDGE__TARGET = eINSTANCE.getExecutionEdge_Target();

		/**
		 * The meta object literal for the '<em>URI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.util.URI
		 * @see org.esmp.dsm.execution.executiongraph.impl.ExecutionGraphPackageImpl#getURI()
		 * @generated
		 */
		EDataType URI = eINSTANCE.getURI();

	}

} //ExecutionGraphPackage
