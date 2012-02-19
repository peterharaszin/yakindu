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
 * A representation of the model object '<em><b>Mapping Target Path</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dconfig.MappingTargetPath#getPropertyReferences <em>Property References</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.MappingTargetPath#getResource <em>Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getMappingTargetPath()
 * @model
 * @generated
 */
public interface MappingTargetPath extends EObject {
	/**
	 * Returns the value of the '<em><b>Property References</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.dconfig.MappingPropertyReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property References</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property References</em>' containment reference list.
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getMappingTargetPath_PropertyReferences()
	 * @model containment="true"
	 * @generated
	 */
	EList<MappingPropertyReference> getPropertyReferences();

	/**
	 * Returns the value of the '<em><b>Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource</em>' reference.
	 * @see #setResource(ResourceDeclaration)
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getMappingTargetPath_Resource()
	 * @model
	 * @generated
	 */
	ResourceDeclaration getResource();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dconfig.MappingTargetPath#getResource <em>Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource</em>' reference.
	 * @see #getResource()
	 * @generated
	 */
	void setResource(ResourceDeclaration value);

} // MappingTargetPath
