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
/**
 * 
 */
package com.yakindu.statechart.transformation.uml2.tests;

import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.FinalState;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.TimeEvent;
import org.eclipse.uml2.uml.TimeExpression;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.xtend.XtendFacade;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.ExecutionContextImpl;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;
import org.eclipse.xtend.typesystem.uml2.UML2MetaModel;
import junit.framework.Assert;

import com.yakindu.test.AbstractExpressionEvaluationTest;

import statemachine.PseudoTypes;
import statemachine.StatemachineFactory;
import statemachine.StatemachinePackage;

/**
 * @author dschmidt
 * 
 */

/*
 * Because of http://www.jetbrains.net/jira/browse/IDEA-16466 you cannot use any
 * JUnit 4 annotation in your test classes!
 */
public class TestExtendCoreTest extends AbstractExpressionEvaluationTest {

	@Override
	protected XtendFacade createXtendFacade(ExecutionContext executionContext) {
		return XtendFacade.create(executionContext,
				"com::yakindu::statechart::transformation::uml2::m2m");
	}

	@Override
	protected ExecutionContextImpl createExecutionContext() {
		ExecutionContextImpl executionContext = new ExecutionContextImpl();

		// register the meta model
		EmfMetaModel statemachineMetamodel = new EmfMetaModel();
		statemachineMetamodel.setMetaModelPackage(StatemachinePackage.class
				.getName());
		executionContext.registerMetaModel(statemachineMetamodel);
		executionContext.registerMetaModel(new UML2MetaModel());

		return executionContext;
	}

	public void testMapping() {
		// call extend
		PseudoTypes pt = (PseudoTypes) getXtendFacade().call("mapUml2State",
				PseudostateKind.INITIAL_LITERAL);
		Assert.assertEquals("Transformation is wrong", PseudoTypes.INITIAL, pt);
	}

	public void testCreatePseudoState() {
		Pseudostate ps = UMLFactory.eINSTANCE.createPseudostate();
		ps.setKind(PseudostateKind.INITIAL_LITERAL);

		statemachine.Pseudostate expected = StatemachineFactory.eINSTANCE
				.createPseudostate();
		expected.setPseudoType(PseudoTypes.INITIAL);

		statemachine.Region r = StatemachineFactory.eINSTANCE.createRegion();

		// call extend
		statemachine.Pseudostate result = (statemachine.Pseudostate) getXtendFacade()
				.call("createPseudostate", ps, r);
		Assert.assertEquals(expected.getPseudoType(), result.getPseudoType());
	}

	public void testCreateFinalState() {
		FinalState fs = UMLFactory.eINSTANCE.createFinalState();
		fs.setName("FinalState-Test");
		fs.setEntry(UMLFactory.eINSTANCE.createActivity());
		fs.getEntry().setName("Entry-Test");
		fs.setDoActivity(UMLFactory.eINSTANCE.createActivity());
		fs.getDoActivity().setName("DoActivity-Test");
		fs.setExit(UMLFactory.eINSTANCE.createActivity());
		fs.getExit().setName("Exit-Test");

		statemachine.FinalState expected = StatemachineFactory.eINSTANCE
				.createFinalState();
		expected.setName("FinalState-Test");
		expected.setEntry("Entry-Test");
		expected.setDo("DoActivity-Test");
		expected.setExit("Exit-Test");

		statemachine.Region r = StatemachineFactory.eINSTANCE.createRegion();

		// call extend
		statemachine.FinalState result = (statemachine.FinalState) getXtendFacade()
				.call("createState", fs, r);

		Assert.assertEquals(expected.getName(), result.getName());
		Assert.assertEquals(expected.getEntry(), result.getEntry());
		Assert.assertEquals(expected.getDo(), result.getDo());
		Assert.assertEquals(expected.getExit(), result.getExit());
	}

	public void testCreateState() {
		FinalState fs = UMLFactory.eINSTANCE.createFinalState();
		fs.setName("FinalState-Test");
		fs.setEntry(UMLFactory.eINSTANCE.createActivity());
		fs.getEntry().setName("Entry-Test");
		fs.setDoActivity(UMLFactory.eINSTANCE.createActivity());
		fs.getDoActivity().setName("DoActivity-Test");
		fs.setExit(UMLFactory.eINSTANCE.createActivity());
		fs.getExit().setName("Exit-Test");

		statemachine.FinalState expected = StatemachineFactory.eINSTANCE
				.createFinalState();
		expected.setName("FinalState-Test");
		expected.setEntry("Entry-Test");
		expected.setDo("DoActivity-Test");
		expected.setExit("Exit-Test");

		statemachine.Region r = StatemachineFactory.eINSTANCE.createRegion();

		// call extend
		statemachine.FinalState result = (statemachine.FinalState) getXtendFacade()
				.call("createState", fs, r);

		Assert.assertEquals(expected.getName(), result.getName());
		Assert.assertEquals(expected.getEntry(), result.getEntry());
		Assert.assertEquals(expected.getDo(), result.getDo());
		Assert.assertEquals(expected.getExit(), result.getExit());
	}

	public void testParseSignalEvent() {
		SignalEvent se = UMLFactory.eINSTANCE.createSignalEvent();
		Signal s = UMLFactory.eINSTANCE.createSignal();
		s.setName("Signal-Test");
		se.setSignal(s);

		String expected = "Signal-Test";

		String result = (String) getXtendFacade().call("parseEvent", se);

		Assert.assertEquals(expected, result);
	}

	public void testParseCallEvent() {
		CallEvent ce = UMLFactory.eINSTANCE.createCallEvent();
		ce.setOperation(UMLFactory.eINSTANCE.createOperation());
		ce.getOperation().setName("test");

		String expected = "test()";

		String result = (String) getXtendFacade().call("parseEvent", ce);

		Assert.assertEquals(expected, result);
	}

	public void testParseTimeEvent() {
		TimeEvent te = UMLFactory.eINSTANCE.createTimeEvent();
		OpaqueExpression oe = UMLFactory.eINSTANCE.createOpaqueExpression();
		oe.getBodies().add("15s");
		TimeExpression texpr = UMLFactory.eINSTANCE.createTimeExpression();
		texpr.setExpr(oe);
		te.setWhen(texpr);
		te.setIsRelative(true);

		String expected = "after(15s)";

		String result = (String) getXtendFacade().call("parseEvent", te);

		Assert.assertEquals(expected, result);
	}

	public void testCreateTransition() {
		State s1 = UMLFactory.eINSTANCE.createState();
		s1.setName("Node1");
		State s2 = UMLFactory.eINSTANCE.createState();
		s2.setName("Node2");
		statemachine.Region r = StatemachineFactory.eINSTANCE.createRegion();

		Transition t = UMLFactory.eINSTANCE.createTransition();
		t.setSource(s1);
		t.setTarget(s2);
		t.setGuard(UMLFactory.eINSTANCE.createConstraint());
		OpaqueExpression oe = UMLFactory.eINSTANCE.createOpaqueExpression();
		oe.getBodies().add("test1 > test2");
		t.getGuard().setSpecification(oe);

		OpaqueBehavior ob = UMLFactory.eINSTANCE.createOpaqueBehavior();
		ob.setName("test");
		t.setEffect(ob);

		TimeEvent te = UMLFactory.eINSTANCE.createTimeEvent();
		oe = UMLFactory.eINSTANCE.createOpaqueExpression();
		oe.getBodies().add("10s");
		TimeExpression texpr = UMLFactory.eINSTANCE.createTimeExpression();
		texpr.setExpr(oe);
		te.setWhen(texpr);
		te.setIsRelative(true);

		Trigger trigger = UMLFactory.eINSTANCE.createTrigger();
		trigger.setEvent(te);

		t.getTriggers().add(trigger);

		getXtendFacade().call("createState", s1, r);
		getXtendFacade().call("createState", s2, r);

		statemachine.Transition result = (statemachine.Transition) getXtendFacade()
				.call("createTransition", t);

		Assert.assertEquals("after(10s) [test1 > test2] /test", result
				.getExpression());
		Assert.assertEquals("Node1", result.getSourceNode().getName());
		Assert.assertEquals("Node2", result.getTargetNode().getName());
	}

	public void testCreateRegion() {
		Region r = UMLFactory.eINSTANCE.createRegion();
		r.setName("TestRegion");
			
		//TODO: test profile "Statechart Extension" here

		/*statemachine.Region result = (statemachine.Region) getXtendFacade()
				.call("createRegion", r);

		Assert.assertEquals(result.getPriority(), 1);*/
	}
}
