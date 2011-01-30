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

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.codegen.c.generator.AbstractComponentGenerator;
import org.eclipselabs.damos.codegen.c.generator.IVariableAccessor;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.mscript.codegen.c.MscriptGeneratorContext;
import org.eclipselabs.mscript.codegen.c.util.MscriptGeneratorUtil;

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
	public void generateComputeOutputsCode(Writer writer, IVariableAccessor variableAccessor, IProgressMonitor monitor) throws CoreException {
		PrintWriter printWriter = new PrintWriter(writer);

		InputPort inputPort = getComponent().getFirstInputPort();
		OutputPort outputPort = getComponent().getFirstOutputPort();

		MscriptGeneratorContext mscriptGeneratorContext = new MscriptGeneratorContext(getComputationModel(), writer);

		printWriter.printf("output->%s = ", StringUtils.uncapitalize(getComponent().getName()));
		String inputVariableString = variableAccessor.getInputVariable(inputPort, false);
		MscriptGeneratorUtil.cast(mscriptGeneratorContext, inputVariableString, getSignature().getInputDataType(inputPort), getSignature().getOutputDataType(outputPort));
		printWriter.println(";");
	}
	
}
