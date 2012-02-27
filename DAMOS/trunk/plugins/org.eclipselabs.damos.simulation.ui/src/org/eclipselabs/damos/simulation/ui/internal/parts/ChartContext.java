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

package org.eclipselabs.damos.simulation.ui.internal.parts;

import org.eclipse.birt.chart.factory.GeneratedChartState;
import org.eclipse.birt.chart.model.ChartWithAxes;
import org.eclipse.birt.chart.model.attribute.AxisType;
import org.eclipse.birt.chart.model.attribute.ColorDefinition;
import org.eclipse.birt.chart.model.attribute.FormatSpecifier;
import org.eclipse.birt.chart.model.attribute.LineAttributes;
import org.eclipse.birt.chart.model.attribute.LineStyle;
import org.eclipse.birt.chart.model.attribute.impl.ColorDefinitionImpl;
import org.eclipse.birt.chart.model.attribute.impl.JavaNumberFormatSpecifierImpl;
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
import org.eclipselabs.damos.simulation.IXYChartData;

/**
 * @author Andreas Unger
 *
 */
public class ChartContext {

	private static final int MAX_POINT_COUNT = 2000;
	private static final double MAX_SLOPE = 0.5;

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
	
	public void setChartData(IXYChartData data) {
		chart.getTitle().getLabel().getCaption().setValue(data.getChartTitle());

		double[] xValues = data.getXValues();
		double[][] yValues = data.getYValues();
		int m = yValues.length;
		
		int length = reduceDataSet(xValues, yValues, xValues.length / MAX_POINT_COUNT);
		double[] reducedXValues = new double[length];
		double[][] reducedYValues = new double[m][length];
		System.arraycopy(xValues, 0, reducedXValues, 0, length);
		for (int i = 0; i < m; ++i) {
			System.arraycopy(yValues[i], 0, reducedYValues[i], 0, length);
		}
		
		Axis xAxis = chart.getPrimaryBaseAxes()[0];
		xAxis.setFormatSpecifier(createNumberFormatSpecifier(reducedXValues));

		Axis yAxis = chart.getPrimaryOrthogonalAxis(xAxis);
		yAxis.setFormatSpecifier(createNumberFormatSpecifier(reducedYValues));
		
		xSeries.setDataSet(NumberDataSetImpl.create(reducedXValues));
		ySeriesDefinition.getSeries().clear();
		for (int i = 0; i < m; ++i) {
			LineSeries ySeries = (LineSeries) LineSeriesImpl.create();
			ySeries.setDataSet(NumberDataSetImpl.create(reducedYValues[i]));
			ySeries.getMarkers().clear();
			ySeries.getLineAttributes().setColor(createSeriesLineColorDefinition(i));
			ySeriesDefinition.getSeries().add(ySeries);
		}
	}
	
	private int reduceDataSet(double[] xValues, double[][] yValuesMatrix, int maxSkip) {
		if (maxSkip == 0 || xValues.length < 2) {
			return xValues.length;
		}
		
		int lastIndex = xValues.length - 1;
		int counter = maxSkip;
		int end = 1;
		
		double der = Double.POSITIVE_INFINITY;
		
		for (int j = 1; j < lastIndex; ++j) {
			double nextDer = 0;
			double dx = xValues[j + 1] - xValues[j];
			for (int i = 0; i < yValuesMatrix.length; ++i) {
				double dy = yValuesMatrix[i][j + 1] - yValuesMatrix[i][j];
				double currentDer = Math.abs(dy / dx);
				if (nextDer < currentDer) {
					nextDer = currentDer;
				}
			}
			
			if (counter-- == 0 || Math.abs((nextDer - der) / dx) > MAX_SLOPE) {
				appendValues(xValues, yValuesMatrix, j, end++);
				counter = maxSkip;
			}
			
			der = nextDer;
		}
		
		appendValues(xValues, yValuesMatrix, lastIndex, end++);
		
		return end;
	}

	/**
	 * @param xValues
	 * @param yValuesMatrix
	 * @param index
	 * @param end
	 */
	private void appendValues(double[] xValues, double[][] yValuesMatrix, int index, int end) {
		xValues[end] = xValues[index];
		for (int i = 0; i < yValuesMatrix.length; ++i) {
			yValuesMatrix[i][end] = yValuesMatrix[i][index];
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
	
	private FormatSpecifier createNumberFormatSpecifier(double[] values) {
		return createNumberFormatSpecifier(requiresExponentNumberFormatFor(values));
	}

	private FormatSpecifier createNumberFormatSpecifier(double[][] values) {
		for (int i = 0; i < values.length; ++i) {
			if (requiresExponentNumberFormatFor(values[i])) {
				return createNumberFormatSpecifier(true);
			}
		}
		return createNumberFormatSpecifier(false);
	}
	
	private FormatSpecifier createNumberFormatSpecifier(boolean exponentNumberFormat) {
		if (exponentNumberFormat) {
			return JavaNumberFormatSpecifierImpl.create("0.####E0");
		}
		return JavaNumberFormatSpecifierImpl.create("0.########");
	}

	private boolean requiresExponentNumberFormatFor(double[] values) {
		for (int i = 0; i < values.length; ++i) {
			if (Math.abs(values[i]) >= 100000.0) {
				return true;
			}
		}
		return false;
	}

}
