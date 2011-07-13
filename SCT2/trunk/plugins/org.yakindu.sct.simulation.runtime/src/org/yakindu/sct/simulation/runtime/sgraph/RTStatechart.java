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
package org.yakindu.sct.simulation.runtime.sgraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.yakindu.sct.simulation.runtime.ExecutionScope;
import org.yakindu.sct.simulation.runtime.sgraph.AbstractStatechart;
import org.yakindu.sct.simulation.runtime.sgraph.RTCompoundState;
import org.yakindu.sct.simulation.runtime.sgraph.RTEvent;
import org.yakindu.sct.simulation.runtime.sgraph.RTNode;
import org.yakindu.sct.simulation.runtime.sgraph.RTRegion;
import org.yakindu.sct.simulation.runtime.sgraph.RTSignalEvent;
import org.yakindu.sct.simulation.runtime.sgraph.RTState;
import org.yakindu.sct.simulation.runtime.sgraph.RTTimingService;
import org.yakindu.sct.simulation.runtime.sgraph.RTTransition;
import org.yakindu.sct.simulation.runtime.stext.Variable;


public class RTStatechart extends AbstractStatechart implements ExecutionScope {


	protected Map<Object, Object> aliasToElementMap = new HashMap<Object, Object>();
	protected Map<Object, Object> elementToAliasMap = new HashMap<Object, Object>();

	protected List<RTSignalEvent> events = new ArrayList<RTSignalEvent>(); 
	protected Map<String, RTSignalEvent> eventMap = new HashMap<String, RTSignalEvent>();

	protected List<Variable> variables = new ArrayList<Variable>(); 
	protected Map<String, Variable> variableMap = new HashMap<String, Variable>();
		
	protected Set<RTState> currentStateConfigurartion = new HashSet<RTState>();
	
	protected StatechartListener listener;
	
	
	public RTStatechart(String id) {
		super(id);
	}

	public RTStatechart(String id, RTTimingService timingService) {
		super(id, timingService);
	}

	
	public RTTimingService getTimingService() {
		return timingService;
	}
	
	public void setTimingService(RTTimingService ts) {
		timingService = ts;
	}
	
	
	public StatechartListener getListener() {
		return listener;
	}

	public void setListener(StatechartListener listener) {
		this.listener = listener;
	}

	/**
	 * Adds a signal event definition to the interface of the statechart. 
	 * only those events, that are registered should be used during operation.
	 *  
	 * @param event
	 */
	public void addSignalEvent(RTSignalEvent event) {
		events.add(event);
		eventMap.put(event.getId(), event);
	}
	
	/**
	 * Gets a signal event by its id.
	 * 
	 * @param id
	 * @return the signal event
	 */
	public RTSignalEvent getSignalEvent(String id) {
		return eventMap.get(id);
	}
	
	public Set<RTEvent> getRaisedEvents() {
		return Collections.unmodifiableSet(raisedEvents);
	}

	/**
	 * @return The list of all defined signal events of this statechart.
	 */
	public List<RTSignalEvent> getSignalEvents() {
		return Collections.unmodifiableList(events);
	}
	
	
	public void addVariable(Variable var) {
		variables.add(var);
		variableMap.put(var.getName(), var);
	}

	
	public Object getValue(String varName) {
		Variable var = getVariable(varName);
		return (var != null) ? var.getValue() : null ;		
	}

	
	public Variable getVariable(String varName) {
		return variableMap.get(varName);
	}
	
	public List<Variable>  getVariables() {
		return Collections.unmodifiableList(variables);
	}

	
	protected void stateLeft(RTState state) {
		currentStateConfigurartion.remove(state);
		if (listener != null) listener.stateLeft(state);
	}
	
	protected void stateEntered(RTState state) {
		currentStateConfigurartion.add(state);
		if (listener != null) listener.stateEntered(state);
	}
	
	protected void transitionFired(RTTransition trans) {
		if (listener != null) listener.transitionFired(trans);
	}
	
	public Set<RTState> getCurrentStateConfiguration() {
		return Collections.unmodifiableSet(currentStateConfigurartion);
	}
	
	
	public void raise(String signal) {
		setEvent(eventMap.get(signal));
	}

	public void reset(String signal) {
		raisedEvents.remove(eventMap.get(signal));
	}

	
	public void call(String procedureId) {
		// TODO Auto-generated method stub		
	}

	
	/**
	 * If a node is registered with a key then it can be accessed by the key using this method.
	 * Before a node can be accessed this way it must be registered using {@link #registerNode}. 
	 * @param alias
	 * @return the node object that is registered for the given key.
	 */
	public Object getElementByAlias(Object alias) {
		return aliasToElementMap.get(alias);
	}
	
	/**
	 * If a node is registered with a key then it can be accessed by the key using this method.
	 * Before a node can be accessed this way it must be registered using {@link #registerNode}. 
	 * @param element
	 * @return the node object that is registered for the given key.
	 */
	public Object getAliasByElement(Object element) {
		return elementToAliasMap.get(element);
	}
	
	/**
	 * Nodes can optionally be regitered with a key for later lookup.
	 * 
	 * @param key the key object
	 * @param element the node
	 */
	public void defineAlias(Object alias, Object element) {
		aliasToElementMap.put(alias, element);
		elementToAliasMap.put(element, alias);
	}

	
	public List<RTRegion> getAllRegions() {
		List<RTRegion> allRegions = new ArrayList<RTRegion>();
		
		allRegions.addAll(getRegions());
		for (RTRegion region : getRegions()) {
			addAllRegions(allRegions, region);
		}

		
		return allRegions;
	}

	
	protected void addAllRegions(List<RTRegion> regions, RTRegion region) {
		for (RTNode node : region.getNodes()) {
			if (node instanceof RTCompoundState) addAllRegions(regions, (RTCompoundState) node);
		}
	}
	
	protected void addAllRegions(List<RTRegion> regions, RTCompoundState cState) {
		regions.addAll(cState.getRegions());
		
		for (RTRegion region : cState.getRegions()) {
			addAllRegions(regions, region);
		}
	}
	
	
}
