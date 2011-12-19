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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.execution.core.util.ExpressionUtil;
import org.eclipselabs.damos.library.base.util.sinks.CommonScopeConstants;
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
abstract class AbstractScopeSimulationObject extends AbstractBlockSimulationObject {

	private int portCount;

	private String title;
	
	private int j;

	private double[] xValues;
	private double[][] yValues;
	
	private int limit = 20000;
	
	private boolean full;
	
	@Override
	public void initialize(IProgressMonitor monitor) throws CoreException {
		if (getComponent().getArgument(CommonScopeConstants.PARAMETER__DATA_POINT_LIMIT) != null) { // Check for backward-compatibility
			ISimpleNumericValue limitValue = ExpressionUtil.evaluateIntegerArgument(getComponent(), CommonScopeConstants.PARAMETER__DATA_POINT_LIMIT);
			if (limitValue.longValue() > 0 && limitValue.longValue() < Integer.MAX_VALUE) {
				limit = (int) limitValue.longValue();
			}
		}
		
		portCount = getComponent().getPrimaryInputPorts().size();

		title = getComponent().getName();
		j = 0;

		xValues = new double[limit];
		yValues = new double[portCount][limit];
	}
	
	@Override
	public final void setInputValue(int inputIndex, int portIndex, IValue value) {
		double doubleValue = 0;
		if (value instanceof ISimpleNumericValue) {
			doubleValue = ((ISimpleNumericValue) value).doubleValue();
		} else if (value instanceof IBooleanValue) {
			doubleValue = ((IBooleanValue) value).booleanValue() ? 1.0 : 0.0;
		}
		setInputValue(inputIndex, portIndex, doubleValue);
	}
	
	protected abstract void setInputValue(int inputIndex, int portIndex, double value);
	
	@Override
	public void update(double t) {
		if (j == limit) {
			j = 0;
			full = true;
		}
		xValues[j] = getXValue(t);
		for (int i = 0; i < portCount; ++i) {
			yValues[i][j] = getYValue(t, i);
		}
		++j;
	}
	
	protected abstract double getXValue(double t);
	protected abstract double getYValue(double t, int index);
	
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
			double[] resultXValues;
			double[][] resultYValues;
		
			public String getChartTitle() {
				return title;
			}
		
			public String getXAxisTitle() {
				return "";
			}
		
			public double[] getXValues() {
				if (resultXValues == null) {
					int firstPartLength = full ? limit - j : 0;
					resultXValues = new double[firstPartLength + j];
					if (firstPartLength > 0) {
						System.arraycopy(xValues, j, resultXValues, 0, firstPartLength);
					}
					System.arraycopy(xValues, 0, resultXValues, firstPartLength, j);
				}
				return resultXValues;
			}
		
			public String[] getYAxisTitles() {
				return new String[portCount];
			}
		
			public double[][] getYValues() {
				if (resultYValues == null) {
					int firstPartLength = full ? limit - j : 0;
					resultYValues = new double[portCount][firstPartLength + j];
					if (firstPartLength > 0) {
						for (int i = 0; i < portCount; ++i) {
							System.arraycopy(yValues[i], j, resultYValues[i], 0, firstPartLength);
						}
					}
					for (int i = 0; i < portCount; ++i) {
						System.arraycopy(yValues[i], 0, resultYValues[i], firstPartLength, j);
					}
				}
				return resultYValues;
			}
			
		}
		
	}

}
