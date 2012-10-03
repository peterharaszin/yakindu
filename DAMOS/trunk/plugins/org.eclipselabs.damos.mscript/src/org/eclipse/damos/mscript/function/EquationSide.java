/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.mscript.function;

import org.eclipse.damos.mscript.Expression;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Equation Side</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.mscript.function.EquationSide#getEquationDescription <em>Equation Description</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.function.EquationSide#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.function.EquationSide#getParts <em>Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.mscript.function.FunctionPackage#getEquationSide()
 * @model
 * @generated
 */
public interface EquationSide extends EObject {
	/**
	 * Returns the value of the '<em><b>Equation Description</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.damos.mscript.function.EquationDescription#getSides <em>Sides</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Descriptor</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Equation Description</em>' container reference.
	 * @see #setEquationDescription(EquationDescription)
	 * @see org.eclipse.damos.mscript.function.FunctionPackage#getEquationSide_EquationDescription()
	 * @see org.eclipse.damos.mscript.function.EquationDescription#getSides
	 * @model opposite="sides" required="true" transient="false"
	 * @generated
	 */
	EquationDescription getEquationDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.function.EquationSide#getEquationDescription <em>Equation Description</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Equation Description</em>' container reference.
	 * @see #getEquationDescription()
	 * @generated
	 */
	void setEquationDescription(EquationDescription value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' reference.
	 * @see #setExpression(Expression)
	 * @see org.eclipse.damos.mscript.function.FunctionPackage#getEquationSide_Expression()
	 * @model required="true"
	 * @generated
	 */
	Expression getExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.function.EquationSide#getExpression <em>Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Expression value);

	/**
	 * Returns the value of the '<em><b>Parts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.mscript.function.EquationPart}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.damos.mscript.function.EquationPart#getSide <em>Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parts</em>' containment reference list.
	 * @see org.eclipse.damos.mscript.function.FunctionPackage#getEquationSide_Parts()
	 * @see org.eclipse.damos.mscript.function.EquationPart#getSide
	 * @model opposite="side" containment="true"
	 * @generated
	 */
	EList<EquationPart> getParts();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	EquationSide getOtherSide();

} // EquationSide
