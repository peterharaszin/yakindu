/**
 * <copyright>
 * </copyright>
 *
 */
package com.yakindu.statechart.model.expressions.statechartexpressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.yakindu.statechart.model.expressions.statechartexpressions.VariableAssignment#getVariableReference <em>Variable Reference</em>}</li>
 *   <li>{@link com.yakindu.statechart.model.expressions.statechartexpressions.VariableAssignment#getOperator <em>Operator</em>}</li>
 *   <li>{@link com.yakindu.statechart.model.expressions.statechartexpressions.VariableAssignment#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.yakindu.statechart.model.expressions.statechartexpressions.StatechartexpressionsPackage#getVariableAssignment()
 * @model
 * @generated
 */
public interface VariableAssignment extends Statement
{
  /**
   * Returns the value of the '<em><b>Variable Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variable Reference</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variable Reference</em>' containment reference.
   * @see #setVariableReference(VariableReference)
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.StatechartexpressionsPackage#getVariableAssignment_VariableReference()
   * @model containment="true"
   * @generated
   */
  VariableReference getVariableReference();

  /**
   * Sets the value of the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.VariableAssignment#getVariableReference <em>Variable Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable Reference</em>' containment reference.
   * @see #getVariableReference()
   * @generated
   */
  void setVariableReference(VariableReference value);

  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link com.yakindu.statechart.model.expressions.statechartexpressions.AssignmentOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.AssignmentOperator
   * @see #setOperator(AssignmentOperator)
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.StatechartexpressionsPackage#getVariableAssignment_Operator()
   * @model
   * @generated
   */
  AssignmentOperator getOperator();

  /**
   * Sets the value of the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.VariableAssignment#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.AssignmentOperator
   * @see #getOperator()
   * @generated
   */
  void setOperator(AssignmentOperator value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(ConditionalExpression)
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.StatechartexpressionsPackage#getVariableAssignment_Value()
   * @model containment="true"
   * @generated
   */
  ConditionalExpression getValue();

  /**
   * Sets the value of the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.VariableAssignment#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(ConditionalExpression value);

} // VariableAssignment
