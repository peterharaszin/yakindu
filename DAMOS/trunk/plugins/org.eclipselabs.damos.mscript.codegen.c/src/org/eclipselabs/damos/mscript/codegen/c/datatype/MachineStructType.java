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

package org.eclipselabs.damos.mscript.codegen.c.datatype;

import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentDependency;
import org.eclipselabs.damos.mscript.codegen.c.StructTypeDeclarationCodeFragment;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;

/**
 * @author Andreas Unger
 *
 */
public class MachineStructType extends MachineDataType {

	private final List<MachineStructMember> members;

	/**
	 * 
	 */
	MachineStructType(List<MachineStructMember> members) {
		this.members = members;
	}
	
	@Override
	public String getCDataType(ComputationModel computationModel, ICodeFragmentCollector codeFragmentCollector,
			ICodeFragment dependentCodeFragment) {
		final StructTypeDeclarationCodeFragment codeFragment = (StructTypeDeclarationCodeFragment) codeFragmentCollector.addCodeFragment(new StructTypeDeclarationCodeFragment(computationModel, this), new NullProgressMonitor());
		if (dependentCodeFragment != null) {
			dependentCodeFragment.addDependency(new ICodeFragmentDependency.Stub() {
				
				/* (non-Javadoc)
				 * @see org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentDependency.Stub#dependsOn(org.eclipselabs.damos.mscript.codegen.c.ICodeFragment)
				 */
				@Override
				public boolean forwardDeclarationDependsOn(ICodeFragment other) {
					return other == codeFragment;
				}
				
			});
		}
		return codeFragment.getName();
	}
	
	/**
	 * @return the members
	 */
	public List<MachineStructMember> getMembers() {
		return members;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.codegen.c.datatype.MachineDataType#hashCode()
	 */
	@Override
	public int hashCode() {
		return super.hashCode() ^ members.hashCode();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MachineStructType) {
			MachineStructType other = (MachineStructType) obj;
			return other.members.equals(members);
		}
		return false;
	}
	
}
