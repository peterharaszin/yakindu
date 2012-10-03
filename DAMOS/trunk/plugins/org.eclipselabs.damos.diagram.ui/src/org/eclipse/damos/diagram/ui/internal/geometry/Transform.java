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

import org.eclipse.draw2d.geometry.PointList;

/**
 * @author Andreas Unger
 *
 */
public class Transform extends org.eclipse.draw2d.geometry.Transform {

	public PointList getTransformed(PointList points) {
		PointList pointsCopy = new PointList(points.size());
		for (int i = 0; i < points.size(); ++i) {
			pointsCopy.addPoint(getTransformed(points.getPoint(i)));
		}
		return pointsCopy;
	}
	
}
