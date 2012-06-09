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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.codegen.c.IGlobalNameProvider;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineArrayType;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;

/**
 * @author Andreas Unger
 *
 */
public class ArrayConstructionCodeFragment extends AbstractCodeFragment {

	private MachineArrayType arrayType;
	private ComputationModel computationModel;
	
	private String typeName;
	private String name;
	
	private String functionSignature;
	
	/**
	 * 
	 */
	public ArrayConstructionCodeFragment(ComputationModel computationModel, MachineArrayType arrayType) {
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
	public void initialize(IAdaptable context, IProgressMonitor monitor) {
		addDependency(FORWARD_DECLARATION_DEPENDS_ON, new IDependencyRule() {
			
			public boolean applies(ICodeFragment other) {
				return other instanceof ArrayTypeDeclarationCodeFragment;
			}
			
		});

		ArrayTypeDeclarationCodeFragment arrayTypeDeclarationCodeFragment = new ArrayTypeDeclarationCodeFragment(computationModel, arrayType);
		ICodeFragmentCollector codeFragmentCollector = (ICodeFragmentCollector) context.getAdapter(ICodeFragmentCollector.class);
		ArrayTypeDeclarationCodeFragment codeFragment = (ArrayTypeDeclarationCodeFragment) codeFragmentCollector.addCodeFragment(arrayTypeDeclarationCodeFragment, new NullProgressMonitor());
		typeName = codeFragment.getName();
		
		IGlobalNameProvider globalNameProvider = (IGlobalNameProvider) context.getAdapter(IGlobalNameProvider.class);
		name = globalNameProvider.getName("createArray");

		functionSignature = getFunctionSignature(codeFragmentCollector);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#contributesInternalForwardDeclaration()
	 */
	@Override
	public boolean contributesInternalForwardDeclaration() {
		return false;
	}
	
	public CharSequence generateForwardDeclaration(boolean internal) {
		StringBuilder sb = new StringBuilder();
		if (internal) {
			sb.append("static ");
		}
		sb.append(functionSignature);
		sb.append(";\n");
		return sb;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment#contributesImplementation()
	 */
	@Override
	public boolean contributesImplementation() {
		return true;
	}
	
	@Override
	public CharSequence generateImplementation(boolean internal) {
		StringBuilder sb = new StringBuilder();
		if (internal) {
			sb.append("static ");
		}
		PrintAppendable out = new PrintAppendable(sb);
		out.print(functionSignature);
		out.println(" {");
		out.printf("%s a;\n", typeName);
		for (int i = 0; i < arrayType.getDimension(0); ++i) {
			out.printf("a.data[%d] = e%d;\n", i, i);
		}
		out.println("return a;");
		out.println("}");
		return sb;
	}
	
	private String getFunctionSignature(ICodeFragmentCollector codeFragmentCollector) {
		StringBuilder sb = new StringBuilder();
		sb.append(typeName);
		sb.append(" ");
		sb.append(name);
		sb.append("(");
		boolean first = true;
		for (int i = 0; i < arrayType.getDimension(0); ++i) {
			if (first) {
				first = false;
			} else {
				sb.append(", ");
			}
			sb.append(arrayType.getElementType().getCDataType(computationModel, codeFragmentCollector, this));
			sb.append(" ");
			sb.append("e");
			sb.append(i);
		}
		sb.append(")");
		return sb.toString();
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
		if (obj instanceof ArrayConstructionCodeFragment) {
			ArrayConstructionCodeFragment other = (ArrayConstructionCodeFragment) obj;
			return other.arrayType.equals(arrayType);
		}
		return false;
	}

}
