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

package org.eclipselabs.damos.diagram.ui.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.NodeListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipselabs.damos.diagram.ui.figures.PortFigure;
import org.eclipselabs.damos.diagram.ui.figures.TerminalFigure;
import org.eclipselabs.damos.diagram.ui.internal.editparts.PortEditPartDelegate;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.Port;
import org.eclipselabs.damos.dml.util.DMLUtil;

public abstract class PortEditPart extends ShapeNodeEditPart {

	private static final PortEditPartDelegate PASSIVE_DELEGATE = new PortEditPartDelegate(null);
	private PortEditPartDelegate delegate;

	private TerminalFigure terminalFigure;
	
	private NodeListener nodeListener = new NodeListener() {
		
		public void sourceConnectionAdded(ConnectionEditPart connection, int index) {
			refreshTerminalFigure(null);
		}

		public void targetConnectionAdded(ConnectionEditPart connection, int index) {
			refreshTerminalFigure(null);
		}
		
		public void removingSourceConnection(ConnectionEditPart connection, int index) {
			refreshTerminalFigure(connection);
		}

		public void removingTargetConnection(ConnectionEditPart connection, int index) {
			refreshTerminalFigure(connection);
		}
		
	};
	
	FragmentSelectionChangeListener fragmentChangeListener = new FragmentSelectionChangeListener() {
		
		public void fragmentSelectionChanged(FragmentSelectionChangeEvent event) {
			refreshTerminalFigure(event.getSelectedFragment(), null);
		}
		
	};
	
	public PortEditPart(View view) {
		super(view);
	}

	/**
	 * @return the delegate
	 */
	PortEditPartDelegate getDelegate() {
		if (delegate == null) {
			delegate = createDelegate();
		}
		return delegate;
	}
	
	PortEditPartDelegate createDelegate() {
		return PASSIVE_DELEGATE;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#activate()
	 */
	public void activate() {
		super.activate();
		addTerminalBorderFigure();
		addTerminalFigure();
		refreshTerminalFigure(null);
		addNodeListener(nodeListener);
		FragmentSelectionManager fragmentManager = (FragmentSelectionManager) getParent().getRoot().getContents().getAdapter(FragmentSelectionManager.class);
		if (fragmentManager != null) {
			fragmentManager.addFragmentSelectionChangeListener(fragmentChangeListener);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#deactivate()
	 */
	public void deactivate() {
		FragmentSelectionManager fragmentManager = (FragmentSelectionManager) getParent().getRoot().getContents().getAdapter(FragmentSelectionManager.class);
		if (fragmentManager != null) {
			fragmentManager.removeFragmentSelectionChangeListener(fragmentChangeListener);
		}
		removeNodeListener(nodeListener);
		removeTerminalFigure();
		removeTerminalBorderFigure();
		super.deactivate();
	}

	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		removeEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#addSemanticListeners()
	 */
	protected void addSemanticListeners() {
		super.addSemanticListeners();
		EObject o = resolveSemanticElement();
		if (o instanceof Port) {
			addListenerFilter("ParentSemanticElement", this, ((Port) o).getComponent());
		}
		getDelegate().addSemanticListeners();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#removeSemanticListeners()
	 */
	protected void removeSemanticListeners() {
		getDelegate().removeSemanticListeners();
		removeListenerFilter("ParentSemanticElement");
		super.removeSemanticListeners();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#isSelectable()
	 */
	public boolean isSelectable() {
		return false;
	}
	
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshTerminalFigure(null);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart#refreshBounds()
	 */
	protected void refreshBounds() {
		// Do nothing
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#handleNotificationEvent(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	protected void handleNotificationEvent(Notification notification) {
		if (notification.getFeature() == DMLPackage.Literals.FRAGMENT_ELEMENT__OWNING_FRAGMENT) {
			refreshTerminalFigure(null);
		} else {
			super.handleNotificationEvent(notification);
		}
	}
		
	protected void addTerminalBorderFigure() {
		IFigure hostFigure = getFigure();
		if (hostFigure instanceof PortFigure) {
			IFigure terminalBorderFigure = ((PortFigure) hostFigure).getTerminalBorderFigure();
			if (hostFigure.getParent() != null) {
				hostFigure.getParent().add(terminalBorderFigure);
			}
		}
	}
	
	protected void removeTerminalBorderFigure() {
		IFigure hostFigure = getFigure();
		if (hostFigure instanceof PortFigure) {
			IFigure terminalBorderFigure = ((PortFigure) hostFigure).getTerminalBorderFigure();
			if (hostFigure.getParent() != null) {
				hostFigure.getParent().remove(terminalBorderFigure);
			}
		}
	}
	
	protected final void refreshTerminalFigure(ConnectionEditPart excludedConnection) {
		FragmentSelectionManager fragmentManager = (FragmentSelectionManager) getRoot().getContents().getAdapter(FragmentSelectionManager.class);
		if (fragmentManager != null) {
			refreshTerminalFigure(fragmentManager.getSelectedFragment(), excludedConnection);
		}
	}

	protected void refreshTerminalFigure(Fragment selectedFragment, ConnectionEditPart excludedConnection) {
		if (terminalFigure == null) {
			return;
		}
		
		EObject element = resolveSemanticElement();
		if (element instanceof Port) {
			Port port = (Port) element;
			if (port.getComponent().getOwningFragment() != selectedFragment
					&& !DMLUtil.isChildFragment(selectedFragment, port.getComponent().getOwningFragment())) {
				terminalFigure.setBlank(true);
				return;
			}
		}

		int connectionCount = 0;
		for (Object o : getSourceConnections()) {
			if (o != excludedConnection && objectIsConnectionAndBelongsToFragment(o, selectedFragment)) {
				++connectionCount;
			}
		}
		for (Object o : getTargetConnections()) {
			if (o != excludedConnection && objectIsConnectionAndBelongsToFragment(o, selectedFragment)) {
				++connectionCount;
			}
		}
		terminalFigure.setBlank(connectionCount != 0);
	}
	
	private boolean objectIsConnectionAndBelongsToFragment(Object o, Fragment selectedFragment) {
		if (o instanceof org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart) {
			org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart connectionEditPart = (org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart) o;
			EObject element = connectionEditPart.resolveSemanticElement();
			if (element instanceof Connection) {
				Connection connection = (Connection) element;
				if (connection.getOwningFragment() == selectedFragment || DMLUtil.isChildFragment(selectedFragment, connection.getOwningFragment())) {
					return true;
				}
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	protected void addTerminalFigure() {
		if (terminalFigure == null) {
			IFigure hostFigure = getFigure();
			if (hostFigure instanceof PortFigure) {
				terminalFigure = ((PortFigure) hostFigure).getTerminalFigure();
				terminalFigure.setBlank(true);
				IFigure parent = getTerminalParentFigure();
				if (parent != null) {
					parent.add(terminalFigure, new Rectangle(0, 0, -1, -1));
				}
				getViewer().getVisualPartMap().put(terminalFigure, this);
			}
		}
	}
	
	protected void removeTerminalFigure() {
		if (terminalFigure != null) {
			getViewer().getVisualPartMap().remove(terminalFigure);
			IFigure parent = getTerminalParentFigure();
			if (parent != null) {
				parent.remove(terminalFigure);
			}
			terminalFigure.invalidate();
			terminalFigure = null;
		}
	}
	
	protected IFigure getTerminalParentFigure() {
		IFigure parent = getFigure().getParent();
		while (parent != null && !(parent instanceof Layer)) {
			parent = parent.getParent();
		}
		return parent;
	}

}
