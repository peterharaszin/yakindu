/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.ArrayType#getElementTypeSpecifier <em>Element Type Specifier</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.ArrayType#isTensor <em>Tensor</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.ArrayType#getDimensions <em>Dimensions</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.ArrayType#getDimensionality <em>Dimensionality</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.ArrayType#isDimensional <em>Dimensional</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.ArrayType#isMultidimensional <em>Multidimensional</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.ArrayType#isVector <em>Vector</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.ArrayType#isMatrix <em>Matrix</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.MscriptPackage#getArrayType()
 * @model
 * @generated
 */
public interface ArrayType extends DataType {
	/**
	 * Returns the value of the '<em><b>Element Type Specifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type Specifier</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Type Specifier</em>' containment reference.
	 * @see #setElementTypeSpecifier(DataTypeSpecifier)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getArrayType_ElementTypeSpecifier()
	 * @model containment="true"
	 * @generated
	 */
	DataTypeSpecifier getElementTypeSpecifier();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.ArrayType#getElementTypeSpecifier <em>Element Type Specifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Type Specifier</em>' containment reference.
	 * @see #getElementTypeSpecifier()
	 * @generated
	 */
	void setElementTypeSpecifier(DataTypeSpecifier value);

	/**
	 * Returns the value of the '<em><b>Tensor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tensor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tensor</em>' attribute.
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getArrayType_Tensor()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isTensor();

	/**
	 * Returns the value of the '<em><b>Dimensions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.ArrayDimension}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimensions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dimensions</em>' containment reference list.
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getArrayType_Dimensions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ArrayDimension> getDimensions();

	/**
	 * Returns the value of the '<em><b>Dimensionality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimensionality</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dimensionality</em>' attribute.
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getArrayType_Dimensionality()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	int getDimensionality();

	/**
	 * Returns the value of the '<em><b>Dimensional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimensional</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dimensional</em>' attribute.
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getArrayType_Dimensional()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isDimensional();

	/**
	 * Returns the value of the '<em><b>Multidimensional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multidimensional</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multidimensional</em>' attribute.
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getArrayType_Multidimensional()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isMultidimensional();

	/**
	 * Returns the value of the '<em><b>Vector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vector</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vector</em>' attribute.
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getArrayType_Vector()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isVector();

	/**
	 * Returns the value of the '<em><b>Matrix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matrix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matrix</em>' attribute.
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getArrayType_Matrix()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isMatrix();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	DataType getElementType();

} // ArrayType
