/**
 * <copyright>
 * </copyright>
 *
 */
package org.yakindu.sct.statechart.expressions;

import org.yakindu.model.sct.statechart.Event;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.statechart.expressions.EventDefinition#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.EventDefinition#getType <em>Type</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.EventDefinition#getDerivation <em>Derivation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getEventDefinition()
 * @model
 * @generated
 */
public interface EventDefinition extends Event
{
  /**
   * Returns the value of the '<em><b>Direction</b></em>' attribute.
   * The literals are from the enumeration {@link org.yakindu.sct.statechart.expressions.Direction}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Direction</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Direction</em>' attribute.
   * @see org.yakindu.sct.statechart.expressions.Direction
   * @see #setDirection(Direction)
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getEventDefinition_Direction()
   * @model
   * @generated
   */
  Direction getDirection();

  /**
   * Sets the value of the '{@link org.yakindu.sct.statechart.expressions.EventDefinition#getDirection <em>Direction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Direction</em>' attribute.
   * @see org.yakindu.sct.statechart.expressions.Direction
   * @see #getDirection()
   * @generated
   */
  void setDirection(Direction value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.yakindu.sct.statechart.expressions.Type}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see org.yakindu.sct.statechart.expressions.Type
   * @see #setType(Type)
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getEventDefinition_Type()
   * @model
   * @generated
   */
  Type getType();

  /**
   * Sets the value of the '{@link org.yakindu.sct.statechart.expressions.EventDefinition#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see org.yakindu.sct.statechart.expressions.Type
   * @see #getType()
   * @generated
   */
  void setType(Type value);

  /**
   * Returns the value of the '<em><b>Derivation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Derivation</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Derivation</em>' containment reference.
   * @see #setDerivation(EventDerivation)
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getEventDefinition_Derivation()
   * @model containment="true"
   * @generated
   */
  EventDerivation getDerivation();

  /**
   * Sets the value of the '{@link org.yakindu.sct.statechart.expressions.EventDefinition#getDerivation <em>Derivation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Derivation</em>' containment reference.
   * @see #getDerivation()
   * @generated
   */
  void setDerivation(EventDerivation value);

} // EventDefinition
