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

package org.eclipselabs.damos.library.base.simulation.ui.editparts.io;

import java.util.Collection;

import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipselabs.damos.diagram.ui.editparts.RectangularBlockEditPart;
import org.eclipselabs.damos.diagram.ui.figures.StandardComponentLayout;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.library.base.simulation.ui.figures.io.ButtonContentFigure;
import org.eclipselabs.damos.library.base.simulation.ui.figures.io.ButtonContentFigure.IButtonChangeListener;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.Values;
import org.eclipselabs.damos.simulation.core.AbstractSimulationRunnable;
import org.eclipselabs.damos.simulation.core.ISimulation;
import org.eclipselabs.damos.simulation.core.ISimulationAgent;
import org.eclipselabs.damos.simulation.core.ISimulationVariationPoint;
import org.eclipselabs.damos.simulation.core.SimulationManager;

/**
 * @author Andreas Unger
 *
 */
public class ButtonEditPart extends RectangularBlockEditPart {
	
	private IButtonChangeListener buttonChangeListener = new IButtonChangeListener() {
		
		public void buttonChanged(boolean pressed) {
			Collection<ISimulation> simulations = SimulationManager.getInstance().getRunningSimulations();
			if (!simulations.isEmpty()) {
				ISimulation simulation = simulations.iterator().next();
				simulation.execute(new ButtonRunnable(simulation, (Component) resolveSemanticElement(), pressed));
			}
		}
		
	};

	private ButtonContentFigure contentFigure;

	/**
	 * @param view
	 */
	public ButtonEditPart(View view) {
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
		layout.setHorizontalContentPadding(300);
		layout.setVerticalContentPadding(300);
		contentFigure = new ButtonContentFigure();
		contentFigure.addButtonChangeListener(buttonChangeListener);
		figure.add(contentFigure);
		return figure;
	}
	
	private static class ButtonRunnable extends AbstractSimulationRunnable {
		
		private boolean pressed;
		
		/**
		 * 
		 */
		public ButtonRunnable(ISimulation simulation, Component component, boolean pressed) {
			super(simulation, component);
			this.pressed = pressed;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		public void run() {
			ISimulationAgent agent = getSimulation().getAgent(getComponent());
			if (agent != null) {
				ISimulationVariationPoint variationPoint = agent.getVariationPoints()[0];
				IValue value = Values.valueOf(agent.getComputationContext(), pressed);
				variationPoint.setValue(value);
			}
		}

	}
	
}
