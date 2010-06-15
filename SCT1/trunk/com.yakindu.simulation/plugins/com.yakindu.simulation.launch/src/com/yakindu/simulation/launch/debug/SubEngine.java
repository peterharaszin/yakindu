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

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;
import org.mda4e.simulation.core.ISimulationEngine;
import org.mda4e.simulation.core.SimulationException;
import org.mda4e.simulation.core.event.EventDispatcher;
import org.mda4e.simulation.core.event.IEvent;
import org.mda4e.simulation.core.event.IEventListener;
import org.mda4e.simulation.core.event.SimulationEvent;

public class SubEngine implements IStackFrame, EventHandler {

    private ISimulationEngine engine;
    private final IThread parent;
    private boolean stepping = false;
    private boolean suspended = true;
    private boolean terminated = false;
    
    public SubEngine(final IThread parent, final ISimulationEngine engine) {
        this.parent = parent;
        this.engine = engine;
    }
    
    public int getCharEnd() throws DebugException {
        return -1;
    }

    public int getCharStart() throws DebugException {
        return -1;
    }

    public int getLineNumber() throws DebugException {
        return -1;
    }

    public String getName() throws DebugException {
        return engine.getEngineName();
    }

    public IRegisterGroup[] getRegisterGroups() throws DebugException {
        // TODO Auto-generated method stub
        return new IRegisterGroup[0];
    }

    public IThread getThread() {
        return parent;
    }

    public IVariable[] getVariables() throws DebugException {
        // TODO Auto-generated method stub
        return new IVariable[0];
    }

    public boolean hasRegisterGroups() throws DebugException {
        return false;
    }

    public boolean hasVariables() throws DebugException {
        return false;
    }

    public IDebugTarget getDebugTarget() {
        return parent.getDebugTarget();
    }

    public ILaunch getLaunch() {
        return parent.getLaunch();
    }

    public String getModelIdentifier() {
        return parent.getModelIdentifier();
    }

    public Object getAdapter(final Class adapter) {
        return null;
    }

    public boolean canStepInto() {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean canStepOver() {
        // TODO Auto-generated method stub
        return false;
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
        stepping = true;
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

    public boolean canResume() {
        return !terminated && !stepping && suspended;
    }

    public boolean canSuspend() {
        return !terminated && !stepping && !suspended;
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

    public boolean canTerminate() {
        return !terminated;
    }

    public boolean isTerminated() {
        return terminated;
    }

    public void terminate() throws DebugException {
        try {
            engine.disposeEngine();
        } catch (SimulationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    private EventDispatcher eventDispatcher = new EventDispatcher();
    
    public void addEventListener(final IEventListener listener) {
        eventDispatcher.addEventListener(listener);
    }
    
    public void removeEventListener(final IEventListener listener) {
        eventDispatcher.removeEventListener(listener);
    }

    public void handleEvent(final IEvent event) {
        if (event.getSource() == engine) {
            if (event instanceof SimulationEvent) {
                SimulationEvent simEvent =  (SimulationEvent)event;
                switch (simEvent.getEventType()) {
                case SimPause:
                    suspended = true;
                    stepping = false;
                    break;
                case SimResume:
                    suspended = false;
                    break;
                case SimStop:
                    terminated = true;
                    break;
                case SimStart:
                    suspended = false;
                    break;
					default:
						break;
                }
            }
        }
    }

}
