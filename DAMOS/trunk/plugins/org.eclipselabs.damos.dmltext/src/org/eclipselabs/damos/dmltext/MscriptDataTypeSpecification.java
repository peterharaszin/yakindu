/**
 */
package org.eclipselabs.damos.dmltext;

import org.eclipselabs.damos.dml.DataTypeSpecification;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.TypeSpecifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mscript Data Type Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dmltext.MscriptDataTypeSpecification#getTypeSpecifier <em>Type Specifier</em>}</li>
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
	 * Returns the value of the '<em><b>Type Specifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specifier</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Specifier</em>' containment reference.
	 * @see #setTypeSpecifier(TypeSpecifier)
	 * @see org.eclipselabs.damos.dmltext.DMLTextPackage#getMscriptDataTypeSpecification_TypeSpecifier()
	 * @model containment="true"
	 * @generated
	 */
	TypeSpecifier getTypeSpecifier();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dmltext.MscriptDataTypeSpecification#getTypeSpecifier <em>Type Specifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Specifier</em>' containment reference.
	 * @see #getTypeSpecifier()
	 * @generated
	 */
	void setTypeSpecifier(TypeSpecifier value);

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
	Type getType();

} // MscriptDataTypeSpecification
