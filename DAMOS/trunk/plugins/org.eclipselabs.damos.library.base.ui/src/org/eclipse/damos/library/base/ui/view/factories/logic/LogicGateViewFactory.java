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

package org.eclipse.damos.library.base.ui.view.factories.logic;

import java.util.List;

import org.eclipse.damos.diagram.ui.view.factories.ComponentViewFactory;
import org.eclipse.damos.library.base.ui.figures.shapes.logic.LogicGateShapeType;
import org.eclipse.damos.library.common.ui.view.styles.MultiShapeBlockStyles;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.PropertiesSetStyle;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @author Andreas Unger
 *
 */
public class LogicGateViewFactory extends ComponentViewFactory {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected List createStyles(View view) {
		List styles = super.createStyles(view);
		
		PropertiesSetStyle shapeStyle = NotationFactory.eINSTANCE.createPropertiesSetStyle();
		shapeStyle.setName(MultiShapeBlockStyles.SHAPE_STYLE);
		shapeStyle.createProperty(MultiShapeBlockStyles.SHAPE_STYLE__SHAPE, EcorePackage.eINSTANCE.getEString(), LogicGateShapeType.DISTINCTIVE.name());
		styles.add(shapeStyle);
		
		return styles;
	}

}
