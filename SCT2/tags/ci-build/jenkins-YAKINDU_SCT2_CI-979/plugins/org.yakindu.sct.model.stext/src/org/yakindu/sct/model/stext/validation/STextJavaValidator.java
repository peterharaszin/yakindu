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

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.yakindu.base.base.BasePackage;
import org.yakindu.base.types.Event;
import org.yakindu.base.types.Operation;
import org.yakindu.base.types.Parameter;
import org.yakindu.base.types.Property;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.stext.stext.AlwaysEvent;
import org.yakindu.sct.model.stext.stext.AssignmentExpression;
import org.yakindu.sct.model.stext.stext.Direction;
import org.yakindu.sct.model.stext.stext.EntryEvent;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.EventRaisingExpression;
import org.yakindu.sct.model.stext.stext.EventSpec;
import org.yakindu.sct.model.stext.stext.ExitEvent;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.FeatureCall;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.OnCycleEvent;
import org.yakindu.sct.model.stext.stext.OperationDefinition;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.SimpleScope;
import org.yakindu.sct.model.stext.stext.StatechartSpecification;
import org.yakindu.sct.model.stext.stext.StextPackage;
import org.yakindu.sct.model.stext.stext.TypedElementReferenceExpression;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

import com.google.inject.Inject;

import de.itemis.xtext.utils.gmf.resource.InjectMembersResource;

/**
 * Several validations for nonsensical expressions.
 * 
 * @author muehlbrandt
 * 
 */
public class STextJavaValidator extends AbstractSTextJavaValidator {

	@Inject
	private StaticTypeAnalyzer analyzer;

	// @Check
	// public void checkOperationCall(final FeatureCall call) {
	// if (! (call.getFeature() instanceof Operation) /*&&
	// !call.isOperationCall()*/) {
	// error(call.getFeature().getName()
	// + " is not an operation ", null);
	// }
	// }
	@Check
	public void checkOperationArguments(final FeatureCall call) {
		if (call.getFeature() instanceof Operation) {
			Operation operation = (Operation) call.getFeature();
			EList<Parameter> parameters = operation.getParameters();
			EList<Expression> args = call.getArgs();
			if (parameters.size() != args.size()) {
				error("Wrong number of arguments, expected " + parameters, null);
			}
		}
	}

	@Check
	public void checkExpression(final Statement statement) {
		try {
			analyzer.setErrorAcceptor(new ErrorAcceptor());
			analyzer.check(statement);
		} catch (TypeCheckException e) {
			error(e.getMessage(), null);
		} catch (IllegalArgumentException e) {
			// This happens, when the expression is not completed for Unhandled
			// parameter types: [null]
			// We can safely ignore this exception
		}
	}

	@Check(CheckType.FAST)
	public void checkReactionTrigger(ReactionTrigger reactionTrigger) {
		for (EventSpec eventSpec : reactionTrigger.getTriggers()) {

			// Allow only entries, exit, oncycle and always as event for local
			// reactions.
			if (!(reactionTrigger.eContainer() instanceof LocalReaction)
					&& (eventSpec instanceof EntryEvent
							|| eventSpec instanceof ExitEvent
							|| eventSpec instanceof OnCycleEvent || eventSpec instanceof AlwaysEvent)) {

				error("entry, exit, oncycle and always events are allowed as local reactions only.",
						StextPackage.Literals.REACTION_TRIGGER__TRIGGERS);
			}

			// Context StatechartDefiniton
			if (isStatechartDefinitionChild(reactionTrigger)) {
				if (eventSpec instanceof EntryEvent) {
					error("Entry events are not allowed in statechart definition.",
							StextPackage.Literals.REACTION_TRIGGER__TRIGGERS);
				} else if (eventSpec instanceof ExitEvent) {
					error("Exit events are not allowed in statechart definition.",
							StextPackage.Literals.REACTION_TRIGGER__TRIGGERS);
				}
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

			if (!(exp instanceof AssignmentExpression)
					&& !(exp instanceof EventRaisingExpression)) {

				if (exp instanceof FeatureCall) {
					checkFeatureCallEffect((FeatureCall) exp);
				} else if (exp instanceof TypedElementReferenceExpression) {
					checkTypedElementReferenceEffect((TypedElementReferenceExpression) exp);
				} else {
					error("Action has no effect.",
							StextPackage.Literals.REACTION_EFFECT__ACTIONS,
							effect.getActions().indexOf(exp));
				}

			}
		}
	}

	protected void checkFeatureCallEffect(FeatureCall call) {
		if (!(call.getFeature() instanceof Operation)) {
			if (call.getFeature() instanceof Property) {
				error("Access to property '" + call.getFeature().getName()
						+ "' has no effect.", call,
						StextPackage.Literals.FEATURE_CALL__FEATURE, 0);
			} else if (call.getFeature() instanceof Event) {
				error("Access to event '" + call.getFeature().getName()
						+ "' has no effect.", call,
						StextPackage.Literals.FEATURE_CALL__FEATURE, 0);
			} else {
				error("Access to feature '" + call.getFeature().getName()
						+ "' has no effect.", call,
						StextPackage.Literals.FEATURE_CALL__FEATURE, 0);
			}

			if (call.getOwner() != null) {
				if (call.getOwner() instanceof FeatureCall)
					checkFeatureCallEffect((FeatureCall) call.getOwner());
				else if (call.getOwner() instanceof TypedElementReferenceExpression)
					checkTypedElementReferenceEffect((TypedElementReferenceExpression) call
							.getOwner());
			}
		}

	}

	protected void checkTypedElementReferenceEffect(
			TypedElementReferenceExpression ter) {
		if (!(ter.getReference() instanceof Operation)) {
			if (ter.getReference() instanceof Property) {
				error("Access to property '" + ter.getReference().getName()
						+ "' has no effect.",
						ter,
						StextPackage.Literals.TYPED_ELEMENT_REFERENCE_EXPRESSION__REFERENCE,
						0);
			} else if (ter.getReference() instanceof Event) {
				error("Access to event '" + ter.getReference().getName()
						+ "' has no effect.",
						ter,
						StextPackage.Literals.TYPED_ELEMENT_REFERENCE_EXPRESSION__REFERENCE,
						0);
			} else {
				error("Access to feature '" + ter.getReference().getName()
						+ "' has no effect.",
						ter,
						StextPackage.Literals.TYPED_ELEMENT_REFERENCE_EXPRESSION__REFERENCE,
						0);
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkVariable(VariableDefinition variable) {
		if (variable.eContainer() instanceof SimpleScope) {
			error("Variables can not be defined in states.", variable,
					BasePackage.Literals.NAMED_ELEMENT__NAME,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX);
		}
	}

	@Check(CheckType.FAST)
	public void checkEventDefinition(EventDefinition event) {
		if (event.eContainer() instanceof InterfaceScope
				&& event.getDirection() == Direction.LOCAL) {
			error("Local declarations are not allowed in interface scope.",
					StextPackage.Literals.EVENT_DEFINITION__DIRECTION);
		}
		if (event.eContainer() instanceof InternalScope
				&& event.getDirection() != Direction.LOCAL) {
			error("In/Out declarations are not allowed in internal scope.",
					StextPackage.Literals.EVENT_DEFINITION__DIRECTION);
		}
	}

	@Check(CheckType.FAST)
	public void checkOperation(OperationDefinition operation) {
		if (operation.eContainer() instanceof SimpleScope) {
			error("Operations can not be defined in states.", operation,
					StextPackage.Literals.OPERATION_DEFINITION__PARAMS,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX);
		}
	}

	@Check(CheckType.FAST)
	public void checkLocalReaction(LocalReaction localReaction) {
		if (localReaction.eContainer() instanceof InterfaceScope) {
			error("Local reactions are not allowed in interface scope.",
					localReaction,
					StextPackage.Literals.LOCAL_REACTION__PROPERTIES,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX);
		}
	}

	@Check(CheckType.FAST)
	public void checkInterfaceScope(Statechart statechart) {
		List<InterfaceScope> defaultInterfaces = new LinkedList<InterfaceScope>();

		for (Scope scope : statechart.getScopes()) {
			if (scope instanceof InterfaceScope
					&& ((InterfaceScope) scope).getName() == null) {
				defaultInterfaces.add((InterfaceScope) scope);
			}
		}
		if (defaultInterfaces.size() > 1) {
			for (InterfaceScope scope : defaultInterfaces) {
				error("It can only exist one default/unnamed interface", scope,
						BasePackage.Literals.NAMED_ELEMENT__NAME,
						ValidationMessageAcceptor.INSIGNIFICANT_INDEX);
			}
		}
	}

	private boolean isStatechartDefinitionChild(EObject element) {
		while (element.eContainer() != null) {
			if (element.eContainer() instanceof StatechartSpecification) {
				return true;
			}
			element = element.eContainer();
		}
		return false;
	}

	@Override
	protected String getCurrentLanguage(Map<Object, Object> context,
			EObject eObject) {
		Resource resource = eObject.eResource();
		if (resource instanceof InjectMembersResource)
			return ((InjectMembersResource) resource).getLanguageName();
		return super.getCurrentLanguage(context, eObject);
	}
}
