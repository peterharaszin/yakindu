/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.execution.executiongraph;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.esmp.dsm.execution.executiongraph.ExecutionEdge#getSource <em>Source</em>}</li>
 *   <li>{@link org.esmp.dsm.execution.executiongraph.ExecutionEdge#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.esmp.dsm.execution.executiongraph.ExecutionGraphPackage#getExecutionEdge()
 * @model
 * @generated
 */
public interface ExecutionEdge extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.esmp.dsm.execution.executiongraph.ExecutionNode#getOutgoingEdges <em>Outgoing Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(ExecutionNode)
	 * @see org.esmp.dsm.execution.executiongraph.ExecutionGraphPackage#getExecutionEdge_Source()
	 * @see org.esmp.dsm.execution.executiongraph.ExecutionNode#getOutgoingEdges
	 * @model opposite="outgoingEdges" required="true" ordered="false"
	 * @generated
	 */
	ExecutionNode getSource();

	/**
	 * Sets the value of the '{@link org.esmp.dsm.execution.executiongraph.ExecutionEdge#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(ExecutionNode value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.esmp.dsm.execution.executiongraph.ExecutionNode#getIncomingEdges <em>Incoming Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(ExecutionNode)
	 * @see org.esmp.dsm.execution.executiongraph.ExecutionGraphPackage#getExecutionEdge_Target()
	 * @see org.esmp.dsm.execution.executiongraph.ExecutionNode#getIncomingEdges
	 * @model opposite="incomingEdges" required="true" ordered="false"
	 * @generated
	 */
	ExecutionNode getTarget();

	/**
	 * Sets the value of the '{@link org.esmp.dsm.execution.executiongraph.ExecutionEdge#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(ExecutionNode value);

} // ExecutionEdge
