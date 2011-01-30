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

package org.eclipselabs.damos.diagram.ui.internal.properties;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipselabs.damos.diagram.ui.properties.AbstractTextPropertySection;
import org.eclipselabs.damos.dml.Component;

/**
 * @author Andreas Unger
 *
 */
public class ComponentNamePropertySection extends AbstractTextPropertySection {

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
			if (o instanceof Component) {
				String name = ((Component) o).getName();
				if (name != null) {
					return name;
				}
			}
		}
		return "";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractBasicTextPropertySection#setPropertyValue(org.eclipse.emf.ecore.EObject, java.lang.Object)
	 */
	protected void setPropertyValue(EObject object, Object value) {
		if (object instanceof Component && value instanceof String) {
			((Component) object).setName((String) value);
		}
	}

}
