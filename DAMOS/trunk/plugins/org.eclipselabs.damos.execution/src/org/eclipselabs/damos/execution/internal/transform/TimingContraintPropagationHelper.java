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

package org.eclipselabs.damos.execution.internal.transform;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.common.math.MathUtil;
import org.eclipselabs.damos.dml.AsynchronousTimingConstraint;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.ContinuousTimingConstraint;
import org.eclipselabs.damos.dml.Latch;
import org.eclipselabs.damos.dml.Port;
import org.eclipselabs.damos.dml.SynchronousTimingConstraint;
import org.eclipselabs.damos.dml.ValueSpecification;
import org.eclipselabs.damos.dscript.DscriptValueSpecification;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.execution.DataFlowEnd;
import org.eclipselabs.damos.execution.ExecutionFlow;
import org.eclipselabs.damos.execution.Graph;
import org.eclipselabs.damos.execution.Node;
import org.eclipselabs.damos.execution.internal.ExecutionPlugin;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.interpreter.ExpressionEvaluator;
import org.eclipselabs.damos.mscript.interpreter.IExpressionEvaluator;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationResult;
import org.eclipselabs.damos.mscript.interpreter.StaticEvaluationContext;
import org.eclipselabs.damos.mscript.interpreter.StaticEvaluationResult;
import org.eclipselabs.damos.mscript.interpreter.StaticExpressionEvaluationContext;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class TimingContraintPropagationHelper {
	
	private static final double INHERITED = -1;
	private static final double CONTINUOUS = 0;
	private static final double ASYNCHRONOUS = Double.POSITIVE_INFINITY;

	private final IExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
	
	private int asynchronousZone;

	public void propagateTimingConstraints(ExecutionFlow executionFlow) throws CoreException {
		Graph graph = executionFlow.getGraph();
		List<ComponentNode> inheritingNodes = new LinkedList<ComponentNode>();
		applySampleTimes(executionFlow, graph, inheritingNodes);
		
		boolean changed;
		do {
			changed = inheritSampleTimes(inheritingNodes, false);
			if (!inheritingNodes.isEmpty()) {
				changed |= inheritSampleTimes(inheritingNodes, true);
			}
		} while (changed);
		
		executionFlow.setAsynchronousZoneCount(asynchronousZone);

		checkFailedComponentNodes(inheritingNodes);
	}

	/**
	 * @param inheritingNodes
	 * @throws CoreException
	 */
	private void checkFailedComponentNodes(List<ComponentNode> inheritingNodes) throws CoreException {
		List<ComponentNode> failedComponentNodes = null;
		for (ComponentNode inheritingNode : inheritingNodes) {
			if (inheritingNode.getSampleTime() == INHERITED) {
				if (failedComponentNodes == null) {
					failedComponentNodes = new ArrayList<ComponentNode>();
				}
				failedComponentNodes.add(inheritingNode);
			}
		}
		
		if (failedComponentNodes != null) {
			StringBuilder message = new StringBuilder("Resolving sample times failed for ");
			boolean first = true;
			for (ComponentNode node : failedComponentNodes) {
				String name = node.getComponent().getName();
				if (name != null) {
					if (first) {
						first = false;
					} else {
						message.append(", ");
					}
					message.append(name);
				}
			}
			throw new CoreException(new Status(
					IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, 0, message.toString(), null));
		}
	}
	
	private void applySampleTimes(ExecutionFlow executionFlow, Graph graph, List<ComponentNode> inheritingNodes) throws CoreException {
		for (Node node : graph.getNodes()) {
			if (node instanceof ComponentNode) {
				ComponentNode componentNode = (ComponentNode) node;
				try {
					double sampleTime = getSampleTime(componentNode.getComponent());
					componentNode.setSampleTime(sampleTime);
					if (sampleTime == ASYNCHRONOUS) {
						componentNode.setAsynchronousZone(asynchronousZone++);
					} else if (sampleTime == INHERITED) {
						inheritingNodes.add(componentNode);
					} else if (sampleTime != CONTINUOUS) {
						double fundamentalSampleTime = executionFlow.getFundamentalSampleTime();
						if (fundamentalSampleTime == 0) {
							fundamentalSampleTime = sampleTime;
						} else {
							fundamentalSampleTime = MathUtil.gcd(sampleTime, fundamentalSampleTime);
						}
						executionFlow.setFundamentalSampleTime(fundamentalSampleTime);
					}
				} catch (NumberFormatException e) {
					throw new CoreException(new Status(
							IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, 0, "Invalid sample time specified", e));
				}
			} else if (node instanceof Graph) {
				applySampleTimes(executionFlow, (Graph) node, inheritingNodes);
			}
		}
	}

	/**
	 * @param sampleTimeSpecification
	 * @return
	 */
	private double getSampleTime(Component component) {
		if (component.getTimingConstraint() instanceof ContinuousTimingConstraint) {
			return CONTINUOUS;
		}
		if (component.getTimingConstraint() instanceof AsynchronousTimingConstraint) {
			return ASYNCHRONOUS;
		}
		if (component.getTimingConstraint() instanceof SynchronousTimingConstraint) {
			SynchronousTimingConstraint synchronousTimingConstraint = (SynchronousTimingConstraint) component.getTimingConstraint();
			ValueSpecification sampleTimeSpecification = synchronousTimingConstraint.getSampleTime();
			if (sampleTimeSpecification instanceof DscriptValueSpecification) {
				IStaticEvaluationResult staticEvaluationResult = new StaticEvaluationResult();
				Expression sampleTimeExpression = ((DscriptValueSpecification) sampleTimeSpecification).getExpression();
				IValue sampleTime = expressionEvaluator.evaluate(new StaticExpressionEvaluationContext(new StaticEvaluationContext(staticEvaluationResult)), sampleTimeExpression);
				if (sampleTime instanceof ISimpleNumericValue) {
					return ((ISimpleNumericValue) sampleTime).doubleValue();
				}
			}
		}
		return INHERITED;
	}

	private boolean inheritSampleTimes(List<ComponentNode> inheritingNodes, boolean backwards) {
		boolean changedOnce = false;
		
		boolean changed;
		do {
			changed = false;
			for (Iterator<ComponentNode> it = inheritingNodes.iterator(); it.hasNext();) {
				ComponentNode next = it.next();
				
				// Inherit time constraint only from driven nodes (targets)
				if (!backwards && next.getComponent() instanceof Latch) {
					continue;
				}

				double sampleTime = next.getSampleTime();
				int asynchronousZone = next.getAsynchronousZone();
				
				List<? extends DataFlowEnd> nodes;
				if (backwards) {
					nodes = next.getDrivenEnds();
				} else {
					nodes = next.getDrivingEnds();
				}
				
				for (DataFlowEnd end : nodes) {
					if (end.getNode() instanceof ComponentNode) {
						ComponentNode sourceComponentNode = (ComponentNode) end.getNode();
						if (sourceComponentNode.getSampleTime() == ASYNCHRONOUS) {
							if (sampleTime != ASYNCHRONOUS) {
								sampleTime = ASYNCHRONOUS;
								if (isSocket(end)) {
									asynchronousZone = this.asynchronousZone++;
									break;
								} else {
									asynchronousZone = sourceComponentNode.getAsynchronousZone();
								}
							} else if (asynchronousZone != sourceComponentNode.getAsynchronousZone()) {
								asynchronousZone = this.asynchronousZone++;
								break;
							}
							continue;
						}
						if (sampleTime == CONTINUOUS || sampleTime == ASYNCHRONOUS) {
							continue;
						}
						if (sourceComponentNode.getSampleTime() == CONTINUOUS) {
							sampleTime = CONTINUOUS;
							continue;
						}
						if (sourceComponentNode.getSampleTime() > 0) {
							if (sampleTime == INHERITED) {
								sampleTime = sourceComponentNode.getSampleTime();
							} else {
								sampleTime = gcd(sampleTime, sourceComponentNode.getSampleTime());
							}
						}
					}
				}
				
				if (sampleTime != next.getSampleTime() || asynchronousZone != next.getAsynchronousZone()) {
					next.setSampleTime(sampleTime);
					next.setAsynchronousZone(asynchronousZone);

					if (sampleTime == ASYNCHRONOUS) {
						it.remove();
					}
					
					changed = true;
					changedOnce = true;
				}
			}
		} while (changed);
		
		if (changedOnce) {
			for (Iterator<ComponentNode> it = inheritingNodes.iterator(); it.hasNext();) {
				if (it.next().getSampleTime() != INHERITED) {
					it.remove();
				}
			}
		}
		
		return changedOnce;
	}
	
	private boolean isSocket(DataFlowEnd end) {
		if (end.getConnector() instanceof Port) {
			Port port = (Port) end.getConnector();
			return port.getInoutput().isSocket();
		}
		return false;
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
