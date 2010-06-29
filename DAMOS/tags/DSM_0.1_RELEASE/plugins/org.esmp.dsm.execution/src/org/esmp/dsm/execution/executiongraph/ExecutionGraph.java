/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.execution.executiongraph;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagram;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.esmp.dsm.execution.executiongraph.ExecutionGraph#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.esmp.dsm.execution.executiongraph.ExecutionGraph#getInitialNodes <em>Initial Nodes</em>}</li>
 *   <li>{@link org.esmp.dsm.execution.executiongraph.ExecutionGraph#getEdges <em>Edges</em>}</li>
 *   <li>{@link org.esmp.dsm.execution.executiongraph.ExecutionGraph#getBlockDiagram <em>Block Diagram</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.esmp.dsm.execution.executiongraph.ExecutionGraphPackage#getExecutionGraph()
 * @model
 * @generated
 */
public interface ExecutionGraph extends EObject {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.esmp.dsm.execution.executiongraph.ExecutionNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see org.esmp.dsm.execution.executiongraph.ExecutionGraphPackage#getExecutionGraph_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExecutionNode> getNodes();

	/**
	 * Returns the value of the '<em><b>Initial Nodes</b></em>' reference list.
	 * The list contents are of type {@link org.esmp.dsm.execution.executiongraph.ExecutionNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Nodes</em>' reference list.
	 * @see org.esmp.dsm.execution.executiongraph.ExecutionGraphPackage#getExecutionGraph_InitialNodes()
	 * @model
	 * @generated
	 */
	EList<ExecutionNode> getInitialNodes();

	/**
	 * Returns the value of the '<em><b>Edges</b></em>' containment reference list.
	 * The list contents are of type {@link org.esmp.dsm.execution.executiongraph.ExecutionEdge}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edges</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges</em>' containment reference list.
	 * @see org.esmp.dsm.execution.executiongraph.ExecutionGraphPackage#getExecutionGraph_Edges()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExecutionEdge> getEdges();

	/**
	 * Returns the value of the '<em><b>Block Diagram</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Block Diagram</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Block Diagram</em>' reference.
	 * @see #setBlockDiagram(BlockDiagram)
	 * @see org.esmp.dsm.execution.executiongraph.ExecutionGraphPackage#getExecutionGraph_BlockDiagram()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	BlockDiagram getBlockDiagram();

	/**
	 * Sets the value of the '{@link org.esmp.dsm.execution.executiongraph.ExecutionGraph#getBlockDiagram <em>Block Diagram</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Block Diagram</em>' reference.
	 * @see #getBlockDiagram()
	 * @generated
	 */
	void setBlockDiagram(BlockDiagram value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" blockURIDataType="org.esmp.dsm.execution.executiongraph.URI" blockURIRequired="true" blockURIOrdered="false"
	 * @generated
	 */
	ExecutionNode getNode(URI blockURI);

} // ExecutionGraph
