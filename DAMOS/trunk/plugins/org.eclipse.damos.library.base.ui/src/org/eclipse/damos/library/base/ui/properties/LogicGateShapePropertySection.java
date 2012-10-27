/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.library.base.ui.properties;

import java.util.Arrays;
import java.util.List;

import org.eclipse.damos.diagram.ui.view.util.PropertiesSetStyleUtil;
import org.eclipse.damos.library.base.ui.figures.shapes.LogicGateShapeType;
import org.eclipse.damos.library.common.ui.properties.ShapePropertySection;
import org.eclipse.damos.library.common.ui.view.styles.MultiShapeBlockStyles;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @author Andreas Unger
 *
 */
public class LogicGateShapePropertySection extends ShapePropertySection {

	private static final List<String> PROPERTY_VALUE_STRINGS = Arrays.asList(new String[] { "Distinctive", "Rectangular" });
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.library.basicblocks.ui.properties.ShapePropertySection#getNames()
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
					switch (LogicGateShapeType.valueOf(shape)) {
					case DISTINCTIVE:
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
	 * @see org.eclipse.damos.diagram.ui.properties.AbstractBasicComboPropertySection#computeNewPropertyValue()
	 */
	protected Object computeNewPropertyValue() {
		switch (getSelectionIndex()) {
		case 0:
			return LogicGateShapeType.DISTINCTIVE;
		case 1:
			return LogicGateShapeType.RECTANGULAR;
		}
		return null;
	}
		
}
