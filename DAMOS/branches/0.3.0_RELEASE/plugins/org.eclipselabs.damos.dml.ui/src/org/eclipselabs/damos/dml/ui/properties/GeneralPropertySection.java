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

package org.eclipselabs.damos.dml.ui.properties;

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

/**
 * @author Andreas Unger
 *
 */
public class GeneralPropertySection extends AbstractModelPropertySection {

	private Text nameText;
	private IObservableValue nameObservable;
	private IObservableValue nameTextObservable;
	
	private EMFDataBindingContext context;
	
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		
		Composite composite = PropertySectionUtil.createTopLevelComposite(parent, 2, getWidgetFactory());
		
		Label nameLabel = getWidgetFactory().createLabel(composite, "Name:");
		GridData gridData = new GridData();
		nameLabel.setLayoutData(gridData);

		nameText = getWidgetFactory().createText(composite, "");
		gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
		nameText.setLayoutData(gridData);		

		initializeDataBinding();
	}

	private void initializeDataBinding() {
		context = new EMFDataBindingContext();
		IWidgetValueProperty sampleTimeUIProperty = WidgetProperties.text(new int[] { SWT.DefaultSelection, SWT.FocusOut });
		nameTextObservable = sampleTimeUIProperty.observe(nameText);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
	 */
	@Override
	public void refresh() {
		super.refresh();
		disposeModelObservables();

		IValueProperty property = EMFEditProperties.value(getEditingDomain(), DMLPackage.eINSTANCE.getComponent_Name());
		nameObservable = property.observe(getModel());
		context.bindValue(nameTextObservable, nameObservable);
	}
	
	private void disposeModelObservables() {
		if (nameObservable != null) {
			nameObservable.dispose();
			nameObservable = null;
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
