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

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import java.io.StringReader;

import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.MscriptRuntimeModule;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.interpreter.value.IArrayValue;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.services.MscriptGrammarAccess;
import org.eclipselabs.damos.mscript.util.TypeUtil;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionEvaluatorTest {
	
	private final StaticExpressionEvaluator staticExpressionEvaluator = new StaticExpressionEvaluator();
	
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
	public void createVector() {
		IValue value = evaluate("{ 1, 2, 3 }");
		
		assertTrue(value instanceof IArrayValue);
		IArrayValue arrayValue = (IArrayValue) value;
		
		assertEquals("Array must have 1 dimension", 1, arrayValue.getDataType().getDimensionality());
		assertEquals("Array size must be 3", 3, TypeUtil.getArraySize(arrayValue.getDataType()));
	}

	@Test
	public void createMatrix2x3() {
		IValue value = evaluate("{ { 1, 2, 3 }, { 4, 5.1, 6 } }");
		
		assertTrue(value instanceof IArrayValue);
		IArrayValue arrayValue = (IArrayValue) value;
		
		assertTrue(arrayValue.getDataType() instanceof ArrayType);
		assertTrue(arrayValue.getDataType().getElementType() instanceof RealType);
		assertEquals("Array must have 2 dimensions", 2, arrayValue.getDataType().getDimensionality());
		assertEquals("Row size must be 2", 2, TypeUtil.getArrayRowSize(arrayValue.getDataType()));
		assertEquals("Column size must be 3", 3, TypeUtil.getArrayColumnSize(arrayValue.getDataType()));
		
		assertValueEquals(1.0, arrayValue.get(0, 0), 1e-10);
		assertValueEquals(2.0, arrayValue.get(0, 1), 1e-10);
		assertValueEquals(3.0, arrayValue.get(0, 2), 1e-10);
		assertValueEquals(4.0, arrayValue.get(1, 0), 1e-10);
		assertValueEquals(5.1, arrayValue.get(1, 1), 1e-10);
		assertValueEquals(6.0, arrayValue.get(1, 2), 1e-10);
	}
	
	@Test
	public void createMatrix2x3ScalarMultiplyPre() {
		IValue value = evaluate("10 * { { 1, 2, 3 }, { 4, 5.1, 6 } }");
		
		assertTrue(value instanceof IArrayValue);
		IArrayValue arrayValue = (IArrayValue) value;
		
		assertTrue(arrayValue.getDataType() instanceof ArrayType);
		assertTrue(arrayValue.getDataType().getElementType() instanceof RealType);
		assertEquals("Array must have 2 dimensions", 2, arrayValue.getDataType().getDimensionality());
		assertEquals("Row size must be 2", 2, TypeUtil.getArrayRowSize(arrayValue.getDataType()));
		assertEquals("Column size must be 3", 3, TypeUtil.getArrayColumnSize(arrayValue.getDataType()));
		
		assertValueEquals(10.0, arrayValue.get(0, 0), 1e-10);
		assertValueEquals(20.0, arrayValue.get(0, 1), 1e-10);
		assertValueEquals(30.0, arrayValue.get(0, 2), 1e-10);
		assertValueEquals(40.0, arrayValue.get(1, 0), 1e-10);
		assertValueEquals(51.0, arrayValue.get(1, 1), 1e-10);
		assertValueEquals(60.0, arrayValue.get(1, 2), 1e-10);
	}

	@Test
	public void createMatrix2x3ScalarMultiplyPost() {
		IValue value = evaluate("{ { 1, 2, 3 }, { 4, 5.1, 6 } } * 10");
		
		assertTrue(value instanceof IArrayValue);
		IArrayValue arrayValue = (IArrayValue) value;
		
		assertTrue(arrayValue.getDataType() instanceof ArrayType);
		assertTrue(arrayValue.getDataType().getElementType() instanceof RealType);
		assertEquals("Array must have 2 dimensions", 2, arrayValue.getDataType().getDimensionality());
		assertEquals("Row size must be 2", 2, TypeUtil.getArrayRowSize(arrayValue.getDataType()));
		assertEquals("Column size must be 3", 3, TypeUtil.getArrayColumnSize(arrayValue.getDataType()));
		
		assertValueEquals(10.0, arrayValue.get(0, 0), 1e-10);
		assertValueEquals(20.0, arrayValue.get(0, 1), 1e-10);
		assertValueEquals(30.0, arrayValue.get(0, 2), 1e-10);
		assertValueEquals(40.0, arrayValue.get(1, 0), 1e-10);
		assertValueEquals(51.0, arrayValue.get(1, 1), 1e-10);
		assertValueEquals(60.0, arrayValue.get(1, 2), 1e-10);
	}

	private void assertValueEquals(double expected, IValue actual, double delta) {
		assertTrue("Value must be ISimpleNumericValue", actual instanceof ISimpleNumericValue);
		assertEquals(expected, ((ISimpleNumericValue) actual).doubleValue(), delta);
	}
	
//	private void assertValueEquals(long expected, IValue actual) {
//		assertTrue("Value must be ISimpleNumericValue", actual instanceof ISimpleNumericValue);
//		assertEquals(expected, ((ISimpleNumericValue) actual).doubleValue());
//	}

	private IValue evaluate(String expressionString) {
		IStaticEvaluationContext staticEvaluationContext = new StaticEvaluationContext();

		Expression expression = parseExpression(expressionString);
		staticExpressionEvaluator.evaluate(staticEvaluationContext, expression);
		
		return staticEvaluationContext.getValue(expression);
	}
	
	private Expression parseExpression(String expressionString) {
		IParseResult result = parser.parse(grammarAccess.getExpressionRule(), new StringReader(expressionString));
		if (result.hasSyntaxErrors()) {
			throw new RuntimeException("Syntax errors in '" + expressionString + "'");
		}
		return (Expression) result.getRootASTElement();
	}
}
