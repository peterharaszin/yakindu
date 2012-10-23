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

package org.eclipse.damos.ide.core.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.SynchronousTimingConstraint;
import org.eclipse.damos.dml.TimingConstraint;
import org.eclipse.damos.dml.util.DMLUtil;
import org.eclipse.damos.dscript.DscriptValueSpecification;
import org.eclipse.damos.ide.core.IDECorePlugin;
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
import org.eclipse.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class TimingConstraintValidator {

	private IExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();

	public IStatus validateTimingConstraint(Component component) {
		IStatus status = Status.OK_STATUS;

		TimingConstraint timingConstraint = component.getTimingConstraint();
		if (timingConstraint instanceof SynchronousTimingConstraint) {
			SynchronousTimingConstraint synchronousTimingConstraint = (SynchronousTimingConstraint) timingConstraint;
			
			if (!(synchronousTimingConstraint.getSampleInterval() instanceof DscriptValueSpecification)) {
				return addStatus(status, new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Invalid synchronous timing constraint specified"));
			}
			
			Expression expression = ((DscriptValueSpecification) synchronousTimingConstraint.getSampleInterval()).getExpression();
			IStaticEvaluationResult staticEvaluationResult = new StaticEvaluationResult();
			IValue value = expressionEvaluator.evaluate(new StaticExpressionEvaluationContext(new StaticEvaluationContext(staticEvaluationResult)), expression);
			if (!staticEvaluationResult.getStatus().isOK()) {
				status = addStatus(status, staticEvaluationResult.getStatus());
			}
			if (staticEvaluationResult.getStatus().getSeverity() > IStatus.WARNING) {
				return status;
			}
			
			if (!(value instanceof ISimpleNumericValue)) {
				return addStatus(status, new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Sample interval must be numeric value"));
			}
			
			ISimpleNumericValue sampleInterval = (ISimpleNumericValue) value;

			boolean validUnit = true;
			
			Unit normalizedUnit = sampleInterval.getDataType().getUnit().getNormalized();
			if (normalizedUnit != null && normalizedUnit.getFactors().size() == 1) {
				UnitFactor secondFactor = normalizedUnit.getFactors().get(0);
				if (!DMLUtil.isResolved(secondFactor.getSymbol())
						|| !TypeUtil.SECOND_UNIT.equals(secondFactor.getSymbol().getName())
						|| secondFactor.getExponent() != 1 && secondFactor.getExponent() != -1) {
					validUnit = false;
				}
			} else {
				validUnit = false;
			}
			
			if (!validUnit) {
				String secondValue;
				String hertzValue;
				if (sampleInterval.getDataType() instanceof IntegerType) {
					long longValue = Math.abs(sampleInterval.longValue());
					if (longValue == 0) {
						longValue = 1;
					}
					secondValue = Double.toString(1.0 / longValue);
					hertzValue = Long.toString(longValue);
				} else {
					double doubleValue = Math.abs(sampleInterval.doubleValue());
					if (doubleValue == 0.0) {
						doubleValue = 1.0;
					}
					if (doubleValue < 1.0) {
						secondValue = Double.toString(doubleValue);
						hertzValue = Double.toString(1.0 / doubleValue);
					} else {
						secondValue = Double.toString(1.0 / doubleValue);
						hertzValue = Double.toString(doubleValue);
					}
				}
				status = addStatus(status, new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID,
						"Sample interval unit must be s (sample time) or Hz (sample rate), e.g. " + secondValue
								+ "(s) or " + hertzValue + "(Hz)"));
			}
			
			if (sampleInterval.doubleValue() <= 0.0) {
				status = addStatus(status, new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Sample interval must be greater than 0"));
			}
		}
		
		return status;
	}
	
	private IStatus addStatus(IStatus result, IStatus status) {
		if (result == Status.OK_STATUS || !(result instanceof MultiStatus)) {
			result = new MultiStatus(IDECorePlugin.PLUGIN_ID, 0, "", null);
		}
		((MultiStatus) result).add(status);
		return result;
	}

}
