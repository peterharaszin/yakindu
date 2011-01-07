/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executiongraph;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.Link#getSourceNode <em>Source Node</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.Link#getTargetNode <em>Target Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.execution.executiongraph.ExecutionGraphPackage#getLink()
 * @model
 * @generated
 */
public interface Link extends EObject {
	/**
	 * Returns the value of the '<em><b>Source Node</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.execution.executiongraph.Node#getOutgoingLinks <em>Outgoing Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Node</em>' reference.
	 * @see #setSourceNode(Node)
	 * @see org.eclipselabs.damos.execution.executiongraph.ExecutionGraphPackage#getLink_SourceNode()
	 * @see org.eclipselabs.damos.execution.executiongraph.Node#getOutgoingLinks
	 * @model opposite="outgoingLinks" required="true" ordered="false"
	 * @generated
	 */
	Node getSourceNode();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.execution.executiongraph.Link#getSourceNode <em>Source Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Node</em>' reference.
	 * @see #getSourceNode()
	 * @generated
	 */
	void setSourceNode(Node value);

	/**
	 * Returns the value of the '<em><b>Target Node</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.execution.executiongraph.Node#getIncomingLinks <em>Incoming Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Node</em>' reference.
	 * @see #setTargetNode(Node)
	 * @see org.eclipselabs.damos.execution.executiongraph.ExecutionGraphPackage#getLink_TargetNode()
	 * @see org.eclipselabs.damos.execution.executiongraph.Node#getIncomingLinks
	 * @model opposite="incomingLinks" required="true" ordered="false"
	 * @generated
	 */
	Node getTargetNode();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.execution.executiongraph.Link#getTargetNode <em>Target Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Node</em>' reference.
	 * @see #getTargetNode()
	 * @generated
	 */
	void setTargetNode(Node value);

} // Link
