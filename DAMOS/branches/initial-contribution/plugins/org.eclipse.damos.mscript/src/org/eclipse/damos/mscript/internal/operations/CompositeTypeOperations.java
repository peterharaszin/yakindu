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

package org.eclipse.damos.mscript.internal.operations;

import org.eclipse.damos.mscript.CompositeType;
import org.eclipse.damos.mscript.CompositeTypeMember;
import org.eclipse.damos.mscript.CompositeTypeMemberList;
import org.eclipse.damos.mscript.MscriptFactory;
import org.eclipse.damos.mscript.OperatorKind;
import org.eclipse.damos.mscript.Type;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import com.google.common.base.Objects;

public class CompositeTypeOperations extends TypeOperations {
	
	public static EList<CompositeTypeMember> getMembers(CompositeType compositeType) {
		EList<CompositeTypeMember> members = new BasicEList<CompositeTypeMember>();
		for (CompositeTypeMemberList memberList : compositeType.getMemberLists()) {
			members.addAll(memberList.getMembers());
		}
		return ECollections.unmodifiableEList(members);
	}
	
	public static CompositeTypeMember getMember(CompositeType compositeType, String name) {
		for (CompositeTypeMember member : compositeType.getMembers()) {
			if (name.equals(member.getName())) {
				return member;
			}
		}
		return null;
	}

	public static int getMemberIndex(CompositeType compositeType, String name) {
		int i = 0;
		for (CompositeTypeMember member : compositeType.getMembers()) {
			if (name.equals(member.getName())) {
				return i;
			}
			++i;
		}
		return -1;
	}

	public static Type evaluate(CompositeType compositeType, OperatorKind operator, Type other) {
		switch (operator) {
		case EQUAL_TO:
		case NOT_EQUAL_TO:
			if (compositeType.isAssignableFrom(other) || other.isAssignableFrom(compositeType)) {
				return MscriptFactory.eINSTANCE.createBooleanType();
			}
		default:
			break;
		}
		return MscriptFactory.eINSTANCE.createInvalidType();
	}

	public static boolean isAssignableFrom(CompositeType compositeType, Type other) {
		if (other instanceof CompositeType) {
			CompositeType otherCompositeType = (CompositeType) other;
			
			if (!compositeType.isAnyLabel() && !Objects.equal(compositeType.getLabel(), otherCompositeType.getLabel())) {
				return false;
			}
			
			EList<CompositeTypeMember> members = compositeType.getMembers();
			EList<CompositeTypeMember> otherMembers = otherCompositeType.getMembers();
			if (members.size() != otherMembers.size()) {
				return false;
			}
			for (int i = 0; i < members.size(); ++i) {
				CompositeTypeMember member = members.get(i);
				CompositeTypeMember otherMember = otherMembers.get(i);
				
				if (!member.getName().equals(otherMember.getName())) {
					return false;
				}

				Type type = member.getType();
				Type otherType = otherMember.getType();
				if (type == null || otherType == null || type.eIsProxy() || otherType.eIsProxy() || !type.isAssignableFrom(otherType)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

}
