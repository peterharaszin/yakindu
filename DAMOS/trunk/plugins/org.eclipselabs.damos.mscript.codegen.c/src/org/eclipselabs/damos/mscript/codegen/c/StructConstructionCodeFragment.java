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
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineStructMember;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineStructType;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;

/**
 * @author Andreas Unger
 *
 */
public class StructConstructionCodeFragment extends AbstractCodeFragment {

	private MachineStructType structType;
	private ComputationModel computationModel;
	
	private String typeName;
	private String name;
	
	private String functionSignature;
	
	/**
	 * 
	 */
	public StructConstructionCodeFragment(ComputationModel computationModel, MachineStructType structType) {
		this.computationModel = computationModel;
		this.structType = structType;
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
		addDependency(FORWARD_DECLARATION_DEPENDS_ON, new IDependencyRule() {
			
			public boolean applies(ICodeFragment other) {
				return other instanceof StructTypeDeclarationCodeFragment;
			}
			
		});

		StructTypeDeclarationCodeFragment structTypeDeclarationCodeFragment = new StructTypeDeclarationCodeFragment(computationModel, structType);
		ICodeFragmentCollector codeFragmentCollector = (ICodeFragmentCollector) context.getAdapter(ICodeFragmentCollector.class);
		StructTypeDeclarationCodeFragment codeFragment = (StructTypeDeclarationCodeFragment) codeFragmentCollector.addCodeFragment(structTypeDeclarationCodeFragment, new NullProgressMonitor());
		typeName = codeFragment.getName();
		
		IGlobalNameProvider globalNameProvider = (IGlobalNameProvider) context.getAdapter(IGlobalNameProvider.class);
		name = globalNameProvider.getName("createStructure");

		functionSignature = getFunctionSignature(codeFragmentCollector);
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
		if (internal) {
			appendable.append("static ");
		}
		appendable.append(functionSignature);
		appendable.append(";\n");
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
		out.print(functionSignature);
		out.println(" {");
		out.printf("%s _s;\n", typeName);
		for (MachineStructMember member : structType.getMembers()) {
			out.printf("_s.%s = %s;\n", member.getName(), member.getName());
		}
		out.println("return _s;");
		out.println("}");
	}
	
	private String getFunctionSignature(ICodeFragmentCollector codeFragmentCollector) {
		StringBuilder sb = new StringBuilder();
		sb.append(typeName);
		sb.append(" ");
		sb.append(name);
		sb.append("(");
		boolean first = true;
		for (MachineStructMember member : structType.getMembers()) {
			if (first) {
				first = false;
			} else {
				sb.append(", ");
			}
			sb.append(member.getType().getCDataType(computationModel, codeFragmentCollector, this));
			sb.append(" ");
			sb.append(member.getName());
		}
		sb.append(")");
		return sb.toString();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return getClass().hashCode() ^ structType.hashCode();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof StructConstructionCodeFragment) {
			StructConstructionCodeFragment other = (StructConstructionCodeFragment) obj;
			return other.structType.equals(structType);
		}
		return false;
	}

}
