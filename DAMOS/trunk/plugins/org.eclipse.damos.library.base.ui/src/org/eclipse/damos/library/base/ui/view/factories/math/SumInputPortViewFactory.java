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

package org.eclipse.damos.library.base.ui.view.factories.math;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.damos.diagram.ui.view.factories.PortViewFactory;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @author Andreas Unger
 *
 */
public class SumInputPortViewFactory extends PortViewFactory {

	protected void decorateView(View containerView, View view, IAdaptable element, String semanticHint, int index, boolean persisted) {
		super.decorateView(containerView, view, element, semanticHint, index, persisted);
        FontStyle fontStyle = (FontStyle) view.getStyle(NotationPackage.eINSTANCE.getFontStyle());
        fontStyle.setFontHeight(7);
	}

}
