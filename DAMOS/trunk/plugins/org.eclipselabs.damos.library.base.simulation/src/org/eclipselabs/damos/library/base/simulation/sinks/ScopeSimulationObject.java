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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.mscript.interpreter.value.IBooleanValue;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.simulation.core.AbstractSimulationAgent;
import org.eclipselabs.damos.simulation.core.ISimulationAgent;
import org.eclipselabs.damos.simulation.core.IXYChartData;
import org.eclipselabs.damos.simulation.core.IXYChartDataProvider;
import org.eclipselabs.damos.simulation.simulator.AbstractBlockSimulationObject;

/**
 * @author Andreas Unger
 *
 */
public class ScopeSimulationObject extends AbstractBlockSimulationObject {

	private int portCount;

	private String title;
	
	private int j;

	double[] inputValues;
	
	private double[] xValues;
	private double[][] yValues;
	
	private int limit = 20000;
	
	@Override
	public void initialize(IProgressMonitor monitor) {
		portCount = getComponent().getPrimaryInputPorts().size();

		title = getComponent().getName();
		j = 0;

		inputValues = new double[portCount];
		xValues = new double[limit];
		yValues = new double[portCount][limit];
	}
	
	@Override
	public void setInputValue(int inputIndex, int portIndex, IValue value) {
		double y = 0;
		if (value instanceof ISimpleNumericValue) {
			y = ((ISimpleNumericValue) value).doubleValue();
		} else if (value instanceof IBooleanValue) {
			y = ((IBooleanValue) value).booleanValue() ? 1.0 : 0.0;
		}
		inputValues[portIndex] = y;
	}
	
	@Override
	public void update(double t) {
		if (j < limit) {
			xValues[j] = t;
			for (int i = 0; i < portCount; ++i) {
				yValues[i][j] = inputValues[i];
			}
			++j;
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject#createAgent()
	 */
	@Override
	protected ISimulationAgent createAgent() {
		return new Agent(getComponent());
	}
	
	private class Agent extends AbstractSimulationAgent implements IXYChartDataProvider {
		
		/**
		 * @param component
		 */
		public Agent(Component component) {
			super(component);
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.simulation.simulator.IXYChartDataProvider#getXYChartData()
		 */
		public IXYChartData getXYChartData() {
			return new XYChartData();
		}

		/**
		 * @author Andreas Unger
		 *
		 */
		private final class XYChartData implements IXYChartData {
			double[] truncatedXValues;
			double[][] truncatedYValues;
		
			public String getChartTitle() {
				return title;
			}
		
			public String getXAxisTitle() {
				return "Time [s]";
			}
		
			public double[] getXValues() {
				if (truncatedXValues == null) {
					truncatedXValues = new double[j];
					System.arraycopy(xValues, 0, truncatedXValues, 0, j);
				}
				return truncatedXValues;
			}
		
			public String[] getYAxisTitles() {
				return new String[] { "Magnitude" };
			}
		
			public double[][] getYValues() {
				if (truncatedYValues == null) {
					truncatedYValues = new double[portCount][j];
					for (int i = 0; i < portCount; ++i) {
						System.arraycopy(yValues[i], 0, truncatedYValues[i], 0, j);
					}
				}
				return truncatedYValues;
			}
			
		}
		
	}

}
