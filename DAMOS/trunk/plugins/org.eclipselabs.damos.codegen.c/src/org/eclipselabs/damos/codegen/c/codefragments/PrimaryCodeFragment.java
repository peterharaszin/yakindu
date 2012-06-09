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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.codegen.c.IGeneratorContext;
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment;

/**
 * @author Andreas Unger
 *
 */
public abstract class PrimaryCodeFragment extends AbstractCodeFragment {

	@Override
	public final void initialize(IAdaptable context, IProgressMonitor monitor) {
		IGeneratorContext generatorContext = (IGeneratorContext) context.getAdapter(IGeneratorContext.class);
		if (generatorContext == null) {
			throw new IllegalArgumentException("Context argument must be adaptable to " + IGeneratorContext.class.getCanonicalName());
		}
		doInitialize(generatorContext, monitor);
	}
	
	protected abstract void doInitialize(IGeneratorContext context, IProgressMonitor monitor);
	
}
