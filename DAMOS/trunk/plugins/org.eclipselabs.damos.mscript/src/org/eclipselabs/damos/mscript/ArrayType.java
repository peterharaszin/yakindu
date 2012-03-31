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
 *   <li>{@link org.eclipselabs.damos.mscript.ArrayType#getElementType <em>Element Type</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.ArrayType#getAnonymousElementType <em>Anonymous Element Type</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.ArrayType#getDimensions <em>Dimensions</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.ArrayType#getDimensionality <em>Dimensionality</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.ArrayType#isDimensional <em>Dimensional</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.ArrayType#isMultidimensional <em>Multidimensional</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.MscriptPackage#getArrayType()
 * @model
 * @generated
 */
public interface ArrayType extends DataType {
	/**
	 * Returns the value of the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Type</em>' reference.
	 * @see #setElementType(DataType)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getArrayType_ElementType()
	 * @model
	 * @generated
	 */
	DataType getElementType();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.ArrayType#getElementType <em>Element Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Type</em>' reference.
	 * @see #getElementType()
	 * @generated
	 */
	void setElementType(DataType value);

	/**
	 * Returns the value of the '<em><b>Anonymous Element Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defined Element Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Anonymous Element Type</em>' containment reference.
	 * @see #setAnonymousElementType(DataType)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getArrayType_AnonymousElementType()
	 * @model containment="true"
	 * @generated
	 */
	DataType getAnonymousElementType();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.ArrayType#getAnonymousElementType <em>Anonymous Element Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Anonymous Element Type</em>' containment reference.
	 * @see #getAnonymousElementType()
	 * @generated
	 */
	void setAnonymousElementType(DataType value);

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

} // ArrayType
