/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.functionmodel;

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
 *   <li>{@link org.eclipselabs.damos.mscript.functionmodel.FunctionDescriptor#getDeclaration <em>Declaration</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.functionmodel.FunctionDescriptor#getEquationDescriptors <em>Equation Descriptors</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.functionmodel.FunctionDescriptor#getVariableDescriptors <em>Variable Descriptors</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionModelPackage#getFunctionDescriptor()
 * @model
 * @generated
 */
public interface FunctionDescriptor extends EObject {
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
	 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionModelPackage#getFunctionDescriptor_Declaration()
	 * @model required="true"
	 * @generated
	 */
	FunctionDeclaration getDeclaration();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.functionmodel.FunctionDescriptor#getDeclaration <em>Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declaration</em>' reference.
	 * @see #getDeclaration()
	 * @generated
	 */
	void setDeclaration(FunctionDeclaration value);

	/**
	 * Returns the value of the '<em><b>Equation Descriptors</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.functionmodel.EquationDescriptor}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.mscript.functionmodel.EquationDescriptor#getFunctionDescriptor <em>Function Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Equation Descriptors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Equation Descriptors</em>' containment reference list.
	 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionModelPackage#getFunctionDescriptor_EquationDescriptors()
	 * @see org.eclipselabs.damos.mscript.functionmodel.EquationDescriptor#getFunctionDescriptor
	 * @model opposite="functionDescriptor" containment="true"
	 * @generated
	 */
	EList<EquationDescriptor> getEquationDescriptors();

	/**
	 * Returns the value of the '<em><b>Variable Descriptors</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.functionmodel.VariableDescriptor}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.mscript.functionmodel.VariableDescriptor#getFunctionDescriptor <em>Function Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Descriptors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Descriptors</em>' containment reference list.
	 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionModelPackage#getFunctionDescriptor_VariableDescriptors()
	 * @see org.eclipselabs.damos.mscript.functionmodel.VariableDescriptor#getFunctionDescriptor
	 * @model opposite="functionDescriptor" containment="true"
	 * @generated
	 */
	EList<VariableDescriptor> getVariableDescriptors();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model nameRequired="true"
	 * @generated
	 */
	VariableDescriptor getVariableDescriptor(String name);

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
