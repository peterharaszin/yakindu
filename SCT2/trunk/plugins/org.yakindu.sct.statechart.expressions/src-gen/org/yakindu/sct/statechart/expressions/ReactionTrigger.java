/**
 * <copyright>
 * </copyright>
 *
 */
package org.yakindu.sct.statechart.expressions;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.yakindu.model.sct.statechart.Event;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reaction Trigger</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.statechart.expressions.ReactionTrigger#getTriggers <em>Triggers</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.ReactionTrigger#getGuardExpression <em>Guard Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getReactionTrigger()
 * @model
 * @generated
 */
public interface ReactionTrigger extends EObject
{
  /**
   * Returns the value of the '<em><b>Triggers</b></em>' reference list.
   * The list contents are of type {@link org.yakindu.model.sct.statechart.Event}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Triggers</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Triggers</em>' reference list.
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getReactionTrigger_Triggers()
   * @model
   * @generated
   */
  EList<Event> getTriggers();

  /**
   * Returns the value of the '<em><b>Guard Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Guard Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Guard Expression</em>' containment reference.
   * @see #setGuardExpression(Expression)
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getReactionTrigger_GuardExpression()
   * @model containment="true"
   * @generated
   */
  Expression getGuardExpression();

  /**
   * Sets the value of the '{@link org.yakindu.sct.statechart.expressions.ReactionTrigger#getGuardExpression <em>Guard Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Guard Expression</em>' containment reference.
   * @see #getGuardExpression()
   * @generated
   */
  void setGuardExpression(Expression value);

} // ReactionTrigger
