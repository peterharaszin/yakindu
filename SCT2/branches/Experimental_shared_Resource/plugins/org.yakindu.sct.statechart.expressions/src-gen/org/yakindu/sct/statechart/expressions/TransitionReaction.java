/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.statechart.expressions;

import org.yakindu.model.sct.statechart.Reaction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition Reaction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.statechart.expressions.TransitionReaction#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getTransitionReaction()
 * @model
 * @generated
 */
public interface TransitionReaction extends Reaction
{
  /**
   * Returns the value of the '<em><b>Properties</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Properties</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Properties</em>' containment reference.
   * @see #setProperties(ReactionProperties)
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getTransitionReaction_Properties()
   * @model containment="true"
   * @generated
   */
  ReactionProperties getProperties();

  /**
   * Sets the value of the '{@link org.yakindu.sct.statechart.expressions.TransitionReaction#getProperties <em>Properties</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Properties</em>' containment reference.
   * @see #getProperties()
   * @generated
   */
  void setProperties(ReactionProperties value);

} // TransitionReaction
