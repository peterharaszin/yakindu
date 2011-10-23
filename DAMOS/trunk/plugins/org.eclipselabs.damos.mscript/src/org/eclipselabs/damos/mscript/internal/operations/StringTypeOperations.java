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

import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.StringType;


public class StringTypeOperations extends PrimitiveTypeOperations {

	public static boolean isAssignableFrom(StringType stringType, DataType other) {
		return other instanceof StringType;
	}

}
