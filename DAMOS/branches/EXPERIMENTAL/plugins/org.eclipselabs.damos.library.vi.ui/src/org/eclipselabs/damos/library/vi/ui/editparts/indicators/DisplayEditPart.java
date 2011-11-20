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

import java.util.IllegalFormatException;

import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipselabs.damos.diagram.ui.editparts.RectangularBlockEditPart;
import org.eclipselabs.damos.diagram.ui.figures.StandardComponentLayout;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.library.vi.ui.figures.indicators.DisplayContentFigure;
import org.eclipselabs.damos.library.vi.util.indicators.DisplayConstants;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.interpreter.value.IBooleanValue;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.simulation.core.ISimulationAgent;
import org.eclipselabs.damos.simulation.core.ISimulationListener;
import org.eclipselabs.damos.simulation.core.ISimulationTracePoint;
import org.eclipselabs.damos.simulation.core.SimulationEvent;
import org.eclipselabs.damos.simulation.core.SimulationManager;

/**
 * @author Andreas Unger
 *
 */
public class DisplayEditPart extends RectangularBlockEditPart {
	
	private DisplayContentFigure contentFigure;
	
	private volatile String cachedFormatString;
	
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
					Display.getDefault().asyncExec(new SetValuesRunnable(values));
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
		SimulationManager.getInstance().addSimulationListener(simulationListener);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#deactivate()
	 */
	@Override
	public void deactivate() {
		SimulationManager.getInstance().removeSimulationListener(simulationListener);
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
	
	private class SetValuesRunnable implements Runnable {
		
		private volatile IValue[] values;
		
		/**
		 * 
		 */
		public SetValuesRunnable(IValue[] values) {
			this.values = values;
		}
		
		public void run() {
			if (isActive()) {
				setValues(values);
			}
		}

	}

}
