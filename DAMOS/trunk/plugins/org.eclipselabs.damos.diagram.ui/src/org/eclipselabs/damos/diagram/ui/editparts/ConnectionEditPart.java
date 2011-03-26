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

import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipselabs.damos.diagram.ui.figures.ConnectionFigure;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.Connector;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.Inport;
import org.eclipselabs.damos.dml.Outport;
import org.eclipselabs.damos.dml.Port;
import org.eclipselabs.damos.dml.util.DMLUtil;

public class ConnectionEditPart extends ConnectionNodeEditPart {

	private IFragmentSelectionChangeListener fragmentChangeListener = new IFragmentSelectionChangeListener() {
		
		public void fragmentSelectionChanged(FragmentSelectionChangeEvent event) {
			refreshVisibility();
		}

	};

	public ConnectionEditPart(View view) {
		super(view);
	}
	
	public void activate() {
		super.activate();
		FragmentSelectionManager fragmentManager = (FragmentSelectionManager) getRoot().getContents().getAdapter(FragmentSelectionManager.class);
		if (fragmentManager != null) {
			fragmentManager.addFragmentSelectionChangeListener(fragmentChangeListener);
		}
	}
	
	public void deactivate() {
		FragmentSelectionManager fragmentManager = (FragmentSelectionManager) getRoot().getContents().getAdapter(FragmentSelectionManager.class);
		if (fragmentManager != null) {
			fragmentManager.removeFragmentSelectionChangeListener(fragmentChangeListener);
		}
		super.deactivate();
	}
	
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshConnectionType();
	}
	
	protected void refreshConnectionType() {
		Connection connection = (Connection) resolveSemanticElement();
		if (connection != null) {
			Connector source = connection.getSource();
			Connector target = connection.getTarget();
			Component sourceComponent = source instanceof Port ? ((Port) source).getComponent() : null;
			Component targetComponent = target instanceof Port ? ((Port) target).getComponent() : null;
			setLineType(sourceComponent instanceof Outport || targetComponent instanceof Inport ? SWT.LINE_DASHDOTDOT : SWT.LINE_SOLID);
		}
	}
	
	protected void setLineType(int lineType) {
		((ConnectionFigure) getFigure()).setLineStyle(lineType);
	}
	
	protected void refreshVisibility() {
		boolean visible = true;
		
		EObject element = resolveSemanticElement();
		if (element instanceof Connection) {
			Connection connection = (Connection) element;
			FragmentSelectionManager fragmentManager = (FragmentSelectionManager) getRoot().getContents().getAdapter(FragmentSelectionManager.class);
			if (fragmentManager != null) {
				Fragment selectedFragment = fragmentManager.getSelectedFragment();
				visible = selectedFragment == connection.getOwningFragment() || DMLUtil.isChildFragment(selectedFragment, connection.getOwningFragment());
			}
		}
		
		if (visible) {
			super.refreshVisibility();
		} else {
			setVisibility(false);
		}
	}
	
	protected PolylineConnection createConnectionFigure() {
		if (getModel() == null) {
			return null;
		}
		return new ConnectionFigure();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart#getTargetEditPart(org.eclipse.gef.Request)
	 */
	public EditPart getTargetEditPart(Request request) {
		EditPart editPart = super.getTargetEditPart(request);
		if (editPart instanceof org.eclipse.gef.ConnectionEditPart) {
			Object type = request.getType();
			if (RequestConstants.REQ_CONNECTION_START.equals(type)
					|| RequestConstants.REQ_RECONNECT_SOURCE.equals(type)) {
				 return ((org.eclipse.gef.ConnectionEditPart) editPart).getSource();
			} else if (RequestConstants.REQ_CONNECTION_END.equals(type)
					|| RequestConstants.REQ_RECONNECT_TARGET.equals(type)) {
				 return ((org.eclipse.gef.ConnectionEditPart) editPart).getTarget();
			}
		}
		return editPart;
	}
	
	protected void handleNotificationEvent(Notification notification) {
		Object feature = notification.getFeature();
		if (DMLPackage.Literals.FRAGMENT_ELEMENT__OWNING_FRAGMENT == feature) {
			refreshVisibility();
		} else if (DMLPackage.eINSTANCE.getConnection_Source() == feature || DMLPackage.eINSTANCE.getConnection_Target() == feature) {
			refreshConnectionType();
		} else {
			super.handleNotificationEvent(notification);
		}
	}

}
