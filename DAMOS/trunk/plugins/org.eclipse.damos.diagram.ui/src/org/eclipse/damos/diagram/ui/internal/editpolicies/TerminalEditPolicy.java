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

package org.eclipse.damos.diagram.ui.internal.editpolicies;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.damos.diagram.ui.figures.TerminalFigure;
import org.eclipse.damos.diagram.ui.internal.editparts.IConnectorEditPart;
import org.eclipse.damos.dml.Connection;
import org.eclipse.damos.dml.Connector;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.dml.FragmentElement;
import org.eclipse.damos.dml.util.ConnectionEvent;
import org.eclipse.damos.dml.util.ConnectionEventBroker;
import org.eclipse.damos.dml.util.DMLUtil;
import org.eclipse.damos.dml.util.FragmentSelectionChangeEvent;
import org.eclipse.damos.dml.util.FragmentSelectionManager;
import org.eclipse.damos.dml.util.IConnectionListener;
import org.eclipse.damos.dml.util.IFragmentSelectionChangeListener;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;

/**
 * @author Andreas Unger
 *
 */
public class TerminalEditPolicy extends GraphicalEditPolicy {

	private Connector cachedConnector;

	private IConnectionListener connectionListener = new IConnectionListener() {
		
		public void connectionChanged(ConnectionEvent event) {
			refreshTerminalFigure();
		}
		
	};
	
	private IFragmentSelectionChangeListener fragmentChangeListener = new IFragmentSelectionChangeListener() {
		
		public void fragmentSelectionChanged(FragmentSelectionChangeEvent event) {
			refreshTerminalFigure(event.getSelectedFragment());
		}
		
	};
	
	private Adapter semanticAdapter = new AdapterImpl() {
		
		public void notifyChanged(Notification msg) {
			if (msg.getFeature() == DMLPackage.Literals.FRAGMENT_ELEMENT__OWNING_FRAGMENT) {
				refreshTerminalFigure();
			}
		}
		
	};

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#activate()
	 */
	@Override
	public void activate() {
		super.activate();
		
		if (getTerminalFigure() != null) {
			@SuppressWarnings("unchecked")
			Map<Object, Object> visualMap = getHost().getViewer().getVisualPartMap();
			visualMap.put(getTerminalFigure(), getHost());
		}

		refreshTerminalFigure();
		
		FragmentSelectionManager fragmentManager = (FragmentSelectionManager) getHost().getParent().getRoot().getContents().getAdapter(FragmentSelectionManager.class);
		if (fragmentManager != null) {
			fragmentManager.addFragmentSelectionChangeListener(fragmentChangeListener);
		}

		Connector connector = (Connector) getHost().resolveSemanticElement();
		if (connector != null) {
			cachedConnector = connector;
			ConnectionEventBroker.addListener(cachedConnector, connectionListener);

			FragmentElement fragmentElement = DMLUtil.getOwner(cachedConnector, FragmentElement.class);
			if (fragmentElement != null) {
				fragmentElement.eAdapters().add(semanticAdapter);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#deactivate()
	 */
	@Override
	public void deactivate() {
		if (cachedConnector != null) {
			FragmentElement fragmentElement = DMLUtil.getOwner(cachedConnector, FragmentElement.class);
			if (fragmentElement != null) {
				fragmentElement.eAdapters().remove(semanticAdapter);
			}

			ConnectionEventBroker.removeListener(cachedConnector, connectionListener);
		}
		
		FragmentSelectionManager fragmentManager = (FragmentSelectionManager) getHost().getParent().getRoot().getContents().getAdapter(FragmentSelectionManager.class);
		if (fragmentManager != null) {
			fragmentManager.removeFragmentSelectionChangeListener(fragmentChangeListener);
		}

		if (getTerminalFigure() != null) {
			getHost().getViewer().getVisualPartMap().remove(getTerminalFigure());
		}

		super.deactivate();
	}
	
	protected final void refreshTerminalFigure() {
		RootEditPart root = getHost().getRoot();
		if (root != null) {
			FragmentSelectionManager fragmentManager = (FragmentSelectionManager) root.getContents().getAdapter(FragmentSelectionManager.class);
			if (fragmentManager != null) {
				refreshTerminalFigure(fragmentManager.getSelectedFragment());
			}
		}
	}

	protected void refreshTerminalFigure(Fragment selectedFragment) {
		if (getTerminalFigure() == null) {
			return;
		}
		
		EObject element = getHost().resolveSemanticElement();
		if (element instanceof Connector) {
			int connectionCount = 0;
			for (Connection connection : getConnections()) {
				if (connection.getOwningFragment() == selectedFragment
						|| DMLUtil.isChildFragment(selectedFragment, connection.getOwningFragment())) {
					++connectionCount;
				}
			}
			getTerminalFigure().setConnected(connectionCount != 0);
		}
	}
	
	protected TerminalFigure getTerminalFigure() {
		return getHost().getConnectorFigure().getTerminalFigure();
	}
	
	protected List<Connection> getConnections() {
		Connector connector = (Connector) getHost().resolveSemanticElement();
		if (connector != null) {
			return connector.getConnections();
		}
		return Collections.emptyList();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#getHost()
	 */
	@Override
	public IConnectorEditPart getHost() {
		return (IConnectorEditPart) super.getHost();
	}

}
