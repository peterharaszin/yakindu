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
package com.yakindu.statechart.simulation.engine;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.mda4e.simulation.core.ISimulationParameterSet;
import org.mda4e.simulation.core.SimulationException;
import org.mda4e.simulation.core.SimulationState;
import org.mda4e.simulation.core.event.IEvent;
import org.mda4e.simulation.core.event.IEventListener;
import org.mda4e.simulation.statemachine.IStatemachineEngine;
import org.mda4e.simulation.statemachine.IStatemachineParameterSet;
import org.mda4e.simulation.statemachine.event.StatemachineEvent;
import org.mda4e.simulation.statemachine.event.StatemachineEvent.StatemachineEventTypes;

import com.yakindu.simulation.engine.statechart.nls.Messages;
import com.yakindu.statechart.model.expressions.runtime.Variable;
import com.yakindu.statechart.runtime.Region;
import com.yakindu.statechart.runtime.SignalEvent;
import com.yakindu.statechart.runtime.State;
import com.yakindu.statechart.runtime.Statechart;
import com.yakindu.statechart.runtime.builder.StatechartBuilder;


public class StatechartEngine implements IStatemachineEngine {


	//=========================================================================
	// General engine properties
	// 
	
	/** The name of the engine */
	public static String engineName = "YSC Simulator";
	
	
	public String getEngineName() {
		return engineName;
	}


	//=========================================================================
	// Configuration properties of the simulation engine
	
	protected ISimulationParameterSet simulationParameters;
	
	/**
	 */
	public void setSimulationParameters(
			ISimulationParameterSet simulationParameters)
			throws SimulationException {
	
		this.simulationParameters = simulationParameters;
	}
	
	/** Not required currently ...  */
	public void setSimulationParameters(
			IStatemachineParameterSet simulationParameters)
			throws SimulationException {
		this.setSimulationParameters(simulationParameters);
	}

	
	 /**
	 * @see org.mda4e.simulation.core.ISimulationEngine#getSimulationParameters()
	 */
	public ISimulationParameterSet getSimulationParameters() {
		return simulationParameters;
	}

	public int getInstanceNumber() {
		return (simulationParameters != null) ? simulationParameters.getInstanceNumber() : -1;
	}
	
	protected void validateSimulationParameters(ISimulationParameterSet params) {
		
	}

	//=========================================================================
	// Managing the engine life cycle
	//
	
	
	protected EngineState engineState = EngineState.NEW;
	protected Thread sesionThread = null;
	protected Thread eventDispatchThread = null;
	protected SimulationSession session;
	protected BlockingQueue<Runnable> taskQueue;
	protected BlockingQueue<IEvent> eventQueue;
	
	
	synchronized public void initializeEngine() throws SimulationException {
		if (engineState == EngineState.NEW) {
			validateSimulationParameters(simulationParameters);
			loadStatechartModel();
			validateStatechartModel();
			setUpStatechart();
			validateStatechart();
			
			taskQueue = new LinkedBlockingQueue<Runnable>();			
			eventQueue = new LinkedBlockingQueue<IEvent>();			
			session = new SimulationSession(this, statechart, taskQueue, eventQueue, getUUID(), getInstanceNumber());
			sesionThread = new Thread(session, getEngineName() + "-" + getInstanceNumber() + "-"+"Worker");
			sesionThread.start();
			
			eventDispatcher.setEventQueue(eventQueue);
			eventDispatchThread = new Thread(eventDispatcher, getEngineName() + "-" + getInstanceNumber() + "-"+"EventDispatcher");
			eventDispatchThread.start();
			
			engineState = EngineState.INITIALIZED;
		} 
	}

	
	synchronized public void disposeEngine() throws SimulationException {
		if (engineState == EngineState.INITIALIZED) {
			stopSimulation();
			tearDownStatechart();
			statechartModel=null;
			
			session.terminate();
			sesionThread = null;
			eventDispatcher.terminate();
			eventDispatchThread = null;
			engineState = EngineState.DISPOSED;
		}
	}
	
	
	public EngineState getEngineState() {
		return engineState;
	}


	
	//=========================================================================
	// Managing the statechart 
	//
	
	protected statemachine.Statechart statechartModel; 
	protected Statechart statechart;
	//TODO synchronize variable value map acess here?
	
	public statemachine.Statechart getStatechart() {
		return statechartModel;
	}


	public String getUUID() {
		return (statechartModel != null) 
			? statechartModel.getUUID()
			: "";
	}


	public String getSystemName() {
		return (statechartModel != null) 
			? statechartModel.getName()
			: "";
	}

	protected void loadStatechartModel() throws SimulationException {

		// Initialize the simulator
		String path = simulationParameters.getSimulationSystem().getAbsolutePath();
		if (path.endsWith("_diagram")){
			path = path.substring(0,path.length()-"_diagram".length());
		}
		
		try {
			// Reading of the statechart file
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				Resource.Factory.Registry.DEFAULT_EXTENSION,
				new XMIResourceFactoryImpl());
			final ResourceSet resourceSet = new ResourceSetImpl();
			// The file extension is: "statemachine"
			resourceSet.getPackageRegistry().put(
				"statemachine",
				statemachine.StatemachinePackage.eINSTANCE);
			final URI fileURI = URI.createURI("file:///" + path);

			final Resource resource = resourceSet.getResource(fileURI, true);
			statechartModel = (statemachine.Statechart) resource.getContents().get(0);

		} catch (final Exception e) {
			throw new SimulationException(String.format(
				Messages.SCSimulator_unabletoparse,
				path), e);
		}
	}
	
	
	protected void validateStatechartModel() {
	}
	
	protected void setUpStatechart()  {
		StatechartBuilder builder = new StatechartBuilder();
		statechart = builder.build(statechartModel);
		
	}
	
	
	protected void tearDownStatechart()  {
		statechart.setListener(null);
		statechart = null;
	}

	
	protected void validateStatechart() {
	}
	
	
	//=========================================================================
	// Managing the simulation life cycle
	//
	



	public SimulationState getSimulationState() {
		if (engineState == EngineState.DISPOSED) return SimulationState.DISPOSED;
		
		return (session != null) ? session.getSimulationState() : null;
	}


	public void startSimulation() throws SimulationException {
			session.start();
	}

	/**
	 * TODO: why will resume be called before start ?!?!
	 */
	public void resumeSimulation() throws SimulationException {
		if (getSimulationState() == null) startSimulation();
		else if (getSimulationState() == SimulationState.PAUSED) session.resume();
	}

	
	/**
	 * TODO: won't be called from the environment on stop ...
	 * We currently stop on dispose ...
	 */
	public void stopSimulation() throws SimulationException {
		session.stop();		
	}
	
	
	public void pauseSimulation() throws SimulationException {
		session.pause();
	}

	public void singleStepForward() throws SimulationException {
		session.singleStepForward();
	}


	//=========================================================================
	// Handling the simulation properties
	//

	public List<statemachine.State> getActiveStates() {
		return session.getActiveStates();
	}

	public boolean sendActiveStates() {
		session.sendActiveStates();
		return true;
	}


	public Map<statemachine.Event, Boolean> getEvents() {
		return Collections.unmodifiableMap(session.getSignalEvents());
	}


	public Map<statemachine.Variable, Double> getVariables() {
		return Collections.unmodifiableMap(session.getVariables());
	}

	
	/**
	 * TODO: hier kommen sowohl Variablen-Werte als auch Events !!! Dreck-Hack !!
	 */
	public boolean setItem(String name, Double value) throws SimulationException {
		return session.setItem(name, value);
	}

	
	
	
	
	//=========================================================================
	// managing event listeners
	//
	
	/** We use an EventDispatcher for managing event listeners. */
	private ActiveEventDispatcher eventDispatcher = new ActiveEventDispatcher();

	
	public void addEventListener(IEventListener listener) {
		if (listener != null) {
				eventDispatcher.addEventListener(listener);
			}
	}

	public void removeEventListener(IEventListener listener) {
		if (listener != null) {
				eventDispatcher.removeEventListener(listener);
			}
	}


	/**
	 * No events are processed currently
	 */
	public void receiveEvent(IEvent event) {
	}



	//=========================================================================
	// 
	//
	


	public boolean fireEvent(String name) throws SimulationException {
		return false;
	}


	
}
