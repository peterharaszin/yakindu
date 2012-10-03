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
 * org.apache.commons.math.ode.nonstiff.ClassicalRungeKuttaIntegrator class,
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

package org.eclipse.damos.simulation.simulator.solvers;

import org.eclipse.damos.simulation.simulator.solver.RungeKuttaSolver;

public class ClassicalRungeKuttaSolver extends RungeKuttaSolver {

	/** Time steps Butcher array. */
	private static final double[] STATIC_C = { 1.0 / 2.0, 1.0 / 2.0, 1.0 };

	/** Internal weights Butcher array. */
	private static final double[][] STATIC_A = { { 1.0 / 2.0 }, { 0.0, 1.0 / 2.0 }, { 0.0, 0.0, 1.0 } };

	/** Propagation weights Butcher array. */
	private static final double[] STATIC_B = { 1.0 / 6.0, 1.0 / 3.0, 1.0 / 3.0, 1.0 / 6.0 };

	/**
	 * Simple constructor. Build a fourth-order Runge-Kutta integrator with the
	 * given step.
	 * 
	 * @param step
	 *            integration step
	 */
	public ClassicalRungeKuttaSolver() {
		super(STATIC_C, STATIC_A, STATIC_B);
	}

}
