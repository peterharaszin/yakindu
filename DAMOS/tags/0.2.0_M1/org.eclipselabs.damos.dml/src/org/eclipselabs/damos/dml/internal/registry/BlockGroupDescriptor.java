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

package org.eclipselabs.damos.dml.internal.registry;

import org.eclipselabs.damos.dml.registry.IBlockGroupDescriptor;

/**
 * @author Andreas Unger
 *
 */
public class BlockGroupDescriptor implements IBlockGroupDescriptor {

	private String id;
	private String name;
	private IBlockGroupDescriptor supergroup;
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.internal.services.BlockGroupDescriptor#getId()
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.internal.services.BlockGroupDescriptor#getName()
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.internal.services.BlockGroupDescriptor#getSupergroup()
	 */
	public IBlockGroupDescriptor getSupergroup() {
		return supergroup;
	}
	
	/**
	 * @param supergroup the supergroup to set
	 */
	public void setSupergroup(IBlockGroupDescriptor supergroup) {
		this.supergroup = supergroup;
	}
	
}
