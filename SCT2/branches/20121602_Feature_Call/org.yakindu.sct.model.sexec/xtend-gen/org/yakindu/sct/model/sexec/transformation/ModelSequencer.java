package org.yakindu.sct.model.sexec.transformation;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogConfigurationException;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
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
import org.yakindu.sct.model.stext.stext.Operation;
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
  
  @Inject
  @Named("ADD_TRACES")
  private boolean _addTraceSteps;
  
  public ExecutionFlow transform(final Statechart sc) {
    {
      ExecutionFlow _create = this.mapping.create(sc);
      final ExecutionFlow ef = _create;
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
      this.retargetDeclRefs(ef);
      return ef;
    }
  }
  
  public void retargetDeclRefs(final ExecutionFlow flow) {
    {
      List<EObject> _eAllContentsAsList = EcoreUtil2.eAllContentsAsList(flow);
      final List<EObject> allContent = _eAllContentsAsList;
      final Function1<EObject,Boolean> _function = new Function1<EObject,Boolean>() {
          public Boolean apply(final EObject e) {
            boolean _operator_or = false;
            boolean _operator_or_1 = false;
            if ((e instanceof org.yakindu.sct.model.stext.stext.EventDefinition)) {
              _operator_or_1 = true;
            } else {
              _operator_or_1 = BooleanExtensions.operator_or((e instanceof org.yakindu.sct.model.stext.stext.EventDefinition), (e instanceof org.yakindu.sct.model.stext.stext.VariableDefinition));
            }
            if (_operator_or_1) {
              _operator_or = true;
            } else {
              _operator_or = BooleanExtensions.operator_or(_operator_or_1, (e instanceof org.yakindu.sct.model.stext.stext.Operation));
            }
            return ((Boolean)_operator_or);
          }
        };
      Iterable<EObject> _filter = IterableExtensions.<EObject>filter(allContent, _function);
      Set<EObject> _set = IterableExtensions.<EObject>toSet(_filter);
      final Set<EObject> declared = _set;
      Iterable<TypedElementReferenceExpression> _filter_1 = IterableExtensions.<TypedElementReferenceExpression>filter(allContent, org.yakindu.sct.model.stext.stext.TypedElementReferenceExpression.class);
      final Function1<TypedElementReferenceExpression,Object> _function_1 = new Function1<TypedElementReferenceExpression,Object>() {
          public Object apply(final TypedElementReferenceExpression ere) {
            Object _retarget = ModelSequencer.this.retarget(ere, declared);
            return _retarget;
          }
        };
      IterableExtensions.<TypedElementReferenceExpression>forEach(_filter_1, _function_1);
      Iterable<FeatureCall> _filter_2 = IterableExtensions.<FeatureCall>filter(allContent, org.yakindu.sct.model.stext.stext.FeatureCall.class);
      final Function1<FeatureCall,Object> _function_2 = new Function1<FeatureCall,Object>() {
          public Object apply(final FeatureCall call) {
            Object _retarget_1 = ModelSequencer.this.retarget(call, declared);
            return _retarget_1;
          }
        };
      IterableExtensions.<FeatureCall>forEach(_filter_2, _function_2);
    }
  }
  
  public Object retarget(final TypedElementReferenceExpression ere, final Collection<EObject> declared) {
    Object _xifexpression = null;
    NamedElement _reference = ere.getReference();
    boolean _contains = declared.contains(_reference);
    boolean _operator_not = BooleanExtensions.operator_not(_contains);
    if (_operator_not) {
      NamedElement _reference_1 = ere.getReference();
      Declaration _replaced = this.replaced(_reference_1);
      ere.setReference(_replaced);
    }
    return _xifexpression;
  }
  
  public Object retarget(final FeatureCall call, final Collection<EObject> declared) {
    Object _xifexpression = null;
    Feature _feature = call.getFeature();
    boolean _contains = declared.contains(_feature);
    boolean _operator_not = BooleanExtensions.operator_not(_contains);
    if (_operator_not) {
      Feature _feature_1 = call.getFeature();
      Declaration _replaced = this.replaced(_feature_1);
      call.setFeature(((Feature) _replaced));
    }
    return _xifexpression;
  }
  
  protected Declaration _replaced(final NamedElement ne) {
    Declaration _xblockexpression = null;
    {
      try {
        Log _log = LogFactory.getLog(org.yakindu.sct.model.sexec.transformation.ModelSequencer.class);
        String _xifexpression = null;
        boolean _operator_equals = ObjectExtensions.operator_equals(ne, null);
        if (_operator_equals) {
          _xifexpression = "null";
        } else {
          String _name = ne.getName();
          _xifexpression = _name;
        }
        String _operator_plus = StringExtensions.operator_plus("Replace with unknown NamedElement called: ", _xifexpression);
        _log.error(_operator_plus);
      } catch (final LogConfigurationException e) { 
        {
          e.printStackTrace();
          String _xifexpression_1 = null;
          boolean _operator_equals_1 = ObjectExtensions.operator_equals(ne, null);
          if (_operator_equals_1) {
            _xifexpression_1 = "null";
          } else {
            String _name_1 = ne.getName();
            _xifexpression_1 = _name_1;
          }
          String _operator_plus_1 = StringExtensions.operator_plus("Replace with unknown NamedElement called: ", _xifexpression_1);
          InputOutput.<String>println(_operator_plus_1);
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
  
  protected Declaration _replaced(final Operation vd) {
    Operation _create = this.mapping.create(vd);
    return _create;
  }
  
  protected Declaration _replaced(final EventDefinition ed) {
    EventDefinition _create = this.mapping.create(ed);
    return _create;
  }
  
  protected Declaration _replaced(final TimeEvent ed) {
    return ed;
  }
  
  public Declaration replaced(final NamedElement vd) {
    if ((vd instanceof Operation)) {
      return _replaced((Operation)vd);
    } else if ((vd instanceof TimeEvent)) {
      return _replaced((TimeEvent)vd);
    } else if ((vd instanceof EventDefinition)) {
      return _replaced((EventDefinition)vd);
    } else if ((vd instanceof VariableDefinition)) {
      return _replaced((VariableDefinition)vd);
    } else if ((vd instanceof NamedElement)) {
      return _replaced((NamedElement)vd);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(vd).toString());
    }
  }
}