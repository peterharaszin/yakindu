/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.functionmodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.functionmodel.VariableStep#getVariableDescription <em>Variable Description</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.functionmodel.VariableStep#getIndex <em>Index</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.functionmodel.VariableStep#isInitial <em>Initial</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.functionmodel.VariableStep#isDerivative <em>Derivative</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.functionmodel.VariableStep#getUsingEquationParts <em>Using Equation Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionModelPackage#getVariableStep()
 * @model
 * @generated
 */
public interface VariableStep extends EObject {
	/**
	 * Returns the value of the '<em><b>Variable Description</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.mscript.functionmodel.VariableDescription#getSteps <em>Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Descriptor</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Description</em>' container reference.
	 * @see #setVariableDescription(VariableDescription)
	 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionModelPackage#getVariableStep_VariableDescription()
	 * @see org.eclipselabs.damos.mscript.functionmodel.VariableDescription#getSteps
	 * @model opposite="steps" transient="false"
	 * @generated
	 */
	VariableDescription getVariableDescription();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.functionmodel.VariableStep#getVariableDescription <em>Variable Description</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Description</em>' container reference.
	 * @see #getVariableDescription()
	 * @generated
	 */
	void setVariableDescription(VariableDescription value);

	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #setIndex(int)
	 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionModelPackage#getVariableStep_Index()
	 * @model
	 * @generated
	 */
	int getIndex();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.functionmodel.VariableStep#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(int value);

	/**
	 * Returns the value of the '<em><b>Initial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial</em>' attribute.
	 * @see #setInitial(boolean)
	 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionModelPackage#getVariableStep_Initial()
	 * @model
	 * @generated
	 */
	boolean isInitial();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.functionmodel.VariableStep#isInitial <em>Initial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial</em>' attribute.
	 * @see #isInitial()
	 * @generated
	 */
	void setInitial(boolean value);

	/**
	 * Returns the value of the '<em><b>Derivative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derivative</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derivative</em>' attribute.
	 * @see #setDerivative(boolean)
	 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionModelPackage#getVariableStep_Derivative()
	 * @model
	 * @generated
	 */
	boolean isDerivative();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.functionmodel.VariableStep#isDerivative <em>Derivative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Derivative</em>' attribute.
	 * @see #isDerivative()
	 * @generated
	 */
	void setDerivative(boolean value);

	/**
	 * Returns the value of the '<em><b>Using Equation Parts</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.functionmodel.EquationPart}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.mscript.functionmodel.EquationPart#getVariableStep <em>Variable Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Using Equation Parts</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Using Equation Parts</em>' reference list.
	 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionModelPackage#getVariableStep_UsingEquationParts()
	 * @see org.eclipselabs.damos.mscript.functionmodel.EquationPart#getVariableStep
	 * @model opposite="variableStep"
	 * @generated
	 */
	EList<EquationPart> getUsingEquationParts();

} // VariableStep
