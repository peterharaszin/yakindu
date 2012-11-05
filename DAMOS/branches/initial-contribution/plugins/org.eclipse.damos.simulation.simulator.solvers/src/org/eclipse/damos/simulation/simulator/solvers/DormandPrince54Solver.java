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
package org.eclipse.damos.simulation.simulator.solvers;

import org.eclipse.damos.simulation.simulator.solver.EmbeddedRungeKuttaIntegrationData;
import org.eclipse.damos.simulation.simulator.solver.EmbeddedRungeKuttaSolver;

public class DormandPrince54Solver extends EmbeddedRungeKuttaSolver {

	/** Time steps Butcher array. */
	private static final double[] STATIC_C = {
		1.0 / 5.0, 3.0 / 10.0, 4.0 / 5.0, 8.0 / 9.0, 1.0, 1.0
	};

	/** Internal weights Butcher array. */
	private static final double[][] STATIC_A = {
		{ 1.0 / 5.0 },
		{ 3.0 / 40.0, 9.0 / 40.0 },
		{ 44.0 / 45.0, -56.0 / 15.0, 32.0 / 9.0 },
		{ 19372.0 / 6561.0, -25360.0 / 2187.0, 64448.0 / 6561.0, -212.0 / 729.0 },
		{ 9017.0 / 3168.0, -355.0 / 33.0, 46732.0 / 5247.0, 49.0 / 176.0, -5103.0 / 18656.0 },
		{ 35.0 / 384.0, 0.0, 500.0 / 1113.0, 125.0 / 192.0, -2187.0 / 6784.0, 11.0 / 84.0 }
	};

	/** Propagation weights Butcher array. */
	private static final double[] STATIC_B = {
		35.0 / 384.0, 0.0, 500.0 / 1113.0, 125.0 / 192.0, -2187.0 / 6784.0, 11.0 / 84.0, 0.0
	};

	/** Error array, element 1. */
	private static final double E1 = 71.0 / 57600.0;

	// element 2 is zero, so it is neither stored nor used

	/** Error array, element 3. */
	private static final double E3 = -71.0 / 16695.0;

	/** Error array, element 4. */
	private static final double E4 = 71.0 / 1920.0;

	/** Error array, element 5. */
	private static final double E5 = -17253.0 / 339200.0;

	/** Error array, element 6. */
	private static final double E6 = 22.0 / 525.0;

	/** Error array, element 7. */
	private static final double E7 = -1.0 / 40.0;
  
	/**
	 * Simple constructor. Build a fifth order Dormand-Prince integrator with
	 * the given step bounds
	 * 
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
	public DormandPrince54Solver() {
		super(true, STATIC_C, STATIC_A, STATIC_B);
	}

	/** {@inheritDoc} */
	@Override
	public int getOrder() {
		return 5;
	}

	/** {@inheritDoc} */
	@Override
	protected double estimateError(EmbeddedRungeKuttaIntegrationData data, final double[][] yDotK, final double[] y0,
			final double[] y1, final double h) {
		double error = 0;

		for (int j = 0; j < data.y.length; ++j) {
			final double errSum = E1 * yDotK[0][j] + E3 * yDotK[2][j] + E4 * yDotK[3][j] + E5 * yDotK[4][j] + E6
					* yDotK[5][j] + E7 * yDotK[6][j];

			final double yScale = Math.max(Math.abs(y0[j]), Math.abs(y1[j]));
			final double tol = absoluteTolerance + relativeTolerance * yScale;
			final double ratio = h * errSum / tol;
			error += ratio * ratio;

		}

		return Math.sqrt(error / data.y.length);
	}

}
