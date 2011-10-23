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
import org.eclipselabs.damos.mscript.Equation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Equation Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.functionmodel.EquationDescriptor#getFunctionDescriptor <em>Function Descriptor</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.functionmodel.EquationDescriptor#getEquation <em>Equation</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.functionmodel.EquationDescriptor#getSides <em>Sides</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.functionmodel.EquationDescriptor#getLeftHandSide <em>Left Hand Side</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.functionmodel.EquationDescriptor#getRightHandSide <em>Right Hand Side</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionModelPackage#getEquationDescriptor()
 * @model
 * @generated
 */
public interface EquationDescriptor extends EObject {
	/**
	 * Returns the value of the '<em><b>Function Descriptor</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.mscript.functionmodel.FunctionDescriptor#getEquationDescriptors <em>Equation Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Descriptor</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Descriptor</em>' container reference.
	 * @see #setFunctionDescriptor(FunctionDescriptor)
	 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionModelPackage#getEquationDescriptor_FunctionDescriptor()
	 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionDescriptor#getEquationDescriptors
	 * @model opposite="equationDescriptors" required="true" transient="false"
	 * @generated
	 */
	FunctionDescriptor getFunctionDescriptor();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.functionmodel.EquationDescriptor#getFunctionDescriptor <em>Function Descriptor</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function Descriptor</em>' container reference.
	 * @see #getFunctionDescriptor()
	 * @generated
	 */
	void setFunctionDescriptor(FunctionDescriptor value);

	/**
	 * Returns the value of the '<em><b>Equation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Equation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Equation</em>' reference.
	 * @see #setEquation(Equation)
	 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionModelPackage#getEquationDescriptor_Equation()
	 * @model required="true"
	 * @generated
	 */
	Equation getEquation();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.functionmodel.EquationDescriptor#getEquation <em>Equation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Equation</em>' reference.
	 * @see #getEquation()
	 * @generated
	 */
	void setEquation(Equation value);

	/**
	 * Returns the value of the '<em><b>Sides</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.functionmodel.EquationSide}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.mscript.functionmodel.EquationSide#getDescriptor <em>Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sides</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sides</em>' containment reference list.
	 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionModelPackage#getEquationDescriptor_Sides()
	 * @see org.eclipselabs.damos.mscript.functionmodel.EquationSide#getDescriptor
	 * @model opposite="descriptor" containment="true" lower="2" upper="2"
	 * @generated
	 */
	EList<EquationSide> getSides();

	/**
	 * Returns the value of the '<em><b>Left Hand Side</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Hand Side</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Hand Side</em>' reference.
	 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionModelPackage#getEquationDescriptor_LeftHandSide()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EquationSide getLeftHandSide();

	/**
	 * Returns the value of the '<em><b>Right Hand Side</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Hand Side</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Hand Side</em>' reference.
	 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionModelPackage#getEquationDescriptor_RightHandSide()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EquationSide getRightHandSide();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean isLeftHandSideValid(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean isRightHandSideValid(DiagnosticChain diagnostics, Map<Object, Object> context);

} // EquationDescriptor
