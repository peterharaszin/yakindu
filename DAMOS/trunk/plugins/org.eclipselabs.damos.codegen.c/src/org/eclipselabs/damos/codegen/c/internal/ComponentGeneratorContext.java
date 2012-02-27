/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.codegen.c.internal;

import org.eclipselabs.damos.codegen.c.IComponentGeneratorContext;
import org.eclipselabs.damos.codegen.c.IVariableAccessor;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.execution.core.IComponentSignature;
import org.eclipselabs.damos.execution.executionflow.ComponentNode;

/**
 * @author Andreas Unger
 *
 */
public class ComponentGeneratorContext implements IComponentGeneratorContext {

	private ComponentNode node;
	private IComponentSignature componentSignature;
	private IVariableAccessor variableAccessor;
	private Configuration configuration;
	
	/**
	 * 
	 */
	public ComponentGeneratorContext(ComponentNode node, IComponentSignature componentSignature, IVariableAccessor variableAccessor, Configuration configuration) {
		this.node = node;
		this.componentSignature = componentSignature;
		this.variableAccessor = variableAccessor;
		this.configuration = configuration;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.IComponentGeneratorContext#getNode()
	 */
	public ComponentNode getNode() {
		return node;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.IComponentGeneratorContext#getComponentSignature()
	 */
	public IComponentSignature getComponentSignature() {
		return componentSignature;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.IComponentGeneratorContext#getVariableAccessor()
	 */
	public IVariableAccessor getVariableAccessor() {
		return variableAccessor;
	}

	public Configuration getConfiguration() {
		return configuration;
	}

}
