/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sexec;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Save History</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.SaveHistory#getRegion <em>Region</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.sexec.SexecPackage#getSaveHistory()
 * @model
 * @generated
 */
public interface SaveHistory extends Step {
	/**
	 * Returns the value of the '<em><b>Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Region</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Region</em>' reference.
	 * @see #setRegion(ExecutionRegion)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getSaveHistory_Region()
	 * @model
	 * @generated
	 */
	ExecutionRegion getRegion();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.SaveHistory#getRegion <em>Region</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Region</em>' reference.
	 * @see #getRegion()
	 * @generated
	 */
	void setRegion(ExecutionRegion value);

} // SaveHistory
