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

package org.eclipselabs.damos.library.base.simulation.ui.figures.io;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipselabs.damos.diagram.ui.figures.FontColorAwareFigure;
import org.eclipselabs.damos.diagram.ui.figures.IFigureConstants;

/**
 * @author Andreas Unger
 *
 */
public class ButtonContentFigure extends FontColorAwareFigure implements IFigureConstants {
	
	/**
	 * @author Andreas Unger
	 *
	 */
	public interface IButtonChangeListener {

		void buttonChanged(boolean pressed);
		
	}

	private List<IButtonChangeListener> buttonChangeListeners = new ArrayList<IButtonChangeListener>();

	private boolean pressed;
	
	/**
	 * 
	 */
	public ButtonContentFigure() {
		setPreferredSize(400, 400);
		addMouseListener(new MouseEventHandler());
	}
	
	public void addButtonChangeListener(IButtonChangeListener l) {
		if (!buttonChangeListeners.contains(l)) {
			buttonChangeListeners.add(l);
		}
	}

	public void removeButtonChangeListener(IButtonChangeListener l) {
		buttonChangeListeners.remove(l);
	}
	
	private void fireButtonChanged(boolean pressed) {
		for (IButtonChangeListener l : buttonChangeListeners) {
			l.buttonChanged(pressed);
		}
	}
	
	private void setPressed(boolean pressed) {
		this.pressed = pressed;
		repaint();
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.figures.BlockFigure#paintCanvas(org.eclipselabs.damos.diagram.figures.ICanvasContext)
	 */
	protected void paintFigure(Graphics g) {
    	g.setForegroundColor(getFontColor());
		g.setLineWidth(DEFAULT_LINE_WIDTH);
		Rectangle bounds = getBounds().getShrinked(DEFAULT_LINE_WIDTH_HALF, DEFAULT_LINE_WIDTH_HALF);

		int spacing = 2 * DEFAULT_LINE_WIDTH;
		if (pressed) {
			spacing += DEFAULT_LINE_WIDTH;
		}
		g.drawRectangle(bounds);
		g.setBackgroundColor(getFontColor());
		g.fillRectangle(bounds.shrink(spacing, spacing));
	}
	
	private class MouseEventHandler implements MouseListener {
		
		public void mousePressed(MouseEvent me) {
			me.consume();
			setPressed(true);
			fireButtonChanged(true);
		}

		public void mouseReleased(MouseEvent me) {
			setPressed(false);
			fireButtonChanged(false);
		}

		public void mouseDoubleClicked(MouseEvent me) {
		}
		
	}
	
}
