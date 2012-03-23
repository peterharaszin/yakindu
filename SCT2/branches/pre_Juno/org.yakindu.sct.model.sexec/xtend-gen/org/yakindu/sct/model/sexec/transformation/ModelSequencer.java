package org.yakindu.sct.model.sexec.transformation;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogConfigurationException;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.yakindu.base.base.NamedElement;
import org.yakindu.base.types.Feature;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.TimeEvent;
import org.yakindu.sct.model.sexec.transformation.BehaviorMapping;
import org.yakindu.sct.model.sexec.transformation.ReactionBuilder;
import org.yakindu.sct.model.sexec.transformation.SequenceBuilder;
import org.yakindu.sct.model.sexec.transformation.SexecElementMapping;
import org.yakindu.sct.model.sexec.transformation.SexecExtensions;
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions;
import org.yakindu.sct.model.sexec.transformation.StateVectorBuilder;
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions;
import org.yakindu.sct.model.sexec.transformation.StextExtensions;
import org.yakindu.sct.model.sexec.transformation.StructureMapping;
import org.yakindu.sct.model.sexec.transformation.TraceExtensions;
import org.yakindu.sct.model.sgraph.Declaration;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.FeatureCall;
import org.yakindu.sct.model.stext.stext.OperationDefinition;
import org.yakindu.sct.model.stext.stext.TypedElementReferenceExpression;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

@SuppressWarnings("all")
public class ModelSequencer {
  @Inject
  private IQualifiedNameProvider qfnProvider;
  
  @Inject
  private SexecElementMapping mapping;
  
  @Inject
  private StatechartExtensions sct;
  
  @Inject
  private SgraphExtensions sgraph;
  
  @Inject
  private StextExtensions stext;
  
  @Inject
  private SexecExtensions sexec;
  
  @Inject
  private StructureMapping structureMapping;
  
  @Inject
  private BehaviorMapping behaviorMapping;
  
  @Inject
  private ReactionBuilder reactBuilder;
  
  @Inject
  private SequenceBuilder seqBuilder;
  
  @Inject
  private StateVectorBuilder svBuilder;
  
  @Inject
  private TraceExtensions trace;
  
  /**
   * ==========================================================================
   * TRANSFORMATION ROOT
   */
  public ExecutionFlow transform(final Statechart sc) {
    final ExecutionFlow ef = this.mapping.create(sc);
    this.structureMapping.mapScopes(sc, ef);
    this.structureMapping.mapRegularStates(sc, ef);
    this.structureMapping.mapRegions(sc, ef);
    this.structureMapping.mapPseudoStates(sc, ef);
    this.structureMapping.mapTimeEvents(sc, ef);
    this.svBuilder.defineStateVector(ef, sc);
    this.svBuilder.defineHistoryVector(ef, sc);
    this.behaviorMapping.mapEntryActions(sc, ef);
    this.behaviorMapping.mapExitActions(sc, ef);
    this.seqBuilder.defineStateEnterSequences(ef, sc);
    this.seqBuilder.defineStateExitSequences(ef, sc);
    this.seqBuilder.defineDeepEnterSequences(ef, sc);
    this.seqBuilder.defineShallowEnterSequences(ef, sc);
    this.seqBuilder.defineStatechartEnterSequence(ef, sc);
    this.seqBuilder.defineStatechartExitSequence(ef, sc);
    this.behaviorMapping.mapTransitions(sc, ef);
    this.behaviorMapping.mapLocalReactions(sc, ef);
    this.behaviorMapping.mapChoiceTransitions(sc, ef);
    this.reactBuilder.defineEntryReactions(sc, ef);
    this.reactBuilder.defineRegularStateReactions(ef, sc);
    this.reactBuilder.definePseudoStateReactions(ef, sc);
    this.reactBuilder.defineStatechartReaction(ef, sc);
    this.retargetDeclRefs(ef);
    return ef;
  }
  
  /**
   * retarget declaration refs
   */
  public void retargetDeclRefs(final ExecutionFlow flow) {
    final List<EObject> allContent = EcoreUtil2.eAllContentsAsList(flow);
    final Function1<EObject,Boolean> _function = new Function1<EObject,Boolean>() {
        public Boolean apply(final EObject e) {
          boolean _or = false;
          boolean _or_1 = false;
          if ((e instanceof EventDefinition)) {
            _or_1 = true;
          } else {
            _or_1 = ((e instanceof EventDefinition) || (e instanceof VariableDefinition));
          }
          if (_or_1) {
            _or = true;
          } else {
            _or = (_or_1 || (e instanceof OperationDefinition));
          }
          return Boolean.valueOf(_or);
        }
      };
    Iterable<EObject> _filter = IterableExtensions.<EObject>filter(allContent, _function);
    final Set<EObject> declared = IterableExtensions.<EObject>toSet(_filter);
    Iterable<TypedElementReferenceExpression> _filter_1 = Iterables.<TypedElementReferenceExpression>filter(allContent, TypedElementReferenceExpression.class);
    final Procedure1<TypedElementReferenceExpression> _function_1 = new Procedure1<TypedElementReferenceExpression>() {
        public void apply(final TypedElementReferenceExpression ere) {
          ModelSequencer.this.retarget(ere, declared);
        }
      };
    IterableExtensions.<TypedElementReferenceExpression>forEach(_filter_1, _function_1);
    Iterable<FeatureCall> _filter_2 = Iterables.<FeatureCall>filter(allContent, FeatureCall.class);
    final Procedure1<FeatureCall> _function_2 = new Procedure1<FeatureCall>() {
        public void apply(final FeatureCall call) {
          ModelSequencer.this.retarget(call, declared);
        }
      };
    IterableExtensions.<FeatureCall>forEach(_filter_2, _function_2);
  }
  
  public void retarget(final TypedElementReferenceExpression ere, final Collection<EObject> declared) {
    boolean _and = false;
    NamedElement _reference = ere.getReference();
    boolean _notEquals = (!Objects.equal(_reference, null));
    if (!_notEquals) {
      _and = false;
    } else {
      NamedElement _reference_1 = ere.getReference();
      boolean _contains = declared.contains(_reference_1);
      boolean _not = (!_contains);
      _and = (_notEquals && _not);
    }
    if (_and) {
      NamedElement _reference_2 = ere.getReference();
      final Declaration r = this.replaced(_reference_2);
      boolean _notEquals_1 = (!Objects.equal(r, null));
      if (_notEquals_1) {
        ere.setReference(r);
      }
    }
  }
  
  public void retarget(final FeatureCall call, final Collection<EObject> declared) {
    boolean _and = false;
    Feature _feature = call.getFeature();
    boolean _notEquals = (!Objects.equal(_feature, null));
    if (!_notEquals) {
      _and = false;
    } else {
      Feature _feature_1 = call.getFeature();
      boolean _contains = declared.contains(_feature_1);
      boolean _not = (!_contains);
      _and = (_notEquals && _not);
    }
    if (_and) {
      Feature _feature_2 = call.getFeature();
      final Declaration r = this.replaced(_feature_2);
      boolean _notEquals_1 = (!Objects.equal(r, null));
      if (_notEquals_1) {
        call.setFeature(((Feature) r));
      }
    }
  }
  
  protected Declaration _replaced(final NamedElement ne) {
    Declaration _xblockexpression = null;
    {
      try {
        String _xifexpression = null;
        boolean _equals = Objects.equal(ne, null);
        if (_equals) {
          _xifexpression = "null";
        } else {
          String _name = ne.getName();
          _xifexpression = _name;
        }
        String _plus = ("Replace with unknown NamedElement called: " + _xifexpression);
        InputOutput.<String>println(_plus);
        Log _log = LogFactory.getLog(ModelSequencer.class);
        String _xifexpression_1 = null;
        boolean _equals_1 = Objects.equal(ne, null);
        if (_equals_1) {
          _xifexpression_1 = "null";
        } else {
          String _name_1 = ne.getName();
          _xifexpression_1 = _name_1;
        }
        String _plus_1 = ("Replace with unknown NamedElement called: " + _xifexpression_1);
        _log.error(_plus_1);
      } catch (final Throwable _t) {
        if (_t instanceof LogConfigurationException) {
          final LogConfigurationException e = (LogConfigurationException)_t;
          e.printStackTrace();
          String _xifexpression_2 = null;
          boolean _equals_2 = Objects.equal(ne, null);
          if (_equals_2) {
            _xifexpression_2 = "null";
          } else {
            String _name_2 = ne.getName();
            _xifexpression_2 = _name_2;
          }
          String _plus_2 = ("Replace with unknown NamedElement called: " + _xifexpression_2);
          InputOutput.<String>println(_plus_2);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = (null);
    }
    return _xblockexpression;
  }
  
  protected Declaration _replaced(final VariableDefinition vd) {
    VariableDefinition _create = this.mapping.create(vd);
    return _create;
  }
  
  protected Declaration _replaced(final OperationDefinition vd) {
    OperationDefinition _create = this.mapping.create(vd);
    return _create;
  }
  
  protected Declaration _replaced(final EventDefinition ed) {
    EventDefinition _create = this.mapping.create(ed);
    return _create;
  }
  
  protected Declaration _replaced(final TimeEvent ed) {
    return ed;
  }
  
  public Declaration replaced(final NamedElement ed) {
    if (ed instanceof TimeEvent) {
      return _replaced((TimeEvent)ed);
    } else if (ed instanceof EventDefinition) {
      return _replaced((EventDefinition)ed);
    } else if (ed instanceof OperationDefinition) {
      return _replaced((OperationDefinition)ed);
    } else if (ed instanceof VariableDefinition) {
      return _replaced((VariableDefinition)ed);
    } else if (ed != null) {
      return _replaced(ed);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(ed).toString());
    }
  }
}
