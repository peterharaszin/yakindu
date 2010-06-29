/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.esmp.dsm.simulation.internal;

import org.esmp.dsm.simulation.OverflowMonitor;
import org.esmp.dsm.simulation.SimulationContext;

/**
 * @author Andreas Unger
 *
 */
public class SimulationContextImpl implements SimulationContext {

	private long samplingFrequency;
	private double simulationTime;
	
	private OverflowMonitor overflowMonitor = new OverflowMonitorImpl();
	
	/**
	 * @return the samplingFrequency
	 */
	public long getSamplingFrequency() {
		return samplingFrequency;
	}
	
	/**
	 * @param samplingFrequency the samplingFrequency to set
	 */
	public void setSamplingFrequency(long samplingFrequency) {
		this.samplingFrequency = samplingFrequency;
	}
	
	/**
	 * @return the simulationTime
	 */
	public double getSimulationTime() {
		return simulationTime;
	}
	
	/**
	 * @param simulationTime the simulationTime to set
	 */
	public void setSimulationTime(double simulationTime) {
		this.simulationTime = simulationTime;
	}
	
	public long getSampleCount() {
		return (long) Math.ceil(samplingFrequency * simulationTime) + 1;
	}
	
	/**
	 * @return the overflowMonitor
	 */
	public OverflowMonitor getOverflowMonitor() {
		return overflowMonitor;
	}
	
	/**
	 * @param overflowMonitor the overflowMonitor to set
	 */
	public void setOverflowMonitor(OverflowMonitor overflowMonitor) {
		this.overflowMonitor = overflowMonitor;
	}

}
