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

package org.eclipselabs.damos.simulation.util;

import org.eclipse.core.runtime.CoreException;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.execution.util.ExpressionUtil;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class SimulationConfigurationUtil {

	public static double getSimulationTime(Configuration configuration) {
		Expression simulationTimeExpression = configuration.getPropertyValue("damos.simulation.simulationTime");
		if (simulationTimeExpression != null) {
			try {
				IValue simulationTimeValue = ExpressionUtil.evaluateExpression(simulationTimeExpression);
				if (simulationTimeValue instanceof ISimpleNumericValue) {
					return ((ISimpleNumericValue) simulationTimeValue).doubleValue();
				}
			} catch (CoreException e) {
				// return -1
			}
		}
		return -1;
	}
	
	public static double getSolverPropertyDoubleValue(Configuration configuration, String propertyName, double defaultValue) {
		Expression expression = configuration.getPropertyValue("damos.simulation.solver/" + propertyName);
		if (expression != null) {
			try {
				IValue value = ExpressionUtil.evaluateExpression(expression);
				if (value instanceof ISimpleNumericValue) {
					return ((ISimpleNumericValue) value).doubleValue();
				}
			} catch (CoreException e) {
				// return -1
			}
		}
		return defaultValue;
	}
	
}
