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
package org.eclipse.damos.mscript.codegen.c;

import org.eclipse.damos.mscript.computation.FloatingPointFormatKind;

/**
 * @author Andreas Unger
 *
 */
public class PrimitiveTypeGenerator {

	public CharSequence generateIndexType(long maximumIndex) {
		if (maximumIndex < 0xffL) {
			return "uint_fast8_t";
		}
		if (maximumIndex < 0xffffL) {
			return "uint_fast16_t";
		}
		if (maximumIndex < 0xffffffffL) {
			return "uint_fast32_t";
		}
		return "uint_fast64_t";
	}

	public CharSequence generateBooleanType() {
		return "uint_fast8_t";
	}

	public CharSequence generateIntegerType(int wordSize) {
		return "int" + wordSize + "_t";
	}

	public CharSequence generateFloatingPointType(FloatingPointFormatKind floatingPointFormatKind) {
		switch (floatingPointFormatKind) {
		case BINARY32:
			return "float";
		case BINARY64:
			return "double";
		default:
			break;
		}
		throw new IllegalArgumentException("Unknown number floating point kind " + floatingPointFormatKind.getName());
	}

}
