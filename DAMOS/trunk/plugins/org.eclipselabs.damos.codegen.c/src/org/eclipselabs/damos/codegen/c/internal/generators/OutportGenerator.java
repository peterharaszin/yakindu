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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.codegen.c.AbstractComponentGenerator;
import org.eclipselabs.damos.codegen.c.internal.util.InternalGeneratorUtil;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.mscript.codegen.c.util.MscriptGeneratorUtil;

/**
 * @author Andreas Unger
 *
 */
public class OutportGenerator extends AbstractComponentGenerator {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.AbstractComponentGenerator#contributesComputeOutputsCode()
	 */
	@Override
	public boolean contributesComputeOutputsCode() {
		return true;
	}
	
	@Override
	public CharSequence generateComputeOutputsCode(IProgressMonitor monitor) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);

		InputPort inputPort = getComponent().getFirstInputPort();
		OutputPort outputPort = getComponent().getFirstOutputPort();

		out.printf("output->%s = ", InternalGeneratorUtil.uncapitalize(getComponent().getName()));
		String inputVariableString = getVariableAccessor().getInputVariable(inputPort, false);
		out.print(MscriptGeneratorUtil.cast(getComputationModel(), inputVariableString, getComponentSignature().getInputDataType(inputPort), getComponentSignature().getOutputDataType(outputPort)));
		out.println(";");
		return sb;
	}
	
}
