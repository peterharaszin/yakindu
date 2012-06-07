/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dconfig;

import org.eclipselabs.damos.dml.Subsystem;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subsystem Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dconfig.SubsystemConfiguration#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.SubsystemConfiguration#getSubsystem <em>Subsystem</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getSubsystemConfiguration()
 * @model
 * @generated
 */
public interface SubsystemConfiguration extends SystemConfiguration {
	/**
	 * Returns the value of the '<em><b>Subsystem</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subsystem</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subsystem</em>' reference.
	 * @see #setSubsystem(Subsystem)
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getSubsystemConfiguration_Subsystem()
	 * @model
	 * @generated
	 */
	Subsystem getSubsystem();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dconfig.SubsystemConfiguration#getSubsystem <em>Subsystem</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subsystem</em>' reference.
	 * @see #getSubsystem()
	 * @generated
	 */
	void setSubsystem(Subsystem value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enclosing System Configuration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getSubsystemConfiguration_Parent()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	SystemConfiguration getParent();

} // SubsystemConfiguration
