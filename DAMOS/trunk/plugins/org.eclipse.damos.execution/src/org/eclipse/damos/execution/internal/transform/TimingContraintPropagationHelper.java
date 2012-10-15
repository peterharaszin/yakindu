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

package org.eclipse.damos.execution.internal.transform;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.damos.dml.AsynchronousTimingConstraint;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.ContinuousTimingConstraint;
import org.eclipse.damos.dml.Latch;
import org.eclipse.damos.dml.Port;
import org.eclipse.damos.dml.SynchronousTimingConstraint;
import org.eclipse.damos.dml.ValueSpecification;
import org.eclipse.damos.dml.util.DMLUtil;
import org.eclipse.damos.dscript.DscriptValueSpecification;
import org.eclipse.damos.execution.ComponentNode;
import org.eclipse.damos.execution.DataFlowEnd;
import org.eclipse.damos.execution.ExecutionFlow;
import org.eclipse.damos.execution.Graph;
import org.eclipse.damos.execution.Node;
import org.eclipse.damos.execution.internal.ExecutionPlugin;
import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.IntegerType;
import org.eclipse.damos.mscript.Unit;
import org.eclipse.damos.mscript.UnitFactor;
import org.eclipse.damos.mscript.interpreter.ExpressionEvaluator;
import org.eclipse.damos.mscript.interpreter.IExpressionEvaluator;
import org.eclipse.damos.mscript.interpreter.IStaticEvaluationResult;
import org.eclipse.damos.mscript.interpreter.StaticEvaluationContext;
import org.eclipse.damos.mscript.interpreter.StaticEvaluationResult;
import org.eclipse.damos.mscript.interpreter.StaticExpressionEvaluationContext;
import org.eclipse.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.mscript.util.ISampleInterval;
import org.eclipse.damos.mscript.util.SampleRate;
import org.eclipse.damos.mscript.util.SampleTime;
import org.eclipse.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class TimingContraintPropagationHelper {
	
	private static final ISampleInterval INHERITED = new SampleTime(-1);
	private static final ISampleInterval CONTINUOUS = new SampleTime(0);
	private static final ISampleInterval ASYNCHRONOUS = new SampleTime(Double.POSITIVE_INFINITY);

	private final IExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
	
	private int asynchronousZone;

	public void propagateTimingConstraints(ExecutionFlow executionFlow) throws CoreException {
		executionFlow.setFundamentalSampleInterval(CONTINUOUS);
		
		Graph graph = executionFlow.getGraph();
		List<ComponentNode> inheritingNodes = new LinkedList<ComponentNode>();
		applySampleIntervals(executionFlow, graph, inheritingNodes);
		
		boolean changed;
		do {
			changed = inheritSampleIntervals(inheritingNodes, false);
			if (!inheritingNodes.isEmpty()) {
				changed |= inheritSampleIntervals(inheritingNodes, true);
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
			if (inheritingNode.getSampleInterval() == INHERITED) {
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
	
	private void applySampleIntervals(ExecutionFlow executionFlow, Graph graph, List<ComponentNode> inheritingNodes) throws CoreException {
		for (Node node : graph.getNodes()) {
			if (node instanceof ComponentNode) {
				ComponentNode componentNode = (ComponentNode) node;
				try {
					ISampleInterval sampleInterval = getSampleInterval(componentNode.getComponent());
					componentNode.setSampleInterval(sampleInterval);
					if (sampleInterval == ASYNCHRONOUS) {
						componentNode.setAsynchronousZone(asynchronousZone++);
					} else if (sampleInterval == INHERITED) {
						inheritingNodes.add(componentNode);
					} else if (sampleInterval != CONTINUOUS) {
						ISampleInterval fundamentalSampleTime = executionFlow.getFundamentalSampleInterval();
						if (fundamentalSampleTime == CONTINUOUS) {
							fundamentalSampleTime = sampleInterval;
						} else {
							fundamentalSampleTime = sampleInterval.getFundamental(fundamentalSampleTime);
						}
						executionFlow.setFundamentalSampleInterval(fundamentalSampleTime);
					}
				} catch (NumberFormatException e) {
					throw new CoreException(new Status(
							IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, 0, "Invalid sample time specified", e));
				}
			} else if (node instanceof Graph) {
				applySampleIntervals(executionFlow, (Graph) node, inheritingNodes);
			}
		}
	}

	private ISampleInterval getSampleInterval(Component component) {
		if (component.getTimingConstraint() instanceof ContinuousTimingConstraint) {
			return CONTINUOUS;
		}
		if (component.getTimingConstraint() instanceof AsynchronousTimingConstraint) {
			return ASYNCHRONOUS;
		}
		if (component.getTimingConstraint() instanceof SynchronousTimingConstraint) {
			SynchronousTimingConstraint synchronousTimingConstraint = (SynchronousTimingConstraint) component.getTimingConstraint();
			ValueSpecification sampleTimeSpecification = synchronousTimingConstraint.getSampleInterval();
			if (sampleTimeSpecification instanceof DscriptValueSpecification) {
				IStaticEvaluationResult staticEvaluationResult = new StaticEvaluationResult();
				Expression sampleTimeExpression = ((DscriptValueSpecification) sampleTimeSpecification).getExpression();
				IValue value = expressionEvaluator.evaluate(new StaticExpressionEvaluationContext(new StaticEvaluationContext(staticEvaluationResult)), sampleTimeExpression);
				if (value instanceof ISimpleNumericValue) {
					ISimpleNumericValue sampleInterval = (ISimpleNumericValue) value;
					Unit normalizedUnit = sampleInterval.getDataType().getUnit().getNormalized();
					if (normalizedUnit.getFactors().size() == 1) {
						UnitFactor secondFactor = normalizedUnit.getFactors().get(0);
						if (DMLUtil.isResolved(secondFactor.getSymbol())
								&& TypeUtil.SECOND_UNIT.equals(secondFactor.getSymbol().getName())
								&& secondFactor.getExponent() == -1) {
							if (sampleInterval.getDataType() instanceof IntegerType && normalizedUnit.getScale() == 0) {
								return new SampleRate(sampleInterval.longValue());
							}
							BigDecimal sampleRate = BigDecimal.valueOf(sampleInterval.doubleValue());
							sampleRate = sampleRate.scaleByPowerOfTen(normalizedUnit.getScale());
							try {
								return new SampleRate(sampleRate.longValueExact());
							} catch (ArithmeticException e) {
								// Fall-through and return SampleTime if sampleRate value
								// cannot be represented by a long value 
							}
							return new SampleTime(1.0 / sampleInterval.doubleValue());
						}
					}
					double sampleTime = sampleInterval.doubleValue();
					if (normalizedUnit.getScale() != 0) {
						sampleTime *= Math.pow(10.0, normalizedUnit.getScale());
					}
					return new SampleTime(sampleTime);
				}
			}
		}
		return INHERITED;
	}

	private boolean inheritSampleIntervals(List<ComponentNode> inheritingNodes, boolean backwards) {
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

				ISampleInterval sampleInterval = next.getSampleInterval();
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
						if (sourceComponentNode.getSampleInterval() == ASYNCHRONOUS) {
							if (sampleInterval != ASYNCHRONOUS) {
								sampleInterval = ASYNCHRONOUS;
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
						if (sampleInterval == CONTINUOUS || sampleInterval == ASYNCHRONOUS) {
							continue;
						}
						if (sourceComponentNode.getSampleInterval() == CONTINUOUS) {
							sampleInterval = CONTINUOUS;
							continue;
						}
						if (sourceComponentNode.getSampleInterval().sampleTime() > 0) {
							if (sampleInterval == INHERITED) {
								sampleInterval = sourceComponentNode.getSampleInterval();
							} else {
								sampleInterval = sampleInterval.getFundamental(sourceComponentNode.getSampleInterval());
							}
						}
					}
				}
				
				if (!sampleInterval.equals(next.getSampleInterval()) || asynchronousZone != next.getAsynchronousZone()) {
					next.setSampleInterval(sampleInterval);
					next.setAsynchronousZone(asynchronousZone);

					if (sampleInterval == ASYNCHRONOUS) {
						it.remove();
					}
					
					changed = true;
					changedOnce = true;
				}
			}
		} while (changed);
		
		if (changedOnce) {
			for (Iterator<ComponentNode> it = inheritingNodes.iterator(); it.hasNext();) {
				if (it.next().getSampleInterval() != INHERITED) {
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
	
}
