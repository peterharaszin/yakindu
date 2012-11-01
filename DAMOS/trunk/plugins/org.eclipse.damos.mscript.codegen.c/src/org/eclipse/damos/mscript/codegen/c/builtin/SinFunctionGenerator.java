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

package org.eclipse.damos.mscript.codegen.c.builtin;

import org.eclipse.damos.mscript.computation.FixedPointFormat;
import org.eclipse.damos.mscript.computation.FloatingPointFormat;

/**
 * @author Andreas Unger
 *
 */
public class SinFunctionGenerator extends AbstractSingleParameterFunctionGenerator {

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.codegen.c.internal.AbstractSingleParameterFunctionGenerator#getFixedPointFunctionName(org.eclipse.damos.mscript.computation.FixedPointFormat)
	 */
	@Override
	protected String getFixedPointFunctionName(FixedPointFormat fixedPointFormat) {
		return fixedPointFormat.getWordSize() > 32 ? "DamosMath_sinfix64" : "DamosMath_sinfix32";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.codegen.c.internal.AbstractSingleParameterFunctionGenerator#getFloatingPointFunctionName(org.eclipse.damos.mscript.computation.FloatingPointFormat)
	 */
	@Override
	protected String getFloatingPointFunctionName(FloatingPointFormat floatingPointFormat) {
		return "sin";
	}

}
