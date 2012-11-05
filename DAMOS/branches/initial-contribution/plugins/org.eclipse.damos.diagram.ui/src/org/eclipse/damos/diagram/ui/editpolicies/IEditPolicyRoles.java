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

package org.eclipse.damos.diagram.ui.editpolicies;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;

/**
 * @author Andreas Unger
 *
 * @noextend
 * @noimplement
 */
public interface IEditPolicyRoles extends EditPolicyRoles {

	String TRANSFORM_ROLE = "transformRole";
	String INPUT_PORT_COUNT_ROLE = "inputPortCountRole";
	String OUTPUT_PORT_COUNT_ROLE = "outputPortCountRole";
	String SNAP_TO_CONNECTOR_FEEDBACK_ROLE = "snapToConnectorFeedbackRole";
	String TERMINAL_ROLE = "terminalRole";
	String FRAGMENT_SELECTION_ROLE = "fragmentSelectionRole";
	
}
