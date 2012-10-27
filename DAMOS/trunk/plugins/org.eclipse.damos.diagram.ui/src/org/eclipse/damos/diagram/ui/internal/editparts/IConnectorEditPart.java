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

package org.eclipse.damos.diagram.ui.internal.editparts;

import org.eclipse.damos.diagram.ui.internal.figures.IConnectorFigure;
import org.eclipse.damos.dml.Connector;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;

/**
 * @author Andreas Unger
 *
 */
public interface IConnectorEditPart extends IGraphicalEditPart {

	Connector getConnector();
	
	IConnectorFigure getConnectorFigure();
	
}
