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

package org.eclipselabs.damos.diagram.ui.editpolicies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.Fragment;

/**
 * Sync notation views with semantic children
 * 
 * @author Andreas Unger
 */
public class FragmentCanonicalEditPolicy extends CanonicalConnectionEditPolicy {
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#getSemanticChildrenList()
	 */
	protected List<EObject> getSemanticChildrenList() {
		EObject o = resolveSemanticElement();
		if (o.eResource() == null) {
			return Collections.emptyList();
		}

		List<EObject> children = new ArrayList<EObject>();
		for (EObject eObject : o.eResource().getContents()) {
			if (eObject instanceof Fragment) {
				children.addAll(((Fragment) eObject).getComponents());
			}
		}
		
		return children;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy#getSemanticConnectionsList()
	 */
	@Override
	protected List<EObject> getSemanticConnectionsList() {
		EObject o = resolveSemanticElement();
		if (o.eResource() == null) {
			return Collections.emptyList();
		}

		List<EObject> children = new ArrayList<EObject>();
		for (EObject eObject : o.eResource().getContents()) {
			if (eObject instanceof Fragment) {
				children.addAll(((Fragment) eObject).getConnections());
			}
		}
		
		return children;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy#getSourceElement(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected EObject getSourceElement(EObject relationship) {
		if (relationship instanceof Connection) {
			return ((Connection) relationship).getSource();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy#getTargetElement(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected EObject getTargetElement(EObject relationship) {
		if (relationship instanceof Connection) {
			return ((Connection) relationship).getTarget();
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy#shouldCheckForConnections(org.eclipse.gmf.runtime.notation.View, java.util.Collection)
	 */
	@Override
	protected boolean shouldCheckForConnections(View view, Collection<View> viewChildren) {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy#shouldDeleteView(org.eclipse.gmf.runtime.notation.View)
	 */
	@Override
	protected boolean shouldDeleteView(View view) {
		if (view instanceof Edge) {
			if (view.getElement() instanceof Connection) {
				Connection connection = (Connection) view.getElement();
				return connection.getOwningFragment() == resolveSemanticElement();
			}
			return false;
		}
		return super.shouldDeleteView(view);
	}
	
}
