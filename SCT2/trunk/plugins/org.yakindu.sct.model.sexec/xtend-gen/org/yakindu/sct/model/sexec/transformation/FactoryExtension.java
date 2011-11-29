package org.yakindu.sct.model.sexec.transformation;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.yakindu.sct.model.sexec.Call;
import org.yakindu.sct.model.sexec.Check;
import org.yakindu.sct.model.sexec.CheckRef;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.ScheduleTimeEvent;
import org.yakindu.sct.model.sexec.SexecFactory;
import org.yakindu.sct.model.sexec.Step;
import org.yakindu.sct.model.sexec.TimeEvent;
import org.yakindu.sct.model.sexec.UnscheduleTimeEvent;
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions;
import org.yakindu.sct.model.sgraph.Reaction;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

@SuppressWarnings("all")
public class FactoryExtension {
  
  @Inject
  private IQualifiedNameProvider qfnProvider;
  
  @Inject
  private StatechartExtensions sce;
  
  private final HashMap<ArrayList<?>,ExecutionFlow> _createCache_create = new HashMap<ArrayList<?>,ExecutionFlow>();
  
  public ExecutionFlow create(final Statechart statechart) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(statechart);
    ExecutionFlow r;
    synchronized (_createCache_create) {
      if (_createCache_create.containsKey(_cacheKey)) {
        return _createCache_create.get(_cacheKey);
      }
      SexecFactory _sexecFactory = this.sexecFactory();
      ExecutionFlow _createExecutionFlow = _sexecFactory.createExecutionFlow();
      r = _createExecutionFlow;
      _createCache_create.put(_cacheKey, r);
    }
    String _name = statechart.getName();
    r.setName(_name);
    return r;
  }
  
  private final HashMap<ArrayList<?>,InterfaceScope> _createCache_create_1 = new HashMap<ArrayList<?>,InterfaceScope>();
  
  protected Scope _create(final InterfaceScope scope) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(scope);
    InterfaceScope r;
    synchronized (_createCache_create_1) {
      if (_createCache_create_1.containsKey(_cacheKey)) {
        return _createCache_create_1.get(_cacheKey);
      }
      StextFactory _stextFactory = this.stextFactory();
      InterfaceScope _createInterfaceScope = _stextFactory.createInterfaceScope();
      r = _createInterfaceScope;
      _createCache_create_1.put(_cacheKey, r);
    }
    String _name = scope.getName();
    r.setName(_name);
    return r;
  }
  
  private final HashMap<ArrayList<?>,InternalScope> _createCache_create_2 = new HashMap<ArrayList<?>,InternalScope>();
  
  protected Scope _create(final InternalScope scope) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(scope);
    InternalScope r;
    synchronized (_createCache_create_2) {
      if (_createCache_create_2.containsKey(_cacheKey)) {
        return _createCache_create_2.get(_cacheKey);
      }
      StextFactory _stextFactory = this.stextFactory();
      InternalScope _createInternalScope = _stextFactory.createInternalScope();
      r = _createInternalScope;
      _createCache_create_2.put(_cacheKey, r);
    }
    return r;
  }
  
  private final HashMap<ArrayList<?>,EventDefinition> _createCache_create_3 = new HashMap<ArrayList<?>,EventDefinition>();
  
  public EventDefinition create(final EventDefinition event) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(event);
    EventDefinition r;
    synchronized (_createCache_create_3) {
      if (_createCache_create_3.containsKey(_cacheKey)) {
        return _createCache_create_3.get(_cacheKey);
      }
      EventDefinition _copy = EcoreUtil.<EventDefinition>copy(event);
      r = _copy;
      _createCache_create_3.put(_cacheKey, r);
    }
    return r;
  }
  
  private final HashMap<ArrayList<?>,VariableDefinition> _createCache_create_4 = new HashMap<ArrayList<?>,VariableDefinition>();
  
  public VariableDefinition create(final VariableDefinition v) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(v);
    VariableDefinition r;
    synchronized (_createCache_create_4) {
      if (_createCache_create_4.containsKey(_cacheKey)) {
        return _createCache_create_4.get(_cacheKey);
      }
      VariableDefinition _copy = EcoreUtil.<VariableDefinition>copy(v);
      r = _copy;
      _createCache_create_4.put(_cacheKey, r);
    }
    return r;
  }
  
  private final HashMap<ArrayList<?>,ExecutionState> _createCache_create_5 = new HashMap<ArrayList<?>,ExecutionState>();
  
  public ExecutionState create(final RegularState state) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(state);
    ExecutionState r;
    synchronized (_createCache_create_5) {
      if (_createCache_create_5.containsKey(_cacheKey)) {
        return _createCache_create_5.get(_cacheKey);
      }
      SexecFactory _sexecFactory = this.sexecFactory();
      ExecutionState _createExecutionState = _sexecFactory.createExecutionState();
      r = _createExecutionState;
      _createCache_create_5.put(_cacheKey, r);
    }
    boolean _operator_notEquals = ObjectExtensions.operator_notEquals(state, null);
    if (_operator_notEquals) {
      {
        String _xifexpression = null;
        if ((state instanceof org.yakindu.sct.model.sgraph.FinalState)) {
          _xifexpression = "_final_";
        } else {
          String _name = state.getName();
          _xifexpression = _name;
        }
        r.setSimpleName(_xifexpression);
        QualifiedName _fullyQualifiedName = this.qfnProvider.getFullyQualifiedName(state);
        String _string = _fullyQualifiedName.toString();
        String _replaceAll = _string.replaceAll(" ", "");
        r.setName(_replaceAll);
      }
    }
    return r;
  }
  
  private final HashMap<ArrayList<?>,Check> _createCache_createCheck = new HashMap<ArrayList<?>,Check>();
  
  public Check createCheck(final ReactionTrigger tr) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(tr);
    Check r;
    synchronized (_createCache_createCheck) {
      if (_createCache_createCheck.containsKey(_cacheKey)) {
        return _createCache_createCheck.get(_cacheKey);
      }
      SexecFactory _sexecFactory = this.sexecFactory();
      Check _createCheck = _sexecFactory.createCheck();
      r = _createCheck;
      _createCache_createCheck.put(_cacheKey, r);
    }
    Reaction _reaction = this.sce.reaction(tr);
    String _id = this.sce.id(_reaction);
    r.setName(_id);
    return r;
  }
  
  private final HashMap<ArrayList<?>,org.yakindu.sct.model.sexec.Reaction> _createCache_create_6 = new HashMap<ArrayList<?>,org.yakindu.sct.model.sexec.Reaction>();
  
  public org.yakindu.sct.model.sexec.Reaction create(final Transition tr) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(tr);
    org.yakindu.sct.model.sexec.Reaction r;
    synchronized (_createCache_create_6) {
      if (_createCache_create_6.containsKey(_cacheKey)) {
        return _createCache_create_6.get(_cacheKey);
      }
      SexecFactory _sexecFactory = this.sexecFactory();
      org.yakindu.sct.model.sexec.Reaction _createReaction = _sexecFactory.createReaction();
      r = _createReaction;
      _createCache_create_6.put(_cacheKey, r);
    }
    {
      String _id = this.sce.id(tr);
      r.setName(_id);
      r.setTransition(true);
    }
    return r;
  }
  
  private final HashMap<ArrayList<?>,org.yakindu.sct.model.sexec.Reaction> _createCache_create_7 = new HashMap<ArrayList<?>,org.yakindu.sct.model.sexec.Reaction>();
  
  public org.yakindu.sct.model.sexec.Reaction create(final LocalReaction lr) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(lr);
    org.yakindu.sct.model.sexec.Reaction r;
    synchronized (_createCache_create_7) {
      if (_createCache_create_7.containsKey(_cacheKey)) {
        return _createCache_create_7.get(_cacheKey);
      }
      SexecFactory _sexecFactory = this.sexecFactory();
      org.yakindu.sct.model.sexec.Reaction _createReaction = _sexecFactory.createReaction();
      r = _createReaction;
      _createCache_create_7.put(_cacheKey, r);
    }
    {
      String _id = this.sce.id(lr);
      r.setName(_id);
      r.setTransition(false);
    }
    return r;
  }
  
  public CheckRef newRef(final Check check) {
    CheckRef _xblockexpression = null;
    {
      SexecFactory _sexecFactory = this.sexecFactory();
      CheckRef _createCheckRef = _sexecFactory.createCheckRef();
      final CheckRef r = _createCheckRef;
      r.setCheck(check);
      _xblockexpression = (r);
    }
    return _xblockexpression;
  }
  
  public Call newCall(final Step step) {
    Call _xblockexpression = null;
    {
      SexecFactory _sexecFactory = this.sexecFactory();
      Call _createCall = _sexecFactory.createCall();
      final Call r = _createCall;
      r.setStep(step);
      _xblockexpression = (r);
    }
    return _xblockexpression;
  }
  
  public ScheduleTimeEvent newScheduleTimeEvent(final TimeEvent te, final Statement timeValue) {
    ScheduleTimeEvent _xblockexpression = null;
    {
      SexecFactory _sexecFactory = this.sexecFactory();
      ScheduleTimeEvent _createScheduleTimeEvent = _sexecFactory.createScheduleTimeEvent();
      final ScheduleTimeEvent r = _createScheduleTimeEvent;
      r.setTimeEvent(te);
      r.setTimeValue(timeValue);
      _xblockexpression = (r);
    }
    return _xblockexpression;
  }
  
  public UnscheduleTimeEvent newUnscheduleTimeEvent(final TimeEvent te) {
    UnscheduleTimeEvent _xblockexpression = null;
    {
      SexecFactory _sexecFactory = this.sexecFactory();
      UnscheduleTimeEvent _createUnscheduleTimeEvent = _sexecFactory.createUnscheduleTimeEvent();
      final UnscheduleTimeEvent r = _createUnscheduleTimeEvent;
      r.setTimeEvent(te);
      _xblockexpression = (r);
    }
    return _xblockexpression;
  }
  
  public SexecFactory sexecFactory() {
    return SexecFactory.eINSTANCE;
  }
  
  public StextFactory stextFactory() {
    return StextFactory.eINSTANCE;
  }
  
  public Scope create(final Scope scope) {
    if ((scope instanceof InterfaceScope)) {
      return _create((InterfaceScope)scope);
    } else if ((scope instanceof InternalScope)) {
      return _create((InternalScope)scope);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(scope).toString());
    }
  }
}