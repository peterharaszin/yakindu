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

package org.eclipselabs.damos.diagram.ui.figures;

import org.eclipse.swt.graphics.Color;

/**
 * @author Andreas Unger
 *
 * @noextend
 * @noimplement
 */
public interface IFigureConstants {

	int UNIT = 26;

	int DEFAULT_LINE_WIDTH = UNIT;
	int DEFAULT_LINE_WIDTH_HALF = DEFAULT_LINE_WIDTH / 2;
	
	int DEFAULT_TERMINAL_SIZE = 4 * UNIT;

	Color DEFAULT_TERMINAL_COLOR = new Color(null, 0xb3, 0x00, 0x77);
	
}
