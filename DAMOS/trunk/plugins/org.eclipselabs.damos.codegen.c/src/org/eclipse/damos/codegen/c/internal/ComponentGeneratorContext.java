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

package org.eclipse.damos.codegen.c.internal;

import org.eclipse.damos.codegen.c.IComponentGeneratorContext;
import org.eclipse.damos.codegen.c.IVariableAccessor;
import org.eclipse.damos.dconfig.Configuration;
import org.eclipse.damos.execution.ComponentNode;
import org.eclipse.damos.execution.datatype.IComponentSignature;
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentCollector;

/**
 * @author Andreas Unger
 *
 */
public class ComponentGeneratorContext implements IComponentGeneratorContext {

	private ComponentNode node;
	private IComponentSignature componentSignature;
	private IVariableAccessor variableAccessor;
	private Configuration configuration;
	private ICodeFragmentCollector codeFragmentCollector;
	
	/**
	 * 
	 */
	public ComponentGeneratorContext(ComponentNode node, IComponentSignature componentSignature, IVariableAccessor variableAccessor, Configuration configuration, ICodeFragmentCollector codeFragmentCollector) {
		this.node = node;
		this.componentSignature = componentSignature;
		this.variableAccessor = variableAccessor;
		this.configuration = configuration;
		this.codeFragmentCollector = codeFragmentCollector;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.codegen.c.IComponentGeneratorContext#getNode()
	 */
	public ComponentNode getNode() {
		return node;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.codegen.c.IComponentGeneratorContext#getComponentSignature()
	 */
	public IComponentSignature getComponentSignature() {
		return componentSignature;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.codegen.c.IComponentGeneratorContext#getVariableAccessor()
	 */
	public IVariableAccessor getVariableAccessor() {
		return variableAccessor;
	}

	public Configuration getConfiguration() {
		return configuration;
	}
	
	public ICodeFragmentCollector getCodeFragmentCollector() {
		return codeFragmentCollector;
	}

}
