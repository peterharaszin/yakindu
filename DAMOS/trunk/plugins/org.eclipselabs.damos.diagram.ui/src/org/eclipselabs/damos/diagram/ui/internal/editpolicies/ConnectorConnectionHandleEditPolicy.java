/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.diagram.ui.internal.editpolicies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Handle;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionHandleEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.handles.ConnectionHandle;
import org.eclipse.gmf.runtime.diagram.ui.handles.ConnectionHandle.HandleDirection;
import org.eclipselabs.damos.diagram.ui.figures.TerminalFigure;
import org.eclipselabs.damos.diagram.ui.internal.figures.IConnectorFigure;
import org.eclipselabs.damos.dml.Connector;
import org.eclipselabs.damos.dml.InputConnector;

/**
 * @author Andreas Unger
 *
 */
public class ConnectorConnectionHandleEditPolicy extends ConnectionHandleEditPolicy {

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionHandleEditPolicy#activate()
	 */
	@Override
	public void activate() {
		super.activate();
		if (getHostFigure() instanceof IConnectorFigure) {
			TerminalFigure terminalFigure = ((IConnectorFigure) getHostFigure()).getTerminalFigure();
			if (terminalFigure != null) {
				terminalFigure.addMouseMotionListener(this);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionHandleEditPolicy#deactivate()
	 */
	@Override
	public void deactivate() {
		if (getHostFigure() instanceof IConnectorFigure) {
			TerminalFigure terminalFigure = ((IConnectorFigure) getHostFigure()).getTerminalFigure();
			if (terminalFigure != null) {
				terminalFigure.removeMouseMotionListener(this);
			}
		}
		super.deactivate();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionHandleEditPolicy#getHandleFigures()
	 */
	@Override
	protected List<Handle> getHandleFigures() {
		List<Handle> list = new ArrayList<Handle>(2);
		
		if (getConnector() instanceof InputConnector) {
			String tooltip = buildTooltip(HandleDirection.INCOMING);
			if (tooltip != null) {
				list.add(new ConnectionHandle(getHost(), HandleDirection.INCOMING, tooltip));
			}
		} else {
			String tooltip = buildTooltip(HandleDirection.OUTGOING);
			if (tooltip != null) {
				list.add(new ConnectionHandle(getHost(), HandleDirection.OUTGOING, tooltip));
			}
		}

		return list;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#getHost()
	 */
	@Override
	public IGraphicalEditPart getHost() {
		return (IGraphicalEditPart) super.getHost();
	}
	
	Connector getConnector() {
		return (Connector) getHost().resolveSemanticElement();
	}
	
}
