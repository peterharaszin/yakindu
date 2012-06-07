/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Switch Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.SwitchCase#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.SwitchCase#getCaseExpression <em>Case Expression</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.SwitchCase#getResultExpression <em>Result Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.MscriptPackage#getSwitchCase()
 * @model
 * @generated
 */
public interface SwitchCase extends EObject {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.mscript.SwitchExpression#getCases <em>Cases</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(SwitchExpression)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getSwitchCase_Owner()
	 * @see org.eclipselabs.damos.mscript.SwitchExpression#getCases
	 * @model opposite="cases" transient="false"
	 * @generated
	 */
	SwitchExpression getOwner();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.SwitchCase#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(SwitchExpression value);

	/**
	 * Returns the value of the '<em><b>Case Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Case Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Case Expression</em>' containment reference.
	 * @see #setCaseExpression(Expression)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getSwitchCase_CaseExpression()
	 * @model containment="true"
	 * @generated
	 */
	Expression getCaseExpression();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.SwitchCase#getCaseExpression <em>Case Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Case Expression</em>' containment reference.
	 * @see #getCaseExpression()
	 * @generated
	 */
	void setCaseExpression(Expression value);

	/**
	 * Returns the value of the '<em><b>Result Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Expression</em>' containment reference.
	 * @see #setResultExpression(Expression)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getSwitchCase_ResultExpression()
	 * @model containment="true"
	 * @generated
	 */
	Expression getResultExpression();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.SwitchCase#getResultExpression <em>Result Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Expression</em>' containment reference.
	 * @see #getResultExpression()
	 * @generated
	 */
	void setResultExpression(Expression value);

} // SwitchCase
