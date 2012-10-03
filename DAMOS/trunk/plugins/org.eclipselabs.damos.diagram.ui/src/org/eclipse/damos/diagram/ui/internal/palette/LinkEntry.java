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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ActionListener;
import org.eclipse.gef.palette.PaletteEntry;

/**
 * @author Andreas Unger
 *
 */
public class LinkEntry extends PaletteEntry {

	public static final Object PALETTE_TYPE_LINK = "$Palette Link";
	
	private List<ActionListener> actionListeners = new ArrayList<ActionListener>();
	
	/**
	 * @param label
	 * @param shortDescription
	 */
	public LinkEntry(String label, String shortDescription) {
		super(label, shortDescription, PALETTE_TYPE_LINK);
	}
	
	/**
	 * @return the actionListeners
	 */
	public List<ActionListener> getActionListeners() {
		return actionListeners;
	}
	
	public void addActionListener(ActionListener l) {
		actionListeners.add(l);
	}

}
