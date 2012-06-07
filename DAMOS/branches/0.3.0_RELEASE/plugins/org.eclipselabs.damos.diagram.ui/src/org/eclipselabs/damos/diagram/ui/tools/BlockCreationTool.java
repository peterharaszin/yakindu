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

package org.eclipselabs.damos.diagram.ui.tools;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.tools.CreationTool;
import org.eclipselabs.damos.diagram.core.internal.provider.IBlockTypeProvider;
import org.eclipselabs.damos.diagram.core.type.ElementTypes;
import org.eclipselabs.damos.diagram.ui.internal.providers.BlockTypeProvider;
import org.eclipselabs.damos.dml.registry.IBlockTypeDescriptor;

/**
 * @author Andreas Unger
 *
 */
public class BlockCreationTool extends CreationTool {

	private EditingDomain editingDomain;
	private IBlockTypeDescriptor blockType;
	
	/**
	 * 
	 */
	public BlockCreationTool(EditingDomain editingDomain, IBlockTypeDescriptor blockType) {
		super(ElementTypes.BLOCK);
		this.editingDomain = editingDomain;
		this.blockType = blockType;
	}
	
	@SuppressWarnings("unchecked")
	protected Request createTargetRequest() {
		Request request = super.createTargetRequest();
		request.getExtendedData().put(IBlockTypeProvider.class, new BlockTypeProvider(editingDomain, blockType));
		return request;
	}
	
}
