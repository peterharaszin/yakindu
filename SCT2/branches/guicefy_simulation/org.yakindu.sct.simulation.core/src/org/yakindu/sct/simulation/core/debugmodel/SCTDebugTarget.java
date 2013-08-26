/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.core.debugmodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.simulation.core.Activator;
import org.yakindu.sct.simulation.core.runtime.IExecutionContainer;
import org.yakindu.sct.simulation.core.runtime.IExecutionContainerFactory;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTDebugTarget extends SCTDebugElement implements IDebugTarget {

	private ILaunch launch;

	private boolean stepping = false;
	private boolean terminated = false;
	private boolean suspended = false;

	private final Statechart statechart;

	private List<SCTDebugThread> threads;

	@Inject
	private IExecutionContainerFactory containerFactory;
	private IExecutionContainer container;

	public SCTDebugTarget(ILaunch launch, Statechart statechart) throws CoreException {
		super(null, statechart.eResource().getURI().toPlatformString(true));
		Activator.getInjector().injectMembers(this);
		this.launch = launch;
		this.statechart = statechart;
		threads = Lists.newArrayList();

		container = containerFactory.createExecutionContainer(statechart, getLaunch());
		container.start();
		
		// facade.addTraceListener(this);
	}

	public IProcess getProcess() {
		return null;
	}

	public void stepOver() {
		fireEvent(new DebugEvent(getDebugTarget(), DebugEvent.STEP_OVER));
		container.step();
	}

	public IThread[] getThreads() throws DebugException {
		// Collect all active regions
		EList<RegularState> activeLeafStates = container.getRuntimeContext().getActiveStates();
		List<Region> activeRegions = new ArrayList<Region>();
		for (RegularState vertex : activeLeafStates) {
			activeRegions.add(vertex.getParentRegion());
		}
		// Remove orphaned debug threads
		Iterator<SCTDebugThread> iterator = threads.iterator();
		while (iterator.hasNext()) {
			SCTDebugThread next = iterator.next();
			if (!activeRegions.contains(next.getRegion())) {
				iterator.remove();
			}
		}
		// Add new debug threads
		for (Region region : activeRegions) {
			boolean found = false;
			for (SCTDebugThread thread : threads) {
				if (thread.getRegion() == region) {
					found = true;
				}
			}
			if (!found) {
				threads.add(new SCTDebugThread(this, container, getResourceString(), region));
			}
		}
		return threads.toArray(new IThread[] {});
	}

	public boolean hasThreads() throws DebugException {
		return true;
	}

	public String getName() throws DebugException {
		// return facade.getName();
		return "";
	}

	public boolean supportsBreakpoint(IBreakpoint breakpoint) {
		return true;
	}

	public boolean canTerminate() {
		return !terminated;
	}

	public boolean isTerminated() {
		return terminated;
	}

	public void terminate() throws DebugException {
		fireEvent(new DebugEvent(getDebugTarget(), DebugEvent.TERMINATE));
		terminated = true;
		// facade.removeTraceListener(this);
		container.terminate();
	}

	public boolean canResume() {
		return suspended && !terminated;
	}

	public boolean canSuspend() {
		return !suspended && !terminated;
	}

	public boolean isSuspended() {
		return suspended;
	}

	public void resume() throws DebugException {
		fireEvent(new DebugEvent(this, DebugEvent.RESUME));
		fireChangeEvent(DebugEvent.CONTENT);
		suspended = false;
		container.resume();
	}

	public void suspend() throws DebugException {
		fireEvent(new DebugEvent(this, DebugEvent.SUSPEND));
		fireChangeEvent(DebugEvent.CONTENT);
		suspended = true;
		container.suspend();
	}

	public void breakpointAdded(IBreakpoint breakpoint) {
	}

	public void breakpointRemoved(IBreakpoint breakpoint, IMarkerDelta delta) {
	}

	public void breakpointChanged(IBreakpoint breakpoint, IMarkerDelta delta) {
	}

	public boolean canDisconnect() {
		return false;
	}

	public void disconnect() throws DebugException {

	}

	public boolean isDisconnected() {
		return false;
	}

	public boolean supportsStorageRetrieval() {
		return false;
	}

	public IMemoryBlock getMemoryBlock(long startAddress, long length) throws DebugException {
		return null;
	}

	public ILaunch getLaunch() {
		return launch;
	}

	public IDebugTarget getDebugTarget() {
		return this;
	}

	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if (adapter == IExecutionContainer.class)
			return container;
		if (adapter == EObject.class) {
			return statechart;
		}
		return super.getAdapter(adapter);
	}

	public boolean canStepOver() {
		return isSuspended() && !isTerminated();
	}

	public boolean isStepping() {
		return stepping;
	}

	// public void traceStepExecuted(Trace trace) {
	// if (trace instanceof TraceStateEntered || trace instanceof
	// TraceStateExited)
	// fireChangeEvent(DebugEvent.CONTENT);
	// if (trace instanceof TraceReactionWillFire) {
	// if (launch.getLaunchMode().equals("debug"))
	// evaluateBreakpoints(trace);
	// }
	// }private void evaluateBreakpoints(Trace trace) {
	// try {
	// Reaction reaction = ((TraceReactionWillFire) trace).getReaction();
	// EObject sourceElement = reaction.getSourceElement();
	// IBreakpoint[] breakpoints =
	// DebugPlugin.getDefault().getBreakpointManager()
	// .getBreakpoints(SCTBreakpoint.BREAKPOINT_ID);
	// for (IBreakpoint iBreakpoint : breakpoints) {
	// if (!iBreakpoint.isEnabled())
	// continue;
	// if (iBreakpoint instanceof SCTBreakpoint) {
	// SCTBreakpoint sctBreakpoint = (SCTBreakpoint) iBreakpoint;
	// if (EcoreUtil.equals(sctBreakpoint.getSemanticObject(), sourceElement)) {
	// if (sctBreakpoint.isConditional()) {
	// String expression = sctBreakpoint.getExpression();
	//
	// } else {
	// suspend();
	// fireEvent(new DebugEvent(this, DebugEvent.BREAKPOINT));
	// }
	// }
	// }
	// }
	// } catch (CoreException e1) {
	// e1.printStackTrace();
	// }
	// }

}
