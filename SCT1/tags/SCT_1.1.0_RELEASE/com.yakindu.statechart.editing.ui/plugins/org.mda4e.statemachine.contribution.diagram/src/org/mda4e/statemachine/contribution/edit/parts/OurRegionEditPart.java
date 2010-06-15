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

import static org.mda4e.statemachine.contribution.drawing.GraphicsUtil.*;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Pattern;
import org.mda4e.statemachine.contribution.part.OurStatemachineDiagramEditorPlugin;
import org.mda4e.statemachine.contribution.tools.Constants;
import org.mda4e.statemachine.contribution.tools.StaticMethods;

import statemachine.diagram.edit.parts.RegionEditPart;
import statemachine.diagram.edit.parts.TransitionEditPart;
	
public class OurRegionEditPart extends RegionEditPart {
	
	private boolean isOpen;
	private IPreferenceStore store;
	
	public OurRegionEditPart(View view) {
		super(view);
		isOpen = true;
		store = OurStatemachineDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
	
	@Override
	protected void refreshBackgroundColor() {
		this.setBackgroundColor(new Color(null,PreferenceConverter.getColor(store, Constants.P_REGION_BACKGROUND_COLOR)));
	}
	
	public void performRequest(Request request){
		
		if (request.getType() == RequestConstants.REQ_OPEN) {			
			isOpen = !isOpen;
			updateFigure();
			refresh();
		}
		else super.performRequest(request);
	}
	
	private void updateFigure(){
		ShapeCompartmentEditPart regionCompartment = (ShapeCompartmentEditPart) getChildren().get(1);
		regionCompartment.getFigure().setVisible(isOpen);
		updateTransitions(StaticMethods.getRegionTransitionsEditParts(regionCompartment));
		//StaticMethods.setTransitionsVisibility(regionCompartment, isOpen);
	}
	
	private void updateTransitions(List <TransitionEditPart> transitions){
		for (int i=0;i<transitions.size();i++)
			transitions.get(i).getFigure().setVisible(isOpen);
	}
	
	protected IFigure createNodeShape() {
		OurRegionFigure figure = new OurRegionFigure();
		return primaryShape = figure;
	}
	
	public class OurRegionFigure extends RegionFigure {

		protected Image gradientImage= null;

		protected Pattern gradientPattern = null;
		protected Rectangle gradientBounds = null;
		protected float gradientScale = -1.0f;

		public OurRegionFigure(){
			super();
//			setForegroundColor(new Color(null,PreferenceConverter.getColor(store, Constants.P_REGION_FOREGROUND_COLOR)));
//			setBackgroundColor(new Color(null,PreferenceConverter.getColor(store, Constants.P_REGION_BACKGROUND_COLOR)));
//			getFigureRegionCompartmentRectangle().setFill(false);
			for(Object child : getChildren()){
				((IFigure)child).setBackgroundColor(null);
				if(child instanceof RectangleFigure){
					((RectangleFigure)child).setOutline(false);
					((RectangleFigure)child).setFill(false);
				}
			}

		}
			
				
		
		@Override
		protected void fillShape(Graphics graphics) {
			Color c=mixColor(getBackgroundColor(), ColorConstants.white, 180);
			fillVerticalGradientRoundedRectangle(graphics, getBounds(), corner, getBackgroundColor(), c);
			c.dispose();
		}

		
		/**
		 * @see IFigure#getMinimumSize(int, int)
		 */
		public Dimension getMinimumSize(int wHint, int hHint) {
			if (minSize != null)
				return minSize;
			if (getLayoutManager() != null) {
				/*
				 * Schwertfeger
				 * Hack because wrong preferred size while first resize of this shape
				 * prevent from making it smaller. Invalidate calculates minimum new
				 */
				if (wHint==-1 && hHint==-1){
					this.invalidateTree();
				}
				// Hack end
				
				Dimension d;
				d = getLayoutManager().getMinimumSize(this, wHint, hHint);
				/*
				 * Schwertfeger
				 * Hack because GirdLayout uses Preferred size as minimum size,
				 * which prevents regions from making them smaller than initial size.
				 */
				d.height=40;
				d.width=40;
				// Hack end
				if (d != null){
					//TODO (BSC) validate to set minSize
					minSize = d;
					return d;
				}
			}
			return new Dimension();
		}
	}
}
