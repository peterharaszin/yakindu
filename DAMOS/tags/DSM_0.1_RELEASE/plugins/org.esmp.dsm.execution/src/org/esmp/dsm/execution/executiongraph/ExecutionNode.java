/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.execution.executiongraph;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.esmp.dsm.semantic.blockdiagram.Block;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.esmp.dsm.execution.executiongraph.ExecutionNode#getIncomingEdges <em>Incoming Edges</em>}</li>
 *   <li>{@link org.esmp.dsm.execution.executiongraph.ExecutionNode#getOutgoingEdges <em>Outgoing Edges</em>}</li>
 *   <li>{@link org.esmp.dsm.execution.executiongraph.ExecutionNode#getBlock <em>Block</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.esmp.dsm.execution.executiongraph.ExecutionGraphPackage#getExecutionNode()
 * @model
 * @generated
 */
public interface ExecutionNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Incoming Edges</b></em>' reference list.
	 * The list contents are of type {@link org.esmp.dsm.execution.executiongraph.ExecutionEdge}.
	 * It is bidirectional and its opposite is '{@link org.esmp.dsm.execution.executiongraph.ExecutionEdge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Edges</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Edges</em>' reference list.
	 * @see org.esmp.dsm.execution.executiongraph.ExecutionGraphPackage#getExecutionNode_IncomingEdges()
	 * @see org.esmp.dsm.execution.executiongraph.ExecutionEdge#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<ExecutionEdge> getIncomingEdges();

	/**
	 * Returns the value of the '<em><b>Outgoing Edges</b></em>' reference list.
	 * The list contents are of type {@link org.esmp.dsm.execution.executiongraph.ExecutionEdge}.
	 * It is bidirectional and its opposite is '{@link org.esmp.dsm.execution.executiongraph.ExecutionEdge#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Edges</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Edges</em>' reference list.
	 * @see org.esmp.dsm.execution.executiongraph.ExecutionGraphPackage#getExecutionNode_OutgoingEdges()
	 * @see org.esmp.dsm.execution.executiongraph.ExecutionEdge#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<ExecutionEdge> getOutgoingEdges();

	/**
	 * Returns the value of the '<em><b>Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Block</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Block</em>' reference.
	 * @see #setBlock(Block)
	 * @see org.esmp.dsm.execution.executiongraph.ExecutionGraphPackage#getExecutionNode_Block()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Block getBlock();

	/**
	 * Sets the value of the '{@link org.esmp.dsm.execution.executiongraph.ExecutionNode#getBlock <em>Block</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Block</em>' reference.
	 * @see #getBlock()
	 * @generated
	 */
	void setBlock(Block value);

} // ExecutionNode
