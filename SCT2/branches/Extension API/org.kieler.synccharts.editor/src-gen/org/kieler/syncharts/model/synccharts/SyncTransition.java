/**
 */
package org.kieler.syncharts.model.synccharts;

import org.yakindu.sct.model.sgraph.Transition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sync Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.kieler.syncharts.model.synccharts.SyncTransition#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.kieler.syncharts.model.synccharts.SyncchartsPackage#getSyncTransition()
 * @model
 * @generated
 */
public interface SyncTransition extends Transition {

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * The literals are from the enumeration {@link org.kieler.syncharts.model.synccharts.TransitionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.kieler.syncharts.model.synccharts.TransitionType
	 * @see #setType(TransitionType)
	 * @see org.kieler.syncharts.model.synccharts.SyncchartsPackage#getSyncTransition_Type()
	 * @model default="0"
	 * @generated
	 */
	TransitionType getType();

	/**
	 * Sets the value of the '{@link org.kieler.syncharts.model.synccharts.SyncTransition#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.kieler.syncharts.model.synccharts.TransitionType
	 * @see #getType()
	 * @generated
	 */
	void setType(TransitionType value);
} // SyncTransition
