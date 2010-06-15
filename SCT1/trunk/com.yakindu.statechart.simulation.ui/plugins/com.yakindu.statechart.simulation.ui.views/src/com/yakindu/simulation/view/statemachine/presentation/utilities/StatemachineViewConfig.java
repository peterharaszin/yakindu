/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
/**
 * 
 */
package com.yakindu.simulation.view.statemachine.presentation.utilities;

/**
 * @author Philipp Richter
 * 
 */
public class StatemachineViewConfig {

	/**
	 * Indicates whether a new detected simulation engine shall be shown in the
	 * table. If this option is <code>true</code> the new detected engine will
	 * automatically be shown in the table.
	 */
	private boolean showNewEngine = false;

	/**
	 * @param showNewEngine the showNewEngine to set
	 */
	public void setShowNewEngine(final boolean showNewEngine) {

		this.showNewEngine = showNewEngine;
	}

	/**
	 * @return the showNewEngine
	 */
	public boolean isShowNewEngine() {

		return showNewEngine;
	}
}
