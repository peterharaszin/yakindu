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

package org.eclipselabs.damos.dml.ui.editpane;

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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipselabs.damos.common.ui.widgets.IWidgetFactory;
import org.eclipselabs.damos.dml.DMLFactory;
import org.eclipselabs.damos.dml.StringValueSpecification;
import org.eclipselabs.damos.dml.ValueSpecification;

/**
 * @author Andreas Unger
 *
 */
public class StringValueSpecificationEditPane implements IValueSpecificationEditPane {

	private EMFDataBindingContext context;
	private IObservableValue valueObservable;
	private IObservableValue valueTextObservable;
	
	private Text text;

	public void createControl(Composite parent, IWidgetFactory widgetFactory) {
		text = createText(parent, widgetFactory);
	}
	
	public Control getControl() {
		return getText();
	}
	
	protected Text createText(Composite parent, IWidgetFactory widgetFactory) {
		Text text = widgetFactory.createText(parent, "");
		GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
		text.setLayoutData(gridData);
		return text;
	}

	/**
	 * @return the text
	 */
	protected Text getText() {
		return text;
	}
	
	protected void setValue(String value) {
		StringValueSpecification valueSpecification = DMLFactory.eINSTANCE.createStringValueSpecification();
		valueSpecification.setValue(value);
		valueObservable.setValue(valueSpecification);
	}
	
	public void initialize() {
		context = new EMFDataBindingContext();

		IWidgetValueProperty textProperty = WidgetProperties.text(new int[] { SWT.DefaultSelection, SWT.FocusOut });
		valueTextObservable = textProperty.observe(getText());
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.ui.IValueSpecificationEditor#refresh(org.eclipse.emf.edit.domain.EditingDomain, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature)
	 */
	public void refresh(EditingDomain editingDomain, EObject source, EStructuralFeature feature) {
		disposeModelObservables();
		
		IValueProperty property = EMFEditProperties.value(editingDomain, feature);
		refreshDataBinding(source, property);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.ui.IValueSpecificationEditor#refresh(org.eclipse.emf.edit.domain.EditingDomain, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature[])
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
		UpdateValueStrategy updateValueStrategy = new StringValueSpecificationUpdateValueStrategy();
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

	private static class StringValueSpecificationUpdateValueStrategy extends UpdateValueStrategy {

		/* (non-Javadoc)
		 * @see org.eclipse.core.databinding.UpdateValueStrategy#convert(java.lang.Object)
		 */
		@Override
		public Object convert(Object value) {
			if (value == null) {
				return null;
			}
			if (value instanceof String) {
				StringValueSpecification valueSpecification = DMLFactory.eINSTANCE.createStringValueSpecification();
				valueSpecification.setValue((String) value);
				return valueSpecification;
			}
			if (value instanceof ValueSpecification) {
				return ((ValueSpecification) value).stringValue();
			}
			throw new IllegalArgumentException();
		}
		
	}

}
