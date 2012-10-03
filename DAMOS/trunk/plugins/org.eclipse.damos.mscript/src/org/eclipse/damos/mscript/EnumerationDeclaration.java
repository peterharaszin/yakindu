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
 * A representation of the model object '<em><b>Enumeration Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.mscript.EnumerationDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.EnumerationDeclaration#getLiteralDeclarations <em>Literal Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.mscript.MscriptPackage#getEnumerationDeclaration()
 * @model
 * @generated
 */
public interface EnumerationDeclaration extends TopLevelDeclaration {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.damos.mscript.MscriptPackage#getEnumerationDeclaration_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.EnumerationDeclaration#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Literal Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.mscript.EnumerationLiteralDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literal Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal Declarations</em>' containment reference list.
	 * @see org.eclipse.damos.mscript.MscriptPackage#getEnumerationDeclaration_LiteralDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<EnumerationLiteralDeclaration> getLiteralDeclarations();

} // EnumerationDefinition
