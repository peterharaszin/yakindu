/**
 */
package org.eclipse.damos.dscript;

import org.eclipse.damos.dml.DataTypeSpecification;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.TypeSpecifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mscript Data Type Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dscript.DscriptDataTypeSpecification#getTypeSpecifier <em>Type Specifier</em>}</li>
 *   <li>{@link org.eclipse.damos.dscript.DscriptDataTypeSpecification#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dscript.DscriptPackage#getDscriptDataTypeSpecification()
 * @model
 * @generated
 */
public interface DscriptDataTypeSpecification extends DataTypeSpecification {
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
	 * @see org.eclipse.damos.dscript.DscriptPackage#getDscriptDataTypeSpecification_TypeSpecifier()
	 * @model containment="true"
	 * @generated
	 */
	TypeSpecifier getTypeSpecifier();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dscript.DscriptDataTypeSpecification#getTypeSpecifier <em>Type Specifier</em>}' containment reference.
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
	 * @see org.eclipse.damos.dscript.DscriptPackage#getDscriptDataTypeSpecification_Type()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Type getType();

} // MscriptDataTypeSpecification
