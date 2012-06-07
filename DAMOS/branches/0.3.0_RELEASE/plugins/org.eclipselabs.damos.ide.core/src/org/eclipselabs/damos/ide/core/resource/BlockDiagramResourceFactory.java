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

package org.eclipselabs.damos.ide.core.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResourceFactory;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Andreas Unger
 *
 */
public class BlockDiagramResourceFactory extends GMFResourceFactory {

	@Inject
	private Injector injector;
	
	private static final String ENCODING = "UTF-8";
	
	@SuppressWarnings("unchecked")
	public Resource createResource(URI uri) {

		XMIResource resource = new BlockDiagramResource(uri);
		injector.injectMembers(resource);

		resource.getDefaultLoadOptions().putAll(getDefaultLoadOptions());
		resource.getDefaultSaveOptions().putAll(getDefaultSaveOptions());

		if (!ENCODING.equals(resource.getEncoding())) {
			resource.setEncoding(ENCODING);
		}

		return resource;
	}

}
