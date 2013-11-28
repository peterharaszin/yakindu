/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package com.yakindu.statechart.model.expressions.statechartexpressions.impl;

import com.yakindu.statechart.model.expressions.statechartexpressions.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StatechartexpressionsFactoryImpl extends EFactoryImpl implements StatechartexpressionsFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static StatechartexpressionsFactory init()
  {
    try
    {
      StatechartexpressionsFactory theStatechartexpressionsFactory = (StatechartexpressionsFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.yakindu.com/statechart/model/expressions"); 
      if (theStatechartexpressionsFactory != null)
      {
        return theStatechartexpressionsFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new StatechartexpressionsFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StatechartexpressionsFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case StatechartexpressionsPackage.EXPRESSION: return createExpression();
      case StatechartexpressionsPackage.TRIGGER_EXPRESSION: return createTriggerExpression();
      case StatechartexpressionsPackage.GUARD_EXPRESSION: return createGuardExpression();
      case StatechartexpressionsPackage.ACTION_EXPRESSION: return createActionExpression();
      case StatechartexpressionsPackage.TRIGGER: return createTrigger();
      case StatechartexpressionsPackage.EVENT: return createEvent();
      case StatechartexpressionsPackage.SIGNAL_EVENT: return createSignalEvent();
      case StatechartexpressionsPackage.TIME_EVENT: return createTimeEvent();
      case StatechartexpressionsPackage.TIME_EXPRESSION: return createTimeExpression();
      case StatechartexpressionsPackage.VARIABLE_REFERENCE: return createVariableReference();
      case StatechartexpressionsPackage.VARIABLE: return createVariable();
      case StatechartexpressionsPackage.TIME_CONSTANT: return createTimeConstant();
      case StatechartexpressionsPackage.STATEMENT: return createStatement();
      case StatechartexpressionsPackage.VARIABLE_ASSIGNMENT: return createVariableAssignment();
      case StatechartexpressionsPackage.PROCEDURE_CALL: return createProcedureCall();
      case StatechartexpressionsPackage.PROCEDURE: return createProcedure();
      case StatechartexpressionsPackage.EVENT_RAISING: return createEventRaising();
      case StatechartexpressionsPackage.BOOLEAN_OR_EXPRESSION: return createBooleanOrExpression();
      case StatechartexpressionsPackage.BOOLEAN_AND_EXPRESSION: return createBooleanAndExpression();
      case StatechartexpressionsPackage.BITWISE_XOR_EXPRESSION: return createBitwiseXorExpression();
      case StatechartexpressionsPackage.BITWISE_OR_EXPRESSION: return createBitwiseOrExpression();
      case StatechartexpressionsPackage.BITWISE_AND_EXPRESSION: return createBitwiseAndExpression();
      case StatechartexpressionsPackage.EQUALITY_EXPRESSION: return createEqualityExpression();
      case StatechartexpressionsPackage.RELATIONAL_EXPRESSION: return createRelationalExpression();
      case StatechartexpressionsPackage.CONDITIONAL_EXPRESSION: return createConditionalExpression();
      case StatechartexpressionsPackage.SHIFT_EXPRESSION: return createShiftExpression();
      case StatechartexpressionsPackage.ADDITIVE_EXPRESSION: return createAdditiveExpression();
      case StatechartexpressionsPackage.MULTIPLICATIVE_EXPRESSION: return createMultiplicativeExpression();
      case StatechartexpressionsPackage.UNARY_EXPRESSION: return createUnaryExpression();
      case StatechartexpressionsPackage.PRIMARY_EXPRESSION: return createPrimaryExpression();
      case StatechartexpressionsPackage.NESTED_EXPRESSION: return createNestedExpression();
      case StatechartexpressionsPackage.LITERAL_VALUE: return createLiteralValue();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case StatechartexpressionsPackage.TIME_UNIT:
        return createTimeUnitFromString(eDataType, initialValue);
      case StatechartexpressionsPackage.ASSIGNMENT_OPERATOR:
        return createAssignmentOperatorFromString(eDataType, initialValue);
      case StatechartexpressionsPackage.EQUALITY_OPERATOR:
        return createEqualityOperatorFromString(eDataType, initialValue);
      case StatechartexpressionsPackage.RELATIONAL_OPERATOR:
        return createRelationalOperatorFromString(eDataType, initialValue);
      case StatechartexpressionsPackage.SHIFT_OPERATOR:
        return createShiftOperatorFromString(eDataType, initialValue);
      case StatechartexpressionsPackage.ADDITIVE_OPERATOR:
        return createAdditiveOperatorFromString(eDataType, initialValue);
      case StatechartexpressionsPackage.MULTIPLICATIVE_OPERATOR:
        return createMultiplicativeOperatorFromString(eDataType, initialValue);
      case StatechartexpressionsPackage.UNARY_OPERATOR:
        return createUnaryOperatorFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case StatechartexpressionsPackage.TIME_UNIT:
        return convertTimeUnitToString(eDataType, instanceValue);
      case StatechartexpressionsPackage.ASSIGNMENT_OPERATOR:
        return convertAssignmentOperatorToString(eDataType, instanceValue);
      case StatechartexpressionsPackage.EQUALITY_OPERATOR:
        return convertEqualityOperatorToString(eDataType, instanceValue);
      case StatechartexpressionsPackage.RELATIONAL_OPERATOR:
        return convertRelationalOperatorToString(eDataType, instanceValue);
      case StatechartexpressionsPackage.SHIFT_OPERATOR:
        return convertShiftOperatorToString(eDataType, instanceValue);
      case StatechartexpressionsPackage.ADDITIVE_OPERATOR:
        return convertAdditiveOperatorToString(eDataType, instanceValue);
      case StatechartexpressionsPackage.MULTIPLICATIVE_OPERATOR:
        return convertMultiplicativeOperatorToString(eDataType, instanceValue);
      case StatechartexpressionsPackage.UNARY_OPERATOR:
        return convertUnaryOperatorToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TriggerExpression createTriggerExpression()
  {
    TriggerExpressionImpl triggerExpression = new TriggerExpressionImpl();
    return triggerExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GuardExpression createGuardExpression()
  {
    GuardExpressionImpl guardExpression = new GuardExpressionImpl();
    return guardExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActionExpression createActionExpression()
  {
    ActionExpressionImpl actionExpression = new ActionExpressionImpl();
    return actionExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Trigger createTrigger()
  {
    TriggerImpl trigger = new TriggerImpl();
    return trigger;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Event createEvent()
  {
    EventImpl event = new EventImpl();
    return event;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SignalEvent createSignalEvent()
  {
    SignalEventImpl signalEvent = new SignalEventImpl();
    return signalEvent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TimeEvent createTimeEvent()
  {
    TimeEventImpl timeEvent = new TimeEventImpl();
    return timeEvent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TimeExpression createTimeExpression()
  {
    TimeExpressionImpl timeExpression = new TimeExpressionImpl();
    return timeExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableReference createVariableReference()
  {
    VariableReferenceImpl variableReference = new VariableReferenceImpl();
    return variableReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Variable createVariable()
  {
    VariableImpl variable = new VariableImpl();
    return variable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TimeConstant createTimeConstant()
  {
    TimeConstantImpl timeConstant = new TimeConstantImpl();
    return timeConstant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Statement createStatement()
  {
    StatementImpl statement = new StatementImpl();
    return statement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableAssignment createVariableAssignment()
  {
    VariableAssignmentImpl variableAssignment = new VariableAssignmentImpl();
    return variableAssignment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProcedureCall createProcedureCall()
  {
    ProcedureCallImpl procedureCall = new ProcedureCallImpl();
    return procedureCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Procedure createProcedure()
  {
    ProcedureImpl procedure = new ProcedureImpl();
    return procedure;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EventRaising createEventRaising()
  {
    EventRaisingImpl eventRaising = new EventRaisingImpl();
    return eventRaising;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanOrExpression createBooleanOrExpression()
  {
    BooleanOrExpressionImpl booleanOrExpression = new BooleanOrExpressionImpl();
    return booleanOrExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanAndExpression createBooleanAndExpression()
  {
    BooleanAndExpressionImpl booleanAndExpression = new BooleanAndExpressionImpl();
    return booleanAndExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BitwiseXorExpression createBitwiseXorExpression()
  {
    BitwiseXorExpressionImpl bitwiseXorExpression = new BitwiseXorExpressionImpl();
    return bitwiseXorExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BitwiseOrExpression createBitwiseOrExpression()
  {
    BitwiseOrExpressionImpl bitwiseOrExpression = new BitwiseOrExpressionImpl();
    return bitwiseOrExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BitwiseAndExpression createBitwiseAndExpression()
  {
    BitwiseAndExpressionImpl bitwiseAndExpression = new BitwiseAndExpressionImpl();
    return bitwiseAndExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EqualityExpression createEqualityExpression()
  {
    EqualityExpressionImpl equalityExpression = new EqualityExpressionImpl();
    return equalityExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RelationalExpression createRelationalExpression()
  {
    RelationalExpressionImpl relationalExpression = new RelationalExpressionImpl();
    return relationalExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionalExpression createConditionalExpression()
  {
    ConditionalExpressionImpl conditionalExpression = new ConditionalExpressionImpl();
    return conditionalExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShiftExpression createShiftExpression()
  {
    ShiftExpressionImpl shiftExpression = new ShiftExpressionImpl();
    return shiftExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AdditiveExpression createAdditiveExpression()
  {
    AdditiveExpressionImpl additiveExpression = new AdditiveExpressionImpl();
    return additiveExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicativeExpression createMultiplicativeExpression()
  {
    MultiplicativeExpressionImpl multiplicativeExpression = new MultiplicativeExpressionImpl();
    return multiplicativeExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryExpression createUnaryExpression()
  {
    UnaryExpressionImpl unaryExpression = new UnaryExpressionImpl();
    return unaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimaryExpression createPrimaryExpression()
  {
    PrimaryExpressionImpl primaryExpression = new PrimaryExpressionImpl();
    return primaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NestedExpression createNestedExpression()
  {
    NestedExpressionImpl nestedExpression = new NestedExpressionImpl();
    return nestedExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LiteralValue createLiteralValue()
  {
    LiteralValueImpl literalValue = new LiteralValueImpl();
    return literalValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TimeUnit createTimeUnitFromString(EDataType eDataType, String initialValue)
  {
    TimeUnit result = TimeUnit.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertTimeUnitToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignmentOperator createAssignmentOperatorFromString(EDataType eDataType, String initialValue)
  {
    AssignmentOperator result = AssignmentOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAssignmentOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EqualityOperator createEqualityOperatorFromString(EDataType eDataType, String initialValue)
  {
    EqualityOperator result = EqualityOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertEqualityOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RelationalOperator createRelationalOperatorFromString(EDataType eDataType, String initialValue)
  {
    RelationalOperator result = RelationalOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertRelationalOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShiftOperator createShiftOperatorFromString(EDataType eDataType, String initialValue)
  {
    ShiftOperator result = ShiftOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertShiftOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AdditiveOperator createAdditiveOperatorFromString(EDataType eDataType, String initialValue)
  {
    AdditiveOperator result = AdditiveOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAdditiveOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicativeOperator createMultiplicativeOperatorFromString(EDataType eDataType, String initialValue)
  {
    MultiplicativeOperator result = MultiplicativeOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertMultiplicativeOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryOperator createUnaryOperatorFromString(EDataType eDataType, String initialValue)
  {
    UnaryOperator result = UnaryOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertUnaryOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StatechartexpressionsPackage getStatechartexpressionsPackage()
  {
    return (StatechartexpressionsPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static StatechartexpressionsPackage getPackage()
  {
    return StatechartexpressionsPackage.eINSTANCE;
  }

} //StatechartexpressionsFactoryImpl
