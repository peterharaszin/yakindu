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

package org.eclipselabs.damos.dml.ui;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipselabs.damos.common.ui.widgets.IWidgetFactory;

/**
 * @author Andreas Unger
 *
 */
public interface IDataTypeSpecificationEditor {
	
	Control createEditControl(Composite parent, IWidgetFactory widgetFactory);
	
	Control getEditControl();

	boolean providesCommonDataTypesControl();
	
	Control createCommonDataTypesControl(Composite parent, IWidgetFactory widgetFactory);
	
	Control getCommonDataTypesControl();
	
	void initialize();

	void refresh(EditingDomain editingDomain, EObject source, EStructuralFeature feature);

	void refresh(EditingDomain editingDomain, EObject source, EStructuralFeature... featurePath);

	void dispose();
	
}
