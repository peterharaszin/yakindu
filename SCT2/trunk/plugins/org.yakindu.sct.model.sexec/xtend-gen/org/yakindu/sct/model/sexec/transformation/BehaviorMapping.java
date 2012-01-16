package org.yakindu.sct.model.sexec.transformation;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.ComparableExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.EObjectExtensions;
import org.yakindu.sct.model.sexec.Call;
import org.yakindu.sct.model.sexec.Check;
import org.yakindu.sct.model.sexec.Execution;
import org.yakindu.sct.model.sexec.ExecutionChoice;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.ExecutionScope;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.Reaction;
import org.yakindu.sct.model.sexec.ReactionFired;
import org.yakindu.sct.model.sexec.ScheduleTimeEvent;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.SexecFactory;
import org.yakindu.sct.model.sexec.StateSwitch;
import org.yakindu.sct.model.sexec.StateVector;
import org.yakindu.sct.model.sexec.Step;
import org.yakindu.sct.model.sexec.TimeEvent;
import org.yakindu.sct.model.sexec.TraceStateEntered;
import org.yakindu.sct.model.sexec.TraceStateExited;
import org.yakindu.sct.model.sexec.UnscheduleTimeEvent;
import org.yakindu.sct.model.sexec.transformation.SequenceBuilder;
import org.yakindu.sct.model.sexec.transformation.SexecElementMapping;
import org.yakindu.sct.model.sexec.transformation.SexecExtensions;
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions;
import org.yakindu.sct.model.sexec.transformation.StateVectorBuilder;
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions;
import org.yakindu.sct.model.sexec.transformation.StextExtensions;
import org.yakindu.sct.model.sexec.transformation.TraceExtensions;
import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.CompositeElement;
import org.yakindu.sct.model.sgraph.Effect;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Trigger;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.model.stext.stext.EventSpec;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.IntLiteral;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.MultiplicativeOperator;
import org.yakindu.sct.model.stext.stext.NumericalMultiplyDivideExpression;
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.stext.TimeEventSpec;
import org.yakindu.sct.model.stext.stext.TimeUnit;

@SuppressWarnings("all")
public class BehaviorMapping {
  
  @Inject
  private StatechartExtensions sc;
  
  @Inject
  private StextExtensions stext;
  
  @Inject
  private SexecExtensions sexec;
  
  @Inject
  private SexecElementMapping factory;
  
  @Inject
  private SgraphExtensions sgraph;
  
  @Inject
  private StextExtensions stext_1;
  
  @Inject
  private StateVectorBuilder svBuilder;
  
  @Inject
  private SequenceBuilder seqBuilder;
  
  @Inject
  private TraceExtensions trace;
  
  public ExecutionFlow mapEntryActions(final Statechart statechart, final ExecutionFlow r) {
    {
      List<RegularState> _allRegularStates = this.sc.allRegularStates(statechart);
      Iterable<State> _filter = IterableExtensions.<State>filter(_allRegularStates, org.yakindu.sct.model.sgraph.State.class);
      final Iterable<State> allStates = _filter;
      final Function1<State,Object> _function = new Function1<State,Object>() {
          public Object apply(final State s) {
            Object _xblockexpression = null;
            {
              ExecutionState _create = BehaviorMapping.this.factory.create(s);
              Step _mapEntryAction = BehaviorMapping.this.mapEntryAction(s);
              _create.setEntryAction(_mapEntryAction);
              _xblockexpression = (null);
            }
            return _xblockexpression;
          }
        };
      IterableExtensions.<State>forEach(allStates, _function);
      return r;
    }
  }
  
  public Step mapEntryAction(final State state) {
    Sequence _xblockexpression = null;
    {
      SexecFactory _factory = this.sexec.factory();
      Sequence _createSequence = _factory.createSequence();
      final Sequence seq = _createSequence;
      seq.setName("entryAction");
      String _name = state.getName();
      String _operator_plus = StringExtensions.operator_plus("Entry action for state \'", _name);
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "\'.");
      seq.setComment(_operator_plus_1);
      List<TimeEventSpec> _timeEventSpecs = this.sc.timeEventSpecs(state);
      for (final TimeEventSpec tes : _timeEventSpecs) {
        {
          TimeEvent _createDerivedEvent = this.factory.createDerivedEvent(tes);
          final TimeEvent timeEvent = _createDerivedEvent;
          Statement _buildValueExpression = this.buildValueExpression(tes);
          ScheduleTimeEvent _newScheduleTimeEvent = this.factory.newScheduleTimeEvent(timeEvent, _buildValueExpression);
          final ScheduleTimeEvent scheduleStep = _newScheduleTimeEvent;
          EList<Step> _steps = seq.getSteps();
          _steps.add(scheduleStep);
        }
      }
      List<LocalReaction> _entryReactions = this.sc.entryReactions(state);
      final Function1<LocalReaction,Sequence> _function = new Function1<LocalReaction,Sequence>() {
          public Sequence apply(final LocalReaction lr) {
            Sequence _xifexpression = null;
            Effect _effect = lr.getEffect();
            boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_effect, null);
            if (_operator_notEquals) {
              Effect _effect_1 = lr.getEffect();
              Sequence _mapEffect = BehaviorMapping.this.mapEffect(((ReactionEffect) _effect_1));
              _xifexpression = _mapEffect;
            } else {
              _xifexpression = null;
            }
            return _xifexpression;
          }
        };
      List<Sequence> _map = ListExtensions.<LocalReaction, Sequence>map(_entryReactions, _function);
      final Function1<Sequence,Boolean> _function_1 = new Function1<Sequence,Boolean>() {
          public Boolean apply(final Sequence e) {
            Boolean _xifexpression_1 = null;
            boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(e, null);
            if (_operator_notEquals_1) {
              EList<Step> _steps_1 = seq.getSteps();
              boolean _add = _steps_1.add(e);
              _xifexpression_1 = _add;
            }
            return _xifexpression_1;
          }
        };
      IterableExtensions.<Sequence>forEach(_map, _function_1);
      Sequence _xifexpression_2 = null;
      EList<Step> _steps_2 = seq.getSteps();
      int _size = _steps_2.size();
      boolean _operator_greaterThan = ComparableExtensions.<Integer>operator_greaterThan(((Integer)_size), ((Integer)0));
      if (_operator_greaterThan) {
        _xifexpression_2 = seq;
      } else {
        _xifexpression_2 = null;
      }
      _xblockexpression = (_xifexpression_2);
    }
    return _xblockexpression;
  }
  
  public ExecutionFlow mapExitActions(final Statechart statechart, final ExecutionFlow r) {
    {
      List<RegularState> _allRegularStates = this.sc.allRegularStates(statechart);
      Iterable<State> _filter = IterableExtensions.<State>filter(_allRegularStates, org.yakindu.sct.model.sgraph.State.class);
      final Iterable<State> allStates = _filter;
      final Function1<State,Object> _function = new Function1<State,Object>() {
          public Object apply(final State s) {
            Object _xblockexpression = null;
            {
              ExecutionState _create = BehaviorMapping.this.factory.create(s);
              Step _mapExitAction = BehaviorMapping.this.mapExitAction(s);
              _create.setExitAction(_mapExitAction);
              _xblockexpression = (null);
            }
            return _xblockexpression;
          }
        };
      IterableExtensions.<State>forEach(allStates, _function);
      return r;
    }
  }
  
  public Step mapExitAction(final State state) {
    Sequence _xblockexpression = null;
    {
      SexecFactory _factory = this.sexec.factory();
      Sequence _createSequence = _factory.createSequence();
      final Sequence seq = _createSequence;
      seq.setName("exitAction");
      String _name = state.getName();
      String _operator_plus = StringExtensions.operator_plus("Exit action for state \'", _name);
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, "\'.");
      seq.setComment(_operator_plus_1);
      List<TimeEventSpec> _timeEventSpecs = this.sc.timeEventSpecs(state);
      for (final TimeEventSpec tes : _timeEventSpecs) {
        {
          TimeEvent _createDerivedEvent = this.factory.createDerivedEvent(tes);
          final TimeEvent timeEvent = _createDerivedEvent;
          UnscheduleTimeEvent _newUnscheduleTimeEvent = this.factory.newUnscheduleTimeEvent(timeEvent);
          final UnscheduleTimeEvent unscheduleStep = _newUnscheduleTimeEvent;
          EList<Step> _steps = seq.getSteps();
          _steps.add(unscheduleStep);
        }
      }
      List<LocalReaction> _exitReactions = this.sc.exitReactions(state);
      final Function1<LocalReaction,Sequence> _function = new Function1<LocalReaction,Sequence>() {
          public Sequence apply(final LocalReaction lr) {
            Sequence _xifexpression = null;
            Effect _effect = lr.getEffect();
            boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_effect, null);
            if (_operator_notEquals) {
              Effect _effect_1 = lr.getEffect();
              Sequence _mapEffect = BehaviorMapping.this.mapEffect(((ReactionEffect) _effect_1));
              _xifexpression = _mapEffect;
            } else {
              _xifexpression = null;
            }
            return _xifexpression;
          }
        };
      List<Sequence> _map = ListExtensions.<LocalReaction, Sequence>map(_exitReactions, _function);
      final Function1<Sequence,Boolean> _function_1 = new Function1<Sequence,Boolean>() {
          public Boolean apply(final Sequence e) {
            Boolean _xifexpression_1 = null;
            boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(e, null);
            if (_operator_notEquals_1) {
              EList<Step> _steps_1 = seq.getSteps();
              boolean _add = _steps_1.add(e);
              _xifexpression_1 = _add;
            }
            return _xifexpression_1;
          }
        };
      IterableExtensions.<Sequence>forEach(_map, _function_1);
      Sequence _xifexpression_2 = null;
      EList<Step> _steps_2 = seq.getSteps();
      int _size = _steps_2.size();
      boolean _operator_greaterThan = ComparableExtensions.<Integer>operator_greaterThan(((Integer)_size), ((Integer)0));
      if (_operator_greaterThan) {
        _xifexpression_2 = seq;
      } else {
        _xifexpression_2 = null;
      }
      _xblockexpression = (_xifexpression_2);
    }
    return _xblockexpression;
  }
  
  public Statement buildValueExpression(final TimeEventSpec tes) {
    Statement _xblockexpression = null;
    {
      StextFactory _factory = this.stext.factory();
      PrimitiveValueExpression _createPrimitiveValueExpression = _factory.createPrimitiveValueExpression();
      final PrimitiveValueExpression pve = _createPrimitiveValueExpression;
      StextFactory _factory_1 = this.stext.factory();
      IntLiteral _createIntLiteral = _factory_1.createIntLiteral();
      final IntLiteral intLit = _createIntLiteral;
      int _value = tes.getValue();
      intLit.setValue(_value);
      pve.setValue(intLit);
      Statement _switchResult = null;
      TimeUnit _unit = tes.getUnit();
      final TimeUnit __valOfSwitchOver = _unit;
      boolean matched = false;
      if (!matched) {
        if (org.eclipse.xtext.xbase.lib.ObjectExtensions.operator_equals(__valOfSwitchOver,TimeUnit.MILLISECOND)) {
          matched=true;
          _switchResult = pve;
        }
      }
      if (!matched) {
        if (org.eclipse.xtext.xbase.lib.ObjectExtensions.operator_equals(__valOfSwitchOver,TimeUnit.NANOSECOND)) {
          matched=true;
          Statement _divide = this.divide(pve, 1000000);
          _switchResult = _divide;
        }
      }
      if (!matched) {
        if (org.eclipse.xtext.xbase.lib.ObjectExtensions.operator_equals(__valOfSwitchOver,TimeUnit.SECOND)) {
          matched=true;
          Statement _multiply = this.multiply(pve, 1000);
          _switchResult = _multiply;
        }
      }
      if (!matched) {
        _switchResult = pve;
      }
      _xblockexpression = (_switchResult);
    }
    return _xblockexpression;
  }
  
  public Statement divide(final Expression stmnt, final long divisor) {
    NumericalMultiplyDivideExpression _xblockexpression = null;
    {
      StextFactory _factory = this.stext.factory();
      NumericalMultiplyDivideExpression _createNumericalMultiplyDivideExpression = _factory.createNumericalMultiplyDivideExpression();
      final NumericalMultiplyDivideExpression div = _createNumericalMultiplyDivideExpression;
      StextFactory _factory_1 = this.stext.factory();
      PrimitiveValueExpression _createPrimitiveValueExpression = _factory_1.createPrimitiveValueExpression();
      final PrimitiveValueExpression pve = _createPrimitiveValueExpression;
      StextFactory _factory_2 = this.stext.factory();
      IntLiteral _createIntLiteral = _factory_2.createIntLiteral();
      final IntLiteral intLit = _createIntLiteral;
      int _intValue = ((Long)divisor).intValue();
      intLit.setValue(_intValue);
      pve.setValue(intLit);
      div.setOperator(MultiplicativeOperator.DIV);
      div.setLeftOperand(stmnt);
      div.setRightOperand(pve);
      _xblockexpression = (div);
    }
    return _xblockexpression;
  }
  
  public Statement multiply(final Expression stmnt, final long factor) {
    NumericalMultiplyDivideExpression _xblockexpression = null;
    {
      StextFactory _factory = this.stext.factory();
      NumericalMultiplyDivideExpression _createNumericalMultiplyDivideExpression = _factory.createNumericalMultiplyDivideExpression();
      final NumericalMultiplyDivideExpression div = _createNumericalMultiplyDivideExpression;
      StextFactory _factory_1 = this.stext.factory();
      PrimitiveValueExpression _createPrimitiveValueExpression = _factory_1.createPrimitiveValueExpression();
      final PrimitiveValueExpression pve = _createPrimitiveValueExpression;
      StextFactory _factory_2 = this.stext.factory();
      IntLiteral _createIntLiteral = _factory_2.createIntLiteral();
      final IntLiteral intLit = _createIntLiteral;
      int _intValue = ((Long)factor).intValue();
      intLit.setValue(_intValue);
      pve.setValue(intLit);
      div.setOperator(MultiplicativeOperator.MUL);
      div.setLeftOperand(stmnt);
      div.setRightOperand(pve);
      _xblockexpression = (div);
    }
    return _xblockexpression;
  }
  
  protected Sequence _mapEffect(final Effect effect) {
    return null;
  }
  
  protected Sequence _mapEffect(final ReactionEffect effect) {
    Sequence _xifexpression = null;
    EList<Statement> _actions = effect.getActions();
    boolean _isEmpty = _actions.isEmpty();
    boolean _operator_not = BooleanExtensions.operator_not(_isEmpty);
    if (_operator_not) {
      {
        SexecFactory _factory = this.sexec.factory();
        Sequence _createSequence = _factory.createSequence();
        final Sequence sequence = _createSequence;
        sequence.setName("reaction_action");
        EList<Step> _steps = sequence.getSteps();
        EList<Statement> _actions_1 = effect.getActions();
        final Function1<Statement,Execution> _function = new Function1<Statement,Execution>() {
            public Execution apply(final Statement stmnt) {
              Execution _mapToExecution = BehaviorMapping.this.mapToExecution(stmnt);
              return _mapToExecution;
            }
          };
        List<Execution> _map = ListExtensions.<Statement, Execution>map(_actions_1, _function);
        _steps.addAll(_map);
        return sequence;
      }
    }
    return _xifexpression;
  }
  
  public Execution mapToExecution(final Statement stmnt) {
    Execution _xblockexpression = null;
    {
      SexecFactory _factory = this.sexec.factory();
      Execution _createExecution = _factory.createExecution();
      final Execution exec = _createExecution;
      Statement _copy = EcoreUtil.<Statement>copy(stmnt);
      exec.setStatement(_copy);
      _xblockexpression = (exec);
    }
    return _xblockexpression;
  }
  
  public ExecutionFlow mapTransitions(final Statechart statechart, final ExecutionFlow r) {
    {
      Iterable<EObject> _allContentsIterable = EObjectExtensions.allContentsIterable(statechart);
      Iterable<EObject> content = _allContentsIterable;
      Iterable<State> _filter = IterableExtensions.<State>filter(content, org.yakindu.sct.model.sgraph.State.class);
      final Iterable<State> allStates = _filter;
      final Function1<State,ExecutionState> _function = new Function1<State,ExecutionState>() {
          public ExecutionState apply(final State s) {
            ExecutionState _mapStateTransition = BehaviorMapping.this.mapStateTransition(s);
            return _mapStateTransition;
          }
        };
      IterableExtensions.<State>forEach(allStates, _function);
      return r;
    }
  }
  
  public ExecutionState mapStateTransition(final State state) {
    {
      ExecutionState _create = this.factory.create(state);
      final ExecutionState _state = _create;
      EList<Reaction> _reactions = _state.getReactions();
      EList<Transition> _outgoingTransitions = state.getOutgoingTransitions();
      final Function1<Transition,Reaction> _function = new Function1<Transition,Reaction>() {
          public Reaction apply(final Transition t) {
            Reaction _mapTransition = BehaviorMapping.this.mapTransition(t);
            return _mapTransition;
          }
        };
      List<Reaction> _map = ListExtensions.<Transition, Reaction>map(_outgoingTransitions, _function);
      _reactions.addAll(_map);
      return _state;
    }
  }
  
  public Reaction mapTransition(final Transition t) {
    {
      Reaction _create = this.factory.create(t);
      final Reaction r = _create;
      Trigger _trigger = t.getTrigger();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_trigger, null);
      if (_operator_notEquals) {
        Trigger _trigger_1 = t.getTrigger();
        Check _mapToCheck = this.mapToCheck(_trigger_1);
        r.setCheck(_mapToCheck);
      }
      Sequence _mapToEffect = this.mapToEffect(t, r);
      r.setEffect(_mapToEffect);
      return r;
    }
  }
  
  protected Check _mapToCheck(final Trigger tr) {
    return null;
  }
  
  protected Check _mapToCheck(final ReactionTrigger tr) {
    {
      Check _createCheck = this.factory.createCheck(tr);
      final Check check = _createCheck;
      Statement _buildCondition = this.buildCondition(tr);
      check.setCondition(_buildCondition);
      return check;
    }
  }
  
  public ExecutionFlow mapLocalReactions(final Statechart statechart, final ExecutionFlow r) {
    {
      Iterable<EObject> _allContentsIterable = EObjectExtensions.allContentsIterable(statechart);
      Iterable<EObject> content = _allContentsIterable;
      Iterable<State> _filter = IterableExtensions.<State>filter(content, org.yakindu.sct.model.sgraph.State.class);
      final Iterable<State> allStates = _filter;
      final Function1<State,ExecutionState> _function = new Function1<State,ExecutionState>() {
          public ExecutionState apply(final State s) {
            ExecutionState _mapStateLocalReactions = BehaviorMapping.this.mapStateLocalReactions(((State) s));
            return _mapStateLocalReactions;
          }
        };
      IterableExtensions.<State>forEach(allStates, _function);
      return r;
    }
  }
  
  public ExecutionState mapStateLocalReactions(final State state) {
    {
      ExecutionState _create = this.factory.create(state);
      final ExecutionState _state = _create;
      EList<Reaction> _reactions = _state.getReactions();
      EList<org.yakindu.sct.model.sgraph.Reaction> _localReactions = state.getLocalReactions();
      Iterable<LocalReaction> _filter = IterableExtensions.<LocalReaction>filter(_localReactions, org.yakindu.sct.model.stext.stext.LocalReaction.class);
      final Function1<LocalReaction,Boolean> _function = new Function1<LocalReaction,Boolean>() {
          public Boolean apply(final LocalReaction lr) {
            boolean _operator_or = false;
            Trigger _trigger = lr.getTrigger();
            EList<EventSpec> _triggers = ((ReactionTrigger) _trigger).getTriggers();
            boolean _isEmpty = _triggers.isEmpty();
            if (_isEmpty) {
              _operator_or = true;
            } else {
              Trigger _trigger_1 = lr.getTrigger();
              EList<EventSpec> _triggers_1 = ((ReactionTrigger) _trigger_1).getTriggers();
              final Function1<EventSpec,Boolean> _function_1 = new Function1<EventSpec,Boolean>() {
                  public Boolean apply(final EventSpec t) {
                    boolean _operator_or_1 = false;
                    boolean _operator_or_2 = false;
                    boolean _operator_or_3 = false;
                    if ((t instanceof org.yakindu.sct.model.stext.stext.RegularEventSpec)) {
                      _operator_or_3 = true;
                    } else {
                      _operator_or_3 = BooleanExtensions.operator_or((t instanceof org.yakindu.sct.model.stext.stext.RegularEventSpec), (t instanceof org.yakindu.sct.model.stext.stext.TimeEventSpec));
                    }
                    if (_operator_or_3) {
                      _operator_or_2 = true;
                    } else {
                      _operator_or_2 = BooleanExtensions.operator_or(_operator_or_3, (t instanceof org.yakindu.sct.model.stext.stext.OnCycleEvent));
                    }
                    if (_operator_or_2) {
                      _operator_or_1 = true;
                    } else {
                      _operator_or_1 = BooleanExtensions.operator_or(_operator_or_2, (t instanceof org.yakindu.sct.model.stext.stext.AlwaysEvent));
                    }
                    return ((Boolean)_operator_or_1);
                  }
                };
              Iterable<EventSpec> _filter_1 = IterableExtensions.<EventSpec>filter(_triggers_1, _function_1);
              List<EventSpec> _list = IterableExtensions.<EventSpec>toList(_filter_1);
              boolean _isEmpty_1 = _list.isEmpty();
              boolean _operator_not = BooleanExtensions.operator_not(_isEmpty_1);
              _operator_or = BooleanExtensions.operator_or(_isEmpty, _operator_not);
            }
            return ((Boolean)_operator_or);
          }
        };
      Iterable<LocalReaction> _filter_2 = IterableExtensions.<LocalReaction>filter(_filter, _function);
      final Function1<LocalReaction,Reaction> _function_2 = new Function1<LocalReaction,Reaction>() {
          public Reaction apply(final LocalReaction t_1) {
            Reaction _mapReaction = BehaviorMapping.this.mapReaction(t_1);
            return _mapReaction;
          }
        };
      Iterable<Reaction> _map = IterableExtensions.<LocalReaction, Reaction>map(_filter_2, _function_2);
      CollectionExtensions.<Reaction>addAll(_reactions, _map);
      return _state;
    }
  }
  
  public Reaction mapReaction(final LocalReaction lr) {
    {
      Reaction _create = this.factory.create(lr);
      final Reaction r = _create;
      Trigger _trigger = lr.getTrigger();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_trigger, null);
      if (_operator_notEquals) {
        Trigger _trigger_1 = lr.getTrigger();
        Check _mapToCheck = this.mapToCheck(_trigger_1);
        r.setCheck(_mapToCheck);
      }
      Sequence _mapToEffect = this.mapToEffect(lr);
      r.setEffect(_mapToEffect);
      return r;
    }
  }
  
  public Sequence mapToEffect(final LocalReaction lr) {
    Sequence _xifexpression = null;
    Effect _effect = lr.getEffect();
    boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_effect, null);
    if (_operator_notEquals) {
      Effect _effect_1 = lr.getEffect();
      Sequence _mapEffect = this.mapEffect(_effect_1);
      _xifexpression = _mapEffect;
    }
    return _xifexpression;
  }
  
  public Sequence mapToEffect(final Transition t, final Reaction r) {
    {
      SexecFactory _factory = this.sexec.factory();
      Sequence _createSequence = _factory.createSequence();
      final Sequence sequence = _createSequence;
      Iterable<State> _exitStates = this.exitStates(t);
      State _last = IterableExtensions.<State>last(_exitStates);
      final State topExitState = _last;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(topExitState, null);
      if (_operator_notEquals) {
        {
          ArrayList<RegularState> _arrayList = new ArrayList<RegularState>();
          List<RegularState> _collectLeafStates = this.sgraph.collectLeafStates(topExitState, _arrayList);
          final Function1<RegularState,ExecutionState> _function = new Function1<RegularState,ExecutionState>() {
              public ExecutionState apply(final RegularState rs) {
                ExecutionState _create = BehaviorMapping.this.factory.create(rs);
                return _create;
              }
            };
          List<ExecutionState> _map = ListExtensions.<RegularState, ExecutionState>map(_collectLeafStates, _function);
          final List<ExecutionState> leafStates = _map;
          StateVector _stateVector = this.svBuilder.stateVector(topExitState);
          final StateVector topVector = _stateVector;
          Vertex _source = t.getSource();
          StateVector _stateVector_1 = this.svBuilder.stateVector(_source);
          final StateVector sourceVector = _stateVector_1;
          int _offset = topVector.getOffset();
          int _offset_1 = sourceVector.getOffset();
          Iterable<Integer> _operator_upTo = IntegerExtensions.operator_upTo(((Integer)_offset), ((Integer)_offset_1));
          int _offset_2 = sourceVector.getOffset();
          int _offset_3 = topVector.getOffset();
          int _operator_minus = IntegerExtensions.operator_minus(((Integer)_offset_2), ((Integer)_offset_3));
          Iterable<Integer> _take = IterableExtensions.<Integer>take(_operator_upTo, _operator_minus);
          final Iterable<Integer> prepositions = _take;
          for (final Integer i : prepositions) {
            {
              ExecutionState _create_1 = this.factory.create(topExitState);
              StateSwitch _defineExitSwitch = this.seqBuilder.defineExitSwitch(_create_1, leafStates, i);
              StateSwitch sSwitch = _defineExitSwitch;
              EList<Step> _steps = sequence.getSteps();
              _steps.add(sSwitch);
            }
          }
        }
      }
      boolean _operator_and = false;
      Vertex _source_1 = t.getSource();
      boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_source_1, null);
      if (!_operator_notEquals_1) {
        _operator_and = false;
      } else {
        Vertex _source_2 = t.getSource();
        _operator_and = BooleanExtensions.operator_and(_operator_notEquals_1, (_source_2 instanceof org.yakindu.sct.model.sgraph.RegularState));
      }
      if (_operator_and) {
        EList<Step> _steps_1 = sequence.getSteps();
        Vertex _source_3 = t.getSource();
        ExecutionState _create_2 = this.factory.create(((RegularState) _source_3));
        Sequence _exitSequence = _create_2.getExitSequence();
        Call _newCall = this.factory.newCall(_exitSequence);
        _steps_1.add(_newCall);
      }
      Iterable<State> _exitStates_1 = this.exitStates(t);
      final Function2<Sequence,State,Sequence> _function_1 = new Function2<Sequence,State,Sequence>() {
          public Sequence apply(final Sequence seq , final State state) {
            Sequence _xblockexpression = null;
            {
              boolean _operator_and_1 = false;
              Vertex _source_4 = t.getSource();
              boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(state, _source_4);
              if (!_operator_notEquals_2) {
                _operator_and_1 = false;
              } else {
                boolean _operator_notEquals_3 = ObjectExtensions.operator_notEquals(state, topExitState);
                _operator_and_1 = BooleanExtensions.operator_and(_operator_notEquals_2, _operator_notEquals_3);
              }
              if (_operator_and_1) {
                Vertex _source_5 = t.getSource();
                StateVector _stateVector_2 = BehaviorMapping.this.svBuilder.stateVector(_source_5);
                int _last_1 = BehaviorMapping.this.sexec.last(_stateVector_2);
                ExecutionState _create_3 = BehaviorMapping.this.factory.create(state);
                StateVector _stateVector_3 = _create_3.getStateVector();
                int _last_2 = BehaviorMapping.this.sexec.last(_stateVector_3);
                boolean _operator_equals = ObjectExtensions.operator_equals(((Integer)_last_1), ((Integer)_last_2));
                if (_operator_equals) {
                  {
                    ExecutionState _create_4 = BehaviorMapping.this.factory.create(state);
                    Step _exitAction = _create_4.getExitAction();
                    boolean _operator_notEquals_4 = ObjectExtensions.operator_notEquals(_exitAction, null);
                    if (_operator_notEquals_4) {
                      EList<Step> _steps_2 = seq.getSteps();
                      ExecutionState _create_5 = BehaviorMapping.this.factory.create(state);
                      Step _exitAction_1 = _create_5.getExitAction();
                      Call _newCall_1 = BehaviorMapping.this.factory.newCall(_exitAction_1);
                      _steps_2.add(_newCall_1);
                    }
                    boolean _isAddTraceSteps = BehaviorMapping.this.trace.isAddTraceSteps();
                    if (_isAddTraceSteps) {
                      EList<Step> _steps_3 = seq.getSteps();
                      ExecutionState _create_6 = BehaviorMapping.this.factory.create(state);
                      TraceStateExited _newTraceStateExited = BehaviorMapping.this.trace.newTraceStateExited(_create_6);
                      _steps_3.add(_newTraceStateExited);
                    }
                  }
                }
              }
              _xblockexpression = (seq);
            }
            return _xblockexpression;
          }
        };
      IterableExtensions.<State, Sequence>fold(_exitStates_1, sequence, _function_1);
      boolean _operator_notEquals_5 = ObjectExtensions.operator_notEquals(topExitState, null);
      if (_operator_notEquals_5) {
        {
          ArrayList<RegularState> _arrayList_1 = new ArrayList<RegularState>();
          List<RegularState> _collectLeafStates_1 = this.sgraph.collectLeafStates(topExitState, _arrayList_1);
          final Function1<RegularState,ExecutionState> _function_2 = new Function1<RegularState,ExecutionState>() {
              public ExecutionState apply(final RegularState rs_1) {
                ExecutionState _create_7 = BehaviorMapping.this.factory.create(rs_1);
                return _create_7;
              }
            };
          List<ExecutionState> _map_1 = ListExtensions.<RegularState, ExecutionState>map(_collectLeafStates_1, _function_2);
          final List<ExecutionState> leafStates_1 = _map_1;
          StateVector _stateVector_4 = this.svBuilder.stateVector(topExitState);
          final StateVector topVector_1 = _stateVector_4;
          Vertex _source_6 = t.getSource();
          StateVector _stateVector_5 = this.svBuilder.stateVector(_source_6);
          final StateVector sourceVector_1 = _stateVector_5;
          int _last_3 = this.sexec.last(sourceVector_1);
          int _last_4 = this.sexec.last(topVector_1);
          Iterable<Integer> _operator_upTo_1 = IntegerExtensions.operator_upTo(((Integer)_last_3), ((Integer)_last_4));
          Iterable<Integer> _drop = IterableExtensions.<Integer>drop(_operator_upTo_1, 1);
          final Iterable<Integer> postpositions = _drop;
          for (final Integer i_1 : postpositions) {
            {
              ExecutionState _create_8 = this.factory.create(topExitState);
              StateSwitch _defineExitSwitch_1 = this.seqBuilder.defineExitSwitch(_create_8, leafStates_1, i_1);
              StateSwitch sSwitch_1 = _defineExitSwitch_1;
              EList<Step> _steps_4 = sequence.getSteps();
              _steps_4.add(sSwitch_1);
            }
          }
        }
      }
      Vertex _source_7 = t.getSource();
      boolean _operator_notEquals_6 = ObjectExtensions.operator_notEquals(topExitState, _source_7);
      if (_operator_notEquals_6) {
        {
          ExecutionState _create_9 = this.factory.create(topExitState);
          Step _exitAction_2 = _create_9.getExitAction();
          boolean _operator_notEquals_7 = ObjectExtensions.operator_notEquals(_exitAction_2, null);
          if (_operator_notEquals_7) {
            EList<Step> _steps_5 = sequence.getSteps();
            ExecutionState _create_10 = this.factory.create(topExitState);
            Step _exitAction_3 = _create_10.getExitAction();
            Call _newCall_2 = this.factory.newCall(_exitAction_3);
            _steps_5.add(_newCall_2);
          }
          boolean _isAddTraceSteps_1 = this.trace.isAddTraceSteps();
          if (_isAddTraceSteps_1) {
            EList<Step> _steps_6 = sequence.getSteps();
            ExecutionState _create_11 = this.factory.create(topExitState);
            TraceStateExited _newTraceStateExited_1 = this.trace.newTraceStateExited(_create_11);
            CollectionExtensions.<Step>operator_add(_steps_6, _newTraceStateExited_1);
          }
        }
      }
      Effect _effect = t.getEffect();
      boolean _operator_notEquals_8 = ObjectExtensions.operator_notEquals(_effect, null);
      if (_operator_notEquals_8) {
        EList<Step> _steps_7 = sequence.getSteps();
        Effect _effect_1 = t.getEffect();
        Sequence _mapEffect = this.mapEffect(_effect_1);
        _steps_7.add(_mapEffect);
      }
      boolean _isAddTraceSteps_2 = this.trace.isAddTraceSteps();
      if (_isAddTraceSteps_2) {
        EList<Step> _steps_8 = sequence.getSteps();
        ReactionFired _newTraceReactionFired = this.trace.newTraceReactionFired(r);
        CollectionExtensions.<Step>operator_add(_steps_8, _newTraceReactionFired);
      }
      List<ExecutionScope> _entryScopes = this.entryScopes(t);
      Iterable<ExecutionScope> _drop_1 = IterableExtensions.<ExecutionScope>drop(_entryScopes, 1);
      List<ExecutionScope> _list = IterableExtensions.<ExecutionScope>toList(_drop_1);
      List<ExecutionScope> _reverse = ListExtensions.<ExecutionScope>reverse(_list);
      final Function2<Sequence,ExecutionScope,Sequence> _function_3 = new Function2<Sequence,ExecutionScope,Sequence>() {
          public Sequence apply(final Sequence seq_1 , final ExecutionScope scope) {
            Sequence _xblockexpression_1 = null;
            {
              if ((scope instanceof org.yakindu.sct.model.sexec.ExecutionRegion)) {
                {
                  ExecutionScope _superScope = scope.getSuperScope();
                  EList<ExecutionScope> _subScopes = _superScope.getSubScopes();
                  final EList<ExecutionScope> siblingRegions = _subScopes;
                  int _indexOf = siblingRegions.indexOf(scope);
                  Iterable<ExecutionScope> _take_1 = IterableExtensions.<ExecutionScope>take(siblingRegions, _indexOf);
                  for (final ExecutionScope region : _take_1) {
                    Sequence _enterSequence = region.getEnterSequence();
                    boolean _operator_notEquals_9 = ObjectExtensions.operator_notEquals(_enterSequence, null);
                    if (_operator_notEquals_9) {
                      EList<Step> _steps_9 = seq_1.getSteps();
                      Sequence _enterSequence_1 = region.getEnterSequence();
                      Call _newCall_3 = BehaviorMapping.this.factory.newCall(_enterSequence_1);
                      _steps_9.add(_newCall_3);
                    }
                  }
                }
              }
              if ((scope instanceof org.yakindu.sct.model.sexec.ExecutionState)) {
                {
                  Step _entryAction = ((ExecutionState) scope).getEntryAction();
                  boolean _operator_notEquals_10 = ObjectExtensions.operator_notEquals(_entryAction, null);
                  if (_operator_notEquals_10) {
                    EList<Step> _steps_10 = seq_1.getSteps();
                    Step _entryAction_1 = ((ExecutionState) scope).getEntryAction();
                    Call _newCall_4 = BehaviorMapping.this.factory.newCall(_entryAction_1);
                    _steps_10.add(_newCall_4);
                  }
                  boolean _isAddTraceSteps_3 = BehaviorMapping.this.trace.isAddTraceSteps();
                  if (_isAddTraceSteps_3) {
                    EList<Step> _steps_11 = seq_1.getSteps();
                    TraceStateEntered _newTraceStateEntered = BehaviorMapping.this.trace.newTraceStateEntered(((ExecutionState) scope));
                    _steps_11.add(_newTraceStateEntered);
                  }
                }
              }
              _xblockexpression_1 = (seq_1);
            }
            return _xblockexpression_1;
          }
        };
      IterableExtensions.<ExecutionScope, Sequence>fold(_reverse, sequence, _function_3);
      Vertex _target = t.getTarget();
      boolean _operator_notEquals_11 = ObjectExtensions.operator_notEquals(_target, null);
      if (_operator_notEquals_11) {
        {
          Vertex _target_1 = t.getTarget();
          Region _parentRegion = _target_1.getParentRegion();
          CompositeElement _composite = _parentRegion.getComposite();
          EList<Region> _regions = _composite.getRegions();
          final EList<Region> siblingRegions_1 = _regions;
          Vertex _target_2 = t.getTarget();
          if ((_target_2 instanceof org.yakindu.sct.model.sgraph.RegularState)) {
            EList<Step> _steps_12 = sequence.getSteps();
            Vertex _target_3 = t.getTarget();
            ExecutionState _create_12 = this.factory.create(((RegularState) _target_3));
            Sequence _enterSequence_2 = _create_12.getEnterSequence();
            Call _newCall_5 = this.factory.newCall(_enterSequence_2);
            _steps_12.add(_newCall_5);
          } else {
            Vertex _target_4 = t.getTarget();
            if ((_target_4 instanceof org.yakindu.sct.model.sgraph.Choice)) {
              EList<Step> _steps_13 = sequence.getSteps();
              Vertex _target_5 = t.getTarget();
              ExecutionChoice _create_13 = this.factory.create(((Choice) _target_5));
              Sequence _reactSequence = _create_13.getReactSequence();
              Call _newCall_6 = this.factory.newCall(_reactSequence);
              _steps_13.add(_newCall_6);
            }
          }
        }
      }
      List<ExecutionScope> _entryScopes_1 = this.entryScopes(t);
      Iterable<ExecutionScope> _drop_2 = IterableExtensions.<ExecutionScope>drop(_entryScopes_1, 1);
      final Function2<Sequence,ExecutionScope,Sequence> _function_4 = new Function2<Sequence,ExecutionScope,Sequence>() {
          public Sequence apply(final Sequence seq_2 , final ExecutionScope scope_1) {
            Sequence _xblockexpression_2 = null;
            {
              if ((scope_1 instanceof org.yakindu.sct.model.sexec.ExecutionRegion)) {
                {
                  ExecutionScope _superScope_1 = scope_1.getSuperScope();
                  EList<ExecutionScope> _subScopes_1 = _superScope_1.getSubScopes();
                  final EList<ExecutionScope> siblingRegions_2 = _subScopes_1;
                  int _indexOf_1 = siblingRegions_2.indexOf(scope_1);
                  int _operator_plus = IntegerExtensions.operator_plus(((Integer)_indexOf_1), ((Integer)1));
                  Iterable<ExecutionScope> _drop_3 = IterableExtensions.<ExecutionScope>drop(siblingRegions_2, _operator_plus);
                  for (final ExecutionScope region_1 : _drop_3) {
                    Sequence _enterSequence_3 = region_1.getEnterSequence();
                    boolean _operator_notEquals_12 = ObjectExtensions.operator_notEquals(_enterSequence_3, null);
                    if (_operator_notEquals_12) {
                      EList<Step> _steps_14 = seq_2.getSteps();
                      Sequence _enterSequence_4 = region_1.getEnterSequence();
                      Call _newCall_7 = BehaviorMapping.this.factory.newCall(_enterSequence_4);
                      _steps_14.add(_newCall_7);
                    }
                  }
                }
              }
              _xblockexpression_2 = (seq_2);
            }
            return _xblockexpression_2;
          }
        };
      IterableExtensions.<ExecutionScope, Sequence>fold(_drop_2, sequence, _function_4);
      return sequence;
    }
  }
  
  public List<ExecutionScope> entryScopes(final Transition t) {
    List<ExecutionScope> _xblockexpression = null;
    {
      Vertex _target = t.getTarget();
      List<EObject> _containers = this.sgraph.containers(_target);
      final List<EObject> l = _containers;
      Vertex _source = t.getSource();
      List<EObject> _containers_1 = this.sgraph.containers(_source);
      l.removeAll(_containers_1);
      final Function1<EObject,ExecutionScope> _function = new Function1<EObject,ExecutionScope>() {
          public ExecutionScope apply(final EObject c) {
            ExecutionScope _xifexpression = null;
            if ((c instanceof org.yakindu.sct.model.sgraph.RegularState)) {
              ExecutionState _create = BehaviorMapping.this.factory.create(((RegularState) c));
              _xifexpression = ((ExecutionScope) _create);
            } else {
              ExecutionScope _xifexpression_1 = null;
              if ((c instanceof org.yakindu.sct.model.sgraph.Region)) {
                ExecutionRegion _create_1 = BehaviorMapping.this.factory.create(((Region) c));
                _xifexpression_1 = ((ExecutionScope) _create_1);
              } else {
                ExecutionScope _xifexpression_2 = null;
                if ((c instanceof org.yakindu.sct.model.sgraph.Statechart)) {
                  ExecutionFlow _create_2 = BehaviorMapping.this.factory.create(((Statechart) c));
                  _xifexpression_2 = ((ExecutionScope) _create_2);
                }
                _xifexpression_1 = _xifexpression_2;
              }
              _xifexpression = _xifexpression_1;
            }
            return _xifexpression;
          }
        };
      List<ExecutionScope> _map = ListExtensions.<EObject, ExecutionScope>map(l, _function);
      List<ExecutionScope> _list = IterableExtensions.<ExecutionScope>toList(_map);
      _xblockexpression = (_list);
    }
    return _xblockexpression;
  }
  
  public Iterable<State> exitStates(final Transition t) {
    Iterable<State> _xblockexpression = null;
    {
      Vertex _source = t.getSource();
      List<EObject> _containers = this.sgraph.containers(_source);
      final List<EObject> l = _containers;
      Vertex _target = t.getTarget();
      List<EObject> _containers_1 = this.sgraph.containers(_target);
      l.removeAll(_containers_1);
      Iterable<State> _filter = IterableExtensions.<State>filter(l, org.yakindu.sct.model.sgraph.State.class);
      _xblockexpression = (_filter);
    }
    return _xblockexpression;
  }
  
  public Iterable<State> entryStates(final Transition t) {
    Iterable<State> _xblockexpression = null;
    {
      Vertex _target = t.getTarget();
      List<EObject> _containers = this.sgraph.containers(_target);
      final List<EObject> l = _containers;
      Vertex _source = t.getSource();
      List<EObject> _containers_1 = this.sgraph.containers(_source);
      l.removeAll(_containers_1);
      Iterable<State> _filter = IterableExtensions.<State>filter(l, org.yakindu.sct.model.sgraph.State.class);
      _xblockexpression = (_filter);
    }
    return _xblockexpression;
  }
  
  public Iterable<ExecutionScope> exitScopes(final Transition t) {
    Iterable<ExecutionScope> _xblockexpression = null;
    {
      Vertex _source = t.getSource();
      final Vertex source = _source;
      ExecutionState _switchResult = null;
      final Vertex source_1 = source;
      boolean matched = false;
      if (!matched) {
        if (source_1 instanceof RegularState) {
          final RegularState source_2 = (RegularState) source_1;
          matched=true;
          ExecutionState _create = this.factory.create(source_2);
          _switchResult = _create;
        }
      }
      ExecutionState executionSource = _switchResult;
      Vertex _target = t.getTarget();
      final Vertex target = _target;
      ExecutionState _switchResult_1 = null;
      final Vertex source_3 = source;
      boolean matched_1 = false;
      if (!matched_1) {
        if (source_3 instanceof RegularState) {
          final RegularState source_4 = (RegularState) source_3;
          matched_1=true;
          ExecutionState _create_1 = this.factory.create(source_4);
          _switchResult_1 = _create_1;
        }
      }
      ExecutionState executionTarget = _switchResult_1;
      List<EObject> _containers = this.sgraph.containers(executionSource);
      final List<EObject> l = _containers;
      List<EObject> _containers_1 = this.sgraph.containers(executionTarget);
      l.removeAll(_containers_1);
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  protected Statement _buildCondition(final Trigger t) {
    return null;
  }
  
  protected Statement _buildCondition(final ReactionTrigger t) {
    Expression _xblockexpression = null;
    {
      Expression _xifexpression = null;
      EList<EventSpec> _triggers = t.getTriggers();
      boolean _isEmpty = _triggers.isEmpty();
      boolean _operator_not = BooleanExtensions.operator_not(_isEmpty);
      if (_operator_not) {
        EList<EventSpec> _triggers_1 = t.getTriggers();
        Iterable<EventSpec> _reverseView = ListExtensions.<EventSpec>reverseView(_triggers_1);
        final Function2<Expression,EventSpec,Expression> _function = new Function2<Expression,EventSpec,Expression>() {
            public Expression apply(final Expression s , final EventSpec e) {
              Expression _xblockexpression_1 = null;
              {
                Expression _raised = BehaviorMapping.this.factory.raised(e);
                final Expression raised = _raised;
                Expression _xifexpression_1 = null;
                boolean _operator_equals = ObjectExtensions.operator_equals(raised, null);
                if (_operator_equals) {
                  _xifexpression_1 = s;
                } else {
                  Expression _xifexpression_2 = null;
                  boolean _operator_equals_1 = ObjectExtensions.operator_equals(s, null);
                  if (_operator_equals_1) {
                    _xifexpression_2 = raised;
                  } else {
                    Expression _or = BehaviorMapping.this.stext.or(raised, s);
                    _xifexpression_2 = _or;
                  }
                  _xifexpression_1 = _xifexpression_2;
                }
                _xblockexpression_1 = (_xifexpression_1);
              }
              return _xblockexpression_1;
            }
          };
        Expression _fold = IterableExtensions.<EventSpec, Expression>fold(_reverseView, ((Expression) null), _function);
        _xifexpression = _fold;
      } else {
        _xifexpression = null;
      }
      final Expression triggerCheck = _xifexpression;
      Expression _xifexpression_3 = null;
      Expression _guardExpression = t.getGuardExpression();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_guardExpression, null);
      if (_operator_notEquals) {
        Expression _guardExpression_1 = t.getGuardExpression();
        Expression _copy = EcoreUtil.<Expression>copy(_guardExpression_1);
        _xifexpression_3 = _copy;
      } else {
        _xifexpression_3 = null;
      }
      final Expression guard = _xifexpression_3;
      Expression _xifexpression_4 = null;
      boolean _operator_and = false;
      boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(triggerCheck, null);
      if (!_operator_notEquals_1) {
        _operator_and = false;
      } else {
        boolean _operator_notEquals_2 = ObjectExtensions.operator_notEquals(guard, null);
        _operator_and = BooleanExtensions.operator_and(_operator_notEquals_1, _operator_notEquals_2);
      }
      if (_operator_and) {
        Expression _and = this.stext.and(triggerCheck, guard);
        _xifexpression_4 = _and;
      } else {
        Expression _xifexpression_5 = null;
        boolean _operator_notEquals_3 = ObjectExtensions.operator_notEquals(triggerCheck, null);
        if (_operator_notEquals_3) {
          _xifexpression_5 = triggerCheck;
        } else {
          _xifexpression_5 = guard;
        }
        _xifexpression_4 = _xifexpression_5;
      }
      _xblockexpression = (_xifexpression_4);
    }
    return _xblockexpression;
  }
  
  public Sequence mapEffect(final Effect effect) {
    if ((effect instanceof ReactionEffect)) {
      return _mapEffect((ReactionEffect)effect);
    } else if ((effect instanceof Effect)) {
      return _mapEffect((Effect)effect);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(effect).toString());
    }
  }
  
  public Check mapToCheck(final Trigger tr) {
    if ((tr instanceof ReactionTrigger)) {
      return _mapToCheck((ReactionTrigger)tr);
    } else if ((tr instanceof Trigger)) {
      return _mapToCheck((Trigger)tr);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(tr).toString());
    }
  }
  
  public Statement buildCondition(final Trigger t) {
    if ((t instanceof ReactionTrigger)) {
      return _buildCondition((ReactionTrigger)t);
    } else if ((t instanceof Trigger)) {
      return _buildCondition((Trigger)t);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(t).toString());
    }
  }
}