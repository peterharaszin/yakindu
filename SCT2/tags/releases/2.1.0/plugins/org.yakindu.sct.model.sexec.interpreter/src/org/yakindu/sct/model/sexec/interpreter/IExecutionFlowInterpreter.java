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
package org.yakindu.sct.model.sexec.interpreter;

import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.simulation.core.runtime.IExecutionFacade;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface IExecutionFlowInterpreter extends IExecutionFacade {

	/**
	 * @param flow
	 */
	public void initialize(final ExecutionFlow flow);
	
}
