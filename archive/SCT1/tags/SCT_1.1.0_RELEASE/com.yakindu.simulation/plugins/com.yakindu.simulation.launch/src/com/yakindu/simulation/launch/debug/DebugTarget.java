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

import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.mda4e.simulation.controller.ISimulationController;
import org.mda4e.simulation.core.event.EventDispatcher;
import org.mda4e.simulation.core.event.IEvent;
import org.mda4e.simulation.core.event.IEventListener;
import org.mda4e.simulation.core.event.SimulationEvent;

import com.yakindu.simulation.launch.Activator;
import com.yakindu.simulation.launch.message.Messages;

public class DebugTarget implements IDebugTarget, ISimulationController {

    private final ILaunch launch;
    private final IDebugTarget target;
    private EngineThread thread;
    private boolean suspended = true;
    private boolean terminated = false;
    private final IProgressMonitor monitor;
    
    public DebugTarget(final IProgressMonitor monitor, final ILaunch launch) throws CoreException {
        super();
        this.monitor = monitor;
        this.launch = launch;
        target = this;
    }
    
    public String getName() throws DebugException {
        return launch.getLaunchConfiguration().getName();
    }

    public IProcess getProcess() {
        return null;
    }

    public IThread[] getThreads() throws DebugException {
        while (thread == null) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return new EngineThread[] {thread};
    }

    public boolean hasThreads() throws DebugException {
        return true;
    }

    public boolean supportsBreakpoint(final IBreakpoint breakpoint) {
        return false;
    }

    public IDebugTarget getDebugTarget() {
        return target;
    }

    public ILaunch getLaunch() {
        return launch;
    }

    public String getModelIdentifier() {
        return Activator.PLUGIN_ID;
    }

    public Object getAdapter(final Class adapter) {
        return null;
    }

    public boolean canTerminate() {
        return !monitor.isCanceled();
    }

    public boolean isTerminated() {
        return monitor.isCanceled() || terminated;
    }

    public void terminate() throws DebugException {
    	monitor.setCanceled(true);
    }

    public boolean canResume() {
        if (thread != null) {
            return thread.canResume();
        }
        return !terminated && suspended;
    }

    public boolean canSuspend() {
        if (thread != null) {
            return thread.canSuspend();
        }
        return !terminated && !suspended;
    }

    public boolean isSuspended() {
        if (thread != null) {
            return thread.isSuspended();
        }
        return suspended;
    }

    public void resume() throws DebugException {
        thread.resume();
    }

    public void suspend() throws DebugException {
        thread.suspend();
    }

    public void breakpointAdded(final IBreakpoint breakpoint) {
        // TODO Auto-generated method stub

    }

    public void breakpointChanged(final IBreakpoint breakpoint, final IMarkerDelta delta) {
        // TODO Auto-generated method stub

    }

    public void breakpointRemoved(final IBreakpoint breakpoint, final IMarkerDelta delta) {
        // TODO Auto-generated method stub

    }

    public boolean canDisconnect() {
        return false;
    }

    public void disconnect() throws DebugException {
        }

    public boolean isDisconnected() {
        return false;
    }

    public IMemoryBlock getMemoryBlock(final long startAddress, final long length) throws DebugException {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean supportsStorageRetrieval() {
        // TODO Auto-generated method stub
        return false;
    }

    
    private EventDispatcher eventDispatcher = new EventDispatcher();
    
    public void addEventListener(final IEventListener listener) {
        eventDispatcher.addEventListener(listener);
    }

    public Group createControlGroup(final Composite parent) {
        return null;
    }

    public String getControllerName() {
        return Messages.DEBUG_CONTROLLER_NAME;
    }

    public void removeEventListener(final IEventListener listener) {
        eventDispatcher.removeEventListener(listener);
    }

    public void receiveEvent(final IEvent event) {
        if (event instanceof SimulationEvent) {
            SimulationEvent simEvent =  (SimulationEvent)event;
            switch (simEvent.getEventType()) {
            case EngineCreated:
                thread = new EngineThread(this, simEvent.getSource());
                //eventDispatcher.addEventListener(thread);
                thread.addEventListener(this);
                break;
            case EngineDisposed:
                fireEvent(new DebugEvent(this, DebugEvent.TERMINATE));
                thread.removeEventListener(this);
                monitor.setCanceled(true);
                //eventDispatcher.removeEventListener(thread);
                break;
            case SimPause:
                suspended = true;
                fireSuspendEvent(DebugEvent.STEP_END);
                thread.handleEvent(simEvent);
                break;
            case SimStart:
            case SimResume:
                suspended = false;
                thread.handleEvent(simEvent);
                fireResumeEvent(DebugEvent.UNSPECIFIED);
                break;
            case SimStop:
                suspended = true;
                fireEvent(new DebugEvent(this, DebugEvent.TERMINATE));
                break;
            case SimError:
            case SubEngineInitialized:
                suspended = true;
                break;
            case EngineInitialized:
                suspended = true;
                break;
            case SubEngineCreated:
            case SubEngineDisposed:
                break;
				default:
					break;
            }
            
        }
        thread.handleEvent(event);
    }
    
    /** Fires a debug event
     * 
     * @param event the event to be fired
     */
    protected void fireEvent(final DebugEvent event) {
    	if(DebugPlugin.getDefault() != null) {
            DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[] {event});
    	}
    }
    
    /**
     * Fires a <code>RESUME</code> event for this element with
     * the given detail.
     * 
     * @param detail event detail code
     */
    public void fireResumeEvent(final int detail) {
            fireEvent(new DebugEvent(this, DebugEvent.RESUME, detail));
    }

    /**
     * Fires a <code>SUSPEND</code> event for this element with
     * the given detail.
     * 
     * @param detail event detail code
     */
    public void fireSuspendEvent(final int detail) {
        fireEvent(new DebugEvent(this, DebugEvent.SUSPEND, detail));
    }
}
