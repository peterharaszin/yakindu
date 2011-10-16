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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.jface.databinding.swt.IWidgetValueProperty;
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
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipselabs.damos.common.ui.widgets.FormWidgetFactory;
import org.eclipselabs.damos.common.util.NameUtil;
import org.eclipselabs.damos.dml.Argument;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.ExpressionParameter;
import org.eclipselabs.damos.dml.ExpressionSpecification;
import org.eclipselabs.damos.dml.ParameterPredefinedValue;
import org.eclipselabs.damos.dml.ParameterVisibilityKind;
import org.eclipselabs.damos.dml.PredefinedExpressionEntry;
import org.eclipselabs.damos.dml.ui.IValueSpecificationEditor;
import org.eclipselabs.damos.dml.ui.internal.databinding.TextualElementUpdateValueStrategy;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Andreas Unger
 *
 */
public class ParametersPropertySection extends AbstractModelPropertySection {

	private static final String YES = "yes";
	private static final String NO = "no";

	@Inject
	private Provider<IValueSpecificationEditor> valueSpecificationEditorProvider;
	
	private Composite composite;
	
	private List<IObservableValue> modelObservables = new ArrayList<IObservableValue>();
	
	private List<IValueSpecificationEditor> valueSpecificationEditors = new ArrayList<IValueSpecificationEditor>();
	
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
		
		for (Argument argument : ((Block) getModel()).getArguments()) {
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
		// TODO: Remove the following if block
		if (argument.getParameter() instanceof ExpressionParameter
				&& argument.getParameter().getVisibility() == ParameterVisibilityKind.PUBLIC) {
			ExpressionParameter parameter = (ExpressionParameter) argument.getParameter();
			List<PredefinedExpressionEntry> predefinedExpressionEntries = parameter.getPredefinedExpressions();
			if (!predefinedExpressionEntries.isEmpty()) {
				if (predefinedExpressionEntries.size() == 2) {
					String alias1 = predefinedExpressionEntries.get(0).getAlias();
					String alias2 = predefinedExpressionEntries.get(1).getAlias();
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
			return;
		}
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
		
		if (valueSpecificationEditorProvider != null) {
			IValueSpecificationEditor editor = valueSpecificationEditorProvider.get();
			editor.createControl(composite, FormWidgetFactory.INSTANCE);
			editor.initialize();
			editor.refresh(getEditingDomain(), argument, DMLPackage.eINSTANCE.getArgument_Value());
			valueSpecificationEditors.add(editor);
		} else {
			Text text = getWidgetFactory().createText(composite, "");
			GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
			text.setLayoutData(gridData);		
	
			IWidgetValueProperty textProperty = WidgetProperties.text(new int[] { SWT.DefaultSelection, SWT.FocusOut });
			IObservableValue textObservable = textProperty.observe(text);
			UpdateValueStrategy updateValueStrategy = new TextualElementUpdateValueStrategy(
					DMLPackage.eINSTANCE.getExpressionSpecification());
			IObservableValue argumentObservable = createModelObservable(argument);
			context.bindValue(textObservable, argumentObservable, updateValueStrategy, updateValueStrategy);
		}
	}
	
	private void initializeComboParameter(Argument argument) {
		ExpressionParameter parameter = (ExpressionParameter) argument.getParameter();
		addParameterLabel(argument);
		
		CCombo combo = getWidgetFactory().createCCombo(composite, SWT.BORDER | SWT.READ_ONLY);
		ComboViewer comboViewer = new ComboViewer(combo);
		comboViewer.setContentProvider(new ArrayContentProvider());
		comboViewer.setLabelProvider(new LabelProvider() {
			
			@Override
			public String getText(Object element) {
				if (element instanceof PredefinedExpressionEntry) {
					return ((PredefinedExpressionEntry) element).getAlias();
				}
				return super.getText(element);
			}
			
		});
		comboViewer.setInput(parameter.getPredefinedExpressions());

		IObservableValue comboObservable = ViewerProperties.singleSelection().observe(comboViewer);
		UpdateValueStrategy updateValueStrategy = new ComboUpdateValueStrategy(parameter);
		IObservableValue argumentObservable = createModelObservable(argument);
		context.bindValue(comboObservable, argumentObservable, updateValueStrategy, updateValueStrategy);
	}

	private void initializeCheckboxParameter(Argument argument) {
		ExpressionParameter parameter = (ExpressionParameter) argument.getParameter();

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
		for (IValueSpecificationEditor valueSpecificationEditor : valueSpecificationEditors) {
			valueSpecificationEditor.dispose();
		}
		valueSpecificationEditors.clear();
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
		
		private ExpressionParameter parameter;
		
		/**
		 * 
		 */
		public ComboUpdateValueStrategy(ExpressionParameter parameter) {
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
			if (value instanceof PredefinedExpressionEntry) {
				return ((PredefinedExpressionEntry) value).getExpression().copy();
			}
			if (value instanceof ExpressionSpecification) {
				return parameter.getPredefinedExpression(((ExpressionSpecification) value).getExpression());
			}
			throw new IllegalArgumentException();
		}
		
	}

	private static class CheckboxUpdateValueStrategy extends UpdateValueStrategy {
		
		private ExpressionParameter parameter;
		
		/**
		 * 
		 */
		public CheckboxUpdateValueStrategy(ExpressionParameter parameter) {
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
				PredefinedExpressionEntry entry;
				if (((Boolean) value).booleanValue()) {
					entry = parameter.getPredefinedExpressionByAlias(YES);
				} else {
					entry = parameter.getPredefinedExpressionByAlias(NO);
				}
				if (entry == null) {
					throw new IllegalArgumentException();
				}
				return entry.getExpression().copy();
			}
			if (value instanceof ExpressionSpecification) {
				PredefinedExpressionEntry entry = parameter.getPredefinedExpression(((ExpressionSpecification) value).getExpression());
				return entry != null && YES.equalsIgnoreCase(entry.getAlias());
			}
			throw new IllegalArgumentException();
		}
		
	}

}
