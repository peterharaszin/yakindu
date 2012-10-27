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

package org.eclipse.damos.dml.ui.editpane;

import org.eclipse.damos.common.ui.widgets.IWidgetFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * @author Andreas Unger
 *
 */
public interface IValueSpecificationEditPane {
	
	void createControl(Composite parent, IWidgetFactory widgetFactory);
	
	Control getControl();

	void initialize();
	
	void refresh(EditingDomain editingDomain, EObject source, EStructuralFeature feature);
	void refresh(EditingDomain editingDomain, EObject source, EStructuralFeature... featurePath);

	void dispose();
	
}
