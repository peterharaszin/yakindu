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

import java.util.regex.Pattern;

import org.eclipselabs.damos.dml.QualifiedElement;

/**
 * @author Andreas Unger
 *
 */
public class QualifiedElementOperations {

	private static final Pattern QUALIFIED_NAME_SEPARATOR_PATTERN = Pattern.compile("\\.|::");
	
	public static String getName(QualifiedElement qualifiedElement) {
		String qualifiedName = qualifiedElement.getQualifiedName();
		if (qualifiedName != null) {
			String[] segments = QUALIFIED_NAME_SEPARATOR_PATTERN.split(qualifiedName);
			return segments[segments.length - 1];
		}
		return null;
	}

	public static String getQualifier(QualifiedElement qualifiedElement) {
		String qualifiedName = qualifiedElement.getQualifiedName();
		if (qualifiedName != null) {
			int index = qualifiedName.lastIndexOf(".");
			if (index >= 0) {
				return qualifiedName.substring(0, index);
			}
			return qualifiedName;
		}
		return null;
	}

}
