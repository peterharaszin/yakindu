/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dconfig;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fragment Configuration Body</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dconfig.FragmentConfigurationBody#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dconfig.DconfigPackage#getFragmentConfigurationBody()
 * @model
 * @generated
 */
public interface FragmentConfigurationBody extends PropertyContainer {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.damos.dconfig.FragmentConfiguration#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(FragmentConfiguration)
	 * @see org.eclipse.damos.dconfig.DconfigPackage#getFragmentConfigurationBody_Owner()
	 * @see org.eclipse.damos.dconfig.FragmentConfiguration#getBody
	 * @model opposite="body" transient="false"
	 * @generated
	 */
	FragmentConfiguration getOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dconfig.FragmentConfigurationBody#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(FragmentConfiguration value);

} // FragmentConfigurationBody
