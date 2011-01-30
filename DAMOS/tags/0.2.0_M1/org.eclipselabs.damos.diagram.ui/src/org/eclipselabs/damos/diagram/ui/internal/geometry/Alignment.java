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

package org.eclipselabs.damos.diagram.ui.internal.geometry;

/**
 * @author Andreas Unger
 *
 */
public class Alignment {

	public int horizontal;
	public int vertical;
	
	/**
	 * 
	 */
	public Alignment() {
	}
	
	/**
	 * 
	 */
	public Alignment(int horizontal, int vertical) {
		this.horizontal = horizontal;
		this.vertical = vertical;
	}
	
}
