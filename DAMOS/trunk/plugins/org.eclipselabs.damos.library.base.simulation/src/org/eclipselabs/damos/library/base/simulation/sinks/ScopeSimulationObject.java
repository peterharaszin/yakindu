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

package org.eclipselabs.damos.library.base.simulation.sinks;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.util.DMLUtil;
import org.eclipselabs.damos.simulation.engine.AbstractBlockSimulationObject;
import org.eclipselabs.damos.simulation.engine.IChartData;
import org.eclipselabs.damos.simulation.engine.util.SimulationUtil;
import org.eclipselabs.mscript.computation.engine.value.ISimpleNumericValue;
import org.eclipselabs.mscript.computation.engine.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class ScopeSimulationObject extends AbstractBlockSimulationObject implements IAdaptable {

	private String title;

	private double sampleTime;
	private int n;
	private int[] positions;
	
	private double[][] xValues;
	private double[][] yValues;

	public void initialize() {
		int portCount = getComponent().getPrimaryInputPorts().size();

		title = getComponent().getName();
		sampleTime = getContext().getSimulationModel().getExecutionModel().getSampleTime();
		n = (int) SimulationUtil.getSampleCount(getContext().getSimulationModel());
		positions = new int[portCount];

		xValues = new double[1][n];
		yValues = new double[portCount][n];
	}
	
	public void consumeInputValue(InputPort inputPort, IValue value) {
		int inputPortIndex = DMLUtil.indexOf(inputPort);
		int j = positions[inputPortIndex];
		double y = 0;
		if (value instanceof ISimpleNumericValue) {
			y = ((ISimpleNumericValue) value).doubleValue();
		}
		xValues[0][j] = j * sampleTime;
		yValues[inputPortIndex][j] = y;
		positions[inputPortIndex] += 1;
	}
	
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if (adapter == IChartData.class) {
			return new IChartData() {
				
				public String getChartTitle() {
					return title;
				}

				public double[][] getXValues() {
					return xValues;
				}
								
				public String getXAxisTitle() {
					return "Time [s]";
				}

				public double[][] getYValues() {
					return yValues;
				}
								
				public String getYAxisTitle() {
					return "Magnitude";
				}

			};
		}
		return Platform.getAdapterManager().getAdapter(this, adapter);
	}

}
