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

package org.eclipselabs.damos.execution.executionflow.internal.construct;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.dml.AsynchronousTimingConstraint;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.ContinuousTimingConstraint;
import org.eclipselabs.damos.dml.Latch;
import org.eclipselabs.damos.dml.SynchronousTimingConstraint;
import org.eclipselabs.damos.execution.executionflow.ComponentNode;
import org.eclipselabs.damos.execution.executionflow.ExecutionFlow;
import org.eclipselabs.damos.execution.executionflow.Graph;
import org.eclipselabs.damos.execution.executionflow.Node;
import org.eclipselabs.damos.execution.executionflow.construct.ExecutionFlowPlugin;

/**
 * @author Andreas Unger
 *
 */
public class SampleTimePropagationHelper {

	public void propagateSampleTimes(ExecutionFlow executionFlow) throws CoreException {
		Graph graph = executionFlow.getGraph();
		List<ComponentNode> inheritingNodes = new LinkedList<ComponentNode>();
		applySampleTimes(graph, inheritingNodes);
		
		boolean changed;
		do {
			changed = inheritSampleTimes(inheritingNodes, false);
			if (!inheritingNodes.isEmpty()) {
				changed |= inheritSampleTimes(inheritingNodes, true);
			}
		} while (changed);

		for (ComponentNode inheritingNode : inheritingNodes) {
			if (inheritingNode.getSampleTime() == -1) {
				throw new CoreException(new Status(
						IStatus.ERROR, ExecutionFlowPlugin.PLUGIN_ID, 0, "Resolving sample times failed", null));
			}
		}
	}
	
	private void applySampleTimes(Graph graph, List<ComponentNode> inheritingNodes) throws CoreException {
		for (Node node : graph.getNodes()) {
			if (node instanceof ComponentNode) {
				ComponentNode componentNode = (ComponentNode) node;
				try {
					double sampleTime = getSampleTime(componentNode.getComponent());
					componentNode.setSampleTime(sampleTime);
					if (sampleTime == -1) {
						inheritingNodes.add(componentNode);
					}
				} catch (NumberFormatException e) {
					throw new CoreException(new Status(
							IStatus.ERROR, ExecutionFlowPlugin.PLUGIN_ID, 0, "Invalid sample time specified", e));
				}
			} else if (node instanceof Graph) {
				applySampleTimes((Graph) node, inheritingNodes);
			}
		}
	}

	/**
	 * @param sampleTimeSpecification
	 * @return
	 */
	private double getSampleTime(Component component) {
		if (component instanceof Latch) {
			return Double.NaN;
		}
		if (component.getTimingConstraint() == null) {
			return -1;
		}
		if (component.getTimingConstraint() instanceof ContinuousTimingConstraint) {
			return 0;
		}
		if (component.getTimingConstraint() instanceof AsynchronousTimingConstraint) {
			return Double.POSITIVE_INFINITY;
		}
		if (component.getTimingConstraint() instanceof SynchronousTimingConstraint) {
			SynchronousTimingConstraint synchronousTimingConstraint = (SynchronousTimingConstraint) component.getTimingConstraint();
			return Double.parseDouble(synchronousTimingConstraint.getSampleTime().stringSampleTime());
		}
		throw new IllegalArgumentException();
	}

	private boolean inheritSampleTimes(List<ComponentNode> inheritingNodes, boolean backwards) {
		boolean changedOnce = false;
		
		boolean changed;
		do {
			changed = false;
			for (Iterator<ComponentNode> it = inheritingNodes.iterator(); it.hasNext();) {
				ComponentNode next = it.next();
				
				double sampleTime = next.getSampleTime();
				
				List<Node> nodes;
				if (backwards) {
					nodes = next.getDrivenNodes();
				} else {
					nodes = next.getDrivingNodes();
				}
				
				for (Node node : nodes) {
					if (node instanceof ComponentNode) {
						ComponentNode sourceComponentNode = (ComponentNode) node;
						if (sourceComponentNode.getComponent() instanceof Latch) {
							continue;
						}
						if (sourceComponentNode.getSampleTime() == 0) {
							sampleTime = 0;
							it.remove();
							break;
						}
						if (sourceComponentNode.getSampleTime() == Double.POSITIVE_INFINITY) {
							sampleTime = Double.POSITIVE_INFINITY;
							it.remove();
							break;
						}
						if (sourceComponentNode.getSampleTime() > 0) {
							if (sampleTime == -1) {
								sampleTime = sourceComponentNode.getSampleTime();
							} else {
								sampleTime = gcd(sampleTime, sourceComponentNode.getSampleTime());
							}
						}
					}
				}
				
				if (sampleTime != next.getSampleTime()) {
					next.setSampleTime(sampleTime);
					changed = true;
					changedOnce = true;
				}
			}
		} while (changed);
		
		if (changedOnce) {
			for (Iterator<ComponentNode> it = inheritingNodes.iterator(); it.hasNext();) {
				if (it.next().getSampleTime() != -1) {
					it.remove();
				}
			}
		}
		
		return changedOnce;
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
