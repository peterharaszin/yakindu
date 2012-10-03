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

package org.eclipse.damos.diagram.ui.properties;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.damos.diagram.ui.view.ISemanticHints;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @author Andreas Unger
 *
 */
public class ShowComponentNamePropertySection extends AbstractCheckboxPropertySection {

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.properties.AbstractBasicCheckboxPropertySection#getPropertyChangeCommandName()
	 */
	protected String getPropertyChangeCommandName() {
		return "Change Show Name Property";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.properties.AbstractBasicCheckboxPropertySection#getPropertyNameLabel()
	 */
	protected String getPropertyNameLabel() {
		return "Show Name";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.properties.AbstractBasicCheckboxPropertySection#getPropertyValue()
	 */
	@SuppressWarnings("unchecked")
	protected boolean getPropertyValueBoolean() {
		IGraphicalEditPart editPart = (IGraphicalEditPart) getPrimarySelection();
		if (editPart != null) {
			View view = editPart.getNotationView();
			if (view != null) {
				for (View childView : (List<View>) view.getChildren()) {
					if (ISemanticHints.COMPONENT_NAME.equals(childView.getType())) {
						return childView.isVisible();
					}
				}
			}
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.ui.properties.AbstractBasicCheckboxPropertySection#setPropertyValue(org.eclipse.emf.ecore.EObject, java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	protected void setPropertyValue(EObject object, Object value) {
		for (View childView : (List<View>) ((View) object).getChildren()) {
			if (ISemanticHints.COMPONENT_NAME.equals(childView.getType())) {
				childView.setVisible((Boolean) value);
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractModelerPropertySection#adapt(java.lang.Object)
	 */
	protected EObject adapt(Object object) {
		if (object instanceof IGraphicalEditPart) {
			return (EObject) ((IAdaptable) object).getAdapter(View.class);
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractModelerPropertySection#isCurrentSelection(org.eclipse.emf.common.notify.Notification, org.eclipse.emf.ecore.EObject)
	 */
	protected boolean isCurrentSelection(Notification notification, EObject element) {
		return true;
	}

}
