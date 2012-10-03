/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subsystem Input</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.SubsystemInput#getInlet <em>Inlet</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dml.DMLPackage#getSubsystemInput()
 * @model
 * @generated
 */
public interface SubsystemInput extends Input, SubsystemInoutput {
	/**
	 * Returns the value of the '<em><b>Inlet</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inlet</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inlet</em>' reference.
	 * @see #setInlet(Inlet)
	 * @see org.eclipse.damos.dml.DMLPackage#getSubsystemInput_Inlet()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Inlet getInlet();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dml.SubsystemInput#getInlet <em>Inlet</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inlet</em>' reference.
	 * @see #getInlet()
	 * @generated
	 */
	void setInlet(Inlet value);

} // SubsystemInput
