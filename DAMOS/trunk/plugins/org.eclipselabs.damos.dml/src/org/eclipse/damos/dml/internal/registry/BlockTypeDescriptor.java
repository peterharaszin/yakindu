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

package org.eclipse.damos.dml.internal.registry;

import org.eclipse.damos.dml.registry.IBlockGroupDescriptor;
import org.eclipse.damos.dml.registry.IBlockTypeDescriptor;
import org.eclipse.emf.common.util.URI;

/**
 * @author Andreas Unger
 *
 */
public class BlockTypeDescriptor implements IBlockTypeDescriptor {

	private String qualifiedName;
	private String name;
	private URI uri;
	private BlockGroupDescriptor group;
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.dml.internal.services.BlockTypeDescriptor#getId()
	 */
	public String getQualifiedName() {
		return qualifiedName;
	}
	
	/**
	 * @param qualifiedName the qualified name to set
	 */
	public void setQualifiedName(String qualifiedName) {
		this.qualifiedName = qualifiedName;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.dml.internal.services.BlockTypeDescriptor#getName()
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
	 * @see org.eclipse.damos.dml.internal.services.BlockTypeDescriptor#getUri()
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
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.dml.internal.services.BlockTypeDescriptor#getGroup()
	 */
	public IBlockGroupDescriptor getGroup() {
		return group;
	}
	
	/**
	 * @param group the group to set
	 */
	public void setGroup(BlockGroupDescriptor group) {
		this.group = group;
		this.group.blockTypes.add(this);
	}
	
}
