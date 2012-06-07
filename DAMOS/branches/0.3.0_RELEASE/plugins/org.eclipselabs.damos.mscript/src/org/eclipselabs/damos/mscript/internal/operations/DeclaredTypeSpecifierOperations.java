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

package org.eclipselabs.damos.mscript.internal.operations;

import java.util.HashSet;
import java.util.Set;

import org.eclipselabs.damos.mscript.AnonymousTypeSpecifier;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.DataTypeDeclaration;
import org.eclipselabs.damos.mscript.DataTypeSpecifier;
import org.eclipselabs.damos.mscript.DeclaredTypeSpecifier;

/**
 * @author Andreas Unger
 *
 */
public class DeclaredTypeSpecifierOperations {

	public static DataType getType(DeclaredTypeSpecifier dataTypeSpecifier) {
		return getType(dataTypeSpecifier, null);
	}
	
	private static DataType getType(DataTypeSpecifier dataTypeSpecifier, Set<DataTypeDeclaration> visitedTypeDeclarations) {
		if (dataTypeSpecifier instanceof AnonymousTypeSpecifier) {
			return dataTypeSpecifier.getType();
		}
		if (dataTypeSpecifier instanceof DeclaredTypeSpecifier) {
			DataTypeDeclaration typeDeclaration = ((DeclaredTypeSpecifier) dataTypeSpecifier).getTypeDeclaration();
			if (typeDeclaration != null) {
				if (visitedTypeDeclarations == null) {
					visitedTypeDeclarations = new HashSet<DataTypeDeclaration>();
				}
				if (visitedTypeDeclarations.add(typeDeclaration)) { // Break cycle
					DataTypeSpecifier typeSpecifier = typeDeclaration.getTypeSpecifier();
					if (typeSpecifier != null) {
						return getType(typeSpecifier, visitedTypeDeclarations);
					}
				}
			}
		}
		return null;
	}

}
