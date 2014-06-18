/**
 */
package org.yakindu.base.types;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.base.types.ArrayType#getElementType <em>Element Type</em>}</li>
 *   <li>{@link org.yakindu.base.types.ArrayType#getArraySelector <em>Array Selector</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.base.types.TypesPackage#getArrayType()
 * @model
 * @generated
 */
public interface ArrayType extends Type {
	/**
	 * Returns the value of the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Type</em>' reference.
	 * @see #setElementType(Type)
	 * @see org.yakindu.base.types.TypesPackage#getArrayType_ElementType()
	 * @model
	 * @generated
	 */
	Type getElementType();

	/**
	 * Sets the value of the '{@link org.yakindu.base.types.ArrayType#getElementType <em>Element Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Type</em>' reference.
	 * @see #getElementType()
	 * @generated
	 */
	void setElementType(Type value);

	/**
	 * Returns the value of the '<em><b>Array Selector</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Array Selector</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Array Selector</em>' attribute list.
	 * @see org.yakindu.base.types.TypesPackage#getArrayType_ArraySelector()
	 * @model
	 * @generated
	 */
	EList<Integer> getArraySelector();

} // ArrayType
