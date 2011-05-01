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

package org.eclipselabs.damos.simulation.engine;

import org.eclipse.core.runtime.CoreException;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.execution.engine.IComponentSignature;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModel;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModel;
import org.eclipselabs.mscript.computation.computationmodel.ComputationModel;
import org.eclipselabs.mscript.computation.computationmodel.util.ComputationModelUtil;
import org.eclipselabs.mscript.computation.engine.IOverflowMonitor;
import org.eclipselabs.mscript.computation.engine.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractComponentSimulationObject implements IComponentSimulationObject {

	private IComponentSimulationInfo info;
	
	private ComputationModel cachedComputationModel;
	
	private Object integratorData;
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.engine.IComponentSimulationObject#getInfo()
	 */
	public IComponentSimulationInfo getInfo() {
		return info;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.engine.IComponentSimulationObject#setInfo(org.eclipselabs.damos.simulation.engine.IComponentSimulationInfo)
	 */
	public void setInfo(IComponentSimulationInfo info) {
		this.info = info;
	}
		
	public void setInputValue(int inputIndex, int portIndex, IValue value) throws CoreException {
	}

	public IValue getOutputValue(int outputIndex, int portIndex) throws CoreException {
		return null;
	}

	public void initialize() throws CoreException {
	}
		
	public void computeOutputValues(double t) throws CoreException {
	}
	
	public void update() throws CoreException {
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.engine.IComponentSimulationObject#getStateVector()
	 */
	public double[] getStateVector() throws CoreException {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.engine.IComponentSimulationObject#computeDerivatives(double, double[])
	 */
	public void computeDerivatives(double t, double[] yDot) throws CoreException {
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.engine.IComponentSimulationObject#getIntegratorData()
	 */
	public Object getIntegratorData() {
		return integratorData;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.engine.IComponentSimulationObject#setIntegratorData(java.lang.Object)
	 */
	public void setIntegratorData(Object data) {
		this.integratorData = data;
	}
	
	protected Component getComponent() {
		return info.getComponent();
	}
	
	protected IComponentSignature getSignature() {
		return info.getComponentSignature();
	}

	protected final SimulationModel getSimulationModel() {
		return info.getSimulationModel();
	}
	
	protected final ExecutionModel getExecutionModel() {
		return getSimulationModel().getExecutionModel();
	}
	
	protected final ComputationModel getComputationModel() {
		if (cachedComputationModel == null) {
			cachedComputationModel = getExecutionModel().getComputationModel(getComponent().getOwningFragment());
			if (cachedComputationModel == null) {
				cachedComputationModel = ComputationModelUtil.constructDefaultComputationModel();
			}
		}
		return cachedComputationModel;
	}
	
	protected IOverflowMonitor getOverflowMonitor() {
		return info.getOverflowMonitor();
	}
	
}