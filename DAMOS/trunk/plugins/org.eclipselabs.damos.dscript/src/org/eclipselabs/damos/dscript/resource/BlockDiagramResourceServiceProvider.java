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

package org.eclipselabs.damos.dscript.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceDescription.Manager;
import org.eclipse.xtext.resource.impl.DefaultResourceServiceProvider;

/**
 * @author Andreas Unger
 *
 */
public class BlockDiagramResourceServiceProvider extends DefaultResourceServiceProvider {

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.resource.impl.DefaultResourceServiceProvider#getResourceDescriptionManager()
	 */
	@Override
	public Manager getResourceDescriptionManager() {
		return get(BlockDiagramResourceDescriptionManager.class);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.resource.impl.DefaultResourceServiceProvider#canHandle(org.eclipse.emf.common.util.URI)
	 */
	@Override
	public boolean canHandle(URI uri) {
		return "blockdiagram".equals(uri.fileExtension());
	}
	
}
