/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dconfig;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Body</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dconfig.MappingBody#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getMappingBody()
 * @model
 * @generated
 */
public interface MappingBody extends PropertyContainer {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.dconfig.Mapping#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Mapping)
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getMappingBody_Owner()
	 * @see org.eclipselabs.damos.dconfig.Mapping#getBody
	 * @model opposite="body" transient="false"
	 * @generated
	 */
	Mapping getOwner();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dconfig.MappingBody#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Mapping value);

} // MappingBody
