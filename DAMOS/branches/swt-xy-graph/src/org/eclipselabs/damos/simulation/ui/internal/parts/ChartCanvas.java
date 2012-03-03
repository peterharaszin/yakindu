/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.simulation.ui.internal.parts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.csstudio.swt.xygraph.Preferences;
import org.csstudio.swt.xygraph.dataprovider.CircularBufferDataProvider;
import org.csstudio.swt.xygraph.dataprovider.IDataProvider;
import org.csstudio.swt.xygraph.figures.Axis;
import org.csstudio.swt.xygraph.figures.ToolbarArmedXYGraph;
import org.csstudio.swt.xygraph.figures.Trace;
import org.csstudio.swt.xygraph.figures.XYGraph;
import org.csstudio.swt.xygraph.util.SWTConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipselabs.damos.simulation.IXYChartData;

/**
 * @author Andreas Unger
 *
 */
public class ChartCanvas extends Canvas implements PaintListener {

//	private IDeviceRenderer renderer;
//	private Image cachedImage;
//	private List<ChartContext> chartContexts = new ArrayList<ChartContext>();
	private int singleChartIndex = -1;

	private boolean realtime;
	private long progress = -1;

	private Figure pane;
	
	public ChartCanvas(Composite parent, int style) {
		super(parent, style);
		
		setBackground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
		
		LightweightSystem lws = new LightweightSystem(this);
		pane = new Figure();
		pane.setLayoutManager(new TileLayout(2));
		lws.setContents(pane);

//		try {
//			PluginSettings ps = PluginSettings.instance();
//			renderer = ps.getDevice("dv.SWT");
//		} catch (ChartException e) {
//			logChartError(e);
//		}
//		
//		addControlListener(new ControlAdapter() {
//			
//			public void controlResized(ControlEvent e) {
//				if (cachedImage != null) {
//					cachedImage.dispose();
//					cachedImage = null;
//				}
//			}
//			
//		});
//		addPaintListener(this);
		
	}
	
	public void clear() {
//		chartContexts.clear();
		redraw();
	}
	
	/**
	 * @param realtime the realtime to set
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
//			redraw();
		}
	}
		
	public void setDataset(Collection<IXYChartData> dataset) {
		pane.removeAll();
		
		for (IXYChartData data : dataset) {
			XYGraph xyGraph = new XYGraph();
			xyGraph.setTitle(data.getChartTitle());
			xyGraph.primaryXAxis.setShowMajorGrid(true);
			xyGraph.primaryXAxis.setAutoScale(true);
			xyGraph.primaryXAxis.setTitle(data.getXAxisTitle());
			xyGraph.primaryYAxis.setShowMajorGrid(true);
			xyGraph.primaryYAxis.setAutoScale(true);
			xyGraph.primaryYAxis.setTitle("");
			xyGraph.setShowLegend(false);
	
			double[] xValues = data.getXValues();
			double[][] yValues = data.getYValues();
			
			for (int i = 0; i < yValues.length; ++i) {
				CircularBufferDataProvider traceDataProvider = new CircularBufferDataProvider(false);
				traceDataProvider.setBufferSize(xValues.length);
				traceDataProvider.setCurrentXDataArray(xValues);
				traceDataProvider.setCurrentYDataArray(yValues[i]);
				Trace trace = new MyTrace("Input " + (i + 1), xyGraph.primaryXAxis, xyGraph.primaryYAxis, traceDataProvider);
				xyGraph.addTrace(trace);
			}
			
			xyGraph.performAutoScale();
			pane.add(new ToolbarArmedXYGraph(xyGraph));
		}
		
		updateSingletonIndex();

//		getDisplay().asyncExec(new Runnable() {
//			
//			public void run() {
//				if (!getDisplay().isDisposed()) {
//					for (Object o : pane.getChildren()) {
//						if (o instanceof ToolbarArmedXYGraph) {
//							((ToolbarArmedXYGraph) o).getXYGraph().performAutoScale();
//						}
//					}
//				}
//			}
//			
//		});

//		chartContexts.clear();
//		for (IXYChartData data : dataset) {
//			ChartContext context = new ChartContext();
//			context.initializeChart();
//			context.setChartData(data);
//			chartContexts.add(context);
//		}
//		if (cachedImage != null) {
//			cachedImage.dispose();
//			cachedImage = null;
//		}
//		redraw();
	}
	
	public void setSingleChartIndex(int index) {
		if (singleChartIndex != index) {
			singleChartIndex = index;
			updateSingletonIndex();
//			if (chartContexts.size() > 1) {
//				if (cachedImage != null) {
//					cachedImage.dispose();
//					cachedImage = null;
//				}
//				redraw();
//			}
		}
	}
	
	private void updateSingletonIndex() {
		((TileLayout) pane.getLayoutManager()).setContextFigure(singleChartIndex);
		pane.revalidate();
		pane.repaint();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.swt.events.PaintListener#paintControl(org.eclipse.swt.events.PaintEvent)
	 */
	public void paintControl(PaintEvent e) {
//		Composite composite = (Composite) e.getSource();
//		Rectangle size = composite.getClientArea();
//
//		String message = null;
//		
//		if (progress >= 0) {
//			message = String.format("Simulating... %d%s", progress, realtime ? "s" : "%");
//		} else if (!chartContexts.isEmpty()) {
//			if (cachedImage == null) {
//				buildChart(e.gc);
//				drawToCachedImage(size);
//			}
//			e.gc.drawImage(
//					cachedImage,
//					0, 0, cachedImage.getBounds().width, cachedImage.getBounds().height,
//					0, 0, size.width, size.height);
//		} else {
//			message = "No simulation data available.";
//		}
//		
//		if (message != null) {
//			Point extent = e.gc.stringExtent(message);
//			e.gc.drawText(message, (size.width - extent.x) / 2, (size.height - extent.y) / 2);
//		}
	}

//	private void buildChart(GC gc) {
//		Point size = getSize();
//		double scale = 72.0 / renderer.getDisplayServer().getDpiResolution();
//		renderer.setProperty(IDeviceRenderer.GRAPHICS_CONTEXT, gc);
//		if (singleChartIndex < 0) {
//			size.y /= chartContexts.size();
//			for (int i = 0; i < chartContexts.size(); ++i) {
//				Bounds bounds = BoundsImpl.create(0, i * size.y, size.x, size.y);
//				bounds.scale(scale);
//				buildChart(i, bounds);
//			}
//		} else {
//			Bounds bounds = BoundsImpl.create(0, 0, size.x, size.y);
//			bounds.scale(scale);
//			buildChart(singleChartIndex, bounds);
//		}
//	}
	
//	private void buildChart(int index, Bounds bounds) {
//		try {
//			chartContexts.get(index).setState(Generator.instance().build(
//					renderer.getDisplayServer(),
//					chartContexts.get(index).getChart(),
//					bounds, null, null, null));
//		} catch (ChartException e) {
//			logChartError(e);
//		}
//	}
//
//	private void drawToCachedImage(Rectangle size) {
//		GC gc = null;
//		try {
//			if (cachedImage != null) {
//				cachedImage.dispose();
//			}
//			cachedImage = new Image(getDisplay(), size);
//
//			gc = new GC(cachedImage);
//			renderer.setProperty(IDeviceRenderer.GRAPHICS_CONTEXT, gc);
//
//			if (singleChartIndex < 0) {
//				for (int i = 0; i < chartContexts.size(); ++i) {
//					Generator.instance().render(renderer, chartContexts.get(i).getState());
//				}
//			} else {
//				Generator.instance().render(renderer, chartContexts.get(singleChartIndex).getState());
//			}
//		} catch (ChartException e) {
//			logChartError(e);
//		} finally {
//			if (gc != null) {
//				gc.dispose();
//			}
//		}
//	}
		
//	private void logChartError(Exception e) {
//		SimulationUIPlugin.getDefault().getLog().log(
//				new Status(IStatus.ERROR, SimulationUIPlugin.PLUGIN_ID,
//						"Chart error", e));
//	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Widget#dispose()
	 */
	public void dispose() {
//		if (cachedImage != null) {
//			cachedImage.dispose();
//		}
		super.dispose();
	}
	
	private static class MyTrace extends Trace {

		private List<PointList> pointLists;
		private Point previousPoint;
		
		final private static boolean use_advanced_graphics = Preferences.useAdvancedGraphics();
		
		/**
		 * @param name
		 * @param xAxis
		 * @param yAxis
		 * @param dataProvider
		 */
		public MyTrace(String name, Axis xAxis, Axis yAxis, IDataProvider dataProvider) {
			super(name, xAxis, yAxis, dataProvider);
		}
		
		/* (non-Javadoc)
		 * @see org.csstudio.swt.xygraph.figures.Trace#paintFigure(org.eclipse.draw2d.Graphics)
		 */
		@Override
		protected void paintFigure(Graphics graphics) {
//			points.removeAllPoints();
			pointLists = new ArrayList<PointList>();
			super.paintFigure(graphics);
			
//			if (use_advanced_graphics) {
//				graphics.setAntialias(isAntiAliasing()? SWT.ON : SWT.OFF);
//			}
			graphics.setForegroundColor(getTraceColor());
			graphics.setLineWidth(getLineWidth());
			
			switch (getTraceType()) {
			case SOLID_LINE:
				graphics.setLineStyle(SWTConstants.LINE_SOLID);
				for (PointList points : pointLists) {
					graphics.drawPolyline(points);
				}
				break;
			case DASH_LINE:
				graphics.setLineStyle(SWTConstants.LINE_DASH);
				for (PointList points : pointLists) {
					graphics.drawPolyline(points);
				}
				break;
			}
			
			pointLists = null;
			previousPoint = null;
		}
		
		/* (non-Javadoc)
		 * @see org.csstudio.swt.xygraph.figures.Trace#drawLine(org.eclipse.draw2d.Graphics, org.eclipse.draw2d.geometry.Point, org.eclipse.draw2d.geometry.Point)
		 */
		@Override
		public void drawLine(Graphics graphics, Point p1, Point p2) {
			if (!p1.equals(previousPoint)) {
				PointList points = new PointList();
				pointLists.add(points);
				points.addPoint(p1);
			}
			pointLists.get(pointLists.size() - 1).addPoint(p2);
			previousPoint = p2;
		}
		
	}
		
}
