/**
 */
package org.eclipselabs.damos.mscript;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Check Argument</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.TypeCheckArgument#getTypeSpecifier <em>Type Specifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.MscriptPackage#getTypeCheckArgument()
 * @model
 * @generated
 */
public interface TypeCheckArgument extends CheckArgument {
	/**
	 * Returns the value of the '<em><b>Type Specifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Specifier</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Specifier</em>' containment reference.
	 * @see #setTypeSpecifier(TypeSpecifier)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getTypeCheckArgument_TypeSpecifier()
	 * @model containment="true"
	 * @generated
	 */
	TypeSpecifier getTypeSpecifier();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.TypeCheckArgument#getTypeSpecifier <em>Type Specifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Specifier</em>' containment reference.
	 * @see #getTypeSpecifier()
	 * @generated
	 */
	void setTypeSpecifier(TypeSpecifier value);

} // TypeCheckArgument
