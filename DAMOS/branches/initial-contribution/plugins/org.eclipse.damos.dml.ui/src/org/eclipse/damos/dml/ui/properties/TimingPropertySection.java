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

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.damos.common.ui.widgets.FormWidgetFactory;
import org.eclipse.damos.dml.AsynchronousTimingConstraint;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.ContinuousTimingConstraint;
import org.eclipse.damos.dml.DMLFactory;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.SynchronousTimingConstraint;
import org.eclipse.damos.dml.ui.editpane.IValueSpecificationEditPane;
import org.eclipse.damos.dml.util.IElementInitializer;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.IViewerValueProperty;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
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
public class TimingPropertySection extends AbstractModelPropertySection {

	private ComboViewer timingConstraintViewer;
	
	@Inject
	private Provider<IValueSpecificationEditPane> sampleTimeEditorProvider;
	private IValueSpecificationEditPane sampleTimeEditor;
	
	@Inject
	private IElementInitializer elementInitializer;
	
	private EMFDataBindingContext context;
	
	private IObservableValue timingConstraintViewerObservable;
	private IObservableValue timingConstraintObservable;
	private IObservableValue sampleTimeControlEnabledObservable;
	private IObservableValue sampleTimeLabelEnabledObservable;
	private Label sampleTimeLabel;
	
	private enum TimingConstraintKind {
		
		INHERITED("Inherited"),
		CONTINUOUS("Continuous"),
		SYNCHRONOUS("Synchronous"),
		ASYNCHRONOUS("Asynchronous");
		
		private String name;
		
		TimingConstraintKind(String name) {
			this.name = name;
		}
		
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		
	};
	
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		
		sampleTimeEditor = sampleTimeEditorProvider.get();
		
		Composite client = (Composite) PropertySectionUtil.createTopLevelSection(parent, "Timing Information", 2,
				getWidgetFactory()).getClient();
		
		Label timingConstraintLabel = getWidgetFactory().createLabel(client, "Timing Constraint:");
		GridData gridData = new GridData();
		timingConstraintLabel.setLayoutData(gridData);

		CCombo combo = getWidgetFactory().createCCombo(client, SWT.BORDER | SWT.READ_ONLY);
		gridData = new GridData();
		combo.setLayoutData(gridData);
		timingConstraintViewer = new ComboViewer(combo);

		sampleTimeLabel = getWidgetFactory().createLabel(client, "Sample Interval (in s or Hz):");
		gridData = new GridData();
		sampleTimeLabel.setLayoutData(gridData);
		
		sampleTimeEditor.createControl(client, FormWidgetFactory.INSTANCE);

		timingConstraintViewer.setLabelProvider(new LabelProvider() {
			
			@Override
			public String getText(Object element) {
				if (element instanceof TimingConstraintKind) {
					return ((TimingConstraintKind) element).getName();
				}
				return super.getText(element);
			}
			
		});
		
		timingConstraintViewer.setContentProvider(new ArrayContentProvider());
		timingConstraintViewer.setInput(TimingConstraintKind.values());
		timingConstraintViewer.addFilter(new ViewerFilter() {
			
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				Component component = getComponent();
				if (component != null) {
					switch ((TimingConstraintKind) element) {
					case INHERITED:
						return true;
					case CONTINUOUS:
						return component.isTimingConstraintApplicable(DMLPackage.eINSTANCE.getContinuousTimingConstraint());
					case SYNCHRONOUS:
						return component.isTimingConstraintApplicable(DMLPackage.eINSTANCE.getSynchronousTimingConstraint());
					case ASYNCHRONOUS:
						return component.isTimingConstraintApplicable(DMLPackage.eINSTANCE.getAsynchronousTimingConstraint());
					}
				}
				return false;
			}
			
		});
		
		sampleTimeEditor.initialize();

		context = new EMFDataBindingContext();

		IViewerValueProperty timingConstraintUIProperty = ViewerProperties.singleSelection();
		timingConstraintViewerObservable = timingConstraintUIProperty.observe(timingConstraintViewer);
		
		sampleTimeControlEnabledObservable = WidgetProperties.enabled().observe(sampleTimeEditor.getControl());
		sampleTimeLabelEnabledObservable = WidgetProperties.enabled().observe(sampleTimeLabel);
	}

	private Component getComponent() {
		return (Component) getModel();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
	 */
	@Override
	public void refresh() {
		super.refresh();
		disposeModelObservables();
		
		// Refresh viewer to refilter the input
		timingConstraintViewer.refresh();

		sampleTimeEditor.refresh(getEditingDomain(), getComponent(),
				DMLPackage.eINSTANCE.getComponent_TimingConstraint(),
				DMLPackage.eINSTANCE.getSynchronousTimingConstraint_SampleInterval());

		IValueProperty timingConstraintProperty = EMFEditProperties.value(getEditingDomain(),
				DMLPackage.eINSTANCE.getComponent_TimingConstraint());
		timingConstraintObservable = timingConstraintProperty.observe(getComponent());
		UpdateValueStrategy timingConstraintUpdateStrategy = new TimingConstraintUpdateStrategy();
		context.bindValue(timingConstraintViewerObservable, timingConstraintObservable, timingConstraintUpdateStrategy,
				timingConstraintUpdateStrategy);
		
		context.bindValue(sampleTimeControlEnabledObservable, timingConstraintObservable, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_NEVER), new SynchronousTimingConstraintUpdateValueStrategy());
		context.bindValue(sampleTimeLabelEnabledObservable, timingConstraintObservable, new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_NEVER), new SynchronousTimingConstraintUpdateValueStrategy());
	}

	/**
	 * 
	 */
	private void disposeModelObservables() {
		if (timingConstraintObservable != null) {
			timingConstraintObservable.dispose();
			timingConstraintObservable = null;
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#dispose()
	 */
	@Override
	public void dispose() {
		if (sampleTimeEditor != null) {
			sampleTimeEditor.dispose();
		}
		disposeModelObservables();
		super.dispose();
	}
	
	private class TimingConstraintUpdateStrategy extends UpdateValueStrategy {
		
		private ContinuousTimingConstraint continuousTimingConstraint;
		private SynchronousTimingConstraint synchronousTimingConstraint;
		private AsynchronousTimingConstraint asynchronousTimingConstraint;
		
		/* (non-Javadoc)
		 * @see org.eclipse.core.databinding.UpdateValueStrategy#convert(java.lang.Object)
		 */
		@Override
		public Object convert(Object value) {
			if (value instanceof TimingConstraintKind) {
				switch ((TimingConstraintKind) value) {
				case INHERITED:
					return null;
				case CONTINUOUS:
					return getContinuousTimingConstraint();
				case SYNCHRONOUS:
					return getSynchronousTimingConstraint();
				case ASYNCHRONOUS:
					return getAsynchronousTimingConstraint();
				}
			} else {
				if (value == null) {
					return TimingConstraintKind.INHERITED;
				}
				if (value instanceof ContinuousTimingConstraint) {
					return TimingConstraintKind.CONTINUOUS;
				}
				if (value instanceof SynchronousTimingConstraint) {
					return TimingConstraintKind.SYNCHRONOUS;
				}
				if (value instanceof AsynchronousTimingConstraint) {
					return TimingConstraintKind.ASYNCHRONOUS;
				}
			}
			throw new IllegalArgumentException();
		}
		
		/**
		 * @return the continuousTimingConstraint
		 */
		private ContinuousTimingConstraint getContinuousTimingConstraint() {
			if (continuousTimingConstraint == null) {
				if (getComponent().getTimingConstraint() instanceof ContinuousTimingConstraint) {
					continuousTimingConstraint = (ContinuousTimingConstraint) getComponent().getTimingConstraint();
				} else {
					continuousTimingConstraint = DMLFactory.eINSTANCE.createContinuousTimingConstraint();;
				}
			}
			return continuousTimingConstraint;
		}
		
		/**
		 * @return the synchronousTimingConstraint
		 */
		private SynchronousTimingConstraint getSynchronousTimingConstraint() {
			if (synchronousTimingConstraint == null) {
				if (getComponent().getTimingConstraint() instanceof SynchronousTimingConstraint) {
					synchronousTimingConstraint = (SynchronousTimingConstraint) getComponent().getTimingConstraint();
				} else {
					synchronousTimingConstraint = DMLFactory.eINSTANCE.createSynchronousTimingConstraint();
					if (elementInitializer != null) {
						elementInitializer.initialize(getComponent().eResource().getResourceSet(), synchronousTimingConstraint,
								DMLPackage.eINSTANCE.getSynchronousTimingConstraint_SampleInterval(), null);
					}
				}
			}
			return synchronousTimingConstraint;
		}
		
		/**
		 * @return the asynchronousTimingConstraint
		 */
		private AsynchronousTimingConstraint getAsynchronousTimingConstraint() {
			if (asynchronousTimingConstraint == null) {
				if (getComponent().getTimingConstraint() instanceof AsynchronousTimingConstraint) {
					asynchronousTimingConstraint = (AsynchronousTimingConstraint) getComponent().getTimingConstraint();
				} else {
					asynchronousTimingConstraint = DMLFactory.eINSTANCE.createAsynchronousTimingConstraint();
				}
			}
			return asynchronousTimingConstraint;
		}
		
	}
	
	private static final class SynchronousTimingConstraintUpdateValueStrategy extends UpdateValueStrategy {

		/* (non-Javadoc)
		 * @see org.eclipse.core.databinding.UpdateValueStrategy#convert(java.lang.Object)
		 */
		@Override
		public Object convert(Object value) {
			return value instanceof SynchronousTimingConstraint;
		}
		
	}

}
