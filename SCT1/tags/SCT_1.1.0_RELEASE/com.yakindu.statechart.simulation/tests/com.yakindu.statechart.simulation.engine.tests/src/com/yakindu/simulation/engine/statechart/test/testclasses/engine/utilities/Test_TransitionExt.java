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
package com.yakindu.simulation.engine.statechart.test.testclasses.engine.utilities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Before;
import org.junit.Test;

import statemachine.Node;
import statemachine.Transition;

import com.yakindu.simulation.engine.statechart.engine.utilities.TransitionExt;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ArgumentIsNullException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ParserException;

/**
 * Defines test cases for the class {@link TransitionExt}.
 * 
 * @author Philipp Richter
 */
public class Test_TransitionExt {

	/** The instance of the class <code>TransitionExt</code> which shall be tested. */
	private TransitionExt transition = null;
	
	/** Defines the basic transition of the <code>TransitionExt</code> instance. */
	private Transition basicTrans = null;
	
	/**
	 * Sets up the test environment.
	 */
	@Before
	public void setUp() throws Exception {
		
		basicTrans = new Transition() {

			private Node source = new Node() {
			
				public void eSetDeliver(boolean arg0) {}
				public void eNotify(Notification arg0) {}
				public boolean eDeliver() {return false;}
				public EList<Adapter> eAdapters() {return null;}
				public void eUnset(EStructuralFeature arg0) {}
				public void eSet(EStructuralFeature arg0, Object arg1) {}
				public Resource eResource() {return null;}
				public boolean eIsSet(EStructuralFeature arg0) {return false;}
				public boolean eIsProxy() {return false;}
				public Object eGet(EStructuralFeature arg0, boolean arg1) {return null;}
				public Object eGet(EStructuralFeature arg0) {return null;}
				public EList<EObject> eCrossReferences() {return null;}
				public EList<EObject> eContents() {return null;}
				public EReference eContainmentFeature() {return null;}
				public EStructuralFeature eContainingFeature() {return null;}
				public EObject eContainer() {return null;}
				public EClass eClass() {return null;}
				public TreeIterator<EObject> eAllContents() {return null;}
				public void setName(String value) {}
				public void setId(int value) {}
				public String getName() {return null;}
				public int getId() {return 0;}
			};
			
			private Node target = new Node() {
				
				public void eSetDeliver(boolean arg0) {}
				public void eNotify(Notification arg0) {}
				public boolean eDeliver() {return false;}
				public EList<Adapter> eAdapters() {return null;}
				public void eUnset(EStructuralFeature arg0) {}
				public void eSet(EStructuralFeature arg0, Object arg1) {}
				public Resource eResource() {return null;}
				public boolean eIsSet(EStructuralFeature arg0) {return false;}
				public boolean eIsProxy() {return false;}
				public Object eGet(EStructuralFeature arg0, boolean arg1) {return null;}
				public Object eGet(EStructuralFeature arg0) {return null;}
				public EList<EObject> eCrossReferences() {return null;}
				public EList<EObject> eContents() {return null;}
				public EReference eContainmentFeature() {return null;}
				public EStructuralFeature eContainingFeature() {return null;}
				public EObject eContainer() {return null;}
				public EClass eClass() {return null;}
				public TreeIterator<EObject> eAllContents() {return null;}
				public void setName(String value) {}
				public void setId(int value) {}
				public String getName() {return null;}
				public int getId() {return 0;}
			};
			
			private String expression = "";
			private int priority = 0;
			private int id = 0;
			
			public void eSetDeliver(boolean arg0) {}
			public void eNotify(Notification arg0) {}
			public boolean eDeliver() {	return false; }
			public EList<Adapter> eAdapters() { return null; }
			public void eUnset(EStructuralFeature arg0) {}
			public void eSet(EStructuralFeature arg0, Object arg1) {}
			public Resource eResource() { return null; }
			public boolean eIsSet(EStructuralFeature arg0) { return false; }
			public boolean eIsProxy() { return false; }
			public Object eGet(EStructuralFeature arg0, boolean arg1) { return null; }
			public Object eGet(EStructuralFeature arg0) { return null; }
			public EList<EObject> eCrossReferences() { return null; }
			public EList<EObject> eContents() { return null; }
			public EReference eContainmentFeature() { return null; }
			public EStructuralFeature eContainingFeature() { return null; }
			public EObject eContainer() { return null; }
			public EClass eClass() { return null; }
			public TreeIterator<EObject> eAllContents() { return null; }
			public void setTargetNode(Node value) { target = value; }
			public void setSourceNode(Node value) { source = value; }
			public void setPriority(int value) { priority = value; }
			public void setId(int value) { id = value; }
			public void setExpression(String value) { expression = value; }
			public Node getTargetNode() { return target; }
			public Node getSourceNode() { return source; }
			public int getPriority() { return priority; }
			public int getId() { return id; }
			public String getExpression() { return expression; }
		};
		
		transition = new TransitionExt(basicTrans);
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.utilities.TransitionExt#TransitionExt(statemachine.Transition)}.
	 */
	@Test
	public void testTransitionExt() throws ArgumentIsNullException {
		
		// --- Normal case ---

		transition = new TransitionExt(basicTrans);
		
		// --- Exceptional case ---

		// Basic transition is null
		try {
			transition = new TransitionExt(null);
			fail("The basic transition is \"null\", but no exception is occurred!");
		} catch (ArgumentIsNullException e) {}

		// Source node of the basic transition is null
		try {
			basicTrans.setSourceNode(null);
			transition = new TransitionExt(basicTrans);
			fail("The source state of the basic transition is \"null\", but no exception is occurred!");
		} catch (ArgumentIsNullException e) {}

		// Target node of the basic transition is null
		try {
			basicTrans.setSourceNode(basicTrans.getTargetNode());
			basicTrans.setTargetNode(null);
			transition = new TransitionExt(basicTrans);
			fail("The target state of the basic transition is \"null\", but no exception is occurred!");
		} catch (ArgumentIsNullException e) {}
		
		// The expression of the basic transition is null
		try {
			basicTrans.setExpression(null);
			transition = new TransitionExt(basicTrans);
			fail("The expression of the basic transition is \"null\", but no exception is occurred!");
		} catch (ArgumentIsNullException e) {}
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.utilities.TransitionExt#setProperties()}.
	 */
	@Test
	public void testSetProperties() throws ParserException, ArgumentIsNullException {
		
		// --- Normal case ---

		// Defines test expressions
		String[] expressions = {
			
			"trigger",
			"trigger1, trigger2,\n trigger3",
			"after(5)",
			"after(5ms)",
			"after(5ns)",
			"after(5s)",
			"after(5500ms)",
			"after(1200ms)",
			"[2<3]",
			"[[2<3]]",
			"/var=1",
			"trigger[2<3]",
			"trigger [ 2 < 3 ]",
			"after(2533333445ns), trigger2, trigger3[2<3]",
			"trigger1, trigger2, trigger3 [ 2 < 3 ]",
			"trigger1, trigger2, trigger3[2<(3-2)]/var1=1",
			"trigger1, trigger2, trigger3[2<3] / var = 1",
			"[trigger1,trigger2,trigger3[2<3]/var=1]",
			"[trigger]",	// It is a trigger but it can be a guard, too. The result must be a trigger because no operators are between the squared brackets.
			"[true]",	// It is a guard and not a trigger!
			"[false]",	// It is a guard and not a trigger!
			"[trigger/var=1]",
			"trigger / var = 1",
			"[True]",
			"[FALSE]",
			"[true&&true]",
			"[true||false]",
			"[2<3]/var=1"
		};

		// Defines the number of triggers to each test expression
		int[] numberOfTriggers = {
				
			1,
			3,
			1,
			1,
			1,
			1,
			1,
			1,
			0,
			0,
			0,
			1,
			1,
			3,
			3,
			3,
			3,
			3,
			1,
			0,
			0,
			1,
			1,
			0,
			0,
			0,
			0,
			0
		};
		
		//Defines whether the test expression has a guard or not
		boolean[] guard = {
		
			false,
			false,
			false,
			false,
			false,
			false,
			false,
			false,
			true,
			true,
			false,
			true,
			true,
			true,
			true,
			true,
			true,
			true,
			false,
			true,
			true,
			false,
			false,
			true,
			true,
			true,
			true,
			true
		};

		//Defines whether the test expression has a behavior or not
		boolean[] behaviour = {
				
			false,
			false,
			false,
			false,
			false,
			false,
			false,
			false,
			false,
			false,
			true,
			false,
			false,
			false,
			false,
			true,
			true,
			true,
			false,
			false,
			false,
			true,
			true,
			false,
			false,
			false,
			false,
			true
		};
		
		//Defines whether the test expression can be fired directly ( has no triggers and no guard)
		boolean[] fireDirectly = {
				
			false, 
			false, 
			false, 
			false,
			false,
			false,
			false, 
			false, 
			false, 
			false, 
			true, 
			false, 
			false, 
			false, 
			false, 
			false, 
			false, 
			false, 
			false, 
			false, 
			false, 
			false, 
			false, 
			false, 
			false, 
			false, 
			false, 
			false
		};
		
		for (int ind = 0; ind < expressions.length; ind++) {
			
			basicTrans.setExpression(expressions[ind]);
			
			transition = new TransitionExt(basicTrans);
			
			// Check whether the expression can be parsed
			try {
				transition.setProperties();
			} catch (ParserException e) {
				fail("The method TransitionExt.setProperties() has thrown an exception, but the regular expression is valid (\"" + expressions[ind] + "\"):\n\n" + e);
			}
			
			// Check the number of located triggers
			assertEquals("The number of located triggers is wrong: \"" + expressions[ind] + "\"!", numberOfTriggers[ind], transition.getTriggers().size());
			
			// Check whether an guard was found
			assertEquals("An guard was found but no guard was expected or vice versa: \"" + expressions[ind] + "\"!", guard[ind], transition.getGuard().equals("") ? false : true);

			// Check whether an behavior was found
			assertEquals("An behaviour was found but no behaviour was expected or vice versa: \"" + expressions[ind] + "\"!", behaviour[ind], transition.getBehavior().equals("") ? false : true);
			
			// Check whether the transition can be fired, if the source state is active
			assertEquals("The method fireDirectly() returns the wrong result: \"" + expressions[ind] + "\" -> result: " + fireDirectly[ind] + "!", fireDirectly[ind], transition.fireDirectly());
		}
		
		// --- Exceptional case ---

		// Defines test expressions which are not valid
		expressions = new String[] {
			
			"trigger1, trigger2,/action",
			"after(q5s)",
			"after(5.)",
			"after(.)",
			"after(2), after(3)",
			"after[3]",
			"after{3}",
			"after(2.0.)",
			"after()",
			"after()",
			"after(no)",
			"after(5.0.0)",
			"after(-2)",
			"after(test 4 seconds)",
			"after",
			"trigger, trigger",
			"[2<3",
			"[[2<3",
			"\\var=1",
			"trigger2<3]",
			"trigger [ 2 < 3 ] test",
			"trigger1 trigger2, trigger32<3]",
			"trigger1, trigger2, trigger3[2<3]var1=1[test]",
			"[test]trigger1, trigger2, trigger3[2<3] / var = 1",
			"[[trigger1,trigger2,trigger3[2<3]/var=1]]",
			"trigger]",
			"[true",
			"/",
			"[]",
			"[[[]]]",
			"[[]]",
			"true&&true",
			"{[true||false]}",
			"[2<3/var=1",
			"ß",
			"[ß]",
			"/¥¥",
			"trigger, trigger2,",
			"count=2",
			"[count=2]"
		};
		
		for (int ind = 0; ind < expressions.length; ind++) {
			
			basicTrans.setExpression(expressions[ind]);
			
			transition = new TransitionExt(basicTrans);
			
			// Check whether the expression can be parsed
			try {
				transition.setProperties();
				fail("The regular expression is not valid (\"" + expressions[ind] + "\"), but the method TransitionExt.setProperties() has not thrown an exception!");
			} catch (ParserException e) {
			}
		}
		
		// Test a expression with control characters
		basicTrans.setExpression("\u0000\t\n\r\u000C\u0007\u001B");
		transition = new TransitionExt(basicTrans);
		transition.setProperties();
		
		assertTrue("Not all control characters were be removed from the expression!",
				transition.getTriggers().isEmpty() &&
				transition.getGuard().length() == 0 &&
				transition.getBehavior().length() == 0);
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.utilities.TransitionExt#fireDirectly()}.
	 */
	@Test
	public void testFireDirectly() {
		
		// --- Normal case ---

		//see testSetProperties()
	}

//	/**
//	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.utilities.TransitionExt#sourceStateIsActive()}.
//	 */
//	@Test
//	public void testSourceStateIsActive() throws ArgumentIsNullException, ParserException {
//
//		// --- Normal case ---
//
//		basicTrans.setExpression("after(3)");
//		transition = new TransitionExt(basicTrans, null);
//		
//		transition.setProperties();
//		transition.sourceStateIsActive(System.currentTimeMillis());
//
//		long starttime = System.currentTimeMillis();
//		while(System.currentTimeMillis() - starttime < 50) {
//			Thread.yield();
//		}
//		
//		// Elapsed time is greater than -1
//		assertTrue("The time trigger was not be activated!", transition.getCurrentTime() > -1);
//		
//		// --- Exceptional case ---
//
//		// Time must not be set a second time.
//		transition.sourceStateIsActive(System.currentTimeMillis());
//		
//		// Elapsed time must be greater than 50ms
//		assertTrue("The time trigger could be set a second time (expected elapsed time >= 50, trigger time: " + transition.getCurrentTime() + "!", transition.getCurrentTime() >= 50);
//		
//		transition.pauseTimeTrigger(System.currentTimeMillis());
//		// Time must not be reset, if the time trigger is paused.
//		transition.sourceStateIsActive(System.currentTimeMillis());
//		transition.resumeTimeTrigger(System.currentTimeMillis());
//		
//		// Elapsed time must be greater than 50ms
//		assertTrue("The time trigger was be set if the time trigger was paused (expected elapsed time >= 50, trigger time: " + transition.getCurrentTime() + "!", transition.getCurrentTime() >= 50);
//	}

//	/**
//	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.utilities.TransitionExt#getCurrentTime()}.
//	 */
//	@Test
//	public void testGetCurrentTime() throws ArgumentIsNullException, ParserException {
//		
//		// --- Normal case ---
//
//		basicTrans.setExpression("after(3)");
//		transition = new TransitionExt(basicTrans, null);
//		transition.setProperties();
//		
//		// Time must be -1
//		assertTrue("The time trigger was not activated, but the result is unequal to -1!", transition.getCurrentTime() == -1);
//		
//		transition.sourceStateIsActive(System.currentTimeMillis());
//		
//		long starttime = System.currentTimeMillis();
//		while(System.currentTimeMillis() - starttime < 50) {
//			Thread.yield();
//		}
//		
//		// Elapsed time must be 50ms
//		assertEquals("The time trigger was be activated 50ms ago, but the result is not (circa) 50!", 75.0, Double.valueOf(transition.getCurrentTime()), 25d);
//		
//		transition.pauseTimeTrigger(System.currentTimeMillis());
//		
//		// Elapsed time must be 50ms
//		assertEquals("The time trigger was be activated 50ms ago and paused, but the result is not (circa) 50!", 75.0, Double.valueOf(transition.getCurrentTime()), 25d);
//	}
	
	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.utilities.TransitionExt#getTriggers()}.
	 */
	@Test
	public void testGetTriggers() throws ArgumentIsNullException, ParserException {
		
		// --- Normal case ---
		
		// No trigger
		assertEquals("The transition has no triggers, but the trigger list is not empty!", 0, transition.getTriggers().size());
		
		basicTrans.setExpression("trigger");
		transition = new TransitionExt(basicTrans);
		transition.setProperties();
		
		// One trigger
		assertEquals("The transition has one trigger, but the trigger list has not a length of 1!", 1, transition.getTriggers().size());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.utilities.TransitionExt#hasTrigger(java.lang.String)}.
	 */
	@Test
	public void testHasTrigger() throws ArgumentIsNullException, ParserException {
		
		// --- Normal case ---
		
		// No trigger
		assertFalse("The transition has no trigger, but the result was true!", transition.hasTrigger("doesntexist"));
		
		basicTrans.setExpression("trigger");
		transition = new TransitionExt(basicTrans);
		transition.setProperties();
		
		// One trigger
		assertTrue("The transition has one trigger, but the result was false!", transition.hasTrigger("trigger"));
		
		// --- Exceptional case ---

		// Parameter is null
		assertFalse("The parameter was \"null\", but the result was true!", transition.hasTrigger(null));
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.utilities.TransitionExt#getGuard()}.
	 */
	@Test
	public void testGetGuard() throws ArgumentIsNullException, ParserException {
		
		// --- Normal case ---
		
		// No guard
		assertEquals("The transition has no guard, but the result was not \"\"!", "", transition.getGuard());
		
		basicTrans.setExpression("[count==1]");
		transition = new TransitionExt(basicTrans);
		transition.setProperties();
		
		// Has guard
		assertEquals("The result was not equal to the defined guard!", basicTrans.getExpression(), "[" + transition.getGuard() + "]");
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.utilities.TransitionExt#getBehavior()}.
	 */
	@Test
	public void testGetBehavior() throws ArgumentIsNullException, ParserException {
		
		// --- Normal case ---
		
		// No behavior
		assertEquals("The transition has not a behavior, but the result was not \"\"!", "", transition.getBehavior());
		
		basicTrans.setExpression("/action=1");
		transition = new TransitionExt(basicTrans);
		transition.setProperties();
		
		// Has behavior
		assertEquals("The result was not equal to the defined behavior!", basicTrans.getExpression(), "/" + transition.getBehavior());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.utilities.TransitionExt#getExpression()}.
	 */
	@Test
	public void testGetExpression() throws ArgumentIsNullException, ParserException {
		
		// --- Normal case ---
		
		// No expression
		assertEquals("The transition has no expression, but the result was not \"\"!", "", transition.getExpression());
		
		basicTrans.setExpression("trigger[count==1]/action=1");
		transition = new TransitionExt(basicTrans);
		transition.setProperties();
		
		// Has expression
		assertEquals("The result was not equal to the defined expression!", basicTrans.getExpression(), transition.getExpression());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.utilities.TransitionExt#getPriority()}.  
	 */
	@Test
	public void testGetPriority() throws ArgumentIsNullException, ParserException  {
		
		// --- Normal case ---
		
		assertEquals("The priority is wrong!", 0, transition.getPriority());
		
		basicTrans.setPriority(-1);
		transition = new TransitionExt(basicTrans);
		transition.setProperties();
		
		assertEquals("The priority is wrong!", -1, transition.getPriority());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.utilities.TransitionExt#getSourceNode()}.
	 */
	@Test
	public void testGetSourceNode() {

		// --- Normal case ---
		
		assertEquals("The source state is not the right one!", basicTrans.getSourceNode(), transition.getSourceNode());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.utilities.TransitionExt#getTargetNode()}.
	 */
	@Test
	public void testGetTargetNode() {
		
		// --- Normal case ---
		
		assertEquals("The target state is not the right one!", basicTrans.getTargetNode(), transition.getTargetNode());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.utilities.TransitionExt#getId()}.
	 */
	@Test
	public void testGetId() {

		// --- Normal case ---

		assertEquals("The id of the transition is wrong!", 0, transition.getId());
		
		basicTrans.setId(42);
		
		assertEquals("The id of the transition is wrong!", 42, transition.getId());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.utilities.TransitionExt#getBasicTransition()}.
	 */
	@Test
	public void testGetBasicTransition() {
		
		// --- Normal case ---

		assertEquals("The basic transition instance is not the right one!", basicTrans, transition.getBasicTransition());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.utilities.TransitionExt#isActive()}.
	 */
	@Test
	public void testIsActive() throws ArgumentIsNullException, ParserException {

		// --- Normal case ---

		// Default configuration without a trigger
		assertTrue("The default state of the transition (has no trigger) is wrong. The result is \"false\", but the transition was never disabled.", transition.isActive());
		
		// Default configuration with a trigger
		basicTrans.setExpression("trigger[count==1]/behavior=42");
		transition = new TransitionExt(basicTrans);
		transition.setProperties();
		assertFalse("The default state of the transition (has a trigger) is wrong. The result is \"true\", but the transition was never be activated by a method or a trigger!", transition.isActive());
		
		// Was activated by setActive()
		transition.setActive(true);
		assertTrue("The state of the transition is wrong after it was activated by setActive()!", transition.isActive());
		
//		// Time trigger is running, but not finished
//		basicTrans.setExpression("after(1)");
//		transition = new TransitionExt(basicTrans, null);
//		transition.setProperties();
//		transition.sourceStateIsActive(System.currentTimeMillis());
//		
//		long starttime = System.currentTimeMillis();
//		while(System.currentTimeMillis() - starttime < 50) {
//			Thread.yield();
//		}
//		
//		assertFalse("The time trigger (elapsed time: " + transition.getCurrentTime() + "ms, time trigger duration: 1 second) is not finished, but the result is \"true\"!", transition.isActive());
//		
//		// Time is finished
//		starttime = System.currentTimeMillis();
//		while(System.currentTimeMillis() - starttime < 1000) {
//			Thread.yield();
//		}
//		
//		assertTrue("The time trigger (elapsed time: " + transition.getCurrentTime() + "ms, time trigger duration: 1 second) is finished, but the result is \"false\"!", transition.isActive());
//		
//		// Time trigger is paused!?
//		
//		// Timer is paused and running, but not finished
//		basicTrans.setExpression("after(1)");
//		transition = new TransitionExt(basicTrans, null);
//		transition.setProperties();
//		transition.sourceStateIsActive(System.currentTimeMillis());
//
//		starttime = System.currentTimeMillis();
//		while(System.currentTimeMillis() - starttime < 50) {
//			Thread.yield();
//		}
//		
//		transition.pauseTimeTrigger(System.currentTimeMillis());
//		assertFalse("The time trigger (elapsed time: " + transition.getCurrentTime() + "ms, time trigger duration: 1 second) is not finished, but the result is \"true\"!", transition.isActive());
//		
//		// Timer is paused and finished
//		transition.resumeTimeTrigger(System.currentTimeMillis());
//
//		starttime = System.currentTimeMillis();
//		while(System.currentTimeMillis() - starttime < 1000) {
//			Thread.yield();
//		}
//		transition.pauseTimeTrigger(System.currentTimeMillis());
//		assertTrue("The time trigger (elapsed time: " + transition.getCurrentTime() + "ms, time trigger duration: 1 second) is finished, but the result is \"false\"!", transition.isActive());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.utilities.TransitionExt#setActive(boolean)}.
	 */
	@Test
	public void testSetActive() throws ArgumentIsNullException, ParserException {
		
		// --- Normal case ---
		
		// Was activated
		basicTrans.setExpression("trigger");
		transition = new TransitionExt(basicTrans);
		transition.setProperties();
		transition.setActive(true);
		assertTrue("The transition was be activated, but the method returns \"false\"!", transition.isActive());
		
		// --- Exceptional case ---

//		// starttime and elapsed test
//		basicTrans.setExpression("after(0.4)");
//		transition = new TransitionExt(basicTrans, null);
//		transition.setProperties();
		
//		// Activate the timer
//		transition.sourceStateIsActive(System.currentTimeMillis());
//		// Deactivate the transition (the timer)
//		transition.setActive(false);
//		
//		// Wait for at least 410 milliseconds
//		long starttime = System.currentTimeMillis();
//		while(System.currentTimeMillis() - starttime < 410) {
//			Thread.yield();
//		}
//		
//		// Check if the transition is really not active
//		assertFalse("The transition was deactivated, but the result is \"true\"!", transition.isActive());
	}
	
//	/**
//	 * Tests the time trigger timer whether it wakes up the simulator notify object.
//	 */
//	@Test(timeout=2000)
//	public void testTimer() throws ChangeConfigurationException, PseudostateNotImplemented, Exception {
//		
//		String testfile = Utilities.getFile(Test_TransitionExt.class, "com/yakindu/simulation/engine/statechart/test/resources/changestateconf/TransitionTimer.statemachine");
//
//		// --- Normal case ---
//
//		SCSimulator simulator = new SCSimulator(new TimeEventScheduler());
//		simulator.initializeStatemachine(testfile);
//		
//		// 1. Test the notification and duration of the timer
//		
//		// Activate the first state "State1" after the initial state
//		simulator.changeStateConfiguration();
//		
//		// Nothing is changed
//		simulator.changeStateConfiguration();
//		
//		long start = System.currentTimeMillis();
//		// Because in the last step nothing was changed -> waiting for notification
//		// Activate "State2"
//		simulator.changeStateConfiguration();
//		// Check the time duration, it must be about 200ms
//		double duration = System.currentTimeMillis() - start;
//		assertEquals("The timer has the wrong duration (190 - 240ms are allowed)!", 215d, duration, 25d);
//		
//		// Activate the final state
//		simulator.changeStateConfiguration();
//		
//		// 2. Test whether the paused transition doesn't send a notification
//		
//		Object notifyObj = new Object();
//		basicTrans.setExpression("after(0.2)");
//		transition = new TransitionExt(basicTrans, notifyObj);
//		transition.setProperties();
//		
//		// Check the duration
//		synchronized (notifyObj) {
//			
//			transition.sourceStateIsActive(System.currentTimeMillis());
//			transition.pauseTimeTrigger(System.currentTimeMillis());
//			
//			start = System.currentTimeMillis();
//			
//			// The object must not be notified by the transition, because it is paused
//			notifyObj.wait(300);
//			
//			duration = System.currentTimeMillis() - start;
//		}
//		// The duration must be at least 300ms
//		assertEquals("The transition was paused, but notifies the thread (timer duration was 200ms and the thread waits 300ms after this check is done)!", 310d, duration, 20d);
//		
//		// 3. Check whether the duration of the timer is right, if the transition is paused and is then resumed.
//		
//		transition.setActive(false);
//		
//		// Check the duration
//		synchronized (notifyObj) {
//			
//			// Activate timer
//			transition.sourceStateIsActive(System.currentTimeMillis());
//			// Pause timer
//			transition.pauseTimeTrigger(System.currentTimeMillis());
//			
//			// Wait for 100ms
//			start = System.currentTimeMillis();
//			while(System.currentTimeMillis() - start < 100) {
//				Thread.yield();
//			}
//			
//			// Resume timer
//			transition.resumeTimeTrigger(System.currentTimeMillis());
//			
//			// The object must not be notified by the transition, because it is paused
//			start = System.currentTimeMillis();
//			notifyObj.wait(300);
//			duration = System.currentTimeMillis() - start;
//		}
//		// The duration must be about 200ms
//		assertEquals("The transition was paused and then resumed, but doesn't notify the thread (timer duration: 200ms, pause: 100ms, thread waits 300ms after resume)!", 225d, duration, 30d);
//	}
}