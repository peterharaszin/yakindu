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

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.figures.LabelEx;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;

public class SubsystemFigure extends StandardComponentFigure implements IFigureConstants {
	
	private int borderStyle = SWT.LINE_DASH;
	private Label leftTextIcon;
	private Label rightTextIcon;
	private Label textLabel;
	
	/**
	 * 
	 */
	public SubsystemFigure() {
		((StandardComponentLayout) getLayoutManager()).setEqualPortExtents(true);
		
		Figure textContainer = new FontColorAwareFigure();
		textContainer.setLayoutManager(new GridLayout(3, false));
		
		leftTextIcon = new LabelEx();
		textContainer.add(leftTextIcon);
		textLabel = new FontColorAwareLabel();
		textContainer.add(textLabel);
		rightTextIcon = new LabelEx();
		textContainer.add(rightTextIcon);
		
		add(textContainer);
	}
	
	public Dimension calculateMinimumCanvasSize(int wHint, int hHint) {
		if (minSize == null) {
			minSize = getPreferredCanvasSize().getCopy();
			if (minSize.width < minSize.height) {
				minSize.width = minSize.height;
			}
		}
		return minSize;
	}

	protected void paintCanvas(ICanvasContext cc) {
		Dimension size = getCanvasSize();
		
		int x = DEFAULT_LINE_WIDTH_HALF;
		int y = DEFAULT_LINE_WIDTH_HALF;
		int width = size.width - DEFAULT_LINE_WIDTH;
		int height = size.height - DEFAULT_LINE_WIDTH;

		cc.setLineWidth(DEFAULT_LINE_WIDTH);
		cc.setLineStyle(borderStyle);
		cc.fillRectangle(x, y, width, height);
		cc.drawRectangle(x, y, width, height);
	}
	
	public void setBorderStyle(int borderStyle) {
		this.borderStyle = borderStyle;
		repaint();
	}
	
	public void setLeftTextIcon(Image image) {
		leftTextIcon.setIcon(image);
	}
	
	public void setRightTextIcon(Image image) {
		rightTextIcon.setIcon(image);
	}
	
	public void setText(String text) {
		textLabel.setText(text);
	}
	
}