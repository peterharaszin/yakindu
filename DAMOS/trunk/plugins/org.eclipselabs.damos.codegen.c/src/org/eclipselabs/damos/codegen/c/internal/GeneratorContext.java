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

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.codegen.c.IGeneratorContext;
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationExtensions;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.execution.ExecutionFlow;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext;
import org.eclipselabs.damos.mscript.codegen.c.IGlobalNameProvider;

/**
 * @author Andreas Unger
 *
 */
public class GeneratorContext implements IGeneratorContext, ICodeFragmentContext, IGlobalNameProvider {

	private final Configuration configuration;
	private final ExecutionFlow executionFlow;
	private final Map<ICodeFragment, ICodeFragment> codeFragments = new LinkedHashMap<ICodeFragment, ICodeFragment>();
	
	private final Set<String> globalNames = new HashSet<String>();
	private final String prefix;
	
	/**
	 * 
	 */
	public GeneratorContext(Configuration configuration, ExecutionFlow executionFlow) {
		this.configuration = configuration;
		this.executionFlow = executionFlow;
		this.prefix = GeneratorConfigurationExtensions.getPrefix(configuration);
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
	 * @see org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext#getCodeFragmentCollector()
	 */
	public ICodeFragmentCollector getCodeFragmentCollector() {
		return this;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext#getGlobalNameProvider()
	 */
	public IGlobalNameProvider getGlobalNameProvider() {
		return this;
	}
	
	public ICodeFragment addCodeFragment(ICodeFragment codeFragment, IProgressMonitor monitor) {
		ICodeFragment existing = codeFragments.get(codeFragment);
		if (existing != null) {
			return existing;
		}
		codeFragment.initialize(this, monitor);
		codeFragments.put(codeFragment, codeFragment);
		return codeFragment;
	}
	
	public Collection<ICodeFragment> getCodeFragments() {
		return codeFragments.keySet();
	}
	
	public String newGlobalName(String preferredName) {
		preferredName = prefix + preferredName;
		String name = preferredName;
		int i = 2;
		while (!globalNames.add(name)) {
			name = preferredName + i++;
		}
		return name;
	}
		
}
