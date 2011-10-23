/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tensor Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.TensorType#isVector <em>Vector</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.TensorType#isMatrix <em>Matrix</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.MscriptPackage#getTensorType()
 * @model
 * @generated
 */
public interface TensorType extends ArrayType {
	/**
	 * Returns the value of the '<em><b>Vector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vector</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vector</em>' attribute.
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getTensorType_Vector()
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
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getTensorType_Matrix()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isMatrix();
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.ArrayType#getElementType()
	 */
	public NumericType getElementType();

} // TensorType
