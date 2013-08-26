/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.core.runtime;

import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.simulation.core.sruntime.RuntimeContext;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface IStatechartInterpreter {

	public void initialize(final Statechart statechart);

	/**
	 * Unique name
	 */
	public String getName();

	/**
	 * Called before execution, used for initialization
	 */
	public void enter();

	/**
	 * Called after execution, used for clean up
	 */
	public void exit();

	/**
	 * Called after execution, used for clean up
	 */
	public void tearDown();

	/**
	 * Call on every cycle
	 */
	public void runCycle();
 
	public RuntimeContext getRuntimeContext();

	public void setRuntimeContext(RuntimeContext context);

}
