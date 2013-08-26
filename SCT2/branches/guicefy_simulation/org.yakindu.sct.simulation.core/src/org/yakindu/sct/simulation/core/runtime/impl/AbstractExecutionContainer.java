/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */

package org.yakindu.sct.simulation.core.runtime.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IStatusHandler;
import org.eclipse.emf.common.util.WrappedException;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.simulation.core.Activator;
import org.yakindu.sct.simulation.core.runtime.IExecutionContainer;
import org.yakindu.sct.simulation.core.runtime.IStatechartInterpreter;
import org.yakindu.sct.simulation.core.sruntime.RuntimeContext;

import com.google.inject.Inject;

/**
 * Abstract base implementation for {@link IExecutionContainer}s
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractExecutionContainer implements IExecutionContainer {

	public static final int ERROR_DURING_SIMULATION = 765;

	@Inject
	protected IStatechartInterpreter interpreter;
	@Inject
	protected RuntimeContext context;

	protected boolean terminated = false;
	protected boolean suspended = false;

	private Statechart model;
	private List<Object> operationCallbacks;

	public AbstractExecutionContainer(Statechart model) {
		this.model = model;
		operationCallbacks = new ArrayList<Object>(1);
	}

	protected void runCycle() {
		try {
			interpreter.runCycle();
		} catch (WrappedException ex) {
			Status errorStatus = new Status(Status.ERROR, Activator.PLUGIN_ID, ERROR_DURING_SIMULATION, ex.getCause()
					.getMessage(), ex.getCause());
			IStatusHandler statusHandler = DebugPlugin.getDefault().getStatusHandler(errorStatus);
			try {
				statusHandler.handleStatus(errorStatus, this);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	public void start() {
		interpreter.setRuntimeContext(context);
		interpreter.initialize(model);
		interpreter.enter();
	}

	public void suspend() {
		suspended = true;
	}

	public void resume() {
		suspended = false;
	}

	public void terminate() {
		terminated = true;
		interpreter.tearDown();
	}

	public void step() {
		interpreter.runCycle();
	}

	public RuntimeContext getRuntimeContext() {
		return context;
	}

	public IStatechartInterpreter getStatechartInterpreter() {
		return interpreter;
	}

	public void addCallbackObject(Object object) {
		operationCallbacks.add(object);
	}

	public List<Object> getOperationCallbacks() {
		return operationCallbacks;
	}

}
