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

import java.util.Formatter;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.codegen.c.AbstractComponentGenerator;
import org.eclipselabs.damos.codegen.c.rte.IFastLockGenerator;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.codegen.c.util.MscriptGeneratorUtil;

/**
 * @author Andreas Unger
 *
 */
public class LatchGenerator extends AbstractComponentGenerator {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.AbstractComponentGenerator#contributesContextStructCode()
	 */
	@Override
	public boolean contributesContextCode() {
		return true;
	}
	
	@Override
	public CharSequence generateContextCode(String typeName, IProgressMonitor monitor) {
		StringBuilder sb = new StringBuilder();
		DataType dataType = getComponentSignature().getOutputDataType(getComponent().getFirstOutputPort());
		String cDataType = MscriptGeneratorUtil.getCDataType(getComputationModel(), getContext().getCodeFragmentCollector(), dataType, null);
		sb.append("typedef struct {\n").append(cDataType).append(" ").append("data;\n");
		sb.append(getFastLockGenerator().generateContextCode("lock"));
		sb.append("} ").append(typeName).append(";\n");
		return sb;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.AbstractComponentGenerator#contributesInitializationCode()
	 */
	@Override
	public boolean contributesInitializationCode() {
		return true;
	}
	
	@Override
	public CharSequence generateInitializationCode(IProgressMonitor monitor) {
		String contextVariable = getVariableAccessor().getContextVariable(false);
		return getFastLockGenerator().generateInitializationCode(contextVariable + "." + "lock");
	}
	
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
		String contextVariable = getVariableAccessor().getContextVariable(false);
		String variableName = contextVariable + "." + "lock";
		String outputVariable = getVariableAccessor().getOutputVariable(getComponent().getFirstOutputPort(), false);

		sb.append(getFastLockGenerator().generateLockCode(variableName));
		new Formatter(sb).format("%s = %s.data;\n", outputVariable, contextVariable);
		sb.append(getFastLockGenerator().generateUnlockCode( variableName));
		return sb;
	}
	
	private IFastLockGenerator getFastLockGenerator() {
		return getRuntimeEnvironmentAPI().getFastLockGenerator();
	}
	
}
