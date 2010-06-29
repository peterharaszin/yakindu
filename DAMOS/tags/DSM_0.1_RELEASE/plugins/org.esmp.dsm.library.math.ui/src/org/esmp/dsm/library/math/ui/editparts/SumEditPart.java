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

package org.esmp.dsm.library.math.ui.editparts;

import org.eclipse.draw2d.LayoutManager;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.esmp.dsm.diagram.ui.figures.OvalBlockLayout;
import org.esmp.dsm.diagram.ui.view.util.PropertiesSetStyleUtil;
import org.esmp.dsm.library.basic.ui.editparts.MultiShapeBlockEditPart;
import org.esmp.dsm.library.basic.ui.figures.MultiShapeBlockFigure;
import org.esmp.dsm.library.basic.ui.figures.shapes.BlockShape;
import org.esmp.dsm.library.basic.ui.view.styles.MultiShapeBlockStyles;
import org.esmp.dsm.library.math.ui.figures.shapes.RectangularSumShape;
import org.esmp.dsm.library.math.ui.figures.shapes.RoundSumShape;
import org.esmp.dsm.library.math.ui.figures.shapes.SumShapeType;
import org.esmp.dsm.library.math.ui.view.styles.SumStyles;

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
	 * @see org.esmp.dsm.library.basicblocks.editparts.MultiShapeBlockEditPart#refreshShape()
	 */
	protected void refreshShape() {
		super.refreshShape();
		refreshInputPortsArrangement();
	}
	
	protected void refreshInputPortsArrangement() {
		LayoutManager layout = getBlockFigure().getLayoutManager();
		if (layout instanceof OvalBlockLayout) {
			View view = (Node) getNotationView();
			if (view != null) {
				String arrangement = PropertiesSetStyleUtil.getStringValue(view, SumStyles.INPUT_PORTS_STYLE, SumStyles.INPUT_PORTS_STYLE__ARRANGEMENT);
				if (arrangement != null) {
					((OvalBlockLayout) layout).setInputPortsArrangement(arrangement);
					getBlockFigure().revalidate();
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
		return new RoundSumShape(getBlockFigure());
	}
	
	protected BlockShape createRectangularShape() {
		return new RectangularSumShape(getBlockFigure());
	}
	
}
