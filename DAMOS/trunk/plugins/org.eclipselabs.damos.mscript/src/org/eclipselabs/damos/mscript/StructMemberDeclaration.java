/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Struct Member Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.StructMemberDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.StructMemberDeclaration#getTypeSpecifier <em>Type Specifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.MscriptPackage#getStructMemberDeclaration()
 * @model
 * @generated
 */
public interface StructMemberDeclaration extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getStructMemberDeclaration_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.StructMemberDeclaration#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type Specifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Specifier</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Specifier</em>' containment reference.
	 * @see #setTypeSpecifier(DataTypeSpecifier)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getStructMemberDeclaration_TypeSpecifier()
	 * @model containment="true"
	 * @generated
	 */
	DataTypeSpecifier getTypeSpecifier();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.StructMemberDeclaration#getTypeSpecifier <em>Type Specifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Specifier</em>' containment reference.
	 * @see #getTypeSpecifier()
	 * @generated
	 */
	void setTypeSpecifier(DataTypeSpecifier value);

} // StructMemberDeclaration
