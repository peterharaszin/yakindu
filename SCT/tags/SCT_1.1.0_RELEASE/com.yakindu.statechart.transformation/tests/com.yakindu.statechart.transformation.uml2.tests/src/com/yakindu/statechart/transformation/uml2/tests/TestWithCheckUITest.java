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
package com.yakindu.statechart.transformation.uml2.tests;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.mwe.core.WorkflowInterruptedException;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.eclipse.emf.mwe.core.issues.MWEDiagnostic;
import org.eclipse.emf.mwe.utils.Reader;
import org.eclipse.emf.mwe.utils.SingleGlobalResourceSet;
import org.eclipse.uml2.uml.Model;
import org.eclipse.xtend.XtendFacade;
import org.eclipse.xtend.check.CheckFacade;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.ExecutionContextImpl;
import org.eclipse.xtend.expression.ExpressionFacade;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;
import org.eclipse.xtend.typesystem.uml2.Setup;
import org.eclipse.xtend.typesystem.uml2.UML2MetaModel;

import com.yakindu.test.AbstractExpressionEvaluationTest;

import statemachine.StatemachinePackage;


public class TestWithCheckUITest extends AbstractExpressionEvaluationTest {
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

	public void testTransformation() {

		Issues issues = new IssuesImpl();

		new Setup().setStandardUML2Setup(true);

		Model uml2 = (Model) Reader
				.load(
						SingleGlobalResourceSet.get(),
						"platform:/plugin/com.yakindu.statechart.transformation.uml2.tests/model/PedestrianTrafficLightGER.uml",
						true);

		// call extend
		List<?> statecharts = (List<?>) getXtendFacade().call("transform",
				uml2);

		ExpressionFacade f = new ExpressionFacade(getExecutionContext());
		Map<String, Object> ctx = new HashMap<String, Object>();
		ctx.put("statecharts", statecharts);
		Collection<?> model = (Collection<?>) f.evaluate(
				"statecharts.eAllContents.union( {statecharts} )", ctx);
		if (model == null) {
			model = Collections.EMPTY_SET;
		}


		CheckFacade.checkAll(
				"com/yakindu/statechart/transformation/uml2/tests/modelTest",
				model, getExecutionContext(), issues, false);
		if (issues.hasErrors()) {
			EObject eobj;
			for (MWEDiagnostic issue : issues.getErrors()) {
				eobj = (EObject) issue.getElement();
				if (eobj != null) {
					System.err.println(eobj.eClass().getName() + ": "
							+ issue.getMessage());
				} else {
					System.err.println(issue.getMessage());
				}
			}
			throw new WorkflowInterruptedException("Test failed");
		}
	}
}
