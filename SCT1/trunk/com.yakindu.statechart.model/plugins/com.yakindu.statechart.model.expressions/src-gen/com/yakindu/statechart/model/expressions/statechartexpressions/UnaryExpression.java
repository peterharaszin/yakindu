/**
 * <copyright>
 * </copyright>
 *
 */
package com.yakindu.statechart.model.expressions.statechartexpressions;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.yakindu.statechart.model.expressions.statechartexpressions.UnaryExpression#getOperator <em>Operator</em>}</li>
 *   <li>{@link com.yakindu.statechart.model.expressions.statechartexpressions.UnaryExpression#getOperand <em>Operand</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.yakindu.statechart.model.expressions.statechartexpressions.StatechartexpressionsPackage#getUnaryExpression()
 * @model
 * @generated
 */
public interface UnaryExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link com.yakindu.statechart.model.expressions.statechartexpressions.UnaryOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.UnaryOperator
   * @see #setOperator(UnaryOperator)
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.StatechartexpressionsPackage#getUnaryExpression_Operator()
   * @model
   * @generated
   */
  UnaryOperator getOperator();

  /**
   * Sets the value of the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.UnaryExpression#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.UnaryOperator
   * @see #getOperator()
   * @generated
   */
  void setOperator(UnaryOperator value);

  /**
   * Returns the value of the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operand</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operand</em>' containment reference.
   * @see #setOperand(PrimaryExpression)
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.StatechartexpressionsPackage#getUnaryExpression_Operand()
   * @model containment="true"
   * @generated
   */
  PrimaryExpression getOperand();

  /**
   * Sets the value of the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.UnaryExpression#getOperand <em>Operand</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operand</em>' containment reference.
   * @see #getOperand()
   * @generated
   */
  void setOperand(PrimaryExpression value);

} // UnaryExpression
