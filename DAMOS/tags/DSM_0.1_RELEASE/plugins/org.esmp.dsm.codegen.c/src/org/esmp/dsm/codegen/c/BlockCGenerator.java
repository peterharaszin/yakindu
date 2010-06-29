/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.esmp.dsm.codegen.c;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.esmp.dsm.semantic.blockdiagram.Block;

/**
 * @author Andreas Unger
 *
 */
public abstract class BlockCGenerator extends AdapterImpl implements IAdaptable {
	
	private IConfigurationElement configurationElement;
	
	/**
	 * 
	 */
	public BlockCGenerator(IConfigurationElement configurationElement) {
		this.configurationElement = configurationElement;
	}
	
	public abstract void generate(CCodegenContext context);
	
	/**
	 * @return the configurationElement
	 */
	protected IConfigurationElement getConfigurationElement() {
		return configurationElement;
	}
	
	public boolean isAdapterForType(Object type) {
		return type == BlockCGenerator.class;
	}
	
	public Block getTarget() {
		return (Block) super.getTarget();
	}

	@SuppressWarnings("unchecked")
	public Object getAdapter(Class adapter) {
		return Platform.getAdapterManager().getAdapter(this, adapter);
	}

}
