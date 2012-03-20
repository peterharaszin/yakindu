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
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.execution.datatype.IComponentSignature;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;
import org.eclipselabs.damos.mscript.computationmodel.util.ComputationModelUtil;
import org.eclipselabs.damos.mscript.interpreter.ComputationContext;
import org.eclipselabs.damos.mscript.interpreter.IComputationContext;
import org.eclipselabs.damos.mscript.interpreter.IOverflowMonitor;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.simulation.ISimulationAgent;
import org.eclipselabs.damos.simulation.ISimulationMonitor;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractSimulationObject implements ISimulationObject {

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
	 * @see org.eclipselabs.damos.simulation.simulator.ISimulationObject#getClock()
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
	 * @see org.eclipselabs.damos.simulation.simulator.ISimulationObject#initialize(org.eclipselabs.damos.simulation.simulator.ISimulationObjectContext, org.eclipselabs.damos.simulation.simulator.ISimulationMonitor)
	 */
	public void initialize(ISimulationObjectContext context, IProgressMonitor monitor) throws CoreException {
		this.context = context;
		initialize(monitor);
	}

	public void initialize(IProgressMonitor monitor) throws CoreException {
	}
		
	public void computeOutputValues(double t, ISimulationMonitor monitor) throws CoreException {
	}

	public void update(double t) throws CoreException {
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.ISimulationObject#stop()
	 */
	public boolean stop() {
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.ISimulationObject#getStateVector()
	 */
	public double[] getStateVector() {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.ISimulationObject#computeDerivatives(double, double[])
	 */
	public void computeDerivatives(double t, double[] y, double[] yDot) {
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.ISimulationObject#getZeroCrossingTime(double)
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
	 * @see org.eclipselabs.damos.simulation.simulator.ISimulationObject#dispose()
	 */
	public void dispose() {
	}
	
	protected Component getComponent() {
		return context.getNode().getComponent();
	}
	
	protected final Configuration getConfiguration() {
		return context.getConfiguration();
	}
	
	protected final IComputationContext getComputationContext() {
		if (computationContext == null) {
			computationContext = new ComputationContext(getComputationModel(), getOverflowMonitor());
		}
		return computationContext;
	}

	private final ComputationModel getComputationModel() {
		if (cachedComputationModel == null) {
			cachedComputationModel = getConfiguration().getComputationModel(getNode().getSystemPath());
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