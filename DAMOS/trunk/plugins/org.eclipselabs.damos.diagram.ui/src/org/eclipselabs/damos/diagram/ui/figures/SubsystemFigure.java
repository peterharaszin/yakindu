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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.figures.LabelEx;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;

public class SubsystemFigure extends ComponentFigure implements IFigureConstants {
	
	private int borderStyle = SWT.LINE_DASH;
	
	private Label systemInterfaceNameLabel;
	private Label overrideIcon;
	
	/**
	 * 
	 */
	public SubsystemFigure() {
		ThreePaneLayout layout = new ThreePaneLayout();
		layout.setEqualPortExtents(true);
		layout.setTopHeaderPadding(IFigureConstants.DEFAULT_LINE_WIDTH);
		layout.setHorizontalHeaderPadding(300);
		setLayoutManager(layout);
		
		systemInterfaceNameLabel = new LabelEx();
		systemInterfaceNameLabel.setOpaque(true);
		systemInterfaceNameLabel.setForegroundColor(ColorConstants.white);
		systemInterfaceNameLabel.setBackgroundColor(ColorConstants.black);
		
		add(systemInterfaceNameLabel, new ThreePaneLayoutData(ThreePaneLayoutData.HEADER, SWT.CENTER, SWT.BEGINNING));

		overrideIcon = new LabelEx();
		add(overrideIcon, new ThreePaneLayoutData(ThreePaneLayoutData.BODY));
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
	
	public void setOverrideIcon(Image image) {
		overrideIcon.setIcon(image);
	}
	
	public void setSystemInterfaceName(String text) {
		systemInterfaceNameLabel.setText(" " + text + " ");
	}
	
}