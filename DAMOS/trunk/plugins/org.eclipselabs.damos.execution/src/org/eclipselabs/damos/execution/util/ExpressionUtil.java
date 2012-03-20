/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.execution.util;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.common.util.NameUtil;
import org.eclipselabs.damos.dml.Argument;
import org.eclipselabs.damos.dml.ParameterizedElement;
import org.eclipselabs.damos.dmltext.MscriptValueSpecification;
import org.eclipselabs.damos.execution.internal.ExecutionPlugin;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.interpreter.StaticEvaluationContext;
import org.eclipselabs.damos.mscript.interpreter.StaticExpressionEvaluator;
import org.eclipselabs.damos.mscript.interpreter.value.IBooleanValue;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionUtil {

	public static IValue evaluateArgumentExpression(ParameterizedElement element, String parameterName) throws CoreException {
		Argument argument = element.getArgument(parameterName);
		if (argument != null) {
			if (!(argument.getValue() instanceof MscriptValueSpecification)) {
				throw new CoreException(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "Evaluating " + NameUtil.formatName(parameterName) + " failed: Invalid value"));
			}
			try {
				return evaluateExpression(((MscriptValueSpecification) argument.getValue()).getExpression());
			} catch (CoreException e) {
				throw new CoreException(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "Evaluating " + NameUtil.formatName(parameterName) + " failed: " + e.getStatus().getMessage()));
			}
		}
		throw new CoreException(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, "Parameter '" + parameterName + "' not found"));
	}

	public static ISimpleNumericValue evaluateSimpleNumericArgument(ParameterizedElement element, String parameterName) throws CoreException {
		IValue value = evaluateArgumentExpression(element, parameterName);
		if (value instanceof ISimpleNumericValue) {
			return (ISimpleNumericValue) value;
		}
		throw new CoreException(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, NameUtil.formatName(parameterName) + " must be numeric"));
	}

	public static ISimpleNumericValue evaluateIntegerArgument(ParameterizedElement element, String parameterName) throws CoreException {
		IValue value = evaluateArgumentExpression(element, parameterName);
		if (value instanceof ISimpleNumericValue && value.getDataType() instanceof IntegerType) {
			return (ISimpleNumericValue) value;
		}
		throw new CoreException(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, NameUtil.formatName(parameterName) + " must be integer"));
	}

	public static IBooleanValue evaluateBooleanArgument(ParameterizedElement element, String parameterName) throws CoreException {
		IValue value = evaluateArgumentExpression(element, parameterName);
		if (value instanceof IBooleanValue) {
			return (IBooleanValue) value;
		}
		throw new CoreException(new Status(IStatus.ERROR, ExecutionPlugin.PLUGIN_ID, NameUtil.formatName(parameterName) + " must be boolean"));
	}

	public static IValue evaluateExpression(Expression expression) throws CoreException {
		StaticEvaluationContext context = new StaticEvaluationContext();
		IStatus status = new StaticExpressionEvaluator().evaluate(context, expression);
		if (status.getSeverity() > IStatus.WARNING) {
			throw new CoreException(status);
		}
		return context.getValue(expression);
	}

}
