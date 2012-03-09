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

package org.eclipselabs.damos.codegen.c.internal;

import org.eclipselabs.damos.codegen.c.IGeneratorContext;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.execution.executionflow.ExecutionFlow;

/**
 * @author Andreas Unger
 *
 */
public class GeneratorContext implements IGeneratorContext {

	private final Configuration configuration;
	private final ExecutionFlow executionFlow;
	
	/**
	 * 
	 */
	public GeneratorContext(Configuration configuration, ExecutionFlow executionFlow) {
		this.configuration = configuration;
		this.executionFlow = executionFlow;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.IGeneratorContext#getConfiguration()
	 */
	public Configuration getConfiguration() {
		return configuration;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.IGeneratorContext#getExecutionFlow()
	 */
	public ExecutionFlow getExecutionFlow() {
		return executionFlow;
	}

}
