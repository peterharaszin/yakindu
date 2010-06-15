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
package com.yakindu.simulation.view.statemachine;

import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.mda4e.simulation.core.SimulationState;
import org.mda4e.simulation.core.event.EventDispatcher;
import org.mda4e.simulation.core.event.IEvent;
import org.mda4e.simulation.core.event.IEventListener;
import org.mda4e.simulation.core.event.SimulationEvent;
import org.mda4e.simulation.core.event.SimulationEvent.SimulationEventTypes;
import org.mda4e.simulation.statemachine.IStatemachineEngine;

import com.yakindu.simulation.view.statemachine.nls.Messages;
import com.yakindu.simulation.view.statemachine.presentation.utilities.comparators.EngineComparator;

/**
 * @author Philipp Richter
 */
public final class ViewController extends EventDispatcher implements
		IEventListener {

	// implements ISimulationController {

	/** Defines the instance to log informations and errors. */
	private final Logger log = Logger.getLogger(ViewController.class);

	/** Defines the unique instance of this class. */
	private static ViewController instance = null;

	/**
	 * Defines the <code>EventDispatcher</code> instance which contains all
	 * listeners.
	 */
	private EventDispatcher viewDispatcher = null;

	/**
	 * Defines all instances of the <code>IStatemachineEngine</code> which are
	 * active.
	 */
	private SortedSet<IStatemachineEngine> engines = null;

	/**
	 * Creates an instance of this class with a default configuration.
	 */
	public ViewController() {

		viewDispatcher = new EventDispatcher();

		engines = new TreeSet<IStatemachineEngine>(new EngineComparator());
	}

	/**
	 * Provides the unique instance of this class. If no instance was created, a
	 * new one is instantiated.
	 * 
	 * @return The unique instance of this class.
	 */
	public static synchronized ViewController getInstance() {

		if (instance == null) {
			instance = new ViewController();
		}

		return instance;
	}

	/**
	 * @see org.mda4e.simulation.controller.ISimulationController#createControlGroup(org.eclipse.swt.widgets.Composite)
	 */
	public Group createControlGroup(final Composite parent) {

		return null;
	}

	/**
	 * @see org.mda4e.simulation.core.event.IEventListener#receiveEvent(org.mda4e.simulation.core.event.IEvent)
	 */
	public void receiveEvent(final IEvent event) {

		if (event != null) {

			if (event instanceof SimulationEvent) {

				final SimulationEvent simEvent = (SimulationEvent) event;

				if (simEvent.getSource() != null
					&& simEvent.getSource() instanceof IStatemachineEngine) {

					if (simEvent.getEventType() == SimulationEventTypes.EngineCreated
						|| simEvent.getEventType() == SimulationEventTypes.SubEngineCreated) {

						final IStatemachineEngine engine =
								(IStatemachineEngine) simEvent.getSource();

						// Register the own listener
						engine.addEventListener(this);

						if (log.isDebugEnabled()) {
							log.debug(new StringBuffer("New engine detected: ")
								.append(engine.getEngineName())
								.toString());
						}

					} else if (simEvent.getEventType() == SimulationEventTypes.EngineInitialized
								|| simEvent.getEventType() == SimulationEventTypes.SubEngineInitialized) {

						final IStatemachineEngine engine =
								(IStatemachineEngine) simEvent.getSource();

						Display.getDefault().asyncExec(new Runnable() {

							public void run() {

								synchronized (engines) {
									addEngine(engine);
								}
							}
						});

					} else if (simEvent.getEventType() == SimulationEventTypes.EngineDisposed
								|| simEvent.getEventType() == SimulationEventTypes.SubEngineDisposed) {

						Display.getDefault().syncExec(new Runnable() {

							public void run() {

								synchronized (engines) {

									checkEngines();
								}
							}
						});
					}
				}
			}

			viewDispatcher.fireEvent(event);
		}
	}

	/**
	 * Adds the given {@link IEventListener} to list of observers of instances
	 * of this class.
	 * 
	 * @param listener defines the new listener
	 */
	public void addViewEventListener(final IEventListener listener) {

		viewDispatcher.addEventListener(listener);
	}

	/**
	 * Removes the given {@link IEventListener} to list of observers of
	 * instances of this class.
	 * 
	 * @param listener defines the listener which shall be removed
	 */
	public void removeViewEventListener(final IEventListener listener) {

		viewDispatcher.removeEventListener(listener);
	}

	/*
	 * @see
	 * org.mda4e.simulation.controller.ISimulationController#getControllerName()
	 */
	public String getControllerName() {

		return "Yakindu Statemachine View";
	}

	/**
	 * Creates a name for the engine like: "Statechart (Instance: 1)".
	 * 
	 * @param engine defines the engine whose name must be created
	 * 
	 * @return The new name for the engine. The result is every time unequal to
	 *         <code>null</code>.
	 */
	public String getEngineName(final IStatemachineEngine engine) {

		String result = Messages.ViewController_engineisunknown;

		if (engine != null) {

			if (engine.getStatechart() != null) {

				String name = engine.getStatechart().getName();
				final int instance = engine.getInstanceNumber();

				if (name == null || name == "") {
					name = Messages.ViewController_statechartisunknown;
				}

				result =
						name + " (" + Messages.ViewController_instance + ": "
								+ instance + ")";

			} else {
				log.warn("The statechart of the engine \""
							+ engine.getEngineName() + "\" is null!");
			}
		} else {
			log.warn("The given engine is null!");
		}

		return result;
	}

	/**
	 * Adds the given engine to the engine list.
	 * 
	 * @param engine defines the engine which shall be add
	 * 
	 * @return The result is <code>true</code> if the engine could be added,
	 *         otherwise <code>false</code>.
	 */
	private boolean addEngine(final IStatemachineEngine engine) {

		synchronized (engines) {
			return engines.add(engine);
		}
	}

	/**
	 * Allows to check whether all engines are valid that is if a engine has not
	 * the state {@link SimulationState#DISPOSED DISPOSED}.
	 */
	private void checkEngines() {

		synchronized (engines) {

			final SortedSet<IStatemachineEngine> newEngines =
					new TreeSet<IStatemachineEngine>(new EngineComparator());

			for (final IStatemachineEngine engine : engines) {

				if (engine.getSimulationState() != SimulationState.DISPOSED) {

					newEngines.add(engine);

				} else {

					if (log.isDebugEnabled()) {
						log
							.debug(new StringBuffer(
								"Engine removed from list: ").append(
								engine.getEngineName()).toString());
					}
				}
			}
			
			engines.clear();
			
			for (IStatemachineEngine engine : newEngines) {
				engines.add(engine);
			}
		}
	}

	/**
	 * Provides a set of all currently available simulation engines.
	 * 
	 * @return All available simulation engines in a sorted order.
	 */
	public SortedSet<IStatemachineEngine> getEngines() {

		synchronized (engines) {

			checkEngines();

			return engines;
		}
	}
}