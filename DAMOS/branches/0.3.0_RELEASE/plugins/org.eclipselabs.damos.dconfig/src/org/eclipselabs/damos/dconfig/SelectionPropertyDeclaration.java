/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dconfig;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Selection Property Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dconfig.SelectionPropertyDeclaration#getCount <em>Count</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getSelectionPropertyDeclaration()
 * @model
 * @generated
 */
public interface SelectionPropertyDeclaration extends PropertyDeclaration {

	/**
	 * Returns the value of the '<em><b>Count</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Count</em>' attribute.
	 * @see #setCount(int)
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getSelectionPropertyDeclaration_Count()
	 * @model default="1"
	 * @generated
	 */
	int getCount();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dconfig.SelectionPropertyDeclaration#getCount <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Count</em>' attribute.
	 * @see #getCount()
	 * @generated
	 */
	void setCount(int value);
} // SelectionPropertyDeclaration
