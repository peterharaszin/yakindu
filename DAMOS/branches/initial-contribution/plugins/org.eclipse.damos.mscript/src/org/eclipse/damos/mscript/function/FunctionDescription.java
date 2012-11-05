/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.mscript.function;

import java.util.Map;

import org.eclipse.damos.mscript.FunctionDeclaration;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.mscript.function.FunctionDescription#getDeclaration <em>Declaration</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.function.FunctionDescription#getEquationDescriptions <em>Equation Descriptions</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.function.FunctionDescription#getVariableDescriptions <em>Variable Descriptions</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.function.FunctionDescription#isStateful <em>Stateful</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.mscript.function.FunctionPackage#getFunctionDescription()
 * @model
 * @generated
 */
public interface FunctionDescription extends EObject {
	/**
	 * Returns the value of the '<em><b>Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declaration</em>' reference.
	 * @see #setDeclaration(FunctionDeclaration)
	 * @see org.eclipse.damos.mscript.function.FunctionPackage#getFunctionDescription_Declaration()
	 * @model required="true"
	 * @generated
	 */
	FunctionDeclaration getDeclaration();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.function.FunctionDescription#getDeclaration <em>Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declaration</em>' reference.
	 * @see #getDeclaration()
	 * @generated
	 */
	void setDeclaration(FunctionDeclaration value);

	/**
	 * Returns the value of the '<em><b>Equation Descriptions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.mscript.function.EquationDescription}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.damos.mscript.function.EquationDescription#getFunctionDescription <em>Function Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Equation Descriptors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Equation Descriptions</em>' containment reference list.
	 * @see org.eclipse.damos.mscript.function.FunctionPackage#getFunctionDescription_EquationDescriptions()
	 * @see org.eclipse.damos.mscript.function.EquationDescription#getFunctionDescription
	 * @model opposite="functionDescription" containment="true"
	 * @generated
	 */
	EList<EquationDescription> getEquationDescriptions();

	/**
	 * Returns the value of the '<em><b>Variable Descriptions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.mscript.function.VariableDescription}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.damos.mscript.function.VariableDescription#getFunctionDescription <em>Function Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Descriptors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Descriptions</em>' containment reference list.
	 * @see org.eclipse.damos.mscript.function.FunctionPackage#getFunctionDescription_VariableDescriptions()
	 * @see org.eclipse.damos.mscript.function.VariableDescription#getFunctionDescription
	 * @model opposite="functionDescription" containment="true"
	 * @generated
	 */
	EList<VariableDescription> getVariableDescriptions();

	/**
	 * Returns the value of the '<em><b>Stateful</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stateful</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stateful</em>' attribute.
	 * @see #setStateful(boolean)
	 * @see org.eclipse.damos.mscript.function.FunctionPackage#getFunctionDescription_Stateful()
	 * @model required="true"
	 * @generated
	 */
	boolean isStateful();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.function.FunctionDescription#isStateful <em>Stateful</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stateful</em>' attribute.
	 * @see #isStateful()
	 * @generated
	 */
	void setStateful(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model nameRequired="true"
	 * @generated
	 */
	VariableDescription getVariableDescription(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean hasNoDuplicateEquations(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean hasNoCyclicEquations(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean hasEquationsForEachOutput(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean hasEquationsForEachVariableStep(DiagnosticChain diagnostics, Map<Object, Object> context);

} // FunctionDescription
