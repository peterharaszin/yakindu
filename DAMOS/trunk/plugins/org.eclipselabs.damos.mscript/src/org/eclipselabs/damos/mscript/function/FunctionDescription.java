/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.function;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.mscript.FunctionDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.function.FunctionDescription#getDeclaration <em>Declaration</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.function.FunctionDescription#getEquationDescriptions <em>Equation Descriptions</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.function.FunctionDescription#getVariableDescriptions <em>Variable Descriptions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.function.FunctionModelPackage#getFunctionDescription()
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
	 * @see org.eclipselabs.damos.mscript.function.FunctionModelPackage#getFunctionDescription_Declaration()
	 * @model required="true"
	 * @generated
	 */
	FunctionDeclaration getDeclaration();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.function.FunctionDescription#getDeclaration <em>Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declaration</em>' reference.
	 * @see #getDeclaration()
	 * @generated
	 */
	void setDeclaration(FunctionDeclaration value);

	/**
	 * Returns the value of the '<em><b>Equation Descriptions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.function.EquationDescription}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.mscript.function.EquationDescription#getFunctionDescription <em>Function Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Equation Descriptors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Equation Descriptions</em>' containment reference list.
	 * @see org.eclipselabs.damos.mscript.function.FunctionModelPackage#getFunctionDescription_EquationDescriptions()
	 * @see org.eclipselabs.damos.mscript.function.EquationDescription#getFunctionDescription
	 * @model opposite="functionDescription" containment="true"
	 * @generated
	 */
	EList<EquationDescription> getEquationDescriptions();

	/**
	 * Returns the value of the '<em><b>Variable Descriptions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.function.VariableDescription}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.mscript.function.VariableDescription#getFunctionDescription <em>Function Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Descriptors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Descriptions</em>' containment reference list.
	 * @see org.eclipselabs.damos.mscript.function.FunctionModelPackage#getFunctionDescription_VariableDescriptions()
	 * @see org.eclipselabs.damos.mscript.function.VariableDescription#getFunctionDescription
	 * @model opposite="functionDescription" containment="true"
	 * @generated
	 */
	EList<VariableDescription> getVariableDescriptions();

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

} // FunctionDescriptor
