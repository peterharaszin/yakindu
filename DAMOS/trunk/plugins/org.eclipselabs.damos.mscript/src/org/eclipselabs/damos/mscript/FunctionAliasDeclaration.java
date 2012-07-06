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
 * A representation of the model object '<em><b>Function Alias Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.FunctionAliasDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.FunctionAliasDeclaration#getFunctionDeclaration <em>Function Declaration</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.FunctionAliasDeclaration#getStaticArguments <em>Static Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.MscriptPackage#getFunctionAliasDeclaration()
 * @model
 * @generated
 */
public interface FunctionAliasDeclaration extends CallableElement {
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
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getFunctionAliasDeclaration_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.FunctionAliasDeclaration#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Function Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Declaration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Declaration</em>' reference.
	 * @see #setFunctionDeclaration(FunctionDeclaration)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getFunctionAliasDeclaration_FunctionDeclaration()
	 * @model
	 * @generated
	 */
	FunctionDeclaration getFunctionDeclaration();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.FunctionAliasDeclaration#getFunctionDeclaration <em>Function Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function Declaration</em>' reference.
	 * @see #getFunctionDeclaration()
	 * @generated
	 */
	void setFunctionDeclaration(FunctionDeclaration value);

	/**
	 * Returns the value of the '<em><b>Static Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Static Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Static Arguments</em>' containment reference list.
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getFunctionAliasDeclaration_StaticArguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getStaticArguments();

} // FunctionAliasDeclaration
