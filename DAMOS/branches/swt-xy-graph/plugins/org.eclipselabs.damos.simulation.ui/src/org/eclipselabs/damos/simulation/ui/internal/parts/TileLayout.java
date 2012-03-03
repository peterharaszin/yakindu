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

package org.eclipselabs.damos.simulation.ui.internal.parts;

import java.util.Iterator;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * @author Andreas Unger
 *
 */
public class TileLayout extends AbstractLayout {
	
	private double ratio;
	
	private int singletonIndex;

	/**
	 * 
	 */
	public TileLayout(double ratio) {
		this.ratio = ratio;
	}
	
	public void setContextFigure(int singletonIndex) {
		this.singletonIndex = singletonIndex;
		invalidate();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.AbstractLayout#calculatePreferredSize(org.eclipse.draw2d.IFigure, int, int)
	 */
	@Override
	protected Dimension calculatePreferredSize(IFigure container, int wHint, int hHint) {
		return new Dimension(wHint, hHint);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.LayoutManager#layout(org.eclipse.draw2d.IFigure)
	 */
	public void layout(IFigure container) {
		if (singletonIndex >= 0 && singletonIndex < container.getChildren().size()) {
			((IFigure) container.getChildren().get(singletonIndex)).setBounds(container.getBounds().getCopy());
			return;
		}
		
		int[] dimensions = computeMatrixDimensions(container);
		if (dimensions[0] == 0 || dimensions[1] == 0) {
			return;
		}
		
		Rectangle bounds = container.getBounds();
		int width = bounds.width / dimensions[0];
		int height = bounds.height / dimensions[1];

		Iterator<?> it = container.getChildren().iterator();
		for (int y = 0; y < dimensions[1]; ++y) {
			for (int x = 0; x < dimensions[0]; ++x) {
				if (!it.hasNext()) {
					return;
				}
				IFigure child = (IFigure) it.next();
				child.setBounds(new Rectangle(x * width, y * height, width, height));
			}
		}
	}
	
	private int[] computeMatrixDimensions(IFigure container) {
		Rectangle bounds = container.getBounds();

		int childCount = container.getChildren().size();
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
