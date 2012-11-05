/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.mscript;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Check</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.mscript.Check#getFunction <em>Function</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.Check#getInputArguments <em>Input Arguments</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.Check#getOutputTypeSpecifiers <em>Output Type Specifiers</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.mscript.MscriptPackage#getCheck()
 * @model
 * @generated
 */
public interface Check extends EObject {
	/**
	 * Returns the value of the '<em><b>Function</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.damos.mscript.FunctionDeclaration#getChecks <em>Checks</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function</em>' container reference.
	 * @see #setFunction(FunctionDeclaration)
	 * @see org.eclipse.damos.mscript.MscriptPackage#getCheck_Function()
	 * @see org.eclipse.damos.mscript.FunctionDeclaration#getChecks
	 * @model opposite="checks" required="true" transient="false"
	 * @generated
	 */
	FunctionDeclaration getFunction();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.Check#getFunction <em>Function</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function</em>' container reference.
	 * @see #getFunction()
	 * @generated
	 */
	void setFunction(FunctionDeclaration value);

	/**
	 * Returns the value of the '<em><b>Input Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.mscript.CheckArgument}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Arguments</em>' containment reference list.
	 * @see org.eclipse.damos.mscript.MscriptPackage#getCheck_InputArguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<CheckArgument> getInputArguments();

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Static Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<Expression> getExpressionArguments();

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Parameter Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<TypeSpecifier> getInputTypeSpecifiers();

	/**
	 * Returns the value of the '<em><b>Output Type Specifiers</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.mscript.TypeSpecifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Parameter Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Type Specifiers</em>' containment reference list.
	 * @see org.eclipse.damos.mscript.MscriptPackage#getCheck_OutputTypeSpecifiers()
	 * @model containment="true"
	 * @generated
	 */
	EList<TypeSpecifier> getOutputTypeSpecifiers();

} // Check
