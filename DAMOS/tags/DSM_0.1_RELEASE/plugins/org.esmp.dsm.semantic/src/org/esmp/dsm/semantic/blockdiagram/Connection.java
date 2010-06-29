/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.semantic.blockdiagram;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.Connection#getSourcePort <em>Source Port</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.Connection#isVirtual <em>Virtual</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.Connection#getTargetPort <em>Target Port</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getConnection()
 * @model
 * @generated
 */
public interface Connection extends EObject {
	/**
	 * Returns the value of the '<em><b>Source Port</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.esmp.dsm.semantic.blockdiagram.OutputPort#getOutgoingConnections <em>Outgoing Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Port</em>' reference.
	 * @see #setSourcePort(OutputPort)
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getConnection_SourcePort()
	 * @see org.esmp.dsm.semantic.blockdiagram.OutputPort#getOutgoingConnections
	 * @model opposite="outgoingConnections" required="true" ordered="false"
	 * @generated
	 */
	OutputPort getSourcePort();

	/**
	 * Sets the value of the '{@link org.esmp.dsm.semantic.blockdiagram.Connection#getSourcePort <em>Source Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Port</em>' reference.
	 * @see #getSourcePort()
	 * @generated
	 */
	void setSourcePort(OutputPort value);

	/**
	 * Returns the value of the '<em><b>Virtual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Virtual</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Virtual</em>' attribute.
	 * @see #setVirtual(boolean)
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getConnection_Virtual()
	 * @model required="true" transient="true" ordered="false"
	 * @generated
	 */
	boolean isVirtual();

	/**
	 * Sets the value of the '{@link org.esmp.dsm.semantic.blockdiagram.Connection#isVirtual <em>Virtual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Virtual</em>' attribute.
	 * @see #isVirtual()
	 * @generated
	 */
	void setVirtual(boolean value);

	/**
	 * Returns the value of the '<em><b>Target Port</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.esmp.dsm.semantic.blockdiagram.InputPort#getIncomingConnection <em>Incoming Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Port</em>' reference.
	 * @see #setTargetPort(InputPort)
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getConnection_TargetPort()
	 * @see org.esmp.dsm.semantic.blockdiagram.InputPort#getIncomingConnection
	 * @model opposite="incomingConnection" required="true" ordered="false"
	 * @generated
	 */
	InputPort getTargetPort();

	/**
	 * Sets the value of the '{@link org.esmp.dsm.semantic.blockdiagram.Connection#getTargetPort <em>Target Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Port</em>' reference.
	 * @see #getTargetPort()
	 * @generated
	 */
	void setTargetPort(InputPort value);

} // Connection
