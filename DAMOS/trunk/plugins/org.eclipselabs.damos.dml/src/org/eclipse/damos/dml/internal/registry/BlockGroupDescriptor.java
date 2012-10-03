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

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.damos.dml.registry.IBlockGroupDescriptor;
import org.eclipse.damos.dml.registry.IBlockTypeDescriptor;
import org.eclipse.damos.dml.registry.ILanguageDescriptor;

/**
 * @author Andreas Unger
 *
 */
public class BlockGroupDescriptor implements IBlockGroupDescriptor {

	private String id;
	private String name;
	private BlockGroupDescriptor supergroup;
	
	Collection<IBlockGroupDescriptor> subgroups = new ArrayList<IBlockGroupDescriptor>();
	Collection<IBlockTypeDescriptor> blockTypes = new ArrayList<IBlockTypeDescriptor>();
	
	private ILanguageDescriptor language;
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.dml.internal.services.BlockGroupDescriptor#getId()
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
	 * @see org.eclipse.damos.dml.internal.services.BlockGroupDescriptor#getName()
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
	 * @see org.eclipse.damos.dml.internal.services.BlockGroupDescriptor#getSupergroup()
	 */
	public IBlockGroupDescriptor getSupergroup() {
		return supergroup;
	}
	
	/**
	 * @param supergroup the supergroup to set
	 */
	public void setSupergroup(BlockGroupDescriptor supergroup) {
		this.supergroup = supergroup;
		this.supergroup.subgroups.add(this);
	}
	
	/**
	 * @return the subgroups
	 */
	public Collection<IBlockGroupDescriptor> getSubgroups() {
		return subgroups;
	}
	
	/**
	 * @return the blockTypes
	 */
	public Collection<IBlockTypeDescriptor> getBlockTypes() {
		return blockTypes;
	}
	
	/**
	 * @return the language
	 */
	public ILanguageDescriptor getLanguage() {
		if (language == null && supergroup != null) {
			return supergroup.language;
		}
		return language;
	}
	
	/**
	 * @param language the language to set
	 */
	public void setLanguage(ILanguageDescriptor language) {
		this.language = language;
	}
	
}
