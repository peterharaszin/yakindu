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

package org.eclipselabs.damos.dml.internal.operations;

import org.eclipselabs.damos.dml.QualifiedElement;

/**
 * @author Andreas Unger
 *
 */
public class QualifiedElementOperations {

	public static String getQualifiedName(QualifiedElement qualifiedElement) {
		String packageName = qualifiedElement.getPackageName();
		return packageName != null ? packageName + "." + qualifiedElement.getName() : qualifiedElement.getName();
	}

	public static void setQualifiedName(QualifiedElement qualifiedElement, String newQualifiedName) {
		if (newQualifiedName != null) {
			int index = newQualifiedName.lastIndexOf(".");
			int nameIndex = index + 1;
			if (index == -1) {
				index = newQualifiedName.lastIndexOf("::");
				++nameIndex;
			}
			if (index >= 0) {
				qualifiedElement.setName(newQualifiedName.substring(nameIndex));
				qualifiedElement.setPackageName(newQualifiedName.substring(0, index));
			} else {
				qualifiedElement.setName(newQualifiedName);
				qualifiedElement.setPackageName(null);
			}
		}
	}

}
