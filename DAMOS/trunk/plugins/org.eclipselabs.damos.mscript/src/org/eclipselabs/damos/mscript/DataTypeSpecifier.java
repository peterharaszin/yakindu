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
 * A representation of the model object '<em><b>Data Type Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.DataTypeSpecifier#getTypeDeclaration <em>Type Declaration</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.DataTypeSpecifier#getAnonymousType <em>Anonymous Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.MscriptPackage#getDataTypeSpecifier()
 * @model
 * @generated
 */
public interface DataTypeSpecifier extends EObject {
	/**
	 * Returns the value of the '<em><b>Type Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Declaration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Declaration</em>' reference.
	 * @see #setTypeDeclaration(DataTypeDeclaration)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getDataTypeSpecifier_TypeDeclaration()
	 * @model
	 * @generated
	 */
	DataTypeDeclaration getTypeDeclaration();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.DataTypeSpecifier#getTypeDeclaration <em>Type Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Declaration</em>' reference.
	 * @see #getTypeDeclaration()
	 * @generated
	 */
	void setTypeDeclaration(DataTypeDeclaration value);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	DataType getType();

	/**
	 * Returns the value of the '<em><b>Anonymous Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defined Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Anonymous Type</em>' containment reference.
	 * @see #setAnonymousType(DataType)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getDataTypeSpecifier_AnonymousType()
	 * @model containment="true"
	 * @generated
	 */
	DataType getAnonymousType();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.DataTypeSpecifier#getAnonymousType <em>Anonymous Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Anonymous Type</em>' containment reference.
	 * @see #getAnonymousType()
	 * @generated
	 */
	void setAnonymousType(DataType value);

} // DataTypeSpecifier
