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

import org.eclipse.draw2d.geometry.PointList;

/**
 * @author Andreas Unger
 *
 */
public class PointListEx extends org.eclipse.draw2d.geometry.PointList {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4600423676833249958L;
	
	/**
	 * 
	 */
	public PointListEx() {
	}
	
	/**
	 * 
	 */
	public PointListEx(int x1, int y1, int x2, int y2) {
		super(new int[] {x1, y1, x2, y2});
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o instanceof PointList) {
			PointList pointList = (PointList) o;
			if (pointList.size() != size()) {
				return false;
			}
			for (int i = 0; i < size(); ++i) {
				if (!pointList.getPoint(i).equals(getPoint(i))) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		int hashCode = 0;
		for (int i = 0; i < size(); ++i) {
			hashCode ^= getPoint(i).hashCode();
		}
		return hashCode;
	}
	
}
