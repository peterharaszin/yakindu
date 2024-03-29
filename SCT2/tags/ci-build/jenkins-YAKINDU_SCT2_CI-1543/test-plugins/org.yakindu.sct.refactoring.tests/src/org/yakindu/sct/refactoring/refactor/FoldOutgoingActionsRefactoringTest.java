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

import org.junit.Test;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.refactoring.refactor.AbstractRefactoring;
import org.yakindu.sct.refactoring.refactor.impl.FoldOutgoingActionsRefactoring;
import org.yakindu.sct.refactoring.refactor.util.TestModels;

import com.google.common.collect.Lists;
/**
 * 
 * @author thomas kutz - Initial contribution and API
 * 
 */
public class FoldOutgoingActionsRefactoringTest extends
		StateBasedRefactoringTest {

	@Test
	public void testFoldOutgoingActions() {

		testRefactoringOnState(TestModels.FOLD_OUTGOING_ACTIONS
				+ TestModels.INITIAL_STATECHART,
				TestModels.FOLD_OUTGOING_ACTIONS
						+ TestModels.EXPECTED_STATECHART, "A");

		// TODO check if executionFlow is modified after refactoring?? May not
		// be possible for all refactorings
	}

	@Override
	protected AbstractRefactoring<?> getRefactoring(State state) {
		FoldOutgoingActionsRefactoring foldOutgoingActionsRefactoring = new FoldOutgoingActionsRefactoring();
		foldOutgoingActionsRefactoring.setContextObjects(Lists.newArrayList(state));
		return foldOutgoingActionsRefactoring;

	}

}
