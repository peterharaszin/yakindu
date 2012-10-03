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

package org.eclipse.damos.dml.ui.properties;

import org.eclipse.damos.common.ui.widgets.FormWidgetFactory;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.ui.editpane.IDataTypeSpecificationEditPane;
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
public class InoutportDataTypePropertySection extends AbstractModelPropertySection {

	@Inject
	private Provider<IDataTypeSpecificationEditPane> dataTypeEditorProvider;
	private IDataTypeSpecificationEditPane dataTypeEditor;
	
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		
		dataTypeEditor = dataTypeEditorProvider.get();
		
		Composite client = (Composite) PropertySectionUtil.createTopLevelSection(parent, "Data Type Information", 2,
				getWidgetFactory()).getClient();
		
		Label nameLabel = getWidgetFactory().createLabel(client, "Data Type:");
		GridData gridData = new GridData();
		nameLabel.setLayoutData(gridData);

		dataTypeEditor.createEditControl(client, FormWidgetFactory.INSTANCE);
		
		if (dataTypeEditor.providesCommonDataTypesControl()) {
			getWidgetFactory().createLabel(client, "");
			dataTypeEditor.createCommonDataTypesControl(client, FormWidgetFactory.INSTANCE);
		}
		
		dataTypeEditor.initialize();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
	 */
	@Override
	public void refresh() {
		super.refresh();
		dataTypeEditor.refresh(getEditingDomain(), getModel(), DMLPackage.eINSTANCE.getInoutport_DataType());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#dispose()
	 */
	@Override
	public void dispose() {
		if (dataTypeEditor != null) {
			dataTypeEditor.dispose();
		}
		super.dispose();
	}

}
