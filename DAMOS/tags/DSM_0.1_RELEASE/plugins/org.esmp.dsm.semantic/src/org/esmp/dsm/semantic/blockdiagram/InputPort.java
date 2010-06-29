/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.semantic.blockdiagram;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.InputPort#getIncomingConnection <em>Incoming Connection</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.InputPort#isDirectFeedthrough <em>Direct Feedthrough</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.InputPort#getInput <em>Input</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getInputPort()
 * @model
 * @generated
 */
public interface InputPort extends Port {
	/**
	 * Returns the value of the '<em><b>Incoming Connection</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.esmp.dsm.semantic.blockdiagram.Connection#getTargetPort <em>Target Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Connection</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Connection</em>' reference.
	 * @see #setIncomingConnection(Connection)
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getInputPort_IncomingConnection()
	 * @see org.esmp.dsm.semantic.blockdiagram.Connection#getTargetPort
	 * @model opposite="targetPort" ordered="false"
	 * @generated
	 */
	Connection getIncomingConnection();

	/**
	 * Sets the value of the '{@link org.esmp.dsm.semantic.blockdiagram.InputPort#getIncomingConnection <em>Incoming Connection</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Incoming Connection</em>' reference.
	 * @see #getIncomingConnection()
	 * @generated
	 */
	void setIncomingConnection(Connection value);

	/**
	 * Returns the value of the '<em><b>Direct Feedthrough</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direct Feedthrough</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direct Feedthrough</em>' attribute.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getInputPort_DirectFeedthrough()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	boolean isDirectFeedthrough();

	/**
	 * Returns the value of the '<em><b>Input</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.esmp.dsm.semantic.blockdiagram.Input#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input</em>' container reference.
	 * @see #setInput(Input)
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getInputPort_Input()
	 * @see org.esmp.dsm.semantic.blockdiagram.Input#getPorts
	 * @model opposite="ports" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Input getInput();

	/**
	 * Sets the value of the '{@link org.esmp.dsm.semantic.blockdiagram.InputPort#getInput <em>Input</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input</em>' container reference.
	 * @see #getInput()
	 * @generated
	 */
	void setInput(Input value);

} // InputPort
