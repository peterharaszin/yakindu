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

import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.mwe.utils.Reader;
import org.eclipse.emf.mwe.utils.SingleGlobalResourceSet;
import org.eclipse.uml2.uml.Model;
import org.eclipse.xtend.XtendFacade;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.ExecutionContextImpl;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;
import org.eclipse.xtend.typesystem.uml2.Setup;
import org.eclipse.xtend.typesystem.uml2.UML2MetaModel;

import com.yakindu.test.AbstractExpressionEvaluationTest;

import statemachine.Node;
import statemachine.PseudoTypes;
import statemachine.Pseudostate;
import statemachine.State;
import statemachine.Statechart;
import statemachine.StatemachinePackage;
import statemachine.Transition;

/**
 * @author dschmidt
 * 
 */
public class TestWithJavaUITest extends AbstractExpressionEvaluationTest {

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

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	private List<Statechart> transformModel() {
		new Setup().setStandardUML2Setup(true);

		Model uml2 = (Model) Reader
				.load(
						SingleGlobalResourceSet.get(),
						"platform:/plugin/com.yakindu.statechart.transformation.uml2.tests/model/PedestrianTrafficLightGER.uml",
						true);

		// call extend
		return (List<Statechart>) getXtendFacade().call("transform", uml2);
	}

	public void testTransformation() {
		List<Statechart> statecharts = transformModel();
		assertTrue(statecharts != null && statecharts.size() == 1);

		Statechart statechart = statecharts.iterator().next();
		checkName(statechart);
		checkStates(statechart);
		checkTransitions(statechart);
		checkPriorities(statechart);
	}

	private void checkName(Statechart statechart) {
		// check Name
		assertEquals("Name of Statechart wrong", "PedestrianTrafficLightGER",
				statechart.getName());
	}

	public void checkPriorities(Statechart statechart) {
		// TODO: need to check priority here
		/*
		 * EObject element; for (TreeIterator<EObject> iter =
		 * statechart.eAllContents(); iter .hasNext();) { element = iter.next();
		 * if (element instanceof Region) {
		 * Assert.assertEquals("Priority must be 0", 0, ((Region) element)
		 * .getPriority()); } }
		 */
	}

	private void checkStates(Statechart statechart) {
		EObject element;
		State state;
		for (TreeIterator<EObject> iter = statechart.eAllContents(); iter
				.hasNext();) {
			element = iter.next();
			if (element instanceof State) {
				state = (State) element;
				if (state.getName().equals("On")) {
					Assert.assertEquals("Entry of State 'On' is wrong",
							"red=green=warning=0;", state.getEntry());
					Assert.assertEquals("State 'On' does not have 4 states", 4,
							state.getRegion().get(0).getState().size());
					Node node;
					State state2;
					for (Iterator<Node> iter2 = state.getRegion().get(0)
							.getState().iterator(); iter2.hasNext();) {
						node = iter2.next();
						if (node instanceof State) {
							state2 = (State) node;
							if (state2.getName().equals("Blocked")) {
								Assert.assertEquals(
										"Entry of State 'Blocked' is wrong",
										"red=blocked=1;unblocked=0;", state2
												.getEntry());
							}
							if (state2.getName().equals("Wait")) {
								Assert.assertEquals(
										"Entry of State 'Wait' is wrong",
										"wait=1;", state2.getEntry());
								Assert.assertEquals(
										"Exit of State 'Wait' is wrong",
										"red=0; wait=0;", state2.getExit());
							}
							if (state2.getName().equals("Unblocked")) {
								Assert.assertEquals(
										"Entry of State 'Unblocked' is wrong",
										"green=unblocked=1;blocked=0;", state2
												.getEntry());
								Assert.assertEquals(
										"Exit of State 'Unblocked' is wrong",
										"green=0;", state2.getExit());
							}
						}
					}
				}
				if (state.getName().equals("Off")) {
					Assert.assertEquals("Entry of State 'Unblocked' is wrong",
							"red=green=warning=0;off=1;", state.getEntry());
					Assert.assertEquals("Exit of State 'Unblocked' is wrong",
							"off=0;", state.getExit());
				}
			}
		}
	}

	private void checkTransitions(Statechart statechart) {
		EObject element;
		Transition transition;
		for (TreeIterator<EObject> iter = statechart.eAllContents(); iter
				.hasNext();) {
			element = iter.next();
			if (element instanceof Transition) {
				transition = (Transition) element;
				if (transition.getSourceNode() instanceof Pseudostate
						&& ((Pseudostate) transition.getSourceNode())
								.getPseudoType().equals(PseudoTypes.INITIAL)
						&& transition.getTargetNode().getName().equals(
								"Blocked")) {
					// okay, it does exist
				} else if (transition.getSourceNode() instanceof Pseudostate
						&& ((Pseudostate) transition.getSourceNode())
								.getPseudoType().equals(PseudoTypes.INITIAL)
						&& transition.getTargetNode().getName().equals("Off")) {
					// okay, it does exist
				} else if (transition.getSourceNode().getName().equals(
						"Blocked")
						&& transition.getTargetNode().getName().equals("Wait")) {
					Assert.assertEquals(transition.getExpression(),
							"ev_pedestrianRequest");
				} else if (transition.getSourceNode().getName().equals("Wait")
						&& transition.getTargetNode().getName().equals(
								"Unblocked")) {
					Assert.assertEquals(transition.getExpression(),
							"ev_unblock");
				} else if (transition.getSourceNode().getName().equals(
						"Unblocked")
						&& transition.getTargetNode().getName().equals(
								"Blocked")) {
					Assert.assertEquals(transition.getExpression(), "ev_block");
				} else if (transition.getSourceNode().getName().equals("On")
						&& transition.getTargetNode().getName().equals("Off")) {
					Assert.assertEquals(transition.getExpression(), "ev_off");
				} else if (transition.getSourceNode().getName().equals("Off")
						&& transition.getTargetNode().getName().equals("On")) {
					Assert.assertEquals(transition.getExpression(), "ev_on");
				} else {
					// should never get here
					Assert.fail("Error in Transitions");
				}
			}
		}
	}
}
