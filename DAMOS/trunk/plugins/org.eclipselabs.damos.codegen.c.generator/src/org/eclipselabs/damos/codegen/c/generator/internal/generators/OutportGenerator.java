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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.codegen.c.generator.AbstractComponentGenerator;
import org.eclipselabs.damos.codegen.c.generator.internal.util.InternalGeneratorUtil;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.mscript.codegen.c.util.MscriptGeneratorUtil;
import org.eclipselabs.mscript.common.util.PrintAppendable;

/**
 * @author Andreas Unger
 *
 */
public class OutportGenerator extends AbstractComponentGenerator {

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
	public void writeComputeOutputsCode(Appendable appendable, IProgressMonitor monitor) {
		PrintAppendable out = new PrintAppendable(appendable);

		InputPort inputPort = getComponent().getFirstInputPort();
		OutputPort outputPort = getComponent().getFirstOutputPort();

		out.printf("output->%s = ", InternalGeneratorUtil.uncapitalize(getComponent().getName()));
		String inputVariableString = getVariableAccessor().getInputVariable(inputPort, false);
		MscriptGeneratorUtil.cast(getComputationModel(), appendable, inputVariableString, getComponentSignature().getInputDataType(inputPort), getComponentSignature().getOutputDataType(outputPort));
		out.println(";");
	}
	
}
