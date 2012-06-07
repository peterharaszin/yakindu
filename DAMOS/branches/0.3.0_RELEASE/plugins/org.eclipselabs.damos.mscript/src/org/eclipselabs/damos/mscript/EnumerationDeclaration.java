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
 * A representation of the model object '<em><b>Enumeration Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.EnumerationDeclaration#getLiteralDeclarations <em>Literal Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.MscriptPackage#getEnumerationDeclaration()
 * @model
 * @generated
 */
public interface EnumerationDeclaration extends Declaration {
	/**
	 * Returns the value of the '<em><b>Literal Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.EnumerationLiteralDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literal Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal Declarations</em>' containment reference list.
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getEnumerationDeclaration_LiteralDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<EnumerationLiteralDeclaration> getLiteralDeclarations();

} // EnumerationDefinition
