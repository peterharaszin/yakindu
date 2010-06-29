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

package org.esmp.dsm.simulation.ui.internal.views;

import org.eclipse.birt.chart.factory.GeneratedChartState;
import org.eclipse.birt.chart.model.ChartWithAxes;
import org.eclipse.birt.chart.model.attribute.AxisType;
import org.eclipse.birt.chart.model.attribute.ColorDefinition;
import org.eclipse.birt.chart.model.attribute.LineAttributes;
import org.eclipse.birt.chart.model.attribute.LineStyle;
import org.eclipse.birt.chart.model.attribute.impl.ColorDefinitionImpl;
import org.eclipse.birt.chart.model.attribute.impl.LineAttributesImpl;
import org.eclipse.birt.chart.model.component.Axis;
import org.eclipse.birt.chart.model.component.Series;
import org.eclipse.birt.chart.model.component.impl.SeriesImpl;
import org.eclipse.birt.chart.model.data.SeriesDefinition;
import org.eclipse.birt.chart.model.data.impl.NumberDataSetImpl;
import org.eclipse.birt.chart.model.data.impl.SeriesDefinitionImpl;
import org.eclipse.birt.chart.model.impl.ChartWithAxesImpl;
import org.eclipse.birt.chart.model.type.LineSeries;
import org.eclipse.birt.chart.model.type.impl.LineSeriesImpl;
import org.esmp.dsm.simulation.IChartData;

/**
 * @author Andreas Unger
 *
 */
public class ChartContext {

	private ChartWithAxes chart;
	private GeneratedChartState state;
	private Series xSeries;
	private SeriesDefinition ySeriesDefinition;
	
	/**
	 * @return the chart
	 */
	public ChartWithAxes getChart() {
		return chart;
	}
	
	/**
	 * @return the state
	 */
	public GeneratedChartState getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(GeneratedChartState state) {
		this.state = state;
	}
	
	public void initializeChart() {
		chart = ChartWithAxesImpl.create();
		chart.getLegend().setVisible(false);
		
		Axis xAxis = chart.getPrimaryBaseAxes()[0];
		xAxis.setType(AxisType.LINEAR_LITERAL);
		xAxis.getTitle().setVisible(false);
		xAxis.getMajorGrid().setLineAttributes(createGridLineAttributes());

		Axis yAxis = chart.getPrimaryOrthogonalAxis(xAxis);
		yAxis.getTitle().setVisible(false);
		yAxis.getMajorGrid().setLineAttributes(createGridLineAttributes());
		
		xSeries = SeriesImpl.create();
		SeriesDefinition xSeriesDefinition = SeriesDefinitionImpl.create();
		xSeriesDefinition.getSeries().add(xSeries);
		xAxis.getSeriesDefinitions().add(xSeriesDefinition);

		ySeriesDefinition = SeriesDefinitionImpl.create();
		yAxis.getSeriesDefinitions().add(ySeriesDefinition);
	}
	
	public void setSimulationData(IChartData data) {
		chart.getTitle().getLabel().getCaption().setValue(data.getChartTitle());

		double[][] xValuesMatrix = data.getXValues();
		double[][] yValuesMatrix = data.getYValues();
		int m = yValuesMatrix.length;
		int n = yValuesMatrix[0].length;
		
		int increment = 1;
		while (n > 2000) {
			n >>= 1;
			increment <<= 1;
		}
		
		double[] xValues = new double[n];
		double[][] yValues = new double[m][n];
		
		for (int jj = 0, j = 0; jj < n; ++jj, j += increment) {
			xValues[jj] = xValuesMatrix[0][j];
			for (int i = 0; i < m; ++i) {
				yValues[i][jj] = yValuesMatrix[i][j];
			}
		}
		
		xSeries.setDataSet(NumberDataSetImpl.create(xValues));
		ySeriesDefinition.getSeries().clear();
		for (int i = 0; i < m; ++i) {
			LineSeries ySeries = (LineSeries) LineSeriesImpl.create();
			ySeries.setDataSet(NumberDataSetImpl.create(yValues[i]));
			ySeries.getMarkers().clear();
			ySeries.getLineAttributes().setColor(createSeriesLineColorDefinition(i));
			ySeriesDefinition.getSeries().add(ySeries);
		}
	}

	private LineAttributes createGridLineAttributes() {
		return LineAttributesImpl.create(
				ColorDefinitionImpl.create(220, 220, 220),
				LineStyle.DASHED_LITERAL,
				1);
	}

	private ColorDefinition createSeriesLineColorDefinition(int n) {
		ColorDefinition c = ColorDefinitionImpl.BLACK();
		switch (n % 4) {
		case 0:
			c = ColorDefinitionImpl.BLUE();
			break;
		case 1:
			c = ColorDefinitionImpl.RED();
			break;
		case 2:
			c = ColorDefinitionImpl.GREEN();
			break;
		case 3:
			c = ColorDefinitionImpl.create(255, 186, 0);
			break;
		}
		while (n > 3) {
			c = c.darker();
			n -= 4;
		}
		return c;
	}

}
