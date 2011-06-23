/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

/*
 * This class is derivative works (i.e. modified version) of the
 * org.apache.commons.math.ode.nonstiff.AdaptiveStepsizeIntegrator class,
 * which is licensed under the following terms. The original source code can
 * be found at http://commons.apache.org/math/.
 */

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.eclipselabs.damos.simulation.engine.solver;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.execution.executionflow.ComponentNode;
import org.eclipselabs.damos.execution.executionflow.Graph;
import org.eclipselabs.damos.execution.executionflow.Node;
import org.eclipselabs.damos.simulation.core.ISimulationMonitor;
import org.eclipselabs.damos.simulation.engine.IComponentSimulationObject;
import org.eclipselabs.damos.simulation.engine.internal.ISimulationContext;
import org.eclipselabs.damos.simulation.engine.util.SimulationUtil;
import org.eclipselabs.damos.simulation.simulationmodel.AdaptiveStepSizeSolverConfiguration;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModel;

public abstract class AdaptiveStepSizeSolver extends AbstractSolver {

	protected List<DiscreteStepTracker> discreteStepTrackers = new ArrayList<DiscreteStepTracker>();

	/** Allowed absolute scalar error. */
	protected double absoluteTolerance;

	/** Allowed relative scalar error. */
	protected double relativeTolerance;

	/** User supplied initial step. */
	private double initialStepSize;

	/** Minimal step. */
	private double minimumStepSize;

	/** Maximal step. */
	private double maximumStepSize;

	public void configure(SimulationModel simulationModel) {
		AdaptiveStepSizeSolverConfiguration adaptiveStepSizeSolverConfiguration = (AdaptiveStepSizeSolverConfiguration) simulationModel.getSolverConfiguration();
		
		minimumStepSize = adaptiveStepSizeSolverConfiguration.getMinimumStepSize();
		
		if (adaptiveStepSizeSolverConfiguration.isSetMaximumStepSize()) {
			maximumStepSize = adaptiveStepSizeSolverConfiguration.getMaximumStepSize();
		} else {
			if (simulationModel.isSetSimulationTime() && simulationModel.getSimulationTime() > 0) {
				maximumStepSize = simulationModel.getSimulationTime() / 100;
			} else {
				maximumStepSize = 0.04; // 25 Hz
			}
		}
		
		if (adaptiveStepSizeSolverConfiguration.isSetInitialStepSize()) {
			initialStepSize = adaptiveStepSizeSolverConfiguration.getInitialStepSize();
		} else {
			initialStepSize = -1;
		}
		
		absoluteTolerance = adaptiveStepSizeSolverConfiguration.getAbsoluteTolerance();
		relativeTolerance = adaptiveStepSizeSolverConfiguration.getRelativeTolerance();
	}

	/**
	 * Initialize the integration step.
	 * 
	 * @param equations
	 *            differential equations set
	 * @param forward
	 *            forward integration indicator
	 * @param order
	 *            order of the method
	 * @param scale
	 *            scaling vector for the state vector (can be shorter than state
	 *            vector)
	 * @param t0
	 *            start time
	 * @param y0
	 *            state vector at t0
	 * @param yDot0
	 *            first time derivative of y0
	 * @param y1
	 *            work array for a state vector
	 * @param yDot1
	 *            work array for the first time derivative of y1
	 * @return first integration step
	 * @throws CoreException 
	 */
	public double initializeStep(AbstractIntegrationData data, final int order, final double[] scale, final double t0,
			final double[] y0, final double[] yDot0, final double[] y1, final double[] yDot1)
			throws CoreException {
		if (initialStepSize > 0) {
			// use the user provided value
			return initialStepSize;
		}

		// very rough first guess : h = 0.01 * ||y/scale|| / ||y'/scale||
		// this guess will be used to perform an Euler step
		double ratio;
		double yOnScale2 = 0;
		double yDotOnScale2 = 0;
		for (int j = 0; j < scale.length; ++j) {
			ratio = y0[j] / scale[j];
			yOnScale2 += ratio * ratio;
			ratio = yDot0[j] / scale[j];
			yDotOnScale2 += ratio * ratio;
		}

		double h = ((yOnScale2 < 1.0e-10) || (yDotOnScale2 < 1.0e-10)) ? 1.0e-6 : (0.01 * Math.sqrt(yOnScale2
				/ yDotOnScale2));

		// perform an Euler step using the preceding rough guess
		for (int j = 0; j < y0.length; ++j) {
			y1[j] = y0[j] + h * yDot0[j];
		}
		data.simulationObject.computeDerivatives(t0 + h, y1, yDot1);

		// estimate the second derivative of the solution
		double yDDotOnScale = 0;
		for (int j = 0; j < scale.length; ++j) {
			ratio = (yDot1[j] - yDot0[j]) / scale[j];
			yDDotOnScale += ratio * ratio;
		}
		yDDotOnScale = Math.sqrt(yDDotOnScale) / h;

		// step size is computed such that
		// h^order * max (||y'/tol||, ||y''/tol||) = 0.01
		final double maxInv2 = Math.max(Math.sqrt(yDotOnScale2), yDDotOnScale);
		final double h1 = (maxInv2 < 1.0e-15) ? Math.max(1.0e-6, 0.001 * Math.abs(h)) : Math.pow(
				0.01 / maxInv2, 1.0 / order);
		h = Math.min(100.0 * Math.abs(h), h1);
		h = Math.max(h, 1.0e-12 * Math.abs(t0)); // avoids cancellation
															// when computing t1
															// - t0
		if (h < getMinimumStepSize()) {
			h = getMinimumStepSize();
		}
		if (h > getMaximumStepSize()) {
			h = getMaximumStepSize();
		}

		return h;
	}

	/**
	 * Filter the integration step.
	 * 
	 * @param h
	 *            signed step
	 * @param forward
	 *            forward integration indicator
	 * @param acceptSmall
	 *            if true, steps smaller than the minimal value are silently
	 *            increased up to this value, if false such small steps generate
	 *            an exception
	 * @return a bounded integration step (h if no bound is reach, or a bounded
	 *         value)
	 * @throws MinimumStepSizeReachedException 
	 * @exception IntegratorException
	 *                if the step is too small and acceptSmall is false
	 */
	protected double filterStep(final double h, final boolean forward, final boolean acceptSmall) throws MinimumStepSizeReachedException {
		double filteredH = h;
		if (Math.abs(h) < minimumStepSize) {
			if (acceptSmall) {
				filteredH = forward ? minimumStepSize : -minimumStepSize;
			} else {
				throw new MinimumStepSizeReachedException(Math.abs(h));
			}
		}

		if (filteredH > maximumStepSize) {
			filteredH = maximumStepSize;
		} else if (filteredH < -maximumStepSize) {
			filteredH = -maximumStepSize;
		}

		return filteredH;
	}

	/**
	 * Get the minimal step.
	 * 
	 * @return minimal step
	 */
	public double getMinimumStepSize() {
		return minimumStepSize;
	}

	/**
	 * Get the maximal step.
	 * 
	 * @return maximal step
	 */
	public double getMaximumStepSize() {
		return maximumStepSize;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.engine.solver.AbstractSolver#initialize(org.eclipselabs.damos.simulation.engine.ISimulationContext, org.eclipselabs.damos.execution.executionflow.Graph, org.eclipselabs.damos.simulation.engine.ISimulationMonitor)
	 */
	@Override
	public void initialize(ISimulationContext context, IProgressMonitor monitor) throws CoreException {
		super.initialize(context, monitor);
		initializeDiscreteStepTrackers(context.getExecutionFlow().getGraph());
	}

	private void initializeDiscreteStepTrackers(Graph graph) {
		for (Node node : graph.getNodes()) {
			if (node instanceof ComponentNode) {
				ComponentNode componentNode = (ComponentNode) node;
				if (componentNode.getSampleTime() > 0) {
					DiscreteStepTracker discreteStepTracker = new DiscreteStepTracker(componentNode.getSampleTime(), 0);
					componentNode.eAdapters().add(discreteStepTracker);
					discreteStepTrackers.add(discreteStepTracker);
				}
			} else if (node instanceof Graph) {
				initializeDiscreteStepTrackers((Graph) node);
			}
		}
	}
	
	protected double computeNextStepSize(Graph graph, double t, double currentStepSize) {
		double nextStepSize = 0;
		for (Node node : graph.getNodes()) {
			if (node instanceof ComponentNode) {
				AdaptiveStepSizeIntegrationData data = (AdaptiveStepSizeIntegrationData) EcoreUtil.getAdapter(node.eAdapters(), IIntegrationData.class);
				if (data != null && (nextStepSize == 0 || data.getNextStepSize() < nextStepSize)) {
					nextStepSize = data.getNextStepSize();
				}
			}
		}
		
		if (nextStepSize == 0) {
			nextStepSize = getMaximumStepSize();
		}
		
		for (DiscreteStepTracker discreteStepTracker : discreteStepTrackers) {
			double delta = discreteStepTracker.getDelta();
			if (delta < nextStepSize) {
				if (delta > getMinimumStepSize()) {
					nextStepSize = delta - getMinimumStepSize();
				} else {
					nextStepSize = delta;
				}
			}
		}

		if (nextStepSize > getMinimumStepSize()) {
			nextStepSize = computeZeroCrossings(graph, t, currentStepSize, nextStepSize);
		}
		
		if (nextStepSize < getMinimumStepSize()) {
			nextStepSize = getMinimumStepSize();
		}
		
		if (nextStepSize > 0) {
			for (Node node : graph.getNodes()) {
				if (node instanceof ComponentNode) {
					AdaptiveStepSizeIntegrationData data = (AdaptiveStepSizeIntegrationData) EcoreUtil.getAdapter(node.eAdapters(), IIntegrationData.class);
					if (data != null) {
						data.setNextStepSize(nextStepSize);
					}
				}
			}
		}
		
		return nextStepSize;
	}

	/**
	 * @param graph
	 * @param t
	 * @param currentStepSize
	 * @param nextStepSize
	 * @return
	 */
	private double computeZeroCrossings(Graph graph, double t, double currentStepSize, double nextStepSize) {
		for (Node node : graph.getNodes()) {
			if (node instanceof ComponentNode) {
				ComponentNode componentNode = (ComponentNode) node;
				IComponentSimulationObject simulationObject = SimulationUtil.getComponentSimulationObject(componentNode);
				if (simulationObject != null) {
					double zeroCrossingTime = simulationObject.computeZeroCrossingTime(t);
					if (zeroCrossingTime > t) {
						if (zeroCrossingTime < t + nextStepSize) {
							nextStepSize = zeroCrossingTime - t - getMinimumStepSize();
						} else if (zeroCrossingTime - (t + nextStepSize) < 2 * getMinimumStepSize()) {
							nextStepSize -= 2 * getMinimumStepSize();
						}
						if (nextStepSize < getMinimumStepSize()) {
							nextStepSize = getMinimumStepSize();
							return nextStepSize;
						}
					}
					
					double[] zcv = simulationObject.getZeroCrossingValues();
					if (zcv != null && zcv.length > 0) {
						double[] zcv1 = new double[zcv.length];
						System.arraycopy(zcv, 0, zcv1, 0, zcv.length);
						simulationObject.updateZeroCrossingValues(t);
						double[] zcv2 = simulationObject.getZeroCrossingValues();
						
						if (nextStepSize > getMinimumStepSize()) {
							for (int i = 0; i < zcv1.length; ++i) {
								double m = currentStepSize / (zcv2[i] - zcv1[i]);
								double zcv3 = (currentStepSize + nextStepSize) * m + zcv1[i];
								
								if (!(zcv1[i] > 0 && zcv3 > 0 || zcv1[i] < 0 && zcv3 < 0)) {
									nextStepSize = -zcv1[i] / m - currentStepSize;
									if (nextStepSize < getMinimumStepSize()) {
										nextStepSize = getMinimumStepSize();
										return nextStepSize;
									}
								}
							}
						}
					}
				}
			}
		}
		return nextStepSize;
	}
	
	protected boolean canExecute(ComponentNode componentNode, double t) {
		DiscreteStepTracker discreteStepTracker = (DiscreteStepTracker) EcoreUtil.getAdapter(componentNode.eAdapters(), DiscreteStepTracker.class);
		if (discreteStepTracker != null) {
			return discreteStepTracker.isHit();
		}
		return super.canExecute(componentNode, t);
	}
	
	protected void computeContinuousStates(Graph graph, double t, ISimulationMonitor monitor) throws CoreException, MinimumStepSizeReachedException {
		for (Node node : graph.getNodes()) {
			if (node instanceof ComponentNode) {
				AdaptiveStepSizeIntegrationData data = (AdaptiveStepSizeIntegrationData) EcoreUtil.getAdapter(node.eAdapters(), IIntegrationData.class);
				if (data != null) {
					integrateStep(data, t);
				}
			}
		}
	}

	protected abstract void integrateStep(AdaptiveStepSizeIntegrationData data, double t) throws MinimumStepSizeReachedException;

}
