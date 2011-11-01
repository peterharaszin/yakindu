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

package org.eclipselabs.damos.simulation.simulationmodel.internal.registry;

import org.eclipse.emf.common.util.URI;
import org.eclipselabs.damos.simulation.simulationmodel.registry.ISolverTypeDescriptor;

/**
 * @author Andreas Unger
 *
 */
public class SolverTypeDescriptor implements ISolverTypeDescriptor {

	private String qualifiedName;
	private URI uri;
	
	public String getQualifiedName() {
		return qualifiedName;
	}
	
	public void setQualifiedName(String qualifiedName) {
		this.qualifiedName = qualifiedName;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulationmodel.internal.registry.ISolverConfigurationDescriptor#getURI()
	 */
	public URI getURI() {
		return uri;
	}
	
	/**
	 * @param uri the uri to set
	 */
	public void setURI(URI uri) {
		this.uri = uri;
	}
	
}
