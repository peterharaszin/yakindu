/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dconfig;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dconfig.ConfigurationDefinition#getPackageName <em>Package Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.ConfigurationDefinition#getMembers <em>Members</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getConfigurationDefinition()
 * @model
 * @generated
 */
public interface ConfigurationDefinition extends EObject {
	/**
	 * Returns the value of the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package Name</em>' attribute.
	 * @see #setPackageName(String)
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getConfigurationDefinition_PackageName()
	 * @model
	 * @generated
	 */
	String getPackageName();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dconfig.ConfigurationDefinition#getPackageName <em>Package Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package Name</em>' attribute.
	 * @see #getPackageName()
	 * @generated
	 */
	void setPackageName(String value);

	/**
	 * Returns the value of the '<em><b>Members</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.dconfig.ConfigurationDefinitionMember}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.dconfig.ConfigurationDefinitionMember#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Members</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Members</em>' containment reference list.
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getConfigurationDefinition_Members()
	 * @see org.eclipselabs.damos.dconfig.ConfigurationDefinitionMember#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<ConfigurationDefinitionMember> getMembers();

} // ConfigurationDefinition
