/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.simulation.simulator.internal;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipselabs.damos.execution.executionflow.DataFlowSourceEnd;
import org.eclipselabs.damos.execution.executionflow.LatchNode;
import org.eclipselabs.damos.execution.executionflow.TaskInputNode;
import org.eclipselabs.damos.execution.executionflow.TaskNode;
import org.eclipselabs.damos.simulation.core.ISimulationRunnable;
import org.eclipselabs.damos.simulation.core.SimulationEvent;
import org.eclipselabs.damos.simulation.core.SimulationManager;
import org.eclipselabs.damos.simulation.simulator.ISimulationObject;
import org.eclipselabs.damos.simulation.simulator.util.SimulationUtil;
import org.eclipselabs.mscript.computation.core.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class Task extends Thread implements Adapter {
	
	private static final int QUEUE_CAPACITY = 100;
	
	private final DiscreteStateComputationHelper discreteStateComputationHelper = new DiscreteStateComputationHelper();
	
	private Notifier target = null;

	private Simulation simulation;
	private TaskNode taskNode;
	private BlockingQueue<Data> queue = new ArrayBlockingQueue<Data>(QUEUE_CAPACITY);
	
	private volatile IStatus status = Status.OK_STATUS;

	/**
	 * 
	 */
	public Task(Simulation simulation, TaskNode taskNode) {
		this.simulation = simulation;
		this.taskNode = taskNode;
	}
	
	public void sendValue(TaskInputNode taskInputNode, IValue value) {
		queue.offer(new Data(taskInputNode, value));
	}
	
	public void execute(ISimulationRunnable runnable) {
		queue.offer(new Data(runnable));
	}
	
	public void newLatchValueAvailable() {
		queue.offer(Data.UNBLOCK);
	}
	
	/**
	 * @return the status
	 */
	public IStatus getStatus() {
		return status;
	}
	
	public void run() {
		SimulationMonitor monitor = new SimulationMonitor();
		try {
			for (;;) {
				Data data = queue.take();

				if (data == Data.UNBLOCK) {
					for (LatchNode latchNode : taskNode.getLatchNodes()) {
						ISimulationObject simulationObject = SimulationUtil.getSimulationObject(latchNode);
						discreteStateComputationHelper.propagateComponentOutputValues(latchNode, simulationObject);
					}
				} else if (data.value != null) {
					EList<DataFlowSourceEnd> outgoingDataFlows = data.taskInputNode.getOutgoingDataFlows();
					if (!outgoingDataFlows.isEmpty()) {
						discreteStateComputationHelper.setInputValues(outgoingDataFlows.get(0), data.value);
					}
				} else if (data.runnable != null) {
					data.runnable.run();
				}
				
				discreteStateComputationHelper.computeDiscreteStates(taskNode, Double.NaN, monitor);
				SimulationManager.getInstance().fireSimulationEvent(new SimulationEvent(this, simulation, SimulationEvent.ASYNCHRONOUS));
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		} catch (CoreException e) {
			status = e.getStatus();
		}
		
		SimulationEngine.dispose(taskNode);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.Adapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	public void notifyChanged(Notification notification) {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.Adapter#getTarget()
	 */
	public Notifier getTarget() {
	    return target;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.Adapter#setTarget(org.eclipse.emf.common.notify.Notifier)
	 */
	public void setTarget(Notifier newTarget) {
	    target = newTarget;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.Adapter#isAdapterForType(java.lang.Object)
	 */
	public boolean isAdapterForType(Object type) {
		return type == Task.class;
	}
	
	private static class Data {
		
		public static final Data UNBLOCK = new Data();
		
		public TaskInputNode taskInputNode;
		public IValue value;
		public ISimulationRunnable runnable;

		/**
		 * 
		 */
		public Data() {
		}
		
		/**
		 * 
		 */
		public Data(TaskInputNode taskInputNode, IValue value) {
			this.taskInputNode = taskInputNode;
			this.value = value;
		}
		
		public Data(ISimulationRunnable runnable) {
			this.runnable = runnable;
		}

	}

}
