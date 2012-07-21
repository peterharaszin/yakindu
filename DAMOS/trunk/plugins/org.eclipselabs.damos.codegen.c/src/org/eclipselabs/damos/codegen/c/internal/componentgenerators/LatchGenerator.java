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

package org.eclipselabs.damos.codegen.c.internal.componentgenerators;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.codegen.c.AbstractComponentGenerator;
import org.eclipselabs.damos.codegen.c.MscriptGeneratorConfiguration;
import org.eclipselabs.damos.codegen.c.rte.IFastLockGenerator;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.codegen.c.DataTypeGenerator;

/**
 * @author Andreas Unger
 *
 */
public class LatchGenerator extends AbstractComponentGenerator {

	private final DataTypeGenerator dataTypeGenerator = new DataTypeGenerator();
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.AbstractComponentGenerator#contributesContextStructCode()
	 */
	@Override
	public boolean contributesContextCode() {
		return true;
	}
	
	@Override
	public CharSequence generateContextCode(CharSequence typeName, IProgressMonitor monitor) {
		StringBuilder sb = new StringBuilder();
		DataType dataType = getComponentSignature().getOutputDataType(getComponent().getFirstOutputPort());
		sb.append("typedef struct {\n");
		sb.append(dataTypeGenerator.generateDataType(new MscriptGeneratorConfiguration(getComputationModel(), getConfiguration()), "data", getContext().getCodeFragmentCollector(), dataType, null));
		sb.append(";\n");
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
		String contextVariable = getVariableAccessor().generateContextVariableReference(false);
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
		String contextVariable = getVariableAccessor().generateContextVariableReference(false);
		String variableName = contextVariable + "." + "lock";
		String outputVariable = getVariableAccessor().generateOutputVariableReference(getComponent().getFirstOutputPort(), false);

		sb.append(getFastLockGenerator().generateLockCode(variableName));
		sb.append(String.format("%s = %s.data;\n", outputVariable, contextVariable));
		sb.append(getFastLockGenerator().generateUnlockCode( variableName));
		return sb;
	}
	
	private IFastLockGenerator getFastLockGenerator() {
		return getRuntimeEnvironmentAPI().getFastLockGenerator();
	}
	
}
