/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.simulation.ui.internal.parts;

import java.util.Collection;

import org.eclipse.damos.simulation.IXYChartData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.swtchart.Chart;
import org.swtchart.ILineSeries;
import org.swtchart.ILineSeries.PlotSymbolType;
import org.swtchart.ISeries.SeriesType;
import org.swtchart.ext.InteractiveChart;

/**
 * @author Andreas Unger
 *
 */
public class ChartCanvas extends Composite {

	private int singleChartIndex = -1;

	private boolean realtime;
	private long progress = -1;
	
	private boolean chartsAvailable; 
	private Label messageLabel;

	public ChartCanvas(Composite parent, int style) {
		super(parent, style);
		setBackground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
		updateCanvas();
	}
	
	/**
	 * @param realtime the real-time to set
	 */
	public void setRealtime(boolean realtime) {
		this.realtime = realtime;
	}
	
	/**
	 * @param progress the progress to set
	 */
	public void setProgress(long progress) {
		if (this.progress != progress) {
			this.progress = progress;
			updateCanvas();
		}
	}
		
	public void setSingleChartIndex(int index) {
		if (singleChartIndex != index) {
			singleChartIndex = index;
			updateCanvas();
		}
	}

	public void setDataset(Collection<IXYChartData> dataset) {
		progress = -1;
		disposeChildren();
		chartsAvailable = !dataset.isEmpty();
		updateCanvas();
		
		for (IXYChartData data : dataset) {
			Chart chart = new InteractiveChart(this, SWT.NONE);
			chart.getTitle().setText(data.getChartTitle());
			chart.getLegend().setVisible(false);
			chart.getAxisSet().getXAxis(0).getTitle().setVisible(false);
			chart.getAxisSet().getYAxis(0).getTitle().setVisible(false);
			chart.setBackground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
			
			double[] xValues = data.getXValues();
			double[][] yValues = data.getYValues();
			
			for (int i = 0; i < yValues.length; ++i) {
				ILineSeries lineSeries = (ILineSeries) chart.getSeriesSet().createSeries(SeriesType.LINE, "Series " + (i + 1));
				lineSeries.setLineColor(getLineColor(i));
				lineSeries.setSymbolType(PlotSymbolType.NONE);
				lineSeries.setXSeries(xValues);
				lineSeries.setYSeries(yValues[i]);
			}
		}

		// Adjust range *after* we added all charts
		for (Control control : getChildren()) {
			if (control instanceof Chart) {
				((Chart) control).getAxisSet().adjustRange();
			}
		}
	}
	
	private Color getLineColor(int index) {
		switch (index) {
		case 0:
			return getDisplay().getSystemColor(SWT.COLOR_BLUE);
		case 1:
			return getDisplay().getSystemColor(SWT.COLOR_RED);
		case 2:
			return getDisplay().getSystemColor(SWT.COLOR_GREEN);
		case 3:
			return getDisplay().getSystemColor(SWT.COLOR_MAGENTA);
		case 4:
			return getDisplay().getSystemColor(SWT.COLOR_DARK_YELLOW);
		case 5:
			return getDisplay().getSystemColor(SWT.COLOR_DARK_CYAN);
		case 6:
			return getDisplay().getSystemColor(SWT.COLOR_DARK_BLUE);
		case 7:
			return getDisplay().getSystemColor(SWT.COLOR_DARK_RED);
		case 8:
			return getDisplay().getSystemColor(SWT.COLOR_DARK_GREEN);
		}
		return getDisplay().getSystemColor(SWT.COLOR_BLACK);
	}
	
	private void updateCanvas() {
		String message = null;
		if (progress >= 0) {
			message = String.format("Simulating... %d%s", progress, realtime ? "s" : "%");
		} else if (chartsAvailable) {
			if (singleChartIndex < 0 || singleChartIndex >= getChildren().length) {
				setLayout(new TileLayout(2));
			} else {
				StackLayout layout = new StackLayout();
				layout.topControl = getChildren()[singleChartIndex];
				setLayout(layout);
			}
		} else {
			message = "No chart data available.";
		}
		
		if (message != null) {
			setMessage(message);
		}

		layout();
	}

	/**
	 * @param message
	 */
	private void setMessage(String message) {
		if (messageLabel == null) {
			disposeChildren();
			setLayout(new GridLayout());
			messageLabel = new Label(this, SWT.NONE);
			messageLabel.setBackground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
			messageLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
		}
		messageLabel.setText(message);
	}

	/**
	 * 
	 */
	private void disposeChildren() {
		for (Control control : getChildren()) {
			control.dispose();
		}
		messageLabel = null;
		chartsAvailable = false;
	}

}
