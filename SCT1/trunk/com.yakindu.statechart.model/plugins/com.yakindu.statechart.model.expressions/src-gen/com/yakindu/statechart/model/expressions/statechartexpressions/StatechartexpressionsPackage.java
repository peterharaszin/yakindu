/**
 * <copyright>
 * </copyright>
 *
 */
package com.yakindu.statechart.model.expressions.statechartexpressions;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.yakindu.statechart.model.expressions.statechartexpressions.StatechartexpressionsFactory
 * @model kind="package"
 * @generated
 */
public interface StatechartexpressionsPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "statechartexpressions";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.yakindu.com/statechart/model/expressions";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "statechartexpressions";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  StatechartexpressionsPackage eINSTANCE = com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl.init();

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.ExpressionImpl
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 0;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.TriggerExpressionImpl <em>Trigger Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.TriggerExpressionImpl
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getTriggerExpression()
   * @generated
   */
  int TRIGGER_EXPRESSION = 1;

  /**
   * The feature id for the '<em><b>Triggers</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGER_EXPRESSION__TRIGGERS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Trigger Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGER_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.GuardExpressionImpl <em>Guard Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.GuardExpressionImpl
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getGuardExpression()
   * @generated
   */
  int GUARD_EXPRESSION = 2;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD_EXPRESSION__EXPRESSION = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Guard Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.ActionExpressionImpl <em>Action Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.ActionExpressionImpl
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getActionExpression()
   * @generated
   */
  int ACTION_EXPRESSION = 3;

  /**
   * The feature id for the '<em><b>Statement</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION_EXPRESSION__STATEMENT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Action Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.TriggerImpl <em>Trigger</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.TriggerImpl
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getTrigger()
   * @generated
   */
  int TRIGGER = 4;

  /**
   * The feature id for the '<em><b>Event</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGER__EVENT = 0;

  /**
   * The number of structural features of the '<em>Trigger</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIGGER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.EventImpl <em>Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.EventImpl
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getEvent()
   * @generated
   */
  int EVENT = 5;

  /**
   * The number of structural features of the '<em>Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.SignalEventImpl <em>Signal Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.SignalEventImpl
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getSignalEvent()
   * @generated
   */
  int SIGNAL_EVENT = 6;

  /**
   * The feature id for the '<em><b>Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIGNAL_EVENT__IDENTIFIER = EVENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Signal Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIGNAL_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.TimeEventImpl <em>Time Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.TimeEventImpl
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getTimeEvent()
   * @generated
   */
  int TIME_EVENT = 7;

  /**
   * The feature id for the '<em><b>Duration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_EVENT__DURATION = EVENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Time Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.TimeExpressionImpl <em>Time Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.TimeExpressionImpl
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getTimeExpression()
   * @generated
   */
  int TIME_EXPRESSION = 8;

  /**
   * The number of structural features of the '<em>Time Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.VariableReferenceImpl <em>Variable Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.VariableReferenceImpl
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getVariableReference()
   * @generated
   */
  int VARIABLE_REFERENCE = 9;

  /**
   * The feature id for the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_REFERENCE__VARIABLE = TIME_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Variable Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_REFERENCE_FEATURE_COUNT = TIME_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.VariableImpl <em>Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.VariableImpl
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getVariable()
   * @generated
   */
  int VARIABLE = 10;

  /**
   * The feature id for the '<em><b>Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__IDENTIFIER = 0;

  /**
   * The number of structural features of the '<em>Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.TimeConstantImpl <em>Time Constant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.TimeConstantImpl
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getTimeConstant()
   * @generated
   */
  int TIME_CONSTANT = 11;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_CONSTANT__VALUE = TIME_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Unit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_CONSTANT__UNIT = TIME_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Time Constant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_CONSTANT_FEATURE_COUNT = TIME_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatementImpl <em>Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatementImpl
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getStatement()
   * @generated
   */
  int STATEMENT = 12;

  /**
   * The number of structural features of the '<em>Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.VariableAssignmentImpl <em>Variable Assignment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.VariableAssignmentImpl
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getVariableAssignment()
   * @generated
   */
  int VARIABLE_ASSIGNMENT = 13;

  /**
   * The feature id for the '<em><b>Variable Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_ASSIGNMENT__VARIABLE_REFERENCE = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_ASSIGNMENT__OPERATOR = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_ASSIGNMENT__VALUE = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Variable Assignment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_ASSIGNMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.ProcedureCallImpl <em>Procedure Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.ProcedureCallImpl
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getProcedureCall()
   * @generated
   */
  int PROCEDURE_CALL = 14;

  /**
   * The feature id for the '<em><b>Procedure</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROCEDURE_CALL__PROCEDURE = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Procedure Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROCEDURE_CALL_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.ProcedureImpl <em>Procedure</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.ProcedureImpl
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getProcedure()
   * @generated
   */
  int PROCEDURE = 15;

  /**
   * The feature id for the '<em><b>Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROCEDURE__IDENTIFIER = 0;

  /**
   * The number of structural features of the '<em>Procedure</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROCEDURE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.EventRaisingImpl <em>Event Raising</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.EventRaisingImpl
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getEventRaising()
   * @generated
   */
  int EVENT_RAISING = 16;

  /**
   * The feature id for the '<em><b>Event</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_RAISING__EVENT = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Event Raising</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_RAISING_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.BooleanOrExpressionImpl <em>Boolean Or Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.BooleanOrExpressionImpl
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getBooleanOrExpression()
   * @generated
   */
  int BOOLEAN_OR_EXPRESSION = 17;

  /**
   * The feature id for the '<em><b>Operand1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_OR_EXPRESSION__OPERAND1 = 0;

  /**
   * The feature id for the '<em><b>Operand2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_OR_EXPRESSION__OPERAND2 = 1;

  /**
   * The number of structural features of the '<em>Boolean Or Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_OR_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.BooleanAndExpressionImpl <em>Boolean And Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.BooleanAndExpressionImpl
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getBooleanAndExpression()
   * @generated
   */
  int BOOLEAN_AND_EXPRESSION = 18;

  /**
   * The feature id for the '<em><b>Operand1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_AND_EXPRESSION__OPERAND1 = 0;

  /**
   * The feature id for the '<em><b>Operand2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_AND_EXPRESSION__OPERAND2 = 1;

  /**
   * The number of structural features of the '<em>Boolean And Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_AND_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.BitwiseXorExpressionImpl <em>Bitwise Xor Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.BitwiseXorExpressionImpl
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getBitwiseXorExpression()
   * @generated
   */
  int BITWISE_XOR_EXPRESSION = 19;

  /**
   * The feature id for the '<em><b>Operand1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BITWISE_XOR_EXPRESSION__OPERAND1 = 0;

  /**
   * The feature id for the '<em><b>Operand2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BITWISE_XOR_EXPRESSION__OPERAND2 = 1;

  /**
   * The number of structural features of the '<em>Bitwise Xor Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BITWISE_XOR_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.BitwiseOrExpressionImpl <em>Bitwise Or Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.BitwiseOrExpressionImpl
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getBitwiseOrExpression()
   * @generated
   */
  int BITWISE_OR_EXPRESSION = 20;

  /**
   * The feature id for the '<em><b>Operand1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BITWISE_OR_EXPRESSION__OPERAND1 = 0;

  /**
   * The feature id for the '<em><b>Operand2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BITWISE_OR_EXPRESSION__OPERAND2 = 1;

  /**
   * The number of structural features of the '<em>Bitwise Or Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BITWISE_OR_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.BitwiseAndExpressionImpl <em>Bitwise And Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.BitwiseAndExpressionImpl
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getBitwiseAndExpression()
   * @generated
   */
  int BITWISE_AND_EXPRESSION = 21;

  /**
   * The feature id for the '<em><b>Operand1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BITWISE_AND_EXPRESSION__OPERAND1 = 0;

  /**
   * The feature id for the '<em><b>Operand2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BITWISE_AND_EXPRESSION__OPERAND2 = 1;

  /**
   * The number of structural features of the '<em>Bitwise And Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BITWISE_AND_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.EqualityExpressionImpl <em>Equality Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.EqualityExpressionImpl
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getEqualityExpression()
   * @generated
   */
  int EQUALITY_EXPRESSION = 22;

  /**
   * The feature id for the '<em><b>Operand1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION__OPERAND1 = 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION__OPERATOR = 1;

  /**
   * The feature id for the '<em><b>Operand2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION__OPERAND2 = 2;

  /**
   * The number of structural features of the '<em>Equality Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.RelationalExpressionImpl <em>Relational Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.RelationalExpressionImpl
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getRelationalExpression()
   * @generated
   */
  int RELATIONAL_EXPRESSION = 23;

  /**
   * The feature id for the '<em><b>Operand1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__OPERAND1 = 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__OPERATOR = 1;

  /**
   * The feature id for the '<em><b>Operand2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__OPERAND2 = 2;

  /**
   * The number of structural features of the '<em>Relational Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.ConditionalExpressionImpl <em>Conditional Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.ConditionalExpressionImpl
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getConditionalExpression()
   * @generated
   */
  int CONDITIONAL_EXPRESSION = 24;

  /**
   * The feature id for the '<em><b>Operand1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION__OPERAND1 = 0;

  /**
   * The feature id for the '<em><b>Operand2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION__OPERAND2 = 1;

  /**
   * The feature id for the '<em><b>Operand3</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION__OPERAND3 = 2;

  /**
   * The number of structural features of the '<em>Conditional Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.ShiftExpressionImpl <em>Shift Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.ShiftExpressionImpl
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getShiftExpression()
   * @generated
   */
  int SHIFT_EXPRESSION = 25;

  /**
   * The feature id for the '<em><b>Operand1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHIFT_EXPRESSION__OPERAND1 = 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHIFT_EXPRESSION__OPERATOR = 1;

  /**
   * The feature id for the '<em><b>Operand2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHIFT_EXPRESSION__OPERAND2 = 2;

  /**
   * The number of structural features of the '<em>Shift Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHIFT_EXPRESSION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.AdditiveExpressionImpl <em>Additive Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.AdditiveExpressionImpl
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getAdditiveExpression()
   * @generated
   */
  int ADDITIVE_EXPRESSION = 26;

  /**
   * The feature id for the '<em><b>Operand1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION__OPERAND1 = 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION__OPERATOR = 1;

  /**
   * The feature id for the '<em><b>Operand2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION__OPERAND2 = 2;

  /**
   * The number of structural features of the '<em>Additive Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.MultiplicativeExpressionImpl <em>Multiplicative Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.MultiplicativeExpressionImpl
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getMultiplicativeExpression()
   * @generated
   */
  int MULTIPLICATIVE_EXPRESSION = 27;

  /**
   * The feature id for the '<em><b>Operand1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION__OPERAND1 = 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION__OPERATOR = 1;

  /**
   * The feature id for the '<em><b>Operand2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION__OPERAND2 = 2;

  /**
   * The number of structural features of the '<em>Multiplicative Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.UnaryExpressionImpl
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getUnaryExpression()
   * @generated
   */
  int UNARY_EXPRESSION = 28;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION__OPERATOR = 0;

  /**
   * The feature id for the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION__OPERAND = 1;

  /**
   * The number of structural features of the '<em>Unary Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.PrimaryExpressionImpl <em>Primary Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.PrimaryExpressionImpl
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getPrimaryExpression()
   * @generated
   */
  int PRIMARY_EXPRESSION = 29;

  /**
   * The number of structural features of the '<em>Primary Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.NestedExpressionImpl <em>Nested Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.NestedExpressionImpl
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getNestedExpression()
   * @generated
   */
  int NESTED_EXPRESSION = 30;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_EXPRESSION__EXPRESSION = PRIMARY_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Nested Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_EXPRESSION_FEATURE_COUNT = PRIMARY_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.LiteralValueImpl <em>Literal Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.LiteralValueImpl
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getLiteralValue()
   * @generated
   */
  int LITERAL_VALUE = 31;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_VALUE__VALUE = PRIMARY_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Literal Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_VALUE_FEATURE_COUNT = PRIMARY_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.TimeUnit <em>Time Unit</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.TimeUnit
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getTimeUnit()
   * @generated
   */
  int TIME_UNIT = 32;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.AssignmentOperator <em>Assignment Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.AssignmentOperator
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getAssignmentOperator()
   * @generated
   */
  int ASSIGNMENT_OPERATOR = 33;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.EqualityOperator <em>Equality Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.EqualityOperator
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getEqualityOperator()
   * @generated
   */
  int EQUALITY_OPERATOR = 34;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.RelationalOperator <em>Relational Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.RelationalOperator
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getRelationalOperator()
   * @generated
   */
  int RELATIONAL_OPERATOR = 35;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.ShiftOperator <em>Shift Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.ShiftOperator
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getShiftOperator()
   * @generated
   */
  int SHIFT_OPERATOR = 36;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.AdditiveOperator <em>Additive Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.AdditiveOperator
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getAdditiveOperator()
   * @generated
   */
  int ADDITIVE_OPERATOR = 37;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.MultiplicativeOperator <em>Multiplicative Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.MultiplicativeOperator
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getMultiplicativeOperator()
   * @generated
   */
  int MULTIPLICATIVE_OPERATOR = 38;

  /**
   * The meta object id for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.UnaryOperator <em>Unary Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.UnaryOperator
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getUnaryOperator()
   * @generated
   */
  int UNARY_OPERATOR = 39;


  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.model.expressions.statechartexpressions.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.model.expressions.statechartexpressions.TriggerExpression <em>Trigger Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trigger Expression</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.TriggerExpression
   * @generated
   */
  EClass getTriggerExpression();

  /**
   * Returns the meta object for the containment reference list '{@link com.yakindu.statechart.model.expressions.statechartexpressions.TriggerExpression#getTriggers <em>Triggers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Triggers</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.TriggerExpression#getTriggers()
   * @see #getTriggerExpression()
   * @generated
   */
  EReference getTriggerExpression_Triggers();

  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.model.expressions.statechartexpressions.GuardExpression <em>Guard Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Guard Expression</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.GuardExpression
   * @generated
   */
  EClass getGuardExpression();

  /**
   * Returns the meta object for the containment reference '{@link com.yakindu.statechart.model.expressions.statechartexpressions.GuardExpression#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.GuardExpression#getExpression()
   * @see #getGuardExpression()
   * @generated
   */
  EReference getGuardExpression_Expression();

  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.model.expressions.statechartexpressions.ActionExpression <em>Action Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Action Expression</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.ActionExpression
   * @generated
   */
  EClass getActionExpression();

  /**
   * Returns the meta object for the containment reference list '{@link com.yakindu.statechart.model.expressions.statechartexpressions.ActionExpression#getStatement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statement</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.ActionExpression#getStatement()
   * @see #getActionExpression()
   * @generated
   */
  EReference getActionExpression_Statement();

  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.model.expressions.statechartexpressions.Trigger <em>Trigger</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trigger</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.Trigger
   * @generated
   */
  EClass getTrigger();

  /**
   * Returns the meta object for the containment reference '{@link com.yakindu.statechart.model.expressions.statechartexpressions.Trigger#getEvent <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Event</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.Trigger#getEvent()
   * @see #getTrigger()
   * @generated
   */
  EReference getTrigger_Event();

  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.model.expressions.statechartexpressions.Event <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.Event
   * @generated
   */
  EClass getEvent();

  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.model.expressions.statechartexpressions.SignalEvent <em>Signal Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Signal Event</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.SignalEvent
   * @generated
   */
  EClass getSignalEvent();

  /**
   * Returns the meta object for the attribute '{@link com.yakindu.statechart.model.expressions.statechartexpressions.SignalEvent#getIdentifier <em>Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Identifier</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.SignalEvent#getIdentifier()
   * @see #getSignalEvent()
   * @generated
   */
  EAttribute getSignalEvent_Identifier();

  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.model.expressions.statechartexpressions.TimeEvent <em>Time Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Time Event</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.TimeEvent
   * @generated
   */
  EClass getTimeEvent();

  /**
   * Returns the meta object for the containment reference '{@link com.yakindu.statechart.model.expressions.statechartexpressions.TimeEvent#getDuration <em>Duration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Duration</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.TimeEvent#getDuration()
   * @see #getTimeEvent()
   * @generated
   */
  EReference getTimeEvent_Duration();

  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.model.expressions.statechartexpressions.TimeExpression <em>Time Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Time Expression</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.TimeExpression
   * @generated
   */
  EClass getTimeExpression();

  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.model.expressions.statechartexpressions.VariableReference <em>Variable Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable Reference</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.VariableReference
   * @generated
   */
  EClass getVariableReference();

  /**
   * Returns the meta object for the containment reference '{@link com.yakindu.statechart.model.expressions.statechartexpressions.VariableReference#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Variable</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.VariableReference#getVariable()
   * @see #getVariableReference()
   * @generated
   */
  EReference getVariableReference_Variable();

  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.model.expressions.statechartexpressions.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.Variable
   * @generated
   */
  EClass getVariable();

  /**
   * Returns the meta object for the attribute '{@link com.yakindu.statechart.model.expressions.statechartexpressions.Variable#getIdentifier <em>Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Identifier</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.Variable#getIdentifier()
   * @see #getVariable()
   * @generated
   */
  EAttribute getVariable_Identifier();

  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.model.expressions.statechartexpressions.TimeConstant <em>Time Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Time Constant</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.TimeConstant
   * @generated
   */
  EClass getTimeConstant();

  /**
   * Returns the meta object for the attribute '{@link com.yakindu.statechart.model.expressions.statechartexpressions.TimeConstant#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.TimeConstant#getValue()
   * @see #getTimeConstant()
   * @generated
   */
  EAttribute getTimeConstant_Value();

  /**
   * Returns the meta object for the attribute '{@link com.yakindu.statechart.model.expressions.statechartexpressions.TimeConstant#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unit</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.TimeConstant#getUnit()
   * @see #getTimeConstant()
   * @generated
   */
  EAttribute getTimeConstant_Unit();

  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.model.expressions.statechartexpressions.Statement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statement</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.Statement
   * @generated
   */
  EClass getStatement();

  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.model.expressions.statechartexpressions.VariableAssignment <em>Variable Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable Assignment</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.VariableAssignment
   * @generated
   */
  EClass getVariableAssignment();

  /**
   * Returns the meta object for the containment reference '{@link com.yakindu.statechart.model.expressions.statechartexpressions.VariableAssignment#getVariableReference <em>Variable Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Variable Reference</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.VariableAssignment#getVariableReference()
   * @see #getVariableAssignment()
   * @generated
   */
  EReference getVariableAssignment_VariableReference();

  /**
   * Returns the meta object for the attribute '{@link com.yakindu.statechart.model.expressions.statechartexpressions.VariableAssignment#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.VariableAssignment#getOperator()
   * @see #getVariableAssignment()
   * @generated
   */
  EAttribute getVariableAssignment_Operator();

  /**
   * Returns the meta object for the containment reference '{@link com.yakindu.statechart.model.expressions.statechartexpressions.VariableAssignment#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.VariableAssignment#getValue()
   * @see #getVariableAssignment()
   * @generated
   */
  EReference getVariableAssignment_Value();

  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.model.expressions.statechartexpressions.ProcedureCall <em>Procedure Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Procedure Call</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.ProcedureCall
   * @generated
   */
  EClass getProcedureCall();

  /**
   * Returns the meta object for the containment reference '{@link com.yakindu.statechart.model.expressions.statechartexpressions.ProcedureCall#getProcedure <em>Procedure</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Procedure</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.ProcedureCall#getProcedure()
   * @see #getProcedureCall()
   * @generated
   */
  EReference getProcedureCall_Procedure();

  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.model.expressions.statechartexpressions.Procedure <em>Procedure</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Procedure</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.Procedure
   * @generated
   */
  EClass getProcedure();

  /**
   * Returns the meta object for the attribute '{@link com.yakindu.statechart.model.expressions.statechartexpressions.Procedure#getIdentifier <em>Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Identifier</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.Procedure#getIdentifier()
   * @see #getProcedure()
   * @generated
   */
  EAttribute getProcedure_Identifier();

  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.model.expressions.statechartexpressions.EventRaising <em>Event Raising</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event Raising</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.EventRaising
   * @generated
   */
  EClass getEventRaising();

  /**
   * Returns the meta object for the containment reference '{@link com.yakindu.statechart.model.expressions.statechartexpressions.EventRaising#getEvent <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Event</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.EventRaising#getEvent()
   * @see #getEventRaising()
   * @generated
   */
  EReference getEventRaising_Event();

  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.model.expressions.statechartexpressions.BooleanOrExpression <em>Boolean Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Or Expression</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.BooleanOrExpression
   * @generated
   */
  EClass getBooleanOrExpression();

  /**
   * Returns the meta object for the containment reference '{@link com.yakindu.statechart.model.expressions.statechartexpressions.BooleanOrExpression#getOperand1 <em>Operand1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand1</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.BooleanOrExpression#getOperand1()
   * @see #getBooleanOrExpression()
   * @generated
   */
  EReference getBooleanOrExpression_Operand1();

  /**
   * Returns the meta object for the containment reference '{@link com.yakindu.statechart.model.expressions.statechartexpressions.BooleanOrExpression#getOperand2 <em>Operand2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand2</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.BooleanOrExpression#getOperand2()
   * @see #getBooleanOrExpression()
   * @generated
   */
  EReference getBooleanOrExpression_Operand2();

  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.model.expressions.statechartexpressions.BooleanAndExpression <em>Boolean And Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean And Expression</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.BooleanAndExpression
   * @generated
   */
  EClass getBooleanAndExpression();

  /**
   * Returns the meta object for the containment reference '{@link com.yakindu.statechart.model.expressions.statechartexpressions.BooleanAndExpression#getOperand1 <em>Operand1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand1</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.BooleanAndExpression#getOperand1()
   * @see #getBooleanAndExpression()
   * @generated
   */
  EReference getBooleanAndExpression_Operand1();

  /**
   * Returns the meta object for the containment reference '{@link com.yakindu.statechart.model.expressions.statechartexpressions.BooleanAndExpression#getOperand2 <em>Operand2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand2</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.BooleanAndExpression#getOperand2()
   * @see #getBooleanAndExpression()
   * @generated
   */
  EReference getBooleanAndExpression_Operand2();

  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.model.expressions.statechartexpressions.BitwiseXorExpression <em>Bitwise Xor Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bitwise Xor Expression</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.BitwiseXorExpression
   * @generated
   */
  EClass getBitwiseXorExpression();

  /**
   * Returns the meta object for the containment reference '{@link com.yakindu.statechart.model.expressions.statechartexpressions.BitwiseXorExpression#getOperand1 <em>Operand1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand1</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.BitwiseXorExpression#getOperand1()
   * @see #getBitwiseXorExpression()
   * @generated
   */
  EReference getBitwiseXorExpression_Operand1();

  /**
   * Returns the meta object for the containment reference '{@link com.yakindu.statechart.model.expressions.statechartexpressions.BitwiseXorExpression#getOperand2 <em>Operand2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand2</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.BitwiseXorExpression#getOperand2()
   * @see #getBitwiseXorExpression()
   * @generated
   */
  EReference getBitwiseXorExpression_Operand2();

  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.model.expressions.statechartexpressions.BitwiseOrExpression <em>Bitwise Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bitwise Or Expression</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.BitwiseOrExpression
   * @generated
   */
  EClass getBitwiseOrExpression();

  /**
   * Returns the meta object for the containment reference '{@link com.yakindu.statechart.model.expressions.statechartexpressions.BitwiseOrExpression#getOperand1 <em>Operand1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand1</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.BitwiseOrExpression#getOperand1()
   * @see #getBitwiseOrExpression()
   * @generated
   */
  EReference getBitwiseOrExpression_Operand1();

  /**
   * Returns the meta object for the containment reference '{@link com.yakindu.statechart.model.expressions.statechartexpressions.BitwiseOrExpression#getOperand2 <em>Operand2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand2</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.BitwiseOrExpression#getOperand2()
   * @see #getBitwiseOrExpression()
   * @generated
   */
  EReference getBitwiseOrExpression_Operand2();

  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.model.expressions.statechartexpressions.BitwiseAndExpression <em>Bitwise And Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bitwise And Expression</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.BitwiseAndExpression
   * @generated
   */
  EClass getBitwiseAndExpression();

  /**
   * Returns the meta object for the containment reference '{@link com.yakindu.statechart.model.expressions.statechartexpressions.BitwiseAndExpression#getOperand1 <em>Operand1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand1</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.BitwiseAndExpression#getOperand1()
   * @see #getBitwiseAndExpression()
   * @generated
   */
  EReference getBitwiseAndExpression_Operand1();

  /**
   * Returns the meta object for the containment reference '{@link com.yakindu.statechart.model.expressions.statechartexpressions.BitwiseAndExpression#getOperand2 <em>Operand2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand2</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.BitwiseAndExpression#getOperand2()
   * @see #getBitwiseAndExpression()
   * @generated
   */
  EReference getBitwiseAndExpression_Operand2();

  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.model.expressions.statechartexpressions.EqualityExpression <em>Equality Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Equality Expression</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.EqualityExpression
   * @generated
   */
  EClass getEqualityExpression();

  /**
   * Returns the meta object for the containment reference '{@link com.yakindu.statechart.model.expressions.statechartexpressions.EqualityExpression#getOperand1 <em>Operand1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand1</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.EqualityExpression#getOperand1()
   * @see #getEqualityExpression()
   * @generated
   */
  EReference getEqualityExpression_Operand1();

  /**
   * Returns the meta object for the attribute '{@link com.yakindu.statechart.model.expressions.statechartexpressions.EqualityExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.EqualityExpression#getOperator()
   * @see #getEqualityExpression()
   * @generated
   */
  EAttribute getEqualityExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link com.yakindu.statechart.model.expressions.statechartexpressions.EqualityExpression#getOperand2 <em>Operand2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand2</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.EqualityExpression#getOperand2()
   * @see #getEqualityExpression()
   * @generated
   */
  EReference getEqualityExpression_Operand2();

  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.model.expressions.statechartexpressions.RelationalExpression <em>Relational Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relational Expression</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.RelationalExpression
   * @generated
   */
  EClass getRelationalExpression();

  /**
   * Returns the meta object for the containment reference '{@link com.yakindu.statechart.model.expressions.statechartexpressions.RelationalExpression#getOperand1 <em>Operand1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand1</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.RelationalExpression#getOperand1()
   * @see #getRelationalExpression()
   * @generated
   */
  EReference getRelationalExpression_Operand1();

  /**
   * Returns the meta object for the attribute '{@link com.yakindu.statechart.model.expressions.statechartexpressions.RelationalExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.RelationalExpression#getOperator()
   * @see #getRelationalExpression()
   * @generated
   */
  EAttribute getRelationalExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link com.yakindu.statechart.model.expressions.statechartexpressions.RelationalExpression#getOperand2 <em>Operand2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand2</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.RelationalExpression#getOperand2()
   * @see #getRelationalExpression()
   * @generated
   */
  EReference getRelationalExpression_Operand2();

  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.model.expressions.statechartexpressions.ConditionalExpression <em>Conditional Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Conditional Expression</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.ConditionalExpression
   * @generated
   */
  EClass getConditionalExpression();

  /**
   * Returns the meta object for the containment reference '{@link com.yakindu.statechart.model.expressions.statechartexpressions.ConditionalExpression#getOperand1 <em>Operand1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand1</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.ConditionalExpression#getOperand1()
   * @see #getConditionalExpression()
   * @generated
   */
  EReference getConditionalExpression_Operand1();

  /**
   * Returns the meta object for the containment reference '{@link com.yakindu.statechart.model.expressions.statechartexpressions.ConditionalExpression#getOperand2 <em>Operand2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand2</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.ConditionalExpression#getOperand2()
   * @see #getConditionalExpression()
   * @generated
   */
  EReference getConditionalExpression_Operand2();

  /**
   * Returns the meta object for the containment reference '{@link com.yakindu.statechart.model.expressions.statechartexpressions.ConditionalExpression#getOperand3 <em>Operand3</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand3</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.ConditionalExpression#getOperand3()
   * @see #getConditionalExpression()
   * @generated
   */
  EReference getConditionalExpression_Operand3();

  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.model.expressions.statechartexpressions.ShiftExpression <em>Shift Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Shift Expression</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.ShiftExpression
   * @generated
   */
  EClass getShiftExpression();

  /**
   * Returns the meta object for the containment reference '{@link com.yakindu.statechart.model.expressions.statechartexpressions.ShiftExpression#getOperand1 <em>Operand1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand1</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.ShiftExpression#getOperand1()
   * @see #getShiftExpression()
   * @generated
   */
  EReference getShiftExpression_Operand1();

  /**
   * Returns the meta object for the attribute '{@link com.yakindu.statechart.model.expressions.statechartexpressions.ShiftExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.ShiftExpression#getOperator()
   * @see #getShiftExpression()
   * @generated
   */
  EAttribute getShiftExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link com.yakindu.statechart.model.expressions.statechartexpressions.ShiftExpression#getOperand2 <em>Operand2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand2</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.ShiftExpression#getOperand2()
   * @see #getShiftExpression()
   * @generated
   */
  EReference getShiftExpression_Operand2();

  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.model.expressions.statechartexpressions.AdditiveExpression <em>Additive Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Additive Expression</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.AdditiveExpression
   * @generated
   */
  EClass getAdditiveExpression();

  /**
   * Returns the meta object for the containment reference '{@link com.yakindu.statechart.model.expressions.statechartexpressions.AdditiveExpression#getOperand1 <em>Operand1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand1</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.AdditiveExpression#getOperand1()
   * @see #getAdditiveExpression()
   * @generated
   */
  EReference getAdditiveExpression_Operand1();

  /**
   * Returns the meta object for the attribute '{@link com.yakindu.statechart.model.expressions.statechartexpressions.AdditiveExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.AdditiveExpression#getOperator()
   * @see #getAdditiveExpression()
   * @generated
   */
  EAttribute getAdditiveExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link com.yakindu.statechart.model.expressions.statechartexpressions.AdditiveExpression#getOperand2 <em>Operand2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand2</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.AdditiveExpression#getOperand2()
   * @see #getAdditiveExpression()
   * @generated
   */
  EReference getAdditiveExpression_Operand2();

  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.model.expressions.statechartexpressions.MultiplicativeExpression <em>Multiplicative Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiplicative Expression</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.MultiplicativeExpression
   * @generated
   */
  EClass getMultiplicativeExpression();

  /**
   * Returns the meta object for the containment reference '{@link com.yakindu.statechart.model.expressions.statechartexpressions.MultiplicativeExpression#getOperand1 <em>Operand1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand1</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.MultiplicativeExpression#getOperand1()
   * @see #getMultiplicativeExpression()
   * @generated
   */
  EReference getMultiplicativeExpression_Operand1();

  /**
   * Returns the meta object for the attribute '{@link com.yakindu.statechart.model.expressions.statechartexpressions.MultiplicativeExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.MultiplicativeExpression#getOperator()
   * @see #getMultiplicativeExpression()
   * @generated
   */
  EAttribute getMultiplicativeExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link com.yakindu.statechart.model.expressions.statechartexpressions.MultiplicativeExpression#getOperand2 <em>Operand2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand2</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.MultiplicativeExpression#getOperand2()
   * @see #getMultiplicativeExpression()
   * @generated
   */
  EReference getMultiplicativeExpression_Operand2();

  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.model.expressions.statechartexpressions.UnaryExpression <em>Unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary Expression</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.UnaryExpression
   * @generated
   */
  EClass getUnaryExpression();

  /**
   * Returns the meta object for the attribute '{@link com.yakindu.statechart.model.expressions.statechartexpressions.UnaryExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.UnaryExpression#getOperator()
   * @see #getUnaryExpression()
   * @generated
   */
  EAttribute getUnaryExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link com.yakindu.statechart.model.expressions.statechartexpressions.UnaryExpression#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.UnaryExpression#getOperand()
   * @see #getUnaryExpression()
   * @generated
   */
  EReference getUnaryExpression_Operand();

  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.model.expressions.statechartexpressions.PrimaryExpression <em>Primary Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Primary Expression</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.PrimaryExpression
   * @generated
   */
  EClass getPrimaryExpression();

  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.model.expressions.statechartexpressions.NestedExpression <em>Nested Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Nested Expression</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.NestedExpression
   * @generated
   */
  EClass getNestedExpression();

  /**
   * Returns the meta object for the containment reference '{@link com.yakindu.statechart.model.expressions.statechartexpressions.NestedExpression#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.NestedExpression#getExpression()
   * @see #getNestedExpression()
   * @generated
   */
  EReference getNestedExpression_Expression();

  /**
   * Returns the meta object for class '{@link com.yakindu.statechart.model.expressions.statechartexpressions.LiteralValue <em>Literal Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Literal Value</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.LiteralValue
   * @generated
   */
  EClass getLiteralValue();

  /**
   * Returns the meta object for the attribute '{@link com.yakindu.statechart.model.expressions.statechartexpressions.LiteralValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.LiteralValue#getValue()
   * @see #getLiteralValue()
   * @generated
   */
  EAttribute getLiteralValue_Value();

  /**
   * Returns the meta object for enum '{@link com.yakindu.statechart.model.expressions.statechartexpressions.TimeUnit <em>Time Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Time Unit</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.TimeUnit
   * @generated
   */
  EEnum getTimeUnit();

  /**
   * Returns the meta object for enum '{@link com.yakindu.statechart.model.expressions.statechartexpressions.AssignmentOperator <em>Assignment Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Assignment Operator</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.AssignmentOperator
   * @generated
   */
  EEnum getAssignmentOperator();

  /**
   * Returns the meta object for enum '{@link com.yakindu.statechart.model.expressions.statechartexpressions.EqualityOperator <em>Equality Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Equality Operator</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.EqualityOperator
   * @generated
   */
  EEnum getEqualityOperator();

  /**
   * Returns the meta object for enum '{@link com.yakindu.statechart.model.expressions.statechartexpressions.RelationalOperator <em>Relational Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Relational Operator</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.RelationalOperator
   * @generated
   */
  EEnum getRelationalOperator();

  /**
   * Returns the meta object for enum '{@link com.yakindu.statechart.model.expressions.statechartexpressions.ShiftOperator <em>Shift Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Shift Operator</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.ShiftOperator
   * @generated
   */
  EEnum getShiftOperator();

  /**
   * Returns the meta object for enum '{@link com.yakindu.statechart.model.expressions.statechartexpressions.AdditiveOperator <em>Additive Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Additive Operator</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.AdditiveOperator
   * @generated
   */
  EEnum getAdditiveOperator();

  /**
   * Returns the meta object for enum '{@link com.yakindu.statechart.model.expressions.statechartexpressions.MultiplicativeOperator <em>Multiplicative Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Multiplicative Operator</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.MultiplicativeOperator
   * @generated
   */
  EEnum getMultiplicativeOperator();

  /**
   * Returns the meta object for enum '{@link com.yakindu.statechart.model.expressions.statechartexpressions.UnaryOperator <em>Unary Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Unary Operator</em>'.
   * @see com.yakindu.statechart.model.expressions.statechartexpressions.UnaryOperator
   * @generated
   */
  EEnum getUnaryOperator();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  StatechartexpressionsFactory getStatechartexpressionsFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.ExpressionImpl
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.TriggerExpressionImpl <em>Trigger Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.TriggerExpressionImpl
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getTriggerExpression()
     * @generated
     */
    EClass TRIGGER_EXPRESSION = eINSTANCE.getTriggerExpression();

    /**
     * The meta object literal for the '<em><b>Triggers</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRIGGER_EXPRESSION__TRIGGERS = eINSTANCE.getTriggerExpression_Triggers();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.GuardExpressionImpl <em>Guard Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.GuardExpressionImpl
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getGuardExpression()
     * @generated
     */
    EClass GUARD_EXPRESSION = eINSTANCE.getGuardExpression();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GUARD_EXPRESSION__EXPRESSION = eINSTANCE.getGuardExpression_Expression();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.ActionExpressionImpl <em>Action Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.ActionExpressionImpl
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getActionExpression()
     * @generated
     */
    EClass ACTION_EXPRESSION = eINSTANCE.getActionExpression();

    /**
     * The meta object literal for the '<em><b>Statement</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTION_EXPRESSION__STATEMENT = eINSTANCE.getActionExpression_Statement();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.TriggerImpl <em>Trigger</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.TriggerImpl
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getTrigger()
     * @generated
     */
    EClass TRIGGER = eINSTANCE.getTrigger();

    /**
     * The meta object literal for the '<em><b>Event</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRIGGER__EVENT = eINSTANCE.getTrigger_Event();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.EventImpl <em>Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.EventImpl
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getEvent()
     * @generated
     */
    EClass EVENT = eINSTANCE.getEvent();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.SignalEventImpl <em>Signal Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.SignalEventImpl
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getSignalEvent()
     * @generated
     */
    EClass SIGNAL_EVENT = eINSTANCE.getSignalEvent();

    /**
     * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIGNAL_EVENT__IDENTIFIER = eINSTANCE.getSignalEvent_Identifier();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.TimeEventImpl <em>Time Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.TimeEventImpl
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getTimeEvent()
     * @generated
     */
    EClass TIME_EVENT = eINSTANCE.getTimeEvent();

    /**
     * The meta object literal for the '<em><b>Duration</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TIME_EVENT__DURATION = eINSTANCE.getTimeEvent_Duration();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.TimeExpressionImpl <em>Time Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.TimeExpressionImpl
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getTimeExpression()
     * @generated
     */
    EClass TIME_EXPRESSION = eINSTANCE.getTimeExpression();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.VariableReferenceImpl <em>Variable Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.VariableReferenceImpl
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getVariableReference()
     * @generated
     */
    EClass VARIABLE_REFERENCE = eINSTANCE.getVariableReference();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_REFERENCE__VARIABLE = eINSTANCE.getVariableReference_Variable();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.VariableImpl <em>Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.VariableImpl
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getVariable()
     * @generated
     */
    EClass VARIABLE = eINSTANCE.getVariable();

    /**
     * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE__IDENTIFIER = eINSTANCE.getVariable_Identifier();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.TimeConstantImpl <em>Time Constant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.TimeConstantImpl
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getTimeConstant()
     * @generated
     */
    EClass TIME_CONSTANT = eINSTANCE.getTimeConstant();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TIME_CONSTANT__VALUE = eINSTANCE.getTimeConstant_Value();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TIME_CONSTANT__UNIT = eINSTANCE.getTimeConstant_Unit();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatementImpl <em>Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatementImpl
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getStatement()
     * @generated
     */
    EClass STATEMENT = eINSTANCE.getStatement();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.VariableAssignmentImpl <em>Variable Assignment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.VariableAssignmentImpl
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getVariableAssignment()
     * @generated
     */
    EClass VARIABLE_ASSIGNMENT = eINSTANCE.getVariableAssignment();

    /**
     * The meta object literal for the '<em><b>Variable Reference</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_ASSIGNMENT__VARIABLE_REFERENCE = eINSTANCE.getVariableAssignment_VariableReference();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_ASSIGNMENT__OPERATOR = eINSTANCE.getVariableAssignment_Operator();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_ASSIGNMENT__VALUE = eINSTANCE.getVariableAssignment_Value();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.ProcedureCallImpl <em>Procedure Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.ProcedureCallImpl
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getProcedureCall()
     * @generated
     */
    EClass PROCEDURE_CALL = eINSTANCE.getProcedureCall();

    /**
     * The meta object literal for the '<em><b>Procedure</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROCEDURE_CALL__PROCEDURE = eINSTANCE.getProcedureCall_Procedure();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.ProcedureImpl <em>Procedure</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.ProcedureImpl
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getProcedure()
     * @generated
     */
    EClass PROCEDURE = eINSTANCE.getProcedure();

    /**
     * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROCEDURE__IDENTIFIER = eINSTANCE.getProcedure_Identifier();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.EventRaisingImpl <em>Event Raising</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.EventRaisingImpl
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getEventRaising()
     * @generated
     */
    EClass EVENT_RAISING = eINSTANCE.getEventRaising();

    /**
     * The meta object literal for the '<em><b>Event</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT_RAISING__EVENT = eINSTANCE.getEventRaising_Event();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.BooleanOrExpressionImpl <em>Boolean Or Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.BooleanOrExpressionImpl
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getBooleanOrExpression()
     * @generated
     */
    EClass BOOLEAN_OR_EXPRESSION = eINSTANCE.getBooleanOrExpression();

    /**
     * The meta object literal for the '<em><b>Operand1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BOOLEAN_OR_EXPRESSION__OPERAND1 = eINSTANCE.getBooleanOrExpression_Operand1();

    /**
     * The meta object literal for the '<em><b>Operand2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BOOLEAN_OR_EXPRESSION__OPERAND2 = eINSTANCE.getBooleanOrExpression_Operand2();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.BooleanAndExpressionImpl <em>Boolean And Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.BooleanAndExpressionImpl
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getBooleanAndExpression()
     * @generated
     */
    EClass BOOLEAN_AND_EXPRESSION = eINSTANCE.getBooleanAndExpression();

    /**
     * The meta object literal for the '<em><b>Operand1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BOOLEAN_AND_EXPRESSION__OPERAND1 = eINSTANCE.getBooleanAndExpression_Operand1();

    /**
     * The meta object literal for the '<em><b>Operand2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BOOLEAN_AND_EXPRESSION__OPERAND2 = eINSTANCE.getBooleanAndExpression_Operand2();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.BitwiseXorExpressionImpl <em>Bitwise Xor Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.BitwiseXorExpressionImpl
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getBitwiseXorExpression()
     * @generated
     */
    EClass BITWISE_XOR_EXPRESSION = eINSTANCE.getBitwiseXorExpression();

    /**
     * The meta object literal for the '<em><b>Operand1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BITWISE_XOR_EXPRESSION__OPERAND1 = eINSTANCE.getBitwiseXorExpression_Operand1();

    /**
     * The meta object literal for the '<em><b>Operand2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BITWISE_XOR_EXPRESSION__OPERAND2 = eINSTANCE.getBitwiseXorExpression_Operand2();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.BitwiseOrExpressionImpl <em>Bitwise Or Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.BitwiseOrExpressionImpl
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getBitwiseOrExpression()
     * @generated
     */
    EClass BITWISE_OR_EXPRESSION = eINSTANCE.getBitwiseOrExpression();

    /**
     * The meta object literal for the '<em><b>Operand1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BITWISE_OR_EXPRESSION__OPERAND1 = eINSTANCE.getBitwiseOrExpression_Operand1();

    /**
     * The meta object literal for the '<em><b>Operand2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BITWISE_OR_EXPRESSION__OPERAND2 = eINSTANCE.getBitwiseOrExpression_Operand2();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.BitwiseAndExpressionImpl <em>Bitwise And Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.BitwiseAndExpressionImpl
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getBitwiseAndExpression()
     * @generated
     */
    EClass BITWISE_AND_EXPRESSION = eINSTANCE.getBitwiseAndExpression();

    /**
     * The meta object literal for the '<em><b>Operand1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BITWISE_AND_EXPRESSION__OPERAND1 = eINSTANCE.getBitwiseAndExpression_Operand1();

    /**
     * The meta object literal for the '<em><b>Operand2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BITWISE_AND_EXPRESSION__OPERAND2 = eINSTANCE.getBitwiseAndExpression_Operand2();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.EqualityExpressionImpl <em>Equality Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.EqualityExpressionImpl
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getEqualityExpression()
     * @generated
     */
    EClass EQUALITY_EXPRESSION = eINSTANCE.getEqualityExpression();

    /**
     * The meta object literal for the '<em><b>Operand1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUALITY_EXPRESSION__OPERAND1 = eINSTANCE.getEqualityExpression_Operand1();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EQUALITY_EXPRESSION__OPERATOR = eINSTANCE.getEqualityExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Operand2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUALITY_EXPRESSION__OPERAND2 = eINSTANCE.getEqualityExpression_Operand2();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.RelationalExpressionImpl <em>Relational Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.RelationalExpressionImpl
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getRelationalExpression()
     * @generated
     */
    EClass RELATIONAL_EXPRESSION = eINSTANCE.getRelationalExpression();

    /**
     * The meta object literal for the '<em><b>Operand1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RELATIONAL_EXPRESSION__OPERAND1 = eINSTANCE.getRelationalExpression_Operand1();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RELATIONAL_EXPRESSION__OPERATOR = eINSTANCE.getRelationalExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Operand2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RELATIONAL_EXPRESSION__OPERAND2 = eINSTANCE.getRelationalExpression_Operand2();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.ConditionalExpressionImpl <em>Conditional Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.ConditionalExpressionImpl
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getConditionalExpression()
     * @generated
     */
    EClass CONDITIONAL_EXPRESSION = eINSTANCE.getConditionalExpression();

    /**
     * The meta object literal for the '<em><b>Operand1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_EXPRESSION__OPERAND1 = eINSTANCE.getConditionalExpression_Operand1();

    /**
     * The meta object literal for the '<em><b>Operand2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_EXPRESSION__OPERAND2 = eINSTANCE.getConditionalExpression_Operand2();

    /**
     * The meta object literal for the '<em><b>Operand3</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_EXPRESSION__OPERAND3 = eINSTANCE.getConditionalExpression_Operand3();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.ShiftExpressionImpl <em>Shift Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.ShiftExpressionImpl
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getShiftExpression()
     * @generated
     */
    EClass SHIFT_EXPRESSION = eINSTANCE.getShiftExpression();

    /**
     * The meta object literal for the '<em><b>Operand1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SHIFT_EXPRESSION__OPERAND1 = eINSTANCE.getShiftExpression_Operand1();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SHIFT_EXPRESSION__OPERATOR = eINSTANCE.getShiftExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Operand2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SHIFT_EXPRESSION__OPERAND2 = eINSTANCE.getShiftExpression_Operand2();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.AdditiveExpressionImpl <em>Additive Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.AdditiveExpressionImpl
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getAdditiveExpression()
     * @generated
     */
    EClass ADDITIVE_EXPRESSION = eINSTANCE.getAdditiveExpression();

    /**
     * The meta object literal for the '<em><b>Operand1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADDITIVE_EXPRESSION__OPERAND1 = eINSTANCE.getAdditiveExpression_Operand1();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ADDITIVE_EXPRESSION__OPERATOR = eINSTANCE.getAdditiveExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Operand2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADDITIVE_EXPRESSION__OPERAND2 = eINSTANCE.getAdditiveExpression_Operand2();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.MultiplicativeExpressionImpl <em>Multiplicative Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.MultiplicativeExpressionImpl
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getMultiplicativeExpression()
     * @generated
     */
    EClass MULTIPLICATIVE_EXPRESSION = eINSTANCE.getMultiplicativeExpression();

    /**
     * The meta object literal for the '<em><b>Operand1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLICATIVE_EXPRESSION__OPERAND1 = eINSTANCE.getMultiplicativeExpression_Operand1();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MULTIPLICATIVE_EXPRESSION__OPERATOR = eINSTANCE.getMultiplicativeExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Operand2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLICATIVE_EXPRESSION__OPERAND2 = eINSTANCE.getMultiplicativeExpression_Operand2();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.UnaryExpressionImpl
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getUnaryExpression()
     * @generated
     */
    EClass UNARY_EXPRESSION = eINSTANCE.getUnaryExpression();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNARY_EXPRESSION__OPERATOR = eINSTANCE.getUnaryExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_EXPRESSION__OPERAND = eINSTANCE.getUnaryExpression_Operand();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.PrimaryExpressionImpl <em>Primary Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.PrimaryExpressionImpl
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getPrimaryExpression()
     * @generated
     */
    EClass PRIMARY_EXPRESSION = eINSTANCE.getPrimaryExpression();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.NestedExpressionImpl <em>Nested Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.NestedExpressionImpl
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getNestedExpression()
     * @generated
     */
    EClass NESTED_EXPRESSION = eINSTANCE.getNestedExpression();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NESTED_EXPRESSION__EXPRESSION = eINSTANCE.getNestedExpression_Expression();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.impl.LiteralValueImpl <em>Literal Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.LiteralValueImpl
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getLiteralValue()
     * @generated
     */
    EClass LITERAL_VALUE = eINSTANCE.getLiteralValue();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LITERAL_VALUE__VALUE = eINSTANCE.getLiteralValue_Value();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.TimeUnit <em>Time Unit</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.TimeUnit
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getTimeUnit()
     * @generated
     */
    EEnum TIME_UNIT = eINSTANCE.getTimeUnit();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.AssignmentOperator <em>Assignment Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.AssignmentOperator
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getAssignmentOperator()
     * @generated
     */
    EEnum ASSIGNMENT_OPERATOR = eINSTANCE.getAssignmentOperator();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.EqualityOperator <em>Equality Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.EqualityOperator
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getEqualityOperator()
     * @generated
     */
    EEnum EQUALITY_OPERATOR = eINSTANCE.getEqualityOperator();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.RelationalOperator <em>Relational Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.RelationalOperator
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getRelationalOperator()
     * @generated
     */
    EEnum RELATIONAL_OPERATOR = eINSTANCE.getRelationalOperator();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.ShiftOperator <em>Shift Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.ShiftOperator
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getShiftOperator()
     * @generated
     */
    EEnum SHIFT_OPERATOR = eINSTANCE.getShiftOperator();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.AdditiveOperator <em>Additive Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.AdditiveOperator
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getAdditiveOperator()
     * @generated
     */
    EEnum ADDITIVE_OPERATOR = eINSTANCE.getAdditiveOperator();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.MultiplicativeOperator <em>Multiplicative Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.MultiplicativeOperator
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getMultiplicativeOperator()
     * @generated
     */
    EEnum MULTIPLICATIVE_OPERATOR = eINSTANCE.getMultiplicativeOperator();

    /**
     * The meta object literal for the '{@link com.yakindu.statechart.model.expressions.statechartexpressions.UnaryOperator <em>Unary Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.UnaryOperator
     * @see com.yakindu.statechart.model.expressions.statechartexpressions.impl.StatechartexpressionsPackageImpl#getUnaryOperator()
     * @generated
     */
    EEnum UNARY_OPERATOR = eINSTANCE.getUnaryOperator();

  }

} //StatechartexpressionsPackage
