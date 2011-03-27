/**
 * <copyright>
 * </copyright>
 *
 */
package org.yakindu.sct.statechart.expressions;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage
 * @generated
 */
public interface ExpressionsFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ExpressionsFactory eINSTANCE = org.yakindu.sct.statechart.expressions.impl.ExpressionsFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Root</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Root</em>'.
   * @generated
   */
  Root createRoot();

  /**
   * Returns a new object of class '<em>Def Root</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Def Root</em>'.
   * @generated
   */
  DefRoot createDefRoot();

  /**
   * Returns a new object of class '<em>Statechart Root</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Statechart Root</em>'.
   * @generated
   */
  StatechartRoot createStatechartRoot();

  /**
   * Returns a new object of class '<em>State Root</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>State Root</em>'.
   * @generated
   */
  StateRoot createStateRoot();

  /**
   * Returns a new object of class '<em>Transition Root</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transition Root</em>'.
   * @generated
   */
  TransitionRoot createTransitionRoot();

  /**
   * Returns a new object of class '<em>Statechart Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Statechart Definition</em>'.
   * @generated
   */
  StatechartDefinition createStatechartDefinition();

  /**
   * Returns a new object of class '<em>State Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>State Definition</em>'.
   * @generated
   */
  StateDefinition createStateDefinition();

  /**
   * Returns a new object of class '<em>Transition Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transition Statement</em>'.
   * @generated
   */
  TransitionStatement createTransitionStatement();

  /**
   * Returns a new object of class '<em>Scope</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Scope</em>'.
   * @generated
   */
  Scope createScope();

  /**
   * Returns a new object of class '<em>Simple Scope</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Simple Scope</em>'.
   * @generated
   */
  SimpleScope createSimpleScope();

  /**
   * Returns a new object of class '<em>Statechart Scope</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Statechart Scope</em>'.
   * @generated
   */
  StatechartScope createStatechartScope();

  /**
   * Returns a new object of class '<em>Interface Scope</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Interface Scope</em>'.
   * @generated
   */
  InterfaceScope createInterfaceScope();

  /**
   * Returns a new object of class '<em>Internal Scope</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Internal Scope</em>'.
   * @generated
   */
  InternalScope createInternalScope();

  /**
   * Returns a new object of class '<em>Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Definition</em>'.
   * @generated
   */
  Definition createDefinition();

  /**
   * Returns a new object of class '<em>Event Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Event Definition</em>'.
   * @generated
   */
  EventDefinition createEventDefinition();

  /**
   * Returns a new object of class '<em>Event Derivation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Event Derivation</em>'.
   * @generated
   */
  EventDerivation createEventDerivation();

  /**
   * Returns a new object of class '<em>Variable Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable Definition</em>'.
   * @generated
   */
  VariableDefinition createVariableDefinition();

  /**
   * Returns a new object of class '<em>Clock</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Clock</em>'.
   * @generated
   */
  Clock createClock();

  /**
   * Returns a new object of class '<em>Operation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Operation</em>'.
   * @generated
   */
  Operation createOperation();

  /**
   * Returns a new object of class '<em>Entrypoint</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Entrypoint</em>'.
   * @generated
   */
  Entrypoint createEntrypoint();

  /**
   * Returns a new object of class '<em>Exitpoint</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Exitpoint</em>'.
   * @generated
   */
  Exitpoint createExitpoint();

  /**
   * Returns a new object of class '<em>Reaction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Reaction</em>'.
   * @generated
   */
  Reaction createReaction();

  /**
   * Returns a new object of class '<em>Reaction Trigger</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Reaction Trigger</em>'.
   * @generated
   */
  ReactionTrigger createReactionTrigger();

  /**
   * Returns a new object of class '<em>Action</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Action</em>'.
   * @generated
   */
  Action createAction();

  /**
   * Returns a new object of class '<em>Reaction Properties</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Reaction Properties</em>'.
   * @generated
   */
  ReactionProperties createReactionProperties();

  /**
   * Returns a new object of class '<em>Reaction Property</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Reaction Property</em>'.
   * @generated
   */
  ReactionProperty createReactionProperty();

  /**
   * Returns a new object of class '<em>Reaction Priority</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Reaction Priority</em>'.
   * @generated
   */
  ReactionPriority createReactionPriority();

  /**
   * Returns a new object of class '<em>Entry Point Spec</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Entry Point Spec</em>'.
   * @generated
   */
  EntryPointSpec createEntryPointSpec();

  /**
   * Returns a new object of class '<em>Exit Point Spec</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Exit Point Spec</em>'.
   * @generated
   */
  ExitPointSpec createExitPointSpec();

  /**
   * Returns a new object of class '<em>Event Spec</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Event Spec</em>'.
   * @generated
   */
  EventSpec createEventSpec();

  /**
   * Returns a new object of class '<em>Regular Event Spec</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Regular Event Spec</em>'.
   * @generated
   */
  RegularEventSpec createRegularEventSpec();

  /**
   * Returns a new object of class '<em>Time Event Spec</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Time Event Spec</em>'.
   * @generated
   */
  TimeEventSpec createTimeEventSpec();

  /**
   * Returns a new object of class '<em>Builtin Event Spec</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Builtin Event Spec</em>'.
   * @generated
   */
  BuiltinEventSpec createBuiltinEventSpec();

  /**
   * Returns a new object of class '<em>Enter Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enter Event</em>'.
   * @generated
   */
  EnterEvent createEnterEvent();

  /**
   * Returns a new object of class '<em>Exit Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Exit Event</em>'.
   * @generated
   */
  ExitEvent createExitEvent();

  /**
   * Returns a new object of class '<em>On Cycle Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>On Cycle Event</em>'.
   * @generated
   */
  OnCycleEvent createOnCycleEvent();

  /**
   * Returns a new object of class '<em>State Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>State Expression</em>'.
   * @generated
   */
  StateExpression createStateExpression();

  /**
   * Returns a new object of class '<em>Entry Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Entry Expression</em>'.
   * @generated
   */
  EntryExpression createEntryExpression();

  /**
   * Returns a new object of class '<em>Exit Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Exit Expression</em>'.
   * @generated
   */
  ExitExpression createExitExpression();

  /**
   * Returns a new object of class '<em>On Tick Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>On Tick Expression</em>'.
   * @generated
   */
  OnTickExpression createOnTickExpression();

  /**
   * Returns a new object of class '<em>Expression Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression Rule</em>'.
   * @generated
   */
  ExpressionRule createExpressionRule();

  /**
   * Returns a new object of class '<em>Raise Event Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Raise Event Expression</em>'.
   * @generated
   */
  RaiseEventExpression createRaiseEventExpression();

  /**
   * Returns a new object of class '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression</em>'.
   * @generated
   */
  Expression createExpression();

  /**
   * Returns a new object of class '<em>Logical Or Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Logical Or Expression</em>'.
   * @generated
   */
  LogicalOrExpression createLogicalOrExpression();

  /**
   * Returns a new object of class '<em>Logical And Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Logical And Expression</em>'.
   * @generated
   */
  LogicalAndExpression createLogicalAndExpression();

  /**
   * Returns a new object of class '<em>Logical Not Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Logical Not Expression</em>'.
   * @generated
   */
  LogicalNotExpression createLogicalNotExpression();

  /**
   * Returns a new object of class '<em>Logical Relation Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Logical Relation Expression</em>'.
   * @generated
   */
  LogicalRelationExpression createLogicalRelationExpression();

  /**
   * Returns a new object of class '<em>Numerical Add Subtract Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Numerical Add Subtract Expression</em>'.
   * @generated
   */
  NumericalAddSubtractExpression createNumericalAddSubtractExpression();

  /**
   * Returns a new object of class '<em>Numerical Multiply Divide Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Numerical Multiply Divide Expression</em>'.
   * @generated
   */
  NumericalMultiplyDivideExpression createNumericalMultiplyDivideExpression();

  /**
   * Returns a new object of class '<em>Numerical Unary Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Numerical Unary Expression</em>'.
   * @generated
   */
  NumericalUnaryExpression createNumericalUnaryExpression();

  /**
   * Returns a new object of class '<em>Primitive Value Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Primitive Value Expression</em>'.
   * @generated
   */
  PrimitiveValueExpression createPrimitiveValueExpression();

  /**
   * Returns a new object of class '<em>Property Reference Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Reference Expression</em>'.
   * @generated
   */
  PropertyReferenceExpression createPropertyReferenceExpression();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ExpressionsPackage getExpressionsPackage();

} //ExpressionsFactory
