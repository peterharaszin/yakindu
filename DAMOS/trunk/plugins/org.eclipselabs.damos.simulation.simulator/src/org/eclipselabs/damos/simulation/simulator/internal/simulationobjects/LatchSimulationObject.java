/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.simulation.simulator.internal.simulationobjects;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.dml.Latch;
import org.eclipselabs.damos.dmltext.MscriptValueSpecification;
import org.eclipselabs.damos.execution.executionflow.LatchNode;
import org.eclipselabs.damos.execution.executionflow.TaskGraph;
import org.eclipselabs.damos.execution.util.ExpressionUtil;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject;
import org.eclipselabs.damos.simulation.simulator.internal.SimulatorPlugin;
import org.eclipselabs.damos.simulation.simulator.internal.Task;

/**
 * @author Andreas Unger
 *
 */
public class LatchSimulationObject extends AbstractSimulationObject {

	private volatile IValue value;
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject#initialize(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void initialize(IProgressMonitor monitor) throws CoreException {
		Latch latch = (Latch) getComponent();
		if (latch.getInitialValue() == null) {
			throw new CoreException(new Status(IStatus.ERROR, SimulatorPlugin.PLUGIN_ID, "No initial value set"));
		}
		if (!(latch.getInitialValue() instanceof MscriptValueSpecification)) {
			throw new CoreException(new Status(IStatus.ERROR, SimulatorPlugin.PLUGIN_ID, "Invalid initial value"));
		}
		value = ExpressionUtil.evaluateExpression(((MscriptValueSpecification) latch.getInitialValue()).getExpression());
	}
	
	@Override
	public void setInputValue(int inputIndex, int portIndex, IValue value) {
		this.value = value;
		for (TaskGraph taskGraph : getNode().getTaskNodes()) {
			if (taskGraph.getInputNodes().isEmpty()) {
				Task task = (Task) EcoreUtil.getAdapter(taskGraph.eAdapters(), Task.class);
				if (task != null) {
					task.newLatchValueAvailable();
				}
			}
		}
	}
	
	@Override
	public IValue getOutputValue(int outputIndex, int portIndex) {
		return value;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject#getNode()
	 */
	@Override
	protected LatchNode getNode() {
		return (LatchNode) super.getNode();
	}
	
}
