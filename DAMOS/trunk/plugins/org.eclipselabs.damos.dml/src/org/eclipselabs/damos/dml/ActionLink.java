/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.ActionLink#getChoice <em>Choice</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.ActionLink#getAction <em>Action</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.ActionLink#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dml.DMLPackage#getActionLink()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ChoiceAndActionHaveSameOwner'"
 * @generated
 */
public interface ActionLink extends EObject {
	/**
	 * Returns the value of the '<em><b>Choice</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.dml.Choice#getActionLinks <em>Action Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Choice</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Choice</em>' container reference.
	 * @see #setChoice(Choice)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getActionLink_Choice()
	 * @see org.eclipselabs.damos.dml.Choice#getActionLinks
	 * @model opposite="actionLinks" required="true" transient="false"
	 * @generated
	 */
	Choice getChoice();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.ActionLink#getChoice <em>Choice</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Choice</em>' container reference.
	 * @see #getChoice()
	 * @generated
	 */
	void setChoice(Choice value);

	/**
	 * Returns the value of the '<em><b>Action</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.dml.Action#getLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' reference.
	 * @see #setAction(Action)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getActionLink_Action()
	 * @see org.eclipselabs.damos.dml.Action#getLink
	 * @model opposite="link" required="true"
	 * @generated
	 */
	Action getAction();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.ActionLink#getAction <em>Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' reference.
	 * @see #getAction()
	 * @generated
	 */
	void setAction(Action value);

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(ValueSpecification)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getActionLink_Condition()
	 * @model containment="true"
	 * @generated
	 */
	ValueSpecification getCondition();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.ActionLink#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(ValueSpecification value);

} // ActionLink
