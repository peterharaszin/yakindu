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

package org.eclipselabs.damos.codegen.c;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.codegen.c.rte.IRuntimeEnvironmentAPI;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationUtil;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.execution.datatype.IComponentSignature;
import org.eclipselabs.damos.mscript.codegen.c.Include;
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
	 * @see org.eclipselabs.damos.codegen.c.IComponentGenerator#initialize()
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
	 * @see org.eclipselabs.damos.codegen.c.IComponentGenerator#contributesContextCode()
	 */
	public boolean contributesContextCode() {
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.IComponentGenerator#getContextCodeIncludes()
	 */
	public Collection<Include> getContextCodeIncludes() {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.IComponentGenerator#getContextTypeName()
	 */
	public String getContextTypeName() {
		return null;
	}
	
	public void writeContextCode(Appendable appendable, String typeName, IProgressMonitor monitor) throws IOException {
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.IComponentGenerator#contributesInitializationCode()
	 */
	public boolean contributesInitializationCode() {
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.IComponentGenerator#getInitializationCodeIncludes()
	 */
	public Collection<Include> getInitializationCodeIncludes() {
		return getImplementationIncludes();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.IComponentGenerator#generateInitializationCode(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void writeInitializationCode(Appendable appendable, IProgressMonitor monitor) throws IOException {
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.IComponentGenerator#contributesComputeOutputsCode()
	 */
	public boolean contributesComputeOutputsCode() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.IComponentGenerator#getComputeOutputsCodeIncludes()
	 */
	public Collection<Include> getComputeOutputsCodeIncludes() {
		return getImplementationIncludes();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.IComponentGenerator#generateComputeOutputsCode(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void writeComputeOutputsCode(Appendable appendable, IProgressMonitor monitor) throws IOException {
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.IComponentGenerator#contributesUpdateCode()
	 */
	public boolean contributesUpdateCode() {
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.IComponentGenerator#getUpdateCodeIncludes()
	 */
	public Collection<Include> getUpdateCodeIncludes() {
		return getImplementationIncludes();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.IComponentGenerator#generateUpdateCode(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void writeUpdateCode(Appendable appendable, IProgressMonitor monitor) throws IOException {
	}
	
	protected Collection<Include> getImplementationIncludes() {
		return null;
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

	protected final Configuration getConfiguration() {
		return context.getConfiguration();
	}
	
	protected final ComputationModel getComputationModel() {
		if (cachedComputationModel == null) {
			cachedComputationModel = getConfiguration().getComputationModel(getNode().getSystemPath());
			if (cachedComputationModel == null) {
				cachedComputationModel = ComputationModelUtil.constructDefaultComputationModel();
			}
		}
		return cachedComputationModel;
	}
	
	protected final IRuntimeEnvironmentAPI getRuntimeEnvironmentAPI() {
		if (cachedRuntimeEnvironmentAPI == null) {
			cachedRuntimeEnvironmentAPI = GeneratorConfigurationUtil.getRuntimeEnvironmentAPI(getConfiguration());
		}
		return cachedRuntimeEnvironmentAPI;
	}

}
