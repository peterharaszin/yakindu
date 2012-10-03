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

package org.eclipse.damos.dscript.scoping;

import org.eclipse.damos.dml.BlockType;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.mscript.scoping.MscriptImportedNamespaceScopeProvider;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Andreas Unger
 *
 */
public class DscriptImportedNamespaceScopeProvider extends MscriptImportedNamespaceScopeProvider {

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.scoping.MscriptImportedNamespaceScopeProvider#getPackageName(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected String getPackageName(EObject context) {
		if (context instanceof Fragment) {
			return ((Fragment) context).getPackageName();
		}
		if (context instanceof BlockType) {
			return ((BlockType) context).getPackageName();
		}
		return super.getPackageName(context);
	}
	
}
