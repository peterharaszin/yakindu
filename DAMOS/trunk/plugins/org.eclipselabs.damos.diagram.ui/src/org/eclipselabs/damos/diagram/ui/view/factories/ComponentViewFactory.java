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

package org.eclipselabs.damos.diagram.ui.view.factories;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory;
import org.eclipse.gmf.runtime.notation.GradientStyle;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.GradientData;
import org.eclipselabs.damos.diagram.dmlnotation.DMLNotationFactory;
import org.eclipselabs.damos.diagram.ui.view.ISemanticHints;

public class ComponentViewFactory extends AbstractShapeViewFactory {

	protected void decorateView(View containerView, View view, IAdaptable element, String semanticHint, int index, boolean persisted) {
		super.decorateView(containerView, view, element, semanticHint, index, persisted);
        ShapeStyle style = (ShapeStyle) view.getStyle(NotationPackage.eINSTANCE.getShapeStyle());
        style.setLineColor(0x555555);
        style.setFontColor(0);
        
        GradientData gradientData = new GradientData();
        gradientData.setGradientColor1(0xfffafa);
        gradientData.setGradientColor2(0xffe1e1);
        gradientData.setGradientStyle(GradientStyle.VERTICAL);
        style.setGradient(gradientData);
        
        getViewService().createNode(element, view, ISemanticHints.COMPONENT_NAME, ViewUtil.APPEND, persisted, getPreferencesHint());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory#createLayoutConstraint()
	 */
	protected LayoutConstraint createLayoutConstraint() {
		return DMLNotationFactory.eINSTANCE.createComponentLayoutConstraint();
	}
	
}
