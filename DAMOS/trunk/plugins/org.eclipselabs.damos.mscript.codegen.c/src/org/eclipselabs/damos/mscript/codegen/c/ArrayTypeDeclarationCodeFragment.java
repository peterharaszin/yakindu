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

package org.eclipselabs.damos.mscript.codegen.c;

import java.io.IOException;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.codegen.c.util.MscriptGeneratorUtil;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;

/**
 * @author Andreas Unger
 *
 */
public class ArrayTypeDeclarationCodeFragment extends AbstractCodeFragment {

	private ComputationModel computationModel;
	private DataType elementType;
	private String elementTypeString;
	private NumberFormat elementNumberFormat;
	private int size;
	
	private String name;
	
	/**
	 * 
	 */
	public ArrayTypeDeclarationCodeFragment(ComputationModel computationModel, DataType elementType, int size) {
		this.computationModel = computationModel;
		this.elementType = elementType;
		this.size = size;
		this.elementNumberFormat = computationModel.getNumberFormat(elementType);
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#initialize(org.eclipse.core.runtime.IAdaptable, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void initialize(IAdaptable context, IProgressMonitor monitor) throws IOException {
		elementTypeString = MscriptGeneratorUtil.getCDataType(computationModel, (ICodeFragmentCollector) context.getAdapter(ICodeFragmentCollector.class), elementType, this);
		
		IGlobalNameProvider globalNameProvider = (IGlobalNameProvider) context.getAdapter(IGlobalNameProvider.class);
		name = globalNameProvider.getName("Array");
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.ICodeFragment#writeForwardDeclaration(java.lang.Appendable, boolean)
	 */
	public void writeForwardDeclaration(Appendable appendable, boolean internal) throws IOException {
		PrintAppendable out = new PrintAppendable(appendable);
		out.printf("typedef struct { %s data[%d]; } %s;\n", elementTypeString, size, name);
		if (!internal) {
			out.printf("#define %s_SIZE %d\n", name.toUpperCase(), size);
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return getClass().hashCode() ^ elementNumberFormat.getClass().hashCode() ^ size;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ArrayTypeDeclarationCodeFragment) {
			ArrayTypeDeclarationCodeFragment other = (ArrayTypeDeclarationCodeFragment) obj;
			return other.size == size && other.elementNumberFormat.isEquivalentTo(elementNumberFormat);
		}
		return false;
	}

}
