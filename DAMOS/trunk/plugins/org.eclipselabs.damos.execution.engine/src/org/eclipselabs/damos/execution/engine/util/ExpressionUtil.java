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

package org.eclipselabs.damos.execution.engine.util;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipselabs.damos.common.util.NameUtil;
import org.eclipselabs.damos.dml.ParameterizedElement;
import org.eclipselabs.damos.execution.engine.ExecutionEnginePlugin;
import org.eclipselabs.mscript.computation.engine.ComputationContext;
import org.eclipselabs.mscript.computation.engine.value.IBooleanValue;
import org.eclipselabs.mscript.computation.engine.value.ISimpleNumericValue;
import org.eclipselabs.mscript.computation.engine.value.IValue;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.ExpressionList;
import org.eclipselabs.mscript.language.il.transform.ITransformerContext;
import org.eclipselabs.mscript.language.il.transform.TransformerContext;
import org.eclipselabs.mscript.language.interpreter.IInterpreterContext;
import org.eclipselabs.mscript.language.interpreter.InterpreterContext;
import org.eclipselabs.mscript.language.interpreter.util.ExpressionInterpreterHelper;
import org.eclipselabs.mscript.language.parser.antlr.MscriptParser;
import org.eclipselabs.mscript.typesystem.IntegerType;

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

		ITransformerContext transformerContext = new TransformerContext();
		IInterpreterContext interpreterContext = new InterpreterContext(new ComputationContext());

		ExpressionInterpreterHelper expressionInterpreterHelper = new ExpressionInterpreterHelper(transformerContext,
				interpreterContext, expression);
		IValue value = expressionInterpreterHelper.evaluateSingle();
		
		return value;
	}

	public static List<IValue> evaluateExpressionList(String expressionList) throws CoreException {
		MscriptParser parser = ExecutionEnginePlugin.getDefault().getMscriptParser();
		IParseResult result = parser.parse(
				parser.getGrammarAccess().getExpressionListRule().getName(),
				new StringReader(expressionList));
		if (!result.getParseErrors().isEmpty()) {
			throw new CoreException(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Syntax error"));
		}
		List<IValue> values = new ArrayList<IValue>();
		ExpressionList expressions = (ExpressionList) result.getRootASTElement();
		
		ITransformerContext transformerContext = new TransformerContext();
		IInterpreterContext interpreterContext = new InterpreterContext(new ComputationContext());
		
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
				parser.getGrammarAccess().getExpressionRule().getName(),
				new StringReader(expressionString));
		if (!result.getParseErrors().isEmpty()) {
			throw new CoreException(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Syntax error"));
		}
		
		Expression expression = (Expression) result.getRootASTElement();
		return expression;
	}
	
}
