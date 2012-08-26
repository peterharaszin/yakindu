/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.function;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.mscript.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Equation Side</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.function.EquationSide#getEquationDescription <em>Equation Description</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.function.EquationSide#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.function.EquationSide#getParts <em>Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.function.FunctionModelPackage#getEquationSide()
 * @model
 * @generated
 */
public interface EquationSide extends EObject {
	/**
	 * Returns the value of the '<em><b>Equation Description</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.mscript.function.EquationDescription#getSides <em>Sides</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Descriptor</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Equation Description</em>' container reference.
	 * @see #setEquationDescription(EquationDescription)
	 * @see org.eclipselabs.damos.mscript.function.FunctionModelPackage#getEquationSide_EquationDescription()
	 * @see org.eclipselabs.damos.mscript.function.EquationDescription#getSides
	 * @model opposite="sides" required="true" transient="false"
	 * @generated
	 */
	EquationDescription getEquationDescription();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.function.EquationSide#getEquationDescription <em>Equation Description</em>}' container reference.
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
	 * @see org.eclipselabs.damos.mscript.function.FunctionModelPackage#getEquationSide_Expression()
	 * @model required="true"
	 * @generated
	 */
	Expression getExpression();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.function.EquationSide#getExpression <em>Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Expression value);

	/**
	 * Returns the value of the '<em><b>Parts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.function.EquationPart}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.mscript.function.EquationPart#getSide <em>Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parts</em>' containment reference list.
	 * @see org.eclipselabs.damos.mscript.function.FunctionModelPackage#getEquationSide_Parts()
	 * @see org.eclipselabs.damos.mscript.function.EquationPart#getSide
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
