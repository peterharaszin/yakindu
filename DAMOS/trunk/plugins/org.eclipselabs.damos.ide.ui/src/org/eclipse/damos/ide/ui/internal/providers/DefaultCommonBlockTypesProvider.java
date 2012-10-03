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

package org.eclipse.damos.ide.ui.internal.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.damos.diagram.ui.preferences.IDefaultCommonBlockTypesProvider;

/**
 * @author Andreas Unger
 *
 */
public class DefaultCommonBlockTypesProvider implements IDefaultCommonBlockTypesProvider {

	private static final List<String> BLOCK_TYPES = new ArrayList<String>();
	
	static {
        BLOCK_TYPES.add("damos.blocks.Constant");
        BLOCK_TYPES.add("damos.blocks.Step");
        BLOCK_TYPES.add("damos.blocks.Scope");
        BLOCK_TYPES.add("|");
        BLOCK_TYPES.add("damos.blocks.Gain");
        BLOCK_TYPES.add("damos.blocks.Sum");
        BLOCK_TYPES.add("|");
        BLOCK_TYPES.add("damos.blocks.And");
        BLOCK_TYPES.add("damos.blocks.Or");
        BLOCK_TYPES.add("damos.blocks.Inverter");
        BLOCK_TYPES.add("damos.blocks.Compare");
        BLOCK_TYPES.add("|");
        BLOCK_TYPES.add("damos.blocks.TransferFunction");
        BLOCK_TYPES.add("damos.blocks.Integrator");
        BLOCK_TYPES.add("damos.blocks.DiscreteIntegrator");
        BLOCK_TYPES.add("damos.blocks.Delay");
        BLOCK_TYPES.add("|");
        BLOCK_TYPES.add("damos.blocks.Saturation");
        BLOCK_TYPES.add("damos.blocks.Switch");
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.preferences.IDefaultCommonBlockTypesProvider#getBlockTypes()
	 */
	public List<String> getBlockTypes() {
		return BLOCK_TYPES;
	}

}
