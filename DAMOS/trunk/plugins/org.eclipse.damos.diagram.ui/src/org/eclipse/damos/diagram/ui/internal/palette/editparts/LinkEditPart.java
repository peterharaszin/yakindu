/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.diagram.ui.internal.palette.editparts;

import org.eclipse.damos.diagram.ui.internal.palette.LinkEntry;
import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.Clickable;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Cursors;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ui.palette.editparts.PaletteEditPart;

/**
 * @author Andreas Unger
 *
 */
public class LinkEditPart extends PaletteEditPart {

	/**
	 * @param model
	 */
	public LinkEditPart(LinkEntry model) {
		super(model);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractEditPart#getModel()
	 */
	@Override
	public LinkEntry getModel() {
		return (LinkEntry) super.getModel();
	}

	@Override
	protected IFigure createFigure() {
		LinkEntry linkEntry = getModel();
		LinkFigure linkFigure = new LinkFigure(linkEntry.getLabel(), linkEntry.getDescription());
		for (ActionListener l : linkEntry.getActionListeners()) {
			linkFigure.addActionListener(l);
		}
		return linkFigure;
	}
	
	private class LinkFigure extends Clickable {
		
		private Label label;
		
		/**
		 * 
		 */
		public LinkFigure(String text, String tooltip) {
			setCursor(Cursors.HAND);

			label = new UnderlinedLabel(text);
			if (tooltip != null) {
				label.setToolTip(new Label(tooltip));
			}
			label.setForegroundColor(ColorConstants.darkBlue);

			addMouseMotionListener(new MouseMotionListener.Stub() {

				public void mouseEntered(MouseEvent me) {
					label.setForegroundColor(ColorConstants.blue);
				}

				public void mouseExited(MouseEvent me) {
					label.setForegroundColor(ColorConstants.darkBlue);
				}
				
			});
			
			setContents(label);
		}
		
	}
	
	/**
	 * @author Andreas Unger
	 *
	 */
	private final class UnderlinedLabel extends Label {

		private UnderlinedLabel(String s) {
			super(s);
		}

		@Override
		protected void paintFigure(Graphics graphics) {
			super.paintFigure(graphics);
			
			Rectangle textBounds = getTextBounds();
			int ascent = getTextUtilities().getAscent(getFont());
			int y = textBounds.y + ascent + 1;
			
		    graphics.drawLine(textBounds.x, y, textBounds.getRight().x, y);
		}
		
	}

}
