/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dconfig;

import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dconfig.SystemConfiguration#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dconfig.DconfigPackage#getSystemConfiguration()
 * @model abstract="true"
 * @generated
 */
public interface SystemConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.damos.dconfig.SystemConfigurationBody#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(SystemConfigurationBody)
	 * @see org.eclipse.damos.dconfig.DconfigPackage#getSystemConfiguration_Body()
	 * @see org.eclipse.damos.dconfig.SystemConfigurationBody#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	SystemConfigurationBody getBody();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dconfig.SystemConfiguration#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(SystemConfigurationBody value);

} // SystemConfiguration
