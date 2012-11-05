/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dconfig;

import org.eclipse.damos.dml.Fragment;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fragment Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dconfig.FragmentConfiguration#getStartFragment <em>Start Fragment</em>}</li>
 *   <li>{@link org.eclipse.damos.dconfig.FragmentConfiguration#getEndFragment <em>End Fragment</em>}</li>
 *   <li>{@link org.eclipse.damos.dconfig.FragmentConfiguration#isRange <em>Range</em>}</li>
 *   <li>{@link org.eclipse.damos.dconfig.FragmentConfiguration#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dconfig.DconfigPackage#getFragmentConfiguration()
 * @model
 * @generated
 */
public interface FragmentConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Start Fragment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Fragment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Fragment</em>' reference.
	 * @see #setStartFragment(Fragment)
	 * @see org.eclipse.damos.dconfig.DconfigPackage#getFragmentConfiguration_StartFragment()
	 * @model
	 * @generated
	 */
	Fragment getStartFragment();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dconfig.FragmentConfiguration#getStartFragment <em>Start Fragment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Fragment</em>' reference.
	 * @see #getStartFragment()
	 * @generated
	 */
	void setStartFragment(Fragment value);

	/**
	 * Returns the value of the '<em><b>End Fragment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Fragment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Fragment</em>' reference.
	 * @see #setEndFragment(Fragment)
	 * @see org.eclipse.damos.dconfig.DconfigPackage#getFragmentConfiguration_EndFragment()
	 * @model
	 * @generated
	 */
	Fragment getEndFragment();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dconfig.FragmentConfiguration#getEndFragment <em>End Fragment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Fragment</em>' reference.
	 * @see #getEndFragment()
	 * @generated
	 */
	void setEndFragment(Fragment value);

	/**
	 * Returns the value of the '<em><b>Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Range</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Range</em>' attribute.
	 * @see #setRange(boolean)
	 * @see org.eclipse.damos.dconfig.DconfigPackage#getFragmentConfiguration_Range()
	 * @model
	 * @generated
	 */
	boolean isRange();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dconfig.FragmentConfiguration#isRange <em>Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Range</em>' attribute.
	 * @see #isRange()
	 * @generated
	 */
	void setRange(boolean value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.damos.dconfig.FragmentConfigurationBody#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(FragmentConfigurationBody)
	 * @see org.eclipse.damos.dconfig.DconfigPackage#getFragmentConfiguration_Body()
	 * @see org.eclipse.damos.dconfig.FragmentConfigurationBody#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	FragmentConfigurationBody getBody();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dconfig.FragmentConfiguration#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(FragmentConfigurationBody value);

} // FragmentConfiguration
