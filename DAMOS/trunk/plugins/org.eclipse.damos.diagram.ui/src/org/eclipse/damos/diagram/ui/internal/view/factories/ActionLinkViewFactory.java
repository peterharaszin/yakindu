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

package org.eclipse.damos.diagram.ui.internal.view.factories;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.damos.diagram.ui.view.ISemanticHints;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.notation.ConnectorStyle;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

public class ActionLinkViewFactory extends org.eclipse.gmf.runtime.diagram.ui.view.factories.ConnectionViewFactory {
	
	protected void decorateView(View containerView, View view, IAdaptable element, String semanticHint, int index, boolean persisted) {
		super.decorateView(containerView, view, element, semanticHint, index, persisted);
        ConnectorStyle connectorStyle = (ConnectorStyle) view.getStyle(NotationPackage.eINSTANCE.getConnectorStyle());
        connectorStyle.setLineColor((FigureUtilities.colorToInteger(ColorConstants.black)).intValue());
        
        DecorationNode decorationNode = (DecorationNode) view.createChild(NotationPackage.eINSTANCE.getDecorationNode());
        Location location = NotationFactory.eINSTANCE.createLocation();
        decorationNode.setType(ISemanticHints.ACTION_LINK_CONDITION);
        decorationNode.setLayoutConstraint(location);
	}
	
}
