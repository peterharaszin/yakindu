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

package org.esmp.dsm.diagram.ui.editpolicies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.NodeListener;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.esmp.dsm.diagram.ui.figures.PortFigure;
import org.esmp.dsm.diagram.ui.figures.TerminalFigure;

/**
 * @author Andreas Unger
 *
 */
public class TerminalEditPolicy extends GraphicalEditPolicy implements NodeListener {

	private TerminalFigure terminalFigure;
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#activate()
	 */
	public void activate() {
		super.activate();
		if (getHost() instanceof NodeEditPart) {
			NodeEditPart ep = (NodeEditPart) getHost();
			addTerminalBorderFigure();
			if (ep.getSourceConnections().size() + ep.getTargetConnections().size() == 0) {
				addTerminalFigure();
			}
			ep.addNodeListener(this);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#deactivate()
	 */
	public void deactivate() {
		if (getHost() instanceof NodeEditPart) {
			((NodeEditPart) getHost()).removeNodeListener(this);
			removeTerminalFigure();
			removeTerminalBorderFigure();
		}
		super.deactivate();
	}
	
	protected void addTerminalBorderFigure() {
		IFigure hostFigure = getHostFigure();
		if (hostFigure instanceof PortFigure) {
			IFigure terminalBorderFigure = ((PortFigure) hostFigure).getTerminalBorderFigure();
			if (hostFigure.getParent() != null) {
				hostFigure.getParent().add(terminalBorderFigure);
			}
		}
	}
	
	protected void removeTerminalBorderFigure() {
		IFigure hostFigure = getHostFigure();
		if (hostFigure instanceof PortFigure) {
			IFigure terminalBorderFigure = ((PortFigure) hostFigure).getTerminalBorderFigure();
			if (hostFigure.getParent() != null) {
				hostFigure.getParent().remove(terminalBorderFigure);
			}
		}
	}

	@SuppressWarnings("unchecked")
	protected void addTerminalFigure() {
		if (terminalFigure == null) {
			IFigure hostFigure = getHostFigure();
			if (hostFigure instanceof PortFigure) {
				terminalFigure = ((PortFigure) hostFigure).getTerminalFigure();
				IFigure parent = getTerminalParentFigure();
				if (parent != null) {
					parent.add(terminalFigure, new Rectangle(0, 0, -1, -1));
				}
				getHost().getViewer().getVisualPartMap().put(terminalFigure, getHost());
			}
		}
	}
	
	protected void removeTerminalFigure() {
		if (terminalFigure != null) {
			getHost().getViewer().getVisualPartMap().remove(terminalFigure);
			IFigure parent = getTerminalParentFigure();
			if (parent != null) {
				parent.remove(terminalFigure);
			}
			terminalFigure.invalidate();
			terminalFigure = null;
		}
	}
	
	protected IFigure getTerminalParentFigure() {
		IFigure parent = getHostFigure().getParent();
		while (parent != null && !(parent instanceof Layer)) {
			parent = parent.getParent(); 
		} 
		return parent;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.NodeListener#sourceConnectionAdded(org.eclipse.gef.ConnectionEditPart, int)
	 */
	public void sourceConnectionAdded(ConnectionEditPart connection, int index) {
		removeTerminalFigure();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.NodeListener#targetConnectionAdded(org.eclipse.gef.ConnectionEditPart, int)
	 */
	public void targetConnectionAdded(ConnectionEditPart connection, int index) {
		removeTerminalFigure();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.NodeListener#removingSourceConnection(org.eclipse.gef.ConnectionEditPart, int)
	 */
	public void removingSourceConnection(ConnectionEditPart connection, int index) {
		removingConnection();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.NodeListener#removingTargetConnection(org.eclipse.gef.ConnectionEditPart, int)
	 */
	public void removingTargetConnection(ConnectionEditPart connection, int index) {
		removingConnection();
	}
	
	private void removingConnection() {
		NodeEditPart ep = (NodeEditPart) getHost();
		if (ep.getSourceConnections().size() + ep.getTargetConnections().size() == 1) {
			addTerminalFigure();
		}
	}

}
