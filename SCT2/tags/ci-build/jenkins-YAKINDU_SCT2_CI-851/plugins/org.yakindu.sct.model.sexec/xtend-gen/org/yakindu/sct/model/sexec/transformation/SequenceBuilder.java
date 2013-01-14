package org.yakindu.sct.model.sexec.transformation;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.yakindu.sct.model.sexec.Call;
import org.yakindu.sct.model.sexec.EnterState;
import org.yakindu.sct.model.sexec.Execution;
import org.yakindu.sct.model.sexec.ExecutionEntry;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.ExecutionScope;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.ExitState;
import org.yakindu.sct.model.sexec.SaveHistory;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.SexecFactory;
import org.yakindu.sct.model.sexec.StateCase;
import org.yakindu.sct.model.sexec.StateSwitch;
import org.yakindu.sct.model.sexec.StateVector;
import org.yakindu.sct.model.sexec.Step;
import org.yakindu.sct.model.sexec.TraceStateEntered;
import org.yakindu.sct.model.sexec.TraceStateExited;
import org.yakindu.sct.model.sexec.transformation.SexecElementMapping;
import org.yakindu.sct.model.sexec.transformation.SexecExtensions;
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions;
import org.yakindu.sct.model.sexec.transformation.StextExtensions;
import org.yakindu.sct.model.sexec.transformation.TraceExtensions;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.NamedElement;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Variable;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.model.stext.stext.Assignment;
import org.yakindu.sct.model.stext.stext.AssignmentOperator;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

@SuppressWarnings("all")
public class SequenceBuilder {
  
  @Inject
  private SgraphExtensions sgraph;
  
  @Inject
  private StextExtensions stext;
  
  @Inject
  private SexecExtensions sexec;
  
  @Inject
  private SexecElementMapping mapping;
  
  @Inject
  private TraceExtensions trace;
  
  @Inject
  @Named("ADD_TRACES")
  private boolean _addTraceSteps;
  
  public void defineStateEnterSequences(final ExecutionFlow flow, final Statechart sc) {
    EList<Region> _regions = sc.getRegions();
    for (final Region r : _regions) {
      this.defineStateEnterSequence(r);
    }
  }
  
  protected void _defineStateEnterSequence(final Region r) {
    {
      ExecutionRegion _create = this.mapping.create(r);
      final ExecutionRegion execState = _create;
      SexecFactory _factory = this.sexec.factory();
      Sequence _createSequence = _factory.createSequence();
      final Sequence seq = _createSequence;
      seq.setName("enterSequence");
      String _name = r.getName();
      String _operator_plus = StringExtensions.operator_plus("Default enter sequence for region ", _name);
      seq.setComment(_operator_plus);
      EList<Vertex> _vertices = r.getVertices();
      for (final Vertex s : _vertices) {
        this.defineStateEnterSequence(s);
      }
      Entry _entry = this.sgraph.entry(r);
      ExecutionEntry _create_1 = this.mapping==null?(ExecutionEntry)null:this.mapping.create(_entry);
      final ExecutionEntry entryNode = _create_1;
      boolean _operator_and = false;
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(entryNode, null);
      if (!_operator_notEquals) {
        _operator_and = false;
      } else {
        Sequence _reactSequence = entryNode.getReactSequence();
        boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_reactSequence, null);
        _operator_and = BooleanExtensions.operator_and(_operator_notEquals, _operator_notEquals_1);
      }
      if (_operator_and) {
        EList<Step> _steps = seq.getSteps();
        Sequence _reactSequence_1 = entryNode.getReactSequence();
        Call _newCall = this.mapping.newCall(_reactSequence_1);
        _steps.add(_newCall);
      }
      execState.setEnterSequence(seq);
    }
  }
  
  protected void _defineStateEnterSequence(final Vertex v) {
  }
  
  protected void _defineStateEnterSequence(final FinalState state) {
    {
      ExecutionState _create = this.mapping.create(state);
      final ExecutionState execState = _create;
      SexecFactory _factory = this.sexec.factory();
      Sequence _createSequence = _factory.createSequence();
      final Sequence seq = _createSequence;
      seq.setName("enterSequence");
      String _name = state.getName();
      String _operator_plus = StringExtensions.operator_plus("Default enter sequence for state ", _name);
      seq.setComment(_operator_plus);
      Step _entryAction = execState.getEntryAction();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_entryAction, null);
      if (_operator_notEquals) {
        EList<Step> _steps = seq.getSteps();
        Step _entryAction_1 = execState.getEntryAction();
        Call _newCall = this.mapping.newCall(_entryAction_1);
        _steps.add(_newCall);
      }
      if (this._addTraceSteps) {
        EList<Step> _steps_1 = seq.getSteps();
        TraceStateEntered _newTraceStateEntered = this.trace.newTraceStateEntered(execState);
        CollectionExtensions.<Step>operator_add(_steps_1, _newTraceStateEntered);
      }
      EList<Step> _steps_2 = seq.getSteps();
      EnterState _newEnterStateStep = this.sexec.newEnterStateStep(execState);
      CollectionExtensions.<Step>operator_add(_steps_2, _newEnterStateStep);
      execState.setEnterSequence(seq);
    }
  }
  
  protected void _defineStateEnterSequence(final State state) {
    {
      ExecutionState _create = this.mapping.create(state);
      final ExecutionState execState = _create;
      SexecFactory _factory = this.sexec.factory();
      Sequence _createSequence = _factory.createSequence();
      final Sequence seq = _createSequence;
      seq.setName("enterSequence");
      String _name = state.getName();
      String _operator_plus = StringExtensions.operator_plus("Default enter sequence for state ", _name);
      seq.setComment(_operator_plus);
      Step _entryAction = execState.getEntryAction();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_entryAction, null);
      if (_operator_notEquals) {
        EList<Step> _steps = seq.getSteps();
        Step _entryAction_1 = execState.getEntryAction();
        Call _newCall = this.mapping.newCall(_entryAction_1);
        _steps.add(_newCall);
      }
      if (this._addTraceSteps) {
        EList<Step> _steps_1 = seq.getSteps();
        TraceStateEntered _newTraceStateEntered = this.trace.newTraceStateEntered(execState);
        CollectionExtensions.<Step>operator_add(_steps_1, _newTraceStateEntered);
      }
      boolean _isLeaf = execState.isLeaf();
      if (_isLeaf) {
        EList<Step> _steps_2 = seq.getSteps();
        EnterState _newEnterStateStep = this.sexec.newEnterStateStep(execState);
        CollectionExtensions.<Step>operator_add(_steps_2, _newEnterStateStep);
      } else {
        EList<Region> _regions = state.getRegions();
        for (final Region r : _regions) {
          {
            this.defineStateEnterSequence(r);
            ExecutionRegion _create_1 = this.mapping.create(r);
            final ExecutionRegion execRegion = _create_1;
            Sequence _enterSequence = execRegion.getEnterSequence();
            boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_enterSequence, null);
            if (_operator_notEquals_1) {
              EList<Step> _steps_3 = seq.getSteps();
              Sequence _enterSequence_1 = execRegion.getEnterSequence();
              Call _newCall_1 = this.mapping.newCall(_enterSequence_1);
              _steps_3.add(_newCall_1);
            }
          }
        }
      }
      execState.setEnterSequence(seq);
    }
  }
  
  public void defineStateExitSequences(final ExecutionFlow flow, final Statechart sc) {
    EList<Region> _regions = sc.getRegions();
    for (final Region r : _regions) {
      this.defineStateExitSequence(r);
    }
  }
  
  protected void _defineStateExitSequence(final Region r) {
    {
      ExecutionRegion _create = this.mapping.create(r);
      final ExecutionRegion execRegion = _create;
      SexecFactory _factory = this.sexec.factory();
      Sequence _createSequence = _factory.createSequence();
      final Sequence seq = _createSequence;
      seq.setName("exitSequence");
      String _name = r.getName();
      String _operator_plus = StringExtensions.operator_plus("Default exit sequence for region ", _name);
      seq.setComment(_operator_plus);
      EList<Vertex> _vertices = r.getVertices();
      for (final Vertex s : _vertices) {
        this.defineStateExitSequence(s);
      }
      Iterable<Entry> _collectEntries = this.sgraph.collectEntries(r);
      final Function1<Entry,Boolean> _function = new Function1<Entry,Boolean>() {
          public Boolean apply(final Entry e) {
            boolean _operator_or = false;
            EntryKind _kind = e.getKind();
            boolean _operator_equals = ObjectExtensions.operator_equals(_kind, EntryKind.DEEP_HISTORY);
            if (_operator_equals) {
              _operator_or = true;
            } else {
              EntryKind _kind_1 = e.getKind();
              boolean _operator_equals_1 = ObjectExtensions.operator_equals(_kind_1, EntryKind.SHALLOW_HISTORY);
              _operator_or = BooleanExtensions.operator_or(_operator_equals, _operator_equals_1);
            }
            return ((Boolean)_operator_or);
          }
        };
      boolean _exists = IterableExtensions.<Entry>exists(_collectEntries, _function);
      if (_exists) {
        EList<Step> _steps = seq.getSteps();
        Iterable<Entry> _collectEntries_1 = this.sgraph.collectEntries(r);
        final Function1<Entry,Boolean> _function_1 = new Function1<Entry,Boolean>() {
            public Boolean apply(final Entry e_1) {
              EntryKind _kind_2 = e_1.getKind();
              boolean _operator_equals_2 = ObjectExtensions.operator_equals(_kind_2, EntryKind.DEEP_HISTORY);
              return ((Boolean)_operator_equals_2);
            }
          };
        boolean _exists_1 = IterableExtensions.<Entry>exists(_collectEntries_1, _function_1);
        SaveHistory _newSaveHistory = this.sexec.newSaveHistory(execRegion, _exists_1);
        CollectionExtensions.<Step>operator_add(_steps, _newSaveHistory);
      }
      ArrayList<RegularState> _arrayList = new ArrayList<RegularState>();
      List<RegularState> _collectLeafStates = this.sgraph.collectLeafStates(r, _arrayList);
      final Function1<RegularState,ExecutionState> _function_2 = new Function1<RegularState,ExecutionState>() {
          public ExecutionState apply(final RegularState rs) {
            ExecutionState _create_1 = SequenceBuilder.this.mapping.create(rs);
            return _create_1;
          }
        };
      List<ExecutionState> _map = ListExtensions.<RegularState, ExecutionState>map(_collectLeafStates, _function_2);
      final Iterable<ExecutionState> leafStates = _map;
      StateVector _stateVector = execRegion.getStateVector();
      final StateVector sVector = _stateVector;
      int _offset = sVector.getOffset();
      int _offset_1 = sVector.getOffset();
      int _size = sVector.getSize();
      int _operator_plus_1 = IntegerExtensions.operator_plus(((Integer)_offset_1), ((Integer)_size));
      int _operator_minus = IntegerExtensions.operator_minus(((Integer)_operator_plus_1), ((Integer)1));
      Iterable<Integer> _operator_upTo = IntegerExtensions.operator_upTo(((Integer)_offset), ((Integer)_operator_minus));
      for (final Integer i : _operator_upTo) {
        {
          StateSwitch _defineExitSwitch = this.defineExitSwitch(execRegion, leafStates, i);
          final StateSwitch sSwitch = _defineExitSwitch;
          EList<Step> _steps_1 = seq.getSteps();
          _steps_1.add(sSwitch);
        }
      }
      execRegion.setExitSequence(seq);
    }
  }
  
  protected void _defineStateExitSequence(final Vertex v) {
  }
  
  protected void _defineStateExitSequence(final FinalState s) {
    {
      ExecutionState _create = this.mapping.create(s);
      final ExecutionState execState = _create;
      SexecFactory _factory = this.sexec.factory();
      Sequence _createSequence = _factory.createSequence();
      final Sequence seq = _createSequence;
      seq.setName("exitSequence");
      seq.setComment("Default exit sequence for final state.");
      EList<Step> _steps = seq.getSteps();
      ExitState _newExitStateStep = this.sexec.newExitStateStep(execState);
      CollectionExtensions.<Step>operator_add(_steps, _newExitStateStep);
      if (this._addTraceSteps) {
        EList<Step> _steps_1 = seq.getSteps();
        TraceStateExited _newTraceStateExited = this.trace.newTraceStateExited(execState);
        CollectionExtensions.<Step>operator_add(_steps_1, _newTraceStateExited);
      }
      execState.setExitSequence(seq);
    }
  }
  
  protected void _defineStateExitSequence(final State state) {
    {
      ExecutionState _create = this.mapping.create(state);
      final ExecutionState execState = _create;
      SexecFactory _factory = this.sexec.factory();
      Sequence _createSequence = _factory.createSequence();
      final Sequence seq = _createSequence;
      seq.setName("exitSequence");
      String _name = state.getName();
      String _operator_plus = StringExtensions.operator_plus("Default exit sequence for state ", _name);
      seq.setComment(_operator_plus);
      boolean _isLeaf = execState.isLeaf();
      if (_isLeaf) {
        EList<Step> _steps = seq.getSteps();
        ExitState _newExitStateStep = this.sexec.newExitStateStep(execState);
        CollectionExtensions.<Step>operator_add(_steps, _newExitStateStep);
      } else {
        EList<Region> _regions = state.getRegions();
        for (final Region r : _regions) {
          {
            this.defineStateExitSequence(r);
            ExecutionRegion _create_1 = this.mapping.create(r);
            final ExecutionRegion execRegion = _create_1;
            Sequence _exitSequence = execRegion.getExitSequence();
            boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_exitSequence, null);
            if (_operator_notEquals) {
              EList<Step> _steps_1 = seq.getSteps();
              Sequence _exitSequence_1 = execRegion.getExitSequence();
              Call _newCall = this.mapping.newCall(_exitSequence_1);
              _steps_1.add(_newCall);
            }
          }
        }
      }
      Step _exitAction = execState.getExitAction();
      boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_exitAction, null);
      if (_operator_notEquals_1) {
        EList<Step> _steps_2 = seq.getSteps();
        Step _exitAction_1 = execState.getExitAction();
        Call _newCall_1 = this.mapping.newCall(_exitAction_1);
        _steps_2.add(_newCall_1);
      }
      if (this._addTraceSteps) {
        EList<Step> _steps_3 = seq.getSteps();
        TraceStateExited _newTraceStateExited = this.trace.newTraceStateExited(execState);
        CollectionExtensions.<Step>operator_add(_steps_3, _newTraceStateExited);
      }
      execState.setExitSequence(seq);
    }
  }
  
  public StateSwitch defineExitSwitch(final ExecutionScope state, final Iterable<ExecutionState> leafStates, final int pos) {
    {
      SexecFactory _factory = this.sexec.factory();
      StateSwitch _createStateSwitch = _factory.createStateSwitch();
      StateSwitch sSwitch = _createStateSwitch;
      sSwitch.setStateConfigurationIdx(pos);
      String _name = state.getName();
      String _operator_plus = StringExtensions.operator_plus("Handle exit of all possible states (of ", _name);
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, ") at position ");
      int _stateConfigurationIdx = sSwitch.getStateConfigurationIdx();
      String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, ((Integer)_stateConfigurationIdx));
      String _operator_plus_3 = StringExtensions.operator_plus(_operator_plus_2, "...");
      sSwitch.setComment(_operator_plus_3);
      final Function1<ExecutionState,Boolean> _function = new Function1<ExecutionState,Boolean>() {
          public Boolean apply(final ExecutionState rs) {
            boolean _operator_and = false;
            StateVector _stateVector = rs.getStateVector();
            int _size = _stateVector.getSize();
            boolean _operator_equals = ObjectExtensions.operator_equals(((Integer)_size), ((Integer)1));
            if (!_operator_equals) {
              _operator_and = false;
            } else {
              StateVector _stateVector_1 = rs.getStateVector();
              int _offset = _stateVector_1.getOffset();
              boolean _operator_equals_1 = ObjectExtensions.operator_equals(((Integer)_offset), ((Integer)pos));
              _operator_and = BooleanExtensions.operator_and(_operator_equals, _operator_equals_1);
            }
            return ((Boolean)_operator_and);
          }
        };
      Iterable<ExecutionState> _filter = IterableExtensions.<ExecutionState>filter(leafStates, _function);
      final Iterable<ExecutionState> posStates = _filter;
      for (final ExecutionState s : posStates) {
        {
          SexecFactory _factory_1 = this.sexec.factory();
          Sequence _createSequence = _factory_1.createSequence();
          final Sequence caseSeq = _createSequence;
          Sequence _exitSequence = s.getExitSequence();
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_exitSequence, null);
          if (_operator_notEquals) {
            EList<Step> _steps = caseSeq.getSteps();
            Sequence _exitSequence_1 = s.getExitSequence();
            Call _newCall = this.mapping.newCall(_exitSequence_1);
            CollectionExtensions.<Step>operator_add(_steps, _newCall);
          }
          ArrayList<ExecutionScope> _parentScopes = this.sexec.parentScopes(s);
          final ArrayList<ExecutionScope> exitScopes = _parentScopes;
          ArrayList<ExecutionScope> _parentScopes_1 = this.sexec.parentScopes(state);
          exitScopes.removeAll(_parentScopes_1);
          exitScopes.remove(s);
          final Function2<Sequence,ExecutionScope,Sequence> _function_1 = new Function2<Sequence,ExecutionScope,Sequence>() {
              public Sequence apply(final Sequence cs , final ExecutionScope exitScope) {
                Sequence _xblockexpression = null;
                {
                  boolean _operator_and_1 = false;
                  if (!(exitScope instanceof org.yakindu.sct.model.sexec.ExecutionState)) {
                    _operator_and_1 = false;
                  } else {
                    StateVector _stateVector_2 = s.getStateVector();
                    int _last = SequenceBuilder.this.sexec.last(_stateVector_2);
                    StateVector _stateVector_3 = exitScope.getStateVector();
                    int _last_1 = SequenceBuilder.this.sexec.last(_stateVector_3);
                    boolean _operator_equals_2 = ObjectExtensions.operator_equals(((Integer)_last), ((Integer)_last_1));
                    _operator_and_1 = BooleanExtensions.operator_and((exitScope instanceof org.yakindu.sct.model.sexec.ExecutionState), _operator_equals_2);
                  }
                  if (_operator_and_1) {
                    {
                      final ExecutionState execState = ((ExecutionState) exitScope);
                      Step _exitAction = execState.getExitAction();
                      boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_exitAction, null);
                      if (_operator_notEquals_1) {
                        EList<Step> _steps_1 = cs.getSteps();
                        Step _exitAction_1 = execState.getExitAction();
                        Call _newCall_1 = SequenceBuilder.this.mapping.newCall(_exitAction_1);
                        _steps_1.add(_newCall_1);
                      }
                      if (SequenceBuilder.this._addTraceSteps) {
                        EList<Step> _steps_2 = cs.getSteps();
                        TraceStateExited _newTraceStateExited = SequenceBuilder.this.trace.newTraceStateExited(execState);
                        _steps_2.add(_newTraceStateExited);
                      }
                    }
                  }
                  _xblockexpression = (cs);
                }
                return _xblockexpression;
              }
            };
          IterableExtensions.<ExecutionScope, Sequence>fold(exitScopes, caseSeq, _function_1);
          EList<Step> _steps_3 = caseSeq.getSteps();
          boolean _isEmpty = _steps_3.isEmpty();
          boolean _operator_not = BooleanExtensions.operator_not(_isEmpty);
          if (_operator_not) {
            EList<StateCase> _cases = sSwitch.getCases();
            StateCase _newCase = this.sexec.newCase(s, caseSeq);
            _cases.add(_newCase);
          }
        }
      }
      return sSwitch;
    }
  }
  
  public Sequence defineStatechartExitSequence(final ExecutionFlow flow, final Statechart sc) {
    {
      SexecFactory _factory = this.sexec.factory();
      Sequence _createSequence = _factory.createSequence();
      final Sequence exitSequence = _createSequence;
      exitSequence.setName("exit");
      String _name = sc.getName();
      String _operator_plus = StringExtensions.operator_plus("Default exit sequence for statechart ", _name);
      exitSequence.setComment(_operator_plus);
      EList<Region> _regions = sc.getRegions();
      for (final Region r : _regions) {
        {
          ExecutionRegion _create = this.mapping.create(r);
          final ExecutionRegion execRegion = _create;
          Sequence _exitSequence = execRegion.getExitSequence();
          boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_exitSequence, null);
          if (_operator_notEquals) {
            EList<Step> _steps = exitSequence.getSteps();
            Sequence _exitSequence_1 = execRegion.getExitSequence();
            Call _newCall = this.mapping.newCall(_exitSequence_1);
            _steps.add(_newCall);
          }
        }
      }
      flow.setExitSequence(exitSequence);
      return exitSequence;
    }
  }
  
  public Sequence defineStatechartEnterSequence(final ExecutionFlow flow, final Statechart sc) {
    {
      SexecFactory _factory = this.sexec.factory();
      Sequence _createSequence = _factory.createSequence();
      final Sequence enterSequence = _createSequence;
      enterSequence.setName("enter");
      String _name = sc.getName();
      String _operator_plus = StringExtensions.operator_plus("Default enter sequence for statechart ", _name);
      enterSequence.setComment(_operator_plus);
      EList<Scope> _scopes = sc.getScopes();
      final Function1<Scope,EList<Variable>> _function = new Function1<Scope,EList<Variable>>() {
          public EList<Variable> apply(final Scope s) {
            EList<Variable> _variables = s.getVariables();
            return _variables;
          }
        };
      List<EList<Variable>> _map = ListExtensions.<Scope, EList<Variable>>map(_scopes, _function);
      Iterable<Variable> _flatten = IterableExtensions.<Variable>flatten(_map);
      Iterable<VariableDefinition> _filter = IterableExtensions.<VariableDefinition>filter(_flatten, org.yakindu.sct.model.stext.stext.VariableDefinition.class);
      for (final VariableDefinition vd : _filter) {
        Expression _initialValue = vd.getInitialValue();
        boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_initialValue, null);
        if (_operator_notEquals) {
          EList<Step> _steps = enterSequence.getSteps();
          Execution _createInitialization = this.createInitialization(vd);
          _steps.add(_createInitialization);
        }
      }
      EList<Region> _regions = sc.getRegions();
      for (final Region r : _regions) {
        {
          ExecutionRegion _create = this.mapping.create(r);
          final ExecutionRegion execRegion = _create;
          Sequence _enterSequence = execRegion.getEnterSequence();
          boolean _operator_notEquals_1 = ObjectExtensions.operator_notEquals(_enterSequence, null);
          if (_operator_notEquals_1) {
            EList<Step> _steps_1 = enterSequence.getSteps();
            Sequence _enterSequence_1 = execRegion.getEnterSequence();
            Call _newCall = this.mapping.newCall(_enterSequence_1);
            _steps_1.add(_newCall);
          }
        }
      }
      flow.setEnterSequence(enterSequence);
      return enterSequence;
    }
  }
  
  public Execution createInitialization(final VariableDefinition vd) {
    {
      SexecFactory _factory = this.sexec.factory();
      Execution _createExecution = _factory.createExecution();
      final Execution execution = _createExecution;
      StextFactory _factory_1 = this.stext.factory();
      Assignment _createAssignment = _factory_1.createAssignment();
      final Assignment assignment = _createAssignment;
      assignment.setVarRef(vd);
      assignment.setOperator(AssignmentOperator.ASSIGN);
      Expression _initialValue = vd.getInitialValue();
      Expression _copy = EcoreUtil.<Expression>copy(_initialValue);
      assignment.setExpression(_copy);
      execution.setStatement(assignment);
      return execution;
    }
  }
  
  public void defineStateEnterSequence(final NamedElement state) {
    if ((state instanceof FinalState)) {
      _defineStateEnterSequence((FinalState)state);
    } else if ((state instanceof State)) {
      _defineStateEnterSequence((State)state);
    } else if ((state instanceof Region)) {
      _defineStateEnterSequence((Region)state);
    } else if ((state instanceof Vertex)) {
      _defineStateEnterSequence((Vertex)state);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(state).toString());
    }
  }
  
  public void defineStateExitSequence(final NamedElement s) {
    if ((s instanceof FinalState)) {
      _defineStateExitSequence((FinalState)s);
    } else if ((s instanceof State)) {
      _defineStateExitSequence((State)s);
    } else if ((s instanceof Region)) {
      _defineStateExitSequence((Region)s);
    } else if ((s instanceof Vertex)) {
      _defineStateExitSequence((Vertex)s);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(s).toString());
    }
  }
}