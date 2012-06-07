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

package org.eclipselabs.damos.ide.ui.internal.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipselabs.damos.diagram.ui.preferences.IDefaultCommonBlockTypesProvider;

/**
 * @author Andreas Unger
 *
 */
public class DefaultCommonBlockTypesProvider implements IDefaultCommonBlockTypesProvider {

	private static final List<String> BLOCK_TYPES = new ArrayList<String>();
	
	static {
        BLOCK_TYPES.add("damos.library.base.sources.Constant");
        BLOCK_TYPES.add("damos.library.base.sources.Step");
        BLOCK_TYPES.add("damos.library.base.sinks.Scope");
        BLOCK_TYPES.add("|");
        BLOCK_TYPES.add("damos.library.base.math.Gain");
        BLOCK_TYPES.add("damos.library.base.math.Sum");
        BLOCK_TYPES.add("|");
        BLOCK_TYPES.add("damos.library.base.logic.And");
        BLOCK_TYPES.add("damos.library.base.logic.Or");
        BLOCK_TYPES.add("damos.library.base.logic.Inverter");
        BLOCK_TYPES.add("damos.library.base.logic.Compare");
        BLOCK_TYPES.add("|");
        BLOCK_TYPES.add("damos.library.base.continuous.TransferFunction");
        BLOCK_TYPES.add("damos.library.base.continuous.Integrator");
        BLOCK_TYPES.add("damos.library.base.discrete.DiscreteIntegrator");
        BLOCK_TYPES.add("damos.library.base.discrete.Delay");
        BLOCK_TYPES.add("|");
        BLOCK_TYPES.add("damos.library.base.discontinuities.Saturation");
        BLOCK_TYPES.add("damos.library.base.signal.Switch");
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.preferences.IDefaultCommonBlockTypesProvider#getBlockTypes()
	 */
	public List<String> getBlockTypes() {
		return BLOCK_TYPES;
	}

}
