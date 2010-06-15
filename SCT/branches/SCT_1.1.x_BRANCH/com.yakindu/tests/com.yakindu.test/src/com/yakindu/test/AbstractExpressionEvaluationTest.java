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
package com.yakindu.test;

import org.eclipse.xtend.XtendFacade;
import org.eclipse.xtend.expression.ExecutionContext;

public abstract class AbstractExpressionEvaluationTest extends
		AbstractExecutionTest {

	private XtendFacade xtendFacade;

	public AbstractExpressionEvaluationTest() {
		super();
	}

	public AbstractExpressionEvaluationTest(String name) {
		super(name);
	}

	/**
	 * Hook method to create an XtendFacade.
	 * 
	 * @param executionContext
	 *            The ExecutionContext to parameterize the newly created
	 *            XtendFacade with.
	 * @return The newly created XtendFacade.
	 */
	protected abstract XtendFacade createXtendFacade(
			ExecutionContext executionContext);

	/**
	 * Return the lazily created XtendFacade.
	 * 
	 * @return
	 */
	public XtendFacade getXtendFacade() {
		if (xtendFacade == null) {
			xtendFacade = createXtendFacade(getExecutionContext());
		}
		return xtendFacade;
	}

}