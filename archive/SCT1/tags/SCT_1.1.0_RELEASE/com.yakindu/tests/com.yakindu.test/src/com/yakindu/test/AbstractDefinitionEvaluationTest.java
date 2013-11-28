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

import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.XpandFacade;

public abstract class AbstractDefinitionEvaluationTest extends
		AbstractExecutionTest {

	XpandFacade xpandFacade = null;

	public AbstractDefinitionEvaluationTest() {
		super();
	}

	public XpandFacade getXpandFacade() {
		if(xpandFacade == null){
			xpandFacade = createExpandFacade(getExecutionContext());
		}	
		return xpandFacade;
	}

	@Override
	public final XpandExecutionContextImpl getExecutionContext() {
		return (XpandExecutionContextImpl) super.getExecutionContext();
	}

	public AbstractDefinitionEvaluationTest(String name) {
		super(name);
	}

	protected abstract XpandFacade createExpandFacade(
			XpandExecutionContextImpl executionContext);

}