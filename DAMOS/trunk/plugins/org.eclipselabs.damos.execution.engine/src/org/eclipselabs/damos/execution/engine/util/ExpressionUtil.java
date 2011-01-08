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
import org.eclipselabs.damos.dml.Block;
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

	public static IValue evaluateArgumentExpression(Block block, String parameterName) throws CoreException {
		String parameterExpression = block.getArgumentStringValue(parameterName);
		if (parameterExpression != null) {
			return evaluateExpression(parameterExpression);
		}
		throw new CoreException(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Parameter '" + parameterName + "' not found"));
	}

	public static List<IValue> evaluateArgumentExpressionList(Block block, String parameterName) throws CoreException {
		String parameterExpressionList = block.getArgumentStringValue(parameterName);
		if (parameterExpressionList != null) {
			return evaluateExpressionList(parameterExpressionList);
		}
		throw new CoreException(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Parameter '" + parameterName + "' not found"));
	}

	public static ISimpleNumericValue evaluateSimpleNumericArgument(Block block, String parameterName) throws CoreException {
		IValue value = evaluateArgumentExpression(block, parameterName);
		if (value instanceof ISimpleNumericValue) {
			return (ISimpleNumericValue) value;
		}
		throw new CoreException(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, NameUtil.formatName(parameterName) + " must be numeric"));
	}

	public static ISimpleNumericValue evaluateIntegerArgument(Block block, String parameterName) throws CoreException {
		IValue value = evaluateArgumentExpression(block, parameterName);
		if (value instanceof ISimpleNumericValue && value.getDataType() instanceof IntegerType) {
			return (ISimpleNumericValue) value;
		}
		throw new CoreException(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, NameUtil.formatName(parameterName) + " must be integer"));
	}

	public static IBooleanValue evaluateBooleanArgument(Block block, String parameterName) throws CoreException {
		IValue value = evaluateArgumentExpression(block, parameterName);
		if (value instanceof IBooleanValue) {
			return (IBooleanValue) value;
		}
		throw new CoreException(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, NameUtil.formatName(parameterName) + " must be boolean"));
	}

	public static IValue evaluateExpression(String expression) throws CoreException {
		MscriptParser parser = ExecutionEnginePlugin.getDefault().getMscriptParser();
		IParseResult result = parser.parse(
				parser.getGrammarAccess().getExpressionRule().getName(),
				new StringReader(expression));
		if (!result.getParseErrors().isEmpty()) {
			throw new CoreException(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Parse error"));
		}
		
		ITransformerContext transformerContext = new TransformerContext();
		IInterpreterContext interpreterContext = new InterpreterContext(new ComputationContext());

		ExpressionInterpreterHelper expressionInterpreterHelper = new ExpressionInterpreterHelper(transformerContext,
				interpreterContext, (Expression) result.getRootASTElement());
		IValue value = expressionInterpreterHelper.evaluateSingle();
		
		return value;
	}

	public static List<IValue> evaluateExpressionList(String expressionList) throws CoreException {
		MscriptParser parser = ExecutionEnginePlugin.getDefault().getMscriptParser();
		IParseResult result = parser.parse(
				parser.getGrammarAccess().getExpressionListRule().getName(),
				new StringReader(expressionList));
		if (!result.getParseErrors().isEmpty()) {
			throw new CoreException(new Status(IStatus.ERROR, ExecutionEnginePlugin.PLUGIN_ID, "Parse error"));
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
	
}
