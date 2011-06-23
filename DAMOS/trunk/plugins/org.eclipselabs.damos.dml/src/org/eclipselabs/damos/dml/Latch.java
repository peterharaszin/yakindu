/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Latch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.Latch#getInitialValue <em>Initial Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dml.DMLPackage#getLatch()
 * @model
 * @generated
 */
public interface Latch extends Component {
	/**
	 * Returns the value of the '<em><b>Initial Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Value</em>' containment reference.
	 * @see #setInitialValue(ValueSpecification)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getLatch_InitialValue()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ValueSpecification getInitialValue();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.Latch#getInitialValue <em>Initial Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Value</em>' containment reference.
	 * @see #getInitialValue()
	 * @generated
	 */
	void setInitialValue(ValueSpecification value);

} // Latch
