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
 *   <li>{@link org.eclipse.damos.dml.SynchronousTimingConstraint#getSampleInterval <em>Sample Interval</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dml.DMLPackage#getSynchronousTimingConstraint()
 * @model
 * @generated
 */
public interface SynchronousTimingConstraint extends TimingConstraint {
	/**
	 * Returns the value of the '<em><b>Sample Interval</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sample Interval</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sample Interval</em>' containment reference.
	 * @see #setSampleInterval(ValueSpecification)
	 * @see org.eclipse.damos.dml.DMLPackage#getSynchronousTimingConstraint_SampleInterval()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ValueSpecification getSampleInterval();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dml.SynchronousTimingConstraint#getSampleInterval <em>Sample Interval</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sample Interval</em>' containment reference.
	 * @see #getSampleInterval()
	 * @generated
	 */
	void setSampleInterval(ValueSpecification value);

} // SynchronousTimingConstraint
