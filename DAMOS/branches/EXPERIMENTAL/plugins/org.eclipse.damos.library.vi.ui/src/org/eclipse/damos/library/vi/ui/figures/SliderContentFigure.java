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

package org.eclipse.damos.library.vi.ui.figures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.damos.diagram.ui.figures.FontColorAwareFigure;
import org.eclipse.damos.diagram.ui.figures.IFigureConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * @author Andreas Unger
 *
 */
public class SliderContentFigure extends FontColorAwareFigure implements IFigureConstants {
	
	/**
	 * @author Andreas Unger
	 *
	 */
	public interface ISliderChangeListener {

		void positionChanged();
		
	}

	private List<ISliderChangeListener> sliderChangeListeners = new ArrayList<ISliderChangeListener>();
	
	private static final int SLIDER_HANDLE_WIDTH = 200;
	
	private double position;
	
	/**
	 * 
	 */
	public SliderContentFigure() {
		setPreferredSize(1500, 500);
		MouseEventHandler mouseEventHandler = new MouseEventHandler();
		addMouseListener(mouseEventHandler);
		addMouseMotionListener(mouseEventHandler);
	}
	
	/**
	 * @return the position
	 */
	public double getPosition() {
		return position;
	}
	
	/**
	 * @param position the position to set
	 */
	public void setPosition(double position) {
		if (this.position == position) {
			return;
		}
		this.position = position;
		repaint();
	}
	
	public void addSliderChangeListener(ISliderChangeListener l) {
		if (!sliderChangeListeners.contains(l)) {
			sliderChangeListeners.add(l);
		}
	}

	public void removeSliderChangeListener(ISliderChangeListener l) {
		sliderChangeListeners.remove(l);
	}
	
	private void fireSliderChanged() {
		for (ISliderChangeListener l : sliderChangeListeners) {
			l.positionChanged();
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.BlockFigure#paintCanvas(org.eclipse.damos.diagram.figures.ICanvasContext)
	 */
	protected void paintFigure(Graphics g) {
    	g.setForegroundColor(getFontColor());
		g.setLineWidth(DEFAULT_LINE_WIDTH);
		Rectangle bounds = getBounds().getCopy().shrink(DEFAULT_LINE_WIDTH_HALF, DEFAULT_LINE_WIDTH_HALF);
		
		int centerY = bounds.y + bounds.height / 2;
		g.drawLine(bounds.x + SLIDER_HANDLE_WIDTH / 2, centerY, bounds.right() - SLIDER_HANDLE_WIDTH / 2, centerY);
		g.setBackgroundColor(getFontColor());
		g.fillRectangle(getSliderHandleBounds());
	}
	
	private Rectangle getSliderHandleBounds() {
		Rectangle bounds = getBounds();
		int sliderRange = getSliderRange();
		int x = bounds.x + (int) Math.round(sliderRange * (position));
		int y = bounds.y;
		int width = SLIDER_HANDLE_WIDTH;
		int height = bounds.height;
		return new Rectangle(x, y, width, height);
	}

	/**
	 * @return
	 */
	private int getSliderRange() {
		return getBounds().width - SLIDER_HANDLE_WIDTH;
	}
	
	private class MouseEventHandler implements MouseListener, MouseMotionListener {
		
		private Point mouseStartLocation;
		private double originalPosition = Double.NaN;
		
		public void mousePressed(MouseEvent me) {
			Rectangle sliderHandleBounds = getSliderHandleBounds();
			if (sliderHandleBounds.contains(me.getLocation())) {
				mouseStartLocation = me.getLocation();
				originalPosition = position;
				me.consume();
			}
		}

		public void mouseReleased(MouseEvent me) {
			mouseStartLocation = null;
			originalPosition = Double.NaN;
		}

		public void mouseDoubleClicked(MouseEvent me) {
		}

		public void mouseDragged(MouseEvent me) {
			if (mouseStartLocation != null) {
				double newPosition = originalPosition + (double) (me.getLocation().x - mouseStartLocation.x) / getSliderRange();
				if (newPosition > 1) {
					newPosition = 1;
				} else if (newPosition < 0) {
					newPosition = 0;
				}
				if (newPosition != position) {
					setPosition(newPosition);
					fireSliderChanged();
				}
			}
		}

		public void mouseEntered(MouseEvent me) {
		}

		public void mouseExited(MouseEvent me) {
		}

		public void mouseHover(MouseEvent me) {
		}

		public void mouseMoved(MouseEvent me) {
		}

	}
	
}
