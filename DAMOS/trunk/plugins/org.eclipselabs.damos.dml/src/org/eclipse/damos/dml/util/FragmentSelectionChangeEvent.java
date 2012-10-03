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

package org.eclipse.damos.dml.util;

import java.util.EventObject;

import org.eclipse.damos.dml.Fragment;

/**
 * @author Andreas Unger
 *
 */
public class FragmentSelectionChangeEvent extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Fragment selectedFragment;
	
	/**
	 * @param source
	 */
	public FragmentSelectionChangeEvent(Object source, Fragment selectedFragment) {
		super(source);
		this.selectedFragment = selectedFragment;
	}
	
	/**
	 * @return the fragment
	 */
	public Fragment getSelectedFragment() {
		return selectedFragment;
	}

}
