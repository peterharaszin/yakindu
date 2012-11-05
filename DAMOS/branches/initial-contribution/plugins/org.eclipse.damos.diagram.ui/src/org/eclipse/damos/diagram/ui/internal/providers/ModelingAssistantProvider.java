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

package org.eclipse.damos.diagram.ui.internal.providers;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.damos.diagram.core.type.ElementTypes;
import org.eclipse.damos.diagram.ui.editparts.PortEditPart;

/**
 * @author Andreas Unger
 *
 */
public class ModelingAssistantProvider extends org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider {

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider#getRelTypesOnSourceAndTarget(org.eclipse.core.runtime.IAdaptable, org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	public List<?> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		if (source instanceof PortEditPart && target instanceof PortEditPart) {
			return Collections.singletonList(ElementTypes.CONNECTION);
		}
		return super.getRelTypesOnSourceAndTarget(source, target);
	}

}
