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

import org.eclipselabs.damos.mscript.UnitDeclaration;
import org.eclipselabs.damos.mscript.UnitSymbol;

/**
 * @author Andreas Unger
 *
 */
public class UnitSymbolOperations {

	public static String getName(UnitSymbol unitSymbol) {
		UnitDeclaration owner = unitSymbol.getOwner();
		if (owner != null && owner.getName() != null) {
			return unitSymbol.getPrefix().getLiteral() + owner.getName();
		}
		return null;
	}

}
