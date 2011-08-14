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

import java.io.PrintWriter;
import java.io.Writer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.codegen.c.generator.AbstractComponentGenerator;
import org.eclipselabs.damos.codegen.c.generator.internal.util.InternalGeneratorUtil;

/**
 * @author Andreas Unger
 *
 */
public class LatchGenerator extends AbstractComponentGenerator {

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
	public void writeComputeOutputsCode(Writer writer, IProgressMonitor monitor) throws CoreException {
		PrintWriter printWriter = new PrintWriter(writer);
		printWriter.printf("/* TODO: lock */\n");
		printWriter.printf("%s = %s_data;\n", getVariableAccessor().getOutputVariable(getComponent().getFirstOutputPort(), false), InternalGeneratorUtil.getPrefix(getGenModel(), getNode()) + getComponent().getName());
		printWriter.printf("/* TODO: unlock */\n");
	}
	
}
