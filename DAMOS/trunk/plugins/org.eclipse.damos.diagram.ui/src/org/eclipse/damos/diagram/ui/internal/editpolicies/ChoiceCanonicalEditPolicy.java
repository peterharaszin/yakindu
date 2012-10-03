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

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.damos.diagram.ui.editpolicies.ComponentCanonicalEditPolicy;
import org.eclipse.damos.dml.ActionLink;
import org.eclipse.damos.dml.Choice;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @author Andreas Unger
 *
 */
public class ChoiceCanonicalEditPolicy extends ComponentCanonicalEditPolicy {

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy#getSemanticConnectionsList()
	 */
	@Override
	protected List<EObject> getSemanticConnectionsList() {
		return Collections.<EObject>unmodifiableList(((Choice) resolveSemanticElement()).getActionLinks());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy#getSourceElement(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected EObject getSourceElement(EObject relationship) {
		return ((ActionLink) relationship).getChoice();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy#getTargetElement(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected EObject getTargetElement(EObject relationship) {
		return ((ActionLink) relationship).getAction();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy#shouldIncludeConnection(org.eclipse.gmf.runtime.notation.Edge, java.util.Collection)
	 */
	@Override
	protected boolean shouldIncludeConnection(Edge connection, Collection<View> children) {
		return connection.getSource() != null && connection.getSource() == getHost().getModel();
	}

}
