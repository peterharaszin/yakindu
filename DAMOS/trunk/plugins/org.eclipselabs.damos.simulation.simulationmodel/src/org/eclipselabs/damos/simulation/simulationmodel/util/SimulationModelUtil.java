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

package org.eclipselabs.damos.simulation.simulationmodel.util;

import org.eclipse.core.runtime.IStatus;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.RealLiteral;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationContext;
import org.eclipselabs.damos.mscript.interpreter.StaticEvaluationContext;
import org.eclipselabs.damos.mscript.interpreter.StaticExpressionEvaluator;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.util.TypeUtil;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModelFactory;
import org.eclipselabs.damos.simulation.simulationmodel.SolverArgument;
import org.eclipselabs.damos.simulation.simulationmodel.SolverConfiguration;
import org.eclipselabs.damos.simulation.simulationmodel.SolverParameter;

/**
 * @author Andreas Unger
 *
 */
public class SimulationModelUtil {

	public static double getSolverArgumentDoubleValue(SolverConfiguration solverConfiguration, String parameterName) {
		return getSolverArgumentDoubleValue(solverConfiguration, parameterName, Double.NaN);
	}

	public static double getSolverArgumentDoubleValue(SolverConfiguration solverConfiguration, String argumentName, double defaultValue) {
		SolverArgument argument = solverConfiguration.getArgument(argumentName);
		return argument != null ? getSolverArgumentDoubleValue(argument, defaultValue) : defaultValue;
	}

	/**
	 * @param valueExpression
	 * @param defaultValue
	 * @return
	 */
	public static double getSolverArgumentDoubleValue(SolverArgument argument, double defaultValue) {
		Expression valueExpression = argument.getValue();
		if (valueExpression != null) {
			IStaticEvaluationContext context = new StaticEvaluationContext();
			IStatus status = new StaticExpressionEvaluator().evaluate(context, valueExpression);
			if (status.isOK()) {
				IValue value = context.getValue(valueExpression);
				if (value instanceof ISimpleNumericValue) {
					ISimpleNumericValue numericValue = (ISimpleNumericValue) value;
					return numericValue.doubleValue();
				}
			}
		}
		return defaultValue;
	}

	public static void setSolverArgumentValue(SolverConfiguration solverConfiguration, String parameterName, Expression value) {
		SolverArgument argument = solverConfiguration.getArgument(parameterName);
		if (argument == null) {
			SolverParameter parameter = solverConfiguration.getType().getConfigurationDefinition().getParameter(parameterName);
			if (parameter != null) {
				argument = SimulationModelFactory.eINSTANCE.createSolverArgument();
				argument.setParameter(parameter);
				solverConfiguration.getArguments().add(argument);
			}
		}
		if (argument != null) {
			argument.setValue(value);
		}
	}

	public static void setSolverArgumentValue(SolverConfiguration solverConfiguration, String parameterName, double value) {
		RealLiteral realLiteral = MscriptFactory.eINSTANCE.createRealLiteral();
		realLiteral.setValue(value);
		realLiteral.setUnit(TypeUtil.createUnit());
		setSolverArgumentValue(solverConfiguration, parameterName, realLiteral);
	}

}
