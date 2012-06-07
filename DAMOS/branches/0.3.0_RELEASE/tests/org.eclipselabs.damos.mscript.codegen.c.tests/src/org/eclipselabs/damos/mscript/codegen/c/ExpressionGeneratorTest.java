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

package org.eclipselabs.damos.mscript.codegen.c;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.StringReader;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.MscriptRuntimeModule;
import org.eclipselabs.damos.mscript.computationmodel.util.ComputationModelUtil;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationContext;
import org.eclipselabs.damos.mscript.interpreter.StaticEvaluationContext;
import org.eclipselabs.damos.mscript.interpreter.StaticExpressionEvaluator;
import org.eclipselabs.damos.mscript.services.MscriptGrammarAccess;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionGeneratorTest {

	private final StaticExpressionEvaluator staticExpressionEvaluator = new StaticExpressionEvaluator();
	private final ExpressionGenerator expressionGenerator = new ExpressionGenerator();
	
	@Inject
	private IParser parser;
	
	@Inject
	private MscriptGrammarAccess grammarAccess;
	
	@Before
	public void setUp() {
		Injector injector = Guice.createInjector(new MscriptRuntimeModule());
		injector.injectMembers(this);
	}
	
	@Test
	public void realLiteral() {
		assertEquals("(double) 100.0", generate("100.0"));
	}

	@Test
	public void integerLiteral() {
		assertEquals("(int64_t) 100", generate("100"));
	}
	
	@Test
	public void booleanLiteral() {
		assertEquals("1", generate("true"));
		assertEquals("0", generate("false"));
	}

	@Test
	public void impliesExpression() {
		assertEquals("(!(1) || 0)", generate("true => false"));
	}
	
	@Test
	public void logicalOrExpression() {
		assertEquals("1 || 0", generate("true || false"));
	}

	@Test
	public void logicalAndExpression() {
		assertEquals("1 && 0", generate("true && false"));
	}

	@Test
	public void equalsExpression() {
		assertEquals("1 == 0", generate("true == false"));
	}

	@Test
	public void notEqualsExpression() {
		assertEquals("1 != 0", generate("true != false"));
	}

	@Test
	public void lessThanExpression() {
		assertEquals("(double) 1.0 < (double) 1.0", generate("1.0 < 1.0"));
	}

	@Test
	public void lessThanOrEqualToExpression() {
		assertEquals("(double) 1.0 <= (double) 1.0", generate("1.0 <= 1.0"));
	}

	@Test
	public void greaterThanExpression() {
		assertEquals("(double) 1.0 > (double) 1.0", generate("1.0 > 1.0"));
	}
	
	@Test
	public void greaterThanOrEqualToExpression() {
		assertEquals("(double) 1.0 >= (double) 1.0", generate("1.0 >= 1.0"));
	}

	@Test
	public void additionExpression() {
		assertEquals("(double) 1.0 + (double) 1.0", generate("1.0 + 1.0"));
	}

	@Test
	public void subtractionExpression() {
		assertEquals("(double) 1.0 + (double) 1.0", generate("1.0 + 1.0"));
	}

	@Test
	public void multiplicationExpression() {
		assertEquals("(double) 1.0 * (double) 1.0", generate("1.0 * 1.0"));
	}

	@Test
	public void divisionExpression() {
		assertEquals("(double) 1.0 / (double) 1.0", generate("1.0 / 1.0"));
	}

	@Test
	public void parenthesizedExpression() {
		assertEquals("(1)", generate("(true)"));
		assertEquals("(1 || (0 && 0))", generate("(true || (false && false))"));
	}

	@Test
	public void negateExpression() {
		assertEquals("-(double) 1.0", generate("-1.0"));
	}

	@Test
	public void powerExpression() {
		assertEquals("pow((double) 2.0, (double) 10.0)", generate("2.0^10.0"));
	}

	@Test
	public void logicalNotExpression() {
		assertEquals("!0", generate("!false"));
	}

	private String generate(String expressionString) {
		try {
			IStaticEvaluationContext staticEvaluationContext = new StaticEvaluationContext();

			Expression expression = parseExpression(expressionString);
			staticExpressionEvaluator.evaluate(staticEvaluationContext, expression);
			
			StringBuilder stringBuilder = new StringBuilder();
			IMscriptGeneratorContext context = new MscriptGeneratorContext(stringBuilder, ComputationModelUtil.constructDefaultComputationModel(), staticEvaluationContext, new ICodeFragmentCollector() {
				
				public ICodeFragment addCodeFragment(ICodeFragment codeFragment, IProgressMonitor monitor) {
					return codeFragment;
				}
				
			});
			expressionGenerator.generate(context, expression);
			
			return stringBuilder.toString();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private Expression parseExpression(String expressionString) {
		IParseResult result = parser.parse(grammarAccess.getExpressionRule(), new StringReader(expressionString));
		if (result.hasSyntaxErrors()) {
			throw new RuntimeException("Syntax errors in '" + expressionString + "'");
		}
		return (Expression) result.getRootASTElement();
	}
	
}
