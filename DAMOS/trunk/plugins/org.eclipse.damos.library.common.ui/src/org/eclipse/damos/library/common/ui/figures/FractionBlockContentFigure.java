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

package org.eclipse.damos.library.common.ui.figures;

import org.eclipse.damos.diagram.ui.figures.FontColorAwareFigure;
import org.eclipse.damos.diagram.ui.figures.IFigureConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

/**
 * @author Andreas Unger
 *
 */
public class FractionBlockContentFigure extends FontColorAwareFigure {

	private MathExpressionLabel numeratorLabel;
	private MathExpressionLabel denominatorLabel;
	
	/**
	 * 
	 */
	public FractionBlockContentFigure() {
		setLayoutManager(new GridLayout());
		numeratorLabel = new MathExpressionLabel();
		denominatorLabel = new MathExpressionLabel();
		add(numeratorLabel, new GridData(SWT.CENTER, SWT.CENTER, false, false));
		add(denominatorLabel, new GridData(SWT.CENTER, SWT.CENTER, false, false));
	}
	
	public String getNumerator() {
		return numeratorLabel.getText();
	}
	
	public void setNumerator(String numerator) {
		numeratorLabel.setText(numerator);
	}
	
	public String getDenominator() {
		return denominatorLabel.getText();
	}
	
	public void setDenominator(String denominator) {
		denominatorLabel.setText(denominator);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.LabelEx#paintFigure(org.eclipse.draw2d.Graphics)
	 */
	protected void paintFigure(Graphics graphics) {
		graphics.setForegroundColor(getFontColor());
		int y = numeratorLabel.getBounds().bottom();
		Rectangle bounds = getBounds();
		graphics.setLineWidth(IFigureConstants.DEFAULT_LINE_WIDTH);
		graphics.drawLine(bounds.x, y, bounds.x + bounds.width, y);
	}
	
}
