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
 * A representation of the model object '<em><b>Function Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.FunctionDefinition#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.FunctionDefinition#getTemplateParameterDeclarations <em>Template Parameter Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.FunctionDefinition#getInputParameterDeclarations <em>Input Parameter Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.FunctionDefinition#getOutputParameterDeclarations <em>Output Parameter Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.FunctionDefinition#getChecks <em>Checks</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.FunctionDefinition#getAssertions <em>Assertions</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.FunctionDefinition#getFunctionObjectDeclarations <em>Function Object Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.FunctionDefinition#getStateVariableDeclarations <em>State Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.FunctionDefinition#getEquations <em>Equations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.MscriptPackage#getFunctionDefinition()
 * @model
 * @generated
 */
public interface FunctionDefinition extends Definition, CallableElement {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipselabs.damos.mscript.FunctionKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipselabs.damos.mscript.FunctionKind
	 * @see #setKind(FunctionKind)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getFunctionDefinition_Kind()
	 * @model
	 * @generated
	 */
	FunctionKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.FunctionDefinition#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipselabs.damos.mscript.FunctionKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(FunctionKind value);

	/**
	 * Returns the value of the '<em><b>Template Parameter Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.TemplateParameterDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template Parameter Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template Parameter Declarations</em>' containment reference list.
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getFunctionDefinition_TemplateParameterDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<TemplateParameterDeclaration> getTemplateParameterDeclarations();

	/**
	 * Returns the value of the '<em><b>Input Parameter Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.InputParameterDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Parameter Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Parameter Declarations</em>' containment reference list.
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getFunctionDefinition_InputParameterDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<InputParameterDeclaration> getInputParameterDeclarations();

	/**
	 * Returns the value of the '<em><b>Output Parameter Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.OutputParameterDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Parameter Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Parameter Declarations</em>' containment reference list.
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getFunctionDefinition_OutputParameterDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<OutputParameterDeclaration> getOutputParameterDeclarations();

	/**
	 * Returns the value of the '<em><b>Checks</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.Check}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.mscript.Check#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Checks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Checks</em>' containment reference list.
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getFunctionDefinition_Checks()
	 * @see org.eclipselabs.damos.mscript.Check#getFunction
	 * @model opposite="function" containment="true"
	 * @generated
	 */
	EList<Check> getChecks();

	/**
	 * Returns the value of the '<em><b>Assertions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.Assertion}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assertions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assertions</em>' containment reference list.
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getFunctionDefinition_Assertions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Assertion> getAssertions();

	/**
	 * Returns the value of the '<em><b>Function Object Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.FunctionObjectDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Object Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Object Declarations</em>' containment reference list.
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getFunctionDefinition_FunctionObjectDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<FunctionObjectDeclaration> getFunctionObjectDeclarations();

	/**
	 * Returns the value of the '<em><b>State Variable Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.StateVariableDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Variable Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Variable Declarations</em>' containment reference list.
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getFunctionDefinition_StateVariableDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<StateVariableDeclaration> getStateVariableDeclarations();

	/**
	 * Returns the value of the '<em><b>Equations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.Equation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Equations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Equations</em>' containment reference list.
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getFunctionDefinition_Equations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Equation> getEquations();

} // FunctionDefinition
