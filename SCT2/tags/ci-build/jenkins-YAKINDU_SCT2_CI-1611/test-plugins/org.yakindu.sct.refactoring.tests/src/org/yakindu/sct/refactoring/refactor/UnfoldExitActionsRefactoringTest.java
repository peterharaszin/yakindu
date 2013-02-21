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
package org.yakindu.sct.refactoring.refactor;

import static org.yakindu.sct.test.models.RefactoringTestModels.EXPECTED_STATECHART;
import static org.yakindu.sct.test.models.RefactoringTestModels.INITIAL_STATECHART;
import static org.yakindu.sct.test.models.RefactoringTestModels.UNFOLD_EXIT_ACTIONS;

import org.junit.Test;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.refactoring.refactor.impl.UnfoldExitActionsRefactoring;

import com.google.common.collect.Lists;

/**
 * Tests for {@link UnfoldExitActionsRefactoring}.
 * 
 * @author thomas kutz - Initial contribution and API
 * 
 */
public class UnfoldExitActionsRefactoringTest extends StateBasedRefactoringTest {

	@Test
	public void testUnfoldExitActions() {

		testRefactoringOnState(
				UNFOLD_EXIT_ACTIONS + INITIAL_STATECHART,
				UNFOLD_EXIT_ACTIONS + EXPECTED_STATECHART, 
				"A");
	}

	@Test
	public void testIsExecutable() {
		testRefactoringIsExecutableOnState(
				UNFOLD_EXIT_ACTIONS + INITIAL_STATECHART,
				UNFOLD_EXIT_ACTIONS + EXPECTED_STATECHART, 
				"A",
				true);
		testRefactoringIsExecutableOnState(
				UNFOLD_EXIT_ACTIONS + INITIAL_STATECHART,
				UNFOLD_EXIT_ACTIONS + EXPECTED_STATECHART, 
				"InnerState",
				false);
		
		testRefactoringIsExecutableOnState(
				UNFOLD_EXIT_ACTIONS + INITIAL_STATECHART,
				UNFOLD_EXIT_ACTIONS + EXPECTED_STATECHART, 
				"D",
				false);
		
		testRefactoringIsExecutableOnState(
				UNFOLD_EXIT_ACTIONS + INITIAL_STATECHART,
				UNFOLD_EXIT_ACTIONS + EXPECTED_STATECHART, 
				"E",
				false);
		
	}
	
	@Override
	protected AbstractRefactoring<?> getRefactoring(State state) {
		UnfoldExitActionsRefactoring unfoldExitActionsRefactoring = new UnfoldExitActionsRefactoring();
		unfoldExitActionsRefactoring.setContextObjects(Lists
				.newArrayList(state));
		return unfoldExitActionsRefactoring;
	}

}
