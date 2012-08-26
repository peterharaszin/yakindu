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

package org.eclipselabs.damos.mscript.internal.computation.operations;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.mscript.computation.FloatingPointFormat;
import org.eclipselabs.damos.mscript.computation.NumberFormat;

/**
 * @author Andreas Unger
 *
 */
public class FloatingPointFormatOperations {

	public static boolean isEquivalentTo(FloatingPointFormat floatingPointFormat, NumberFormat other) {
		return EcoreUtil.equals(floatingPointFormat, other);
	}

}
