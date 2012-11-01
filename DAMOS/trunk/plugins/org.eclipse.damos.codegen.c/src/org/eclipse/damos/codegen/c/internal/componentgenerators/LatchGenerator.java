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
import org.eclipse.damos.codegen.c.IGeneratorContext;
import org.eclipse.damos.codegen.c.MscriptGeneratorConfiguration;
import org.eclipse.damos.codegen.c.codefragments.PrimaryCodeFragment;
import org.eclipse.damos.codegen.c.rte.IFastLockGenerator;
import org.eclipse.damos.codegen.c.util.GeneratorConfigurationExtensions;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.codegen.c.DataTypeGenerator;
import org.eclipse.damos.mscript.codegen.c.ICodeFragment;
import org.eclipse.damos.mscript.codegen.c.codefragments.ContextStruct;
import org.eclipse.damos.mscript.codegen.c.codefragments.DeclaredContextStructMember;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class LatchGenerator extends AbstractComponentGenerator {

	@Inject
	private DataTypeGenerator dataTypeGenerator;

	@Override
	public void addContextStructMembers(ContextStruct contextStruct, IProgressMonitor monitor) {
		String prefix = GeneratorConfigurationExtensions.getPrefix(getConfiguration());
		String typeName = prefix + getNode().getComponent().getName() + "_Context";

		ICodeFragment declaration = new ContextStructDeclaration(typeName);
		getContext().getCodeFragmentCollector().addCodeFragment(declaration, monitor);
		
		contextStruct.addMember(new DeclaredContextStructMember(prefix + getNode().getComponent().getName(), typeName, declaration));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.codegen.c.AbstractComponentGenerator#contributesInitializationCode()
	 */
	@Override
	public boolean contributesInitializationCode() {
		return true;
	}
	
	@Override
	public CharSequence generateInitializationCode(IProgressMonitor monitor) {
		CharSequence contextVariable = getVariableAccessor().generateContextVariableReference(false);
		return getFastLockGenerator().generateInitializationCode(contextVariable + "." + "lock");
	}
	
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
		CharSequence contextVariable = getVariableAccessor().generateContextVariableReference(false);
		String variableName = contextVariable + "." + "lock";
		CharSequence outputVariable = getVariableAccessor().generateOutputVariableReference(getComponent().getFirstOutputPort(), false);

		sb.append(getFastLockGenerator().generateLockCode(variableName));
		sb.append(String.format("%s = %s.data;\n", outputVariable, contextVariable));
		sb.append(getFastLockGenerator().generateUnlockCode( variableName));
		return sb;
	}
	
	private IFastLockGenerator getFastLockGenerator() {
		return getRuntimeEnvironmentAPI().getFastLockGenerator();
	}

	private class ContextStructDeclaration extends PrimaryCodeFragment {

		private final String typeName;
	
		/**
		 * @param typeName
		 */
		public ContextStructDeclaration(String typeName) {
			this.typeName = typeName;
		}
	
		@Override
		protected void doInitialize(IGeneratorContext context, IProgressMonitor monitor) {
		}
	
		public CharSequence generateForwardDeclaration(boolean internal) {
			StringBuilder sb = new StringBuilder();
			Type type = getComponentSignature().getOutputDataType(getComponent().getFirstOutputPort());
			sb.append("typedef struct {\n");
			sb.append(dataTypeGenerator.generateDataType(new MscriptGeneratorConfiguration(getComputationModel(), getConfiguration()), "data", getContext().getCodeFragmentCollector(), type, null));
			sb.append(";\n");
			sb.append(getFastLockGenerator().generateContextCode("lock"));
			sb.append("} ").append(typeName).append(";\n");
			return sb;
		}
	}
	
}
