/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.refactoring.test.models;

import org.yakindu.sct.test.models.BaseTestModels;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class RefactoringTestModels extends BaseTestModels {

	private static final String TESTMODEL_DIR = "org.yakindu.sct.refactoring.tests/testmodels/refactoring/";

	public static final String INITIAL_STATECHART = "before.sct";
	public static final String EXPECTED_STATECHART = "after.sct";
	public static final String FOLD_INCOMING_ACTIONS = "fold_inc_action/";
	public static final String FOLD_OUTGOING_ACTIONS = "fold_out_action/";
	public static final String UNFOLD_ENTRY_ACTIONS = "unfold_entry_action/";
	public static final String UNFOLD_EXIT_ACTIONS = "unfold_exit_action/";
	public static final String GROUPING_STATES = "grouping_states/";
	public static final String RENAMING = "renaming/";
	public static final String CREATE_SUBMACHINE = "create_submachine/";

	@Override
	public String getModelDirectory() {
		return TESTMODEL_DIR;
	}

}
