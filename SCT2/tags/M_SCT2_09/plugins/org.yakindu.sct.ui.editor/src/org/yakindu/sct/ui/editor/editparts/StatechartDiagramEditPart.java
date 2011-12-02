/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.editparts;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IDiagramPreferenceSupport;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.ui.editor.policies.StatechartCanonicalEditPolicy;

import de.itemis.gmf.runtime.commons.editparts.FixedXYLayoutEditPolicy;

/**
 * 
 * @author andreas muelder
 * 
 */
public class StatechartDiagramEditPart extends DiagramEditPart implements
		IDiagramPreferenceSupport {

	private PreferencesHint preferenceHint;

	public StatechartDiagramEditPart(View diagramView) {
		super(diagramView);
	}

	@Override
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new StatechartCanonicalEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new DragDropEditPolicy());
		// TODO: This is a workaround for GMF bug #349042
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new FixedXYLayoutEditPolicy());
		removeEditPolicy(EditPolicyRoles.POPUPBAR_ROLE);
	}

	public void setPreferencesHint(PreferencesHint preferenceHint) {
		this.preferenceHint = preferenceHint;
	}

	public PreferencesHint getPreferencesHint() {
		return preferenceHint;
	}

}
