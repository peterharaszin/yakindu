/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.mscript.function;

import org.eclipse.damos.mscript.FeatureReference;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Equation Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.mscript.function.EquationPart#getSide <em>Side</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.function.EquationPart#getVariableReference <em>Variable Reference</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.function.EquationPart#getVariableStep <em>Variable Step</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.mscript.function.FunctionPackage#getEquationPart()
 * @model
 * @generated
 */
public interface EquationPart extends EObject {
	/**
	 * Returns the value of the '<em><b>Side</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.damos.mscript.function.EquationSide#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Side</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Side</em>' container reference.
	 * @see #setSide(EquationSide)
	 * @see org.eclipse.damos.mscript.function.FunctionPackage#getEquationPart_Side()
	 * @see org.eclipse.damos.mscript.function.EquationSide#getParts
	 * @model opposite="parts" transient="false"
	 * @generated
	 */
	EquationSide getSide();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.function.EquationPart#getSide <em>Side</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Side</em>' container reference.
	 * @see #getSide()
	 * @generated
	 */
	void setSide(EquationSide value);

	/**
	 * Returns the value of the '<em><b>Variable Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Access</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Reference</em>' reference.
	 * @see #setVariableReference(FeatureReference)
	 * @see org.eclipse.damos.mscript.function.FunctionPackage#getEquationPart_VariableReference()
	 * @model required="true"
	 * @generated
	 */
	FeatureReference getVariableReference();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.function.EquationPart#getVariableReference <em>Variable Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Reference</em>' reference.
	 * @see #getVariableReference()
	 * @generated
	 */
	void setVariableReference(FeatureReference value);

	/**
	 * Returns the value of the '<em><b>Variable Step</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.damos.mscript.function.VariableStep#getUsingEquationParts <em>Using Equation Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Step</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Step</em>' reference.
	 * @see #setVariableStep(VariableStep)
	 * @see org.eclipse.damos.mscript.function.FunctionPackage#getEquationPart_VariableStep()
	 * @see org.eclipse.damos.mscript.function.VariableStep#getUsingEquationParts
	 * @model opposite="usingEquationParts" required="true"
	 * @generated
	 */
	VariableStep getVariableStep();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.function.EquationPart#getVariableStep <em>Variable Step</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Step</em>' reference.
	 * @see #getVariableStep()
	 * @generated
	 */
	void setVariableStep(VariableStep value);

} // EquationPart
