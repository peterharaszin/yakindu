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

package org.eclipse.damos.diagram.ui.internal.palette;

import org.eclipse.jface.resource.ImageDescriptor;

/**
 * @author Andreas Unger
 *
 */
public class PaletteDrawer extends org.eclipse.gef.palette.PaletteDrawer {

	/**
	 * @param label
	 * @param icon
	 */
	public PaletteDrawer(String label) {
		super(label);
	}

	/**
	 * @param label
	 * @param icon
	 */
	public PaletteDrawer(String label, ImageDescriptor icon) {
		super(label, icon);
	}

	@Override
	public boolean acceptsType(Object type) {
		if (LinkEntry.PALETTE_TYPE_LINK.equals(type)) {
			return true;
		}
		return super.acceptsType(type);
	}

}
