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
 * A representation of the model object '<em><b>Property Declaration Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dconfig.PropertyDeclarationContainer#getPropertyDeclarations <em>Property Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getPropertyDeclarationContainer()
 * @model abstract="true"
 * @generated
 */
public interface PropertyDeclarationContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Property Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.dconfig.PropertyDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Declarations</em>' containment reference list.
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getPropertyDeclarationContainer_PropertyDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<PropertyDeclaration> getPropertyDeclarations();

} // PropertyDeclarationContainer
