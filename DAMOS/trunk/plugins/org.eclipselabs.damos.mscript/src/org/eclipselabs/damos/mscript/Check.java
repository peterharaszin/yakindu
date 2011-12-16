/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript;

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
 *   <li>{@link org.eclipselabs.damos.mscript.Check#getFunction <em>Function</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.Check#getTemplateArguments <em>Template Arguments</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.Check#getInputParameterTypes <em>Input Parameter Types</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.Check#getOutputParameterTypes <em>Output Parameter Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.MscriptPackage#getCheck()
 * @model
 * @generated
 */
public interface Check extends EObject {
	/**
	 * Returns the value of the '<em><b>Function</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.mscript.FunctionDeclaration#getChecks <em>Checks</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function</em>' container reference.
	 * @see #setFunction(FunctionDeclaration)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getCheck_Function()
	 * @see org.eclipselabs.damos.mscript.FunctionDeclaration#getChecks
	 * @model opposite="checks" required="true" transient="false"
	 * @generated
	 */
	FunctionDeclaration getFunction();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.Check#getFunction <em>Function</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function</em>' container reference.
	 * @see #getFunction()
	 * @generated
	 */
	void setFunction(FunctionDeclaration value);

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
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getCheck_TemplateArguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getTemplateArguments();

	/**
	 * Returns the value of the '<em><b>Input Parameter Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.DataTypeSpecifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Parameter Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Parameter Types</em>' containment reference list.
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getCheck_InputParameterTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<DataTypeSpecifier> getInputParameterTypes();

	/**
	 * Returns the value of the '<em><b>Output Parameter Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.DataTypeSpecifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Parameter Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Parameter Types</em>' containment reference list.
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getCheck_OutputParameterTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<DataTypeSpecifier> getOutputParameterTypes();

} // Check
