/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger. All rights reserved.
 ****************************************************************************/

package org.eclipselabs.damos.codegen.targets.arduino;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.codegen.c.IGeneratorContext;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractShieldGenerator implements IShieldGenerator {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.targets.arduino.IShieldGenerator#generate(org.eclipselabs.damos.codegen.c.IGeneratorContext, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void generate(IGeneratorContext context, IProgressMonitor monitor) throws CoreException {
	}

}
