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

package org.eclipselabs.damos.library.vi.ui.editparts.indicators;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipselabs.damos.diagram.ui.editparts.RectangularBlockEditPart;
import org.eclipselabs.damos.diagram.ui.figures.StandardComponentLayout;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.library.vi.ui.figures.indicators.GaugeContentFigure;
import org.eclipselabs.damos.library.vi.util.indicators.GaugeConstants;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.simulation.ISimulationAgent;
import org.eclipselabs.damos.simulation.ISimulationListener;
import org.eclipselabs.damos.simulation.ISimulationTracePoint;
import org.eclipselabs.damos.simulation.SimulationEvent;
import org.eclipselabs.damos.simulation.SimulationManager;

/**
 * @author Andreas Unger
 *
 */
public class GaugeEditPart extends RectangularBlockEditPart {
	
	private GaugeContentFigure contentFigure;
	
	private volatile double cachedScaleOffset = Double.NaN;
	private volatile double cachedScaleLength = Double.NaN;
	
	private volatile ConsumerThread consumerThread;
	
	private ISimulationListener simulationListener = new ISimulationListener() {
		
		public void handleSimulationEvent(SimulationEvent event) {
			if (event.getKind() == SimulationEvent.START) {
				updateScaleParameters();
			} else if (event.getKind() == SimulationEvent.STEP || event.getKind() == SimulationEvent.ASYNCHRONOUS) {
				ISimulationAgent agent = event.getSimulation().getAgent((Component) resolveSemanticElement());
				if (agent != null) {
					ISimulationTracePoint tracePoint = agent.getTracePoints()[0];
					IValue value = tracePoint.getValue();
					if (value != null && consumerThread != null) {
						consumerThread.consume(value);
					}
				}
			}
		}
		
	};

	/**
	 * @param view
	 */
	public GaugeEditPart(View view) {
		super(view);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#activate()
	 */
	@Override
	public void activate() {
		super.activate();
		if (consumerThread != null) {
			consumerThread.cancel();
		}
		consumerThread = new ConsumerThread();
		consumerThread.start();
		SimulationManager.getInstance().addSimulationListener(simulationListener);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#deactivate()
	 */
	@Override
	public void deactivate() {
		SimulationManager.getInstance().removeSimulationListener(simulationListener);
		if (consumerThread != null) {
			consumerThread.cancel();
			consumerThread = null;
		}
		super.deactivate();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart#createMainFigure()
	 */
	protected NodeFigure createMainFigure() {
		NodeFigure figure = super.createMainFigure();
		StandardComponentLayout layout = (StandardComponentLayout) figure.getLayoutManager();
		layout.setHorizontalContentAlignment(SWT.FILL);
		layout.setVerticalContentAlignment(SWT.FILL);
		contentFigure = new GaugeContentFigure();
		figure.add(contentFigure);
		return figure;
	}
	
	private void setValue(IValue value) {
		if (Double.isNaN(cachedScaleOffset)) {
			updateScaleParameters();
		}
		if (contentFigure != null) {
			ISimpleNumericValue numericValue = (ISimpleNumericValue) value;
			final double newValue = (numericValue.doubleValue() - cachedScaleOffset) / (cachedScaleLength);
			contentFigure.setValue(newValue);
		}
	}
	
	private void updateScaleParameters() {
		Block block = (Block) resolveSemanticElement();
		cachedScaleOffset = Double.parseDouble(block.getArgumentStringValue(GaugeConstants.PARAMETER__SCALE_MINIMUM));
		cachedScaleLength = Double.parseDouble(block.getArgumentStringValue(GaugeConstants.PARAMETER__SCALE_MAXIMUM)) - cachedScaleOffset;
	}
	
	private class ConsumerThread extends Thread {
		
		private final BlockingQueue<IValue> queue = new ArrayBlockingQueue<IValue>(1);
		private volatile boolean canceled;
		
		public void consume(IValue value) {
			if (!queue.offer(value)) {
				queue.clear();
				queue.offer(value);
			}
		}
		
		public void cancel() {
			canceled = true;
			interrupt();
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Thread#run()
		 */
		@Override
		public void run() {
			try {
				while (!canceled) {
					final IValue value = queue.take();
					Display.getDefault().syncExec(new Runnable() {
						
						public void run() {
							if (isActive()) {
								setValue(value);
							}
						}
						
					});
				}
			} catch (InterruptedException e) {
				interrupt();
			}
		}
		
	}

}
