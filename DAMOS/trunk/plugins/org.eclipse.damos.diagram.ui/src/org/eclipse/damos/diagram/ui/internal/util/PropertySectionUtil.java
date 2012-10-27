/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.diagram.ui.internal.util;

import org.eclipse.swt.graphics.GC;

/**
 * @author Andreas Unger
 *
 */
public class PropertySectionUtil {

	public static int calculateMinimumLabelWidth(GC gc) {
		return gc.textExtent("XXXXXXXXXXXXXXXXXXXXXX").x;
	}

	public static int calculateStandardLabelWidth(GC gc, String[] labels, int minimumLabelWidth) {
		int standardLabelWidth = minimumLabelWidth;
		int indent = gc.textExtent("XX").x; //$NON-NLS-1$
		for (int i = 0; i < labels.length; i++) {
			int width = gc.textExtent(labels[i]).x;
			if (width + indent > standardLabelWidth) {
				standardLabelWidth = width + indent;
			}
		}
		gc.dispose();
		return standardLabelWidth;
	}
	
}
