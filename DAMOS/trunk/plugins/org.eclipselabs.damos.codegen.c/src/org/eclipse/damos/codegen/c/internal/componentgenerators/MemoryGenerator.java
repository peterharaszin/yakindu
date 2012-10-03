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

package org.eclipse.damos.codegen.c.internal.componentgenerators;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.damos.codegen.c.AbstractComponentGenerator;
import org.eclipse.damos.codegen.c.internal.VariableAccessor;
import org.eclipse.damos.codegen.c.internal.util.CompoundGeneratorUtil;
import org.eclipse.damos.codegen.c.util.GeneratorUtil;
import org.eclipse.damos.common.util.PrintAppendable;

/**
 * @author Andreas Unger
 *
 */
public class MemoryGenerator extends AbstractComponentGenerator {

	/* (non-Javadoc)
	 * @see org.eclipse.damos.codegen.c.AbstractComponentGenerator#contributesComputeOutputsCode()
	 */
	@Override
	public boolean contributesComputeOutputsCode() {
		return true;
	}
	
	@Override
	public CharSequence generateComputeOutputsCode(IProgressMonitor monitor) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		String previousValueVariableName = CompoundGeneratorUtil.getMemoryPreviousValueVariableName(getConfiguration(), getNode());
		String outputVariableName = new VariableAccessor(getConfiguration(), getNode()).generateOutputVariableReference(getComponent().getFirstOutputPort(), false);
		out.printf("%s = %s;\n", outputVariableName, previousValueVariableName);
		return sb;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.codegen.c.AbstractComponentGenerator#contributesUpdateCode()
	 */
	@Override
	public boolean contributesUpdateCode() {
		return true;
	}
	
	@Override
	public CharSequence generateUpdateCode(IProgressMonitor monitor) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		String previousValueVariableName = CompoundGeneratorUtil.getMemoryPreviousValueVariableName(getConfiguration(), getNode());
		String incomingVariableName = GeneratorUtil.getIncomingVariableName(getConfiguration(), getNode(), getComponent().getInputPorts().get(1));
		out.printf("%s = %s;\n", previousValueVariableName, incomingVariableName);
		return sb;
	}
	
}
