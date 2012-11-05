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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.damos.mscript.AnonymousTypeSpecifier;
import org.eclipse.damos.mscript.DeclaredTypeSpecifier;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.TypeDeclaration;
import org.eclipse.damos.mscript.TypeSpecifier;

/**
 * @author Andreas Unger
 *
 */
public class DeclaredTypeSpecifierOperations {

	public static Type getType(DeclaredTypeSpecifier dataTypeSpecifier) {
		return getType(dataTypeSpecifier, null);
	}
	
	private static Type getType(TypeSpecifier typeSpecifier, Set<TypeDeclaration> visitedTypeDeclarations) {
		if (typeSpecifier instanceof AnonymousTypeSpecifier) {
			return typeSpecifier.getType();
		}
		if (typeSpecifier instanceof DeclaredTypeSpecifier) {
			TypeDeclaration typeDeclaration = ((DeclaredTypeSpecifier) typeSpecifier).getTypeDeclaration();
			if (typeDeclaration != null) {
				if (visitedTypeDeclarations == null) {
					visitedTypeDeclarations = new HashSet<TypeDeclaration>();
				}
				if (visitedTypeDeclarations.add(typeDeclaration)) { // Break cycle
					TypeSpecifier nextTypeSpecifier = typeDeclaration.getTypeSpecifier();
					if (nextTypeSpecifier != null) {
						return getType(nextTypeSpecifier, visitedTypeDeclarations);
					}
				}
			}
		}
		return null;
	}

}
