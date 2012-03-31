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
 *   <li>{@link org.eclipselabs.damos.mscript.DataTypeSpecifier#getType <em>Type</em>}</li>
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
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(DataType)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getDataTypeSpecifier_Type()
	 * @model
	 * @generated
	 */
	DataType getType();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.DataTypeSpecifier#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(DataType value);

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
