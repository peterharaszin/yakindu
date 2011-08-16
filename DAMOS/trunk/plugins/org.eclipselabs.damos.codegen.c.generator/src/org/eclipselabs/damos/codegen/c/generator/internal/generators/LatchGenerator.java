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

package org.eclipselabs.damos.codegen.c.generator.internal.generators;

import java.io.IOException;
import java.util.Formatter;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.codegen.c.generator.AbstractComponentGenerator;
import org.eclipselabs.damos.codegen.c.generator.internal.util.InternalGeneratorUtil;

/**
 * @author Andreas Unger
 *
 */
public class LatchGenerator extends AbstractComponentGenerator {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.AbstractComponentGenerator#contributesInitializationCode()
	 */
	@Override
	public boolean contributesInitializationCode() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.AbstractComponentGenerator#writeInitializationCode(java.io.Writer, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void writeInitializationCode(Appendable appendable, IProgressMonitor monitor) throws IOException {
		String prefix = InternalGeneratorUtil.getPrefix(getGenModel(), getNode()) + getComponent().getName() + "_";
		getRuntimeEnvironmentAPI().writeLatchDataInitializeLock(appendable, prefix);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.AbstractComponentGenerator#contributesComputeOutputsCode()
	 */
	@Override
	public boolean contributesComputeOutputsCode() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.AbstractComponentGenerator#generateComputeOutputsCode(java.io.Writer, org.eclipselabs.damos.codegen.c.generator.IVariableAccessor, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void writeComputeOutputsCode(Appendable appendable, IProgressMonitor monitor) throws IOException {
		String prefix = InternalGeneratorUtil.getPrefix(getGenModel(), getNode()) + getComponent().getName() + "_";
		getRuntimeEnvironmentAPI().writeLatchDataLock(appendable, prefix);
		new Formatter(appendable).format("%s = %sdata;\n", getVariableAccessor().getOutputVariable(getComponent().getFirstOutputPort(), false), prefix);
		getRuntimeEnvironmentAPI().writeLatchDataUnlock(appendable, prefix);
	}
	
}
