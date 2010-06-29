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

package org.esmp.dsm.diagram.ui.internal.properties;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.esmp.dsm.diagram.ui.properties.AbstractTextPropertySection;
import org.esmp.dsm.semantic.blockdiagram.Block;

/**
 * @author Andreas Unger
 *
 */
public class BlockNamePropertySection extends AbstractTextPropertySection {

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractBasicTextPropertySection#getPropertyChangeCommandName()
	 */
	protected String getPropertyChangeCommandName() {
		return "Change Block Name";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractBasicTextPropertySection#getPropertyNameLabel()
	 */
	protected String getPropertyNameLabel() {
		return "Name:";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractBasicTextPropertySection#getPropertyValueString()
	 */
	protected String getPropertyValueString() {
		IGraphicalEditPart editPart = (IGraphicalEditPart) getPrimarySelection();
		if (editPart != null) {
			EObject o = editPart.resolveSemanticElement();
			if (o instanceof Block) {
				return ((Block) o).getName();
			}
		}
		return "";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractBasicTextPropertySection#setPropertyValue(org.eclipse.emf.ecore.EObject, java.lang.Object)
	 */
	protected void setPropertyValue(EObject object, Object value) {
		if (object instanceof Block && value instanceof String) {
			((Block) object).setName((String) value);
		}
	}

}
