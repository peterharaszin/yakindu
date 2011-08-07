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
import org.eclipselabs.damos.simulation.core.ISimulationAgent;
import org.eclipselabs.damos.simulation.core.ISimulationListener;
import org.eclipselabs.damos.simulation.core.ISimulationTracePoint;
import org.eclipselabs.damos.simulation.core.SimulationEvent;
import org.eclipselabs.damos.simulation.core.SimulationManager;
import org.eclipselabs.mscript.computation.core.value.ISimpleNumericValue;
import org.eclipselabs.mscript.computation.core.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class GaugeEditPart extends RectangularBlockEditPart {
	
	private GaugeContentFigure contentFigure;
	
	private volatile double cachedScaleOffset = Double.NaN;
	private volatile double cachedScaleLength = Double.NaN;
	
	private volatile IValue value;
	
	private final Runnable setValueRunnable = new Runnable() {
		
		public void run() {
			if (isActive()) {
				setValue(value);
			}
		}
		
	};
	
	private ISimulationListener simulationListener = new ISimulationListener() {
		
		public void handleSimulationEvent(SimulationEvent event) {
			if (event.getKind() == SimulationEvent.START) {
				updateScaleParameters();
			} else if (event.getKind() == SimulationEvent.STEP || event.getKind() == SimulationEvent.ASYNCHRONOUS) {
				ISimulationAgent agent = event.getSimulation().getAgent((Component) resolveSemanticElement());
				if (agent != null) {
					ISimulationTracePoint tracePoint = agent.getTracePoints()[0];
					value = tracePoint.getValue();
					Display.getDefault().asyncExec(setValueRunnable);
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

}
