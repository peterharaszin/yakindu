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

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedHashSet;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipselabs.damos.codegen.c.IGeneratorContext;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.execution.ExecutionFlow;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;

/**
 * @author Andreas Unger
 *
 */
public class GeneratorContext extends PlatformObject implements IGeneratorContext {

	private final Configuration configuration;
	private final ExecutionFlow executionFlow;
	private final Collection<ICodeFragment> codeFragments = new LinkedHashSet<ICodeFragment>();
	
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
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector#addCodeFragment(org.eclipselabs.damos.mscript.codegen.c.ICodeFragment, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void addCodeFragment(ICodeFragment codeFragment, IProgressMonitor monitor) {
		if (codeFragments.add(codeFragment)) {
			try {
				codeFragment.initialize(this, monitor);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Collection<ICodeFragment> getCodeFragments() {
		return codeFragments;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.PlatformObject#getAdapter(java.lang.Class)
	 */
	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if (adapter == ICodeFragmentCollector.class || adapter == IGeneratorContext.class) {
			return this;
		}
		return super.getAdapter(adapter);
	}

}
