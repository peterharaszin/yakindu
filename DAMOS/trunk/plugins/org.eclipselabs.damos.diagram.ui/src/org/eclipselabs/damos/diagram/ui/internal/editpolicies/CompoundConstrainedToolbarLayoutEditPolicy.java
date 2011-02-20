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

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableCompartmentEditPolicy;

/**
 * @author Andreas Unger
 *
 */
public class CompoundConstrainedToolbarLayoutEditPolicy extends ConstrainedToolbarLayoutEditPolicy {

	@Override
	protected EditPolicy createChildEditPolicy(EditPart child) {
		if (child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE) == null
				&& child instanceof ResizableCompartmentEditPart) {
			return new ResizableCompartmentEditPolicy(isHorizontal()) {

				protected java.util.List<?> createCollapseHandles() {
					return Collections.emptyList();
				}
				
			};
		}
		return super.createChildEditPolicy(child);
	}

}
