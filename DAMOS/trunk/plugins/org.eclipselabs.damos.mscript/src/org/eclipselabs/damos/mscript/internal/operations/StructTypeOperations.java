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

package org.eclipselabs.damos.mscript.internal.operations;

import org.eclipse.emf.common.util.EList;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.StructMember;
import org.eclipselabs.damos.mscript.StructType;

public class StructTypeOperations extends DataTypeOperations {
	
	public static StructMember getMember(StructType structType, String name) {
		for (StructMember member : structType.getMembers()) {
			if (name.equals(member.getName())) {
				return member;
			}
		}
		return null;
	}

	public static int getMemberIndex(StructType structType, String name) {
		int i = 0;
		for (StructMember member : structType.getMembers()) {
			if (name.equals(member.getName())) {
				return i;
			}
			++i;
		}
		return -1;
	}

	public static DataType evaluate(StructType structType, OperatorKind operator, DataType other) {
		switch (operator) {
		case EQUAL_TO:
		case NOT_EQUAL_TO:
			if (structType.isAssignableFrom(other) || other.isAssignableFrom(structType)) {
				return MscriptFactory.eINSTANCE.createBooleanType();
			}
		default:
			break;
		}
		return MscriptFactory.eINSTANCE.createInvalidDataType();
	}

	public static boolean isAssignableFrom(StructType structType, DataType other) {
		if (other instanceof StructType) {
			StructType otherStructType = (StructType) other;
			EList<StructMember> members = structType.getMembers();
			EList<StructMember> otherMembers = otherStructType.getMembers();
			if (members.size() != otherMembers.size()) {
				return false;
			}
			for (int i = 0; i < members.size(); ++i) {
				StructMember member = members.get(i);
				StructMember otherMember = otherMembers.get(i);
				
				if (!member.getName().equals(otherMember.getName())) {
					return false;
				}

				DataType type = member.getTypeSpecifier().getType();
				DataType otherType = otherMember.getTypeSpecifier().getType();
				if (type == null || otherType == null || type.eIsProxy() || otherType.eIsProxy() || !type.isAssignableFrom(otherType)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

}
