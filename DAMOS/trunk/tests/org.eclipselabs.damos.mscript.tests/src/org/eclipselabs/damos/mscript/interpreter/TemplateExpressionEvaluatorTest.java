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

import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.StringValue;
import org.junit.Test;

/**
 * @author Andreas Unger
 *
 */
public class TemplateExpressionEvaluatorTest extends AbstractExpressionEvaluatorTest {

	private static final String Q = "\"\"\"";
	private static final String GL = "\u00ab";
	private static final String GR = "\u00bb";
	
	@Test
	public void empty() {
		IValue value = evaluateQuoted("");
		
		assertStringEquals("", value);
	}

	@Test
	public void whiteSpaceOnly() {
		IValue value = evaluateQuoted(" \t   \t ");
		
		assertStringEquals(" \t   \t ", value);
	}

	@Test
	public void whiteSpaceOnlyMultiLine() {
		IValue value = evaluateQuoted("\t\t\n\t\t  \n\t\t\t  \n\t\t  \n\t");
		
		assertStringEquals("\t\t  \n\t\t\t  \n\t\t  \n", value);
	}

	@Test
	public void constantTemplateSegment() {
		IValue value = evaluateQuoted("hello");
		
		assertStringEquals("hello", value);
	}
	
	@Test
	public void expressionTemplateSegment() {
		IValue value = evaluateQuoted(GL + "\"hel\" + \"lo\"" + GR);
		
		assertStringEquals("hello", value);
	}

	@Test
	public void constantExpressionConstantTemplateSegment() {
		IValue value = evaluateQuoted("prefix" + GL + "\"hel\" + \"lo\"" + GR + "suffix");
		
		assertStringEquals("prefixhellosuffix", value);
	}

	@Test
	public void constantExpressionConstantTemplateSegmentWithNewLine() {
		IValue value = evaluateQuoted("prefix" + GL + "\"hel\" + \"lo\n\"" + GR + "suffix");
		
		assertStringEquals("prefixhello\nsuffix", value);
	}

	@Test
	public void expressionConstantExpressionTemplateSegment() {
		IValue value = evaluateQuoted(GL + "\"prefix\"" + GR + "hello" + GL + "\"suffix\"" + GR);
		
		assertStringEquals("prefixhellosuffix", value);
	}

	@Test
	public void constantTemplateSegmentIgnoreFirstNewLine() {
		IValue value = evaluateQuoted("\nhello");
		
		assertStringEquals("hello", value);
	}

	@Test
	public void expressionTemplateSegmentIgnoreFirstNewLine() {
		IValue value = evaluateQuoted("\n" + GL + "\"hel\" + \"lo\"" + GR);
		
		assertStringEquals("hello", value);
	}

	@Test
	public void constantTemplateSegmentIgnoreFirstNewLineWithTabs() {
		IValue value = evaluateQuoted("\t \n\t\thello");
		
		assertStringEquals("hello", value);
	}

	@Test
	public void expressionTemplateSegmentIgnoreFirstNewLineWithTabs() {
		IValue value = evaluateQuoted("\t \n\t\t" + GL + "\"hel\" + \"lo\"" + GR);
		
		assertStringEquals("hello", value);
	}

	@Test
	public void constantTemplateSegmentDoNotIgnoreFirstNewLineWithTabs() {
		IValue value = evaluateQuoted("\tX\n\t\thello");
		
		assertStringEquals("\tX\n\t\thello", value);
	}

	@Test
	public void expressionTemplateSegmentDoNotIgnoreFirstNewLineWithTabs() {
		IValue value = evaluateQuoted("\tX\n\t\t" + GL + "\"hel\" + \"lo\"" + GR);
		
		assertStringEquals("\tX\n\t\thello", value);
	}

	@Test
	public void constantTemplateSegmentIgnoreLastWhiteSpaces() {
		IValue value = evaluateQuoted("\n\t\thello\n\t");
		
		assertStringEquals("hello\n", value);
	}

	@Test
	public void expressionTemplateSegmentIgnoreLastWhiteSpaces() {
		IValue value = evaluateQuoted("\n\t\t" + GL + "\"hel\" + \"lo\"" + GR + "\n\t");
		
		assertStringEquals("hello\n", value);
	}

	@Test
	public void constantTemplateSegmentDoNotIgnoreLastWhiteSpaces() {
		IValue value = evaluateQuoted("\n\t\thello\n\tX");
		
		assertStringEquals("\thello\nX", value);
	}

	@Test
	public void expressionTemplateSegmentDoNotIgnoreLastWhiteSpaces() {
		IValue value = evaluateQuoted("\n\t\t" + GL + "\"hel\" + \"lo\"" + GR + "\n\tX");
		
		assertStringEquals("\thello\nX", value);
	}

	@Test
	public void constantExpressionConstantTemplateSegmentMultiLine() {
		IValue value = evaluateQuoted("\n\t\tprefix\n\t" + GL + "\"hel\" + \"lo\"" + GR + "\n\t\tsuffix\n\t");
		
		assertStringEquals("\tprefix\nhello\n\tsuffix\n", value);
	}

	@Test
	public void expressionConstantExpressionTemplateSegmentMultiLine() {
		IValue value = evaluateQuoted("\n\t\t" + GL + "\"prefix\"" + GR + "\n\thello\n\t\t" + GL + "\"suffix\"" + GR + "\n\t");
		
		assertStringEquals("\tprefix\nhello\n\tsuffix\n", value);
	}

	@Test
	public void constantExpressionConstantTemplateSegmentMultiLineWithNewLine() {
		IValue value = evaluateQuoted("\n\t\tprefix\n\t" + GL + "\"hel\" + \"lo\n\"" + GR + "\n\t\tsuffix\n\t");
		
		assertStringEquals("\tprefix\nhello\n\tsuffix\n", value);
	}

	@Test
	public void constantExpressionConstantTemplateSegmentMultiLineWithDoubleNewLine() {
		IValue value = evaluateQuoted("\n\tprefix\n\t\t" + GL + "\"hel\" + \"lo\n\n\"" + GR + "\n\tsuffix\n\t");
		
		assertStringEquals("prefix\n\thello\n\t\nsuffix\n", value);
	}

	@Test
	public void constantExpressionConstantTemplateSegmentMultiLineWithMultiIndentation() {
		IValue value = evaluateQuoted("\n\tprefix\n\t\t" + GL + "\"hel\" + \"lo\n\t, world\n\"" + GR + "\n\tsuffix\n\t");
		
		assertStringEquals("prefix\n\thello\n\t\t, world\nsuffix\n", value);
	}

	private void assertStringEquals(String expected, IValue actual) {
		assertTrue("Result must be string", actual instanceof StringValue);
		assertEquals(expected, actual.toString());
	}
	
	private IValue evaluateQuoted(String expressionString) {
		return evaluate(Q + expressionString + Q);
	}
	
}
