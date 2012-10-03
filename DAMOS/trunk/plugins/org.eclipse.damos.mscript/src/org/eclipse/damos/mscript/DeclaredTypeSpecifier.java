/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.mscript;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Declared Type Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.mscript.DeclaredTypeSpecifier#getTypeDeclaration <em>Type Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.mscript.MscriptPackage#getDeclaredTypeSpecifier()
 * @model
 * @generated
 */
public interface DeclaredTypeSpecifier extends TypeSpecifier {
	/**
	 * Returns the value of the '<em><b>Type Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Declaration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Declaration</em>' reference.
	 * @see #setTypeDeclaration(TypeDeclaration)
	 * @see org.eclipse.damos.mscript.MscriptPackage#getDeclaredTypeSpecifier_TypeDeclaration()
	 * @model
	 * @generated
	 */
	TypeDeclaration getTypeDeclaration();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.DeclaredTypeSpecifier#getTypeDeclaration <em>Type Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Declaration</em>' reference.
	 * @see #getTypeDeclaration()
	 * @generated
	 */
	void setTypeDeclaration(TypeDeclaration value);

} // DeclaredTypeSpecifier
