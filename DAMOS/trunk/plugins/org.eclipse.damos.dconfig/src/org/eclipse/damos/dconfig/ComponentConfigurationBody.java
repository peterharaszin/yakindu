/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dconfig;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Configuration Body</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dconfig.ComponentConfigurationBody#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dconfig.DconfigPackage#getComponentConfigurationBody()
 * @model
 * @generated
 */
public interface ComponentConfigurationBody extends PropertyContainer {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.damos.dconfig.ComponentConfiguration#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(ComponentConfiguration)
	 * @see org.eclipse.damos.dconfig.DconfigPackage#getComponentConfigurationBody_Owner()
	 * @see org.eclipse.damos.dconfig.ComponentConfiguration#getBody
	 * @model opposite="body" transient="false"
	 * @generated
	 */
	ComponentConfiguration getOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dconfig.ComponentConfigurationBody#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(ComponentConfiguration value);

} // ComponentConfigurationBody
