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

package org.eclipselabs.damos.library.base.ui.properties.math;

import java.util.Arrays;
import java.util.List;

import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.view.util.PropertiesSetStyleUtil;
import org.eclipselabs.damos.library.base.ui.figures.shapes.math.SumShapeType;
import org.eclipselabs.damos.library.common.ui.properties.ShapePropertySection;
import org.eclipselabs.damos.library.common.ui.view.styles.MultiShapeBlockStyles;

/**
 * @author Andreas Unger
 *
 */
public class SumShapePropertySection extends ShapePropertySection {

	private static final List<String> PROPERTY_VALUE_STRINGS = Arrays.asList(new String[] { "Round", "Rectangular" });

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.library.basicblocks.ui.properties.ShapePropertySection#getNames()
	 */
	protected List<String> getPropertyValueStrings() {
		return PROPERTY_VALUE_STRINGS;
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
	 * @see org.eclipselabs.damos.diagram.ui.properties.AbstractBasicComboPropertySection#computeNewPropertyValue()
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
