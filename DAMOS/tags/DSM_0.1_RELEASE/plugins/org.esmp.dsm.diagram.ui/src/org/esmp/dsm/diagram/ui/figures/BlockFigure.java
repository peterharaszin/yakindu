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

package org.esmp.dsm.diagram.ui.figures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.esmp.dsm.diagram.core.internal.util.MathUtil;
import org.esmp.dsm.diagram.ui.internal.figures.CanvasContextImpl;
import org.esmp.dsm.diagram.ui.internal.figures.TerminalBorderFigure;

public abstract class BlockFigure extends NodeFigure {

	private boolean flipped;
	private int rotation;

	/* (non-Javadoc)
	 * @see org.esmp.dsm.diagram.figures.ITransformableFigure#isFlipped()
	 */
	public boolean isFlipped() {
		return flipped;
	}

	/* (non-Javadoc)
	 * @see org.esmp.dsm.diagram.figures.ITransformableFigure#setFlipped(boolean)
	 */
	public void setFlipped(boolean flipped) {
		this.flipped = flipped;
		revalidate();
		repaint();
	}

	/* (non-Javadoc)
	 * @see org.esmp.dsm.diagram.figures.ITransformableFigure#getRotation()
	 */
	public int getRotation() {
		return rotation;
	}

	/* (non-Javadoc)
	 * @see org.esmp.dsm.diagram.figures.ITransformableFigure#setRotation(int)
	 */
	public void setRotation(int rotation) {
		this.rotation = MathUtil.normalizeAngle(rotation);
		revalidate();
		repaint();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	public Object getHelper(Class<?> clazz) {
		return null;
	}
	
	public List<IFigure> getContentFigures() {
		List<IFigure> contentFigures = new ArrayList<IFigure>();
		for (Object o : getChildren()) {
			if (!(o instanceof PortFigure || o instanceof TerminalBorderFigure)) {
				contentFigures.add((IFigure) o);
			}
		}
		return contentFigures;
	}

	public IFigure getPrimaryContentFigure() {
		List<IFigure> contentFigures = getContentFigures();
		return contentFigures.isEmpty() ? null : contentFigures.get(0);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.Figure#getMinimumSize(int, int)
	 */
	public Dimension getMinimumSize(int wHint, int hHint) {
		if (minSize == null) {
			Dimension calculatedMinSize = calculateMinimumSize(wHint, hHint);
			if (calculatedMinSize != null) {
				minSize = calculatedMinSize;
			} else {
				minSize = super.getMinimumSize(wHint, hHint);
			}
		}
		return minSize;
	}
	
	/* (non-Javadoc)
	 * @see org.esmp.dsm.diagram.figures.BlockFigure#calculateMinimumSize(int, int)
	 */
	private Dimension calculateMinimumSize(int wHint, int hHint) {
		Dimension size = calculateMinimumCanvasSize(wHint, hHint);
		if (size != null && (rotation == 90 || rotation == 270)) {
			size.transpose();
		}
		return size;
	}

	protected Dimension calculateMinimumCanvasSize(int wHint, int hHint) {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.Figure#getPreferredSize(int, int)
	 */
	public final Dimension getPreferredCanvasSize() {
		return getPreferredCanvasSize(-1, -1);
	}
	
	/* (non-Javadoc)
	 * @see org.esmp.dsm.diagram.figures.BlockFigure#getPreferredCanvasSize(int, int)
	 */
	public Dimension getPreferredCanvasSize(int wHint, int hHint) {
		Dimension size = getPreferredSize(wHint, hHint).getCopy();
		if (rotation == 90 || rotation == 270) {
			size.transpose();
		}
		return size;
	}
	
	public Dimension getCanvasSize() {
		Dimension size = getSize().getCopy();
		if (rotation == 90 || rotation == 270) {
			size.transpose();
		}
		return size;
	}

	/* (non-Javadoc)
	 * @see org.esmp.dsm.diagram.figures.TransformableBlockFigure#invalidate()
	 */
	public void invalidate() {
		minSize = null;
		for (Object o : getChildren()) {
			((IFigure) o).invalidate();
		}
		super.invalidate();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#paintFigure(org.eclipse.draw2d.Graphics)
	 */
	protected void paintFigure(Graphics graphics) {
		Rectangle bounds = getBounds();
		graphics.translate(bounds.x, bounds.y);
		paintCanvas(new CanvasContextImpl(graphics, getCanvasSize(), flipped, rotation));
	}

	protected void paintCanvas(CanvasContext cc) {
	}

}
