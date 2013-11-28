/**
 * <copyright>
 * </copyright>
 *
 */
package com.yakindu.statechart.model.expressions.statechartexpressions;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Equality Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.yakindu.statechart.model.expressions.statechartexpressions.EqualityExpression#getOperand1 <em>Operand1</em>}</li>
 *   <li>{@link com.yakindu.statechart.model.expressions.statechartexpressions.EqualityExpression#getOperator <em>Operator</em>}</li>
 *   <li>{@link com.yakindu.statechart.model.expressions.statechartexpressions.EqualityExpression#getOperand2 <em>Operand2</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.yakindu.statechart.model.expressions.statechartexpressions.StatechartexpressionsPackage#getEqualityExpression()
 * @model
 * @generated
 */
public interface EqualityExpression extends EObject
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
   * @see #setOperand1(RelationalExpression)
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.StatechartexpressionsPackage#getEqualityExpression_Operand1()
   * @model containment="true"
   * @generated
   */
  RelationalExpression getOperand1();

  /**
   * Sets the value of the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.EqualityExpression#getOperand1 <em>Operand1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operand1</em>' containment reference.
   * @see #getOperand1()
   * @generated
   */
  void setOperand1(RelationalExpression value);

  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link com.yakindu.statechart.model.expressions.statechartexpressions.EqualityOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.EqualityOperator
   * @see #setOperator(EqualityOperator)
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.StatechartexpressionsPackage#getEqualityExpression_Operator()
   * @model
   * @generated
   */
  EqualityOperator getOperator();

  /**
   * Sets the value of the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.EqualityExpression#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.EqualityOperator
   * @see #getOperator()
   * @generated
   */
  void setOperator(EqualityOperator value);

  /**
   * Returns the value of the '<em><b>Operand2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operand2</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operand2</em>' containment reference.
   * @see #setOperand2(RelationalExpression)
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.StatechartexpressionsPackage#getEqualityExpression_Operand2()
   * @model containment="true"
   * @generated
   */
  RelationalExpression getOperand2();

  /**
   * Sets the value of the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.EqualityExpression#getOperand2 <em>Operand2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operand2</em>' containment reference.
   * @see #getOperand2()
   * @generated
   */
  void setOperand2(RelationalExpression value);

} // EqualityExpression
