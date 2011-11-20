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

package org.eclipselabs.damos.library.base.ui.editparts.math;

import org.eclipse.draw2d.LayoutManager;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.figures.OvalComponentLayout;
import org.eclipselabs.damos.diagram.ui.view.util.PropertiesSetStyleUtil;
import org.eclipselabs.damos.library.base.ui.figures.shapes.math.RectangularSumShape;
import org.eclipselabs.damos.library.base.ui.figures.shapes.math.RoundSumShape;
import org.eclipselabs.damos.library.base.ui.figures.shapes.math.SumShapeType;
import org.eclipselabs.damos.library.base.ui.view.styles.math.SumStyles;
import org.eclipselabs.damos.library.common.ui.editparts.MultiShapeBlockEditPart;
import org.eclipselabs.damos.library.common.ui.figures.MultiShapeBlockFigure;
import org.eclipselabs.damos.library.common.ui.figures.shapes.BlockShape;
import org.eclipselabs.damos.library.common.ui.view.styles.MultiShapeBlockStyles;

/**
 * @author Andreas Unger
 *
 */
public class SumEditPart extends MultiShapeBlockEditPart {

	/**
	 * @param view
	 */
	public SumEditPart(View view) {
		super(view);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart#createMainFigure()
	 */
	protected NodeFigure createMainFigure() {
		return new MultiShapeBlockFigure();
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.library.basicblocks.editparts.MultiShapeBlockEditPart#refreshShape()
	 */
	protected void refreshShape() {
		super.refreshShape();
		refreshInputPortsArrangement();
	}
	
	protected void refreshInputPortsArrangement() {
		LayoutManager layout = getComponentFigure().getLayoutManager();
		if (layout instanceof OvalComponentLayout) {
			View view = (Node) getNotationView();
			if (view != null) {
				String arrangement = PropertiesSetStyleUtil.getStringValue(view, SumStyles.INPUT_PORTS_STYLE, SumStyles.INPUT_PORTS_STYLE__ARRANGEMENT);
				if (arrangement != null) {
					((OvalComponentLayout) layout).setInputPortsArrangement(arrangement);
					getComponentFigure().revalidate();
				}
			}
		}
	}

	protected void handleNotificationEvent(Notification notification) {
		if (PropertiesSetStyleUtil.isNotifier(notification, SumStyles.INPUT_PORTS_STYLE, SumStyles.INPUT_PORTS_STYLE__ARRANGEMENT)) {
			refreshInputPortsArrangement();
		} else {
			super.handleNotificationEvent(notification);
		}
	}

	protected BlockShape getShape() {
		View view = getNotationView();
		if (view != null) {
			String shape = PropertiesSetStyleUtil.getStringValue(view, MultiShapeBlockStyles.SHAPE_STYLE, MultiShapeBlockStyles.SHAPE_STYLE__SHAPE);
			try {
				switch (SumShapeType.valueOf(shape)) {
				case ROUND:
					return createRoundShape();
				case RECTANGULAR:
					return createRectangularShape();
				}
			} catch (Exception e) {
				// Ignore invalid shape
			}
		}
		return null;
	}
	
	protected BlockShape createRoundShape() {
		return new RoundSumShape(getComponentFigure());
	}
	
	protected BlockShape createRectangularShape() {
		return new RectangularSumShape(getComponentFigure());
	}
	
}
