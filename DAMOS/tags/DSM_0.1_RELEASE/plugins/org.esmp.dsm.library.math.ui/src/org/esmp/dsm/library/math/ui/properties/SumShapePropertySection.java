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

package org.esmp.dsm.library.math.ui.properties;

import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.esmp.dsm.diagram.ui.view.util.PropertiesSetStyleUtil;
import org.esmp.dsm.library.basic.ui.properties.ShapePropertySection;
import org.esmp.dsm.library.basic.ui.view.styles.MultiShapeBlockStyles;
import org.esmp.dsm.library.math.ui.figures.shapes.SumShapeType;

/**
 * @author Andreas Unger
 *
 */
public class SumShapePropertySection extends ShapePropertySection {

	/* (non-Javadoc)
	 * @see org.esmp.dsm.library.basicblocks.ui.properties.ShapePropertySection#getNames()
	 */
	protected String[] getPropertyValueStrings() {
		return new String[] { "Round", "Rectangular" };
	}
	
	protected int getPropertyValueIndex() {
		IGraphicalEditPart editPart = (IGraphicalEditPart) getPrimarySelection();
		if (editPart != null) {
			View view = editPart.getNotationView();
			if (view != null) {
				try {
					String shape = PropertiesSetStyleUtil.getStringValue(view, MultiShapeBlockStyles.SHAPE_STYLE, MultiShapeBlockStyles.SHAPE_STYLE__SHAPE);
					switch (SumShapeType.valueOf(shape)) {
					case ROUND:
						return 0;
					case RECTANGULAR:
						return 1;
					}
				} catch (Exception e) {
					// Ignore unknown shape
				}
			}
		}
		return -1;
	}
		
	/* (non-Javadoc)
	 * @see org.esmp.dsm.diagram.ui.properties.AbstractBasicComboPropertySection#computeNewPropertyValue()
	 */
	protected Object computeNewPropertyValue() {
		switch (getSelectionIndex()) {
		case 0:
			return SumShapeType.ROUND;
		case 1:
			return SumShapeType.RECTANGULAR;
		}
		return null;
	}

}
