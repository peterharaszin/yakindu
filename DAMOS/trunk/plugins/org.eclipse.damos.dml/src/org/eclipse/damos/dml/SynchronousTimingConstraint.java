/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Synchronous Timing Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.SynchronousTimingConstraint#getSampleTime <em>Sample Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dml.DMLPackage#getSynchronousTimingConstraint()
 * @model
 * @generated
 */
public interface SynchronousTimingConstraint extends TimingConstraint {
	/**
	 * Returns the value of the '<em><b>Sample Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sample Time</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sample Time</em>' containment reference.
	 * @see #setSampleTime(ValueSpecification)
	 * @see org.eclipse.damos.dml.DMLPackage#getSynchronousTimingConstraint_SampleTime()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ValueSpecification getSampleTime();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dml.SynchronousTimingConstraint#getSampleTime <em>Sample Time</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sample Time</em>' containment reference.
	 * @see #getSampleTime()
	 * @generated
	 */
	void setSampleTime(ValueSpecification value);

} // SynchronousTimingConstraint
