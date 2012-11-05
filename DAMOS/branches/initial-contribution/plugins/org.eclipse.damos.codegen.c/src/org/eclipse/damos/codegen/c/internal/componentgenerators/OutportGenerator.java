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

package org.eclipse.damos.codegen.c.internal.componentgenerators;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.damos.codegen.c.AbstractComponentGenerator;
import org.eclipse.damos.common.util.PrintAppendable;
import org.eclipse.damos.dml.InputPort;
import org.eclipse.damos.dml.OutputPort;
import org.eclipse.damos.mscript.codegen.c.util.MscriptGeneratorUtil;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * @author Andreas Unger
 *
 */
public class OutportGenerator extends AbstractComponentGenerator {

	/* (non-Javadoc)
	 * @see org.eclipse.damos.codegen.c.AbstractComponentGenerator#contributesComputeOutputsCode()
	 */
	@Override
	public boolean contributesComputeOutputsCode() {
		if (getNode().getIncomingDataFlows().isEmpty()) {
			return false;
		}
		if (getNode().getIncomingDataFlows().get(0).getSourceEnd().getTargetEnds().size() == 1) {
			return false;
		}
		return true;
	}
	
	@Override
	public CharSequence generateComputeOutputsCode(IProgressMonitor monitor) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);

		InputPort inputPort = getComponent().getFirstInputPort();
		OutputPort outputPort = getComponent().getFirstOutputPort();

		out.printf("output->%s = ", StringExtensions.toFirstLower(getComponent().getName()));
		String inputVariableString = getVariableAccessor().generateInputVariableReference(inputPort, false);
		out.print(MscriptGeneratorUtil.cast(getComputationModel(), inputVariableString, getComponentSignature().getInputDataType(inputPort), getComponentSignature().getOutputDataType(outputPort)));
		out.println(";");
		return sb;
	}
	
}
