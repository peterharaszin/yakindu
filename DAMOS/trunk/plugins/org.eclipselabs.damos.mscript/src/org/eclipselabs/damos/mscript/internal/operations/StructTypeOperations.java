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

import org.eclipselabs.damos.mscript.StructType;
import org.eclipselabs.damos.mscript.Type;

public class StructTypeOperations extends CompositeTypeOperations {
	
	public static boolean isAssignableFrom(StructType structType, Type other) {
		if (other instanceof StructType) {
			return CompositeTypeOperations.isAssignableFrom(structType, other);
		}
		return false;
	}

}
