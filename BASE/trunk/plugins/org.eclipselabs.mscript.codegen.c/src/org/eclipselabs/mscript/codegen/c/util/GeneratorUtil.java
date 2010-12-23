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

package org.eclipselabs.mscript.codegen.c.util;

import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.IntegerType;
import org.eclipselabs.mscript.typesystem.RealType;

/**
 * @author Andreas Unger
 *
 */
public class GeneratorUtil {

	public static String toString(DataType dataType) {
		if (dataType instanceof RealType) {
			return "double";
		}
		if (dataType instanceof IntegerType) {
			return "int";
		}
		return "void";
	}
	
}
