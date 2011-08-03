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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.ui.internal.databinding.TextualElementUpdateValueStrategy;

/**
 * @author Andreas Unger
 *
 */
public class LatchPropertySection extends AbstractModelPropertySection {

	private Text initialValueText;

	private IObservableValue initialValueObservable;
	private IObservableValue initialValueTextObservable;
	private EMFDataBindingContext context;
	
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		
		Composite client = (Composite) PropertySectionUtil.createTopLevelSection(parent, "Latch Details", 2,
				getWidgetFactory()).getClient();
		
		Label nameLabel = getWidgetFactory().createLabel(client, "Initial Value:");
		GridData gridData = new GridData();
		nameLabel.setLayoutData(gridData);

		initialValueText = getWidgetFactory().createText(client, "");
		gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
		initialValueText.setLayoutData(gridData);
		
		getWidgetFactory().createLabel(client, "");

		initializeDataBinding();
	}

	private void initializeDataBinding() {
		context = new EMFDataBindingContext();

		IWidgetValueProperty dataTypeTextProperty = WidgetProperties.text(new int[] { SWT.DefaultSelection, SWT.FocusOut });
		initialValueTextObservable = dataTypeTextProperty.observe(initialValueText);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
	 */
	@Override
	public void refresh() {
		super.refresh();
		disposeModelObservables();

		IValueProperty property = EMFEditProperties.value(getEditingDomain(), DMLPackage.eINSTANCE.getLatch_InitialValue());
		initialValueObservable = property.observe(getModel());
		UpdateValueStrategy updateValueStrategy = new TextualElementUpdateValueStrategy(DMLPackage.eINSTANCE.getExpressionSpecification());
		context.bindValue(initialValueTextObservable, initialValueObservable, updateValueStrategy, updateValueStrategy);
	}
	
	private void disposeModelObservables() {
		if (initialValueObservable != null) {
			initialValueObservable.dispose();
			initialValueObservable = null;
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
