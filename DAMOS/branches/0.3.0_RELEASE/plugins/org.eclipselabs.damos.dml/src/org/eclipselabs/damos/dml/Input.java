/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.Input#getPorts <em>Ports</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.Input#getComponent <em>Component</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dml.DMLPackage#getInput()
 * @model
 * @generated
 */
public interface Input extends Inoutput {
	/**
	 * Returns the value of the '<em><b>Ports</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.dml.InputPort}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.dml.InputPort#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ports</em>' containment reference list.
	 * @see org.eclipselabs.damos.dml.DMLPackage#getInput_Ports()
	 * @see org.eclipselabs.damos.dml.InputPort#getInput
	 * @model opposite="input" containment="true"
	 * @generated
	 */
	EList<InputPort> getPorts();

	/**
	 * Returns the value of the '<em><b>Component</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.dml.Component#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component</em>' container reference.
	 * @see #setComponent(Component)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getInput_Component()
	 * @see org.eclipselabs.damos.dml.Component#getInputs
	 * @model opposite="inputs" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Component getComponent();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.Input#getComponent <em>Component</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component</em>' container reference.
	 * @see #getComponent()
	 * @generated
	 */
	void setComponent(Component value);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direct Feedthrough</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true" ordered="false"
	 * @generated
	 */
	boolean isDirectFeedthrough();
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.Inoutput#createPort()
	 */
	public InputPort createPort();

} // Input
