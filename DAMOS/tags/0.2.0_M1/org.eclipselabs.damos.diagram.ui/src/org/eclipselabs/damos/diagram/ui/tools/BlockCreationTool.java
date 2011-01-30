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

import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.tools.CreationTool;
import org.eclipselabs.damos.diagram.core.type.ElementTypes;
import org.eclipselabs.damos.dml.BlockType;


/**
 * @author Andreas Unger
 *
 */
public class BlockCreationTool extends CreationTool {

	private BlockType blockType;
	
	/**
	 * 
	 */
	public BlockCreationTool(BlockType blockType) {
		super(ElementTypes.BLOCK);
		this.blockType = blockType;
	}
	
	@SuppressWarnings("unchecked")
	protected Request createTargetRequest() {
		Request request = super.createTargetRequest();
		request.getExtendedData().put(BlockType.class, blockType);
		return request;
	}
	
}
