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

package org.eclipse.damos.dscript.resource;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionManager;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Andreas Unger
 *
 */
public class BlockDiagramResourceDescriptionManager extends DefaultResourceDescriptionManager {

	@Inject
	private Injector injector;
	
	public IResourceDescription getResourceDescription(Resource resource) {
		BlockDiagramResourceDescription resourceDescription = new BlockDiagramResourceDescription(resource);
		injector.injectMembers(resourceDescription);
		return resourceDescription;
	}
	
}
