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

import static org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.FORWARD_DECLARATION_DEPENDS_ON;

import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.IDependencyRule;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.RecordTypeDeclaration;

/**
 * @author Andreas Unger
 *
 */
public class MachineRecordType extends MachineDataType {

	private final List<MachineStructMember> members;

	/**
	 * 
	 */
	MachineRecordType(List<MachineStructMember> members) {
		this.members = members;
	}
	
	@Override
	public CharSequence generateDataType(CharSequence variableName, ICodeFragmentCollector codeFragmentCollector,
			ICodeFragment dependentCodeFragment) {
		final RecordTypeDeclaration codeFragment = (RecordTypeDeclaration) codeFragmentCollector.addCodeFragment(new RecordTypeDeclaration(this), new NullProgressMonitor());
		if (dependentCodeFragment != null) {
			dependentCodeFragment.addDependency(FORWARD_DECLARATION_DEPENDS_ON, new IDependencyRule() {
				
				public boolean applies(ICodeFragment other) {
					return other == codeFragment;
				}
				
			});
		}

		StringBuilder sb = new StringBuilder();
		sb.append(codeFragment.getName());
		if (variableName != null) {
			sb.append(" ");
			sb.append(variableName);
		}
		return sb;
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
		if (obj instanceof MachineRecordType) {
			MachineRecordType other = (MachineRecordType) obj;
			return other.members.equals(members);
		}
		return false;
	}
	
}
