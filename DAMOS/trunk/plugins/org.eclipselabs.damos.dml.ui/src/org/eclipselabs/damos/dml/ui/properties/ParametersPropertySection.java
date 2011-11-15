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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipselabs.damos.common.ui.widgets.FormWidgetFactory;
import org.eclipselabs.damos.common.util.NameUtil;
import org.eclipselabs.damos.dml.Argument;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Parameter;
import org.eclipselabs.damos.dml.ParameterPredefinedValue;
import org.eclipselabs.damos.dml.ParameterVisibilityKind;
import org.eclipselabs.damos.dml.ParameterizedElement;
import org.eclipselabs.damos.dml.ValueSpecification;
import org.eclipselabs.damos.dml.ui.editpane.IValueSpecificationEditPane;
import org.eclipselabs.damos.dml.ui.internal.registry.ParameterEditPaneProviderRegistry;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class ParametersPropertySection extends AbstractModelPropertySection {

	private static final String YES = "yes";
	private static final String NO = "no";

	@Inject
	private ParameterEditPaneProviderRegistry parameterEditPaneProviderRegistry;
	
	private Composite composite;
	
	private List<IObservableValue> modelObservables = new ArrayList<IObservableValue>();
	
	private List<IValueSpecificationEditPane> valueSpecificationEditPanes = new ArrayList<IValueSpecificationEditPane>();
	
	private EMFDataBindingContext context;

	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		
		composite = PropertySectionUtil.createTopLevelComposite(parent, 2, getWidgetFactory());
		
		initializeDataBinding();
	}
	
	private void initializeDataBinding() {
		context = new EMFDataBindingContext();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
	 */
	@Override
	public void refresh() {
		super.refresh();
		disposeModelObservables();
		disposeValueSpecificationEditors();
		
		for (Control control : composite.getChildren()) {
			control.dispose();
		}
		
		for (Argument argument : ((ParameterizedElement) getModel()).getArguments()) {
			addParameterWidgets(argument);
		}
	
		composite.layout();
	}
	
	private IObservableValue createModelObservable(Argument argument) {
		IValueProperty property = EMFEditProperties.value(getEditingDomain(), DMLPackage.eINSTANCE.getArgument_Value());
		IObservableValue observable = property.observe(argument);
		modelObservables.add(observable);
		return observable;
	}

	private void addParameterWidgets(Argument argument) {
		if (argument.getParameter().getVisibility() == ParameterVisibilityKind.PUBLIC) {
			List<ParameterPredefinedValue> predefinedValues = argument.getParameter().getPredefinedValues();
			if (!predefinedValues.isEmpty()) {
				if (predefinedValues.size() == 2) {
					String alias1 = predefinedValues.get(0).getAlias();
					String alias2 = predefinedValues.get(1).getAlias();
					if (YES.equalsIgnoreCase(alias1) && NO.equalsIgnoreCase(alias2) || YES.equalsIgnoreCase(alias2)
							&& NO.equalsIgnoreCase(alias1)) {
						initializeCheckboxParameter(argument);
						return;
					}
				}
				initializeComboParameter(argument);
				return;
			}
			addTextParameter(argument);
		}
	}

	private void addParameterLabel(Argument argument) {
		Label nameLabel = getWidgetFactory().createLabel(composite,
				NameUtil.formatName(argument.getParameter().getName()) + ":");
		GridData gridData = new GridData();
		nameLabel.setLayoutData(gridData);
	}

	private void addTextParameter(Argument argument) {
		addParameterLabel(argument);
		
		IValueSpecificationEditPane editor = parameterEditPaneProviderRegistry.createEditor(argument.getParameter());
		editor.createControl(composite, FormWidgetFactory.INSTANCE);
		editor.initialize();
		editor.refresh(getEditingDomain(), argument, DMLPackage.eINSTANCE.getArgument_Value());
		valueSpecificationEditPanes.add(editor);
	}
	
	private void initializeComboParameter(Argument argument) {
		addParameterLabel(argument);
		
		CCombo combo = getWidgetFactory().createCCombo(composite, SWT.BORDER | SWT.READ_ONLY);
		ComboViewer comboViewer = new ComboViewer(combo);
		comboViewer.setContentProvider(new ArrayContentProvider());
		comboViewer.setLabelProvider(new LabelProvider() {
			
			@Override
			public String getText(Object element) {
				if (element instanceof ParameterPredefinedValue) {
					ParameterPredefinedValue predefinedValue = (ParameterPredefinedValue) element;
					String alias = predefinedValue.getAlias();
					if (alias != null && alias.trim().length() > 0) {
						return alias;
					}
					return predefinedValue.getValue().stringValue();
				}
				return super.getText(element);
			}
			
		});
		comboViewer.setInput(argument.getParameter().getPredefinedValues());

		IObservableValue comboObservable = ViewerProperties.singleSelection().observe(comboViewer);
		UpdateValueStrategy updateValueStrategy = new ComboUpdateValueStrategy(argument.getParameter());
		IObservableValue argumentObservable = createModelObservable(argument);
		context.bindValue(comboObservable, argumentObservable, updateValueStrategy, updateValueStrategy);
	}

	private void initializeCheckboxParameter(Argument argument) {
		Parameter parameter = (Parameter) argument.getParameter();

		Button button = getWidgetFactory().createButton(composite, NameUtil.formatName(parameter.getName()), SWT.CHECK);
		GridData gridData = new GridData();
		gridData.horizontalSpan = 2;
		button.setLayoutData(gridData);
		
		getWidgetFactory().createLabel(composite, "");

		IObservableValue buttonObservable = WidgetProperties.selection().observe(button);
		UpdateValueStrategy updateValueStrategy = new CheckboxUpdateValueStrategy(parameter);
		IObservableValue argumentObservable = createModelObservable(argument);
		context.bindValue(buttonObservable, argumentObservable, updateValueStrategy, updateValueStrategy);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#shouldUseExtraSpace()
	 */
	@Override
	public boolean shouldUseExtraSpace() {
		return true;
	}
	
	private void disposeModelObservables() {
		for (IObservableValue observable : modelObservables) {
			observable.dispose();
		}
		modelObservables.clear();
	}
	
	private void disposeValueSpecificationEditors() {
		for (IValueSpecificationEditPane valueSpecificationEditPane : valueSpecificationEditPanes) {
			valueSpecificationEditPane.dispose();
		}
		valueSpecificationEditPanes.clear();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#dispose()
	 */
	@Override
	public void dispose() {
		disposeModelObservables();
		disposeValueSpecificationEditors();
		super.dispose();
	}
	
	private static class ComboUpdateValueStrategy extends UpdateValueStrategy {
		
		private Parameter parameter;
		
		/**
		 * 
		 */
		public ComboUpdateValueStrategy(Parameter parameter) {
			this.parameter = parameter;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.core.databinding.UpdateValueStrategy#convert(java.lang.Object)
		 */
		@Override
		public Object convert(Object value) {
			if (value == null) {
				return null;
			}
			if (value instanceof ParameterPredefinedValue) {
				return ((ParameterPredefinedValue) value).getValue().copy();
			}
			if (value instanceof ValueSpecification) {
				return parameter.getPredefinedValue(((ValueSpecification) value).stringValue());
			}
			throw new IllegalArgumentException();
		}
		
	}

	private static class CheckboxUpdateValueStrategy extends UpdateValueStrategy {
		
		private Parameter parameter;
		
		/**
		 * 
		 */
		public CheckboxUpdateValueStrategy(Parameter parameter) {
			this.parameter = parameter;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.core.databinding.UpdateValueStrategy#convert(java.lang.Object)
		 */
		@Override
		public Object convert(Object value) {
			if (value == null) {
				return null;
			}
			if (value instanceof Boolean) {
				ParameterPredefinedValue predefinedValue;
				if (((Boolean) value).booleanValue()) {
					predefinedValue = parameter.getPredefinedValueByAlias(YES);
				} else {
					predefinedValue = parameter.getPredefinedValueByAlias(NO);
				}
				if (predefinedValue == null) {
					throw new IllegalArgumentException();
				}
				return predefinedValue.getValue().copy();
			}
			if (value instanceof ValueSpecification) {
				ParameterPredefinedValue predefinedValue = parameter.getPredefinedValue(((ValueSpecification) value).stringValue());
				return predefinedValue != null && YES.equalsIgnoreCase(predefinedValue.getAlias());
			}
			throw new IllegalArgumentException();
		}
		
	}

}
