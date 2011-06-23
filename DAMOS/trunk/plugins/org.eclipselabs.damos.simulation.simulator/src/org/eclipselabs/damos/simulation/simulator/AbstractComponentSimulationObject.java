/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.simulation.simulator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.execution.engine.IComponentSignature;
import org.eclipselabs.damos.execution.executionflow.ComponentNode;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModel;
import org.eclipselabs.damos.simulation.core.ISimulationAgent;
import org.eclipselabs.damos.simulation.core.ISimulationMonitor;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModel;
import org.eclipselabs.mscript.computation.computationmodel.ComputationModel;
import org.eclipselabs.mscript.computation.computationmodel.util.ComputationModelUtil;
import org.eclipselabs.mscript.computation.core.ComputationContext;
import org.eclipselabs.mscript.computation.core.IComputationContext;
import org.eclipselabs.mscript.computation.core.IOverflowMonitor;
import org.eclipselabs.mscript.computation.core.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractComponentSimulationObject implements IComponentSimulationObject {

	private ISimulationObjectContext context;
	
	private ISimulationAgent agent;
	
	private ComputationModel cachedComputationModel;
	
	private IComputationContext computationContext;
	
	/**
	 * @return the agent
	 */
	public ISimulationAgent getAgent() {
		if (agent == null) {
			agent = createAgent();
		}
		return agent;
	}
	
	protected ISimulationAgent createAgent() {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.IComponentSimulationObject#getClock()
	 */
	public ISimulationClock getClock() {
		return null;
	}
	
	public void setInputValue(int inputIndex, int portIndex, IValue value) {
	}

	public IValue getOutputValue(int outputIndex, int portIndex) {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.IComponentSimulationObject#initialize(org.eclipselabs.damos.simulation.simulator.ISimulationObjectContext, org.eclipselabs.damos.simulation.simulator.ISimulationMonitor)
	 */
	public void initialize(ISimulationObjectContext context, IProgressMonitor monitor) throws CoreException {
		this.context = context;
		initialize(monitor);
	}

	public void initialize(IProgressMonitor monitor) throws CoreException {
	}
		
	public void computeOutputValues(double t, ISimulationMonitor monitor) throws CoreException {
	}

	public void update(double t) {
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.IComponentSimulationObject#stop()
	 */
	public boolean stop() {
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.IComponentSimulationObject#getStateVector()
	 */
	public double[] getStateVector() {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.IComponentSimulationObject#computeDerivatives(double, double[])
	 */
	public void computeDerivatives(double t, double[] y, double[] yDot) {
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.IComponentSimulationObject#getZeroCrossingTime(double)
	 */
	public double computeZeroCrossingTime(double t) {
		return Double.NaN;
	}
	
	public double[] getZeroCrossingValues() {
		return null;
	}
	
	public void updateZeroCrossingValues(double t) {
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.IComponentSimulationObject#dispose()
	 */
	public void dispose() {
	}
	
	protected Component getComponent() {
		return context.getNode().getComponent();
	}
	
	protected final IComponentSignature getSignature() {
		return context.getComponentSignature();
	}

	protected final SimulationModel getSimulationModel() {
		return context.getSimulationModel();
	}
	
	protected final ExecutionModel getExecutionModel() {
		return getSimulationModel().getExecutionModel();
	}
	
	protected final IComputationContext getComputationContext() {
		if (computationContext == null) {
			computationContext = new ComputationContext(getComputationModel(), getOverflowMonitor());
		}
		return computationContext;
	}

	private final ComputationModel getComputationModel() {
		if (cachedComputationModel == null) {
			cachedComputationModel = getExecutionModel().getComputationModel(getComponent().getOwningFragment());
			if (cachedComputationModel == null) {
				cachedComputationModel = ComputationModelUtil.constructDefaultComputationModel();
			}
		}
		return cachedComputationModel;
	}
	
	private IOverflowMonitor getOverflowMonitor() {
		return context.getOverflowMonitor();
	}
	
	protected IComponentSignature getComponentSignature() {
		return context.getComponentSignature();
	}
	
	protected ComponentNode getNode() {
		return context.getNode();
	}
	
}