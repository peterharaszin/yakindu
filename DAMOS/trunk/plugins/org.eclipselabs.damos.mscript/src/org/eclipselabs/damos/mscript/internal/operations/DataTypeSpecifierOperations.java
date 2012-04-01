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

import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.DataTypeDeclaration;
import org.eclipselabs.damos.mscript.DataTypeSpecifier;

/**
 * @author Andreas Unger
 *
 */
public class DataTypeSpecifierOperations {

	public static DataType getType(DataTypeSpecifier dataTypeSpecifier) {
		return getType(dataTypeSpecifier, null);
	}
	
	private static DataType getType(DataTypeSpecifier dataTypeSpecifier, Set<DataTypeDeclaration> visitedTypeDeclarations) {
		DataType anonymousType = dataTypeSpecifier.getAnonymousType();
		if (anonymousType != null) {
			return anonymousType;
		}
		DataTypeDeclaration typeDeclaration = dataTypeSpecifier.getTypeDeclaration();
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
		return null;
	}

}
