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

package org.eclipselabs.damos.library.vi.ui.editparts.controls;

import java.util.Collection;

import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipselabs.damos.diagram.ui.editparts.RectangularBlockEditPart;
import org.eclipselabs.damos.diagram.ui.figures.StandardComponentLayout;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.library.vi.ui.figures.controls.SliderContentFigure;
import org.eclipselabs.damos.library.vi.ui.figures.controls.SliderContentFigure.ISliderChangeListener;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.Values;
import org.eclipselabs.damos.simulation.AbstractSimulationRunnable;
import org.eclipselabs.damos.simulation.ISimulation;
import org.eclipselabs.damos.simulation.ISimulationAgent;
import org.eclipselabs.damos.simulation.ISimulationVariationPoint;
import org.eclipselabs.damos.simulation.SimulationManager;

/**
 * @author Andreas Unger
 *
 */
public class SliderEditPart extends RectangularBlockEditPart {
	
	private ISliderChangeListener sliderChangeListener = new ISliderChangeListener() {
		
		public void positionChanged() {
			if (contentFigure != null) {
				double position = contentFigure.getPosition();
				Collection<ISimulation> simulations = SimulationManager.getInstance().getRunningSimulations();
				if (!simulations.isEmpty()) {
					ISimulation simulation = simulations.iterator().next();
					simulation.execute(new SliderRunnable(simulation, (Component) resolveSemanticElement(), position));
				}
			}
		}
		
	};

	private SliderContentFigure contentFigure;

	/**
	 * @param view
	 */
	public SliderEditPart(View view) {
		super(view);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart#createMainFigure()
	 */
	protected NodeFigure createMainFigure() {
		NodeFigure figure = super.createMainFigure();
		StandardComponentLayout layout = (StandardComponentLayout) figure.getLayoutManager();
		layout.setHorizontalContentAlignment(SWT.FILL);
		layout.setVerticalContentAlignment(SWT.FILL);
		contentFigure = new SliderContentFigure();
		contentFigure.addSliderChangeListener(sliderChangeListener);
		figure.add(contentFigure);
		return figure;
	}
	
	private static class SliderRunnable extends AbstractSimulationRunnable {
		
		private double position;
		
		/**
		 * 
		 */
		public SliderRunnable(ISimulation simulation, Component component, double position) {
			super(simulation, component);
			this.position = position;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		public void run() {
			ISimulationAgent agent = getSimulation().getAgent(getComponent());
			if (agent != null) {
				ISimulationVariationPoint variationPoint = agent.getVariationPoints()[0];
				IValue value = Values.valueOf(agent.getComputationContext(), (NumericType) variationPoint.getDataType(), position);
				variationPoint.setValue(value);
			}
		}

	}
	
}
