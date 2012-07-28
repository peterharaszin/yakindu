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

import org.eclipselabs.damos.mscript.CompositeTypeMember;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.TypeSpecifier;

/**
 * @author Andreas Unger
 *
 */
public class CompositeTypeMemberOperations {

	public static Type getType(CompositeTypeMember compositeTypeMember) {
		if (compositeTypeMember.getOwner() != null) {
			TypeSpecifier typeSpecifier = compositeTypeMember.getOwner().getTypeSpecifier();
			if (typeSpecifier != null) {
				return typeSpecifier.getType();
			}
		}
		return null;
	}
	
}
