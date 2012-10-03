/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.mscript.interpreter.value;

import org.eclipse.damos.mscript.CompositeTypeMember;
import org.eclipse.damos.mscript.RecordType;
import org.eclipse.damos.mscript.interpreter.IComputationContext;

/**
 * @author Andreas Unger
 *
 */
public class RecordValue extends AbstractExplicitDataTypeValue {

	private IValue[] members;
	
	/**
	 * @param context
	 * @param dataType
	 */
	public RecordValue(IComputationContext context, RecordType dataType, IValue[] members) {
		super(context, dataType);
		this.members = members;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.computation.core.value.AbstractExplicitDataTypeValue#getDataType()
	 */
	@Override
	public RecordType getDataType() {
		return (RecordType) super.getDataType();
	}
	
	public IValue get(int memberIndex) {
		return members[memberIndex];
	}
	
	public IValue get(String memberName) {
		int i = 0;
		for (CompositeTypeMember member : getDataType().getMembers()) {
			if (memberName.equals(member.getName())) {
				return members[i]; 
			}
			++i;
		}
		throw new IllegalArgumentException("Invalid member " + memberName);
	}
	
}
