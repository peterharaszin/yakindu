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

package org.eclipse.damos.diagram.ui.internal.figures;

import org.eclipse.damos.diagram.core.internal.util.MathUtil;
import org.eclipse.draw2d.PositionConstants;

/**
 * @author Andreas Unger
 *
 */
public class FigureUtil {

	public static int rotationToOrientation(double rotation) {
		switch (MathUtil.normalizeAngle((int) Math.round(Math.toDegrees(rotation)))) {
		case 0:
			return PositionConstants.EAST;
		case 45:
			return PositionConstants.NORTH_EAST;
		case 90:
			return PositionConstants.NORTH;
		case 135:
			return PositionConstants.NORTH_WEST;
		case 180:
			return PositionConstants.WEST;
		case 225:
			return PositionConstants.SOUTH_WEST;
		case 270:
			return PositionConstants.SOUTH;
		case 315:
			return PositionConstants.SOUTH_EAST;
		}
		return PositionConstants.NONE;
	}

}
