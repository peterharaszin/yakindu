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

package org.eclipselabs.damos.library.common.ui.properties;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.PropertiesSetStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.properties.AbstractComboPropertySection;
import org.eclipselabs.damos.library.common.ui.view.styles.MultiShapeBlockStyles;

/**
 * @author Andreas Unger
 *
 */
public abstract class ShapePropertySection extends AbstractComboPropertySection {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.properties.AbstractBasicComboPropertySection#isStandalone()
	 */
	protected boolean isStandalone() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.properties.AbstractBasicComboPropertySection#getPropertyNameLabel()
	 */
	protected String getPropertyNameLabel() {
		return "Shape:";
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.properties.AbstractBasicComboPropertySection#getPropertyChangeCommandName()
	 */
	protected String getPropertyChangeCommandName() {
		return "Change Shape";
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
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.library.basic.ui.properties.ShapePropertySection#setPropertyValue(org.eclipse.emf.ecore.EObject, java.lang.Object)
	 */
	protected void setPropertyValue(EObject object, Object value) {
		if (object instanceof Node && value instanceof Enum<?>) {
			PropertiesSetStyle shapeStyle = (PropertiesSetStyle) ((Node) object).getNamedStyle(NotationPackage.eINSTANCE.getPropertiesSetStyle(), MultiShapeBlockStyles.SHAPE_STYLE);
			if (shapeStyle != null) {
				shapeStyle.setProperty(MultiShapeBlockStyles.SHAPE_STYLE__SHAPE, ((Enum<?>) value).name());
			}
		}
	}

}
