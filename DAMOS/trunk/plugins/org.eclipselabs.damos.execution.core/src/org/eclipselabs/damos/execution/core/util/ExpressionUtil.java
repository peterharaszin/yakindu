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

package org.eclipselabs.damos.execution.core.util;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipselabs.damos.common.util.NameUtil;
import org.eclipselabs.damos.dml.ParameterizedElement;
import org.eclipselabs.damos.execution.core.ExecutionEnginePlugin;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.ExpressionList;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.functionmodel.transform.ITransformerContext;
import org.eclipselabs.damos.mscript.functionmodel.transform.TransformerContext;
import org.eclipselabs.damos.mscript.interpreter.ComputationContext;
import org.eclipselabs.damos.mscript.interpreter.IInterpreterContext;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationContext;
import org.eclipselabs.damos.mscript.interpreter.InterpreterContext;
import org.eclipselabs.damos.mscript.interpreter.StaticEvaluationContext;
import org.eclipselabs.damos.mscript.interpreter.util.ExpressionInterpreterHelper;
import org.eclipselabs.damos.mscript.interpreter.value.IBooleanValue;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.parser.antlr.MscriptParser;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionUtil {

	public static IValue evaluateArgumentExpression(ParameterizedElement element, String parameterName) throws CoreException {
		String parameterExpression = element.getArgumentStringValue(parameterName);
		if (parameterExpression != null) {
			try {
				return evaluateExpression(parameterExpression);
			} catch (CoreException e) {
				throw new CoreException(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Evaluating " + NameUtil.formatName(parameterName) + " failed: " + e.getStatus().getMessage()));
			}
		}
		throw new CoreException(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Parameter '" + parameterName + "' not found"));
	}

	public static List<IValue> evaluateArgumentExpressionList(ParameterizedElement element, String parameterName) throws CoreException {
		String parameterExpressionList = element.getArgumentStringValue(parameterName);
		if (parameterExpressionList != null) {
			return evaluateExpressionList(parameterExpressionList);
		}
		throw new CoreException(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Parameter '" + parameterName + "' not found"));
	}

	public static ISimpleNumericValue evaluateSimpleNumericArgument(ParameterizedElement element, String parameterName) throws CoreException {
		IValue value = evaluateArgumentExpression(element, parameterName);
		if (value instanceof ISimpleNumericValue) {
			return (ISimpleNumericValue) value;
		}
		throw new CoreException(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, NameUtil.formatName(parameterName) + " must be numeric"));
	}

	public static ISimpleNumericValue evaluateIntegerArgument(ParameterizedElement element, String parameterName) throws CoreException {
		IValue value = evaluateArgumentExpression(element, parameterName);
		if (value instanceof ISimpleNumericValue && value.getDataType() instanceof IntegerType) {
			return (ISimpleNumericValue) value;
		}
		throw new CoreException(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, NameUtil.formatName(parameterName) + " must be integer"));
	}

	public static IBooleanValue evaluateBooleanArgument(ParameterizedElement element, String parameterName) throws CoreException {
		IValue value = evaluateArgumentExpression(element, parameterName);
		if (value instanceof IBooleanValue) {
			return (IBooleanValue) value;
		}
		throw new CoreException(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, NameUtil.formatName(parameterName) + " must be boolean"));
	}

	public static IValue evaluateExpression(String expressionString) throws CoreException {
		Expression expression = parseExpression(expressionString);
		return evaluateExpression(expression);
	}

	/**
	 * @param expression
	 * @return
	 * @throws CoreException
	 */
	public static IValue evaluateExpression(Expression expression) throws CoreException {
		IStaticEvaluationContext staticEvaluationContext = new StaticEvaluationContext();
		ITransformerContext transformerContext = new TransformerContext(staticEvaluationContext);
		IInterpreterContext interpreterContext = new InterpreterContext(staticEvaluationContext, new ComputationContext());

		ExpressionInterpreterHelper expressionInterpreterHelper = new ExpressionInterpreterHelper(transformerContext,
				interpreterContext, expression);
		IValue value = expressionInterpreterHelper.evaluateSingle();
		
		return value;
	}

	public static List<IValue> evaluateExpressionList(String expressionList) throws CoreException {
		MscriptParser parser = ExecutionEnginePlugin.getDefault().getMscriptParser();
		IParseResult result = parser.parse(
				parser.getGrammarAccess().getExpressionListRule(),
				new StringReader(expressionList));
		if (result.hasSyntaxErrors()) {
			throw new CoreException(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Syntax error"));
		}
		List<IValue> values = new ArrayList<IValue>();
		ExpressionList expressions = (ExpressionList) result.getRootASTElement();
		
		IStaticEvaluationContext staticEvaluationContext = new StaticEvaluationContext();
		ITransformerContext transformerContext = new TransformerContext(staticEvaluationContext);
		IInterpreterContext interpreterContext = new InterpreterContext(staticEvaluationContext, new ComputationContext());
		
		for (Expression expression : expressions.getExpressions()) {
			ExpressionInterpreterHelper expressionInterpreterHelper = new ExpressionInterpreterHelper(
					transformerContext, interpreterContext, expression);
			IValue value = expressionInterpreterHelper.evaluateSingle();
			values.add(value);
		}
		
		return values;
	}

	/**
	 * @param expressionString
	 * @return
	 * @throws CoreException
	 */
	public static Expression parseExpression(String expressionString) throws CoreException {
		MscriptParser parser = ExecutionEnginePlugin.getDefault().getMscriptParser();
		IParseResult result = parser.parse(
				parser.getGrammarAccess().getExpressionRule(),
				new StringReader(expressionString));
		if (result.hasSyntaxErrors()) {
			throw new CoreException(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Syntax error"));
		}
		
		Expression expression = (Expression) result.getRootASTElement();
		return expression;
	}
	
}
