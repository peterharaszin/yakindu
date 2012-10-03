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

package org.eclipse.damos.diagram.ui.internal.geometry;

import org.eclipse.draw2d.geometry.Rectangle;

/**
 * @author Andreas Unger
 *
 */
public class Extents {

	public int top;
	public int bottom;
	public int left;
	public int right;

	/**
	 * 
	 */
	public Extents() {
	}
	
	/**
	 * 
	 */
	public Extents(int top, int bottom, int left, int right) {
		this.top = top;
		this.bottom = bottom;
		this.left = left;
		this.right = right;
	}
	
	public int getWidth() {
		return left + right;
	}
	
	public int getHeight() {
		return top + bottom;
	}
	
	public Extents expand(int horizontal, int vertical) {
		top += vertical;
		bottom += vertical;
		left += horizontal;
		right += horizontal;
		return this;
	}
	
	public Extents union(Extents extents) {
		if (extents.top > top) {
			top = extents.top;
		}
		if (extents.bottom > bottom) {
			bottom = extents.bottom;
		}
		if (extents.left > left) {
			left = extents.left;
		}
		if (extents.right > right) {
			right = extents.right;
		}
		return this;
	}
	
	public static Extents fromRectangle(Rectangle r) {
		Extents extents = new Extents();
		if (r.y < 0) {
			extents.top = -r.y;
		}
		int rBottom = r.y + r.height;
		if (rBottom > 0) {
			extents.bottom = rBottom;
		}
		if (r.x < 0) {
			extents.left = -r.x;
		}
		int rRight = r.x + r.width;
		if (rRight > 0) {
			extents.right = rRight;
		}
		return extents;
	}
	
}
