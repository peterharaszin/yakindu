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
 * org.apache.commons.math.ode.nonstiff.EmbeddedRungeKuttaIntegrator class,
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

package org.eclipselabs.damos.simulation.simulator.solver;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.execution.executionflow.ComponentNode;
import org.eclipselabs.damos.execution.executionflow.Graph;
import org.eclipselabs.damos.execution.executionflow.Node;
import org.eclipselabs.damos.simulation.ISimulationMonitor;
import org.eclipselabs.damos.simulation.simulator.ISimulationObject;
import org.eclipselabs.damos.simulation.simulator.internal.ISimulationContext;
import org.eclipselabs.damos.simulation.simulator.internal.SimulatorPlugin;

public abstract class EmbeddedRungeKuttaSolver extends AdaptiveStepSizeSolver implements ISolver {

	/** Indicator for <i>fsal</i> methods. */
	private final boolean fsal;

	/** Time steps from Butcher array (without the first zero). */
	private final double[] c;

	/** Internal weights from Butcher array (without the first empty row). */
	private final double[][] a;

	/** External weights for the high order method from Butcher array. */
	private final double[] b;

	/** Stepsize control exponent. */
	private final double exponent;
	
	private final int stageCount;

	/** Safety factor for stepsize control. */
	private double safetyFactor;

	/** Minimal reduction factor for stepsize control. */
	private double minimumReduction;

	/** Maximal growth factor for stepsize control. */
	private double maximumGrowth;

	private double currentStepSize;

	private double t;

	/**
	 * Build a Runge-Kutta integrator with the given Butcher array.
	 * 
	 * @param name
	 *            name of the method
	 * @param fsal
	 *            indicate that the method is an <i>fsal</i>
	 * @param c
	 *            time steps from Butcher array (without the first zero)
	 * @param a
	 *            internal weights from Butcher array (without the first empty
	 *            row)
	 * @param b
	 *            propagation weights for the high order method from Butcher
	 *            array
	 * @param prototype
	 *            prototype of the step interpolator to use
	 * @param minStep
	 *            minimal step (must be positive even for backward integration),
	 *            the last step can be smaller than this
	 * @param maxStep
	 *            maximal step (must be positive even for backward integration)
	 * @param absoluteTolerance
	 *            allowed absolute error
	 * @param relativeTolerance
	 *            allowed relative error
	 */
	protected EmbeddedRungeKuttaSolver(final boolean fsal, final double[] c, final double[][] a,
			final double[] b) {

		this.fsal = fsal;
		this.c = c;
		this.a = a;
		this.b = b;
		this.stageCount = c.length + 1;

		exponent = -1.0 / getOrder();

		// set the default values of the algorithm control parameters
		setSafetyFactor(0.9);
		setMinimumReduction(0.2);
		setMaximumGrowth(10.0);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.solver.ISolver#getNextTime()
	 */
	public double getTime() {
		return t;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.solver.AdaptiveStepSizeSolver#initialize(org.eclipselabs.damos.simulation.simulator.ISimulationContext, org.eclipselabs.damos.execution.executionflow.Graph, org.eclipselabs.damos.simulation.simulator.ISimulationMonitor)
	 */
	@Override
	public void initialize(ISimulationContext context, IProgressMonitor monitor) throws CoreException {
		super.initialize(context, monitor);
		computeInitialStepSize(context.getExecutionFlow().getGraph());
		t = 0;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.solver.ISolver#createData(org.eclipselabs.damos.simulation.simulator.ISimulationObject, org.eclipselabs.damos.simulation.simulationmodel.SimulationModel)
	 */
	public AdaptiveStepSizeIntegrationData createIntegrationData(ISimulationObject simulationObject) {
		return new EmbeddedRungeKuttaIntegrationData(simulationObject, stageCount);
	}

	/**
	 * @param graph
	 * @throws CoreException
	 */
	private void computeInitialStepSize(Graph graph) throws CoreException {
		currentStepSize = Double.MAX_VALUE;
		for (Node node : graph.getNodes()) {
			if (node instanceof ComponentNode) {
				EmbeddedRungeKuttaIntegrationData data = (EmbeddedRungeKuttaIntegrationData) EcoreUtil.getAdapter(node.eAdapters(), IIntegrationData.class);
				if (data != null) {
					computeInitialStepSize(data, 0);
					if (data.getNextStepSize() < currentStepSize) {
						currentStepSize = data.getNextStepSize();
					}
				}
			}
		}
	}

	/**
	 * @param data
	 * @param t
	 * @throws CoreException
	 */
	private void computeInitialStepSize(EmbeddedRungeKuttaIntegrationData data, double t) throws CoreException {
		final double[] scale = new double[data.y.length];
		for (int i = 0; i < scale.length; ++i) {
			scale[i] = absoluteTolerance + relativeTolerance * Math.abs(data.y[i]);
		}
		data.setNextStepSize(initializeStep(data, getOrder(), scale, t, data.y, data.yDotKs[0], data.yTmps,
				data.yDotKs[1]));
	}

	public void computeStep(ISimulationMonitor monitor) throws CoreException {
		Graph graph = context.getExecutionFlow().getGraph();
		try {
			computeDiscreteStates(graph, t, monitor);
			
			for (DiscreteStepTracker discreteStepTracker : discreteStepTrackers) {
				discreteStepTracker.step(t);
			}
	
			currentStepSize = computeNextStepSize(graph, t, currentStepSize);
			computeContinuousStates(graph, t, monitor);
			
			t += currentStepSize;
		} catch (MinimumStepSizeReachedException e) {
			throw new CoreException(new Status(IStatus.ERROR, SimulatorPlugin.PLUGIN_ID, String.format("Minimum step size (%.2e) reached, integration needs %.2e", getMinimumStepSize(), e.getRequiredStepSize()), e));
		}
	}

	public void integrateStep(AdaptiveStepSizeIntegrationData adaptiveStepSizeSolverData, double t) throws MinimumStepSizeReachedException {
		EmbeddedRungeKuttaIntegrationData data = (EmbeddedRungeKuttaIntegrationData) adaptiveStepSizeSolverData;
		
		double stepSize = Double.NaN;
	
		// iterate over step size, ensuring local normalized error is smaller
		// than 1
		double error = 10;
		while (error >= 1.0) {
	
			if (!fsal) {
				data.simulationObject.computeDerivatives(t, data.y, data.yDotKs[0]);
			}
	
			stepSize = data.getNextStepSize();
	
			// next stages
			for (int k = 1; k < stageCount; ++k) {
	
				for (int j = 0; j < data.y.length; ++j) {
					double sum = a[k - 1][0] * data.yDotKs[0][j];
					for (int l = 1; l < k; ++l) {
						sum += a[k - 1][l] * data.yDotKs[l][j];
					}
					data.yTmps[j] = data.y[j] + stepSize * sum;
				}
	
				data.simulationObject.computeDerivatives(t + c[k - 1] * stepSize, data.yTmps, data.yDotKs[k]);
	
			}
	
			// estimate the state at the end of the step
			for (int j = 0; j < data.y.length; ++j) {
				double sum = b[0] * data.yDotKs[0][j];
				for (int l = 1; l < stageCount; ++l) {
					sum += b[l] * data.yDotKs[l][j];
				}
				data.yTmps[j] = data.y[j] + stepSize * sum;
			}
	
			// estimate the error at the end of the step
			error = estimateError(data, data.yDotKs, data.y, data.yTmps, stepSize);
			if (error >= 1.0) {
				// reject the step and attempt to reduce error by stepsize
				// control
				final double factor = Math.min(maximumGrowth,
						Math.max(minimumReduction, safetyFactor * Math.pow(error, exponent)));
				data.setNextStepSize(filterStep(stepSize * factor, true, false));
			}
	
		}
	
		System.arraycopy(data.yTmps, 0, data.y, 0, data.y.length);
		System.arraycopy(data.yDotKs[stageCount - 1], 0, data.yDotTmp, 0, data.y.length);
	
		if (fsal) {
			// save the last evaluation for the next step
			System.arraycopy(data.yDotTmp, 0, data.yDotKs[0], 0, data.y.length);
		}
	
		// stepsize control for next step
		final double factor = Math.min(maximumGrowth, Math.max(minimumReduction, safetyFactor * Math.pow(error, exponent)));
		final double scaledH = stepSize * factor;
		final boolean nextIsLast = false;
		data.setNextStepSize(filterStep(scaledH, true, nextIsLast));
	}

	/**
	 * Get the order of the method.
	 * 
	 * @return order of the method
	 */
	public abstract int getOrder();

	/**
	 * Get the safety factor for step size control.
	 * 
	 * @return safety factor
	 */
	public double getSafetyFactor() {
		return safetyFactor;
	}

	/**
	 * Set the safety factor for stepsize control.
	 * 
	 * @param safetyFactor
	 *            safety factor
	 */
	public void setSafetyFactor(final double safetyFactor) {
		this.safetyFactor = safetyFactor;
	}
	
	/**
	 * Get the minimal reduction factor for stepsize control.
	 * 
	 * @return minimal reduction factor
	 */
	public double getMinimumReduction() {
		return minimumReduction;
	}

	/**
	 * Set the minimal reduction factor for stepsize control.
	 * 
	 * @param minimumReduction
	 *            minimal reduction factor
	 */
	public void setMinimumReduction(final double minimumReduction) {
		this.minimumReduction = minimumReduction;
	}

	/**
	 * Get the maximal growth factor for stepsize control.
	 * 
	 * @return maximal growth factor
	 */
	public double getMaximumGrowth() {
		return maximumGrowth;
	}

	/**
	 * Set the maximal growth factor for stepsize control.
	 * 
	 * @param maximumGrowth
	 *            maximal growth factor
	 */
	public void setMaximumGrowth(final double maximumGrowth) {
		this.maximumGrowth = maximumGrowth;
	}
	
	/**
	 * Compute the error ratio.
	 * 
	 * @param yDotK
	 *            derivatives computed during the first stages
	 * @param y0
	 *            estimate of the step at the start of the step
	 * @param y1
	 *            estimate of the step at the end of the step
	 * @param h
	 *            current step
	 * @return error ratio, greater than 1 if step should be rejected
	 */
	protected abstract double estimateError(EmbeddedRungeKuttaIntegrationData data, double[][] yDotK, double[] y0,
			double[] y1, double h);

}
