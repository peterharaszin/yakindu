/**
 * Copyright (c) 2006-2009 committers of mda4e and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of mda4e (http://www.mda4e.org/) - initial API and implementation
 *
 */
package org.mda4e.statemachine.contribution.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import statemachine.Statechart;
import statemachine.StatemachinePackage;
import statemachine.Transition;

public class TransitionHelper {

	// Only useful if the list contains TransitionContainer!
	private static Transition getTransition(List<Transition> transitions,
			Transition transition) {
		for (Transition t : transitions) {
			if (t.equals(transition)) {
				return t;
			}
		}
		return null;
	}

	public static Integer getLowestPriority(Transition transition) {
		Statechart sc = (Statechart) EcoreUtil.getRootContainer(transition);
		Integer lowestPriority = null;

		for (Transition t : sc.getTransition()) {
			if (!t.equals(transition) && t.getSourceNode().equals(transition.getSourceNode())) {
				if (lowestPriority == null || t.getPriority() >= lowestPriority) {
					lowestPriority = t.getPriority();
				}
			}
		}
		return lowestPriority;
	}

	public static Integer getHighestPriority(Transition transition) {
		Statechart sc = (Statechart) EcoreUtil.getRootContainer(transition);
		Integer highestPriority = null;

		for (Transition t : sc.getTransition()) {
			if (!t.equals(transition) &&t.getSourceNode().equals(transition.getSourceNode())) {
				if (highestPriority == null
						|| t.getPriority() < highestPriority) {
					highestPriority = t.getPriority();
				}
			}
		}
		return highestPriority;
	}

	public static void setLowestPriority(Transition transition,
			TransactionalEditingDomain ted) {
		List<Transition> transitions = getSortedTransitionsWithSameSourceNode(transition);
		transition = getTransition(transitions, transition);

		Map<Transition, Integer> priorities = createTransitionPriorityMap(transitions);

		// changing priorities of affected transitions
		Transition tmpTransition;
		int tmpPriority;
		for (int i = 0; i < transitions.size() - 1; i++) {
			if (transitions.get(i).equals(transition)) {
				tmpTransition = transitions.get(i + 1);
				tmpPriority = priorities.get(tmpTransition);
				priorities.put(tmpTransition, priorities.get(transition));
				priorities.put(transition, tmpPriority);
				transitions.set(i, tmpTransition);
				transitions.set(i + 1, transition);
			}
		}

		executeCommandsToUpdatePriorities(ted, priorities,
				"Set Lowest Transition Priority");
	}

	public static void lowerPriority(Transition transition,
			TransactionalEditingDomain ted) {
		List<Transition> transitions = getSortedTransitionsWithSameSourceNode(transition);
		transition = getTransition(transitions, transition);

		Map<Transition, Integer> priorities = createTransitionPriorityMap(transitions);

		// changing priorities of affected transitions
		Integer oldPriority = null;
		Transition tmpTransition;
		for (int i = 0; i < transitions.size() - 1; i++) {
			if (transitions.get(i).equals(transition)) {
				tmpTransition = transitions.get(i + 1);
				oldPriority = tmpTransition.getPriority();
				priorities.put(transition, oldPriority);
				priorities.put(tmpTransition, transition.getPriority());
				break;
			}
		}

		if (oldPriority == null) {
			priorities.put(transition, transition.getPriority() + 1);
		}

		executeCommandsToUpdatePriorities(ted, priorities,
				"Lower Transition Priority");
	}

	public static void setHighestPriority(Transition transition,
			TransactionalEditingDomain ted) {
		List<Transition> transitions = getSortedTransitionsWithSameSourceNode(transition);
		transition = getTransition(transitions, transition);

		Collections.reverse(transitions);

		Map<Transition, Integer> priorities = createTransitionPriorityMap(transitions);

		// changing priorities of affected transitions
		Transition tmpTransition;
		int tmpPriority;
		for (int i = 0; i < transitions.size() - 1; i++) {
			if (transitions.get(i).equals(transition)) {
				tmpTransition = transitions.get(i + 1);
				tmpPriority = priorities.get(tmpTransition);
				priorities.put(tmpTransition, priorities.get(transition));
				transitions.set(i, tmpTransition);
				priorities.put(transition, tmpPriority);
				transitions.set(i + 1, transition);
			}
		}

		executeCommandsToUpdatePriorities(ted, priorities,
				"Set Highest Transition Priority");
	}

	public static void raisePriority(Transition transition,
			TransactionalEditingDomain ted) {
		List<Transition> transitions = getSortedTransitionsWithSameSourceNode(transition);
		transition = getTransition(transitions, transition);

		Map<Transition, Integer> priorities = createTransitionPriorityMap(transitions);

		// changing priorities of affected transitions
		Integer oldPriority = null;
		Transition tmpTransition;
		for (int i = transitions.size() - 1; i > 0; i--) {
			if (transitions.get(i).equals(transition)) {
				tmpTransition = transitions.get(i - 1);
				oldPriority = tmpTransition.getPriority();
				priorities.put(transition, oldPriority);
				priorities.put(tmpTransition, transition.getPriority());
				break;
			}
		}

		if (oldPriority == null && transition.getPriority() > 0) {
			priorities.put(transition, transition.getPriority() - 1);
		}

		executeCommandsToUpdatePriorities(ted, priorities,
				"Raise Transition Priority");
	}

	public static void normalizePriorities(Transition transition,
			TransactionalEditingDomain ted) {
		List<Transition> transitions = getSortedTransitionsWithSameSourceNode(transition);

		Map<Transition, Integer> priorities = new HashMap<Transition, Integer>(
				transitions.size());

		int counter = 0;
		for (int i = 0; i < transitions.size(); i++) {
			priorities.put(transitions.get(i), counter);
			if (!(i + 1 < transitions.size() && transitions.get(i)
					.getPriority() == transitions.get(i + 1).getPriority())) {
				counter++;
			}
		}

		executeCommandsToUpdatePriorities(ted, priorities,
				"Normalize Priorities");
	}

	public static void changePriorityAndRearrangeTransitions(
			Transition transition, TransactionalEditingDomain ted, int priority) {

		List<Transition> transitions = getSortedTransitionsWithSameSourceNode(transition);

		List<Transition> transitionsWithGreaterPriority = new ArrayList<Transition>();
		for (Transition t : transitions) {
			if (t.getPriority() >= priority) {
				transitionsWithGreaterPriority.add(t);
			}
		}

		transitionsWithGreaterPriority.remove(transition);
		if (transitionsWithGreaterPriority.isEmpty()) {
			return;
		}

		Map<Transition, Integer> priorities = createTransitionPriorityMap(transitionsWithGreaterPriority);
		priorities.put(transition, priority);

		int lastPriority = priority;
		boolean firstLoop = true;
		for (Transition t : transitionsWithGreaterPriority) {
			if (t.getPriority() == lastPriority) {
				priorities.put(t, lastPriority + 1);
			} else if (!firstLoop && t.getPriority() == lastPriority + 1) {
				lastPriority++;
				priorities.put(t, lastPriority + 1);
			} else {
				break;
			}
			firstLoop = false;
		}

		executeCommandsToUpdatePriorities(ted, priorities, "Change Priority");
	}

	private static Map<Transition, Integer> createTransitionPriorityMap(
			List<Transition> transitions) {
		// copy transitions with their priorities into a map since we need
		// commands to edit the priority
		Map<Transition, Integer> priorities = new HashMap<Transition, Integer>(
				transitions.size());
		for (Transition t : transitions) {
			priorities.put(t, t.getPriority());
		}
		return priorities;
	}

	private static void executeCommandsToUpdatePriorities(
			TransactionalEditingDomain ted,
			Map<Transition, Integer> priorities, String commandLabel) {
		// execute only necessary commands
		EAttribute feature = StatemachinePackage.eINSTANCE
				.getTransition_Priority();
		CompoundCommand cc = new CompoundCommand(commandLabel);
		for (Transition t : priorities.keySet()) {
			if (t.getPriority() != priorities.get(t)) {
				if (t instanceof TransitionContainer) {
					for (Transition tt : ((TransitionContainer) t)
							.getTransitions()) {
						cc.append(SetCommand.create(ted, tt, feature,
								priorities.get(t)));
					}
				} else {
					cc.append(SetCommand.create(ted, t, feature, priorities
							.get(t)));
				}
			}
		}
		ted.getCommandStack().execute(cc);
	}

	private static List<Transition> getSortedTransitionsWithSameSourceNode(
			Transition transition) {
		Statechart sc = (Statechart) EcoreUtil.getRootContainer(transition);

		Map<Integer, Transition> transitions = new HashMap<Integer, Transition>();

		Transition tmpTransition;
		for (Transition t : sc.getTransition()) {
			if (t.getSourceNode().equals(transition.getSourceNode())) {
				tmpTransition = transitions.get(t.getPriority());
				if (tmpTransition == null) {
					transitions.put(t.getPriority(), t);
				} else if (tmpTransition instanceof TransitionContainer) {
					((TransitionContainer) transition).addTransition(t);
				} else {
					TransitionContainer tc = new TransitionContainer(
							tmpTransition);
					tc.addTransition(t);
					transitions.put(t.getPriority(), tc);
				}
			}
		}

		List<Transition> sortedTransitions = new ArrayList<Transition>(
				transitions.values());

		// sort transitions starting with the lowest priority
		Collections.sort(sortedTransitions, new Comparator<Transition>() {

			public int compare(Transition o1, Transition o2) {
				return o1.getPriority() - o2.getPriority();
			}
		});
		return sortedTransitions;
	}
}
