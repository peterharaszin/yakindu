/**
 * Copyright (c) 2009 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package com.yakindu.simulation.engine.statechart.test.testclasses;

import java.io.File;

import org.mda4e.simulation.core.ISimulationParameterSet;
import org.mda4e.simulation.core.SimulationException;
import org.mda4e.simulation.core.SimulationState;
import org.mda4e.simulation.core.event.IEvent;
import org.mda4e.simulation.core.event.IEventListener;

import com.yakindu.simulation.engine.statechart.StatechartSimulator;
import com.yakindu.simulation.engine.statechart.engine.SimulationParameterSet;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ArgumentIsNullException;
import com.yakindu.simulation.engine.statechart.test.Utilities;

import statemachine.Event;
import statemachine.Variable;

/**
 * Provides general variables and methods for test classes which are used
 * to test the functionality of the <code>StatechartSimulator</code>.
 * 
 * @author Philipp Richter
 */
public abstract class AFunctionalityTest implements IEventListener {

	/** The engine is the interface to control the statechart simulator. */
	protected StatechartSimulator engine = null;

	/** Defines the error message, if the variable of an event has the wrong value. */
	protected static final String message = "Event error: The \"%1$s\" is wrong (Event %2$d)! The value %3$s was expected, but the value was %4$s!\n%5$s\n%6$s\n";
	/** Defines the error message, if the event type was wrong. */
	protected static final String message2 = "Event %s error: The event type \"%s\" was expected, but the type \"%s\" was received!\n%s\n%s\n";
	
	/**
	 * Indicates that an simulation was received (if not null),
	 * so the tests can be stopped.
	 */
	protected AssertionError simulationError = null;
	
	/** Is used for the synchronization of "simulationError". */
	protected Object syncObject = new Object();
	
	/** Defines the input history and logs the respective input changes of the current test. */
	protected StringBuffer inputHistory = null;
	/** Defines the event history, so it is possible to look which events were received. */
	protected StringBuffer eventHistory = null;
	
	/** Defines the number of received events which were sent by the simulator. */
	protected int numberOfEvents = 0;
	
	public AFunctionalityTest() {
		inputHistory = new StringBuffer();
		eventHistory = new StringBuffer();
	}
	/**
	 * Set up the <code>SCEngine</code> instance with the given statechart file.
	 * 
	 * @param statechartFile	defines the path of the statechart file
	 * 
	 * @throws SimulationException	will be thrown, if an error during the initialization
	 * 								occurs
	 */
	protected void setUpSimulator(final String statechartFile) throws SimulationException {
		
		//engine = SCEngine.getInstance();
		engine = new StatechartSimulator();
		engine.addEventListener(this);
		
		engine.setSimulationParameters(getDefaultParameterSet(statechartFile));
		engine.initializeEngine();
	}
	
	/**
	 * Provides a default configured parameter set with the given statechart as
	 * simulation system.
	 * 
	 * @param statechartFile	defines the path of the statechart file
	 * 
	 * @return	An instance of the {@link ISimulationParameterSet}.
	 */
	protected ISimulationParameterSet getDefaultParameterSet(final String statechartFile) {
		final String file = Utilities.getFile(getClass(), statechartFile);
		
		ISimulationParameterSet parameterSet = new SimulationParameterSet() {
			
			//Heater_controlled.statemachine
			File system = new File(file);
			
			public File getSimulationSystem() {
				return system;
			}
		
			public int getInstanceNumber() {
				return 1;
			}
		};
		
		return parameterSet;
	}
	
	/**
	 * This method blocks the calling method until the simulator has
	 * finished the current step.
	 */
	protected void waitForNextStep() {
		
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		
		while(engine.getSimulationState() == SimulationState.RUNNING) {
			
			// Checking if an error was occurred
			synchronized (syncObject) {
				if(simulationError != null) {
					throw simulationError;
				}
			}
			
			Thread.yield();
		}
		
		// Checking if an error was occurred
		synchronized (syncObject) {
			if(simulationError != null) {
				throw simulationError;
			}
		}
	}
	
	/**
	 * Creates an assertion error with the full exception hierarchy of the
	 * given exception.
	 * 
	 * @param error		defines the thrown exception
	 *  
	 * @return The generated <code>AssertionError</code> instance.
	 */
	protected AssertionError createAssertionError(Throwable error) {
		
		AssertionError asError = new AssertionError(error.getMessage());
		
		asError.setStackTrace(error.getStackTrace());
		
		if(error.getCause() != null) {
			asError.initCause(createAssertionError(error.getCause()));
		}
		
		return asError;
	}

	/**
	 * Returns the value of the variable with the given name.
	 * 
	 * @param name	defines the name of the variable which value shall be returned
	 * 
	 * @return	The value of the variable with the given name.
	 */
	protected double getVariable(String name) {
		
		double result = 0;
		
		if(engine == null) {
			simulationError = createAssertionError(new ArgumentIsNullException("The engine is null!"));
		}
		
		for(Variable var : engine.getVariables().keySet()) {
			if(var.getName().equalsIgnoreCase(name)) {
				result = engine.getVariables().get(var);
				break;
			}
		}
		
		return result;
	}
	
	/**
	 * Returns the state of the event with the given name.
	 * 
	 * @param name	defines the name of the event which state shall be returned
	 * 
	 * @return	The state of the event with the given name.
	 */
	protected boolean getEvent(String name) {
		
		boolean result = false;
		
		if(engine == null) {
			simulationError = createAssertionError(new ArgumentIsNullException("The engine is null!"));
		}
		
		for(Event var : engine.getEvents().keySet()) {
			if(var.getName().equalsIgnoreCase(name)) {
				result = engine.getEvents().get(var);
				break;
			}
		}
		
		return result;
	}
	
	/**
	 * Receives all test events and calls the respective method which checks the event properties.
	 * 
	 * @param event		defines the event which was sent by the simulator
	 */
	public abstract void receiveEvent(IEvent event);
}
