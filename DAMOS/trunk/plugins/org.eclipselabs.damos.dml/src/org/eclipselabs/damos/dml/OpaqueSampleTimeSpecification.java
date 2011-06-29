/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Opaque Sample Time Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.OpaqueSampleTimeSpecification#getSampleTime <em>Sample Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dml.DMLPackage#getOpaqueSampleTimeSpecification()
 * @model
 * @generated
 */
public interface OpaqueSampleTimeSpecification extends SampleTimeSpecification, ITextualElement {
	/**
	 * Returns the value of the '<em><b>Sample Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sample Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sample Time</em>' attribute.
	 * @see #setSampleTime(String)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getOpaqueSampleTimeSpecification_SampleTime()
	 * @model required="true"
	 * @generated
	 */
	String getSampleTime();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.OpaqueSampleTimeSpecification#getSampleTime <em>Sample Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sample Time</em>' attribute.
	 * @see #getSampleTime()
	 * @generated
	 */
	void setSampleTime(String value);

} // OpaqueSampleTimeSpecification
