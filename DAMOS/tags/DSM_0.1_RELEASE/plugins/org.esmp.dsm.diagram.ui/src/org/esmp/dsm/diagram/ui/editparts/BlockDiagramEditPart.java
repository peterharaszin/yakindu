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

package org.esmp.dsm.diagram.ui.editparts;

import org.eclipse.gef.CompoundSnapToHelper;
import org.eclipse.gef.SnapToGeometry;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.esmp.dsm.diagram.ui.editpolicies.EditPolicyRoles;
import org.esmp.dsm.diagram.ui.editpolicies.SnapToPortFeedbackPolicy;
import org.esmp.dsm.diagram.ui.internal.editparts.SnapToPort;

/**
 * @author Andreas Unger
 *
 */
public class BlockDiagramEditPart extends DiagramEditPart {

	/**
	 * @param diagramView
	 */
	public BlockDiagramEditPart(View diagramView) {
		super(diagramView);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart#createDefaultEditPolicies()
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		removeEditPolicy(EditPolicyRoles.POPUPBAR_ROLE);
		installEditPolicy(EditPolicyRoles.SNAP_TO_PORT_FEEDBACK_ROLE, new SnapToPortFeedbackPolicy());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#getAdapter(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	public Object getAdapter(Class key) {
		if (key == SnapToHelper.class) {
			Boolean snapEnabled = (Boolean) getViewer().getProperty(SnapToGeometry.PROPERTY_SNAP_ENABLED);
			if (snapEnabled != null && snapEnabled.booleanValue()) {
				SnapToHelper snapToHelper = (SnapToHelper) super.getAdapter(key);
				if (snapToHelper != null) {
					return new CompoundSnapToHelper(new SnapToHelper[] { new SnapToPort(this), snapToHelper });
				}
				return new SnapToPort(this);
			}
		}
		return super.getAdapter(key);
	}

}
