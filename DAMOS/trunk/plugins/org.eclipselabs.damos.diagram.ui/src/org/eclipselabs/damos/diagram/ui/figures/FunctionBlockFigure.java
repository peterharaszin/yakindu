package org.eclipselabs.damos.diagram.ui.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.LabelEx;
import org.eclipse.swt.SWT;

public class FunctionBlockFigure extends RectangularComponentFigure {
	
	private Label headerLabel;

	public FunctionBlockFigure() {
		ThreePaneLayout layout = new ThreePaneLayout();
		layout.setEqualPortExtents(true);
		setLayoutManager(layout);
		
		headerLabel = new HeaderFigure();
		add(headerLabel, new ThreePaneLayoutData(ThreePaneLayoutData.HEADER, SWT.FILL, SWT.FILL));
		add(new LabelEx(), new ThreePaneLayoutData(ThreePaneLayoutData.BODY, SWT.FILL, SWT.FILL));
	}
	
	public void setHeaderText(String text) {
		headerLabel.setText(text);
	}
	
	private class HeaderFigure extends FontColorAwareLabel {
		
		protected void paintFigure(Graphics g) {
			super.paintFigure(g);
			Rectangle bounds = getBounds();
			g.setLineWidth(IFigureConstants.DEFAULT_LINE_WIDTH);
			g.drawLine(bounds.x, bounds.bottom(), bounds.right(), bounds.bottom());
		}
		
	}

}
