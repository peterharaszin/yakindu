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

package org.eclipselabs.damos.library.common.ui.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.editparts.BlockEditPart;
import org.eclipselabs.damos.diagram.ui.editparts.PortEditPart;
import org.eclipselabs.damos.diagram.ui.view.util.PropertiesSetStyleUtil;
import org.eclipselabs.damos.dml.Port;
import org.eclipselabs.damos.library.common.ui.figures.MultiShapeBlockFigure;
import org.eclipselabs.damos.library.common.ui.figures.shapes.BlockShape;
import org.eclipselabs.damos.library.common.ui.view.styles.MultiShapeBlockStyles;

/**
 * @author Andreas Unger
 *
 */
public abstract class MultiShapeBlockEditPart extends BlockEditPart {

	private BlockShape shape;
	
	/**
	 * @param view
	 */
	public MultiShapeBlockEditPart(View view) {
		super(view);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart#refreshVisuals()
	 */
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshShape();
	}
	
	protected void refreshShape() {
		shape = getShape();
		if (shape == null) {
			return;
		}
		
		MultiShapeBlockFigure mainFigure = (MultiShapeBlockFigure) getMainFigure();

		IFigure contentFigure = mainFigure.getPrimaryContentFigure();
		if (contentFigure != null) {
			mainFigure.remove(contentFigure);
		}
		
		LayoutManager layoutManager = shape.createLayoutManager();
		mainFigure.setLayoutManager(layoutManager);

		contentFigure = shape.getContentFigure();
		if (contentFigure != null) {
			mainFigure.add(contentFigure, shape.getContentFigureConstraint());
		}
		
		if (layoutManager != null) {
			for (Object o : getChildren()) {
				if (o instanceof PortEditPart) {
					PortEditPart portEditPart = (PortEditPart) o;
					Object constraint = shape.getPortFigureConstraint((Port) portEditPart.resolveSemanticElement());
					mainFigure.setConstraint(portEditPart.getFigure(), constraint);
				}
			}
		}

		mainFigure.setShape(shape);
	}
	
	protected abstract BlockShape getShape();
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart#createMainFigure()
	 */
	protected NodeFigure createMainFigure() {
		return new MultiShapeBlockFigure();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.editparts.BlockEditPart#getPortFigureConstraint(org.eclipselabs.damos.semantic.blockdiagram.Port)
	 */
	protected Object getPortFigureConstraint(Port port) {
		if (shape != null) {
			return shape.getPortFigureConstraint(port);
		}
		return super.getPortFigureConstraint(port);
	}
	
	protected void handleNotificationEvent(Notification notification) {
		if (PropertiesSetStyleUtil.isNotifier(notification, MultiShapeBlockStyles.SHAPE_STYLE, MultiShapeBlockStyles.SHAPE_STYLE__SHAPE)) {
			refreshShape();
		} else {
			super.handleNotificationEvent(notification);
		}
	}

}
