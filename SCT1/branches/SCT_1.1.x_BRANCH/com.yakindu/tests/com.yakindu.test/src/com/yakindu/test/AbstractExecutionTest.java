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

import junit.framework.TestCase;

import org.eclipse.xtend.expression.ExecutionContextImpl;

public abstract class AbstractExecutionTest extends TestCase {

	private ExecutionContextImpl executionContext;

	public AbstractExecutionTest() {
		super();
	}

	public AbstractExecutionTest(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	/**
	 * Hook method to create an ExecutionContext. The client should at least
	 * register the required meta-model.
	 * 
	 * @return
	 */
	protected abstract ExecutionContextImpl createExecutionContext();
	
	/**
	 * Return the lazily created ExecutionContextImpl.
	 * @return
	 */
	public ExecutionContextImpl getExecutionContext() {
		if(executionContext == null){
			executionContext = createExecutionContext();
		}
		return executionContext;
	}

}