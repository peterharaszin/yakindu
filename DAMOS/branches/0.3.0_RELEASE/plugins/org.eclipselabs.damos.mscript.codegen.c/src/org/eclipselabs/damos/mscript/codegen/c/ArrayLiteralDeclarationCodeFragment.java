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
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineArrayType;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineDataTypes;
import org.eclipselabs.damos.mscript.codegen.c.util.MscriptGeneratorUtil;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;
import org.eclipselabs.damos.mscript.interpreter.value.IArrayValue;

/**
 * @author Andreas Unger
 *
 */
public class ArrayLiteralDeclarationCodeFragment extends AbstractCodeFragment {

	private final ComputationModel computationModel;
	private final IArrayValue arrayValue;
	
	private String name;
	private String typeName;
	private String body;

	/**
	 * 
	 */
	public ArrayLiteralDeclarationCodeFragment(ComputationModel computationModel, IArrayValue value) {
		this.computationModel = computationModel;
		this.arrayValue = value;
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
		addDependency(new ICodeFragmentDependency.Stub() {
			
			public boolean forwardDeclarationDependsOn(ICodeFragment other) {
				return other instanceof ArrayTypeDeclarationCodeFragment;
			}
			
		});
		
		MachineArrayType arrayType = MachineDataTypes.create(computationModel, arrayValue.getDataType());
		ArrayTypeDeclarationCodeFragment arrayTypeDeclarationCodeFragment = new ArrayTypeDeclarationCodeFragment(computationModel, arrayType);
		ICodeFragmentCollector codeFragmentCollector = (ICodeFragmentCollector) context.getAdapter(ICodeFragmentCollector.class);
		ArrayTypeDeclarationCodeFragment codeFragment = (ArrayTypeDeclarationCodeFragment) codeFragmentCollector.addCodeFragment(arrayTypeDeclarationCodeFragment, new NullProgressMonitor());
		typeName = codeFragment.getName();
		
		IGlobalNameProvider globalNameProvider = (IGlobalNameProvider) context.getAdapter(IGlobalNameProvider.class);
		name = globalNameProvider.getName("array");

		StringBuilder sb = new StringBuilder();
		MscriptGeneratorUtil.createInitializer(computationModel, codeFragmentCollector, new PrintAppendable(sb), arrayValue);
		body = sb.toString();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#contributesInternalForwardDeclaration()
	 */
	@Override
	public boolean contributesInternalForwardDeclaration() {
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.ICodeFragment#writeForwardDeclaration(java.lang.Appendable, boolean)
	 */
	public void writeForwardDeclaration(Appendable appendable, boolean internal) throws IOException {
		PrintAppendable out = new PrintAppendable(appendable);
		out.printf("extern const %s %s;\n", typeName, name);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#contributesImplementation()
	 */
	@Override
	public boolean contributesImplementation() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#writeImplementation(java.lang.Appendable, boolean)
	 */
	@Override
	public void writeImplementation(Appendable appendable, boolean internal) throws IOException {
		if (internal) {
			appendable.append("static ");
		}
		PrintAppendable out = new PrintAppendable(appendable);
		out.printf("const %s %s = ", typeName, name);
		out.print(body);
		out.print(";\n");
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return getClass().hashCode(); // TODO: get hash from value
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ArrayLiteralDeclarationCodeFragment) {
//			ArrayLiteralDeclarationCodeFragment other = (ArrayLiteralDeclarationCodeFragment) obj;
			// TODO: check equals using value
		}
		return false;
	}

}
