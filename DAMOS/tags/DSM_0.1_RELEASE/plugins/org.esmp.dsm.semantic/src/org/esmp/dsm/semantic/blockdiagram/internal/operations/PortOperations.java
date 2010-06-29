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

package org.esmp.dsm.semantic.blockdiagram.internal.operations;

import org.eclipse.emf.ecore.EObject;
import org.esmp.dsm.semantic.blockdiagram.Block;

/**
 * @author Andreas Unger
 *
 */
public class PortOperations {

	public static Block getBlock(EObject o) {
		do {
			o = o.eContainer();
		} while (o != null && !(o instanceof Block));
		return (Block) o;
	}

}
