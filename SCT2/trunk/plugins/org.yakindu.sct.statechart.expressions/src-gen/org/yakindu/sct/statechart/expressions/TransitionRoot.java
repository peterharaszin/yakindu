/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.statechart.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.statechart.expressions.TransitionRoot#getDef <em>Def</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getTransitionRoot()
 * @model
 * @generated
 */
public interface TransitionRoot extends DefRoot
{
  /**
   * Returns the value of the '<em><b>Def</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Def</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Def</em>' containment reference.
   * @see #setDef(TransitionStatement)
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getTransitionRoot_Def()
   * @model containment="true"
   * @generated
   */
  TransitionStatement getDef();

  /**
   * Sets the value of the '{@link org.yakindu.sct.statechart.expressions.TransitionRoot#getDef <em>Def</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Def</em>' containment reference.
   * @see #getDef()
   * @generated
   */
  void setDef(TransitionStatement value);

} // TransitionRoot
