/**
 * Copyright (c) 2011 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.validation;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.ComposedChecks;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.yakindu.base.types.Event;
import org.yakindu.base.types.Feature;
import org.yakindu.base.types.ITypeSystem.InferenceIssue;
import org.yakindu.base.types.ITypeSystem.InferenceResult;
import org.yakindu.base.types.Operation;
import org.yakindu.base.types.Parameter;
import org.yakindu.base.types.Property;
import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Exit;
import org.yakindu.sct.model.sgraph.ReactionProperty;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.ScopedElement;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Trigger;
import org.yakindu.sct.model.sgraph.Variable;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.model.sgraph.resource.AbstractSCTResource;
import org.yakindu.sct.model.sgraph.validation.SCTResourceValidator;
import org.yakindu.sct.model.sgraph.validation.SGraphJavaValidator;
import org.yakindu.sct.model.stext.services.STextGrammarAccess;
import org.yakindu.sct.model.stext.stext.AssignmentExpression;
import org.yakindu.sct.model.stext.stext.DefaultTrigger;
import org.yakindu.sct.model.stext.stext.Direction;
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression;
import org.yakindu.sct.model.stext.stext.EntryEvent;
import org.yakindu.sct.model.stext.stext.EntryPointSpec;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.EventRaisingExpression;
import org.yakindu.sct.model.stext.stext.EventSpec;
import org.yakindu.sct.model.stext.stext.ExitEvent;
import org.yakindu.sct.model.stext.stext.ExitPointSpec;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.FeatureCall;
import org.yakindu.sct.model.stext.stext.Guard;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.StextPackage;
import org.yakindu.sct.model.stext.stext.TimeEventSpec;
import org.yakindu.sct.model.stext.stext.VariableDefinition;
import org.yakindu.sct.model.stext.types.ISTextTypeInferrer;
import org.yakindu.sct.model.stext.types.ISTextTypeSystem;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * s Several validations for nonsensical expressions.
 * 
 * @author muehlbrandt
 * @auhor muelder
 * 
 */
@ComposedChecks(validators = { SGraphJavaValidator.class, SCTResourceValidator.class })
public class STextJavaValidator extends AbstractSTextJavaValidator {

	public static final String CHOICE_ONE_OUTGOING_DEFAULT_TRANSITION = "A choice should have one outgoing default transition";
	public static final String FEATURE_CALL_HAS_NO_EFFECT = "FeatureCall has no effect";
	public static final String ENTRY_EXIT_TRIGGER_NOT_ALLOWED = "Entry/Exit trigger not allowed";
	public static final String LOCAL_REACTIONS_NOT_ALLOWED = "Local reactions not allowed";
	public static final String FEATURE_CALL_TO_SCOPE = "FEATURE_CALL_TO_SCOPE";
	public static final String ONLY_ONE_INTERFACE = "Only one default/unnamed interface is allowed.";
	public static final String IN_OUT_DECLARATIONS = "In/Out declarations are not allowed in internal scope.";
	public static final String LOCAL_DECLARATIONS = "Local declarations are not allowed in interface scope.";
	public static final String TIME_EXPRESSION = "The evaluation result of a time expression must be of type integer";
	public static final String GUARD_EXPRESSION = "The evaluation result of a guard expression must be of type boolean";
	public static final String ASSIGNMENT_EXPRESSION = "No nested assignment of the same variable allowed (different behavior in various programming languages)";
	public static final String VARIABLE_VOID_TYPE = "'void' is an invalid type for variables";
	public static final String TRANSITION_ENTRY_SPEC_NOT_COMPOSITE = "Target state isn't composite";
	public static final String TRANSITION_EXIT_SPEC_NOT_COMPOSITE = "Source state isn't composite";
	public static final String TRANSITION_UNBOUND_DEFAULT_ENTRY_POINT = "Target state has regions without 'default' entries.";
	public static final String TRANSITION_UNBOUND_NAMED_ENTRY_POINT = "Target state has regions without named entries: ";
	public static final String TRANSITION_NOT_EXISTING_NAMED_EXIT_POINT = "Source State needs at least one region with the named exit point";
	public static final String REGION_UNBOUND_DEFAULT_ENTRY_POINT = "Region must have a 'default' entry.";
	public static final String REGION_UNBOUND_NAMED_ENTRY_POINT = "Region should have a named entry to support transitions entry specification: ";
	public static final String ENTRY_UNUSED = "The named entry is not used by incoming transitions.";
	public static final String EXIT_UNUSED = "The named exit is not used by outgoing transitions.";
	public static final String EXIT_DEFAULT_UNUSED = "The parent composite state has no 'default' exit transition.";
	public static final String TRANSITION_EXIT_SPEC_ON_MULTIPLE_SIBLINGS = "ExitPointSpec can't be used on transition siblings.";
	public static final String LEFT_HAND_ASSIGNMENT = "The left-hand side of an assignment must be a variable";
	public static final String ISSUE_TRANSITION_WITHOUT_TRIGGER = "Missing trigger. Transisition is never taken. Use 'oncycle' or 'always' instead";

	@Inject
	private ISTextTypeInferrer typeInferrer;
	@Inject
	private ISTextTypeSystem typeSystem;
	@Inject
	private STextGrammarAccess grammarAccess;
	@Inject
	private IQualifiedNameProvider nameProvider;
	@Inject
	@Named(Constants.LANGUAGE_NAME)
	private String languageName;

	@Check(CheckType.FAST)
	public void transitionsWithNoTrigger(Transition trans) {
		if (trans.getSource() instanceof Entry || trans.getSource() instanceof Choice) {
			return;
		}
		if (trans.getSource() instanceof org.yakindu.sct.model.sgraph.State) {
			org.yakindu.sct.model.sgraph.State state = (org.yakindu.sct.model.sgraph.State) trans.getSource();
			if (state.isComposite()) {
				for (Region r : state.getRegions()) {
					for (Vertex v : r.getVertices()) {
						if (v instanceof Exit) {
							return;
						}
					}
				}
			}
		}
		if (trans.getTrigger() == null) {
			warning(ISSUE_TRANSITION_WITHOUT_TRIGGER, trans, null, -1);
		}
	}
	

	@Check(CheckType.FAST)
	public void checkUnusedEntry(final Entry entry) {
		if (entry.getParentRegion().getComposite() instanceof org.yakindu.sct.model.sgraph.State
				&& entry.getIncomingTransitions().isEmpty()) {
			org.yakindu.sct.model.sgraph.State state = (org.yakindu.sct.model.sgraph.State) entry.getParentRegion()
					.getComposite();
			if (!STextValidationModelUtils.isDefault(entry)) {
				boolean hasIncomingTransition = false;
				Iterator<Transition> transitionIt = state.getIncomingTransitions().iterator();
				while (transitionIt.hasNext() && !hasIncomingTransition) {
					Iterator<ReactionProperty> propertyIt = transitionIt.next().getProperties().iterator();
					while (propertyIt.hasNext() && !hasIncomingTransition) {
						ReactionProperty property = propertyIt.next();
						if (property instanceof EntryPointSpec) {
							hasIncomingTransition = entry.getName().equals(((EntryPointSpec) property).getEntrypoint());
						}
					}
				}
				if (!hasIncomingTransition) {
					warning(ENTRY_UNUSED, entry, null, -1);
				}
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkLeftHandAssignment(final AssignmentExpression expression) {
		Expression varRef = expression.getVarRef();
		if (varRef instanceof FeatureCall) {
			EObject referencedObject = ((FeatureCall) varRef).getFeature();
			if (!(referencedObject instanceof Variable) && !(referencedObject instanceof Property)) {
				error(LEFT_HAND_ASSIGNMENT, StextPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF);
			}
		} else if (varRef instanceof ElementReferenceExpression) {
			EObject referencedObject = ((ElementReferenceExpression) varRef).getReference();
			if (!(referencedObject instanceof Variable) && !(referencedObject instanceof Property)) {
				error(LEFT_HAND_ASSIGNMENT, StextPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF);
			}

		} else {
			error(LEFT_HAND_ASSIGNMENT, StextPackage.Literals.ASSIGNMENT_EXPRESSION__VAR_REF);
		}
	}

	@Check(CheckType.FAST)
	public void checkUnusedExit(final Exit exit) {
		if (exit.getParentRegion().getComposite() instanceof org.yakindu.sct.model.sgraph.State
				&& exit.getOutgoingTransitions().isEmpty()) {
			org.yakindu.sct.model.sgraph.State state = (org.yakindu.sct.model.sgraph.State) exit.getParentRegion()
					.getComposite();

			if (!STextValidationModelUtils.isDefault(exit)) {
				boolean hasOutgoingTransition = false;
				Iterator<Transition> transitionIt = state.getOutgoingTransitions().iterator();
				while (transitionIt.hasNext() && !hasOutgoingTransition) {
					Transition transition = transitionIt.next();
					hasOutgoingTransition = STextValidationModelUtils.isDefaultExitTransition(transition) ? true
							: STextValidationModelUtils.isNamedExitTransition(transition, exit.getName());
				}
				if (!hasOutgoingTransition) {
					error(EXIT_UNUSED, exit, null, -1);
				}
			} else {
				boolean hasOutgoingTransition = false;
				Iterator<Transition> transitionIt = state.getOutgoingTransitions().iterator();
				while (transitionIt.hasNext() && !hasOutgoingTransition) {
					hasOutgoingTransition = STextValidationModelUtils.isDefaultExitTransition(transitionIt.next());
				}
				if (!hasOutgoingTransition) {
					error(EXIT_DEFAULT_UNUSED, exit, null, -1);
				}
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkTransitionPropertySpec(final Transition transition) {
		for (ReactionProperty property : transition.getProperties()) {
			if (property instanceof EntryPointSpec) {
				if (transition.getTarget() instanceof org.yakindu.sct.model.sgraph.State) {
					org.yakindu.sct.model.sgraph.State state = (org.yakindu.sct.model.sgraph.State) transition
							.getTarget();
					if (!state.isComposite()) {
						warning(TRANSITION_ENTRY_SPEC_NOT_COMPOSITE, transition, null, -1);
					}
				}
			} else if (property instanceof ExitPointSpec) {
				final ExitPointSpec exitPointSpec = (ExitPointSpec) property;
				if (transition.getSource() instanceof org.yakindu.sct.model.sgraph.State) {
					org.yakindu.sct.model.sgraph.State state = (org.yakindu.sct.model.sgraph.State) transition
							.getSource();
					if (!state.isComposite()) {
						warning(TRANSITION_EXIT_SPEC_NOT_COMPOSITE, transition, null, -1);
					} else {
						// Validate an exit point is continued on one transition
						// only.
						for (Transition t : state.getOutgoingTransitions()) {
							if (transition != t
									&& STextValidationModelUtils.isNamedExitTransition(t, exitPointSpec.getExitpoint())) {
								warning(TRANSITION_EXIT_SPEC_ON_MULTIPLE_SIBLINGS, transition, null, -1);
							}
						}

						// Validate the state has minimally one named exit
						// region

						boolean hasExit = false;
						Iterator<Region> regionIter = state.getRegions().iterator();
						while (regionIter.hasNext() && !hasExit) {

							Iterator<Exit> exitIter = STextValidationModelUtils.getExits(regionIter.next().eContents())
									.iterator();
							while (exitIter.hasNext() && !hasExit) {
								Exit exit = exitIter.next();
								hasExit = exitPointSpec.getExitpoint().equals(exit.getName());
							}
						}
						if (!hasExit) {
							error(TRANSITION_NOT_EXISTING_NAMED_EXIT_POINT, transition, null, -1);
						}

					}
				}
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkUnboundEntryPoints(final org.yakindu.sct.model.sgraph.State state) {
		if (state.isComposite()) {
			final List<Transition>[] transitions = STextValidationModelUtils.getEntrySpecSortedTransitions(state
					.getIncomingTransitions());
			Map<Region, List<Entry>> regions = null;

			// first list contains Transitions without entry spec
			if (!transitions[0].isEmpty()) {
				regions = STextValidationModelUtils.getRegionsWithoutDefaultEntry(state.getRegions());
				if (!regions.isEmpty()) {
					for (Transition transition : transitions[0]) {
						error(TRANSITION_UNBOUND_DEFAULT_ENTRY_POINT, transition, null, -1);
					}
					for (Region region : regions.keySet()) {
						error(REGION_UNBOUND_DEFAULT_ENTRY_POINT, region, null, -1);
					}
				}
			}

			// second list contains Transitions with entry spec
			if (!transitions[1].isEmpty()) {
				if (regions == null) {
					regions = STextValidationModelUtils.getRegionsWithoutDefaultEntry(state.getRegions());
				}
				for (Transition transition : transitions[1]) {
					boolean hasTargetEntry = true;
					for (ReactionProperty property : transition.getProperties()) {
						if (property instanceof EntryPointSpec) {
							EntryPointSpec spec = (EntryPointSpec) property;
							String specName = "'" + spec.getEntrypoint() + "'";
							for (Region region : regions.keySet()) {
								boolean hasEntry = false;
								for (Entry entry : regions.get(region)) {
									if (entry.getName().equals(spec.getEntrypoint())) {
										hasEntry = true;
										break;
									}
								}
								if (!hasEntry) {
									error(REGION_UNBOUND_NAMED_ENTRY_POINT + specName, region, null, -1);
									hasTargetEntry = false;
								}
							}
							if (!hasTargetEntry) {
								error(TRANSITION_UNBOUND_NAMED_ENTRY_POINT + specName, transition, null, -1);
							}
						}
					}
				}
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkVariableDefinition(final VariableDefinition definition) {
		try {
			InferenceResult result = typeInferrer.inferType(definition);
			if (result.getType() != null && typeSystem.isVoidType(result.getType())) {
				error(VARIABLE_VOID_TYPE, null);
			} else {
				report(result, null);
			}
		} catch (IllegalArgumentException e) {
			// ignore unknown literals here, as this also happens when a
			// linking problem occurred, which is handled in other locations
		}
	}

	@Check(CheckType.FAST)
	public void checkOperationArguments_FeatureCall(final FeatureCall call) {
		if (call.getFeature() instanceof Operation) {
			Operation operation = (Operation) call.getFeature();
			EList<Parameter> parameters = operation.getParameters();
			EList<Expression> args = call.getArgs();
			if (parameters.size() != args.size()) {
				error("Wrong number of arguments, expected " + parameters, null);
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkOperationArguments_TypedElementReferenceExpression(final ElementReferenceExpression call) {
		if (call.getReference() instanceof Operation) {
			Operation operation = (Operation) call.getReference();
			EList<Parameter> parameters = operation.getParameters();
			EList<Expression> args = call.getArgs();
			if (parameters.size() != args.size()) {
				error("Wrong number of arguments, expected " + parameters, null);
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkAssignmentExpression(final AssignmentExpression exp) {

		final String name = getVariableName(exp);

		List<AssignmentExpression> contents = EcoreUtil2.eAllOfType(exp, AssignmentExpression.class);
		contents.remove(exp);

		Iterable<AssignmentExpression> filter = Iterables.filter(contents, new Predicate<AssignmentExpression>() {
			public boolean apply(final AssignmentExpression ex) {
				String variableName = getVariableName(ex);
				return variableName.equals(name);

			}
		});
		if (Iterables.size(filter) > 0) {
			error(ASSIGNMENT_EXPRESSION, null);
		}
	}

	private String getVariableName(AssignmentExpression exp) {
		Expression varRef = exp.getVarRef();
		if (varRef instanceof ElementReferenceExpression
				&& ((ElementReferenceExpression) varRef).getReference() instanceof Property) {
			Property reference = (Property) ((ElementReferenceExpression) varRef).getReference();
			return reference.getName();
		} else if (varRef instanceof FeatureCall && ((FeatureCall) varRef).getFeature() instanceof Property) {
			Property reference = (Property) ((FeatureCall) varRef).getFeature();
			return reference.getName();
		}
		return null;
	}

	@Check(CheckType.FAST)
	public void checkFeatureCall(FeatureCall call) {
		if (call.eContainer() instanceof FeatureCall) {
			return;
		}
		if (call.getFeature() instanceof Scope) {
			error("A variable, event or operation is required", StextPackage.Literals.FEATURE_CALL__FEATURE,
					INSIGNIFICANT_INDEX, FEATURE_CALL_TO_SCOPE);
		}
	}

	@Check(CheckType.FAST)
	public void checkFeatureCall(ElementReferenceExpression call) {
		if (call.eContainer() instanceof FeatureCall) {
			return;
		}
		if (call.getReference() instanceof Scope) {
			error("A variable, event or operation is required",
					StextPackage.Literals.ELEMENT_REFERENCE_EXPRESSION__REFERENCE, INSIGNIFICANT_INDEX,
					FEATURE_CALL_TO_SCOPE);
		}
	}

	@Check(CheckType.FAST)
	public void checkGuard(Guard guard) {
		try {
			InferenceResult result = typeInferrer.inferType(guard.getExpression());
			if (result.getType() == null || !typeSystem.isBooleanType(result.getType())) {
				error(GUARD_EXPRESSION, StextPackage.Literals.GUARD__EXPRESSION);
			}
			report(result, null);
		} catch (IllegalArgumentException e) {
			// ignore unknown literals here, as this also happens when a
			// linking problem occurred, which is handled in other locations
		}
	}

	@Check(CheckType.FAST)
	public void checkTimeEventSpecValueExpression(TimeEventSpec spec) {
		try {
			InferenceResult result = typeInferrer.inferType(spec.getValue());
			if (result.getType() == null || !typeSystem.isIntegerType(result.getType())) {
				error(TIME_EXPRESSION, null);
			}
			report(result, StextPackage.Literals.TIME_EVENT_SPEC__VALUE);
		} catch (IllegalArgumentException e) {
			// ignore unknown literals here, as this also happens when a
			// linking problem occurred, which is handled in other locations
		}
	}

	@Check(CheckType.FAST)
	public void checkReactionTrigger(ReactionTrigger reactionTrigger) {
		for (EventSpec eventSpec : reactionTrigger.getTriggers()) {
			if (!(reactionTrigger.eContainer() instanceof LocalReaction)
					&& (eventSpec instanceof EntryEvent || eventSpec instanceof ExitEvent)) {
				error("entry and exit events are allowed as local reactions only.",
						StextPackage.Literals.REACTION_TRIGGER__TRIGGERS, INSIGNIFICANT_INDEX,
						LOCAL_REACTIONS_NOT_ALLOWED);
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkReactionEffectActionExpression(ReactionEffect effect) {
		EList<Expression> actions = effect.getActions();
		for (Expression expression : actions) {
			try {
				report(typeInferrer.inferType(expression), null);
			} catch (IllegalArgumentException e) {
				// ignore unknown literals here, as this also happens when a
				// linking problem occurred, which is handled in other locations
			}
		}
	}

	/**
	 * Only Expressions that produce an effect should be used as actions.
	 * 
	 * @param effect
	 */
	@Check(CheckType.FAST)
	public void checkReactionEffectActions(ReactionEffect effect) {
		for (Expression exp : effect.getActions()) {

			if (!(exp instanceof AssignmentExpression) && !(exp instanceof EventRaisingExpression)) {

				if (exp instanceof FeatureCall) {
					checkFeatureCallEffect((FeatureCall) exp);
				} else if (exp instanceof ElementReferenceExpression) {
					checkElementReferenceEffect((ElementReferenceExpression) exp);
				} else {
					error("Action has no effect.", StextPackage.Literals.REACTION_EFFECT__ACTIONS, effect.getActions()
							.indexOf(exp), FEATURE_CALL_HAS_NO_EFFECT);
				}

			}
		}
	}

	protected void checkFeatureCallEffect(FeatureCall call) {
		if (call.getFeature() != null && call.getFeature() instanceof Feature
				&& !(call.getFeature() instanceof Operation)) {
			if (call.getFeature() instanceof Property) {
				error("Access to property '" + nameProvider.getFullyQualifiedName(call.getFeature())
						+ "' has no effect.", call, StextPackage.Literals.FEATURE_CALL__FEATURE, INSIGNIFICANT_INDEX,
						FEATURE_CALL_HAS_NO_EFFECT);
			} else if (call.getFeature() instanceof Event) {
				error("Access to event '" + nameProvider.getFullyQualifiedName(call.getFeature()) + "' has no effect.",
						call, StextPackage.Literals.FEATURE_CALL__FEATURE, INSIGNIFICANT_INDEX,
						FEATURE_CALL_HAS_NO_EFFECT);
			} else {
				error("Access to feature '" + nameProvider.getFullyQualifiedName(call.getFeature())
						+ "' has no effect.", call, StextPackage.Literals.FEATURE_CALL__FEATURE, INSIGNIFICANT_INDEX,
						FEATURE_CALL_HAS_NO_EFFECT);
			}
		}
	}

	protected void checkElementReferenceEffect(ElementReferenceExpression refExp) {
		if (!(refExp.getReference() instanceof Operation)) {
			if (refExp.getReference() instanceof Property) {
				error("Access to property '" + nameProvider.getFullyQualifiedName(refExp.getReference())
						+ "' has no effect.", refExp, StextPackage.Literals.ELEMENT_REFERENCE_EXPRESSION__REFERENCE,
						INSIGNIFICANT_INDEX, FEATURE_CALL_HAS_NO_EFFECT);
			} else if (refExp.getReference() instanceof Event) {
				error("Access to event '" + nameProvider.getFullyQualifiedName(refExp.getReference())
						+ "' has no effect.", refExp, StextPackage.Literals.ELEMENT_REFERENCE_EXPRESSION__REFERENCE,
						INSIGNIFICANT_INDEX, FEATURE_CALL_HAS_NO_EFFECT);
			} else {
				error("Access to feature '" + nameProvider.getFullyQualifiedName(refExp.getReference())
						+ "' has no effect.", refExp, StextPackage.Literals.ELEMENT_REFERENCE_EXPRESSION__REFERENCE,
						INSIGNIFICANT_INDEX, FEATURE_CALL_HAS_NO_EFFECT);
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkEventDefinition(EventDefinition event) {
		if (event.eContainer() instanceof InterfaceScope && event.getDirection() == Direction.LOCAL) {
			error(LOCAL_DECLARATIONS, StextPackage.Literals.EVENT_DEFINITION__DIRECTION);
		}
		if (event.eContainer() instanceof InternalScope && event.getDirection() != Direction.LOCAL) {
			error(IN_OUT_DECLARATIONS, StextPackage.Literals.EVENT_DEFINITION__DIRECTION);
		}
	}

	@Check(CheckType.FAST)
	public void checkInterfaceScope(ScopedElement statechart) {
		List<InterfaceScope> defaultInterfaces = new LinkedList<InterfaceScope>();

		for (Scope scope : statechart.getScopes()) {
			if (scope instanceof InterfaceScope && ((InterfaceScope) scope).getName() == null) {
				defaultInterfaces.add((InterfaceScope) scope);
			}
		}
		if (defaultInterfaces.size() > 1) {
			for (InterfaceScope scope : defaultInterfaces) {
				error(ONLY_ONE_INTERFACE, scope, grammarAccess.getInterfaceScopeAccess().getInterfaceKeyword_1(),
						ValidationMessageAcceptor.INSIGNIFICANT_INDEX, ONLY_ONE_INTERFACE);
			}
		}
	}

	@Check
	public void checkChoiceWithoutDefaultTransition(final Choice choice) {
		boolean found = false;
		for (Transition transition : choice.getOutgoingTransitions()) {
			Trigger trigger = transition.getTrigger();
			if (isDefault(trigger)) {
				found = true;
			}
		}
		if (!found)
			warning(CHOICE_ONE_OUTGOING_DEFAULT_TRANSITION, SGraphPackage.Literals.VERTEX__OUTGOING_TRANSITIONS);
	}

	protected boolean isDefault(Trigger trigger) {

		return trigger == null
				|| trigger instanceof DefaultTrigger
				|| ((trigger instanceof ReactionTrigger) && ((ReactionTrigger) trigger).getTriggers().size() == 0 && ((ReactionTrigger) trigger)
						.getGuard() == null);
	}

	@Override
	protected String getCurrentLanguage(Map<Object, Object> context, EObject eObject) {
		Resource eResource = eObject.eResource();
		if (eResource instanceof XtextResource) {
			return super.getCurrentLanguage(context, eObject);
		} else if (eResource instanceof AbstractSCTResource) {
			return ((AbstractSCTResource) eResource).getLanguageName();
		}
		return "";
	}

	protected void error(String message, EObject source, Keyword keyword, int index, String code) {
		final String[] issueData = null;
		ICompositeNode rootNode = NodeModelUtils.findActualNodeFor(source);
		if (rootNode != null) {
			INode child = findNode(source, false, rootNode, keyword, new int[] { index });
			if (child != null) {
				int offset = child.getTotalOffset();
				int length = child.getTotalLength();
				getMessageAcceptor().acceptError(message, source, offset, length, code, issueData);
				return;
			}
		}
		error(message, source, (EStructuralFeature) null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, code);
	}

	protected void report(InferenceResult result, EStructuralFeature feature) {
		if (result.getIssues().isEmpty())
			return;
		// TODO: Sort issues by severity and evaluate severity
		InferenceIssue error = Iterables.getLast(result.getIssues());
		error(error.getMessage(), feature);

	}

	private INode findNode(EObject source, boolean sourceFound, INode root, Keyword keyword, int[] index) {
		if (sourceFound && root.getSemanticElement() != source) {
			return null;
		}
		if (root.getSemanticElement() == source) {
			sourceFound = true;
		}
		EObject grammarElement = root.getGrammarElement();
		// .equals or == does not work because sub grammars use their own
		// Modules with custom
		// grammarAccess instance and .equals is not overwritten.
		if (grammarElement instanceof Keyword && keyword.getValue().equals(((Keyword) grammarElement).getValue())) {
			if (index[0] != INSIGNIFICANT_INDEX) {
				index[0]--;
			}
			if (index[0] == 0 || index[0] == INSIGNIFICANT_INDEX) {
				return root;
			}
		}
		if (root instanceof ICompositeNode) {
			ICompositeNode node = (ICompositeNode) root;
			for (INode child : node.getChildren()) {
				INode result = findNode(source, sourceFound, child, keyword, index);
				if (result != null) {
					return result;
				}
			}
		}
		return null;
	}
}
