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

package org.eclipse.damos.mscript.codegen.c;

/**
 * @author Andreas Unger
 *
 */
public class CodeFragmentContext implements ICodeFragmentContext {

	private final ICodeFragmentCollector codeFragmentCollector;

	private final IGlobalNameProvider globalNameProvider;
	
	/**
	 * @param codeFragmentCollector
	 * @param globalNameProvider
	 */
	public CodeFragmentContext(ICodeFragmentCollector codeFragmentCollector, IGlobalNameProvider globalNameProvider) {
		this.codeFragmentCollector = codeFragmentCollector;
		this.globalNameProvider = globalNameProvider;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.codegen.c.ICodeFragmentContext#getCodeFragmentCollector()
	 */
	public ICodeFragmentCollector getCodeFragmentCollector() {
		return codeFragmentCollector;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.codegen.c.ICodeFragmentContext#getGlobalNameProvider()
	 */
	public IGlobalNameProvider getGlobalNameProvider() {
		return globalNameProvider;
	}
	
}
