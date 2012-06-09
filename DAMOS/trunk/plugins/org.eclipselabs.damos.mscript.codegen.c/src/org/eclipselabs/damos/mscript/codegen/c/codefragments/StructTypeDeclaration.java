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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.codegen.c.IGlobalNameProvider;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineStructMember;
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineStructType;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;

/**
 * @author Andreas Unger
 *
 */
public class StructTypeDeclaration extends AbstractCodeFragment {

	private ComputationModel computationModel;
	private MachineStructType structType;
	private List<String> memberTypeNames = new ArrayList<String>();
	
	private String name;
	
	/**
	 * 
	 */
	public StructTypeDeclaration(ComputationModel computationModel, MachineStructType structType) {
		this.computationModel = computationModel;
		this.structType = structType;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	@Override
	public void initialize(IAdaptable context, IProgressMonitor monitor) {
		ICodeFragmentCollector codeFragmentCollector = (ICodeFragmentCollector) context.getAdapter(ICodeFragmentCollector.class);
		
		IGlobalNameProvider globalNameProvider = (IGlobalNameProvider) context.getAdapter(IGlobalNameProvider.class);
		name = globalNameProvider.getName("Struct");
		
		for (MachineStructMember member : structType.getMembers()) {
			memberTypeNames.add(member.getType().getCDataType(computationModel, codeFragmentCollector, this));
		}
	}
	
	public CharSequence generateForwardDeclaration(boolean internal) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		out.println("typedef struct {");
		for (int i = 0; i < memberTypeNames.size(); ++i) {
			String memberTypeName = memberTypeNames.get(i);
			String memberName = structType.getMembers().get(i).getName();
			out.printf("%s %s;\n", memberTypeName, memberName);
		}
		out.printf("} %s;\n", name);
		return sb;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return getClass().hashCode() ^ structType.getClass().hashCode();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof StructTypeDeclaration) {
			StructTypeDeclaration other = (StructTypeDeclaration) obj;
			return other.structType.equals(structType);
		}
		return false;
	}

}
