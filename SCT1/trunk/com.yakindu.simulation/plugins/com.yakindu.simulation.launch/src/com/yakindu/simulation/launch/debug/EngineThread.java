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
package com.yakindu.simulation.launch.debug;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.mda4e.simulation.core.ISimulationEngine;
import org.mda4e.simulation.core.SimulationException;
import org.mda4e.simulation.core.event.EventDispatcher;
import org.mda4e.simulation.core.event.IEvent;
import org.mda4e.simulation.core.event.IEventListener;
import org.mda4e.simulation.core.event.SimulationEvent;

import com.yakindu.simulation.launch.message.Messages;

public class EngineThread implements IThread, EventHandler, IEventListener {

	private final ISimulationEngine engine;
	private final List<SubEngine> processes;
	private final IDebugTarget parent;
	private boolean suspended = false;
	private boolean terminated = false;
	private boolean stepping = false;

	public EngineThread(final IDebugTarget parent,
			final ISimulationEngine engine) {
		this.parent = parent;
		this.engine = engine;
		engine.addEventListener(this);
		processes = new CopyOnWriteArrayList<SubEngine>();

	}

	public IBreakpoint[] getBreakpoints() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() throws DebugException {
		return Messages.MAIN_INSTANCE + " " + engine.getInstanceNumber();
	}

	public int getPriority() throws DebugException {
		// TODO Auto-generated method stub
		return 0;
	}

	public IStackFrame[] getStackFrames() throws DebugException {
		// TODO Auto-generated method stub
		return new IStackFrame[] {};
	}

	public IStackFrame getTopStackFrame() throws DebugException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean hasStackFrames() throws DebugException {
		// TODO Auto-generated method stub
		return false;
	}

	public IDebugTarget getDebugTarget() {
		return parent;
	}

	public ILaunch getLaunch() {
		return parent.getLaunch();
	}

	public String getModelIdentifier() {
		return parent.getModelIdentifier();
	}

	public Object getAdapter(final Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean canResume() {
		return !terminated && suspended;
	}

	public boolean canSuspend() {
		return !terminated && !suspended;
	}

	public boolean isSuspended() {
		return suspended;
	}

	public void resume() throws DebugException {
		try {
			engine.resumeSimulation();
		} catch (SimulationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void suspend() throws DebugException {
		try {
			engine.pauseSimulation();
		} catch (SimulationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean canStepInto() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean canStepOver() {
		return !terminated && suspended;
	}

	public boolean canStepReturn() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isStepping() {
		return stepping;
	}

	public void stepInto() throws DebugException {
		// TODO Auto-generated method stub

	}

	public void stepOver() throws DebugException {
		try {
			engine.singleStepForward();
		} catch (SimulationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void stepReturn() throws DebugException {
		// TODO Auto-generated method stub

	}

	public boolean canTerminate() {
		return parent.canTerminate();
	}

	public boolean isTerminated() {
		return parent.isTerminated();
	}

	public void terminate() throws DebugException {
		parent.terminate();
	}

	public ISimulationEngine getEngine() {
		return engine;
	}

	private EventDispatcher eventDispatcher = new EventDispatcher();

	public void addEventListener(final IEventListener listener) {
		eventDispatcher.addEventListener(listener);
	}

	public void removeEventListener(final IEventListener listener) {
		eventDispatcher.removeEventListener(listener);
	}

	public void handleEvent(final IEvent event) {
		if (event instanceof SimulationEvent) {
			SimulationEvent simEvent = (SimulationEvent) event;
			switch (simEvent.getEventType()) {
			case SubEngineCreated:
				SubEngine subEngine = new SubEngine(this, simEvent.getSource());
				processes.add(subEngine);
				subEngine.addEventListener(this);
				break;
			case SubEngineDisposed:
				for (IStackFrame engine : processes) {
					if (engine == simEvent.getSource()) {
						try {
							engine.terminate();
						} catch (DebugException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						processes.remove(engine);
					}
				}
				break;
			case EngineInitialized:
				suspended = true;
				stepping = false;
				break;
			case SimStart:
				suspended = false;
				break;
			case SimResume:
				suspended = false;
				fireResumeEvent(DebugEvent.UNSPECIFIED);
				break;
			case SimPause:
				suspended = true;
				fireSuspendEvent(DebugEvent.UNSPECIFIED);
				break;
			case SimStop:
			case SimError:
			case EngineDisposed:
				terminated = true;
			default:
				break;
			}
		}
		for (SubEngine engine : processes) {
			engine.handleEvent(event);
		}
	}

	public void receiveEvent(final IEvent event) {
		eventDispatcher.fireEvent(event);

	}

	/** Fires a debug event.
	 * 
	 * @param event
	 *            the event to be fired
	 */
	protected void fireEvent(final DebugEvent event) {
		DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[] {event });
	}

	/** Fires a <code>RESUME</code> event for this element with the given detail.
	 * 
	 * @param detail
	 *            event detail code
	 */
	public void fireResumeEvent(final int detail) {
		fireEvent(new DebugEvent(this, DebugEvent.RESUME, detail));
	}

	/**
	 * Fires a <code>SUSPEND</code> event for this element with the given
	 * detail.
	 * 
	 * @param detail
	 *            event detail code
	 */
	public void fireSuspendEvent(final int detail) {
		fireEvent(new DebugEvent(this, DebugEvent.SUSPEND, detail));
	}

}
