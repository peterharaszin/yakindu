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

package org.eclipselabs.damos.codegen.c.internal.generators;

import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.codegen.c.AbstractComponentGenerator;
import org.eclipselabs.damos.codegen.c.internal.util.CompoundGeneratorUtil;
import org.eclipselabs.damos.codegen.c.internal.util.InternalGeneratorUtil;
import org.eclipselabs.damos.common.util.PrintAppendable;

/**
 * @author Andreas Unger
 *
 */
public class MemoryGenerator extends AbstractComponentGenerator {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.AbstractComponentGenerator#contributesComputeOutputsCode()
	 */
	@Override
	public boolean contributesComputeOutputsCode() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.AbstractComponentGenerator#writeComputeOutputsCode(java.lang.Appendable, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void writeComputeOutputsCode(Appendable appendable, IProgressMonitor monitor) throws IOException {
		PrintAppendable out = new PrintAppendable(appendable);
		String previousValueVariableName = CompoundGeneratorUtil.getMemoryPreviousValueVariableName(getConfiguration(), getNode());
		String outputVariableName = InternalGeneratorUtil.getOutputVariableName(getConfiguration(), getNode(), getComponent().getFirstOutputPort());
		out.printf("%s = %s;\n", outputVariableName, previousValueVariableName);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.AbstractComponentGenerator#contributesUpdateCode()
	 */
	@Override
	public boolean contributesUpdateCode() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.AbstractComponentGenerator#writeUpdateCode(java.lang.Appendable, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void writeUpdateCode(Appendable appendable, IProgressMonitor monitor) throws IOException {
		PrintAppendable out = new PrintAppendable(appendable);
		String previousValueVariableName = CompoundGeneratorUtil.getMemoryPreviousValueVariableName(getConfiguration(), getNode());
		String incomingVariableName = InternalGeneratorUtil.getIncomingVariableName(getConfiguration(), getNode(), getComponent().getInputPorts().get(1));
		out.printf("%s = %s;\n", previousValueVariableName, incomingVariableName);
	}
	
}
