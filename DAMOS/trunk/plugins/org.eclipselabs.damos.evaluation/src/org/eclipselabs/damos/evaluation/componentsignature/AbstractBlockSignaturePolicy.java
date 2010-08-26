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

package org.eclipselabs.damos.evaluation.componentsignature;

import java.io.StringReader;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.InputPort;
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
public abstract class AbstractBlockSignaturePolicy implements IComponentSignaturePolicy {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IComponentSignaturePolicy#evaluateSignature(org.eclipselabs.damos.evaluation.IEvaluationContext, org.eclipselabs.damos.dml.Component, java.util.Map)
	 */
	public final IComponentSignature evaluateSignature(IEvaluationContext context, Component component,
			Map<InputPort, DataType> incomingDataTypes, DiagnosticChain diagnostics) {
		return evaluateSignature(context, (Block) component, incomingDataTypes, diagnostics);
	}

	public abstract IComponentSignature evaluateSignature(IEvaluationContext context, Block block,
			Map<InputPort, DataType> incomingDataTypes, DiagnosticChain diagnostics);
	
	protected DataType evaluateArgumentDataType(IEvaluationContext context, Block block, String parameterName, DiagnosticChain diagnostics) {
		String parameterExpression = block.getArgumentStringValue(parameterName);
		if (parameterExpression != null) {
			return evaluateExpressionDataType(context, parameterExpression, diagnostics);
		}
		diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, parameterName, 0, "Parameter '" + parameterName + "' not found", new Object[] { block }));
		return null;
	}

	protected NumericalType evaluateArgumentNumericalType(IEvaluationContext context, Block block, String parameterName, DiagnosticChain diagnostics) {
		String parameterExpression = block.getArgumentStringValue(parameterName);
		if (parameterExpression != null) {
			DataType dataType = evaluateExpressionDataType(context, parameterExpression, diagnostics);
			if (dataType instanceof NumericalType) {
				return (NumericalType) dataType;
			} else {
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, parameterName, 0, "Parameter '" + parameterName + "' must evaluate to numerical type", new Object[] { block }));
			}
		}
		return null;
	}

	protected BooleanType evaluateArgumentBooleanType(IEvaluationContext context, Block block, String parameterName, DiagnosticChain diagnostics) {
		String parameterExpression = block.getArgumentStringValue(parameterName);
		if (parameterExpression != null) {
			DataType dataType = evaluateExpressionDataType(context, parameterExpression, diagnostics);
			if (dataType instanceof BooleanType) {
				return (BooleanType) dataType;
			} else {
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, parameterName, 0, "Parameter '" + parameterName + "' must evaluate to boolean type", new Object[] { block }));
			}
		}
		return null;
	}

	private DataType evaluateExpressionDataType(IEvaluationContext context, String expression, DiagnosticChain diagnostics) {
		MscriptParser parser = EvaluationPlugin.getDefault().getMscriptParser();
		IParseResult result = parser.parse(
				parser.getGrammarAccess().getExpressionRule().getName(),
				new StringReader(expression));
		if (result.getParseErrors().isEmpty()) {
			return new ExpressionDataTypeEvaluator().doSwitch(result.getRootASTElement());
		} else {
			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, expression, 0, "Parse error", new Object[] { result }));
		}
		return null;
	}

}
