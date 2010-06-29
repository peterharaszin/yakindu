/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.esmp.dsm.semantic.blockdiagram.internal.operations;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.esmp.dsm.semantic.blockdiagram.Enumeration;
import org.esmp.dsm.semantic.blockdiagram.EnumerationLiteral;
import org.esmp.dsm.semantic.blockdiagram.EnumerationLiteralOrder;
import org.esmp.dsm.semantic.blockdiagram.NamedElement;

/**
 * @author Andreas Unger
 *
 */
public class EnumerationOperations {

	public static String getName(Enumeration enumeration) {
		StringBuilder sb = new StringBuilder();
		EObject container = enumeration.eContainer();
		if (container instanceof NamedElement) {
			addElementName(sb, (NamedElement) enumeration.eContainer());
		}
		return sb.toString();
	}
	
	private static void addElementName(StringBuilder sb, NamedElement element) {
		EObject container = element.eContainer();
		if (container instanceof NamedElement) {
			addElementName(sb, (NamedElement) container);
			sb.append("::");
		}
		sb.append(element.getName());
	}
	
	public static EList<EnumerationLiteral> getLiterals(Enumeration enumeration) {
		EList<EnumerationLiteral> literals = new BasicEList<EnumerationLiteral>();
		if (enumeration.getLiteralOrder() == EnumerationLiteralOrder.OWNED_FIRST) {
			literals.addAll(enumeration.getOwnedLiterals());
		}
		literals.addAll(enumeration.getInheritedLiterals());
		if (enumeration.getLiteralOrder() == EnumerationLiteralOrder.INHERITED_FIRST) {
			literals.addAll(enumeration.getOwnedLiterals());
		}
		return literals;
	}

}
