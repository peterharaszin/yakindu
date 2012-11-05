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

package org.eclipse.damos.simulation.simulator.solver;

import org.eclipse.emf.common.notify.impl.AdapterImpl;

public class DiscreteStepTracker extends AdapterImpl {
	
	private double sampleTime;
	private double offset;
	private double delta;
	private boolean hit;
	
	private double hitTime;
	
	/**
	 * 
	 */
	public DiscreteStepTracker(double sampleTime, double offset) {
		this.sampleTime = sampleTime;
		this.offset = offset;
		this.delta = offset > 0 ? offset : sampleTime;
		this.hit = offset == 0;
		this.hitTime = offset == 0 ? 0 : Double.NEGATIVE_INFINITY;
	}
	
	/**
	 * @return the hit
	 */
	public boolean isHit() {
		return hit;
	}
	
	public double getDelta() {
		return delta;
	}
	
	public void step(double t) {
		if (t >= offset) {
			double nextHitTime = t - (t - offset) % sampleTime;
			hit = nextHitTime - hitTime > sampleTime / 2;
			if (hit) {
				hitTime = nextHitTime;
			}
			delta = hitTime + sampleTime - t;
		} else {
			delta = offset - t;
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#isAdapterForType(java.lang.Object)
	 */
	@Override
	public boolean isAdapterForType(Object type) {
		return type == DiscreteStepTracker.class;
	}
	
}