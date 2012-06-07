/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subsystem Realization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.SubsystemRealization#getRealizedSubsystem <em>Realized Subsystem</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.SubsystemRealization#getRealizingFragment <em>Realizing Fragment</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dml.DMLPackage#getSubsystemRealization()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='MatchingFragment'"
 * @generated
 */
public interface SubsystemRealization extends FragmentElement {
	/**
	 * Returns the value of the '<em><b>Realized Subsystem</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Realized Subsystem</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Realized Subsystem</em>' reference.
	 * @see #setRealizedSubsystem(Subsystem)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getSubsystemRealization_RealizedSubsystem()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Subsystem getRealizedSubsystem();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.SubsystemRealization#getRealizedSubsystem <em>Realized Subsystem</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Realized Subsystem</em>' reference.
	 * @see #getRealizedSubsystem()
	 * @generated
	 */
	void setRealizedSubsystem(Subsystem value);

	/**
	 * Returns the value of the '<em><b>Realizing Fragment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Realizing Fragment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Realizing Fragment</em>' reference.
	 * @see #setRealizingFragment(Fragment)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getSubsystemRealization_RealizingFragment()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Fragment getRealizingFragment();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.SubsystemRealization#getRealizingFragment <em>Realizing Fragment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Realizing Fragment</em>' reference.
	 * @see #getRealizingFragment()
	 * @generated
	 */
	void setRealizingFragment(Fragment value);

} // SubsystemRealization
