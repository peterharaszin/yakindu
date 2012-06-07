/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dconfig;

import org.eclipselabs.damos.dml.Fragment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root System Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dconfig.RootSystemConfiguration#getContextFragment <em>Context Fragment</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getRootSystemConfiguration()
 * @model
 * @generated
 */
public interface RootSystemConfiguration extends SystemConfiguration {
	/**
	 * Returns the value of the '<em><b>Context Fragment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Fragment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Fragment</em>' reference.
	 * @see #setContextFragment(Fragment)
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getRootSystemConfiguration_ContextFragment()
	 * @model
	 * @generated
	 */
	Fragment getContextFragment();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dconfig.RootSystemConfiguration#getContextFragment <em>Context Fragment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Fragment</em>' reference.
	 * @see #getContextFragment()
	 * @generated
	 */
	void setContextFragment(Fragment value);

} // RootSystemConfiguration
