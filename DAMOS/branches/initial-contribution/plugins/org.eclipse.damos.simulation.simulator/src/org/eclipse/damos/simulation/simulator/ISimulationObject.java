/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.simulation.simulator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.simulation.ISimulationAgent;
import org.eclipse.damos.simulation.ISimulationMonitor;

/**
 * @author Andreas Unger
 *
 * @noextend
 * @noimplement This interface is <em>not</em> intended to be implemented by
 * clients. Clients should extend {@link AbstractSimulationObject}.
 */
public interface ISimulationObject {

	void initialize(ISimulationObjectContext context, IProgressMonitor monitor) throws CoreException;
	
	void setInputValue(int inputIndex, int portIndex, IValue value);

	void computeOutputValues(double t, ISimulationMonitor monitor) throws CoreException;

	IValue getOutputValue(int outputIndex, int portIndex);
	
	void update(double t) throws CoreException;
	
	boolean stop();
	
	ISimulationClock getClock();
	
	ISimulationAgent getAgent();

	double[] getStateVector();
	
	void computeDerivatives(double t, double[] y, double[] yDot);
	
	double computeZeroCrossingTime(double t);

	double[] getZeroCrossingValues();
	
	void updateZeroCrossingValues(double t);

	void dispose();

}
