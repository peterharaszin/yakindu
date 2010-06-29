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

package org.esmp.dsm.library.logic.ui.editparts;

import org.eclipse.gmf.runtime.notation.View;
import org.esmp.dsm.diagram.ui.view.util.PropertiesSetStyleUtil;
import org.esmp.dsm.library.basic.ui.editparts.MultiShapeBlockEditPart;
import org.esmp.dsm.library.basic.ui.figures.shapes.BlockShape;
import org.esmp.dsm.library.basic.ui.view.styles.MultiShapeBlockStyles;
import org.esmp.dsm.library.logic.ui.figures.shapes.LogicGateShapeType;
import org.esmp.dsm.library.logic.ui.figures.shapes.RectangularLogicGateShape;

/**
 * @author Andreas Unger
 *
 */
public abstract class LogicGateEditPart extends MultiShapeBlockEditPart {

	/**
	 * @param view
	 */
	public LogicGateEditPart(View view) {
		super(view);
	}
	
	/* (non-Javadoc)
	 * @see org.esmp.dsm.library.basic.ui.editparts.MultiShapeBlockEditPart#getShape()
	 */
	protected BlockShape getShape() {
		View view = getNotationView();
		if (view != null) {
			try {
				String shape = PropertiesSetStyleUtil.getStringValue(view, MultiShapeBlockStyles.SHAPE_STYLE, MultiShapeBlockStyles.SHAPE_STYLE__SHAPE);
				switch (LogicGateShapeType.valueOf(shape)) {
				case DISTINCTIVE:
					return createDistinctiveShape();
				case RECTANGULAR:
					return createRectangularShape();
				}
			} catch (Exception e) {
				// Ignore unknown shape
			}
		}
		return null;
	}
	
	protected abstract BlockShape createDistinctiveShape();
	
	protected BlockShape createRectangularShape() {
		return new RectangularLogicGateShape(getBlockFigure(), getRectangularShapeLabel());
	}
	
	protected abstract String getRectangularShapeLabel();

}
