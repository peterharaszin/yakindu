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

package org.eclipse.damos.library.base.ui.editparts.logic;

import org.eclipse.damos.library.base.ui.figures.shapes.logic.LogicGateShapeType;
import org.eclipse.damos.library.base.ui.figures.shapes.logic.RectangularLogicGateShape;
import org.eclipse.damos.library.common.ui.editparts.MultiShapeBlockEditPart;
import org.eclipse.damos.library.common.ui.figures.shapes.BlockShape;
import org.eclipse.gmf.runtime.notation.View;

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
	
	protected BlockShape getShape(String shape) {
		switch (LogicGateShapeType.valueOf(shape)) {
		case DISTINCTIVE:
			return createDistinctiveShape();
		case RECTANGULAR:
			return createRectangularShape();
		}
		return null;
	}
	
	protected abstract BlockShape createDistinctiveShape();
	
	protected BlockShape createRectangularShape() {
		return new RectangularLogicGateShape(getComponentFigure(), getRectangularShapeLabel());
	}
	
	protected abstract String getRectangularShapeLabel();

}
