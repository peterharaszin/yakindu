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

package org.eclipse.damos.dml.ui.properties;

import org.eclipse.damos.common.ui.widgets.FormWidgetFactory;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.ui.editpane.IValueSpecificationEditPane;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Andreas Unger
 *
 */
public class LatchPropertySection extends AbstractModelPropertySection {

	@Inject
	private Provider<IValueSpecificationEditPane> initialValueEditorProvider;
	private IValueSpecificationEditPane initialValueEditor;

	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		
		initialValueEditor = initialValueEditorProvider.get();
		
		Composite client = (Composite) PropertySectionUtil.createTopLevelSection(parent, "Latch Details", 2,
				getWidgetFactory()).getClient();
		
		Label nameLabel = getWidgetFactory().createLabel(client, "Initial Value:");
		GridData gridData = new GridData();
		nameLabel.setLayoutData(gridData);

		initialValueEditor.createControl(client, FormWidgetFactory.INSTANCE);
		initialValueEditor.initialize();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
	 */
	@Override
	public void refresh() {
		super.refresh();
		initialValueEditor.refresh(getEditingDomain(), getModel(), DMLPackage.eINSTANCE.getLatch_InitialValue());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#dispose()
	 */
	@Override
	public void dispose() {
		if (initialValueEditor != null) {
			initialValueEditor.dispose();
		}
		super.dispose();
	}

}
