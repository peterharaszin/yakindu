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

package org.eclipselabs.damos.simulation.simulator.solver;

import java.math.BigDecimal;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.execution.executionflow.ComponentNode;
import org.eclipselabs.damos.execution.executionflow.CompoundNode;
import org.eclipselabs.damos.execution.executionflow.Graph;
import org.eclipselabs.damos.execution.executionflow.Node;
import org.eclipselabs.damos.simulation.ISimulationMonitor;
import org.eclipselabs.damos.simulation.simulator.ISimulationObject;
import org.eclipselabs.damos.simulation.simulator.internal.ISimulationContext;
import org.eclipselabs.damos.simulation.simulator.util.SimulationUtil;
import org.eclipselabs.damos.simulation.util.SimulationConfigurationUtil;

/**
 * @author Andreas Unger
 * 
 */
public abstract class RungeKuttaSolver extends AbstractSolver implements ISolver {

	private long n;
	
	/** Time steps from Butcher array (without the first zero). */
	private final double[] c;

	/** Internal weights from Butcher array (without the first empty row). */
	private final double[][] a;

	/** External weights for the high order method from Butcher array. */
	private final double[] b;

	private final int stageCount;

	/** Integration step size. */
	private double stepSize;

	/**
	 * Simple constructor. Build a Runge-Kutta integrator with the given step.
	 * The default step handler does nothing.
	 * 
	 * @param name
	 *            name of the method
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
	 * @param stepSize
	 *            integration step
	 */
	protected RungeKuttaSolver(final double[] c, final double[][] a, final double[] b) {
		this.c = c;
		this.a = a;
		this.b = b;
		this.stageCount = c.length + 1;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.solver.ISolver#getNextTime()
	 */
	public double getTime() {
		return n * stepSize;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.solver.AbstractSolver#initialize(org.eclipselabs.damos.simulation.simulator.ISimulationContext, org.eclipselabs.damos.execution.executionflow.Graph, org.eclipselabs.damos.simulation.simulator.ISimulationMonitor)
	 */
	@Override
	public void initialize(ISimulationContext context, IProgressMonitor monitor) throws CoreException {
		super.initialize(context, monitor);
		stepSize = computeStepSize(context.getExecutionFlow().getGraph(), stepSize);
		n = 0;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.solver.ISolver#initialize(org.eclipselabs.damos.simulation.simulationmodel.SolverConfiguration)
	 */
	public void configure(Configuration configuration) {
		this.stepSize = Math.abs(SimulationConfigurationUtil.getSolverPropertyDoubleValue(context.getSimulationModel(), "stepSize", 1.0));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.solver.ISolver#createData(org.eclipselabs.damos.simulation.simulator.ISimulationObject, org.eclipselabs.damos.simulation.simulationmodel.SimulationModel)
	 */
	public IIntegrationData createIntegrationData(ISimulationObject simulationObject) {
		return new RungeKuttaIntegrationData(simulationObject, stageCount);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.solver.ISolver#run(org.eclipselabs.damos.simulation.simulator.ISimulationContext, org.eclipselabs.damos.simulation.simulator.ISimulationMonitor)
	 */
	public void computeStep(ISimulationMonitor monitor) throws CoreException {
		Graph graph = context.getExecutionFlow().getGraph();
		computeDiscreteStates(graph, n * stepSize, monitor);
		computeContinuousStates(context, graph, n * stepSize, monitor);
		++n;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.solver.AbstractSolver#canExecute(org.eclipselabs.damos.execution.executionflow.ComponentNode, double)
	 */
	@Override
	protected boolean canExecute(ComponentNode componentNode, double t) {
		if (componentNode.getSampleTime() > 0) {
			return n % (long) (componentNode.getSampleTime() / stepSize) == 0;
		}
		return super.canExecute(componentNode, t);
	}

	private double computeStepSize(Graph graph, double maximumStepSize) {
		for (Node node : graph.getNodes()) {
			if (node instanceof ComponentNode) {
				ComponentNode componentNode = (ComponentNode) node;
				if (componentNode.getSampleTime() > 0) {
					if (maximumStepSize == -1) {
						maximumStepSize = componentNode.getSampleTime();
					} else {
						maximumStepSize = gcd(maximumStepSize, componentNode.getSampleTime());
					}
				}
			} else if (node instanceof CompoundNode) {
				maximumStepSize = computeStepSize((CompoundNode) node, maximumStepSize);
			}
		}
		return maximumStepSize;
	}

	/**
	 * @throws IntegratorException
	 */
	private void completeStep(RungeKuttaIntegrationData data) {
		// estimate the state at the end of the step
		for (int j = 0; j < data.y.length; ++j) {
			double sum = b[0] * data.yDotKs[0][j];
			for (int l = 1; l < stageCount; ++l) {
				sum += b[l] * data.yDotKs[l][j];
			}
			data.yTmps[j] = data.y[j] + stepSize * sum;
		}

		System.arraycopy(data.yTmps, 0, data.y, 0, data.y.length);
	}

	private void computeContinuousStates(ISimulationContext context, Graph graph, double t, ISimulationMonitor monitor) throws CoreException {
		for (Node node : graph.getNodes()) {
			if (node instanceof ComponentNode) {
				RungeKuttaIntegrationData data = (RungeKuttaIntegrationData) EcoreUtil.getAdapter(node.eAdapters(), IIntegrationData.class);
				if (data != null) {
					integrateFirstStage(data, t);
				}
			}
		}
		
		double offset = 0;
		for (double timeStep : c) {
			for (Node node : graph.getNodes()) {
				if (node instanceof ComponentNode) {
					ComponentNode componentNode = (ComponentNode) node;
					if (componentNode.getSampleTime() == 0) {
						ISimulationObject simulationObject = SimulationUtil.getSimulationObject(componentNode);
						if (simulationObject != null) {
							simulationObject.computeOutputValues(t + offset, monitor);
							propagateComponentOutputValues(componentNode, simulationObject);
						}
					}
				}
			}
			
			for (Node node : graph.getNodes()) {
				if (node instanceof ComponentNode) {
					RungeKuttaIntegrationData data = (RungeKuttaIntegrationData) EcoreUtil.getAdapter(node.eAdapters(), IIntegrationData.class);
					if (data != null) {
						integrateNextStage(data, t + stepSize * timeStep);
					}
				}
			}
			
			offset = stepSize * timeStep;
		}
	
		for (Node node : graph.getNodes()) {
			if (node instanceof ComponentNode) {
				RungeKuttaIntegrationData data = (RungeKuttaIntegrationData) EcoreUtil.getAdapter(node.eAdapters(), IIntegrationData.class);
				if (data != null) {
					completeStep(data);
				}
			}
		}
	}

	/**
	 * @throws CoreException 
	 */
	private void integrateFirstStage(RungeKuttaIntegrationData data, double t) {
		// first stage
		data.simulationObject.computeDerivatives(t, data.y, data.yDotKs[0]);
		data.k = 1;
		if (data.k < stageCount) {
			computeTemporaryYs(data);
		}
	}

	/**
	 * @throws CoreException 
	 */
	private void integrateNextStage(RungeKuttaIntegrationData data, double t) {
		// next stages
		data.simulationObject.computeDerivatives(t, data.yTmps, data.yDotKs[data.k]);
		++data.k;
		if (data.k < stageCount) {
			computeTemporaryYs(data);
		}
	}

	/**
	 * @return
	 */
	private void computeTemporaryYs(RungeKuttaIntegrationData data) {
		for (int j = 0; j < data.y.length; ++j) {
			double sum = a[data.k - 1][0] * data.yDotKs[0][j];
			for (int l = 1; l < data.k; ++l) {
				sum += a[data.k - 1][l] * data.yDotKs[l][j];
			}
			data.yTmps[j] = data.y[j] + stepSize * sum;
		}
	}

	private static double gcd(double a, double b) {
		return gcd(BigDecimal.valueOf(a), BigDecimal.valueOf(b));
	}

	private static double gcd(BigDecimal a, BigDecimal b) {
		if (BigDecimal.ZERO.compareTo(b) == 0) {
			return a.doubleValue();
		}
		return gcd(b, a.remainder(b));
	}
	
}
