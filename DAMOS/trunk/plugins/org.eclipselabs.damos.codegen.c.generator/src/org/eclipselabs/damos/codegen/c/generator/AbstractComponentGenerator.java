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

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.codegen.c.cgenmodel.GenModel;
import org.eclipselabs.damos.codegen.c.generator.internal.registry.RuntimeEnvironmentAPIRegistry;
import org.eclipselabs.damos.codegen.c.generator.rte.IRuntimeEnvironmentAPI;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.execution.core.IComponentSignature;
import org.eclipselabs.damos.execution.executionflow.ComponentNode;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModel;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;
import org.eclipselabs.damos.mscript.computationmodel.util.ComputationModelUtil;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractComponentGenerator implements IComponentGenerator {

	private IComponentGeneratorContext context;
	
	private ComputationModel cachedComputationModel;
	
	private IRuntimeEnvironmentAPI cachedRuntimeEnvironmentAPI;

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.IComponentGenerator#initialize()
	 */
	public void initialize(IComponentGeneratorContext context, IProgressMonitor monitor) throws CoreException {
		this.context = context;
		initialize(monitor);
	}
	
	protected void initialize(IProgressMonitor monitor) throws CoreException {
	}
	
	/**
	 * @return the context
	 */
	public IComponentGeneratorContext getContext() {
		return context;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.IComponentGenerator#contributesContextCode()
	 */
	public boolean contributesContextCode() {
		return false;
	}
	
	public void writeContextCode(Appendable appendable, String typeName, IProgressMonitor monitor) throws IOException {
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
	public void writeInitializationCode(Appendable appendable, IProgressMonitor monitor) throws IOException {
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
	public void writeComputeOutputsCode(Appendable appendable, IProgressMonitor monitor) throws IOException {
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
	public void writeUpdateCode(Appendable appendable, IProgressMonitor monitor) throws IOException {
	}
	
	protected final ComponentNode getNode() {
		return context.getNode();
	}

	protected Component getComponent() {
		return getNode().getComponent();
	}

	protected final IComponentSignature getComponentSignature() {
		return context.getComponentSignature();
	}
	
	protected final IVariableAccessor getVariableAccessor() {
		return context.getVariableAccessor();
	}

	protected final GenModel getGenModel() {
		return context.getGenModel();
	}
	
	protected final ExecutionModel getExecutionModel() {
		return getGenModel().getExecutionModel();
	}
	
	protected final ComputationModel getComputationModel() {
		if (cachedComputationModel == null) {
			cachedComputationModel = getExecutionModel().getComputationModel(getComponent().getOwningFragment());
			if (cachedComputationModel == null) {
				cachedComputationModel = ComputationModelUtil.constructDefaultComputationModel();
			}
		}
		return cachedComputationModel;
	}
	
	protected final IRuntimeEnvironmentAPI getRuntimeEnvironmentAPI() {
		if (cachedRuntimeEnvironmentAPI == null) {
			String runtimeEnvironmentId = getExecutionModel().getRuntimeEnvironmentId();
			if (runtimeEnvironmentId != null) {
				cachedRuntimeEnvironmentAPI = RuntimeEnvironmentAPIRegistry.getInstance().getRuntimeEnvironmentAPI(runtimeEnvironmentId);
			}
		}
		return cachedRuntimeEnvironmentAPI;
	}

}
