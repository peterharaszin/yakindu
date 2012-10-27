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

package org.eclipse.damos.library.vi.ui.editparts;

import java.util.IllegalFormatException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.eclipse.damos.diagram.ui.editparts.RectangularBlockEditPart;
import org.eclipse.damos.diagram.ui.figures.StandardComponentLayout;
import org.eclipse.damos.dml.Block;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.library.vi.ui.figures.DisplayContentFigure;
import org.eclipse.damos.library.vi.util.DisplayConstants;
import org.eclipse.damos.mscript.IntegerType;
import org.eclipse.damos.mscript.interpreter.value.IBooleanValue;
import org.eclipse.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.mscript.interpreter.value.StringValue;
import org.eclipse.damos.simulation.ISimulationAgent;
import org.eclipse.damos.simulation.ISimulationListener;
import org.eclipse.damos.simulation.ISimulationTracePoint;
import org.eclipse.damos.simulation.SimulationEvent;
import org.eclipse.damos.simulation.SimulationManager;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;

/**
 * @author Andreas Unger
 *
 */
public class DisplayEditPart extends RectangularBlockEditPart {
	
	private DisplayContentFigure contentFigure;
	
	private volatile String cachedFormatString;
	
	private volatile ConsumerThread consumerThread;

	private ISimulationListener simulationListener = new ISimulationListener() {
		
		public void handleSimulationEvent(SimulationEvent event) {
			if (event.getKind() == SimulationEvent.START) {
				updateFormatString();
			} else if (event.getKind() == SimulationEvent.STEP || event.getKind() == SimulationEvent.ASYNCHRONOUS) {
				ISimulationAgent agent = event.getSimulation().getAgent((Component) resolveSemanticElement());
				if (agent != null) {
					ISimulationTracePoint[] tracePoints = agent.getTracePoints();
					IValue[] values = new IValue[tracePoints.length];
					for (int i = 0; i < tracePoints.length; ++i) {
						IValue value = tracePoints[i].getValue();
						if (value == null) {
							return;
						}
						values[i] = value;
					}
					if (consumerThread != null) {
						consumerThread.consume(values);
					}
				}
			}
		}
		
	};

	/**
	 * @param view
	 */
	public DisplayEditPart(View view) {
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
		contentFigure = new DisplayContentFigure();
		contentFigure.setText("<NO DATA>");
		figure.add(contentFigure);
		return figure;
	}
	
	private void setValues(IValue[] values) {
		if (cachedFormatString == null) {
			updateFormatString();
		}
		if (contentFigure != null) {
			Object[] args = new Object[values.length];
			for (int i = 0; i < values.length; ++i) {
				IValue value = values[i];
				if (value instanceof ISimpleNumericValue) {
					ISimpleNumericValue simpleNumericValue = (ISimpleNumericValue) value;
					if (value.getDataType() instanceof IntegerType) {
						args[i] = simpleNumericValue.longValue();
					} else {
						args[i] = simpleNumericValue.doubleValue();
					}
				} else if (value instanceof IBooleanValue) {
					args[i] = ((IBooleanValue) value).booleanValue();
				} else if (value instanceof StringValue) {
					args[i] = value.toString();
				} else {
					args[i] = "INVALID";
				}
			}
			String text;
			try {
				text = String.format(cachedFormatString, args);
			} catch (IllegalFormatException e) {
				text = "<FORMAT ERROR>";
			}
			contentFigure.setText(text);
		}
	}
	
	private void updateFormatString() {
		Block block = (Block) resolveSemanticElement();
		cachedFormatString = block.getArgumentStringValue(DisplayConstants.PARAMETER__FORMAT_STRING);
	}
	
	private class ConsumerThread extends Thread {
		
		private final BlockingQueue<IValue[]> queue = new ArrayBlockingQueue<IValue[]>(1);
		private volatile boolean canceled;
		
		public void consume(IValue[] values) {
			if (!queue.offer(values)) {
				queue.clear();
				queue.offer(values);
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
					final IValue[] values = queue.take();
					Display.getDefault().syncExec(new Runnable() {
						
						public void run() {
							if (isActive()) {
								setValues(values);
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
