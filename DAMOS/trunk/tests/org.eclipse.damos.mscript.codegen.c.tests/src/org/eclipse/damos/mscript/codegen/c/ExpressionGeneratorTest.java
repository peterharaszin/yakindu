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

package org.eclipse.damos.mscript.codegen.c;

import static org.junit.Assert.assertEquals;

import java.io.StringReader;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.MscriptRuntimeModule;
import org.eclipse.damos.mscript.codegen.c.ExpressionGenerator;
import org.eclipse.damos.mscript.codegen.c.ICodeFragment;
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorConfiguration;
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipse.damos.mscript.codegen.c.MscriptGeneratorContext;
import org.eclipse.damos.mscript.computation.ComputationModel;
import org.eclipse.damos.mscript.computation.util.ComputationModelUtil;
import org.eclipse.damos.mscript.interpreter.ExpressionEvaluator;
import org.eclipse.damos.mscript.interpreter.FunctionCallPath;
import org.eclipse.damos.mscript.interpreter.IExpressionEvaluator;
import org.eclipse.damos.mscript.interpreter.IStaticEvaluationResult;
import org.eclipse.damos.mscript.interpreter.StaticEvaluationContext;
import org.eclipse.damos.mscript.interpreter.StaticEvaluationResult;
import org.eclipse.damos.mscript.interpreter.StaticExpressionEvaluationContext;
import org.eclipse.damos.mscript.services.MscriptGrammarAccess;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
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

	private final IExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
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
		assertEquals("100.0", generate("100.0"));
	}

	@Test
	public void integerLiteral() {
		assertEquals("INT64_C(100)", generate("100"));
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
		assertEquals("1.0 < 1.0", generate("1.0 < 1.0"));
	}

	@Test
	public void lessThanOrEqualToExpression() {
		assertEquals("1.0 <= 1.0", generate("1.0 <= 1.0"));
	}

	@Test
	public void greaterThanExpression() {
		assertEquals("1.0 > 1.0", generate("1.0 > 1.0"));
	}
	
	@Test
	public void greaterThanOrEqualToExpression() {
		assertEquals("1.0 >= 1.0", generate("1.0 >= 1.0"));
	}

	@Test
	public void additionExpression() {
		assertEquals("1.0 + 1.0", generate("1.0 + 1.0"));
	}

	@Test
	public void subtractionExpression() {
		assertEquals("1.0 + 1.0", generate("1.0 + 1.0"));
	}

	@Test
	public void multiplicationExpression() {
		assertEquals("1.0 * 1.0", generate("1.0 * 1.0"));
	}

	@Test
	public void divisionExpression() {
		assertEquals("1.0 / 1.0", generate("1.0 / 1.0"));
	}

	@Test
	public void parenthesizedExpression() {
		assertEquals("(1)", generate("(true)"));
		assertEquals("(1 || (0 && 0))", generate("(true || (false && false))"));
	}

	@Test
	public void negateExpression() {
		assertEquals("-1.0", generate("-1.0"));
	}

	@Test
	public void powerExpression() {
		assertEquals("pow(2.0, 10.0)", generate("2.0^10.0"));
	}

	@Test
	public void logicalNotExpression() {
		assertEquals("!0", generate("!false"));
	}

	private String generate(String expressionString) {
		IStaticEvaluationResult staticEvaluationResult = new StaticEvaluationResult();

		Expression expression = parseExpression(expressionString);
		expressionEvaluator.evaluate(new StaticExpressionEvaluationContext(new StaticEvaluationContext(staticEvaluationResult)), expression);
		
		IMscriptGeneratorContext context = new MscriptGeneratorContext(new MscriptGeneratorConfiguration(), staticEvaluationResult.getFunctionInfo(FunctionCallPath.EMPTY), new CodeFragmentCollector());
		return expressionGenerator.generate(context, expression).toString();
	}
	
	private Expression parseExpression(String expressionString) {
		IParseResult result = parser.parse(grammarAccess.getExpressionRule(), new StringReader(expressionString));
		if (result.hasSyntaxErrors()) {
			throw new RuntimeException("Syntax errors in '" + expressionString + "'");
		}
		return (Expression) result.getRootASTElement();
	}
	
	private static class MscriptGeneratorConfiguration implements IMscriptGeneratorConfiguration {
		
		public ComputationModel getComputationModel() {
			return ComputationModelUtil.constructDefaultComputationModel();
		}
		
		public int getStringBufferSize() {
			return 32;
		}
		
		public boolean isSingleton() {
			return false;
		}
		
	}
	
	private static class CodeFragmentCollector implements ICodeFragmentCollector {
		
		public <T extends ICodeFragment> T addCodeFragment(T codeFragment, IProgressMonitor monitor) {
			return codeFragment;
		}

	}
	
}
