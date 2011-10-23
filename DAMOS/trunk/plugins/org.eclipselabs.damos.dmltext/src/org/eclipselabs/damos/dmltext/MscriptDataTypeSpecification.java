/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dmltext;

import org.eclipselabs.damos.dml.DataTypeSpecification;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.DataTypeSpecifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mscript Data Type Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dmltext.MscriptDataTypeSpecification#getSpecifier <em>Specifier</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dmltext.MscriptDataTypeSpecification#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dmltext.DMLTextPackage#getMscriptDataTypeSpecification()
 * @model
 * @generated
 */
public interface MscriptDataTypeSpecification extends DataTypeSpecification {
	/**
	 * Returns the value of the '<em><b>Specifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specifier</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specifier</em>' containment reference.
	 * @see #setSpecifier(DataTypeSpecifier)
	 * @see org.eclipselabs.damos.dmltext.DMLTextPackage#getMscriptDataTypeSpecification_Specifier()
	 * @model containment="true"
	 * @generated
	 */
	DataTypeSpecifier getSpecifier();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dmltext.MscriptDataTypeSpecification#getSpecifier <em>Specifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specifier</em>' containment reference.
	 * @see #getSpecifier()
	 * @generated
	 */
	void setSpecifier(DataTypeSpecifier value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see org.eclipselabs.damos.dmltext.DMLTextPackage#getMscriptDataTypeSpecification_Type()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	DataType getType();

} // MscriptDataTypeSpecification
