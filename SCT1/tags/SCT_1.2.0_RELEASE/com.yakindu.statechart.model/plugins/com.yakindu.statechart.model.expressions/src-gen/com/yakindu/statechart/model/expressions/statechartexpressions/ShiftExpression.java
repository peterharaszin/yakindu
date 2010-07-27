/**
 * <copyright>
 * </copyright>
 *
 */
package com.yakindu.statechart.model.expressions.statechartexpressions;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Shift Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.yakindu.statechart.model.expressions.statechartexpressions.ShiftExpression#getOperand1 <em>Operand1</em>}</li>
 *   <li>{@link com.yakindu.statechart.model.expressions.statechartexpressions.ShiftExpression#getOperator <em>Operator</em>}</li>
 *   <li>{@link com.yakindu.statechart.model.expressions.statechartexpressions.ShiftExpression#getOperand2 <em>Operand2</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.yakindu.statechart.model.expressions.statechartexpressions.StatechartexpressionsPackage#getShiftExpression()
 * @model
 * @generated
 */
public interface ShiftExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Operand1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operand1</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operand1</em>' containment reference.
   * @see #setOperand1(AdditiveExpression)
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.StatechartexpressionsPackage#getShiftExpression_Operand1()
   * @model containment="true"
   * @generated
   */
  AdditiveExpression getOperand1();

  /**
   * Sets the value of the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.ShiftExpression#getOperand1 <em>Operand1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operand1</em>' containment reference.
   * @see #getOperand1()
   * @generated
   */
  void setOperand1(AdditiveExpression value);

  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link com.yakindu.statechart.model.expressions.statechartexpressions.ShiftOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.ShiftOperator
   * @see #setOperator(ShiftOperator)
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.StatechartexpressionsPackage#getShiftExpression_Operator()
   * @model
   * @generated
   */
  ShiftOperator getOperator();

  /**
   * Sets the value of the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.ShiftExpression#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.ShiftOperator
   * @see #getOperator()
   * @generated
   */
  void setOperator(ShiftOperator value);

  /**
   * Returns the value of the '<em><b>Operand2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operand2</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operand2</em>' containment reference.
   * @see #setOperand2(AdditiveExpression)
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.StatechartexpressionsPackage#getShiftExpression_Operand2()
   * @model containment="true"
   * @generated
   */
  AdditiveExpression getOperand2();

  /**
   * Sets the value of the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.ShiftExpression#getOperand2 <em>Operand2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operand2</em>' containment reference.
   * @see #getOperand2()
   * @generated
   */
  void setOperand2(AdditiveExpression value);

} // ShiftExpression
