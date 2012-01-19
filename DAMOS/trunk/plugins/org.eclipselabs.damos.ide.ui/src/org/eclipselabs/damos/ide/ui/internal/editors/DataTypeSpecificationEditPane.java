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

package org.eclipselabs.damos.ide.ui.internal.editors;

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.swt.IWidgetValueProperty;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipselabs.damos.common.ui.widgets.IWidgetFactory;
import org.eclipselabs.damos.dml.ui.editpane.IDataTypeSpecificationEditPane;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Andreas Unger
 *
 */
public class DataTypeSpecificationEditPane implements IDataTypeSpecificationEditPane {

	@Inject
	private Provider<DataTypeSpecificationUpdateValueStrategy> updateValueStrategyProvider;
	
	private static final String[] COMMON_DATA_TYPES = new String[] {
		"real",
		"int",
		"boolean"
	};

	private EMFDataBindingContext context;
	private IObservableValue dataTypeObservable;
	private IObservableValue dataTypeTextObservable;
	
	private Text dataTypeText;
	private Composite commonDataTypesComposite;
	private Hyperlink[] hyperlinks = new Hyperlink[COMMON_DATA_TYPES.length];

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.ui.IDataTypeSpecificationEditor#createEditControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createEditControl(Composite parent, IWidgetFactory widgetFactory) {
		dataTypeText = widgetFactory.createText(parent, "");
		GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
		dataTypeText.setLayoutData(gridData);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.ui.IDataTypeSpecificationEditor#getEditControl()
	 */
	public Control getEditControl() {
		return dataTypeText;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.ui.IDataTypeSpecificationEditor#contributesCommonDataTypesControl()
	 */
	public boolean providesCommonDataTypesControl() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.ui.IDataTypeSpecificationEditor#createCommonDataTypesControl(org.eclipse.swt.widgets.Composite)
	 */
	public Control createCommonDataTypesControl(Composite parent, IWidgetFactory widgetFactory) {
		commonDataTypesComposite = widgetFactory.createComposite(parent);
		GridLayout commonDataTypesLayout = new GridLayout(COMMON_DATA_TYPES.length + 1, false);
		commonDataTypesLayout.marginWidth = 0;
		commonDataTypesLayout.marginHeight = 0;
		commonDataTypesComposite.setLayout(commonDataTypesLayout);
		widgetFactory.createLabel(commonDataTypesComposite, "Common data types:");

		for (int i = 0; i < COMMON_DATA_TYPES.length; ++i) {
			hyperlinks[i] = widgetFactory.createHyperlink(commonDataTypesComposite, COMMON_DATA_TYPES[i], SWT.NONE);
		}
		
		return commonDataTypesComposite;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.ui.IDataTypeSpecificationEditor#getCommonDataTypesControl()
	 */
	public Control getCommonDataTypesControl() {
		return commonDataTypesComposite;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.ui.IDataTypeSpecificationEditor#initialize()
	 */
	public void initialize() {
		context = new EMFDataBindingContext();

		IWidgetValueProperty dataTypeTextProperty = WidgetProperties.text(new int[] { SWT.DefaultSelection, SWT.FocusOut });
		dataTypeTextObservable = dataTypeTextProperty.observe(dataTypeText);
		
		for (Hyperlink hyperlink : hyperlinks) {
			IObservableValue observable = new HyperlinkObservableValue(hyperlink);
			context.bindValue(dataTypeTextObservable, observable, new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), null);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.ui.IDataTypeSpecificationEditor#initialize(org.eclipse.emf.edit.domain.EditingDomain, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature)
	 */
	public void refresh(EditingDomain editingDomain, EObject source, EStructuralFeature feature) {
		disposeModelObservables();

		IValueProperty property = EMFEditProperties.value(editingDomain, feature);
		refreshDataBinding(source, property);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.ui.IDataTypeSpecificationEditor#refresh(org.eclipse.emf.edit.domain.EditingDomain, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature[])
	 */
	public void refresh(EditingDomain editingDomain, EObject source, EStructuralFeature... featurePath) {
		disposeModelObservables();

		IValueProperty property = EMFEditProperties.value(editingDomain, FeaturePath.fromList(featurePath));
		refreshDataBinding(source, property);
	}

	/**
	 * @param source
	 * @param property
	 */
	private void refreshDataBinding(EObject source, IValueProperty property) {
		dataTypeObservable = property.observe(source);
		UpdateValueStrategy updateValueStrategy = updateValueStrategyProvider.get();
		context.bindValue(dataTypeTextObservable, dataTypeObservable, updateValueStrategy, updateValueStrategy);
	}
	
	private void disposeModelObservables() {
		if (dataTypeObservable != null) {
			dataTypeObservable.dispose();
			dataTypeObservable = null;
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.ui.IDataTypeSpecificationEditor#dispose()
	 */
	public void dispose() {
		disposeModelObservables();
	}

}
