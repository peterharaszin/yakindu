/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.refactoring.refactor.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.yakindu.sct.model.sgraph.Effect;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.stext.EntryEvent;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.refactoring.refactor.AbstractRefactoring;

/**
 * Implementation for 'fold incoming actions' refactoring. This refactoring
 * moves actions of incoming transitions to the entry block of a state. Actions
 * can only be moved if they are used at all incoming transitions in the same
 * order (checked from back to front). If one of the incoming transitions enters
 * a composite state which has entry actions, the refactoring is not applied.
 * 
 * @author kutz
 * 
 */
public class FoldIncomingActionsRefactoring extends AbstractRefactoring<State> {

	@Override
	protected void internalExecute() {
		List<Expression> actionsToFold = getFoldableActions();
		addActionsToEntryReaction(actionsToFold);
	}

	/**
	 * Checks if one of the incoming transitions enters a parent composite state
	 * of its target. If so, false is returned if this parent composite state
	 * has entry actions.
	 * 
	 * @return true if all preconditions are fulfilled, false otherwise
	 */
	@Override
	public boolean isExecutable() {
		return super.isExecutable()
				&& noTransitionEntersCompositeWithEntryActions(getContextObject()
						.getIncomingTransitions());

	}

	private boolean noTransitionEntersCompositeWithEntryActions(
			EList<Transition> transitions) {

		for (Transition transition : transitions) {
			// all parent states of source need to be contained in the set of
			// the target's parent states
			Set<State> targetParentStates = new HashSet<State>(
					helper.getParentStates(transition.getTarget()));
			Set<State> sourceParentStates = helper.getParentStates(transition
					.getSource());

			targetParentStates.removeAll(sourceParentStates);

			for (State crossedCompositeState : targetParentStates) {
				if (helper.hasEntryAction(crossedCompositeState))
					return false;
			}
		}
		return true;
	}

	private List<Expression> getFoldableActions() {
		EList<Transition> transitions = getContextObject()
				.getIncomingTransitions();
		List<Expression> foldableActions = new ArrayList<Expression>();

		Expression lastFoldableAction;
		int indexFromBack = 0;
		while ((lastFoldableAction = getLastFoldableAction(
				helper.getAllActions(transitions), indexFromBack)) != null) {
			foldableActions.add(0, lastFoldableAction);
			indexFromBack++;
		}
		removeLastActions(transitions, indexFromBack);
		return foldableActions;
	}

	private void addActionsToEntryReaction(final List<Expression> actionsToAdd) {

		if (actionsToAdd.isEmpty()) {
			return;
		}

		EList<Expression> actionsOriginal = helper
				.getFirstEntryActions(getContextObject());

		if (actionsOriginal == null) {
			actionsOriginal = createEntryBlock();
		}

		actionsOriginal.addAll(actionsToAdd);
	}

	private EList<Expression> createEntryBlock() {
		EList<Expression> actionsOriginal;
		LocalReaction newLocalReaction = StextFactory.eINSTANCE
				.createLocalReaction();
		ReactionTrigger newReactionTrigger = StextFactory.eINSTANCE
				.createReactionTrigger();
		EntryEvent entryEvent = StextFactory.eINSTANCE.createEntryEvent();
		ReactionEffect newReactionEffect = StextFactory.eINSTANCE
				.createReactionEffect();

		newLocalReaction.setTrigger(newReactionTrigger);
		newReactionTrigger.getTriggers().add(entryEvent);
		newLocalReaction.setEffect(newReactionEffect);

		Scope scope = getContextObject().getScopes().get(0);
		scope.getDeclarations().add(newLocalReaction);

		actionsOriginal = newReactionEffect.getActions();
		return actionsOriginal;
	}

	private void removeLastActions(EList<Transition> transitions, int number) {

		for (Transition transition : transitions) {
			List<Expression> actionsToRemove = getLastActions(transition,
					number);
			for (Expression action : actionsToRemove) {
				EcoreUtil.delete(action);
			}
			// delete transition's effect when no more actions left
			Effect effect = transition.getEffect();
			if (!helper.hasAtLeastOneAction(transition) && effect != null) {
				EcoreUtil.delete(transition.getEffect());
			}
		}
	}

	private List<Expression> getLastActions(Transition transition, int number) {
		List<Expression> lastActions = new ArrayList<Expression>();
		Effect effect = transition.getEffect();
		if (effect instanceof ReactionEffect) {
			ReactionEffect reactionEffect = (ReactionEffect) effect;
			EList<Expression> actions = reactionEffect.getActions();
			for (int i = 1; i <= number; i++) {
				lastActions.add(actions.get(actions.size() - i));
			}
		}
		return lastActions;
	}

	private Expression getLastFoldableAction(
			List<EList<Expression>> allActions, int indexFromBack) {
		Expression actionToCheck = null;
		for (List<Expression> actionList : allActions) {
			if (actionList.size() - 1 - indexFromBack < 0) {
				return null;
			}
			Expression lastAction = actionList.get(actionList.size() - 1
					- indexFromBack);
			if (actionToCheck == null) {
				actionToCheck = lastAction;
			} else if (!EcoreUtil.equals(actionToCheck, lastAction)) {
				return null;
			}
		}
		return actionToCheck;
	}

	@Override
	protected String getCommandLabel() {
		return "Fold Incoming Actions";
	}

}
