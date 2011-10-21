/**
 * <copyright>
 * </copyright>
 *
 */
package org.yakindu.sct.model.stext.stext.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.yakindu.sct.model.sgraph.Declaration;
import org.yakindu.sct.model.sgraph.Effect;
import org.yakindu.sct.model.sgraph.Event;
import org.yakindu.sct.model.sgraph.NamedElement;
import org.yakindu.sct.model.sgraph.Reaction;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.Trigger;
import org.yakindu.sct.model.sgraph.Variable;

import org.yakindu.sct.model.stext.stext.*;

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
 * @see org.yakindu.sct.model.stext.stext.StextPackage
 * @generated
 */
public class StextSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static StextPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StextSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = StextPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case StextPackage.ROOT:
      {
        Root root = (Root)theEObject;
        T result = caseRoot(root);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.DEF_ROOT:
      {
        DefRoot defRoot = (DefRoot)theEObject;
        T result = caseDefRoot(defRoot);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.STATECHART_ROOT:
      {
        StatechartRoot statechartRoot = (StatechartRoot)theEObject;
        T result = caseStatechartRoot(statechartRoot);
        if (result == null) result = caseDefRoot(statechartRoot);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.STATE_ROOT:
      {
        StateRoot stateRoot = (StateRoot)theEObject;
        T result = caseStateRoot(stateRoot);
        if (result == null) result = caseDefRoot(stateRoot);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.TRANSITION_ROOT:
      {
        TransitionRoot transitionRoot = (TransitionRoot)theEObject;
        T result = caseTransitionRoot(transitionRoot);
        if (result == null) result = caseDefRoot(transitionRoot);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.STATECHART_DEFINITION:
      {
        StatechartDefinition statechartDefinition = (StatechartDefinition)theEObject;
        T result = caseStatechartDefinition(statechartDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.STATE_DECLARATION:
      {
        StateDeclaration stateDeclaration = (StateDeclaration)theEObject;
        T result = caseStateDeclaration(stateDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.TRANSITION_STATEMENT:
      {
        TransitionStatement transitionStatement = (TransitionStatement)theEObject;
        T result = caseTransitionStatement(transitionStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.EVENT_DERIVATION:
      {
        EventDerivation eventDerivation = (EventDerivation)theEObject;
        T result = caseEventDerivation(eventDerivation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.LOCAL_REACTION:
      {
        LocalReaction localReaction = (LocalReaction)theEObject;
        T result = caseLocalReaction(localReaction);
        if (result == null) result = caseDeclaration(localReaction);
        if (result == null) result = caseReaction(localReaction);
        if (result == null) result = caseNamedElement(localReaction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.TRANSITION_REACTION:
      {
        TransitionReaction transitionReaction = (TransitionReaction)theEObject;
        T result = caseTransitionReaction(transitionReaction);
        if (result == null) result = caseTransitionStatement(transitionReaction);
        if (result == null) result = caseReaction(transitionReaction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.REACTION_PROPERTIES:
      {
        ReactionProperties reactionProperties = (ReactionProperties)theEObject;
        T result = caseReactionProperties(reactionProperties);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.REACTION_PROPERTY:
      {
        ReactionProperty reactionProperty = (ReactionProperty)theEObject;
        T result = caseReactionProperty(reactionProperty);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.REACTION_PRIORITY:
      {
        ReactionPriority reactionPriority = (ReactionPriority)theEObject;
        T result = caseReactionPriority(reactionPriority);
        if (result == null) result = caseReactionProperty(reactionPriority);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.ENTRY_POINT_SPEC:
      {
        EntryPointSpec entryPointSpec = (EntryPointSpec)theEObject;
        T result = caseEntryPointSpec(entryPointSpec);
        if (result == null) result = caseReactionProperty(entryPointSpec);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.EXIT_POINT_SPEC:
      {
        ExitPointSpec exitPointSpec = (ExitPointSpec)theEObject;
        T result = caseExitPointSpec(exitPointSpec);
        if (result == null) result = caseReactionProperty(exitPointSpec);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.EVENT_SPEC:
      {
        EventSpec eventSpec = (EventSpec)theEObject;
        T result = caseEventSpec(eventSpec);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.REGULAR_EVENT_SPEC:
      {
        RegularEventSpec regularEventSpec = (RegularEventSpec)theEObject;
        T result = caseRegularEventSpec(regularEventSpec);
        if (result == null) result = caseEventSpec(regularEventSpec);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.TIME_EVENT_SPEC:
      {
        TimeEventSpec timeEventSpec = (TimeEventSpec)theEObject;
        T result = caseTimeEventSpec(timeEventSpec);
        if (result == null) result = caseEventSpec(timeEventSpec);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.BUILTIN_EVENT_SPEC:
      {
        BuiltinEventSpec builtinEventSpec = (BuiltinEventSpec)theEObject;
        T result = caseBuiltinEventSpec(builtinEventSpec);
        if (result == null) result = caseEventSpec(builtinEventSpec);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.ENTRY_EVENT:
      {
        EntryEvent entryEvent = (EntryEvent)theEObject;
        T result = caseEntryEvent(entryEvent);
        if (result == null) result = caseBuiltinEventSpec(entryEvent);
        if (result == null) result = caseEventSpec(entryEvent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.EXIT_EVENT:
      {
        ExitEvent exitEvent = (ExitEvent)theEObject;
        T result = caseExitEvent(exitEvent);
        if (result == null) result = caseBuiltinEventSpec(exitEvent);
        if (result == null) result = caseEventSpec(exitEvent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.ON_CYCLE_EVENT:
      {
        OnCycleEvent onCycleEvent = (OnCycleEvent)theEObject;
        T result = caseOnCycleEvent(onCycleEvent);
        if (result == null) result = caseBuiltinEventSpec(onCycleEvent);
        if (result == null) result = caseEventSpec(onCycleEvent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.ALWAYS_EVENT:
      {
        AlwaysEvent alwaysEvent = (AlwaysEvent)theEObject;
        T result = caseAlwaysEvent(alwaysEvent);
        if (result == null) result = caseBuiltinEventSpec(alwaysEvent);
        if (result == null) result = caseEventSpec(alwaysEvent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.STATEMENT:
      {
        Statement statement = (Statement)theEObject;
        T result = caseStatement(statement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.ASSIGNMENT:
      {
        Assignment assignment = (Assignment)theEObject;
        T result = caseAssignment(assignment);
        if (result == null) result = caseStatement(assignment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.EVENT_RAISING:
      {
        EventRaising eventRaising = (EventRaising)theEObject;
        T result = caseEventRaising(eventRaising);
        if (result == null) result = caseStatement(eventRaising);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.EXPRESSION:
      {
        Expression expression = (Expression)theEObject;
        T result = caseExpression(expression);
        if (result == null) result = caseStatement(expression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.SIMPLE_SCOPE:
      {
        SimpleScope simpleScope = (SimpleScope)theEObject;
        T result = caseSimpleScope(simpleScope);
        if (result == null) result = caseScope(simpleScope);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.INTERFACE_SCOPE:
      {
        InterfaceScope interfaceScope = (InterfaceScope)theEObject;
        T result = caseInterfaceScope(interfaceScope);
        if (result == null) result = caseScope(interfaceScope);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.INTERNAL_SCOPE:
      {
        InternalScope internalScope = (InternalScope)theEObject;
        T result = caseInternalScope(internalScope);
        if (result == null) result = caseScope(internalScope);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.EVENT_DEFINITION:
      {
        EventDefinition eventDefinition = (EventDefinition)theEObject;
        T result = caseEventDefinition(eventDefinition);
        if (result == null) result = caseEvent(eventDefinition);
        if (result == null) result = caseDeclaration(eventDefinition);
        if (result == null) result = caseNamedElement(eventDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.VARIABLE_DEFINITION:
      {
        VariableDefinition variableDefinition = (VariableDefinition)theEObject;
        T result = caseVariableDefinition(variableDefinition);
        if (result == null) result = caseVariable(variableDefinition);
        if (result == null) result = caseDeclaration(variableDefinition);
        if (result == null) result = caseNamedElement(variableDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.CLOCK:
      {
        Clock clock = (Clock)theEObject;
        T result = caseClock(clock);
        if (result == null) result = caseDeclaration(clock);
        if (result == null) result = caseNamedElement(clock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.OPERATION:
      {
        Operation operation = (Operation)theEObject;
        T result = caseOperation(operation);
        if (result == null) result = caseDeclaration(operation);
        if (result == null) result = caseNamedElement(operation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.ENTRYPOINT:
      {
        Entrypoint entrypoint = (Entrypoint)theEObject;
        T result = caseEntrypoint(entrypoint);
        if (result == null) result = caseDeclaration(entrypoint);
        if (result == null) result = caseNamedElement(entrypoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.EXITPOINT:
      {
        Exitpoint exitpoint = (Exitpoint)theEObject;
        T result = caseExitpoint(exitpoint);
        if (result == null) result = caseDeclaration(exitpoint);
        if (result == null) result = caseNamedElement(exitpoint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.REACTION_TRIGGER:
      {
        ReactionTrigger reactionTrigger = (ReactionTrigger)theEObject;
        T result = caseReactionTrigger(reactionTrigger);
        if (result == null) result = caseTrigger(reactionTrigger);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.REACTION_EFFECT:
      {
        ReactionEffect reactionEffect = (ReactionEffect)theEObject;
        T result = caseReactionEffect(reactionEffect);
        if (result == null) result = caseEffect(reactionEffect);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.CONDITIONAL_EXPRESSION:
      {
        ConditionalExpression conditionalExpression = (ConditionalExpression)theEObject;
        T result = caseConditionalExpression(conditionalExpression);
        if (result == null) result = caseExpression(conditionalExpression);
        if (result == null) result = caseStatement(conditionalExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.LOGICAL_OR_EXPRESSION:
      {
        LogicalOrExpression logicalOrExpression = (LogicalOrExpression)theEObject;
        T result = caseLogicalOrExpression(logicalOrExpression);
        if (result == null) result = caseExpression(logicalOrExpression);
        if (result == null) result = caseStatement(logicalOrExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.LOGICAL_AND_EXPRESSION:
      {
        LogicalAndExpression logicalAndExpression = (LogicalAndExpression)theEObject;
        T result = caseLogicalAndExpression(logicalAndExpression);
        if (result == null) result = caseExpression(logicalAndExpression);
        if (result == null) result = caseStatement(logicalAndExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.LOGICAL_NOT_EXPRESSION:
      {
        LogicalNotExpression logicalNotExpression = (LogicalNotExpression)theEObject;
        T result = caseLogicalNotExpression(logicalNotExpression);
        if (result == null) result = caseExpression(logicalNotExpression);
        if (result == null) result = caseStatement(logicalNotExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.BITWISE_XOR_EXPRESSION:
      {
        BitwiseXorExpression bitwiseXorExpression = (BitwiseXorExpression)theEObject;
        T result = caseBitwiseXorExpression(bitwiseXorExpression);
        if (result == null) result = caseExpression(bitwiseXorExpression);
        if (result == null) result = caseStatement(bitwiseXorExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.BITWISE_OR_EXPRESSION:
      {
        BitwiseOrExpression bitwiseOrExpression = (BitwiseOrExpression)theEObject;
        T result = caseBitwiseOrExpression(bitwiseOrExpression);
        if (result == null) result = caseExpression(bitwiseOrExpression);
        if (result == null) result = caseStatement(bitwiseOrExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.BITWISE_AND_EXPRESSION:
      {
        BitwiseAndExpression bitwiseAndExpression = (BitwiseAndExpression)theEObject;
        T result = caseBitwiseAndExpression(bitwiseAndExpression);
        if (result == null) result = caseExpression(bitwiseAndExpression);
        if (result == null) result = caseStatement(bitwiseAndExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.LOGICAL_RELATION_EXPRESSION:
      {
        LogicalRelationExpression logicalRelationExpression = (LogicalRelationExpression)theEObject;
        T result = caseLogicalRelationExpression(logicalRelationExpression);
        if (result == null) result = caseExpression(logicalRelationExpression);
        if (result == null) result = caseStatement(logicalRelationExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.SHIFT_EXPRESSION:
      {
        ShiftExpression shiftExpression = (ShiftExpression)theEObject;
        T result = caseShiftExpression(shiftExpression);
        if (result == null) result = caseExpression(shiftExpression);
        if (result == null) result = caseStatement(shiftExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.NUMERICAL_ADD_SUBTRACT_EXPRESSION:
      {
        NumericalAddSubtractExpression numericalAddSubtractExpression = (NumericalAddSubtractExpression)theEObject;
        T result = caseNumericalAddSubtractExpression(numericalAddSubtractExpression);
        if (result == null) result = caseExpression(numericalAddSubtractExpression);
        if (result == null) result = caseStatement(numericalAddSubtractExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION:
      {
        NumericalMultiplyDivideExpression numericalMultiplyDivideExpression = (NumericalMultiplyDivideExpression)theEObject;
        T result = caseNumericalMultiplyDivideExpression(numericalMultiplyDivideExpression);
        if (result == null) result = caseExpression(numericalMultiplyDivideExpression);
        if (result == null) result = caseStatement(numericalMultiplyDivideExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.NUMERICAL_UNARY_EXPRESSION:
      {
        NumericalUnaryExpression numericalUnaryExpression = (NumericalUnaryExpression)theEObject;
        T result = caseNumericalUnaryExpression(numericalUnaryExpression);
        if (result == null) result = caseExpression(numericalUnaryExpression);
        if (result == null) result = caseStatement(numericalUnaryExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.PRIMITIVE_VALUE_EXPRESSION:
      {
        PrimitiveValueExpression primitiveValueExpression = (PrimitiveValueExpression)theEObject;
        T result = casePrimitiveValueExpression(primitiveValueExpression);
        if (result == null) result = caseExpression(primitiveValueExpression);
        if (result == null) result = caseStatement(primitiveValueExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.ELEMENT_REFERENCE_EXPRESSION:
      {
        ElementReferenceExpression elementReferenceExpression = (ElementReferenceExpression)theEObject;
        T result = caseElementReferenceExpression(elementReferenceExpression);
        if (result == null) result = caseExpression(elementReferenceExpression);
        if (result == null) result = caseStatement(elementReferenceExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case StextPackage.OPERATION_CALL:
      {
        OperationCall operationCall = (OperationCall)theEObject;
        T result = caseOperationCall(operationCall);
        if (result == null) result = caseExpression(operationCall);
        if (result == null) result = caseStatement(operationCall);
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
   * Returns the result of interpreting the object as an instance of '<em>State Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>State Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStateDeclaration(StateDeclaration object)
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
   * Returns the result of interpreting the object as an instance of '<em>Local Reaction</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Local Reaction</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLocalReaction(LocalReaction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Transition Reaction</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transition Reaction</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransitionReaction(TransitionReaction object)
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
   * Returns the result of interpreting the object as an instance of '<em>Entry Event</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Entry Event</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEntryEvent(EntryEvent object)
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
   * Returns the result of interpreting the object as an instance of '<em>Always Event</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Always Event</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAlwaysEvent(AlwaysEvent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStatement(Statement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Assignment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Assignment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssignment(Assignment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Event Raising</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Event Raising</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEventRaising(EventRaising object)
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
   * Returns the result of interpreting the object as an instance of '<em>Reaction Effect</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Reaction Effect</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReactionEffect(ReactionEffect object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Conditional Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Conditional Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConditionalExpression(ConditionalExpression object)
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
   * Returns the result of interpreting the object as an instance of '<em>Bitwise Xor Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bitwise Xor Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBitwiseXorExpression(BitwiseXorExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Bitwise Or Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bitwise Or Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBitwiseOrExpression(BitwiseOrExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Bitwise And Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bitwise And Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBitwiseAndExpression(BitwiseAndExpression object)
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
   * Returns the result of interpreting the object as an instance of '<em>Shift Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Shift Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseShiftExpression(ShiftExpression object)
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
   * Returns the result of interpreting the object as an instance of '<em>Element Reference Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Element Reference Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseElementReferenceExpression(ElementReferenceExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Operation Call</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Operation Call</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOperationCall(OperationCall object)
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
   * Returns the result of interpreting the object as an instance of '<em>Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDeclaration(Declaration object)
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
   * Returns the result of interpreting the object as an instance of '<em>Trigger</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Trigger</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTrigger(Trigger object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Effect</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Effect</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEffect(Effect object)
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
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //StextSwitch
