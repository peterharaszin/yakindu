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

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.damos.diagram.ui.editparts.RectangularBlockEditPart;
import org.eclipse.damos.diagram.ui.figures.StandardComponentLayout;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.library.vi.ui.figures.SliderContentFigure;
import org.eclipse.damos.library.vi.ui.figures.SliderContentFigure.ISliderChangeListener;
import org.eclipse.damos.simulation.AbstractSimulationRunnable;
import org.eclipse.damos.simulation.ISimulation;
import org.eclipse.damos.simulation.ISimulationAgent;
import org.eclipse.damos.simulation.ISimulationVariationPoint;
import org.eclipse.damos.simulation.SimulationManager;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;

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
			Iterator<ISimulationAgent> it = getSimulation().getAgents(getComponentURIPath().lastSegment()).iterator();
			if (it.hasNext()) {
				ISimulationVariationPoint variationPoint = it.next().getVariationPoints()[0];
				variationPoint.setValue(position);
			}
		}

	}
	
}
