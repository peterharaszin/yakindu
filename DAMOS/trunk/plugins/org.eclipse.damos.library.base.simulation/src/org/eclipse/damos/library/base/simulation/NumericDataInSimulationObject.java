package org.eclipse.damos.library.base.simulation;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.simulation.ISimulationMonitor;
import org.eclipse.damos.simulation.simulator.AbstractSimulationObject;

/**
 * @author Andreas Unger
 *
 */
public class NumericDataInSimulationObject extends AbstractSimulationObject {

	private IValue value;
	
	@Override
	public void setInputValue(int inputIndex, int portIndex, IValue value) {
		this.value = value;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.simulation.simulator.AbstractSimulationObject#computeOutputValues(double, org.eclipse.damos.simulation.ISimulationMonitor)
	 */
	@Override
	public void computeOutputValues(double t, ISimulationMonitor monitor) throws CoreException {
		if (value == null) {
			throw new CoreException(new Status(IStatus.ERROR, LibraryBaseSimulationPlugin.PLUGIN_ID, "Missing input value for component '" + getComponent().getName() + "'"));
		}
	}
	
	@Override
	public IValue getOutputValue(int outputIndex, int portIndex) {
		return value;
	}
	
}
