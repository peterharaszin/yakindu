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
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipselabs.damos.common.util.NameUtil;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.evaluation.EvaluationPlugin;
import org.eclipselabs.mscript.computation.core.ComputationContext;
import org.eclipselabs.mscript.computation.core.value.IValue;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.ExpressionList;
import org.eclipselabs.mscript.language.il.transform.ITransformerContext;
import org.eclipselabs.mscript.language.il.transform.TransformerContext;
import org.eclipselabs.mscript.language.interpreter.DataTypeSpecifierEvaluator;
import org.eclipselabs.mscript.language.interpreter.IInterpreterContext;
import org.eclipselabs.mscript.language.interpreter.InterpreterContext;
import org.eclipselabs.mscript.language.interpreter.util.ExpressionInterpreterHelper;
import org.eclipselabs.mscript.language.parser.antlr.MscriptParser;
import org.eclipselabs.mscript.typesystem.BooleanType;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.IntegerType;
import org.eclipselabs.mscript.typesystem.NumericType;

/**
 * @author Andreas Unger
 *
 */
public class EvaluationUtil {

	public static DataType evaluateArgumentDataType(Block block, String parameterName) throws CoreException {
		String parameterExpression = block.getArgumentStringValue(parameterName);
		if (parameterExpression != null) {
			return evaluateExpressionDataType(parameterExpression);
		}
		throw new CoreException(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, "Parameter '" + parameterName + "' not found"));
	}

	public static List<DataType> evaluateArgumentExpressionListDataTypes(Block block, String parameterName) throws CoreException {
		String parameterExpressionList = block.getArgumentStringValue(parameterName);
		if (parameterExpressionList != null) {
			return evaluateExpressionListDataTypes(parameterExpressionList);
		}
		throw new CoreException(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, "Parameter '" + parameterName + "' not found"));
	}

	public static NumericType evaluateArgumentNumericType(Block block, String parameterName) throws CoreException {
		DataType dataType = evaluateArgumentDataType(block, parameterName);
		if (dataType instanceof NumericType) {
			return (NumericType) dataType;
		}
		throw new CoreException(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, NameUtil.formatName(parameterName) + " must be numeric"));
	}

	public static IntegerType evaluateArgumentIntegerType(Block block, String parameterName) throws CoreException {
		DataType dataType = evaluateArgumentDataType(block, parameterName);
		if (dataType instanceof IntegerType) {
			return (IntegerType) dataType;
		}
		throw new CoreException(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, NameUtil.formatName(parameterName) + " must be integer"));
	}

	public static BooleanType evaluateArgumentBooleanType(Block block, String parameterName) throws CoreException {
		DataType dataType = evaluateArgumentDataType(block, parameterName);
		if (dataType instanceof BooleanType) {
			return (BooleanType) dataType;
		}
		throw new CoreException(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, NameUtil.formatName(parameterName) + " must be boolean"));
	}

	public static DataType evaluateExpressionDataType(String expression) throws CoreException {
		MscriptParser parser = EvaluationPlugin.getDefault().getMscriptParser();
		IParseResult result = parser.parse(
				parser.getGrammarAccess().getExpressionRule().getName(),
				new StringReader(expression));
		if (!result.getParseErrors().isEmpty()) {
			throw new CoreException(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, "Parse error"));
		}
		
		ITransformerContext transformerContext = new TransformerContext();
		IInterpreterContext interpreterContext = new InterpreterContext(new ComputationContext());

		ExpressionInterpreterHelper expressionInterpreterHelper = new ExpressionInterpreterHelper(transformerContext,
				interpreterContext, (Expression) result.getRootASTElement());
		IValue value = expressionInterpreterHelper.evaluateSingle();
		
		return value.getDataType();
	}

	public static List<DataType> evaluateExpressionListDataTypes(String expressionList) throws CoreException {
		MscriptParser parser = EvaluationPlugin.getDefault().getMscriptParser();
		IParseResult result = parser.parse(
				parser.getGrammarAccess().getExpressionListRule().getName(),
				new StringReader(expressionList));
		if (!result.getParseErrors().isEmpty()) {
			throw new CoreException(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, "Parse error"));
		}
		List<DataType> dataTypes = new ArrayList<DataType>();
		ExpressionList expressions = (ExpressionList) result.getRootASTElement();
		
		ITransformerContext transformerContext = new TransformerContext();
		IInterpreterContext interpreterContext = new InterpreterContext(new ComputationContext());
		
		for (Expression expression : expressions.getExpressions()) {
			ExpressionInterpreterHelper expressionInterpreterHelper = new ExpressionInterpreterHelper(
					transformerContext, interpreterContext, expression);
			IValue value = expressionInterpreterHelper.evaluateSingle();
			dataTypes.add(value.getDataType());
		}
		
		return dataTypes;
	}

	public static DataType evaluateDataTypeSpecifierDataType(IInterpreterContext context, String dataTypeSpecifier) throws CoreException {
		MscriptParser parser = EvaluationPlugin.getDefault().getMscriptParser();
		IParseResult result = parser.parse(
				parser.getGrammarAccess().getDataTypeSpecifierRule().getName(),
				new StringReader(dataTypeSpecifier));
		if (!result.getParseErrors().isEmpty()) {
			throw new CoreException(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, "Parse error"));
		}
		return new DataTypeSpecifierEvaluator(context).doSwitch(result.getRootASTElement());
	}
	
//	public static IValue evaluateArgumentValue(IEvaluationContext context, Block block, String parameterName) throws CoreException {
//		String parameterExpression = block.getArgumentStringValue(parameterName);
//		if (parameterExpression != null) {
//			return evaluateExpressionValue(context, parameterExpression);
//		}
//		throw new CoreException(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, "Parameter '" + parameterName + "' not found"));
//	}
//
//	public static INumericValue evaluateArgumentNumericalValue(IEvaluationContext context, Block block, String parameterName) throws CoreException {
//		IValue value = evaluateArgumentValue(context, block, parameterName);
//		if (value instanceof INumericValue) {
//			return (INumericValue) value;
//		}
//		throw new CoreException(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, NameUtil.formatName(parameterName) + " must be numeric"));
//	}
//
//	public static IValue evaluateExpressionValue(IEvaluationContext context, String expression) throws CoreException {
//		MscriptParser parser = EvaluationPlugin.getDefault().getMscriptParser();
//		IParseResult result = parser.parse(
//				parser.getGrammarAccess().getExpressionRule().getName(),
//				new StringReader(expression));
//		if (!result.getParseErrors().isEmpty()) {
//			throw new CoreException(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, "Parse error"));
//		}
//		return new ExpressionValueEvaluator(context).doSwitch(result.getRootASTElement());
//	}

}
