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

package org.eclipse.damos.mscript.codegen.c.datatype;

/**
 * @author Andreas Unger
 *
 */
public class MachineCompositeTypeMember {

	private final String name;
	private final MachineDataType type;

	/**
	 * 
	 */
	MachineCompositeTypeMember(String name, MachineDataType type) {
		this.name = name;
		this.type = type;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the type
	 */
	public MachineDataType getType() {
		return type;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.codegen.c.datatype.MachineDataType#hashCode()
	 */
	@Override
	public int hashCode() {
		return name.hashCode() ^ type.hashCode();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MachineCompositeTypeMember) {
			MachineCompositeTypeMember other = (MachineCompositeTypeMember) obj;
			return other.name.equals(name) && other.type.equals(type);
		}
		return false;
	}
	
}
