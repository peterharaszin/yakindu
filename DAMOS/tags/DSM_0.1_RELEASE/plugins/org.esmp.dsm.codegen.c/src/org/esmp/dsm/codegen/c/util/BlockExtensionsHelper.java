/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.esmp.dsm.codegen.c.util;

import org.esmp.dsm.expressions.FixedPointDataType;
import org.esmp.dsm.expressions.util.FixedPointDataTypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class BlockExtensionsHelper {

	public static String toString(FixedPointDataType type, Integer value) {
		return Long.toString(value << type.getFractionLength());
	}
	
	public static String toString(FixedPointDataType type, String value) {
		try {
			return FixedPointDataTypeUtil.toFixedPoint(Double.parseDouble(value), type).toString();
		} catch (NumberFormatException e) {
			return "/* ERROR: " + e.getMessage() + " */ 0.0";
		}
	}

}
