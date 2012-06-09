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

package org.eclipselabs.damos.codegen.c.codefragments;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.codegen.c.IGeneratorContext;
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext;

/**
 * @author Andreas Unger
 *
 */
public abstract class PrimaryCodeFragment extends AbstractCodeFragment {

	/**
	 * Initializes this code fragment. The passed context must be an instance of {@link IGeneratorContext}.
	 * 
	 * @param context
	 * @param monitor
	 * @throws IllegalArgumentException if context is not an instance of {@link IGeneratorContext}
	 * @see AbstractCodeFragment#initialize(ICodeFragmentContext, IProgressMonitor)
	 */
	@Override
	public final void initialize(ICodeFragmentContext context, IProgressMonitor monitor) {
		if (!(context instanceof IGeneratorContext)) {
			throw new IllegalArgumentException("Context must be instanceof " + IGeneratorContext.class.getCanonicalName());
		}
		doInitialize((IGeneratorContext) context, monitor);
	}
	
	protected abstract void doInitialize(IGeneratorContext context, IProgressMonitor monitor);
	
}
