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

package org.eclipse.damos.library.base.simulation.ui.editparts;

import java.util.Collection;

import org.eclipse.damos.diagram.ui.editparts.RectangularBlockEditPart;
import org.eclipse.damos.diagram.ui.figures.StandardComponentLayout;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.library.base.simulation.ui.figures.ButtonContentFigure;
import org.eclipse.damos.library.base.simulation.ui.figures.ButtonContentFigure.IButtonChangeListener;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.mscript.interpreter.value.Values;
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
