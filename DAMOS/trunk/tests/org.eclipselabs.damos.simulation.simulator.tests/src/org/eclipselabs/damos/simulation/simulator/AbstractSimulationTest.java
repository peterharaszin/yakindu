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

package org.eclipselabs.damos.simulation.simulator;

import static junit.framework.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipselabs.damos.dconfig.SelectionProperty;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.execution.test.AbstractExecutionTest;
import org.eclipselabs.damos.simulation.ISimulation;
import org.eclipselabs.damos.simulation.ISimulationAgent;
import org.eclipselabs.damos.simulation.IXYChartData;
import org.eclipselabs.damos.simulation.IXYChartDataProvider;

/**
 * @author Andreas Unger
 *
 */
public class AbstractSimulationTest extends AbstractExecutionTest {

	protected static final String STEP = "damos.library.base.sources.Step";
	protected static final String TRANSFER_FUNCTION = "damos.library.base.continuous.TransferFunction";
	protected static final String SCOPE = "damos.library.base.sinks.Scope";

	private static final Pattern COMMA_PATTERN = Pattern.compile(",");
	
	@Override
	protected void createConfiguration() {
		super.createConfiguration();
		SelectionProperty solverSelection = createSelectionProperty("damos.simulation.solver", "damos.simulation.solvers.DormandPrince54");
		configuration.getProperties().add(solverSelection);
		configuration.getProperties().add(createSimpleProperty("damos.simulation.simulationTime", getSimulationTime()));
	}
	
	protected ISimulation simulate() {
		try {
			Simulator simulator = new Simulator();
			simulator.initialize(configuration, new NullProgressMonitor());
			simulator.getSimulationEngine().run();
			return simulator.getSimulationEngine().getSimulation();
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
	}
	
	protected String getSimulationTime() {
		return "10(s)";
	}
	
	protected IXYChartData getChartData(ISimulation simulation, Component component) {
		for (ISimulationAgent agent : simulation.getAgents()) {
			if (agent instanceof IXYChartDataProvider && agent.getComponent() == component) {
				return ((IXYChartDataProvider) agent).getXYChartData();
			}
		}
		return null;
	}
	
	protected void compareChartData(ISimulation simulation, Component component, String dataFileName, double delta) {
		IXYChartData chartData = getChartData(simulation, component);
		if (chartData == null) {
			throw new RuntimeException("No chart data found for component " + component.getName());
		}
		
		double[] xValues = chartData.getXValues();
		double[] yValues = chartData.getYValues()[0];
		
		try {
			InputStream is = FileLocator.openStream(SimulatorTestsPlugin.getDefault().getBundle(), new Path("data/" + dataFileName + ".csv"), false);
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			
			int i = 0;
			
			double pt = Double.NaN;
			double py = Double.NaN;
			
			double[] data = new double[2];

			int comparisonCount = 0;
			while (readChartDataLine(reader, data)) { 
				if (!Double.isNaN(pt)) {
					boolean proceed;
					do {
						proceed = false;
						while (xValues[i] > data[0]) {
							if (!readChartDataLine(reader, data)) {
								proceed = false;
								break;
							}
							proceed = true;
						}
						while (xValues[i] < pt) {
							if (i == xValues.length - 1) {
								proceed = false;
								break;
							}
							++i;
							proceed = true;
						}
					} while (proceed);
					
					if (!Double.isNaN(data[0])) {
						double m = (data[1] - py) / (data[0] - pt);
						double y = py + m * (xValues[i] - pt);
						assertEquals(y, yValues[i], delta);
						++comparisonCount;
					}
					
					++i;
					if (i == xValues.length) {
						break;
					}
				}
				
				pt = data[0];
				py = data[1];
			}
			
			int minimumComparisonCount = xValues.length / 4;
			if (comparisonCount < minimumComparisonCount) {
				throw new RuntimeException("Number of comparisons must be at least " + minimumComparisonCount);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private boolean readChartDataLine(BufferedReader reader, double[] data) throws IOException {
		String line = reader.readLine();
		if (line == null) {
			data[0] = Double.NaN;
			data[1] = Double.NaN;
			return false;
		}
		
		String[] split = COMMA_PATTERN.split(line);
		if (split.length != 2) {
			throw new RuntimeException("Invalid CSV file");
		}
		
		data[0] = Double.parseDouble(split[0]);
		data[1] = Double.parseDouble(split[1]);
		
		return true;
	}
	
}
