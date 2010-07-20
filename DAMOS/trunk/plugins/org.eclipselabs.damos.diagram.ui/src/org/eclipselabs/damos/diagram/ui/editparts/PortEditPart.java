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

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.editpolicies.IEditPolicyRoles;
import org.eclipselabs.damos.diagram.ui.figures.PortFigure;
import org.eclipselabs.damos.diagram.ui.figures.TerminalFigure;
import org.eclipselabs.damos.diagram.ui.internal.editparts.PortEditPartDelegate;
import org.eclipselabs.damos.diagram.ui.internal.editpolicies.PortConnectionHandleEditPolicy;
import org.eclipselabs.damos.diagram.ui.internal.editpolicies.PortCreationEditPolicy;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.Port;
import org.eclipselabs.damos.dml.util.DMLUtil;
import org.eclipselabs.damos.dml.util.IPortListener;
import org.eclipselabs.damos.dml.util.PortEvent;
import org.eclipselabs.damos.dml.util.PortEventBroker;

public abstract class PortEditPart extends ShapeNodeEditPart {

	private static final String PARENT_SEMANTIC_ELEMENT = "ParentSemanticElement";
	private static final PortEditPartDelegate PASSIVE_DELEGATE = new PortEditPartDelegate(null);
	
	private PortEditPartDelegate delegate;

	private IPortListener portListener = new IPortListener() {

		public void handlePortEvent(PortEvent event) {
			switch (event.getEventType()) {
			case PortEvent.CONNECTION_CONNECTED:
			case PortEvent.CONNECTION_DISCONNECTED:
				refreshTerminalFigure();
				break;
			}
		}
		
	};

	IFragmentSelectionChangeListener fragmentChangeListener = new IFragmentSelectionChangeListener() {
		
		public void fragmentSelectionChanged(FragmentSelectionChangeEvent event) {
			refreshTerminalFigure(event.getSelectedFragment());
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
		refreshTerminalFigure();
		FragmentSelectionManager fragmentManager = (FragmentSelectionManager) getParent().getRoot().getContents().getAdapter(FragmentSelectionManager.class);
		if (fragmentManager != null) {
			fragmentManager.addFragmentSelectionChangeListener(fragmentChangeListener);
		}
		Port port = (Port) resolveSemanticElement();
		if (port != null) {
			PortEventBroker.addPortListener(port, portListener);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#deactivate()
	 */
	public void deactivate() {
		PortEventBroker.removePortListener(portListener);
		FragmentSelectionManager fragmentManager = (FragmentSelectionManager) getParent().getRoot().getContents().getAdapter(FragmentSelectionManager.class);
		if (fragmentManager != null) {
			fragmentManager.removeFragmentSelectionChangeListener(fragmentChangeListener);
		}
		removeTerminalFigure();
		removeTerminalBorderFigure();
		super.deactivate();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#createDefaultEditPolicies()
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(IEditPolicyRoles.CREATION_ROLE, new PortCreationEditPolicy());
		installEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE, new PortConnectionHandleEditPolicy());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#addSemanticListeners()
	 */
	protected void addSemanticListeners() {
		super.addSemanticListeners();
		EObject o = resolveSemanticElement();
		if (o instanceof Port) {
			addListenerFilter(PARENT_SEMANTIC_ELEMENT, this, ((Port) o).getComponent());
		}
		getDelegate().addSemanticListeners();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#removeSemanticListeners()
	 */
	protected void removeSemanticListeners() {
		getDelegate().removeSemanticListeners();
		removeListenerFilter(PARENT_SEMANTIC_ELEMENT);
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
		refreshTerminalFigure();
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
			refreshTerminalFigure();
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
	
	protected final void refreshTerminalFigure() {
		FragmentSelectionManager fragmentManager = (FragmentSelectionManager) getRoot().getContents().getAdapter(FragmentSelectionManager.class);
		if (fragmentManager != null) {
			refreshTerminalFigure(fragmentManager.getSelectedFragment());
		}
	}

	protected void refreshTerminalFigure(Fragment selectedFragment) {
		if (getTerminalFigure() == null) {
			return;
		}
		
		EObject element = resolveSemanticElement();
		if (element instanceof Port) {
			Port port = (Port) element;
			if (port.getComponent().getOwningFragment() != selectedFragment
					&& !DMLUtil.isChildFragment(selectedFragment, port.getComponent().getOwningFragment())) {
				getTerminalFigure().setBlank(true);
			} else {
				int connectionCount = 0;
				for (Connection connection : getConnections()) {
					if (connection.getOwningFragment() == selectedFragment
							|| DMLUtil.isChildFragment(selectedFragment, connection.getOwningFragment())) {
						++connectionCount;
					}
				}
				getTerminalFigure().setBlank(connectionCount != 0);
			}
		}
	}
	
	protected abstract List<Connection> getConnections();
	
	@SuppressWarnings("unchecked")
	protected void addTerminalFigure() {
		if (getTerminalFigure() != null) {
			getTerminalFigure().setBlank(true);
			IFigure parent = getTerminalParentFigure();
			if (parent != null) {
				parent.add(getTerminalFigure(), new Rectangle(0, 0, -1, -1));
			}
			getViewer().getVisualPartMap().put(getTerminalFigure(), this);
		}
	}
	
	protected void removeTerminalFigure() {
		if (getTerminalFigure() != null) {
			getViewer().getVisualPartMap().remove(getTerminalFigure());
			IFigure parent = getTerminalParentFigure();
			if (parent != null) {
				parent.remove(getTerminalFigure());
			}
			getTerminalFigure().invalidate();
		}
	}
	
	protected TerminalFigure getTerminalFigure() {
		IFigure hostFigure = getFigure();
		if (hostFigure instanceof PortFigure) {
			return ((PortFigure) hostFigure).getTerminalFigure();
		}
		return null;
	}
	
	protected IFigure getTerminalParentFigure() {
		IFigure parent = getFigure().getParent();
		while (parent != null && !(parent instanceof Layer)) {
			parent = parent.getParent();
		}
		return parent;
	}

}
