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
 * A representation of the model object '<em><b>Function Object Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.FunctionObjectDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.FunctionObjectDeclaration#getFunctionName <em>Function Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.FunctionObjectDeclaration#getTemplateArguments <em>Template Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.MscriptPackage#getFunctionObjectDeclaration()
 * @model
 * @generated
 */
public interface FunctionObjectDeclaration extends CallableElement {
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
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getFunctionObjectDeclaration_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.FunctionObjectDeclaration#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Function Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Name</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Name</em>' reference.
	 * @see #setFunctionName(FunctionDeclaration)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getFunctionObjectDeclaration_FunctionName()
	 * @model
	 * @generated
	 */
	FunctionDeclaration getFunctionName();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.FunctionObjectDeclaration#getFunctionName <em>Function Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function Name</em>' reference.
	 * @see #getFunctionName()
	 * @generated
	 */
	void setFunctionName(FunctionDeclaration value);

	/**
	 * Returns the value of the '<em><b>Template Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template Arguments</em>' containment reference list.
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getFunctionObjectDeclaration_TemplateArguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getTemplateArguments();

} // FunctionObjectDeclaration
