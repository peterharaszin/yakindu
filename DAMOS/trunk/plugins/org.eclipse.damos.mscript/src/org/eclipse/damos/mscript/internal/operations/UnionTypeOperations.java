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

import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.UnionType;

public class UnionTypeOperations extends CompositeTypeOperations {
	
	public static boolean isAssignableFrom(UnionType unionType, Type other) {
		if (other instanceof UnionType) {
			return CompositeTypeOperations.isAssignableFrom(unionType, other);
		}
		return false;
	}

}
