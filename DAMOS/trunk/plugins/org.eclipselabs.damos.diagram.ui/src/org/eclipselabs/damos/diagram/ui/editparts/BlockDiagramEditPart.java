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

import org.eclipse.gef.CompoundSnapToHelper;
import org.eclipse.gef.SnapToGeometry;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.editpolicies.IEditPolicyRoles;
import org.eclipselabs.damos.diagram.ui.editpolicies.SnapToConnectorFeedbackPolicy;
import org.eclipselabs.damos.diagram.ui.internal.editparts.SnapToConnector;
import org.eclipselabs.damos.diagram.ui.internal.editpolicies.BlockDiagramCreationEditPolicy;
import org.eclipselabs.damos.dml.System;

/**
 * @author Andreas Unger
 *
 */
public class BlockDiagramEditPart extends DiagramEditPart {

	private FragmentSelectionManager fragmentManager;
	
	/**
	 * @param diagramView
	 */
	public BlockDiagramEditPart(View diagramView) {
		super(diagramView);
	}
	
	public void deactivate() {
		if (fragmentManager != null) {
			fragmentManager.dispose();
			fragmentManager = null;
		}
		super.deactivate();
	}

	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		removeEditPolicy(IEditPolicyRoles.POPUPBAR_ROLE);
		installEditPolicy(IEditPolicyRoles.SNAP_TO_CONNECTOR_FEEDBACK_ROLE, new SnapToConnectorFeedbackPolicy());
		installEditPolicy(IEditPolicyRoles.CREATION_ROLE, new BlockDiagramCreationEditPolicy());
	}
	
	public Object getAdapter(@SuppressWarnings("rawtypes") Class key) {
		if (key == FragmentSelectionManager.class) {
			if (fragmentManager == null) {
				fragmentManager = new FragmentSelectionManager((System) resolveSemanticElement());
			}
			return fragmentManager;
		}
		if (key == SnapToHelper.class) {
			Boolean snapEnabled = (Boolean) getViewer().getProperty(SnapToGeometry.PROPERTY_SNAP_ENABLED);
			if (snapEnabled != null && snapEnabled.booleanValue()) {
				SnapToHelper snapToHelper = (SnapToHelper) super.getAdapter(key);
				if (snapToHelper != null) {
					return new CompoundSnapToHelper(new SnapToHelper[] { new SnapToConnector(this), snapToHelper });
				}
				return new SnapToConnector(this);
			}
		}
		return super.getAdapter(key);
	}
	
}
