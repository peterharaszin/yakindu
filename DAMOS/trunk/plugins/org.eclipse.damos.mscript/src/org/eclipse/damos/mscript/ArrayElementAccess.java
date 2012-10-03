/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.mscript;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Element Access</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.mscript.ArrayElementAccess#getArray <em>Array</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.ArrayElementAccess#getSubscripts <em>Subscripts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.mscript.MscriptPackage#getArrayElementAccess()
 * @model
 * @generated
 */
public interface ArrayElementAccess extends Expression {
	/**
	 * Returns the value of the '<em><b>Array</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Array</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Array</em>' containment reference.
	 * @see #setArray(Expression)
	 * @see org.eclipse.damos.mscript.MscriptPackage#getArrayElementAccess_Array()
	 * @model containment="true"
	 * @generated
	 */
	Expression getArray();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.ArrayElementAccess#getArray <em>Array</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Array</em>' containment reference.
	 * @see #getArray()
	 * @generated
	 */
	void setArray(Expression value);

	/**
	 * Returns the value of the '<em><b>Subscripts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.mscript.ArraySubscript}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subscripts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subscripts</em>' containment reference list.
	 * @see org.eclipse.damos.mscript.MscriptPackage#getArrayElementAccess_Subscripts()
	 * @model containment="true"
	 * @generated
	 */
	EList<ArraySubscript> getSubscripts();

} // ArrayElementAccess
