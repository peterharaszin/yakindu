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

package org.eclipselabs.damos.diagram.ui.editpolicies;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.widgets.Display;
import org.eclipselabs.damos.diagram.ui.internal.editparts.SnapToConnector;

/**
 * @author Andreas Unger
 *
 */
public class SnapToConnectorFeedbackPolicy extends GraphicalEditPolicy {

	private static final Color FEEDBACK_COLOR = new Color(null, 0, 192, 0);

	private Map<PointList, IFigure> guides = new HashMap<PointList, IFigure>();

	/*
	 * @see org.eclipse.gef.EditPolicy#eraseTargetFeedback(org.eclipse.gef.Request)
	 */
	public void eraseTargetFeedback(Request request) {
		for (IFigure f : guides.values()) {
			removeFeedback(f);
		}
		guides.clear();
	}

	private static class FadeIn extends Figure {
		private int opacity = 0;
		private static final int FRAMES = 6;
		private Image image;

		FadeIn(Color bg) {
			setBackgroundColor(bg);
			super.setOpaque(true);
		}

		/*
		 * @see org.eclipse.draw2d.IFigure#getLocalBackgroundColor()
		 */
		public Color getLocalBackgroundColor() {
			return FigureUtilities.mixColors(super.getLocalBackgroundColor(), getParent().getBackgroundColor(), (double) opacity / FRAMES);
		}

		/*
		 * @see org.eclipse.draw2d.Figure#paintFigure(org.eclipse.draw2d.Graphics)
		 */
		protected void paintFigure(Graphics graphics) {
			if (opacity != FRAMES) {
				if (image != null) {
					image.dispose();
					image = null;
				}
				if (opacity != FRAMES - 1) {
					Display display = Display.getCurrent();
					PaletteData pData = new PaletteData(0xFF, 0xFF00, 0xFF0000);
					int fillColor = pData.getPixel(getLocalBackgroundColor().getRGB());
					ImageData iData = new ImageData(1, 1, 24, pData);
					iData.setPixel(0, 0, fillColor);
					iData.setAlpha(0, 0, 255 * opacity / FRAMES);
					image = new Image(display, iData);
				}
				Display.getCurrent().timerExec(100, new Runnable() {
					public void run() {
						opacity = Math.min(FRAMES, opacity + 1);
						repaint();
					}
				});
			}
			Rectangle r = getBounds();
			if (image != null) {
				graphics.drawImage(image, 0, 0, 1, 1, r.x, r.y, r.width, r.height);
			} else {
				super.paintFigure(graphics);
			}
		}

		/*
		 * @see org.eclipse.draw2d.Figure#removeNotify()
		 */
		public void removeNotify() {
			if (image != null) {
				image.dispose();
				image = null;
			}
		}
	}
	
	private void removeNonExistingGuides(List<PointList> existingLocations) {
		if (existingLocations == null) {
			for (IFigure f : guides.values()) {
				removeFeedback(f);
			}
			guides.clear();
			return;
		}
		
		Map<PointList, IFigure> nonExistingGuides = new HashMap<PointList, IFigure>(guides);
		nonExistingGuides.keySet().removeAll(existingLocations);
		for (IFigure f : nonExistingGuides.values()) {
			removeFeedback(f);
		}
		guides.keySet().removeAll(nonExistingGuides.keySet());
	}
	
	private void highlightGuide(List<PointList> locations, Point delta) {
		removeNonExistingGuides(locations);
		if (locations == null) {
			return;
		}
		
		IFigure contentPane = ((GraphicalEditPart) getHost()).getContentPane();

		for (PointList location : locations) {
			if (guides.containsKey(location)) {
				continue;
			}
			
			IFigure figure = new FadeIn(FEEDBACK_COLOR);
			guides.put(location, figure);
			addFeedback(figure);
		}
		
		for (Entry<PointList, IFigure> e : guides.entrySet()) {
			PointList location = e.getKey();
			IFigure figure = e.getValue();
			
			PrecisionPoint p1 = new PrecisionPoint(location.getFirstPoint());
			PrecisionPoint p2 = new PrecisionPoint(location.getLastPoint());
			
			contentPane.translateToAbsolute(p1);
			contentPane.translateToAbsolute(p2);
	
			figure.translateToRelative(p1);
			figure.translateToRelative(p2);
			
			int x1 = (int) Math.round(p1.preciseX());
			int y1 = (int) Math.round(p1.preciseY());
			int x2 = (int) Math.round(p2.preciseX());
			int y2 = (int) Math.round(p2.preciseY());
			Rectangle bounds = new Rectangle();
			if (location.getFirstPoint().x == location.getLastPoint().x) {
				y1 += delta.y;
				bounds.x = x1;
				bounds.y = Math.min(y1, y2);
				bounds.width = 1;
				bounds.height = Math.abs(y1 - y2);
			} else {
				x1 += delta.x;
				bounds.x = Math.min(x1, x2);
				bounds.y = y1;
				bounds.width = Math.abs(x1 - x2);
				bounds.height = 1;
			}
			figure.setBounds(bounds);
		}
	}

	/*
	 * @see org.eclipse.gef.EditPolicy#showTargetFeedback(org.eclipse.gef.Request)
	 */
	@SuppressWarnings("unchecked")
	public void showTargetFeedback(Request req) {
		if (req.getType().equals(REQ_MOVE)) {
			highlightGuide((List<PointList>) req.getExtendedData().get(SnapToConnector.KEY_GUIDE_LOCATIONS), ((ChangeBoundsRequest) req).getMoveDelta());
		}
	}

}
