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

package org.eclipse.damos.ide.ui.internal.editors;

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.damos.common.ui.widgets.IWidgetFactory;
import org.eclipse.damos.dml.ui.editpane.IValueSpecificationEditPane;
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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Andreas Unger
 *
 */
public class ValueSpecificationEditPane implements IValueSpecificationEditPane {

	@Inject
	private Provider<ValueSpecificationUpdateValueStrategy> updateValueStrategyProvider;

	private EMFDataBindingContext context;
	private IObservableValue valueObservable;
	private IObservableValue valueTextObservable;
	
	private Text text;

	public void createControl(Composite parent, IWidgetFactory widgetFactory) {
		text = widgetFactory.createText(parent, "");
		GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
		text.setLayoutData(gridData);		
	}
	
	public Control getControl() {
		return text;
	}

	public void initialize() {
		context = new EMFDataBindingContext();

		IWidgetValueProperty textProperty = WidgetProperties.text(new int[] { SWT.DefaultSelection, SWT.FocusOut });
		valueTextObservable = textProperty.observe(text);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.dml.ui.IValueSpecificationEditor#refresh(org.eclipse.emf.edit.domain.EditingDomain, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature)
	 */
	public void refresh(EditingDomain editingDomain, EObject source, EStructuralFeature feature) {
		disposeModelObservables();
		
		IValueProperty property = EMFEditProperties.value(editingDomain, feature);
		refreshDataBinding(source, property);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.dml.ui.IValueSpecificationEditor#refresh(org.eclipse.emf.edit.domain.EditingDomain, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature[])
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
	protected void refreshDataBinding(EObject source, IValueProperty property) {
		valueObservable = property.observe(source);
		UpdateValueStrategy updateValueStrategy = updateValueStrategyProvider.get();
		context.bindValue(valueTextObservable, valueObservable, updateValueStrategy, updateValueStrategy);
	}
	
	private void disposeModelObservables() {
		if (valueObservable != null) {
			valueObservable.dispose();
			valueObservable = null;
		}
	}

	public void dispose() {
		disposeModelObservables();
	}

}
