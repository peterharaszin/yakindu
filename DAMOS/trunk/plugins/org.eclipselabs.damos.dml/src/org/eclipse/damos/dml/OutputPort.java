/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.OutputPort#getOutput <em>Output</em>}</li>
 *   <li>{@link org.eclipse.damos.dml.OutputPort#getSignal <em>Signal</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dml.DMLPackage#getOutputPort()
 * @model
 * @generated
 */
public interface OutputPort extends Port, OutputConnector {
	/**
	 * Returns the value of the '<em><b>Output</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.damos.dml.Output#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output</em>' container reference.
	 * @see #setOutput(Output)
	 * @see org.eclipse.damos.dml.DMLPackage#getOutputPort_Output()
	 * @see org.eclipse.damos.dml.Output#getPorts
	 * @model opposite="ports" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Output getOutput();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dml.OutputPort#getOutput <em>Output</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output</em>' container reference.
	 * @see #getOutput()
	 * @generated
	 */
	void setOutput(Output value);

	/**
	 * Returns the value of the '<em><b>Signal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signal</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signal</em>' containment reference.
	 * @see #isSetSignal()
	 * @see #unsetSignal()
	 * @see #setSignal(SignalSpecification)
	 * @see org.eclipse.damos.dml.DMLPackage#getOutputPort_Signal()
	 * @model containment="true" unsettable="true" ordered="false"
	 * @generated
	 */
	SignalSpecification getSignal();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dml.OutputPort#getSignal <em>Signal</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signal</em>' containment reference.
	 * @see #isSetSignal()
	 * @see #unsetSignal()
	 * @see #getSignal()
	 * @generated
	 */
	void setSignal(SignalSpecification value);

	/**
	 * Unsets the value of the '{@link org.eclipse.damos.dml.OutputPort#getSignal <em>Signal</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSignal()
	 * @see #getSignal()
	 * @see #setSignal(SignalSpecification)
	 * @generated
	 */
	void unsetSignal();

	/**
	 * Returns whether the value of the '{@link org.eclipse.damos.dml.OutputPort#getSignal <em>Signal</em>}' containment reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Signal</em>' containment reference is set.
	 * @see #unsetSignal()
	 * @see #getSignal()
	 * @see #setSignal(SignalSpecification)
	 * @generated
	 */
	boolean isSetSignal();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" ordered="false"
	 * @generated
	 */
	@Deprecated
	EList<Connection> getOutgoingConnections();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" contextRequired="true" contextOrdered="false"
	 * @generated
	 */
	@Deprecated
	EList<Connection> getOutgoingConnections(Fragment context);

} // OutputPort
