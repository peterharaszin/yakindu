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

package org.esmp.dsm.library.sinks.simulation;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.esmp.dsm.semantic.blockdiagram.InputPort;
import org.esmp.dsm.semantic.blockdiagram.util.BlockDiagramUtil;
import org.esmp.dsm.simulation.AbstractSimulationModel;
import org.esmp.dsm.simulation.IChartData;
import org.esmp.dsm.simulation.Value;

/**
 * @author Andreas Unger
 *
 */
public class ScopeSimulationModel extends AbstractSimulationModel implements IAdaptable {

	private String title;

	private long samplingFrequency;
	private int n;
	private int[] positions;
	
	private double[][] xValues;
	private double[][] yValues;

	public void initialize() {
		int portCount = getBlock().getInputs().get(0).getPorts().size();

		title = getBlock().getName();
		samplingFrequency = getContext().getSamplingFrequency();
		n = (int) getContext().getSampleCount();
		positions = new int[portCount];

		xValues = new double[1][n];
		yValues = new double[portCount][n];
	}
	
	public void consumeInputValue(InputPort inputPort, Value value) {
		int inputPortIndex = BlockDiagramUtil.getIndex(inputPort);
		int j = positions[inputPortIndex];
		xValues[0][j] = (double) j / samplingFrequency;
		yValues[inputPortIndex][j] = value.toDouble();
		positions[inputPortIndex] += 1;
	}
	
	@SuppressWarnings("unchecked")
	public Object getAdapter(Class adapter) {
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
