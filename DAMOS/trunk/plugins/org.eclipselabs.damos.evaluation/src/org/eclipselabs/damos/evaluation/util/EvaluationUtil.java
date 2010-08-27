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

package org.eclipselabs.damos.evaluation.util;

import java.io.StringReader;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.evaluation.EvaluationPlugin;
import org.eclipselabs.damos.evaluation.ExpressionDataTypeEvaluator;
import org.eclipselabs.damos.evaluation.IEvaluationContext;
import org.eclipselabs.damos.scripting.parser.antlr.MscriptParser;
import org.eclipselabs.damos.typesystem.BooleanType;
import org.eclipselabs.damos.typesystem.DataType;
import org.eclipselabs.damos.typesystem.NumericalType;

/**
 * @author Andreas Unger
 *
 */
public class EvaluationUtil {

	public static DataType evaluateArgumentDataType(IEvaluationContext context, Block block, String parameterName) throws CoreException {
		String parameterExpression = block.getArgumentStringValue(parameterName);
		if (parameterExpression != null) {
			return evaluateExpressionDataType(context, parameterExpression);
		}
		throw new CoreException(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, "Parameter '" + parameterName + "' not found"));
	}

	public static NumericalType evaluateArgumentNumericalType(IEvaluationContext context, Block block, String parameterName) throws CoreException {
		DataType dataType = evaluateArgumentDataType(context, block, parameterName);
		if (dataType instanceof NumericalType) {
			return (NumericalType) dataType;
		}
		throw new CoreException(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, "Parameter '" + parameterName + "' must evaluate to numerical type"));
	}

	public static BooleanType evaluateArgumentBooleanType(IEvaluationContext context, Block block, String parameterName) throws CoreException {
		DataType dataType = evaluateArgumentDataType(context, block, parameterName);
		if (dataType instanceof BooleanType) {
			return (BooleanType) dataType;
		}
		throw new CoreException(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, "Parameter '" + parameterName + "' must evaluate to boolean type"));
	}

	private static DataType evaluateExpressionDataType(IEvaluationContext context, String expression) throws CoreException {
		MscriptParser parser = EvaluationPlugin.getDefault().getMscriptParser();
		IParseResult result = parser.parse(
				parser.getGrammarAccess().getExpressionRule().getName(),
				new StringReader(expression));
		if (!result.getParseErrors().isEmpty()) {
			throw new CoreException(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, "Parse error"));
		}
		return new ExpressionDataTypeEvaluator(context).doSwitch(result.getRootASTElement());
	}

}
