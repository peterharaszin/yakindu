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
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.yakindu.sct.model.sgraph.Effect;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.stext.impl.ExitEventImpl;
import org.yakindu.sct.refactoring.refactor.AbstractRefactoring;
/**
 * 
 * @author thomas kutz - Initial contribution and API
 * 
 */
public class UnfoldExitActionsRefactoring extends AbstractRefactoring<State> {

	@Override
	protected void internalExecute() {
		unfoldExitActions();
	}

	/**
	 * Checks if one of the outgoing transitions leaves a parent composite state
	 * of its source. If so, false is returned if this parent composite state
	 * has exit actions.
	 * 
	 * @return true if all preconditions are fulfilled, false otherwise
	 */
	@Override
	public boolean isExecutable() {
		return super.isExecutable()
				&& noTransitionLeavesCompositeWithExitActions(getContextObject()
						.getOutgoingTransitions());
	}

	private boolean noTransitionLeavesCompositeWithExitActions(
			EList<Transition> transitions) {

		for (Transition transition : transitions) {
			// all parent states of target need to be contained in the set of
			// the source's parent states
			Set<State> sourceParentStates = new HashSet<State>(
					helper.getParentStates(transition.getSource()));
			Set<State> targetParentStates = helper.getParentStates(transition
					.getTarget());

			sourceParentStates.removeAll(targetParentStates);

			for (State crossedCompositeState : sourceParentStates) {
				if (helper.hasExitAction(crossedCompositeState))
					return false;
			}
		}
		return true;
	}

	private void unfoldExitActions() {
		List<Expression> actionsToUnfold = new ArrayList<Expression>(
				helper.getAllLocalActionsForEventType(getContextObject(),
						ExitEventImpl.class));
		addActionsToOutgoingTransitions(actionsToUnfold);
	}

	private void addActionsToOutgoingTransitions(List<Expression> actionsToAdd) {
		for (Transition transition : getContextObject()
				.getOutgoingTransitions()) {
			addActionsToTransition(transition, EcoreUtil.copyAll(actionsToAdd));
		}
	}

	private void addActionsToTransition(final Transition transition,
			final Collection<Expression> actionsToAdd) {

		Effect effect = transition.getEffect();
		if (effect instanceof ReactionEffect) {
			ReactionEffect reactionEffect = (ReactionEffect) effect;
			reactionEffect.getActions().addAll(0, actionsToAdd);
		} else {
			ReactionEffect reactionEffect = StextFactory.eINSTANCE
					.createReactionEffect();
			transition.setEffect(reactionEffect);
			reactionEffect.getActions().addAll(actionsToAdd);
		}
	}

	@Override
	protected String getCommandLabel() {
		return "Unfold Exit Actions";
	}

}
