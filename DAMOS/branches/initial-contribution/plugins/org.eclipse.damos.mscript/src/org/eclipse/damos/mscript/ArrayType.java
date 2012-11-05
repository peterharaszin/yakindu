/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
package org.eclipse.damos.mscript;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.mscript.ArrayType#getDimensions <em>Dimensions</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.ArrayType#getDimensionality <em>Dimensionality</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.ArrayType#isDimensional <em>Dimensional</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.ArrayType#isMultidimensional <em>Multidimensional</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.ArrayType#isNumeric <em>Numeric</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.ArrayType#isNumericVector <em>Numeric Vector</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.ArrayType#isNumericMatrix <em>Numeric Matrix</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.mscript.MscriptPackage#getArrayType()
 * @model abstract="true"
 * @generated
 */
public interface ArrayType extends DataType {
	/**
	 * Returns the value of the '<em><b>Numeric</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tensor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Numeric</em>' attribute.
	 * @see org.eclipse.damos.mscript.MscriptPackage#getArrayType_Numeric()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isNumeric();

	/**
	 * Returns the value of the '<em><b>Dimensions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.mscript.ArrayDimension}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimensions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dimensions</em>' containment reference list.
	 * @see org.eclipse.damos.mscript.MscriptPackage#getArrayType_Dimensions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ArrayDimension> getDimensions();
	
	/**
	 * The following data type rules apply for array operations.
	 * 
	 * <h4>Array element-wise Addition and Subtraction</h4>
	 * <p>
	 * Addition <code>a+b</code> and subtraction <code>a-b</code> is defined as element-wise operation
	 * for <code>a</code> and <code>b</code> of the same dimensionality:
	 * 
	 * <p>
	 * <table border="1">
	 * <th>Type of a</th><th>Type of b</th><th>Type of a+/-b</th>
	 * <tr><td>Scalar</td><td>Scalar</td><td>Scalar</td></tr>
	 * <tr><td>Vector[n]</td><td>Vector[n]</td><td>Vector[n]</td></tr>
	 * <tr><td>Matrix[m, n]</td><td>Matrix[m, n]</td><td>Matrix[m, n]</td></tr>
	 * <tr><td>Array[m, n, ...]</td><td>Array[m, n, ...]</td><td>Array[m, n, ...]</td></tr>
	 * </table>
	 * 
	 * <p>
	 * Element-wise addition <code>a.+b</code> and subtraction <code>a.-b</code> is defined as follows:
	 * 
	 * <p>
	 * <table border="1">
	 * <th>Type of a</th><th>Type of b</th><th>Type of a.+/.-b</th>
	 * <tr><td>Scalar</td><td>Scalar</td><td>Scalar</td></tr>
	 * <tr><td>Scalar</td><td>Array[m, n, ...]</td><td>Array[m, n, ...]</td></tr>
	 * <tr><td>Array[m, n, ...]</td><td>Scalar</td><td>Array[m, n, ...]</td></tr>
	 * <tr><td>Array[m, n, ...]</td><td>Array[m, n, ...]</td><td>Array[m, n, ...]</td></tr>
	 * </table>
	 * 
	 * <h4>Array Element-wise Multiplication</h4>
	 * 
	 * <p>
	 * Scalar multiplication <code>s*a</code> and <code>a*s</code> is defined as follows:
	 * 
	 * <p>
	 * <table border="1">
	 * <th>Type of s</th><th>Type of a</th><th>Type of s*a and a*s</th>
	 * <tr><td>Scalar</td><td>Scalar</td><td>Scalar</td></tr>
	 * <tr><td>Scalar</td><td>Vector[n]</td><td>Vector[n]</td></tr>
	 * <tr><td>Scalar</td><td>Matrix[m, n]</td><td>Matrix[m, n]</td></tr>
	 * <tr><td>Scalar</td><td>Array[m, n, ...]</td><td>Array[m, n, ...]</td></tr>
	 * </table>
	 * 
	 * <p>
	 * Element-wise multiplication <code>a.*b</code> is defined as follows:
	 * 
	 * <p>
	 * <table border="1">
	 * <th>Type of a</th><th>Type of b</th><th>Type of a.*b</th>
	 * <tr><td>Scalar</td><td>Scalar</td><td>Scalar</td></tr>
	 * <tr><td>Scalar</td><td>Array[m, n, ...]</td><td>Array[m, n, ...]</td></tr>
	 * <tr><td>Array[m, n, ...]</td><td>Scalar</td><td>Array[m, n, ...]</td></tr>
	 * <tr><td>Array[m, n, ...]</td><td>Array[m, n, ...]</td><td>Array[m, n, ...]</td></tr>
	 * </table>
	 * 
	 * <h4>Matrix and Vector Multiplication of Numeric Arrays</h4>
	 * 
	 * <p>
	 * Multiplication <code>a*b</code> is defined as follows:
	 * 
	 * <p>
	 * <table border="1">
	 * <th>Type of a</th><th>Type of b</th><th>Type of a*b</th>
	 * <tr><td>Vector[n]</td><td>Vector[n]</td><td>Scalar</td></tr>
	 * <tr><td>Vector[m]</td><td>Matrix[m, n]</td><td>Vector[n]</td></tr>
	 * <tr><td>Matrix[m, n]</td><td>Vector[n]</td><td>Vector[m]</td></tr>
	 * <tr><td>Matrix[m, n]</td><td>Matrix[n, p]</td><td>Matrix[m, p]</td></tr>
	 * </table>
	 * 
	 * <h4>Division of Scalars or Numeric Arrays by Numeric Scalars</h4>
	 * 
	 * <p>
	 * Division <code>a/s</code> and modulo <code>a%s</code> is defined as follows:
	 * 
	 * <p>
	 * <table border="1">
	 * <th>Type of s</th><th>Type of a</th><th>Type of a/s and a%s</th>
	 * <tr><td>Scalar</td><td>Scalar</td><td>Scalar</td></tr>
	 * <tr><td>Vector[n]</td><td>Scalar</td><td>Vector[n]</td></tr>
	 * <tr><td>Matrix[m, n]</td><td>Scalar</td><td>Matrix[m, n]</td></tr>
	 * <tr><td>Array[m, n, ...]</td><td>Scalar</td><td>Array[m, n, ...]</td></tr>
	 * </table>
	 * 
	 * <h4>Array Element-wise Division</h4>
	 * 
	 * <p>
	 * Element-wise division <code>a./b</code> and modulo <code>a.%s</code> is defined as follows:
	 * 
	 * <p>
	 * <table border="1">
	 * <th>Type of a</th><th>Type of b</th><th>Type of a./b and a.%s</th>
	 * <tr><td>Scalar</td><td>Scalar</td><td>Scalar</td></tr>
	 * <tr><td>Scalar</td><td>Array[m, n, ...]</td><td>Array[m, n, ...]</td></tr>
	 * <tr><td>Array[m, n, ...]</td><td>Scalar</td><td>Array[m, n, ...]</td></tr>
	 * <tr><td>Array[m, n, ...]</td><td>Array[m, n, ...]</td><td>Array[m, n, ...]</td></tr>
	 * </table>
	 * 
	 * @param operator
	 * @param other
	 * @return
	 */
	public Type evaluate(OperatorKind operator, Type other);

	/**
	 * Returns the value of the '<em><b>Dimensionality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimensionality</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dimensionality</em>' attribute.
	 * @see org.eclipse.damos.mscript.MscriptPackage#getArrayType_Dimensionality()
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
	 * @see org.eclipse.damos.mscript.MscriptPackage#getArrayType_Dimensional()
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
	 * @see org.eclipse.damos.mscript.MscriptPackage#getArrayType_Multidimensional()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isMultidimensional();

	/**
	 * Returns the value of the '<em><b>Numeric Vector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vector</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Numeric Vector</em>' attribute.
	 * @see org.eclipse.damos.mscript.MscriptPackage#getArrayType_NumericVector()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isNumericVector();

	/**
	 * Returns the value of the '<em><b>Numeric Matrix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matrix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Numeric Matrix</em>' attribute.
	 * @see org.eclipse.damos.mscript.MscriptPackage#getArrayType_NumericMatrix()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isNumericMatrix();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Type getElementType();

} // ArrayType
