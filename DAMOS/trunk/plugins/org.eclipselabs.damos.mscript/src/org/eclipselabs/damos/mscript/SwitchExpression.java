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
 * A representation of the model object '<em><b>Switch Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.SwitchExpression#isStatic <em>Static</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.SwitchExpression#getControlExpression <em>Control Expression</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.SwitchExpression#getCases <em>Cases</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.SwitchExpression#getDefaultExpression <em>Default Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.MscriptPackage#getSwitchExpression()
 * @model
 * @generated
 */
public interface SwitchExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Static</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Static</em>' attribute.
	 * @see #setStatic(boolean)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getSwitchExpression_Static()
	 * @model
	 * @generated
	 */
	boolean isStatic();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.SwitchExpression#isStatic <em>Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Static</em>' attribute.
	 * @see #isStatic()
	 * @generated
	 */
	void setStatic(boolean value);

	/**
	 * Returns the value of the '<em><b>Control Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Control Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Control Expression</em>' containment reference.
	 * @see #setControlExpression(Expression)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getSwitchExpression_ControlExpression()
	 * @model containment="true"
	 * @generated
	 */
	Expression getControlExpression();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.SwitchExpression#getControlExpression <em>Control Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Control Expression</em>' containment reference.
	 * @see #getControlExpression()
	 * @generated
	 */
	void setControlExpression(Expression value);

	/**
	 * Returns the value of the '<em><b>Cases</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.SwitchCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cases</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cases</em>' containment reference list.
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getSwitchExpression_Cases()
	 * @model containment="true"
	 * @generated
	 */
	EList<SwitchCase> getCases();

	/**
	 * Returns the value of the '<em><b>Default Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Expression</em>' containment reference.
	 * @see #setDefaultExpression(Expression)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getSwitchExpression_DefaultExpression()
	 * @model containment="true"
	 * @generated
	 */
	Expression getDefaultExpression();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.SwitchExpression#getDefaultExpression <em>Default Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Expression</em>' containment reference.
	 * @see #getDefaultExpression()
	 * @generated
	 */
	void setDefaultExpression(Expression value);

} // SwitchExpression
