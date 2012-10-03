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

package org.eclipse.damos.mscript.linking;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.linking.lazy.LazyLinker;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

/**
 * @author Andreas Unger
 *
 */
public class MscriptLinker extends LazyLinker {

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.linking.impl.AbstractCleaningLinker#clearAllReferences(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected void clearAllReferences(EObject model) {
		if (NodeModelUtils.getNode(model) != null) {
			super.clearAllReferences(model);
		}
	}
	
}
