/**
 * <copyright>
 * </copyright>
 *
 */
package com.yakindu.statechart.model.expressions.statechartexpressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time Constant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.yakindu.statechart.model.expressions.statechartexpressions.TimeConstant#getValue <em>Value</em>}</li>
 *   <li>{@link com.yakindu.statechart.model.expressions.statechartexpressions.TimeConstant#getUnit <em>Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.yakindu.statechart.model.expressions.statechartexpressions.StatechartexpressionsPackage#getTimeConstant()
 * @model
 * @generated
 */
public interface TimeConstant extends TimeExpression
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(int)
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.StatechartexpressionsPackage#getTimeConstant_Value()
   * @model
   * @generated
   */
  int getValue();

  /**
   * Sets the value of the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.TimeConstant#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(int value);

  /**
   * Returns the value of the '<em><b>Unit</b></em>' attribute.
   * The literals are from the enumeration {@link com.yakindu.statechart.model.expressions.statechartexpressions.TimeUnit}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unit</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unit</em>' attribute.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.TimeUnit
   * @see #setUnit(TimeUnit)
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.StatechartexpressionsPackage#getTimeConstant_Unit()
   * @model
   * @generated
   */
  TimeUnit getUnit();

  /**
   * Sets the value of the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.TimeConstant#getUnit <em>Unit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unit</em>' attribute.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.TimeUnit
   * @see #getUnit()
   * @generated
   */
  void setUnit(TimeUnit value);

} // TimeConstant
