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

package org.eclipse.damos.simulation.ui.internal.parts;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;

/**
 * @author Andreas Unger
 *
 */
public class TileLayout extends Layout {
	
	private double ratio;
	
	/**
	 * 
	 */
	public TileLayout(double ratio) {
		this.ratio = ratio;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Layout#computeSize(org.eclipse.swt.widgets.Composite, int, int, boolean)
	 */
	@Override
	protected Point computeSize(Composite composite, int wHint, int hHint, boolean flushCache) {
		return new Point(wHint, hHint);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Layout#flushCache(org.eclipse.swt.widgets.Control)
	 */
	@Override
	protected boolean flushCache(Control control) {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Layout#layout(org.eclipse.swt.widgets.Composite, boolean)
	 */
	@Override
	protected void layout(Composite composite, boolean flushCache) {
		int[] dimensions = computeMatrixDimensions(composite);
		if (dimensions[0] == 0 || dimensions[1] == 0) {
			return;
		}
		
		Rectangle bounds = composite.getClientArea();
		int width = bounds.width / dimensions[0];
		int height = bounds.height / dimensions[1];

		Control[] children = composite.getChildren();
		for (int i = 0, y = 0; y < dimensions[1]; ++y) {
			for (int x = 0; x < dimensions[0]; ++x) {
				if (i >= children.length) {
					return;
				}
				Control child = children[i++];
				child.setBounds(x * width, y * height, width, height);
				child.setVisible(true);
			}
		}
	}
	
	private int[] computeMatrixDimensions(Composite composite) {
		Rectangle bounds = composite.getBounds();

		int childCount = composite.getChildren().length;
		if (childCount == 0) {
			return new int[] { 0, 0 };
		}
		
		int x = childCount;
		int y = 1;
		int[] dimensions = new int[] { x, y };		
		double bestRatioDifference = Double.POSITIVE_INFINITY;

		for (;;) {
			double ratioDifference = Math.abs(((double) bounds.width / x) / ((double) bounds.height / y) - ratio);
			if (bestRatioDifference > ratioDifference) {
				bestRatioDifference = ratioDifference;
				dimensions[0] = x;
				dimensions[1] = y;
			}
			if (x == 1) {
				break;
			}
			++y;
			while ((x - 1) * y >= childCount) {
				--x;
			}
		}
		
		return dimensions;
	}

}
