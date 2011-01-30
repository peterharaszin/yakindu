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

package org.eclipselabs.damos.dml.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

/**
 * @author Andreas Unger
 *
 */
public class DMLResource extends XMIResourceImpl {

	/**
	 * 
	 */
	public DMLResource() {
		super();
	}
	
	public DMLResource(URI uri) {
		super(uri);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl#useUUIDs()
	 */
	@Override
	protected boolean useUUIDs() {
		return true;
	}
	
}
