/**
 * Copyright (c) 2009 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package com.yakindu.simulation.engine.statechart.test.testclasses.engine.utilities.calculation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mda4e.simulation.core.event.IEvent;
import org.mda4e.simulation.core.event.IEventListener;

import com.yakindu.simulation.engine.statechart.engine.utilities.calculation.Parser;
import com.yakindu.simulation.engine.statechart.engine.utilities.calculation.utilities.events.ParserEventFiredEvent;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ArgumentIsNullException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ParserException;

/**
 * Test class to check the functionality of the class {@link Parser}.
 * @author Philipp Richter
 */
public class Test_Parser implements IEventListener {

	/** Defines the instance of the class to test. */
	private Parser parser = null;
	
	/** Defines all test variables. */
	Map<String, Double> varList = null;
	/** Defines all test inputs. */
	Map<String, Double> inputList = null;
	/** Defines all test outputs. */
	Map<String, Double> outputList = null;

	/** Defines the last sent event of the parser. */
	private String event = "";
	
	/**
	 * 
	 */
	@Before
	public void setUp() throws Exception {
		
		parser = new Parser();
		parser.addEventListener(this);
		
		varList = new HashMap<String, Double>();
		inputList = new HashMap<String, Double>();
		outputList = new HashMap<String, Double>();
		
		outputList.put("Waermestrom", 0.0);
		outputList.put("Level", 0.0);
		
		inputList.put("RoomTemp", 333.0);
		
		varList.put("WishTemp", 21.0);
		varList.put("MDot", 800.0);
		varList.put("c", 1005.4);
		varList.put("BurnerTemp", 50.0);
		varList.put("RoomTemp_old", 0.0);
		varList.put("Time", 21.0);
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.utilities.calculation.Parser#Parser()}.
	 */
	@Test
	public void testParser() {
		// see setUp()
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.utilities.calculation.Parser#addEventListener(org.mda4e.simulation.core.event.IEventListener)}.
	 */
	@Test
	public void testAddEventListener() {
		// see setUp()
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.utilities.calculation.Parser#parseExpression(String, String, Map...)}.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testParseExpression() throws ParserException, ArgumentIsNullException {
	
		// --- Normal case ---

		// Test all relational operators
		String[] expressions = {
			
			"2==2",
			"2==3",
			"2!=2",
			"2!=1",
			"2>=3",
			"2>=2",
			"2>=1",
			"2<=3",
			"2<=2",
			"2<=1",
			"2>3",
			"2>2",
			"2>1",
			"2<1",
			"2<2",
			"2<3",
			"2==2&&2==2",
			"2!=2&&2==2",
			"2==2&&2!=2",
			"2!=2&&2!=2",
			"2==2||2==2",
			"2!=2||2==2",
			"2==2||2!=2",
			"2!=2||2!=2"
		};
		
		Boolean[] result = {
		
			true,
			false,
			false,
			true,
			false,
			true,
			true,
			true,
			true,
			false,
			false,
			false,
			true,
			false,
			false,
			true,
			true,
			false,
			false,
			false,
			true,
			true,
			true,
			false
		};
		
		boolean curResult = false;
		
		for(int index = 0; index < expressions.length; index++) {
			
			curResult = parser.parseExpression(expressions[index], "test");
			assertEquals("The result of the expression \"" + expressions[index] + "\" is wrong!", result[index].booleanValue(), curResult);
		}
		
		// complex expressions
		String expression ="[RoomTemp<WishTemp-25 && Time*abs(3.4)>=BurnerTemp*(5-MDot) || c == 5]";
		
		assertFalse("The result of the expression \"" + expression + "\" is wrong!", parser.parseExpression(expression, null, inputList, varList));
		
		expression = "[Time<22 || Time>20+2 && RoomTemp>20+2 && RoomTemp-3>20/2&& RoomTemp>=(WishTemp-0.2)*10]";
		
		assertTrue("The result of the expression \"" + expression + "\" is wrong!", parser.parseExpression(expression, null, inputList, varList));
		
		expression = "[RoomTemp<WishTemp+500 && RoomTemp>=20+2 || 5>=6/11]";
		
		assertTrue("The result of the expression \"" + expression + "\" is wrong!", parser.parseExpression(expression, null, inputList, varList));
		
		expression = "[1<2*2-1 && 5>=6-1]";
		
		assertTrue("The result of the expression \"" + expression + "\" is wrong!", parser.parseExpression(expression, null));
		
		expression = "";
		
		assertTrue("The result of the expression \"" + expression + "\" is wrong!", parser.parseExpression(expression, null));
		
		// --- Exceptional case ---

		// Expression is "null"
		try {
			parser.parseExpression(null, "test", new HashMap<String, Double>());
			fail("The expression is \"null\", but no exception is occurred!");
		} catch (ArgumentIsNullException e) {}
		
		// Source element is "null"
		try {
			// "var" is not defined, so an exception have to be occurred!
			parser.parseExpression("[var==2]", null, varList);
		} catch (ParserException e) {}
		
		// One map is "null"
		try {
			parser.parseExpression("[var==2]", "test", (Map<String, Double>[])null);
		} catch (ParserException e) {}
		
		// The second map is "null"
		try {
			parser.parseExpression("[var==2]", "test", varList, null);
		} catch (ParserException e) {}
		
		// Two maps are "null"
		try {
			parser.parseExpression("[var==2]", "test", varList, null, null);
		} catch (ParserException e) {}
		
		// Variable name is "null"
		varList.put(null, 2.0);
		try {
			parser.parseExpression("[var==2]", "test", varList);
		} catch (ParserException e) {}
		
		// Variable value is "null"
		varList.put("var", null);
		try {
			parser.parseExpression("[var==2]", "test", varList);
			fail("The list contains a variable which value is \"null\", but no exception is occurred!");
		} catch (ParserException e) {}
		
		// Expression is not valid
		try {
			parser.parseExpression("2==2&&", "test");
			fail("The expression is invalid, but no exception is occurred!");
		} catch (ParserException e) {}
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.utilities.calculation.Parser#parseAction(String, String, Map...)}.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testParseAction() throws ParserException, ArgumentIsNullException {
	
		// --- Normal case ---

		// Action 1
		String action = "MDot=300;c=100;Level=1;RoomTemp_old=RoomTemp;"; 

		parser.parseAction(action, null, inputList, outputList, varList);
		
		assertEquals("The variable \"MDot\" was not set correctly!", 300.0, varList.get("MDot").doubleValue(), 0.0);
		assertEquals("The variable \"c\" was not set correctly!", 100.0, varList.get("c").doubleValue(), 0.0);
		assertEquals("The output \"Level\" was not set correctly!", 1.0, outputList.get("Level").doubleValue(), 0.0);
		assertEquals("The variable \"RoomTemp_old\" was not set correctly!", 333.0, varList.get("RoomTemp_old").doubleValue(), 0.0);
		
		// Action 2
		action = "Heatflow=MDot*-c/c*0.5/(-BurnerTemp-RoomTemp*0.3*(50-c))+-55;M=300;"; 
		
		varList.clear();
		inputList.clear();
		outputList.clear();
		
		outputList.put("Heatflow", 0.0);
		outputList.put("M", 0.0);
		
		inputList.put("RoomTemp", 33.0);
		
		varList.put("MDot", 8.0);
		varList.put("c", 10.0);
		varList.put("BurnerTemp", 50.0);
		varList.put("WishTemp", 21.0);
		varList.put("Time", 21.0);
	
		parser.parseAction(action, null, inputList, outputList, varList);
		
		assertEquals("The variable \"M\" was not set correctly!", 300.0, outputList.get("M").doubleValue(), 0.0);
		assertEquals("The variable \"Heatflow\" was not set correctly!", -54.991, outputList.get("Heatflow"), 0.0001);
		
		// Action 3
		action = "Heatflow=((MDot* -c));";
		
		varList.clear();
		inputList.clear();
		outputList.clear();
		
		outputList.put("Heatflow", 0.0);
		outputList.put("M", 0.0);
			
		inputList.put("RoomTemp", 333.0);
		
		varList.put("MDot", 800.0);
		varList.put("c", 1005.4);
		varList.put("BurnerTemp", 50.0);
		varList.put("WishTemp", 21.0);
		varList.put("Time", 21.0);
		
		parser.parseAction(action, null, inputList, outputList, varList);
		
		// --- Exceptional case ---

		// Action is "null"
		parser.parseAction(null, "test", new HashMap<String, Double>());
		
		// Source element is "null"
		try {
			// "var" is not defined, so an exception have to be occurred!
			parser.parseAction("var=3", null, varList);
		} catch (ParserException e) {}
		
		// One map is "null"
		try {
			parser.parseAction("var=3", "test", (Map<String, Double>[])null);
			fail("The list which contains all variable lists is \"null\", but no exception is occurred!");
		} catch (ArgumentIsNullException e) {}
		
		// The second map is "null"
		try {
			parser.parseAction("var=3", "test", varList, null);
			fail("The single variable map is \"null\", but no exception is occurred!");
		} catch (ParserException e) {}
		
		// Two maps are "null"
		try {
			parser.parseAction("var=3", "test", varList, null, null);
		} catch (ParserException e) {}
		
		// Variable name is "null"
		varList.put(null, 2.0);
		try {
			parser.parseAction("var=var+3", "test", varList);
		} catch (ParserException e) {}
		
		// Variable value is "null"
		varList.put("var", null);
		try {
			parser.parseAction("var=var+3", "test", varList);
			fail("The list contains a variable which value is \"null\", but no exception is occurred!");
		} catch (ParserException e) {}
		
		// Action has no target
		try {
			parser.parseAction("=2+3", "test", varList);
			fail("The action has no target, but no exception is occurred!");
		} catch (ParserException e) {}
		try {
			parser.parseAction("2+3", "test", varList);
			fail("The action has no target and no assignment character, but no exception is occurred!");
		} catch (ParserException e) {}
		
		// Has target, but no action part
		varList.put("var", 2.0);
		varList.put("var2", 2.0);
		try {
			parser.parseAction("var", "test", varList);
			fail("The action has a target but no action part, but no exception is occurred!");
		} catch (ParserException e) {}
		try {
			parser.parseAction("var=", "test", varList);
			fail("The action has a target but no action part, but no exception is occurred!");
		} catch (ParserException e) {}
		try {
			parser.parseAction("var=var2=", "test", varList);
			fail("The action has two targets but no action part and no exception is occurred!");
		} catch (ParserException e) {}
		
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.utilities.calculation.Parser#parseFunction(String, String, Map...)}.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testParseFunctionStringStringMap() throws ParserException, ArgumentIsNullException {
		
		// --- Normal case ---

		// For complex functions see testParseExpression()
		
		// ParseFunction 1
		String func = "-1-2";
		assertEquals("The result of the function \"" + func + "\" is wrong!", -3.0, parser.parseFunction(func, null), 0.0);
		
		// ParseFunction 2
		func = "-1--2";
		assertEquals("The result of the function \"" + func + "\" is wrong!", 1.0, parser.parseFunction(func, null), 0.0);
		
		// ParseFunction 3
		func = "-3*-5";				
		assertEquals("The result of the function \"" + func + "\" is wrong!", 15.0, parser.parseFunction(func, null), 0.0);
		
		// ParseFunction 4
		func = "-3+5";
		assertEquals("The result of the function \"" + func + "\" is wrong!", 2.0, parser.parseFunction(func, null), 0.0);
		
		// ParseFunction 5
		func = "2^-2";
		assertEquals("The result of the function \"" + func + "\" is wrong!", 0.25, parser.parseFunction(func, null), 0.0);
			
		// ParseFunction 6
		func = "(-1-1)-2";
		assertEquals("The result of the function \"" + func + "\" is wrong!", -4.0, parser.parseFunction(func, null), 0.0);
		
		// --- Exceptional case ---

		// Function is "null"
		try {
			parser.parseFunction(null, "test", new HashMap<String, Double>());
			fail("The function is \"null\", but no exception is occurred!");
		} catch (ArgumentIsNullException e) {}
		
		// Source element is "null"
		try {
			// "var" is not defined, so an exception have to be occurred!
			parser.parseFunction("var*2*3", null, new HashMap<String, Double>());
		} catch (ParserException e) {}
		
		// One map is "null"
		parser.parseFunction("2*3", "test", varList);
		
		// The second map is "null"
		parser.parseFunction("2*3", "test", varList, null);
		
		// Two maps is "null"
		parser.parseFunction("2*3", "test", varList, null, null);
		
		// Variable name is "null"
		varList.put(null, 2.0);
		try {
			parser.parseFunction("var*2*3", "test", varList);
		} catch (ParserException e) {}
		
		// Variable value is "null"
		varList.put("var", null);
		try {
			parser.parseFunction("var*2*3", "test", varList);
			fail("The list contains a variable which value is \"null\", but no exception is occurred!");
		} catch (ParserException e) {}
		
		// Function is empty ("")
		try {
			parser.parseFunction("", "test", varList);
			fail("The function is empty, but no exception is occurred!");
		} catch (ParserException e) {}
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.utilities.calculation.Parser#parseFunction(java.lang.String, java.lang.String, java.lang.String, double)}.
	 */
	@Test
	public void testParseFunctionStringStringStringDouble() throws ParserException, ArgumentIsNullException {
		
		// --- Normal case ---

		String function = "var*4-4";
		Double varValue = 5.0;
		
		assertEquals("The result of the function \"" + function + "\" is wrong!", 16.0, parser.parseFunction(function, "test", "var", varValue), 0.0);
		
		// --- Exceptional case ---

		// Function is "null"
		try {
			parser.parseFunction(null, "test", "var", 5.0);
			fail("The function is \"null\", but no exception is occurred!");
		} catch (ArgumentIsNullException e) {}
		
		// Source element is "null"
		try {
			// "var" is not defined, so an exception have to be occurred!
			parser.parseFunction("var*3", null, "var", 5.0);
		} catch (ArgumentIsNullException e) {}
		
		// Variable is "null"
		// "null" is allowed
		parser.parseFunction("2*3", "test", null, 5.0);
		
		// Function is empty ("")
		try {
			parser.parseFunction("", "test", "var", 2.0);
			fail("The function is empty, but no exception is occurred!");
		} catch (ParserException e) {}
	}

	/**
	 * Tests all methods with different wrong functions.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testInvalidFunctions() throws ArgumentIsNullException {
		
		String[] invalidFunctions = {
			
			// Parenthesis
			"(2*3+(2+)",
			"2(2-1)",
			
			// Negative sign
			"-+2+2",
			"--2+2",
			"2+2+-",
			"2+2*--",
			"2+--2",
			"2-/2",
			
			// Power
			"2-^2",
			"2^",
			"2^+",
			
			// Wrong operators
			"2%2",
			"3°2",
			"1=1",
			"2~2",
			
			// Mathematical functions
			"ln(2*)",
			"ln()",
			"log(-)",
			"2*abs(2*(3+3)"
		};
		
		varList.put("var", 0.0);
		
		for(String function : invalidFunctions) {
			
			try {
				parser.parseFunction(function, "test");
			} catch (ParserException e) {}
			
			try {
				parser.parseAction("var=" + function, "test", varList);
			} catch (ParserException e) {}
			
			try {
				parser.parseAction("var==" + function, "test", varList);
			} catch (ParserException e) {}
			
		}
	}
	
	/**
	 * Tests the parser processing of valid and invalid definitions of the function "send()".
	 */
	@Test
	public void testSend() throws ParserException, ArgumentIsNullException {
		
		// --- Normal case ---

		String action = "send(event)";
		parser.parseAction(action, "test");
		assertEquals("The event \"event\" was not fired by the parser!", "event", this.event);
		
		action = "send(e)";
		parser.parseAction(action, "test");
		assertEquals("The event \"event\" was not fired by the parser!", "e", this.event);
		
		// --- Exceptional case ---

		// An empty event is not allowed
		action = "send()";
		try {
			parser.parseAction(action, "test");
		} catch (ParserException e) {}
	}
	
	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.utilities.calculation.Parser#isExternalChanged()}. 
	 */
	@Test
	public void testIsExternalChanged() throws ParserException, ArgumentIsNullException {
		
		// --- Normal case ---

		String action = "RoomTemp=21;"; 

		parser.parseAction(action, null, inputList);
		
		assertTrue("An input was changed during the processing of an action, but the method isExternalChanged() returns \"false\"!", parser.isExternalChanged());
		
		parser.resetExternalChanged();
		
		assertFalse("An input was changed during the processing of an action. After this the resetExternalChanged() was called, but the method isExternalChanged() returns \"true\"!", parser.isExternalChanged());
	}
	
	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.utilities.calculation.Parser#resetExternalChanged()}.
	 */
	@Test
	public void testResetExternalChanged() {
	
		// --- Normal case ---

		assertFalse("No method of the parser was called, but the method isExternalChanged() returns \"true\"!", parser.isExternalChanged());
	}
	
	/* (non-Javadoc)
	 * @see org.mda4e.simulation.core.event.IEventListener#receiveEvent(org.mda4e.simulation.core.event.IEvent)
	 */
	public void receiveEvent(IEvent event) {
		
		if(event instanceof ParserEventFiredEvent) {
			
			this.event = (String) event.getSource();
		}
	}
}