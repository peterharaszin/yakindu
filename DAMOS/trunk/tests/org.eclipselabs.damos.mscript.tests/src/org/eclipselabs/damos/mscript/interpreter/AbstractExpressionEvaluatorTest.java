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

package org.eclipselabs.damos.mscript.interpreter;

import java.io.StringReader;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.resource.impl.ListBasedDiagnosticConsumer;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.MscriptRuntimeModule;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.services.MscriptGrammarAccess;
import org.junit.Before;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractExpressionEvaluatorTest {
	
	private final IExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
	
	@Inject
	private IParser parser;
	
	@Inject
	private ILinker linker;
	
	@Inject
	private MscriptGrammarAccess grammarAccess;
	
	@Before
	public void setUp() {
		Injector injector = Guice.createInjector(new MscriptRuntimeModule());
		injector.injectMembers(this);
	}
	
	protected IValue evaluate(String expressionString) {
		return evaluate(expressionString, false);
	}
	
	protected IValue evaluate(String expressionString, boolean link) {
		IStaticEvaluationResult staticEvaluationResult = new StaticEvaluationResult();

		Expression expression = parseExpression(expressionString, link);
		expressionEvaluator.evaluate(new StaticExpressionEvaluationContext(new StaticEvaluationContext(staticEvaluationResult)), expression);

		Interpreter interpreter = new Interpreter(staticEvaluationResult, staticEvaluationResult.getComputationContext());
		IInterpreterContext interpreterContext = new InterpreterContext(staticEvaluationResult, staticEvaluationResult.getComputationContext(), interpreter, FunctionCallPath.EMPTY);
		return expressionEvaluator.evaluate(new ExpressionEvaluationContext(interpreterContext), expression);
	}

	protected Expression parseExpression(String expressionString, boolean link) {
		IParseResult result = parser.parse(grammarAccess.getExpressionRule(), new StringReader(expressionString));
		if (result.hasSyntaxErrors()) {
			throw new RuntimeException("Syntax errors in '" + expressionString + "'");
		}
		
		Expression expression = (Expression) result.getRootASTElement();
		if (link) {
			ResourceSet resourceSet = new ResourceSetImpl();
			Resource resource = resourceSet.createResource(URI.createURI("__test.mscript"));
			resource.getContents().add(expression);
			
			ListBasedDiagnosticConsumer diagnosticsConsumer = new ListBasedDiagnosticConsumer();
			linker.linkModel(expression, diagnosticsConsumer);
			if (diagnosticsConsumer.hasConsumedDiagnostics(Severity.ERROR)) {
				throw new RuntimeException("Linker errors in '" + expressionString + "'");
			}
		}
		
		return expression;
	}

}
