/**
 * <copyright>
 * </copyright>
 *
 */
package org.yakindu.sct.statechart.expressions.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.yakindu.model.sct.statechart.Event;
import org.yakindu.model.sct.statechart.NamedElement;
import org.yakindu.model.sct.statechart.Variable;

import org.yakindu.sct.statechart.expressions.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage
 * @generated
 */
public class ExpressionsSwitch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ExpressionsPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionsSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = ExpressionsPackage.eINSTANCE;
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  public T doSwitch(EObject theEObject)
  {
    return doSwitch(theEObject.eClass(), theEObject);
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T doSwitch(EClass theEClass, EObject theEObject)
  {
    if (theEClass.eContainer() == modelPackage)
    {
      return doSwitch(theEClass.getClassifierID(), theEObject);
    }
    else
    {
      List<EClass> eSuperTypes = theEClass.getESuperTypes();
      return
        eSuperTypes.isEmpty() ?
          defaultCase(theEObject) :
          doSwitch(eSuperTypes.get(0), theEObject);
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case ExpressionsPackage.ROOT:
      {
        Root root = (Root)theEObject;
        T result = caseRoot(root);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.DEF_ROOT:
      {
        DefRoot defRoot = (DefRoot)theEObject;
        T result = caseDefRoot(defRoot);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.STATECHART_ROOT:
      {
        StatechartRoot statechartRoot = (StatechartRoot)theEObject;
        T result = caseStatechartRoot(statechartRoot);
        if (result == null) result = caseDefRoot(statechartRoot);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.STATE_ROOT:
      {
        StateRoot stateRoot = (StateRoot)theEObject;
        T result = caseStateRoot(stateRoot);
        if (result == null) result = caseDefRoot(stateRoot);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.TRANSITION_ROOT:
      {
        TransitionRoot transitionRoot = (TransitionRoot)theEObject;
        T result = caseTransitionRoot(transitionRoot);
        if (result == null) result = caseDefRoot(transitionRoot);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.STATECHART_DEFINITION:
      {
        StatechartDefinition statechartDefinition = (StatechartDefinition)theEObject;
        T result = caseStatechartDefinition(statechartDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.STATE_DEFINITION:
      {
        StateDefinition stateDefinition = (StateDefinition)theEObject;
        T result = caseStateDefinition(stateDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.TRANSITION_STATEMENT:
      {
        TransitionStatement transitionStatement = (TransitionStatement)theEObject;
        T result = caseTransitionStatement(transitionStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.SCOPE:
      {
        Scope scope = (Scope)theEObject;
        T result = caseScope(scope);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.SIMPLE_SCOPE:
      {
        SimpleScope simpleScope = (SimpleScope)theEObject;
        T result = caseSimpleScope(simpleScope);
        if (result == null) result = caseStateDefinition(simpleScope);
        if (result == null) result = caseScope(simpleScope);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.STATECHART_SCOPE:
      {
        StatechartScope statechartScope = (StatechartScope)theEObject;
        T result = caseStatechartScope(statechartScope);
        if (result == null) result = caseScope(statechartScope);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.INTERFACE_SCOPE:
      {
        InterfaceScope interfaceScope = (InterfaceScope)theEObject;
        T result = caseInterfaceScope(interfaceScope);
        if (result == null) result = caseStatechartScope(interfaceScope);
        if (result == null) result = caseScope(interfaceScope);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.INTERNAL_SCOPE:
      {
        InternalScope internalScope = (InternalScope)theEObject;
        T result = caseInternalScope(internalScope);
        if (result == null) result = caseStatechartScope(internalScope);
        if (result == null) result = caseScope(internalScope);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.DEFINITION:
      {
        Definition definition = (Definition)theEObject;
        T result = caseDefinition(definition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.EVENT_DEFINITION:
      {
        EventDefinition eventDefinition = (EventDefinition)theEObject;
        T result = caseEventDefinition(eventDefinition);
        if (result == null) result = caseDefinition(eventDefinition);
        if (result == null) result = caseEvent(eventDefinition);
        if (result == null) result = caseNamedElement(eventDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.EVENT_DERIVATION:
      {
        EventDerivation eventDerivation = (EventDerivation)theEObject;
        T result = caseEventDerivation(eventDerivation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.VARIABLE_DEFINITION:
      {
        VariableDefinition variableDefinition = (VariableDefinition)theEObject;
        T result = caseVariableDefinition(variableDefinition);
        if (result == null) result = caseDefinition(variableDefinition);
        if (result == null) result = caseVariable(variableDefinition);
        if (result == null) result = caseNamedElement(variableDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.CLOCK:
      {
        Clock clock = (Clock)theEObject;
        T result = caseClock(clock);
        if (result == null) result = caseDefinition(clock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.OPERATION:
      {
        Operation operation = (Operation)theEObject;
        T result = caseOperation(operation);
        if (result == null) result = caseDefinition(operation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.ENTRYPOINT:
      {
        Entrypoint entrypoint = (Entrypoint)theEObject;
        T result = caseEntrypoint(entrypoint);
        if (result == null) result = caseDefinition(entrypoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.EXITPOINT:
      {
        Exitpoint exitpoint = (Exitpoint)theEObject;
        T result = caseExitpoint(exitpoint);
        if (result == null) result = caseDefinition(exitpoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.REACTION:
      {
        Reaction reaction = (Reaction)theEObject;
        T result = caseReaction(reaction);
        if (result == null) result = caseTransitionStatement(reaction);
        if (result == null) result = caseDefinition(reaction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.REACTION_TRIGGER:
      {
        ReactionTrigger reactionTrigger = (ReactionTrigger)theEObject;
        T result = caseReactionTrigger(reactionTrigger);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.ACTION:
      {
        Action action = (Action)theEObject;
        T result = caseAction(action);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.REACTION_PROPERTIES:
      {
        ReactionProperties reactionProperties = (ReactionProperties)theEObject;
        T result = caseReactionProperties(reactionProperties);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.REACTION_PROPERTY:
      {
        ReactionProperty reactionProperty = (ReactionProperty)theEObject;
        T result = caseReactionProperty(reactionProperty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.REACTION_PRIORITY:
      {
        ReactionPriority reactionPriority = (ReactionPriority)theEObject;
        T result = caseReactionPriority(reactionPriority);
        if (result == null) result = caseReactionProperty(reactionPriority);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.ENTRY_POINT_SPEC:
      {
        EntryPointSpec entryPointSpec = (EntryPointSpec)theEObject;
        T result = caseEntryPointSpec(entryPointSpec);
        if (result == null) result = caseReactionProperty(entryPointSpec);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.EXIT_POINT_SPEC:
      {
        ExitPointSpec exitPointSpec = (ExitPointSpec)theEObject;
        T result = caseExitPointSpec(exitPointSpec);
        if (result == null) result = caseReactionProperty(exitPointSpec);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.EVENT_SPEC:
      {
        EventSpec eventSpec = (EventSpec)theEObject;
        T result = caseEventSpec(eventSpec);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.REGULAR_EVENT_SPEC:
      {
        RegularEventSpec regularEventSpec = (RegularEventSpec)theEObject;
        T result = caseRegularEventSpec(regularEventSpec);
        if (result == null) result = caseEventSpec(regularEventSpec);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.TIME_EVENT_SPEC:
      {
        TimeEventSpec timeEventSpec = (TimeEventSpec)theEObject;
        T result = caseTimeEventSpec(timeEventSpec);
        if (result == null) result = caseEventSpec(timeEventSpec);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.BUILTIN_EVENT_SPEC:
      {
        BuiltinEventSpec builtinEventSpec = (BuiltinEventSpec)theEObject;
        T result = caseBuiltinEventSpec(builtinEventSpec);
        if (result == null) result = caseEventSpec(builtinEventSpec);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.ENTER_EVENT:
      {
        EnterEvent enterEvent = (EnterEvent)theEObject;
        T result = caseEnterEvent(enterEvent);
        if (result == null) result = caseBuiltinEventSpec(enterEvent);
        if (result == null) result = caseEventSpec(enterEvent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.EXIT_EVENT:
      {
        ExitEvent exitEvent = (ExitEvent)theEObject;
        T result = caseExitEvent(exitEvent);
        if (result == null) result = caseBuiltinEventSpec(exitEvent);
        if (result == null) result = caseEventSpec(exitEvent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.ON_CYCLE_EVENT:
      {
        OnCycleEvent onCycleEvent = (OnCycleEvent)theEObject;
        T result = caseOnCycleEvent(onCycleEvent);
        if (result == null) result = caseBuiltinEventSpec(onCycleEvent);
        if (result == null) result = caseEventSpec(onCycleEvent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.STATE_EXPRESSION:
      {
        StateExpression stateExpression = (StateExpression)theEObject;
        T result = caseStateExpression(stateExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.ENTRY_EXPRESSION:
      {
        EntryExpression entryExpression = (EntryExpression)theEObject;
        T result = caseEntryExpression(entryExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.EXIT_EXPRESSION:
      {
        ExitExpression exitExpression = (ExitExpression)theEObject;
        T result = caseExitExpression(exitExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.ON_TICK_EXPRESSION:
      {
        OnTickExpression onTickExpression = (OnTickExpression)theEObject;
        T result = caseOnTickExpression(onTickExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.EXPRESSION_RULE:
      {
        ExpressionRule expressionRule = (ExpressionRule)theEObject;
        T result = caseExpressionRule(expressionRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.RAISE_EVENT_EXPRESSION:
      {
        RaiseEventExpression raiseEventExpression = (RaiseEventExpression)theEObject;
        T result = caseRaiseEventExpression(raiseEventExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.EXPRESSION:
      {
        Expression expression = (Expression)theEObject;
        T result = caseExpression(expression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.LOGICAL_OR_EXPRESSION:
      {
        LogicalOrExpression logicalOrExpression = (LogicalOrExpression)theEObject;
        T result = caseLogicalOrExpression(logicalOrExpression);
        if (result == null) result = caseExpression(logicalOrExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.LOGICAL_AND_EXPRESSION:
      {
        LogicalAndExpression logicalAndExpression = (LogicalAndExpression)theEObject;
        T result = caseLogicalAndExpression(logicalAndExpression);
        if (result == null) result = caseExpression(logicalAndExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.LOGICAL_NOT_EXPRESSION:
      {
        LogicalNotExpression logicalNotExpression = (LogicalNotExpression)theEObject;
        T result = caseLogicalNotExpression(logicalNotExpression);
        if (result == null) result = caseExpression(logicalNotExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.LOGICAL_RELATION_EXPRESSION:
      {
        LogicalRelationExpression logicalRelationExpression = (LogicalRelationExpression)theEObject;
        T result = caseLogicalRelationExpression(logicalRelationExpression);
        if (result == null) result = caseExpression(logicalRelationExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.NUMERICAL_ADD_SUBTRACT_EXPRESSION:
      {
        NumericalAddSubtractExpression numericalAddSubtractExpression = (NumericalAddSubtractExpression)theEObject;
        T result = caseNumericalAddSubtractExpression(numericalAddSubtractExpression);
        if (result == null) result = caseExpression(numericalAddSubtractExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION:
      {
        NumericalMultiplyDivideExpression numericalMultiplyDivideExpression = (NumericalMultiplyDivideExpression)theEObject;
        T result = caseNumericalMultiplyDivideExpression(numericalMultiplyDivideExpression);
        if (result == null) result = caseExpression(numericalMultiplyDivideExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.NUMERICAL_UNARY_EXPRESSION:
      {
        NumericalUnaryExpression numericalUnaryExpression = (NumericalUnaryExpression)theEObject;
        T result = caseNumericalUnaryExpression(numericalUnaryExpression);
        if (result == null) result = caseExpression(numericalUnaryExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.PRIMITIVE_VALUE_EXPRESSION:
      {
        PrimitiveValueExpression primitiveValueExpression = (PrimitiveValueExpression)theEObject;
        T result = casePrimitiveValueExpression(primitiveValueExpression);
        if (result == null) result = caseExpression(primitiveValueExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ExpressionsPackage.PROPERTY_REFERENCE_EXPRESSION:
      {
        PropertyReferenceExpression propertyReferenceExpression = (PropertyReferenceExpression)theEObject;
        T result = casePropertyReferenceExpression(propertyReferenceExpression);
        if (result == null) result = caseExpression(propertyReferenceExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Root</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Root</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRoot(Root object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Def Root</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Def Root</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDefRoot(DefRoot object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Statechart Root</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Statechart Root</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStatechartRoot(StatechartRoot object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>State Root</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>State Root</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStateRoot(StateRoot object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Transition Root</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transition Root</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransitionRoot(TransitionRoot object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Statechart Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Statechart Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStatechartDefinition(StatechartDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>State Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>State Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStateDefinition(StateDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Transition Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transition Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransitionStatement(TransitionStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Scope</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Scope</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseScope(Scope object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Simple Scope</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Simple Scope</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSimpleScope(SimpleScope object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Statechart Scope</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Statechart Scope</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStatechartScope(StatechartScope object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Interface Scope</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Interface Scope</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInterfaceScope(InterfaceScope object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Internal Scope</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Internal Scope</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInternalScope(InternalScope object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDefinition(Definition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Event Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Event Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEventDefinition(EventDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Event Derivation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Event Derivation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEventDerivation(EventDerivation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Variable Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Variable Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVariableDefinition(VariableDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Clock</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Clock</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClock(Clock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Operation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Operation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOperation(Operation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Entrypoint</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Entrypoint</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEntrypoint(Entrypoint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Exitpoint</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Exitpoint</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExitpoint(Exitpoint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Reaction</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Reaction</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReaction(Reaction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Reaction Trigger</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Reaction Trigger</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReactionTrigger(ReactionTrigger object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Action</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Action</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAction(Action object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Reaction Properties</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Reaction Properties</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReactionProperties(ReactionProperties object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Reaction Property</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Reaction Property</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReactionProperty(ReactionProperty object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Reaction Priority</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Reaction Priority</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReactionPriority(ReactionPriority object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Entry Point Spec</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Entry Point Spec</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEntryPointSpec(EntryPointSpec object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Exit Point Spec</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Exit Point Spec</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExitPointSpec(ExitPointSpec object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Event Spec</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Event Spec</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEventSpec(EventSpec object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Regular Event Spec</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Regular Event Spec</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRegularEventSpec(RegularEventSpec object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Time Event Spec</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Time Event Spec</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTimeEventSpec(TimeEventSpec object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Builtin Event Spec</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Builtin Event Spec</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBuiltinEventSpec(BuiltinEventSpec object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enter Event</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enter Event</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnterEvent(EnterEvent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Exit Event</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Exit Event</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExitEvent(ExitEvent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>On Cycle Event</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>On Cycle Event</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOnCycleEvent(OnCycleEvent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>State Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>State Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStateExpression(StateExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Entry Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Entry Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEntryExpression(EntryExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Exit Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Exit Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExitExpression(ExitExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>On Tick Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>On Tick Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOnTickExpression(OnTickExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpressionRule(ExpressionRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Raise Event Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Raise Event Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRaiseEventExpression(RaiseEventExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpression(Expression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Logical Or Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Logical Or Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLogicalOrExpression(LogicalOrExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Logical And Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Logical And Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLogicalAndExpression(LogicalAndExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Logical Not Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Logical Not Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLogicalNotExpression(LogicalNotExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Logical Relation Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Logical Relation Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLogicalRelationExpression(LogicalRelationExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Numerical Add Subtract Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Numerical Add Subtract Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNumericalAddSubtractExpression(NumericalAddSubtractExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Numerical Multiply Divide Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Numerical Multiply Divide Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNumericalMultiplyDivideExpression(NumericalMultiplyDivideExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Numerical Unary Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Numerical Unary Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNumericalUnaryExpression(NumericalUnaryExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Primitive Value Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Primitive Value Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrimitiveValueExpression(PrimitiveValueExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Property Reference Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Property Reference Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePropertyReferenceExpression(PropertyReferenceExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedElement(NamedElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Event</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Event</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEvent(Event object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVariable(Variable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  public T defaultCase(EObject object)
  {
    return null;
  }

} //ExpressionsSwitch
