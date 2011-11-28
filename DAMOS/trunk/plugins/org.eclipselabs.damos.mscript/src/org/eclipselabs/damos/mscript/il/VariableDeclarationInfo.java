/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.il;

import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.mscript.VariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Declaration Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.il.VariableDeclarationInfo#getVariableDeclaration <em>Variable Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.il.ILPackage#getVariableDeclarationInfo()
 * @model
 * @generated
 */
public interface VariableDeclarationInfo extends EObject {
	/**
	 * Returns the value of the '<em><b>Variable Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Declaration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Declaration</em>' reference.
	 * @see #setVariableDeclaration(VariableDeclaration)
	 * @see org.eclipselabs.damos.mscript.il.ILPackage#getVariableDeclarationInfo_VariableDeclaration()
	 * @model
	 * @generated
	 */
	VariableDeclaration getVariableDeclaration();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.il.VariableDeclarationInfo#getVariableDeclaration <em>Variable Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Declaration</em>' reference.
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	void setVariableDeclaration(VariableDeclaration value);

} // VariableDeclarationInfo
