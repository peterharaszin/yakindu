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

package org.eclipselabs.damos.codegen.c.generator.internal;

import org.eclipselabs.damos.codegen.c.cgenmodel.GenModel;
import org.eclipselabs.damos.codegen.c.generator.IComponentGeneratorContext;
import org.eclipselabs.damos.codegen.c.generator.IVariableAccessor;
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
	private GenModel genModel;
	
	/**
	 * 
	 */
	public ComponentGeneratorContext(ComponentNode node, IComponentSignature componentSignature, IVariableAccessor variableAccessor, GenModel genModel) {
		this.node = node;
		this.componentSignature = componentSignature;
		this.variableAccessor = variableAccessor;
		this.genModel = genModel;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.IComponentGeneratorContext#getNode()
	 */
	public ComponentNode getNode() {
		return node;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.IComponentGeneratorContext#getComponentSignature()
	 */
	public IComponentSignature getComponentSignature() {
		return componentSignature;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.IComponentGeneratorContext#getVariableAccessor()
	 */
	public IVariableAccessor getVariableAccessor() {
		return variableAccessor;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.IComponentGeneratorContext#getGenModel()
	 */
	public GenModel getGenModel() {
		return genModel;
	}

}
