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
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.AbstractComponentGenerator#writeContextStructCode(java.lang.Appendable, java.lang.String, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void writeContextCode(Appendable appendable, String typeName, IProgressMonitor monitor) throws IOException {
		DataType dataType = getComponentSignature().getOutputDataType(getComponent().getFirstOutputPort());
		String cDataType = MscriptGeneratorUtil.getCDataType(getComputationModel(), getContext().getCodeFragmentCollector(), dataType, null);
		appendable.append("typedef struct {\n").append(cDataType).append(" ").append("data;\n");
		getFastLockGenerator().writeContextCode(appendable, "lock");
		appendable.append("} ").append(typeName).append(";\n");
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.AbstractComponentGenerator#contributesInitializationCode()
	 */
	@Override
	public boolean contributesInitializationCode() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.AbstractComponentGenerator#writeInitializationCode(java.io.Writer, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void writeInitializationCode(Appendable appendable, IProgressMonitor monitor) throws IOException {
		String contextVariable = getVariableAccessor().getContextVariable(false);
		getFastLockGenerator().writeInitializationCode(appendable, contextVariable + "." + "lock");
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.AbstractComponentGenerator#contributesComputeOutputsCode()
	 */
	@Override
	public boolean contributesComputeOutputsCode() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.AbstractComponentGenerator#generateComputeOutputsCode(java.io.Writer, org.eclipselabs.damos.codegen.c.IVariableAccessor, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void writeComputeOutputsCode(Appendable appendable, IProgressMonitor monitor) throws IOException {
		String contextVariable = getVariableAccessor().getContextVariable(false);
		String variableName = contextVariable + "." + "lock";
		String outputVariable = getVariableAccessor().getOutputVariable(getComponent().getFirstOutputPort(), false);

		getFastLockGenerator().writeLockCode(appendable, variableName);
		new Formatter(appendable).format("%s = %s.data;\n", outputVariable, contextVariable);
		getFastLockGenerator().writeUnlockCode(appendable, variableName);
	}
	
	private IFastLockGenerator getFastLockGenerator() {
		return getRuntimeEnvironmentAPI().getFastLockGenerator();
	}
	
}
