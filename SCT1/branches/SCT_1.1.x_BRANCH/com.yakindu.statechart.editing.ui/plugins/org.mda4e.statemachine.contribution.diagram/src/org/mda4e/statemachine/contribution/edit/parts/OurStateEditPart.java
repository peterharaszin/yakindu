/**
 * Copyright (c) 2006-2009 committers of mda4e and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of mda4e (http://www.mda4e.org/) - initial API and implementation
 *
 */
package org.mda4e.statemachine.contribution.edit.parts;

import static org.mda4e.statemachine.contribution.drawing.GraphicsUtil.fillVerticalGradientRoundedRectangle;
import static org.mda4e.statemachine.contribution.drawing.GraphicsUtil.mixColor;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Pattern;
import org.eclipse.swt.widgets.Display;
import org.mda4e.statemachine.contribution.commands.CmdSetStateBackground;
import org.mda4e.statemachine.contribution.commands.CmdSetStateForeground;
import org.mda4e.statemachine.contribution.drawing.ImageRenderer;
import org.mda4e.statemachine.contribution.part.OurStatemachineDiagramEditorPlugin;
import org.mda4e.statemachine.contribution.tools.Constants;

import statemachine.diagram.edit.parts.StateEditPart;

public class OurStateEditPart extends StateEditPart {

	public final static int GRADIENT_MAX_SIZE = 800 * 800;
	private static final int BLUR_SHADOW_WIDTH = 5;
	private boolean isOpen;
	private IPreferenceStore store;
	private IPropertyChangeListener propertyChangeListener;

	public OurStateEditPart(View view) {
		super(view);
		isOpen = true;
		store = OurStatemachineDiagramEditorPlugin.getInstance()
				.getPreferenceStore();
		propertyChangeListener = getPropertyChangeListener();
	}
	
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40) {

			@Override
			public void setBounds(Rectangle rect) {
				if (getParent() != null) {
					getUpdateManager().addDirtyRegion(getParent(),
							getBounds().getExpanded(BLUR_SHADOW_WIDTH, BLUR_SHADOW_WIDTH));
				}
				super.setBounds(rect);
			}
		};
		return result;
	}

	public void activate() {
		if (!isActive()) {
			super.activate();
			store.addPropertyChangeListener(propertyChangeListener);
		}
	}

	public void deactivate() {
		if (isActive()) {
			super.deactivate();
			store.removePropertyChangeListener(propertyChangeListener);
		}
	}

	public void performRequest(Request request) {
		if (request.getType() == RequestConstants.REQ_OPEN) {
			isOpen = !isOpen;
//			updateFigure();
			refresh();
		} else
			super.performRequest(request);
	}

//	private void updateFigure() {
//		/*
//		 * int x=0; int y=0;
//		 */
//		Rectangle rect = new Rectangle();
//		// Bounds bounds;
//		int width = 0;
//		int height = 0;
//		int offset = 100;
//		ShapeCompartmentEditPart stateCompartment = (ShapeCompartmentEditPart) getChildren()
//				.get(4);
//		if (stateCompartment.getChildren().size() > 0) {
//			for (int i = 0; i < stateCompartment.getChildren().size(); i++) {
//				ShapeNodeEditPart region = (ShapeNodeEditPart) stateCompartment
//						.getChildren().get(i);
//				height = height + region.getFigure().getBounds().height;
//				if (region.getFigure().getBounds().width > width)
//					width = region.getFigure().getBounds().width;
//			}
//			for (int i = 0; i < stateCompartment.getChildren().size(); i++) {
//				ShapeNodeEditPart region = (ShapeNodeEditPart) stateCompartment
//						.getChildren().get(i);
//				/*
//				 * LayoutConstraint layoutConstraint = ((Node)
//				 * region.getModel()).getLayoutConstraint(); if
//				 * (layoutConstraint instanceof Bounds) bounds = (Bounds)
//				 * layoutConstraint;
//				 */
//				if (i < 1)
//					rect = new Rectangle(0, 0, width, region.getFigure()
//							.getBounds().height);
//				else {
//					ShapeNodeEditPart region2 = (ShapeNodeEditPart) stateCompartment
//							.getChildren().get(i - 1);
//					int y = region2.getFigure().getBounds().y
//							+ region2.getFigure().getBounds().height;
//					rect = new Rectangle(0, y, width, region.getFigure()
//							.getBounds().height);
//				}
//				try {
//					OperationHistoryFactory.getOperationHistory().execute(
//							new SetBoundsCommand(region.getEditingDomain(),
//									"resize state & regions", region, rect),
//							null, this);
//				} catch (ExecutionException e) {
//					e.printStackTrace();
//				}
//			}
//			// State resizen
//			rect = new Rectangle(figure.getBounds().x, figure.getBounds().y,
//					width + 10, height + offset);
//			try {
//				OperationHistoryFactory.getOperationHistory().execute(
//						new SetBoundsCommand(getEditingDomain(),
//								"resize state & regions", this, rect), null,
//						this);
//			} catch (ExecutionException e) {
//				e.printStackTrace();
//			}
//		}
//	}

	protected IFigure createNodeShape() {
		OurStateFigure figure = new OurStateFigure();
		return primaryShape = figure;
	}

	private IPropertyChangeListener getPropertyChangeListener() {
		return new IPropertyChangeListener() {

			public void propertyChange(PropertyChangeEvent event) {
				if (event.getProperty().equals(Constants.P_STATE_BACKGROUND_COLOR)) {
					Color color = new Color(null,PreferenceConverter.getColor(store, Constants.P_STATE_BACKGROUND_COLOR));
					try {
						OperationHistoryFactory.getOperationHistory().execute(new CmdSetStateBackground(getEditingDomain(),"set color",OurStateEditPart.this,color),null,OurStateEditPart.this);
					} catch (ExecutionException e) {
						e.printStackTrace();
					}
				}
				else if (event.getProperty().equals(Constants.P_STATE_FOREGROUND_COLOR)) {
					Color color = new Color(null,PreferenceConverter.getColor(store, Constants.P_STATE_FOREGROUND_COLOR));
					try {
						OperationHistoryFactory.getOperationHistory().execute(new CmdSetStateForeground(getEditingDomain(),"set color",OurStateEditPart.this,color),null,OurStateEditPart.this);
					} catch (ExecutionException e) {
						e.printStackTrace();
					}
				}
				
			}
		};
	}

	@Override
	protected void refreshBackgroundColor() {
		setBackgroundColor(new Color(null,PreferenceConverter.getColor(store, Constants.P_STATE_BACKGROUND_COLOR)));
	}

	@Override
	protected void refreshForegroundColor() {
		setForegroundColor(new Color(null, PreferenceConverter.getColor(store,
				Constants.P_STATE_FOREGROUND_COLOR)));
	}

	public class OurStateFigure extends StateFigure {

		protected Image gradientImage = null;
		protected Pattern gradientPattern = null;
		protected Rectangle gradientBounds = null;
		protected float gradientScale = -1.0f;

		public OurStateFigure() {
			super();
			setLineWidth(Constants.stateLineWidth);
			int cornerSize = 20; //MapModeUtil.getMapMode(this).DPtoLP(20);
			setCornerDimensions(new Dimension(getMapMode().DPtoLP(20), getMapMode().DPtoLP(20)));
			setOutline(true);
			setFill(true);
			// getFigureStateNameFigure().setFont(new Font(null, "Arial", 16,
			// SWT.BOLD));
			// getFigureStateNameFigure().setTextUnderline(true);

			for (Object child : getChildren()) {
				((IFigure) child).setBackgroundColor(null);
				if (child instanceof RectangleFigure) {
					((RectangleFigure) child).setOutline(false);
					((RectangleFigure) child).setFill(false);
				}
			}
		}

		@Override
		public void paintFigure(Graphics graphics) {

			setForegroundColor(ColorConstants.lightGray);
			drawBlurredShadow(graphics);

			// graphics.setBackgroundPattern(provideGradient(graphics));

			super.paintFigure(graphics);

			// graphics.setBackgroundPattern(null);

		}

		private void drawBlurredShadow(Graphics graphics) {
			// draw the shadow...
			graphics.pushState();

			int size = MapModeUtil.getMapMode(this).DPtoLP(BLUR_SHADOW_WIDTH);
			int step = MapModeUtil.getMapMode(this).DPtoLP(-1);
			
			graphics.setForegroundColor(ColorConstants.gray);
			graphics.setLineWidth(MapModeUtil.getMapMode(this).DPtoLP(2));
			graphics.translate(size, size);
			graphics.setClip(graphics.getClip(new Rectangle(getBounds()))
					.expand(size, size));
			graphics.setAlpha(20);
			outlineShape(graphics);
			graphics.translate(step, step);
			graphics.setAlpha(30);
			outlineShape(graphics);
			graphics.translate(step, step);
			graphics.setAlpha(60);
			outlineShape(graphics);
			graphics.translate(step, step);
			graphics.setAlpha(100);
			outlineShape(graphics);
			graphics.translate(step, step);
			graphics.setAlpha(150);
			outlineShape(graphics);

			graphics.popState();
		}

		// private void drawSolidShadow(Graphics graphics) {
		// // draw the shadow...
		// graphics.pushState();
		// graphics.setBackgroundColor(new Color(Display.getCurrent(),
		// new RGB(100, 100, 100)));
		// graphics.setAlpha(100);
		// graphics.translate(4, 4);
		// graphics.setClip(graphics.getClip(new Rectangle(getBounds()))
		// .expand(4, 4));
		// fillShapeShadow(graphics);
		// graphics.popState();
		// }

		@Override
		protected void fillShape(Graphics graphics) {
//			super.fillShape(graphics);
//			graphics.drawImage(provideGradientImage(graphics), getBounds()
//					.getTopLeft());
			
			Color c=mixColor(getBackgroundColor(), ColorConstants.white, 220);
			fillVerticalGradientRoundedRectangle(graphics, getBounds(), corner, getBackgroundColor(), c);
			c.dispose();

		}

		protected void fillShapeShadow(Graphics graphics) {
			super.fillShape(graphics);
		}

		protected Pattern provideGradient(Graphics graphics) {
			checkGradient(graphics);
			if (gradientPattern == null) {

				gradientBounds = getBounds().getCopy();
				Point topLeft = gradientBounds.getTopLeft();
				Point bottomRight = gradientBounds.getBottomRight();

				gradientScale = (float) graphics.getAbsoluteScale();
				gradientPattern = new Pattern(Display.getCurrent(), topLeft.x
						* gradientScale, topLeft.y * gradientScale,
						bottomRight.x * gradientScale, bottomRight.y
								* gradientScale, getBackgroundColor(),
						ColorConstants.white);
			}

			return gradientPattern;
		}

		protected void checkGradient(Graphics graphics) {
			if (gradientPattern != null) {
				Rectangle r = getBounds().getCopy();
				float s = (float) graphics.getAbsoluteScale();
				if (!r.equals(gradientBounds)
						|| gradientPattern.getDevice() != Display.getCurrent()
						|| gradientScale != s) {
					gradientPattern.dispose();
					gradientPattern = null;
					gradientBounds = null;
				}
			}
		}

		boolean useGradient() {
			Rectangle r = getBounds().getCopy();
			MapModeUtil.getMapMode(this).LPtoDP(r);

			return (r.height * r.width <= GRADIENT_MAX_SIZE );
		}
		
		
		protected Image provideGradientImage(Graphics graphics) {
			checkGradientImage(graphics);
			if ( gradientImage == null && useGradient()) {
				
				gradientBounds = getBounds().getCopy();
				Rectangle imageBounds  = gradientBounds.getCopy();
				
				ImageRenderer r = new ImageRenderer();
				MapModeUtil.getMapMode(this).LPtoDP(imageBounds);
				ImageData id = r.calculateVerticalAlphaGradient(imageBounds, ColorConstants.white.getRGB(), 220);
				
				Dimension imageCorner = corner.getCopy();
				MapModeUtil.getMapMode(this).LPtoDP(imageCorner);

				r.maskAlphaAsRoundedrectangle(id, imageCorner, 0);
				gradientImage = new Image(Display.getCurrent(), id);
				
			}
			
			return gradientImage;
		}
		
		protected void checkGradientImage(Graphics graphics) {
			if (gradientImage != null) {
				Rectangle r = getBounds().getCopy();
				if (! useGradient() 
						|| ! r.equals(gradientBounds) 
						|| gradientImage.getDevice() != Display.getCurrent() ) {
					gradientImage.dispose();
					gradientImage = null;
					gradientBounds = null;
				}
			}
		}

		/**
		 * @see IFigure#getMinimumSize(int, int)
		 */
		public Dimension getMinimumSize(int wHint, int hHint) {
			if (minSize != null)
				return minSize;
			if (getLayoutManager() != null) {
				/**
				 * Schwertfeger Hack because wrong preferred size while first
				 * resize of this shape prevent from making it smaller.
				 * Invalidate calculates minimum new
				 */
				if (wHint == -1 && hHint == -1) {
					this.invalidateTree();
				}
				// Hack end
				Dimension d = getLayoutManager().getMinimumSize(this, wHint,
						hHint);
				/*
				 * Schwertfeger
				 * Hack because GirdLayout uses Preferred size as minimum size,
				 * which prevents regions from making them smaller than initial size.
				 */
				d.height=getMapMode().DPtoLP(40);
				d.width=getMapMode().DPtoLP(40);
				// Hack end
				if (d != null) {
					// TODO (BSC) validate to set minSize
					minSize = d;
					return d;
				}
			}
			return new Dimension();
		}
	}
}
