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
 * A representation of the model object '<em><b>Function Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.FunctionDeclaration#getChecks <em>Checks</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.FunctionDeclaration#getAssertions <em>Assertions</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.FunctionDeclaration#getStateVariableDeclarations <em>State Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.FunctionDeclaration#getConstantDeclarations <em>Constant Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.FunctionDeclaration#getEquations <em>Equations</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.FunctionDeclaration#getAllImplicitVariableDeclarations <em>All Implicit Variable Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.MscriptPackage#getFunctionDeclaration()
 * @model abstract="true"
 * @generated
 */
public interface FunctionDeclaration extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getName();

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	FunctionKind getKind();

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Parameter Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<InputParameterDeclaration> getInputParameterDeclarations();

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template Parameter Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<InputParameterDeclaration> getConstantInputParameterDeclarations();

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Parameter Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<InputParameterDeclaration> getNonConstantInputParameterDeclarations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<ImplicitVariableDeclaration> getImplicitVariableDeclarations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ImplicitVariableDeclaration getImplicitVariableDeclaration(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Parameter Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation"
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
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getFunctionDeclaration_Checks()
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
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getFunctionDeclaration_Assertions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Assertion> getAssertions();

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
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getFunctionDeclaration_StateVariableDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<StateVariableDeclaration> getStateVariableDeclarations();

	/**
	 * Returns the value of the '<em><b>Constant Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.ConstantDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constant Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constant Declarations</em>' containment reference list.
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getFunctionDeclaration_ConstantDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConstantDeclaration> getConstantDeclarations();

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
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getFunctionDeclaration_Equations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Equation> getEquations();

	/**
	 * Returns the value of the '<em><b>All Implicit Variable Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.ImplicitVariableDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Implicit Variable Declarations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Implicit Variable Declarations</em>' containment reference list.
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getFunctionDeclaration_AllImplicitVariableDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<ImplicitVariableDeclaration> getAllImplicitVariableDeclarations();

} // FunctionDeclaration
