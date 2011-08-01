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
package org.yakindu.sct.core.simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.yakindu.sct.core.simulation.ISimulationSessionListener.SimulationState;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ISGraphSimulationSession implements Runnable,
		ISGraphExecutionListener {

	private List<ISimulationSessionListener> listeners;

	private BlockingQueue<Runnable> taskQueue;

	private SimulationState currentState;

	private final ISGraphExecutionFacade facade;

	private Timer timer;

	public ISGraphSimulationSession(ISGraphExecutionFacade facade) {
		this.facade = facade;
		facade.addExecutionListener(this);
		listeners = new ArrayList<ISimulationSessionListener>();
		taskQueue = new LinkedBlockingQueue<Runnable>();
		timer = new Timer();
	}

	public void start() {
		taskQueue.add(new Runnable() {
			public void run() {
				SGraphSimulationSessionRegistry.INSTANCE
						.registerSimulationSession(ISGraphSimulationSession.this);
				changeSimulationState(SimulationState.STARTED);
				facade.enter();
				changeSimulationState(SimulationState.RUNNING);
				scheduleCycle();
			}
		});
	}

	public void singleStep() {
		taskQueue.add(new Runnable() {
			public void run() {
				changeSimulationState(SimulationState.SINGLESTEP);
			}
		});
	}

	public void resume() {
		taskQueue.add(new Runnable() {
			public void run() {
				changeSimulationState(SimulationState.RUNNING);
				scheduleCycle();
			}
		});
	}

	public void suspend() {
		taskQueue.add(new Runnable() {
			public void run() {
				changeSimulationState(SimulationState.PAUSED);
			}
		});
	}

	public void terminate() {
		taskQueue.add(new Runnable() {
			public void run() {
				changeSimulationState(SimulationState.TERMINATED);
				SGraphSimulationSessionRegistry.INSTANCE
						.unregisterSimulationSession(ISGraphSimulationSession.this);
			}
		});
	}

	public void raiseEvent(final String eventName) {
		taskQueue.add(new Runnable() {
			public void run() {
				facade.raise(eventName);
			}
		});
	}

	public void setVariableValue(String variableName, Object value) {

	}

	protected void scheduleCycle() {
		if (currentState == SimulationState.RUNNING) {
			timer.schedule(new TimerTask() {
				public void run() {
					taskQueue.add(new Runnable() {
						public void run() {
							facade.runCycle();
						}
					});
					scheduleCycle();
				}
			}, 100);

		}
	}

	public void run() {
		while (!(currentState == SimulationState.TERMINATED)) {
			try {
				Runnable task = taskQueue.take();
				task.run();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	protected void changeSimulationState(SimulationState newState) {
		for (ISimulationSessionListener listener : listeners) {
			listener.simulationStateChanged(this.currentState, newState);
		}
		this.currentState = newState;
	}

	public void stateEntered(Vertex vertex) {
		for (ISimulationSessionListener listener : listeners) {
			listener.stateEntered(vertex);
		}
	}

	public void stateLeft(Vertex vertex) {
		for (ISimulationSessionListener listener : listeners) {
			listener.stateLeft(vertex);
		}

	}

	public void transitionFired(Transition transition) {
		for (ISimulationSessionListener listener : listeners) {
			listener.transitionFired(transition);
		}

	}

	public List<ISimulationSessionListener> getListeners() {
		return listeners;
	}

	public void variableValueChanged(String variableName, Object value) {
		for (ISimulationSessionListener listener : listeners) {
			listener.variableValueChanged(variableName, value);
		}

	}

	public void eventRaised(String eventName) {
		for (ISimulationSessionListener listener : listeners) {
			listener.eventRaised(eventName);
		}
	}

	public ISGraphExecutionScope getExecutionScope() {
		return facade.getExecutionScope();
	}
}
