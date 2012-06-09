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

package org.eclipselabs.damos.mscript.codegen.c.codefragments;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext;
import org.eclipselabs.damos.mscript.codegen.c.IGlobalNameProvider;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineArrayType;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;

/**
 * @author Andreas Unger
 *
 */
public class ArrayTypeDeclaration extends AbstractCodeFragment {

	private final ComputationModel computationModel;
	private final MachineArrayType arrayType;

	private String elementTypeString;
	private String name;
	
	/**
	 * 
	 */
	public ArrayTypeDeclaration(ComputationModel computationModel, MachineArrayType arrayType) {
		this.computationModel = computationModel;
		this.arrayType = arrayType;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	@Override
	public void initialize(ICodeFragmentContext context, IProgressMonitor monitor) {
		elementTypeString = arrayType.getElementType().getCDataType(computationModel, context.getCodeFragmentCollector(), this);
		
		IGlobalNameProvider globalNameProvider = context.getGlobalNameProvider();
		name = globalNameProvider.newGlobalName("Array");
	}
	
	public CharSequence generateForwardDeclaration(boolean internal) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		out.printf("typedef struct { %s data[%d]; } %s;\n", elementTypeString, arrayType.getDimension(0), name);
		if (!internal) {
			out.printf("#define %s_SIZE %d\n", name.toUpperCase(), arrayType.getDimension(0));
		}
		return sb;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return getClass().hashCode() ^ arrayType.hashCode();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ArrayTypeDeclaration) {
			ArrayTypeDeclaration other = (ArrayTypeDeclaration) obj;
			return other.arrayType.equals(arrayType);
		}
		return false;
	}

}
