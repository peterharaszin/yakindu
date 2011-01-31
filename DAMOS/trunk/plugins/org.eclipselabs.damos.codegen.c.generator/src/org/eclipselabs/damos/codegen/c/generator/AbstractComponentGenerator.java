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

package org.eclipselabs.damos.codegen.c.generator;

import java.io.Writer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.codegen.c.cgenmodel.GenModel;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.execution.engine.IComponentSignature;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModel;
import org.eclipselabs.mscript.computation.computationmodel.ComputationModel;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractComponentGenerator implements IComponentGenerator {

	private IGeneratorContext context;
	private Component component;
	private IComponentSignature signature;
	
	/**
	 * @return the context
	 */
	public IGeneratorContext getContext() {
		return context;
	}
	
	/**
	 * @param context the context to set
	 */
	public void setContext(IGeneratorContext context) {
		this.context = context;
	}
	
	/**
	 * @return the component
	 */
	public Component getComponent() {
		return component;
	}
	
	/**
	 * @param component the component to set
	 */
	public void setComponent(Component component) {
		this.component = component;
	}
	
	/**
	 * @return the signature
	 */
	public IComponentSignature getSignature() {
		return signature;
	}
	
	/**
	 * @param signature the signature to set
	 */
	public void setSignature(IComponentSignature signature) {
		this.signature = signature;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.IComponentGenerator#initialize()
	 */
	public void initialize() throws CoreException {
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.IComponentGenerator#contributesContextCode()
	 */
	public boolean contributesContextCode() {
		return false;
	}
	
	public void generateContextCode(Writer writer, String typeName, IProgressMonitor monitor) throws CoreException {
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.IComponentGenerator#contributesInitializationCode()
	 */
	public boolean contributesInitializationCode() {
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.IComponentGenerator#generateInitializationCode(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void generateInitializationCode(Writer writer, IVariableAccessor variableAccessor, IProgressMonitor monitor) throws CoreException {
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.IComponentGenerator#contributesComputeOutputsCode()
	 */
	public boolean contributesComputeOutputsCode() {
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.IComponentGenerator#generateComputeOutputsCode(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void generateComputeOutputsCode(Writer writer, IVariableAccessor variableAccessor, IProgressMonitor monitor) throws CoreException {
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.IComponentGenerator#contributesUpdateCode()
	 */
	public boolean contributesUpdateCode() {
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.IComponentGenerator#generateUpdateCode(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void generateUpdateCode(Writer writer, IVariableAccessor variableAccessor, IProgressMonitor monitor) throws CoreException {
	}
	
	protected final GenModel getGenModel() {
		return getContext().getGenModel();
	}
	
	protected final ExecutionModel getExecutionModel() {
		return getGenModel().getExecutionModel();
	}
	
	protected final ComputationModel getComputationModel() {
		return getExecutionModel().getComputationModel();
	}

}
