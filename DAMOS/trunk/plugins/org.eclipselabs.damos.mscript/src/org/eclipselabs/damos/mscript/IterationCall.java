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
 * A representation of the model object '<em><b>Iteration Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.IterationCall#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.IterationCall#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.IterationCall#getIterationVariables <em>Iteration Variables</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.IterationCall#getAccumulator <em>Accumulator</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.IterationCall#getBreakCondition <em>Break Condition</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.IterationCall#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.MscriptPackage#getIterationCall()
 * @model
 * @generated
 */
public interface IterationCall extends Expression {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(Expression)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getIterationCall_Target()
	 * @model containment="true"
	 * @generated
	 */
	Expression getTarget();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.IterationCall#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Expression value);

	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' attribute.
	 * @see #setIdentifier(String)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getIterationCall_Identifier()
	 * @model
	 * @generated
	 */
	String getIdentifier();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.IterationCall#getIdentifier <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' attribute.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>Iteration Variables</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.IterationVariableDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iteration Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iteration Variables</em>' containment reference list.
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getIterationCall_IterationVariables()
	 * @model containment="true"
	 * @generated
	 */
	EList<IterationVariableDeclaration> getIterationVariables();

	/**
	 * Returns the value of the '<em><b>Accumulator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Accumulator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accumulator</em>' containment reference.
	 * @see #setAccumulator(IterationAccumulator)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getIterationCall_Accumulator()
	 * @model containment="true"
	 * @generated
	 */
	IterationAccumulator getAccumulator();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.IterationCall#getAccumulator <em>Accumulator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Accumulator</em>' containment reference.
	 * @see #getAccumulator()
	 * @generated
	 */
	void setAccumulator(IterationAccumulator value);

	/**
	 * Returns the value of the '<em><b>Break Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Break Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Break Condition</em>' containment reference.
	 * @see #setBreakCondition(Expression)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getIterationCall_BreakCondition()
	 * @model containment="true"
	 * @generated
	 */
	Expression getBreakCondition();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.IterationCall#getBreakCondition <em>Break Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Break Condition</em>' containment reference.
	 * @see #getBreakCondition()
	 * @generated
	 */
	void setBreakCondition(Expression value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(Expression)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getIterationCall_Expression()
	 * @model containment="true"
	 * @generated
	 */
	Expression getExpression();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.IterationCall#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Expression value);

} // IterationCall
