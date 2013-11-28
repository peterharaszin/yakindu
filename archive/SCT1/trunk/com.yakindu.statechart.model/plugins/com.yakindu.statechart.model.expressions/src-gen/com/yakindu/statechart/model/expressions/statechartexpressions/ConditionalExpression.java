/**
 * <copyright>
 * </copyright>
 *
 */
package com.yakindu.statechart.model.expressions.statechartexpressions;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditional Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.yakindu.statechart.model.expressions.statechartexpressions.ConditionalExpression#getOperand1 <em>Operand1</em>}</li>
 *   <li>{@link com.yakindu.statechart.model.expressions.statechartexpressions.ConditionalExpression#getOperand2 <em>Operand2</em>}</li>
 *   <li>{@link com.yakindu.statechart.model.expressions.statechartexpressions.ConditionalExpression#getOperand3 <em>Operand3</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.yakindu.statechart.model.expressions.statechartexpressions.StatechartexpressionsPackage#getConditionalExpression()
 * @model
 * @generated
 */
public interface ConditionalExpression extends EObject
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
   * @see #setOperand1(BooleanOrExpression)
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.StatechartexpressionsPackage#getConditionalExpression_Operand1()
   * @model containment="true"
   * @generated
   */
  BooleanOrExpression getOperand1();

  /**
   * Sets the value of the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.ConditionalExpression#getOperand1 <em>Operand1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operand1</em>' containment reference.
   * @see #getOperand1()
   * @generated
   */
  void setOperand1(BooleanOrExpression value);

  /**
   * Returns the value of the '<em><b>Operand2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operand2</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operand2</em>' containment reference.
   * @see #setOperand2(ShiftExpression)
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.StatechartexpressionsPackage#getConditionalExpression_Operand2()
   * @model containment="true"
   * @generated
   */
  ShiftExpression getOperand2();

  /**
   * Sets the value of the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.ConditionalExpression#getOperand2 <em>Operand2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operand2</em>' containment reference.
   * @see #getOperand2()
   * @generated
   */
  void setOperand2(ShiftExpression value);

  /**
   * Returns the value of the '<em><b>Operand3</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operand3</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operand3</em>' containment reference.
   * @see #setOperand3(ShiftExpression)
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.StatechartexpressionsPackage#getConditionalExpression_Operand3()
   * @model containment="true"
   * @generated
   */
  ShiftExpression getOperand3();

  /**
   * Sets the value of the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.ConditionalExpression#getOperand3 <em>Operand3</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operand3</em>' containment reference.
   * @see #getOperand3()
   * @generated
   */
  void setOperand3(ShiftExpression value);

} // ConditionalExpression
