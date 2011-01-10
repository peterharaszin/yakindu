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
import org.eclipselabs.mscript.computation.engine.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractComponentSimulationObject implements IComponentSimulationObject {

	private ISimulationContext context;
	private Component component;
	private IComponentSignature signature;
		
	public ISimulationContext getContext() {
		return context;
	}
	
	public void setContext(ISimulationContext context) {
		this.context = context;
	}

	public Component getComponent() {
		return component;
	}
	
	public void setComponent(Component component) {
		this.component = component;
	}
	
	public IComponentSignature getSignature() {
		return signature;
	}
	
	public void setSignature(IComponentSignature signature) {
		this.signature = signature;
	}
	
	public void initialize() throws CoreException {
	}
	
	public void reset() throws CoreException {
	}
	
	public void setInputValue(int inputIndex, int portIndex, IValue value) throws CoreException {
	}
	
	public void computeOutputValues() throws CoreException {
	}

	public IValue getOutputValue(int outputIndex, int portIndex) throws CoreException {
		return null;
	}
	
	public void update() throws CoreException {
	}
	
	protected final SimulationModel getSimulationModel() {
		return getContext().getSimulationModel();
	}
	
	protected final ExecutionModel getExecutionModel() {
		return getSimulationModel().getExecutionModel();
	}
	
	protected final ComputationModel getComputationModel() {
		return getExecutionModel().getComputationModel();
	}
	
}