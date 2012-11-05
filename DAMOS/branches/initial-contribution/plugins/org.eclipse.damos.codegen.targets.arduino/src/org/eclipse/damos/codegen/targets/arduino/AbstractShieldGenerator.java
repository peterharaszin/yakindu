/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger. All rights reserved.
 ****************************************************************************/

package org.eclipse.damos.codegen.targets.arduino;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.damos.codegen.c.IGeneratorContext;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractShieldGenerator implements IShieldGenerator {

	/* (non-Javadoc)
	 * @see org.eclipse.damos.codegen.targets.arduino.IShieldGenerator#generate(org.eclipse.damos.codegen.c.IGeneratorContext, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void generate(IGeneratorContext context, IProgressMonitor monitor) throws CoreException {
	}

}
