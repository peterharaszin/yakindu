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

package org.eclipselabs.damos.dml.ui.internal.properties;

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.jface.databinding.swt.IWidgetValueProperty;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.ui.internal.databinding.HyperlinkObservableValue;
import org.eclipselabs.damos.dml.ui.internal.databinding.TextualElementUpdateValueStrategy;

/**
 * @author Andreas Unger
 *
 */
public class InoutportDataTypePropertySection extends AbstractModelPropertySection {

	private static final String[] PREDEFINED_DATA_TYPES = new String[] {
		"real",
		"int",
		"bool"
	};
	
	private Text dataTypeText;
	private Composite commonDataTypesComposite;

	private IObservableValue dataTypeObservable;
	private IObservableValue dataTypeTextObservable;
	private EMFDataBindingContext context;
	
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		
		Composite client = (Composite) PropertySectionUtil.createTopLevelSection(parent, "Data Type Information", 2,
				getWidgetFactory()).getClient();
		
		Label nameLabel = getWidgetFactory().createLabel(client, "Data Type:");
		GridData gridData = new GridData();
		nameLabel.setLayoutData(gridData);

		dataTypeText = getWidgetFactory().createText(client, "");
		gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
		dataTypeText.setLayoutData(gridData);
		
		getWidgetFactory().createLabel(client, "");

		commonDataTypesComposite = getWidgetFactory().createComposite(client);
		GridLayout commonDataTypesLayout = new GridLayout(PREDEFINED_DATA_TYPES.length + 1, false);
		commonDataTypesLayout.marginWidth = 0;
		commonDataTypesLayout.marginHeight = 0;
		commonDataTypesComposite.setLayout(commonDataTypesLayout);
		getWidgetFactory().createLabel(commonDataTypesComposite, "Common data types:");
		
		initializeDataBinding();
	}

	private void initializeDataBinding() {
		context = new EMFDataBindingContext();

		IWidgetValueProperty dataTypeTextProperty = WidgetProperties.text(new int[] { SWT.DefaultSelection, SWT.FocusOut });
		dataTypeTextObservable = dataTypeTextProperty.observe(dataTypeText);

		for (final String predefinedDataType : PREDEFINED_DATA_TYPES) {
			Hyperlink hyperlink = getWidgetFactory().createHyperlink(commonDataTypesComposite, predefinedDataType, SWT.NONE);
			IObservableValue observable = new HyperlinkObservableValue(hyperlink);
			context.bindValue(dataTypeTextObservable, observable, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
	 */
	@Override
	public void refresh() {
		super.refresh();
		disposeModelObservables();

		IValueProperty property = EMFEditProperties.value(getEditingDomain(), DMLPackage.eINSTANCE.getInoutport_DataType());
		dataTypeObservable = property.observe(getModel());
		UpdateValueStrategy updateValueStrategy = new TextualElementUpdateValueStrategy(DMLPackage.eINSTANCE.getOpaqueDataTypeSpecification());
		context.bindValue(dataTypeTextObservable, dataTypeObservable, updateValueStrategy, updateValueStrategy);
	}
	
	private void disposeModelObservables() {
		if (dataTypeObservable != null) {
			dataTypeObservable.dispose();
			dataTypeObservable = null;
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#dispose()
	 */
	@Override
	public void dispose() {
		disposeModelObservables();
		super.dispose();
	}

}
