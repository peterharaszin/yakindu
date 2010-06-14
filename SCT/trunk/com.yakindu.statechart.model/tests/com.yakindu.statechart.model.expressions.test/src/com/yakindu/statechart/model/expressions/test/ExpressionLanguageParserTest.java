/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package com.yakindu.statechart.model.expressions.test;

import junit.framework.TestCase;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.parser.IParseResult;

import com.yakindu.statechart.model.expressions.JavaExtensions;

public class ExpressionLanguageParserTest extends TestCase {

	public void testTimeTriggerWithTimeConstant() throws RecognitionException {
		// create a debug event listener that builds parse trees
		IParseResult result = JavaExtensions.parseTriggerExpression("after(12s)");
		assertNotNull(result.getRootNode().getElement());
		System.out.println(result.getParseErrors());
		assertTrue(result.getParseErrors().isEmpty());
	}

	public void testSimpleActionWithEventRaising() throws RecognitionException {
		// create a debug event listener that builds parse trees
		IParseResult result = JavaExtensions.parseActionExpression("raise(event1);");
		assertNotNull(result.getRootNode().getElement());
		System.out.println(result.getParseErrors());
		assertTrue(result.getParseErrors().isEmpty());
	}

	public void testSimpleActionExpressionWithVariableAssignment()
			throws RecognitionException {
		IParseResult result = JavaExtensions.parseActionExpression("b = 5;");
		assertNotNull(result.getRootNode().getElement());
		System.out.println(result.getParseErrors());
		assertTrue(result.getParseErrors().isEmpty());
	}

	public void testSimpleActionExpressionWithProcedureCall()
			throws RecognitionException {
		IParseResult result = JavaExtensions.parseActionExpression("doSomething();");
		assertNotNull(result.getRootNode().getElement());
		System.out.println(result.getParseErrors());
		assertTrue(result.getParseErrors().isEmpty());
	}

	public void testSimpleTransitionExpressionWithConditionalVariableAssignmentWithoutNestedExpressions()
			throws RecognitionException {
		IParseResult result = JavaExtensions.parseActionExpression("ped_blinking_rate = ped_blinking_rate >= 1000 ? ped_blinking_rate - 500 : 500;");
		assertNotNull(result.getRootNode().getElement());
		System.out.println(result.getParseErrors());
		assertTrue(result.getParseErrors().isEmpty());
	}

	public void testSimpleTransitionExpressionWithConditionalVariableAssignmentWithNestedExpressions()
			throws RecognitionException {
		IParseResult result = JavaExtensions.parseActionExpression("b += (a < (5 + -8 + 5 * 3) ? (a < 13 ? c : g * 3) : 9);");
		assertNotNull(result.getRootNode().getElement());
		System.out.println(result.getParseErrors());
		assertTrue(result.getParseErrors().isEmpty());
	}

	public void testSimpleGuardExpressionWithConditionsInBrackets()
			throws RecognitionException {
		IParseResult result = JavaExtensions.parseGuardExpression("(a >= 5)");
		assertNotNull(result.getRootNode().getElement());
		System.out.println(result.getParseErrors());
		assertTrue(result.getParseErrors().isEmpty());
	}

	public void testActionExpressionHavingBooleanVariableAssignmentWithConditional()
			throws RecognitionException {
		IParseResult result = JavaExtensions.parseActionExpression("dutch = dutch ? true : false;");
		assertNotNull(result.getRootNode().getElement());
		System.out.println(result.getParseErrors());
		assertTrue(result.getParseErrors().isEmpty());
	}

}
