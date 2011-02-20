/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.diagram.ui.internal.editpolicies;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipselabs.damos.dml.Compound;
import org.eclipselabs.damos.dml.DMLPackage;

/**
 * @author Andreas Unger
 *
 */
public class CompoundCompartmentCanonicalEditPolicy extends CanonicalEditPolicy {

	@Override
	protected List<EObject> getSemanticChildrenList() {
		Compound compound = (Compound) resolveSemanticElement();
		if (compound != null) {
			return Collections.<EObject>unmodifiableList(compound.getMembers());
		}
		return Collections.emptyList();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#getFeatureToSynchronize()
	 */
	@Override
	protected EStructuralFeature getFeatureToSynchronize() {
		return DMLPackage.eINSTANCE.getCompound_Members();
	}

}
