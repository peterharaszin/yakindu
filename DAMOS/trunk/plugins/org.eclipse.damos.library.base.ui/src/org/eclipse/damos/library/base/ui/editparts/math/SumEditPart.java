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

package org.eclipse.damos.library.base.ui.editparts.math;

import org.eclipse.damos.diagram.ui.figures.OvalComponentLayout;
import org.eclipse.damos.diagram.ui.view.util.PropertiesSetStyleUtil;
import org.eclipse.damos.library.base.ui.figures.shapes.math.RectangularSumShape;
import org.eclipse.damos.library.base.ui.figures.shapes.math.RoundSumShape;
import org.eclipse.damos.library.base.ui.figures.shapes.math.SumShapeType;
import org.eclipse.damos.library.base.ui.view.styles.math.SumStyles;
import org.eclipse.damos.library.common.ui.editparts.MultiShapeBlockEditPart;
import org.eclipse.damos.library.common.ui.figures.MultiShapeBlockFigure;
import org.eclipse.damos.library.common.ui.figures.shapes.BlockShape;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

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
	 * @see org.eclipse.damos.library.basicblocks.editparts.MultiShapeBlockEditPart#refreshShape()
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

	protected BlockShape getShape(String shape) {
		switch (SumShapeType.valueOf(shape)) {
		case ROUND:
			return createRoundShape();
		case RECTANGULAR:
			return createRectangularShape();
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
